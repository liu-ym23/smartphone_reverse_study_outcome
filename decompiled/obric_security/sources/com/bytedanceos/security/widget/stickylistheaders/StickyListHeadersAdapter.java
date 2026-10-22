package com.bytedanceos.security.widget.stickylistheaders;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

/* JADX INFO: loaded from: classes2.dex */
public interface StickyListHeadersAdapter extends ListAdapter {
    long getHeaderId(int position);

    View getHeaderView(int position, View convertView, ViewGroup parent);
}
