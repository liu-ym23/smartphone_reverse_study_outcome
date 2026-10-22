package com.obric.matrix.server;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\bH\u0002J(\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0006J\u0016\u0010\u0011\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013¨\u0006\u0014"}, d2 = {"Lcom/obric/matrix/server/ServerMonitor;", "", "()V", "monitorInvokeAsync", "", "status", "", "category", "Lorg/json/JSONObject;", "metric", WsConstants.KEY_EXTRA, "monitorInvokeAsyncFail", "cmd", "statusCode", "exceptionMsg", "", "exceptionType", "monitorInvokeAsyncSuccess", "monitorData", "Lcom/obric/matrix/model/BaseMonitorData;", "sdk_platform_server_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f10007a = null;

    static {
        f10007a = new s();
    }

    private s() {
    }

    private final void a(int r7, JSONObject r8, JSONObject r9, JSONObject r10) {
        com.obric.matrix.q.f.a.f9854a.b("matrix_server_binder_invoke_asyn", r7, r8, r9, r10);
    }

    public final void b(int r3, int r4, String r5, int r6) {
        JSONObject r0 = new JSONObject();
        r0.put("api_cmd", r3);
        r0.put("status_code", r4);
        r0.put("exception_type", r6);
        JSONObject r7 = new JSONObject();
        r7.put("exception_msg", r5);
        a(1, r0, null, r7);
    }

    public final void c(int r4, com.obric.matrix.u.a r5) {
        kotlin.n0.d.o.f(r5, "monitorData");
        JSONObject r0 = new JSONObject();
        r0.put("api_cmd", r4);
        r0.put("server_error_code", r5.b());
        JSONObject r6 = new JSONObject();
        r6.put("server_log_id", r5.c());
        r6.put("server_description", r5.a());
        a(0, r0, null, r6);
    }
}
