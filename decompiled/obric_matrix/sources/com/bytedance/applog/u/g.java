package com.bytedance.applog.u;

import android.text.TextUtils;
import com.bytedance.bdlocation.client.BDLocationConfig;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class g extends a {
    g(int r1, Set<String> r2, Map<String, List<Set<String>>> r3, Map<String, List<Map<String, Object>>> r4) {
        super(r1, r2, r3, r4);
    }

    @Override // com.bytedance.applog.u.a
    boolean c(i r7) {
        int r0 = a();
        if (r0 >= 0) goto L6;
        return true;
    L6:
        if (r0 <= 0) goto L8;
        return false;
    L8:
        if (r7 != null) goto L10;
    L16:
        return false;
    L10:
        if (TextUtils.isEmpty(r7.a()) == true) goto L16;
        if (TextUtils.isEmpty(r7.b()) == true) goto L16;
        return !com.bytedance.applog.u.j.c.a(r7.a() + ":" + r7.b(), BDLocationConfig.sScanBleMaxInterval, this.f2398a);
    }
}
