package d.g.d.d;

import android.content.Context;
import android.os.Vibrator;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import d.g.d.f.b;
import java.lang.reflect.Method;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Class<?> f16930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Method f16931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f16932c = null;

    static {
        f16932c = new a();
    }

    private a() {
    }

    public static final void b(Context r3, int r4) {
        b r0 = b.f16934a;
        Object r1 = null;
        if (r3 == null) goto L5;
        Object r2 = r3.getSystemService("vibrator");
    L6:
        if (r2 != null) goto L9;
    L11:
        Vibrator r5 = (Vibrator) r1;
        if (r5 == null) goto L14;
        c(r5, r4);
        return;
    L14:
        StringBuilder r6 = new StringBuilder();
        r6.append("vibrateEffectWithHapticPlayer error: vibrator is null, context is null? ");
        if (r3 != null) goto L17;
        boolean r7 = true;
    L18:
        r6.append(r7);
        d.g.d.f.f.b.b("VibratorSmt", r6.toString());
        return;
    L17:
        r7 = false;
        goto L18
    L9:
        if ((r2 instanceof Vibrator) == false) goto L11;
        r1 = r2;
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    public static final void c(Vibrator r7, int r8) {
        o.f(r7, TypedValues.AttributesType.S_TARGET);
    L15:
        e = move-exception;
        d.g.d.f.f.b.b("VibratorSmt", "vibrateEffectWithHapticPlayer error: " + e);
        return;
    L4:
        if (f16930a != null) goto L7;
        f16930a = Class.forName("bytedance.api.VibratorSmt");     // Catch: Exception -> L15
    L7:
        if (f16931b != null) goto L11;
        Class<?> r0 = f16930a;     // Catch: Exception -> L15
        o.c(r0);     // Catch: Exception -> L15
        Method r1 = r0.getDeclaredMethod("vibrateEffectWithHapticPlayer", new Class[]{Vibrator.class, Integer.TYPE});     // Catch: Exception -> L15
        f16931b = r1;     // Catch: Exception -> L15
        if (r1 == null) goto L11;
        r1.setAccessible(true);     // Catch: Exception -> L15
    L11:
        Method r2 = f16931b;     // Catch: Exception -> L15
        if (r2 == null) goto L20;
        r2.invoke(f16930a, new Object[]{r7, Integer.valueOf(r8)});     // Catch: Exception -> L15
        return;
    }

    public final void a(View r1, int r2) {
        if (r1 == null) goto L10;
        r1.performHapticFeedback(r2);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        d.g.d.f.f.b.b("VibratorSmt", "performHapticFeedbackAOSP error: " + e);
        return;
    }
}
