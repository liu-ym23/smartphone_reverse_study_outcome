package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class UsbModePickerItemBinding implements ViewBinding {
    public final RadioButton radio;
    private final LinearLayout rootView;
    public final TextView summary;
    public final TextView title;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private UsbModePickerItemBinding(LinearLayout r1, RadioButton r2, TextView r3, TextView r4) {
        this.rootView = r1;
        this.radio = r2;
        this.summary = r3;
        this.title = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static UsbModePickerItemBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static UsbModePickerItemBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.usb_mode_picker_item, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static UsbModePickerItemBinding bind(View r4) {
        int r0 = R.id.radio;
        RadioButton r1 = (RadioButton) ViewBindings.findChildViewById(r4, R.id.radio);
        if (r1 == null) goto L11;
        r0 = R.id.summary;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r4, R.id.summary);
        if (r2 == null) goto L11;
        r0 = R.id.title;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r4, R.id.title);
        if (r3 == null) goto L11;
        return new UsbModePickerItemBinding((LinearLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
