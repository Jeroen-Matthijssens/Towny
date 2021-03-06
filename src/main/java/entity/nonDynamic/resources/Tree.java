package entity.nonDynamic.resources;

import entity.dynamic.item.ItemHashtable;
import entity.dynamic.mob.Villager;
import graphics.OpenglUtils;
import graphics.Sprite;
import graphics.SpriteHashtable;
import map.Level;
import sound.Sound;

public class Tree extends Resource {
	private byte chopped = 100;
	private Sprite topsprite;

	// basic constructor
	public Tree(int x, int y, int z, Level level) {
		super(x, y, z, level);
		sprite = SpriteHashtable.get(12);
		topsprite = SpriteHashtable.get(13);
		setVisible(true);
		setName("tree");
	}

	// render method to render onto the screen
	public void render() {
		super.render();
		topsprite.draw(x,y-Sprite.SIZE);

	}

	// work method (same as in the Ore class)
	public boolean work(Villager worker) {
		if (chopped > 0) {
			if (chopped % 20 == 0) {
				Sound.playSound(Sound.woodChopping);
			}
			chopped--;
			return false;
		} else {
			level.removeEntity(this);
			level.addItem(ItemHashtable.get(1, this.x, this.y, this.z));
			return true;
		}

	}

	@Override
	protected void drawSelection() {
		if (this.isSelected()) {
			OpenglUtils.drawSelection(x, y-Sprite.SIZE, Sprite.SIZE, Sprite.SIZE*2); // render the red square around selected resources
		}
	}

}
