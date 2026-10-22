package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import obric.widget.SwitchEx;

/* JADX INFO: loaded from: classes2.dex */
public final class OcrAppItemLayoutBinding implements ViewBinding {
    public final RelativeLayout appLayout;
    public final ImageView itemIcon;
    public final SwitchEx itemSwitch;
    public final TextView itemTitle;
    private final FrameLayout rootView;
    public final LinearLayout scrollHandleLayout;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private OcrAppItemLayoutBinding(FrameLayout r1, RelativeLayout r2, ImageView r3, SwitchEx r4, TextView r5, LinearLayout r6) {
        this.rootView = r1;
        this.appLayout = r2;
        this.itemIcon = r3;
        this.itemSwitch = r4;
        this.itemTitle = r5;
        this.scrollHandleLayout = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static OcrAppItemLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static OcrAppItemLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.ocr_app_item_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static OcrAppItemLayoutBinding bind(View r9) {
        int r0 = R.id.app_layout;
        RelativeLayout r4 = (RelativeLayout) ViewBindings.findChildViewById(r9, R.id.app_layout);
        if (r4 == null) goto L15;
        r0 = R.id.item_icon;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r9, R.id.item_icon);
        if (r5 == null) goto L15;
        r0 = R.id.item_switch;
        SwitchEx r6 = (SwitchEx) ViewBindings.findChildViewById(r9, R.id.item_switch);
        if (r6 == null) goto L15;
        r0 = R.id.item_title;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r9, R.id.item_title);
        if (r7 == null) goto L15;
        r0 = R.id.scroll_handle_layout;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r9, R.id.scroll_handle_layout);
        if (r8 == null) goto L15;
        return new OcrAppItemLayoutBinding((FrameLayout) r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
