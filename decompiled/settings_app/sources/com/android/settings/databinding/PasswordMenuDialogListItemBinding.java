package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OListItemGeneral;

/* JADX INFO: loaded from: classes2.dex */
public final class PasswordMenuDialogListItemBinding implements ViewBinding {
    public final OListItemGeneral appItem;
    private final FrameLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PasswordMenuDialogListItemBinding(FrameLayout r1, OListItemGeneral r2) {
        this.rootView = r1;
        this.appItem = r2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static PasswordMenuDialogListItemBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PasswordMenuDialogListItemBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.password_menu_dialog_list_item, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PasswordMenuDialogListItemBinding bind(View r2) {
        OListItemGeneral r1 = (OListItemGeneral) ViewBindings.findChildViewById(r2, R.id.app_item);
        if (r1 == null) goto L7;
        return new PasswordMenuDialogListItemBinding((FrameLayout) r2, r1);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r2.getResources().getResourceName(R.id.app_item)));
    }
}
