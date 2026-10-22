package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class DlgPatternEdittextLayoutBinding implements ViewBinding {
    public final EditText etCustomKey;
    public final TextView etCustomKeyTips;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DlgPatternEdittextLayoutBinding(LinearLayout r1, EditText r2, TextView r3) {
        this.rootView = r1;
        this.etCustomKey = r2;
        this.etCustomKeyTips = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DlgPatternEdittextLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DlgPatternEdittextLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.dlg_pattern_edittext_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DlgPatternEdittextLayoutBinding bind(View r3) {
        int r0 = R.id.et_custom_key;
        EditText r1 = (EditText) ViewBindings.findChildViewById(r3, R.id.et_custom_key);
        if (r1 == null) goto L9;
        r0 = R.id.et_custom_key_tips;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r3, R.id.et_custom_key_tips);
        if (r2 == null) goto L9;
        return new DlgPatternEdittextLayoutBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
