package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class ItemLanguageCustomRightBinding implements ViewBinding {
    private final ImageView rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ItemLanguageCustomRightBinding(ImageView r1) {
        this.rootView = r1;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ImageView getRoot() {
        return this.rootView;
    }

    public static ItemLanguageCustomRightBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemLanguageCustomRightBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.item_language_custom_right, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ItemLanguageCustomRightBinding bind(View r1) {
        if (r1 == null) goto L6;
        return new ItemLanguageCustomRightBinding((ImageView) r1);
    L6:
        throw new NullPointerException("rootView");
    }
}
