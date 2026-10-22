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
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class LockNotificationLayoutBinding implements ViewBinding {
    public final OCheckBox aiSpaceExpandedCheckbox;
    public final OUILinearLayout aiSpaceExpandedDisplay;
    public final OCheckBox countCheckbox;
    public final OUILinearLayout countTheme;
    public final OCardListItem dozeEnableSwitch;
    public final OCardListItem keepLockScreenNotificationSwitch;
    public final OCheckBox listCheckbox;
    public final OUILinearLayout listTheme;
    public final OCardListItem lockScreenNotification;
    public final OCheckBox notificationExpandedCheckbox;
    public final OUILinearLayout notificationExpandedDisplay;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private LockNotificationLayoutBinding(RelativeLayout r1, OCheckBox r2, OUILinearLayout r3, OCheckBox r4, OUILinearLayout r5, OCardListItem r6, OCardListItem r7, OCheckBox r8, OUILinearLayout r9, OCardListItem r10, OCheckBox r11, OUILinearLayout r12, LinearLayout r13, OScrollView r14, OFloatingTitleBar r15) {
        this.rootView = r1;
        this.aiSpaceExpandedCheckbox = r2;
        this.aiSpaceExpandedDisplay = r3;
        this.countCheckbox = r4;
        this.countTheme = r5;
        this.dozeEnableSwitch = r6;
        this.keepLockScreenNotificationSwitch = r7;
        this.listCheckbox = r8;
        this.listTheme = r9;
        this.lockScreenNotification = r10;
        this.notificationExpandedCheckbox = r11;
        this.notificationExpandedDisplay = r12;
        this.pageContainer = r13;
        this.pageScrollview = r14;
        this.viewTitle = r15;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LockNotificationLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static LockNotificationLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.lock_notification_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static LockNotificationLayoutBinding bind(View r19) {
        int r1 = R.id.ai_space_expanded_checkbox;
        OCheckBox r5 = (OCheckBox) ViewBindings.findChildViewById(r19, R.id.ai_space_expanded_checkbox);
        if (r5 == null) goto L33;
        r1 = R.id.ai_space_expanded_display;
        OUILinearLayout r6 = (OUILinearLayout) ViewBindings.findChildViewById(r19, R.id.ai_space_expanded_display);
        if (r6 == null) goto L33;
        r1 = R.id.count_checkbox;
        OCheckBox r7 = (OCheckBox) ViewBindings.findChildViewById(r19, R.id.count_checkbox);
        if (r7 == null) goto L33;
        r1 = R.id.count_theme;
        OUILinearLayout r8 = (OUILinearLayout) ViewBindings.findChildViewById(r19, R.id.count_theme);
        if (r8 == null) goto L33;
        r1 = R.id.doze_enable_switch;
        OCardListItem r9 = (OCardListItem) ViewBindings.findChildViewById(r19, R.id.doze_enable_switch);
        if (r9 == null) goto L33;
        r1 = R.id.keep_lock_screen_notification_switch;
        OCardListItem r10 = (OCardListItem) ViewBindings.findChildViewById(r19, R.id.keep_lock_screen_notification_switch);
        if (r10 == null) goto L33;
        r1 = R.id.list_checkbox;
        OCheckBox r11 = (OCheckBox) ViewBindings.findChildViewById(r19, R.id.list_checkbox);
        if (r11 == null) goto L33;
        r1 = R.id.list_theme;
        OUILinearLayout r12 = (OUILinearLayout) ViewBindings.findChildViewById(r19, R.id.list_theme);
        if (r12 == null) goto L33;
        r1 = R.id.lock_screen_notification;
        OCardListItem r13 = (OCardListItem) ViewBindings.findChildViewById(r19, R.id.lock_screen_notification);
        if (r13 == null) goto L33;
        r1 = R.id.notification_expanded_checkbox;
        OCheckBox r14 = (OCheckBox) ViewBindings.findChildViewById(r19, R.id.notification_expanded_checkbox);
        if (r14 == null) goto L33;
        r1 = R.id.notification_expanded_display;
        OUILinearLayout r15 = (OUILinearLayout) ViewBindings.findChildViewById(r19, R.id.notification_expanded_display);
        if (r15 == null) goto L33;
        r1 = R.id.page_container;
        LinearLayout r16 = (LinearLayout) ViewBindings.findChildViewById(r19, R.id.page_container);
        if (r16 == null) goto L33;
        r1 = R.id.page_scrollview;
        OScrollView r17 = (OScrollView) ViewBindings.findChildViewById(r19, R.id.page_scrollview);
        if (r17 == null) goto L33;
        r1 = R.id.view_title;
        OFloatingTitleBar r18 = (OFloatingTitleBar) ViewBindings.findChildViewById(r19, R.id.view_title);
        if (r18 == null) goto L33;
        return new LockNotificationLayoutBinding((RelativeLayout) r19, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    L33:
        throw new NullPointerException("Missing required view with ID: ".concat(r19.getResources().getResourceName(r1)));
    }
}
