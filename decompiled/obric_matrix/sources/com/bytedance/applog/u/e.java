package com.bytedance.applog.u;

import android.text.TextUtils;
import com.bytedance.bdlocation.client.BDLocationConfig;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class e extends a {
    e(int r1, Set<String> r2, Map<String, List<Set<String>>> r3, Map<String, List<Map<String, Object>>> r4) {
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
    L18:
        return false;
    L10:
        if (TextUtils.isEmpty(r8.b()) == true) goto L18;
        if ((Long.parseLong(r8.b()) % BDLocationConfig.sScanBleMaxInterval) < this.f2398a) goto L17;
        return true;
    L17:
        return false;
    }
}
