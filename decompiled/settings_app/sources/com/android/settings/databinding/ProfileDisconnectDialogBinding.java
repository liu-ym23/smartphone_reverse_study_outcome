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
public final class ProfileDisconnectDialogBinding implements ViewBinding {
    public final OTextView desName;
    public final OTextView desName2;
    public final OTextView desTitle;
    public final OTextView descTitle2;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ProfileDisconnectDialogBinding(LinearLayout r1, OTextView r2, OTextView r3, OTextView r4, OTextView r5) {
        this.rootView = r1;
        this.desName = r2;
        this.desName2 = r3;
        this.desTitle = r4;
        this.descTitle2 = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ProfileDisconnectDialogBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ProfileDisconnectDialogBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.profile_disconnect_dialog, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ProfileDisconnectDialogBinding bind(View r8) {
        int r0 = R.id.des_name;
        OTextView r4 = (OTextView) ViewBindings.findChildViewById(r8, R.id.des_name);
        if (r4 == null) goto L13;
        r0 = R.id.des_name2;
        OTextView r5 = (OTextView) ViewBindings.findChildViewById(r8, R.id.des_name2);
        if (r5 == null) goto L13;
        r0 = R.id.des_title;
        OTextView r6 = (OTextView) ViewBindings.findChildViewById(r8, R.id.des_title);
        if (r6 == null) goto L13;
        r0 = R.id.desc_title2;
        OTextView r7 = (OTextView) ViewBindings.findChildViewById(r8, R.id.desc_title2);
        if (r7 == null) goto L13;
        return new ProfileDisconnectDialogBinding((LinearLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
