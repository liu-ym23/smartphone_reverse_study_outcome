package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class SettingItemEditableLayoutBinding implements ViewBinding {
    public final ImageView cbDel;
    public final ImageView icMove;
    public final ImageView itemArrow;
    public final FrameLayout rlListItemParent;
    private final FrameLayout rootView;
    public final TextView textview;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SettingItemEditableLayoutBinding(FrameLayout r1, ImageView r2, ImageView r3, ImageView r4, FrameLayout r5, TextView r6) {
        this.rootView = r1;
        this.cbDel = r2;
        this.icMove = r3;
        this.itemArrow = r4;
        this.rlListItemParent = r5;
        this.textview = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static SettingItemEditableLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SettingItemEditableLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.setting_item_editable_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SettingItemEditableLayoutBinding bind(View r9) {
        int r0 = R.id.cb_del;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r9, R.id.cb_del);
        if (r4 == null) goto L13;
        r0 = R.id.ic_move;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r9, R.id.ic_move);
        if (r5 == null) goto L13;
        r0 = R.id.item_arrow;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r9, R.id.item_arrow);
        if (r6 == null) goto L13;
        FrameLayout r7 = (FrameLayout) r9;
        r0 = R.id.textview;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r9, R.id.textview);
        if (r8 == null) goto L13;
        return new SettingItemEditableLayoutBinding(r7, r4, r5, r6, r7, r8);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
