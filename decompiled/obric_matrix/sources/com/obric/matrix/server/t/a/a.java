package com.obric.matrix.server.t.a;

import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/obric/matrix/server/thirdapp/applog/BindMonitor;", "", "()V", "onBindDisconnected", "", "onBindFailed", "reason", "", "onBindSucc", "during", "", "sdk_platform_server_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10008a = null;

    static {
        f10008a = new a();
    }

    private a() {
    }

    public final void a() {
        c.f10010a.m("matrix_third_bind_disconnected", null);
    }

    public final void b(String r4) {
        o.f(r4, "reason");
        c r3 = c.f10010a;
        JSONObject r0 = new JSONObject();
        r0.put("result", 0);
        r0.put("error_msg", r4);
        f0 r5 = f0.f18324a;
        r3.m("matrix_third_bind_result", r0);
    }

    public final void c(long r4) {
        c r3 = c.f10010a;
        JSONObject r0 = new JSONObject();
        r0.put("result", 1);
        r0.put("during", r4);
        f0 r5 = f0.f18324a;
        r3.m("matrix_third_bind_result", r0);
    }
}
