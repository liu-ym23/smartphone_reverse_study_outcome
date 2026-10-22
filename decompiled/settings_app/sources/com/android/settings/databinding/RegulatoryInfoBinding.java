package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;

/* JADX INFO: loaded from: classes2.dex */
public final class RegulatoryInfoBinding implements ViewBinding {
    public final ImageView regulatoryInfo;
    private final OScrollView rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RegulatoryInfoBinding(OScrollView r1, ImageView r2) {
        this.rootView = r1;
        this.regulatoryInfo = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public OScrollView getRoot() {
        return this.rootView;
    }

    public static RegulatoryInfoBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static RegulatoryInfoBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.regulatory_info, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static RegulatoryInfoBinding bind(View r2) {
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r2, R.id.regulatoryInfo);
        if (r1 == null) goto L7;
        return new RegulatoryInfoBinding((OScrollView) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.regulatoryInfo)));
    }
}
