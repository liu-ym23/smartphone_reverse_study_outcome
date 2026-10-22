package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import obric.widget.DividerListView;
import obric.widget.RoundedRectLinearLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class OMenuPopupwindowLayoutBinding implements ViewBinding {
    public final TextView actionText;
    public final RelativeLayout bottomActionBar;
    public final Button leftBtn;
    public final ImageView leftIcon;
    public final DividerListView menuList;
    public final View menuListBottomDivider;
    public final TextView menuTitle;
    public final LinearLayout menuTitleContainer;
    public final Button rightBtn;
    public final ImageView rightIcon;
    private final RoundedRectLinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private OMenuPopupwindowLayoutBinding(RoundedRectLinearLayout r1, TextView r2, RelativeLayout r3, Button r4, ImageView r5, DividerListView r6, View r7, TextView r8, LinearLayout r9, Button r10, ImageView r11) {
        this.rootView = r1;
        this.actionText = r2;
        this.bottomActionBar = r3;
        this.leftBtn = r4;
        this.leftIcon = r5;
        this.menuList = r6;
        this.menuListBottomDivider = r7;
        this.menuTitle = r8;
        this.menuTitleContainer = r9;
        this.rightBtn = r10;
        this.rightIcon = r11;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RoundedRectLinearLayout getRoot() {
        return this.rootView;
    }

    public static OMenuPopupwindowLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static OMenuPopupwindowLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.o_menu_popupwindow_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static OMenuPopupwindowLayoutBinding bind(View r14) {
        int r0 = R.id.action_text;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r14, R.id.action_text);
        if (r4 == null) goto L25;
        r0 = R.id.bottom_action_bar;
        RelativeLayout r5 = (RelativeLayout) ViewBindings.findChildViewById(r14, R.id.bottom_action_bar);
        if (r5 == null) goto L25;
        r0 = R.id.left_btn;
        Button r6 = (Button) ViewBindings.findChildViewById(r14, R.id.left_btn);
        if (r6 == null) goto L25;
        r0 = R.id.left_icon;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r14, R.id.left_icon);
        if (r7 == null) goto L25;
        r0 = R.id.menu_list;
        DividerListView r8 = (DividerListView) ViewBindings.findChildViewById(r14, R.id.menu_list);
        if (r8 == null) goto L25;
        r0 = R.id.menu_list_bottom_divider;
        View r9 = ViewBindings.findChildViewById(r14, R.id.menu_list_bottom_divider);
        if (r9 == null) goto L25;
        r0 = R.id.menu_title;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r14, R.id.menu_title);
        if (r10 == null) goto L25;
        r0 = R.id.menu_title_container;
        LinearLayout r11 = (LinearLayout) ViewBindings.findChildViewById(r14, R.id.menu_title_container);
        if (r11 == null) goto L25;
        r0 = R.id.right_btn;
        Button r12 = (Button) ViewBindings.findChildViewById(r14, R.id.right_btn);
        if (r12 == null) goto L25;
        r0 = R.id.right_icon;
        ImageView r13 = (ImageView) ViewBindings.findChildViewById(r14, R.id.right_icon);
        if (r13 == null) goto L25;
        return new OMenuPopupwindowLayoutBinding((RoundedRectLinearLayout) r14, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    L25:
        throw new NullPointerException("Missing required view with ID: ".concat(r14.getResources().getResourceName(r0)));
    }
}
