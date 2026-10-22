package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OListView;
import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.searchbar.v2.OSearchBar;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class SettingsSearchLayoutBinding implements ViewBinding {
    public final RelativeLayout historyLayout;
    public final OSearchBar idSearchBar;
    private final RelativeLayout rootView;
    public final OIconButtonFloating searchCancelButton;
    public final OListView searchHistoryView;
    public final OFloatingTitleBar viewTitle1;
    public final RelativeLayout wholeView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SettingsSearchLayoutBinding(RelativeLayout r1, RelativeLayout r2, OSearchBar r3, OIconButtonFloating r4, OListView r5, OFloatingTitleBar r6, RelativeLayout r7) {
        this.rootView = r1;
        this.historyLayout = r2;
        this.idSearchBar = r3;
        this.searchCancelButton = r4;
        this.searchHistoryView = r5;
        this.viewTitle1 = r6;
        this.wholeView = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SettingsSearchLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SettingsSearchLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.settings_search_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SettingsSearchLayoutBinding bind(View r10) {
        int r0 = R.id.history_layout;
        RelativeLayout r4 = (RelativeLayout) ViewBindings.findChildViewById(r10, R.id.history_layout);
        if (r4 == null) goto L15;
        r0 = R.id.id_search_bar;
        OSearchBar r5 = (OSearchBar) ViewBindings.findChildViewById(r10, R.id.id_search_bar);
        if (r5 == null) goto L15;
        r0 = R.id.search_cancel_button;
        OIconButtonFloating r6 = (OIconButtonFloating) ViewBindings.findChildViewById(r10, R.id.search_cancel_button);
        if (r6 == null) goto L15;
        r0 = R.id.search_history_view;
        OListView r7 = (OListView) ViewBindings.findChildViewById(r10, R.id.search_history_view);
        if (r7 == null) goto L15;
        r0 = R.id.view_title1;
        OFloatingTitleBar r8 = (OFloatingTitleBar) ViewBindings.findChildViewById(r10, R.id.view_title1);
        if (r8 == null) goto L15;
        RelativeLayout r9 = (RelativeLayout) r10;
        return new SettingsSearchLayoutBinding(r9, r4, r5, r6, r7, r8, r9);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
