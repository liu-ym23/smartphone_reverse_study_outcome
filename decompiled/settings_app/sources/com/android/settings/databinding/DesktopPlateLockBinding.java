package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.ListContentItemCheck;

/* JADX INFO: loaded from: classes2.dex */
public final class DesktopPlateLockBinding implements ViewBinding {
    public final LinearLayout applicationsLockLayout;
    public final ListContentItemCheck itemDesktopPlateLock;
    public final TextView plateLockContent;
    public final ImageView plateLockGuide;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DesktopPlateLockBinding(RelativeLayout r1, LinearLayout r2, ListContentItemCheck r3, TextView r4, ImageView r5, OFloatingTitleBar r6) {
        this.rootView = r1;
        this.applicationsLockLayout = r2;
        this.itemDesktopPlateLock = r3;
        this.plateLockContent = r4;
        this.plateLockGuide = r5;
        this.viewTitle = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DesktopPlateLockBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DesktopPlateLockBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.desktop_plate_lock, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DesktopPlateLockBinding bind(View r9) {
        int r0 = R.id.applications_lock_layout;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r9, R.id.applications_lock_layout);
        if (r4 == null) goto L15;
        r0 = R.id.item_desktop_plate_lock;
        ListContentItemCheck r5 = (ListContentItemCheck) ViewBindings.findChildViewById(r9, R.id.item_desktop_plate_lock);
        if (r5 == null) goto L15;
        r0 = R.id.plate_lock_content;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r9, R.id.plate_lock_content);
        if (r6 == null) goto L15;
        r0 = R.id.plate_lock_guide;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r9, R.id.plate_lock_guide);
        if (r7 == null) goto L15;
        r0 = R.id.view_title;
        OFloatingTitleBar r8 = (OFloatingTitleBar) ViewBindings.findChildViewById(r9, R.id.view_title);
        if (r8 == null) goto L15;
        return new DesktopPlateLockBinding((RelativeLayout) r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
