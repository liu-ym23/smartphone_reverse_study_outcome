package com.bytedance.android.sdk.bdticketguard;

import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\r\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u0010\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0013\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001c\u0010\u0016\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0019\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001c\u0010\u001c\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u001c\u0010\u001f\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u001c\u0010\"\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006R\u001c\u0010%\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006¨\u0006*"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/l1;", "Lcom/bytedance/android/sdk/bdticketguard/k;", "", "u", "Ljava/lang/String;", "getRequest_client_data_req_sign_ree", "()Ljava/lang/String;", "request_client_data_req_sign_ree", "w", "getRequest_client_data_ts_sign", "request_client_data_ts_sign", "p", "getTicket_name", "ticket_name", "r", "getRequest_client_data", "request_client_data", "t", "getRequest_client_data_req_sign", "request_client_data_req_sign", BaseSwitches.V, "getRequest_client_data_timestamp", "request_client_data_timestamp", "x", "getRequest_client_data_ts_sign_ree", "request_client_data_ts_sign_ree", "n", "getLocal_error", "local_error", "s", "getRequest_client_data_req_content", "request_client_data_req_content", "q", "getTicket", "ticket", "o", "getRemote_error", "remote_error", "Lcom/bytedance/android/sdk/bdticketguard/o;", "consumerResponseContent", "<init>", "(Lcom/bytedance/android/sdk/bdticketguard/o;)V", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
public final class l1 extends k {

    @com.google.gson.y.c("local_error")
    private final String n;

    @com.google.gson.y.c("remote_error")
    private final String o;

    @com.google.gson.y.c("ticket_name")
    private final String p;

    @com.google.gson.y.c("ticket")
    private final String q;

    @com.google.gson.y.c("request_client_data")
    private final String r;

    @com.google.gson.y.c("request_client_data_req_content")
    private final String s;

    @com.google.gson.y.c("request_client_data_req_sign")
    private final String t;

    @com.google.gson.y.c("request_client_data_req_sign_ree")
    private final String u;

    @com.google.gson.y.c("request_client_data_timestamp")
    private final String v;

    @com.google.gson.y.c("request_client_data_ts_sign")
    private final String w;

    @com.google.gson.y.c("request_client_data_ts_sign_ree")
    private final String x;

    public l1(o r5) {
        kotlin.n0.d.o.g(r5, "consumerResponseContent");
        super(r5);
        this.o = r5.d();
        r r6 = r5.b();
        Long r0 = null;
        if (r6 == null) goto L5;
        l r7 = r6.a();
    L6:
        String r1 = "";
        if (r7 == null) goto L11;
        String r2 = r7.f();
        if (r2 == null) goto L11;
    L12:
        this.n = r2;
        if (r7 == null) goto L15;
        m r3 = r7.b();
    L16:
        if (r3 == null) goto L22;
        String r4 = r3.i();
        if (r4 == null) goto L22;
        String r8 = p0.b(r4);
        if (r8 == null) goto L22;
    L23:
        this.q = r8;
        if (r3 == null) goto L28;
        String r9 = r3.j();
        if (r9 == null) goto L28;
    L29:
        this.p = r9;
        this.r = p0.b(r7.e());
        if (r7 == null) goto L32;
        j r10 = r7.d();
    L33:
        this.s = r10.a();
        if (r10 == null) goto L40;
        String r11 = r10.b();
        if (r11 == null) goto L40;
        String r12 = p0.b(r11);
        if (r12 == null) goto L40;
    L41:
        this.t = r12;
        if (r10 == null) goto L48;
        String r13 = r10.c();
        if (r13 == null) goto L48;
        String r14 = p0.b(r13);
        if (r14 == null) goto L48;
    L49:
        this.u = r14;
        if (r10 == null) goto L52;
        r0 = Long.valueOf(r10.d());
    L52:
        String r15 = String.valueOf(r0.longValue());
        if (r15 != null) goto L56;
        r15 = "";
    L56:
        this.v = r15;
        if (r10 == null) goto L63;
        String r16 = r10.e();
        if (r16 == null) goto L63;
        String r17 = p0.b(r16);
        if (r17 == null) goto L63;
    L64:
        this.w = r17;
        if (r10 == null) goto L71;
        String r18 = r10.f();
        if (r18 == null) goto L71;
        String r19 = p0.b(r18);
        if (r19 == null) goto L71;
        r1 = r19;
    L71:
        this.x = r1;
        return;
    L63:
        r17 = "";
    L48:
        r14 = "";
    L40:
        r12 = "";
        goto L41
    L32:
        r10 = null;
    L28:
        r9 = "";
    L22:
        r8 = "";
        goto L23
    L15:
        r3 = null;
    L11:
        r2 = "";
        goto L12
    L5:
        r7 = null;
        goto L6
    }
}
