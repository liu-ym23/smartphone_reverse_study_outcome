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
import obric.widget.ListContentItemCustom;

/* JADX INFO: loaded from: classes2.dex */
public final class SeekbarWithTextBinding implements ViewBinding {
    public final SeekBar idSeekbar;
    public final ListContentItemCustom idSeekbarInLayout;
    public final TextView idSeekbarLeft;
    public final TextView idSeekbarRight;
    public final TextView idSeekbarTitle;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SeekbarWithTextBinding(LinearLayout r1, SeekBar r2, ListContentItemCustom r3, TextView r4, TextView r5, TextView r6) {
        this.rootView = r1;
        this.idSeekbar = r2;
        this.idSeekbarInLayout = r3;
        this.idSeekbarLeft = r4;
        this.idSeekbarRight = r5;
        this.idSeekbarTitle = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SeekbarWithTextBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SeekbarWithTextBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.seekbar_with_text, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SeekbarWithTextBinding bind(View r9) {
        int r0 = R.id.id_seekbar;
        SeekBar r4 = (SeekBar) ViewBindings.findChildViewById(r9, R.id.id_seekbar);
        if (r4 == null) goto L15;
        r0 = R.id.id_seekbar_in_layout;
        ListContentItemCustom r5 = (ListContentItemCustom) ViewBindings.findChildViewById(r9, R.id.id_seekbar_in_layout);
        if (r5 == null) goto L15;
        r0 = R.id.id_seekbar_left;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r9, R.id.id_seekbar_left);
        if (r6 == null) goto L15;
        r0 = R.id.id_seekbar_right;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r9, R.id.id_seekbar_right);
        if (r7 == null) goto L15;
        r0 = R.id.id_seekbar_title;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r9, R.id.id_seekbar_title);
        if (r8 == null) goto L15;
        return new SeekbarWithTextBinding((LinearLayout) r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
