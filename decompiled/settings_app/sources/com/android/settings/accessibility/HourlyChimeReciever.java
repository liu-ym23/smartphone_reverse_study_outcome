package com.android.settings.accessibility;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;
import android.provider.Settings;
import android.speech.tts.TextToSpeech;
import android.text.format.DateUtils;
import com.android.settings.ExecutorManager;
import com.android.settings.PreferenceMgr;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsInitialize;
import com.android.settings.Utils;
import com.android.vcard.VCardConfig;
import com.bytedance.sremlib.LibUtil;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes2.dex */
public class HourlyChimeReciever extends BroadcastReceiver {
    public static final String ACTION_HOURLY_CHIME = "com.android.settings.HOURLY_CHIME";
    public static final int HOURLY_CHIME_REQUEST_CODE = 17;
    public static final String SETTINGS_PACKAGE_NAME = "com.android.settings";
    private int mChimeFrequency;
    private int mChimeType;
    private int mEndTime;
    private boolean mIsHourlyChimeEnabled;
    private long mLastTimesetTimeMillis;
    private int mStartTime;
    private TextSpeaker mTextSpeaker;
    private String mVoiceUri;

    public class TextSpeaker implements TextToSpeech.OnInitListener {
        private Locale currentLocale;
        private boolean isReady;
        private TextToSpeech textToSpeech;
        private String textWaiting;
        final /* synthetic */ HourlyChimeReciever this$0;

        static /* synthetic */ TextToSpeech access$300(TextSpeaker r0) {
            return r0.textToSpeech;
        }

        public TextSpeaker(final HourlyChimeReciever r4, Context r5) {
            this.this$0 = r4;
            this.isReady = false;
            TextToSpeech r1 = new TextToSpeech(r5.getApplicationContext(), this);
            this.textToSpeech = r1;
            r1.setOnUtteranceProgressListener(new AnonymousClass1(this, r4));
            this.currentLocale = r5.getResources().getConfiguration().getLocales().get(0);
        }

        @Override // android.speech.tts.TextToSpeech.OnInitListener
        public void onInit(int r1) {
            if (r1 != 0) goto L6;
            this.isReady = true;
            String r2 = this.textWaiting;
            if (r2 == null) goto L8;
            speak(r2);
            return;
        L8:
            return;
        L6:
            this.isReady = false;
        }

        public void speak(String r4) {
            if (this.isReady == true) goto L7;
            this.textWaiting = r4;
            return;
        L7:
            if (Utils.isChineseLocale() == false) goto L9;
            Locale r0 = Locale.CHINA;
        L10:
            int r1 = this.textToSpeech.setLanguage(r0);
            if (r1 != 0) goto L13;
        L14:
            this.textToSpeech.speak(r4, 0, null);
            this.textWaiting = null;
            return;
        L13:
            if (r1 == 1) goto L14;
            return;
        L9:
            r0 = Locale.ENGLISH;
            goto L10
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r1, Intent r2) {
        com_android_settings_accessibility_HourlyChimeReciever_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
    }

    public HourlyChimeReciever() {
        this.mIsHourlyChimeEnabled = false;
        this.mChimeFrequency = -1;
        this.mChimeType = -1;
        this.mStartTime = -1;
        this.mEndTime = -1;
        this.mLastTimesetTimeMillis = -1;
    }

    static /* synthetic */ void access$000(HourlyChimeReciever r0, Context r1) {
        r0.updateSetting(r1);
    }

    static /* synthetic */ boolean access$100(HourlyChimeReciever r0, Context r1) {
        return r0.tryChime(r1);
    }

    static /* synthetic */ boolean access$200(HourlyChimeReciever r0) {
        return r0.mIsHourlyChimeEnabled;
    }

    public void com_android_settings_accessibility_HourlyChimeReciever__onReceive$___twin___(Context r5, Intent r6) {
        final Context r7 = r5.getApplicationContext();
        if (ACTION_HOURLY_CHIME != r6.getAction()) goto L6;
        new Thread(new AnonymousClass1(this, r7)).start();
        return;
    L6:
        if (LibUtil.ACTION_BOOT_COMPLETELY != r6.getAction()) goto L8;
    L11:
        updateSetting(r7);
        ExecutorManager.execute(new AnonymousClass2(this, r7));
        if ("android.intent.action.TIME_SET" != r6.getAction()) goto L14;
    L15:
        long r0 = System.currentTimeMillis();
        if (this.mLastTimesetTimeMillis > r0) goto L18;
        return;
    L18:
        if (tryChime(r7) == false) goto L25;
        PreferenceMgr.getInstance(r7).putLong(PreferenceMgr.KEY_HOURLY_CHIME_TIMESET_MILLIS, r0);
        return;
    L25:
        return;
    L14:
        if ("android.intent.action.TIMEZONE_CHANGED" == r6.getAction()) goto L15;
        return;
    L8:
        if ("android.intent.action.TIME_SET" == r6.getAction()) goto L11;
        if ("android.intent.action.TIMEZONE_CHANGED" == r6.getAction()) goto L11;
    }

