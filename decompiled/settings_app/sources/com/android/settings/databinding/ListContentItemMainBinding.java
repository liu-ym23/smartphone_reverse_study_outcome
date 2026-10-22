package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.widget.SettingListItem;

/* JADX INFO: loaded from: classes2.dex */
public final class ListContentItemMainBinding implements ViewBinding {
    public final View bottomSpacer;
    public final SettingListItem itemAccount;
    public final SettingListItem itemText;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ListContentItemMainBinding(LinearLayout r1, View r2, SettingListItem r3, SettingListItem r4) {
        this.rootView = r1;
        this.bottomSpacer = r2;
        this.itemAccount = r3;
        this.itemText = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ListContentItemMainBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ListContentItemMainBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.list_content_item_main, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ListContentItemMainBinding bind(View r4) {
        int r0 = R.id.bottom_spacer;
        View r1 = ViewBindings.findChildViewById(r4, R.id.bottom_spacer);
        if (r1 == null) goto L11;
        r0 = R.id.item_account;
        SettingListItem r2 = (SettingListItem) ViewBindings.findChildViewById(r4, R.id.item_account);
        if (r2 == null) goto L11;
        r0 = R.id.item_text;
        SettingListItem r3 = (SettingListItem) ViewBindings.findChildViewById(r4, R.id.item_text);
        if (r3 == null) goto L11;
        return new ListContentItemMainBinding((LinearLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
