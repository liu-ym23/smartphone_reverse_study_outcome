package com.bytedance.android.sdk.bdticketguard;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/q;", "Lcom/bytedance/android/sdk/bdticketguard/k;", "", "o", "Ljava/lang/String;", "getResponse_ticket_data", "()Ljava/lang/String;", "response_ticket_data", "n", "getServer_data", "server_data", "Lcom/bytedance/android/sdk/bdticketguard/f0;", "providerResponseContent", "<init>", "(Lcom/bytedance/android/sdk/bdticketguard/f0;)V", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
public final class q extends k {

    @com.google.gson.y.c("server_data")
    private final String n;

    @com.google.gson.y.c("response_ticket_data")
    private final String o;

    public q(f0 r7) {
        kotlin.n0.d.o.g(r7, "providerResponseContent");
        super(r7);
        this.n = p0.b(r7.d());
        StringBuilder r0 = new StringBuilder();
        List<v0> r8 = r7.e();
        if (r8 == null) goto L15;
        Iterator<T> r9 = r8.iterator();
    L6:
        if (r9.hasNext() == false) goto L15;
        v0 r1 = (v0) r9.next();
        w0.a r2 = (w0.a) y0.a().m(r1.b(), w0.a.class);
        StringBuilder r3 = new StringBuilder();
        r3.append(';');
        r3.append(p0.b(r1.a()));
        r3.append(':');
        String r4 = r2.a();
        String r5 = null;
        if (r4 == null) goto L10;
        String r6 = p0.b(r4);
    L11:
        r3.append(r6);
        r3.append(':');
        String r10 = r2.b();
        if (r10 == null) goto L14;
        r5 = p0.b(r10);
    L14:
        r3.append(r5);
        r0.append(r3.toString());
        goto L6
    L10:
        r6 = null;
    L15:
        String r11 = r0.toString();
        kotlin.n0.d.o.b(r11, "sb.toString()");
        kotlin.n0.d.o.b(r11, "run {\n            val sb…  sb.toString()\n        }");
        this.o = r11;
    }
}
