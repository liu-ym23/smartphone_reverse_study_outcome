package com.obric.matrix.opush.base.network;

import android.util.Pair;
import com.bytedance.common.utility.g;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.matrix.common_api.INetworkApi;
import d.b.r.d0;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.n0.d.o;
import p000j.e0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J0\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J3\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\t2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J(\u0010\u0015\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\t2\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000eH\u0016J0\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0014\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J8\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J<\u0010\u0015\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016JN\u0010\u0015\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\t2\u001a\u0010\u001c\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001e\u0018\u00010\u001d2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/matrix/opush/base/network/TTNetWorkService;", "Lcom/obric/matrix/opush/base/network/INetworkService;", "Lcom/bytedance/common/utility/NetworkClient;", "()V", "REQUEST_CONNECT_TIMEOUT", "", "REQUEST_READ_TIMEOUT", "REQUEST_WRITE_TIMEOUT", "TAG", "", "get", "", WsConstants.KEY_CONNECTION_URL, "headers", "", "iRequestCallback", "Lcom/obric/matrix/opush/base/network/IRequestCallback;", "requestHeaders", "", "ctx", "Lcom/bytedance/common/utility/NetworkClient$ReqContext;", "post", "form", "", "bodyJson", "Lokhttp3/RequestBody;", "data", "", "params", "", "Landroid/util/Pair;", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class e extends g implements a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e f9238b = null;

    static {
        f9238b = new e();
    }

    private e() {
    }

    @Override // com.obric.matrix.opush.base.network.a
    public void a(String r6, e0 r7, Map<String, String> r8, b r9) {
        o.f(r6, WsConstants.KEY_CONNECTION_URL);
        o.f(r7, "bodyJson");
        ITTNetworkService r5 = (ITTNetworkService) com.bytedance.ttnet.s.d.h(r6).e(ITTNetworkService.class);
        com.bytedance.ttnet.m.d r10 = new com.bytedance.ttnet.m.d();
        TimeUnit r0 = TimeUnit.SECONDS;
        r10.f13368c = r0.toMillis(15);
        r10.f13370e = r0.toMillis(15);
        r10.f13369d = r0.toMillis(15);
        d.b.r.b<String> r11 = r5.postCall(r7, r8, r10);     // Catch: Throwable -> L18
        if (r11 != null) goto L8;
        if (r9 == null) goto L24;
        r9.onResult(101, "call is null");     // Catch: Throwable -> L18
        return;
    L24:
        return;
    L8:
        d0<String> r12 = r11.execute();     // Catch: Throwable -> L18
        if (r12 == null) goto L11;
        String r13 = r12.a();     // Catch: Throwable -> L18
    L12:
        if (r9 == null) goto L25;
        if (r13 == null) goto L15;
        int r14 = 0;
    L16:
        r9.onResult(r14, r13);     // Catch: Throwable -> L18
        return;
    L15:
        r14 = 101;
        goto L16
    L25:
        return;
    L11:
        r13 = null;
    L18:
        th = move-exception;
        com.obric.matrix.opush.c.f9247a.d("TTNetWorkService", "post: ", th);
        if (r9 == null) goto L26;
        r9.onResult(101, "req exception, " + th);
        return;
    }

    @Override // com.bytedance.common.utility.g
    public String e(String r1, Map<String, String> r2, g.a r3) {
        return "";
    }

    @Override // com.bytedance.common.utility.g
    public String g(String r1, List<Pair<String, String>> r2, Map<String, String> r3, g.a r4) {
        return "";
    }

    @Override // com.bytedance.common.utility.g
    public String h(String r6, byte[] r7, Map<String, String> r8, g.a r9) {
        ITTNetworkService r5 = (ITTNetworkService) com.bytedance.ttnet.s.d.h(r6).e(ITTNetworkService.class);
        com.bytedance.ttnet.m.d r10 = new com.bytedance.ttnet.m.d();
        TimeUnit r0 = TimeUnit.SECONDS;
        r10.f13368c = r0.toMillis(15);
        r10.f13370e = r0.toMillis(15);
        r10.f13369d = r0.toMillis(15);
        if (r8 == null) goto L5;
        String r1 = r8.get(INetworkApi.CONTENT_TYPE);
    L6:
        boolean r2 = false;
        d.b.r.k0.g r3 = new d.b.r.k0.g(r1, r7, new String[0]);
        if (r9 != null) goto L23;
    L11:
        d.b.r.b<String> r11 = r5.postCall(r3, r8, r2, r10);     // Catch: Throwable -> L9
        if (r11 != null) goto L14;
        return "";
    L14:
        d0<String> r12 = r11.execute();     // Catch: Throwable -> L9
        if (r12 == null) goto L25;
        String r13 = r12.a();     // Catch: Throwable -> L9
        if (r13 != null) goto L20;
        return "";
    L20:
        return r13;
    L9:
        th = move-exception;
        com.obric.matrix.opush.c.f9247a.d("", "", th);
        return "";
    L25:
        return "";
    L23:
        r2 = r9.f3274a;     // Catch: Throwable -> L9
        goto L11
    L5:
        r1 = null;
        goto L6
    }
}
