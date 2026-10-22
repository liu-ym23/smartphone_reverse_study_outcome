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
public final class BluetoothAccessNewBinding implements ViewBinding {
    public final TextView message;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private BluetoothAccessNewBinding(LinearLayout r1, TextView r2) {
        this.rootView = r1;
        this.message = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BluetoothAccessNewBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static BluetoothAccessNewBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.bluetooth_access_new, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static BluetoothAccessNewBinding bind(View r2) {
        TextView r1 = (TextView) ViewBindings.findChildViewById(r2, R.id.message);
        if (r1 == null) goto L7;
        return new BluetoothAccessNewBinding((LinearLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.message)));
    }
}
