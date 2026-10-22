package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class PreferenceVpnBinding implements ViewBinding {
    public final ItemBottomShadowLayout2Binding layoutBottom;
    public final View layoutGapBottom;
    public final View layoutGapTop;
    public final OCardListItem listItemContainer;
    public final OSectionTitleBar listItemSubtitle;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PreferenceVpnBinding(LinearLayout r1, ItemBottomShadowLayout2Binding r2, View r3, View r4, OCardListItem r5, OSectionTitleBar r6) {
        this.rootView = r1;
        this.layoutBottom = r2;
        this.layoutGapBottom = r3;
        this.layoutGapTop = r4;
        this.listItemContainer = r5;
        this.listItemSubtitle = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PreferenceVpnBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PreferenceVpnBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.preference_vpn, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PreferenceVpnBinding bind(View r9) {
        int r0 = R.id.layout_bottom;
        View r1 = ViewBindings.findChildViewById(r9, R.id.layout_bottom);
        if (r1 == null) goto L15;
        ItemBottomShadowLayout2Binding r4 = ItemBottomShadowLayout2Binding.bind(r1);
        r0 = R.id.layout_gap_bottom;
        View r5 = ViewBindings.findChildViewById(r9, R.id.layout_gap_bottom);
        if (r5 == null) goto L15;
        r0 = R.id.layout_gap_top;
        View r6 = ViewBindings.findChildViewById(r9, R.id.layout_gap_top);
        if (r6 == null) goto L15;
        r0 = R.id.list_item_container;
        OCardListItem r7 = (OCardListItem) ViewBindings.findChildViewById(r9, R.id.list_item_container);
        if (r7 == null) goto L15;
        r0 = R.id.list_item_subtitle;
        OSectionTitleBar r8 = (OSectionTitleBar) ViewBindings.findChildViewById(r9, R.id.list_item_subtitle);
        if (r8 == null) goto L15;
        return new PreferenceVpnBinding((LinearLayout) r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
