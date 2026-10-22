package com.android.settings.widget;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetFileDescriptor;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.AudioPlaybackConfiguration;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.GlobalProxyLancet;
import com.android.settings.R;
import com.android.settings.SettingsApplication;
import com.android.settings.SettingsInitialize;
import com.android.settings.utils.ResourceUtils;
import com.android.settings.utils.VoiceUtils;
import com.android.settings.widget.opt.SeekBarVolumizer;
import com.obric.olog.OLog;
import com.obric.oui.slider.OSlider;
import com.obric.privacy.GrantUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Insert;

/* JADX INFO: loaded from: classes.dex */
public class VolumeSeekBar extends OSlider {
    private static final int ORIGIN_VOLUME_LEVEL = 15;
    private static final int SCALE_VALUE = 100;
    private static final String TAG = "VolumeSeekBar";
    AudioManager audioManager;
    private boolean calling;
    private AudioManager.OnAudioFocusChangeListener mAudioFocusListener;
    private Callback mCallback;
    private Handler mHandler;
    private boolean mIsChanging;
    private volatile boolean mIsPlaying;
    private int mLastProgress;
    private long mLastStreamDeviceChangeOrRingIdleTime;
    private MediaPlayer mMediaPlayer;
    private MediaPlayerPlayCallback mMediaPlayerPlayCallback;
    private RingerModeSwitchClickStatusProvider mRingerModeSwitchClickStatusProvider;
    private SeekBar mSeekBar;
    private Runnable mStopPreviewRunnable;
    private int mStream;
    private SeekBarVolumizer mVolumizer;
    private SeekBar mWrapSeekBar;
    private Receiver receiver;
    private boolean visible;

    public interface Callback {
        void showToast(boolean r1);
    }

    private static class MediaPlayerManager {
        private static AudioManager.OnAudioFocusChangeListener sAudioFocusListener = null;
        private static AudioFocusRequest sAudioFocusRequest = null;
        private static AudioManager sAudioManager = null;
        private static int sCurrentStream = -1;
        private static MediaPlayer sMediaPlayer;
        private static MediaPlayerPlayCallback sMediaPlayerPlayCallback;

        static {
        }

        private MediaPlayerManager() {
        }

        public static void init(AudioManager r0, AudioManager.OnAudioFocusChangeListener r1, MediaPlayerPlayCallback r2) {
            sAudioManager = r0;
            sAudioFocusListener = r1;
            sMediaPlayerPlayCallback = r2;
        }

        public static boolean isPlaying() {
            MediaPlayer r0 = sMediaPlayer;
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.isPlaying() == false) goto L7;
            return true;
        }

        public static boolean isStreamType(int r1) {
            if (sCurrentStream != r1) goto L5;
            return true;
        L5:
            return false;
        }

        public static boolean isPlayingForStream(int r1) {
            if (sCurrentStream == r1) goto L5;
        L7:
            return false;
        L5:
            if (isPlaying() == false) goto L7;
            return true;
        }

        public static void stopPlaying() {
            MediaPlayer r0 = sMediaPlayer;
            if (r0 != null) goto L50;
            return;
        L50:
        L20:
            th = move-exception;
            MediaPlayer r3 = sMediaPlayer;
            if (r3 == null) goto L39;
            r3.release();
            sMediaPlayer = null;
        L39:
            sCurrentStream = -1;
            AudioManager r1 = sAudioManager;
            if (r1 != null) goto L42;
        L48:
            throw th;
        L42:
            if (sAudioFocusListener == null) goto L48;
            AudioFocusRequest r2 = sAudioFocusRequest;
            if (r2 == null) goto L48;
            r1.abandonAudioFocusRequest(r2);
            MediaPlayerPlayCallback r4 = sMediaPlayerPlayCallback;
            if (r4 == null) goto L48;
            r4.stopPlaying();
        L22:
            e = move-exception;
            OLog.e(VolumeSeekBar.access$200(), "stopPlaying", e);     // Catch: Throwable -> L20
            MediaPlayer r5 = sMediaPlayer;
            if (r5 == null) goto L27;
            r5.release();
            sMediaPlayer = null;
        L27:
            sCurrentStream = -1;
            AudioManager r6 = sAudioManager;
            if (r6 != null) goto L30;
            return;
        L30:
            if (sAudioFocusListener == null) goto L58;
            AudioFocusRequest r7 = sAudioFocusRequest;
            if (r7 == null) goto L59;
            r6.abandonAudioFocusRequest(r7);
            MediaPlayerPlayCallback r8 = sMediaPlayerPlayCallback;
            if (r8 == null) goto L60;
        L19:
            r8.stopPlaying();
            return;
        L60:
            return;
        L59:
            return;
        L58:
            return;
        L6:
            if (r0.isPlaying() == false) goto L8;
            sMediaPlayer.stop();     // Catch: Throwable -> L20 Exception -> L22
        L8:
            MediaPlayer r9 = sMediaPlayer;
            if (r9 == null) goto L11;
            r9.release();
            sMediaPlayer = null;
        L11:
            sCurrentStream = -1;
            AudioManager r10 = sAudioManager;
            if (r10 != null) goto L14;
            return;
        L14:
            if (sAudioFocusListener == null) goto L53;
            AudioFocusRequest r11 = sAudioFocusRequest;
            if (r11 == null) goto L54;
            r10.abandonAudioFocusRequest(r11);
            r8 = sMediaPlayerPlayCallback;
            if (r8 != null) goto L19;
            return;
        L54:
            return;
        }

