package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import obric.widget.PreviewOptionsCheckView;
import obric.widget.SettingItemSwitch;

/* JADX INFO: loaded from: classes2.dex */
public final class SidekeySettingsFooterLayoutBinding implements ViewBinding {
    public final TextView bootPhoneTips;
    public final PreviewOptionsCheckView doubleClickHomeChooser;
    public final TextView enableIdeaPillsTips;
    public final PreviewOptionsCheckView idShortcutKeyChooser;
    private final LinearLayout rootView;
    public final TextView switchingSongsTips;
    public final SettingItemSwitch switchingSongsWithBrightnessKeys;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private SidekeySettingsFooterLayoutBinding(LinearLayout r1, TextView r2, PreviewOptionsCheckView r3, TextView r4, PreviewOptionsCheckView r5, TextView r6, SettingItemSwitch r7) {
        this.rootView = r1;
        this.bootPhoneTips = r2;
        this.doubleClickHomeChooser = r3;
        this.enableIdeaPillsTips = r4;
        this.idShortcutKeyChooser = r5;
        this.switchingSongsTips = r6;
        this.switchingSongsWithBrightnessKeys = r7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static SidekeySettingsFooterLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static SidekeySettingsFooterLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.sidekey_settings_footer_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static SidekeySettingsFooterLayoutBinding bind(View r10) {
        int r0 = R.id.boot_phone_tips;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r10, R.id.boot_phone_tips);
        if (r4 == null) goto L17;
        r0 = R.id.double_click_home_chooser;
        PreviewOptionsCheckView r5 = (PreviewOptionsCheckView) ViewBindings.findChildViewById(r10, R.id.double_click_home_chooser);
        if (r5 == null) goto L17;
        r0 = R.id.enable_idea_pills_tips;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r10, R.id.enable_idea_pills_tips);
        if (r6 == null) goto L17;
        r0 = R.id.id_shortcut_key_chooser;
        PreviewOptionsCheckView r7 = (PreviewOptionsCheckView) ViewBindings.findChildViewById(r10, R.id.id_shortcut_key_chooser);
        if (r7 == null) goto L17;
        r0 = R.id.switching_songs_tips;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r10, R.id.switching_songs_tips);
        if (r8 == null) goto L17;
        r0 = R.id.switching_songs_with_brightness_keys;
        SettingItemSwitch r9 = (SettingItemSwitch) ViewBindings.findChildViewById(r10, R.id.switching_songs_with_brightness_keys);
        if (r9 == null) goto L17;
        return new SidekeySettingsFooterLayoutBinding((LinearLayout) r10, r4, r5, r6, r7, r8, r9);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r10.getResources().getResourceName(r0)));
    }
}
