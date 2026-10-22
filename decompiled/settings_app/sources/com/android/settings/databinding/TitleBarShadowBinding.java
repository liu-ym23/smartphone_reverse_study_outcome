package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class TitleBarShadowBinding implements ViewBinding {
    private final ImageView rootView;
    public final ImageView titleShadow;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private TitleBarShadowBinding(ImageView r1, ImageView r2) {
        this.rootView = r1;
        this.titleShadow = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ImageView getRoot() {
        return this.rootView;
    }

    public static TitleBarShadowBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static TitleBarShadowBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.title_bar_shadow, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static TitleBarShadowBinding bind(View r1) {
        if (r1 == null) goto L6;
        ImageView r2 = (ImageView) r1;
        return new TitleBarShadowBinding(r2, r2);
    L6:
        throw new NullPointerException("rootView");
    }
}
