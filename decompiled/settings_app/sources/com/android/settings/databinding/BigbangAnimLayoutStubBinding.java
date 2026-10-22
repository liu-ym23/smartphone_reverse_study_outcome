package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.android.settings.R;
import com.android.settings.widget.BigbangGifAnimView;

/* JADX INFO: loaded from: classes2.dex */
public final class BigbangAnimLayoutStubBinding implements ViewBinding {
    public final BigbangGifAnimView gifView;
    private final BigbangGifAnimView rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private BigbangAnimLayoutStubBinding(BigbangGifAnimView r1, BigbangGifAnimView r2) {
        this.rootView = r1;
        this.gifView = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public BigbangGifAnimView getRoot() {
        return this.rootView;
    }

    public static BigbangAnimLayoutStubBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static BigbangAnimLayoutStubBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.bigbang_anim_layout_stub, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static BigbangAnimLayoutStubBinding bind(View r1) {
        if (r1 == null) goto L6;
        BigbangGifAnimView r2 = (BigbangGifAnimView) r1;
        return new BigbangAnimLayoutStubBinding(r2, r2);
    L6:
        throw new NullPointerException("rootView");
    }
}
