package com.TubesPBO.Entity.Static;

import com.TubesPBO.Entity.Entity;
import com.TubesPBO.Game.Handler;

public abstract class StaticEntity extends Entity {

    public StaticEntity(Handler handler, int width, int height, float x, float y) {
        super(handler, width, height, x, y);
    }
}
