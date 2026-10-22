package com.android.settings.notification;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.search.BaseSearchIndexProvider;
import com.android.settings.search.Indexable;
import com.android.settings.teaevent.AppMetricsUtils;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class OtherSoundSettings extends SettingsPreferenceFragment implements Indexable {
    private static final int DEFAULT_DOCK_AUDIO_MEDIA = 0;
    private static final int DEFAULT_EMERGENCY_TONE = 0;
    private static final int DEFAULT_ON = 1;
    private static final int DOCK_AUDIO_MEDIA_DISABLED = 0;
    private static final int DOCK_AUDIO_MEDIA_ENABLED = 1;
    private static final int EMERGENCY_TONE_ALERT = 1;
    private static final int EMERGENCY_TONE_SILENT = 0;
    private static final int EMERGENCY_TONE_VIBRATE = 2;
    private static final String KEY_CHARGING_SOUNDS = "charging_sounds";
    private static final String KEY_DIAL_PAD_TONES = "dial_pad_tones";
    private static final String KEY_DOCKING_SOUNDS = "docking_sounds";
    private static final String KEY_DOCK_AUDIO_MEDIA = "dock_audio_media";
    private static final String KEY_EMERGENCY_TONE = "emergency_tone";
    private static final String KEY_SCREEN_LOCKING_SOUNDS = "screen_locking_sounds";
    private static final String KEY_TOUCH_SOUNDS = "touch_sounds";
    private static final String KEY_VIBRATE_ON_TOUCH = "vibrate_on_touch";
    private static final SettingPref[] PREFS = null;
    private static final SettingPref PREF_CHARGING_SOUNDS = null;
    private static final SettingPref PREF_DIAL_PAD_TONES = null;
    private static final SettingPref PREF_DOCKING_SOUNDS = null;
    private static final SettingPref PREF_DOCK_AUDIO_MEDIA = null;
    private static final SettingPref PREF_EMERGENCY_TONE = null;
    private static final SettingPref PREF_SCREEN_LOCKING_SOUNDS = null;
    private static final SettingPref PREF_TOUCH_SOUNDS = null;
    private static final SettingPref PREF_VIBRATE_ON_TOUCH = null;
    public static final BaseSearchIndexProvider SEARCH_INDEX_DATA_PROVIDER = null;
    private static final String TAG = "OtherSoundSettings";
    private Context mContext;
    private final SettingsObserver mSettingsObserver;

    private final class SettingsObserver extends ContentObserver {
        final /* synthetic */ OtherSoundSettings this$0;

        public SettingsObserver(OtherSoundSettings r1) {
            this.this$0 = r1;
            super(new Handler());
        }

        public void register(boolean r6) {
            ContentResolver r0 = OtherSoundSettings.access$200(this.this$0);
            if (r6 == false) goto L7;
            SettingPref[] r7 = OtherSoundSettings.access$300();
            int r1 = r7.length;
            int r3 = 0;
        L5:
            if (r3 >= r1) goto L10;
            r0.registerContentObserver(r7[r3].getUri(), false, this);
            r3 = r3 + 1;
            goto L5
        L10:
            return;
        L7:
            r0.unregisterContentObserver(this);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r5, Uri r6) {
            super.onChange(r5, r6);
            SettingPref[] r7 = OtherSoundSettings.access$300();
            int r0 = r7.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L9;
            SettingPref r2 = r7[r1];
            if (r2.getUri().equals(r6) == true) goto L6;
            r1 = r1 + 1;
            goto L3
        L6:
            r2.update(OtherSoundSettings.access$400(this.this$0));
            return;
        }
    }

    @Override // com.android.settings.SettingsPreferenceFragment
    protected int getHelpResource() {
        return R.string.help_uri_other_sounds;
    }

    @Override // com.android.settings.SettingsPreferenceFragment, androidx.preference.PreferenceFragmentCompat, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        com_android_settings_notification_OtherSoundSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(this, r1);
    }

    @Override // com.android.settings.SettingsPreferenceFragment, com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onResume() {
        com_android_settings_notification_OtherSoundSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(this);
    }

    public OtherSoundSettings() {
        this.mSettingsObserver = new SettingsObserver(this);
    }

    static /* synthetic */ boolean access$000(Context r0) {
        return hasDockSettings(r0);
    }

    static /* synthetic */ boolean access$100(Context r0) {
        return hasHaptic(r0);
    }

    static /* synthetic */ ContentResolver access$200(OtherSoundSettings r0) {
        return r0.getContentResolver();
    }

    static /* synthetic */ SettingPref[] access$300() {
        return PREFS;
    }

    static /* synthetic */ Context access$400(OtherSoundSettings r0) {
        return r0.mContext;
    }

    static {
        final int r1 = 2;
        final String r2 = KEY_DIAL_PAD_TONES;
        final String r3 = "dtmf_tone";
        final int r4 = 1;
        final int[] r5 = new int[0];
        SettingPref r6 = new AnonymousClass1(r1, r2, r3, r4, r5);
        PREF_DIAL_PAD_TONES = r6;
        final int r12 = 1;
        SettingPref r0 = new SettingPref(2, KEY_SCREEN_LOCKING_SOUNDS, "lockscreen_sounds_enabled", 1, new int[0]);
        PREF_SCREEN_LOCKING_SOUNDS = r0;
        final int r18 = 1;
        SettingPref r7 = new SettingPref(1, KEY_CHARGING_SOUNDS, "charging_sounds_enabled", 1, new int[0]);
        PREF_CHARGING_SOUNDS = r7;
        final int r9 = 1;
        final String r10 = KEY_DOCKING_SOUNDS;
        final String r11 = "dock_sounds_enabled";
        final int[] r13 = new int[0];
        SettingPref r8 = new AnonymousClass2(r9, r10, r11, r12, r13);
        PREF_DOCKING_SOUNDS = r8;
        final int r15 = 2;
        final String r16 = KEY_TOUCH_SOUNDS;
        final String r17 = "sound_effects_enabled";
        final int[] r14 = new int[0];
        SettingPref r19 = new AnonymousClass3(r15, r16, r17, r18, r14);
        PREF_TOUCH_SOUNDS = r19;
        final int r20 = 2;
        final String r110 = KEY_VIBRATE_ON_TOUCH;
        final String r111 = "haptic_feedback_enabled";
        final int[] r112 = new int[0];
        SettingPref r21 = new AnonymousClass4(r20, r110, r111, r12, r112);
        PREF_VIBRATE_ON_TOUCH = r21;
        final int r113 = 1;
        final String r114 = KEY_DOCK_AUDIO_MEDIA;
        final String r115 = "dock_audio_media_enabled";
        final int r116 = 0;
        final int[] r22 = {0, 1};
        SettingPref r23 = new AnonymousClass5(r113, r114, r115, r116, r22);
        PREF_DOCK_AUDIO_MEDIA = r23;
        final int r24 = 1;
        final String r25 = KEY_EMERGENCY_TONE;
        final String r26 = KEY_EMERGENCY_TONE;
        final int r27 = 0;
        final int[] r117 = {1, 2, 0};
        SettingPref r28 = new AnonymousClass6(r24, r25, r26, r27, r117);
        PREF_EMERGENCY_TONE = r28;
        PREFS = new SettingPref[]{r6, r0, r7, r8, r19, r21, r23, r28};
        SEARCH_INDEX_DATA_PROVIDER = new AnonymousClass7();
    }

    public void com_android_settings_notification_OtherSoundSettings__onCreate$___twin___(Bundle r4) {
        super.onCreate(r4);
        addPreferencesFromResource(R.xml.other_sound_settings);
        this.mContext = getActivity();
        SettingPref[] r5 = PREFS;
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r5[r1].init(this);
        r1 = r1 + 1;
        goto L3
    }

    public void com_android_settings_notification_OtherSoundSettings__onResume$___twin___() {
        super.onResume();
        this.mSettingsObserver.register(true);
    }

    @Override // com.android.settings.InstrumentedPreferenceFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.mSettingsObserver.register(false);
    }

    private static boolean hasDockSettings(Context r1) {
        return r1.getResources().getBoolean(R.bool.has_dock_settings);
    }

    private static boolean hasHaptic(Context r1) {
        Vibrator r2 = (Vibrator) r1.getSystemService("vibrator");
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.hasVibrator() == false) goto L7;
        return true;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onCreate")
    public static void com_android_settings_notification_OtherSoundSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onCreate_FragmentX(OtherSoundSettings r2, Bundle r3) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_notification_OtherSoundSettings__onCreate$___twin___(r3);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onCreate_FragmentX " + r0);
        AppMetricsUtils r4 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r4.callingPackageEvent("self", r0, true);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_notification_OtherSoundSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onResume_FragmentX(OtherSoundSettings r2) {
        String r0 = r2.getClass().getName();
        com_android_settings_notification_OtherSoundSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(r2);
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onResume_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.recordVisibleTime(r0);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "androidx.fragment.app.Fragment")
    @Insert(mayCreateSuper = true, value = "onResume")
    public static void com_android_settings_notification_OtherSoundSettings_com_obric_hook_lancet_AppLifecycleMetricsLancet_onPause_FragmentX(OtherSoundSettings r2) {
        String r0 = r2.getClass().getName();
        r2.com_android_settings_notification_OtherSoundSettings__onResume$___twin___();
        if (GrantUtil.INSTANCE.isPrivacyAllowed() == false) goto L6;
        OLog.i("AppLifecycle", "onPause_FragmentX " + r0);
        AppMetricsUtils r3 = AppMetricsUtils.INSTANCE;
        Intrinsics.checkNotNull(r0);
        r3.reportVisibleTime(r0, true);
        return;
    }
}
