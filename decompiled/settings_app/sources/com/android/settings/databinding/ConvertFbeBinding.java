package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class ConvertFbeBinding implements ViewBinding {
    public final Button buttonConvertFbe;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ConvertFbeBinding(LinearLayout r1, Button r2) {
        this.rootView = r1;
        this.buttonConvertFbe = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ConvertFbeBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ConvertFbeBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.convert_fbe, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ConvertFbeBinding bind(View r2) {
        Button r1 = (Button) ViewBindings.findChildViewById(r2, R.id.button_convert_fbe);
        if (r1 == null) goto L7;
        return new ConvertFbeBinding((LinearLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.button_convert_fbe)));
    }
}
