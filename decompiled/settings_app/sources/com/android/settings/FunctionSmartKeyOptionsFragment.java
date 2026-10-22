package com.android.settings;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bytedanceos.api.SettingsSmt;
import bytedanceos.util.SettingsUtil;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.SettingItemImage;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.app.settings.search.SettingsSwitchKeyUtil;
import obric.widget.SettingItemCheck;

/* JADX INFO: loaded from: classes2.dex */
public class FunctionSmartKeyOptionsFragment extends BaseFragment {
    private static final int DIALOG_TYPE_DISABLE_IDEA_PILLS = 1;
    private static final int DIALOG_TYPE_ENABLE_CMEL_OPTION = 3;
    private static final int DIALOG_TYPE_ENABLE_OPTION = 2;
    private static final String SIDE_BAR_PACKAGENAME = "com.bytedanceos.sidebar";
    private static final int UPDATE_VIEW_DELAY_TIME = 100;
    private static final boolean sIsCmelVersion = false;
    private String mCurrentValue;
    private AlertDialog mDialog;
    private int mDialogType;
    private String mDoubleClickCurrentValue;
    private ContentObserver mDoubleClickFunctionChanged;
    private TextView mDoubleOptionHeaderText;
    private SettingItemCheck mDoubleOptionLiveSubtitles;
    private SettingItemCheck mDoubleOptionNone;
    private SettingItemCheck mDoubleOptionWallet;
    private Handler mHandler;
    private View.OnClickListener mIntroVideoClickListener;
    private boolean mOneStepEnabled;
    private SettingItemImage mOneStepVideo;
    private View.OnClickListener mOptionClickListener;
    private SettingItemCheck mOptionCmel;
    private SettingItemCheck mOptionNone;
    private SettingItemCheck mOptionOneStep;
    private SettingItemCheck mOptionthinkboost;
    private boolean mthinkboostEnabled;
    private SettingItemImage mthinkboostVideo;

    public void com_android_settings_FunctionSmartKeyOptionsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_FunctionSmartKeyOptionsFragment__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_FunctionSmartKeyOptionsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_FunctionSmartKeyOptionsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public FunctionSmartKeyOptionsFragment() {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mOptionClickListener = new AnonymousClass1(this);
        this.mIntroVideoClickListener = new AnonymousClass2(this);
        final Handler r1 = null;
        this.mDoubleClickFunctionChanged = new AnonymousClass7(this, r1);
    }

    static /* synthetic */ boolean access$000(FunctionSmartKeyOptionsFragment r0) {
        return r0.mthinkboostEnabled;
    }

    static /* synthetic */ int access$102(FunctionSmartKeyOptionsFragment r0, int r1) {
        r0.mDialogType = r1;
        return r1;
    }

    static /* synthetic */ void access$200(FunctionSmartKeyOptionsFragment r0, int r1) {
        r0.showWarning(r1);
    }

    static /* synthetic */ void access$300(FunctionSmartKeyOptionsFragment r0) {
        r0.enablethinkboostIfNeed();
    }

    static /* synthetic */ boolean access$400(FunctionSmartKeyOptionsFragment r0) {
        return r0.mOneStepEnabled;
    }

    static /* synthetic */ void access$500(FunctionSmartKeyOptionsFragment r0, String r1) {
        r0.setDoubleClickFunction(r1);
    }

    static /* synthetic */ void access$600(FunctionSmartKeyOptionsFragment r0, int r1) {
        r0.playUsageVideo(r1);
    }

    static /* synthetic */ void access$700(FunctionSmartKeyOptionsFragment r0) {
        r0.enableOptionByType();
    }

    static /* synthetic */ Handler access$800(FunctionSmartKeyOptionsFragment r0) {
        return r0.mHandler;
    }

