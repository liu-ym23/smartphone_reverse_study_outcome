package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class CryptKeeperPinFieldBinding implements ViewBinding {
    public final EditText passwordEntry;
    private final View rootView;

    private CryptKeeperPinFieldBinding(View r1, EditText r2) {
        this.rootView = r1;
        this.passwordEntry = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static CryptKeeperPinFieldBinding inflate(LayoutInflater r1, ViewGroup r2) {
        if (r2 == null) goto L6;
        r1.inflate(R.layout.crypt_keeper_pin_field, r2);
        return bind(r2);
    L6:
        throw new NullPointerException("parent");
    }

    public static CryptKeeperPinFieldBinding bind(View r2) {
        EditText r1 = (EditText) ViewBindings.findChildViewById(r2, R.id.passwordEntry);
        if (r1 == null) goto L7;
        return new CryptKeeperPinFieldBinding(r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.passwordEntry)));
    }
}
