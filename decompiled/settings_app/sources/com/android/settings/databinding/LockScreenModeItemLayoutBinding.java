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

/* JADX INFO: loaded from: classes2.dex */
public final class LockScreenModeItemLayoutBinding implements ViewBinding {
    public final FrameLayout frameLayout;
    public final ImageView itemIcon;
    public final ImageView itemIconFrame;
    public final TextView itemSubtitle;
    public final TextView itemTitle;
    private final RelativeLayout rootView;
    public final LinearLayout textArea;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private LockScreenModeItemLayoutBinding(RelativeLayout r1, FrameLayout r2, ImageView r3, ImageView r4, TextView r5, TextView r6, LinearLayout r7) {
        this.rootView = r1;
        this.frameLayout = r2;
        this.itemIcon = r3;
        this.itemIconFrame = r4;
        this.itemSubtitle = r5;
        this.itemTitle = r6;
        this.textArea = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LockScreenModeItemLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static LockScreenModeItemLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.lock_screen_mode_item_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static LockScreenModeItemLayoutBinding bind(View r10) {
        int r0 = R.id.frame_layout;
        FrameLayout r4 = (FrameLayout) ViewBindings.findChildViewById(r10, R.id.frame_layout);
        if (r4 == null) goto L17;
        r0 = R.id.item_icon;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r10, R.id.item_icon);
        if (r5 == null) goto L17;
        r0 = R.id.item_icon_frame;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r10, R.id.item_icon_frame);
        if (r6 == null) goto L17;
        r0 = R.id.item_subtitle;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r10, R.id.item_subtitle);
        if (r7 == null) goto L17;
        r0 = R.id.item_title;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r10, R.id.item_title);
        if (r8 == null) goto L17;
        r0 = R.id.text_area;
        LinearLayout r9 = (LinearLayout) ViewBindings.findChildViewById(r10, R.id.text_area);
        if (r9 == null) goto L17;
        return new LockScreenModeItemLayoutBinding((RelativeLayout) r10, r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