    private boolean tryChime(Context r5) {
        if (this.mIsHourlyChimeEnabled == true) goto L5;
        return false;
    L5:
        Calendar r0 = Calendar.getInstance(TimeZone.getDefault());
        int r2 = r0.get(12);
        int r1 = (r0.get(11) * 100) + r2;
        if ((r2 % this.mChimeFrequency) == 0) goto L8;
        return false;
    L8:
        int r3 = this.mStartTime;
        int r4 = this.mEndTime;
        if (r3 >= r4) goto L13;
        if (r1 < r3) goto L12;
        if (r1 > r4) goto L12;
    L19:
        int r6 = this.mChimeType;
        if (r6 != 0) goto L22;
        chimeInVoice(r5, r1);
    L27:
        return true;
    L22:
        if (r6 != 1) goto L25;
        chimeInRingTone(r5, this.mVoiceUri);
        goto L27
    L25:
        if (r6 != 2) goto L27;
        chimeInVibration(r5);
    L12:
        return false;
    L13:
        if (r3 <= r4) goto L17;
        if (r1 >= r3) goto L19;
        if (r1 <= r4) goto L19;
        return false;
    L17:
        if (r1 == r3) goto L19;
        return false;
    }

    public static void maintainChimeLife(Context r8) {
        Intent r0 = new Intent();
        r0.setAction(ACTION_HOURLY_CHIME);
        r0.setPackage("com.android.settings");
        r0.setFlags(32);
        PendingIntent r1 = PendingIntent.getBroadcast(r8, 17, r0, VCardConfig.FLAG_CONVERT_PHONETIC_NAME_STRINGS);
        ((AlarmManager) r8.getSystemService("alarm")).setExactAndAllowWhileIdle(0, ((System.currentTimeMillis() / 900000) + 1) * 900000, r1);
        PreferenceMgr.getInstance(r8).putLong(PreferenceMgr.KEY_HOURLY_CHIME_TIMESET_MILLIS, System.currentTimeMillis());
    }

    public static void cancelChime(Context r3) {
        Intent r0 = new Intent();
        r0.setAction(ACTION_HOURLY_CHIME);
        r0.setPackage("com.android.settings");
        r0.setFlags(32);
        PendingIntent r1 = PendingIntent.getBroadcast(r3, 17, r0, VCardConfig.FLAG_CONVERT_PHONETIC_NAME_STRINGS);
        ((AlarmManager) r3.getSystemService("alarm")).cancel(r1);
    }

    private void chimeInVoice(Context r2, int r3) {
        if (this.mTextSpeaker != null) goto L5;
        this.mTextSpeaker = new TextSpeaker(this, r2);
    L5:
        this.mTextSpeaker.speak(getTimeString(r2, r3));
    }

    private String getTimeString(Context r3, int r4) {
        int r2 = r4 % 100;
        Calendar r0 = Calendar.getInstance();
        r0.set(11, r4 / 100);
        r0.set(12, r2);
        return DateUtils.formatDateTime(r3, r0.getTimeInMillis(), 1);
    }

    private void chimeInRingTone(Context r1, String r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        Ringtone r0 = RingtoneManager.getRingtone(r1, Uri.parse(r2));
        if (r0 != null) goto L7;
        return;
    L7:
        r0.play();
    }

    private void chimeInVibration(Context r2) {
        Vibrator r1 = (Vibrator) r2.getSystemService("vibrator");
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.hasVibrator() == false) goto L9;
        r1.vibrate(new long[]{0, 250, 250, 250}, -1);
        return;
    }

    private void updateSetting(Context r5) {
        boolean r1 = true;
        if (Settings.Global.getInt(r5.getContentResolver(), "accessibility_hourly_chime", 0) == 1) goto L6;
        r1 = false;
    L6:
        this.mIsHourlyChimeEnabled = r1;
        this.mChimeFrequency = Settings.Global.getInt(r5.getContentResolver(), "accessibility_hourly_chime_frequency", 60);
        this.mChimeType = Settings.Global.getInt(r5.getContentResolver(), "accessibility_hourly_chime_type", 0);
        this.mStartTime = Settings.Global.getInt(r5.getContentResolver(), "accessibility_hourly_chime_start", 800);
        this.mEndTime = Settings.Global.getInt(r5.getContentResolver(), "accessibility_hourly_chime_end", HourlyChimeFragment.DEFAULT_CHIME_END);
        this.mVoiceUri = Settings.System.getString(r5.getContentResolver(), "hourly_chime_ringtone_uri");
        this.mLastTimesetTimeMillis = PreferenceMgr.getInstance(r5).getLong(PreferenceMgr.KEY_HOURLY_CHIME_TIMESET_MILLIS, -1);
    }

    @Insert("onReceive")
    public static void com_android_settings_accessibility_HourlyChimeReciever_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(HourlyChimeReciever r7, Context r8, Intent r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        String[] r0 = {"android.bluetooth.device.action.PAIRING_REQUEST", "android.bluetooth.device.action.BOND_STATE_CHANGED", "com.bytedanceos.launcher.new_message", "intent.provision.import_data", "com.android.settings.action.SHOW_IMPORT_DATA_NOTIFICATION"};
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.content.BroadcastReceiver");
        HourlyChimeReciever r1 = r7;
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
        r7.com_android_settings_accessibility_HourlyChimeReciever__onReceive$___twin___(r8, r9);
        return;
    L13:
        GrantUtil r11 = GrantUtil.INSTANCE;
        Application r12 = SettingsApplication.getApplication();
        Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
        if (r11.isSetupCompelete(r12) == true) goto L16;
        OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
        r7.com_android_settings_accessibility_HourlyChimeReciever__onReceive$___twin___(r8, r9);
        return;
    L16:
        String r13 = r3;
        if (r13 != null) goto L19;
    L22:
        boolean r14 = true;
    L23:
        if (r14 == false) goto L26;
        OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
        r7.com_android_settings_accessibility_HourlyChimeReciever__onReceive$___twin___(r8, r9);
        return;
    L26:
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
        if (r4 == true) goto L30;
        OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
        return;
    L30:
        GrantUtil.INSTANCE.applicationInit();
        r7.com_android_settings_accessibility_HourlyChimeReciever__onReceive$___twin___(r8, r9);
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
