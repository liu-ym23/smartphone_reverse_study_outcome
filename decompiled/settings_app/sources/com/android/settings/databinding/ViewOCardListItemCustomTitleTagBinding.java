package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes2.dex */
public final class ViewOCardListItemCustomTitleTagBinding implements ViewBinding {
    public final LinearLayout customTitleContainer;
    public final OTextView customTitleText;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ViewOCardListItemCustomTitleTagBinding(LinearLayout r1, LinearLayout r2, OTextView r3) {
        this.rootView = r1;
        this.customTitleContainer = r2;
        this.customTitleText = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewOCardListItemCustomTitleTagBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ViewOCardListItemCustomTitleTagBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.view_o_card_list_item_custom_title_tag, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ViewOCardListItemCustomTitleTagBinding bind(View r3) {
        LinearLayout r0 = (LinearLayout) r3;
        OTextView r2 = (OTextView) ViewBindings.findChildViewById(r3, R.id.custom_title_text);
        if (r2 == null) goto L7;
        return new ViewOCardListItemCustomTitleTagBinding(r0, r0, r2);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(R.id.custom_title_text)));
    }
}
