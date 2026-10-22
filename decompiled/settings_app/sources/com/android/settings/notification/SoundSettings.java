package com.android.settings.notification;

import android.app.Application;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.media.AudioManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.UserHandle;
import android.os.UserManager;
import android.os.Vibrator;
import android.preference.SeekBarVolumizer;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.preference.Preference;
import androidx.preference.TwoStatePreference;
import com.GlobalProxyLancet;
import com.android.settings.MultiSDKAdapterNew;
import com.android.settings.R;
import com.android.settings.RingtonePreference;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsInitialize;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.Utils;
import com.android.settings.search.BaseSearchIndexProvider;
import com.android.settings.search.Indexable;
import com.android.settings.teaevent.AppMetricsUtils;
import com.android.settingslib.RestrictedLockUtils;
import com.android.settingslib.RestrictedPreference;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class SoundSettings extends SettingsPreferenceFragment implements Indexable {
    private static final String KEY_ALARM_RINGTONE = "alarm_ringtone";
    private static final String KEY_ALARM_VOLUME = "alarm_volume";
    private static final String KEY_CELL_BROADCAST_SETTINGS = "cell_broadcast_settings";
    private static final String KEY_MEDIA_VOLUME = "media_volume";
    private static final String KEY_NOTIFICATION_RINGTONE = "notification_ringtone";
    private static final String KEY_NOTIFICATION_VOLUME = "notification_volume";
    private static final String KEY_PHONE_RINGTONE = "ringtone";
    private static final String KEY_RING_VOLUME = "ring_volume";
    private static final String KEY_VIBRATE_WHEN_RINGING = "vibrate_when_ringing";
    private static final String KEY_WIFI_DISPLAY = "wifi_display";
    private static final String KEY_ZEN_MODE = "zen_mode";
    private static final int REQUEST_CODE = 200;
    private static final String[] RESTRICTED_KEYS = null;
    private static final int SAMPLE_CUTOFF = 2000;
    public static final BaseSearchIndexProvider SEARCH_INDEX_DATA_PROVIDER = null;
    private static final String SELECTED_PREFERENCE_KEY = "selected_preference";
    private static final String TAG = "SoundSettings";
    private Preference mAlarmRingtonePreference;
    private AudioManager mAudioManager;
    private Context mContext;
    private final H mHandler;
    private final Runnable mLookupRingtoneNames;
    private Preference mNotificationRingtonePreference;
    private Preference mPhoneRingtonePreference;
    private PackageManager mPm;
    private final Receiver mReceiver;
    private RingtonePreference mRequestPreference;
    private VolumeSeekBarPreference mRingOrNotificationPreference;
    private int mRingerMode;
    private final SettingsObserver mSettingsObserver;
    private ComponentName mSuppressor;
    private UserManager mUserManager;
    private TwoStatePreference mVibrateWhenRinging;
    private Vibrator mVibrator;
    private boolean mVoiceCapable;
    private final VolumePreferenceCallback mVolumeCallback;
    private final ArrayList<VolumeSeekBarPreference> mVolumePrefs;

    private final class H extends Handler {
        private static final int STOP_SAMPLE = 3;
        private static final int UPDATE_ALARM_RINGTONE = 6;
        private static final int UPDATE_EFFECTS_SUPPRESSOR = 4;
        private static final int UPDATE_NOTIFICATION_RINGTONE = 2;
        private static final int UPDATE_PHONE_RINGTONE = 1;
        private static final int UPDATE_RINGER_MODE = 5;
        final /* synthetic */ SoundSettings this$0;

        /* synthetic */ H(SoundSettings r1, AnonymousClass1 r2) {
            this(r1);
        }

        private H(SoundSettings r1) {
            this.this$0 = r1;
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message r2) {
            switch(r2.what) {
                case 1: goto L10;
                case 2: goto L9;
                case 3: goto L8;
                case 4: goto L7;
                case 5: goto L6;
                case 6: goto L5;
                default: goto L17;
            };
        L5:
            SoundSettings.access$800(this.this$0).setSummary((CharSequence) r2.obj);
            return;
        L6:
            SoundSettings.access$1400(this.this$0);
            return;
        L7:
            SoundSettings.access$1300(this.this$0);
            return;
        L8:
            SoundSettings.access$1200(this.this$0).stopSample();
            return;
        L9:
            SoundSettings.access$700(this.this$0).setSummary((CharSequence) r2.obj);
            return;
        L10:
            SoundSettings.access$400(this.this$0).setSummary((CharSequence) r2.obj);
            return;
        }
    }

    private class Receiver extends BroadcastReceiver {
        private boolean mRegistered;
        final /* synthetic */ SoundSettings this$0;

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r1, Intent r2) {
            com_android_settings_notification_SoundSettings$Receiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
        }

        private Receiver(SoundSettings r1) {
            this.this$0 = r1;
        }

        /* synthetic */ Receiver(SoundSettings r1, AnonymousClass1 r2) {
            this(r1);
        }

        public void register(boolean r4) {
            if (this.mRegistered != r4) goto L5;
            return;
        L5:
            if (r4 == false) goto L7;
            IntentFilter r0 = new IntentFilter();
            r0.addAction("android.os.action.ACTION_EFFECTS_SUPPRESSOR_CHANGED");
            r0.addAction("android.media.INTERNAL_RINGER_MODE_CHANGED_ACTION");
            GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(SoundSettings.access$500(this.this$0), this, r0, 2);
        L8:
            this.mRegistered = r4;
            return;
        L7:
            SoundSettings.access$500(this.this$0).unregisterReceiver(this);
            goto L8
        }

        public void com_android_settings_notification_SoundSettings$Receiver__onReceive$___twin___(Context r1, Intent r2) {
            String r3 = r2.getAction();
            if ("android.os.action.ACTION_EFFECTS_SUPPRESSOR_CHANGED".equals(r3) == false) goto L6;
            SoundSettings.access$300(this.this$0).sendEmptyMessage(4);
            return;
        L6:
            if ("android.media.INTERNAL_RINGER_MODE_CHANGED_ACTION".equals(r3) == false) goto L10;
            SoundSettings.access$300(this.this$0).sendEmptyMessage(5);
            return;
        }

        @Insert("onReceive")
        public static void com_android_settings_notification_SoundSettings$Receiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(Receiver r7, Context r8, Intent r9) {
            Intrinsics.checkNotNullParameter(r8, "context");
            String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
            Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
            Receiver r1 = r7;
            String r2 = r1.getClass().getName();
            String r3 = r1.getClass().getSimpleName();
            boolean r4 = Intrinsics.areEqual(SettingsInitialize.class, r1.getClass());
            String r5 = null;
            if (r9 == null) goto L5;
            String r6 = r9.getAction();
        L7:
            if (ArraysKt.contains(r0, r6) == false) goto L13;
            StringBuilder r10 = new StringBuilder("onReceive allowList ");
            if (r9 == null) goto L11;
            r5 = r9.getAction();
        L11:
            OLog.i("PrivacyHookForReceiver", r10.append(r5).toString());
            r7.com_android_settings_notification_SoundSettings$Receiver__onReceive$___twin___(r8, r9);
            return;
        L13:
            GrantUtil r11 = GrantUtil.INSTANCE;
            Application r12 = SettingsApplication.getApplication();
            Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
            if (r11.isSetupCompelete(r12) == true) goto L16;
            OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
            r7.com_android_settings_notification_SoundSettings$Receiver__onReceive$___twin___(r8, r9);
            return;
        L16:
            String r13 = r3;
            if (r13 != null) goto L19;
        L22:
            boolean r14 = true;
        L23:
            if (r14 == false) goto L26;
            OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
            r7.com_android_settings_notification_SoundSettings$Receiver__onReceive$___twin___(r8, r9);
            return;
        L26:
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
            if (r4 == true) goto L30;
            OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
            return;
        L30:
            GrantUtil.INSTANCE.applicationInit();
            r7.com_android_settings_notification_SoundSettings$Receiver__onReceive$___twin___(r8, r9);
            return;
        L19:
            if (r13.length() == 0) goto L22;
            r14 = false;
            goto L23
        L5:
            r6 = null;
            goto L7
        }
    }

    private final class SettingsObserver extends ContentObserver {
        private final Uri VIBRATE_WHEN_RINGING_URI;
        final /* synthetic */ SoundSettings this$0;

        public SettingsObserver(SoundSettings r1) {
            this.this$0 = r1;
            super(SoundSettings.access$300(r1));
            this.VIBRATE_WHEN_RINGING_URI = Settings.System.getUriFor(SoundSettings.KEY_VIBRATE_WHEN_RINGING);
        }

        public void register(boolean r3) {
            ContentResolver r0 = SoundSettings.access$1000(this.this$0);
            if (r3 == false) goto L5;
            r0.registerContentObserver(this.VIBRATE_WHEN_RINGING_URI, false, this);
            return;
        L5:
            r0.unregisterContentObserver(this);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r1, Uri r2) {
            super.onChange(r1, r2);
            if (this.VIBRATE_WHEN_RINGING_URI.equals(r2) == false) goto L6;
            SoundSettings.access$1100(this.this$0);
            return;
        }
    }

    private final class VolumePreferenceCallback implements VolumeSeekBarPreference.Callback {
        private SeekBarVolumizer mCurrent;
        final /* synthetic */ SoundSettings this$0;

        @Override // com.android.settings.notification.VolumeSeekBarPreference.Callback
        public void onStreamValueChanged(int r1, int r2) {
        }

        private VolumePreferenceCallback(SoundSettings r1) {
            this.this$0 = r1;
        }

        /* synthetic */ VolumePreferenceCallback(SoundSettings r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.android.settings.notification.VolumeSeekBarPreference.Callback
        public void onSampleStarting(SeekBarVolumizer r4) {
            SeekBarVolumizer r0 = this.mCurrent;
            if (r0 == null) goto L6;
            if (r0 == r4) goto L6;
            r0.stopSample();
        L6:
            this.mCurrent = r4;
            if (r4 == null) goto L10;
            SoundSettings.access$300(this.this$0).removeMessages(3);
            SoundSettings.access$300(this.this$0).sendEmptyMessageDelayed(3, 2000);
            return;
        }

        public void stopSample() {
            SeekBarVolumizer r0 = this.mCurrent;
            if (r0 == null) goto L6;
            r0.stopSample();
            return;
        }
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_notification_SoundSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_notification_SoundSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public SoundSettings() {
        AnonymousClass1 r1 = null;
        this.mVolumeCallback = new VolumePreferenceCallback(this, r1);
        this.mHandler = new H(this, r1);
        this.mSettingsObserver = new SettingsObserver(this);
        this.mReceiver = new Receiver(this, r1);
        this.mVolumePrefs = new ArrayList();
        this.mRingerMode = -1;
        this.mLookupRingtoneNames = new AnonymousClass1(this);
    }

    static /* synthetic */ ContentResolver access$1000(SoundSettings r0) {
        return r0.getContentResolver();
    }

    static /* synthetic */ void access$1100(SoundSettings r0) {
        r0.updateVibrateWhenRinging();
    }

    static /* synthetic */ VolumePreferenceCallback access$1200(SoundSettings r0) {
        return r0.mVolumeCallback;
    }

    static /* synthetic */ void access$1300(SoundSettings r0) {
        r0.updateEffectsSuppressor();
    }

    static /* synthetic */ void access$1400(SoundSettings r0) {
        r0.updateRingerMode();
    }

    static /* synthetic */ H access$300(SoundSettings r0) {
        return r0.mHandler;
    }

    static /* synthetic */ Preference access$400(SoundSettings r0) {
        return r0.mPhoneRingtonePreference;
    }

    static /* synthetic */ Context access$500(SoundSettings r0) {
        return r0.mContext;
    }

    static /* synthetic */ CharSequence access$600(Context r0, int r1) {
        return updateRingtoneName(r0, r1);
    }

    static /* synthetic */ Preference access$700(SoundSettings r0) {
        return r0.mNotificationRingtonePreference;
    }

    static /* synthetic */ Preference access$800(SoundSettings r0) {
        return r0.mAlarmRingtonePreference;
    }

    static /* synthetic */ ContentResolver access$900(SoundSettings r0) {
        return r0.getContentResolver();
    }

    static {
        RESTRICTED_KEYS = new String[]{KEY_MEDIA_VOLUME, KEY_ALARM_VOLUME, KEY_RING_VOLUME, KEY_NOTIFICATION_VOLUME, KEY_ZEN_MODE};
        SEARCH_INDEX_DATA_PROVIDER = new AnonymousClass3();
    }

    public void com_android_settings_notification_SoundSettings__onCreate$___twin___(Bundle r7) {
        super.onCreate(r7);
        this.mContext = getActivity();
        this.mPm = getPackageManager();
        this.mUserManager = UserManager.get(getContext());
        this.mVoiceCapable = Utils.isVoiceCapable(this.mContext);
        this.mAudioManager = (AudioManager) this.mContext.getSystemService("audio");
        Vibrator r0 = (Vibrator) getActivity().getSystemService("vibrator");
        this.mVibrator = r0;
        if (r0 != null) goto L5;
    L7:
        addPreferencesFromResource(R.xml.sound_settings);
        initVolumePreference(KEY_MEDIA_VOLUME, 3, android.R.drawable.ic_qs_auto_rotate);
        initVolumePreference(KEY_ALARM_VOLUME, 4, android.R.drawable.ic_private_profile_icon_badge);
        if (this.mVoiceCapable == false) goto L10;
        this.mRingOrNotificationPreference = initVolumePreference(KEY_RING_VOLUME, 2, android.R.drawable.ic_qs_one_handed_mode);
        removePreference(KEY_NOTIFICATION_VOLUME);
    L11:
        boolean r1 = getResources().getBoolean(android.R.bool.config_closeDialogWhenTouchOutside);
        if (r1 == false) goto L17;
        boolean r3 = false;
        if (this.mPm.getApplicationEnabledSetting("com.android.cellbroadcastreceiver") != 2) goto L17;
        r1 = false;
    L19:
        if (this.mUserManager.isAdminUser() == false) goto L23;
        if (r3 == false) goto L23;
        if (MultiSDKAdapterNew.hasBaseUserRestriction(this.mContext, "no_config_cell_broadcasts", UserHandle.myUserId()) == true) goto L23;
    L24:
        initRingtones();
        initVibrateWhenRinging();
        updateRingerMode();
        updateEffectsSuppressor();
        if (r7 == null) goto L33;
        String r8 = r7.getString(SELECTED_PREFERENCE_KEY, null);
        if (TextUtils.isEmpty(r8) == true) goto L34;
        this.mRequestPreference = (RingtonePreference) findPreference(r8);
        return;
    L34:
        return;
    L33:
        return;
    L23:
        removePreference(KEY_CELL_BROADCAST_SETTINGS);
    L17:
        r3 = r1;
        goto L19
    L10:
        this.mRingOrNotificationPreference = initVolumePreference(KEY_NOTIFICATION_VOLUME, 5, android.R.drawable.ic_qs_one_handed_mode);
        removePreference(KEY_RING_VOLUME);
        goto L11
    L5:
        if (r0.hasVibrator() == true) goto L7;
        this.mVibrator = null;
        goto L7
    }

    public void com_android_settings_notification_SoundSettings__onResume$___twin___() {
        super.onResume();
        lookupRingtoneNames();
        this.mSettingsObserver.register(true);
        this.mReceiver.register(true);
        updateRingOrNotificationPreference();
        updateEffectsSuppressor();
        Iterator<VolumeSeekBarPreference> r0 = this.mVolumePrefs.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onActivityResume();
        goto L4
    L6:
        RestrictedLockUtils.EnforcedAdmin r1 = MultiSDKAdapterNew.checkIfRestrictionEnforced(this.mContext, "no_adjust_volume", UserHandle.myUserId());
        boolean r2 = MultiSDKAdapterNew.hasBaseUserRestriction(this.mContext, "no_adjust_volume", UserHandle.myUserId());
        String[] r3 = RESTRICTED_KEYS;
        int r4 = r3.length;
        int r5 = 0;
    L7:
        if (r5 >= r4) goto L16;
        Preference r6 = findPreference(r3[r5]);
        if (r6 == null) goto L12;
        r6.setEnabled(!r2);
    L12:
        if ((r6 instanceof RestrictedPreference) == false) goto L15;
        if (r2 == true) goto L15;
        ((RestrictedPreference) r6).setDisabledByAdmin(r1);
    L15:
        r5 = r5 + 1;
        goto L7
    L16:
        RestrictedPreference r7 = (RestrictedPreference) findPreference(KEY_CELL_BROADCAST_SETTINGS);
        if (r7 == null) goto L25;
        r7.checkRestrictionAndSetDisabled("no_config_cell_broadcasts");
        return;
    }

    @Override // com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Iterator<VolumeSeekBarPreference> r0 = this.mVolumePrefs.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onActivityPause();
        goto L4
    L6:
        this.mVolumeCallback.stopSample();
        this.mSettingsObserver.register(false);
        this.mReceiver.register(false);
    }

    @Override // androidx.preference.PreferenceFragmentCompat, androidx.preference.PreferenceManager.OnPreferenceTreeClickListener
    public boolean onPreferenceTreeClick(Preference r3) {
        if ((r3 instanceof RingtonePreference) == false) goto L7;
        RingtonePreference r0 = (RingtonePreference) r3;
        this.mRequestPreference = r0;
        r0.onPrepareRingtonePickerIntent(r0.getIntent());
        startActivityForResult(r3.getIntent(), 200);
        return true;
    L7:
        return super.onPreferenceTreeClick(r3);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        RingtonePreference r0 = this.mRequestPreference;
        if (r0 == null) goto L6;
        r0.onActivityResult(r2, r3, r4);
        this.mRequestPreference = null;
        return;
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r2) {
        super.onSaveInstanceState(r2);
        RingtonePreference r1 = this.mRequestPreference;
        if (r1 == null) goto L6;
        r2.putString(SELECTED_PREFERENCE_KEY, r1.getKey());
        return;
    }

    private VolumeSeekBarPreference initVolumePreference(String r2, int r3, int r4) {
        VolumeSeekBarPreference r5 = (VolumeSeekBarPreference) findPreference(r2);
        r5.setCallback(this.mVolumeCallback);
        r5.setStream(r3);
        this.mVolumePrefs.add(r5);
        r5.setMuteIcon(r4);
        return r5;
    }

    private void updateRingOrNotificationPreference() {
        VolumeSeekBarPreference r0 = this.mRingOrNotificationPreference;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.mSuppressor == null) goto L9;
        int r3 = android.R.drawable.ic_qs_one_handed_mode;
    L15:
        r0.showIcon(r3);
        return;
    L9:
        if (this.mRingerMode != 1) goto L11;
    L14:
        r3 = android.R.drawable.ic_qs_ui_mode_night;
        goto L15
    L11:
        if (wasRingerModeVibrate() == true) goto L14;
        r3 = android.R.drawable.ic_qs_night_display_on;
        goto L15
    }

    private boolean wasRingerModeVibrate() {
        if (this.mVibrator != null) goto L5;
    L9:
        return false;
    L5:
        if (this.mRingerMode != 0) goto L9;
        if (this.mAudioManager.getLastAudibleStreamVolume(2) != 0) goto L9;
        return true;
    }

    private void updateRingerMode() {
        int r0 = this.mAudioManager.getRingerModeInternal();
        if (this.mRingerMode != r0) goto L5;
        return;
    L5:
        this.mRingerMode = r0;
        updateRingOrNotificationPreference();
    }

    private void updateEffectsSuppressor() {
        ComponentName r0 = NotificationManager.from(this.mContext).getEffectsSuppressor();
        if (Objects.equals(r0, this.mSuppressor) == false) goto L5;
        return;
    L5:
        this.mSuppressor = r0;
        if (this.mRingOrNotificationPreference == null) goto L11;
        if (r0 == null) goto L9;
        String r1 = this.mContext.getString(android.R.string.permdesc_addVoicemail, new Object[]{getSuppressorCaption(r0)});
    L10:
        this.mRingOrNotificationPreference.setSuppressionText(r1);
        goto L11
    L9:
        r1 = null;
    L11:
        updateRingOrNotificationPreference();
    }

    private String getSuppressorCaption(ComponentName r3) {
        PackageManager r2 = this.mContext.getPackageManager();
        ServiceInfo r0 = r2.getServiceInfo(r3, 0);     // Catch: Throwable -> L10
        if (r0 == null) goto L13;
        CharSequence r4 = r0.loadLabel(r2);     // Catch: Throwable -> L10
        if (r4 == null) goto L13;
        String r5 = r4.toString().trim();     // Catch: Throwable -> L10
        if (r5.length() <= 0) goto L13;
        return r5;
    L13:
        return r3.getPackageName();
    L10:
        th = move-exception;
        OLog.w(TAG, "Error loading suppressor caption", th);
        goto L13
    }

    private void initRingtones() {
        Preference r0 = getPreferenceScreen().findPreference(KEY_PHONE_RINGTONE);
        this.mPhoneRingtonePreference = r0;
        if (r0 != null) goto L5;
    L7:
        this.mNotificationRingtonePreference = getPreferenceScreen().findPreference(KEY_NOTIFICATION_RINGTONE);
        this.mAlarmRingtonePreference = getPreferenceScreen().findPreference(KEY_ALARM_RINGTONE);
        return;
    L5:
        if (this.mVoiceCapable == true) goto L7;
        getPreferenceScreen().removePreference(this.mPhoneRingtonePreference);
        this.mPhoneRingtonePreference = null;
        goto L7
    }

    private void lookupRingtoneNames() {
        AsyncTask.execute(this.mLookupRingtoneNames);
    }

    private static CharSequence updateRingtoneName(Context r7, int r8) {
        Cursor r0 = null;
        if (r7 != null) goto L6;
        OLog.e(TAG, "Unable to update ringtone name, no context provided");
        return null;
    L6:
        Uri r2 = RingtoneManager.getActualDefaultRingtoneUri(r7, r8);
        String r9 = r7.getString(android.R.string.storage_internal);
        if (r2 == null) goto L30;
    L28:
        if (r0 == null) goto L36;
    L21:
        r0.close();
        return r9;
    L36:
        return r9;
    L26:
        if (r0 != null) goto L21;
        return r9;
    L22:
        th = move-exception;
        if (r0 == null) goto L25;
        r0.close();
    L25:
        throw th;
    L10:
        if ("media".equals(r2.getAuthority()) == false) goto L14;
        Cursor r10 = r7.getContentResolver().query(r2, new String[]{"title"}, null, null, null);     // Catch: Throwable -> L22 IllegalArgumentException -> L26 SQLiteException -> L28
    L12:
        r0 = r10;
    L16:
        if (r0 != null) goto L18;
    L20:
        if (r0 != null) goto L21;
        return r9;
    L18:
        if (r0.moveToFirst() == false) goto L20;
        r9 = r0.getString(0);     // Catch: Throwable -> L22 IllegalArgumentException -> L26 SQLiteException -> L28
    L14:
        if ("content".equals(r2.getScheme()) == false) goto L16;
        r10 = r7.getContentResolver().query(r2, new String[]{"_display_name"}, null, null, null);     // Catch: Throwable -> L22 IllegalArgumentException -> L26 SQLiteException -> L28
        goto L12
    L30:
        return r7.getString(android.R.string.stk_cc_ussd_to_ussd);
    }

    private void initVibrateWhenRinging() {
        TwoStatePreference r0 = (TwoStatePreference) getPreferenceScreen().findPreference(KEY_VIBRATE_WHEN_RINGING);
        this.mVibrateWhenRinging = r0;
        if (r0 != null) goto L7;
        OLog.i(TAG, "Preference not found: vibrate_when_ringing");
        return;
    L7:
        if (this.mVoiceCapable == true) goto L10;
        getPreferenceScreen().removePreference(this.mVibrateWhenRinging);
        this.mVibrateWhenRinging = null;
        return;
    L10:
        r0.setPersistent(false);
        updateVibrateWhenRinging();
        this.mVibrateWhenRinging.setOnPreferenceChangeListener(new AnonymousClass2(this));
    }

    private void updateVibrateWhenRinging() {
        TwoStatePreference r0 = this.mVibrateWhenRinging;
        if (r0 != null) goto L5;
        return;
    L5:
        boolean r2 = false;
        if (Settings.System.getInt(getContentResolver(), KEY_VIBRATE_WHEN_RINGING, 0) == 0) goto L8;
        r2 = true;
    L8:
        r0.setChecked(r2);
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_notification_SoundSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(SoundSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_notification_SoundSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_notification_SoundSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(SoundSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_notification_SoundSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_notification_SoundSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(SoundSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_notification_SoundSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
