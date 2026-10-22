package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.android.settings.R;
import com.obric.oui.dropdown.ODropdownTrigger;

/* JADX INFO: loaded from: classes2.dex */
public final class SimpleSpinnerDropdownTriggerBinding implements ViewBinding {
    public final ODropdownTrigger dropdownTrigger;
    private final ODropdownTrigger rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SimpleSpinnerDropdownTriggerBinding(ODropdownTrigger r1, ODropdownTrigger r2) {
        this.rootView = r1;
        this.dropdownTrigger = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ODropdownTrigger getRoot() {
        return this.rootView;
    }

    public static SimpleSpinnerDropdownTriggerBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SimpleSpinnerDropdownTriggerBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.simple_spinner_dropdown_trigger, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SimpleSpinnerDropdownTriggerBinding bind(View r1) {
        if (r1 == null) goto L6;
        ODropdownTrigger r2 = (ODropdownTrigger) r1;
        return new SimpleSpinnerDropdownTriggerBinding(r2, r2);
    L6:
        throw new NullPointerException("rootView");
    }
}
