package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OCardListItem;

/* JADX INFO: loaded from: classes2.dex */
public final class ListContentItemCheckOuiWithIcon2Binding implements ViewBinding {
    public final OCardListItem itemCheck;
    public final LinearLayout pageContainer;
    private final RelativeLayout rootView;
    public final TextView section;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ListContentItemCheckOuiWithIcon2Binding(RelativeLayout r1, OCardListItem r2, LinearLayout r3, TextView r4) {
        this.rootView = r1;
        this.itemCheck = r2;
        this.pageContainer = r3;
        this.section = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ListContentItemCheckOuiWithIcon2Binding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ListContentItemCheckOuiWithIcon2Binding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.list_content_item_check_oui_with_icon_2, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ListContentItemCheckOuiWithIcon2Binding bind(View r4) {
        int r0 = R.id.item_check;
        OCardListItem r1 = (OCardListItem) ViewBindings.findChildViewById(r4, R.id.item_check);
        if (r1 == null) goto L11;
        r0 = R.id.page_container;
        LinearLayout r2 = (LinearLayout) ViewBindings.findChildViewById(r4, R.id.page_container);
        if (r2 == null) goto L11;
        r0 = R.id.section;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r4, R.id.section);
        if (r3 == null) goto L11;
        return new ListContentItemCheckOuiWithIcon2Binding((RelativeLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
