package com.bytedance.bdinstall.d1;

import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static n<String> f2733a;

    class a extends n<String> {
        a() {
        }

        @Override // com.bytedance.bdinstall.d1.n
        protected /* bridge */ /* synthetic */ String a(Object[] r1) {
            return c(r1);
        }

        protected String c(Object... r1) {
            return UUID.randomUUID().toString();
        }
    }

    static {
        f2733a = a();
    }

    private static n<String> a() {
        return new a();
    }

    public static String b() {
        return f2733a.b(new Object[0]);
    }
}
