package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class SearchResultLayoutBinding implements ViewBinding {
    public final OCardListItem item;
    private final RelativeLayout rootView;
    public final OSectionTitleBar title;
    public final OSectionTitleBar titleWithGap;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SearchResultLayoutBinding(RelativeLayout r1, OCardListItem r2, OSectionTitleBar r3, OSectionTitleBar r4) {
        this.rootView = r1;
        this.item = r2;
        this.title = r3;
        this.titleWithGap = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SearchResultLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SearchResultLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.search_result_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SearchResultLayoutBinding bind(View r4) {
        int r0 = R.id.item;
        OCardListItem r1 = (OCardListItem) ViewBindings.findChildViewById(r4, R.id.item);
        if (r1 == null) goto L11;
        r0 = R.id.title;
        OSectionTitleBar r2 = (OSectionTitleBar) ViewBindings.findChildViewById(r4, R.id.title);
        if (r2 == null) goto L11;
        r0 = R.id.title_with_gap;
        OSectionTitleBar r3 = (OSectionTitleBar) ViewBindings.findChildViewById(r4, R.id.title_with_gap);
        if (r3 == null) goto L11;
        return new SearchResultLayoutBinding((RelativeLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
