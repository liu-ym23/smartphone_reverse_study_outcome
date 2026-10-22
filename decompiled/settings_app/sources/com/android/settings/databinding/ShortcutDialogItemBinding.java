package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class ShortcutDialogItemBinding implements ViewBinding {
    public final ImageView iconArrow;
    public final ImageView itemCheck;
    public final RelativeLayout listItemLayout;
    private final FrameLayout rootView;
    public final TextView subTitle;
    public final TextView textTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ShortcutDialogItemBinding(FrameLayout r1, ImageView r2, ImageView r3, RelativeLayout r4, TextView r5, TextView r6) {
        this.rootView = r1;
        this.iconArrow = r2;
        this.itemCheck = r3;
        this.listItemLayout = r4;
        this.subTitle = r5;
        this.textTitle = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ShortcutDialogItemBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ShortcutDialogItemBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.shortcut_dialog_item, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ShortcutDialogItemBinding bind(View r9) {
        int r0 = R.id.icon_arrow;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r9, R.id.icon_arrow);
        if (r4 == null) goto L15;
        r0 = R.id.item_check;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r9, R.id.item_check);
        if (r5 == null) goto L15;
        r0 = R.id.list_item_layout;
        RelativeLayout r6 = (RelativeLayout) ViewBindings.findChildViewById(r9, R.id.list_item_layout);
        if (r6 == null) goto L15;
        r0 = R.id.sub_title;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r9, R.id.sub_title);
        if (r7 == null) goto L15;
        r0 = R.id.text_title;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r9, R.id.text_title);
        if (r8 == null) goto L15;
        return new ShortcutDialogItemBinding((FrameLayout) r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
