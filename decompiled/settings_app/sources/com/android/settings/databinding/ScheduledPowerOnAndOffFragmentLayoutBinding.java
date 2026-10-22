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
public final class ScheduledPowerOnAndOffFragmentLayoutBinding implements ViewBinding {
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OCardListItem schedulePowerOffItem;
    public final OCardListItem schedulePowerOnItem;
    public final OCardListItem shutdownTimeItem;
    public final OCardListItem startupTimeItem;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ScheduledPowerOnAndOffFragmentLayoutBinding(RelativeLayout r1, LinearLayout r2, OScrollView r3, OCardListItem r4, OCardListItem r5, OCardListItem r6, OCardListItem r7, OFloatingTitleBar r8) {
        this.rootView = r1;
        this.pageContainer = r2;
        this.pageScrollview = r3;
        this.schedulePowerOffItem = r4;
        this.schedulePowerOnItem = r5;
        this.shutdownTimeItem = r6;
        this.startupTimeItem = r7;
        this.viewTitle = r8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ScheduledPowerOnAndOffFragmentLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ScheduledPowerOnAndOffFragmentLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.scheduled_power_on_and_off_fragment_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ScheduledPowerOnAndOffFragmentLayoutBinding bind(View r11) {
        int r0 = R.id.page_container;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r11, R.id.page_container);
        if (r4 == null) goto L19;
        r0 = R.id.page_scrollview;
        OScrollView r5 = (OScrollView) ViewBindings.findChildViewById(r11, R.id.page_scrollview);
        if (r5 == null) goto L19;
        r0 = R.id.schedule_power_off_item;
        OCardListItem r6 = (OCardListItem) ViewBindings.findChildViewById(r11, R.id.schedule_power_off_item);
        if (r6 == null) goto L19;
        r0 = R.id.schedule_power_on_item;
        OCardListItem r7 = (OCardListItem) ViewBindings.findChildViewById(r11, R.id.schedule_power_on_item);
        if (r7 == null) goto L19;
        r0 = R.id.shutdown_time_item;
        OCardListItem r8 = (OCardListItem) ViewBindings.findChildViewById(r11, R.id.shutdown_time_item);
        if (r8 == null) goto L19;
        r0 = R.id.startup_time_item;
        OCardListItem r9 = (OCardListItem) ViewBindings.findChildViewById(r11, R.id.startup_time_item);
        if (r9 == null) goto L19;
        r0 = R.id.view_title;
        OFloatingTitleBar r10 = (OFloatingTitleBar) ViewBindings.findChildViewById(r11, R.id.view_title);
        if (r10 == null) goto L19;
        return new ScheduledPowerOnAndOffFragmentLayoutBinding((RelativeLayout) r11, r4, r5, r6, r7, r8, r9, r10);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }
}
