package com.bytedance.android.sdk.bdticketguard;

import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u000fB;\u0012\b\b\u0002\u0010 \u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b!\u0010\"J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0004R$\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0004R\u001c\u0010\u001e\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u000e\u001a\u0004\b\u001d\u0010\u0004R\u001c\u0010 \u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u001f\u0010\u0004¨\u0006#"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/g;", "Ljava/io/Serializable;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "h", "Ljava/lang/String;", "a", "attestationAdapter", "Lcom/bytedance/android/sdk/bdticketguard/g$a;", "j", "Lcom/bytedance/android/sdk/bdticketguard/g$a;", "c", "()Lcom/bytedance/android/sdk/bdticketguard/g$a;", "f", "(Lcom/bytedance/android/sdk/bdticketguard/g$a;)V", "monitorData", "i", "b", "logId", "g", "d", "reePublicKey", "e", "teePublicKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/sdk/bdticketguard/g$a;)V", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
public final class g implements Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @com.google.gson.y.c("tee_public_key")
    private final String f765f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @com.google.gson.y.c("ree_public_key")
    private final String f766g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @com.google.gson.y.c("attestation_adapter")
    private final String f767h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final transient String f768i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private transient a f769j;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f770a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f771b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final i f772c;

        public a(long r2, long r4, i r6) {
            kotlin.n0.d.o.g(r6, "snapshot");
            this.f770a = r2;
            this.f771b = r4;
            this.f772c = r6;
        }

        public final long a() {
            return this.f770a;
        }

        public final long b() {
            return this.f771b;
        }

        public final i c() {
            return this.f772c;
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L5;
        L20:
            return true;
        L5:
            if ((r8 instanceof a) == false) goto L19;
            a r9 = (a) r8;
            if (this.f770a != r9.f770a) goto L9;
            boolean r1 = true;
        L10:
            if (r1 == false) goto L19;
            if (this.f771b != r9.f771b) goto L14;
            boolean r2 = true;
        L15:
            if (r2 == false) goto L19;
            if (kotlin.n0.d.o.a(this.f772c, r9.f772c) == false) goto L19;
        L14:
            r2 = false;
            goto L15
        L9:
            r1 = false;
        L19:
            return false;
        }

        public int hashCode() {
            int r0 = ((Long.hashCode(this.f770a) * 31) + Long.hashCode(this.f771b)) * 31;
            i r3 = this.f772c;
            if (r3 == null) goto L5;
            int r4 = r3.hashCode();
        L7:
            return r0 + r4;
        L5:
            r4 = 0;
            goto L7
        }

        public String toString() {
            return "MonitorData(localAttestationTimeMs=" + this.f770a + ", remoteAttestationTimeMs=" + this.f771b + ", snapshot=" + this.f772c + ")";
        }
    }

    public g() {
        this(null, null, null, null, null, 31, null);
    }

    public g(String r2, String r3, String r4, String r5, a r6) {
        kotlin.n0.d.o.g(r2, "teePublicKey");
        kotlin.n0.d.o.g(r3, "reePublicKey");
        kotlin.n0.d.o.g(r4, "attestationAdapter");
        kotlin.n0.d.o.g(r5, "logId");
        this.f765f = r2;
        this.f766g = r3;
        this.f767h = r4;
        this.f768i = r5;
        this.f769j = r6;
    }

    public /* synthetic */ g(String r2, String r3, String r4, String r5, a r6, int r7, kotlin.n0.d.g r8) {
        if ((r7 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r7 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r7 & 4) == 0) goto L12;
        r4 = "";
    L12:
        if ((r7 & 8) == 0) goto L15;
        r5 = "";
    L15:
        if ((r7 & 16) == 0) goto L17;
        r6 = null;
    L17:
        this(r2, r3, r4, r5, r6);
    }

    public final String a() {
        return this.f767h;
    }

    public final String b() {
        return this.f768i;
    }

    public final a c() {
        return this.f769j;
    }

    public final String d() {
        return this.f766g;
    }

    public final String e() {
        return this.f765f;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof g) == false) goto L16;
        g r4 = (g) r3;
        if (kotlin.n0.d.o.a(this.f765f, r4.f765f) == true) goto L8;
        return false;
    L8:
        if (kotlin.n0.d.o.a(this.f766g, r4.f766g) == true) goto L10;
        return false;
    L10:
        if (kotlin.n0.d.o.a(this.f767h, r4.f767h) == true) goto L12;
        return false;
    L12:
        if (kotlin.n0.d.o.a(this.f768i, r4.f768i) == true) goto L14;
        return false;
    L14:
        if (kotlin.n0.d.o.a(this.f769j, r4.f769j) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final void f(a r1) {
        this.f769j = r1;
    }

    public int hashCode() {
        String r0 = this.f765f;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.f766g;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.f767h;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.f768i;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        a r13 = this.f769j;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        return r12 + r1;
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "AttestationResult(teePublicKey=" + this.f765f + ", reePublicKey=" + this.f766g + ", attestationAdapter=" + this.f767h + ", logId=" + this.f768i + ", monitorData=" + this.f769j + ")";
    }
}
