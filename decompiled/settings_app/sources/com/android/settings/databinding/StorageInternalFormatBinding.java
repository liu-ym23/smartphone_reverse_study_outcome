package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class StorageInternalFormatBinding implements ViewBinding {
    public final TextView body;
    public final Button confirm;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private StorageInternalFormatBinding(LinearLayout r1, TextView r2, Button r3) {
        this.rootView = r1;
        this.body = r2;
        this.confirm = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static StorageInternalFormatBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static StorageInternalFormatBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.storage_internal_format, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static StorageInternalFormatBinding bind(View r3) {
        int r0 = R.id.body;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r3, R.id.body);
        if (r1 == null) goto L9;
        r0 = R.id.confirm;
        Button r2 = (Button) ViewBindings.findChildViewById(r3, R.id.confirm);
        if (r2 == null) goto L9;
        return new StorageInternalFormatBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
