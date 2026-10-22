package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class BigbangGifAnimLayoutBinding implements ViewBinding {
    public final ImageView bigbangResult;
    public final ImageView circle;
    public final ImageView foreBg;
    public final ImageView hand;
    public final ImageView middleText;
    private final View rootView;
    public final ImageView textBg;

    private BigbangGifAnimLayoutBinding(View r1, ImageView r2, ImageView r3, ImageView r4, ImageView r5, ImageView r6, ImageView r7) {
        this.rootView = r1;
        this.bigbangResult = r2;
        this.circle = r3;
        this.foreBg = r4;
        this.hand = r5;
        this.middleText = r6;
        this.textBg = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static BigbangGifAnimLayoutBinding inflate(LayoutInflater r1, ViewGroup r2) {
        if (r2 == null) goto L6;
        r1.inflate(R.layout.bigbang_gif_anim_layout, r2);
        return bind(r2);
    L6:
        throw new NullPointerException("parent");
    }

    public static BigbangGifAnimLayoutBinding bind(View r10) {
        int r0 = R.id.bigbang_result;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r10, R.id.bigbang_result);
        if (r4 == null) goto L17;
        r0 = R.id.circle;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r10, R.id.circle);
        if (r5 == null) goto L17;
        r0 = R.id.fore_bg;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r10, R.id.fore_bg);
        if (r6 == null) goto L17;
        r0 = R.id.hand;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r10, R.id.hand);
        if (r7 == null) goto L17;
        r0 = R.id.middle_text;
        ImageView r8 = (ImageView) ViewBindings.findChildViewById(r10, R.id.middle_text);
        if (r8 == null) goto L17;
        r0 = R.id.text_bg;
        ImageView r9 = (ImageView) ViewBindings.findChildViewById(r10, R.id.text_bg);
        if (r9 == null) goto L17;
        return new BigbangGifAnimLayoutBinding(r10, r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
