package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.SettingItemCheckbox;

/* JADX INFO: loaded from: classes2.dex */
public final class ListContentItemCheckboxBinding implements ViewBinding {
    public final SettingItemCheckbox itemCheckbox;
    private final RelativeLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ListContentItemCheckboxBinding(RelativeLayout r1, SettingItemCheckbox r2) {
        this.rootView = r1;
        this.itemCheckbox = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ListContentItemCheckboxBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ListContentItemCheckboxBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.list_content_item_checkbox, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ListContentItemCheckboxBinding bind(View r2) {
        SettingItemCheckbox r1 = (SettingItemCheckbox) ViewBindings.findChildViewById(r2, R.id.item_checkbox);
        if (r1 == null) goto L7;
        return new ListContentItemCheckboxBinding((RelativeLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.item_checkbox)));
    }
}
