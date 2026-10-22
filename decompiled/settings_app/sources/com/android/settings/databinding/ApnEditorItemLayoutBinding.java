package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class ApnEditorItemLayoutBinding implements ViewBinding {
    public final TextView itemTextSubTitle;
    public final TextView itemTextTitle;
    private final View rootView;

    private ApnEditorItemLayoutBinding(View r1, TextView r2, TextView r3) {
        this.rootView = r1;
        this.itemTextSubTitle = r2;
        this.itemTextTitle = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static ApnEditorItemLayoutBinding inflate(LayoutInflater r1, ViewGroup r2) {
        if (r2 == null) goto L6;
        r1.inflate(R.layout.apn_editor_item_layout, r2);
        return bind(r2);
    L6:
        throw new NullPointerException("parent");
    }

    public static ApnEditorItemLayoutBinding bind(View r3) {
        int r0 = R.id.item_text_sub_title;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r3, R.id.item_text_sub_title);
        if (r1 == null) goto L9;
        r0 = R.id.item_text_title;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r3, R.id.item_text_title);
        if (r2 == null) goto L9;
        return new ApnEditorItemLayoutBinding(r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
