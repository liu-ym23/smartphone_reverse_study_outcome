package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.SettingItemCheckSimpleText;

/* JADX INFO: loaded from: classes2.dex */
public final class RevoneListItemLeftCheckBinding implements ViewBinding {
    public final SettingItemCheckSimpleText itemCheckText;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RevoneListItemLeftCheckBinding(LinearLayout r1, SettingItemCheckSimpleText r2) {
        this.rootView = r1;
        this.itemCheckText = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RevoneListItemLeftCheckBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static RevoneListItemLeftCheckBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.revone_list_item_left_check, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static RevoneListItemLeftCheckBinding bind(View r2) {
        SettingItemCheckSimpleText r1 = (SettingItemCheckSimpleText) ViewBindings.findChildViewById(r2, R.id.item_check_text);
        if (r1 == null) goto L7;
        return new RevoneListItemLeftCheckBinding((LinearLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.item_check_text)));
    }
}
