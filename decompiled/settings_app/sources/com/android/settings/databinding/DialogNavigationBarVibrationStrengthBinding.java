package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class DialogNavigationBarVibrationStrengthBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final SeekBar vibrationDurationSeekBar;
    public final TextView vibrationDurationTitle;
    public final SeekBar vibrationStrengthSeekBar;
    public final TextView vibrationStrengthTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DialogNavigationBarVibrationStrengthBinding(LinearLayout r1, SeekBar r2, TextView r3, SeekBar r4, TextView r5) {
        this.rootView = r1;
        this.vibrationDurationSeekBar = r2;
        this.vibrationDurationTitle = r3;
        this.vibrationStrengthSeekBar = r4;
        this.vibrationStrengthTitle = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogNavigationBarVibrationStrengthBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DialogNavigationBarVibrationStrengthBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.dialog_navigation_bar_vibration_strength, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DialogNavigationBarVibrationStrengthBinding bind(View r8) {
        int r0 = R.id.vibration_duration_seek_bar;
        SeekBar r4 = (SeekBar) ViewBindings.findChildViewById(r8, R.id.vibration_duration_seek_bar);
        if (r4 == null) goto L13;
        r0 = R.id.vibration_duration_title;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r8, R.id.vibration_duration_title);
        if (r5 == null) goto L13;
        r0 = R.id.vibration_strength_seek_bar;
        SeekBar r6 = (SeekBar) ViewBindings.findChildViewById(r8, R.id.vibration_strength_seek_bar);
        if (r6 == null) goto L13;
        r0 = R.id.vibration_strength_title;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r8, R.id.vibration_strength_title);
        if (r7 == null) goto L13;
        return new DialogNavigationBarVibrationStrengthBinding((LinearLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
