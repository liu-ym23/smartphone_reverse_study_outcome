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
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class SoundWorkSettingsLayoutBinding implements ViewBinding {
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;
    public final OCardListItem workAlarmRingtoneItem;
    public final OCardListItem workNotificationRingtoneItem;
    public final OCardListItem workRingtoneItem;
    public final OCardListItem workUsePersonalSoundsItem;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SoundWorkSettingsLayoutBinding(RelativeLayout r1, LinearLayout r2, OScrollView r3, OFloatingTitleBar r4, OCardListItem r5, OCardListItem r6, OCardListItem r7, OCardListItem r8) {
        this.rootView = r1;
        this.pageContainer = r2;
        this.pageScrollview = r3;
        this.viewTitle = r4;
        this.workAlarmRingtoneItem = r5;
        this.workNotificationRingtoneItem = r6;
        this.workRingtoneItem = r7;
        this.workUsePersonalSoundsItem = r8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static SoundWorkSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SoundWorkSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.sound_work_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SoundWorkSettingsLayoutBinding bind(View r11) {
        int r0 = R.id.page_container;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r11, R.id.page_container);
        if (r4 == null) goto L19;
        r0 = R.id.page_scrollview;
        OScrollView r5 = (OScrollView) ViewBindings.findChildViewById(r11, R.id.page_scrollview);
        if (r5 == null) goto L19;
        r0 = R.id.view_title;
        OFloatingTitleBar r6 = (OFloatingTitleBar) ViewBindings.findChildViewById(r11, R.id.view_title);
        if (r6 == null) goto L19;
        r0 = R.id.work_alarm_ringtone_item;
        OCardListItem r7 = (OCardListItem) ViewBindings.findChildViewById(r11, R.id.work_alarm_ringtone_item);
        if (r7 == null) goto L19;
        r0 = R.id.work_notification_ringtone_item;
        OCardListItem r8 = (OCardListItem) ViewBindings.findChildViewById(r11, R.id.work_notification_ringtone_item);
        if (r8 == null) goto L19;
        r0 = R.id.work_ringtone_item;
        OCardListItem r9 = (OCardListItem) ViewBindings.findChildViewById(r11, R.id.work_ringtone_item);
        if (r9 == null) goto L19;
        r0 = R.id.work_use_personal_sounds_item;
        OCardListItem r10 = (OCardListItem) ViewBindings.findChildViewById(r11, R.id.work_use_personal_sounds_item);
        if (r10 == null) goto L19;
        return new SoundWorkSettingsLayoutBinding((RelativeLayout) r11, r4, r5, r6, r7, r8, r9, r10);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }
}
