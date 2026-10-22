package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import obric.widget.ListContentItemCustom;

/* JADX INFO: loaded from: classes2.dex */
public final class NotificationCustomViewLayoutNewSystemUiBinding implements ViewBinding {
    public final GridView candidateContainer;
    private final RelativeLayout rootView;
    public final ListContentItemCustom widgetContainer;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private NotificationCustomViewLayoutNewSystemUiBinding(RelativeLayout r1, GridView r2, ListContentItemCustom r3) {
        this.rootView = r1;
        this.candidateContainer = r2;
        this.widgetContainer = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static NotificationCustomViewLayoutNewSystemUiBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static NotificationCustomViewLayoutNewSystemUiBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.notification_custom_view_layout_new_system_ui, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static NotificationCustomViewLayoutNewSystemUiBinding bind(View r3) {
        int r0 = R.id.candidate_container;
        GridView r1 = (GridView) ViewBindings.findChildViewById(r3, R.id.candidate_container);
        if (r1 == null) goto L9;
        r0 = R.id.widget_container;
        ListContentItemCustom r2 = (ListContentItemCustom) ViewBindings.findChildViewById(r3, R.id.widget_container);
        if (r2 == null) goto L9;
        return new NotificationCustomViewLayoutNewSystemUiBinding((RelativeLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
