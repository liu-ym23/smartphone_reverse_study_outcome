package com.bytedance.applog.u;

import android.text.TextUtils;
import com.bytedance.bdlocation.client.BDLocationConfig;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.CRC32;

/* JADX INFO: loaded from: classes.dex */
public class d extends a {
    d(int r1, Set<String> r2, Map<String, List<Set<String>>> r3, Map<String, List<Map<String, Object>>> r4) {
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
    L17:
        return false;
    L10:
        if (TextUtils.isEmpty(r8.b()) == true) goto L17;
        CRC32 r1 = new CRC32();
        r1.update(r8.b().getBytes());
        if ((r1.getValue() % BDLocationConfig.sScanBleMaxInterval) < this.f2398a) goto L16;
        return true;
    L16:
        return false;
    }
}
