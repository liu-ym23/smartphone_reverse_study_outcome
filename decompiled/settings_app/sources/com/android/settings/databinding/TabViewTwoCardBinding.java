package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class TabViewTwoCardBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final LinearLayout topTabContactLayout;
    public final TextView topTabSim1;
    public final TextView topTabSim2;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private TabViewTwoCardBinding(LinearLayout r1, LinearLayout r2, TextView r3, TextView r4) {
        this.rootView = r1;
        this.topTabContactLayout = r2;
        this.topTabSim1 = r3;
        this.topTabSim2 = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TabViewTwoCardBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static TabViewTwoCardBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.tab_view_two_card, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static TabViewTwoCardBinding bind(View r4) {
        LinearLayout r0 = (LinearLayout) r4;
        int r1 = R.id.top_tab_sim1;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r4, R.id.top_tab_sim1);
        if (r2 == null) goto L9;
        r1 = R.id.top_tab_sim2;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r4, R.id.top_tab_sim2);
        if (r3 == null) goto L9;
        return new TabViewTwoCardBinding(r0, r0, r2, r3);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r1)));
    }
}
