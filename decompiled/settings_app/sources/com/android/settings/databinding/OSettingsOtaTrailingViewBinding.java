package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class OSettingsOtaTrailingViewBinding implements ViewBinding {
    public final ConstraintLayout constraintLayout6;
    private final ConstraintLayout rootView;
    public final ImageView trailingImage;
    public final ImageView trailingText;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private OSettingsOtaTrailingViewBinding(ConstraintLayout r1, ConstraintLayout r2, ImageView r3, ImageView r4) {
        this.rootView = r1;
        this.constraintLayout6 = r2;
        this.trailingImage = r3;
        this.trailingText = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static OSettingsOtaTrailingViewBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static OSettingsOtaTrailingViewBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.o_settings_ota_trailing_view, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static OSettingsOtaTrailingViewBinding bind(View r4) {
        int r0 = R.id.constraintLayout6;
        ConstraintLayout r1 = (ConstraintLayout) ViewBindings.findChildViewById(r4, R.id.constraintLayout6);
        if (r1 == null) goto L11;
        r0 = R.id.trailingImage;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(r4, R.id.trailingImage);
        if (r2 == null) goto L11;
        r0 = R.id.trailingText;
        ImageView r3 = (ImageView) ViewBindings.findChildViewById(r4, R.id.trailingText);
        if (r3 == null) goto L11;
        return new OSettingsOtaTrailingViewBinding((ConstraintLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
