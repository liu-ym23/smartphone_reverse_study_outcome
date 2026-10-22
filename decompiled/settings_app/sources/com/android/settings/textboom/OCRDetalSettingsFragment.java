package com.android.settings.textboom;

import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.settings.ImageSpanAlignCenter;
import com.android.settings.R;
import com.android.settings.SettingsTracker;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public class OCRDetalSettingsFragment extends BaseFragment implements View.OnClickListener {
    private SettingItemText mOCRAudio;
    private SettingItemText mOCRLanguage;

    public void com_android_settings_textboom_OCRDetalSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_textboom_OCRDetalSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_textboom_OCRDetalSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public OCRDetalSettingsFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r5, ViewGroup r6, Bundle r7) {
        this.mRootView = r5.inflate(R.layout.ocr_detail_settings_layout, r6, false);
        SettingItemText r8 = (SettingItemText) findViewByIdNullable(R.id.id_ocr_language);
        this.mOCRLanguage = r8;
        r8.setOnClickListener(this);
        SettingItemText r9 = (SettingItemText) findViewByIdNullable(R.id.id_audio_language);
        this.mOCRAudio = r9;
        r9.setOnClickListener(this);
        TextView r10 = (TextView) findViewByIdNullable(R.id.id_ocr_tips);
        String r11 = getString(R.string.ocr_tips);
        SpannableStringBuilder r12 = new SpannableStringBuilder(r11);
        Matcher r13 = Pattern.compile("/camscanner/").matcher(r11);
    L4:
        if (r13.find() == false) goto L6;
        r12.setSpan(new ImageSpanAlignCenter(this.mContext, R.drawable.bigbang_scan), r13.start(), r13.end(), 33);
        goto L4
    L6:
        r10.setText(r12);
        this.mTitleResId = Integer.valueOf(R.string.ocr_detail_setting_title);
        return this.mRootView;
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        this.mOCRLanguage.setSubTitle(getOCRLangSubtitle(this.mContext));
        this.mOCRAudio.setSubTitle(getOCRAudioMode(this.mContext));
    }

    public void com_android_settings_textboom_OCRDetalSettingsFragment__onResume$___twin___() {
        super.onResume();
        this.mOCRLanguage.setSubTitle(getOCRLangSubtitle(this.mContext));
        this.mOCRAudio.setSubTitle(getOCRAudioMode(this.mContext));
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (this.mOCRLanguage != r2) goto L6;
        start(OCRLanguageChooserFragment.class);
        SettingsTracker.onItemClick(803);
        return;
    L6:
        if (this.mOCRAudio != r2) goto L10;
        start(OcrAudioModeFragment.class);
        return;
    }

    public String getOCRAudioMode(Context r1) {
        if (OcrAudioModeFragment.getDefaultLangMode(r1) != 0) goto L7;
        return this.mContext.getString(R.string.language_chinese);
    L7:
        return this.mContext.getString(R.string.language_english);
    }

    public static String getOCRLangSubtitle(Context r7) {
        String[] r0 = r7.getResources().getStringArray(R.array.ocr_language_list);
        int r8 = Settings.Global.getInt(r7.getContentResolver(), "big_bang_ocr_language", 3);
        StringBuilder r1 = new StringBuilder("");
        int r3 = 0;
    L3:
        boolean r6 = true;
        if (r3 >= OCRLanguageChooserFragment.sOCRLangArray.length) goto L12;
        if ((OCRLanguageChooserFragment.sOCRLangArray[r3].intValue() & r8) > 0) goto L9;
        r6 = false;
    L9:
        if (r6 == false) goto L11;
        r1.append(r0[r3]).append("、");
    L11:
        r3 = r3 + 1;
        goto L3
    L12:
        String r9 = r1.toString();
        if (r9.endsWith("、") == true) goto L15;
        return r9;
    L15:
        return r9.substring(0, r9.length() - 1);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_textboom_OCRDetalSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(OCRDetalSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_textboom_OCRDetalSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_textboom_OCRDetalSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(OCRDetalSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_textboom_OCRDetalSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_textboom_OCRDetalSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(OCRDetalSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_textboom_OCRDetalSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
