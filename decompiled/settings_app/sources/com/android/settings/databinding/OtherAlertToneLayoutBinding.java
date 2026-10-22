package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class OtherAlertToneLayoutBinding implements ViewBinding {
    public final OCardListItem dialPadTones;
    public final OCardListItem lowBatterySound;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OCardListItem screenLockingSounds;
    public final OCardListItem screenshotSounds;
    public final OCardListItem touchSounds;
    public final OCardListItem unlockSounds;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private OtherAlertToneLayoutBinding(RelativeLayout r1, OCardListItem r2, OCardListItem r3, LinearLayout r4, OScrollView r5, OCardListItem r6, OCardListItem r7, OCardListItem r8, OCardListItem r9, OFloatingTitleBar r10) {
        this.rootView = r1;
        this.dialPadTones = r2;
        this.lowBatterySound = r3;
        this.pageContainer = r4;
        this.pageScrollview = r5;
        this.screenLockingSounds = r6;
        this.screenshotSounds = r7;
        this.touchSounds = r8;
        this.unlockSounds = r9;
        this.viewTitle = r10;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static OtherAlertToneLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static OtherAlertToneLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.other_alert_tone_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static OtherAlertToneLayoutBinding bind(View r13) {
        int r0 = R.id.dial_pad_tones;
        OCardListItem r4 = (OCardListItem) ViewBindings.findChildViewById(r13, R.id.dial_pad_tones);
        if (r4 == null) goto L23;
        r0 = R.id.low_battery_sound;
        OCardListItem r5 = (OCardListItem) ViewBindings.findChildViewById(r13, R.id.low_battery_sound);
        if (r5 == null) goto L23;
        r0 = R.id.page_container;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r13, R.id.page_container);
        if (r6 == null) goto L23;
        r0 = R.id.page_scrollview;
        OScrollView r7 = (OScrollView) ViewBindings.findChildViewById(r13, R.id.page_scrollview);
        if (r7 == null) goto L23;
        r0 = R.id.screen_locking_sounds;
        OCardListItem r8 = (OCardListItem) ViewBindings.findChildViewById(r13, R.id.screen_locking_sounds);
        if (r8 == null) goto L23;
        r0 = R.id.screenshot_sounds;
        OCardListItem r9 = (OCardListItem) ViewBindings.findChildViewById(r13, R.id.screenshot_sounds);
        if (r9 == null) goto L23;
        r0 = R.id.touch_sounds;
        OCardListItem r10 = (OCardListItem) ViewBindings.findChildViewById(r13, R.id.touch_sounds);
        if (r10 == null) goto L23;
        r0 = R.id.unlock_sounds;
        OCardListItem r11 = (OCardListItem) ViewBindings.findChildViewById(r13, R.id.unlock_sounds);
        if (r11 == null) goto L23;
        r0 = R.id.view_title;
        OFloatingTitleBar r12 = (OFloatingTitleBar) ViewBindings.findChildViewById(r13, R.id.view_title);
        if (r12 == null) goto L23;
        return new OtherAlertToneLayoutBinding((RelativeLayout) r13, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r0)));
    }
}
