package com.android.settings.stickylistheaders;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

/* JADX INFO: loaded from: classes2.dex */
public interface StickyListHeadersAdapter extends ListAdapter {
    long getHeaderId(int r1);

    View getHeaderView(int r1, View r2, ViewGroup r3);

    default void onBindHeaderAndItem(int r1, View r2, View r3) {
    }
}
