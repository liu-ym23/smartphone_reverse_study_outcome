package com.android.settings.accessibility;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceFrameLayout;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.CaptioningManager;
import androidx.fragment.app.FragmentActivity;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import com.android.internal.widget.SubtitleView;
import com.android.settings.R;
import com.android.settings.SettingsActivity;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.SwitchBar;
import com.android.settings.widget.ToggleSwitch;
import com.android.settingslib.accessibility.AccessibilityUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class CaptionPropertiesFragment extends SettingsPreferenceFragment implements Preference.OnPreferenceChangeListener, ListDialogPreference.OnValueChangedListener {
    private static final float LINE_HEIGHT_RATIO = 0.0533f;
    private static final String PREF_BACKGROUND_COLOR = "captioning_background_color";
    private static final String PREF_BACKGROUND_OPACITY = "captioning_background_opacity";
    private static final String PREF_CUSTOM = "custom";
    private static final String PREF_EDGE_COLOR = "captioning_edge_color";
    private static final String PREF_EDGE_TYPE = "captioning_edge_type";
    private static final String PREF_FONT_SIZE = "captioning_font_size";
    private static final String PREF_FOREGROUND_COLOR = "captioning_foreground_color";
    private static final String PREF_FOREGROUND_OPACITY = "captioning_foreground_opacity";
    private static final String PREF_LOCALE = "captioning_locale";
    private static final String PREF_PRESET = "captioning_preset";
    private static final String PREF_TYPEFACE = "captioning_typeface";
    private static final String PREF_WINDOW_COLOR = "captioning_window_color";
    private static final String PREF_WINDOW_OPACITY = "captioning_window_opacity";
    private ColorPreference mBackgroundColor;
    private ColorPreference mBackgroundOpacity;
    private CaptioningManager mCaptioningManager;
    private PreferenceCategory mCustom;
    private ColorPreference mEdgeColor;
    private EdgeTypePreference mEdgeType;
    private ListPreference mFontSize;
    private ColorPreference mForegroundColor;
    private ColorPreference mForegroundOpacity;
    private LocalePreference mLocale;
    private PresetPreference mPreset;
    private SubtitleView mPreviewText;
    private View mPreviewViewport;
    private View mPreviewWindow;
    private boolean mShowingCustom;
    private SwitchBar mSwitchBar;
    private ToggleSwitch mToggleSwitch;
    private ListPreference mTypeface;
    private ColorPreference mWindowColor;
    private ColorPreference mWindowOpacity;

    public void com_android_settings_accessibility_CaptionPropertiesFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_accessibility_CaptionPropertiesFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_accessibility_CaptionPropertiesFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public CaptionPropertiesFragment() {
    }

    static /* synthetic */ void access$000(CaptionPropertiesFragment r0) {
        r0.refreshPreviewText();
    }

    static /* synthetic */ SwitchBar access$100(CaptionPropertiesFragment r0) {
        return r0.mSwitchBar;
    }

    static /* synthetic */ SubtitleView access$200(CaptionPropertiesFragment r0) {
        return r0.mPreviewText;
    }

    public void com_android_settings_accessibility_CaptionPropertiesFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
        this.mCaptioningManager = (CaptioningManager) getSystemService("captioning");
        addPreferencesFromResource(R.xml.captioning_settings);
        initializeAllPreferences();
        updateAllPreferences();
        refreshShowingCustom();
        installUpdateListeners();
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        View r0 = r4.inflate(R.layout.captioning_preview, r5, false);
        if ((r5 instanceof PreferenceFrameLayout) == false) goto L5;
        r0.getLayoutParams().removeBorders = true;
    L5:
        View r3 = super.onCreateView(r4, r5, r6);
        ((ViewGroup) r0.findViewById(R.id.properties_fragment)).addView(r3, -1, -1);
        return r0;
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        boolean r4 = this.mCaptioningManager.isEnabled();
        SubtitleView r0 = r2.findViewById(R.id.preview_text);
        this.mPreviewText = r0;
        if (r4 == false) goto L5;
        int r5 = 0;
    L6:
        r0.setVisibility(r5);
        this.mPreviewWindow = r2.findViewById(R.id.preview_window);
        View r6 = r2.findViewById(R.id.preview_viewport);
        this.mPreviewViewport = r6;
        r6.addOnLayoutChangeListener(new AnonymousClass1(this));
        return;
    L5:
        r5 = 4;
        goto L6
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r2) {
        super.onActivityCreated(r2);
        boolean r3 = this.mCaptioningManager.isEnabled();
        SwitchBar r0 = ((SettingsActivity) getActivity()).getSwitchBar();
        this.mSwitchBar = r0;
        r0.setCheckedInternal(r3);
        this.mToggleSwitch = this.mSwitchBar.getSwitch();
        getPreferenceScreen().setEnabled(r3);
        refreshPreviewText();
        installSwitchBarToggleSwitch();
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        removeSwitchBarToggleSwitch();
    }

    private void refreshPreviewText() {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L5;
        return;
    L5:
        SubtitleView r1 = this.mPreviewText;
        if (r1 == null) goto L16;
        int r2 = this.mCaptioningManager.getRawUserStyle();
        applyCaptionProperties(this.mCaptioningManager, r1, this.mPreviewViewport, r2);
        Locale r3 = this.mCaptioningManager.getLocale();
        if (r3 == null) goto L10;
        r1.setText(AccessibilityUtils.getTextForLocale(r0, r3, R.string.captioning_preview_text));
    L11:
        CaptioningManager.CaptionStyle r4 = this.mCaptioningManager.getUserStyle();
        if (r4.hasWindowColor() == false) goto L14;
        this.mPreviewWindow.setBackgroundColor(r4.windowColor);
        return;
    L14:
        CaptioningManager.CaptionStyle r5 = CaptioningManager.CaptionStyle.DEFAULT;
        this.mPreviewWindow.setBackgroundColor(r5.windowColor);
        return;
    L10:
        r1.setText(R.string.captioning_preview_text);
        goto L11
    }

    public static void applyCaptionProperties(CaptioningManager r2, SubtitleView r3, View r4, int r5) {
        r3.setStyle(r5);
        Context r6 = r3.getContext();
        r6.getContentResolver();
        float r0 = r2.getFontScale();
        if (r4 == null) goto L5;
        r3.setTextSize(((Math.max(r4.getWidth() * 9, r4.getHeight() * 16) / 16.0f) * LINE_HEIGHT_RATIO) * r0);
    L6:
        Locale r7 = r2.getLocale();
        if (r7 == null) goto L9;
        r3.setText(AccessibilityUtils.getTextForLocale(r6, r7, R.string.captioning_preview_characters));
        return;
    L9:
        r3.setText(R.string.captioning_preview_characters);
        return;
    L5:
        r3.setTextSize(r6.getResources().getDimension(R.dimen.caption_preview_text_size) * r0);
        goto L6
    }

    protected void onInstallSwitchBarToggleSwitch() {
        this.mToggleSwitch.setOnBeforeCheckedChangeListener(new AnonymousClass2(this));
    }

    private void installSwitchBarToggleSwitch() {
        onInstallSwitchBarToggleSwitch();
        this.mSwitchBar.show();
    }

    private void removeSwitchBarToggleSwitch() {
        this.mSwitchBar.hide();
        this.mToggleSwitch.setOnBeforeCheckedChangeListener(null);
    }

    private void initializeAllPreferences() {
        this.mLocale = (LocalePreference) findPreference(PREF_LOCALE);
        this.mFontSize = (ListPreference) findPreference(PREF_FONT_SIZE);
        Resources r0 = getResources();
        int[] r1 = r0.getIntArray(R.array.captioning_preset_selector_values);
        String[] r2 = r0.getStringArray(R.array.captioning_preset_selector_titles);
        PresetPreference r3 = (PresetPreference) findPreference(PREF_PRESET);
        this.mPreset = r3;
        r3.setValues(r1);
        this.mPreset.setTitles(r2);
        this.mCustom = (PreferenceCategory) findPreference("custom");
        this.mShowingCustom = true;
        int[] r4 = r0.getIntArray(R.array.captioning_color_selector_values);
        String[] r5 = r0.getStringArray(R.array.captioning_color_selector_titles);
        ColorPreference r6 = (ColorPreference) this.mCustom.findPreference(PREF_FOREGROUND_COLOR);
        this.mForegroundColor = r6;
        r6.setTitles(r5);
        this.mForegroundColor.setValues(r4);
        int[] r7 = r0.getIntArray(R.array.captioning_opacity_selector_values);
        String[] r8 = r0.getStringArray(R.array.captioning_opacity_selector_titles);
        ColorPreference r9 = (ColorPreference) this.mCustom.findPreference(PREF_FOREGROUND_OPACITY);
        this.mForegroundOpacity = r9;
        r9.setTitles(r8);
        this.mForegroundOpacity.setValues(r7);
        ColorPreference r10 = (ColorPreference) this.mCustom.findPreference(PREF_EDGE_COLOR);
        this.mEdgeColor = r10;
        r10.setTitles(r5);
        this.mEdgeColor.setValues(r4);
        int[] r11 = new int[r4.length + 1];
        String[] r12 = new String[r5.length + 1];
        System.arraycopy(r4, 0, r11, 1, r4.length);
        System.arraycopy(r5, 0, r12, 1, r5.length);
        r11[0] = 0;
        r12[0] = getString(R.string.color_none);
        ColorPreference r13 = (ColorPreference) this.mCustom.findPreference(PREF_BACKGROUND_COLOR);
        this.mBackgroundColor = r13;
        r13.setTitles(r12);
        this.mBackgroundColor.setValues(r11);
        ColorPreference r14 = (ColorPreference) this.mCustom.findPreference(PREF_BACKGROUND_OPACITY);
        this.mBackgroundOpacity = r14;
        r14.setTitles(r8);
        this.mBackgroundOpacity.setValues(r7);
        ColorPreference r15 = (ColorPreference) this.mCustom.findPreference(PREF_WINDOW_COLOR);
        this.mWindowColor = r15;
        r15.setTitles(r12);
        this.mWindowColor.setValues(r11);
        ColorPreference r16 = (ColorPreference) this.mCustom.findPreference(PREF_WINDOW_OPACITY);
        this.mWindowOpacity = r16;
        r16.setTitles(r8);
        this.mWindowOpacity.setValues(r7);
        this.mEdgeType = (EdgeTypePreference) this.mCustom.findPreference(PREF_EDGE_TYPE);
        this.mTypeface = (ListPreference) this.mCustom.findPreference(PREF_TYPEFACE);
    }

    private void installUpdateListeners() {
        this.mPreset.setOnValueChangedListener(this);
        this.mForegroundColor.setOnValueChangedListener(this);
        this.mForegroundOpacity.setOnValueChangedListener(this);
        this.mEdgeColor.setOnValueChangedListener(this);
        this.mBackgroundColor.setOnValueChangedListener(this);
        this.mBackgroundOpacity.setOnValueChangedListener(this);
        this.mWindowColor.setOnValueChangedListener(this);
        this.mWindowOpacity.setOnValueChangedListener(this);
        this.mEdgeType.setOnValueChangedListener(this);
        this.mTypeface.setOnPreferenceChangeListener(this);
        this.mFontSize.setOnPreferenceChangeListener(this);
        this.mLocale.setOnPreferenceChangeListener(this);
    }

    private void updateAllPreferences() {
        this.mPreset.setValue(this.mCaptioningManager.getRawUserStyle());
        this.mFontSize.setValue(Float.toString(this.mCaptioningManager.getFontScale()));
        CaptioningManager.CaptionStyle r0 = CaptioningManager.CaptionStyle.getCustomStyle(getContentResolver());
        this.mEdgeType.setValue(r0.edgeType);
        this.mEdgeColor.setValue(r0.edgeColor);
        int r2 = 16777215;
        if (r0.hasForegroundColor() == false) goto L5;
        int r1 = r0.foregroundColor;
    L6:
        parseColorOpacity(this.mForegroundColor, this.mForegroundOpacity, r1);
        if (r0.hasBackgroundColor() == false) goto L9;
        int r3 = r0.backgroundColor;
    L10:
        parseColorOpacity(this.mBackgroundColor, this.mBackgroundOpacity, r3);
        if (r0.hasWindowColor() == false) goto L13;
        r2 = r0.windowColor;
    L13:
        parseColorOpacity(this.mWindowColor, this.mWindowOpacity, r2);
        String r4 = r0.mRawTypeface;
        ListPreference r5 = this.mTypeface;
        String r6 = "";
        if (r4 != null) goto L16;
        r4 = "";
    L16:
        r5.setValue(r4);
        String r7 = this.mCaptioningManager.getRawLocale();
        LocalePreference r8 = this.mLocale;
        if (r7 == null) goto L20;
        r6 = r7;
    L20:
        r8.setValue(r6);
        return;
    L9:
        r3 = 16777215;
        goto L10
    L5:
        r1 = 16777215;
        goto L6
    }

    private void parseColorOpacity(ColorPreference r3, ColorPreference r4, int r5) {
        if (CaptioningManager.CaptionStyle.hasColor(r5) == true) goto L6;
        int r2 = (r5 & 255) << 24;
        int r6 = 16777215;
    L9:
        r4.setValue(r2 | 16777215);
        r3.setValue(r6);
        return;
    L6:
        if ((r5 >>> 24) != 0) goto L8;
        r2 = (r5 & 255) << 24;
        r6 = 0;
        goto L9
    L8:
        r2 = (-16777216) & r5;
        r6 = r5 | (-16777216);
        goto L9
    }

    private int mergeColorOpacity(ColorPreference r1, ColorPreference r2) {
        int r0 = r1.getValue();
        int r3 = r2.getValue();
        if (CaptioningManager.CaptionStyle.hasColor(r0) == false) goto L9;
        if (r0 != 0) goto L8;
        return Color.alpha(r3);
    L8:
        return (r0 & 16777215) | (r3 & (-16777216));
    L9:
        return 16776960 | Color.alpha(r3);
    }

    private void refreshShowingCustom() {
        if (this.mPreset.getValue() != (-1)) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
    L10:
        if (r0 == true) goto L12;
        return;
    L12:
        if (this.mShowingCustom == true) goto L17;
        getPreferenceScreen().addPreference(this.mCustom);
        this.mShowingCustom = true;
        return;
    L17:
        return;
    L8:
        if (this.mShowingCustom == false) goto L10;
        getPreferenceScreen().removePreference(this.mCustom);
        this.mShowingCustom = false;
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.android.settings.accessibility.ListDialogPreference.OnValueChangedListener
    public void onValueChanged(ListDialogPreference r4, int r5) {
        ContentResolver r0 = getActivity().getContentResolver();
        ColorPreference r1 = this.mForegroundColor;
        if (r1 != r4) goto L5;
    L28:
        Settings.Secure.putInt(r0, "accessibility_captioning_foreground_color", mergeColorOpacity(r1, this.mForegroundOpacity));
    L29:
        refreshPreviewText();
        return;
    L5:
        if (this.mForegroundOpacity == r4) goto L28;
        ColorPreference r2 = this.mBackgroundColor;
        if (r2 != r4) goto L10;
    L27:
        Settings.Secure.putInt(r0, "accessibility_captioning_background_color", mergeColorOpacity(r2, this.mBackgroundOpacity));
        goto L29
    L10:
        if (this.mBackgroundOpacity == r4) goto L27;
        ColorPreference r3 = this.mWindowColor;
        if (r3 != r4) goto L15;
    L26:
        Settings.Secure.putInt(r0, "accessibility_captioning_window_color", mergeColorOpacity(r3, this.mWindowOpacity));
        goto L29
    L15:
        if (this.mWindowOpacity == r4) goto L26;
        if (this.mEdgeColor != r4) goto L21;
        Settings.Secure.putInt(r0, "accessibility_captioning_edge_color", r5);
        goto L29
    L21:
        if (this.mPreset != r4) goto L24;
        Settings.Secure.putInt(r0, "accessibility_captioning_preset", r5);
        refreshShowingCustom();
        goto L29
    L24:
        if (this.mEdgeType != r4) goto L29;
        Settings.Secure.putInt(r0, "accessibility_captioning_edge_type", r5);
        goto L29
    }

    @Override // androidx.preference.Preference.OnPreferenceChangeListener
    public boolean onPreferenceChange(Preference r3, Object r4) {
        ContentResolver r0 = getActivity().getContentResolver();
        if (this.mTypeface != r3) goto L6;
        Settings.Secure.putString(r0, "accessibility_captioning_typeface", (String) r4);
    L11:
        refreshPreviewText();
        return true;
    L6:
        if (this.mFontSize != r3) goto L9;
        Settings.Secure.putFloat(r0, "accessibility_captioning_font_scale", Float.parseFloat((String) r4));
        goto L11
    L9:
        if (this.mLocale != r3) goto L11;
        Settings.Secure.putString(r0, "accessibility_captioning_locale", (String) r4);
        goto L11
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_accessibility_CaptionPropertiesFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(CaptionPropertiesFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_accessibility_CaptionPropertiesFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accessibility_CaptionPropertiesFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(CaptionPropertiesFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_accessibility_CaptionPropertiesFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_accessibility_CaptionPropertiesFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(CaptionPropertiesFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_accessibility_CaptionPropertiesFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
