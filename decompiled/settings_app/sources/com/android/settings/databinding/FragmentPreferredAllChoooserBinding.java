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
import com.android.settings.applications.PreferredActivityChooserForAllFragment;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class FragmentPreferredAllChoooserBinding implements ViewBinding {
    public final TextView emptyTitle;
    public final LinearLayout llSeeList;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    public final RelativeLayout preferredEmpty;
    private final RelativeLayout rootView;
    public final PreferredActivityChooserForAllFragment.ExtendListView seeList;
    public final TextView viewEmpty;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private FragmentPreferredAllChoooserBinding(RelativeLayout r1, TextView r2, LinearLayout r3, LinearLayout r4, OScrollView r5, RelativeLayout r6, PreferredActivityChooserForAllFragment.ExtendListView r7, TextView r8, OFloatingTitleBar r9) {
        this.rootView = r1;
        this.emptyTitle = r2;
        this.llSeeList = r3;
        this.pageContainer = r4;
        this.pageScrollview = r5;
        this.preferredEmpty = r6;
        this.seeList = r7;
        this.viewEmpty = r8;
        this.viewTitle = r9;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentPreferredAllChoooserBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FragmentPreferredAllChoooserBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.fragment_preferred_all_choooser, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static FragmentPreferredAllChoooserBinding bind(View r12) {
        int r0 = R.id.empty_title;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r12, R.id.empty_title);
        if (r4 == null) goto L21;
        r0 = R.id.ll_see_list;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r12, R.id.ll_see_list);
        if (r5 == null) goto L21;
        r0 = R.id.page_container;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r12, R.id.page_container);
        if (r6 == null) goto L21;
        r0 = R.id.page_scrollview;
        OScrollView r7 = (OScrollView) ViewBindings.findChildViewById(r12, R.id.page_scrollview);
        if (r7 == null) goto L21;
        r0 = R.id.preferred_empty;
        RelativeLayout r8 = (RelativeLayout) ViewBindings.findChildViewById(r12, R.id.preferred_empty);
        if (r8 == null) goto L21;
        r0 = R.id.see_list;
        PreferredActivityChooserForAllFragment.ExtendListView r9 = (PreferredActivityChooserForAllFragment.ExtendListView) ViewBindings.findChildViewById(r12, R.id.see_list);
        if (r9 == null) goto L21;
        r0 = R.id.view_empty;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r12, R.id.view_empty);
        if (r10 == null) goto L21;
        r0 = R.id.view_title;
        OFloatingTitleBar r11 = (OFloatingTitleBar) ViewBindings.findChildViewById(r12, R.id.view_title);
        if (r11 == null) goto L21;
        return new FragmentPreferredAllChoooserBinding((RelativeLayout) r12, r4, r5, r6, r7, r8, r9, r10, r11);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r0)));
    }
}
