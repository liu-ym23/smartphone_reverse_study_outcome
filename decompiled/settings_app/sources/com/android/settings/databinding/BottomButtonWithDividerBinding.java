package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.button.OButton;
import com.obric.oui.divider.ODivider;

/* JADX INFO: loaded from: classes2.dex */
public final class BottomButtonWithDividerBinding implements ViewBinding {
    public final RelativeLayout bottomActionBar;
    public final OButton bottomButton;
    public final LinearLayout bottomButtonContainer;
    public final ODivider listViewDivider;
    private final RelativeLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private BottomButtonWithDividerBinding(RelativeLayout r1, RelativeLayout r2, OButton r3, LinearLayout r4, ODivider r5) {
        this.rootView = r1;
        this.bottomActionBar = r2;
        this.bottomButton = r3;
        this.bottomButtonContainer = r4;
        this.listViewDivider = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BottomButtonWithDividerBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static BottomButtonWithDividerBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.bottom_button_with_divider, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static BottomButtonWithDividerBinding bind(View r6) {
        RelativeLayout r2 = (RelativeLayout) r6;
        int r0 = R.id.bottom_button;
        OButton r3 = (OButton) ViewBindings.findChildViewById(r6, R.id.bottom_button);
        if (r3 == null) goto L11;
        r0 = R.id.bottom_button_container;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r6, R.id.bottom_button_container);
        if (r4 == null) goto L11;
        r0 = R.id.list_view_divider;
        ODivider r5 = (ODivider) ViewBindings.findChildViewById(r6, R.id.list_view_divider);
        if (r5 == null) goto L11;
        return new BottomButtonWithDividerBinding(r2, r2, r3, r4, r5);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r0)));
    }
}
