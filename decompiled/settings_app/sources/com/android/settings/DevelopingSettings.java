package com.android.settings;

import android.app.ActivityManagerNative;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import bytedanceos.util.DeviceType;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.oui.forms.OEditText;
import com.obric.oui.forms.OInputView;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public class DevelopingSettings extends BaseFragment implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    public static final String ALLOW_DRAG_TNT_WINDOWS = "allow_drag_tnt_windows";
    public static final String ALLOW_MOVE_ACTIVITY_DIRECTLY = "allow_move_task_directly";
    private static final String BIG_BANG_OCR_TRIGGER_AREA = "big_bang_ocr_trigger_area";
    private static final String BIG_BANG_TEXT_TRIGGER_AREA = "big_bang_text_trigger_area";
    private static final int BIG_BANG_TYPE_OCR = 2;
    private static final int BIG_BANG_TYPE_TEXT = 1;
    private static final boolean DEFAULT_VALUE = false;
    private static final int FORCE_TOUCH_TYPE = 6;
    private static final String HOME_VIBRATOR_DURATION = "home_vibrator_duration";
    private static final long MB = 1048576;
    public static final String MM_ENTER_TO_SEND = "mm_enter_to_send_key";
    private static final String NAVIGATION_BAR_VIBRATION_STRENGTH = "navigation_bar_vibration_strength";
    private static final int OFF = 0;
    private static final int ON = 1;
    private static final String PHONE_VOICE_WATER_DROP_SWITCH = "phone_voice_water_drop_switch";
    private static final String PULL_DOWN_SCREEN_SCALE = "pull_down_screen_scale";
    private static final String SWAP_FEATURE_PROPERTY_ENABLE = "persist.vendor.bytedanceswap.enable";
    private static final String SWAP_FEATURE_PROPERTY_SIZE = "persist.vendor.bytedanceswap.size";
    private static final long SWAP_FEATURE_PROPERTY_SIZE_2G = 2147483648L;
    private static final String SWAP_FEATURE_PROPERTY_UNAVAILABLE = "persist.vendor.bytedanceswap.unavailable";
    private static final String SWAP_FILE_PATH = "/data/vendor/swap/swapfile";
    private static final int TYPE_HOME_VIBRATOR_DURATION = 4;

    @Deprecated
    private static final int TYPE_HOME_VIBRATOR_STRENGTH = 3;
    private static final int TYPE_NAVIGATION_BAR_VIBRATION_STRENGTH = 5;

    @Deprecated
    private static final String VIBRATOR_STRENGTH = "vibrator_strength";
    private SettingItemSwitch mAllowDragWindows;
    private SettingItemSwitch mAllowMoveTaskDirectly;
    private SettingItemText mAppDevItem;
    private SettingItemText mBigBangOCRSettings;
    private SettingItemText mBigBangTextSettings;
    private final Configuration mCurConfig;
    private AlertDialog mDialog;
    private SettingItemSwitch mDpLaneSwitch;
    private EditText mEditor;
    private String[] mFontEntries;
    private SettingItemText mFontSize;
    private String[] mFontValues;
    private SettingItemText mForceTouchSettings;
    private SettingItemSwitch mLeakCanary;
    private SettingItemSwitch mMmSendByEnterFeature;
    private SettingItemText mMmSendByEnterSelection;
    private SettingItemSwitch mPhoneVoiceWaterDrop;
    private SettingItemText mScreenScale;
    private String[] mScreenScaleEntries;
    private String[] mScreenScaleValues;
    private SettingItemText mStatusBarMode;
    private SettingItemSwitch mSwapFeature;
    private SettingItemText mTabletSettings;
    private AlertDialog mVibrationSettingDialog;
    private SettingItemText mVibrationSettingItem;
    private SettingItemSwitch mZoomModeSwitch;

    private float getLeftIntervalForType(int r1) {
        if (r1 != 1) goto L5;
        return 0.1f;
    L5:
        if (r1 != 2) goto L7;
        return 0.1f;
    L7:
        if (r1 != 3) goto L9;
        return 1.0f;
    L9:
        if (r1 != 4) goto L11;
        return 1.0f;
    L11:
        if (r1 == 6) goto L20;
        return 0.0f;
    L20:
        return 0.1f;
    }

    private float getRightIntervalForType(int r1) {
        if (r1 != 1) goto L5;
        return 1.0f;
    L5:
        if (r1 != 2) goto L7;
        return 1.0f;
    L7:
        if (r1 != 3) goto L9;
        return 62.0f;
    L9:
        if (r1 != 4) goto L11;
        return 500.0f;
    L11:
        if (r1 == 6) goto L21;
        return 0.0f;
    L21:
        return 1.0f;
    }

    public void com_android_settings_DevelopingSettings__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    public void com_android_settings_DevelopingSettings__onResume$___twin___() {
        super.onResume();
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_DevelopingSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_DevelopingSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public DevelopingSettings() {
        this.mCurConfig = new Configuration();
    }

    static /* synthetic */ void access$000(DevelopingSettings r0, int r1, float r2) {
        r0.setValueForType(r1, r2);
    }

    static /* synthetic */ int access$100(DevelopingSettings r0, int r1) {
        return r0.progressToStrengthValue(r1);
    }

    static /* synthetic */ void access$200(DevelopingSettings r0) {
        r0.updateVibrationItemSubTitle();
    }

    static /* synthetic */ EditText access$300(DevelopingSettings r0) {
        return r0.mEditor;
    }

    static /* synthetic */ void access$400(DevelopingSettings r0) {
        r0.updateSubTitles();
    }

    static /* synthetic */ float access$500(DevelopingSettings r0, int r1) {
        return r0.getLeftIntervalForType(r1);
    }

    static /* synthetic */ float access$600(DevelopingSettings r0, int r1) {
        return r0.getRightIntervalForType(r1);
    }

    static /* synthetic */ AlertDialog access$700(DevelopingSettings r0) {
        return r0.mDialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        this.mRootView = r3.inflate(R.layout.developing_settings_layout, r4, false);
        this.mFontEntries = getResources().getStringArray(R.array.font_size_entries);
        this.mFontValues = getResources().getStringArray(R.array.font_size_values);
        this.mScreenScaleEntries = getResources().getStringArray(R.array.screen_scale_entries);
        this.mScreenScaleValues = getResources().getStringArray(R.array.screen_scale_values);
        findViewByIdNullable(R.id.multi_user).setOnClickListener(this);
        this.mZoomModeSwitch = (SettingItemSwitch) findViewByIdNullable(R.id.zoom_mode);
        SettingItemText r6 = (SettingItemText) findViewByIdNullable(R.id.font_size);
        this.mFontSize = r6;
        r6.setOnClickListener(this);
        SettingItemText r7 = (SettingItemText) findViewByIdNullable(R.id.dev_app);
        this.mAppDevItem = r7;
        r7.setOnClickListener(this);
        SettingItemText r8 = (SettingItemText) findViewByIdNullable(R.id.tablet_settings);
        this.mTabletSettings = r8;
        r8.setVisibility(8);
        this.mTabletSettings.setOnClickListener(this);
        this.mScreenScale = (SettingItemText) findViewByIdNullable(R.id.screen_scale);
        SettingItemText r9 = (SettingItemText) findViewByIdNullable(R.id.big_bang_text_settings);
        this.mBigBangTextSettings = r9;
        r9.setOnClickListener(this);
        SettingItemText r10 = (SettingItemText) findViewByIdNullable(R.id.force_touch_settings);
        this.mForceTouchSettings = r10;
        r10.setOnClickListener(this);
        SettingItemText r11 = (SettingItemText) findViewByIdNullable(R.id.big_bang_ocr_settings);
        this.mBigBangOCRSettings = r11;
        r11.setOnClickListener(this);
        this.mScreenScale.setVisibility(0);
        SettingItemText r12 = (SettingItemText) findViewByIdNullable(R.id.id_navigation_bar_vibration_strength);
        this.mVibrationSettingItem = r12;
        r12.setOnClickListener(this);
        this.mLeakCanary = (SettingItemSwitch) findViewByIdNullable(R.id.leak_canary);
        this.mScreenScale.setOnClickListener(this);
        this.mDpLaneSwitch = (SettingItemSwitch) findViewByIdNullable(R.id.dp_lane);
        this.mAllowDragWindows = (SettingItemSwitch) findViewByIdNullable(R.id.allow_drag_windows);
        this.mSwapFeature = (SettingItemSwitch) findViewByIdNullable(R.id.swap_feature);
        this.mMmSendByEnterFeature = (SettingItemSwitch) findViewByIdNullable(R.id.mm_send_by_enter_feature);
        SettingItemText r13 = (SettingItemText) findViewByIdNullable(R.id.mm_send_by_enter_selection);
        this.mMmSendByEnterSelection = r13;
        r13.setOnClickListener(this);
        this.mAllowMoveTaskDirectly = (SettingItemSwitch) findViewByIdNullable(R.id.allow_move_task_directly);
        this.mPhoneVoiceWaterDrop = (SettingItemSwitch) findViewByIdNullable(R.id.phone_voice_water_drop);
        boolean r14 = true;
        if (DeviceType.isOneOf(new DeviceType[]{DeviceType.OCEAN, DeviceType.TRIDENT}) == false) goto L9;
        this.mPhoneVoiceWaterDrop.setVisibility(0);
        SettingItemSwitch r15 = this.mPhoneVoiceWaterDrop;
        if (android.provider.Settings.Global.getInt(getContentResolver(), PHONE_VOICE_WATER_DROP_SWITCH, 0) == 1) goto L8;
        r14 = false;
    L8:
        r15.setChecked(r14);
        this.mPhoneVoiceWaterDrop.setOnCheckedChangeListener(this);
    L9:
        SettingItemText r16 = (SettingItemText) findViewByIdNullable(R.id.status_bar_mode);
        this.mStatusBarMode = r16;
        r16.setOnClickListener(this);
        if (Utils.isNotchStatusBar(this.mContext) == false) goto L13;
        this.mStatusBarMode.setVisibility(0);
    L13:
        if (PickApplicationActivity.EXTRA_USER.equals(Build.TYPE) == false) goto L16;
        finish();
    L16:
        return this.mRootView;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r6) {
        super.onViewStateRestored(r6);
        updateViews();
        this.mZoomModeSwitch.setOnCheckedChangeListener(this);
        SettingItemSwitch r7 = this.mZoomModeSwitch;
        boolean r2 = true;
        if (android.provider.Settings.Global.getInt(getContentResolver(), "sm_zoom_screen_enabled", 1) != 1) goto L5;
        boolean r0 = true;
    L6:
        r7.setChecked(r0);
        this.mLeakCanary.setOnCheckedChangeListener(this);
        SettingItemSwitch r8 = this.mLeakCanary;
        if (android.provider.Settings.Global.getInt(getContentResolver(), "open_close_leak_canary", 0) != 1) goto L9;
        boolean r1 = true;
    L10:
        r8.setChecked(r1);
        this.mDpLaneSwitch.setOnCheckedChangeListener(this);
        SettingItemSwitch r9 = this.mDpLaneSwitch;
        if (android.provider.Settings.Global.getInt(getContentResolver(), "revone_dp_lane_num", 4) != 2) goto L13;
        boolean r3 = true;
    L14:
        r9.setChecked(r3);
        SettingItemSwitch r10 = this.mAllowDragWindows;
        if (android.provider.Settings.Global.getInt(getContentResolver(), ALLOW_DRAG_TNT_WINDOWS, 1) != 1) goto L17;
        boolean r4 = true;
    L18:
        r10.setChecked(r4);
        this.mAllowDragWindows.setOnCheckedChangeListener(this);
        SettingItemSwitch r11 = this.mMmSendByEnterFeature;
        if (android.provider.Settings.Global.getInt(getContentResolver(), "mm_enter_to_send_key", 1) != 1) goto L21;
        boolean r5 = true;
    L22:
        r11.setChecked(r5);
        this.mMmSendByEnterFeature.setOnCheckedChangeListener(this);
        SettingItemSwitch r12 = this.mAllowMoveTaskDirectly;
        if (android.provider.Settings.Global.getInt(getContentResolver(), ALLOW_MOVE_ACTIVITY_DIRECTLY, 0) == 1) goto L26;
        r2 = false;
    L26:
        r12.setChecked(r2);
        this.mAllowMoveTaskDirectly.setOnCheckedChangeListener(this);
        return;
    L21:
        r5 = false;
        goto L22
    L17:
        r4 = false;
        goto L18
    L13:
        r3 = false;
        goto L14
    L9:
        r1 = false;
        goto L10
    L5:
        r0 = false;
        goto L6
    }

    public void updateViews() {
        updateSubTitles();
        this.mFontSize.setSubTitle(String.valueOf(getCurrentFontScale()));
        float r0 = android.provider.Settings.Global.getFloat(getContentResolver(), PULL_DOWN_SCREEN_SCALE, 0.823f);
        this.mScreenScale.setSubTitle(this.mScreenScaleEntries[getIndexOfScreenScaleValue(r0)]);
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    private void updateSubTitles() {
        this.mBigBangTextSettings.setSubTitle(String.valueOf(getValueForType(1)));
        this.mForceTouchSettings.setSubTitle(String.valueOf(getValueForType(6)));
        this.mBigBangOCRSettings.setSubTitle(String.valueOf(getValueForType(2)));
        updateVibrationItemSubTitle();
    }

    private int getIndexOfScreenScaleValue(float r5) {
        int r1 = 0;
    L3:
        String[] r2 = this.mScreenScaleValues;
        if (r1 >= r2.length) goto L9;
        if (Float.valueOf(r2[r1]).floatValue() == r5) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return r1;
    L9:
        return 0;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (r2 != this.mZoomModeSwitch.getSwitch()) goto L6;
        android.provider.Settings.Global.putInt(getContentResolver(), "sm_zoom_screen_enabled", r3 ? 1 : 0);
        return;
    L6:
        if (r2 != this.mAllowDragWindows.getSwitch()) goto L9;
        android.provider.Settings.Global.putInt(getContentResolver(), ALLOW_DRAG_TNT_WINDOWS, r3 ? 1 : 0);
        return;
    L9:
        if (r2 != this.mAllowMoveTaskDirectly.getSwitch()) goto L12;
        android.provider.Settings.Global.putInt(getContentResolver(), ALLOW_MOVE_ACTIVITY_DIRECTLY, r3 ? 1 : 0);
        return;
    L12:
        if (r2 != this.mPhoneVoiceWaterDrop.getSwitch()) goto L15;
        android.provider.Settings.Global.putInt(getContentResolver(), PHONE_VOICE_WATER_DROP_SWITCH, r3 ? 1 : 0);
        return;
    L15:
        if (r2 != this.mDpLaneSwitch.getSwitch()) goto L22;
        ContentResolver r1 = getContentResolver();
        if (r3 == false) goto L19;
        int r4 = 2;
    L20:
        android.provider.Settings.Global.putInt(r1, "revone_dp_lane_num", r4);
        return;
    L19:
        r4 = 4;
        goto L20
    L22:
        if (r2 != this.mLeakCanary.getSwitch()) goto L25;
        android.provider.Settings.Global.putInt(getContentResolver(), "open_close_leak_canary", r3 ? 1 : 0);
        return;
    L25:
        if (r2 != this.mSwapFeature.getSwitch()) goto L28;
        return;
    L28:
        if (r2 != this.mMmSendByEnterFeature.getSwitch()) goto L37;
        android.provider.Settings.Global.putInt(getContentResolver(), "mm_enter_to_send_key", r3 ? 1 : 0);
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r6) {
        if (r6 != this.mAppDevItem) goto L6;
        start(AppCompnentFragment.class);
        return;
    L6:
        if (r6 != this.mFontSize) goto L9;
        Intent r7 = new Intent(this.mContext, FontSettingsActivity.class);
        r7.putExtra("title", getString(R.string.font_size));
        r7.putExtra("back_text_id", R.string.developing_function_settings);
        Utils.startActivity(this._mActivity, r7);
        return;
    L9:
        if (r6 != this.mScreenScale) goto L12;
        launchScreenScaleSettings();
        return;
    L12:
        if (r6 != this.mBigBangTextSettings) goto L15;
        showEditDialog(1);
        return;
    L15:
        if (r6 != this.mForceTouchSettings) goto L18;
        showEditDialog(6);
        return;
    L18:
        if (r6 != this.mBigBangOCRSettings) goto L21;
        showEditDialog(2);
        return;
    L21:
        if (r6 != this.mVibrationSettingItem) goto L24;
        showVibrationSettingsDialog();
        return;
    L24:
        if (r6 != this.mTabletSettings) goto L27;
        Intent r8 = new Intent();
        r8.setClassName("com.android.settings", "com.android.settings.revone.TabletSettings$TabletSettingsActivity");
        Utils.startActivity(this._mActivity, r8);
        return;
    L27:
        if (r6.getId() != R.id.multi_user) goto L30;
        return;
    L30:
        if (r6 != this.mStatusBarMode) goto L33;
        start(StatusBarFragment.class);
        return;
    L33:
        if (r6 != this.mMmSendByEnterSelection) goto L45;
        Intent r9 = new Intent(this.mContext, MMSendKeySettingsActivity.class);
        r9.putExtra("title", getString(R.string.mm_send_by_enter_selection));
        r9.putExtra("back_text_id", R.string.developing_function_settings);
        Utils.startActivity(this._mActivity, r9);
        return;
    }

    private void showVibrationSettingsDialog() {
        AlertDialog r0 = this.mVibrationSettingDialog;
        if (r0 != null) goto L5;
    L7:
        FragmentActivity r1 = getActivity();
        if (r1 != null) goto L11;
        OLog.e(this.TAG, "showVibrationSettingsDialog, activity is null, return");
        return;
    L11:
        AlertDialog.Builder r2 = new AlertDialog.Builder(r1);
        View r3 = View.inflate(this.mContext, R.layout.dialog_navigation_bar_vibration_strength, null);
        final TextView r4 = (TextView) r3.findViewById(R.id.vibration_duration_title);
        final String r5 = getString(R.string.vibration_duration) + "(%1$d)";
        r4.setText(String.format(r5, new Object[]{Integer.valueOf((int) getValueForType(4))}));
        SeekBar r6 = (SeekBar) r3.findViewById(R.id.vibration_duration_seek_bar);
        r6.setMax(500);
        r6.setProgress((int) getValueForType(4));
        r6.setOnSeekBarChangeListener(new AnonymousClass1(this, r4, r5));
        final TextView r7 = (TextView) r3.findViewById(R.id.vibration_strength_title);
        final String r8 = getString(R.string.vibration_strength) + "(%1$d)";
        r7.setText(String.format(r8, new Object[]{Integer.valueOf((int) getValueForType(5))}));
        SeekBar r9 = (SeekBar) r3.findViewById(R.id.vibration_strength_seek_bar);
        r9.setMax(getStrengthMaxValue());
        r9.setProgress(strengthValueToProgress((int) getValueForType(5)));
        r9.setOnSeekBarChangeListener(new AnonymousClass2(this, r7, r8));
        r2.setView(r3);
        r2.setOnDismissListener(new AnonymousClass3(this));
        r2.setOnKeyListener(new AnonymousClass4(this));
        this.mVibrationSettingDialog = r2.show();
        return;
    L5:
        if (r0.isShowing() == false) goto L7;
    }

    private int getStrengthMaxValue() {
        if (DeviceType.is(DeviceType.OSCAR) == false) goto L6;
        return 6;
    L6:
        return 62;
    }

    private int progressToStrengthValue(int r1) {
        if (DeviceType.is(DeviceType.OSCAR) == true) goto L5;
        return r1;
    L5:
        return r1 + 27;
    }

    private int strengthValueToProgress(int r1) {
        if (DeviceType.is(DeviceType.OSCAR) == true) goto L5;
        return r1;
    L5:
        return r1 - 27;
    }

    private int getDefaultStrengthValue() {
        if (DeviceType.is(DeviceType.OSCAR) == false) goto L6;
        return 33;
    L6:
        return 44;
    }

    private void updateVibrationItemSubTitle() {
        String r0 = String.valueOf((int) getValueForType(5));
        this.mVibrationSettingItem.setSubTitle(String.valueOf((int) getValueForType(4)) + "，" + r0);
    }

    private float getValueForType(int r2) {
        switch(r2) {
            case 1: goto L19;
            case 2: goto L25;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L6;
            case 6: goto L20;
            default: goto L26;
        };
    L6:
        float r0 = android.provider.Settings.Global.getInt(getContentResolver(), NAVIGATION_BAR_VIBRATION_STRENGTH, getDefaultStrengthValue());
        if (DeviceType.is(DeviceType.OSCAR) == false) goto L21;
        float r1 = 33.0f;
        if (r0 > 33.0f) goto L22;
        r1 = 27.0f;
        if (r0 < 27.0f) goto L22;
        return r0;
    L22:
        return r1;
    L21:
        return r0;
    L14:
        int r3 = android.provider.Settings.Global.getInt(getContentResolver(), HOME_VIBRATOR_DURATION, 10);
    L24:
        return r3;
    L15:
        r3 = android.provider.Settings.Global.getInt(getContentResolver(), VIBRATOR_STRENGTH, 44);
        goto L24
    L26:
        return 0.5f;
    L20:
        return android.provider.Settings.Global.getFloat(getContentResolver(), "pressure_of_forcetouch", 0.6f);
    L25:
        return android.provider.Settings.Global.getFloat(getContentResolver(), BIG_BANG_OCR_TRIGGER_AREA, 0.5f);
    L19:
        return android.provider.Settings.Global.getFloat(getContentResolver(), BIG_BANG_TEXT_TRIGGER_AREA, 0.5f);
    }

    private void setValueForType(int r1, float r2) {
        switch(r1) {
            case 1: goto L9;
            case 2: goto L8;
            case 3: goto L7;
            case 4: goto L6;
            case 5: goto L5;
            case 6: goto L4;
            default: goto L16;
        };
    L4:
        android.provider.Settings.Global.putFloat(getContentResolver(), "pressure_of_forcetouch", r2);
        return;
    L5:
        android.provider.Settings.Global.putInt(getContentResolver(), NAVIGATION_BAR_VIBRATION_STRENGTH, (int) r2);
        return;
    L6:
        android.provider.Settings.Global.putInt(getContentResolver(), HOME_VIBRATOR_DURATION, (int) r2);
        return;
    L7:
        android.provider.Settings.Global.putInt(getContentResolver(), VIBRATOR_STRENGTH, (int) r2);
        return;
    L8:
        android.provider.Settings.Global.putFloat(getContentResolver(), BIG_BANG_OCR_TRIGGER_AREA, r2);
        return;
    L9:
        android.provider.Settings.Global.putFloat(getContentResolver(), BIG_BANG_TEXT_TRIGGER_AREA, r2);
        return;
    }

    private void showEditDialog(final int r4) {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L6;
        OLog.e(this.TAG, "showEditDialog, activity is null, return");
        return;
    L6:
        AlertDialog.Builder r1 = new AlertDialog.Builder(r0);
        r1.setTitle("自定义(" + getLeftIntervalForType(r4) + " ~ " + getRightIntervalForType(r4) + ")").setView(createDialogView(r4)).setPositiveButton(R.string.ok, new AnonymousClass5(this, r4)).setNegativeButton(R.string.cancel, null);
        AlertDialog r5 = r1.create();
        this.mDialog = r5;
        r5.getWindow().setSoftInputMode(37);
        this.mDialog.show();
    }

    private View createDialogView(final int r5) {
        String r0 = String.valueOf(getValueForType(r5));
        View r1 = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.dialog_edittext, null);
        OEditText r2 = ((OInputView) r1.findViewById(R.id.edittext)).getVInput();
        this.mEditor = r2;
        r2.addTextChangedListener(new AnonymousClass6(this, r5));
        this.mEditor.setInputType(8194);
        this.mEditor.setSingleLine();
        this.mEditor.setText(r0);
        this.mEditor.setSelection(0, r0.length());
        return r1;
    }

    public void launchScreenScaleSettings() {
        float r0 = android.provider.Settings.Global.getFloat(getContentResolver(), PULL_DOWN_SCREEN_SCALE, 0.823f);
        OptionsInfo r1 = new OptionsInfo(this.mScreenScaleEntries, this.mScreenScaleValues, OptionsInfo.SaveTargetTable.Global, PULL_DOWN_SCREEN_SCALE);
        startActivity(Utils.getOptionsActivityIntent(requireActivity(), r1, this.mScreenScaleValues[getIndexOfScreenScaleValue(r0)], getString(R.string.adjust_screen_scale), R.string.developing_function_settings));
    }

    private float getCurrentFontScale() {
        this.mCurConfig.updateFrom(ActivityManagerNative.getDefault().getConfiguration());     // Catch: RemoteException -> L5
    L4:
        return this.mCurConfig.fontScale;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_DevelopingSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(DevelopingSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_DevelopingSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_DevelopingSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(DevelopingSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_DevelopingSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_DevelopingSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(DevelopingSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_DevelopingSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
