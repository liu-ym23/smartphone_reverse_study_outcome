package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import obric.widget.SwitchEx;

/* JADX INFO: loaded from: classes2.dex */
public final class SearchResultLandLayoutBinding implements ViewBinding {
    public final SwitchEx checkbox;
    public final LinearLayout container;
    public final ImageView icon1;
    public final ImageView icon2;
    private final LinearLayout rootView;
    public final TextView summay1;
    public final TextView summay2;
    public final TextView text1;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SearchResultLandLayoutBinding(LinearLayout r1, SwitchEx r2, LinearLayout r3, ImageView r4, ImageView r5, TextView r6, TextView r7, TextView r8) {
        this.rootView = r1;
        this.checkbox = r2;
        this.container = r3;
        this.icon1 = r4;
        this.icon2 = r5;
        this.summay1 = r6;
        this.summay2 = r7;
        this.text1 = r8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SearchResultLandLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SearchResultLandLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.search_result_land_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SearchResultLandLayoutBinding bind(View r11) {
        int r0 = R.id.checkbox;
        SwitchEx r4 = (SwitchEx) ViewBindings.findChildViewById(r11, R.id.checkbox);
        if (r4 == null) goto L19;
        r0 = R.id.container;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r11, R.id.container);
        if (r5 == null) goto L19;
        r0 = R.id.icon1;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r11, R.id.icon1);
        if (r6 == null) goto L19;
        r0 = R.id.icon2;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r11, R.id.icon2);
        if (r7 == null) goto L19;
        r0 = R.id.summay1;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r11, R.id.summay1);
        if (r8 == null) goto L19;
        r0 = R.id.summay2;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r11, R.id.summay2);
        if (r9 == null) goto L19;
        r0 = R.id.text1;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r11, R.id.text1);
        if (r10 == null) goto L19;
        return new SearchResultLandLayoutBinding((LinearLayout) r11, r4, r5, r6, r7, r8, r9, r10);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }
}
