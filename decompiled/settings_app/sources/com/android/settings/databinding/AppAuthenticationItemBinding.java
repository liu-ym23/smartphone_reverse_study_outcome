package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class AppAuthenticationItemBinding implements ViewBinding {
    public final RelativeLayout appDetails;
    public final ImageView appIcon;
    public final TextView appName;
    public final ImageView expand;
    public final TextView numberOfUris;
    private final RelativeLayout rootView;
    public final RecyclerView uris;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AppAuthenticationItemBinding(RelativeLayout r1, RelativeLayout r2, ImageView r3, TextView r4, ImageView r5, TextView r6, RecyclerView r7) {
        this.rootView = r1;
        this.appDetails = r2;
        this.appIcon = r3;
        this.appName = r4;
        this.expand = r5;
        this.numberOfUris = r6;
        this.uris = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AppAuthenticationItemBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AppAuthenticationItemBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.app_authentication_item, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AppAuthenticationItemBinding bind(View r10) {
        int r0 = R.id.app_details;
        RelativeLayout r4 = (RelativeLayout) ViewBindings.findChildViewById(r10, R.id.app_details);
        if (r4 == null) goto L17;
        r0 = R.id.app_icon;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r10, R.id.app_icon);
        if (r5 == null) goto L17;
        r0 = R.id.app_name;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r10, R.id.app_name);
        if (r6 == null) goto L17;
        r0 = R.id.expand;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r10, R.id.expand);
        if (r7 == null) goto L17;
        r0 = R.id.number_of_uris;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r10, R.id.number_of_uris);
        if (r8 == null) goto L17;
        r0 = R.id.uris;
        RecyclerView r9 = (RecyclerView) ViewBindings.findChildViewById(r10, R.id.uris);
        if (r9 == null) goto L17;
        return new AppAuthenticationItemBinding((RelativeLayout) r10, r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
