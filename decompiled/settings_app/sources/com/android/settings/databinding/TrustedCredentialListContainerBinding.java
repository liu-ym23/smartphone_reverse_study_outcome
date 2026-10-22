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
import com.obric.oui.bouncelayout.OListView;

/* JADX INFO: loaded from: classes2.dex */
public final class TrustedCredentialListContainerBinding implements ViewBinding {
    public final OListView certList;
    public final ImageView groupIndicator;
    public final FrameLayout headerContentContainer;
    public final View headerDivider;
    public final LinearLayout headerView;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private TrustedCredentialListContainerBinding(LinearLayout r1, OListView r2, ImageView r3, FrameLayout r4, View r5, LinearLayout r6) {
        this.rootView = r1;
        this.certList = r2;
        this.groupIndicator = r3;
        this.headerContentContainer = r4;
        this.headerDivider = r5;
        this.headerView = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TrustedCredentialListContainerBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static TrustedCredentialListContainerBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.trusted_credential_list_container, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static TrustedCredentialListContainerBinding bind(View r9) {
        int r0 = R.id.cert_list;
        OListView r4 = (OListView) ViewBindings.findChildViewById(r9, R.id.cert_list);
        if (r4 == null) goto L15;
        r0 = R.id.group_indicator;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r9, R.id.group_indicator);
        if (r5 == null) goto L15;
        r0 = R.id.header_content_container;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r9, R.id.header_content_container);
        if (r6 == null) goto L15;
        r0 = R.id.header_divider;
        View r7 = ViewBindings.findChildViewById(r9, R.id.header_divider);
        if (r7 == null) goto L15;
        r0 = R.id.header_view;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r9, R.id.header_view);
        if (r8 == null) goto L15;
        return new TrustedCredentialListContainerBinding((LinearLayout) r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
