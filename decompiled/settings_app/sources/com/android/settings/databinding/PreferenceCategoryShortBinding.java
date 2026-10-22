package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class PreferenceCategoryShortBinding implements ViewBinding {
    private final TextView rootView;
    public final TextView title;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PreferenceCategoryShortBinding(TextView r1, TextView r2) {
        this.rootView = r1;
        this.title = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public TextView getRoot() {
        return this.rootView;
    }

    public static PreferenceCategoryShortBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PreferenceCategoryShortBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.preference_category_short, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PreferenceCategoryShortBinding bind(View r1) {
        if (r1 == null) goto L6;
        TextView r2 = (TextView) r1;
        return new PreferenceCategoryShortBinding(r2, r2);
    L6:
        throw new NullPointerException("rootView");
    }
}
