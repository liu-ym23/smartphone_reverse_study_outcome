package com.obric.matrix.dataanalysis;

import com.bytedance.bdlocation.exception.BDLocationException;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002¨\u0006\u0003"}, d2 = {"isValidDeviceIdOrInstallId", "", "", "dataanalysis_cnRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class i {
    public static final boolean a(String r3) {
        if (r3 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return false;
    L11:
        if (o.a(r3, BDLocationException.ERROR_TIMEOUT) == false) goto L13;
        return false;
    L13:
        if (o.a(r3, "-1") == false) goto L15;
        return false;
    L15:
        return true;
    L5:
        if (r3.length() == 0) goto L8;
        r2 = false;
        goto L9
    }
}
