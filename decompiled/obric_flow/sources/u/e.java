package u;

import ai.j0;
import android.graphics.PointF;
import java.util.ArrayList;
import k.k;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PointF f22190a = null;

    static {
        f22190a = new PointF();
    }

    public static PointF a(PointF r5, PointF r10) {
        return new PointF(r5.x + r10.x, r5.y + r10.y);
    }

    public static float b(float r5, float r10, float r11) {
        return Math.max(r10, Math.min(r11, r5));
    }

    public static int c(float r5, float r10) {
        int r11 = (int) r5;
        int r12 = (int) r10;
        int r13 = r11 / r12;
        if ((r11 ^ r12) < 0) goto L5;
        boolean r14 = true;
    L6:
        int r15 = r11 % r12;
        if (r14 == true) goto L11;
        if (r15 == 0) goto L11;
        r13 = r13 - 1;
    L11:
        return r11 - (r12 * r13);
    L5:
        r14 = false;
        goto L6
    }

    public static float d(float r5, float r10, float r11) {
        return j0.b(r10, r5, r11, r5);
    }

    public static void e(o.e r5, int r10, ArrayList r11, o.e r12, k r13) {
        if (r5.a(r10, r13.getName()) == false) goto L6;
        String r14 = r13.getName();
        r12.getClass();
        o.e r15 = new o.e(r12);
        r15.f20373a.add(r14);
        o.e r16 = new o.e(r15);
        r16.f20374b = r13;
        r11.add(r16);
        return;
    }
}
