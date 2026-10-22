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
public final class ZenModeLayoutBinding implements ViewBinding {
    public final RelativeLayout historyLayout;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;
    public final OListView zenModeRule;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ZenModeLayoutBinding(RelativeLayout r1, RelativeLayout r2, OFloatingTitleBar r3, OListView r4) {
        this.rootView = r1;
        this.historyLayout = r2;
        this.viewTitle = r3;
        this.zenModeRule = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ZenModeLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ZenModeLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.zen_mode_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ZenModeLayoutBinding bind(View r4) {
        int r0 = R.id.history_layout;
        RelativeLayout r1 = (RelativeLayout) ViewBindings.findChildViewById(r4, R.id.history_layout);
        if (r1 == null) goto L11;
        r0 = R.id.view_title;
        OFloatingTitleBar r2 = (OFloatingTitleBar) ViewBindings.findChildViewById(r4, R.id.view_title);
        if (r2 == null) goto L11;
        r0 = R.id.zen_mode_rule;
        OListView r3 = (OListView) ViewBindings.findChildViewById(r4, R.id.zen_mode_rule);
        if (r3 == null) goto L11;
        return new ZenModeLayoutBinding((RelativeLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
