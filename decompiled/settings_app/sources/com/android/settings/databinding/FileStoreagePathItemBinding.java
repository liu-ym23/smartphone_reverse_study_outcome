package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class FileStoreagePathItemBinding implements ViewBinding {
    public final RelativeLayout appLayout;
    public final CheckBox itemCheckbox;
    public final ImageView itemIcon;
    public final TextView itemSubtitle;
    public final TextView itemTitle;
    private final RelativeLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private FileStoreagePathItemBinding(RelativeLayout r1, RelativeLayout r2, CheckBox r3, ImageView r4, TextView r5, TextView r6) {
        this.rootView = r1;
        this.appLayout = r2;
        this.itemCheckbox = r3;
        this.itemIcon = r4;
        this.itemSubtitle = r5;
        this.itemTitle = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FileStoreagePathItemBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FileStoreagePathItemBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.file_storeage_path_item, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static FileStoreagePathItemBinding bind(View r7) {
        RelativeLayout r2 = (RelativeLayout) r7;
        int r0 = R.id.item_checkbox;
        CheckBox r3 = (CheckBox) ViewBindings.findChildViewById(r7, R.id.item_checkbox);
        if (r3 == null) goto L13;
        r0 = R.id.item_icon;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r7, R.id.item_icon);
        if (r4 == null) goto L13;
        r0 = R.id.item_subtitle;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r7, R.id.item_subtitle);
        if (r5 == null) goto L13;
        r0 = R.id.item_title;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r7, R.id.item_title);
        if (r6 == null) goto L13;
        return new FileStoreagePathItemBinding(r2, r2, r3, r4, r5, r6);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r7.getResources().getResourceName(r0)));
    }
}
