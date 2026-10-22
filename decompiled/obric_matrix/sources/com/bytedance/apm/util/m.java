package com.bytedance.apm.util;

/* JADX INFO: loaded from: classes.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f2054a = null;

    static /* synthetic */ class a {
    }

    private static class b {
        private b() {
        }

        /* synthetic */ b(a r1) {
            this();
        }

        public boolean a(Object r1, Object r2) {
            if (r1 == r2) goto L8;
            if (r1 != null) goto L5;
        L7:
            return false;
        L5:
            if (r1.equals(r2) == false) goto L7;
        L8:
            return true;
        }
    }

    static {
        f2054a = new b(null);
    }

    public static boolean a(Object r1, Object r2) {
        return f2054a.a(r1, r2);
    }
}
