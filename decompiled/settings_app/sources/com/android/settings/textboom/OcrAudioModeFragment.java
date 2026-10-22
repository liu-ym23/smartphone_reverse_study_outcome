package com.android.settings.textboom;

import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import com.android.settings.R;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.ListContentItemCheck;

/* JADX INFO: loaded from: classes2.dex */
public class OcrAudioModeFragment extends BaseFragment implements View.OnClickListener {
    public static final int OCR_AUDIO_LANGUAGE_CHINESE = 0;
    public static final int OCR_AUDIO_LANGUAGE_ENGLISH = 1;
    private ListContentItemCheck mChineseModeCheck;
    private ListContentItemCheck mEnglishModeCheck;
    private int mSelectedMode;

    public void com_android_settings_textboom_OcrAudioModeFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_textboom_OcrAudioModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_textboom_OcrAudioModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public OcrAudioModeFragment() {
        super(R.layout.ocr_audio_mode);
        this.mSelectedMode = -1;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        OFloatingTitleBar r3 = (OFloatingTitleBar) findViewByIdNullable(R.id.view_title);
        this.mEnglishModeCheck = (ListContentItemCheck) findViewByIdNullable(R.id.id_language_eng);
        this.mChineseModeCheck = (ListContentItemCheck) findViewByIdNullable(R.id.id_language_chn);
        this.mEnglishModeCheck.setOnClickListener(this);
        this.mChineseModeCheck.setOnClickListener(this);
        checkMode(getDefaultLangMode(getContext()));
    }

    public void com_android_settings_textboom_OcrAudioModeFragment__onResume$___twin___() {
        super.onResume();
        checkMode(getDefaultLangMode(getContext()));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r5) {
        ListContentItemCheck r0 = this.mEnglishModeCheck;
        if (r5 != r0) goto L6;
        r0.setChecked(true);
        this.mChineseModeCheck.setChecked(false);
        this.mSelectedMode = 1;
        return;
    L6:
        if (r5 != this.mChineseModeCheck) goto L10;
        r0.setChecked(false);
        this.mChineseModeCheck.setChecked(true);
        this.mSelectedMode = 0;
        return;
    }

    public static int getDefaultLangMode(Context r2) {
        return Settings.Global.getInt(r2.getContentResolver(), "big_bang_ocr_audio_language", 0);
    }

    private void checkMode(int r3) {
        if (this.mSelectedMode != r3) goto L5;
        return;
    L5:
        this.mSelectedMode = r3;
        if (r3 != 0) goto L8;
        this.mEnglishModeCheck.setChecked(false);
        this.mChineseModeCheck.setChecked(true);
        return;
    L8:
        this.mEnglishModeCheck.setChecked(true);
        this.mChineseModeCheck.setChecked(false);
    }

    private void setOCrAudioMode() {
        Settings.Global.putInt(getContentResolver(), "big_bang_ocr_audio_language", this.mSelectedMode);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        setOCrAudioMode();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_textboom_OcrAudioModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(OcrAudioModeFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_textboom_OcrAudioModeFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_textboom_OcrAudioModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(OcrAudioModeFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_textboom_OcrAudioModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_textboom_OcrAudioModeFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(OcrAudioModeFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_textboom_OcrAudioModeFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
