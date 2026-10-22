package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class SystemIntelligentLayoutBinding implements ViewBinding {
    public final OCardListItem aiLab;
    public final OCardListItem assistantActivation;
    public final OCardListItem assistantCallForwarding;
    public final OCardListItem assistantEnable;
    public final OCardListItem assistantHighPriorityNotification;
    public final OCardListItem assistantMemory;
    public final OCardListItem assistantRecordingSummary;
    public final LinearLayout assistantSubContainer;
    public final OCardListItem assistantSwitch;
    public final OCardListItem doubaoDevices;
    public final OCardListItem doubaoSettings;
    public final ImageView iconStar;
    public final LinearLayout pageContainer;
    public final RelativeLayout pageRoot;
    public final ONestedScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SystemIntelligentLayoutBinding(RelativeLayout r3, OCardListItem r4, OCardListItem r5, OCardListItem r6, OCardListItem r7, OCardListItem r8, OCardListItem r9, OCardListItem r10, LinearLayout r11, OCardListItem r12, OCardListItem r13, OCardListItem r14, ImageView r15, LinearLayout r16, RelativeLayout r17, ONestedScrollView r18, OFloatingTitleBar r19) {
        this.rootView = r3;
        this.aiLab = r4;
        this.assistantActivation = r5;
        this.assistantCallForwarding = r6;
        this.assistantEnable = r7;
        this.assistantHighPriorityNotification = r8;
        this.assistantMemory = r9;
        this.assistantRecordingSummary = r10;
        this.assistantSubContainer = r11;
        this.assistantSwitch = r12;
        this.doubaoDevices = r13;
        this.doubaoSettings = r14;
        this.iconStar = r15;
        this.pageContainer = r16;
        this.pageRoot = r17;
        this.pageScrollview = r18;
        this.viewTitle = r19;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SystemIntelligentLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SystemIntelligentLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.system_intelligent_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SystemIntelligentLayoutBinding bind(View r21) {
        int r1 = R.id.ai_lab;
        OCardListItem r5 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.ai_lab);
        if (r5 == null) goto L35;
        r1 = R.id.assistant_activation;
        OCardListItem r6 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.assistant_activation);
        if (r6 == null) goto L35;
        r1 = R.id.assistant_call_forwarding;
        OCardListItem r7 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.assistant_call_forwarding);
        if (r7 == null) goto L35;
        r1 = R.id.assistant_enable;
        OCardListItem r8 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.assistant_enable);
        if (r8 == null) goto L35;
        r1 = R.id.assistant_high_priority_notification;
        OCardListItem r9 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.assistant_high_priority_notification);
        if (r9 == null) goto L35;
        r1 = R.id.assistant_memory;
        OCardListItem r10 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.assistant_memory);
        if (r10 == null) goto L35;
        r1 = R.id.assistant_recording_summary;
        OCardListItem r11 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.assistant_recording_summary);
        if (r11 == null) goto L35;
        r1 = R.id.assistant_sub_container;
        LinearLayout r12 = (LinearLayout) ViewBindings.findChildViewById(r21, R.id.assistant_sub_container);
        if (r12 == null) goto L35;
        r1 = R.id.assistant_switch;
        OCardListItem r13 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.assistant_switch);
        if (r13 == null) goto L35;
        r1 = R.id.doubao_devices;
        OCardListItem r14 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.doubao_devices);
        if (r14 == null) goto L35;
        r1 = R.id.doubao_settings;
        OCardListItem r15 = (OCardListItem) ViewBindings.findChildViewById(r21, R.id.doubao_settings);
        if (r15 == null) goto L35;
        r1 = R.id.icon_star;
        ImageView r16 = (ImageView) ViewBindings.findChildViewById(r21, R.id.icon_star);
        if (r16 == null) goto L35;
        r1 = R.id.page_container;
        LinearLayout r17 = (LinearLayout) ViewBindings.findChildViewById(r21, R.id.page_container);
        if (r17 == null) goto L35;
        RelativeLayout r18 = (RelativeLayout) r21;
        r1 = R.id.page_scrollview;
        ONestedScrollView r19 = (ONestedScrollView) ViewBindings.findChildViewById(r21, R.id.page_scrollview);
        if (r19 == null) goto L35;
        r1 = R.id.view_title;
        OFloatingTitleBar r20 = (OFloatingTitleBar) ViewBindings.findChildViewById(r21, R.id.view_title);
        if (r20 == null) goto L35;
        return new SystemIntelligentLayoutBinding(r18, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20);
    L35:
        throw new NullPointerException("Missing required view with ID: ".concat(r21.getResources().getResourceName(r1)));
    }
}
