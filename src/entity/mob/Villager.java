package entity.mob;

import java.util.ArrayList;
import java.util.List;

import entity.Entity;
import entity.Resource;
import entity.item.Clothing;
import entity.item.Item;
import entity.item.VillagerInventory;
import entity.item.weapon.Weapon;
import entity.mob.work.Job;
import entity.pathfinding.Path;
import entity.pathfinding.PathFinder;
import entity.pathfinding.Point;
import graphics.HairSprite;
import graphics.Screen;
import graphics.Sprite;
import map.Level;

public class Villager extends Mob {
	public Path movement; // path for the villager to follow
	private int counter; // counter of steps along the path
	private boolean arrived = false; // has the villager arrived at the path's
										// destination
	public VillagerInventory inventory; // clothing item list
	public boolean male; // is the villager male
	public Item holding; // item the villager is holding in his hands
	private Sprite hair; // hair sprite
	private int hairnr; // hair number (needed for the hair sprite to be
						// decided)
	private List<Job> jobs; // jobs the villager needs to do
	private int idletimer = getIdleTimer(); // timer for the villager to idle

	// basic constructors
	public Villager(int x, int y, Level level) {
		super(level);
		while (!level.isWalkAbleTile(x >> 4, y >> 4)) {
			x += 16;
			y += 16;
		}
		this.x = x;
		this.y = y;
		this.sprite = Sprite.getPerson();
		inventory = new VillagerInventory(this);
		jobs = new ArrayList<Job>();
		male = random.nextBoolean();
		initHair(true);
		this.x = x;
		this.y = y;

	}

	public Villager(int x, int y, Level level, int hairnr, VillagerInventory wearing, Item holding, boolean male) {
		this(x, y, level);
		this.hairnr = hairnr;
		this.male = male;
		initHair(false);
		this.inventory = wearing;
		this.holding = holding;
	}

	// getter
	private int getIdleTimer() {
		return random.nextInt(5) * 60;
	}

	public int getJobSize() {
		return jobs.size();
	}

	// logic for the villager to idle
	private boolean idleTime() {
		if (idletimer <= 0) {
			idletimer = getIdleTimer();
			return true;
		} else {
			idletimer--;
			return false;
		}
	}

	public boolean holding(Item item) {
		if (holding != null) {
			return holding.equals(item);
		}
		return false;
	}

	// the villager moves to a random location nearby if he has nothing to do.
	public void idle() {
		while (movement == null) {
			movement = getPath((x >> 4) + random.nextInt(4) - 2, (y >> 4) + random.nextInt(4) - 2);
		}

	}

	// initialise the hairsprite
	private void initHair(boolean generate) {
		if (generate) {
			if (male) {
				hairnr = random.nextInt(HairSprite.maleHair.length);
			} else {
				hairnr = random.nextInt(HairSprite.femaleHair.length);
			}
		}
		if (male) {
			hair = HairSprite.maleHair[hairnr];
		} else {
			hair = HairSprite.femaleHair[hairnr];
		}

	}

	// gets the item nearest to the villager with a specific name
	private Item getNearestItemOfType(String name) {
		if (holding != null && holding.getName().equals(name)) {
			return holding;
		}
		Item closest = null;
		Path path = null;
		for (int i = 0; i < level.getItemList().size(); i++) {
			if (level.getItem(i).getName().equals(name) && level.getItem(i).isReservedVil(this)) {
				closest = level.getItem(i);
				path = getPath(closest.getX() >> 4, closest.getY() >> 4);
				if (closest.getX() >> 4 == x >> 4 && y >> 4 == closest.getY() >> 4) {
					return closest;
				}
			}
		}
		if (closest == null && path == null) {
			return null;
		}
		return closest;
	}

	// work method for the villager to execute his jobs
	public void work() {
		if (jobs.get(0) != null && !jobs.get(0).isCompleted()) {
			jobs.get(0).execute();
		} else {
			if (jobs.get(0).isCompleted()) {
				jobs.remove(0);
			}
		}

	}

	// is the villager on or around a location (x and y in pixels)
	public boolean aroundSpot(int endx, int endy) {
		return aroundTile(endx, endy);

	}

	// is the villager around a tile (x and y in pixels)
	public boolean aroundTile(int endx, int endy) {
		return ((this.x <= ((endx + 16))) && (this.x >= ((endx - 16)))
				&& ((this.y >= ((endy - 16))) && (this.y <= ((endy + 16)))));

	}

