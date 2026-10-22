package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.android.settings.R;
import com.obric.oui.checkbox.OCheckMark;

/* JADX INFO: loaded from: classes2.dex */
public final class OCardListItemCustomStartMarkBinding implements ViewBinding {
    public final OCheckMark customStartMark;
    private final OCheckMark rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private OCardListItemCustomStartMarkBinding(OCheckMark r1, OCheckMark r2) {
        this.rootView = r1;
        this.customStartMark = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public OCheckMark getRoot() {
        return this.rootView;
    }

    public static OCardListItemCustomStartMarkBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static OCardListItemCustomStartMarkBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.o_card_list_item_custom_start_mark, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static OCardListItemCustomStartMarkBinding bind(View r1) {
        if (r1 == null) goto L6;
        OCheckMark r2 = (OCheckMark) r1;
        return new OCardListItemCustomStartMarkBinding(r2, r2);
    L6:
        throw new NullPointerException("rootView");
    }
}
