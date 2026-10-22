package com.obric.oui.picker.reels.views;

import a.a;
import android.content.Context;
import android.media.SoundPool;
import android.provider.Settings;
import android.view.VelocityTracker;
import android.view.animation.LinearInterpolator;
import android.widget.OverScroller;
import com.bytedance.securityserver.R;
import com.obric.oui.common.style.OUISoundEffectHelper;
import com.obric.oui.utils.log.L;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class WheelScroller extends OverScroller {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f260a;
    public float b;
    public boolean c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public VelocityTracker f261d;
    public boolean e;
    public OnWheelChangedListener f;
    public int g;
    public final WheelView h;

    @Metadata
    public static final class Companion {
    }

    public WheelScroller(Context r3, WheelView r4) {
        Intrinsics.f(r4, "mWheelView");
        super(r3, new LinearInterpolator());
        this.h = r4;
    L6:
        e = move-exception;
        L.c("ScrollerExt", "init reflect error", e);
        ScrollerExt.f259d = false;
    L16:
        this.g = -1;
        return;
    L4:
        if (ScrollerExt.f258a != null) goto L9;
        ScrollerExt.f258a = OverScroller.class;     // Catch: Exception -> L6
    L9:
        if (ScrollerExt.b != null) goto L13;
        Class r5 = ScrollerExt.f258a;     // Catch: Exception -> L6
        Intrinsics.c(r5);     // Catch: Exception -> L6
        Method r6 = r5.getDeclaredMethod("getSplineFlingDistance", new Class[]{Integer.TYPE});     // Catch: Exception -> L6
        ScrollerExt.b = r6;     // Catch: Exception -> L6
        if (r6 == null) goto L13;
        r6.setAccessible(true);     // Catch: Exception -> L6
    L13:
        ScrollerExt.f259d = true;     // Catch: Exception -> L6
        goto L16
    }

    public static void c(WheelScroller r7) {
        WheelView r0 = r7.h;
        int r1 = r0.getItemHeightPx();
        int r2 = r7.f260a % r1;
        if (r2 != 0) goto L8;
        OnWheelChangedListener r3 = r7.f;
        if (r3 == null) goto L8;
        r3.a(r7.g);
    L8:
        if (r2 <= 0) goto L13;
        if (r2 >= (r1 / 2)) goto L13;
        r7.c = true;
        r7.f(r7.f260a, -r2, 200, "justify");
        r0.invalidate();
        return;
    L13:
        if (r2 < (r1 / 2)) goto L15;
        r7.c = true;
        r7.f(r7.f260a, r1 - r2, 200, "justify");
        r0.invalidate();
        return;
    L15:
        if (r2 < 0) goto L17;
    L19:
        int r4 = -r1;
        if (r2 > (r4 / 2)) goto L26;
        r7.c = true;
        r7.f(r7.f260a, r4 - r2, 200, "justify");
        r0.invalidate();
        return;
    L26:
        return;
    L17:
        if (r2 <= ((-r1) / 2)) goto L19;
        r7.c = true;
        r7.f(r7.f260a, -r2, 200, "justify");
        r0.invalidate();
    }

    public final void a(int r3, String r4) {
        this.f260a += r3;
        WheelView r5 = this.h;
        if (r5.y == true) goto L9;
        int r1 = r5.getItemHeightPx() * (r5.getItemSize() - 1);
        r5.getItemHeightPx();
        int r6 = this.f260a;
        if (r6 >= 0) goto L7;
        this.f260a = 0;
        goto L9
    L7:
        if (r6 <= r1) goto L9;
        this.f260a = r1;
    L9:
        d(r4);
    }

    public final int b() {
        WheelView r0 = this.h;
        int r1 = r0.getItemHeightPx();
        int r2 = r0.getItemSize();
        if (r2 != 0) goto L6;
        return -1;
    L6:
        int r4 = this.f260a;
        if (r4 >= 0) goto L9;
        int r5 = (r4 - (r1 / 2)) / r1;
    L10:
        int r3 = r5 % r2;
        if (r0.y == true) goto L14;
        if (r5 < r2) goto L14;
        r3 = r2 - 1;
    L14:
        if (r3 < 0) goto L16;
        return r3;
    L16:
        return r3 + r2;
    L9:
        r5 = ((r1 / 2) + r4) / r1;
        goto L10
    }

    public final void d(String r11) {
        int r0 = this.g;
        int r1 = b();
        if (r0 == r1) goto L56;
        this.g = r1;
        WheelView r2 = this.h;
        Context r3 = r2.getContext();
        L.a("WheelScroller", "performVibrateEffect, scene: [" + r11 + ']');
        int r4 = r11.hashCode();
        if (r4 == (-1621011813)) goto L13;
        if (r4 == 530781668) goto L10;
    L45:
        OnWheelChangedListener r10 = this.f;
        if (r10 == null) goto L57;
        r10.b(r0, r1);
        return;
    L57:
        return;
    L10:
        if (r11.equals("computeScroll") == false) goto L45;
    L52:
        r2.performHapticFeedback(26);     // Catch: Exception -> L17
    L19:
        SoundPool r12 = OUISoundEffectHelper.f201a;
        if (r3 != null) goto L22;
        L.g("OUISoundEffectHelper", "can't play, context is null");
        goto L45
    L22:
        int r5 = 0;
        r5 = Settings.System.getInt(r3.getContentResolver(), "sound_effects_enabled", 0);     // Catch: Exception -> L25
    L27:
        if (r5 == 0) goto L45;
        OUISoundEffectHelper.a();     // Catch: Exception -> L35
        boolean r6 = OUISoundEffectHelper.c.contains(Integer.valueOf(R.raw.reel_picker));     // Catch: Exception -> L35
        ConcurrentHashMap r7 = OUISoundEffectHelper.b;
        if (r6 == false) goto L33;
        Integer r8 = (Integer) r7.get(Integer.valueOf(R.raw.reel_picker));     // Catch: Exception -> L35
        if (r8 == null) goto L49;
        SoundPool r9 = OUISoundEffectHelper.f201a;     // Catch: Exception -> L35
        if (r9 == null) goto L49;
        r9.play(r8.intValue(), 1.0f, 1.0f, 1, 0, 1.0f);     // Catch: Exception -> L35
    L49:
        goto L45
    L33:
        if (r7.containsKey(Integer.valueOf(R.raw.reel_picker)) == true) goto L37;
        L.g("OUISoundEffectHelper", "not loaded, start now: resId=2131689472");     // Catch: Exception -> L35
        OUISoundEffectHelper.b(r3, new int[]{R.raw.reel_picker});     // Catch: Exception -> L35
        goto L49
    L37:
        L.a("OUISoundEffectHelper", "loading: resId=2131689472");     // Catch: Exception -> L35
    L35:
        e = move-exception;
        L.c("OUISoundEffectHelper", "play failed, resId=2131689472", e);
    L25:
        e = move-exception;
        L.c("OUISoundEffectHelper", "get sound effect enabled failed", e);
    L17:
        e = move-exception;
        L.b("VibratorSmt", "performHapticFeedbackAOSP error: " + e);
        goto L19
    L13:
        if (r11.equals("touchEvent") == false) goto L45;
    }

    public final void e(int r4, boolean r5) {
        WheelView r0 = this.h;
        int r1 = r0.getItemHeightPx() * r4;
        int r6 = this.f260a;
        int r2 = r1 - r6;
        if (r2 != 0) goto L6;
        return;
    L6:
        if (r5 == false) goto L8;
        this.c = true;
        f(r6, r2, 200, "setCurrentIndex");
        r0.invalidate();
        return;
    L8:
        a(r2, "setCurrentIndex");
        r0.invalidate();
    }

    public final void f(int r8, int r9, int r10, String r11) {
        StringBuilder r0 = a.r("startScrollInternal, startX: 0, startY: ", r8, ", dx: 0, dy: ", r9, ", duration: ");
        r0.append(r10);
        r0.append(", scene: ");
        r0.append(r11);
        L.a("WheelScroller", r0.toString());
        startScroll(0, r8, 0, r9, r10);
    }
}
