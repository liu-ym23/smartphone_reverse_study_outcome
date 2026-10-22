package com.bytedance.sdk.account.settings.f;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import kotlin.h;
import kotlin.i;
import kotlin.n0.d.e0;
import kotlin.n0.d.q;
import kotlin.n0.d.y;
import kotlin.s0.l;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ l[] f5747a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final h f5748b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f5749c = null;

    static final class a extends q implements kotlin.n0.c.a<JSONObject> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f5750f = null;

        static {
            f5750f = new a();
        }

        a() {
            super(0);
        }

        public final JSONObject a() {
            JSONObject r6 = new JSONObject();
            r6.put(String.valueOf(2054), new JSONObject().put(WsConstants.KEY_CONNECTION_TYPE, 1));
            r6.put(String.valueOf(2068), new JSONObject().put(WsConstants.KEY_CONNECTION_TYPE, 1));
            r6.put(String.valueOf(2171), new JSONObject().put(WsConstants.KEY_CONNECTION_TYPE, 1));
            r6.put(String.valueOf(2172), new JSONObject().put(WsConstants.KEY_CONNECTION_TYPE, 1));
            r6.put(String.valueOf(2173), new JSONObject().put(WsConstants.KEY_CONNECTION_TYPE, 1));
            r6.put(String.valueOf(2105), new JSONObject().put(WsConstants.KEY_CONNECTION_TYPE, 1));
            r6.put(String.valueOf(2157), new JSONObject().put(WsConstants.KEY_CONNECTION_TYPE, 1));
            r6.put(String.valueOf(1049), new JSONObject().put(WsConstants.KEY_CONNECTION_TYPE, 4).put(LocationMonitorConst.INFO, "force_update"));
            r6.put(String.valueOf(7), new JSONObject().put(WsConstants.KEY_CONNECTION_TYPE, 2));
            r6.put(String.valueOf(2156), new JSONObject().put(WsConstants.KEY_CONNECTION_TYPE, 2));
            r6.put(String.valueOf(2055), new JSONObject().put(WsConstants.KEY_CONNECTION_TYPE, 2));
            r6.put(String.valueOf(1454), new JSONObject().put(WsConstants.KEY_CONNECTION_TYPE, 4).put(LocationMonitorConst.INFO, "multi_account_choose"));
            r6.put(String.valueOf(1091), new JSONObject().put(WsConstants.KEY_CONNECTION_TYPE, 4).put(LocationMonitorConst.INFO, "login_account_suspension"));
            r6.put(String.valueOf(1093), new JSONObject().put(WsConstants.KEY_CONNECTION_TYPE, 4).put(LocationMonitorConst.INFO, "login_device_suspension"));
            r6.put(String.valueOf(2028), new JSONObject().put(WsConstants.KEY_CONNECTION_TYPE, 4).put(LocationMonitorConst.INFO, "account_lock"));
            r6.put(String.valueOf(2015), new JSONObject().put(WsConstants.KEY_CONNECTION_TYPE, 4).put(LocationMonitorConst.INFO, "voice_dialog"));
            r6.put(String.valueOf(1039), new JSONObject().put(WsConstants.KEY_CONNECTION_TYPE, 4).put(LocationMonitorConst.INFO, "sms_verify_dialog"));
            return r6;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ JSONObject invoke() {
            return a();
        }
    }

    static {
        f5747a = new l[]{e0.g(new y(e0.b(b.class), "defaultErrorCodeTransfer", "getDefaultErrorCodeTransfer()Lorg/json/JSONObject;"))};
        f5749c = new b();
        f5748b = i.b(a.f5750f);
    }

    private b() {
    }

    private final JSONObject a() {
        h r2 = f5748b;
        l r0 = f5747a[0];
        return (JSONObject) r2.getValue();
    }

    public static final d.b.s.a.e0.a b(int r6) {
        JSONObject r0 = com.bytedance.sdk.account.settings.f.a.d();
        if (r0 == null) goto L5;
        JSONObject r1 = r0.optJSONObject(String.valueOf(r6));
    L7:
        if (r1 != null) goto L13;
        JSONObject r2 = f5749c.a().optJSONObject(String.valueOf(r6));
        if (r2 != null) goto L12;
        return null;
    L12:
        return new d.b.s.a.e0.a(r6, r2.optInt(WsConstants.KEY_CONNECTION_TYPE), r2.optString(LocationMonitorConst.INFO), r2.optString("detail"));
    L13:
        return new d.b.s.a.e0.a(r6, r1.optInt(WsConstants.KEY_CONNECTION_TYPE), r1.optString(LocationMonitorConst.INFO), r1.optString("detail"));
    L5:
        r1 = null;
        goto L7
    }
}
