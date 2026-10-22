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
public final class ListContentItemCommonBinding implements ViewBinding {
    public final View bottomSpacer;
    public final SettingListItem itemText;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ListContentItemCommonBinding(LinearLayout r1, View r2, SettingListItem r3) {
        this.rootView = r1;
        this.bottomSpacer = r2;
        this.itemText = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ListContentItemCommonBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ListContentItemCommonBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.list_content_item_common, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ListContentItemCommonBinding bind(View r3) {
        int r0 = R.id.bottom_spacer;
        View r1 = ViewBindings.findChildViewById(r3, R.id.bottom_spacer);
        if (r1 == null) goto L9;
        r0 = R.id.item_text;
        SettingListItem r2 = (SettingListItem) ViewBindings.findChildViewById(r3, R.id.item_text);
        if (r2 == null) goto L9;
        return new ListContentItemCommonBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
