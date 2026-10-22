package com.obric.oui.common.style;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.provider.Settings;
import com.obric.oui.utils.log.L;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OUISoundEffectHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\b\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001a\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\u0010\u0015\u001a\u00020\u0016\"\u00020\bJ\u001a\u0010\u0017\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0001\u0010\u0018\u001a\u00020\bJ\u0006\u0010\u0019\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R2\u0010\u0006\u001a&\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b \t*\u0012\u0012\f\u0012\n \t*\u0004\u0018\u00010\b0\b\u0018\u00010\n0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/oui/common/style/OUISoundEffectHelper;", "", "()V", "TAG", "", "initLock", "loadedSounds", "", "", "kotlin.jvm.PlatformType", "", "soundIdMap", "Ljava/util/concurrent/ConcurrentHashMap;", "soundPool", "Landroid/media/SoundPool;", "ensureInitialized", "", "context", "Landroid/content/Context;", "isSoundEffectEnabled", "load", "soundResIds", "", "play", "soundResId", "release", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OUISoundEffectHelper {
    public static final OUISoundEffectHelper INSTANCE = null;
    private static final String TAG = "OUISoundEffectHelper";
    private static final Object initLock = null;
    private static final Set<Integer> loadedSounds = null;
    private static final ConcurrentHashMap<Integer, Integer> soundIdMap = null;
    private static SoundPool soundPool;

    public static /* synthetic */ void $r8$lambda$ZDON4HPdNEYKvbg4XqdO3VCKzgU(SoundPool r0, int r1, int r2) {
        m241ensureInitialized$lambda2$lambda1(r0, r1, r2);
    }

    private OUISoundEffectHelper() {
    }

    static {
        INSTANCE = new OUISoundEffectHelper();
        soundIdMap = new ConcurrentHashMap();
        loadedSounds = Collections.newSetFromMap(new ConcurrentHashMap());
        initLock = new Object();
    }

    private final void ensureInitialized(Context r3) {
        if (soundPool != null) goto L18;
        Object r2 = initLock;
        monitor-enter(r2);
    L15:
        th = move-exception;
        throw th;
    L7:
        if (soundPool != null) goto L12;
        L.d(TAG, "init soundPool");     // Catch: Throwable -> L15
        AudioAttributes r4 = new AudioAttributes.Builder().setUsage(13).setContentType(4).build();     // Catch: Throwable -> L15
        SoundPool r5 = new SoundPool.Builder().setMaxStreams(5).setAudioAttributes(r4).build();     // Catch: Throwable -> L15
        soundPool = r5;     // Catch: Throwable -> L15
        if (r5 == null) goto L12;
        r5.setOnLoadCompleteListener(new OUISoundEffectHelper$$ExternalSyntheticLambda0());     // Catch: Throwable -> L15
    L12:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r2);
        return;
    }

    /* JADX INFO: renamed from: ensureInitialized$lambda-2$lambda-1, reason: not valid java name */
    private static final void m241ensureInitialized$lambda2$lambda1(SoundPool r3, int r4, int r5) {
        if (r5 != 0) goto L23;
        Set<Map.Entry<Integer, Integer>> r6 = soundIdMap.entrySet();
        Intrinsics.checkNotNullExpressionValue(r6, "soundIdMap.entries");
        Iterator<T> r7 = r6.iterator();
    L5:
        Integer r1 = null;
        if (r7.hasNext() == false) goto L16;
        Object r0 = r7.next();
        Integer r2 = (Integer) ((Map.Entry) r0).getValue();
        if (r2 != null) goto L11;
    L13:
        boolean r8 = false;
    L14:
        if (r8 == false) goto L5;
    L17:
        Map.Entry r9 = (Map.Entry) r0;
        if (r9 == null) goto L21;
        r1 = (Integer) r9.getKey();
    L21:
        if (r1 == null) goto L30;
        loadedSounds.add(r1);
        L.d(TAG, Intrinsics.stringPlus("loaded: resId=", r1));
        return;
    L30:
        return;
    L11:
        if (r2.intValue() != r4) goto L13;
        r8 = true;
        goto L14
    L16:
        r0 = null;
        goto L17
    L23:
        L.e(TAG, "load failed, sampleId=" + r4 + ", status=" + r5);
    }

    public final void load(Context r11, int... r12) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "soundResIds");
        ensureInitialized(r11);     // Catch: Exception -> L14
        int r10 = r12.length;     // Catch: Exception -> L14
        int r1 = 0;
    L4:
        if (r1 >= r10) goto L23;
        int r2 = r12[r1];     // Catch: Exception -> L14
        ConcurrentHashMap<Integer, Integer> r3 = soundIdMap;     // Catch: Exception -> L14
        if (r3.containsKey(Integer.valueOf(r2)) == true) goto L13;
        SoundPool r4 = soundPool;     // Catch: Exception -> L14
        if (r4 != null) goto L10;
        Integer r5 = null;
    L11:
        if (r5 == null) goto L13;
        r3.put(Integer.valueOf(r2), r5);     // Catch: Exception -> L14
        L.d(TAG, "start load, resId=" + r2 + ", 分配的 soundId=" + r5);     // Catch: Exception -> L14
        goto L13
    L10:
        r5 = Integer.valueOf(r4.load(r11.getApplicationContext(), r2, 1));     // Catch: Exception -> L14
    L13:
        r1 = r1 + 1;
        goto L4
    L23:
        return;
    L14:
        e = move-exception;
        L.e(TAG, Intrinsics.stringPlus("load failed, resIds=", ArraysKt.joinToString$default(r12, ", ", null, null, 0, null, null, 62, null)), e);
    }

    public final void play(Context r9, int r10) {
        if (r9 != null) goto L7;
        L.w(TAG, "can't play, context is null");
        return;
    L7:
        if (isSoundEffectEnabled(r9) != 0) goto L27;
        return;
    L27:
        ensureInitialized(r9);     // Catch: Exception -> L23
        if (loadedSounds.contains(Integer.valueOf(r10)) == false) goto L12;
        Integer r8 = soundIdMap.get(Integer.valueOf(r10));     // Catch: Exception -> L23
        if (r8 == null) goto L26;
        SoundPool r1 = soundPool;     // Catch: Exception -> L23
        if (r1 == null) goto L26;
        r1.play(r8.intValue(), 1.0f, 1.0f, 1, 0, 1.0f);     // Catch: Exception -> L23
    L26:
        return;
    L12:
        if (soundIdMap.containsKey(Integer.valueOf(r10)) == true) goto L14;
        L.w(TAG, Intrinsics.stringPlus("not loaded, start now: resId=", Integer.valueOf(r10)));     // Catch: Exception -> L23
        load(r9, new int[]{r10});     // Catch: Exception -> L23
        goto L26
    L14:
        L.d(TAG, Intrinsics.stringPlus("loading: resId=", Integer.valueOf(r10)));     // Catch: Exception -> L23
    L23:
        e = move-exception;
        L.e(TAG, Intrinsics.stringPlus("play failed, resId=", Integer.valueOf(r10)), e);
    }

    public final void release() {
        L.d(TAG, "release");     // Catch: Exception -> L9
        SoundPool r0 = soundPool;     // Catch: Exception -> L9
        if (r0 == null) goto L7;
        r0.release();     // Catch: Exception -> L9
    L7:
        soundPool = null;     // Catch: Exception -> L9
        soundIdMap.clear();     // Catch: Exception -> L9
        loadedSounds.clear();     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        L.w(TAG, Intrinsics.stringPlus("release Exception: ", e));
    }

    private final int isSoundEffectEnabled(Context r3) {
        return Settings.System.getInt(r3.getContentResolver(), "sound_effects_enabled", 0);
    L5:
        e = move-exception;
        L.e(TAG, "get sound effect enabled failed", e);
        return 0;
    }
}
