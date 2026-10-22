package com.bytedance.android.sdk.bdticketguard.o1;

import android.util.Log;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final c f933a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final C0032b f934b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f935c = null;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Mac f936a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private SecretKeySpec f937b;

        public a() {
            Mac r0 = Mac.getInstance("HmacSHA256");
            o.b(r0, "Mac.getInstance(HMAC_ALGORITHM)");
            this.f936a = r0;
        }

        public final SecretKeySpec a() {
            return this.f937b;
        }

        public final Mac b() {
            return this.f936a;
        }

        public final void c(SecretKeySpec r1) {
            this.f937b = r1;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.sdk.bdticketguard.o1.b$b, reason: collision with other inner class name */
    public static final class C0032b extends ThreadLocal<a> {
        C0032b() {
        }

        protected a a() {
            return new a();
        L4:
            e = move-exception;
            Log.e("HmacHelper", "error in Mac.getInstance", e);
            throw new RuntimeException(e);
        }

        @Override // java.lang.ThreadLocal
        public /* bridge */ /* synthetic */ a initialValue() {
            return a();
        }
    }

    public static final class c extends ThreadLocal<Mac> {
        c() {
        }

        protected Mac a() {
            Mac r2 = Mac.getInstance("HmacSHA256");     // Catch: Exception -> L4
            o.b(r2, "Mac.getInstance(HMAC_ALGORITHM)");     // Catch: Exception -> L4
            return r2;
        L4:
            e = move-exception;
            Log.e("HmacHelper", "error in Mac.getInstance", e);
            throw new RuntimeException(e);
        }

        @Override // java.lang.ThreadLocal
        public /* bridge */ /* synthetic */ Mac initialValue() {
            return a();
        }
    }

    static {
        f935c = new b();
        f933a = new c();
        f934b = new C0032b();
    }

    private b() {
    }

    public final byte[] a(byte[] r4, byte[] r5) {
        o.g(r4, "key");
        o.g(r5, "data");
        if (r4.length != 0) goto L5;
        boolean r3 = true;
    L7:
        if ((!r3) == false) goto L20;
        a r6 = f934b.get();
        if (r6 == null) goto L18;
        SecretKeySpec r1 = new SecretKeySpec(r4, "HmacSHA256");
        SecretKeySpec r7 = r6.a();
        if (r7 != null) goto L13;
    L14:
        r6.b().init(r1);
        r6.c(r1);
    L15:
        byte[] r8 = r6.b().doFinal(r5);
        o.b(r8, "context.mac.doFinal(data)");
        return r8;
    L13:
        if (r7.equals(r1) == true) goto L15;
    L18:
        throw new RuntimeException("hmacContext is null, Mac probably failed to init");
    L20:
        throw new IllegalStateException("HMAC key cannot be empty".toString());
    L5:
        r3 = false;
        goto L7
    }

    public final byte[] b(byte[] r3, byte[] r4) {
        o.g(r3, "key");
        o.g(r4, "data");
        Mac r2 = f933a.get();
        if (r2 == null) goto L7;
        r2.init(new SecretKeySpec(r3, "HmacSHA256"));
        byte[] r5 = r2.doFinal(r4);
        o.b(r5, "hmacBytes");
        return r5;
    L7:
        throw new RuntimeException("mac is null");
    }
}
