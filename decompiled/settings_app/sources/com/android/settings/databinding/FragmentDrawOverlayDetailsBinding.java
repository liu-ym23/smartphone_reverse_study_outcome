package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.simplified.ORoundedListItemImage;
import com.obric.oui.simplified.ORoundedListItemSwitch;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class FragmentDrawOverlayDetailsBinding implements ViewBinding {
    public final ORoundedListItemSwitch itemSwitchPermitDrawOverlay;
    public final ORoundedListItemImage itemTextAppName;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private FragmentDrawOverlayDetailsBinding(RelativeLayout r1, ORoundedListItemSwitch r2, ORoundedListItemImage r3, OFloatingTitleBar r4) {
        this.rootView = r1;
        this.itemSwitchPermitDrawOverlay = r2;
        this.itemTextAppName = r3;
        this.viewTitle = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentDrawOverlayDetailsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FragmentDrawOverlayDetailsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.fragment_draw_overlay_details, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static FragmentDrawOverlayDetailsBinding bind(View r4) {
        int r0 = R.id.item_switch_permit_draw_overlay;
        ORoundedListItemSwitch r1 = (ORoundedListItemSwitch) ViewBindings.findChildViewById(r4, R.id.item_switch_permit_draw_overlay);
        if (r1 == null) goto L11;
        r0 = R.id.item_text_app_name;
        ORoundedListItemImage r2 = (ORoundedListItemImage) ViewBindings.findChildViewById(r4, R.id.item_text_app_name);
        if (r2 == null) goto L11;
        r0 = R.id.view_title;
        OFloatingTitleBar r3 = (OFloatingTitleBar) ViewBindings.findChildViewById(r4, R.id.view_title);
        if (r3 == null) goto L11;
        return new FragmentDrawOverlayDetailsBinding((RelativeLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
