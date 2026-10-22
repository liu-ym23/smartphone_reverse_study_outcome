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
public final class SearchHistoryHeaderBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final OSectionTitleBar searchHistory;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SearchHistoryHeaderBinding(LinearLayout r1, OSectionTitleBar r2) {
        this.rootView = r1;
        this.searchHistory = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SearchHistoryHeaderBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SearchHistoryHeaderBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.search_history_header, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SearchHistoryHeaderBinding bind(View r2) {
        OSectionTitleBar r1 = (OSectionTitleBar) ViewBindings.findChildViewById(r2, R.id.search_history);
        if (r1 == null) goto L7;
        return new SearchHistoryHeaderBinding((LinearLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.search_history)));
    }
}
