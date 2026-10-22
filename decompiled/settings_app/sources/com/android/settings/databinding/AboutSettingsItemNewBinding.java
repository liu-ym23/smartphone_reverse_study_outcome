package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes2.dex */
public final class AboutSettingsItemNewBinding implements ViewBinding {
    public final ImageView endIcon;
    public final OTextView nameTv;
    private final LinearLayout rootView;
    public final OTextView valueTv;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AboutSettingsItemNewBinding(LinearLayout r1, ImageView r2, OTextView r3, OTextView r4) {
        this.rootView = r1;
        this.endIcon = r2;
        this.nameTv = r3;
        this.valueTv = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AboutSettingsItemNewBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AboutSettingsItemNewBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.about_settings_item_new, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AboutSettingsItemNewBinding bind(View r4) {
        int r0 = R.id.end_icon;
        ImageView r1 = (ImageView) ViewBindings.findChildViewById(r4, R.id.end_icon);
        if (r1 == null) goto L11;
        r0 = R.id.name_tv;
        OTextView r2 = (OTextView) ViewBindings.findChildViewById(r4, R.id.name_tv);
        if (r2 == null) goto L11;
        r0 = R.id.value_tv;
        OTextView r3 = (OTextView) ViewBindings.findChildViewById(r4, R.id.value_tv);
        if (r3 == null) goto L11;
        return new AboutSettingsItemNewBinding((LinearLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
