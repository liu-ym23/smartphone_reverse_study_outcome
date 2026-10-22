package com.obric.oui.animation.engine;

import a.a;
import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.util.Log;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class SpringAnimation extends DynamicAnimation<SpringAnimation> {
    public SpringForce t;
    public float u;
    public boolean v;

    @Override // com.obric.oui.animation.engine.DynamicAnimation
    public final boolean c(long r21) {
        if (this.v == false) goto L10;
        float r1 = this.u;
        if (r1 == Float.MAX_VALUE) goto L7;
        this.t.i = r1;
        this.u = Float.MAX_VALUE;
    L7:
        this.b = (float) this.t.i;
        this.f167a = 0.0f;
        this.v = false;
        return true;
    L10:
        if (this.u == Float.MAX_VALUE) goto L12;
        SpringForce r6 = this.t;
        double r7 = r6.i;
        long r14 = r21 / 2;
        DynamicAnimation.MassState r2 = r6.a(r14, this.b, this.f167a);
        SpringForce r13 = this.t;
        r13.i = this.u;
        this.u = Float.MAX_VALUE;
        DynamicAnimation.MassState r3 = r13.a(r14, r2.f169a, r2.b);
        this.b = r3.f169a;
        this.f167a = r3.b;
    L13:
        float r4 = Math.max(this.b, this.h);
        this.b = r4;
        float r5 = Math.min(r4, this.g);
        this.b = r5;
        float r8 = this.f167a;
        SpringForce r9 = this.t;
        r9.getClass();
        if (Math.abs(r8) < r9.e) goto L16;
    L19:
        return false;
    L16:
        if (Math.abs(r5 - ((float) r9.i)) >= r9.f171d) goto L19;
        this.b = (float) this.t.i;
        this.f167a = 0.0f;
        return true;
    L12:
        DynamicAnimation.MassState r10 = this.t.a(r21, this.b, this.f167a);
        this.b = r10.f169a;
        this.f167a = r10.b;
        goto L13
    }

    public final void d() {
        SpringForce r0 = this.t;
        if (r0 == null) goto L42;
        double r1 = (float) r0.i;
        if (r1 > this.g) goto L40;
        if (r1 < this.h) goto L38;
        double r2 = Math.abs(this.j * 0.75f);
        r0.f171d = r2;
        r0.e = r2 * 62.5d;
        if (Looper.myLooper() != Looper.getMainLooper()) goto L35;
        boolean r3 = this.f;
        if (r3 == true) goto L34;
        if (r3 == true) goto L43;
        this.f = true;
        if (this.c == true) goto L16;
        this.b = this.e.a(this.f168d);
    L16:
        float r4 = this.b;
        if (r4 > this.g) goto L33;
        if (r4 < this.h) goto L33;
        ThreadLocal r5 = AnimationHandler.f;
        if (r5.get() != null) goto L23;
        r5.set(new AnimationHandler());
    L23:
        AnimationHandler r6 = (AnimationHandler) r5.get();
        ArrayList r7 = r6.b;
        if (r7.size() != 0) goto L30;
        if (r6.f164d != null) goto L28;
        r6.f164d = new AnimationHandler.FrameCallbackProvider16(r6.c);
    L28:
        r6.f164d.a();
    L30:
        if (r7.contains(this) == true) goto L44;
        r7.add(this);
        return;
    L44:
        return;
    L33:
        throw new IllegalArgumentException("Starting value need to be in between min value and max value");
    L43:
        return;
    L34:
        return;
    L35:
        long r8 = Thread.currentThread().getId();
        long r9 = Looper.getMainLooper().getThread().getId();
        StringBuilder r10 = a.s("Current Thread Id + ", r8, " Main Thread Id + ");
        r10.append(r9);
        Log.e("DynamicAnimation", r10.toString());
        throw new AndroidRuntimeException("Animations may only be started on the main thread");
    L38:
        throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
    L40:
        throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
    L42:
        throw new UnsupportedOperationException("Incomplete com.obric.oui.animation.engine.SpringAnimation: Either final position or a spring force needs to be set.");
    }
}
