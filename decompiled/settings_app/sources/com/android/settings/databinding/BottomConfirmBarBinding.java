package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class BottomConfirmBarBinding implements ViewBinding {
    public final ImageView cancelBtn;
    public final ImageView okBtn;
    private final View rootView;
    public final TextView title;

    private BottomConfirmBarBinding(View r1, ImageView r2, ImageView r3, TextView r4) {
        this.rootView = r1;
        this.cancelBtn = r2;
        this.okBtn = r3;
        this.title = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static BottomConfirmBarBinding inflate(LayoutInflater r1, ViewGroup r2) {
        if (r2 == null) goto L6;
        r1.inflate(R.layout.bottom_confirm_bar, r2);
        return bind(r2);
    L6:
        throw new NullPointerException("parent");
    }

    public static BottomConfirmBarBinding bind(View r4) {
        int r0 = R.id.cancel_btn;
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r4, R.id.cancel_btn);
        if (r1 == null) goto L11;
        r0 = R.id.ok_btn;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(r4, R.id.ok_btn);
        if (r2 == null) goto L11;
        r0 = R.id.title;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r4, R.id.title);
        if (r3 == null) goto L11;
        return new BottomConfirmBarBinding(r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
