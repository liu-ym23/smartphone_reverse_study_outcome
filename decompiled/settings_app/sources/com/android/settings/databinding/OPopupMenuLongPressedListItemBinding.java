package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class OPopupMenuLongPressedListItemBinding implements ViewBinding {
    public final ImageView menuIcon;
    public final TextView menuTitle;
    private final View rootView;

    private OPopupMenuLongPressedListItemBinding(View r1, ImageView r2, TextView r3) {
        this.rootView = r1;
        this.menuIcon = r2;
        this.menuTitle = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static OPopupMenuLongPressedListItemBinding inflate(LayoutInflater r1, ViewGroup r2) {
        if (r2 == null) goto L6;
        r1.inflate(R.layout.o_popup_menu_long_pressed_list_item, r2);
        return bind(r2);
    L6:
        throw new NullPointerException("parent");
    }

    public static OPopupMenuLongPressedListItemBinding bind(View r3) {
        int r0 = R.id.menu_icon;
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r3, R.id.menu_icon);
        if (r1 == null) goto L9;
        r0 = R.id.menu_title;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r3, R.id.menu_title);
        if (r2 == null) goto L9;
        return new OPopupMenuLongPressedListItemBinding(r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
