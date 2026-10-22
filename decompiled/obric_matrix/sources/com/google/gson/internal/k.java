package com.google.gson.internal;

import com.google.gson.u;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class k {

    static /* synthetic */ class a {
    }

    private static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f7064a = null;

        class a extends b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Method f7065b;

            a(Method r1) {
                this.f7065b = r1;
                super(null);
            }

            @Override // com.google.gson.internal.k.b
            public boolean a(AccessibleObject r3, Object r4) {
                return ((Boolean) this.f7065b.invoke(r3, new Object[]{r4})).booleanValue();
            L4:
                e = move-exception;
                throw new RuntimeException("Failed invoking canAccess", e);
            }
        }

        /* JADX INFO: renamed from: com.google.gson.internal.k$b$b, reason: collision with other inner class name */
        class C0213b extends b {
            C0213b() {
                super(null);
            }

            @Override // com.google.gson.internal.k.b
            public boolean a(AccessibleObject r1, Object r2) {
                return true;
            }
        }

        static {
            if (d.d() == true) goto L12;
        L6:
            b r1 = null;
        L7:
            if (r1 != null) goto L9;
            r1 = new C0213b();
        L9:
            f7064a = r1;
            return;
        L12:
            r1 = new a(AccessibleObject.class.getDeclaredMethod("canAccess", new Class[]{Object.class}));     // Catch: NoSuchMethodException -> L11
            goto L7
        }

        private b() {
        }

        /* synthetic */ b(a r1) {
            this();
        }

        public abstract boolean a(AccessibleObject r1, Object r2);
    }

    public static boolean a(AccessibleObject r1, Object r2) {
        return b.f7064a.a(r1, r2);
    }

    public static u.a b(List<u> r2, Class<?> r3) {
        Iterator<u> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        u.a r0 = r4.next().a(r3);
        if (r0 == u.a.f7100g) goto L4;
        return r0;
    L9:
        return u.a.f7099f;
    }
}
