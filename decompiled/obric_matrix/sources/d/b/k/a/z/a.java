package d.b.k.a.z;

import android.view.View;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: d.b.k.a.z.a$a, reason: collision with other inner class name */
    static /* synthetic */ class C0372a {
    }

    private static class b extends HashMap<String, Object> {
        private b(String r1, Object r2) {
            put(r1, r2);
        }

        /* synthetic */ b(String r1, Object r2, C0372a r3) {
            this(r1, r2);
        }
    }

    public static Object a(View r1) {
        return b(r1, "DraweeHolder");
    }

    public static Object b(View r1, String r2) {
        return c(r1, r2, null);
    }

    public static Object c(View r1, String r2, Object r3) {
        if (r1 == null) goto L8;
        Object r4 = r1.getTag();
        if ((r4 instanceof b) == false) goto L8;
        Object r5 = ((b) r4).get(r2);
        if (r5 == null) goto L8;
        return r5;
    L8:
        return r3;
    }

    public static void d(View r1, Object r2) {
        e(r1, "DraweeHolder", r2);
    }

    public static boolean e(View r1, String r2, Object r3) {
        return f(r1, r2, r3, true);
    }

    public static boolean f(View r3, String r4, Object r5, boolean r6) {
        if (r3 == null) goto L11;
        Object r0 = r3.getTag();
        if ((r0 instanceof b) == false) goto L7;
        ((b) r0).put(r4, r5);
        return true;
    L7:
        if (r0 == null) goto L9;
        if (r6 == true) goto L9;
        return false;
    L9:
        r3.setTag(new b(r4, r5, null));
        return true;
    L11:
        return false;
    }
}
