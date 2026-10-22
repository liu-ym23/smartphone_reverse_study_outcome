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
public final class HorizontalPreferenceBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView summary;
    public final TextView title;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private HorizontalPreferenceBinding(LinearLayout r1, TextView r2, TextView r3) {
        this.rootView = r1;
        this.summary = r2;
        this.title = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static HorizontalPreferenceBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static HorizontalPreferenceBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.horizontal_preference, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static HorizontalPreferenceBinding bind(View r3) {
        int r0 = android.R.id.summary;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r3, android.R.id.summary);
        if (r1 == null) goto L9;
        r0 = android.R.id.title;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r3, android.R.id.title);
        if (r2 == null) goto L9;
        return new HorizontalPreferenceBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
