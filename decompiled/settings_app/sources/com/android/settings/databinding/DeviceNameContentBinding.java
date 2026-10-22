package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.forms.OInputView;

/* JADX INFO: loaded from: classes2.dex */
public final class DeviceNameContentBinding implements ViewBinding {
    public final OInputView inputText;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DeviceNameContentBinding(LinearLayout r1, OInputView r2) {
        this.rootView = r1;
        this.inputText = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DeviceNameContentBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DeviceNameContentBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.device_name_content, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DeviceNameContentBinding bind(View r2) {
        OInputView r1 = (OInputView) ViewBindings.findChildViewById(r2, R.id.input_text);
        if (r1 == null) goto L7;
        return new DeviceNameContentBinding((LinearLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.input_text)));
    }
}
