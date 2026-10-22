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
public final class UserCredentialBinding implements ViewBinding {
    public final TextView alias;
    public final TextView contentsCacrt;
    public final TextView contentsUsercrt;
    public final TextView contentsUserkey;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private UserCredentialBinding(LinearLayout r1, TextView r2, TextView r3, TextView r4, TextView r5) {
        this.rootView = r1;
        this.alias = r2;
        this.contentsCacrt = r3;
        this.contentsUsercrt = r4;
        this.contentsUserkey = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static UserCredentialBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static UserCredentialBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.user_credential, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static UserCredentialBinding bind(View r8) {
        int r0 = R.id.alias;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r8, R.id.alias);
        if (r4 == null) goto L13;
        r0 = R.id.contents_cacrt;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r8, R.id.contents_cacrt);
        if (r5 == null) goto L13;
        r0 = R.id.contents_usercrt;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r8, R.id.contents_usercrt);
        if (r6 == null) goto L13;
        r0 = R.id.contents_userkey;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r8, R.id.contents_userkey);
        if (r7 == null) goto L13;
        return new UserCredentialBinding((LinearLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
