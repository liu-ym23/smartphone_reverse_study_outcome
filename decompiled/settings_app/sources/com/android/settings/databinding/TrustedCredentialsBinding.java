package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OListView;
import com.obric.oui.progress.OProgressView;
import com.obric.oui.tab.OTabLayout;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class TrustedCredentialsBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final ExpandableListView systemExpandableList;
    public final OListView systemList;
    public final OProgressView systemProgress;
    public final FrameLayout systemTab;
    public final OTabLayout tabLayout;
    public final ExpandableListView userExpandableList;
    public final OListView userList;
    public final OProgressView userProgress;
    public final FrameLayout userTab;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private TrustedCredentialsBinding(RelativeLayout r1, ExpandableListView r2, OListView r3, OProgressView r4, FrameLayout r5, OTabLayout r6, ExpandableListView r7, OListView r8, OProgressView r9, FrameLayout r10, OFloatingTitleBar r11) {
        this.rootView = r1;
        this.systemExpandableList = r2;
        this.systemList = r3;
        this.systemProgress = r4;
        this.systemTab = r5;
        this.tabLayout = r6;
        this.userExpandableList = r7;
        this.userList = r8;
        this.userProgress = r9;
        this.userTab = r10;
        this.viewTitle = r11;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static TrustedCredentialsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static TrustedCredentialsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.trusted_credentials, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static TrustedCredentialsBinding bind(View r14) {
        int r0 = R.id.system_expandable_list;
        ExpandableListView r4 = (ExpandableListView) ViewBindings.findChildViewById(r14, R.id.system_expandable_list);
        if (r4 == null) goto L25;
        r0 = R.id.system_list;
        OListView r5 = (OListView) ViewBindings.findChildViewById(r14, R.id.system_list);
        if (r5 == null) goto L25;
        r0 = R.id.system_progress;
        OProgressView r6 = (OProgressView) ViewBindings.findChildViewById(r14, R.id.system_progress);
        if (r6 == null) goto L25;
        r0 = R.id.system_tab;
        FrameLayout r7 = (FrameLayout) ViewBindings.findChildViewById(r14, R.id.system_tab);
        if (r7 == null) goto L25;
        r0 = R.id.tabLayout;
        OTabLayout r8 = (OTabLayout) ViewBindings.findChildViewById(r14, R.id.tabLayout);
        if (r8 == null) goto L25;
        r0 = R.id.user_expandable_list;
        ExpandableListView r9 = (ExpandableListView) ViewBindings.findChildViewById(r14, R.id.user_expandable_list);
        if (r9 == null) goto L25;
        r0 = R.id.user_list;
        OListView r10 = (OListView) ViewBindings.findChildViewById(r14, R.id.user_list);
        if (r10 == null) goto L25;
        r0 = R.id.user_progress;
        OProgressView r11 = (OProgressView) ViewBindings.findChildViewById(r14, R.id.user_progress);
        if (r11 == null) goto L25;
        r0 = R.id.user_tab;
        FrameLayout r12 = (FrameLayout) ViewBindings.findChildViewById(r14, R.id.user_tab);
        if (r12 == null) goto L25;
        r0 = R.id.view_title;
        OFloatingTitleBar r13 = (OFloatingTitleBar) ViewBindings.findChildViewById(r14, R.id.view_title);
        if (r13 == null) goto L25;
        return new TrustedCredentialsBinding((RelativeLayout) r14, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r0)));
    }
}
