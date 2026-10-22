package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settingslib.widget.LinkTextView;

/* JADX INFO: loaded from: classes2.dex */
public final class SuwItemLinkDescriptionBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final ImageView suwItemsIcon;
    public final FrameLayout suwItemsIconContainer;
    public final LinkTextView suwItemsSummary;
    public final LinkTextView suwItemsTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SuwItemLinkDescriptionBinding(LinearLayout r1, ImageView r2, FrameLayout r3, LinkTextView r4, LinkTextView r5) {
        this.rootView = r1;
        this.suwItemsIcon = r2;
        this.suwItemsIconContainer = r3;
        this.suwItemsSummary = r4;
        this.suwItemsTitle = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SuwItemLinkDescriptionBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SuwItemLinkDescriptionBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.suw_item_link_description, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SuwItemLinkDescriptionBinding bind(View r8) {
        int r0 = R.id.suw_items_icon;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r8, R.id.suw_items_icon);
        if (r4 == null) goto L13;
        r0 = R.id.suw_items_icon_container;
        FrameLayout r5 = (FrameLayout) ViewBindings.findChildViewById(r8, R.id.suw_items_icon_container);
        if (r5 == null) goto L13;
        r0 = R.id.suw_items_summary;
        LinkTextView r6 = (LinkTextView) ViewBindings.findChildViewById(r8, R.id.suw_items_summary);
        if (r6 == null) goto L13;
        r0 = R.id.suw_items_title;
        LinkTextView r7 = (LinkTextView) ViewBindings.findChildViewById(r8, R.id.suw_items_title);
        if (r7 == null) goto L13;
        return new SuwItemLinkDescriptionBinding((LinearLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
