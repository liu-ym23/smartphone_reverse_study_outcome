package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import obric.widget.ListContentItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public final class NotificationAccessPreferenceLayoutBinding implements ViewBinding {
    public final View emptyView;
    private final LinearLayout rootView;
    public final ListContentItemSwitch switcher;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private NotificationAccessPreferenceLayoutBinding(LinearLayout r1, View r2, ListContentItemSwitch r3) {
        this.rootView = r1;
        this.emptyView = r2;
        this.switcher = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NotificationAccessPreferenceLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static NotificationAccessPreferenceLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.notification_access_preference_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static NotificationAccessPreferenceLayoutBinding bind(View r3) {
        int r0 = R.id.empty_view;
        View r1 = ViewBindings.findChildViewById(r3, R.id.empty_view);
        if (r1 == null) goto L9;
        r0 = R.id.switcher;
        ListContentItemSwitch r2 = (ListContentItemSwitch) ViewBindings.findChildViewById(r3, R.id.switcher);
        if (r2 == null) goto L9;
        return new NotificationAccessPreferenceLayoutBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
