package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.viewbinding.ViewBinding;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class CryptKeeperEmergencyButtonBinding implements ViewBinding {
    public final Button emergencyCallButton;
    private final Button rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private CryptKeeperEmergencyButtonBinding(Button r1, Button r2) {
        this.rootView = r1;
        this.emergencyCallButton = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public Button getRoot() {
        return this.rootView;
    }

    public static CryptKeeperEmergencyButtonBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static CryptKeeperEmergencyButtonBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.crypt_keeper_emergency_button, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static CryptKeeperEmergencyButtonBinding bind(View r1) {
        if (r1 == null) goto L6;
        Button r2 = (Button) r1;
        return new CryptKeeperEmergencyButtonBinding(r2, r2);
    L6:
        throw new NullPointerException("rootView");
    }
}
