package entity.nonDynamic;

import entity.Entity;
import map.Level;

public abstract class StaticEntity extends Entity {
	public Level level;

	protected StaticEntity(int x, int y, int z, Level level) {
		super(x, y, z);
		this.level = level;
	}

	protected StaticEntity() {
		super();
	}
}
