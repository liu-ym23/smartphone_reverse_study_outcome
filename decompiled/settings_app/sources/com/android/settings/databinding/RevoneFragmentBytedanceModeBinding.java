package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.ListContentItemCheck;

/* JADX INFO: loaded from: classes2.dex */
public final class RevoneFragmentBytedanceModeBinding implements ViewBinding {
    public final ListContentItemCheck mirrorModeCheck;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final ListContentItemCheck tntModeCheck;
    public final ListContentItemCheck tntShareModeCheck;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RevoneFragmentBytedanceModeBinding(RelativeLayout r1, ListContentItemCheck r2, LinearLayout r3, OScrollView r4, ListContentItemCheck r5, ListContentItemCheck r6, OFloatingTitleBar r7) {
        this.rootView = r1;
        this.mirrorModeCheck = r2;
        this.pageContainer = r3;
        this.pageScrollview = r4;
        this.tntModeCheck = r5;
        this.tntShareModeCheck = r6;
        this.viewTitle = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static RevoneFragmentBytedanceModeBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static RevoneFragmentBytedanceModeBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.revone_fragment_bytedance_mode, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static RevoneFragmentBytedanceModeBinding bind(View r10) {
        int r0 = R.id.mirror_mode_check;
        ListContentItemCheck r4 = (ListContentItemCheck) ViewBindings.findChildViewById(r10, R.id.mirror_mode_check);
        if (r4 == null) goto L17;
        r0 = R.id.page_container;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r10, R.id.page_container);
        if (r5 == null) goto L17;
        r0 = R.id.page_scrollview;
        OScrollView r6 = (OScrollView) ViewBindings.findChildViewById(r10, R.id.page_scrollview);
        if (r6 == null) goto L17;
        r0 = R.id.tnt_mode_check;
        ListContentItemCheck r7 = (ListContentItemCheck) ViewBindings.findChildViewById(r10, R.id.tnt_mode_check);
        if (r7 == null) goto L17;
        r0 = R.id.tnt_share_mode_check;
        ListContentItemCheck r8 = (ListContentItemCheck) ViewBindings.findChildViewById(r10, R.id.tnt_share_mode_check);
        if (r8 == null) goto L17;
        r0 = R.id.view_title;
        OFloatingTitleBar r9 = (OFloatingTitleBar) ViewBindings.findChildViewById(r10, R.id.view_title);
        if (r9 == null) goto L17;
        return new RevoneFragmentBytedanceModeBinding((RelativeLayout) r10, r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
