package com.bytedance.applog.util;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.bytedance.bdinstall.d1.n<Boolean> f2426a = null;

    static class a extends com.bytedance.bdinstall.d1.n<Boolean> {
        a() {
        }

        @Override // com.bytedance.bdinstall.d1.n
        protected /* bridge */ /* synthetic */ Boolean a(Object[] r1) {
            return c(r1);
        }

        protected Boolean c(Object... r3) {
            Class<?> r2 = Class.forName("com.huawei.system.BuildEx");     // Catch: Throwable -> L4
            return Boolean.valueOf("harmony".equals(r2.getMethod("getOsBrand", new Class[0]).invoke(r2, new Object[0])));
        L5:
            return Boolean.FALSE;
        }
    }

    static {
        f2426a = new a();
    }

    public static boolean a() {
        return f2426a.b(new Object[0]).booleanValue();
    }
}
