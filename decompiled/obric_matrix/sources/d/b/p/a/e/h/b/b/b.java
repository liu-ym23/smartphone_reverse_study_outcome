package d.b.p.a.e.h.b.b;

import android.os.Build;
import android.os.IBinder;
import d.b.p.a.d.h;
import d.b.p.a.h.d;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class b extends d.b.p.a.e.h.a.a.c {

    static final class a extends d.b.p.a.e.h.a.a.b {
        a() {
        }

        @Override // d.b.p.a.e.h.a.a.b
        public Object a(Object r6, Method r7, Object[] r8, Object r9) {
            StackTraceElement[] r0 = Thread.currentThread().getStackTrace();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L9;
            if (r0[r2].getMethodName().contains("getSharedPreferences") == true) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            h.a("IMountServiceProxy", "IsUserKeyUnlocked method is called，hint getSharedPreferences，return true。");
            return Boolean.TRUE;
        L9:
            super.a(r6, r7, r8, r9);
            return r9;
        }

        @Override // d.b.p.a.e.h.a.a.b
        public Object b(Object r1, Method r2, Object[] r3) {
            h.a("IMountServiceProxy", "IsUserKeyUnlocked method is called.");
            return null;
        }
    }

    static {
        d.b.p.a.e.h.a.a.c.c("isUserKeyUnlocked", new a());
    }

    public b() {
    }

    public void i() {
        d.b.p.a.e.h.b.b.a r0 = new d.b.p.a.e.h.b.b.a("mount", this);
        r0.i();
    L10:
        e = move-exception;
        h.c("IMountServiceProxy", "Hook proxy MountService Failed!!!");
        e.printStackTrace();
        return;
    L4:
        if (Build.VERSION.SDK_INT <= 25) goto L7;
        String r1 = "android.os.storage.IStorageManager$Stub";
    L8:
        h(d.a(Class.forName(r1), "asInterface", new Class[]{IBinder.class}).invoke(null, new Object[]{r0.e()}));     // Catch: Exception -> L10
        return;
    L7:
        r1 = "android.os.storage.IMountService$Stub";
        goto L8
    }
}
