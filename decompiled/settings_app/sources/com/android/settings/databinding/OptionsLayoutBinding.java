package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OListView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class OptionsLayoutBinding implements ViewBinding {
    public final OListView optionsList;
    public final RelativeLayout rootView;
    private final RelativeLayout rootView_;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private OptionsLayoutBinding(RelativeLayout r1, OListView r2, RelativeLayout r3, OFloatingTitleBar r4) {
        this.rootView_ = r1;
        this.optionsList = r2;
        this.rootView = r3;
        this.viewTitle = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView_;
    }

    public static OptionsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static OptionsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.options_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static OptionsLayoutBinding bind(View r4) {
        int r0 = R.id.options_list;
        OListView r1 = (OListView) ViewBindings.findChildViewById(r4, R.id.options_list);
        if (r1 == null) goto L10;
        RelativeLayout r2 = (RelativeLayout) r4;
        OFloatingTitleBar r3 = (OFloatingTitleBar) ViewBindings.findChildViewById(r4, R.id.view_title);
        if (r3 != null) goto L7;
        r0 = R.id.view_title;
        goto L10
    L7:
        return new OptionsLayoutBinding(r2, r1, r2, r3);
    L10:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
