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
import obric.widget.ListContentItemSwitch;
import obric.widget.ListContentItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class DynamicResolutionHeaderBinding implements ViewBinding {
    public final RelativeLayout dynamicResolutionAlways;
    public final ImageView dynamicResolutionAlwaysImage;
    public final TextView dynamicResolutionAlwaysText;
    public final ListContentItemSwitch dynamicResolutionEnabled;
    public final TextView dynamicResolutionGameListTitle;
    public final RelativeLayout dynamicResolutionSmart;
    public final ImageView dynamicResolutionSmartImage;
    public final TextView dynamicResolutionSmartText;
    public final ListContentItemText emptyView;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DynamicResolutionHeaderBinding(LinearLayout r1, RelativeLayout r2, ImageView r3, TextView r4, ListContentItemSwitch r5, TextView r6, RelativeLayout r7, ImageView r8, TextView r9, ListContentItemText r10) {
        this.rootView = r1;
        this.dynamicResolutionAlways = r2;
        this.dynamicResolutionAlwaysImage = r3;
        this.dynamicResolutionAlwaysText = r4;
        this.dynamicResolutionEnabled = r5;
        this.dynamicResolutionGameListTitle = r6;
        this.dynamicResolutionSmart = r7;
        this.dynamicResolutionSmartImage = r8;
        this.dynamicResolutionSmartText = r9;
        this.emptyView = r10;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DynamicResolutionHeaderBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DynamicResolutionHeaderBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.dynamic_resolution_header, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DynamicResolutionHeaderBinding bind(View r13) {
        int r0 = R.id.dynamic_resolution_always;
        RelativeLayout r4 = (RelativeLayout) ViewBindings.findChildViewById(r13, R.id.dynamic_resolution_always);
        if (r4 == null) goto L23;
        r0 = R.id.dynamic_resolution_always_image;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r13, R.id.dynamic_resolution_always_image);
        if (r5 == null) goto L23;
        r0 = R.id.dynamic_resolution_always_text;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r13, R.id.dynamic_resolution_always_text);
        if (r6 == null) goto L23;
        r0 = R.id.dynamic_resolution_enabled;
        ListContentItemSwitch r7 = (ListContentItemSwitch) ViewBindings.findChildViewById(r13, R.id.dynamic_resolution_enabled);
        if (r7 == null) goto L23;
        r0 = R.id.dynamic_resolution_game_list_title;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r13, R.id.dynamic_resolution_game_list_title);
        if (r8 == null) goto L23;
        r0 = R.id.dynamic_resolution_smart;
        RelativeLayout r9 = (RelativeLayout) ViewBindings.findChildViewById(r13, R.id.dynamic_resolution_smart);
        if (r9 == null) goto L23;
        r0 = R.id.dynamic_resolution_smart_image;
        ImageView r10 = (ImageView) ViewBindings.findChildViewById(r13, R.id.dynamic_resolution_smart_image);
        if (r10 == null) goto L23;
        r0 = R.id.dynamic_resolution_smart_text;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r13, R.id.dynamic_resolution_smart_text);
        if (r11 == null) goto L23;
        r0 = R.id.empty_view;
        ListContentItemText r12 = (ListContentItemText) ViewBindings.findChildViewById(r13, R.id.empty_view);
        if (r12 == null) goto L23;
        return new DynamicResolutionHeaderBinding((LinearLayout) r13, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r0)));
    }
}
