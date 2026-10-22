package com.bytedance.android.sdk.bdticketguard;

import java.util.Date;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\n\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001c\u0010\r\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u0010\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0016\u001a\u00020\u00118\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/z;", "", "", "a", "Ljava/lang/String;", "getLocal_client_cert", "()Ljava/lang/String;", "local_client_cert", "b", "getLocal_public_key_ree", "local_public_key_ree", "e", "getCreate_at", "create_at", "c", "getLocal_public_key_tee", "local_public_key_tee", "", "d", "J", "getTimestamp", "()J", "timestamp", "<init>", "()V", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.google.gson.y.c("local_client_cert")
    private final String f1093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.google.gson.y.c("local_public_key_ree")
    private final String f1094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.google.gson.y.c("local_public_key_tee")
    private final String f1095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @com.google.gson.y.c("timestamp")
    private final long f1096d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @com.google.gson.y.c("create_at")
    private final String f1097e;

    public z() {
        d1 r0 = d1.f706b;
        f1 r1 = r0.a();
        String r2 = "";
        if (r1 == null) goto L9;
        String r3 = r1.m();
        if (r3 == null) goto L9;
        String r4 = p0.b(r3);
        if (r4 == null) goto L9;
    L10:
        this.f1093a = r4;
        f1 r5 = r0.a();
        if (r5 == null) goto L17;
        String r6 = r5.v();
        if (r6 == null) goto L17;
        String r7 = p0.b(r6);
        if (r7 == null) goto L17;
    L18:
        this.f1094b = r7;
        f1 r8 = r0.a();
        if (r8 == null) goto L25;
        String r9 = r8.E();
        if (r9 == null) goto L25;
        String r10 = p0.b(r9);
        if (r10 == null) goto L25;
        r2 = r10;
    L25:
        this.f1095c = r2;
        long r11 = System.currentTimeMillis();
        this.f1096d = r11;
        String r12 = p0.a().format(new Date(r11));
        kotlin.n0.d.o.b(r12, "sdf.format(Date(timestamp))");
        this.f1097e = r12;
        return;
    L17:
        r7 = "";
    L9:
        r4 = "";
        goto L10
    }
}
