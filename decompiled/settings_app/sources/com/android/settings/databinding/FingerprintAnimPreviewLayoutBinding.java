package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.FingerprintAnimView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class FingerprintAnimPreviewLayoutBinding implements ViewBinding {
    public final FingerprintAnimView animView;
    public final LinearLayout bottomLayout;
    public final RecyclerView recyclerView;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private FingerprintAnimPreviewLayoutBinding(RelativeLayout r1, FingerprintAnimView r2, LinearLayout r3, RecyclerView r4, OFloatingTitleBar r5) {
        this.rootView = r1;
        this.animView = r2;
        this.bottomLayout = r3;
        this.recyclerView = r4;
        this.viewTitle = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FingerprintAnimPreviewLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FingerprintAnimPreviewLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.fingerprint_anim_preview_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static FingerprintAnimPreviewLayoutBinding bind(View r8) {
        int r0 = R.id.anim_view;
        FingerprintAnimView r4 = (FingerprintAnimView) ViewBindings.findChildViewById(r8, R.id.anim_view);
        if (r4 == null) goto L13;
        r0 = R.id.bottom_layout;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r8, R.id.bottom_layout);
        if (r5 == null) goto L13;
        r0 = R.id.recycler_view;
        RecyclerView r6 = (RecyclerView) ViewBindings.findChildViewById(r8, R.id.recycler_view);
        if (r6 == null) goto L13;
        r0 = R.id.view_title;
        OFloatingTitleBar r7 = (OFloatingTitleBar) ViewBindings.findChildViewById(r8, R.id.view_title);
        if (r7 == null) goto L13;
        return new FingerprintAnimPreviewLayoutBinding((RelativeLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
