package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.ListContentItemCustom;

/* JADX INFO: loaded from: classes2.dex */
public final class BindCloudLayoutBinding implements ViewBinding {
    public final OButton bindingClound;
    public final OFloatingTitleBar bingdingCloundTitle;
    public final RelativeLayout btnLayout;
    public final TextView cloudBindingDes;
    public final ImageView cloudLogo;
    public final ListContentItemCustom cloudLogoImage;
    public final TextView loginContent;
    private final RelativeLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private BindCloudLayoutBinding(RelativeLayout r1, OButton r2, OFloatingTitleBar r3, RelativeLayout r4, TextView r5, ImageView r6, ListContentItemCustom r7, TextView r8) {
        this.rootView = r1;
        this.bindingClound = r2;
        this.bingdingCloundTitle = r3;
        this.btnLayout = r4;
        this.cloudBindingDes = r5;
        this.cloudLogo = r6;
        this.cloudLogoImage = r7;
        this.loginContent = r8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static BindCloudLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static BindCloudLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.bind_cloud_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static BindCloudLayoutBinding bind(View r11) {
        int r0 = R.id.binding_clound;
        OButton r4 = (OButton) ViewBindings.findChildViewById(r11, R.id.binding_clound);
        if (r4 == null) goto L19;
        r0 = R.id.bingding_clound_title;
        OFloatingTitleBar r5 = (OFloatingTitleBar) ViewBindings.findChildViewById(r11, R.id.bingding_clound_title);
        if (r5 == null) goto L19;
        r0 = R.id.btnLayout;
        RelativeLayout r6 = (RelativeLayout) ViewBindings.findChildViewById(r11, R.id.btnLayout);
        if (r6 == null) goto L19;
        r0 = R.id.cloud_binding_des;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r11, R.id.cloud_binding_des);
        if (r7 == null) goto L19;
        r0 = R.id.cloud_logo;
        ImageView r8 = (ImageView) ViewBindings.findChildViewById(r11, R.id.cloud_logo);
        if (r8 == null) goto L19;
        r0 = R.id.cloud_logo_image;
        ListContentItemCustom r9 = (ListContentItemCustom) ViewBindings.findChildViewById(r11, R.id.cloud_logo_image);
        if (r9 == null) goto L19;
        r0 = R.id.login_content;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r11, R.id.login_content);
        if (r10 == null) goto L19;
        return new BindCloudLayoutBinding((RelativeLayout) r11, r4, r5, r6, r7, r8, r9, r10);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }
}
