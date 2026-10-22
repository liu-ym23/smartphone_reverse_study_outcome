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
public final class HeaderTextLayoutBinding implements ViewBinding {
    public final GroupListItemVerticalGapLayoutBinding emptyHead;
    public final TextView headerText;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private HeaderTextLayoutBinding(LinearLayout r1, GroupListItemVerticalGapLayoutBinding r2, TextView r3) {
        this.rootView = r1;
        this.emptyHead = r2;
        this.headerText = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static HeaderTextLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static HeaderTextLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.header_text_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static HeaderTextLayoutBinding bind(View r3) {
        int r0 = R.id.empty_head;
        View r1 = ViewBindings.findChildViewById(r3, R.id.empty_head);
        if (r1 == null) goto L10;
        GroupListItemVerticalGapLayoutBinding r2 = GroupListItemVerticalGapLayoutBinding.bind(r1);
        TextView r4 = (TextView) ViewBindings.findChildViewById(r3, R.id.header_text);
        if (r4 != null) goto L7;
        r0 = R.id.header_text;
        goto L10
    L7:
        return new HeaderTextLayoutBinding((LinearLayout) r3, r2, r4);
    L10:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
