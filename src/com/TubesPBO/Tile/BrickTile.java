package com.TubesPBO.Tile;

import com.TubesPBO.Grapichs.Assets;

import java.awt.image.BufferedImage;

public class BrickTile extends Tiles{
    public BrickTile(int id) {
        super(Assets.brick, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }

}
