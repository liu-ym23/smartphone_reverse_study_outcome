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
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class TrustAgentsLayoutBinding implements ViewBinding {
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private TrustAgentsLayoutBinding(RelativeLayout r1, LinearLayout r2, OScrollView r3, OFloatingTitleBar r4) {
        this.rootView = r1;
        this.pageContainer = r2;
        this.pageScrollview = r3;
        this.viewTitle = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static TrustAgentsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static TrustAgentsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.trust_agents_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static TrustAgentsLayoutBinding bind(View r4) {
        int r0 = R.id.page_container;
        LinearLayout r1 = (LinearLayout) ViewBindings.findChildViewById(r4, R.id.page_container);
        if (r1 == null) goto L11;
        r0 = R.id.page_scrollview;
        OScrollView r2 = (OScrollView) ViewBindings.findChildViewById(r4, R.id.page_scrollview);
        if (r2 == null) goto L11;
        r0 = R.id.view_title;
        OFloatingTitleBar r3 = (OFloatingTitleBar) ViewBindings.findChildViewById(r4, R.id.view_title);
        if (r3 == null) goto L11;
        return new TrustAgentsLayoutBinding((RelativeLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
