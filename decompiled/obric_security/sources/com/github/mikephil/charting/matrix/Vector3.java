package com.github.mikephil.charting.matrix;

/* JADX INFO: loaded from: classes2.dex */
public final class Vector3 {
    public static final Vector3 UNIT_X = null;
    public static final Vector3 UNIT_Y = null;
    public static final Vector3 UNIT_Z = null;
    public static final Vector3 ZERO = null;
    public float x;
    public float y;
    public float z;

    static {
        ZERO = new Vector3(0.0f, 0.0f, 0.0f);
        UNIT_X = new Vector3(1.0f, 0.0f, 0.0f);
        UNIT_Y = new Vector3(0.0f, 1.0f, 0.0f);
        UNIT_Z = new Vector3(0.0f, 0.0f, 1.0f);
    }

    public Vector3() {
    }

    public Vector3(float[] r4) {
        set(r4[0], r4[1], r4[2]);
    }

    public Vector3(float r1, float r2, float r3) {
        set(r1, r2, r3);
    }

    public Vector3(Vector3 r1) {
        set(r1);
    }

    public final void add(Vector3 r3) {
        this.x += r3.x;
        this.y += r3.y;
        this.z += r3.z;
    }

    public final void add(float r2, float r3, float r4) {
        this.x += r2;
        this.y += r3;
        this.z += r4;
    }

    public final void subtract(Vector3 r3) {
        this.x -= r3.x;
        this.y -= r3.y;
        this.z -= r3.z;
    }

    public final void subtractMultiple(Vector3 r3, float r4) {
        this.x -= r3.x * r4;
        this.y -= r3.y * r4;
        this.z -= r3.z * r4;
    }

    public final void multiply(float r2) {
        this.x *= r2;
        this.y *= r2;
        this.z *= r2;
    }

    public final void multiply(Vector3 r3) {
        this.x *= r3.x;
        this.y *= r3.y;
        this.z *= r3.z;
    }

    public final void divide(float r2) {
        if (r2 == 0.0f) goto L6;
        this.x /= r2;
        this.y /= r2;
        this.z /= r2;
        return;
    }

    public final void set(Vector3 r2) {
        this.x = r2.x;
        this.y = r2.y;
        this.z = r2.z;
    }

    public final void set(float r1, float r2, float r3) {
        this.x = r1;
        this.y = r2;
        this.z = r3;
    }

    public final float dot(Vector3 r4) {
        return ((this.x * r4.x) + (this.y * r4.y)) + (this.z * r4.z);
    }

    public final Vector3 cross(Vector3 r8) {
        float r1 = this.y;
        float r2 = r8.z;
        float r4 = this.z;
        float r5 = r8.y;
        float r9 = r8.x;
        float r7 = this.x;
        return new Vector3((r1 * r2) - (r4 * r5), (r4 * r9) - (r2 * r7), (r7 * r5) - (r1 * r9));
    }

    public final float length() {
        return (float) Math.sqrt(length2());
    }

    public final float length2() {
        float r0 = this.x;
        float r1 = this.y;
        float r2 = this.z;
        return ((r0 * r0) + (r1 * r1)) + (r2 * r2);
    }

    public final float distance2(Vector3 r4) {
        float r0 = this.x - r4.x;
        float r1 = this.y - r4.y;
        float r3 = this.z - r4.z;
        return ((r0 * r0) + (r1 * r1)) + (r3 * r3);
    }

    public final float normalize() {
        float r0 = length();
        if (r0 == 0.0f) goto L5;
        this.x /= r0;
        this.y /= r0;
        this.z /= r0;
    L5:
        return r0;
    }

    public final void zero() {
        set(0.0f, 0.0f, 0.0f);
    }

    public final boolean pointsInSameDirection(Vector3 r1) {
        if (dot(r1) <= 0.0f) goto L5;
        return true;
    L5:
        return false;
    }
}
