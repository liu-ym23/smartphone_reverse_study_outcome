package com.obric.matrix.launch.bdtracker;

import com.bytedance.bdinstall.d0;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ttnet.s.d;
import com.obric.matrix.common_api.INetworkApi;
import com.obric.matrix.r.c.c;
import d.b.r.k0.g;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u0096\u0002J&\u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0016J2\u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u0016J.\u0010\b\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u001a\u0010\r\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000f\u0018\u00010\u000eH\u0016J2\u0010\u0010\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u0016¨\u0006\u0011"}, d2 = {"Lcom/obric/matrix/launch/bdtracker/BDTrackerTTNetWorkService;", "Lcom/bytedance/bdinstall/INetworkClient;", "()V", "get", "", WsConstants.KEY_CONNECTION_URL, "headers", "", "post", "data", "", "contentType", "requestHeaders", "list", "", "Landroid/util/Pair;", "postStream", "app_launch_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f9119a = null;

    static {
        f9119a = new b();
    }

    private b() {
    }

    @Override // com.bytedance.bdinstall.d0
    public String a(String r5, byte[] r6, Map<String, String> r7) {
        ITTNetworkService r8 = (ITTNetworkService) d.h(r5).e(ITTNetworkService.class);
        com.bytedance.ttnet.m.d r0 = new com.bytedance.ttnet.m.d();
        if (r7 == null) goto L5;
        String r1 = r7.get(INetworkApi.CONTENT_TYPE);
    L20:
        d.b.r.b<String> r9 = r8.postCall(new g(r1, r6, new String[0]), r7, r0);     // Catch: Throwable -> L17
        if (r9 != null) goto L10;
        return "";
    L10:
        d.b.r.d0<String> r10 = r9.execute();     // Catch: Throwable -> L17
        if (r10 == null) goto L22;
        String r11 = r10.a();     // Catch: Throwable -> L17
        if (r11 != null) goto L16;
        return "";
    L16:
        return r11;
    L22:
        return "";
    L17:
        th = move-exception;
        c.g("BDTrackerTTNetWorkService", "post with exception", th);
        return "";
    L5:
        r1 = null;
        goto L20
    }

    @Override // com.bytedance.bdinstall.d0
    public byte[] b(String r5, byte[] r6, Map<String, String> r7) {
        ITTNetworkService r4 = (ITTNetworkService) d.h(r5).e(ITTNetworkService.class);
        com.bytedance.ttnet.m.d r8 = new com.bytedance.ttnet.m.d();
        if (r7 == null) goto L5;
        String r0 = r7.get(INetworkApi.CONTENT_TYPE);
    L20:
        d.b.r.b<byte[]> r9 = r4.postCallWithByteArray(new g(r0, r6, new String[0]), r7, r8);     // Catch: Throwable -> L17
        if (r9 == null) goto L10;
        d.b.r.d0<byte[]> r10 = r9.execute();     // Catch: Throwable -> L17
        if (r10 == null) goto L16;
        byte[] r11 = r10.a();     // Catch: Throwable -> L17
        if (r11 == null) goto L16;
        return r11;
    L16:
        return new byte[0];
    L10:
        return new byte[0];
    L17:
        th = move-exception;
        c.g("BDTrackerTTNetWorkService", "postStream with exception", th);
        return new byte[0];
    L5:
        r0 = null;
        goto L20
    }

    @Override // com.bytedance.bdinstall.d0
    public String get(String r4, Map<String, String> r5) {
        ITTNetworkService r0 = (ITTNetworkService) d.h(r4).e(ITTNetworkService.class);
        com.bytedance.ttnet.m.d r1 = new com.bytedance.ttnet.m.d();
        if (r5 == null) goto L5;
        new JSONObject(r5);
    L5:
        String r6 = null;
        d.b.r.b<String> r7 = r0.getCall(r4, null, r1);     // Catch: Throwable -> L15
        if (r7 == null) goto L11;
        d.b.r.d0<String> r8 = r7.execute();     // Catch: Throwable -> L15
        if (r8 == null) goto L11;
        r6 = r8.a();     // Catch: Throwable -> L15
    L11:
        if (r6 != null) goto L14;
        return "";
    L14:
        return r6;
    L15:
        th = move-exception;
        c.g("TTNetWorkService", "get: ", th);
        return "";
    }
}
