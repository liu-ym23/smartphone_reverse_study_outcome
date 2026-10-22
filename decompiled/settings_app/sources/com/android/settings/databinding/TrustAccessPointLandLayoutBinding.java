package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import obric.widget.ListContentItemCustom;
import obric.widget.SwitchEx;

/* JADX INFO: loaded from: classes2.dex */
public final class TrustAccessPointLandLayoutBinding implements ViewBinding {
    public final TextView currentlyConnectedText;
    public final ImageView itemRemoveView;
    public final SwitchEx itemSwitch;
    public final ListContentItemCustom listItemContainer;
    public final LinearLayout removeLayout;
    private final LinearLayout rootView;
    public final TextView summary;
    public final TextView title;
    public final RelativeLayout titleLayout;
    public final LinearLayout titleLayoutWifi;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private TrustAccessPointLandLayoutBinding(LinearLayout r1, TextView r2, ImageView r3, SwitchEx r4, ListContentItemCustom r5, LinearLayout r6, TextView r7, TextView r8, RelativeLayout r9, LinearLayout r10) {
        this.rootView = r1;
        this.currentlyConnectedText = r2;
        this.itemRemoveView = r3;
        this.itemSwitch = r4;
        this.listItemContainer = r5;
        this.removeLayout = r6;
        this.summary = r7;
        this.title = r8;
        this.titleLayout = r9;
        this.titleLayoutWifi = r10;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TrustAccessPointLandLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static TrustAccessPointLandLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.trust_access_point_land_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static TrustAccessPointLandLayoutBinding bind(View r13) {
        int r0 = R.id.currently_connected_text;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r13, R.id.currently_connected_text);
        if (r4 == null) goto L23;
        r0 = R.id.item_remove_view;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r13, R.id.item_remove_view);
        if (r5 == null) goto L23;
        r0 = R.id.item_switch;
        SwitchEx r6 = (SwitchEx) ViewBindings.findChildViewById(r13, R.id.item_switch);
        if (r6 == null) goto L23;
        r0 = R.id.list_item_container;
        ListContentItemCustom r7 = (ListContentItemCustom) ViewBindings.findChildViewById(r13, R.id.list_item_container);
        if (r7 == null) goto L23;
        r0 = R.id.remove_layout;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r13, R.id.remove_layout);
        if (r8 == null) goto L23;
        r0 = android.R.id.summary;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r13, android.R.id.summary);
        if (r9 == null) goto L23;
        r0 = android.R.id.title;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r13, android.R.id.title);
        if (r10 == null) goto L23;
        r0 = R.id.title_layout;
        RelativeLayout r11 = (RelativeLayout) ViewBindings.findChildViewById(r13, R.id.title_layout);
        if (r11 == null) goto L23;
        r0 = R.id.title_layout_wifi;
        LinearLayout r12 = (LinearLayout) ViewBindings.findChildViewById(r13, R.id.title_layout_wifi);
        if (r12 == null) goto L23;
        return new TrustAccessPointLandLayoutBinding((LinearLayout) r13, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r0)));
    }
}
