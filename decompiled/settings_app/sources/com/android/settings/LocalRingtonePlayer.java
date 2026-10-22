package com.android.settings;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.AudioRouting;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.obric.olog.OLog;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public class LocalRingtonePlayer {
    private AudioManager mAudioManager;
    private MediaPlayer.OnCompletionListener mCompletionListener;
    private Context mContext;
    private Handler mHandler;
    private MediaPlayer mPlayer;
    private String mSoundType;
    private int mStreamType;
    private Uri mUri;
    private Vibrator mVibratorManager;

    public LocalRingtonePlayer(Context r3, Uri r4) {
        this.mSoundType = SoundSettingsFragment.TYPE_RINGTONE;
        this.mStreamType = 2;
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mContext = r3;
        this.mAudioManager = (AudioManager) r3.getSystemService("audio");
        this.mVibratorManager = (Vibrator) this.mContext.getSystemService("vibrator");
        this.mUri = r4;
    }

    public void setCompletionListener(MediaPlayer.OnCompletionListener r1) {
        this.mCompletionListener = r1;
    }

    public void setStreamType(int r1) {
        this.mStreamType = r1;
        setUri(this.mUri);
    }

    public void setUri(Uri r1) {
        destroyPlayer();
        prepareMediaPlayer(r1);
    }

    public void setSoundType(String r1) {
        this.mSoundType = r1;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public boolean isRingtoneNone() {
        if (this.mUri != null) goto L5;
    L8:
        return true;
    L5:
        if (Uri.EMPTY.equals(this.mUri) == true) goto L8;
        return false;
    }

    private void prepareMediaPlayer(Uri r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (this.mPlayer != null) goto L7;
        this.mPlayer = new MediaPlayer();
    L7:
        this.mUri = r3;
        this.mPlayer.setDataSource(this.mContext, r3);     // Catch: Exception -> L10 IOException -> L12 SecurityException -> L14
        this.mPlayer.setLooping(false);     // Catch: Exception -> L10 IOException -> L12 SecurityException -> L14
        this.mPlayer.setAudioStreamType(this.mStreamType);     // Catch: Exception -> L10 IOException -> L12 SecurityException -> L14
        this.mPlayer.prepareAsync();     // Catch: Exception -> L10 IOException -> L12 SecurityException -> L14
    L21:
        return;
    L12:
        e = move-exception;
        destroyPlayer();
        e.printStackTrace();
        return;
    L14:
        e = move-exception;
        destroyPlayer();
        e.printStackTrace();
        return;
    L10:
        e = move-exception;
        destroyPlayer();
        e.printStackTrace();
    }

    public void play() {
        final long r2 = System.currentTimeMillis();
        final long r4 = getSystemVibrateDelayMs();
        if (this.mPlayer != null) goto L5;
        prepareMediaPlayer(this.mUri);
    L5:
        MediaPlayer r0 = this.mPlayer;
        if (r0 == null) goto L12;
        MediaPlayer.OnCompletionListener r1 = this.mCompletionListener;
        if (r1 == null) goto L10;
        r0.setOnCompletionListener(r1);
    L10:
        this.mPlayer.setOnPreparedListener(new LocalRingtonePlayer$$ExternalSyntheticLambda0(this, r2, r4));
        return;
    }

    /* JADX INFO: renamed from: lambda$play$1$com-android-settings-LocalRingtonePlayer, reason: not valid java name */
    /* synthetic */ void m147lambda$play$1$comandroidsettingsLocalRingtonePlayer(final long r5, long r7, MediaPlayer r9) {
        OLog.d("LocalRingtonePlayer", "onPrepared:" + r9.getDuration());
        OLog.d("LocalRingtonePlayer", "onPrepared cost time " + (System.currentTimeMillis() - r5));
        this.mPlayer.start();
        OLog.d("LocalRingtonePlayer", "onPrepared(start) cost time " + (System.currentTimeMillis() - r5) + "  :" + r9.getCurrentPosition());
        this.mHandler.postDelayed(new LocalRingtonePlayer$$ExternalSyntheticLambda1(this, r5), r7);
    }

    /* JADX INFO: renamed from: lambda$play$0$com-android-settings-LocalRingtonePlayer, reason: not valid java name */
    /* synthetic */ void m146lambda$play$0$comandroidsettingsLocalRingtonePlayer(long r4) {
        OLog.d("LocalRingtonePlayer", "onPrepared(vibrate) cost time " + (System.currentTimeMillis() - r4));
        startVibrate();
    }

    private int getSystemVibrateDelayMs() {
        return android.provider.Settings.System.getInt(this.mContext.getContentResolver(), "use_system_ringtone_vibrate_delay_ms");
    L4:
        return 150;
    }

    public void stop() {
        OLog.d("LocalRingtonePlayer", "stop");
        destroyPlayer();
        stopVibrate();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    private void destroyPlayer() {
        this.mHandler.removeCallbacksAndMessages(null);
        MediaPlayer r0 = this.mPlayer;
        if (r0 == null) goto L6;
        r0.reset();
        this.mPlayer.release();
        this.mPlayer = null;
        return;
    }

    public boolean isPlaying() {
        MediaPlayer r0 = this.mPlayer;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isPlaying() == false) goto L7;
        return true;
    }

    public void addOnRoutingChangedListener(AudioRouting.OnRoutingChangedListener r1, Handler r2) {
        MediaPlayer r0 = this.mPlayer;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.addOnRoutingChangedListener(r1, r2);
    }

    public void removeOnRoutingChangedListener(AudioRouting.OnRoutingChangedListener r1) {
        MediaPlayer r0 = this.mPlayer;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.removeOnRoutingChangedListener(r1);
    }

    public AudioDeviceInfo getRoutedDevice() {
        MediaPlayer r0 = this.mPlayer;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getRoutedDevice();
    }

    public void startVibrate() {
        Vibrator r0 = this.mVibratorManager;
        if (r0 != null) goto L5;
    L59:
        OLog.d("LocalRingtonePlayer", "startVibrate vibratorManager is null");
        return;
    L5:
        if (r0.hasVibrator() == false) goto L59;
        byte r3 = 1;
        int r1 = android.provider.Settings.Global.getInt(this.mContext.getContentResolver(), SoundSettingsFragment.GLOBAL_VIBRATION_ENABLED, 1);
        if (r1 != 0) goto L12;
        OLog.d("LocalRingtonePlayer", "startVibrate isVibrationEnable is " + r1);
        return;
    L12:
        if (this.mSoundType.equals(SoundSettingsFragment.TYPE_RINGTONE) == false) goto L14;
    L22:
        String r2 = this.mSoundType;
        r2.hashCode();
        switch(r2.hashCode()) {
            case -883389629: goto L45;
            case -675989426: goto L42;
            case -150053113: goto L38;
            case 610021948: goto L34;
            case 908205731: goto L30;
            case 1870114858: goto L26;
            default: goto L24;
        };
    L24:
        r3 = -1;
    L49:
        switch(r3) {
            case 0: goto L53;
            case 1: goto L53;
            case 2: goto L51;
            case 3: goto L53;
            case 4: goto L53;
            case 5: goto L51;
            default: goto L50;
        };
    L50:
        String r4 = "";
    L54:
        if (r4 == null) goto L67;
        VibrationEffect r5 = VibrationEffectSettingsFragment.vibrationEffectGetEffectByUri(this.mContext, Uri.parse(r4));
        if (r5 == null) goto L68;
        this.mVibratorManager.vibrate(r5);
        return;
    L68:
        return;
    L67:
        return;
    L51:
        String r6 = android.provider.Settings.System.getString(this.mContext.getContentResolver(), VibrationEffectSettingsFragment.getStorageKey(this.mSoundType, false));
        OLog.d("LocalRingtonePlayer", "startVibrate uriStr:" + r6);
    L52:
        r4 = r6;
        goto L54
    L53:
        r6 = android.provider.Settings.Global.getString(this.mContext.getContentResolver(), VibrationEffectSettingsFragment.getStorageKey(this.mSoundType, false));
        OLog.d("LocalRingtonePlayer", "startVibrate uriStr:" + r6);
        goto L52
    L26:
        if (r2.equals(SoundSettingsFragment.TYPE_RINGTONE_SUB2) == false) goto L61;
        r3 = 5;
        goto L49
    L61:
        r3 = -1;
        goto L49
    L30:
        if (r2.equals(SoundSettingsFragment.TYPE_CALENDAR) == false) goto L62;
        r3 = 4;
        goto L49
    L62:
        r3 = -1;
        goto L49
    L34:
        if (r2.equals(SoundSettingsFragment.TYPE_DEFAULT) == false) goto L63;
        r3 = 3;
        goto L49
    L63:
        r3 = -1;
        goto L49
    L38:
        if (r2.equals(SoundSettingsFragment.TYPE_RINGTONE) == false) goto L64;
        r3 = 2;
        goto L49
    L64:
        r3 = -1;
        goto L49
    L42:
        if (r2.equals(SoundSettingsFragment.TYPE_MMS) == true) goto L49;
        r3 = -1;
        goto L49
    L45:
        if (r2.equals(SoundSettingsFragment.TYPE_MMS_SUB2) == false) goto L66;
        r3 = 0;
        goto L49
    L66:
        r3 = -1;
        goto L49
    L14:
        if (this.mSoundType.equals(SoundSettingsFragment.TYPE_RINGTONE_SUB2) == true) goto L22;
        if (android.provider.Settings.Global.getInt(this.mContext.getContentResolver(), VibrationEffectSettingsFragment.getStorageKey(this.mSoundType, true), 1) != 1) goto L18;
        boolean r7 = true;
    L19:
        if (r7 == true) goto L22;
        OLog.d("LocalRingtonePlayer", "startVibrate isEnabled is " + r7);
        return;
    L18:
        r7 = false;
        goto L19
    }

    public void stopVibrate() {
        Vibrator r0 = this.mVibratorManager;
        if (r0 != null) goto L5;
    L24:
        OLog.d("LocalRingtonePlayer", "stopVibrate vibratorManager is null");
        return;
    L5:
        if (r0.hasVibrator() == false) goto L24;
        boolean r3 = true;
        int r1 = android.provider.Settings.Global.getInt(this.mContext.getContentResolver(), SoundSettingsFragment.GLOBAL_VIBRATION_ENABLED, 1);
        if (r1 != 0) goto L12;
        OLog.d("LocalRingtonePlayer", "stopVibrate isVibrationEnable is " + r1);
        return;
    L12:
        if (this.mSoundType.equals(SoundSettingsFragment.TYPE_RINGTONE) == false) goto L14;
    L22:
        OLog.d("LocalRingtonePlayer", "stopVibrate");
        this.mVibratorManager.cancel();
        return;
    L14:
        if (this.mSoundType.equals(SoundSettingsFragment.TYPE_RINGTONE_SUB2) == true) goto L22;
        if (android.provider.Settings.Global.getInt(this.mContext.getContentResolver(), VibrationEffectSettingsFragment.getStorageKey(this.mSoundType, true), 1) == 1) goto L19;
        r3 = false;
    L19:
        if (r3 == true) goto L22;
        OLog.d("LocalRingtonePlayer", "stopVibrate isEnabled is " + r3);
    }
}
