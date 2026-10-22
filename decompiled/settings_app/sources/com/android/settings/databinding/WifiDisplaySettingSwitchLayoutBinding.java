package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;

/* JADX INFO: loaded from: classes2.dex */
public final class WifiDisplaySettingSwitchLayoutBinding implements ViewBinding {
    private final RelativeLayout rootView;
    public final LinearLayout wifiDisplayEmptyTipsRealTimeSubtitles;
    public final LinearLayout wifiDisplayEmptyTipsScreenVideo;
    public final OCardListItem wifiDisplaySwitch;
    public final OSectionSupportiveText wifiDisplaySwitchSupportiveTextTips;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private WifiDisplaySettingSwitchLayoutBinding(RelativeLayout r1, LinearLayout r2, LinearLayout r3, OCardListItem r4, OSectionSupportiveText r5) {
        this.rootView = r1;
        this.wifiDisplayEmptyTipsRealTimeSubtitles = r2;
        this.wifiDisplayEmptyTipsScreenVideo = r3;
        this.wifiDisplaySwitch = r4;
        this.wifiDisplaySwitchSupportiveTextTips = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static WifiDisplaySettingSwitchLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static WifiDisplaySettingSwitchLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.wifi_display_setting_switch_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static WifiDisplaySettingSwitchLayoutBinding bind(View r8) {
        int r0 = R.id.wifi_display_empty_tips_real_time_subtitles;
        LinearLayout r4 = (LinearLayout) ViewBindings.findChildViewById(r8, R.id.wifi_display_empty_tips_real_time_subtitles);
        if (r4 == null) goto L13;
        r0 = R.id.wifi_display_empty_tips_screen_video;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r8, R.id.wifi_display_empty_tips_screen_video);
        if (r5 == null) goto L13;
        r0 = R.id.wifi_display_switch;
        OCardListItem r6 = (OCardListItem) ViewBindings.findChildViewById(r8, R.id.wifi_display_switch);
        if (r6 == null) goto L13;
        r0 = R.id.wifi_display_switch_supportive_text_tips;
        OSectionSupportiveText r7 = (OSectionSupportiveText) ViewBindings.findChildViewById(r8, R.id.wifi_display_switch_supportive_text_tips);
        if (r7 == null) goto L13;
        return new WifiDisplaySettingSwitchLayoutBinding((RelativeLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
