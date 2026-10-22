package d.b.r;

import android.os.SystemClock;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
abstract class z<T> {
    z() {
    }

    static <T> z<T> b(v r4, Method r5, y r6) {
        r6.u = SystemClock.uptimeMillis();
        u r0 = u.b(r4, r5, r6);
        Type r1 = r5.getGenericReturnType();
        if (f0.l(r1) == true) goto L11;
        if (r1 == Void.TYPE) goto L9;
        r6.v = SystemClock.uptimeMillis();
        return m.f(r4, r5, r0);
    L9:
        throw f0.o(r5, "Service methods cannot return void.", new Object[0]);
    L11:
        throw f0.o(r5, "Method return type must not include a type variable or wildcard: %s", new Object[]{r1});
    }

    abstract T a(Object[] r1);
}
