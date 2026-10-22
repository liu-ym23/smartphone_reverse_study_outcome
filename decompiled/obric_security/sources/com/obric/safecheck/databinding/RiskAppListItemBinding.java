package com.obric.safecheck.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.safecheck.R;

/* JADX INFO: loaded from: classes4.dex */
public final class RiskAppListItemBinding implements ViewBinding {
    public final OCardListItem riskAppListItemCard;
    private final FrameLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RiskAppListItemBinding(FrameLayout rootView, OCardListItem riskAppListItemCard) {
        this.rootView = rootView;
        this.riskAppListItemCard = riskAppListItemCard;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static RiskAppListItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RiskAppListItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View r2 = inflater.inflate(R.layout.risk_app_list_item, parent, false);
        if (attachToParent == false) goto L6;
        parent.addView(r2);
    L6:
        return bind(r2);
    }

    public static RiskAppListItemBinding bind(View rootView) {
        int r0 = R.id.risk_app_list_item_card;
        OCardListItem r1 = (OCardListItem) ViewBindings.findChildViewById(rootView, r0);
        if (r1 == null) goto L7;
        return new RiskAppListItemBinding((FrameLayout) rootView, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(r0)));
    }
}
