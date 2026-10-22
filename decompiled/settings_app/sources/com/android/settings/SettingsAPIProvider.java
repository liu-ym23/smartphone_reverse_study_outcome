package com.android.settings;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.text.TextUtils;
import com.android.internal.telephony.ISms;
import com.android.internal.widget.LockPatternUtils;
import com.android.settings.applications.PickApplicationActivity;
import com.android.settings.applications.PreferredSettingsUtils;
import com.android.settings.eyesprotection.EyesProtectionAPI;
import com.android.settings.sidedial.SideDialHelper;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settings.utils.NotificationHelper;
import com.android.settings.utils.SettingsProviderUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;
import settings.PreferredActivityChooseUtils;

/* JADX INFO: loaded from: classes2.dex */
public class SettingsAPIProvider extends ContentProvider {
    private static final String COLOR_MODE_ID = "mode_id";
    private static final String EXTRAS_CHANGED_URI = "changed_uri";
    private static final String EXTRAS_VISIBLE = "visible";
    private static String EXTRA_RESULT = null;
    private static final String METHOD_GET_KEYGUARD_STORED_PASSWORD_QUALITY = "getKeyguardStoredPasswordQuality";
    private static final String METHOD_GET_NOTIFICATION_CHANNELS = "getNotificationChannels";
    private static final String METHOD_GET_PREMIUM_SMS_PERMISSION = "getPremiumSmsPermission";
    private static final String METHOD_GET_SUPPORT_SHOW_FILE_MIME_TYPE = "getSupportShowFileMimeType";
    private static final String METHOD_NOTIFY_SETTINGS_CHANGED = "notifySettingsChanged";
    private static final String METHOD_NOTIFY_SETTINGS_CHANGE_OTHERS_SUFFIX = "notifySettingsChangedFileSuffix";
    private static final String METHOD_SEND_BROADCAST = "sendBroadcast";
    private static final String METHOD_SET_ACTIVE_MODE = "setActiveMode";
    private static final String METHOD_SET_FINGER_VISIBLE = "set_finger_visible";
    private static final String METHOD_SET_IS_SECURE = "isSecure";
    private static final String METHOD_SET_NOTIFICATION_CHANNELS = "setNotificationChannels";
    private static final String METHOD_SET_READ_MODE = "setReadMode";
    private static String TAG = "SettingsAPIProvider";
    private static final int UPDATE_DAILY_TIME = 300;
    private static Uri sUri;
    private PreferredActivityChooseUtils mChooseUtils;
    private Context mContext;
    private Handler mHandler;

    public void com_android_settings_SettingsAPIProvider__onCreate$___twin___() {
        super.onCreate();
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r1) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r1, ContentValues r2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public void onCreate() {
        com_android_settings_SettingsAPIProvider_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Provider(this);
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        return 0;
    }

    public SettingsAPIProvider() {
        this.mHandler = new Handler();
    }

