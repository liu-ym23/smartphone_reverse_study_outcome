package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.button.OButton;
import com.obric.oui.lisitem.OCardListItem;

/* JADX INFO: loaded from: classes2.dex */
public final class ListContentItemSwitchWithIconBinding implements ViewBinding {
    public final FrameLayout btnLayout;
    public final OButton buttonSync;
    public final OCardListItem itemCheck;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ListContentItemSwitchWithIconBinding(LinearLayout r1, FrameLayout r2, OButton r3, OCardListItem r4) {
        this.rootView = r1;
        this.btnLayout = r2;
        this.buttonSync = r3;
        this.itemCheck = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ListContentItemSwitchWithIconBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ListContentItemSwitchWithIconBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.list_content_item_switch_with_icon, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ListContentItemSwitchWithIconBinding bind(View r4) {
        int r0 = R.id.btnLayout;
        FrameLayout r1 = (FrameLayout) ViewBindings.findChildViewById(r4, R.id.btnLayout);
        if (r1 == null) goto L11;
        r0 = R.id.button_sync;
        OButton r2 = (OButton) ViewBindings.findChildViewById(r4, R.id.button_sync);
        if (r2 == null) goto L11;
        r0 = R.id.item_check;
        OCardListItem r3 = (OCardListItem) ViewBindings.findChildViewById(r4, R.id.item_check);
        if (r3 == null) goto L11;
        return new ListContentItemSwitchWithIconBinding((LinearLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
