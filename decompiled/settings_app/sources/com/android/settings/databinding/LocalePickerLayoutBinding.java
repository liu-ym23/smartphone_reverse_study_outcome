package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OListView;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.ShadowFrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class LocalePickerLayoutBinding implements ViewBinding {
    public final OListView list;
    public final OButton nextStepBtn;
    public final ShadowFrameLayout nextStepBtnGroup;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private LocalePickerLayoutBinding(RelativeLayout r1, OListView r2, OButton r3, ShadowFrameLayout r4, OFloatingTitleBar r5) {
        this.rootView = r1;
        this.list = r2;
        this.nextStepBtn = r3;
        this.nextStepBtnGroup = r4;
        this.viewTitle = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LocalePickerLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static LocalePickerLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.locale_picker_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static LocalePickerLayoutBinding bind(View r8) {
        int r0 = R.id.list;
        OListView r4 = (OListView) ViewBindings.findChildViewById(r8, R.id.list);
        if (r4 == null) goto L13;
        r0 = R.id.next_step_btn;
        OButton r5 = (OButton) ViewBindings.findChildViewById(r8, R.id.next_step_btn);
        if (r5 == null) goto L13;
        r0 = R.id.next_step_btn_group;
        ShadowFrameLayout r6 = (ShadowFrameLayout) ViewBindings.findChildViewById(r8, R.id.next_step_btn_group);
        if (r6 == null) goto L13;
        r0 = R.id.view_title;
        OFloatingTitleBar r7 = (OFloatingTitleBar) ViewBindings.findChildViewById(r8, R.id.view_title);
        if (r7 == null) goto L13;
        return new LocalePickerLayoutBinding((RelativeLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
