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
import com.obric.oui.sectiontitlebar.OSectionTitleBar;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class ScreenSaverSettingsLayoutBinding implements ViewBinding {
    public final LinearLayout pageContainer;
    public final OScrollView pageScrollview;
    private final RelativeLayout rootView;
    public final LinearLayout screensaverAdditionalInfoContainer;
    public final OCardListItem screensaverComplications;
    public final OCardListItem screensaverCustomize;
    public final LinearLayout screensaverDreamList;
    public final OCardListItem screensaverHomeControls;
    public final OCardListItem screensaverMainSwitch;
    public final OSectionTitleBar screensaverPickerTitle;
    public final OCardListItem screensaverPreview;
    public final OCardListItem screensaverWhenToDream;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ScreenSaverSettingsLayoutBinding(RelativeLayout r1, LinearLayout r2, OScrollView r3, LinearLayout r4, OCardListItem r5, OCardListItem r6, LinearLayout r7, OCardListItem r8, OCardListItem r9, OSectionTitleBar r10, OCardListItem r11, OCardListItem r12, OFloatingTitleBar r13) {
        this.rootView = r1;
        this.pageContainer = r2;
        this.pageScrollview = r3;
        this.screensaverAdditionalInfoContainer = r4;
        this.screensaverComplications = r5;
        this.screensaverCustomize = r6;
        this.screensaverDreamList = r7;
        this.screensaverHomeControls = r8;
        this.screensaverMainSwitch = r9;
        this.screensaverPickerTitle = r10;
        this.screensaverPreview = r11;
        this.screensaverWhenToDream = r12;
        this.viewTitle = r13;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static ScreenSaverSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ScreenSaverSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.screen_saver_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ScreenSaverSettingsLayoutBinding bind(View r17) {
        int r1 = R.id.page_container;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r17, R.id.page_container);
        if (r5 == null) goto L29;
        r1 = R.id.page_scrollview;
        OScrollView r6 = (OScrollView) ViewBindings.findChildViewById(r17, R.id.page_scrollview);
        if (r6 == null) goto L29;
        r1 = R.id.screensaver_additional_info_container;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r17, R.id.screensaver_additional_info_container);
        if (r7 == null) goto L29;
        r1 = R.id.screensaver_complications;
        OCardListItem r8 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.screensaver_complications);
        if (r8 == null) goto L29;
        r1 = R.id.screensaver_customize;
        OCardListItem r9 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.screensaver_customize);
        if (r9 == null) goto L29;
        r1 = R.id.screensaver_dream_list;
        LinearLayout r10 = (LinearLayout) ViewBindings.findChildViewById(r17, R.id.screensaver_dream_list);
        if (r10 == null) goto L29;
        r1 = R.id.screensaver_home_controls;
        OCardListItem r11 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.screensaver_home_controls);
        if (r11 == null) goto L29;
        r1 = R.id.screensaver_main_switch;
        OCardListItem r12 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.screensaver_main_switch);
        if (r12 == null) goto L29;
        r1 = R.id.screensaver_picker_title;
        OSectionTitleBar r13 = (OSectionTitleBar) ViewBindings.findChildViewById(r17, R.id.screensaver_picker_title);
        if (r13 == null) goto L29;
        r1 = R.id.screensaver_preview;
        OCardListItem r14 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.screensaver_preview);
        if (r14 == null) goto L29;
        r1 = R.id.screensaver_when_to_dream;
        OCardListItem r15 = (OCardListItem) ViewBindings.findChildViewById(r17, R.id.screensaver_when_to_dream);
        if (r15 == null) goto L29;
        r1 = R.id.view_title;
        OFloatingTitleBar r16 = (OFloatingTitleBar) ViewBindings.findChildViewById(r17, R.id.view_title);
        if (r16 == null) goto L29;
        return new ScreenSaverSettingsLayoutBinding((RelativeLayout) r17, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16);
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r17.getResources().getResourceName(r1)));
    }
}
