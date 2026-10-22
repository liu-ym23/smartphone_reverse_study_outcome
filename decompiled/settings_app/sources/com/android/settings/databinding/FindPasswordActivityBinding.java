package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class FindPasswordActivityBinding implements ViewBinding {
    public final EditText answer;
    public final ImageView iconWrongWarning;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    public final TextView question;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private FindPasswordActivityBinding(RelativeLayout r1, EditText r2, ImageView r3, LinearLayout r4, OScrollView r5, TextView r6, OFloatingTitleBar r7) {
        this.rootView = r1;
        this.answer = r2;
        this.iconWrongWarning = r3;
        this.pageContainer = r4;
        this.pageScrollview = r5;
        this.question = r6;
        this.viewTitle = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FindPasswordActivityBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FindPasswordActivityBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.find_password_activity, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static FindPasswordActivityBinding bind(View r10) {
        int r0 = R.id.answer;
        EditText r4 = (EditText) ViewBindings.findChildViewById(r10, R.id.answer);
        if (r4 == null) goto L17;
        r0 = R.id.icon_wrong_warning;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r10, R.id.icon_wrong_warning);
        if (r5 == null) goto L17;
        r0 = R.id.page_container;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r10, R.id.page_container);
        if (r6 == null) goto L17;
        r0 = R.id.page_scrollview;
        OScrollView r7 = (OScrollView) ViewBindings.findChildViewById(r10, R.id.page_scrollview);
        if (r7 == null) goto L17;
        r0 = R.id.question;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r10, R.id.question);
        if (r8 == null) goto L17;
        r0 = R.id.view_title;
        OFloatingTitleBar r9 = (OFloatingTitleBar) ViewBindings.findChildViewById(r10, R.id.view_title);
        if (r9 == null) goto L17;
        return new FindPasswordActivityBinding((RelativeLayout) r10, r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
