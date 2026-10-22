package com.obric.matrix.account.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.obric.matrix.account.g;
import com.obric.matrix.account.h;

/* JADX INFO: loaded from: classes2.dex */
public final class AccountPhonePageBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f8462a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Button f8463b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayout f8464c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f8465d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final ImageView f8466e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final EditText f8467f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f8468g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f8469h;

    private AccountPhonePageBinding(@NonNull LinearLayout r1, @NonNull Button r2, @NonNull LinearLayout r3, @NonNull TextView r4, @NonNull ImageView r5, @NonNull LinearLayout r6, @NonNull EditText r7, @NonNull TextView r8, @NonNull TextView r9) {
        this.f8462a = r1;
        this.f8463b = r2;
        this.f8464c = r3;
        this.f8465d = r4;
        this.f8466e = r5;
        this.f8467f = r7;
        this.f8468g = r8;
        this.f8469h = r9;
    }

    @NonNull
    public static AccountPhonePageBinding a(@NonNull View r12) {
        int r0 = g.f8479f;
        Button r4 = (Button) r12.findViewById(r0);
        if (r4 == null) goto L21;
        r0 = g.f8481h;
        LinearLayout r5 = (LinearLayout) r12.findViewById(r0);
        if (r5 == null) goto L21;
        r0 = g.f8483j;
        TextView r6 = (TextView) r12.findViewById(r0);
        if (r6 == null) goto L21;
        r0 = g.s;
        ImageView r7 = (ImageView) r12.findViewById(r0);
        if (r7 == null) goto L21;
        r0 = g.t;
        LinearLayout r8 = (LinearLayout) r12.findViewById(r0);
        if (r8 == null) goto L21;
        r0 = g.u;
        EditText r9 = (EditText) r12.findViewById(r0);
        if (r9 == null) goto L21;
        r0 = g.v;
        TextView r10 = (TextView) r12.findViewById(r0);
        if (r10 == null) goto L21;
        r0 = g.w;
        TextView r11 = (TextView) r12.findViewById(r0);
        if (r11 == null) goto L21;
        return new AccountPhonePageBinding((LinearLayout) r12, r4, r5, r6, r7, r8, r9, r10, r11);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r0)));
    }

    @NonNull
    public static AccountPhonePageBinding c(@NonNull LayoutInflater r2, @Nullable ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(h.f8492g, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return a(r5);
    }

    @NonNull
    public LinearLayout b() {
        return this.f8462a;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
