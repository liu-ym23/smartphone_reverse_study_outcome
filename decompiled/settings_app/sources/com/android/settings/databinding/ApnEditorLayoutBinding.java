package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.TitleSummaryItem;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class ApnEditorLayoutBinding implements ViewBinding {
    public final TitleSummaryItem itemApn;
    public final TitleSummaryItem itemApnType;
    public final TitleSummaryItem itemAuthType;
    public final TitleSummaryItem itemBearer;
    public final TitleSummaryItem itemCarrierEnabled;
    public final TitleSummaryItem itemMcc;
    public final TitleSummaryItem itemMmsPort;
    public final TitleSummaryItem itemMmsProxy;
    public final TitleSummaryItem itemMmsc;
    public final TitleSummaryItem itemMnc;
    public final TitleSummaryItem itemName;
    public final TitleSummaryItem itemPassword;
    public final TitleSummaryItem itemPort;
    public final TitleSummaryItem itemProtocal;
    public final TitleSummaryItem itemProxy;
    public final TitleSummaryItem itemRoamingProtocal;
    public final TitleSummaryItem itemServer;
    public final TitleSummaryItem itemUser;
    public final TitleSummaryItem mvnoMatchData;
    public final TitleSummaryItem mvnoType;
    public final LinearLayout pageContainer;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ApnEditorLayoutBinding(RelativeLayout r3, TitleSummaryItem r4, TitleSummaryItem r5, TitleSummaryItem r6, TitleSummaryItem r7, TitleSummaryItem r8, TitleSummaryItem r9, TitleSummaryItem r10, TitleSummaryItem r11, TitleSummaryItem r12, TitleSummaryItem r13, TitleSummaryItem r14, TitleSummaryItem r15, TitleSummaryItem r16, TitleSummaryItem r17, TitleSummaryItem r18, TitleSummaryItem r19, TitleSummaryItem r20, TitleSummaryItem r21, TitleSummaryItem r22, TitleSummaryItem r23, LinearLayout r24, OFloatingTitleBar r25) {
        this.rootView = r3;
        this.itemApn = r4;
        this.itemApnType = r5;
        this.itemAuthType = r6;
        this.itemBearer = r7;
        this.itemCarrierEnabled = r8;
        this.itemMcc = r9;
        this.itemMmsPort = r10;
        this.itemMmsProxy = r11;
        this.itemMmsc = r12;
        this.itemMnc = r13;
        this.itemName = r14;
        this.itemPassword = r15;
        this.itemPort = r16;
        this.itemProtocal = r17;
        this.itemProxy = r18;
        this.itemRoamingProtocal = r19;
        this.itemServer = r20;
        this.itemUser = r21;
        this.mvnoMatchData = r22;
        this.mvnoType = r23;
        this.pageContainer = r24;
        this.viewTitle = r25;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ApnEditorLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ApnEditorLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.apn_editor_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ApnEditorLayoutBinding bind(View r27) {
        int r1 = R.id.item_apn;
        TitleSummaryItem r5 = (TitleSummaryItem) ViewBindings.findChildViewById(r27, R.id.item_apn);
        if (r5 == null) goto L49;
        r1 = R.id.item_apn_type;
        TitleSummaryItem r6 = (TitleSummaryItem) ViewBindings.findChildViewById(r27, R.id.item_apn_type);
        if (r6 == null) goto L49;
        r1 = R.id.item_auth_type;
        TitleSummaryItem r7 = (TitleSummaryItem) ViewBindings.findChildViewById(r27, R.id.item_auth_type);
        if (r7 == null) goto L49;
        r1 = R.id.item_bearer;
        TitleSummaryItem r8 = (TitleSummaryItem) ViewBindings.findChildViewById(r27, R.id.item_bearer);
        if (r8 == null) goto L49;
        r1 = R.id.item_carrier_enabled;
        TitleSummaryItem r9 = (TitleSummaryItem) ViewBindings.findChildViewById(r27, R.id.item_carrier_enabled);
        if (r9 == null) goto L49;
        r1 = R.id.item_mcc;
        TitleSummaryItem r10 = (TitleSummaryItem) ViewBindings.findChildViewById(r27, R.id.item_mcc);
        if (r10 == null) goto L49;
        r1 = R.id.item_mms_port;
        TitleSummaryItem r11 = (TitleSummaryItem) ViewBindings.findChildViewById(r27, R.id.item_mms_port);
        if (r11 == null) goto L49;
        r1 = R.id.item_mms_proxy;
        TitleSummaryItem r12 = (TitleSummaryItem) ViewBindings.findChildViewById(r27, R.id.item_mms_proxy);
        if (r12 == null) goto L49;
        r1 = R.id.item_mmsc;
        TitleSummaryItem r13 = (TitleSummaryItem) ViewBindings.findChildViewById(r27, R.id.item_mmsc);
        if (r13 == null) goto L49;
        r1 = R.id.item_mnc;
        TitleSummaryItem r14 = (TitleSummaryItem) ViewBindings.findChildViewById(r27, R.id.item_mnc);
        if (r14 == null) goto L49;
        r1 = R.id.item_name;
        TitleSummaryItem r15 = (TitleSummaryItem) ViewBindings.findChildViewById(r27, R.id.item_name);
        if (r15 == null) goto L49;
        r1 = R.id.item_password;
        TitleSummaryItem r16 = (TitleSummaryItem) ViewBindings.findChildViewById(r27, R.id.item_password);
        if (r16 == null) goto L49;
        r1 = R.id.item_port;
        TitleSummaryItem r17 = (TitleSummaryItem) ViewBindings.findChildViewById(r27, R.id.item_port);
        if (r17 == null) goto L49;
        r1 = R.id.item_protocal;
        TitleSummaryItem r18 = (TitleSummaryItem) ViewBindings.findChildViewById(r27, R.id.item_protocal);
        if (r18 == null) goto L49;
        r1 = R.id.item_proxy;
        TitleSummaryItem r19 = (TitleSummaryItem) ViewBindings.findChildViewById(r27, R.id.item_proxy);
        if (r19 == null) goto L49;
        r1 = R.id.item_roaming_protocal;
        TitleSummaryItem r20 = (TitleSummaryItem) ViewBindings.findChildViewById(r27, R.id.item_roaming_protocal);
        if (r20 == null) goto L49;
        r1 = R.id.item_server;
        TitleSummaryItem r21 = (TitleSummaryItem) ViewBindings.findChildViewById(r27, R.id.item_server);
        if (r21 == null) goto L49;
        r1 = R.id.item_user;
        TitleSummaryItem r22 = (TitleSummaryItem) ViewBindings.findChildViewById(r27, R.id.item_user);
        if (r22 == null) goto L49;
        r1 = R.id.mvno_match_data;
        TitleSummaryItem r23 = (TitleSummaryItem) ViewBindings.findChildViewById(r27, R.id.mvno_match_data);
        if (r23 == null) goto L49;
        r1 = R.id.mvno_type;
        TitleSummaryItem r24 = (TitleSummaryItem) ViewBindings.findChildViewById(r27, R.id.mvno_type);
        if (r24 == null) goto L49;
        r1 = R.id.page_container;
        LinearLayout r25 = (LinearLayout) ViewBindings.findChildViewById(r27, R.id.page_container);
        if (r25 == null) goto L49;
        r1 = R.id.view_title;
        OFloatingTitleBar r26 = (OFloatingTitleBar) ViewBindings.findChildViewById(r27, R.id.view_title);
        if (r26 == null) goto L49;
        return new ApnEditorLayoutBinding((RelativeLayout) r27, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    L49:
        throw new NullPointerException("Missing required view with ID: ".concat(r27.getResources().getResourceName(r1)));
    }
}
