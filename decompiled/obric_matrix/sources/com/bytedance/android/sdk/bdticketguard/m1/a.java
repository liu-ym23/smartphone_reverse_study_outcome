package com.bytedance.android.sdk.bdticketguard.m1;

import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.b0;
import kotlin.h;
import kotlin.i;
import kotlin.n0.d.e0;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.n0.d.y;
import kotlin.s0.l;
import kotlin.u0.d;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u000eB\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004R\u001f\u0010\u0011\u001a\u0004\u0018\u00010\r8F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u001c\u0010\u0014\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/m1/a;", "", "", "c", "()Ljava/lang/String;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "", "a", "Lkotlin/h;", "()[B", "encoded", "b", "Ljava/lang/String;", "secTs", "<init>", "(Ljava/lang/String;)V", "d", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final /* synthetic */ l[] f850c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0029a f851d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h f852a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.google.gson.y.c("sec_ts")
    private final String f853b;

    /* JADX INFO: renamed from: com.bytedance.android.sdk.bdticketguard.m1.a$a, reason: collision with other inner class name */
    public static final class C0029a {
        private C0029a() {
        }

        public /* synthetic */ C0029a(g r1) {
            this();
        }

        public final a a(String r1) {
            o.g(r1, "serialized");
            return new a(r1);
        }
    }

    static final class b extends q implements kotlin.n0.c.a<byte[]> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f854f;

        b(a r1) {
            this.f854f = r1;
            super(0);
        }

        public final byte[] a() {
            String r2 = "sec_ts=" + this.f854f.b();
            Charset r0 = d.f21429a;
            if (r2 == null) goto L7;
            byte[] r3 = r2.getBytes(r0);
            o.b(r3, "(this as java.lang.String).getBytes(charset)");
            return com.bytedance.android.sdk.bdticketguard.m1.b.a(r3);
        L7:
            throw new b0("null cannot be cast to non-null type java.lang.String");
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ byte[] invoke() {
            return a();
        }
    }

    static {
        f850c = new l[]{e0.g(new y(e0.b(a.class), "encoded", "getEncoded()[B"))};
        f851d = new C0029a(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public a(String r2) {
        o.g(r2, "secTs");
        this.f853b = r2;
        this.f852a = i.b(new b(this));
    }

    public /* synthetic */ a(String r1, int r2, g r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = "";
    L5:
        this(r1);
    }

    public final byte[] a() {
        h r2 = this.f852a;
        l r0 = f850c[0];
        return (byte[]) r2.getValue();
    }

    public final String b() {
        return this.f853b;
    }

    public final String c() {
        return this.f853b;
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L6;
        return true;
    L6:
        if ((r2 instanceof a) == true) goto L10;
        return false;
    L10:
        return o.a(this.f853b, ((a) r2).f853b);
    }

    public int hashCode() {
        return this.f853b.hashCode();
    }

    public String toString() {
        return "AttestSignContent(secTs=" + this.f853b + ")";
    }
}
