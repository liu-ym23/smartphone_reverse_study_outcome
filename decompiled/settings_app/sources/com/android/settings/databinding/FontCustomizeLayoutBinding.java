package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import obric.widget.ListContentItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class FontCustomizeLayoutBinding implements ViewBinding {
    public final ListContentItemText customFontSize;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private FontCustomizeLayoutBinding(LinearLayout r1, ListContentItemText r2) {
        this.rootView = r1;
        this.customFontSize = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FontCustomizeLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FontCustomizeLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.font_customize_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static FontCustomizeLayoutBinding bind(View r2) {
        ListContentItemText r1 = (ListContentItemText) ViewBindings.findChildViewById(r2, R.id.custom_font_size);
        if (r1 == null) goto L7;
        return new FontCustomizeLayoutBinding((LinearLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.custom_font_size)));
    }
}
