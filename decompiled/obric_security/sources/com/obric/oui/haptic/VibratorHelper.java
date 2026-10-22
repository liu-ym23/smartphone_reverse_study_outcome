package com.obric.oui.haptic;

import android.content.Context;
import android.os.Vibrator;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VibratorHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007J\u001a\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u0004H\u0007J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/oui/haptic/VibratorHelper;", "", "()V", "EFFECT_CLEAR", "", "EFFECT_CONFIRM", "EFFECT_LONG_PRESS", "EFFECT_PRESS", "EFFECT_REJECT", "EFFECT_RIGID", "EFFECT_SOFT", "EFFECT_TAP", "EFFECT_TICK", "EFFECT_WAKE_UP", "IMPL_CLASS_NAME", "", "METHOD_NAME_1", "TAG", "implClassInstance", "Ljava/lang/Class;", "method1Instance", "Ljava/lang/reflect/Method;", "getVibrator", "Landroid/os/Vibrator;", "context", "Landroid/content/Context;", VibratorHelper.METHOD_NAME_1, "", "effectId", "target", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class VibratorHelper {
    public static final int EFFECT_CLEAR = 8;
    public static final int EFFECT_CONFIRM = 6;
    public static final int EFFECT_LONG_PRESS = 2;
    public static final int EFFECT_PRESS = 0;
    public static final int EFFECT_REJECT = 7;
    public static final int EFFECT_RIGID = 4;
    public static final int EFFECT_SOFT = 5;
    public static final int EFFECT_TAP = 1;
    public static final int EFFECT_TICK = 3;
    public static final int EFFECT_WAKE_UP = 9;
    private static final String IMPL_CLASS_NAME = "bytedanceos.api.VibratorSmt";
    public static final VibratorHelper INSTANCE = null;
    private static final String METHOD_NAME_1 = "vibrateEffectWithHapticPlayer";
    private static final String TAG = "VibratorSmt";
    private static Class<?> implClassInstance;
    private static Method method1Instance;

    static {
        INSTANCE = new VibratorHelper();
    }

    private VibratorHelper() {
    }

    @JvmStatic
    public static final void vibrateEffectWithHapticPlayer(Context r2, int r3) {
        Object r0 = null;
        if (r2 == null) goto L5;
        Object r4 = r2.getSystemService("vibrator");
    L7:
        if ((r4 instanceof Vibrator) == false) goto L10;
        r0 = r4;
    L10:
        Vibrator r1 = (Vibrator) r0;
        if (r1 == null) goto L14;
        vibrateEffectWithHapticPlayer(r1, r3);
        return;
    L14:
        return;
    L5:
        r4 = null;
        goto L7
    }

    @JvmStatic
    public static final Vibrator getVibrator(Context r2) {
        Object r0 = null;
        if (r2 == null) goto L5;
        Object r3 = r2.getSystemService("vibrator");
    L7:
        if ((r3 instanceof Vibrator) == false) goto L11;
        r0 = r3;
    L11:
        return (Vibrator) r0;
    L5:
        r3 = null;
        goto L7
    }

    @JvmStatic
    public static final void vibrateEffectWithHapticPlayer(Vibrator r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "target");
        if (implClassInstance != null) goto L7;
        implClassInstance = Class.forName(IMPL_CLASS_NAME);     // Catch: Exception -> L15
    L7:
        if (method1Instance != null) goto L11;
        Class<?> r0 = implClassInstance;     // Catch: Exception -> L15
        Intrinsics.checkNotNull(r0);     // Catch: Exception -> L15
        Method r1 = r0.getDeclaredMethod(METHOD_NAME_1, new Class[]{Vibrator.class, Integer.TYPE});     // Catch: Exception -> L15
        method1Instance = r1;     // Catch: Exception -> L15
        if (r1 == null) goto L11;
        r1.setAccessible(true);     // Catch: Exception -> L15
    L11:
        Method r2 = method1Instance;     // Catch: Exception -> L15
        if (r2 == null) goto L18;
        r2.invoke(implClassInstance, new Object[]{r7, Integer.valueOf(r8)});     // Catch: Exception -> L15
        return;
    L18:
        return;
    }
}
