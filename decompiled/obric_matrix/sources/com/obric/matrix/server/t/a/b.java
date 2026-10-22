package com.obric.matrix.server.t.a;

import android.content.Context;
import com.bytedance.bdinstall.d0;
import com.bytedance.bdinstall.m0;
import com.bytedance.bdinstall.n;
import com.bytedance.common.wschannel.WsConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J+\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\rH\u0096\u0002J(\u0010\u000e\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\nH\u0016J4\u0010\u000e\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\rH\u0016J0\u0010\u000e\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u001a\u0010\u0012\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0014\u0018\u00010\u0013H\u0016J4\u0010\u0015\u001a\u0004\u0018\u00010\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\rH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/obric/matrix/server/thirdapp/applog/NetWorkHelper;", "Lcom/bytedance/bdinstall/INetworkClient;", "()V", "defaultClient", "Lcom/bytedance/bdinstall/DefaultClient;", "getDefaultClient", "()Lcom/bytedance/bdinstall/DefaultClient;", "setDefaultClient", "(Lcom/bytedance/bdinstall/DefaultClient;)V", "get", "", WsConstants.KEY_CONNECTION_URL, "requestHeaders", "", "post", "data", "", "contentType", "params", "", "Landroid/util/Pair;", "postStream", "sdk_platform_server_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private n f10009a;

    public b() {
        this.f10009a = new n();
    }

    @Override // com.bytedance.bdinstall.d0
    public String a(String r4, byte[] r5, Map<String, String> r6) {
        Context r0 = c.f10010a.f();
        o.c(r0);
        String r1 = com.bytedance.applog.a.b(r0, r4, true, m0.f2843g);
        if (r1 == null) goto L7;
        r4 = r1;
    L7:
        return this.f10009a.a(r4, r5, r6);
    }

    @Override // com.bytedance.bdinstall.d0
    public byte[] b(String r4, byte[] r5, Map<String, String> r6) {
        Context r0 = c.f10010a.f();
        o.c(r0);
        String r1 = com.bytedance.applog.a.b(r0, r4, true, m0.f2843g);
        if (r1 == null) goto L7;
        r4 = r1;
    L7:
        return this.f10009a.b(r4, r5, r6);
    }

    @Override // com.bytedance.bdinstall.d0
    public String get(String r4, Map<String, String> r5) {
        Context r0 = c.f10010a.f();
        o.c(r0);
        String r1 = com.bytedance.applog.a.b(r0, r4, true, m0.f2843g);
        if (r1 == null) goto L7;
        r4 = r1;
    L7:
        return this.f10009a.get(r4, r5);
    }
}
