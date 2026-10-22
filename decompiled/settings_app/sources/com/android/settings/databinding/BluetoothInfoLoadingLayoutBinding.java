package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.progress.ODownloadProgressView;

/* JADX INFO: loaded from: classes2.dex */
public final class BluetoothInfoLoadingLayoutBinding implements ViewBinding {
    public final ImageView infoImg;
    public final ODownloadProgressView loadingView;
    private final FrameLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private BluetoothInfoLoadingLayoutBinding(FrameLayout r1, ImageView r2, ODownloadProgressView r3) {
        this.rootView = r1;
        this.infoImg = r2;
        this.loadingView = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BluetoothInfoLoadingLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static BluetoothInfoLoadingLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.bluetooth_info_loading_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static BluetoothInfoLoadingLayoutBinding bind(View r3) {
        int r0 = R.id.info_img;
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r3, R.id.info_img);
        if (r1 == null) goto L9;
        r0 = R.id.loading_view;
        ODownloadProgressView r2 = (ODownloadProgressView) ViewBindings.findChildViewById(r3, R.id.loading_view);
        if (r2 == null) goto L9;
        return new BluetoothInfoLoadingLayoutBinding((FrameLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
