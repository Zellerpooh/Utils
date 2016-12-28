package com.jinkworld.downloadmanager.memotopattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 负责管理Memoto对象
 * Created by Zellerpooh on 16/12/28.
 */

public class NoteCaretaker {
    //最大存储数量
    private static final int MAX = 30;
    //存储30条记录
    List<Memoto> mMemotos = new ArrayList<Memoto>(MAX);

    int mIndex = 0;

    /**
     * 保存备忘录到记录列表中
     *
     * @param memoto
     */
    public void saveMemoto(Memoto memoto) {
        if (mMemotos.size() > MAX) {
            mMemotos.remove(0);
        }
        mMemotos.add(memoto);
        mIndex = mMemotos.size() - 1;
    }

    /**
     * 获取上一个存档信息,相当于撤销
     *
     * @return
     */
    public Memoto getPrevMemoto() {
        mIndex = mIndex > 0 ? --mIndex : mIndex;
        return mMemotos.get(mIndex);
    }

    /**
     * 获取下一个存档信息,相当于重做功能
     *
     * @return
     */
    public Memoto getNextMemoto() {
        mIndex = mIndex < mMemotos.size() - 1 ? ++mIndex : mIndex;
        return mMemotos.get(mIndex);
    }

}