    static {
        sIsCmelVersion = SettingsFeature.isCmelVersion();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        int r0 = 0;
        if (SettingsFeature.isDarwin() == false) goto L5;
        this.mRootView = r2.inflate(R.layout.smart_key_options_layout, r3, false);
    L6:
        this.mTitleResId = Integer.valueOf(R.string.smart_key_title);
        this.mOptionNone = (SettingItemCheck) findViewByIdNullable(R.id.id_item_option_none);
        this.mOptionCmel = (SettingItemCheck) findViewByIdNullable(R.id.id_item_option_cmel);
        this.mOptionthinkboost = (SettingItemCheck) findViewByIdNullable(R.id.id_item_option_idea_pills);
        this.mOptionOneStep = (SettingItemCheck) findViewByIdNullable(R.id.id_item_option_one_step);
        this.mDoubleOptionHeaderText = (TextView) findViewByIdNullable(R.id.double_click_header_text);
        this.mDoubleOptionNone = (SettingItemCheck) findViewByIdNullable(R.id.double_click_option_none);
        this.mDoubleOptionLiveSubtitles = (SettingItemCheck) findViewByIdNullable(R.id.double_click_live_subtitles);
        this.mDoubleOptionWallet = (SettingItemCheck) findViewByIdNullable(R.id.double_click_wallet);
        if (SettingsFeature.isDarwin() == true) goto L9;
        this.mDoubleOptionHeaderText.setVisibility(8);
        this.mDoubleOptionNone.setVisibility(8);
        this.mDoubleOptionLiveSubtitles.setVisibility(8);
        this.mDoubleOptionWallet.setVisibility(8);
    L9:
        this.mOptionNone.setOnClickListener(this.mOptionClickListener);
        this.mOptionCmel.setOnClickListener(this.mOptionClickListener);
        this.mOptionCmel.setOnDisabledClickListener(new AnonymousClass3(this));
        this.mOptionthinkboost.setOnClickListener(this.mOptionClickListener);
        this.mOptionOneStep.setOnClickListener(this.mOptionClickListener);
        SettingItemCheck r5 = this.mOptionCmel;
        if (sIsCmelVersion == true) goto L13;
        r0 = 8;
    L13:
        r5.setVisibility(r0);
        if (SettingsFeature.isDarwin() == true) goto L16;
        SettingItemImage r6 = (SettingItemImage) findViewByIdNullable(R.id.idea_pills_video_intro);
        this.mthinkboostVideo = r6;
        r6.setOnClickListener(this.mIntroVideoClickListener);
        SettingItemImage r7 = (SettingItemImage) findViewByIdNullable(R.id.one_step_video_intro);
        this.mOneStepVideo = r7;
        r7.setOnClickListener(this.mIntroVideoClickListener);
    L16:
        this.mDoubleOptionNone.setOnClickListener(this.mOptionClickListener);
        this.mDoubleOptionWallet.setOnClickListener(this.mOptionClickListener);
        this.mDoubleOptionLiveSubtitles.setOnClickListener(this.mOptionClickListener);
        return this.mRootView;
    L5:
        this.mRootView = r2.inflate(R.layout.smart_key_options_extend_layout, r3, false);
        goto L6
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
        registerContentObserver();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        unRegisterContentObserver();
    }

    private void enablethinkboostIfNeed() {
        if (this.mthinkboostEnabled == true) goto L6;
        android.provider.Settings.Global.putInt(getContentResolver(), SettingsSwitchKeyUtil.VOICE_INPUT, 1);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
        registerContentObserver();
    }

