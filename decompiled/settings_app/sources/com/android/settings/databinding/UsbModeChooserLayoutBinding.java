package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.lisitem.OCardListItem;

/* JADX INFO: loaded from: classes2.dex */
public final class UsbModeChooserLayoutBinding implements ViewBinding {
    public final LinearLayout itemLayout;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    public final OCardListItem powerSource;
    private final RelativeLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private UsbModeChooserLayoutBinding(RelativeLayout r1, LinearLayout r2, LinearLayout r3, OScrollView r4, OCardListItem r5) {
        this.rootView = r1;
        this.itemLayout = r2;
        this.pageContainer = r3;
        this.pageScrollview = r4;
        this.powerSource = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static UsbModeChooserLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static UsbModeChooserLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.usb_mode_chooser_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static UsbModeChooserLayoutBinding bind(View r8) {
        int r0 = R.id.item_layout;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r8, R.id.item_layout);
        if (r4 == null) goto L13;
        r0 = R.id.page_container;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r8, R.id.page_container);
        if (r5 == null) goto L13;
        r0 = R.id.page_scrollview;
        OScrollView r6 = (OScrollView) ViewBindings.findChildViewById(r8, R.id.page_scrollview);
        if (r6 == null) goto L13;
        r0 = R.id.power_source;
        OCardListItem r7 = (OCardListItem) ViewBindings.findChildViewById(r8, R.id.power_source);
        if (r7 == null) goto L13;
        return new UsbModeChooserLayoutBinding((RelativeLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
