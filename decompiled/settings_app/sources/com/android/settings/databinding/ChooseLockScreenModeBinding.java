package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OListItemSettings;

/* JADX INFO: loaded from: classes2.dex */
public final class ChooseLockScreenModeBinding implements ViewBinding {
    public final OListItemSettings fourPin;
    public final LinearLayout pageContainer;
    public final OListItemSettings password;
    public final OListItemSettings pattern;
    private final RelativeLayout rootView;
    public final OListItemSettings sixPin;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ChooseLockScreenModeBinding(RelativeLayout r1, OListItemSettings r2, LinearLayout r3, OListItemSettings r4, OListItemSettings r5, OListItemSettings r6) {
        this.rootView = r1;
        this.fourPin = r2;
        this.pageContainer = r3;
        this.password = r4;
        this.pattern = r5;
        this.sixPin = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ChooseLockScreenModeBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ChooseLockScreenModeBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.choose_lock_screen_mode, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ChooseLockScreenModeBinding bind(View r9) {
        int r0 = R.id.four_pin;
        OListItemSettings r4 = (OListItemSettings) ViewBindings.findChildViewById(r9, R.id.four_pin);
        if (r4 == null) goto L15;
        r0 = R.id.page_container;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r9, R.id.page_container);
        if (r5 == null) goto L15;
        r0 = R.id.password;
        OListItemSettings r6 = (OListItemSettings) ViewBindings.findChildViewById(r9, R.id.password);
        if (r6 == null) goto L15;
        r0 = R.id.pattern;
        OListItemSettings r7 = (OListItemSettings) ViewBindings.findChildViewById(r9, R.id.pattern);
        if (r7 == null) goto L15;
        r0 = R.id.six_pin;
        OListItemSettings r8 = (OListItemSettings) ViewBindings.findChildViewById(r9, R.id.six_pin);
        if (r8 == null) goto L15;
        return new ChooseLockScreenModeBinding((RelativeLayout) r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
