package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.oswitch.OSwitch;

/* JADX INFO: loaded from: classes2.dex */
public final class LayoutInputSwitchCardBinding implements ViewBinding {
    public final OSwitch customEndSwitch;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private LayoutInputSwitchCardBinding(LinearLayout r1, OSwitch r2) {
        this.rootView = r1;
        this.customEndSwitch = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutInputSwitchCardBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static LayoutInputSwitchCardBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.layout_input_switch_card, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static LayoutInputSwitchCardBinding bind(View r2) {
        OSwitch r1 = (OSwitch) ViewBindings.findChildViewById(r2, R.id.custom_end_switch);
        if (r1 == null) goto L7;
        return new LayoutInputSwitchCardBinding((LinearLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.custom_end_switch)));
    }
}
