package com.jinkworld.downloadmanager.commandpattern.base;

import android.graphics.Path;

/**
 * Created by Zellerpooh on 16/12/27.
 */

public class NormalBrush implements IBrush {
    @Override
    public void down(Path path, float x, float y) {
        path.moveTo(x,y);
    }

    @Override
    public void move(Path path, float x, float y) {
        path.lineTo(x, y);
    }

    @Override
    public void up(Path path, float x, float y) {

    }
}
