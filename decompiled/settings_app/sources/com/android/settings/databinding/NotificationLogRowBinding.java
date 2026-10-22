package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DateTimeView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class NotificationLogRowBinding implements ViewBinding {
    public final TextView extra;
    public final ImageView icon;
    public final ImageView pkgicon;
    public final TextView pkgname;
    private final LinearLayout rootView;
    public final DateTimeView timestamp;
    public final TextView title;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private NotificationLogRowBinding(LinearLayout r1, TextView r2, ImageView r3, ImageView r4, TextView r5, DateTimeView r6, TextView r7) {
        this.rootView = r1;
        this.extra = r2;
        this.icon = r3;
        this.pkgicon = r4;
        this.pkgname = r5;
        this.timestamp = r6;
        this.title = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static NotificationLogRowBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static NotificationLogRowBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.notification_log_row, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static NotificationLogRowBinding bind(View r10) {
        int r0 = R.id.extra;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r10, R.id.extra);
        if (r4 == null) goto L17;
        r0 = R.id.icon;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r10, R.id.icon);
        if (r5 == null) goto L17;
        r0 = R.id.pkgicon;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r10, R.id.pkgicon);
        if (r6 == null) goto L17;
        r0 = R.id.pkgname;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r10, R.id.pkgname);
        if (r7 == null) goto L17;
        r0 = R.id.timestamp;
        DateTimeView r8 = ViewBindings.findChildViewById(r10, R.id.timestamp);
        if (r8 == null) goto L17;
        r0 = R.id.title;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r10, R.id.title);
        if (r9 == null) goto L17;
        return new NotificationLogRowBinding((LinearLayout) r10, r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
