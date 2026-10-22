package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class UserSelectItemBinding implements ViewBinding {
    public final FrameLayout button;
    public final ImageView icon;
    private final RelativeLayout rootView;
    public final TextView title;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private UserSelectItemBinding(RelativeLayout r1, FrameLayout r2, ImageView r3, TextView r4) {
        this.rootView = r1;
        this.button = r2;
        this.icon = r3;
        this.title = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static UserSelectItemBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static UserSelectItemBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.user_select_item, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static UserSelectItemBinding bind(View r4) {
        int r0 = R.id.button;
        FrameLayout r1 = (FrameLayout) ViewBindings.findChildViewById(r4, R.id.button);
        if (r1 == null) goto L11;
        r0 = android.R.id.icon;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(r4, android.R.id.icon);
        if (r2 == null) goto L11;
        r0 = android.R.id.title;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r4, android.R.id.title);
        if (r3 == null) goto L11;
        return new UserSelectItemBinding((RelativeLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
