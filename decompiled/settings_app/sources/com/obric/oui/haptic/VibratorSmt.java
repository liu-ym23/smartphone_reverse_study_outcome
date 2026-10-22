package com.obric.oui.haptic;

import android.content.Context;
import android.os.Vibrator;
import android.view.View;
import com.obric.oui.utils.KtExt;
import com.obric.oui.utils.log.L;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VibratorSmt.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u0004J\u001a\u0010\u001c\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001b\u001a\u00020\u0004H\u0007J\u0018\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/oui/haptic/VibratorSmt;", "", "()V", "AOSP_EFFECT_ID_SEGMENT_TICK", "", "EFFECT_CLEAR", "EFFECT_CONFIRM", "EFFECT_LONG_PRESS", "EFFECT_PRESS", "EFFECT_REJECT", "EFFECT_RIGID", "EFFECT_SOFT", "EFFECT_TAP", "EFFECT_TICK", "EFFECT_WAKE_UP", "IMPL_CLASS_NAME", "", "METHOD_NAME_1", "TAG", "implClassInstance", "Ljava/lang/Class;", "method1Instance", "Ljava/lang/reflect/Method;", "performHapticFeedbackAOSP", "", "view", "Landroid/view/View;", "effectId", VibratorSmt.METHOD_NAME_1, "context", "Landroid/content/Context;", "target", "Landroid/os/Vibrator;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VibratorSmt {
    public static final int AOSP_EFFECT_ID_SEGMENT_TICK = 26;
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
    public static final VibratorSmt INSTANCE = null;
    private static final String METHOD_NAME_1 = "vibrateEffectWithHapticPlayer";
    private static final String TAG = "VibratorSmt";
    private static Class<?> implClassInstance;
    private static Method method1Instance;

    static {
        INSTANCE = new VibratorSmt();
    }

    private VibratorSmt() {
    }

    @JvmStatic
    public static final void vibrateEffectWithHapticPlayer(Context r3, int r4) {
        KtExt r0 = KtExt.INSTANCE;
        Object r1 = null;
        if (r3 != null) goto L5;
        Object r2 = null;
    L6:
        if (r2 != null) goto L9;
    L11:
        Vibrator r5 = (Vibrator) r1;
        if (r5 == null) goto L14;
        vibrateEffectWithHapticPlayer(r5, r4);
        return;
    L14:
        if (r3 != null) goto L16;
        boolean r6 = true;
    L17:
        L.e(TAG, Intrinsics.stringPlus("vibrateEffectWithHapticPlayer error: vibrator is null, context is null? ", Boolean.valueOf(r6)));
        return;
    L16:
        r6 = false;
        goto L17
    L9:
        if ((r2 instanceof Vibrator) == false) goto L11;
        r1 = r2;
        goto L11
    L5:
        r2 = r3.getSystemService("vibrator");
        goto L6
    }

    public final void performHapticFeedbackAOSP(View r1, int r2) {
        if (r1 == null) goto L11;
        r1.performHapticFeedback(r2);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        L.e(TAG, Intrinsics.stringPlus("performHapticFeedbackAOSP error: ", e));
        return;
    }

    @JvmStatic
    public static final void vibrateEffectWithHapticPlayer(Vibrator r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, "target");
    L17:
        e = move-exception;
        L.e(TAG, Intrinsics.stringPlus("vibrateEffectWithHapticPlayer error: ", e));
        return;
    L4:
        if (implClassInstance != null) goto L7;
        implClassInstance = Class.forName(IMPL_CLASS_NAME);     // Catch: Exception -> L17
    L7:
        if (method1Instance != null) goto L12;
        Class<?> r0 = implClassInstance;     // Catch: Exception -> L17
        Intrinsics.checkNotNull(r0);     // Catch: Exception -> L17
        Method r1 = r0.getDeclaredMethod(METHOD_NAME_1, new Class[]{Vibrator.class, Integer.TYPE});     // Catch: Exception -> L17
        method1Instance = r1;     // Catch: Exception -> L17
        if (r1 == null) goto L12;
        r1.setAccessible(true);     // Catch: Exception -> L17
    L12:
        Method r2 = method1Instance;     // Catch: Exception -> L17
        if (r2 == null) goto L22;
        r2.invoke(implClassInstance, new Object[]{r7, Integer.valueOf(r8)});     // Catch: Exception -> L17
        return;
    }
}
