package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class NotificationAppBinding implements ViewBinding {
    public final ImageView icon;
    private final RelativeLayout rootView;
    public final View rowDivider;
    public final TextView text1;
    public final TextView title;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private NotificationAppBinding(RelativeLayout r1, ImageView r2, View r3, TextView r4, TextView r5) {
        this.rootView = r1;
        this.icon = r2;
        this.rowDivider = r3;
        this.text1 = r4;
        this.title = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static NotificationAppBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static NotificationAppBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.notification_app, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static NotificationAppBinding bind(View r8) {
        int r0 = android.R.id.icon;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r8, android.R.id.icon);
        if (r4 == null) goto L13;
        r0 = R.id.row_divider;
        View r5 = ViewBindings.findChildViewById(r8, R.id.row_divider);
        if (r5 == null) goto L13;
        r0 = android.R.id.text1;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r8, android.R.id.text1);
        if (r6 == null) goto L13;
        r0 = android.R.id.title;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r8, android.R.id.title);
        if (r7 == null) goto L13;
        return new NotificationAppBinding((RelativeLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
