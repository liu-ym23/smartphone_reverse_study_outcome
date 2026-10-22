package com.google.gson.internal.sql;

import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import com.google.gson.x;
import java.sql.Timestamp;
import java.util.Date;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f7087a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final DefaultDateTypeAdapter.b<? extends Date> f7088b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final DefaultDateTypeAdapter.b<? extends Date> f7089c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final x f7090d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final x f7091e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final x f7092f = null;

    /* JADX INFO: renamed from: com.google.gson.internal.sql.a$a, reason: collision with other inner class name */
    class C0215a extends DefaultDateTypeAdapter.b<java.sql.Date> {
        C0215a(Class r1) {
            super(r1);
        }

        @Override // com.google.gson.internal.bind.DefaultDateTypeAdapter.b
        protected /* bridge */ /* synthetic */ Date d(Date r1) {
            return e(r1);
        }

        protected java.sql.Date e(Date r3) {
            return new java.sql.Date(r3.getTime());
        }
    }

    class b extends DefaultDateTypeAdapter.b<Timestamp> {
        b(Class r1) {
            super(r1);
        }

        @Override // com.google.gson.internal.bind.DefaultDateTypeAdapter.b
        protected /* bridge */ /* synthetic */ Date d(Date r1) {
            return e(r1);
        }

        protected Timestamp e(Date r3) {
            return new Timestamp(r3.getTime());
        }
    }

    static {
        Class.forName("java.sql.Date");     // Catch: ClassNotFoundException -> L4
        boolean r0 = true;
    L5:
        f7087a = r0;
        if (r0 == false) goto L8;
        f7088b = new C0215a(java.sql.Date.class);
        f7089c = new b(Timestamp.class);
        f7090d = SqlDateTypeAdapter.f7081b;
        f7091e = SqlTimeTypeAdapter.f7083b;
        x r1 = SqlTimestampTypeAdapter.f7085b;
    L9:
        f7092f = r1;
        return;
    L8:
        r1 = null;
        f7088b = null;
        f7089c = null;
        f7090d = null;
        f7091e = null;
    L4:
        r0 = false;
        goto L5
    }
}
