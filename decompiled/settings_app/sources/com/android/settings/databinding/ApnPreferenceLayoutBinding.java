package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class ApnPreferenceLayoutBinding implements ViewBinding {
    public final RadioButton apnRadiobutton;
    private final LinearLayout rootView;
    public final TextView summary;
    public final RelativeLayout textLayout;
    public final TextView title;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ApnPreferenceLayoutBinding(LinearLayout r1, RadioButton r2, TextView r3, RelativeLayout r4, TextView r5) {
        this.rootView = r1;
        this.apnRadiobutton = r2;
        this.summary = r3;
        this.textLayout = r4;
        this.title = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ApnPreferenceLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ApnPreferenceLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.apn_preference_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ApnPreferenceLayoutBinding bind(View r8) {
        int r0 = R.id.apn_radiobutton;
        RadioButton r4 = (RadioButton) ViewBindings.findChildViewById(r8, R.id.apn_radiobutton);
        if (r4 == null) goto L13;
        r0 = R.id.summary;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r8, R.id.summary);
        if (r5 == null) goto L13;
        r0 = R.id.text_layout;
        RelativeLayout r6 = (RelativeLayout) ViewBindings.findChildViewById(r8, R.id.text_layout);
        if (r6 == null) goto L13;
        r0 = R.id.title;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r8, R.id.title);
        if (r7 == null) goto L13;
        return new ApnPreferenceLayoutBinding((LinearLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
