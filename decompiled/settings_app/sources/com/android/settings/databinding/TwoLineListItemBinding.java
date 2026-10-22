package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class TwoLineListItemBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final TextView summary;
    public final TextView title;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private TwoLineListItemBinding(RelativeLayout r1, TextView r2, TextView r3) {
        this.rootView = r1;
        this.summary = r2;
        this.title = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static TwoLineListItemBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static TwoLineListItemBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.two_line_list_item, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static TwoLineListItemBinding bind(View r3) {
        int r0 = R.id.summary;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r3, R.id.summary);
        if (r1 == null) goto L9;
        r0 = R.id.title;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r3, R.id.title);
        if (r2 == null) goto L9;
        return new TwoLineListItemBinding((RelativeLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
