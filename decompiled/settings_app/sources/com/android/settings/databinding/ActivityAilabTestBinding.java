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
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class ActivityAilabTestBinding implements ViewBinding {
    public final RelativeLayout aboutRootView;
    public final OButton applyBtn;
    private final RelativeLayout rootView;
    public final OScrollView scrollContent;
    public final LinearLayout testItemLayout;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ActivityAilabTestBinding(RelativeLayout r1, RelativeLayout r2, OButton r3, OScrollView r4, LinearLayout r5, OFloatingTitleBar r6) {
        this.rootView = r1;
        this.aboutRootView = r2;
        this.applyBtn = r3;
        this.scrollContent = r4;
        this.testItemLayout = r5;
        this.viewTitle = r6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityAilabTestBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityAilabTestBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.activity_ailab_test, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ActivityAilabTestBinding bind(View r7) {
        RelativeLayout r2 = (RelativeLayout) r7;
        int r0 = R.id.apply_btn;
        OButton r3 = (OButton) ViewBindings.findChildViewById(r7, R.id.apply_btn);
        if (r3 == null) goto L13;
        r0 = R.id.scroll_content;
        OScrollView r4 = (OScrollView) ViewBindings.findChildViewById(r7, R.id.scroll_content);
        if (r4 == null) goto L13;
        r0 = R.id.test_item_layout;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r7, R.id.test_item_layout);
        if (r5 == null) goto L13;
        r0 = R.id.view_title;
        OFloatingTitleBar r6 = (OFloatingTitleBar) ViewBindings.findChildViewById(r7, R.id.view_title);
        if (r6 == null) goto L13;
        return new ActivityAilabTestBinding(r2, r2, r3, r4, r5, r6);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r7.getResources().getResourceName(r0)));
    }
}
