package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class DeviceAdminAddBinding implements ViewBinding {
    public final OButton actionButton;
    public final TextView addMsg;
    public final ImageView addMsgExpander;
    public final TextView adminDescription;
    public final ImageView adminIcon;
    public final TextView adminName;
    public final LinearLayout adminPolicies;
    public final TextView adminWarning;
    public final FrameLayout buttonPanel;
    public final FrameLayout iconContainer;
    public final RelativeLayout pageContainer;
    public final TextView profileOwnerWarning;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DeviceAdminAddBinding(RelativeLayout r1, OButton r2, TextView r3, ImageView r4, TextView r5, ImageView r6, TextView r7, LinearLayout r8, TextView r9, FrameLayout r10, FrameLayout r11, RelativeLayout r12, TextView r13, OFloatingTitleBar r14) {
        this.rootView = r1;
        this.actionButton = r2;
        this.addMsg = r3;
        this.addMsgExpander = r4;
        this.adminDescription = r5;
        this.adminIcon = r6;
        this.adminName = r7;
        this.adminPolicies = r8;
        this.adminWarning = r9;
        this.buttonPanel = r10;
        this.iconContainer = r11;
        this.pageContainer = r12;
        this.profileOwnerWarning = r13;
        this.viewTitle = r14;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DeviceAdminAddBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DeviceAdminAddBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.device_admin_add, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DeviceAdminAddBinding bind(View r18) {
        int r1 = R.id.action_button;
        OButton r5 = (OButton) ViewBindings.findChildViewById(r18, R.id.action_button);
        if (r5 == null) goto L29;
        r1 = R.id.add_msg;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r18, R.id.add_msg);
        if (r6 == null) goto L29;
        r1 = R.id.add_msg_expander;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r18, R.id.add_msg_expander);
        if (r7 == null) goto L29;
        r1 = R.id.admin_description;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r18, R.id.admin_description);
        if (r8 == null) goto L29;
        r1 = R.id.admin_icon;
        ImageView r9 = (ImageView) ViewBindings.findChildViewById(r18, R.id.admin_icon);
        if (r9 == null) goto L29;
        r1 = R.id.admin_name;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r18, R.id.admin_name);
        if (r10 == null) goto L29;
        r1 = R.id.admin_policies;
        LinearLayout r11 = (LinearLayout) ViewBindings.findChildViewById(r18, R.id.admin_policies);
        if (r11 == null) goto L29;
        r1 = R.id.admin_warning;
        TextView r12 = (TextView) ViewBindings.findChildViewById(r18, R.id.admin_warning);
        if (r12 == null) goto L29;
        r1 = R.id.buttonPanel;
        FrameLayout r13 = (FrameLayout) ViewBindings.findChildViewById(r18, R.id.buttonPanel);
        if (r13 == null) goto L29;
        r1 = R.id.icon_container;
        FrameLayout r14 = (FrameLayout) ViewBindings.findChildViewById(r18, R.id.icon_container);
        if (r14 == null) goto L29;
        RelativeLayout r15 = (RelativeLayout) r18;
        r1 = R.id.profile_owner_warning;
        TextView r16 = (TextView) ViewBindings.findChildViewById(r18, R.id.profile_owner_warning);
        if (r16 == null) goto L29;
        r1 = R.id.view_title;
        OFloatingTitleBar r17 = (OFloatingTitleBar) ViewBindings.findChildViewById(r18, R.id.view_title);
        if (r17 == null) goto L29;
        return new DeviceAdminAddBinding(r15, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r18.getResources().getResourceName(r1)));
    }
}
