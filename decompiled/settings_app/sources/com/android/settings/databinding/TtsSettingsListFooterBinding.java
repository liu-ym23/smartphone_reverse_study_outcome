package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.widget.SettingCommonSeekBar;

/* JADX INFO: loaded from: classes2.dex */
public final class TtsSettingsListFooterBinding implements ViewBinding {
    public final TextView idTtsEngineStatus;
    public final ImageView idTtsExampleAudio;
    public final SettingCommonSeekBar idTtsSpeechPitch;
    public final SettingCommonSeekBar idTtsSpeechRate;
    private final LinearLayout rootView;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private TtsSettingsListFooterBinding(LinearLayout r1, TextView r2, ImageView r3, SettingCommonSeekBar r4, SettingCommonSeekBar r5) {
        this.rootView = r1;
        this.idTtsEngineStatus = r2;
        this.idTtsExampleAudio = r3;
        this.idTtsSpeechPitch = r4;
        this.idTtsSpeechRate = r5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static TtsSettingsListFooterBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static TtsSettingsListFooterBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.tts_settings_list_footer, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static TtsSettingsListFooterBinding bind(View r8) {
        int r0 = R.id.id_tts_engine_status;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r8, R.id.id_tts_engine_status);
        if (r4 == null) goto L13;
        r0 = R.id.id_tts_example_audio;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r8, R.id.id_tts_example_audio);
        if (r5 == null) goto L13;
        r0 = R.id.id_tts_speech_pitch;
        SettingCommonSeekBar r6 = (SettingCommonSeekBar) ViewBindings.findChildViewById(r8, R.id.id_tts_speech_pitch);
        if (r6 == null) goto L13;
        r0 = R.id.id_tts_speech_rate;
        SettingCommonSeekBar r7 = (SettingCommonSeekBar) ViewBindings.findChildViewById(r8, R.id.id_tts_speech_rate);
        if (r7 == null) goto L13;
        return new TtsSettingsListFooterBinding((LinearLayout) r8, r4, r5, r6, r7);
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r8.getResources().getResourceName(r0)));
    }
}
