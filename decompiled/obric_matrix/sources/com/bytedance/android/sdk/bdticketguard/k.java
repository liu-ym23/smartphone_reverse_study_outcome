package com.bytedance.android.sdk.bdticketguard;

import android.util.Pair;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001d¢\u0006\u0004\b\u001f\u0010 R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\r\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u0010\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0013\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0016\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0019\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001c\u0010\u001c\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006¨\u0006!"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/k;", "Lcom/bytedance/android/sdk/bdticketguard/z;", "", "j", "Ljava/lang/String;", "getRequest_client_cert", "()Ljava/lang/String;", "request_client_cert", "g", "getPath", "path", "m", "getRequest_version", "request_version", "k", "getRequest_ree_public_key", "request_ree_public_key", "l", "getRequest_iteration_version", "request_iteration_version", "h", "getLogid", "logid", "i", "getRequest_csr", "request_csr", "f", "getHost", "host", "Lcom/bytedance/android/sdk/bdticketguard/j0;", "responseContent", "<init>", "(Lcom/bytedance/android/sdk/bdticketguard/j0;)V", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
public class k extends z {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @com.google.gson.y.c("host")
    private final String f826f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @com.google.gson.y.c("path")
    private final String f827g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @com.google.gson.y.c("logid")
    private final String f828h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @com.google.gson.y.c("request_csr")
    private final String f829i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @com.google.gson.y.c("request_client_cert")
    private final String f830j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @com.google.gson.y.c("request_ree_public_key")
    private final String f831k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @com.google.gson.y.c("request_iteration_version")
    private final String f832l;

    @com.google.gson.y.c("request_version")
    private final String m;

    public k(j0<?> r6) {
        kotlin.n0.d.o.g(r6, "responseContent");
        k0 r0 = r6.b();
        h0 r1 = null;
        if (r0 == null) goto L5;
        g0 r2 = r0.a();
    L6:
        if (r2 == null) goto L8;
        r1 = r2.b();
    L8:
        this.f828h = r6.a();
        String r7 = "";
        if (r1 == null) goto L13;
        String r3 = r1.a();
        if (r3 == null) goto L13;
    L14:
        this.f826f = r3;
        if (r1 == null) goto L19;
        String r4 = r1.b();
        if (r4 == null) goto L19;
    L20:
        this.f827g = r4;
        LinkedHashMap r5 = new LinkedHashMap();
        if (r2 == null) goto L28;
        List<Pair<String, String>> r8 = r2.a();
        if (r8 == null) goto L28;
        Iterator<T> r9 = r8.iterator();
    L26:
        if (r9.hasNext() == false) goto L28;
        Pair r10 = (Pair) r9.next();
        Object r11 = r10.first;
        kotlin.n0.d.o.b(r11, "it.first");
        Object r12 = r10.second;
        kotlin.n0.d.o.b(r12, "it.second");
        r5.put(r11, r12);
    L28:
        String r13 = (String) r5.get("bd-ticket-guard-client-csr");
        if (r13 == null) goto L33;
        String r14 = p0.b(r13);
        if (r14 == null) goto L33;
    L34:
        this.f829i = r14;
        String r15 = (String) r5.get("bd-ticket-guard-client-cert");
        if (r15 == null) goto L39;
        String r16 = p0.b(r15);
        if (r16 == null) goto L39;
    L40:
        this.f830j = r16;
        String r17 = (String) r5.get("bd-ticket-guard-ree-public-key");
        if (r17 == null) goto L45;
        String r18 = p0.b(r17);
        if (r18 == null) goto L45;
    L46:
        this.f831k = r18;
        String r19 = (String) r5.get("bd-ticket-guard-iteration-version");
        if (r19 != null) goto L50;
        r19 = "";
    L50:
        this.f832l = r19;
        String r20 = (String) r5.get("bd-ticket-guard-version");
        if (r20 == null) goto L53;
        r7 = r20;
    L53:
        this.m = r7;
        return;
    L45:
        r18 = "";
    L39:
        r16 = "";
    L33:
        r14 = "";
    L19:
        r4 = "";
    L13:
        r3 = "";
        goto L14
    L5:
        r2 = null;
        goto L6
    }
}
