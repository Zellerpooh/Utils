package com.jinkworld.downloadmanager.memotopattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jinkworld.downloadmanager.R;
import com.wgl.android.library.commonutils.ToastUitl;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 使用备忘录模式实现的一个笔记本
 */
public class MemotoActivity extends AppCompatActivity {

//    @Bind(R.id.note_edittext)
//    NodeEditText noteEdittext;
    @Bind(R.id.undo_btn)
    Button undoBtn;
    @Bind(R.id.save_btn)
    TextView saveBtn;
    @Bind(R.id.redo_btn)
    Button redoBtn;
    private NoteCaretaker mCaretaker = new NoteCaretaker();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memoto);
        ButterKnife.bind(this);

    }


    @OnClick({R.id.undo_btn, R.id.save_btn, R.id.redo_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.undo_btn:
//                noteEdittext.restore(mCaretaker.getPrevMemoto());
                toast("撤销:");
                break;
            case R.id.save_btn:
//                mCaretaker.saveMemoto(noteEdittext.createMemoto());
                toast("保存笔记:");
                break;
            case R.id.redo_btn:
//                noteEdittext.restore(mCaretaker.getNextMemoto());
                toast("重做:");
                break;
        }
    }

    private void toast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
