package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class DataUsageBytesEditorBinding implements ViewBinding {
    public final EditText bytes;
    private final LinearLayout rootView;
    public final Spinner sizeSpinner;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DataUsageBytesEditorBinding(LinearLayout r1, EditText r2, Spinner r3) {
        this.rootView = r1;
        this.bytes = r2;
        this.sizeSpinner = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DataUsageBytesEditorBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DataUsageBytesEditorBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.data_usage_bytes_editor, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DataUsageBytesEditorBinding bind(View r3) {
        int r0 = R.id.bytes;
        EditText r1 = (EditText) ViewBindings.findChildViewById(r3, R.id.bytes);
        if (r1 == null) goto L9;
        r0 = R.id.size_spinner;
        Spinner r2 = (Spinner) ViewBindings.findChildViewById(r3, R.id.size_spinner);
        if (r2 == null) goto L9;
        return new DataUsageBytesEditorBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
