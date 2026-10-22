package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class PortableStorageLayoutBinding implements ViewBinding {
    public final TextView portableStorage;
    private final LinearLayout rootView;
    public final LinearLayout sandiskContent;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PortableStorageLayoutBinding(LinearLayout r1, TextView r2, LinearLayout r3) {
        this.rootView = r1;
        this.portableStorage = r2;
        this.sandiskContent = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PortableStorageLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PortableStorageLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.portable_storage_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PortableStorageLayoutBinding bind(View r3) {
        int r0 = R.id.portable_storage;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r3, R.id.portable_storage);
        if (r1 == null) goto L9;
        r0 = R.id.sandisk_content;
        LinearLayout r2 = (LinearLayout) ViewBindings.findChildViewById(r3, R.id.sandisk_content);
        if (r2 == null) goto L9;
        return new PortableStorageLayoutBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
