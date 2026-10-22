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
public final class UserPreferenceBinding implements ViewBinding {
    public final ImageView icon;
    private final LinearLayout rootView;
    public final TextView title;
    public final LinearLayout widgetFrame;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private UserPreferenceBinding(LinearLayout r1, ImageView r2, TextView r3, LinearLayout r4) {
        this.rootView = r1;
        this.icon = r2;
        this.title = r3;
        this.widgetFrame = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static UserPreferenceBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static UserPreferenceBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.user_preference, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static UserPreferenceBinding bind(View r3) {
        int r0 = android.R.id.icon;
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r3, android.R.id.icon);
        if (r1 == null) goto L9;
        r0 = android.R.id.title;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r3, android.R.id.title);
        if (r2 == null) goto L9;
        LinearLayout r4 = (LinearLayout) r3;
        return new UserPreferenceBinding(r4, r1, r2, r4);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
