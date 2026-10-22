package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OCardListItem;

/* JADX INFO: loaded from: classes2.dex */
public final class WifiAccesspointInfoLayoutBinding implements ViewBinding {
    public final GroupListItemVerticalGapLayoutBinding listBottomView;
    public final OCardListItem listItemContainer;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private WifiAccesspointInfoLayoutBinding(LinearLayout r1, GroupListItemVerticalGapLayoutBinding r2, OCardListItem r3) {
        this.rootView = r1;
        this.listBottomView = r2;
        this.listItemContainer = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static WifiAccesspointInfoLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static WifiAccesspointInfoLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.wifi_accesspoint_info_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static WifiAccesspointInfoLayoutBinding bind(View r3) {
        int r0 = R.id.list_bottom_view;
        View r1 = ViewBindings.findChildViewById(r3, R.id.list_bottom_view);
        if (r1 == null) goto L10;
        GroupListItemVerticalGapLayoutBinding r2 = GroupListItemVerticalGapLayoutBinding.bind(r1);
        OCardListItem r4 = (OCardListItem) ViewBindings.findChildViewById(r3, R.id.list_item_container);
        if (r4 != null) goto L7;
        r0 = R.id.list_item_container;
        goto L10
    L7:
        return new WifiAccesspointInfoLayoutBinding((LinearLayout) r3, r2, r4);
    L10:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
