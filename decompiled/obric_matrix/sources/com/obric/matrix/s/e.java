package com.obric.matrix.s;

import com.obric.matrix.w.b0;
import com.obric.matrix.w.o0;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/obric/matrix/exception/RequestBodyIsNullException;", "Lcom/obric/matrix/exception/BaseException;", "request", "Lcom/obric/matrix/proto/Request;", "(Lcom/obric/matrix/proto/Request;)V", "sdk_platform_server_api_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class e extends b {
    public e(b0 r3) {
        o.f(r3, "request");
        super(o0.f10461j.getValue(), "request is null", r3.f10196g);
    }
}
