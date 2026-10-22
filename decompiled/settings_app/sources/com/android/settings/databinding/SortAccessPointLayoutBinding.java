package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class SortAccessPointLayoutBinding implements ViewBinding {
    public final RelativeLayout allViewLayout;
    public final TextView currentlyConnectedText;
    public final ImageView dragHandle;
    public final ImageView itemRemoveView;
    private final LinearLayout rootView;
    public final TextView summary;
    public final TextView title;
    public final View titleBlankView;
    public final RelativeLayout titleLayout;
    public final LinearLayout titleLayoutWifi;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SortAccessPointLayoutBinding(LinearLayout r1, RelativeLayout r2, TextView r3, ImageView r4, ImageView r5, TextView r6, TextView r7, View r8, RelativeLayout r9, LinearLayout r10) {
        this.rootView = r1;
        this.allViewLayout = r2;
        this.currentlyConnectedText = r3;
        this.dragHandle = r4;
        this.itemRemoveView = r5;
        this.summary = r6;
        this.title = r7;
        this.titleBlankView = r8;
        this.titleLayout = r9;
        this.titleLayoutWifi = r10;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SortAccessPointLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SortAccessPointLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.sort_access_point_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SortAccessPointLayoutBinding bind(View r13) {
        int r0 = R.id.all_view_layout;
        RelativeLayout r4 = (RelativeLayout) ViewBindings.findChildViewById(r13, R.id.all_view_layout);
        if (r4 == null) goto L23;
        r0 = R.id.currently_connected_text;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r13, R.id.currently_connected_text);
        if (r5 == null) goto L23;
        r0 = R.id.drag_handle;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r13, R.id.drag_handle);
        if (r6 == null) goto L23;
        r0 = R.id.item_remove_view;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r13, R.id.item_remove_view);
        if (r7 == null) goto L23;
        r0 = R.id.summary;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r13, R.id.summary);
        if (r8 == null) goto L23;
        r0 = R.id.title;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r13, R.id.title);
        if (r9 == null) goto L23;
        r0 = R.id.title_blank_view;
        View r10 = ViewBindings.findChildViewById(r13, R.id.title_blank_view);
        if (r10 == null) goto L23;
        r0 = R.id.title_layout;
        RelativeLayout r11 = (RelativeLayout) ViewBindings.findChildViewById(r13, R.id.title_layout);
        if (r11 == null) goto L23;
        r0 = R.id.title_layout_wifi;
        LinearLayout r12 = (LinearLayout) ViewBindings.findChildViewById(r13, R.id.title_layout_wifi);
        if (r12 == null) goto L23;
        return new SortAccessPointLayoutBinding((LinearLayout) r13, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r0)));
    }
}
