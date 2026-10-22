package org.apache.commons.math3.geometry.euclidean.threed;

/* JADX INFO: loaded from: classes6.dex */
public final class RotationOrder {
    public static final RotationOrder XYX = null;
    public static final RotationOrder XYZ = null;
    public static final RotationOrder XZX = null;
    public static final RotationOrder XZY = null;
    public static final RotationOrder YXY = null;
    public static final RotationOrder YXZ = null;
    public static final RotationOrder YZX = null;
    public static final RotationOrder YZY = null;
    public static final RotationOrder ZXY = null;
    public static final RotationOrder ZXZ = null;
    public static final RotationOrder ZYX = null;
    public static final RotationOrder ZYZ = null;
    private final Vector3D a1;
    private final Vector3D a2;
    private final Vector3D a3;
    private final String name;

    static {
        XYZ = new RotationOrder("XYZ", Vector3D.PLUS_I, Vector3D.PLUS_J, Vector3D.PLUS_K);
        XZY = new RotationOrder("XZY", Vector3D.PLUS_I, Vector3D.PLUS_K, Vector3D.PLUS_J);
        YXZ = new RotationOrder("YXZ", Vector3D.PLUS_J, Vector3D.PLUS_I, Vector3D.PLUS_K);
        YZX = new RotationOrder("YZX", Vector3D.PLUS_J, Vector3D.PLUS_K, Vector3D.PLUS_I);
        ZXY = new RotationOrder("ZXY", Vector3D.PLUS_K, Vector3D.PLUS_I, Vector3D.PLUS_J);
        ZYX = new RotationOrder("ZYX", Vector3D.PLUS_K, Vector3D.PLUS_J, Vector3D.PLUS_I);
        XYX = new RotationOrder("XYX", Vector3D.PLUS_I, Vector3D.PLUS_J, Vector3D.PLUS_I);
        XZX = new RotationOrder("XZX", Vector3D.PLUS_I, Vector3D.PLUS_K, Vector3D.PLUS_I);
        YXY = new RotationOrder("YXY", Vector3D.PLUS_J, Vector3D.PLUS_I, Vector3D.PLUS_J);
        YZY = new RotationOrder("YZY", Vector3D.PLUS_J, Vector3D.PLUS_K, Vector3D.PLUS_J);
        ZXZ = new RotationOrder("ZXZ", Vector3D.PLUS_K, Vector3D.PLUS_I, Vector3D.PLUS_K);
        ZYZ = new RotationOrder("ZYZ", Vector3D.PLUS_K, Vector3D.PLUS_J, Vector3D.PLUS_K);
    }

    private RotationOrder(String r1, Vector3D r2, Vector3D r3, Vector3D r4) {
        this.name = r1;
        this.a1 = r2;
        this.a2 = r3;
        this.a3 = r4;
    }

    public String toString() {
        return this.name;
    }

    public Vector3D getA1() {
        return this.a1;
    }

    public Vector3D getA2() {
        return this.a2;
    }

    public Vector3D getA3() {
        return this.a3;
    }
}
