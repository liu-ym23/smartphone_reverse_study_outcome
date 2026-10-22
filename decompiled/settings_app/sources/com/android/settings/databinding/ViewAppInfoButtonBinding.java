package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.layout.OUILinearLayoutDisableChildren;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes2.dex */
public final class ViewAppInfoButtonBinding implements ViewBinding {
    public final OUILinearLayoutDisableChildren forceStopApp;
    public final OUILinearLayoutDisableChildren launchApp;
    private final RelativeLayout rootView;
    public final OUILinearLayoutDisableChildren uninstallApp;
    public final OTextView uninstallAppText;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ViewAppInfoButtonBinding(RelativeLayout r1, OUILinearLayoutDisableChildren r2, OUILinearLayoutDisableChildren r3, OUILinearLayoutDisableChildren r4, OTextView r5) {
        this.rootView = r1;
        this.forceStopApp = r2;
        this.launchApp = r3;
        this.uninstallApp = r4;
        this.uninstallAppText = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ViewAppInfoButtonBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ViewAppInfoButtonBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.view_app_info_button, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ViewAppInfoButtonBinding bind(View r8) {
        int r0 = R.id.force_stop_app;
        OUILinearLayoutDisableChildren r4 = (OUILinearLayoutDisableChildren) ViewBindings.findChildViewById(r8, R.id.force_stop_app);
        if (r4 == null) goto L13;
        r0 = R.id.launch_app;
        OUILinearLayoutDisableChildren r5 = (OUILinearLayoutDisableChildren) ViewBindings.findChildViewById(r8, R.id.launch_app);
        if (r5 == null) goto L13;
        r0 = R.id.uninstall_app;
        OUILinearLayoutDisableChildren r6 = (OUILinearLayoutDisableChildren) ViewBindings.findChildViewById(r8, R.id.uninstall_app);
        if (r6 == null) goto L13;
        r0 = R.id.uninstall_app_text;
        OTextView r7 = (OTextView) ViewBindings.findChildViewById(r8, R.id.uninstall_app_text);
        if (r7 == null) goto L13;
        return new ViewAppInfoButtonBinding((RelativeLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
