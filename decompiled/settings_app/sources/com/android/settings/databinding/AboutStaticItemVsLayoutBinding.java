package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.android.settings.AboutStaticItem;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class AboutStaticItemVsLayoutBinding implements ViewBinding {
    public final AboutStaticItem firmwareVersion;
    private final AboutStaticItem rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AboutStaticItemVsLayoutBinding(AboutStaticItem r1, AboutStaticItem r2) {
        this.rootView = r1;
        this.firmwareVersion = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public AboutStaticItem getRoot() {
        return this.rootView;
    }

    public static AboutStaticItemVsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AboutStaticItemVsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.about_static_item_vs_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AboutStaticItemVsLayoutBinding bind(View r1) {
        if (r1 == null) goto L6;
        AboutStaticItem r2 = (AboutStaticItem) r1;
        return new AboutStaticItemVsLayoutBinding(r2, r2);
    L6:
        throw new NullPointerException("rootView");
    }
}
