package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.SearchBarSmt;
import com.android.settings.widget.SlideListView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.letters.QuickBarEx;

/* JADX INFO: loaded from: classes2.dex */
public final class AppLockListBinding implements ViewBinding {
    public final SearchBarSmt applockSearchBar;
    public final SlideListView listView;
    public final QuickBarEx quickbar;
    private final RelativeLayout rootView;
    public final TitleSecondaryBarShadowBinding searchBarShadow;
    public final FrameLayout searchOrOptionBar;
    public final TextView viewEmpty;
    public final OFloatingTitleBar viewTitle;
    public final RelativeLayout wholeView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AppLockListBinding(RelativeLayout r1, SearchBarSmt r2, SlideListView r3, QuickBarEx r4, TitleSecondaryBarShadowBinding r5, FrameLayout r6, TextView r7, OFloatingTitleBar r8, RelativeLayout r9) {
        this.rootView = r1;
        this.applockSearchBar = r2;
        this.listView = r3;
        this.quickbar = r4;
        this.searchBarShadow = r5;
        this.searchOrOptionBar = r6;
        this.viewEmpty = r7;
        this.viewTitle = r8;
        this.wholeView = r9;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AppLockListBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AppLockListBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.app_lock_list, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AppLockListBinding bind(View r12) {
        int r0 = R.id.applock_search_bar;
        SearchBarSmt r4 = (SearchBarSmt) ViewBindings.findChildViewById(r12, R.id.applock_search_bar);
        if (r4 == null) goto L19;
        r0 = R.id.listView;
        SlideListView r5 = (SlideListView) ViewBindings.findChildViewById(r12, R.id.listView);
        if (r5 == null) goto L19;
        r0 = R.id.quickbar;
        QuickBarEx r6 = (QuickBarEx) ViewBindings.findChildViewById(r12, R.id.quickbar);
        if (r6 == null) goto L19;
        r0 = R.id.search_bar_shadow;
        View r1 = ViewBindings.findChildViewById(r12, R.id.search_bar_shadow);
        if (r1 == null) goto L19;
        TitleSecondaryBarShadowBinding r7 = TitleSecondaryBarShadowBinding.bind(r1);
        r0 = R.id.search_or_option_bar;
        FrameLayout r8 = (FrameLayout) ViewBindings.findChildViewById(r12, R.id.search_or_option_bar);
        if (r8 == null) goto L19;
        r0 = R.id.view_empty;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r12, R.id.view_empty);
        if (r9 == null) goto L19;
        r0 = R.id.view_title;
        OFloatingTitleBar r10 = (OFloatingTitleBar) ViewBindings.findChildViewById(r12, R.id.view_title);
        if (r10 == null) goto L19;
        RelativeLayout r11 = (RelativeLayout) r12;
        return new AppLockListBinding(r11, r4, r5, r6, r7, r8, r9, r10, r11);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r0)));
    }
}
