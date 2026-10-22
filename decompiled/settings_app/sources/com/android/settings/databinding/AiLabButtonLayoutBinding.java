package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.button.OButton;

/* JADX INFO: loaded from: classes2.dex */
public final class AiLabButtonLayoutBinding implements ViewBinding {
    public final OButton approveButton;
    public final LinearLayout approveButtonLayout;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AiLabButtonLayoutBinding(LinearLayout r1, OButton r2, LinearLayout r3) {
        this.rootView = r1;
        this.approveButton = r2;
        this.approveButtonLayout = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static AiLabButtonLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AiLabButtonLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.ai_lab_button_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AiLabButtonLayoutBinding bind(View r2) {
        OButton r1 = (OButton) ViewBindings.findChildViewById(r2, R.id.approve_button);
        if (r1 == null) goto L7;
        LinearLayout r3 = (LinearLayout) r2;
        return new AiLabButtonLayoutBinding(r3, r1, r3);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.approve_button)));
    }
}
