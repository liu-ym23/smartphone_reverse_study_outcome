package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes2.dex */
public final class LoadingDialogBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final OTextView textBody;
    public final OTextView textTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private LoadingDialogBinding(LinearLayout r1, OTextView r2, OTextView r3) {
        this.rootView = r1;
        this.textBody = r2;
        this.textTitle = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LoadingDialogBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static LoadingDialogBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.loading_dialog, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static LoadingDialogBinding bind(View r3) {
        int r0 = R.id.textBody;
        OTextView r1 = (OTextView) ViewBindings.findChildViewById(r3, R.id.textBody);
        if (r1 == null) goto L9;
        r0 = R.id.textTitle;
        OTextView r2 = (OTextView) ViewBindings.findChildViewById(r3, R.id.textTitle);
        if (r2 == null) goto L9;
        return new LoadingDialogBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
