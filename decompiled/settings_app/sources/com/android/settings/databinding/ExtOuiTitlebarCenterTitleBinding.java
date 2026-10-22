package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes2.dex */
public final class ExtOuiTitlebarCenterTitleBinding implements ViewBinding {
    public final OTextView centerSubTitle;
    public final OTextView centerTitle;
    public final LinearLayout centerTitleContainer;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ExtOuiTitlebarCenterTitleBinding(LinearLayout r1, OTextView r2, OTextView r3, LinearLayout r4) {
        this.rootView = r1;
        this.centerSubTitle = r2;
        this.centerTitle = r3;
        this.centerTitleContainer = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ExtOuiTitlebarCenterTitleBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ExtOuiTitlebarCenterTitleBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.ext_oui_titlebar_center_title, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ExtOuiTitlebarCenterTitleBinding bind(View r3) {
        int r0 = R.id.center_sub_title;
        OTextView r1 = (OTextView) ViewBindings.findChildViewById(r3, R.id.center_sub_title);
        if (r1 == null) goto L9;
        r0 = R.id.center_title;
        OTextView r2 = (OTextView) ViewBindings.findChildViewById(r3, R.id.center_title);
        if (r2 == null) goto L9;
        LinearLayout r4 = (LinearLayout) r3;
        return new ExtOuiTitlebarCenterTitleBinding(r4, r1, r2, r4);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