        public static void setMediaPlayer(MediaPlayer r0, int r1, MediaPlayerPlayCallback r2) {
            sMediaPlayer = r0;
            sCurrentStream = r1;
            sMediaPlayerPlayCallback = r2;
        }

        public static MediaPlayer getMediaPlayer() {
            return sMediaPlayer;
        }

        public static void setAudioFocusRequest(AudioFocusRequest r0) {
            sAudioFocusRequest = r0;
        }
    }

    public interface MediaPlayerPlayCallback {
        void startPlaying();

        void stopPlaying();
    }

    private class Receiver extends BroadcastReceiver {
        final /* synthetic */ VolumeSeekBar this$0;

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r1, Intent r2) {
            com_android_settings_widget_VolumeSeekBar$Receiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(this, r1, r2);
        }

        private Receiver(VolumeSeekBar r1) {
            this.this$0 = r1;
        }

        /* synthetic */ Receiver(VolumeSeekBar r1, AnonymousClass1 r2) {
            this(r1);
        }

        public void com_android_settings_widget_VolumeSeekBar$Receiver__onReceive$___twin___(Context r3, Intent r4) {
            if (r4 != null) goto L5;
            return;
        L5:
            if ("android.intent.action.PHONE_STATE".equals(r4.getAction()) == false) goto L13;
            if (Objects.equals(r4.getStringExtra("state"), TelephonyManager.EXTRA_STATE_RINGING) == false) goto L10;
            VolumeSeekBar.access$100(this.this$0);
            VolumeSeekBar.access$1602(this.this$0, true);
        L10:
            if (Objects.equals(r4.getStringExtra("state"), TelephonyManager.EXTRA_STATE_IDLE) == false) goto L13;
            VolumeSeekBar.access$1602(this.this$0, false);
            VolumeSeekBar.access$802(this.this$0, System.currentTimeMillis());
        L13:
            if ("android.media.STREAM_DEVICES_CHANGED_ACTION".equals(r4.getAction()) == false) goto L16;
            VolumeSeekBar.access$802(this.this$0, System.currentTimeMillis());
            OLog.d(VolumeSeekBar.access$200(), "onReceive stream device changed time:" + VolumeSeekBar.access$800(this.this$0));
            return;
        }

        @Insert("onReceive")
        public static void com_android_settings_widget_VolumeSeekBar$Receiver_com_obric_hook_lancet_PrivacyHookForReceiver_onReceive(Receiver r7, Context r8, Intent r9) {
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
            r7.com_android_settings_widget_VolumeSeekBar$Receiver__onReceive$___twin___(r8, r9);
            return;
        L13:
            GrantUtil r11 = GrantUtil.INSTANCE;
            Application r12 = SettingsApplication.getApplication();
            Intrinsics.checkNotNullExpressionValue(r12, "getApplication(...)");
            if (r11.isSetupCompelete(r12) == true) goto L16;
            OLog.i("PrivacyHookForReceiver", "onReceive !isSetupCompeleted hooked for " + r3 + ", " + r2);
            r7.com_android_settings_widget_VolumeSeekBar$Receiver__onReceive$___twin___(r8, r9);
            return;
        L16:
            String r13 = r3;
            if (r13 != null) goto L19;
        L22:
            boolean r14 = true;
        L23:
            if (r14 == false) goto L26;
            OLog.i("PrivacyHookForReceiver", "onReceive !simpleName hooked for " + r3 + ", " + r2);
            r7.com_android_settings_widget_VolumeSeekBar$Receiver__onReceive$___twin___(r8, r9);
            return;
        L26:
            if (GrantUtil.INSTANCE.isPrivacyAllowed() == true) goto L30;
            if (r4 == true) goto L30;
            OLog.i("PrivacyHookForReceiver", "onReceive !isPrivacyAllowed hooked for " + r3 + ", " + r2);
            return;
        L30:
            GrantUtil.INSTANCE.applicationInit();
            r7.com_android_settings_widget_VolumeSeekBar$Receiver__onReceive$___twin___(r8, r9);
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

    public interface RingerModeSwitchClickStatusProvider {
        boolean isRingerModeSwitchClicked();

        void onUpdateSlideCompleted();
    }

    static {
    }

    static /* synthetic */ int access$000(VolumeSeekBar r0) {
        return r0.mStream;
    }

    static /* synthetic */ void access$100(VolumeSeekBar r0) {
        r0.stopPreview();
    }

    static /* synthetic */ RingerModeSwitchClickStatusProvider access$1000(VolumeSeekBar r0) {
        return r0.mRingerModeSwitchClickStatusProvider;
    }

    static /* synthetic */ int access$1100(VolumeSeekBar r0, float r1) {
        return r0.getImpliedLevel(r1);
    }

    static /* synthetic */ boolean access$1200(VolumeSeekBar r0, float r1) {
        return r0.isLessThanMinProgress(r1);
    }

    static /* synthetic */ SeekBarVolumizer access$1300(VolumeSeekBar r0) {
        return r0.mVolumizer;
    }

    static /* synthetic */ void access$1400(VolumeSeekBar r0, boolean r1) {
        r0.updateSeekBar(r1);
    }

    static /* synthetic */ void access$1500(VolumeSeekBar r0) {
        r0.delayedStopPreview();
    }

    static /* synthetic */ boolean access$1602(VolumeSeekBar r0, boolean r1) {
        r0.calling = r1;
        return r1;
    }

    static /* synthetic */ String access$200() {
        return TAG;
    }

    static /* synthetic */ SeekBar access$400(VolumeSeekBar r0) {
        return r0.mWrapSeekBar;
    }

    static /* synthetic */ boolean access$502(VolumeSeekBar r0, boolean r1) {
        r0.mIsPlaying = r1;
        return r1;
    }

    static /* synthetic */ MediaPlayerPlayCallback access$600(VolumeSeekBar r0) {
        return r0.mMediaPlayerPlayCallback;
    }

    static /* synthetic */ boolean access$700(VolumeSeekBar r0) {
        return r0.mIsChanging;
    }

    static /* synthetic */ boolean access$702(VolumeSeekBar r0, boolean r1) {
        r0.mIsChanging = r1;
        return r1;
    }

    static /* synthetic */ long access$800(VolumeSeekBar r2) {
        return r2.mLastStreamDeviceChangeOrRingIdleTime;
    }

    static /* synthetic */ long access$802(VolumeSeekBar r0, long r1) {
        r0.mLastStreamDeviceChangeOrRingIdleTime = r1;
        return r1;
    }

    static /* synthetic */ void access$900(VolumeSeekBar r0, boolean r1) {
        r0.startPreview(r1);
    }

    public VolumeSeekBar(Context r2) {
        this(r2, null);
    }

    public VolumeSeekBar(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public VolumeSeekBar(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.mIsChanging = false;
        this.mHandler = new Handler();
        this.mLastProgress = -1;
        this.mStopPreviewRunnable = new AnonymousClass1(this);
        this.visible = true;
        this.mIsPlaying = false;
        this.calling = false;
        this.mLastStreamDeviceChangeOrRingIdleTime = 0;
        this.receiver = new Receiver(this, null);
        this.mSeekBar = getSeekBar();
        this.mWrapSeekBar = new SeekBar(r1);
        this.audioManager = (AudioManager) r1.getSystemService("audio");
        initMediaPlayerManager();
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r1, this.receiver, new IntentFilter("android.intent.action.PHONE_STATE"), 2);
    }

    private void initMediaPlayerManager() {
        this.mMediaPlayerPlayCallback = new AnonymousClass2(this);
        AudioManager.OnAudioFocusChangeListener r0 = new AnonymousClass3(this);
        this.mAudioFocusListener = r0;
        MediaPlayerManager.init(this.audioManager, r0, this.mMediaPlayerPlayCallback);
    }

    public void setStream(int r1) {
        this.mStream = r1;
    }

    public void setCallback(Callback r1) {
        this.mCallback = r1;
    }

    public void setRingerModeSwitchClickStatusProvider(RingerModeSwitchClickStatusProvider r1) {
        this.mRingerModeSwitchClickStatusProvider = r1;
    }

    public void initVolumizer() {
        enableEdgeTouchOptimize(true);
        final SeekBarVolumizer.Callback r6 = new AnonymousClass4(this);
        if (this.mStream != 3) goto L5;
        Uri r0 = getMediaVolumeUri();
    L6:
        final Uri r5 = r0;
        final Context r3 = getContext();
        final int r4 = this.mStream;
        SeekBarVolumizer r1 = new AnonymousClass5(this, r3, r4, r5, r6);
        this.mVolumizer = r1;
        r1.start();
        AudioManager r2 = (AudioManager) getContext().getSystemService("audio");
        SeekBar r7 = this.mWrapSeekBar;
        int r8 = this.mStream;
        if (r8 != 0) goto L9;
    L16:
        int r9 = 0;
    L17:
        r7.setMin(r9);
        this.mVolumizer.setSeekBar(this.mWrapSeekBar);
        OLog.d(TAG, "mStream:" + this.mStream + "  max:" + this.mWrapSeekBar.getMax() + " v:" + this.mWrapSeekBar.getProgress() + " min:" + this.mWrapSeekBar.getMin());
        post(new VolumeSeekBar$$ExternalSyntheticLambda0(this));
        IntentFilter r10 = new IntentFilter("android.intent.action.PHONE_STATE");
        r10.addAction("android.media.STREAM_DEVICES_CHANGED_ACTION");
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(getContext(), this.receiver, r10);
        return;
    L9:
        if (r8 == 6) goto L16;
        if (r8 == 4) goto L16;
        if (r8 == 11) goto L16;
        r9 = r2.getStreamMinVolumeInt(r8);
        goto L17
    L5:
        r0 = null;
        goto L6
    }

    /* JADX INFO: renamed from: lambda$initVolumizer$0$com-android-settings-widget-VolumeSeekBar, reason: not valid java name */
    /* synthetic */ void m657lambda$initVolumizer$0$comandroidsettingswidgetVolumeSeekBar() {
        initSeekBar();
        updateSeekBar(false);
    }

    private void initSeekBar() {
        setMinValue(this.mWrapSeekBar.getMin() * 100);
        setMaxValue(this.mWrapSeekBar.getMax() * 100);
        setProgress(this.mWrapSeekBar.getProgress() * 100);
        setOnSeekBarChangeListenerExt(new AnonymousClass6(this));
    }

    private void updateSeekBar(boolean r8) {
        if (this.mWrapSeekBar.getProgress() != 0) goto L21;
        if (this.mStream != 3) goto L8;
        setLeftIcon(getContext().getDrawable(R.drawable.vol_setting_media_mute));
    L8:
        if (this.mStream != 2) goto L14;
        setLeftIcon(getContext().getDrawable(R.drawable.vol_setting_call_mute));
        Callback r0 = this.mCallback;
        if (r0 == null) goto L14;
        if (r8 == false) goto L14;
        r0.showToast(true);
    L14:
        if (this.mStream != 5) goto L17;
        setLeftIcon(getContext().getDrawable(R.drawable.vol_setting_notification_min));
    L17:
        if (this.mStream != 11) goto L19;
        setLeftIcon(getContext().getDrawable(R.drawable.vol_setting_assistant_mute));
    L19:
        this.mLastProgress = 0;
        return;
    L21:
        if (this.mStream != 3) goto L24;
        setLeftIcon(getContext().getDrawable(R.drawable.vol_setting_media_min));
    L24:
        if (this.mStream != 2) goto L32;
        setLeftIcon(getContext().getDrawable(R.drawable.vol_setting_call_min));
        if (this.mLastProgress != 0) goto L32;
        Callback r1 = this.mCallback;
        if (r1 == null) goto L32;
        if (r8 == false) goto L32;
        r1.showToast(false);
    L32:
        if (this.mStream != 5) goto L35;
        setLeftIcon(getContext().getDrawable(R.drawable.vol_setting_notification_min));
    L35:
        if (this.mStream != 11) goto L37;
        setLeftIcon(getContext().getDrawable(R.drawable.vol_setting_assistant_min));
    L37:
        this.mLastProgress = -1;
    }

    private int getImpliedLevel(float r4) {
        int r3 = (int) getMaxValue();
        int r0 = r3 / 100;
        int r1 = r0 - 1;
        if (r4 != 0.0f) goto L5;
        return 0;
    L5:
        float r5 = r3;
        if (r4 != r5) goto L9;
        return r0;
    L9:
        return ((int) ((r4 / r5) * r1)) + 1;
    }

    private boolean isLessThanMinProgress(float r2) {
        if (r2 >= (getMaxValue() / 15.0f)) goto L5;
        return true;
    L5:
        return false;
    }

    public void stopVolumizer() {
        SeekBarVolumizer r0 = this.mVolumizer;
        if (r0 == null) goto L6;
        r0.stop();
        return;
    }

    public void startSample() {
        SeekBarVolumizer r0 = this.mVolumizer;
        if (r0 == null) goto L6;
        r0.startSample();
        return;
    }

    public void stopSample() {
        SeekBarVolumizer r0 = this.mVolumizer;
        if (r0 == null) goto L6;
        r0.stopSample();
        return;
    }

    public void onHardwareVolumeKeyPressed() {
        SeekBar r0 = this.mWrapSeekBar;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getProgress() <= 0) goto L9;
        startPreview(false);
        return;
    }

    private Uri getMediaVolumeUri() {
        return Uri.parse("android.resource://" + getContext().getPackageName() + "/2131886129");
    }

    private void startPreview(boolean r12) {
        if (this.visible == true) goto L6;
        return;
    L6:
        if (this.calling == false) goto L10;
        OLog.d(TAG, "calling");
        return;
    L10:
        if (r12 == true) goto L16;
        if (Settings.Global.getInt(getContext().getContentResolver(), "volume_key_function", 3) == this.mStream) goto L16;
        OLog.d(TAG, "volKeyFunction != mStream");
        return;
    L16:
        if (isStreamActive(this.mStream, this.audioManager) == false) goto L24;
        String r13 = TAG;
        OLog.d(r13, "Audio playback:  type:" + this.mStream + " is playing");
        if (MediaPlayerManager.isPlaying() == true) goto L20;
        return;
    L20:
        if (MediaPlayerManager.isStreamType(this.mStream) == true) goto L84;
        OLog.d(r13, "Audio playback: The types are different");
        MediaPlayerManager.stopPlaying();
        return;
    L84:
        return;
    L24:
        if (this.mIsPlaying == false) goto L28;
        OLog.d(TAG, "startPreview, mIsPlaying, return");
        return;
    L28:
        if (MediaPlayerManager.isPlaying() == false) goto L32;
        MediaPlayerManager.stopPlaying();
        return;
    L32:
        if (this.mStream == 3) goto L34;
    L36:
        this.mHandler.removeCallbacks(this.mStopPreviewRunnable);
        if (r12 == true) goto L43;
        RingerModeSwitchClickStatusProvider r1 = this.mRingerModeSwitchClickStatusProvider;
        if (r1 == null) goto L43;
        if (r1.isRingerModeSwitchClicked() == false) goto L43;
        return;
    L43:
        if (r12 == true) goto L46;
        delayedStopPreview();
    L46:
        if (this.mAudioFocusListener != null) goto L49;
        initMediaPlayerManager();
    L49:
        if (this.audioManager == null) goto L51;
        AudioFocusRequest r14 = new AudioFocusRequest.Builder(2).setAudioAttributes(new AudioAttributes.Builder().setUsage(1).setContentType(2).build()).setAcceptsDelayedFocusGain(true).setOnAudioFocusChangeListener(this.mAudioFocusListener).build();
        this.audioManager.requestAudioFocus(r14);
        MediaPlayerManager.setAudioFocusRequest(r14);
    L51:
        VoiceUtils r15 = new VoiceUtils();
        int r2 = this.mStream;
        if (r2 == 2) goto L65;
        if (r2 != 3) goto L55;
        Uri r0 = r15.getDefaultRingtoneUri("ringtone");
    L60:
        byte r16 = -1;
    L66:
        if (r0 != null) goto L81;
        if (r16 != (-1)) goto L81;
        return;
    L81:
        MediaPlayer r17 = new MediaPlayer();     // Catch: Exception -> L76
        if (r0 == null) goto L71;
        r17.setDataSource(getContext(), r0);     // Catch: Exception -> L76
    L72:
        r17.setAudioStreamType(this.mStream);     // Catch: Exception -> L76
        r17.prepare();     // Catch: Exception -> L76
        r17.start();     // Catch: Exception -> L76
        r17.setOnCompletionListener(new AnonymousClass7(this));     // Catch: Exception -> L76
        MediaPlayerManager.setMediaPlayer(r17, this.mStream, this.mMediaPlayerPlayCallback);     // Catch: Exception -> L76
        MediaPlayerPlayCallback r18 = this.mMediaPlayerPlayCallback;     // Catch: Exception -> L76
        if (r18 == null) goto L86;
        r18.startPlaying();     // Catch: Exception -> L76
        return;
    L86:
        return;
    L71:
        AssetFileDescriptor r3 = ResourceUtils.getResources().openRawResourceFd(R.raw.assistant_preview);     // Catch: Exception -> L76
        r17.setDataSource(r3.getFileDescriptor(), r3.getStartOffset(), r3.getLength());     // Catch: Exception -> L76
    L76:
        e = move-exception;
        OLog.e(TAG, "startPreview e:" + e);
        MediaPlayerPlayCallback r11 = this.mMediaPlayerPlayCallback;
        if (r11 == null) goto L87;
        r11.stopPlaying();
        return;
    L87:
        return;
    L55:
        if (r2 != 4) goto L57;
        r0 = r15.getAlarmRingtoneUri();
        goto L60
    L57:
        if (r2 == 5) goto L62;
        r0 = null;
        if (r2 != 11) goto L60;
        r16 = R.raw.assistant_preview;
        goto L66
    L62:
        r0 = r15.getNotificationRingtoneUri();
        goto L60
    L65:
        r0 = r15.getSim1RingtoneUri();
        goto L60
    L34:
        if (this.audioManager.isMusicActive() == false) goto L36;
    }

    private void stopPreview() {
        MediaPlayerManager.stopPlaying();
        this.mHandler.removeCallbacks(this.mStopPreviewRunnable);
    }

    private void delayedStopPreview() {
        this.mHandler.removeCallbacks(this.mStopPreviewRunnable);
        int r0 = this.mStream;
        if (r0 != 3) goto L5;
    L10:
        this.mHandler.postDelayed(this.mStopPreviewRunnable, 2000);
        return;
    L5:
        if (r0 == 2) goto L10;
        MediaPlayer r1 = MediaPlayerManager.getMediaPlayer();
        if (r1 == null) goto L12;
        r1.setOnCompletionListener(new AnonymousClass8(this));
        return;
    }

    public void onResume() {
        this.visible = true;
    }

    public void onPause() {
        this.visible = false;
        stopPreview();
    }

    public void onDestroy() {
        getContext().unregisterReceiver(this.receiver);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        OLog.e(TAG, "onDestroy e:" + e);
    }

    private boolean isStreamActive(int r4, AudioManager r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        List<AudioPlaybackConfiguration> r6 = r5.getActivePlaybackConfigurations();
        AudioAttributes r7 = new AudioAttributes.Builder().setLegacyStreamType(r4).build();
        int r0 = r7.getContentType();
        int r8 = r7.getUsage();
        if (r6 != null) goto L8;
        return false;
    L8:
        if (r6.isEmpty() == true) goto L31;
        Iterator<AudioPlaybackConfiguration> r9 = r6.iterator();
    L12:
        if (r9.hasNext() == false) goto L32;
        AudioPlaybackConfiguration r1 = r9.next();
        if (r1.isPlaying() == false) goto L12;
        AudioAttributes r2 = r1.getAudioAttributes();
        if (r0 != r2.getContentType()) goto L12;
        if (r8 != r2.getUsage()) goto L12;
        return true;
    L32:
        return false;
    L31:
        return false;
    }
}
