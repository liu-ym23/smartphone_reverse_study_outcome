package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class PasswordCoverBinding implements ViewBinding {
    public final ImageView easyPasswordNo1;
    public final ImageView easyPasswordNo2;
    public final ImageView easyPasswordNo3;
    public final ImageView easyPasswordNo4;
    public final ImageView easyPasswordNo5;
    public final ImageView easyPasswordNo6;
    public final LinearLayout passwordContainer;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PasswordCoverBinding(LinearLayout r1, ImageView r2, ImageView r3, ImageView r4, ImageView r5, ImageView r6, ImageView r7, LinearLayout r8) {
        this.rootView = r1;
        this.easyPasswordNo1 = r2;
        this.easyPasswordNo2 = r3;
        this.easyPasswordNo3 = r4;
        this.easyPasswordNo4 = r5;
        this.easyPasswordNo5 = r6;
        this.easyPasswordNo6 = r7;
        this.passwordContainer = r8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PasswordCoverBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PasswordCoverBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.password_cover, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PasswordCoverBinding bind(View r11) {
        int r0 = R.id.easy_password_no_1;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r11, R.id.easy_password_no_1);
        if (r4 == null) goto L17;
        r0 = R.id.easy_password_no_2;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r11, R.id.easy_password_no_2);
        if (r5 == null) goto L17;
        r0 = R.id.easy_password_no_3;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r11, R.id.easy_password_no_3);
        if (r6 == null) goto L17;
        r0 = R.id.easy_password_no_4;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r11, R.id.easy_password_no_4);
        if (r7 == null) goto L17;
        r0 = R.id.easy_password_no_5;
        ImageView r8 = (ImageView) ViewBindings.findChildViewById(r11, R.id.easy_password_no_5);
        if (r8 == null) goto L17;
        r0 = R.id.easy_password_no_6;
        ImageView r9 = (ImageView) ViewBindings.findChildViewById(r11, R.id.easy_password_no_6);
        if (r9 == null) goto L17;
        LinearLayout r10 = (LinearLayout) r11;
        return new PasswordCoverBinding(r10, r4, r5, r6, r7, r8, r9, r10);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }
}
