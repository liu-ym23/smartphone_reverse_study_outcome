package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OListItemGeneral;
import com.obric.oui.lisitem.OListItemSwitch;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class ActivityDataSaverSummaryBinding implements ViewBinding {
    public final OListItemGeneral dataSaver;
    public final OListItemSwitch dataSaverSwitch;
    public final View fakeStatusBar;
    public final LinearLayout llContainer;
    public final ConstraintLayout main;
    private final ConstraintLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ActivityDataSaverSummaryBinding(ConstraintLayout r1, OListItemGeneral r2, OListItemSwitch r3, View r4, LinearLayout r5, ConstraintLayout r6, OFloatingTitleBar r7) {
        this.rootView = r1;
        this.dataSaver = r2;
        this.dataSaverSwitch = r3;
        this.fakeStatusBar = r4;
        this.llContainer = r5;
        this.main = r6;
        this.viewTitle = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityDataSaverSummaryBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityDataSaverSummaryBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.activity_data_saver_summary, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ActivityDataSaverSummaryBinding bind(View r10) {
        int r0 = R.id.data_saver;
        OListItemGeneral r4 = (OListItemGeneral) ViewBindings.findChildViewById(r10, R.id.data_saver);
        if (r4 == null) goto L15;
        r0 = R.id.data_saver_switch;
        OListItemSwitch r5 = (OListItemSwitch) ViewBindings.findChildViewById(r10, R.id.data_saver_switch);
        if (r5 == null) goto L15;
        r0 = R.id.fake_status_bar;
        View r6 = ViewBindings.findChildViewById(r10, R.id.fake_status_bar);
        if (r6 == null) goto L15;
        r0 = R.id.ll_container;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r10, R.id.ll_container);
        if (r7 == null) goto L15;
        ConstraintLayout r8 = (ConstraintLayout) r10;
        r0 = R.id.view_title;
        OFloatingTitleBar r9 = (OFloatingTitleBar) ViewBindings.findChildViewById(r10, R.id.view_title);
        if (r9 == null) goto L15;
        return new ActivityDataSaverSummaryBinding(r8, r4, r5, r6, r7, r8, r9);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
