package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.android.settings.R;
import com.obric.oui.lisitem.OCardListItem;

/* JADX INFO: loaded from: classes2.dex */
public final class SettingsOuiCardListItemWithIconBinding implements ViewBinding {
    public final OCardListItem cardListItem;
    private final OCardListItem rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SettingsOuiCardListItemWithIconBinding(OCardListItem r1, OCardListItem r2) {
        this.rootView = r1;
        this.cardListItem = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public OCardListItem getRoot() {
        return this.rootView;
    }

    public static SettingsOuiCardListItemWithIconBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SettingsOuiCardListItemWithIconBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.settings_oui_card_list_item_with_icon, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SettingsOuiCardListItemWithIconBinding bind(View r1) {
        if (r1 == null) goto L6;
        OCardListItem r2 = (OCardListItem) r1;
        return new SettingsOuiCardListItemWithIconBinding(r2, r2);
    L6:
        throw new NullPointerException("rootView");
    }
}
