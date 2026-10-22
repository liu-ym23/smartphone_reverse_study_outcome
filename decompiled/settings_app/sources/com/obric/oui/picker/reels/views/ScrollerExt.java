package com.obric.oui.picker.reels.views;

import android.widget.OverScroller;
import com.bytedance.apm.trace.fps.RealFpsTracer;
import com.obric.oui.utils.log.L;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScrollerExt.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\n\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0006\u0010\u0013\u001a\u00020\u0010J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J$\u0010\u0018\u001a\u00020\u0017*\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0017H\u0002J\u0014\u0010\u001c\u001a\u00020\u0017*\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J:\u0010\u001d\u001a\u00020\u0010*\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/oui/picker/reels/views/ScrollerExt;", "", "()V", "IMPL_CLASS_NAME", "", "METHOD_NAME_1", "METHOD_NAME_2", "TAG", "implClassInstance", "Ljava/lang/Class;", "method1Instance", "Ljava/lang/reflect/Method;", "method2Instance", "reflectSuccess", "", ScrollerExt.METHOD_NAME_2, "", "overScroller", "Landroid/widget/OverScroller;", "init", "reflectGetSplineFlingDistance", "", RealFpsTracer.SCROLL_VELOCITY, "", "calculateSnapVelocity", "velocityY", "startY", "itemHeight", "getFlingDistance", "snapFlingVertically", "minY", "maxY", "overY", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ScrollerExt {
    private static final String IMPL_CLASS_NAME = "android.widget.OverScroller";
    public static final ScrollerExt INSTANCE = null;
    private static final String METHOD_NAME_1 = "getSplineFlingDistance";
    private static final String METHOD_NAME_2 = "disableDynamicScroll";
    private static final String TAG = "ScrollerExt";
    private static Class<?> implClassInstance;
    private static Method method1Instance;
    private static Method method2Instance;
    private static boolean reflectSuccess;

    static {
        INSTANCE = new ScrollerExt();
    }

    private ScrollerExt() {
    }

    public final void snapFlingVertically(OverScroller r12, int r13, int r14, int r15, int r16, int r17, int r18) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        r12.fling(0, r14, 0, calculateSnapVelocity(r12, r15, r14, r13), 0, 0, r16, r17, 0, r18);
    }

    private final int calculateSnapVelocity(OverScroller r18, int r19, int r20, int r21) {
        if (reflectSuccess == true) goto L6;
        L.e(TAG, Intrinsics.stringPlus("calculateSnapVelocity, reflect failed, use original velocityY: ", Integer.valueOf(r19)));
        return r19;
    L6:
        if (r19 == 0) goto L54;
        float r1 = r20;
        float r3 = r21;
        float r4 = getFlingDistance(r18, r19) + r1;
        double r5 = r4 / r3;
        float r7 = ((float) Math.floor(r5)) * r3;
        float r6 = ((float) Math.ceil(r5)) * r3;
        if (Math.abs(r4 - r7) < Math.abs(r6 - r4)) goto L11;
        r7 = r6;
    L11:
        if (r19 <= 0) goto L13;
        byte r8 = 1;
    L14:
        int r9 = 0;
        if (r19 <= 0) goto L17;
        int r10 = 40000;
        int r11 = 0;
    L18:
        float r12 = Float.MAX_VALUE;
        int r13 = r19;
    L20:
        if (r9 >= 20) goto L49;
        int r14 = r9 + 1;
        int r15 = (r11 + r10) / 2;
        float r16 = getFlingDistance(r18, r15) + r1;
        float r17 = r16 - r7;
        if (Math.abs(r17) >= r12) goto L25;
        r12 = Math.abs(r17);
        r13 = r15;
    L25:
        L.v(TAG, "calculateSnapVelocity, iteration: " + r9 + ", mid: " + r15 + ", low: " + r11 + ", high: " + r10 + ", diff: " + r17 + ", dist: " + r16 + ", targetDistance: " + r7 + ", bestDiff: " + r12 + ", bestVelocity: " + r13 + ", velocityY: " + r19 + ", currentOffset: " + r1);
        if (r8 <= 0) goto L33;
        if (r17 >= 0.0f) goto L30;
    L37:
        if (r8 <= 0) goto L42;
        if (r17 > 0.0f) goto L44;
    L43:
        r11 = r15 + 1;
    L45:
        if (r11 > r10) goto L49;
        r9 = r14;
    L44:
        r10 = r15 - 1;
        goto L45
    L42:
        if (r17 >= 0.0f) goto L44;
    L30:
        if (Math.abs(r17) > 0.3f) goto L37;
    L33:
        if (r17 > 0.0f) goto L37;
        if (Math.abs(r17) > 0.3f) goto L37;
    L49:
        return r13;
    L17:
        r11 = -40000;
        r10 = 0;
        goto L18
    L13:
        r8 = -1;
        goto L14
    L54:
        return r19;
    }

    private final int getFlingDistance(OverScroller r1, int r2) {
        double r0 = reflectGetSplineFlingDistance(r1, r2);
        if (r2 != 0) goto L5;
        Number r3 = 0;
    L9:
        return r3.intValue();
    L5:
        if (r2 <= 0) goto L7;
        r3 = Double.valueOf(r0);
        goto L9
    L7:
        r3 = Double.valueOf(-r0);
        goto L9
    }

    public final void init() {
    L14:
        e = move-exception;
        L.e(TAG, "init reflect error", e);
        reflectSuccess = false;
        return;
    L4:
        if (implClassInstance != null) goto L7;
        implClassInstance = Class.forName(IMPL_CLASS_NAME);     // Catch: Exception -> L14
    L7:
        if (method1Instance != null) goto L12;
        Class<?> r0 = implClassInstance;     // Catch: Exception -> L14
        Intrinsics.checkNotNull(r0);     // Catch: Exception -> L14
        Method r1 = r0.getDeclaredMethod(METHOD_NAME_1, new Class[]{Integer.TYPE});     // Catch: Exception -> L14
        method1Instance = r1;     // Catch: Exception -> L14
        if (r1 == null) goto L12;
        r1.setAccessible(true);     // Catch: Exception -> L14
    L12:
        reflectSuccess = true;     // Catch: Exception -> L14
    }

    private final void disableDynamicScroll(OverScroller r4) {
    L13:
        e = move-exception;
        L.w(TAG, "disableDynamicScroll, failed", e);
        return;
    L3:
        if (method2Instance != null) goto L8;
        Method r3 = OverScroller.class.getDeclaredMethod(METHOD_NAME_2, new Class[0]);     // Catch: Exception -> L13
        method2Instance = r3;     // Catch: Exception -> L13
        if (r3 == null) goto L8;
        r3.setAccessible(true);     // Catch: Exception -> L13
    L8:
        Method r5 = method2Instance;     // Catch: Exception -> L13
        if (r5 == null) goto L18;
        r5.invoke(r4, new Object[0]);     // Catch: Exception -> L13
        return;
    }

    @JvmStatic
    public static final double reflectGetSplineFlingDistance(OverScroller r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "overScroller");
        INSTANCE.disableDynamicScroll(r4);     // Catch: Exception -> L11
        Method r1 = method1Instance;     // Catch: Exception -> L11
        if (r1 != null) goto L6;
        Object r6 = null;
    L7:
        if (r6 == null) goto L10;
        return ((Double) r6).doubleValue();
    L10:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Double");     // Catch: Exception -> L11
    L6:
        r6 = r1.invoke(r4, new Object[]{Integer.valueOf(r5)});     // Catch: Exception -> L11
    L11:
        e = move-exception;
        L.e(TAG, "reflectGetSplineFlingDistance, velocity: " + r5 + ", error", e);
        reflectSuccess = false;
        return 0.0d;
    }
}
