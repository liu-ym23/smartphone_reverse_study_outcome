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
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class DozeModeBinding implements ViewBinding {
    public final OSectionSupportiveText autoLockTips;
    public final OCardListItem dozeModeAllDay;
    public final OCardListItem dozeModeLowPowerConsume;
    public final OCardListItem dozeModeOff;
    public final OCardListItem dozeModeScheduled;
    public final OSectionTitleBar dozeModeScheduledTips;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OCardListItem scheduleEnd;
    public final OCardListItem scheduleStart;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DozeModeBinding(RelativeLayout r1, OSectionSupportiveText r2, OCardListItem r3, OCardListItem r4, OCardListItem r5, OCardListItem r6, OSectionTitleBar r7, LinearLayout r8, OScrollView r9, OCardListItem r10, OCardListItem r11, OFloatingTitleBar r12) {
        this.rootView = r1;
        this.autoLockTips = r2;
        this.dozeModeAllDay = r3;
        this.dozeModeLowPowerConsume = r4;
        this.dozeModeOff = r5;
        this.dozeModeScheduled = r6;
        this.dozeModeScheduledTips = r7;
        this.pageContainer = r8;
        this.pageScrollview = r9;
        this.scheduleEnd = r10;
        this.scheduleStart = r11;
        this.viewTitle = r12;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DozeModeBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DozeModeBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.doze_mode, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DozeModeBinding bind(View r15) {
        int r0 = R.id.auto_lock_tips;
        OSectionSupportiveText r4 = (OSectionSupportiveText) ViewBindings.findChildViewById(r15, R.id.auto_lock_tips);
        if (r4 == null) goto L27;
        r0 = R.id.doze_mode_all_day;
        OCardListItem r5 = (OCardListItem) ViewBindings.findChildViewById(r15, R.id.doze_mode_all_day);
        if (r5 == null) goto L27;
        r0 = R.id.doze_mode_low_power_consume;
        OCardListItem r6 = (OCardListItem) ViewBindings.findChildViewById(r15, R.id.doze_mode_low_power_consume);
        if (r6 == null) goto L27;
        r0 = R.id.doze_mode_off;
        OCardListItem r7 = (OCardListItem) ViewBindings.findChildViewById(r15, R.id.doze_mode_off);
        if (r7 == null) goto L27;
        r0 = R.id.doze_mode_scheduled;
        OCardListItem r8 = (OCardListItem) ViewBindings.findChildViewById(r15, R.id.doze_mode_scheduled);
        if (r8 == null) goto L27;
        r0 = R.id.doze_mode_scheduled_tips;
        OSectionTitleBar r9 = (OSectionTitleBar) ViewBindings.findChildViewById(r15, R.id.doze_mode_scheduled_tips);
        if (r9 == null) goto L27;
        r0 = R.id.page_container;
        LinearLayout r10 = (LinearLayout) ViewBindings.findChildViewById(r15, R.id.page_container);
        if (r10 == null) goto L27;
        r0 = R.id.page_scrollview;
        OScrollView r11 = (OScrollView) ViewBindings.findChildViewById(r15, R.id.page_scrollview);
        if (r11 == null) goto L27;
        r0 = R.id.schedule_end;
        OCardListItem r12 = (OCardListItem) ViewBindings.findChildViewById(r15, R.id.schedule_end);
        if (r12 == null) goto L27;
        r0 = R.id.schedule_start;
        OCardListItem r13 = (OCardListItem) ViewBindings.findChildViewById(r15, R.id.schedule_start);
        if (r13 == null) goto L27;
        r0 = R.id.view_title;
        OFloatingTitleBar r14 = (OFloatingTitleBar) ViewBindings.findChildViewById(r15, R.id.view_title);
        if (r14 == null) goto L27;
        return new DozeModeBinding((RelativeLayout) r15, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(r15.getResources().getResourceName(r0)));
    }
}
