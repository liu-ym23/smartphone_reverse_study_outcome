package com.qihoo360.mobilesafe.common.ui.list;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

/* JADX INFO: loaded from: classes4.dex */
public class TreeViewParent extends RelativeLayout implements ITreeViewListener {
    private View mHeaderView;

    public TreeViewParent(Context r1) {
        super(r1);
    }

    public TreeViewParent(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public TreeViewParent(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    @Override // com.qihoo360.mobilesafe.common.ui.list.ITreeViewListener
    public void setHeaderView(View r1) {
        this.mHeaderView = r1;
        if (r1 == null) goto L6;
        addView(r1);
        return;
    }
}