    static {
        sUri = Uri.parse("content://com.android.settings.apiprovider");
        EXTRA_RESULT = "extra_result";
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r6, String r7, Bundle r8) {
        OLog.d(TAG, "call method: " + r6);
        this.mContext = getContext();
        if (r6 == null) goto L95;
        int r2 = 1;
        Object r3 = null;
        if (METHOD_SET_ACTIVE_MODE.equals(r6) == false) goto L15;
        Object r5 = new Object();
        if (r8 != null) goto L9;
    L13:
        return null;
    L9:
        if (r8.containsKey(COLOR_MODE_ID) == false) goto L13;
        EyesProtectionAPI.getInstance(true).setActiveMode(r8.getInt(COLOR_MODE_ID));
    L12:
        r3 = r5;
    L90:
        OLog.d(TAG, "result: " + r3);
        Bundle r9 = new Bundle();
        r9.putString(EXTRA_RESULT, String.valueOf(r3));
        return r9;
    L15:
        if (METHOD_NOTIFY_SETTINGS_CHANGED.equals(r6) == false) goto L24;
        r3 = new Object();
        if (r8 == null) goto L90;
        if (r8.containsKey(EXTRAS_CHANGED_URI) == false) goto L90;
        String r10 = r8.getString(EXTRAS_CHANGED_URI);
        if (TextUtils.isEmpty(r10) == true) goto L90;
        handleSettingsChanged(Uri.parse(r10));
        goto L90
    L24:
        if (METHOD_GET_SUPPORT_SHOW_FILE_MIME_TYPE.equals(r6) == false) goto L27;
        r3 = PreferredSettingsUtils.getSupportShowFileMimeType(getContext(), this.mChooseUtils);
        goto L90
    L27:
        if (METHOD_SET_IS_SECURE.equals(r6) == false) goto L30;
        r3 = Boolean.valueOf(new LockPatternUtils(getContext()).isSecure(UserHandle.myUserId()));
        goto L90
    L30:
        if (METHOD_GET_KEYGUARD_STORED_PASSWORD_QUALITY.equals(r6) == false) goto L33;
        r3 = Integer.valueOf(new LockPatternUtils(getContext()).getKeyguardStoredPasswordQuality(UserHandle.myUserId()));
        goto L90
    L33:
        if (METHOD_GET_PREMIUM_SMS_PERMISSION.equals(r6) == false) goto L39;
        r5 = 0;
        ISms r11 = ISms.Stub.asInterface(ServiceManager.getService("isms"));
        if (r11 == null) goto L12;
        r5 = Integer.valueOf(r11.getPremiumSmsPermission(r7));     // Catch: RemoteException -> L96
        goto L12
    L39:
        if (METHOD_GET_NOTIFICATION_CHANNELS.equals(r6) == false) goto L42;
        r3 = NotificationHelper.getInstance().getChannelsByJson(r7);
        goto L90
    L42:
        if (METHOD_SET_NOTIFICATION_CHANNELS.equals(r6) == false) goto L45;
        NotificationHelper.getInstance().setChannels(r7);
        r3 = new Object();
        goto L90
    L45:
        if (METHOD_SET_FINGER_VISIBLE.equals(r6) == false) goto L59;
        r3 = new Object();
        if (r8 == null) goto L90;
        if (r8.containsKey(EXTRAS_VISIBLE) == false) goto L90;
        boolean r12 = r8.getBoolean(EXTRAS_VISIBLE);     // Catch: Exception -> L56
        OLog.i("FingerprintProvider", "set_finger_visible, caller [" + getCallingPackage() + "], visible " + r12);     // Catch: Exception -> L56
        ContentResolver r13 = SettingsApplication.getContext().getContentResolver();     // Catch: Exception -> L56
        if (r12 == true) goto L54;
        r2 = -1;
    L54:
        android.provider.Settings.Global.putInt(r13, "SHOW_FINGERPRINT_ENROLL_ICON", r2);     // Catch: Exception -> L56
    L56:
        e = move-exception;
        e.printStackTrace();
        goto L90
    L59:
        if (METHOD_SET_READ_MODE.equals(r6) == false) goto L64;
        if (SettingsFeature.isSupportReadMode() == true) goto L90;
    L64:
        if (METHOD_SEND_BROADCAST.equals(r6) == false) goto L84;
        if (TextUtils.isEmpty(r7) == true) goto L72;
        Intent r14 = new Intent(r7);
        if ("android.intent.action.AIRPLANE_MODE".equalsIgnoreCase(r7) == false) goto L71;
        if (r8 == null) goto L71;
        r14.putExtra("state", r8.getBoolean("state", false));
    L71:
        SettingsApplication.getContext().sendBroadcastAsUser(r14, UserHandle.ALL);
        goto L90
    L72:
        if (r8 == null) goto L90;
        Intent r15 = (Intent) r8.getParcelable("intent");
        if (r15 == null) goto L90;
        String r16 = r8.getString("receiverPermission");
        UserHandle r17 = (UserHandle) r8.getParcelable(PickApplicationActivity.EXTRA_USER);
        if (r16 == null) goto L80;
        if (r17 == null) goto L79;
        SettingsApplication.getContext().sendBroadcastAsUser(r15, r17, r16);
        goto L90
    L79:
        SettingsApplication.getContext().sendBroadcast(r15, r16);
        goto L90
    L80:
        if (r17 == null) goto L82;
        SettingsApplication.getContext().sendBroadcastAsUser(r15, r17);
        goto L90
    L82:
        SettingsApplication.getContext().sendBroadcast(r15);
        goto L90
    L84:
        if (METHOD_NOTIFY_SETTINGS_CHANGE_OTHERS_SUFFIX.equals(r6) == false) goto L93;
        if (r8 == null) goto L90;
        String r18 = r8.getString(PreferredSettingsUtils.OTHERS_SUFFIX_KEY, "");
        String r19 = r8.getString(PreferredSettingsUtils.OTHERS_MIME_TYPE_KEY, "");
        if (TextUtils.isEmpty(r19) == true) goto L90;
        if (r18 == null) goto L90;
        PreferredSettingsUtils.handleChangeSuffix(getContext(), r19, r18);
        goto L90
    L93:
        throw new IllegalArgumentException("SettingsAPIProvider: NOT support method " + r6);
    L95:
        throw new IllegalArgumentException("SettingsAPIProvider: call method is null");
    }

