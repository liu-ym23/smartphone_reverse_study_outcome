package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.button.OButton;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class DateTimeSettingBinding implements ViewBinding {
    public final OSectionTitleBar dateTimeSettingTitle;
    public final LinearLayout doubleTimezoneSettingsContainer;
    public final OCardListItem itemDateSet;
    public final OCardListItem itemTimeSet;
    public final OCardListItem itemZoneSet;
    public final LinearLayout itemsContainer;
    public final OButton nextStepBtn;
    public final FrameLayout nextStepBtnGroup;
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OCardListItem switchDateTimeAutoSet;
    public final OCardListItem switchTimeDisplayMode;
    public final LinearLayout temperatureUnitSettingLayout;
    public final OSectionTitleBar temperatureUnitSettingTitle;
    public final OCardListItem timezoneTimeSettings;
    public final OCardListItem unitCelsius;
    public final OCardListItem unitFahrenheit;
    public final OFloatingTitleBar viewTitle;
    public final ImageView wizardSetupImage;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private DateTimeSettingBinding(RelativeLayout r3, OSectionTitleBar r4, LinearLayout r5, OCardListItem r6, OCardListItem r7, OCardListItem r8, LinearLayout r9, OButton r10, FrameLayout r11, LinearLayout r12, OScrollView r13, OCardListItem r14, OCardListItem r15, LinearLayout r16, OSectionTitleBar r17, OCardListItem r18, OCardListItem r19, OCardListItem r20, OFloatingTitleBar r21, ImageView r22) {
        this.rootView = r3;
        this.dateTimeSettingTitle = r4;
        this.doubleTimezoneSettingsContainer = r5;
        this.itemDateSet = r6;
        this.itemTimeSet = r7;
        this.itemZoneSet = r8;
        this.itemsContainer = r9;
        this.nextStepBtn = r10;
        this.nextStepBtnGroup = r11;
        this.pageContainer = r12;
        this.pageScrollview = r13;
        this.switchDateTimeAutoSet = r14;
        this.switchTimeDisplayMode = r15;
        this.temperatureUnitSettingLayout = r16;
        this.temperatureUnitSettingTitle = r17;
        this.timezoneTimeSettings = r18;
        this.unitCelsius = r19;
        this.unitFahrenheit = r20;
        this.viewTitle = r21;
        this.wizardSetupImage = r22;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static DateTimeSettingBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static DateTimeSettingBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.date_time_setting, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static DateTimeSettingBinding bind(View r24) {
        int r1 = R.id.date_time_setting_title;
        OSectionTitleBar r5 = (OSectionTitleBar) ViewBindings.findChildViewById(r24, R.id.date_time_setting_title);
        if (r5 == null) goto L43;
        r1 = R.id.double_timezone_settings_container;
        LinearLayout r6 = (LinearLayout) ViewBindings.findChildViewById(r24, R.id.double_timezone_settings_container);
        if (r6 == null) goto L43;
        r1 = R.id.item_date_set;
        OCardListItem r7 = (OCardListItem) ViewBindings.findChildViewById(r24, R.id.item_date_set);
        if (r7 == null) goto L43;
        r1 = R.id.item_time_set;
        OCardListItem r8 = (OCardListItem) ViewBindings.findChildViewById(r24, R.id.item_time_set);
        if (r8 == null) goto L43;
        r1 = R.id.item_zone_set;
        OCardListItem r9 = (OCardListItem) ViewBindings.findChildViewById(r24, R.id.item_zone_set);
        if (r9 == null) goto L43;
        r1 = R.id.items_container;
        LinearLayout r10 = (LinearLayout) ViewBindings.findChildViewById(r24, R.id.items_container);
        if (r10 == null) goto L43;
        r1 = R.id.next_step_btn;
        OButton r11 = (OButton) ViewBindings.findChildViewById(r24, R.id.next_step_btn);
        if (r11 == null) goto L43;
        r1 = R.id.next_step_btn_group;
        FrameLayout r12 = (FrameLayout) ViewBindings.findChildViewById(r24, R.id.next_step_btn_group);
        if (r12 == null) goto L43;
        r1 = R.id.page_container;
        LinearLayout r13 = (LinearLayout) ViewBindings.findChildViewById(r24, R.id.page_container);
        if (r13 == null) goto L43;
        r1 = R.id.page_scrollview;
        OScrollView r14 = (OScrollView) ViewBindings.findChildViewById(r24, R.id.page_scrollview);
        if (r14 == null) goto L43;
        r1 = R.id.switch_date_time_auto_set;
        OCardListItem r15 = (OCardListItem) ViewBindings.findChildViewById(r24, R.id.switch_date_time_auto_set);
        if (r15 == null) goto L43;
        r1 = R.id.switch_time_display_mode;
        OCardListItem r16 = (OCardListItem) ViewBindings.findChildViewById(r24, R.id.switch_time_display_mode);
        if (r16 == null) goto L43;
        r1 = R.id.temperature_unit_setting_layout;
        LinearLayout r17 = (LinearLayout) ViewBindings.findChildViewById(r24, R.id.temperature_unit_setting_layout);
        if (r17 == null) goto L43;
        r1 = R.id.temperature_unit_setting_title;
        OSectionTitleBar r18 = (OSectionTitleBar) ViewBindings.findChildViewById(r24, R.id.temperature_unit_setting_title);
        if (r18 == null) goto L43;
        r1 = R.id.timezone_time_settings;
        OCardListItem r19 = (OCardListItem) ViewBindings.findChildViewById(r24, R.id.timezone_time_settings);
        if (r19 == null) goto L43;
        r1 = R.id.unit_celsius;
        OCardListItem r20 = (OCardListItem) ViewBindings.findChildViewById(r24, R.id.unit_celsius);
        if (r20 == null) goto L43;
        r1 = R.id.unit_fahrenheit;
        OCardListItem r21 = (OCardListItem) ViewBindings.findChildViewById(r24, R.id.unit_fahrenheit);
        if (r21 == null) goto L43;
        r1 = R.id.view_title;
        OFloatingTitleBar r22 = (OFloatingTitleBar) ViewBindings.findChildViewById(r24, R.id.view_title);
        if (r22 == null) goto L43;
        r1 = R.id.wizard_setup_image;
        ImageView r23 = (ImageView) ViewBindings.findChildViewById(r24, R.id.wizard_setup_image);
        if (r23 == null) goto L43;
        return new DateTimeSettingBinding((RelativeLayout) r24, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23);
    L43:
        throw new NullPointerException("Missing required view with ID: ".concat(r24.getResources().getResourceName(r1)));
    }
}
