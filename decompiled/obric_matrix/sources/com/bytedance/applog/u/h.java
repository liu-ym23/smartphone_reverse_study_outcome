package com.bytedance.applog.u;

import android.text.TextUtils;
import com.bytedance.bdlocation.client.BDLocationConfig;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class h extends a {
    h(int r1, Set<String> r2, Map<String, List<Set<String>>> r3, Map<String, List<Map<String, Object>>> r4) {
        super(r1, r2, r3, r4);
    }

    @Override // com.bytedance.applog.u.a
    boolean c(i r8) {
        int r0 = a();
        if (r0 >= 0) goto L6;
        return true;
    L6:
        if (r0 <= 0) goto L8;
        return false;
    L8:
        if (r8 != null) goto L10;
    L24:
        return false;
    L10:
        if (TextUtils.isEmpty(r8.a()) == true) goto L24;
        if (TextUtils.isEmpty(r8.b()) == true) goto L24;
        if (TextUtils.isEmpty(r8.e()) == true) goto L19;
        return !com.bytedance.applog.u.j.c.a(r8.a() + ":" + r8.e(), BDLocationConfig.sScanBleMaxInterval, this.f2398a);
    L19:
        if (TextUtils.isEmpty(r8.d()) == true) goto L24;
        if (TextUtils.isEmpty(r8.c()) == true) goto L24;
        return !com.bytedance.applog.u.j.c.a(r8.a() + ":" + (r8.d() + "_" + r8.c()), BDLocationConfig.sScanBleMaxInterval, this.f2398a);
    }
}
