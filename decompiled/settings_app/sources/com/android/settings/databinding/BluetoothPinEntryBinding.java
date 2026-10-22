package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.forms.OInputLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class BluetoothPinEntryBinding implements ViewBinding {
    public final TextView message;
    public final TextView pinValuesHint;
    private final LinearLayout rootView;
    public final OInputLayout text;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private BluetoothPinEntryBinding(LinearLayout r1, TextView r2, TextView r3, OInputLayout r4) {
        this.rootView = r1;
        this.message = r2;
        this.pinValuesHint = r3;
        this.text = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BluetoothPinEntryBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static BluetoothPinEntryBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.bluetooth_pin_entry, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static BluetoothPinEntryBinding bind(View r4) {
        int r0 = R.id.message;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r4, R.id.message);
        if (r1 == null) goto L11;
        r0 = R.id.pin_values_hint;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r4, R.id.pin_values_hint);
        if (r2 == null) goto L11;
        r0 = R.id.text;
        OInputLayout r3 = (OInputLayout) ViewBindings.findChildViewById(r4, R.id.text);
        if (r3 == null) goto L11;
        return new BluetoothPinEntryBinding((LinearLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
