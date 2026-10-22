package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class TipsLayoutBinding implements ViewBinding {
    public final ItemSubSettingsPaddingLayout2Binding itemShadow;
    private final RelativeLayout rootView;
    public final TextView tips;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private TipsLayoutBinding(RelativeLayout r1, ItemSubSettingsPaddingLayout2Binding r2, TextView r3) {
        this.rootView = r1;
        this.itemShadow = r2;
        this.tips = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static TipsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static TipsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.tips_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static TipsLayoutBinding bind(View r3) {
        int r0 = R.id.item_shadow;
        View r1 = ViewBindings.findChildViewById(r3, R.id.item_shadow);
        if (r1 == null) goto L10;
        ItemSubSettingsPaddingLayout2Binding r2 = ItemSubSettingsPaddingLayout2Binding.bind(r1);
        TextView r4 = (TextView) ViewBindings.findChildViewById(r3, R.id.tips);
        if (r4 != null) goto L7;
        r0 = R.id.tips;
        goto L10
    L7:
        return new TipsLayoutBinding((RelativeLayout) r3, r2, r4);
    L10:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
