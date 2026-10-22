package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class RevoneFragmentStylusAppSettingsBinding implements ViewBinding {
    public final RecyclerView optionsList;
    private final RelativeLayout rootView;
    public final OScrollView scrollView;
    public final TextView viewEmpty;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RevoneFragmentStylusAppSettingsBinding(RelativeLayout r1, RecyclerView r2, OScrollView r3, TextView r4, OFloatingTitleBar r5) {
        this.rootView = r1;
        this.optionsList = r2;
        this.scrollView = r3;
        this.viewEmpty = r4;
        this.viewTitle = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static RevoneFragmentStylusAppSettingsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static RevoneFragmentStylusAppSettingsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.revone_fragment_stylus_app_settings, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static RevoneFragmentStylusAppSettingsBinding bind(View r8) {
        int r0 = R.id.options_list;
        RecyclerView r4 = (RecyclerView) ViewBindings.findChildViewById(r8, R.id.options_list);
        if (r4 == null) goto L13;
        r0 = R.id.scroll_view;
        OScrollView r5 = (OScrollView) ViewBindings.findChildViewById(r8, R.id.scroll_view);
        if (r5 == null) goto L13;
        r0 = R.id.view_empty;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r8, R.id.view_empty);
        if (r6 == null) goto L13;
        r0 = R.id.view_title;
        OFloatingTitleBar r7 = (OFloatingTitleBar) ViewBindings.findChildViewById(r8, R.id.view_title);
        if (r7 == null) goto L13;
        return new RevoneFragmentStylusAppSettingsBinding((RelativeLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
