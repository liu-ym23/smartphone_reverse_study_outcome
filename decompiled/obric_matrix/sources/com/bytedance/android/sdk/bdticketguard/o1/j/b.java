package com.bytedance.android.sdk.bdticketguard.o1.j;

import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u000f\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u001c\u0010\u0014\u001a\u00020\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u001c\u0010\u0015\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\r\u001a\u0004\b\f\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/o1/j/b;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "b", "attestSign", "Lcom/bytedance/android/sdk/bdticketguard/m1/a;", "c", "Lcom/bytedance/android/sdk/bdticketguard/m1/a;", "()Lcom/bytedance/android/sdk/bdticketguard/m1/a;", "signContent", "adapterName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/sdk/bdticketguard/m1/a;)V", "bd_ticket_guard_core_release"}, k = 1, mv = {1, 1, 15})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.google.gson.y.c("attest_sign")
    private final String f970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.google.gson.y.c("adapter_name")
    private final String f971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.google.gson.y.c("sign_content")
    private final com.bytedance.android.sdk.bdticketguard.m1.a f972c;

    public b() {
        this(null, null, null, 7, null);
    }

    public b(String r2, String r3, com.bytedance.android.sdk.bdticketguard.m1.a r4) {
        o.g(r2, "attestSign");
        o.g(r3, "adapterName");
        o.g(r4, "signContent");
        this.f970a = r2;
        this.f971b = r3;
        this.f972c = r4;
    }

    public /* synthetic */ b(String r2, String r3, com.bytedance.android.sdk.bdticketguard.m1.a r4, int r5, kotlin.n0.d.g r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = new com.bytedance.android.sdk.bdticketguard.m1.a(null, 1, null);
    L11:
        this(r2, r3, r4);
    }

    public final String a() {
        return this.f971b;
    }

    public final String b() {
        return this.f970a;
    }

    public final com.bytedance.android.sdk.bdticketguard.m1.a c() {
        return this.f972c;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L12;
        b r4 = (b) r3;
        if (o.a(this.f970a, r4.f970a) == true) goto L8;
        return false;
    L8:
        if (o.a(this.f971b, r4.f971b) == true) goto L10;
        return false;
    L10:
        if (o.a(this.f972c, r4.f972c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r0 = this.f970a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.f971b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        com.bytedance.android.sdk.bdticketguard.m1.a r7 = this.f972c;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "AttestSignCache(attestSign=" + this.f970a + ", adapterName=" + this.f971b + ", signContent=" + this.f972c + ")";
    }
}
