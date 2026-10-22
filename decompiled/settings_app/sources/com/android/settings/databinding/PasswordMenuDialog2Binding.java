package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OListView;

/* JADX INFO: loaded from: classes2.dex */
public final class PasswordMenuDialog2Binding implements ViewBinding {
    public final OListView contentList;
    public final LinearLayout contentPanel;
    public final LinearLayout rootView;
    private final LinearLayout rootView_;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PasswordMenuDialog2Binding(LinearLayout r1, OListView r2, LinearLayout r3, LinearLayout r4) {
        this.rootView_ = r1;
        this.contentList = r2;
        this.contentPanel = r3;
        this.rootView = r4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView_;
    }

    public static PasswordMenuDialog2Binding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PasswordMenuDialog2Binding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.password_menu_dialog2, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PasswordMenuDialog2Binding bind(View r3) {
        int r0 = R.id.content_list;
        OListView r1 = (OListView) ViewBindings.findChildViewById(r3, R.id.content_list);
        if (r1 == null) goto L9;
        r0 = R.id.contentPanel;
        LinearLayout r2 = (LinearLayout) ViewBindings.findChildViewById(r3, R.id.contentPanel);
        if (r2 == null) goto L9;
        LinearLayout r4 = (LinearLayout) r3;
        return new PasswordMenuDialog2Binding(r4, r1, r2, r4);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
