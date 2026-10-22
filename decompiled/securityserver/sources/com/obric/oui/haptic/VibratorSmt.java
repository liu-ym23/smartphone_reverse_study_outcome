package com.obric.oui.haptic;

import android.content.Context;
import android.os.Vibrator;
import com.obric.oui.utils.log.L;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class VibratorSmt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Class f227a;
    public static Method b;

    public static final void a(Context r6, int r7) {
        Object r0 = null;
        if (r6 == null) goto L5;
        Object r1 = r6.getSystemService("vibrator");
    L6:
        if (r1 != null) goto L9;
    L11:
        Vibrator r2 = (Vibrator) r0;
        boolean r3 = true;
        if (r2 != null) goto L34;
        StringBuilder r8 = new StringBuilder("vibrateEffectWithHapticPlayer error: vibrator is null, context is null? ");
        if (r6 == null) goto L32;
        r3 = false;
    L32:
        r8.append(r3);
        L.b("VibratorSmt", r8.toString());
        return;
    L34:
    L16:
        e = move-exception;
        L.b("VibratorSmt", "vibrateEffectWithHapticPlayer error: " + e);
        return;
    L14:
        if (f227a != null) goto L19;
        f227a = Class.forName("bytedanceos.api.VibratorSmt");     // Catch: Exception -> L16
    L19:
        if (b != null) goto L23;
        Class r9 = f227a;     // Catch: Exception -> L16
        Intrinsics.c(r9);     // Catch: Exception -> L16
        Method r10 = r9.getDeclaredMethod("vibrateEffectWithHapticPlayer", new Class[]{Vibrator.class, Integer.TYPE});     // Catch: Exception -> L16
        b = r10;     // Catch: Exception -> L16
        if (r10 == null) goto L23;
        r10.setAccessible(true);     // Catch: Exception -> L16
    L23:
        Method r11 = b;     // Catch: Exception -> L16
        if (r11 == null) goto L36;
        r11.invoke(f227a, new Object[]{r2, Integer.valueOf(r7)});     // Catch: Exception -> L16
        return;
    L36:
        return;
    L9:
        if ((r1 instanceof Vibrator) == false) goto L11;
        r0 = r1;
        goto L11
    L5:
        r1 = null;
        goto L6
    }
}
