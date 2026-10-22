package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.divider.ODivider;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes2.dex */
public final class PasswordMenuDialogListItem2Binding implements ViewBinding {
    public final OTextView lockType;
    private final RelativeLayout rootView;
    public final ODivider setupDivider;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PasswordMenuDialogListItem2Binding(RelativeLayout r1, OTextView r2, ODivider r3) {
        this.rootView = r1;
        this.lockType = r2;
        this.setupDivider = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static PasswordMenuDialogListItem2Binding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PasswordMenuDialogListItem2Binding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.password_menu_dialog_list_item2, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PasswordMenuDialogListItem2Binding bind(View r3) {
        int r0 = R.id.lock_type;
        OTextView r1 = (OTextView) ViewBindings.findChildViewById(r3, R.id.lock_type);
        if (r1 == null) goto L9;
        r0 = R.id.setup_divider;
        ODivider r2 = (ODivider) ViewBindings.findChildViewById(r3, R.id.setup_divider);
        if (r2 == null) goto L9;
        return new PasswordMenuDialogListItem2Binding((RelativeLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
