package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public final class UnlockMethodLayoutBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final SettingItemSwitch unlockByFace;
    public final SettingItemSwitch unlockByFingerprint;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private UnlockMethodLayoutBinding(RelativeLayout r1, SettingItemSwitch r2, SettingItemSwitch r3, OFloatingTitleBar r4) {
        this.rootView = r1;
        this.unlockByFace = r2;
        this.unlockByFingerprint = r3;
        this.viewTitle = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static UnlockMethodLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static UnlockMethodLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.unlock_method_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static UnlockMethodLayoutBinding bind(View r4) {
        int r0 = R.id.unlock_by_face;
        SettingItemSwitch r1 = (SettingItemSwitch) ViewBindings.findChildViewById(r4, R.id.unlock_by_face);
        if (r1 == null) goto L11;
        r0 = R.id.unlock_by_fingerprint;
        SettingItemSwitch r2 = (SettingItemSwitch) ViewBindings.findChildViewById(r4, R.id.unlock_by_fingerprint);
        if (r2 == null) goto L11;
        r0 = R.id.view_title;
        OFloatingTitleBar r3 = (OFloatingTitleBar) ViewBindings.findChildViewById(r4, R.id.view_title);
        if (r3 == null) goto L11;
        return new UnlockMethodLayoutBinding((RelativeLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
