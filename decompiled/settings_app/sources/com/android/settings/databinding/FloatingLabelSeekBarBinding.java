package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class FloatingLabelSeekBarBinding implements ViewBinding {
    public final LinearLayout labelsContainer;
    public final SeekBar realSeekBar;
    private final View rootView;

    private FloatingLabelSeekBarBinding(View r1, LinearLayout r2, SeekBar r3) {
        this.rootView = r1;
        this.labelsContainer = r2;
        this.realSeekBar = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static FloatingLabelSeekBarBinding inflate(LayoutInflater r1, ViewGroup r2) {
        if (r2 == null) goto L6;
        r1.inflate(R.layout.floating_label_seek_bar, r2);
        return bind(r2);
    L6:
        throw new NullPointerException("parent");
    }

    public static FloatingLabelSeekBarBinding bind(View r3) {
        int r0 = R.id.labels_container;
        LinearLayout r1 = (LinearLayout) ViewBindings.findChildViewById(r3, R.id.labels_container);
        if (r1 == null) goto L9;
        r0 = R.id.real_seek_bar;
        SeekBar r2 = (SeekBar) ViewBindings.findChildViewById(r3, R.id.real_seek_bar);
        if (r2 == null) goto L9;
        return new FloatingLabelSeekBarBinding(r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
