package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OListView;
import com.obric.oui.lisitem.OListItemGeneral;

/* JADX INFO: loaded from: classes2.dex */
public final class PasswordMenuDialogContentBinding implements ViewBinding {
    public final OListItemGeneral btnOk;
    public final OListView contentList;
    public final LinearLayout contentPanel;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PasswordMenuDialogContentBinding(LinearLayout r1, OListItemGeneral r2, OListView r3, LinearLayout r4) {
        this.rootView = r1;
        this.btnOk = r2;
        this.contentList = r3;
        this.contentPanel = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PasswordMenuDialogContentBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PasswordMenuDialogContentBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.password_menu_dialog_content, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PasswordMenuDialogContentBinding bind(View r4) {
        int r0 = R.id.btn_ok;
        OListItemGeneral r1 = (OListItemGeneral) ViewBindings.findChildViewById(r4, R.id.btn_ok);
        if (r1 == null) goto L11;
        r0 = R.id.content_list;
        OListView r2 = (OListView) ViewBindings.findChildViewById(r4, R.id.content_list);
        if (r2 == null) goto L11;
        r0 = R.id.contentPanel;
        LinearLayout r3 = (LinearLayout) ViewBindings.findChildViewById(r4, R.id.contentPanel);
        if (r3 == null) goto L11;
        return new PasswordMenuDialogContentBinding((LinearLayout) r4, r1, r2, r3);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(r0)));
    }
}
