package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OListView;
import com.obric.oui.dialog.base.DialogRootView;
import com.obric.oui.lisitem.OListItemGeneral;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class PasswordMenuDialogBinding implements ViewBinding {
    public final OListItemGeneral btnOk;
    public final OListView contentList;
    public final LinearLayout contentPanel;
    public final OFloatingTitleBar menuDialogTitleBar;
    public final DialogRootView rootView;
    private final DialogRootView rootView_;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PasswordMenuDialogBinding(DialogRootView r1, OListItemGeneral r2, OListView r3, LinearLayout r4, OFloatingTitleBar r5, DialogRootView r6) {
        this.rootView_ = r1;
        this.btnOk = r2;
        this.contentList = r3;
        this.contentPanel = r4;
        this.menuDialogTitleBar = r5;
        this.rootView = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public DialogRootView getRoot() {
        return this.rootView_;
    }

    public static PasswordMenuDialogBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PasswordMenuDialogBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.password_menu_dialog, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PasswordMenuDialogBinding bind(View r9) {
        int r0 = R.id.btn_ok;
        OListItemGeneral r4 = (OListItemGeneral) ViewBindings.findChildViewById(r9, R.id.btn_ok);
        if (r4 == null) goto L13;
        r0 = R.id.content_list;
        OListView r5 = (OListView) ViewBindings.findChildViewById(r9, R.id.content_list);
        if (r5 == null) goto L13;
        r0 = R.id.contentPanel;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r9, R.id.contentPanel);
        if (r6 == null) goto L13;
        r0 = R.id.menu_dialog_title_bar;
        OFloatingTitleBar r7 = (OFloatingTitleBar) ViewBindings.findChildViewById(r9, R.id.menu_dialog_title_bar);
        if (r7 == null) goto L13;
        DialogRootView r8 = (DialogRootView) r9;
        return new PasswordMenuDialogBinding(r8, r4, r5, r6, r7, r8);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
