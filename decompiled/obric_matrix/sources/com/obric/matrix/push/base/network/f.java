package com.obric.matrix.push.base.network;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.matrix.common_api.INetworkApi;
import com.obric.matrix.push.r.j;
import d.b.r.d0;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.a0;
import kotlin.f0;
import kotlin.i0.m0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.u;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J0\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J3\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\t2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J$\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J(\u0010\u0015\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\t2\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u000eH\u0016J0\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J<\u0010\u0015\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016JN\u0010\u0015\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\t2\u001a\u0010\u001b\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001d\u0018\u00010\u001c2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/matrix/push/base/network/TTNetWorkService;", "Lcom/obric/matrix/push/base/network/INetworkService;", "Lcom/bytedance/common/utility/NetworkClient;", "()V", "REQUEST_CONNECT_TIMEOUT", "", "REQUEST_READ_TIMEOUT", "REQUEST_WRITE_TIMEOUT", "TAG", "", "get", "", WsConstants.KEY_CONNECTION_URL, "headers", "", "iRequestCallback", "Lcom/obric/matrix/push/base/network/IRequestCallback;", "requestHeaders", "", "ctx", "Lcom/bytedance/common/utility/NetworkClient$ReqContext;", "post", "bodyJson", "form", "", "data", "", "params", "", "Landroid/util/Pair;", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class f extends com.bytedance.common.utility.g implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f9511b = null;

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends q implements kotlin.n0.c.a<f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d.b.r.b<String> f9512f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f9513g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ c f9514h;

        a(d.b.r.b<String> r1, String r2, c r3) {
            this.f9512f = r1;
            this.f9513g = r2;
            this.f9514h = r3;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ f0 invoke() {
            invoke2();
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            d0<String> r0 = this.f9512f.execute();
            StringBuilder r1 = new StringBuilder();
            r1.append("req url = ");
            r1.append(this.f9513g);
            r1.append(", resp header = ");
            String r2 = null;
            if (r0 == null) goto L5;
            List<d.b.r.h0.b> r3 = r0.d();
        L6:
            r1.append(r3);
            r1.append(", body = ");
            if (r0 == null) goto L9;
            String r4 = r0.a();
        L10:
            r1.append(r4);
            com.obric.matrix.r.c.e.d("TTNetWorkService", r1.toString());
            c r5 = this.f9514h;
            if (r5 == null) goto L19;
            if (r0 == null) goto L14;
            int r6 = 0;
        L15:
            if (r0 == null) goto L17;
            r2 = r0.a();
        L17:
            r5.onResult(r6, r2);
            return;
        L14:
            r6 = 101;
            goto L15
        L19:
            return;
        L9:
            r4 = null;
            goto L10
        L5:
            r3 = null;
            goto L6
        }
    }

    static {
        f9511b = new f();
    }

    private f() {
    }

    @Override // com.obric.matrix.push.base.network.b
    public String b(String r6, Map<String, ? extends Object> r7) {
        o.f(r6, WsConstants.KEY_CONNECTION_URL);
        ITTNetworkService r5 = (ITTNetworkService) com.bytedance.ttnet.s.d.h(r6).e(ITTNetworkService.class);
        com.bytedance.ttnet.m.d r8 = new com.bytedance.ttnet.m.d();
        TimeUnit r0 = TimeUnit.SECONDS;
        r8.f13368c = r0.toMillis(15);
        r8.f13370e = r0.toMillis(15);
        r8.f13369d = r0.toMillis(15);
        if (r7 != null) goto L26;
    L10:
        boolean r3 = true;
    L11:
        if (r3 == false) goto L13;
        return null;
    L13:
        String r9 = com.obric.matrix.push.r.f.f9795a.a(new JSONObject(r7).toString());     // Catch: Throwable -> L8
        if (r9 != null) goto L17;
        r9 = "";
    L17:
        if (TextUtils.isEmpty(r9) == false) goto L19;
        return null;
    L19:
        d.b.r.b<String> r10 = r5.postCall(m0.l(new u[]{a0.a("data", r9)}), r8);     // Catch: Throwable -> L8
        if (r10 != null) goto L22;
        return null;
    L22:
        return r10.execute().a();
    L8:
        th = move-exception;
        com.obric.matrix.push.n.c.c.d("TTNetWorkService", "post: ", th);
        return null;
    L26:
        if (r7.isEmpty() == true) goto L10;
        r3 = false;
        goto L11
    }

    @Override // com.obric.matrix.push.base.network.b
    public void c(String r7, Map<String, ? extends Object> r8, c r9) {
        o.f(r7, WsConstants.KEY_CONNECTION_URL);
        ITTNetworkService r6 = (ITTNetworkService) com.bytedance.ttnet.s.d.h(r7).e(ITTNetworkService.class);
        com.bytedance.ttnet.m.d r0 = new com.bytedance.ttnet.m.d();
        TimeUnit r1 = TimeUnit.SECONDS;
        r0.f13368c = r1.toMillis(15);
        r0.f13370e = r1.toMillis(15);
        r0.f13369d = r1.toMillis(15);
        if (r8 != null) goto L34;
    L10:
        boolean r4 = true;
    L11:
        if (r4 == false) goto L15;
        if (r9 == null) goto L35;
        r9.onResult(101, "req body is null");     // Catch: Throwable -> L8
        return;
    L35:
        return;
    L15:
        String r10 = com.obric.matrix.push.r.f.f9795a.a(new JSONObject(r8).toString());     // Catch: Throwable -> L8
        if (r10 != null) goto L19;
        r10 = "";
    L19:
        if (TextUtils.isEmpty(r10) == false) goto L23;
        if (r9 == null) goto L36;
        r9.onResult(101, "push service handler err");     // Catch: Throwable -> L8
        return;
    L36:
        return;
    L23:
        d.b.r.b<String> r11 = r6.postCall(m0.l(new u[]{a0.a("data", r10)}), r0);     // Catch: Throwable -> L8
        if (r11 != null) goto L28;
        if (r9 == null) goto L37;
        r9.onResult(101, "call is null");     // Catch: Throwable -> L8
        return;
    L37:
        return;
    L28:
        j.f9798a.j(new a(r11, r7, r9));     // Catch: Throwable -> L8
        return;
    L34:
    L8:
        th = move-exception;
        if (r9 == null) goto L32;
        r9.onResult(101, "req exception, " + th);
    L32:
        com.obric.matrix.push.n.c.c.d("TTNetWorkService", "post: ", th);
        return;
    L5:
        if (r8.isEmpty() == true) goto L10;
        r4 = false;
        goto L11
    }

    @Override // com.bytedance.common.utility.g
    public String e(String r1, Map<String, String> r2, com.bytedance.common.utility.g.a r3) {
        return "";
    }

    @Override // com.bytedance.common.utility.g
    public String g(String r1, List<Pair<String, String>> r2, Map<String, String> r3, com.bytedance.common.utility.g.a r4) {
        return "";
    }

    @Override // com.bytedance.common.utility.g
    public String h(String r6, byte[] r7, Map<String, String> r8, com.bytedance.common.utility.g.a r9) {
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
        com.obric.matrix.push.n.c.c.d("", "", th);
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
