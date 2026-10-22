package com.obric.cae.libs.location;

import android.location.Location;

/* JADX INFO: loaded from: classes4.dex */
public class CoordinateTransformUtils {

    public static final enum CoordinateSystem extends Enum<CoordinateSystem> {
        public static final CoordinateSystem BD09 = null;
        public static final CoordinateSystem GCJ02 = null;
        public static final CoordinateSystem WGS84 = null;
        public static final /* synthetic */ CoordinateSystem[] a = null;

        static {
            CoordinateSystem r0 = new CoordinateSystem("WGS84", 0);
            WGS84 = r0;
            CoordinateSystem r1 = new CoordinateSystem("GCJ02", 1);
            GCJ02 = r1;
            CoordinateSystem r3 = new CoordinateSystem("BD09", 2);
            BD09 = r3;
            a = new CoordinateSystem[]{r0, r1, r3};
        }

        public CoordinateSystem(String r1, int r2) {
            super(r1, r2);
        }

        public static CoordinateSystem valueOf(String r1) {
            return (CoordinateSystem) Enum.valueOf(CoordinateSystem.class, r1);
        }

        public static CoordinateSystem[] values() {
            return (CoordinateSystem[]) a.clone();
        }
    }

    public static class a {
        public final double a;
        public final double b;

        public a(double r1, double r3) {
            this.a = r1;
            this.b = r3;
        }
    }

    static {
        System.loadLibrary("coordinate_transform");
    }

    public CoordinateTransformUtils() {
    }

    private static native double[] bd09ToGcj02Native(double r0, double r2);

    public static Location convertLocation(CoordinateSystem r5, CoordinateSystem r6, Location r7) {
        if (r5 == r6) goto L30;
        if (r7 == null) goto L30;
        CoordinateSystem r0 = CoordinateSystem.WGS84;
        if (r5 == r0) goto L8;
    L10:
        CoordinateSystem r3 = CoordinateSystem.GCJ02;
        if (r5 != r3) goto L14;
        if (r6 != r0) goto L14;
        double[] r8 = gcj02ToWgs84Native(r7.getLatitude(), r7.getLongitude());
        a r9 = new a(r8[0], r8[1]);
    L28:
        Location r10 = new Location(r7);
        r10.setLatitude(r9.a);
        r10.setLongitude(r9.b);
        return r10;
    L14:
        CoordinateSystem r4 = CoordinateSystem.BD09;
        if (r5 != r4) goto L18;
        if (r6 != r3) goto L18;
        double[] r11 = bd09ToGcj02Native(r7.getLatitude(), r7.getLongitude());
        r9 = new a(r11[0], r11[1]);
    L18:
        if (r5 != r3) goto L21;
        if (r6 != r4) goto L21;
        double[] r12 = gcj02ToBd09Native(r7.getLatitude(), r7.getLongitude());
        r9 = new a(r12[0], r12[1]);
    L21:
        if (r5 != r0) goto L24;
        if (r6 != r4) goto L24;
        double[] r13 = wgs84ToGcj02Native(r7.getLatitude(), r7.getLongitude());
        double[] r14 = gcj02ToBd09Native(r13[0], r13[1]);
        r9 = new a(r14[0], r14[1]);
    L24:
        if (r5 != r4) goto L27;
        if (r6 != r0) goto L27;
        double[] r15 = bd09ToGcj02Native(r7.getLatitude(), r7.getLongitude());
        double[] r16 = gcj02ToWgs84Native(r15[0], r15[1]);
        r9 = new a(r16[0], r16[1]);
    L27:
        r9 = new a(r7.getLatitude(), r7.getLongitude());
        goto L28
    L8:
        if (r6 != CoordinateSystem.GCJ02) goto L10;
        double[] r17 = wgs84ToGcj02Native(r7.getLatitude(), r7.getLongitude());
        r9 = new a(r17[0], r17[1]);
    L30:
        return r7;
    }

    private static native double[] gcj02ToBd09Native(double r0, double r2);

    private static native double[] gcj02ToWgs84Native(double r0, double r2);

    private static native double[] wgs84ToGcj02Native(double r0, double r2);
}