    private void handleSettingsChanged(Uri r7) {
        if (r7.equals(android.provider.Settings.Global.getUriFor("side_dial_enable")) == false) goto L5;
    L81:
        SideDialHelper.handleSideDialStateChanged(this.mContext);
        return;
    L5:
        if (r7.equals(android.provider.Settings.Global.getUriFor("side_dial_type")) == true) goto L81;
        if (r7.equals(android.provider.Settings.Global.getUriFor("side_dial_car_mode_switch")) == true) goto L81;
        if (r7.equals(android.provider.Settings.Global.getUriFor(SettingsProviderUtils.SIDE_DIAL_CUSTOM_MODE_SWITCH)) == true) goto L81;
        if (r7.equals(android.provider.Settings.System.getUriFor("accelerometer_rotation")) == false) goto L18;
        if (SettingsProviderUtils.getSideDialType(this.mContext) != 5) goto L16;
        Context r6 = this.mContext;
        SideDialHelper.removeCurrentCustomMadeSwitchIfNeed(r6, Constants.SIDE_DIAL_CUSTOM_MODE_SCREEN_ROTATION, SettingsProviderUtils.isAccelerometerRotation(r6));
        return;
    L16:
        Context r8 = this.mContext;
        SideDialHelper.removeCurrentCarMadeSwitchIfNeed(r8, Constants.SIDE_DIAL_CAR_MODE_SCREEN_ROTATION, SettingsProviderUtils.isAccelerometerRotation(r8));
        return;
    L18:
        if (r7.equals(android.provider.Settings.Global.getUriFor("stay_on_alltime")) == false) goto L24;
        if (SettingsProviderUtils.getSideDialType(this.mContext) != 5) goto L22;
        Context r9 = this.mContext;
        SideDialHelper.removeCurrentCustomMadeSwitchIfNeed(r9, Constants.SIDE_DIAL_CUSTOM_MODE_ALWAYS_ON_SCREEN, SettingsProviderUtils.isStayOnAllTimeEnable(r9));
        return;
    L22:
        Context r10 = this.mContext;
        SideDialHelper.removeCurrentCarMadeSwitchIfNeed(r10, Constants.SIDE_DIAL_CAR_MODE_ALWAYS_ON_SCREEN, SettingsProviderUtils.isStayOnAllTimeEnable(r10));
        return;
    L24:
        if (r7.equals(android.provider.Settings.System.getUriFor("screen_brightness_mode")) == false) goto L27;
        Context r11 = this.mContext;
        SideDialHelper.removeCurrentCustomMadeSwitchIfNeed(r11, Constants.SIDE_DIAL_CUSTOM_MODE_AUTO_BRIGHTNESS, SettingsProviderUtils.isAutoBrightness(r11));
        return;
    L27:
        if (r7.equals(android.provider.Settings.Global.getUriFor(SoundSettingsFragment.GLOBAL_VIBRATION_ENABLED)) == false) goto L51;
        boolean r1 = true;
        if (android.provider.Settings.Global.getInt(this.mContext.getContentResolver(), "global_pc_mode_settings", 0) != 1) goto L31;
        boolean r12 = true;
    L33:
        if (android.provider.Settings.Global.getInt(this.mContext.getContentResolver(), "bytedanceos.phone.silence", 1) != 1) goto L35;
        boolean r3 = true;
    L37:
        if (android.provider.Settings.Global.getInt(this.mContext.getContentResolver(), SoundSettingsFragment.GLOBAL_VIBRATION_ENABLED, 1) != 1) goto L39;
        boolean r0 = true;
    L41:
        if (PreferenceMgr.getInstance(this.mContext).getInt(PreferenceMgr.KEY_GLOBAL_VIBRATION_ENABLED_RECORD, 0) == 1) goto L44;
        r1 = false;
    L44:
        if (r12 == false) goto L49;
        if (r3 == false) goto L49;
        if (r1 == false) goto L49;
        if (r0 == false) goto L49;
        PreferenceMgr.getInstance(this.mContext).putInt(PreferenceMgr.KEY_GLOBAL_VIBRATION_ENABLED_RECORD, 0);
    L49:
        Context r13 = this.mContext;
        SideDialHelper.removeCurrentCustomMadeSwitchIfNeed(r13, Constants.SIDE_DIAL_CUSTOM_MODE_GLOBAL_VIBRATE, SettingsProviderUtils.isGlobalVibration(r13));
        return;
    L39:
        r0 = false;
        goto L41
    L35:
        r3 = false;
        goto L37
    L31:
        r12 = false;
        goto L33
    L51:
        if (r7.equals(android.provider.Settings.System.getUriFor("haptic_feedback_enabled")) == false) goto L54;
        Context r14 = this.mContext;
        SideDialHelper.removeCurrentCustomMadeSwitchIfNeed(r14, Constants.SIDE_DIAL_CUSTOM_MODE_FEEDBACK_VIBRATION, SettingsProviderUtils.isFeedbackVibration(r14));
        return;
    L54:
        if (r7.equals(android.provider.Settings.Global.getUriFor("telephony_vibration_enabled")) == false) goto L57;
        Context r15 = this.mContext;
        SideDialHelper.removeCurrentCustomMadeSwitchIfNeed(r15, Constants.SIDE_DIAL_CUSTOM_MODE_TELEPHONY_VIBRATE, SettingsProviderUtils.isTelephonyVibrate(r15));
        return;
    L57:
        if (r7.equals(android.provider.Settings.System.getUriFor("volume_panel_mute_enable")) == false) goto L60;
        Context r16 = this.mContext;
        SideDialHelper.removeCurrentCustomMadeSwitchIfNeed(r16, Constants.SIDE_DIAL_CUSTOM_MODE_MUTE, SettingsProviderUtils.isMute(r16));
        return;
    L60:
        if (SettingsFeature.isSupportReadMode() == false) goto L68;
        if (r7.equals(android.provider.Settings.Global.getUriFor("read_mode_enable")) == false) goto L68;
        if (Utils.isDeviceProvisioned(this.mContext) == true) goto L66;
        return;
    L66:
        Context r17 = this.mContext;
        SideDialHelper.removeCurrentCustomMadeSwitchIfNeed(r17, Constants.SIDE_DIAL_CUSTOM_MODE_READ_MODE, SettingsProviderUtils.isReadMode(r17));
        return;
    L68:
        if (r7.equals(android.provider.Settings.Global.getUriFor("feature_phone_mode")) == false) goto L93;
        PreferenceMgr r18 = PreferenceMgr.getInstance(this.mContext);
        if (SettingsFeature.isSupportSideDialKey() == true) goto L72;
        return;
    L72:
        if (SettingsProviderUtils.isFeaturePhoneMode(this.mContext) == false) goto L75;
        r18.putBoolean(Constants.SIDE_DIAL_ENTER_FUTURE_PHONE_STATUS, SettingsProviderUtils.isSideDialEnable(this.mContext));
        return;
    L75:
        if (SettingsProviderUtils.isSideDialEnable(this.mContext) == true) goto L77;
    L80:
        this.mHandler.postDelayed(new SettingsAPIProvider$$ExternalSyntheticLambda0(this), 300);
        return;
    L77:
        if (SettingsProviderUtils.isSideDialEnable(this.mContext) == true) goto L79;
        return;
    L79:
        if (r18.getBoolean(Constants.SIDE_DIAL_ENTER_FUTURE_PHONE_STATUS, false) == false) goto L80;
        return;
    }

    /* JADX INFO: renamed from: lambda$handleSettingsChanged$0$com-android-settings-SettingsAPIProvider, reason: not valid java name */
    /* synthetic */ void m205xbf922194() {
        SideDialHelper.handleSideDialStateChanged(this.mContext);
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.mChooseUtils = new PreferredActivityChooseUtils(getContext());
        return false;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.content.ContentProvider")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_SettingsAPIProvider_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_Provider(SettingsAPIProvider r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_SettingsAPIProvider__onCreate$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L5;
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportColdStartProvider(r0);
    L5:
        AppMetricsUtils.INSTANCE.setColdStartTime(0);
    }
}
