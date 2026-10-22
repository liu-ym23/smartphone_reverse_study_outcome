package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class SettingsEntityHeaderBinding implements ViewBinding {
    public final ImageButton button1;
    public final ImageButton button2;
    public final RelativeLayout entityHeader;
    public final LinearLayout entityHeaderContent;
    public final ImageView entityHeaderIcon;
    public final TextView entityHeaderSecondSummary;
    public final TextView entityHeaderSummary;
    public final TextView entityHeaderTitle;
    public final TextView installType;
    private final RelativeLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SettingsEntityHeaderBinding(RelativeLayout r1, ImageButton r2, ImageButton r3, RelativeLayout r4, LinearLayout r5, ImageView r6, TextView r7, TextView r8, TextView r9, TextView r10) {
        this.rootView = r1;
        this.button1 = r2;
        this.button2 = r3;
        this.entityHeader = r4;
        this.entityHeaderContent = r5;
        this.entityHeaderIcon = r6;
        this.entityHeaderSecondSummary = r7;
        this.entityHeaderSummary = r8;
        this.entityHeaderTitle = r9;
        this.installType = r10;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SettingsEntityHeaderBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SettingsEntityHeaderBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.settings_entity_header, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SettingsEntityHeaderBinding bind(View r13) {
        int r0 = android.R.id.button1;
        ImageButton r4 = (ImageButton) ViewBindings.findChildViewById(r13, android.R.id.button1);
        if (r4 == null) goto L21;
        r0 = android.R.id.button2;
        ImageButton r5 = (ImageButton) ViewBindings.findChildViewById(r13, android.R.id.button2);
        if (r5 == null) goto L21;
        RelativeLayout r6 = (RelativeLayout) r13;
        r0 = R.id.entity_header_content;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r13, R.id.entity_header_content);
        if (r7 == null) goto L21;
        r0 = R.id.entity_header_icon;
        ImageView r8 = (ImageView) ViewBindings.findChildViewById(r13, R.id.entity_header_icon);
        if (r8 == null) goto L21;
        r0 = R.id.entity_header_second_summary;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r13, R.id.entity_header_second_summary);
        if (r9 == null) goto L21;
        r0 = R.id.entity_header_summary;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r13, R.id.entity_header_summary);
        if (r10 == null) goto L21;
        r0 = R.id.entity_header_title;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r13, R.id.entity_header_title);
        if (r11 == null) goto L21;
        r0 = R.id.install_type;
        TextView r12 = (TextView) ViewBindings.findChildViewById(r13, R.id.install_type);
        if (r12 == null) goto L21;
        return new SettingsEntityHeaderBinding(r6, r4, r5, r6, r7, r8, r9, r10, r11, r12);
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r0)));
    }
}
