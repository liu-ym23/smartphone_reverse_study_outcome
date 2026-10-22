package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.applications.ApplicationItemIconView;
import obric.widget.ListContentItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class AppIconSettingsItemLayoutBinding implements ViewBinding {
    public final TextView appName;
    public final ImageView arrow;
    public final LinearLayout authorInfoLayout;
    public final TextView iconAuthorName;
    public final ListContentItemText iconChooserLayout;
    public final View itemShadowLayout;
    public final ApplicationItemIconView officialIconLayout;
    private final RelativeLayout rootView;
    public final ApplicationItemIconView unofficialIconLayout;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private AppIconSettingsItemLayoutBinding(RelativeLayout r1, TextView r2, ImageView r3, LinearLayout r4, TextView r5, ListContentItemText r6, View r7, ApplicationItemIconView r8, ApplicationItemIconView r9) {
        this.rootView = r1;
        this.appName = r2;
        this.arrow = r3;
        this.authorInfoLayout = r4;
        this.iconAuthorName = r5;
        this.iconChooserLayout = r6;
        this.itemShadowLayout = r7;
        this.officialIconLayout = r8;
        this.unofficialIconLayout = r9;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static AppIconSettingsItemLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static AppIconSettingsItemLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.app_icon_settings_item_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static AppIconSettingsItemLayoutBinding bind(View r12) {
        int r0 = R.id.app_name;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r12, R.id.app_name);
        if (r4 == null) goto L21;
        r0 = R.id.arrow;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r12, R.id.arrow);
        if (r5 == null) goto L21;
        r0 = R.id.author_info_layout;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r12, R.id.author_info_layout);
        if (r6 == null) goto L21;
        r0 = R.id.icon_author_name;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r12, R.id.icon_author_name);
        if (r7 == null) goto L21;
        r0 = R.id.icon_chooser_layout;
        ListContentItemText r8 = (ListContentItemText) ViewBindings.findChildViewById(r12, R.id.icon_chooser_layout);
        if (r8 == null) goto L21;
        r0 = R.id.item_shadow_layout;
        View r9 = ViewBindings.findChildViewById(r12, R.id.item_shadow_layout);
        if (r9 == null) goto L21;
        r0 = R.id.official_icon_layout;
        ApplicationItemIconView r10 = (ApplicationItemIconView) ViewBindings.findChildViewById(r12, R.id.official_icon_layout);
        if (r10 == null) goto L21;
        r0 = R.id.unofficial_icon_layout;
        ApplicationItemIconView r11 = (ApplicationItemIconView) ViewBindings.findChildViewById(r12, R.id.unofficial_icon_layout);
        if (r11 == null) goto L21;
        return new AppIconSettingsItemLayoutBinding((RelativeLayout) r12, r4, r5, r6, r7, r8, r9, r10, r11);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r0)));
    }
}
