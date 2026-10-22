package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class FragmentFakeManageAssistBinding implements ViewBinding {
    public final OCardListItem itemAccessScreen;
    public final OCardListItem itemChoose;
    public final OCardListItem itemFlashScreen;
    public final OCardListItem itemScreenshot;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private FragmentFakeManageAssistBinding(RelativeLayout r1, OCardListItem r2, OCardListItem r3, OCardListItem r4, OCardListItem r5, OFloatingTitleBar r6) {
        this.rootView = r1;
        this.itemAccessScreen = r2;
        this.itemChoose = r3;
        this.itemFlashScreen = r4;
        this.itemScreenshot = r5;
        this.viewTitle = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static FragmentFakeManageAssistBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static FragmentFakeManageAssistBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.fragment_fake_manage_assist, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static FragmentFakeManageAssistBinding bind(View r9) {
        int r0 = R.id.itemAccessScreen;
        OCardListItem r4 = (OCardListItem) ViewBindings.findChildViewById(r9, R.id.itemAccessScreen);
        if (r4 == null) goto L15;
        r0 = R.id.itemChoose;
        OCardListItem r5 = (OCardListItem) ViewBindings.findChildViewById(r9, R.id.itemChoose);
        if (r5 == null) goto L15;
        r0 = R.id.itemFlashScreen;
        OCardListItem r6 = (OCardListItem) ViewBindings.findChildViewById(r9, R.id.itemFlashScreen);
        if (r6 == null) goto L15;
        r0 = R.id.itemScreenshot;
        OCardListItem r7 = (OCardListItem) ViewBindings.findChildViewById(r9, R.id.itemScreenshot);
        if (r7 == null) goto L15;
        r0 = R.id.view_title;
        OFloatingTitleBar r8 = (OFloatingTitleBar) ViewBindings.findChildViewById(r9, R.id.view_title);
        if (r8 == null) goto L15;
        return new FragmentFakeManageAssistBinding((RelativeLayout) r9, r4, r5, r6, r7, r8);
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r9.getResources().getResourceName(r0)));
    }
}
