package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class WifiTitleItemBinding implements ViewBinding {
    private final View rootView;
    public final OSectionTitleBar titleTv;

    private WifiTitleItemBinding(View r1, OSectionTitleBar r2) {
        this.rootView = r1;
        this.titleTv = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static WifiTitleItemBinding inflate(LayoutInflater r1, ViewGroup r2) {
        if (r2 == null) goto L6;
        r1.inflate(R.layout.wifi_title_item, r2);
        return bind(r2);
    L6:
        throw new NullPointerException("parent");
    }

    public static WifiTitleItemBinding bind(View r2) {
        OSectionTitleBar r1 = (OSectionTitleBar) ViewBindings.findChildViewById(r2, R.id.title_tv);
        if (r1 == null) goto L7;
        return new WifiTitleItemBinding(r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.title_tv)));
    }
}
