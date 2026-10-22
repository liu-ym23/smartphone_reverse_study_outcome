package com.obric.common.oea.foundation.animation.manager;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import android.view.View;
import com.obric.common.oea.foundation.animation.AnimationInfo;
import com.obric.common.oea.foundation.animation.constants.RepeatMode;
import com.obric.common.oea.foundation.animation.constants.RunMode;
import com.obric.common.oea.foundation.util.OEALogger;
import com.obric.common.oea.foundation.util.SdkInit;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class AnimationManager {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f122d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnimatableStateManager f123a;
    public AnimatableRunner b;
    public final int c;

    @Metadata
    public static final class Companion {
    }

    static {
        new SdkInit();
    }

    public AnimationManager() {
        AnimatableStateManager r0 = new AnimatableStateManager();
        r0.f120a = RunMode.b;
        r0.b = RepeatMode.b;
        r0.c = EmptyList.b;
        r0.f = -1;
        r0.g = 1.0f;
        r0.j = true;
        this.f123a = r0;
        int r1 = f122d;
        f122d = r1 + 1;
        this.c = r1;
    }

    public final void a(boolean r3) {
        OEALogger.d("AnimationManager", "cancel, instanceId: [" + this.c + "], clearVelocity: " + r3);
        AnimatableRunner r2 = this.b;
        if (r2 == null) goto L9;
        OEALogger.c("cancelAnimation, clearVelocity: " + r3);
        Choreographer.getInstance().removeFrameCallback(r2.f118a);
        r2.b.a(r3);
        Function2 r4 = r2.f119d;
        if (r4 == null) goto L7;
        Unit r5 = (Unit) r4.mo7invoke(Boolean.FALSE, null);
    L7:
        OEALogger.a("AnimatableRunner", "releaseCallbacks, scene: ".concat("cancelAnimation"));
        r2.c = null;
        r2.f119d = null;
        return;
    }

    public final void b(View r9, RunMode r10, float r11, RepeatMode r12, ArrayList r13, Function3 r14, Function2 r15) {
        StringBuilder r0 = new StringBuilder("start, instanceId: [");
        r0.append(this.c);
        r0.append("], runAnimation, mode: ");
        r0.append(r10);
        r0.append(", speed: ");
        r0.append(r11);
        r0.append(", repeatMode: ");
        r0.append(r12);
        r0.append(", animationInfos: ");
        ArrayList r2 = new ArrayList(CollectionsKt.e(r13, 10));
        Iterator r1 = r13.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        AnimationInfo r3 = (AnimationInfo) r1.next();
        r2.add("AnimationInfo(property: " + r3.e + ", initialValue: " + r3.f + ", targetValue: " + r3.g + ", spec: " + r3.h.c() + ", initialVelocity: " + r3.i + ", valueClass: " + r3.j + ", currentVelocity: " + r3.k + ", durationNanos: " + r3.f99a + ", firstFrameTimeNanos: " + r3.b + ", lastFrameTimeNanos: " + r3.c + ", isRunning: " + r3.f100d + ')');
        goto L4
    L6:
        r0.append(CollectionsKt.i(r2, "\n", null, null, null, 62));
        OEALogger.d("AnimationManager", r0.toString());
        AnimatableStateManager r4 = this.f123a;
        r4.getClass();
        r4.f120a = r10;
        r4.b = r12;
        r4.c = r13;
        if (r9 == null) goto L9;
        boolean r16 = true;
    L10:
        r4.j = r16;
        r4.f121d = new WeakReference(r9);
        r4.g = r11;
        AnimatableRunner r17 = new AnimatableRunner(r4, r14, r15);
        this.b = r17;
        Choreographer.getInstance().postFrameCallback(r17.f118a);
        return;
    L9:
        r16 = false;
        goto L10
    }

    public final void c(final float r13, final View r14, final RunMode r15, final float r16, final RepeatMode r17, final ArrayList r18, final Function3 r19, final Function2 r20) {
        Looper r0 = Looper.getMainLooper();
        Intrinsics.e(r0, "Looper.getMainLooper()");
        if ((!Intrinsics.a(r0.getThread(), Thread.currentThread())) == false) goto L5;
        new Handler(Looper.getMainLooper()).post(new AnimationManager$runAnimation$1(this, r13, r14, r15, r16, r17, r18, r19, r20));
        return;
    L5:
        b(r14, r15, r16, r17, r18, r19, r20);
    }
}
