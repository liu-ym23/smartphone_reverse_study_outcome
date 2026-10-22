package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;

/* JADX INFO: loaded from: classes2.dex */
public final class DialogPrivacyPolicyBinding implements ViewBinding {
    public final LinearLayout contentPanel;
    public final TextView message;
    public final CheckBox nextShow;
    private final LinearLayout rootView;
    public final OScrollView scrollView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DialogPrivacyPolicyBinding(LinearLayout r1, LinearLayout r2, TextView r3, CheckBox r4, OScrollView r5) {
        this.rootView = r1;
        this.contentPanel = r2;
        this.message = r3;
        this.nextShow = r4;
        this.scrollView = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DialogPrivacyPolicyBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DialogPrivacyPolicyBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.dialog_privacy_policy, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DialogPrivacyPolicyBinding bind(View r6) {
        LinearLayout r2 = (LinearLayout) r6;
        int r0 = R.id.message;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r6, R.id.message);
        if (r3 == null) goto L11;
        r0 = R.id.next_show;
        CheckBox r4 = (CheckBox) ViewBindings.findChildViewById(r6, R.id.next_show);
        if (r4 == null) goto L11;
        r0 = R.id.scrollView;
        OScrollView r5 = (OScrollView) ViewBindings.findChildViewById(r6, R.id.scrollView);
        if (r5 == null) goto L11;
        return new DialogPrivacyPolicyBinding(r2, r2, r3, r4, r5);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r0)));
    }
}
