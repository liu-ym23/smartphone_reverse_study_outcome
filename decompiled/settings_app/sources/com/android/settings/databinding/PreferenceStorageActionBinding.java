package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class PreferenceStorageActionBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final ImageView unmount;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PreferenceStorageActionBinding(LinearLayout r1, ImageView r2) {
        this.rootView = r1;
        this.unmount = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PreferenceStorageActionBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PreferenceStorageActionBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.preference_storage_action, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PreferenceStorageActionBinding bind(View r2) {
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r2, R.id.unmount);
        if (r1 == null) goto L7;
        return new PreferenceStorageActionBinding((LinearLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.unmount)));
    }
}
