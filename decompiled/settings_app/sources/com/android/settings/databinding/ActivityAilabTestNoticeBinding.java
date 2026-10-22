package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class ActivityAilabTestNoticeBinding implements ViewBinding {
    public final RelativeLayout aboutRootView;
    public final OButton applyBtn;
    private final RelativeLayout rootView;
    public final OScrollView scrollContent;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ActivityAilabTestNoticeBinding(RelativeLayout r1, RelativeLayout r2, OButton r3, OScrollView r4, OFloatingTitleBar r5) {
        this.rootView = r1;
        this.aboutRootView = r2;
        this.applyBtn = r3;
        this.scrollContent = r4;
        this.viewTitle = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ActivityAilabTestNoticeBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityAilabTestNoticeBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.activity_ailab_test_notice, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ActivityAilabTestNoticeBinding bind(View r6) {
        RelativeLayout r2 = (RelativeLayout) r6;
        int r0 = R.id.apply_btn;
        OButton r3 = (OButton) ViewBindings.findChildViewById(r6, R.id.apply_btn);
        if (r3 == null) goto L11;
        r0 = R.id.scroll_content;
        OScrollView r4 = (OScrollView) ViewBindings.findChildViewById(r6, R.id.scroll_content);
        if (r4 == null) goto L11;
        r0 = R.id.view_title;
        OFloatingTitleBar r5 = (OFloatingTitleBar) ViewBindings.findChildViewById(r6, R.id.view_title);
        if (r5 == null) goto L11;
        return new ActivityAilabTestNoticeBinding(r2, r2, r3, r4, r5);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r0)));
    }
}
