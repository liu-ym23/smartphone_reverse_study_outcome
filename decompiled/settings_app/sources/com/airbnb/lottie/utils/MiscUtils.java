package com.airbnb.lottie.utils;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.animation.content.KeyPathElementContent;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.ShapeData;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MiscUtils {
    private static PointF pathFromDataCurrentPoint;

    public static boolean contains(float r0, float r1, float r2) {
        if (r0 >= r1) goto L5;
    L7:
        return false;
    L5:
        if (r0 > r2) goto L7;
        return true;
    }

    public static double lerp(double r0, double r2, double r4) {
        return r0 + (r4 * (r2 - r0));
    }

    public static float lerp(float r0, float r1, float r2) {
        return r0 + (r2 * (r1 - r0));
    }

    public static int lerp(int r1, int r2, float r3) {
        return (int) (r1 + (r3 * (r2 - r1)));
    }

    public MiscUtils() {
    }

    static {
        pathFromDataCurrentPoint = new PointF();
    }

    public static PointF addPoints(PointF r3, PointF r4) {
        return new PointF(r3.x + r4.x, r3.y + r4.y);
    }

    public static void getPathFromData(ShapeData r11, Path r12) {
        r12.reset();
        PointF r0 = r11.getInitialPoint();
        r12.moveTo(r0.x, r0.y);
        pathFromDataCurrentPoint.set(r0.x, r0.y);
        int r1 = 0;
    L4:
        if (r1 >= r11.getCurves().size()) goto L13;
        CubicCurveData r2 = r11.getCurves().get(r1);
        PointF r3 = r2.getControlPoint1();
        PointF r4 = r2.getControlPoint2();
        PointF r5 = r2.getVertex();
        if (r3.equals(pathFromDataCurrentPoint) == true) goto L8;
    L10:
        r12.cubicTo(r3.x, r3.y, r4.x, r4.y, r5.x, r5.y);
    L11:
        pathFromDataCurrentPoint.set(r5.x, r5.y);
        r1 = r1 + 1;
        goto L4
    L8:
        if (r4.equals(r5) == false) goto L10;
        r12.lineTo(r5.x, r5.y);
        goto L11
    L13:
        if (r11.isClosed() == false) goto L19;
        r12.close();
        return;
    }

    static int floorMod(float r0, float r1) {
        return floorMod((int) r0, (int) r1);
    }

    private static int floorMod(int r1, int r2) {
        return r1 - (r2 * floorDiv(r1, r2));
    }

    private static int floorDiv(int r2, int r3) {
        int r0 = r2 / r3;
        if ((r2 ^ r3) < 0) goto L5;
        boolean r1 = true;
    L6:
        int r4 = r2 % r3;
        if (r1 == true) goto L11;
        if (r4 != 0) goto L10;
        return r0;
    L10:
        return r0 - 1;
    L11:
        return r0;
    L5:
        r1 = false;
        goto L6
    }

    public static int clamp(int r0, int r1, int r2) {
        return Math.max(r1, Math.min(r2, r0));
    }

    public static float clamp(float r0, float r1, float r2) {
        return Math.max(r1, Math.min(r2, r0));
    }

    public static void resolveKeyPath(KeyPath r1, int r2, List<KeyPath> r3, KeyPath r4, KeyPathElementContent r5) {
        if (r1.fullyResolvesTo(r5.getName(), r2) == false) goto L6;
        r3.add(r4.addKey(r5.getName()).resolve(r5));
        return;
    }
}
