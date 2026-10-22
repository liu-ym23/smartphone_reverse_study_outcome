package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class TouchpadGestureGroupLayoutBinding implements ViewBinding {
    public final View divider;
    public final RelativeLayout gestureItemLayout;
    public final LinearLayout gestureItems;
    public final TextView groupTitle;
    public final ProgressBar progressBar;
    private final RelativeLayout rootView;
    public final VideoView video;
    public final View videoBackground;
    public final FrameLayout videoLayout;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private TouchpadGestureGroupLayoutBinding(RelativeLayout r1, View r2, RelativeLayout r3, LinearLayout r4, TextView r5, ProgressBar r6, VideoView r7, View r8, FrameLayout r9) {
        this.rootView = r1;
        this.divider = r2;
        this.gestureItemLayout = r3;
        this.gestureItems = r4;
        this.groupTitle = r5;
        this.progressBar = r6;
        this.video = r7;
        this.videoBackground = r8;
        this.videoLayout = r9;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static TouchpadGestureGroupLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static TouchpadGestureGroupLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.touchpad_gesture_group_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static TouchpadGestureGroupLayoutBinding bind(View r11) {
        int r0 = R.id.divider;
        View r3 = ViewBindings.findChildViewById(r11, R.id.divider);
        if (r3 == null) goto L21;
        r0 = R.id.gesture_item_layout;
        RelativeLayout r4 = (RelativeLayout) ViewBindings.findChildViewById(r11, R.id.gesture_item_layout);
        if (r4 == null) goto L21;
        r0 = R.id.gesture_items;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r11, R.id.gesture_items);
        if (r5 == null) goto L21;
        r0 = R.id.group_title;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r11, R.id.group_title);
        if (r6 == null) goto L21;
        r0 = R.id.progress_bar;
        ProgressBar r7 = (ProgressBar) ViewBindings.findChildViewById(r11, R.id.progress_bar);
        if (r7 == null) goto L21;
        r0 = R.id.video;
        VideoView r8 = (VideoView) ViewBindings.findChildViewById(r11, R.id.video);
        if (r8 == null) goto L21;
        r0 = R.id.video_background;
        View r9 = ViewBindings.findChildViewById(r11, R.id.video_background);
        if (r9 == null) goto L21;
        r0 = R.id.video_layout;
        FrameLayout r10 = (FrameLayout) ViewBindings.findChildViewById(r11, R.id.video_layout);
        if (r10 == null) goto L21;
        return new TouchpadGestureGroupLayoutBinding((RelativeLayout) r11, r3, r4, r5, r6, r7, r8, r9, r10);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }
}
