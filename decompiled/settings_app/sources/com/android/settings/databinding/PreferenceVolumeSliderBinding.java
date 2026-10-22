package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class PreferenceVolumeSliderBinding implements ViewBinding {
    public final ImageView icon;
    private final FrameLayout rootView;
    public final SeekBar seekbar;
    public final TextView suppressionText;
    public final TextView title;
    public final LinearLayout widgetFrame;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PreferenceVolumeSliderBinding(FrameLayout r1, ImageView r2, SeekBar r3, TextView r4, TextView r5, LinearLayout r6) {
        this.rootView = r1;
        this.icon = r2;
        this.seekbar = r3;
        this.suppressionText = r4;
        this.title = r5;
        this.widgetFrame = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static PreferenceVolumeSliderBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PreferenceVolumeSliderBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.preference_volume_slider, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PreferenceVolumeSliderBinding bind(View r9) {
        int r0 = android.R.id.icon;
        ImageView r4 = (ImageView) ViewBindings.findChildViewById(r9, android.R.id.icon);
        if (r4 == null) goto L15;
        r0 = R.id.seekbar;
        SeekBar r5 = (SeekBar) ViewBindings.findChildViewById(r9, R.id.seekbar);
        if (r5 == null) goto L15;
        r0 = R.id.suppression_text;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r9, R.id.suppression_text);
        if (r6 == null) goto L15;
        r0 = android.R.id.title;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r9, android.R.id.title);
        if (r7 == null) goto L15;
        r0 = android.R.id.widget_frame;
        LinearLayout r8 = (LinearLayout) ViewBindings.findChildViewById(r9, android.R.id.widget_frame);
        if (r8 == null) goto L15;
        return new PreferenceVolumeSliderBinding((FrameLayout) r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
