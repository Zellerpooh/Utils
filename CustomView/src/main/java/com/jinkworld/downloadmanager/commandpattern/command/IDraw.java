package com.jinkworld.downloadmanager.commandpattern.command;

import android.graphics.Canvas;

/**
 * Created by Zellerpooh on 16/12/27.
 */

public interface IDraw {
    /**
     * 绘制命令
     *
     * @param canvas
     */
    void draw(Canvas canvas);

    /**
     * 撤销指令
     */
    void undo();
}
