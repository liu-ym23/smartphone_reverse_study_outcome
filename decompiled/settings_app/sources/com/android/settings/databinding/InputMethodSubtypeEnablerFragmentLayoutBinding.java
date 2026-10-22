package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class InputMethodSubtypeEnablerFragmentLayoutBinding implements ViewBinding {
    public final LinearLayout imSubtypeContainer;
    public final LinearLayout listContainer;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private InputMethodSubtypeEnablerFragmentLayoutBinding(LinearLayout r1, LinearLayout r2, LinearLayout r3) {
        this.rootView = r1;
        this.imSubtypeContainer = r2;
        this.listContainer = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static InputMethodSubtypeEnablerFragmentLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static InputMethodSubtypeEnablerFragmentLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.input_method_subtype_enabler_fragment_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static InputMethodSubtypeEnablerFragmentLayoutBinding bind(View r2) {
        LinearLayout r1 = (LinearLayout) ViewBindings.findChildViewById(r2, R.id.im_subtype_container);
        if (r1 == null) goto L7;
        LinearLayout r3 = (LinearLayout) r2;
        return new InputMethodSubtypeEnablerFragmentLayoutBinding(r3, r1, r3);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.im_subtype_container)));
    }
}
