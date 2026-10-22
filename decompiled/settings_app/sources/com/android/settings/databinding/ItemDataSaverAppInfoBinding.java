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
public final class ItemDataSaverAppInfoBinding implements ViewBinding {
    public final ManageApplicationsItemBinding appSnippet;
    public final OCardListItem itemBackgroundData;
    public final OCardListItem itemUnrestrictedData;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ItemDataSaverAppInfoBinding(LinearLayout r1, ManageApplicationsItemBinding r2, OCardListItem r3, OCardListItem r4) {
        this.rootView = r1;
        this.appSnippet = r2;
        this.itemBackgroundData = r3;
        this.itemUnrestrictedData = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ItemDataSaverAppInfoBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ItemDataSaverAppInfoBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.item_data_saver_app_info, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ItemDataSaverAppInfoBinding bind(View r4) {
        int r0 = R.id.app_snippet;
        View r1 = ViewBindings.findChildViewById(r4, R.id.app_snippet);
        if (r1 == null) goto L12;
        ManageApplicationsItemBinding r2 = ManageApplicationsItemBinding.bind(r1);
        int r3 = R.id.itemBackgroundData;
        OCardListItem r5 = (OCardListItem) ViewBindings.findChildViewById(r4, R.id.itemBackgroundData);
        if (r5 == null) goto L10;
        r3 = R.id.itemUnrestrictedData;
        OCardListItem r6 = (OCardListItem) ViewBindings.findChildViewById(r4, R.id.itemUnrestrictedData);
        if (r6 == null) goto L10;
        return new ItemDataSaverAppInfoBinding((LinearLayout) r4, r2, r5, r6);
    L10:
        r0 = r3;
    L12:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
