package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.SelectOptionsView;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class LauncherChooseSettingsLayoutBinding implements ViewBinding {
    public final OButton nextStepBtn;
    public final FrameLayout nextStepBtnGroup;
    public final ImageView phoneFrame;
    public final ImageView previewImage;
    private final FrameLayout rootView;
    public final SelectOptionsView selectOptionsView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private LauncherChooseSettingsLayoutBinding(FrameLayout r1, OButton r2, FrameLayout r3, ImageView r4, ImageView r5, SelectOptionsView r6, OFloatingTitleBar r7) {
        this.rootView = r1;
        this.nextStepBtn = r2;
        this.nextStepBtnGroup = r3;
        this.phoneFrame = r4;
        this.previewImage = r5;
        this.selectOptionsView = r6;
        this.viewTitle = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static LauncherChooseSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static LauncherChooseSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.launcher_choose_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static LauncherChooseSettingsLayoutBinding bind(View r10) {
        int r0 = R.id.next_step_btn;
        OButton r4 = (OButton) ViewBindings.findChildViewById(r10, R.id.next_step_btn);
        if (r4 == null) goto L17;
        r0 = R.id.next_step_btn_group;
        FrameLayout r5 = (FrameLayout) ViewBindings.findChildViewById(r10, R.id.next_step_btn_group);
        if (r5 == null) goto L17;
        r0 = R.id.phone_frame;
        ImageView r6 = (ImageView) ViewBindings.findChildViewById(r10, R.id.phone_frame);
        if (r6 == null) goto L17;
        r0 = R.id.preview_image;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r10, R.id.preview_image);
        if (r7 == null) goto L17;
        r0 = R.id.select_options_view;
        SelectOptionsView r8 = (SelectOptionsView) ViewBindings.findChildViewById(r10, R.id.select_options_view);
        if (r8 == null) goto L17;
        r0 = R.id.view_title;
        OFloatingTitleBar r9 = (OFloatingTitleBar) ViewBindings.findChildViewById(r10, R.id.view_title);
        if (r9 == null) goto L17;
        return new LauncherChooseSettingsLayoutBinding((FrameLayout) r10, r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
