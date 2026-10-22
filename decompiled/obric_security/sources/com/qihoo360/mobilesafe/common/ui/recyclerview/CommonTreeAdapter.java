package com.qihoo360.mobilesafe.common.ui.recyclerview;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CommonTreeAdapter {
    public abstract int getItemViewType(CommonTreeNode r1);

    public abstract void onBindView(View r1, CommonTreeNode r2, int r3);

    public abstract View onCreateView(ViewGroup r1, int r2);

    public CommonTreeAdapter() {
    }
}
