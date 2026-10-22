package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import obric.widget.ListContentItemCustom;

/* JADX INFO: loaded from: classes2.dex */
public final class NotificationCustomViewLayoutNewSystemUiDeltaBinding implements ViewBinding {
    public final GridView candidateContainer;
    private final RelativeLayout rootView;
    public final TextView tips;
    public final ListContentItemCustom widgetContainer;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private NotificationCustomViewLayoutNewSystemUiDeltaBinding(RelativeLayout r1, GridView r2, TextView r3, ListContentItemCustom r4) {
        this.rootView = r1;
        this.candidateContainer = r2;
        this.tips = r3;
        this.widgetContainer = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static NotificationCustomViewLayoutNewSystemUiDeltaBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static NotificationCustomViewLayoutNewSystemUiDeltaBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.notification_custom_view_layout_new_system_ui_delta, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static NotificationCustomViewLayoutNewSystemUiDeltaBinding bind(View r4) {
        int r0 = R.id.candidate_container;
        GridView r1 = (GridView) ViewBindings.findChildViewById(r4, R.id.candidate_container);
        if (r1 == null) goto L11;
        r0 = R.id.tips;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r4, R.id.tips);
        if (r2 == null) goto L11;
        r0 = R.id.widget_container;
        ListContentItemCustom r3 = (ListContentItemCustom) ViewBindings.findChildViewById(r4, R.id.widget_container);
        if (r3 == null) goto L11;
        return new NotificationCustomViewLayoutNewSystemUiDeltaBinding((RelativeLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
