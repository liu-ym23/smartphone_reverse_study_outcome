package com.bytedance.applog.u;

import com.bytedance.keva.KevaImpl;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class f extends a {
    f(int r1, Set<String> r2, Map<String, List<Set<String>>> r3, Map<String, List<Map<String, Object>>> r4) {
        super(r1, r2, r3, r4);
    }

    @Override // com.bytedance.applog.u.a
    boolean c(i r4) {
        int r5 = a();
        if (r5 >= 0) goto L6;
        return true;
    L6:
        if (r5 <= 0) goto L9;
        return false;
    L9:
        if (new Random().nextInt(KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD) < this.f2398a) goto L12;
        return true;
    L12:
        return false;
    }
}
