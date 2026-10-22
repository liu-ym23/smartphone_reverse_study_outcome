package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class FingerprintRenameDialogBinding implements ViewBinding {
    public final EditText fingerprintRenameField;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private FingerprintRenameDialogBinding(LinearLayout r1, EditText r2) {
        this.rootView = r1;
        this.fingerprintRenameField = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FingerprintRenameDialogBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FingerprintRenameDialogBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.fingerprint_rename_dialog, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static FingerprintRenameDialogBinding bind(View r2) {
        EditText r1 = (EditText) ViewBindings.findChildViewById(r2, R.id.fingerprint_rename_field);
        if (r1 == null) goto L7;
        return new FingerprintRenameDialogBinding((LinearLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.fingerprint_rename_field)));
    }
}
