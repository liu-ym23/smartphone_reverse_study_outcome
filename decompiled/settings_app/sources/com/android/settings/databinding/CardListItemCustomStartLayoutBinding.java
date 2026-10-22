package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes2.dex */
public final class CardListItemCustomStartLayoutBinding implements ViewBinding {
    public final ImageView customStartImage;
    public final OTextView customStartTitle;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private CardListItemCustomStartLayoutBinding(LinearLayout r1, ImageView r2, OTextView r3) {
        this.rootView = r1;
        this.customStartImage = r2;
        this.customStartTitle = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static CardListItemCustomStartLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static CardListItemCustomStartLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.card_list_item_custom_start_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static CardListItemCustomStartLayoutBinding bind(View r3) {
        int r0 = R.id.custom_start_image;
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r3, R.id.custom_start_image);
        if (r1 == null) goto L9;
        r0 = R.id.custom_start_title;
        OTextView r2 = (OTextView) ViewBindings.findChildViewById(r3, R.id.custom_start_title);
        if (r2 == null) goto L9;
        return new CardListItemCustomStartLayoutBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
