package com.obric.matrix.s;

import com.obric.matrix.w.b0;
import com.obric.matrix.w.o0;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/matrix/exception/IllegalRequestParamException;", "Lcom/obric/matrix/exception/BaseException;", "request", "Lcom/obric/matrix/proto/Request;", "errorMessage", "", "(Lcom/obric/matrix/proto/Request;Ljava/lang/String;)V", "sdk_platform_server_api_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class d extends b {
    public d(b0 r2, String r3) {
        o.f(r3, "errorMessage");
        int r0 = o0.o.getValue();
        if (r2 == null) goto L5;
        String r4 = r2.f10196g;
    L6:
        if (r4 != null) goto L8;
        r4 = "";
    L8:
        super(r0, r3, r4);
        return;
    L5:
        r4 = null;
        goto L6
    }
}
