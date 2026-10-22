package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OListView;

/* JADX INFO: loaded from: classes2.dex */
public final class OListContentBinding implements ViewBinding {
    public final TextView empty;
    public final OListView list;
    public final FrameLayout listContainer;
    public final LinearLayout progressContainer;
    private final FrameLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private OListContentBinding(FrameLayout r1, TextView r2, OListView r3, FrameLayout r4, LinearLayout r5) {
        this.rootView = r1;
        this.empty = r2;
        this.list = r3;
        this.listContainer = r4;
        this.progressContainer = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static OListContentBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static OListContentBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.o_list_content, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static OListContentBinding bind(View r8) {
        int r0 = android.R.id.empty;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r8, android.R.id.empty);
        if (r4 == null) goto L13;
        r0 = android.R.id.list;
        OListView r5 = (OListView) ViewBindings.findChildViewById(r8, android.R.id.list);
        if (r5 == null) goto L13;
        r0 = R.id.listContainer;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r8, R.id.listContainer);
        if (r6 == null) goto L13;
        r0 = R.id.progressContainer;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r8, R.id.progressContainer);
        if (r7 == null) goto L13;
        return new OListContentBinding((FrameLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
