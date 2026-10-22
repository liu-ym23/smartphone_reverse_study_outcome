package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;

/* JADX INFO: loaded from: classes2.dex */
public final class AppPreferredSettingsBinding implements ViewBinding {
    public final TextView autoLaunch;
    public final Button clearActivitiesButton;
    private final OScrollView rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AppPreferredSettingsBinding(OScrollView r1, TextView r2, Button r3) {
        this.rootView = r1;
        this.autoLaunch = r2;
        this.clearActivitiesButton = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public OScrollView getRoot() {
        return this.rootView;
    }

    public static AppPreferredSettingsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AppPreferredSettingsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.app_preferred_settings, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AppPreferredSettingsBinding bind(View r3) {
        int r0 = R.id.auto_launch;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r3, R.id.auto_launch);
        if (r1 == null) goto L9;
        r0 = R.id.clear_activities_button;
        Button r2 = (Button) ViewBindings.findChildViewById(r3, R.id.clear_activities_button);
        if (r2 == null) goto L9;
        return new AppPreferredSettingsBinding((OScrollView) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