    public void updateViews() {
        this.mOptionNone.setChecked(false);
        this.mOptionCmel.setChecked(false);
        this.mOptionthinkboost.setChecked(false);
        this.mOptionOneStep.setChecked(false);
        if (android.provider.Settings.Global.getInt(getContentResolver(), SettingsSwitchKeyUtil.VOICE_INPUT, 0) != 1) goto L5;
        boolean r0 = true;
    L6:
        this.mthinkboostEnabled = r0;
        if (android.provider.Settings.Global.getInt(getContentResolver(), "side_bar_mode", 0) != 1) goto L9;
        boolean r1 = true;
    L10:
        this.mOneStepEnabled = r1;
        this.mCurrentValue = android.provider.Settings.Global.getString(getContentResolver(), "smart_key_click_function");
        if (SettingsUtil.isAccessibilityEnabled(this.mContext) == false) goto L16;
        this.mOptionOneStep.setVisibility(8);
        if ("side_bar".equals(this.mCurrentValue) == false) goto L16;
        disableSmartKey(this.mContext);
        this.mCurrentValue = null;
    L16:
        if ("feature_cmel".equals(this.mCurrentValue) == false) goto L19;
        this.mOptionCmel.setChecked(true);
    L32:
        if (sIsCmelVersion == false) goto L34;
        this.mOptionCmel.setEnabled(Utils.isPackageInstalled(this.mContext, Constants.PKG_CMEL_ESPORT_COMMUNITY));
    L34:
        this.mDoubleOptionNone.setChecked(false);
        this.mDoubleOptionLiveSubtitles.setChecked(false);
        this.mDoubleOptionWallet.setChecked(false);
        String r2 = getDoubleClickFunction();
        this.mDoubleClickCurrentValue = r2;
        if ("wallet".equals(r2) == false) goto L38;
        this.mDoubleOptionWallet.setChecked(true);
        return;
    L38:
        if ("accessibility_transcription".equals(this.mDoubleClickCurrentValue) == false) goto L40;
        this.mDoubleOptionLiveSubtitles.setChecked(true);
        return;
    L40:
        this.mDoubleOptionNone.setChecked(true);
        return;
    L19:
        if ("side_bar".equals(this.mCurrentValue) == false) goto L22;
        this.mOptionOneStep.setChecked(true);
        goto L32
    L22:
        if ("undefine".equals(this.mCurrentValue) == true) goto L32;
        if (this.mCurrentValue != null) goto L28;
        this.mOptionNone.setChecked(true);
        goto L32
    L28:
        if (android.provider.Settings.Global.getInt(this.mContext.getContentResolver(), SettingsSwitchKeyUtil.VOICE_INPUT, 1) != 1) goto L30;
        this.mOptionthinkboost.setChecked(true);
        goto L32
    L30:
        this.mOptionNone.setChecked(true);
        goto L32
    L9:
        r1 = false;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    public static void enableSmartKeyAsCmel(Context r2) {
        ContentResolver r3 = r2.getContentResolver();
        android.provider.Settings.Global.putString(r3, "smart_key_click_function", "feature_cmel");
        android.provider.Settings.Global.putString(r3, "smart_key_long_click_function", "feature_cmel");
        android.provider.Settings.Global.putString(r3, "smart_key_long_click_function_when_screen_off", "feature_cmel");
    }

    public static void enableSmartKeyAsthinkboost(Context r2) {
        ContentResolver r3 = r2.getContentResolver();
        android.provider.Settings.Global.putString(r3, "smart_key_click_function", "idea_pills_list");
        android.provider.Settings.Global.putString(r3, "smart_key_long_click_function", "idea_pills");
        android.provider.Settings.Global.putString(r3, "smart_key_long_click_function_when_screen_off", "idea_pills");
        android.provider.Settings.Global.putInt(r3, SettingsSwitchKeyUtil.VOICE_INPUT, 1);
    }

    public static void disableSmartKey(Context r2) {
        ContentResolver r3 = r2.getContentResolver();
        android.provider.Settings.Global.putString(r3, "smart_key_click_function", SettingsSmt.SHORTCUT_KEY_VALUE.NONE);
        android.provider.Settings.Global.putString(r3, "smart_key_long_click_function", SettingsSmt.SHORTCUT_KEY_VALUE.NONE);
        android.provider.Settings.Global.putString(r3, "smart_key_long_click_function_when_screen_off", SettingsSmt.SHORTCUT_KEY_VALUE.NONE);
    }

    private void showWarning(int r4) {
        AlertDialog.Builder r0 = new AlertDialog.Builder(this._mActivity);
        r0.setTitle(R.string.dlg_title_notice);
        r0.setNegativeButton(android.R.string.cancel, null);
        if (r4 != 1) goto L5;
        AlertDialog.Builder r5 = handleOptionDisableIdeapill(r0);
    L13:
        AlertDialog r6 = r5.create();
        this.mDialog = r6;
        r6.show();
        return;
    L5:
        if (r4 != 2) goto L7;
        r5 = handleOptionEnable(r0);
        goto L13
    L7:
        if (r4 != 3) goto L10;
        r5 = handleCmelOptionDialog(r0);
        goto L13
    L10:
        throw new IllegalArgumentException("dialog type is invalidate");
    }

    private AlertDialog.Builder handleCmelOptionDialog(AlertDialog.Builder r2) {
        r2.setMessage(R.string.cmel_esport_community_install_dialog_msg);
        r2.setPositiveButton(R.string.install_text, new AnonymousClass4(this));
        return r2;
    }

    private AlertDialog.Builder handleOptionEnable(AlertDialog.Builder r4) {
        String r0 = getString(R.string.undefined);
        int r1 = this.mDialogType;
        if (r1 != R.id.id_item_option_idea_pills) goto L6;
        r0 = getString(R.string.idea_pills_beta);
    L8:
        r4.setMessage(getString(R.string.smart_key_enable_tips, new Object[]{r0}));
        r4.setPositiveButton(R.string.ok, new AnonymousClass5(this));
        return r4;
    L6:
        if (r1 != R.id.id_item_option_one_step) goto L8;
        r0 = getString(R.string.one_step_settings);
        goto L8
    }

    private AlertDialog.Builder handleOptionDisableIdeapill(AlertDialog.Builder r4) {
        r4.setMessage(getString(R.string.idea_pills_disabled_by, new Object[]{getString(R.string.undefined)}));
        r4.setPositiveButton(R.string.ok, new AnonymousClass6(this));
        return r4;
    }

    private void enableOptionByType() {
        int r0 = this.mDialogType;
        if (r0 != R.id.id_item_option_idea_pills) goto L5;
        enablethinkboostIfNeed();
        enableSmartKeyAsthinkboost(this.mContext);
        return;
    L5:
        if (r0 != R.id.id_item_option_one_step) goto L11;
        enableSmartKeyAsOneStep(this.mContext);
        return;
    }

    public static void enableSmartKeyAsOneStep(Context r2) {
        ContentResolver r3 = r2.getContentResolver();
        android.provider.Settings.Global.putString(r3, "smart_key_click_function", "side_bar");
        android.provider.Settings.Global.putString(r3, "smart_key_long_click_function", "side_bar");
        android.provider.Settings.Global.putString(r3, "smart_key_long_click_function_when_screen_off", SettingsSmt.SHORTCUT_KEY_VALUE.NONE);
    }

    private String getDoubleClickFunction() {
        ContentResolver r1 = getContentResolver();
        if (r1 != null) goto L5;
        return null;
    L5:
        return android.provider.Settings.Global.getString(r1, "smart_key_double_click_function");
    }

    private void setDoubleClickFunction(String r2) {
        ContentResolver r1 = getContentResolver();
        if (r1 == null) goto L6;
        android.provider.Settings.Global.putString(r1, "smart_key_double_click_function", r2);
        return;
    }

    private void registerContentObserver() {
        ContentResolver r0 = getContentResolver();
        if (r0 == null) goto L6;
        r0.registerContentObserver(android.provider.Settings.Global.getUriFor("smart_key_double_click_function"), true, this.mDoubleClickFunctionChanged);
        return;
    }

    private void unRegisterContentObserver() {
        ContentResolver r0 = getContentResolver();
        if (r0 == null) goto L6;
        r0.unregisterContentObserver(this.mDoubleClickFunctionChanged);
        return;
    }

    private void playUsageVideo(int r5) {
        Intent r0 = new Intent();     // Catch: IllegalStateException -> L11
        r0.setComponent(new ComponentName(Constants.PACKAGE_NAME_HANDBOOK, Constants.CLASS_NAME_HANDBOOK));     // Catch: IllegalStateException -> L11
        if (r5 != R.id.one_step_video_intro) goto L7;
        r0.putExtra(Constants.VIDEO_NAME_KEY, "onestep_video");     // Catch: IllegalStateException -> L11
    L9:
        startActivityForResult(r0, 0);     // Catch: IllegalStateException -> L11
        return;
    L7:
        if (r5 != R.id.idea_pills_video_intro) goto L9;
        r0.putExtra(Constants.VIDEO_NAME_KEY, "thinkboost_video");     // Catch: IllegalStateException -> L11
    L11:
        e = move-exception;
        OLog.e(this.TAG, "play video fail");
        e.printStackTrace();
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_FunctionSmartKeyOptionsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(FunctionSmartKeyOptionsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_FunctionSmartKeyOptionsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_FunctionSmartKeyOptionsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(FunctionSmartKeyOptionsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_FunctionSmartKeyOptionsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_FunctionSmartKeyOptionsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(FunctionSmartKeyOptionsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_FunctionSmartKeyOptionsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
