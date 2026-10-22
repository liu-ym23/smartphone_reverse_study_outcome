package com.android.settings.revone;

import android.app.SmtPCUtils;
import android.casthal.CasthalManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.ContentObserver;
import android.icu.lang.UCharacter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import androidx.fragment.app.FragmentActivity;
import com.GlobalProxyLancet;
import com.android.internal.content.PackageMonitor;
import com.android.settings.Constants;
import com.android.settings.KeyboardLocationSettingsFragment;
import com.android.settings.R;
import com.android.settings.SettingsFeature;
import com.android.settings.SettingsTracker;
import com.android.settings.TrackerConstants;
import com.android.settings.Utils;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.base.BaseActivity;
import com.android.settings.base.BaseFragment;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.widget.SettingItemCheckSimpleText;
import com.android.settings.widget.TickMarkView;
import com.bytedance.bdinstall.Api;
import com.bytedance.librarian.LibrarianImpl;
import com.obric.olog.OLog;
import com.obric.oui.calendar.ODatePickerView;
import com.obric.oui.utils.AnimTokens;
import com.obric.privacy.GrantUtil;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import obric.widget.SettingItemSwitch;
import obric.widget.SettingItemText;
import obric.widget.ShadowDrawable;

/* JADX INFO: loaded from: classes2.dex */
public class KeyboardSettingsFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener, SettingItemCheckSimpleText.IcArrowClickListener {
    private static final int DEFAULT_KEYBOARD_REPEAT_DELAY = 500;
    private static final int DEFAULT_KEYBOARD_REPEAT_INTERVAL = 50;
    private static final int KEYBOARD_PREFERENCE_MAC = 1;
    private static final int KEYBOARD_PREFERENCE_WINDOWS = 0;
    private static final int[] KEYBOARD_REPEAT_DELAY_ARRAY = null;
    private static final int[] KEYBOARD_REPEAT_INTERVAL_ARRAY = null;
    private static final int MARKER_SIZE = 15;
    private static final int MAX_KEYBOARD_REPEAT_DELAY = 2500;
    private static final int MAX_KEYBOARD_REPEAT_INTERVAL = 1000;
    private static final int MIN_KEYBOARD_REPEAT_DELAY = 200;
    private static final int MIN_KEYBOARD_REPEAT_INTERVAL = 30;
    public static final String PROJECTION_MODE = "bytedanceos_projection_mode";
    private static final int REQUEST_CODE_CHOOSE_APP = 1;
    public static final int TRADITIONAL_INPUT_DISABLED = 0;
    public static final int TRADITIONAL_INPUT_ENABLED = 1;
    private static final int UPDATE_VIEW_DELAY_TIME = 100;
    private BroadcastReceiver mBostonKeyboardState;
    private Handler mHandler;
    private SettingItemText mInputMethodBytedance;
    private SettingItemCheckSimpleText mItemCheckCloseScreen;
    private SettingItemCheckSimpleText mItemCheckKeyboardMac;
    private SettingItemCheckSimpleText mItemCheckKeyboardWindows;
    private SettingItemCheckSimpleText mItemCheckNone;
    private SettingItemCheckSimpleText mItemCheckStartApp;
    private SettingItemSwitch mItemSwitchPopupVirtualKeyboard;
    private SettingItemText mItemTextFFunctionalKeys;
    private SettingItemText mKeyboardLocationSettingItem;
    private TickMarkView mKeyboardRepeatDelay;
    private TickMarkView mKeyboardRepeatInterval;
    private SettingItemText mKeyboardStyle;
    private final PackageMonitor mPackageMonitor;
    private ContentObserver mProjectionModeObserver;
    private SettingItemText mRecognizeLanguage;
    private ContentObserver mRecognizeLanguageObserver;
    private SettingItemSwitch mSwitchKeyBoard;
    private SettingItemSwitch mTraditionalChineseInput;
    private ContentObserver mTraditionalInputObserver;
    private ContentObserver mVirtualKeyboardPopupObserver;

