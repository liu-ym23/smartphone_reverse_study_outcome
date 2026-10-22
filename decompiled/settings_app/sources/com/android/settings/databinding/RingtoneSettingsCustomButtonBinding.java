package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.SettingItemButton;
import com.obric.oui.lisitem.OCardListItem;

/* JADX INFO: loaded from: classes2.dex */
public final class RingtoneSettingsCustomButtonBinding implements ViewBinding {
    public final SettingItemButton customRingtoneRecord;
    private final LinearLayout rootView;
    public final OCardListItem textMakeRingtone;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private RingtoneSettingsCustomButtonBinding(LinearLayout r1, SettingItemButton r2, OCardListItem r3) {
        this.rootView = r1;
        this.customRingtoneRecord = r2;
        this.textMakeRingtone = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RingtoneSettingsCustomButtonBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static RingtoneSettingsCustomButtonBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.ringtone_settings_custom_button, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static RingtoneSettingsCustomButtonBinding bind(View r3) {
        int r0 = R.id.custom_ringtone_record;
        SettingItemButton r1 = (SettingItemButton) ViewBindings.findChildViewById(r3, R.id.custom_ringtone_record);
        if (r1 == null) goto L9;
        r0 = R.id.text_make_ringtone;
        OCardListItem r2 = (OCardListItem) ViewBindings.findChildViewById(r3, R.id.text_make_ringtone);
        if (r2 == null) goto L9;
        return new RingtoneSettingsCustomButtonBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
