package com.obric.matrix.sdk.network;

import com.bytedance.retrofit2.client.Request;
import com.bytedance.ttnet.http.RequestContext;

/* JADX INFO: loaded from: classes3.dex */
final class TTNetRequestContextHelper {
    private TTNetRequestContextHelper() {
    }

    static RequestContext configure(Request r2, long r3, boolean r5) {
        Object r0 = r2.getExtraInfo();
        if ((r0 instanceof RequestContext) == false) goto L5;
        RequestContext r1 = (RequestContext) r0;
    L6:
        r1.timeout_connect = r3;
        r1.timeout_read = r3;
        r1.timeout_write = r3;
        r1.socket_connect_timeout = r3;
        r1.socket_read_timeout = r3;
        r1.socket_write_timeout = r3;
        if (r5 == true) goto L9;
        r1.bypassCookie = true;
    L9:
        r2.setExtraInfo(r1);
        return r1;
    L5:
        r1 = new RequestContext();
        goto L6
    }
}
