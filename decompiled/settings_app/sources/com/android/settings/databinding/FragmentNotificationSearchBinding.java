package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OListView;
import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.searchbar.v2.OSearchBar;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class FragmentNotificationSearchBinding implements ViewBinding {
    public final OPageStatus blankview;
    private final RelativeLayout rootView;
    public final OIconButtonFloating searchCancelButton;
    public final TextView searchEmptyView;
    public final OSearchBar searchFieldBar;
    public final OListView searchListview;
    public final RelativeLayout tipsView;
    public final OFloatingTitleBar viewTitle1;
    public final RelativeLayout wholeView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private FragmentNotificationSearchBinding(RelativeLayout r1, OPageStatus r2, OIconButtonFloating r3, TextView r4, OSearchBar r5, OListView r6, RelativeLayout r7, OFloatingTitleBar r8, RelativeLayout r9) {
        this.rootView = r1;
        this.blankview = r2;
        this.searchCancelButton = r3;
        this.searchEmptyView = r4;
        this.searchFieldBar = r5;
        this.searchListview = r6;
        this.tipsView = r7;
        this.viewTitle1 = r8;
        this.wholeView = r9;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentNotificationSearchBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FragmentNotificationSearchBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.fragment_notification_search, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static FragmentNotificationSearchBinding bind(View r12) {
        int r0 = R.id.blankview;
        OPageStatus r4 = (OPageStatus) ViewBindings.findChildViewById(r12, R.id.blankview);
        if (r4 == null) goto L19;
        r0 = R.id.search_cancel_button;
        OIconButtonFloating r5 = (OIconButtonFloating) ViewBindings.findChildViewById(r12, R.id.search_cancel_button);
        if (r5 == null) goto L19;
        r0 = R.id.search_empty_view;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r12, R.id.search_empty_view);
        if (r6 == null) goto L19;
        r0 = R.id.search_field_bar;
        OSearchBar r7 = (OSearchBar) ViewBindings.findChildViewById(r12, R.id.search_field_bar);
        if (r7 == null) goto L19;
        r0 = R.id.search_listview;
        OListView r8 = (OListView) ViewBindings.findChildViewById(r12, R.id.search_listview);
        if (r8 == null) goto L19;
        r0 = R.id.tips_view;
        RelativeLayout r9 = (RelativeLayout) ViewBindings.findChildViewById(r12, R.id.tips_view);
        if (r9 == null) goto L19;
        r0 = R.id.view_title1;
        OFloatingTitleBar r10 = (OFloatingTitleBar) ViewBindings.findChildViewById(r12, R.id.view_title1);
        if (r10 == null) goto L19;
        RelativeLayout r11 = (RelativeLayout) r12;
        return new FragmentNotificationSearchBinding(r11, r4, r5, r6, r7, r8, r9, r10, r11);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r0)));
    }
}