	// pickup an item
	public boolean pickUp(Item e) {
		if (onSpot(e.getX(), e.getY())) {
			e.setReservedVil(this);
			level.removeItem(e);
			holding = e;
			return true;
		}
		return false;

	}

	// drop the item the villager is holding
	public void drop() {
		if (holding != null) {
			holding.setReservedVil(null);
			level.addItem(holding);
			holding = null;
		}
	}

	public void dropItem(Item e) {
		if (e != null) {
			level.addItem(e);
		}
	}

	public boolean onSpot(int x, int y) {
		return (this.x >> 4 == x >> 4 && this.y >> 4 == y >> 4);
	}

	// add a job to the jobs list for the villager to do
	public void addJob(Resource e) {
		if (e != null) {
			addJob(new Job(e, this));
		}
	}

	public void addJob(Job e) {
		if (e != null)
			jobs.add(e);
	}

	public void addJob(Job e, int prio) {
		if (e != null) {
			jobs.add(prio, e);
		}
	}

	// add a buildjob
	public void addBuildJob(int x, int y) {
		addJob(new Job(x, y, getNearestItemOfType("Logs"), this, level));
	}

	// pathfinder
	public Path getShortest(Entity e) {
		if (e != null)
			return getShortest(e.getX() / 16, e.getY() / 16);
		return null;
	}

	public Path getPath(Entity e) {
		return getPath(e.getX() / 16, e.getY() / 16);
	}

	public Path getShortest(int x, int y) {
		return PathFinder
				.getShortest(new Path[] { getPath(x - 1, y), getPath(x + 1, y), getPath(x, y - 1), getPath(x, y + 1) });
	}

	// updates the villager in the game logic
	public void update() {
		if (jobs.size() != 0) {
			work();
		} else {
			// IDLE
			if (idleTime()) {
				idle();
			}
			move();

		}

	}

	// add clothing to the villager
	public void addClothing(Clothing item) {
		inventory.addClothing(item);
	}

	public void addWeapon(Weapon item) {
		inventory.addWeapon(item);
	}

	// method to move the villager
	public void move() {
		if (movement == null) {
			counter = 0;
			return;
		}
		if (arrived) {
			counter++;
			arrived = false;
		}
		if (movement.getLength() == counter) {
			counter = 0;
			movement = null;
			arrived = false;
			return;
		} else {
			if (!arrived) {
				Point step = movement.getStep(counter);
				if (step == null || !level.isWalkAbleTile(step.x, step.y)) {
					int destx = movement.getXdest();
					int desty = movement.getYdest();
					movement = getShortest(destx, desty);
					return;
				}
				moveTo(step.x << 4, step.y << 4);
				if (x == step.x << 4 && y == step.y << 4) {
					arrived = true;
				}

			}
		}

	}

	// resets the villager's path
	public void resetMove() {
		counter = 0;
		arrived = false;
		movement = null;
	}

	public void resetAll() {
		jobsLeeg();
		resetMove();
	}

	// empties the jobs list
	private void jobsLeeg() {
		jobs.clear();

	}

	// DO NOT TOUCH THIS. SET THE MOVEMENT TO THE PATH OBJ USE move()!! DO NOT
	// USE!!!
	private final void moveTo(int x, int y) {
		int xmov, ymov;
		if (this.x > x) {
			xmov = -1;
		} else {
			if (this.x == x) {
				xmov = 0;
			} else {
				xmov = 1;
			}
		}
		if (this.y > y) {
			ymov = -1;
		} else {
			if (this.y == y) {
				ymov = 0;
			} else {
				ymov = 1;
			}
		}
		move(xmov, ymov);
		if (!(holding == null)) {
			holding.setX(x);
			holding.setY(y);
		}

	}

	// render onto the screen
	public void render(Screen screen) {
		inventory.update(x, y);
		screen.renderSprite(x, y, this.sprite); // renders the body
		if (inventory != null) {
			inventory.render(screen);
		}
		screen.renderSprite(x, y, hair); // renders the hair
		if (holding != null) {
			screen.renderSprite(x, y, holding.sprite); // renders the item the
														// villager is holding
		}
		screen.renderSelection(x, y, this); // render the red square around
											// selected villagers

	}

}
