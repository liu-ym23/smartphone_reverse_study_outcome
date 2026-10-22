package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class GestureHeaderLayoutBinding implements ViewBinding {
    public final SettingItemText gestureHeaderTitle;
    private final RelativeLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private GestureHeaderLayoutBinding(RelativeLayout r1, SettingItemText r2) {
        this.rootView = r1;
        this.gestureHeaderTitle = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static GestureHeaderLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static GestureHeaderLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.gesture_header_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static GestureHeaderLayoutBinding bind(View r2) {
        SettingItemText r1 = (SettingItemText) ViewBindings.findChildViewById(r2, R.id.gesture_header_title);
        if (r1 == null) goto L7;
        return new GestureHeaderLayoutBinding((RelativeLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.gesture_header_title)));
    }
}
