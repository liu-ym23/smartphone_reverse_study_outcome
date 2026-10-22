package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class IntroImageLayoutBinding implements ViewBinding {
    public final ImageView introImage;
    private final RelativeLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private IntroImageLayoutBinding(RelativeLayout r1, ImageView r2) {
        this.rootView = r1;
        this.introImage = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static IntroImageLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static IntroImageLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.intro_image_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static IntroImageLayoutBinding bind(View r2) {
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r2, R.id.intro_image);
        if (r1 == null) goto L7;
        return new IntroImageLayoutBinding((RelativeLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.intro_image)));
    }
}
