package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.popover.menu.PopoverMenuLinearLayout;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes2.dex */
public final class DoubaoAssistantItemDisableBinding implements ViewBinding {
    public final PopoverMenuLinearLayout itemDisable;
    public final OUILinearLayout llPopoverContainer;
    private final OUILinearLayout rootView;
    public final OTextView tvPopoverAction;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DoubaoAssistantItemDisableBinding(OUILinearLayout r1, PopoverMenuLinearLayout r2, OUILinearLayout r3, OTextView r4) {
        this.rootView = r1;
        this.itemDisable = r2;
        this.llPopoverContainer = r3;
        this.tvPopoverAction = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public OUILinearLayout getRoot() {
        return this.rootView;
    }

    public static DoubaoAssistantItemDisableBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DoubaoAssistantItemDisableBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.doubao_assistant_item_disable, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DoubaoAssistantItemDisableBinding bind(View r4) {
        int r0 = R.id.item_disable;
        PopoverMenuLinearLayout r1 = (PopoverMenuLinearLayout) ViewBindings.findChildViewById(r4, R.id.item_disable);
        if (r1 == null) goto L10;
        OUILinearLayout r2 = (OUILinearLayout) r4;
        OTextView r3 = (OTextView) ViewBindings.findChildViewById(r4, R.id.tv_popover_action);
        if (r3 != null) goto L7;
        r0 = R.id.tv_popover_action;
        goto L10
    L7:
        return new DoubaoAssistantItemDisableBinding(r2, r1, r2, r3);
    L10:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
