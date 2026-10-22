package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OListItemSettings;

/* JADX INFO: loaded from: classes2.dex */
public final class PreferredActivityDetailsHeaderBinding implements ViewBinding {
    public final TextView fileType;
    public final OListItemSettings itemAllText;
    public final LinearLayout llAll;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PreferredActivityDetailsHeaderBinding(LinearLayout r1, TextView r2, OListItemSettings r3, LinearLayout r4) {
        this.rootView = r1;
        this.fileType = r2;
        this.itemAllText = r3;
        this.llAll = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PreferredActivityDetailsHeaderBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PreferredActivityDetailsHeaderBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.preferred_activity_details_header, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PreferredActivityDetailsHeaderBinding bind(View r4) {
        int r0 = R.id.file_type;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r4, R.id.file_type);
        if (r1 == null) goto L11;
        r0 = R.id.item_all_text;
        OListItemSettings r2 = (OListItemSettings) ViewBindings.findChildViewById(r4, R.id.item_all_text);
        if (r2 == null) goto L11;
        r0 = R.id.ll_all;
        LinearLayout r3 = (LinearLayout) ViewBindings.findChildViewById(r4, R.id.ll_all);
        if (r3 == null) goto L11;
        return new PreferredActivityDetailsHeaderBinding((LinearLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
