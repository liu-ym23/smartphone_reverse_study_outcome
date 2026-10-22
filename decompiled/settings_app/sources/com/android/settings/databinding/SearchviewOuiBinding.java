package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.HorizontalScrollListView;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes2.dex */
public final class SearchviewOuiBinding implements ViewBinding {
    public final LinearLayout emptyView;
    private final RelativeLayout rootView;
    public final RelativeLayout seachresultview;
    public final OTextView searchEmptyView;
    public final HorizontalScrollListView searchListview;
    public final TextView searchviewBg;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SearchviewOuiBinding(RelativeLayout r1, LinearLayout r2, RelativeLayout r3, OTextView r4, HorizontalScrollListView r5, TextView r6) {
        this.rootView = r1;
        this.emptyView = r2;
        this.seachresultview = r3;
        this.searchEmptyView = r4;
        this.searchListview = r5;
        this.searchviewBg = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SearchviewOuiBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SearchviewOuiBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.searchview_oui, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SearchviewOuiBinding bind(View r9) {
        int r0 = R.id.empty_view;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r9, R.id.empty_view);
        if (r4 == null) goto L13;
        RelativeLayout r5 = (RelativeLayout) r9;
        r0 = R.id.search_empty_view;
        OTextView r6 = (OTextView) ViewBindings.findChildViewById(r9, R.id.search_empty_view);
        if (r6 == null) goto L13;
        r0 = R.id.search_listview;
        HorizontalScrollListView r7 = (HorizontalScrollListView) ViewBindings.findChildViewById(r9, R.id.search_listview);
        if (r7 == null) goto L13;
        r0 = R.id.searchview_bg;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r9, R.id.searchview_bg);
        if (r8 == null) goto L13;
        return new SearchviewOuiBinding(r5, r4, r5, r6, r7, r8);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
