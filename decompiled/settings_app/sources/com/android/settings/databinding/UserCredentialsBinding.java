package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OListView;

/* JADX INFO: loaded from: classes2.dex */
public final class UserCredentialsBinding implements ViewBinding {
    public final OListView credentialList;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private UserCredentialsBinding(LinearLayout r1, OListView r2) {
        this.rootView = r1;
        this.credentialList = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static UserCredentialsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static UserCredentialsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.user_credentials, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static UserCredentialsBinding bind(View r2) {
        OListView r1 = (OListView) ViewBindings.findChildViewById(r2, R.id.credential_list);
        if (r1 == null) goto L7;
        return new UserCredentialsBinding((LinearLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.credential_list)));
    }
}
