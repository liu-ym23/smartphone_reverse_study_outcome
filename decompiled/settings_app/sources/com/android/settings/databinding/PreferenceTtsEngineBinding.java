package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;

/* JADX INFO: loaded from: classes2.dex */
public final class PreferenceTtsEngineBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final RadioButton ttsEngineRadiobutton;
    public final ImageView ttsEngineSettings;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private PreferenceTtsEngineBinding(LinearLayout r1, RadioButton r2, ImageView r3) {
        this.rootView = r1;
        this.ttsEngineRadiobutton = r2;
        this.ttsEngineSettings = r3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PreferenceTtsEngineBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static PreferenceTtsEngineBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.preference_tts_engine, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static PreferenceTtsEngineBinding bind(View r3) {
        int r0 = R.id.tts_engine_radiobutton;
        RadioButton r1 = (RadioButton) ViewBindings.findChildViewById(r3, R.id.tts_engine_radiobutton);
        if (r1 == null) goto L9;
        r0 = R.id.tts_engine_settings;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(r3, R.id.tts_engine_settings);
        if (r2 == null) goto L9;
        return new PreferenceTtsEngineBinding((LinearLayout) r3, r1, r2);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r3.getResources().getResourceName(r0)));
    }
}
