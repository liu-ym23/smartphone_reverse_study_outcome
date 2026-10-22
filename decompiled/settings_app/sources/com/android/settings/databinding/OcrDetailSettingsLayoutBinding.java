package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class OcrDetailSettingsLayoutBinding implements ViewBinding {
    public final SettingItemText idAudioLanguage;
    public final TextView idAudioTips;
    public final SettingItemText idOcrLanguage;
    public final TextView idOcrTips;
    public final TextView idOcrTipsV2;
    private final RelativeLayout rootView;
    public final LinearLayout viewList;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private OcrDetailSettingsLayoutBinding(RelativeLayout r1, SettingItemText r2, TextView r3, SettingItemText r4, TextView r5, TextView r6, LinearLayout r7, OFloatingTitleBar r8) {
        this.rootView = r1;
        this.idAudioLanguage = r2;
        this.idAudioTips = r3;
        this.idOcrLanguage = r4;
        this.idOcrTips = r5;
        this.idOcrTipsV2 = r6;
        this.viewList = r7;
        this.viewTitle = r8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static OcrDetailSettingsLayoutBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static OcrDetailSettingsLayoutBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.ocr_detail_settings_layout, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static OcrDetailSettingsLayoutBinding bind(View r11) {
        int r0 = R.id.id_audio_language;
        SettingItemText r4 = (SettingItemText) ViewBindings.findChildViewById(r11, R.id.id_audio_language);
        if (r4 == null) goto L19;
        r0 = R.id.id_audio_tips;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r11, R.id.id_audio_tips);
        if (r5 == null) goto L19;
        r0 = R.id.id_ocr_language;
        SettingItemText r6 = (SettingItemText) ViewBindings.findChildViewById(r11, R.id.id_ocr_language);
        if (r6 == null) goto L19;
        r0 = R.id.id_ocr_tips;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r11, R.id.id_ocr_tips);
        if (r7 == null) goto L19;
        r0 = R.id.id_ocr_tips_v2;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r11, R.id.id_ocr_tips_v2);
        if (r8 == null) goto L19;
        r0 = R.id.view_list;
        LinearLayout r9 = (LinearLayout) ViewBindings.findChildViewById(r11, R.id.view_list);
        if (r9 == null) goto L19;
        r0 = R.id.view_title;
        OFloatingTitleBar r10 = (OFloatingTitleBar) ViewBindings.findChildViewById(r11, R.id.view_title);
        if (r10 == null) goto L19;
        return new OcrDetailSettingsLayoutBinding((RelativeLayout) r11, r4, r5, r6, r7, r8, r9, r10);
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }
}
