package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.HorizontalScrollListView;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes2.dex */
public final class Searchview2Binding implements ViewBinding {
    private final RelativeLayout rootView;
    public final RelativeLayout seachresultview;
    public final OTextView searchEmptyView;
    public final HorizontalScrollListView searchListview;
    public final TextView searchviewBg;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private Searchview2Binding(RelativeLayout r1, RelativeLayout r2, OTextView r3, HorizontalScrollListView r4, TextView r5) {
        this.rootView = r1;
        this.seachresultview = r2;
        this.searchEmptyView = r3;
        this.searchListview = r4;
        this.searchviewBg = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static Searchview2Binding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static Searchview2Binding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.searchview2, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static Searchview2Binding bind(View r6) {
        RelativeLayout r2 = (RelativeLayout) r6;
        int r0 = R.id.search_empty_view;
        OTextView r3 = (OTextView) ViewBindings.findChildViewById(r6, R.id.search_empty_view);
        if (r3 == null) goto L11;
        r0 = R.id.search_listview;
        HorizontalScrollListView r4 = (HorizontalScrollListView) ViewBindings.findChildViewById(r6, R.id.search_listview);
        if (r4 == null) goto L11;
        r0 = R.id.searchview_bg;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r6, R.id.searchview_bg);
        if (r5 == null) goto L11;
        return new Searchview2Binding(r2, r2, r3, r4, r5);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r0)));
    }
}
