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
public final class AppAuthenticationUriItemBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView uriName;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AppAuthenticationUriItemBinding(LinearLayout r1, TextView r2) {
        this.rootView = r1;
        this.uriName = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AppAuthenticationUriItemBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AppAuthenticationUriItemBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.app_authentication_uri_item, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AppAuthenticationUriItemBinding bind(View r2) {
        TextView r1 = (TextView) ViewBindings.findChildViewById(r2, R.id.uri_name);
        if (r1 == null) goto L7;
        return new AppAuthenticationUriItemBinding((LinearLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.uri_name)));
    }
}
