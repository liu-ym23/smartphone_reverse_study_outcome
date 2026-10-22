package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class DisplayBinding implements ViewBinding {
    public final Spinner fontSize;
    public final TextView preview;
    private final LinearLayout rootView;
    public final Button save;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DisplayBinding(LinearLayout r1, Spinner r2, TextView r3, Button r4) {
        this.rootView = r1;
        this.fontSize = r2;
        this.preview = r3;
        this.save = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DisplayBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DisplayBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.display, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DisplayBinding bind(View r4) {
        int r0 = R.id.fontSize;
        Spinner r1 = (Spinner) ViewBindings.findChildViewById(r4, R.id.fontSize);
        if (r1 == null) goto L11;
        r0 = R.id.preview;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r4, R.id.preview);
        if (r2 == null) goto L11;
        r0 = R.id.save;
        Button r3 = (Button) ViewBindings.findChildViewById(r4, R.id.save);
        if (r3 == null) goto L11;
        return new DisplayBinding((LinearLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
