package com.android.server.appop;

import android.media.AudioManager;
import android.media.AudioPlaybackConfiguration;
import android.util.ArraySet;
import android.util.Pair;
import android.util.Slog;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ObricAppOpsServiceImpl implements IObricAppOpsService {
    private static final String TAG = "ObricAppOpsServiceImpl";
    private static final int UID_ANY = -2;
    private boolean mAlreadyCheckFirstApp;
    private boolean mAudioCallbackRegistered;
    private final AppOpsService mBase;
    private boolean mDelayToReset;
    private String mFirstNonmutableApp;
    private boolean mIsMute;
    private int mMuteSessionCount;
    private final Method mNotifyWatchersMethod;
    private final AudioManager.AudioPlaybackCallback mPlaybackCallback;
    private volatile Set<Integer> mPlayingUids;
    private Pair<String, Integer> mTopApp;
    private Set<String> mWhitelist;

    /* JADX INFO: renamed from: $r8$lambda$Qq4uQkHHNA0L8_-tLvU_S6GsHU4, reason: not valid java name */
    public static /* synthetic */ void m2$r8$lambda$Qq4uQkHHNA0L8_tLvU_S6GsHU4(ObricAppOpsServiceImpl r0) {
        r0.lambda$asyncNotifyWatchers$0();
    }

    public static /* synthetic */ void $r8$lambda$oM59N0g5rO4Ag37LLiv7RzQZKm8(ObricAppOpsServiceImpl r0) {
        r0.ensureAudioCallbackRegistered();
    }

    /* JADX INFO: renamed from: -$$Nest$mrebuildPlayingUids, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3$$Nest$mrebuildPlayingUids(ObricAppOpsServiceImpl r0, List r1) {
        r0.rebuildPlayingUids(r1);
    }

    public ObricAppOpsServiceImpl(AppOpsService mService) {
        this.mFirstNonmutableApp = null;
        this.mAlreadyCheckFirstApp = false;
        this.mTopApp = null;
        this.mIsMute = false;
        this.mMuteSessionCount = 0;
        this.mDelayToReset = false;
        this.mWhitelist = null;
        this.mPlayingUids = Collections.emptySet();
        this.mAudioCallbackRegistered = false;
        this.mPlaybackCallback = new AnonymousClass1(this);
        this.mBase = mService;
        Method method = null;
        Class<?> clazz = Class.forName(this.mBase.getClass().getName());     // Catch: ReflectiveOperationException -> L5
        method = clazz.getDeclaredMethod("notifyWatchersOnDefaultDevice", new Class[]{Integer.TYPE, Integer.TYPE});     // Catch: ReflectiveOperationException -> L5
        method.setAccessible(true);     // Catch: ReflectiveOperationException -> L5
    L7:
        this.mNotifyWatchersMethod = method;
        return;
    L5:
        e = move-exception;
        Slog.e(TAG, "err getMethod. e=", e);
        goto L7
    }

    private void tryRegisterAudioCallback() {
        if (this.mAudioCallbackRegistered == false) goto L6;
        return;
    L6:
        if (this.mBase.mHandler != null) goto L8;
        return;
    L8:
        this.mBase.mHandler.post(new ObricAppOpsServiceImpl$$ExternalSyntheticLambda0(this));
    }

    public void updateMutePackage(int uid, String packageName, int activityType) {
        if (this.mBase != null) goto L6;
        Slog.w(TAG, "updateMutedApp. mService is null");
        return;
    L6:
        tryRegisterAudioCallback();
        monitor-enter(this);
        Pair<String, Integer> tempPair = new Pair(packageName, Integer.valueOf(uid));     // Catch: Throwable -> L18
        if (tempPair.equals(this.mTopApp) == false) goto L13;
        monitor-exit(this);     // Catch: Throwable -> L18
        return;
    L13:
        if (this.mIsMute == false) goto L15;
        checkFirstNonmutableApp(uid, packageName, activityType);     // Catch: Throwable -> L18
    L15:
        this.mTopApp = tempPair;     // Catch: Throwable -> L18
        asyncNotifyWatchers();     // Catch: Throwable -> L18
        monitor-exit(this);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        throw th;
    }

    public void updateMuteStatus(boolean shouldMute) {
        if (this.mBase != null) goto L6;
        Slog.w(TAG, "updateMutedApp. mService is null");
        return;
    L6:
        tryRegisterAudioCallback();
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L9:
        if (this.mDelayToReset == false) goto L11;
        this.mFirstNonmutableApp = null;     // Catch: Throwable -> L17
        this.mAlreadyCheckFirstApp = false;     // Catch: Throwable -> L17
        this.mTopApp = null;     // Catch: Throwable -> L17
        this.mIsMute = false;     // Catch: Throwable -> L17
        this.mDelayToReset = false;     // Catch: Throwable -> L17
        Slog.d(TAG, "updateMuteStatus: deferred reset applied");     // Catch: Throwable -> L17
    L11:
        this.mIsMute = shouldMute;     // Catch: Throwable -> L17
        if (shouldMute == false) goto L14;
        this.mMuteSessionCount++;     // Catch: Throwable -> L17
        Slog.d(TAG, "enter mute session #" + this.mMuteSessionCount);     // Catch: Throwable -> L17
    L14:
        monitor-exit(this);     // Catch: Throwable -> L17
        asyncNotifyWatchers();
    }

    public boolean isMutedApp(int uid, String packageName) {
        monitor-enter(this);
        boolean r1 = false;
        if (this.mIsMute == true) goto L8;
        monitor-exit(this);     // Catch: Throwable -> L28
        return false;
    L8:
        if (this.mWhitelist == null) goto L15;
        if (this.mWhitelist.contains(packageName) == false) goto L15;
        Slog.d(TAG, "whitelist skip mute for " + packageName + " (session #" + this.mMuteSessionCount + ")");     // Catch: Throwable -> L28
        monitor-exit(this);     // Catch: Throwable -> L28
        return false;
    L15:
        if (this.mMuteSessionCount > 1) goto L22;
        if (isFirstNoneMutableApp(packageName) == false) goto L22;
        Slog.d(TAG, "1st mute session, skip mute for " + packageName);     // Catch: Throwable -> L28
        monitor-exit(this);     // Catch: Throwable -> L28
        return false;
    L22:
        if (this.mTopApp != null) goto L24;
    L26:
        monitor-exit(this);     // Catch: Throwable -> L28
        return r1;
    L24:
        if (Objects.equals(this.mTopApp.first, packageName) == false) goto L26;
        r1 = true;
    L28:
        th = move-exception;
        throw th;
    }

    public int checkAudioOperation(int code, int usage, int uid, String packageName) {
        if (code != 28) goto L8;
        boolean isMute = isMutedApp(uid, packageName);
        if (isMute == false) goto L10;
        Slog.i(TAG, "mute audio uid=" + uid + " pkg=" + packageName);
        return 1;
    L10:
        return 0;
    L8:
        return 0;
    }

    public void resetMuteSessionState() {
        monitor-enter(this);
        this.mMuteSessionCount = 0;     // Catch: Throwable -> L7
        this.mDelayToReset = true;     // Catch: Throwable -> L7
        Slog.d(TAG, "resetMuteSessionState: deferred reset flagged");     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setWhitelist(Set<String> whitelist) {
        monitor-enter(this);
        this.mWhitelist = whitelist;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private boolean isFirstNoneMutableApp(String packageName) {
        if (this.mFirstNonmutableApp != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mFirstNonmutableApp.equals(packageName) == false) goto L7;
        return true;
    }

    private void checkFirstNonmutableApp(int uid, String packageName, int activityType) {
        if (this.mAlreadyCheckFirstApp == false) goto L5;
        return;
    L5:
        if (this.mFirstNonmutableApp == null) goto L7;
        return;
    L7:
        if (activityType == 2) goto L14;
        this.mAlreadyCheckFirstApp = true;
        boolean isPlaying = isAppPlayingAudio(uid, packageName);
        Slog.d(TAG, "checkFirstNonmutableApp uid=" + uid + " pkg=" + packageName + " isPlaying=" + isPlaying + " playingUids=" + this.mPlayingUids);
        if (isPlaying == false) goto L15;
        this.mFirstNonmutableApp = packageName;
        asyncNotifyWatchers();
        return;
    L15:
        return;
    }

    private boolean isAppPlayingAudio(int uid, String packageName) {
        if (packageName != null) goto L4;
        return false;
    L4:
        if (packageName.isEmpty() == false) goto L7;
        return false;
    L7:
        return this.mPlayingUids.contains(Integer.valueOf(uid));
    }

    private void ensureAudioCallbackRegistered() {
        if (this.mAudioCallbackRegistered == false) goto L16;
        return;
    L16:
        AudioManager audioManager = (AudioManager) this.mBase.mContext.getSystemService(AudioManager.class);     // Catch: Exception -> L13
        if (audioManager != null) goto L11;
        Slog.w(TAG, "ensureAudioCallbackRegistered: AudioManager not ready, retry later");     // Catch: Exception -> L13
        if (this.mBase.mHandler == null) goto L17;
        this.mBase.mHandler.postDelayed(new ObricAppOpsServiceImpl$$ExternalSyntheticLambda0(this), 1000);     // Catch: Exception -> L13
        return;
    L17:
        return;
    L11:
        audioManager.registerAudioPlaybackCallback(this.mPlaybackCallback, this.mBase.mHandler);     // Catch: Exception -> L13
        rebuildPlayingUids(audioManager.getActivePlaybackConfigurations());     // Catch: Exception -> L13
        this.mAudioCallbackRegistered = true;     // Catch: Exception -> L13
        Slog.d(TAG, "AudioPlaybackCallback registered, baseline uids=" + this.mPlayingUids);     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        Slog.e(TAG, "ensureAudioCallbackRegistered failed", e);
    }

    private void rebuildPlayingUids(List<AudioPlaybackConfiguration> configs) {
        Set<Integer> prev = this.mPlayingUids;
        if (configs != null) goto L5;
    L18:
        Set<Integer> next = Collections.emptySet();
    L19:
        this.mPlayingUids = next;
        if (next.equals(prev) == true) goto L35;
        Iterator<Integer> r1 = next.iterator();
    L23:
        if (r1.hasNext() == false) goto L28;
        Integer uid = r1.next();
        if (prev.contains(uid) == true) goto L23;
        Slog.d(TAG, "audio STARTED uid=" + uid);
        goto L23
    L28:
        Iterator<Integer> r2 = prev.iterator();
    L30:
        if (r2.hasNext() == false) goto L53;
        Integer uid2 = r2.next();
        if (next.contains(uid2) == true) goto L30;
        Slog.d(TAG, "audio STOPPED uid=" + uid2);
        goto L30
    L53:
        return;
    L35:
        return;
    L5:
        if (configs.isEmpty() == true) goto L18;
        ArraySet<Integer> built = new ArraySet();
        Iterator<AudioPlaybackConfiguration> r3 = configs.iterator();
    L9:
        if (r3.hasNext() == false) goto L17;
        AudioPlaybackConfiguration config = r3.next();
        if (config == null) goto L9;
        if (config.isPlaying() == false) goto L9;
        built.add(Integer.valueOf(config.getClientUid()));
        goto L9
    L17:
        next = built;
        goto L19
    }

    private void asyncNotifyWatchers() {
        if (this.mNotifyWatchersMethod != null) goto L5;
        return;
    L5:
        this.mBase.mHandler.post(new ObricAppOpsServiceImpl$$ExternalSyntheticLambda1(this));
    }

    private /* synthetic */ void lambda$asyncNotifyWatchers$0() {
        this.mNotifyWatchersMethod.invoke(this.mBase, new Object[]{28, Integer.valueOf(UID_ANY)});     // Catch: Throwable -> L4
        return;
    L4:
        e = move-exception;
        Slog.e(TAG, "Error invoke. e=", e);
    }
}
