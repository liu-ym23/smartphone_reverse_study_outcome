package com.obric.matrix.push.r;

import androidx.core.location.LocationRequestCompat;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007¨\u0006\b"}, d2 = {"Lcom/obric/matrix/push/utils/RandomUtils;", "", "()V", "randomUUID", "", "randomUUIDToLong", "", "random", "push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class h {
    static {
    }

    public static final long a(String r7) {
        o.f(r7, "random");
        int r0 = r7.length();
        long r1 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L6;
        r1 = (r1 * ((long) 31)) + ((long) r7.charAt(r3));
        r3 = r3 + 1;
        goto L3
    L6:
        return r1 & LocationRequestCompat.PASSIVE_INTERVAL;
    }
}
