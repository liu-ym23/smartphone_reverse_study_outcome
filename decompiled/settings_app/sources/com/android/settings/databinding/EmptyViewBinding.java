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
public final class EmptyViewBinding implements ViewBinding {
    public final TextView emptySummary;
    public final TextView emptyTitle;
    public final RelativeLayout preferredEmpty;
    private final RelativeLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private EmptyViewBinding(RelativeLayout r1, TextView r2, TextView r3, RelativeLayout r4) {
        this.rootView = r1;
        this.emptySummary = r2;
        this.emptyTitle = r3;
        this.preferredEmpty = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static EmptyViewBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static EmptyViewBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.empty_view, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static EmptyViewBinding bind(View r3) {
        int r0 = R.id.empty_summary;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r3, R.id.empty_summary);
        if (r1 == null) goto L9;
        r0 = R.id.empty_title;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r3, R.id.empty_title);
        if (r2 == null) goto L9;
        RelativeLayout r4 = (RelativeLayout) r3;
        return new EmptyViewBinding(r4, r1, r2, r4);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
