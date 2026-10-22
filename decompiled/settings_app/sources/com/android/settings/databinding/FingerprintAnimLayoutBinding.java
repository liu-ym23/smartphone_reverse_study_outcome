package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class FingerprintAnimLayoutBinding implements ViewBinding {
    public final ImageView fingerprintAnimView;
    public final ImageView phoneFrame;
    public final ImageView previewImage;
    private final View rootView;

    private FingerprintAnimLayoutBinding(View r1, ImageView r2, ImageView r3, ImageView r4) {
        this.rootView = r1;
        this.fingerprintAnimView = r2;
        this.phoneFrame = r3;
        this.previewImage = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static FingerprintAnimLayoutBinding inflate(LayoutInflater r1, ViewGroup r2) {
        if (r2 == null) goto L6;
        r1.inflate(R.layout.fingerprint_anim_layout, r2);
        return bind(r2);
    L6:
        throw new NullPointerException("parent");
    }

    public static FingerprintAnimLayoutBinding bind(View r4) {
        int r0 = R.id.fingerprint_anim_view;
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r4, R.id.fingerprint_anim_view);
        if (r1 == null) goto L11;
        r0 = R.id.phone_frame;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(r4, R.id.phone_frame);
        if (r2 == null) goto L11;
        r0 = R.id.preview_image;
        ImageView r3 = (ImageView) ViewBindings.findChildViewById(r4, R.id.preview_image);
        if (r3 == null) goto L11;
        return new FingerprintAnimLayoutBinding(r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
