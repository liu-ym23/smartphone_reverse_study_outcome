package com.bytedance.android.sdk.bdticketguard.m1;

import com.bytedance.android.sdk.bdticketguard.s0;
import com.bytedance.common.wschannel.WsConstants;
import kotlin.a0;
import kotlin.i0.m0;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import kotlin.u;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f855a = null;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g r1) {
            this();
        }

        public final c a(String r9) {
            o.g(r9, "json");
            JSONObject r0 = new JSONObject(r9);     // Catch: Exception -> L8
            boolean r10 = r0.getBoolean("isSuccess");     // Catch: Exception -> L8
            String r2 = r0.getString("adapterName");     // Catch: Exception -> L8
            boolean r4 = r0.getBoolean("isCached");     // Catch: Exception -> L8
            String r1 = r0.getString("signContent");     // Catch: Exception -> L8
            com.bytedance.android.sdk.bdticketguard.m1.a.C0029a r3 = com.bytedance.android.sdk.bdticketguard.m1.a.f851d;     // Catch: Exception -> L8
            o.b(r1, "it");     // Catch: Exception -> L8
            com.bytedance.android.sdk.bdticketguard.m1.a r5 = r3.a(r1);     // Catch: Exception -> L8
            long r6 = r0.getLong("durationNs");     // Catch: Exception -> L8
            if (r10 == false) goto L6;
            o.b(r2, "adapterName");     // Catch: Exception -> L8
            String r7 = r0.getString("attestSign");     // Catch: Exception -> L8
            o.b(r7, "jsonObject.getString(\"attestSign\")");     // Catch: Exception -> L8
            c r11 = new d(r2, r7, r4, r5, r6);     // Catch: Exception -> L8
        L11:
            return r11;
        L6:
            o.b(r2, "adapterName");     // Catch: Exception -> L8
            r11 = new b(r2, new Exception(r0.getString(WsConstants.KEY_CONNECTION_ERROR)));     // Catch: Exception -> L8
        L8:
            e = move-exception;
            s0.f1065a.c("AttestSignResult", "fromJson error", e);
            return null;
        }
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f856b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Throwable f857c;

        public b(String r2, Throwable r3) {
            o.g(r2, "adapterName");
            o.g(r3, WsConstants.KEY_CONNECTION_ERROR);
            super(null);
            this.f856b = r2;
            this.f857c = r3;
        }

        @Override // com.bytedance.android.sdk.bdticketguard.m1.c
        public String a() {
            return this.f856b;
        }

        public final Throwable c() {
            return this.f857c;
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L10;
            b r4 = (b) r3;
            if (o.a(a(), r4.a()) == true) goto L8;
            return false;
        L8:
            if (o.a(this.f857c, r4.f857c) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            String r0 = a();
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            Throwable r4 = this.f857c;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "Failed(adapterName=" + a() + ", error=" + this.f857c + ")";
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.sdk.bdticketguard.m1.c$c, reason: collision with other inner class name */
    public static final class C0030c extends RuntimeException {
        public C0030c() {
            super("No attest sign cache");
        }
    }

    public static final class d extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f858b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f859c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f860d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final com.bytedance.android.sdk.bdticketguard.m1.a f861e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final long f862f;

        public d(String r2, String r3, boolean r4, com.bytedance.android.sdk.bdticketguard.m1.a r5, long r6) {
            o.g(r2, "adapterName");
            o.g(r3, "attestSign");
            o.g(r5, "signContent");
            super(null);
            this.f858b = r2;
            this.f859c = r3;
            this.f860d = r4;
            this.f861e = r5;
            this.f862f = r6;
        }

        @Override // com.bytedance.android.sdk.bdticketguard.m1.c
        public String a() {
            return this.f858b;
        }

        public final String c() {
            return this.f859c;
        }

        public final long d() {
            return this.f862f;
        }

        public final com.bytedance.android.sdk.bdticketguard.m1.a e() {
            return this.f861e;
        }

        public boolean equals(Object r6) {
            if (this != r6) goto L5;
        L24:
            return true;
        L5:
            if ((r6 instanceof d) == false) goto L23;
            d r7 = (d) r6;
            if (o.a(a(), r7.a()) == false) goto L23;
            if (o.a(this.f859c, r7.f859c) == false) goto L23;
            if (this.f860d != r7.f860d) goto L13;
            boolean r1 = true;
        L14:
            if (r1 == false) goto L23;
            if (o.a(this.f861e, r7.f861e) == false) goto L23;
            if (this.f862f != r7.f862f) goto L20;
            boolean r5 = true;
        L21:
            if (r5 == false) goto L23;
        L20:
            r5 = false;
            goto L21
        L13:
            r1 = false;
        L23:
            return false;
        }

        public final boolean f() {
            return this.f860d;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r2v4, types: [int] */
        /* JADX WARN: Type inference failed for: r2v6 */
        /* JADX WARN: Type inference failed for: r2v8 */
        public int hashCode() {
            String r0 = a();
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.f859c;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            boolean r7 = this.f860d;
            ?? r8 = r7;
            if (r7 == false) goto L13;
            r8 = 1;
        L13:
            int r9 = (r6 + r8) * 31;
            com.bytedance.android.sdk.bdticketguard.m1.a r10 = this.f861e;
            if (r10 == null) goto L17;
            r1 = r10.hashCode();
        L17:
            return ((r9 + r1) * 31) + Long.hashCode(this.f862f);
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "Success(adapterName=" + a() + ", attestSign=" + this.f859c + ", isCached=" + this.f860d + ", signContent=" + this.f861e + ", durationNs=" + this.f862f + ")";
        }
    }

    static {
        f855a = new a(null);
    }

    private c() {
    }

    public /* synthetic */ c(g r1) {
        this();
    }

    public abstract String a();

    public final String b() {
        boolean r0 = this instanceof d;
        u[] r2 = new u[7];
        r2[0] = a0.a("isSuccess", Boolean.valueOf(r0));
        r2[1] = a0.a("adapterName", a());
        Long r3 = null;
        if (r0 == false) goto L5;
        String r4 = ((d) this).c();
    L6:
        r2[2] = a0.a("attestSign", r4);
        if ((this instanceof b) == false) goto L9;
        String r5 = ((b) this).c().getMessage();
    L10:
        r2[3] = a0.a(WsConstants.KEY_CONNECTION_ERROR, r5);
        if (r0 == false) goto L13;
        Boolean r6 = Boolean.valueOf(((d) this).f());
    L14:
        r2[4] = a0.a("isCached", r6);
        if (r0 == false) goto L17;
        String r7 = ((d) this).e().c();
    L18:
        r2[5] = a0.a("signContent", r7);
        if (r0 == false) goto L21;
        r3 = Long.valueOf(((d) this).d());
    L21:
        r2[6] = a0.a("durationNs", r3);
        String r8 = new JSONObject(m0.k(r2)).toString();
        o.b(r8, "JSONObject(mapOf(\n      …ll)\n        )).toString()");
        return r8;
    L17:
        r7 = null;
        goto L18
    L13:
        r6 = null;
        goto L14
    L9:
        r5 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }
}
