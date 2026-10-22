package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.CheckableLinearLayout;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class RestrictedRadioWithSummaryBinding implements ViewBinding {
    public final ImageView restrictedIcon;
    private final CheckableLinearLayout rootView;
    public final TextView summary;
    public final CheckedTextView title;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RestrictedRadioWithSummaryBinding(CheckableLinearLayout r1, ImageView r2, TextView r3, CheckedTextView r4) {
        this.rootView = r1;
        this.restrictedIcon = r2;
        this.summary = r3;
        this.title = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CheckableLinearLayout getRoot() {
        return this.rootView;
    }

    public static RestrictedRadioWithSummaryBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static RestrictedRadioWithSummaryBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.restricted_radio_with_summary, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static RestrictedRadioWithSummaryBinding bind(View r4) {
        int r0 = R.id.restricted_icon;
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r4, R.id.restricted_icon);
        if (r1 == null) goto L11;
        r0 = android.R.id.summary;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r4, android.R.id.summary);
        if (r2 == null) goto L11;
        r0 = android.R.id.title;
        CheckedTextView r3 = (CheckedTextView) ViewBindings.findChildViewById(r4, android.R.id.title);
        if (r3 == null) goto L11;
        return new RestrictedRadioWithSummaryBinding((CheckableLinearLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
