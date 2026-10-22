package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OListView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class AppDevListLayoutBinding implements ViewBinding {
    public final OListView listView;
    private final RelativeLayout rootView;
    public final TextView viewEmpty;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AppDevListLayoutBinding(RelativeLayout r1, OListView r2, TextView r3, OFloatingTitleBar r4) {
        this.rootView = r1;
        this.listView = r2;
        this.viewEmpty = r3;
        this.viewTitle = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AppDevListLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AppDevListLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.app_dev_list_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AppDevListLayoutBinding bind(View r4) {
        int r0 = R.id.listView;
        OListView r1 = (OListView) ViewBindings.findChildViewById(r4, R.id.listView);
        if (r1 == null) goto L11;
        r0 = R.id.view_empty;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r4, R.id.view_empty);
        if (r2 == null) goto L11;
        r0 = R.id.view_title;
        OFloatingTitleBar r3 = (OFloatingTitleBar) ViewBindings.findChildViewById(r4, R.id.view_title);
        if (r3 == null) goto L11;
        return new AppDevListLayoutBinding((RelativeLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
