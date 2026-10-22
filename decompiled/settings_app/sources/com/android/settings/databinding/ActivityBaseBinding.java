package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.button.OButton;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class ActivityBaseBinding implements ViewBinding {
    public final RelativeLayout bottomActionBar;
    public final OButton bottomButton;
    public final FrameLayout contentFrame;
    public final View fakeStatusBar;
    public final OTextView laterSetting;
    public final RelativeLayout rootView;
    private final RelativeLayout rootView_;
    public final OFloatingTitleBar titleBar;
    public final ImageView titleIcon;
    public final LinearLayout titlebarContainer;
    public final OButton titlebarRightBtn;
    public final OTextView titlebarTitleTv;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ActivityBaseBinding(RelativeLayout r1, RelativeLayout r2, OButton r3, FrameLayout r4, View r5, OTextView r6, RelativeLayout r7, OFloatingTitleBar r8, ImageView r9, LinearLayout r10, OButton r11, OTextView r12) {
        this.rootView_ = r1;
        this.bottomActionBar = r2;
        this.bottomButton = r3;
        this.contentFrame = r4;
        this.fakeStatusBar = r5;
        this.laterSetting = r6;
        this.rootView = r7;
        this.titleBar = r8;
        this.titleIcon = r9;
        this.titlebarContainer = r10;
        this.titlebarRightBtn = r11;
        this.titlebarTitleTv = r12;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView_;
    }

    public static ActivityBaseBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityBaseBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.activity_base, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ActivityBaseBinding bind(View r15) {
        int r0 = R.id.bottom_action_bar;
        RelativeLayout r4 = (RelativeLayout) ViewBindings.findChildViewById(r15, R.id.bottom_action_bar);
        if (r4 == null) goto L25;
        r0 = R.id.bottom_button;
        OButton r5 = (OButton) ViewBindings.findChildViewById(r15, R.id.bottom_button);
        if (r5 == null) goto L25;
        r0 = R.id.content_frame;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r15, R.id.content_frame);
        if (r6 == null) goto L25;
        r0 = R.id.fake_status_bar;
        View r7 = ViewBindings.findChildViewById(r15, R.id.fake_status_bar);
        if (r7 == null) goto L25;
        r0 = R.id.later_setting;
        OTextView r8 = (OTextView) ViewBindings.findChildViewById(r15, R.id.later_setting);
        if (r8 == null) goto L25;
        RelativeLayout r9 = (RelativeLayout) r15;
        r0 = R.id.title_bar;
        OFloatingTitleBar r10 = (OFloatingTitleBar) ViewBindings.findChildViewById(r15, R.id.title_bar);
        if (r10 == null) goto L25;
        r0 = R.id.title_icon;
        ImageView r11 = (ImageView) ViewBindings.findChildViewById(r15, R.id.title_icon);
        if (r11 == null) goto L25;
        r0 = R.id.titlebar_container;
        LinearLayout r12 = (LinearLayout) ViewBindings.findChildViewById(r15, R.id.titlebar_container);
        if (r12 == null) goto L25;
        r0 = R.id.titlebar_right_btn;
        OButton r13 = (OButton) ViewBindings.findChildViewById(r15, R.id.titlebar_right_btn);
        if (r13 == null) goto L25;
        r0 = R.id.titlebar_title_tv;
        OTextView r14 = (OTextView) ViewBindings.findChildViewById(r15, R.id.titlebar_title_tv);
        if (r14 == null) goto L25;
        return new ActivityBaseBinding(r9, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r15.getResources().getResourceName(r0)));
    }
}
