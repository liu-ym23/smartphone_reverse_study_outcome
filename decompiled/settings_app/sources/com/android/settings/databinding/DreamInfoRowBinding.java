package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class DreamInfoRowBinding implements ViewBinding {
    public final RadioButton button1;
    public final ImageView button2;
    public final ImageView divider;
    public final ImageView icon;
    private final LinearLayout rootView;
    public final TextView title;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DreamInfoRowBinding(LinearLayout r1, RadioButton r2, ImageView r3, ImageView r4, ImageView r5, TextView r6) {
        this.rootView = r1;
        this.button1 = r2;
        this.button2 = r3;
        this.divider = r4;
        this.icon = r5;
        this.title = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DreamInfoRowBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DreamInfoRowBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.dream_info_row, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DreamInfoRowBinding bind(View r9) {
        int r0 = android.R.id.button1;
        RadioButton r4 = (RadioButton) ViewBindings.findChildViewById(r9, android.R.id.button1);
        if (r4 == null) goto L15;
        r0 = android.R.id.button2;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r9, android.R.id.button2);
        if (r5 == null) goto L15;
        r0 = R.id.divider;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r9, R.id.divider);
        if (r6 == null) goto L15;
        r0 = android.R.id.icon;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r9, android.R.id.icon);
        if (r7 == null) goto L15;
        r0 = android.R.id.title;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r9, android.R.id.title);
        if (r8 == null) goto L15;
        return new DreamInfoRowBinding((LinearLayout) r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
