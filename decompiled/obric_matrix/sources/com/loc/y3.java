package com.loc;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;

/* JADX INFO: loaded from: classes2.dex */
public final class y3 implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f7985a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    SensorManager f7986b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Sensor f7987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Sensor f7988d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Sensor f7989e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f7990f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public double f7991g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f7992h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f7993i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    Handler f7994j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    double f7995k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    double f7996l;
    double m;
    double n;
    double[] o;
    volatile double p;
    long q;
    long r;

    public y3(Context r4) {
        this.f7985a = null;
        this.f7986b = null;
        this.f7987c = null;
        this.f7988d = null;
        this.f7989e = null;
        this.f7990f = false;
        this.f7991g = 0.0d;
        this.f7992h = 1013.25f;
        this.f7993i = 0.0f;
        this.f7994j = new Handler();
        this.f7995k = 0.0d;
        this.f7996l = 0.0d;
        this.m = 0.0d;
        this.n = 0.0d;
        this.o = new double[3];
        this.p = 0.0d;
        this.q = 0;
        this.r = 0;
        this.f7985a = r4;     // Catch: Throwable -> L10
        if (this.f7986b != null) goto L16;
        this.f7986b = (SensorManager) r4.getSystemService("sensor");     // Catch: Throwable -> L10
    L16:
        this.f7987c = this.f7986b.getDefaultSensor(6);     // Catch: Throwable -> L13
    L22:
        this.f7988d = this.f7986b.getDefaultSensor(11);     // Catch: Throwable -> L14
    L18:
        this.f7989e = this.f7986b.getDefaultSensor(1);     // Catch: Throwable -> L15
        return;
    L24:
        return;
    L10:
        th = move-exception;
        s4.h(th, "AMapSensorManager", "<init>");
    }

    private void b(float[] r13) {
        double[] r0 = this.o;
        r0[0] = (r0[0] * 0.800000011920929d) + ((double) (r13[0] * 0.19999999f));
        r0[1] = (r0[1] * 0.800000011920929d) + ((double) (r13[1] * 0.19999999f));
        r0[2] = (r0[2] * 0.800000011920929d) + ((double) (r13[2] * 0.19999999f));
        this.f7995k = ((double) r13[0]) - r0[0];
        this.f7996l = ((double) r13[1]) - r0[1];
        this.m = ((double) r13[2]) - r0[2];
        long r1 = System.currentTimeMillis();
        if ((r1 - this.q) >= 100) goto L5;
        return;
    L5:
        double r2 = this.f7995k;
        double r4 = this.f7996l;
        double r3 = (r2 * r2) + (r4 * r4);
        double r5 = this.m;
        double r6 = Math.sqrt(r3 + (r5 * r5));
        this.r++;
        this.q = r1;
        this.p += r6;
        if (this.r < 30) goto L9;
        this.n = this.p / this.r;
        this.p = 0.0d;
        this.r = 0;
        return;
    }

    private void d(float[] r3) {
        if (r3 == null) goto L5;
        this.f7991g = a5.b(SensorManager.getAltitude(this.f7992h, r3[0]));
        return;
    }

    private void f(float[] r3) {
        if (r3 == null) goto L9;
        float[] r0 = new float[9];
        SensorManager.getRotationMatrixFromVector(r0, r3);
        float[] r4 = new float[3];
        SensorManager.getOrientation(r0, r4);
        float r5 = (float) Math.toDegrees(r4[0]);
        this.f7993i = r5;
        if (r5 > 0.0f) goto L7;
        r5 = r5 + 360.0f;
    L7:
        this.f7993i = (float) Math.floor(r5);
        return;
    }

    public final void a() {
        SensorManager r1 = this.f7986b;
        if (r1 != null) goto L5;
        return;
    L5:
        if (this.f7990f == true) goto L34;
        this.f7990f = true;
        Sensor r3 = this.f7987c;     // Catch: Throwable -> L11
        if (r3 == null) goto L28;
        r1.registerListener(this, r3, 3, this.f7994j);     // Catch: Throwable -> L11
    L28:
        Sensor r2 = this.f7988d;     // Catch: Throwable -> L17
        if (r2 == null) goto L30;
        this.f7986b.registerListener(this, r2, 3, this.f7994j);     // Catch: Throwable -> L17
    L30:
        Sensor r4 = this.f7989e;     // Catch: Throwable -> L23
        if (r4 == null) goto L32;
        this.f7986b.registerListener(this, r4, 3, this.f7994j);     // Catch: Throwable -> L23
        return;
    L32:
        return;
    L23:
        th = move-exception;
        s4.h(th, "AMapSensorManager", "registerListener mAcceleroMeterVector");
        return;
    L17:
        th = move-exception;
        s4.h(th, "AMapSensorManager", "registerListener mRotationVector");
    L11:
        th = move-exception;
        s4.h(th, "AMapSensorManager", "registerListener mPressure");
        goto L28
    }

    public final void c() {
        SensorManager r0 = this.f7986b;
        if (r0 != null) goto L5;
        return;
    L5:
        if (this.f7990f == false) goto L27;
        this.f7990f = false;
        Sensor r1 = this.f7987c;     // Catch: Throwable -> L17
        if (r1 == null) goto L24;
        r0.unregisterListener(this, r1);     // Catch: Throwable -> L17
    L24:
        Sensor r2 = this.f7988d;     // Catch: Throwable -> L18
        if (r2 == null) goto L22;
        this.f7986b.unregisterListener(this, r2);     // Catch: Throwable -> L18
    L22:
        Sensor r3 = this.f7989e;     // Catch: Throwable -> L19
        if (r3 == null) goto L28;
        this.f7986b.unregisterListener(this, r3);     // Catch: Throwable -> L19
        return;
    L28:
        return;
    L29:
        return;
    }

    public final double e() {
        return this.f7991g;
    }

    public final float g() {
        return this.f7993i;
    }

    public final double h() {
        return this.n;
    }

    public final void i() {
        c();     // Catch: Throwable -> L4
        this.f7987c = null;     // Catch: Throwable -> L4
        this.f7988d = null;     // Catch: Throwable -> L4
        this.f7986b = null;     // Catch: Throwable -> L4
        this.f7989e = null;     // Catch: Throwable -> L4
        this.f7990f = false;     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        s4.h(th, "AMapSensorManager", "destroy");
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor r1, int r2) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent r3) {
        if (r3 != null) goto L34;
        return;
    L34:
        int r0 = r3.sensor.getType();     // Catch: Throwable -> L29
        if (r0 == 1) goto L24;
        if (r0 != 6) goto L10;
        if (this.f7987c == null) goto L38;
        float[] r4 = (float[]) r3.values.clone();     // Catch: Throwable -> L28
        if (r4 == null) goto L21;
        float r1 = r4[0];     // Catch: Throwable -> L28
    L21:
        d(r4);     // Catch: Throwable -> L28
        return;
    L38:
        return;
    L39:
        return;
    L10:
        if (r0 != 11) goto L41;
        if (this.f7988d == null) goto L36;
        f((float[]) r3.values.clone());     // Catch: Throwable -> L27
        return;
    L36:
        return;
    L37:
        return;
    L41:
        return;
    L24:
        if (this.f7989e == null) goto L40;
        b((float[]) r3.values.clone());     // Catch: Throwable -> L29
        return;
    L40:
        return;
    }
}
