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
public final class ProtectEyesTimerLayoutBinding implements ViewBinding {
    public final OCardListItem autoTimer;
    public final OCardListItem autoTurnOnOff;
    public final OCardListItem customTimer;
    public final OCardListItem customTimerEnd;
    public final OCardListItem customTimerStart;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    public final LinearLayout protectEyesCustomTimerContainer;
    public final LinearLayout protectEyesTimerContainer;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ProtectEyesTimerLayoutBinding(RelativeLayout r1, OCardListItem r2, OCardListItem r3, OCardListItem r4, OCardListItem r5, OCardListItem r6, LinearLayout r7, OScrollView r8, LinearLayout r9, LinearLayout r10, OFloatingTitleBar r11) {
        this.rootView = r1;
        this.autoTimer = r2;
        this.autoTurnOnOff = r3;
        this.customTimer = r4;
        this.customTimerEnd = r5;
        this.customTimerStart = r6;
        this.pageContainer = r7;
        this.pageScrollview = r8;
        this.protectEyesCustomTimerContainer = r9;
        this.protectEyesTimerContainer = r10;
        this.viewTitle = r11;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ProtectEyesTimerLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ProtectEyesTimerLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.protect_eyes_timer_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ProtectEyesTimerLayoutBinding bind(View r14) {
        int r0 = R.id.auto_timer;
        OCardListItem r4 = (OCardListItem) ViewBindings.findChildViewById(r14, R.id.auto_timer);
        if (r4 == null) goto L25;
        r0 = R.id.auto_turn_on_off;
        OCardListItem r5 = (OCardListItem) ViewBindings.findChildViewById(r14, R.id.auto_turn_on_off);
        if (r5 == null) goto L25;
        r0 = R.id.custom_timer;
        OCardListItem r6 = (OCardListItem) ViewBindings.findChildViewById(r14, R.id.custom_timer);
        if (r6 == null) goto L25;
        r0 = R.id.custom_timer_end;
        OCardListItem r7 = (OCardListItem) ViewBindings.findChildViewById(r14, R.id.custom_timer_end);
        if (r7 == null) goto L25;
        r0 = R.id.custom_timer_start;
        OCardListItem r8 = (OCardListItem) ViewBindings.findChildViewById(r14, R.id.custom_timer_start);
        if (r8 == null) goto L25;
        r0 = R.id.page_container;
        LinearLayout r9 = (LinearLayout) ViewBindings.findChildViewById(r14, R.id.page_container);
        if (r9 == null) goto L25;
        r0 = R.id.page_scrollview;
        OScrollView r10 = (OScrollView) ViewBindings.findChildViewById(r14, R.id.page_scrollview);
        if (r10 == null) goto L25;
        r0 = R.id.protect_eyes_custom_timer_container;
        LinearLayout r11 = (LinearLayout) ViewBindings.findChildViewById(r14, R.id.protect_eyes_custom_timer_container);
        if (r11 == null) goto L25;
        r0 = R.id.protect_eyes_timer_container;
        LinearLayout r12 = (LinearLayout) ViewBindings.findChildViewById(r14, R.id.protect_eyes_timer_container);
        if (r12 == null) goto L25;
        r0 = R.id.view_title;
        OFloatingTitleBar r13 = (OFloatingTitleBar) ViewBindings.findChildViewById(r14, R.id.view_title);
        if (r13 == null) goto L25;
        return new ProtectEyesTimerLayoutBinding((RelativeLayout) r14, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r0)));
    }
}
