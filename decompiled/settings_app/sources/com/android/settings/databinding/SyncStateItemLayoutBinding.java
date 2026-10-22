package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import obric.widget.ListContentItemCustom;

/* JADX INFO: loaded from: classes2.dex */
public final class SyncStateItemLayoutBinding implements ViewBinding {
    public final CheckBox checkbox;
    public final ListContentItemCustom listContentItem;
    private final RelativeLayout rootView;
    public final TextView summary;
    public final TextView title;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SyncStateItemLayoutBinding(RelativeLayout r1, CheckBox r2, ListContentItemCustom r3, TextView r4, TextView r5) {
        this.rootView = r1;
        this.checkbox = r2;
        this.listContentItem = r3;
        this.summary = r4;
        this.title = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SyncStateItemLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SyncStateItemLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.sync_state_item_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SyncStateItemLayoutBinding bind(View r8) {
        int r0 = android.R.id.checkbox;
        CheckBox r4 = (CheckBox) ViewBindings.findChildViewById(r8, android.R.id.checkbox);
        if (r4 == null) goto L13;
        r0 = R.id.list_content_item;
        ListContentItemCustom r5 = (ListContentItemCustom) ViewBindings.findChildViewById(r8, R.id.list_content_item);
        if (r5 == null) goto L13;
        r0 = android.R.id.summary;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r8, android.R.id.summary);
        if (r6 == null) goto L13;
        r0 = android.R.id.title;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r8, android.R.id.title);
        if (r7 == null) goto L13;
        return new SyncStateItemLayoutBinding((RelativeLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
