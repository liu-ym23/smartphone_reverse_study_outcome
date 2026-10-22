package com.obric.matrix.account.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.obric.matrix.account.g;
import com.obric.matrix.account.h;
import com.obric.matrix.account.ui.CenterTextView;
import com.obric.matrix.account.ui.SideIndexBar;

/* JADX INFO: loaded from: classes2.dex */
public final class AccountCountryPickerPageBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final ConstraintLayout f8451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f8452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final RecyclerView f8453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final SideIndexBar f8454d;

    private AccountCountryPickerPageBinding(@NonNull ConstraintLayout r1, @NonNull CenterTextView r2, @NonNull ImageView r3, @NonNull TextView r4, @NonNull RecyclerView r5, @NonNull SideIndexBar r6) {
        this.f8451a = r1;
        this.f8452b = r3;
        this.f8453c = r5;
        this.f8454d = r6;
    }

    @NonNull
    public static AccountCountryPickerPageBinding a(@NonNull View r9) {
        int r0 = g.f8480g;
        CenterTextView r4 = (CenterTextView) r9.findViewById(r0);
        if (r4 == null) goto L15;
        r0 = g.f8485l;
        ImageView r5 = (ImageView) r9.findViewById(r0);
        if (r5 == null) goto L15;
        r0 = g.m;
        TextView r6 = (TextView) r9.findViewById(r0);
        if (r6 == null) goto L15;
        r0 = g.z;
        RecyclerView r7 = (RecyclerView) r9.findViewById(r0);
        if (r7 == null) goto L15;
        r0 = g.C;
        SideIndexBar r8 = (SideIndexBar) r9.findViewById(r0);
        if (r8 == null) goto L15;
        return new AccountCountryPickerPageBinding((ConstraintLayout) r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }

    @NonNull
    public static AccountCountryPickerPageBinding c(@NonNull LayoutInflater r2, @Nullable ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(h.f8489d, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return a(r5);
    }

    @NonNull
    public ConstraintLayout b() {
        return this.f8451a;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
