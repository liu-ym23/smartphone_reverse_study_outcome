package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class ScreenPinningInstructionsBinding implements ViewBinding {
    public final LinearLayout instructionsArea;
    private final LinearLayout rootView;
    public final TextView screenPinningDescription;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ScreenPinningInstructionsBinding(LinearLayout r1, LinearLayout r2, TextView r3) {
        this.rootView = r1;
        this.instructionsArea = r2;
        this.screenPinningDescription = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ScreenPinningInstructionsBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ScreenPinningInstructionsBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.screen_pinning_instructions, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ScreenPinningInstructionsBinding bind(View r3) {
        LinearLayout r0 = (LinearLayout) r3;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r3, R.id.screen_pinning_description);
        if (r2 == null) goto L7;
        return new ScreenPinningInstructionsBinding(r0, r0, r2);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(R.id.screen_pinning_description)));
    }
}
