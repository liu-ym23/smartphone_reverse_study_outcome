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
public final class AccountCountryListHeadViewBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f8449a;

    private AccountCountryListHeadViewBinding(@NonNull ConstraintLayout r1, @NonNull View r2, @NonNull TextView r3) {
        this.f8449a = r1;
    }

    @NonNull
    public static AccountCountryListHeadViewBinding a(@NonNull View r3) {
        int r0 = g.n;
        View r1 = r3.findViewById(r0);
        if (r1 == null) goto L9;
        r0 = g.r;
        TextView r2 = (TextView) r3.findViewById(r0);
        if (r2 == null) goto L9;
        return new AccountCountryListHeadViewBinding((ConstraintLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }

    @NonNull
    public static AccountCountryListHeadViewBinding c(@NonNull LayoutInflater r2, @Nullable ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(h.f8487b, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return a(r5);
    }

    @NonNull
    public ConstraintLayout b() {
        return this.f8449a;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
