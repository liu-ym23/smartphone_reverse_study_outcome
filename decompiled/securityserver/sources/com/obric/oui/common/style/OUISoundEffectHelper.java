package com.obric.oui.common.style;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.SoundPool;
import androidx.annotation.RequiresApi;
import com.obric.oui.utils.log.L;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(24)
@Metadata
public final class OUISoundEffectHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SoundPool f201a;
    public static final ConcurrentHashMap b = null;
    public static final ConcurrentHashMap.KeySetView c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f202d = null;

    static {
        b = new ConcurrentHashMap();
        c = ConcurrentHashMap.newKeySet();
        f202d = new Object();
    }

    public static void a() {
        if (f201a != null) goto L18;
        Object r0 = f202d;
        monitor-enter(r0);
    L12:
        th = move-exception;
        throw th;
    L7:
        if (f201a != null) goto L14;
        L.a("OUISoundEffectHelper", "init soundPool");     // Catch: Throwable -> L12
        AudioAttributes r1 = new AudioAttributes.Builder().setUsage(13).setContentType(4).build();     // Catch: Throwable -> L12
        SoundPool r2 = new SoundPool.Builder().setMaxStreams(5).setAudioAttributes(r1).build();     // Catch: Throwable -> L12
        f201a = r2;     // Catch: Throwable -> L12
        if (r2 == null) goto L14;
        r2.setOnLoadCompleteListener(OUISoundEffectHelper$ensureInitialized$1$1.f203a);     // Catch: Throwable -> L12
    L14:
        monitor-exit(r0);
        return;
    }

    public static void b(Context r10, int... r11) {
        int r2 = 0;
        a();     // Catch: Exception -> L10
        int r3 = r11.length;     // Catch: Exception -> L10
        int r4 = 0;
    L4:
        if (r4 >= r3) goto L36;
        int r5 = r11[r4];     // Catch: Exception -> L10
        r4 = r4 + 1;     // Catch: Exception -> L10
        ConcurrentHashMap r6 = b;     // Catch: Exception -> L10
        if (r6.containsKey(Integer.valueOf(r5)) == true) goto L4;
        SoundPool r7 = f201a;     // Catch: Exception -> L10
        if (r7 == null) goto L12;
        Integer r8 = Integer.valueOf(r7.load(r10.getApplicationContext(), r5, 1));     // Catch: Exception -> L10
    L13:
        if (r8 == null) goto L4;
        r6.put(Integer.valueOf(r5), r8);     // Catch: Exception -> L10
        L.a("OUISoundEffectHelper", "start load, resId=" + r5 + ", 分配的 soundId=" + r8);     // Catch: Exception -> L10
        goto L4
    L12:
        r8 = null;
        goto L13
    L36:
        return;
    L10:
        e = move-exception;
        StringBuilder r9 = new StringBuilder("load failed, resIds=");
        StringBuilder r12 = new StringBuilder();
        r12.append("");
        int r13 = r11.length;
        int r14 = 0;
    L17:
        if (r2 >= r13) goto L22;
        int r15 = r11[r2];
        r14 = r14 + 1;
        if (r14 <= 1) goto L21;
        r12.append(", ");
    L21:
        r12.append(String.valueOf(r15));
        r2 = r2 + 1;
        goto L17
    L22:
        r12.append("");
        String r16 = r12.toString();
        Intrinsics.e(r16, "joinTo(StringBuilder(), …ed, transform).toString()");
        r9.append(r16);
        L.c("OUISoundEffectHelper", r9.toString(), e);
    }
}
