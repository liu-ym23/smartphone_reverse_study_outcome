package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.applications.PreferredActivityChooserExtendFragment;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class FragmentPreferredChooserBinding implements ViewBinding {
    public final TextView emptyTitle;
    public final LinearLayout llSeeList;
    public final LinearLayout llSendList;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    public final RelativeLayout preferredEmpty;
    private final RelativeLayout rootView;
    public final PreferredActivityChooserExtendFragment.ExtendListView seeList;
    public final TextView seeListTitle;
    public final PreferredActivityChooserExtendFragment.ExtendListView sendList;
    public final TextView sendListTitle;
    public final TextView tips;
    public final TextView viewEmpty;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private FragmentPreferredChooserBinding(RelativeLayout r1, TextView r2, LinearLayout r3, LinearLayout r4, LinearLayout r5, OScrollView r6, RelativeLayout r7, PreferredActivityChooserExtendFragment.ExtendListView r8, TextView r9, PreferredActivityChooserExtendFragment.ExtendListView r10, TextView r11, TextView r12, TextView r13, OFloatingTitleBar r14) {
        this.rootView = r1;
        this.emptyTitle = r2;
        this.llSeeList = r3;
        this.llSendList = r4;
        this.pageContainer = r5;
        this.pageScrollview = r6;
        this.preferredEmpty = r7;
        this.seeList = r8;
        this.seeListTitle = r9;
        this.sendList = r10;
        this.sendListTitle = r11;
        this.tips = r12;
        this.viewEmpty = r13;
        this.viewTitle = r14;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentPreferredChooserBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FragmentPreferredChooserBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.fragment_preferred_chooser, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static FragmentPreferredChooserBinding bind(View r18) {
        int r1 = R.id.empty_title;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r18, R.id.empty_title);
        if (r5 == null) goto L31;
        r1 = R.id.ll_see_list;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r18, R.id.ll_see_list);
        if (r6 == null) goto L31;
        r1 = R.id.ll_send_list;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r18, R.id.ll_send_list);
        if (r7 == null) goto L31;
        r1 = R.id.page_container;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r18, R.id.page_container);
        if (r8 == null) goto L31;
        r1 = R.id.page_scrollview;
        OScrollView r9 = (OScrollView) ViewBindings.findChildViewById(r18, R.id.page_scrollview);
        if (r9 == null) goto L31;
        r1 = R.id.preferred_empty;
        RelativeLayout r10 = (RelativeLayout) ViewBindings.findChildViewById(r18, R.id.preferred_empty);
        if (r10 == null) goto L31;
        r1 = R.id.see_list;
        PreferredActivityChooserExtendFragment.ExtendListView r11 = (PreferredActivityChooserExtendFragment.ExtendListView) ViewBindings.findChildViewById(r18, R.id.see_list);
        if (r11 == null) goto L31;
        r1 = R.id.see_list_title;
        TextView r12 = (TextView) ViewBindings.findChildViewById(r18, R.id.see_list_title);
        if (r12 == null) goto L31;
        r1 = R.id.send_list;
        PreferredActivityChooserExtendFragment.ExtendListView r13 = (PreferredActivityChooserExtendFragment.ExtendListView) ViewBindings.findChildViewById(r18, R.id.send_list);
        if (r13 == null) goto L31;
        r1 = R.id.send_list_title;
        TextView r14 = (TextView) ViewBindings.findChildViewById(r18, R.id.send_list_title);
        if (r14 == null) goto L31;
        r1 = R.id.tips;
        TextView r15 = (TextView) ViewBindings.findChildViewById(r18, R.id.tips);
        if (r15 == null) goto L31;
        r1 = R.id.view_empty;
        TextView r16 = (TextView) ViewBindings.findChildViewById(r18, R.id.view_empty);
        if (r16 == null) goto L31;
        r1 = R.id.view_title;
        OFloatingTitleBar r17 = (OFloatingTitleBar) ViewBindings.findChildViewById(r18, R.id.view_title);
        if (r17 == null) goto L31;
        return new FragmentPreferredChooserBinding((RelativeLayout) r18, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
    L31:
        throw new NullPointerException("Missing required view with ID: ".concat(r18.getResources().getResourceName(r1)));
    }
}
