package com.obric.matrix.account.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.obric.matrix.account.g;
import com.obric.matrix.account.h;

/* JADX INFO: loaded from: classes2.dex */
public final class AccountCountryListItemViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f8450a;

    private AccountCountryListItemViewBinding(@NonNull ConstraintLayout r1, @NonNull TextView r2, @NonNull TextView r3, @NonNull View r4) {
        this.f8450a = r1;
    }

    @NonNull
    public static AccountCountryListItemViewBinding a(@NonNull View r4) {
        int r0 = g.f8482i;
        TextView r1 = (TextView) r4.findViewById(r0);
        if (r1 == null) goto L11;
        r0 = g.f8484k;
        TextView r2 = (TextView) r4.findViewById(r0);
        if (r2 == null) goto L11;
        r0 = g.n;
        View r3 = r4.findViewById(r0);
        if (r3 == null) goto L11;
        return new AccountCountryListItemViewBinding((ConstraintLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }

    @NonNull
    public static AccountCountryListItemViewBinding c(@NonNull LayoutInflater r2, @Nullable ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(h.f8488c, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return a(r5);
    }

    @NonNull
    public ConstraintLayout b() {
        return this.f8450a;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
