package com.obric.matrix.common.network;

import kotlin.Metadata;
import kotlin.u0.k;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/matrix/common/network/NetworkErrorConverter;", "", "()V", "convertThrowableMsgToBaseMonitorData", "Lcom/obric/matrix/model/BaseMonitorData;", "message", "", "common_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f8932a = null;

    static {
        f8932a = new g();
    }

    private g() {
    }

    public final com.obric.matrix.u.a a(String r4) {
        if (r4 != null) goto L5;
    L8:
        boolean r0 = true;
    L10:
        if (r0 == false) goto L13;
        return null;
    L13:
        if (k.F(r4, "-100012", false, 2, null) == true) goto L15;
        return null;
    L15:
        return new com.obric.matrix.u.a("-1", -100012, "Network is unavailable");
    L5:
        if (r4.length() == 0) goto L8;
        r0 = false;
        goto L10
    }
}
