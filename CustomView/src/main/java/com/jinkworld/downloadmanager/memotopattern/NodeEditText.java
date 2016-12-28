package com.jinkworld.downloadmanager.memotopattern;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by Zellerpooh on 16/12/28.
 */

public class NodeEditText extends EditText {


    public NodeEditText(Context context) {
        this(context, null);
    }

    public NodeEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }


    public NodeEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 创建备忘录对象,即存储编辑器的指定数据
     *
     * @return
     */
    public Memoto createMemoto() {
        Memoto noteMemoto = new Memoto();

        noteMemoto.text = getText().toString();
        noteMemoto.cursor = getSelectionStart();
        return noteMemoto;
    }

    /**
     * 从备忘录中恢复数据
     *
     * @param memoto
     */
    public void restore(Memoto memoto) {
        setText(memoto.text);
        setSelection(memoto.cursor);
    }

}
