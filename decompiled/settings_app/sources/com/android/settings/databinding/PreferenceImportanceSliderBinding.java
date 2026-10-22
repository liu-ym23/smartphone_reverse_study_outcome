package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class PreferenceImportanceSliderBinding implements ViewBinding {
    public final ImageView autoImportance;
    private final LinearLayout rootView;
    public final SeekBar seekbar;
    public final TextView summary;
    public final TextView title;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PreferenceImportanceSliderBinding(LinearLayout r1, ImageView r2, SeekBar r3, TextView r4, TextView r5) {
        this.rootView = r1;
        this.autoImportance = r2;
        this.seekbar = r3;
        this.summary = r4;
        this.title = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PreferenceImportanceSliderBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PreferenceImportanceSliderBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.preference_importance_slider, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PreferenceImportanceSliderBinding bind(View r8) {
        int r0 = R.id.auto_importance;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r8, R.id.auto_importance);
        if (r4 == null) goto L13;
        r0 = R.id.seekbar;
        SeekBar r5 = (SeekBar) ViewBindings.findChildViewById(r8, R.id.seekbar);
        if (r5 == null) goto L13;
        r0 = android.R.id.summary;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r8, android.R.id.summary);
        if (r6 == null) goto L13;
        r0 = android.R.id.title;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r8, android.R.id.title);
        if (r7 == null) goto L13;
        return new PreferenceImportanceSliderBinding((LinearLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
