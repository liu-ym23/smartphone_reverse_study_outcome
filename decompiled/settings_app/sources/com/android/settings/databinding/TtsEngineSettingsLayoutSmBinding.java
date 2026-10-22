package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.titlebar.OFloatingTitleBar;
import obric.widget.ListContentItemText;

/* JADX INFO: loaded from: classes2.dex */
public final class TtsEngineSettingsLayoutSmBinding implements ViewBinding {
    public final ListContentItemText idEngineLanguage;
    public final ListContentItemText idEngineSetting;
    public final ListContentItemText idEngineVoicedata;
    private final RelativeLayout rootView;
    public final OFloatingTitleBar viewTitle;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private TtsEngineSettingsLayoutSmBinding(RelativeLayout r1, ListContentItemText r2, ListContentItemText r3, ListContentItemText r4, OFloatingTitleBar r5) {
        this.rootView = r1;
        this.idEngineLanguage = r2;
        this.idEngineSetting = r3;
        this.idEngineVoicedata = r4;
        this.viewTitle = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static TtsEngineSettingsLayoutSmBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static TtsEngineSettingsLayoutSmBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.tts_engine_settings_layout_sm, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static TtsEngineSettingsLayoutSmBinding bind(View r8) {
        int r0 = R.id.id_engine_language;
        ListContentItemText r4 = (ListContentItemText) ViewBindings.findChildViewById(r8, R.id.id_engine_language);
        if (r4 == null) goto L13;
        r0 = R.id.id_engine_setting;
        ListContentItemText r5 = (ListContentItemText) ViewBindings.findChildViewById(r8, R.id.id_engine_setting);
        if (r5 == null) goto L13;
        r0 = R.id.id_engine_voicedata;
        ListContentItemText r6 = (ListContentItemText) ViewBindings.findChildViewById(r8, R.id.id_engine_voicedata);
        if (r6 == null) goto L13;
        r0 = R.id.view_title;
        OFloatingTitleBar r7 = (OFloatingTitleBar) ViewBindings.findChildViewById(r8, R.id.view_title);
        if (r7 == null) goto L13;
        return new TtsEngineSettingsLayoutSmBinding((RelativeLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
