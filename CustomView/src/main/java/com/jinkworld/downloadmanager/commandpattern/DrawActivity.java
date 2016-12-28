package com.jinkworld.downloadmanager.commandpattern;

import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.jinkworld.downloadmanager.R;
import com.jinkworld.downloadmanager.commandpattern.base.CircleBrush;
import com.jinkworld.downloadmanager.commandpattern.base.IBrush;
import com.jinkworld.downloadmanager.commandpattern.base.NormalBrush;
import com.jinkworld.downloadmanager.commandpattern.command.DrawPath;
import com.jinkworld.downloadmanager.commandpattern.receiver.DrawCanvas;

/**
 * 命令模式创建的画板,可以撤销以及重做
 */
public class DrawActivity extends AppCompatActivity {
    private DrawCanvas mCanvas;//绘制画布
    private DrawPath mPath;//路径绘制命令
    private Paint mPaint;//画笔对象
    private IBrush mBrush;//笔触对象

    private Button btnRedo, btnUndo;//重做、撤销按钮

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);

        mPaint = new Paint();
        mPaint.setColor(0xFFFFFFFF);
        mPaint.setStrokeWidth(3);

        mBrush = new NormalBrush();

        mCanvas = (DrawCanvas) findViewById(R.id.ac_draw_canvas);
        mCanvas.setOnTouchListener(new DrawTouchListener());

        btnRedo = (Button) findViewById(R.id.ac_draw_operate_redo_btn);
        btnRedo.setEnabled(false);
        btnUndo = (Button) findViewById(R.id.ac_draw_operate_undo_btn);
        btnUndo.setEnabled(false);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ac_draw_color_red_btn:
                mPaint = new Paint();
                mPaint.setStrokeWidth(3);
                mPaint.setColor(0xFFFF0000);
                break;
            case R.id.ac_draw_color_green_btn:
                mPaint = new Paint();
                mPaint.setStrokeWidth(3);
                mPaint.setColor(0xFF00FF00);
                break;
            case R.id.ac_draw_color_blue_btn:
                mPaint = new Paint();
                mPaint.setStrokeWidth(3);
                mPaint.setColor(0xFF0000FF);
                break;
            case R.id.ac_draw_operate_undo_btn:
                mCanvas.undo();
                if (!mCanvas.canUndo()) {
                    btnUndo.setEnabled(false);
                }
                btnRedo.setEnabled(true);
                break;
            case R.id.ac_draw_operate_redo_btn:
                mCanvas.redo();
                if (!mCanvas.canRedo()) {
                    btnRedo.setEnabled(false);
                }
                btnUndo.setEnabled(true);
                break;
            case R.id.ac_draw_brush_circle_btn:
                mBrush = new CircleBrush();
                break;
            case R.id.ac_draw_brush_normal_btn:
                mBrush = new NormalBrush();
                break;
        }
    }

    private class DrawTouchListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                mPath = new DrawPath();
                mPath.paint = mPaint;
                mPath.path = new Path();
                mBrush.down(mPath.path, event.getX(), event.getY());
            } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                mBrush.move(mPath.path, event.getX(), event.getY());
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                mBrush.up(mPath.path, event.getX(), event.getY());
                mCanvas.add(mPath);
                mCanvas.isDrawing = true;
                btnUndo.setEnabled(true);
                btnRedo.setEnabled(true);
            }
            return true;
        }
    }
}
