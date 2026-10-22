package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class PreferenceIconlessSliderBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final SeekBar seekbar;
    public final TextView title;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PreferenceIconlessSliderBinding(FrameLayout r1, SeekBar r2, TextView r3) {
        this.rootView = r1;
        this.seekbar = r2;
        this.title = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static PreferenceIconlessSliderBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PreferenceIconlessSliderBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.preference_iconless_slider, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PreferenceIconlessSliderBinding bind(View r3) {
        int r0 = R.id.seekbar;
        SeekBar r1 = (SeekBar) ViewBindings.findChildViewById(r3, R.id.seekbar);
        if (r1 == null) goto L9;
        r0 = android.R.id.title;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r3, android.R.id.title);
        if (r2 == null) goto L9;
        return new PreferenceIconlessSliderBinding((FrameLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
