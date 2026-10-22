package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class OPopupMenuStandardListItemBinding implements ViewBinding {
    public final ImageView menuIcon;
    public final ImageView menuSelected;
    public final TextView menuTitle;
    private final RelativeLayout rootView;
    public final TextView subtitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private OPopupMenuStandardListItemBinding(RelativeLayout r1, ImageView r2, ImageView r3, TextView r4, TextView r5) {
        this.rootView = r1;
        this.menuIcon = r2;
        this.menuSelected = r3;
        this.menuTitle = r4;
        this.subtitle = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static OPopupMenuStandardListItemBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static OPopupMenuStandardListItemBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.o_popup_menu_standard_list_item, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static OPopupMenuStandardListItemBinding bind(View r8) {
        int r0 = R.id.menu_icon;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r8, R.id.menu_icon);
        if (r4 == null) goto L13;
        r0 = R.id.menu_selected;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r8, R.id.menu_selected);
        if (r5 == null) goto L13;
        r0 = R.id.menu_title;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r8, R.id.menu_title);
        if (r6 == null) goto L13;
        r0 = R.id.subtitle;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r8, R.id.subtitle);
        if (r7 == null) goto L13;
        return new OPopupMenuStandardListItemBinding((RelativeLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
