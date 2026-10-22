package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.DotsPageIndicator;
import com.android.settings.widget.LabeledSeekBar;
import com.obric.oui.bouncelayout.OScrollView;

/* JADX INFO: loaded from: classes2.dex */
public final class FontSizeActivityBinding implements ViewBinding {
    public final TextView currentLabel;
    public final ImageView larger;
    public final DotsPageIndicator pageIndicator;
    private final OScrollView rootView;
    public final LabeledSeekBar seekBar;
    public final ImageView smaller;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private FontSizeActivityBinding(OScrollView r1, TextView r2, ImageView r3, DotsPageIndicator r4, LabeledSeekBar r5, ImageView r6) {
        this.rootView = r1;
        this.currentLabel = r2;
        this.larger = r3;
        this.pageIndicator = r4;
        this.seekBar = r5;
        this.smaller = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public OScrollView getRoot() {
        return this.rootView;
    }

    public static FontSizeActivityBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FontSizeActivityBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.font_size_activity, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static FontSizeActivityBinding bind(View r9) {
        int r0 = R.id.current_label;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r9, R.id.current_label);
        if (r4 == null) goto L15;
        r0 = R.id.larger;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r9, R.id.larger);
        if (r5 == null) goto L15;
        r0 = R.id.page_indicator;
        DotsPageIndicator r6 = (DotsPageIndicator) ViewBindings.findChildViewById(r9, R.id.page_indicator);
        if (r6 == null) goto L15;
        r0 = R.id.seek_bar;
        LabeledSeekBar r7 = (LabeledSeekBar) ViewBindings.findChildViewById(r9, R.id.seek_bar);
        if (r7 == null) goto L15;
        r0 = R.id.smaller;
        ImageView r8 = (ImageView) ViewBindings.findChildViewById(r9, R.id.smaller);
        if (r8 == null) goto L15;
        return new FontSizeActivityBinding((OScrollView) r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