    /* JADX INFO: renamed from: com.android.settings.revone.KeyboardSettingsFragment$5, reason: invalid class name */
    class AnonymousClass5 extends ContentObserver {
        final /* synthetic */ KeyboardSettingsFragment this$0;

        AnonymousClass5(KeyboardSettingsFragment r1, Handler r2) {
            this.this$0 = r1;
            super(r2);
        }

        /* JADX INFO: renamed from: lambda$onChange$0$com-android-settings-revone-KeyboardSettingsFragment$5, reason: not valid java name */
        /* synthetic */ void m555xa6791da1() {
            KeyboardSettingsFragment.access$1000(this.this$0);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r4) {
            KeyboardSettingsFragment.access$900(this.this$0).postDelayed(new KeyboardSettingsFragment$5$$ExternalSyntheticLambda0(this), 100);
        }
    }

    public void com_android_settings_revone_KeyboardSettingsFragment__onCreate$___twin___(Bundle r1) {
        super.onCreate(r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_revone_KeyboardSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_revone_KeyboardSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    static /* synthetic */ SettingItemSwitch access$000(KeyboardSettingsFragment r0) {
        return r0.mTraditionalChineseInput;
    }

    static /* synthetic */ boolean access$100(KeyboardSettingsFragment r0) {
        return r0.isTraditionalInputEnabled();
    }

    static /* synthetic */ void access$1000(KeyboardSettingsFragment r0) {
        r0.updateVirtualKeyboard();
    }

    static /* synthetic */ void access$1100(KeyboardSettingsFragment r0) {
        r0.updateBostonKeyBoardView();
    }

    static /* synthetic */ String access$200(KeyboardSettingsFragment r0) {
        return r0.getRecognizeLanguage();
    }

    static /* synthetic */ SettingItemText access$300(KeyboardSettingsFragment r0) {
        return r0.mRecognizeLanguage;
    }

    static /* synthetic */ String access$400(KeyboardSettingsFragment r0) {
        return r0.TAG;
    }

    static /* synthetic */ String access$500(KeyboardSettingsFragment r0) {
        return r0.getStartAppPackageName();
    }

    static /* synthetic */ void access$600(KeyboardSettingsFragment r0, String r1) {
        r0.saveStartAppPackageInfo(r1);
    }

    static /* synthetic */ void access$700(KeyboardSettingsFragment r0) {
        r0.updateStartAppItemSubTitle();
    }

    static /* synthetic */ SettingItemSwitch access$800(KeyboardSettingsFragment r0) {
        return r0.mItemSwitchPopupVirtualKeyboard;
    }

    static /* synthetic */ Handler access$900(KeyboardSettingsFragment r0) {
        return r0.mHandler;
    }

    static {
        KEYBOARD_REPEAT_INTERVAL_ARRAY = new int[]{1000, 900, 800, 700, 600, 500, 400, 300, 200, 100, 50, 45, 40, 35, 30};
        KEYBOARD_REPEAT_DELAY_ARRAY = new int[]{200, UCharacter.UnicodeBlock.KANA_EXTENDED_A_ID, AnimTokens.OUI_ANIMATION_DURATION_MEDIUM_3, 425, 500, 700, 900, 1100, 1300, 1500, 1700, ODatePickerView.YEAR_FROM, ODatePickerView.YEAR_TO, 2300, 2500};
    }

    public KeyboardSettingsFragment() {
        super(R.layout.tnt_keyboard_settings);
        this.mHandler = new Handler();
        final Handler r1 = null;
        this.mTraditionalInputObserver = new AnonymousClass1(this, r1);
        this.mRecognizeLanguageObserver = new AnonymousClass2(this, r1);
        this.mPackageMonitor = new AnonymousClass3(this);
        final Handler r2 = this.mHandler;
        this.mVirtualKeyboardPopupObserver = new AnonymousClass4(this, r2);
        this.mProjectionModeObserver = new AnonymousClass5(this, this.mHandler);
        this.mBostonKeyboardState = new AnonymousClass6(this);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r14, Bundle r15) {
        super.onViewCreated(r14, r15);
        this.mKeyboardRepeatInterval = (TickMarkView) findViewByIdNullable(R.id.keyboard_repeat_interval);
        this.mKeyboardRepeatDelay = (TickMarkView) findViewByIdNullable(R.id.keyboard_repeat_delay);
        this.mKeyboardRepeatInterval.setOnMarkerChangeListener(new KeyboardSettingsFragment$$ExternalSyntheticLambda0(this));
        this.mKeyboardRepeatInterval.setMarkerSize(15);
        this.mKeyboardRepeatInterval.setMarkerLabels(getResources().getString(R.string.tts_speech_rate_slower), getResources().getString(R.string.tts_speech_rate_faster), getResources().getString(R.string.force_touch_pressure_standard), 10, 15);
        ShadowDrawable.setViewBackground(this.mKeyboardRepeatInterval, R.drawable.group_list_item_unpressed_bg_single, R.drawable.list_item_single_shadow);
        this.mKeyboardRepeatDelay.setMarkerSize(15);
        this.mKeyboardRepeatDelay.setMarkerLabels(getResources().getString(R.string.time_short), getResources().getString(R.string.time_long), getResources().getString(R.string.force_touch_pressure_standard), 4, 15);
        this.mKeyboardRepeatDelay.setOnMarkerChangeListener(new KeyboardSettingsFragment$$ExternalSyntheticLambda1(this));
        ShadowDrawable.setViewBackground(this.mKeyboardRepeatDelay, R.drawable.group_list_item_unpressed_bg_single, R.drawable.list_item_single_shadow);
        this.mItemCheckCloseScreen = (SettingItemCheckSimpleText) findViewByIdNullable(R.id.item_check_close_screen);
        this.mItemCheckStartApp = (SettingItemCheckSimpleText) findViewByIdNullable(R.id.item_check_start_app);
        this.mItemCheckNone = (SettingItemCheckSimpleText) findViewByIdNullable(R.id.item_check_none);
        this.mItemCheckKeyboardWindows = (SettingItemCheckSimpleText) findViewByIdNullable(R.id.keyboard_preference_windows);
        this.mItemCheckKeyboardMac = (SettingItemCheckSimpleText) findViewByIdNullable(R.id.keyboard_preference_mac);
        this.mItemSwitchPopupVirtualKeyboard = (SettingItemSwitch) findViewByIdNullable(R.id.virtual_keyboard_popup_switch);
        SettingItemText r16 = (SettingItemText) findViewByIdNullable(R.id.f_functional_keys);
        this.mItemTextFFunctionalKeys = r16;
        r16.setOnClickListener(this);
        this.mKeyboardStyle = (SettingItemText) findViewByIdNullable(R.id.keyboard_style);
        this.mTraditionalChineseInput = (SettingItemSwitch) findViewByIdNullable(R.id.traditional_chinese_input);
        this.mRecognizeLanguage = (SettingItemText) findViewByIdNullable(R.id.recognize_language);
        this.mInputMethodBytedance = (SettingItemText) findViewByIdNullable(R.id.id_keyboard_inputmethod_bytedance);
        boolean r17 = true;
        this.mItemCheckCloseScreen.setTag(1);
        this.mItemCheckStartApp.setTag(3);
        this.mItemCheckNone.setTag(0);
        this.mItemCheckKeyboardWindows.setTag(0);
        this.mItemCheckKeyboardMac.setTag(1);
        this.mItemCheckCloseScreen.setOnClickListener(this);
        this.mItemCheckStartApp.setOnClickListener(this);
        this.mItemCheckNone.setOnClickListener(this);
        this.mItemCheckKeyboardWindows.setOnClickListener(this);
        this.mItemCheckKeyboardWindows.setIconArrowListener(this);
        this.mItemCheckKeyboardMac.setOnClickListener(this);
        this.mItemCheckKeyboardMac.setIconArrowListener(this);
        this.mItemCheckStartApp.setIconArrowListener(this);
        this.mRecognizeLanguage.setOnClickListener(this);
        this.mKeyboardStyle.setOnClickListener(this);
        this.mInputMethodBytedance.setOnClickListener(this);
        this.mPackageMonitor.register(this.mContext, Looper.getMainLooper(), false);
        SettingItemText r18 = (SettingItemText) findViewByIdNullable(R.id.id_keyboard_dialog_default_location_setting);
        this.mKeyboardLocationSettingItem = r18;
        r18.setOnClickListener(this);
        this.mSwitchKeyBoard = (SettingItemSwitch) findViewByIdNullable(R.id.id_security_keyboard);
        if (SettingsFeature.isSupportSecurityKeyboard(this.mContext) == false) goto L9;
        this.mSwitchKeyBoard.setOnCheckedChangeListener(this);
        SettingItemSwitch r19 = this.mSwitchKeyBoard;
        if (Settings.Global.getInt(this.mContext.getContentResolver(), Constants.SAFE_KEYBOARD_SWITCH, 1) == 1) goto L8;
        r17 = false;
    L8:
        r19.setChecked(r17);
        return;
    L9:
        this.mSwitchKeyBoard.setVisibility(8);
        findViewByIdNullable(R.id.id_security_keyboard_gap).setVisibility(8);
    }

    /* JADX INFO: renamed from: lambda$onViewCreated$0$com-android-settings-revone-KeyboardSettingsFragment, reason: not valid java name */
    /* synthetic */ void m553x13ac7e55(int r2) {
        setKeyboardKeysRepeatInterval(KEYBOARD_REPEAT_INTERVAL_ARRAY[r2]);
    }

    /* JADX INFO: renamed from: lambda$onViewCreated$1$com-android-settings-revone-KeyboardSettingsFragment, reason: not valid java name */
    /* synthetic */ void m554x2dc7fcf4(int r2) {
        setKeyboardKeysRepeatDelay(KEYBOARD_REPEAT_DELAY_ARRAY[r2]);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle r1) {
        super.onViewStateRestored(r1);
        updateViews();
        this.mItemSwitchPopupVirtualKeyboard.setOnCheckedChangeListener(this);
        this.mTraditionalChineseInput.setOnCheckedChangeListener(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mPackageMonitor.unregister();
    }

    private void updateViews() {
        updateCustomKeyViews(getKeyboardCustomKeyValue());
        updateStartAppItemSubTitle();
        updateKeyboardDialogDefaultLocationOptions();
        this.mKeyboardRepeatInterval.setMarker(getKeyboardKeysRepeatIntervalIndex());
        this.mKeyboardRepeatDelay.setMarker(getKeyboardKeysRepeatDelayIndex());
        updateKeyboardPreference(getKeyboardPreference());
        updateVirtualKeyboard();
        if (SettingsFeature.isSupportBostonKeyboard() == false) goto L5;
        updateBostonKeyBoardView();
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mContext, this.mBostonKeyboardState, new IntentFilter(CasthalManager.HALL_KEYBOARD_CONNECTION_CHANGED_ACTION), 2);
    L7:
        if (Constants.sIsBostonConnected == true) goto L9;
        this.mItemTextFFunctionalKeys.setVisibility(8);
    L9:
        this.mTraditionalChineseInput.setChecked(isTraditionalInputEnabled());
        this.mRecognizeLanguage.setSubTitle(getRecognizeLanguage());
        this.mKeyboardStyle.setSubTitle(getKeyboardStyle());
        return;
    L5:
        this.mItemTextFFunctionalKeys.setSubtitle(Utils.getSwitchStateResId(this.mContext, "tablet_shortcut_buttons_with_f_keys", 0));
        goto L7
    }

    @Override // com.android.settings.base.BaseFragment
    public void onResumeNonInitial() {
        super.onResumeNonInitial();
        updateViews();
    }

    public void com_android_settings_revone_KeyboardSettingsFragment__onResume$___twin___() {
        super.onResume();
        ContentResolver r0 = this.mContext.getContentResolver();
        r0.registerContentObserver(Settings.Global.getUriFor("traditional_input"), true, this.mTraditionalInputObserver);
        r0.registerContentObserver(Settings.Global.getUriFor(Api.KEY_LANGUAGE), true, this.mRecognizeLanguageObserver);
        r0.registerContentObserver(Settings.Secure.getUriFor("show_virtual_ime_always"), false, this.mVirtualKeyboardPopupObserver);
        r0.registerContentObserver(Settings.Global.getUriFor(PROJECTION_MODE), false, this.mProjectionModeObserver);
    }

    private void updateVirtualKeyboard() {
        boolean r2 = false;
        if (Settings.Global.getInt(getContentResolver(), PROJECTION_MODE, 0) != 1) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        this.mItemSwitchPopupVirtualKeyboard.setVisibility(8);
        this.mKeyboardLocationSettingItem.setBackgroundStyle(1);
    L9:
        SettingItemSwitch r1 = this.mItemSwitchPopupVirtualKeyboard;
        if (Settings.Secure.getInt(getContentResolver(), "show_virtual_ime_always", 0) != 1) goto L12;
        r2 = true;
    L12:
        r1.setChecked(r2);
        return;
    L8:
        this.mItemSwitchPopupVirtualKeyboard.setVisibility(0);
        this.mKeyboardLocationSettingItem.setBackgroundStyle(4);
        goto L9
    L5:
        r0 = false;
        goto L6
    }

    private void updateKeyboardPreference(int r5) {
        SettingItemCheckSimpleText r0 = this.mItemCheckKeyboardWindows;
        boolean r1 = false;
        if (r5 != 0) goto L5;
        boolean r3 = true;
    L6:
        r0.setChecked(r3);
        SettingItemCheckSimpleText r4 = this.mItemCheckKeyboardMac;
        if (r5 != 1) goto L9;
        r1 = true;
    L9:
        r4.setChecked(r1);
        return;
    L5:
        r3 = false;
        goto L6
    }

    private int getKeyboardPreference() {
        return Settings.Global.getInt(getContentResolver(), "keyboard_preference", 0);
    }

    private void setKeyboardPreference(int r2) {
        Settings.Global.putInt(getContentResolver(), "keyboard_preference", r2);
    }

    private int getKeyboardKeysRepeatIntervalIndex() {
        int r0 = Settings.Global.getInt(getContentResolver(), "keyboard_keys_repeat_interval", 50);
        int[] r1 = KEYBOARD_REPEAT_INTERVAL_ARRAY;
        int[] r2 = DpiUtils.findNearestIndex(r1, r0);
        if (r2[0] != 1) goto L6;
        OLog.i(this.TAG, "getKeyboardKeysRepeatIntervalIndex: KEYBOARD_KEYS_REPEAT_INTERVAL change from " + r0 + "to" + r1[r2[1]]);
        setKeyboardKeysRepeatInterval(r1[r2[1]]);
    L6:
        return r2[1];
    }

    private int getKeyboardKeysRepeatDelayIndex() {
        int r0 = Settings.Global.getInt(getContentResolver(), "keyboard_keys_repeat_delay", 500);
        int[] r1 = KEYBOARD_REPEAT_DELAY_ARRAY;
        int[] r2 = DpiUtils.findNearestIndex(r1, r0);
        if (r2[0] != 1) goto L6;
        OLog.i(this.TAG, "getKeyboardKeysRepeatDelayIndex: KEYBOARD_KEYS_REPEAT_DELAY change from " + r0 + "to" + r1[r2[1]]);
        setKeyboardKeysRepeatDelay(r1[r2[1]]);
    L6:
        return r2[1];
    }

    private void setKeyboardKeysRepeatInterval(int r3) {
        Settings.Global.putInt(getContentResolver(), "keyboard_keys_repeat_interval", r3);
        OLog.d(this.TAG, "setKeyboardKeysRepeatInterval : " + r3);
    }

    private void setKeyboardKeysRepeatDelay(int r3) {
        Settings.Global.putInt(getContentResolver(), "keyboard_keys_repeat_delay", r3);
        OLog.d(this.TAG, "setKeyboardKeysRepeatDelay : " + r3);
    }

    private int getInRangeValue(int r1, int r2, int r3) {
        return Math.max(Math.min(r2, r1), r3);
    }

    private boolean isTraditionalInputEnabled() {
        if (Settings.Global.getInt(getContentResolver(), "traditional_input", 0) == 1) goto L5;
        return false;
    L5:
        return true;
    }

    private String getKeyboardStyle() {
        if (Settings.Global.getInt(getContentResolver(), "keyboard_style", 0) != 1) goto L6;
        return getString(R.string.keyboard_style_small);
    L6:
        return getString(R.string.keyboard_style_large);
    }

    private String getRecognizeLanguage() {
        int r2 = 0;
        int r0 = Settings.Global.getInt(getContentResolver(), Api.KEY_LANGUAGE, 0);
        String[] r3 = getResources().getStringArray(R.array.voice_languages_all);
        if (r0 < 0) goto L9;
        if (r0 > (r3.length - 1)) goto L9;
        r2 = r0;
    L9:
        return r3[r2];
    }

    @Override // com.android.settings.widget.SettingItemCheckSimpleText.IcArrowClickListener, android.view.View.OnClickListener
    public void onClick(View r6) {
        if (r6 == this.mItemCheckCloseScreen) goto L42;
        SettingItemCheckSimpleText r0 = this.mItemCheckStartApp;
        if (r6 == r0) goto L42;
        if (r6 == this.mItemCheckNone) goto L42;
        if (r6 != r0.getIcArrow()) goto L13;
        startChooseApp();
        return;
    L13:
        if (r6 == this.mItemCheckKeyboardWindows) goto L38;
        SettingItemCheckSimpleText r1 = this.mItemCheckKeyboardMac;
        if (r6 == r1) goto L38;
        if (r6 != this.mItemTextFFunctionalKeys) goto L21;
        start(FFunctionalKeysSettingsFragment.class);
        return;
    L21:
        if (r6 != r1.getIcArrow()) goto L24;
        Bundle r7 = new Bundle();
        r7.putString("title", getString(R.string.keyboard_preference_mac));
        r7.putInt("extra_target_key", 1);
        start(CustomKeyBoardSettingsFragment.class, r7);
        return;
    L24:
        if (r6 != this.mItemCheckKeyboardWindows.getIcArrow()) goto L27;
        Bundle r8 = new Bundle();
        r8.putString("title", getString(R.string.keyboard_preference_windows));
        r8.putInt("extra_target_key", 0);
        start(CustomKeyBoardSettingsFragment.class, r8);
        return;
    L27:
        if (r6 != this.mKeyboardLocationSettingItem) goto L30;
        start(KeyboardLocationSettingsFragment.class);
        return;
    L30:
        if (r6 != this.mRecognizeLanguage) goto L33;
        Intent r9 = new Intent();
        r9.setComponent(new ComponentName(SmtPCUtils.PKG_BYTEDANCE_IME, "com.bytedanceos.ime.activity.LanguageActivity"));
        r9.setFlags(335544320);
        startIntent(r9);
        return;
    L33:
        if (r6 != this.mKeyboardStyle) goto L36;
        start(KeyboardStyleFragment.class);
        return;
    L36:
        if (r6 != this.mInputMethodBytedance) goto L51;
        Intent r10 = new Intent();
        r10.setComponent(new ComponentName(SmtPCUtils.PKG_BYTEDANCE_IME, "com.bytedanceos.ime.activity.SettingsActivity"));
        r10.setFlags(335544320);
        startIntent(r10);
        return;
    L51:
        return;
    L38:
        int r2 = ((Integer) r6.getTag()).intValue();
        setKeyboardPreference(r2);
        updateKeyboardPreference(r2);
        if (r6 != this.mItemCheckKeyboardWindows) goto L41;
        SettingsTracker.onStatus(TrackerConstants.TNT_SETTING_EVENT_ID, TrackerConstants.KEYBOARD_FUNCTION, 0);
        return;
    L41:
        SettingsTracker.onStatus(TrackerConstants.TNT_SETTING_EVENT_ID, TrackerConstants.KEYBOARD_FUNCTION, 1);
        return;
    L42:
        int r11 = ((Integer) r6.getTag()).intValue();
        saveKeyboardCustomKeyValue(r11);
        updateCustomKeyViews(r11);
    }

    private void startIntent(Intent r1) {
        startActivity(r1);
    }

    private void startChooseApp() {
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L6;
        OLog.e(this.TAG, "startChooseApp, activity is null, return");
        return;
    L6:
        Intent r1 = new Intent(r0, PickApplicationActivity.class);
        String[] r5 = fetchStartAppPackageInfo();
        if (r5 != null) goto L15;
    L13:
        ((BaseActivity) r0).customStartActivityForResult(r1);
        return;
    L15:
        int r2 = Integer.parseInt(r5[2]);     // Catch: NumberFormatException -> L11
        r1.putExtra("package_name", r5[0]);     // Catch: NumberFormatException -> L11
        r1.putExtra(PickApplicationActivity.EXTRA_ACTIVITY_NAME, r5[1]);     // Catch: NumberFormatException -> L11
        r1.putExtra(PickApplicationActivity.EXTRA_USER, r2);     // Catch: NumberFormatException -> L11
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    @Override // com.android.settings.base.BaseFragment
    public void onCustomActivityResult(int r3, int r4, Intent r5) {
        super.onCustomActivityResult(r3, r4, r5);
        if (r4 == RESULT_OK) goto L5;
        return;
    L5:
        if (r5 == null) goto L8;
        saveStartAppPackageInfo(buildStartAppPackageInfoValue(r5.getStringExtra("package_name"), r5.getStringExtra(PickApplicationActivity.EXTRA_ACTIVITY_NAME), r5.getIntExtra(PickApplicationActivity.EXTRA_USER, UserHandle.myUserId())));
        updateStartAppItemSubTitle();
        return;
    }

    private void updateCustomKeyViews(int r6) {
        SettingItemCheckSimpleText r0 = this.mItemCheckCloseScreen;
        boolean r1 = false;
        if (r6 != 1) goto L5;
        boolean r3 = true;
    L6:
        r0.setChecked(r3);
        SettingItemCheckSimpleText r2 = this.mItemCheckStartApp;
        if (r6 != 3) goto L9;
        boolean r4 = true;
    L10:
        r2.setChecked(r4);
        SettingItemCheckSimpleText r5 = this.mItemCheckStartApp;
        if (r6 != 3) goto L13;
        boolean r7 = true;
    L14:
        r5.enableIcArrow(r7);
        SettingItemCheckSimpleText r8 = this.mItemCheckNone;
        if (r6 != 0) goto L17;
        r1 = true;
    L17:
        r8.setChecked(r1);
        return;
    L13:
        r7 = false;
        goto L14
    L9:
        r4 = false;
        goto L10
    L5:
        r3 = false;
        goto L6
    }

    private void updateStartAppItemSubTitle() {
        String[] r0 = fetchStartAppPackageInfo();
        CharSequence r1 = null;
        if (r0 != null) goto L5;
    L17:
        this.mItemCheckStartApp.setSubTitle(r1);
        return;
    L5:
        if (TextUtils.isEmpty(r0[0]) == true) goto L17;
        if (Utils.isPackageInstalled(this.mContext, r0[0]) == false) goto L16;
        PackageManager r3 = getPackageManager();
        List<ResolveInfo> r4 = r3.queryIntentActivities(new Intent().setClassName(r0[0], r0[1]), 0);
        if (r4 == null) goto L14;
        if (r4.isEmpty() == true) goto L14;
        r1 = r4.get(0).loadLabel(r3);
    L14:
        if (TextUtils.isEmpty(r1) == false) goto L17;
        r1 = Utils.getApplicationLabel(this.mContext, r0[0]);
        goto L17
    L16:
        saveStartAppPackageInfo(null);
        goto L17
    }

    private int getKeyboardCustomKeyValue() {
        return Settings.Global.getInt(getContentResolver(), "keyboard_custom_key", 0);
    }

    private void saveKeyboardCustomKeyValue(int r2) {
        Settings.Global.putInt(getContentResolver(), "keyboard_custom_key", r2);
    }

    private String getStartAppPackageName() {
        String[] r1 = fetchStartAppPackageInfo();
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1[0];
    }

    private String[] fetchStartAppPackageInfo() {
        String r0 = Settings.Global.getString(getContentResolver(), "keyboard_custom_key_start_app_pkg");
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return null;
    L5:
        String[] r1 = r0.split(LibrarianImpl.Constants.SEPARATOR);
        if (r1 != null) goto L8;
    L11:
        saveStartAppPackageInfo(null);
        return null;
    L8:
        if (r1.length != 3) goto L11;
        return r1;
    }

    private String buildStartAppPackageInfoValue(String r1, String r2, int r3) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
        return null;
    L5:
        if (TextUtils.isEmpty(r2) == false) goto L8;
        return null;
    L8:
        return r1 + LibrarianImpl.Constants.SEPARATOR + r2 + LibrarianImpl.Constants.SEPARATOR + r3;
    }

    private void saveStartAppPackageInfo(String r2) {
        Settings.Global.putString(getContentResolver(), "keyboard_custom_key_start_app_pkg", r2);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r2, boolean r3) {
        if (r2 != this.mItemSwitchPopupVirtualKeyboard.getSwitch()) goto L6;
        Settings.Secure.putInt(getContentResolver(), "show_virtual_ime_always", r3 ? 1 : 0);
        SettingsTracker.onSwitchStatus(TrackerConstants.TNT_SETTING_EVENT_ID, TrackerConstants.ALWAYS_ALLOW_VIRTUAL_KEYBOARD, r3);
        return;
    L6:
        if (r2 != this.mTraditionalChineseInput.getSwitch()) goto L9;
        Settings.Global.putInt(getContentResolver(), "traditional_input", r3 ? 1 : 0);
        return;
    L9:
        if (r2 != this.mSwitchKeyBoard.getSwitch()) goto L14;
        Settings.Global.putInt(this.mContext.getContentResolver(), Constants.SAFE_KEYBOARD_SWITCH, r3 ? 1 : 0);
        return;
    }

    private void updateKeyboardDialogDefaultLocationOptions() {
        String[] r0 = getResources().getStringArray(R.array.keyboard_location_limit_entries);
        int r1 = Settings.Global.getInt(getContentResolver(), KeyboardLocationSettingsFragment.KEYBOARD_DIALOG_DEFAULT_LOCATION, 1);
        this.mKeyboardLocationSettingItem.setSubTitle(r0[r1]);
    }

    @Override // com.android.settings.base.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ContentResolver r0 = this.mContext.getContentResolver();
        r0.unregisterContentObserver(this.mTraditionalInputObserver);
        r0.unregisterContentObserver(this.mRecognizeLanguageObserver);
        r0.unregisterContentObserver(this.mVirtualKeyboardPopupObserver);
        r0.unregisterContentObserver(this.mProjectionModeObserver);
        if (SettingsFeature.isSupportBostonKeyboard() == false) goto L6;
        this.mContext.unregisterReceiver(this.mBostonKeyboardState);
        return;
    }

    private void updateBostonKeyBoardView() {
        if (CasthalManager.getInstance(this.mContext) != null) goto L5;
    L7:
        boolean r0 = false;
    L8:
        OLog.d(this.TAG, "updateBostonKeyBoardView: isBostonKeyBoardConnected : " + r0);
        if (r0 == false) goto L11;
        findViewByIdNullable(R.id.f_functional_keys_gap_layout).setVisibility(0);
        this.mItemTextFFunctionalKeys.setVisibility(0);
        return;
    L11:
        findViewByIdNullable(R.id.f_functional_keys_gap_layout).setVisibility(8);
        this.mItemTextFFunctionalKeys.setVisibility(8);
        return;
    L5:
        if (CasthalManager.getInstance(this.mContext).isKeyboardConnected() == false) goto L7;
        r0 = true;
        goto L8
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_revone_KeyboardSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(KeyboardSettingsFragment r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_KeyboardSettingsFragment__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_KeyboardSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(KeyboardSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_revone_KeyboardSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_revone_KeyboardSettingsFragment_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(KeyboardSettingsFragment r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_revone_KeyboardSettingsFragment__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
