package com.jinkworld.downloadmanager.commandpattern.command;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

/**
 * Created by Zellerpooh on 16/12/27.
 */

public class DrawPath implements IDraw {
    public Path path;
    public Paint paint;

    @Override
    public void draw(Canvas canvas) {
        canvas.drawPath(path, paint);
    }

    @Override
    public void undo() {

    }
}
