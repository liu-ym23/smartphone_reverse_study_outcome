package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settingslib.widget.AnimatedImageView;

/* JADX INFO: loaded from: classes2.dex */
public final class PreferenceWidgetSyncToggleBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final Switch switchWidget;
    public final AnimatedImageView syncActive;
    public final ImageView syncFailed;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PreferenceWidgetSyncToggleBinding(LinearLayout r1, Switch r2, AnimatedImageView r3, ImageView r4) {
        this.rootView = r1;
        this.switchWidget = r2;
        this.syncActive = r3;
        this.syncFailed = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PreferenceWidgetSyncToggleBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PreferenceWidgetSyncToggleBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.preference_widget_sync_toggle, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PreferenceWidgetSyncToggleBinding bind(View r4) {
        int r0 = android.R.id.switch_widget;
        Switch r1 = (Switch) ViewBindings.findChildViewById(r4, android.R.id.switch_widget);
        if (r1 == null) goto L11;
        r0 = R.id.sync_active;
        AnimatedImageView r2 = (AnimatedImageView) ViewBindings.findChildViewById(r4, R.id.sync_active);
        if (r2 == null) goto L11;
        r0 = R.id.sync_failed;
        ImageView r3 = (ImageView) ViewBindings.findChildViewById(r4, R.id.sync_failed);
        if (r3 == null) goto L11;
        return new PreferenceWidgetSyncToggleBinding((LinearLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
