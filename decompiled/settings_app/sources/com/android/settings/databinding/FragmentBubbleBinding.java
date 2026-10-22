package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class FragmentBubbleBinding implements ViewBinding {
    public final LinearLayout itemAppBubble;
    public final OCardListItem itemBubble;
    public final OCardListItem itemCheckAll;
    public final OCardListItem itemCheckNone;
    public final OCardListItem itemCheckSelected;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private FragmentBubbleBinding(RelativeLayout r1, LinearLayout r2, OCardListItem r3, OCardListItem r4, OCardListItem r5, OCardListItem r6, OFloatingTitleBar r7) {
        this.rootView = r1;
        this.itemAppBubble = r2;
        this.itemBubble = r3;
        this.itemCheckAll = r4;
        this.itemCheckNone = r5;
        this.itemCheckSelected = r6;
        this.viewTitle = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentBubbleBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FragmentBubbleBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.fragment_bubble, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static FragmentBubbleBinding bind(View r10) {
        int r0 = R.id.item_app_bubble;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r10, R.id.item_app_bubble);
        if (r4 == null) goto L17;
        r0 = R.id.item_bubble;
        OCardListItem r5 = (OCardListItem) ViewBindings.findChildViewById(r10, R.id.item_bubble);
        if (r5 == null) goto L17;
        r0 = R.id.item_check_all;
        OCardListItem r6 = (OCardListItem) ViewBindings.findChildViewById(r10, R.id.item_check_all);
        if (r6 == null) goto L17;
        r0 = R.id.item_check_none;
        OCardListItem r7 = (OCardListItem) ViewBindings.findChildViewById(r10, R.id.item_check_none);
        if (r7 == null) goto L17;
        r0 = R.id.item_check_selected;
        OCardListItem r8 = (OCardListItem) ViewBindings.findChildViewById(r10, R.id.item_check_selected);
        if (r8 == null) goto L17;
        r0 = R.id.view_title;
        OFloatingTitleBar r9 = (OFloatingTitleBar) ViewBindings.findChildViewById(r10, R.id.view_title);
        if (r9 == null) goto L17;
        return new FragmentBubbleBinding((RelativeLayout) r10, r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
