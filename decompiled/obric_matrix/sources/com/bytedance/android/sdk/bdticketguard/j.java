package com.bytedance.android.sdk.bdticketguard;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\f\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006R\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u0011\u0010\bR\u0019\u0010\u0013\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\u001c\u0010\u001a\u001a\u00020\u00178\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0018\u001a\u0004\b\u0003\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/j;", "", "", "d", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "i", "(Ljava/lang/String;)V", "tsSign", "a", "getRequestContent", "requestContent", "f", "b", "g", "requestSign", "j", "tsSignRee", "requestContentText", "c", "h", "requestSignRee", "", "J", "()J", "timestamp", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.google.gson.y.c("req_content")
    private final String f817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final transient String f818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.google.gson.y.c("timestamp")
    private final long f819c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @com.google.gson.y.c("ts_sign")
    private String f820d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @com.google.gson.y.c("ts_sign_ree")
    private String f821e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @com.google.gson.y.c("req_sign")
    private String f822f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @com.google.gson.y.c("req_sign_ree")
    private String f823g;

    public j(String r2, String r3, long r4, String r6, String r7, String r8, String r9) {
        kotlin.n0.d.o.g(r2, "requestContent");
        kotlin.n0.d.o.g(r3, "requestContentText");
        kotlin.n0.d.o.g(r6, "tsSign");
        kotlin.n0.d.o.g(r7, "tsSignRee");
        kotlin.n0.d.o.g(r8, "requestSign");
        kotlin.n0.d.o.g(r9, "requestSignRee");
        this.f817a = r2;
        this.f818b = r3;
        this.f819c = r4;
        this.f820d = r6;
        this.f821e = r7;
        this.f822f = r8;
        this.f823g = r9;
    }

    public /* synthetic */ j(String r12, String r13, long r14, String r16, String r17, String r18, String r19, int r20, kotlin.n0.d.g r21) {
        if ((r20 & 8) == 0) goto L5;
        String r7 = "";
    L7:
        if ((r20 & 16) == 0) goto L9;
        String r8 = "";
    L11:
        if ((r20 & 32) == 0) goto L13;
        String r9 = "";
    L15:
        if ((r20 & 64) == 0) goto L17;
        String r10 = "";
    L18:
        this(r12, r13, r14, r7, r8, r9, r10);
        return;
    L17:
        r10 = r19;
        goto L18
    L13:
        r9 = r18;
        goto L15
    L9:
        r8 = r17;
        goto L11
    L5:
        r7 = r16;
        goto L7
    }

    public final String a() {
        return this.f818b;
    }

    public final String b() {
        return this.f822f;
    }

    public final String c() {
        return this.f823g;
    }

    public final long d() {
        return this.f819c;
    }

    public final String e() {
        return this.f820d;
    }

    public final String f() {
        return this.f821e;
    }

    public final void g(String r2) {
        kotlin.n0.d.o.g(r2, "<set-?>");
        this.f822f = r2;
    }

    public final void h(String r2) {
        kotlin.n0.d.o.g(r2, "<set-?>");
        this.f823g = r2;
    }

    public final void i(String r2) {
        kotlin.n0.d.o.g(r2, "<set-?>");
        this.f820d = r2;
    }

    public final void j(String r2) {
        kotlin.n0.d.o.g(r2, "<set-?>");
        this.f821e = r2;
    }
}
