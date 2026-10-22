package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OCardListItem;

/* JADX INFO: loaded from: classes2.dex */
public final class SoftapControllerFragmentBinding implements ViewBinding {
    public final ItemSubSettingsPaddingLayout2Binding layoutGapBottom;
    public final ItemSubSettingsPaddingLayout2Binding layoutGapTop;
    public final OCardListItem listItemContainer;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SoftapControllerFragmentBinding(LinearLayout r1, ItemSubSettingsPaddingLayout2Binding r2, ItemSubSettingsPaddingLayout2Binding r3, OCardListItem r4) {
        this.rootView = r1;
        this.layoutGapBottom = r2;
        this.layoutGapTop = r3;
        this.listItemContainer = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SoftapControllerFragmentBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SoftapControllerFragmentBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.softap_controller_fragment, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SoftapControllerFragmentBinding bind(View r4) {
        int r0 = R.id.layout_gap_bottom;
        View r1 = ViewBindings.findChildViewById(r4, R.id.layout_gap_bottom);
        if (r1 == null) goto L13;
        ItemSubSettingsPaddingLayout2Binding r2 = ItemSubSettingsPaddingLayout2Binding.bind(r1);
        View r3 = ViewBindings.findChildViewById(r4, R.id.layout_gap_top);
        if (r3 == null) goto L11;
        ItemSubSettingsPaddingLayout2Binding r5 = ItemSubSettingsPaddingLayout2Binding.bind(r3);
        OCardListItem r6 = (OCardListItem) ViewBindings.findChildViewById(r4, R.id.list_item_container);
        if (r6 != null) goto L9;
        r0 = R.id.list_item_container;
        goto L13
    L9:
        return new SoftapControllerFragmentBinding((LinearLayout) r4, r2, r5, r6);
    L11:
        r0 = R.id.layout_gap_top;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
