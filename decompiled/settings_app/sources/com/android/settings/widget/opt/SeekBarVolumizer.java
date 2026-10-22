package com.android.settings.widget.opt;

import android.app.Application;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.media.audiopolicy.AudioProductStrategy;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.preference.VolumePreference;
import android.provider.Settings;
import android.service.notification.ZenModeConfig;
import android.widget.SeekBar;
import androidx.profileinstaller.ProfileInstallReceiver$$ExternalSyntheticLambda0;
import com.GlobalProxyLancet;
import com.android.internal.os.SomeArgs;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsInitialize;
import com.obric.olog.OLog;
import com.obric.privacy.GrantUtil;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class SeekBarVolumizer implements SeekBar.OnSeekBarChangeListener, Handler.Callback {
    private static final int CHECK_RINGTONE_PLAYBACK_DELAY_MS = 1000;
    private static final int CHECK_UPDATE_SLIDER_LATER_MS = 500;
    private static final long DURATION_TO_START_DELAYING = 0;
    private static final int MSG_GROUP_VOLUME_CHANGED = 1;
    private static final int MSG_INIT_SAMPLE = 3;
    private static final int MSG_SET_STREAM_VOLUME = 0;
    private static final int MSG_START_SAMPLE = 1;
    private static final int MSG_STOP_SAMPLE = 2;
    private static final int MSG_UPDATE_SLIDER_MAYBE_LATER = 4;
    private static final long SET_STREAM_VOLUME_DELAY_MS = 0;
    private static final long START_SAMPLE_DELAY_MS = 0;
    private static final String TAG = "SeekBarVolumizer";
    private static long sStopVolumeTime;
    private boolean mAffectedByRingerMode;
    private boolean mAllowAlarms;
    private boolean mAllowMedia;
    private boolean mAllowRinger;
    private boolean mAnimateProgress;
    private AudioAttributes mAttributes;
    private final AudioManager mAudioManager;
    private final Callback mCallback;
    private final Context mContext;
    private final Uri mDefaultUri;
    private final boolean mDeviceHasProductStrategies;
    private Handler mHandler;
    private int mLastAudibleStreamVolume;
    private int mLastProgress;
    private final int mMaxStreamVolume;
    private boolean mMuted;
    private final NotificationManager mNotificationManager;
    private boolean mNotificationOrRing;
    private NotificationManager.Policy mNotificationPolicy;
    private int mOriginalStreamVolume;
    private boolean mPlaySample;
    private final Receiver mReceiver;
    private int mRingerMode;
    private Ringtone mRingtone;
    private SeekBar mSeekBar;
    private final int mStreamType;
    private final H mUiHandler;
    private UpdateSlideParam mUpdateSlideParam;
    private AtomicBoolean mUserChangingProgress;
    private int mVolumeBeforeMute;
    private final AudioManager.VolumeGroupCallback mVolumeGroupCallback;
    private int mVolumeGroupId;
    private final Handler mVolumeHandler;
    private Observer mVolumeObserver;
    private int mZenMode;

    public interface Callback {
        void onMuted(boolean r1, boolean r2);

        void onProgressChanged(SeekBar r1, int r2, boolean r3);

        void onSampleStarting(SeekBarVolumizer r1);

        void onStartTrackingTouch(SeekBarVolumizer r1);

        default void onStopTrackingTouch(SeekBarVolumizer r1) {
        }

        default void onUpdateSlideCompleted() {
        }
    }

    private final class H extends Handler {
        private static final int RESET_PROGRESS_CHANGED_BY_USER = 2;
        private static final int UPDATE_SLIDER = 1;
        final /* synthetic */ SeekBarVolumizer this$0;

        private H(SeekBarVolumizer r1) {
            this.this$0 = r1;
        }

        /* synthetic */ H(SeekBarVolumizer r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r4) {
            if (r4.what != 1) goto L19;
            if (SeekBarVolumizer.access$500(this.this$0) == null) goto L22;
            SeekBarVolumizer.access$602(this.this$0, r4.arg1);
            SeekBarVolumizer.access$702(this.this$0, r4.arg2);
            boolean r5 = ((Boolean) r4.obj).booleanValue();
            if (r5 == SeekBarVolumizer.access$800(this.this$0)) goto L11;
            SeekBarVolumizer.access$802(this.this$0, r5);
            if (SeekBarVolumizer.access$900(this.this$0) == null) goto L11;
            SeekBarVolumizer.access$900(this.this$0).onMuted(SeekBarVolumizer.access$800(this.this$0), SeekBarVolumizer.access$1000(this.this$0));
        L11:
            this.this$0.updateSeekBar();
            UpdateSlideParam r0 = new UpdateSlideParam(SeekBarVolumizer.access$600(this.this$0), SeekBarVolumizer.access$700(this.this$0), r5);
            if (SeekBarVolumizer.access$1100(this.this$0) != null) goto L14;
        L15:
            SeekBarVolumizer.access$1102(this.this$0, r0);
            if (SeekBarVolumizer.access$900(this.this$0) == null) goto L24;
            SeekBarVolumizer.access$900(this.this$0).onUpdateSlideCompleted();
            return;
        L24:
            return;
        L14:
            if (UpdateSlideParam.access$1200(r0, SeekBarVolumizer.access$1100(this.this$0)) == false) goto L15;
            return;
        L22:
            return;
        L19:
            if (r4.what != 2) goto L26;
            SeekBarVolumizer.access$1300(this.this$0).set(false);
            return;
        }

        public void postUpdateSlider(int r2, int r3, boolean r4) {
            if (SeekBarVolumizer.access$1300(this.this$0).get() == false) goto L6;
            OLog.w(SeekBarVolumizer.TAG, "progress changing, delay update");
            return;
        L6:
            sendMessageDelayed(obtainMessage(1, r2, r3, Boolean.valueOf(r4)), 150);
        }

        public void delayResetUserTouchingKey() {
            if (hasMessages(2) == false) goto L5;
            removeMessages(2);
        L5:
            sendEmptyMessageDelayed(2, 100);
        }
    }

    private final class Observer extends ContentObserver {
        final /* synthetic */ SeekBarVolumizer this$0;

        public Observer(SeekBarVolumizer r1, Handler r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r1) {
            super.onChange(r1);
            SeekBarVolumizer.access$1400(this.this$0);
        }
    }

    private final class Receiver extends BroadcastReceiver {
        private boolean mListening;
        final /* synthetic */ SeekBarVolumizer this$0;

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r1, Intent r2) {
            com_android_settings_widget_opt_SeekBarVolumizer$Receiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
        }

        private Receiver(SeekBarVolumizer r1) {
            this.this$0 = r1;
        }

        /* synthetic */ Receiver(SeekBarVolumizer r1, AnonymousClass1 r2) {
            this(r1);
        }

        public void setListening(boolean r3) {
            if (this.mListening != r3) goto L5;
            return;
        L5:
            this.mListening = r3;
            if (r3 == false) goto L8;
            IntentFilter r4 = new IntentFilter("android.media.VOLUME_CHANGED_ACTION");
            r4.addAction("android.media.INTERNAL_RINGER_MODE_CHANGED_ACTION");
            r4.addAction("android.app.action.INTERRUPTION_FILTER_CHANGED");
            r4.addAction("android.app.action.NOTIFICATION_POLICY_CHANGED");
            r4.addAction("android.media.STREAM_DEVICES_CHANGED_ACTION");
            GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(SeekBarVolumizer.access$1500(this.this$0), this, r4, 2);
            return;
        L8:
            SeekBarVolumizer.access$1500(this.this$0).unregisterReceiver(this);
        }

        public void com_android_settings_widget_opt_SeekBarVolumizer$Receiver__onReceive$___twin___(Context r3, Intent r4) {
            String r5 = r4.getAction();
            if ("android.media.VOLUME_CHANGED_ACTION".equals(r5) == false) goto L10;
            int r6 = r4.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1);
            int r7 = r4.getIntExtra("android.media.EXTRA_VOLUME_STREAM_VALUE", -1);
            if (SeekBarVolumizer.access$1600(this.this$0) == true) goto L7;
            return;
        L7:
            if (SeekBarVolumizer.access$1700(this.this$0) == true) goto L35;
            updateVolumeSlider(r6, r7);
            return;
        L35:
            return;
        L10:
            if ("android.media.INTERNAL_RINGER_MODE_CHANGED_ACTION".equals(r5) == false) goto L18;
            if (SeekBarVolumizer.access$1800(this.this$0) == false) goto L15;
            SeekBarVolumizer r8 = this.this$0;
            SeekBarVolumizer.access$1902(r8, SeekBarVolumizer.access$2000(r8).getRingerModeInternal());
        L15:
            if (SeekBarVolumizer.access$2100(this.this$0) == false) goto L37;
            SeekBarVolumizer.access$1400(this.this$0);
            return;
        L37:
            return;
        L18:
            if ("android.media.STREAM_DEVICES_CHANGED_ACTION".equals(r5) == false) goto L21;
            return;
        L21:
            if ("android.app.action.INTERRUPTION_FILTER_CHANGED".equals(r5) == false) goto L24;
            SeekBarVolumizer r9 = this.this$0;
            SeekBarVolumizer.access$2202(r9, SeekBarVolumizer.access$2300(r9).getZenMode());
            SeekBarVolumizer.access$1400(this.this$0);
            return;
        L24:
            if ("android.app.action.NOTIFICATION_POLICY_CHANGED".equals(r5) == false) goto L40;
            SeekBarVolumizer r10 = this.this$0;
            SeekBarVolumizer.access$2402(r10, SeekBarVolumizer.access$2300(r10).getConsolidatedNotificationPolicy());
            SeekBarVolumizer r11 = this.this$0;
            boolean r0 = false;
            if ((SeekBarVolumizer.access$2400(r11).priorityCategories & 32) == 0) goto L28;
            boolean r12 = true;
        L29:
            SeekBarVolumizer.access$2502(r11, r12);
            SeekBarVolumizer r13 = this.this$0;
            if ((SeekBarVolumizer.access$2400(r13).priorityCategories & 64) == 0) goto L32;
            r0 = true;
        L32:
            SeekBarVolumizer.access$2602(r13, r0);
            SeekBarVolumizer r14 = this.this$0;
            SeekBarVolumizer.access$2702(r14, !ZenModeConfig.areAllPriorityOnlyRingerSoundsMuted(SeekBarVolumizer.access$2400(r14)));
            SeekBarVolumizer.access$1400(this.this$0);
            return;
        L28:
            r12 = false;
            goto L29
        }

        private void updateVolumeSlider(int r4, int r5) {
            boolean r1 = true;
            if (r4 != SeekBarVolumizer.access$2800(this.this$0)) goto L5;
            boolean r6 = true;
        L7:
            if (SeekBarVolumizer.access$500(this.this$0) == null) goto L18;
            if (r6 == true) goto L10;
            return;
        L10:
            if (r5 != (-1)) goto L12;
            return;
        L12:
            if (SeekBarVolumizer.access$2000(this.this$0).isStreamMute(SeekBarVolumizer.access$2800(this.this$0)) == true) goto L16;
            if (r5 == 0) goto L16;
            r1 = false;
        L16:
            SeekBarVolumizer.access$2900(this.this$0).postUpdateSlider(r5, SeekBarVolumizer.access$700(this.this$0), r1);
            return;
        L18:
            return;
        L5:
            r6 = false;
            goto L7
        }

        @Insert("onReceive")
        public static void com_android_settings_widget_opt_SeekBarVolumizer$Receiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(Receiver r7, Context r8, Intent r9) {
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
            r7.com_android_settings_widget_opt_SeekBarVolumizer$Receiver__onReceive$___twin___(r8, r9);
            return;
        L13:
            GrantUtil r11 = GrantUtil.INSTANCE;
            Application r12 = SettingsApplication.getApplication();
            Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
            if (r11.isSetupCompelete(r12) == true) goto L16;
            OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
            r7.com_android_settings_widget_opt_SeekBarVolumizer$Receiver__onReceive$___twin___(r8, r9);
            return;
        L16:
            String r13 = r3;
            if (r13 != null) goto L19;
        L22:
            boolean r14 = true;
        L23:
            if (r14 == false) goto L26;
            OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
            r7.com_android_settings_widget_opt_SeekBarVolumizer$Receiver__onReceive$___twin___(r8, r9);
            return;
        L26:
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
            if (r4 == true) goto L30;
            OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
            return;
        L30:
            GrantUtil.INSTANCE.applicationInit();
            r7.com_android_settings_widget_opt_SeekBarVolumizer$Receiver__onReceive$___twin___(r8, r9);
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

    private static class UpdateSlideParam {
        final int lastAudibleStreamVolume;
        final boolean muted;
        final int progress;

        static /* synthetic */ boolean access$1200(UpdateSlideParam r0, UpdateSlideParam r1) {
            return r0.isSame(r1);
        }

        UpdateSlideParam(int r1, int r2, boolean r3) {
            this.progress = r1;
            this.lastAudibleStreamVolume = r2;
            this.muted = r3;
        }

        private boolean isSame(UpdateSlideParam r3) {
            if (this.progress == r3.progress) goto L5;
        L9:
            return false;
        L5:
            if (this.lastAudibleStreamVolume != r3.lastAudibleStreamVolume) goto L9;
            if (this.muted != r3.muted) goto L9;
            return true;
        }
    }

    private class VolumeHandler extends Handler {
        final /* synthetic */ SeekBarVolumizer this$0;

        private VolumeHandler(SeekBarVolumizer r1) {
            this.this$0 = r1;
        }

        /* synthetic */ VolumeHandler(SeekBarVolumizer r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r3) {
            SomeArgs r0 = (SomeArgs) r3.obj;
            if (r3.what != 1) goto L13;
            int r4 = ((Integer) r0.arg1).intValue();
            if (SeekBarVolumizer.access$3000(this.this$0) == r4) goto L8;
            return;
        L8:
            if (SeekBarVolumizer.access$3000(this.this$0) == (-1)) goto L14;
            SeekBarVolumizer.access$1400(this.this$0);
            return;
        L14:
            return;
        }
    }

    private static boolean isAlarmsStream(int r1) {
        if (r1 != 4) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isMediaStream(int r1) {
        if (r1 != 3) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean isNotificationOrRing(int r1) {
        if (r1 != 2) goto L5;
    L8:
        return true;
    L5:
        if (r1 == 5) goto L8;
        return false;
    }

    private void setStopVolumeTime() {
    }

    static /* synthetic */ Handler access$100(SeekBarVolumizer r0) {
        return r0.mHandler;
    }

    static /* synthetic */ boolean access$1000(SeekBarVolumizer r0) {
        return r0.isZenMuted();
    }

    static /* synthetic */ UpdateSlideParam access$1100(SeekBarVolumizer r0) {
        return r0.mUpdateSlideParam;
    }

    static /* synthetic */ UpdateSlideParam access$1102(SeekBarVolumizer r0, UpdateSlideParam r1) {
        r0.mUpdateSlideParam = r1;
        return r1;
    }

    static /* synthetic */ AtomicBoolean access$1300(SeekBarVolumizer r0) {
        return r0.mUserChangingProgress;
    }

    static /* synthetic */ void access$1400(SeekBarVolumizer r0) {
        r0.updateSlider();
    }

    static /* synthetic */ Context access$1500(SeekBarVolumizer r0) {
        return r0.mContext;
    }

    static /* synthetic */ boolean access$1600(SeekBarVolumizer r0) {
        return r0.mDeviceHasProductStrategies;
    }

    static /* synthetic */ boolean access$1700(SeekBarVolumizer r0) {
        return r0.isDelay();
    }

    static /* synthetic */ boolean access$1800(SeekBarVolumizer r0) {
        return r0.mNotificationOrRing;
    }

    static /* synthetic */ int access$1902(SeekBarVolumizer r0, int r1) {
        r0.mRingerMode = r1;
        return r1;
    }

    static /* synthetic */ Handler access$200(SeekBarVolumizer r0) {
        return r0.mVolumeHandler;
    }

    static /* synthetic */ AudioManager access$2000(SeekBarVolumizer r0) {
        return r0.mAudioManager;
    }

    static /* synthetic */ boolean access$2100(SeekBarVolumizer r0) {
        return r0.mAffectedByRingerMode;
    }

    static /* synthetic */ int access$2202(SeekBarVolumizer r0, int r1) {
        r0.mZenMode = r1;
        return r1;
    }

    static /* synthetic */ NotificationManager access$2300(SeekBarVolumizer r0) {
        return r0.mNotificationManager;
    }

    static /* synthetic */ NotificationManager.Policy access$2400(SeekBarVolumizer r0) {
        return r0.mNotificationPolicy;
    }

    static /* synthetic */ NotificationManager.Policy access$2402(SeekBarVolumizer r0, NotificationManager.Policy r1) {
        r0.mNotificationPolicy = r1;
        return r1;
    }

    static /* synthetic */ boolean access$2502(SeekBarVolumizer r0, boolean r1) {
        r0.mAllowAlarms = r1;
        return r1;
    }

    static /* synthetic */ boolean access$2602(SeekBarVolumizer r0, boolean r1) {
        r0.mAllowMedia = r1;
        return r1;
    }

    static /* synthetic */ boolean access$2702(SeekBarVolumizer r0, boolean r1) {
        r0.mAllowRinger = r1;
        return r1;
    }

    static /* synthetic */ int access$2800(SeekBarVolumizer r0) {
        return r0.mStreamType;
    }

    static /* synthetic */ H access$2900(SeekBarVolumizer r0) {
        return r0.mUiHandler;
    }

    static /* synthetic */ int access$3000(SeekBarVolumizer r0) {
        return r0.mVolumeGroupId;
    }

    static /* synthetic */ SeekBar access$500(SeekBarVolumizer r0) {
        return r0.mSeekBar;
    }

    static /* synthetic */ int access$600(SeekBarVolumizer r0) {
        return r0.mLastProgress;
    }

    static /* synthetic */ int access$602(SeekBarVolumizer r0, int r1) {
        r0.mLastProgress = r1;
        return r1;
    }

    static /* synthetic */ int access$700(SeekBarVolumizer r0) {
        return r0.mLastAudibleStreamVolume;
    }

    static /* synthetic */ int access$702(SeekBarVolumizer r0, int r1) {
        r0.mLastAudibleStreamVolume = r1;
        return r1;
    }

    static /* synthetic */ boolean access$800(SeekBarVolumizer r0) {
        return r0.mMuted;
    }

    static /* synthetic */ boolean access$802(SeekBarVolumizer r0, boolean r1) {
        r0.mMuted = r1;
        return r1;
    }

    static /* synthetic */ Callback access$900(SeekBarVolumizer r0) {
        return r0.mCallback;
    }

    static {
        SET_STREAM_VOLUME_DELAY_MS = TimeUnit.MILLISECONDS.toMillis(500);
        START_SAMPLE_DELAY_MS = TimeUnit.MILLISECONDS.toMillis(500);
        DURATION_TO_START_DELAYING = TimeUnit.MILLISECONDS.toMillis(2000);
    }

    public SeekBarVolumizer(Context r7, int r8, Uri r9, Callback r10) {
        this(r7, r8, r9, r10, true);
    }

    public SeekBarVolumizer(Context r6, int r7, Uri r8, Callback r9, boolean r10) {
        AnonymousClass1 r1 = null;
        this.mVolumeHandler = new VolumeHandler(this, r1);
        this.mVolumeGroupCallback = new AnonymousClass1(this);
        this.mUiHandler = new H(this, r1);
        this.mReceiver = new Receiver(this, r1);
        this.mLastProgress = -1;
        this.mVolumeBeforeMute = -1;
        this.mAnimateProgress = true;
        boolean r2 = false;
        this.mUserChangingProgress = new AtomicBoolean(false);
        this.mContext = r6;
        AudioManager r3 = (AudioManager) r6.getSystemService(AudioManager.class);
        this.mAudioManager = r3;
        boolean r4 = hasAudioProductStrategies();
        this.mDeviceHasProductStrategies = r4;
        NotificationManager r11 = (NotificationManager) r6.getSystemService(NotificationManager.class);
        this.mNotificationManager = r11;
        NotificationManager.Policy r5 = r11.getConsolidatedNotificationPolicy();
        this.mNotificationPolicy = r5;
        if ((r5.priorityCategories & 32) == 0) goto L5;
        boolean r12 = true;
    L6:
        this.mAllowAlarms = r12;
        if ((this.mNotificationPolicy.priorityCategories & 64) == 0) goto L9;
        r2 = true;
    L9:
        this.mAllowMedia = r2;
        this.mAllowRinger = true ^ ZenModeConfig.areAllPriorityOnlyRingerSoundsMuted(this.mNotificationPolicy);
        this.mStreamType = r7;
        this.mAffectedByRingerMode = r3.isStreamAffectedByRingerMode(r7);
        boolean r0 = isNotificationOrRing(r7);
        this.mNotificationOrRing = r0;
        if (r0 == false) goto L12;
        this.mRingerMode = r3.getRingerModeInternal();
    L12:
        this.mZenMode = r11.getZenMode();
        if (r4 == false) goto L15;
        this.mVolumeGroupId = getVolumeGroupIdForLegacyStreamType(r7);
        this.mAttributes = getAudioAttributesForLegacyStreamType(r7);
    L15:
        this.mMaxStreamVolume = r3.getStreamMaxVolume(r7);
        this.mCallback = r9;
        this.mOriginalStreamVolume = r3.getStreamVolume(r7);
        this.mLastAudibleStreamVolume = r3.getLastAudibleStreamVolume(r7);
        boolean r13 = r3.isStreamMute(r7);
        this.mMuted = r13;
        this.mPlaySample = r10;
        if (r9 == null) goto L18;
        r9.onMuted(r13, isZenMuted());
    L18:
        if (r8 == null) goto L20;
    L26:
        this.mDefaultUri = r8;
        return;
    L20:
        if (r7 != 2) goto L23;
        r8 = Settings.System.DEFAULT_RINGTONE_URI;
        goto L26
    L23:
        if (r7 != 5) goto L25;
        r8 = Settings.System.DEFAULT_NOTIFICATION_URI;
        goto L26
    L25:
        r8 = Settings.System.DEFAULT_ALARM_ALERT_URI;
        goto L26
    L5:
        r12 = false;
        goto L6
    }

    private boolean hasAudioProductStrategies() {
        if (AudioManager.getAudioProductStrategies().size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private int getVolumeGroupIdForLegacyStreamType(int r3) {
        Iterator r2 = AudioManager.getAudioProductStrategies().iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        int r0 = ((AudioProductStrategy) r2.next()).getVolumeGroupIdForLegacyStreamType(r3);
        if (r0 == (-1)) goto L4;
        return r0;
    L9:
        return ((Integer) AudioManager.getAudioProductStrategies().stream().map(new SeekBarVolumizer$$ExternalSyntheticLambda0()).filter(new SeekBarVolumizer$$ExternalSyntheticLambda1()).findFirst().orElse(-1)).intValue();
    }

    static /* synthetic */ Integer lambda$getVolumeGroupIdForLegacyStreamType$0(AudioProductStrategy r1) {
        return Integer.valueOf(r1.getVolumeGroupIdForAudioAttributes(AudioProductStrategy.getDefaultAttributes()));
    }

    static /* synthetic */ boolean lambda$getVolumeGroupIdForLegacyStreamType$1(Integer r1) {
        if (r1.intValue() == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    private AudioAttributes getAudioAttributesForLegacyStreamType(int r2) {
        Iterator r1 = AudioManager.getAudioProductStrategies().iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        AudioAttributes r0 = ((AudioProductStrategy) r1.next()).getAudioAttributesForLegacyStreamType(r2);
        if (r0 == null) goto L4;
        return r0;
    L9:
        return new AudioAttributes.Builder().setContentType(0).setUsage(0).build();
    }

    public void setSeekBar(SeekBar r3) {
        SeekBar r0 = this.mSeekBar;
        if (r0 == null) goto L5;
        r0.setOnSeekBarChangeListener(null);
    L5:
        this.mSeekBar = r3;
        r3.setOnSeekBarChangeListener(null);
        this.mSeekBar.setMax(this.mMaxStreamVolume);
        updateSeekBar();
        this.mSeekBar.setOnSeekBarChangeListener(this);
    }

    private boolean isZenMuted() {
        if (this.mNotificationOrRing == true) goto L5;
    L6:
        int r0 = this.mZenMode;
        if (r0 == 2) goto L25;
        if (r0 == 1) goto L10;
    L22:
        return false;
    L10:
        if (this.mAllowAlarms == true) goto L14;
        if (isAlarmsStream(this.mStreamType) == false) goto L14;
        return true;
    L14:
        if (this.mAllowMedia == true) goto L18;
        if (isMediaStream(this.mStreamType) == false) goto L18;
        return true;
    L18:
        if (this.mAllowRinger == true) goto L22;
        if (isNotificationOrRing(this.mStreamType) == false) goto L22;
        return true;
    L25:
        return true;
    L5:
        if (this.mZenMode != 3) goto L6;
        return true;
    }

    protected void updateSeekBar() {
        if (this.mNotificationOrRing == false) goto L8;
        if (this.mRingerMode != 1) goto L8;
        this.mSeekBar.setProgress(0, this.mAnimateProgress);
        return;
    L8:
        if (this.mMuted == false) goto L10;
        this.mSeekBar.setProgress(0, this.mAnimateProgress);
        return;
    L10:
        SeekBar r0 = this.mSeekBar;
        int r1 = this.mLastProgress;
        if (r1 > (-1)) goto L14;
        r1 = this.mOriginalStreamVolume;
    L14:
        r0.setProgress(r1, this.mAnimateProgress);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message r5) {
        int r0 = r5.what;
        if (r0 == 0) goto L22;
        if (r0 == 1) goto L20;
        if (r0 == 2) goto L17;
        if (r0 == 3) goto L14;
        if (r0 == 4) goto L12;
        OLog.e(TAG, "invalid SeekBarVolumizer message: " + r5.what);
    L32:
        return true;
    L12:
        onUpdateSliderMaybeLater();
        goto L32
    L14:
        if (this.mPlaySample == false) goto L32;
        onInitSample();
        goto L32
    L17:
        if (this.mPlaySample == false) goto L32;
        onStopSample();
        goto L32
    L20:
        if (this.mPlaySample == false) goto L32;
        onStartSample();
        goto L32
    L22:
        boolean r6 = this.mMuted;
        if (r6 == true) goto L25;
    L27:
        if (r6 == false) goto L29;
    L31:
        this.mAudioManager.setStreamVolume(this.mStreamType, this.mLastProgress, 1024);
        goto L32
    L29:
        if (this.mLastProgress != 0) goto L31;
        this.mAudioManager.adjustStreamVolume(this.mStreamType, -100, 0);
        goto L31
    L25:
        if (this.mLastProgress <= 0) goto L27;
        this.mAudioManager.adjustStreamVolume(this.mStreamType, 100, 0);
        goto L31
    }

    private void onInitSample() {
        monitor-enter(this);
        Ringtone r0 = RingtoneManager.getRingtone(this.mContext, this.mDefaultUri);     // Catch: Throwable -> L8
        this.mRingtone = r0;     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        r0.setStreamType(this.mStreamType);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void postStartSample() {
        Handler r0 = this.mHandler;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.removeMessages(1);
        Handler r1 = this.mHandler;
        Message r2 = r1.obtainMessage(1);
        if (isSamplePlaying() == false) goto L9;
        long r3 = 1000;
    L12:
        r1.sendMessageDelayed(r2, r3);
        return;
    L9:
        if (isDelay() == false) goto L11;
        r3 = START_SAMPLE_DELAY_MS;
        goto L12
    L11:
        r3 = 0;
        goto L12
    }

    private void onUpdateSliderMaybeLater() {
        if (isDelay() == false) goto L6;
        postUpdateSliderMaybeLater();
        return;
    L6:
        updateSlider();
    }

    private void postUpdateSliderMaybeLater() {
        Handler r0 = this.mHandler;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.removeMessages(4);
        Handler r3 = this.mHandler;
        r3.sendMessageDelayed(r3.obtainMessage(4), 500);
    }

    private boolean isDelay() {
        long r0 = System.currentTimeMillis() - sStopVolumeTime;
        if (r0 >= 0) goto L5;
    L7:
        return false;
    L5:
        if (r0 >= DURATION_TO_START_DELAYING) goto L7;
        return true;
    }

    private void onStartSample() {
        if (isSamplePlaying() == true) goto L19;
        Callback r1 = this.mCallback;
        if (r1 == null) goto L7;
        r1.onSampleStarting(this);
    L7:
        monitor-enter(this);
        Ringtone r2 = this.mRingtone;     // Catch: Throwable -> L16
        if (r2 != null) goto L20;
    L14:
        monitor-exit(this);     // Catch: Throwable -> L16
        return;
    L20:
        r2.setAudioAttributes(new AudioAttributes.Builder(this.mRingtone.getAudioAttributes()).setFlags(128).addTag("VX_AOSP_SAMPLESOUND").build());     // Catch: Throwable -> L12
        this.mRingtone.play();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        OLog.w(TAG, "Error playing ringtone, stream " + this.mStreamType, th);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        throw th;
    }

    private void postStopSample() {
        if (this.mHandler != null) goto L5;
        return;
    L5:
        setStopVolumeTime();
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(2);
        Handler r2 = this.mHandler;
        r2.sendMessage(r2.obtainMessage(2));
    }

    private void onStopSample() {
        monitor-enter(this);
        Ringtone r0 = this.mRingtone;     // Catch: Throwable -> L8
        if (r0 == null) goto L6;
        r0.stop();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void stop() {
        if (this.mHandler != null) goto L5;
        return;
    L5:
        postStopSample();
        this.mContext.getContentResolver().unregisterContentObserver(this.mVolumeObserver);
        this.mReceiver.setListening(false);
        if (this.mDeviceHasProductStrategies == false) goto L8;
        unregisterVolumeGroupCb();
    L8:
        this.mSeekBar.setOnSeekBarChangeListener(null);
        this.mHandler.getLooper().quitSafely();
        this.mHandler = null;
        this.mVolumeObserver = null;
    }

    public void start() {
        if (this.mHandler == null) goto L5;
        return;
    L5:
        HandlerThread r0 = new HandlerThread("SeekBarVolumizer.CallbackHandler");
        r0.start();
        Handler r1 = new Handler(r0.getLooper(), this);
        this.mHandler = r1;
        r1.sendEmptyMessage(3);
        this.mVolumeObserver = new Observer(this, this.mHandler);
        this.mContext.getContentResolver().registerContentObserver(Settings.System.getUriFor(Settings.System.VOLUME_SETTINGS_INT[this.mStreamType]), false, this.mVolumeObserver);
        this.mReceiver.setListening(true);
        if (this.mDeviceHasProductStrategies == false) goto L9;
        registerVolumeGroupCb();
        return;
    }

    public void revertVolume() {
        this.mAudioManager.setStreamVolume(this.mStreamType, this.mOriginalStreamVolume, 0);
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar r3, int r4, boolean r5) {
        if (r5 == false) goto L4;
        this.mUserChangingProgress.set(true);
        this.mUiHandler.delayResetUserTouchingKey();
        postSetVolume(r4);
    L4:
        Callback r2 = this.mCallback;
        if (r2 == null) goto L8;
        r2.onProgressChanged(r3, r4, r5);
        return;
    }

    private void postSetVolume(int r4) {
        Handler r0 = this.mHandler;
        if (r0 != null) goto L5;
        return;
    L5:
        this.mLastProgress = r4;
        r0.removeMessages(0);
        this.mHandler.removeMessages(1);
        this.mHandler.removeMessages(4);
        Handler r1 = this.mHandler;
        Message r5 = r1.obtainMessage(0);
        if (isDelay() == false) goto L8;
        long r2 = SET_STREAM_VOLUME_DELAY_MS;
    L9:
        r1.sendMessageDelayed(r5, r2);
        return;
    L8:
        r2 = 0;
        goto L9
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar r1) {
        Callback r2 = this.mCallback;
        if (r2 == null) goto L6;
        r2.onStartTrackingTouch(this);
        return;
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar r1) {
        postStartSample();
        Callback r2 = this.mCallback;
        if (r2 == null) goto L6;
        r2.onStopTrackingTouch(this);
        return;
    }

    public boolean isSamplePlaying() {
        monitor-enter(this);
        Ringtone r0 = this.mRingtone;     // Catch: Throwable -> L11
        if (r0 != null) goto L6;
    L8:
        boolean r1 = false;
    L9:
        monitor-exit(this);     // Catch: Throwable -> L11
        return r1;
    L6:
        if (r0.isPlaying() == false) goto L8;
        r1 = true;
    L11:
        th = move-exception;
        throw th;
    }

    public void startSample() {
        postStartSample();
    }

    public void stopSample() {
        postStopSample();
    }

    public SeekBar getSeekBar() {
        return this.mSeekBar;
    }

    public void changeVolumeBy(int r2) {
        this.mSeekBar.incrementProgressBy(r2);
        postSetVolume(this.mSeekBar.getProgress());
        postStartSample();
        this.mVolumeBeforeMute = -1;
    }

    public void muteVolume() {
        int r0 = this.mVolumeBeforeMute;
        if (r0 == (-1)) goto L5;
        this.mSeekBar.setProgress(r0, true);
        postSetVolume(this.mVolumeBeforeMute);
        postStartSample();
        this.mVolumeBeforeMute = -1;
        return;
    L5:
        this.mVolumeBeforeMute = this.mSeekBar.getProgress();
        this.mSeekBar.setProgress(0, true);
        postStopSample();
        postSetVolume(0);
    }

    public void onSaveInstanceState(VolumePreference.VolumeStore r2) {
        int r0 = this.mLastProgress;
        if (r0 < 0) goto L6;
        r2.volume = r0;
        r2.originalVolume = this.mOriginalStreamVolume;
        return;
    }

    public void onRestoreInstanceState(VolumePreference.VolumeStore r3) {
        if (r3.volume == (-1)) goto L6;
        this.mOriginalStreamVolume = r3.originalVolume;
        int r4 = r3.volume;
        this.mLastProgress = r4;
        postSetVolume(r4);
        return;
    }

    private void updateSlider() {
        if (this.mSeekBar == null) goto L8;
        AudioManager r0 = this.mAudioManager;
        if (r0 == null) goto L9;
        int r1 = r0.getStreamVolume(this.mStreamType);
        int r2 = this.mAudioManager.getLastAudibleStreamVolume(this.mStreamType);
        boolean r3 = this.mAudioManager.isStreamMute(this.mStreamType);
        this.mUiHandler.postUpdateSlider(r1, r2, r3);
        return;
    L9:
        return;
    }

    private void registerVolumeGroupCb() {
        if (this.mVolumeGroupId == (-1)) goto L6;
        this.mAudioManager.registerVolumeGroupCallback(new ProfileInstallReceiver$$ExternalSyntheticLambda0(), this.mVolumeGroupCallback);
        updateSlider();
        return;
    }

    private void unregisterVolumeGroupCb() {
        if (this.mVolumeGroupId == (-1)) goto L6;
        this.mAudioManager.unregisterVolumeGroupCallback(this.mVolumeGroupCallback);
        return;
    }

    public void setAnimateProgressEnabled(boolean r1) {
        this.mAnimateProgress = r1;
    }
}
