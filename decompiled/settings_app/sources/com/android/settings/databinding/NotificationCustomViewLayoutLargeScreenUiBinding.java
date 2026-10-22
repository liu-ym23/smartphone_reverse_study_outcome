package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.GridViewForScrollView;
import com.obric.oui.bouncelayout.OScrollView;
import obric.widget.ListContentItemCustom;

/* JADX INFO: loaded from: classes2.dex */
public final class NotificationCustomViewLayoutLargeScreenUiBinding implements ViewBinding {
    public final GridViewForScrollView candidateContainer;
    public final View itemBottomShadowView;
    private final OScrollView rootView;
    public final ListContentItemCustom widgetContainer;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private NotificationCustomViewLayoutLargeScreenUiBinding(OScrollView r1, GridViewForScrollView r2, View r3, ListContentItemCustom r4) {
        this.rootView = r1;
        this.candidateContainer = r2;
        this.itemBottomShadowView = r3;
        this.widgetContainer = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public OScrollView getRoot() {
        return this.rootView;
    }

    public static NotificationCustomViewLayoutLargeScreenUiBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static NotificationCustomViewLayoutLargeScreenUiBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.notification_custom_view_layout_large_screen_ui, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static NotificationCustomViewLayoutLargeScreenUiBinding bind(View r4) {
        int r0 = R.id.candidate_container;
        GridViewForScrollView r1 = (GridViewForScrollView) ViewBindings.findChildViewById(r4, R.id.candidate_container);
        if (r1 == null) goto L11;
        r0 = R.id.item_bottom_shadow_view;
        View r2 = ViewBindings.findChildViewById(r4, R.id.item_bottom_shadow_view);
        if (r2 == null) goto L11;
        r0 = R.id.widget_container;
        ListContentItemCustom r3 = (ListContentItemCustom) ViewBindings.findChildViewById(r4, R.id.widget_container);
        if (r3 == null) goto L11;
        return new NotificationCustomViewLayoutLargeScreenUiBinding((OScrollView) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
