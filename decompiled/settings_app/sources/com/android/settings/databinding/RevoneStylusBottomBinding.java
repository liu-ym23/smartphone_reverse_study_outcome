package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.SettingItemButton;

/* JADX INFO: loaded from: classes2.dex */
public final class RevoneStylusBottomBinding implements ViewBinding {
    public final ImageView banner;
    public final SettingItemButton bottomView;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RevoneStylusBottomBinding(LinearLayout r1, ImageView r2, SettingItemButton r3) {
        this.rootView = r1;
        this.banner = r2;
        this.bottomView = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RevoneStylusBottomBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static RevoneStylusBottomBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.revone_stylus_bottom, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static RevoneStylusBottomBinding bind(View r3) {
        int r0 = R.id.banner;
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r3, R.id.banner);
        if (r1 == null) goto L9;
        r0 = R.id.bottom_view;
        SettingItemButton r2 = (SettingItemButton) ViewBindings.findChildViewById(r3, R.id.bottom_view);
        if (r2 == null) goto L9;
        return new RevoneStylusBottomBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
