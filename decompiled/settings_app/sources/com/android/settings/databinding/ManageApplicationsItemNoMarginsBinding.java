package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.simplified.OLocalListItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class ManageApplicationsItemNoMarginsBinding implements ViewBinding {
    public final OLocalListItemText appItem;
    private final RelativeLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ManageApplicationsItemNoMarginsBinding(RelativeLayout r1, OLocalListItemText r2) {
        this.rootView = r1;
        this.appItem = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ManageApplicationsItemNoMarginsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ManageApplicationsItemNoMarginsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.manage_applications_item_no_margins, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ManageApplicationsItemNoMarginsBinding bind(View r2) {
        OLocalListItemText r1 = (OLocalListItemText) ViewBindings.findChildViewById(r2, R.id.app_item);
        if (r1 == null) goto L7;
        return new ManageApplicationsItemNoMarginsBinding((RelativeLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.app_item)));
    }
}
