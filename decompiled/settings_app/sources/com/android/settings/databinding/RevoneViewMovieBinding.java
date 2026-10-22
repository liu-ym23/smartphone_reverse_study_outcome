package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class RevoneViewMovieBinding implements ViewBinding {
    public final ImageView ivMask;
    private final View rootView;
    public final TextureView surface;

    private RevoneViewMovieBinding(View r1, ImageView r2, TextureView r3) {
        this.rootView = r1;
        this.ivMask = r2;
        this.surface = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static RevoneViewMovieBinding inflate(LayoutInflater r1, ViewGroup r2) {
        if (r2 == null) goto L6;
        r1.inflate(R.layout.revone_view_movie, r2);
        return bind(r2);
    L6:
        throw new NullPointerException("parent");
    }

    public static RevoneViewMovieBinding bind(View r3) {
        int r0 = R.id.iv_mask;
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r3, R.id.iv_mask);
        if (r1 == null) goto L9;
        r0 = R.id.surface;
        TextureView r2 = (TextureView) ViewBindings.findChildViewById(r3, R.id.surface);
        if (r2 == null) goto L9;
        return new RevoneViewMovieBinding(r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
