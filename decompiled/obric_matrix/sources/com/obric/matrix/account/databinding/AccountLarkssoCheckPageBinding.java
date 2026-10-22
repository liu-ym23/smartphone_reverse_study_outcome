package com.obric.matrix.account.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.obric.matrix.account.g;
import com.obric.matrix.account.h;
import com.obric.matrix.common_ui.widget.UrlSpanTextView;

/* JADX INFO: loaded from: classes2.dex */
public final class AccountLarkssoCheckPageBinding implements ViewBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    private final LinearLayout f8456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f8457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f8458c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final UrlSpanTextView f8459d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NonNull
    public final CheckBox f8460e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final LinearLayout f8461f;

    private AccountLarkssoCheckPageBinding(@NonNull LinearLayout r1, @NonNull TextView r2, @NonNull TextView r3, @NonNull TextView r4, @NonNull ImageView r5, @NonNull Space r6, @NonNull UrlSpanTextView r7, @NonNull Space r8, @NonNull CheckBox r9, @NonNull LinearLayout r10) {
        this.f8456a = r1;
        this.f8457b = r2;
        this.f8458c = r5;
        this.f8459d = r7;
        this.f8460e = r9;
        this.f8461f = r10;
    }

    @NonNull
    public static AccountLarkssoCheckPageBinding a(@NonNull View r13) {
        int r0 = g.f8475b;
        TextView r4 = (TextView) r13.findViewById(r0);
        if (r4 == null) goto L23;
        r0 = g.f8476c;
        TextView r5 = (TextView) r13.findViewById(r0);
        if (r5 == null) goto L23;
        r0 = g.f8477d;
        TextView r6 = (TextView) r13.findViewById(r0);
        if (r6 == null) goto L23;
        r0 = g.f8478e;
        ImageView r7 = (ImageView) r13.findViewById(r0);
        if (r7 == null) goto L23;
        r0 = g.q;
        Space r8 = (Space) r13.findViewById(r0);
        if (r8 == null) goto L23;
        r0 = g.x;
        UrlSpanTextView r9 = (UrlSpanTextView) r13.findViewById(r0);
        if (r9 == null) goto L23;
        r0 = g.y;
        Space r10 = (Space) r13.findViewById(r0);
        if (r10 == null) goto L23;
        r0 = g.A;
        CheckBox r11 = (CheckBox) r13.findViewById(r0);
        if (r11 == null) goto L23;
        r0 = g.B;
        LinearLayout r12 = (LinearLayout) r13.findViewById(r0);
        if (r12 == null) goto L23;
        return new AccountLarkssoCheckPageBinding((LinearLayout) r13, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r0)));
    }

    @NonNull
    public static AccountLarkssoCheckPageBinding c(@NonNull LayoutInflater r2, @Nullable ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(h.f8491f, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return a(r5);
    }

    @NonNull
    public LinearLayout b() {
        return this.f8456a;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public /* bridge */ /* synthetic */ View getRoot() {
        return b();
    }
}
