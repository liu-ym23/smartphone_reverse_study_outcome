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
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.ExtendListView;

/* JADX INFO: loaded from: classes2.dex */
public final class FragmentPrintSettingsLayoutBinding implements ViewBinding {
    public final View printBottomSpace;
    public final LinearLayout printContainer;
    public final ExtendListView printJobList;
    public final OSectionTitleBar printJobTitle;
    public final ExtendListView printList;
    public final OScrollView printScrollview;
    public final View printSpace;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private FragmentPrintSettingsLayoutBinding(RelativeLayout r1, View r2, LinearLayout r3, ExtendListView r4, OSectionTitleBar r5, ExtendListView r6, OScrollView r7, View r8, OFloatingTitleBar r9) {
        this.rootView = r1;
        this.printBottomSpace = r2;
        this.printContainer = r3;
        this.printJobList = r4;
        this.printJobTitle = r5;
        this.printList = r6;
        this.printScrollview = r7;
        this.printSpace = r8;
        this.viewTitle = r9;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentPrintSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FragmentPrintSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.fragment_print_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static FragmentPrintSettingsLayoutBinding bind(View r11) {
        int r0 = R.id.print_bottom_space;
        View r3 = ViewBindings.findChildViewById(r11, R.id.print_bottom_space);
        if (r3 == null) goto L21;
        r0 = R.id.print_container;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r11, R.id.print_container);
        if (r4 == null) goto L21;
        r0 = R.id.print_job_list;
        ExtendListView r5 = (ExtendListView) ViewBindings.findChildViewById(r11, R.id.print_job_list);
        if (r5 == null) goto L21;
        r0 = R.id.print_job_title;
        OSectionTitleBar r6 = (OSectionTitleBar) ViewBindings.findChildViewById(r11, R.id.print_job_title);
        if (r6 == null) goto L21;
        r0 = R.id.print_list;
        ExtendListView r7 = (ExtendListView) ViewBindings.findChildViewById(r11, R.id.print_list);
        if (r7 == null) goto L21;
        r0 = R.id.print_scrollview;
        OScrollView r8 = (OScrollView) ViewBindings.findChildViewById(r11, R.id.print_scrollview);
        if (r8 == null) goto L21;
        r0 = R.id.print_space;
        View r9 = ViewBindings.findChildViewById(r11, R.id.print_space);
        if (r9 == null) goto L21;
        r0 = R.id.view_title;
        OFloatingTitleBar r10 = (OFloatingTitleBar) ViewBindings.findChildViewById(r11, R.id.view_title);
        if (r10 == null) goto L21;
        return new FragmentPrintSettingsLayoutBinding((RelativeLayout) r11, r3, r4, r5, r6, r7, r8, r9, r10);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }
}
