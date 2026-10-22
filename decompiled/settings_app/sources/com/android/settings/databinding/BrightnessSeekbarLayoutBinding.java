package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class BrightnessSeekbarLayoutBinding implements ViewBinding {
    public final ImageView brightnessIconMax;
    public final ImageView brightnessIconMin;
    public final SeekBar brightnessSeekbar;
    private final View rootView;

    private BrightnessSeekbarLayoutBinding(View r1, ImageView r2, ImageView r3, SeekBar r4) {
        this.rootView = r1;
        this.brightnessIconMax = r2;
        this.brightnessIconMin = r3;
        this.brightnessSeekbar = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static BrightnessSeekbarLayoutBinding inflate(LayoutInflater r1, ViewGroup r2) {
        if (r2 == null) goto L6;
        r1.inflate(R.layout.brightness_seekbar_layout, r2);
        return bind(r2);
    L6:
        throw new NullPointerException("parent");
    }

    public static BrightnessSeekbarLayoutBinding bind(View r4) {
        int r0 = R.id.brightness_icon_max;
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r4, R.id.brightness_icon_max);
        if (r1 == null) goto L11;
        r0 = R.id.brightness_icon_min;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(r4, R.id.brightness_icon_min);
        if (r2 == null) goto L11;
        r0 = R.id.brightness_seekbar;
        SeekBar r3 = (SeekBar) ViewBindings.findChildViewById(r4, R.id.brightness_seekbar);
        if (r3 == null) goto L11;
        return new BrightnessSeekbarLayoutBinding(r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
