package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class TrackballGifAnimLayoutBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final ImageView trackball;
    public final ImageView trackballHand;
    public final ImageView trackballLight;
    public final ImageView trackballMsgEdit;
    public final ImageView trackballMsgList;
    public final ImageView trackballPageHome;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private TrackballGifAnimLayoutBinding(RelativeLayout r1, ImageView r2, ImageView r3, ImageView r4, ImageView r5, ImageView r6, ImageView r7) {
        this.rootView = r1;
        this.trackball = r2;
        this.trackballHand = r3;
        this.trackballLight = r4;
        this.trackballMsgEdit = r5;
        this.trackballMsgList = r6;
        this.trackballPageHome = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static TrackballGifAnimLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static TrackballGifAnimLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.trackball_gif_anim_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static TrackballGifAnimLayoutBinding bind(View r10) {
        int r0 = R.id.trackball;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r10, R.id.trackball);
        if (r4 == null) goto L17;
        r0 = R.id.trackball_hand;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r10, R.id.trackball_hand);
        if (r5 == null) goto L17;
        r0 = R.id.trackball_light;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r10, R.id.trackball_light);
        if (r6 == null) goto L17;
        r0 = R.id.trackball_msg_edit;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r10, R.id.trackball_msg_edit);
        if (r7 == null) goto L17;
        r0 = R.id.trackball_msg_list;
        ImageView r8 = (ImageView) ViewBindings.findChildViewById(r10, R.id.trackball_msg_list);
        if (r8 == null) goto L17;
        r0 = R.id.trackball_page_home;
        ImageView r9 = (ImageView) ViewBindings.findChildViewById(r10, R.id.trackball_page_home);
        if (r9 == null) goto L17;
        return new TrackballGifAnimLayoutBinding((RelativeLayout) r10, r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
