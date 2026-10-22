package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class UserInfoHeaderBinding implements ViewBinding {
    public final LinearLayout appRestrictionsPref;
    public final ImageView delete;
    public final ImageView icon;
    private final LinearLayout rootView;
    public final TextView summary;
    public final TextView title;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private UserInfoHeaderBinding(LinearLayout r1, LinearLayout r2, ImageView r3, ImageView r4, TextView r5, TextView r6) {
        this.rootView = r1;
        this.appRestrictionsPref = r2;
        this.delete = r3;
        this.icon = r4;
        this.summary = r5;
        this.title = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static UserInfoHeaderBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static UserInfoHeaderBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.user_info_header, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static UserInfoHeaderBinding bind(View r9) {
        int r0 = R.id.app_restrictions_pref;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r9, R.id.app_restrictions_pref);
        if (r4 == null) goto L15;
        r0 = R.id.delete;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r9, R.id.delete);
        if (r5 == null) goto L15;
        r0 = android.R.id.icon;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r9, android.R.id.icon);
        if (r6 == null) goto L15;
        r0 = android.R.id.summary;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r9, android.R.id.summary);
        if (r7 == null) goto L15;
        r0 = android.R.id.title;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r9, android.R.id.title);
        if (r8 == null) goto L15;
        return new UserInfoHeaderBinding((LinearLayout) r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
