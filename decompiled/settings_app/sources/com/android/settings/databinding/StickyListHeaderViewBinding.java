package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class StickyListHeaderViewBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final OSectionTitleBar stickyHeader;
    public final LinearLayout stickyHeaderContainer;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private StickyListHeaderViewBinding(LinearLayout r1, OSectionTitleBar r2, LinearLayout r3) {
        this.rootView = r1;
        this.stickyHeader = r2;
        this.stickyHeaderContainer = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static StickyListHeaderViewBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static StickyListHeaderViewBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.sticky_list_header_view, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static StickyListHeaderViewBinding bind(View r2) {
        OSectionTitleBar r1 = (OSectionTitleBar) ViewBindings.findChildViewById(r2, R.id.sticky_header);
        if (r1 == null) goto L7;
        LinearLayout r3 = (LinearLayout) r2;
        return new StickyListHeaderViewBinding(r3, r1, r3);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.sticky_header)));
    }
}
