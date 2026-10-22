package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class BluetoothPinConfirmPasskeyBinding implements ViewBinding {
    public final TextView message1;
    public final TextView message2;
    public final TextView message3;
    public final TextView message4;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private BluetoothPinConfirmPasskeyBinding(LinearLayout r1, TextView r2, TextView r3, TextView r4, TextView r5) {
        this.rootView = r1;
        this.message1 = r2;
        this.message2 = r3;
        this.message3 = r4;
        this.message4 = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BluetoothPinConfirmPasskeyBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static BluetoothPinConfirmPasskeyBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.bluetooth_pin_confirm_passkey, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static BluetoothPinConfirmPasskeyBinding bind(View r8) {
        int r0 = R.id.message1;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r8, R.id.message1);
        if (r4 == null) goto L13;
        r0 = R.id.message2;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r8, R.id.message2);
        if (r5 == null) goto L13;
        r0 = R.id.message3;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r8, R.id.message3);
        if (r6 == null) goto L13;
        r0 = R.id.message4;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r8, R.id.message4);
        if (r7 == null) goto L13;
        return new BluetoothPinConfirmPasskeyBinding((LinearLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
