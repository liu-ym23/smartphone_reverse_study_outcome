package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.internal.widget.KeyguardLockPatternView;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class CryptKeeperPatternFieldBinding implements ViewBinding {
    public final KeyguardLockPatternView lockPattern;
    private final View rootView;

    private CryptKeeperPatternFieldBinding(View r1, KeyguardLockPatternView r2) {
        this.rootView = r1;
        this.lockPattern = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static CryptKeeperPatternFieldBinding inflate(LayoutInflater r1, ViewGroup r2) {
        if (r2 == null) goto L6;
        r1.inflate(R.layout.crypt_keeper_pattern_field, r2);
        return bind(r2);
    L6:
        throw new NullPointerException("parent");
    }

    public static CryptKeeperPatternFieldBinding bind(View r2) {
        KeyguardLockPatternView r1 = (KeyguardLockPatternView) ViewBindings.findChildViewById(r2, R.id.lockPattern);
        if (r1 == null) goto L7;
        return new CryptKeeperPatternFieldBinding(r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.lockPattern)));
    }
}
