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
public final class OPopupMenuRemovableListItemBinding implements ViewBinding {
    public final FrameLayout menuClosed;
    public final ImageView menuIcon;
    public final TextView menuTitle;
    private final RelativeLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private OPopupMenuRemovableListItemBinding(RelativeLayout r1, FrameLayout r2, ImageView r3, TextView r4) {
        this.rootView = r1;
        this.menuClosed = r2;
        this.menuIcon = r3;
        this.menuTitle = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static OPopupMenuRemovableListItemBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static OPopupMenuRemovableListItemBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.o_popup_menu_removable_list_item, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static OPopupMenuRemovableListItemBinding bind(View r4) {
        int r0 = R.id.menu_closed;
        FrameLayout r1 = (FrameLayout) ViewBindings.findChildViewById(r4, R.id.menu_closed);
        if (r1 == null) goto L11;
        r0 = R.id.menu_icon;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(r4, R.id.menu_icon);
        if (r2 == null) goto L11;
        r0 = R.id.menu_title;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r4, R.id.menu_title);
        if (r3 == null) goto L11;
        return new OPopupMenuRemovableListItemBinding((RelativeLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
