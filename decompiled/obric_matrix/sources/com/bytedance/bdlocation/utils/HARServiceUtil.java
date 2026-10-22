package com.bytedance.bdlocation.utils;

import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.network.model.HARStatus;
import com.ss.android.l.a.d;
import com.ss.android.l.a.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class HARServiceUtil {
    public HARServiceUtil() {
    }

    public static List<HARStatus> getHARStatusList() {
        ArrayList r0 = new ArrayList();
        List<e> r1 = d.d().e(BDLocationConfig.getHARStatusRange(), true);
        if (r1 != null) goto L5;
    L10:
        return r0;
    L5:
        if (r1.size() <= 0) goto L10;
        Iterator<e> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        e r3 = r2.next();
        HARStatus r4 = new HARStatus();
        r4.predict = r3.f12007c;
        r4.timestamp = r3.f12008d;
        r0.add(r4);
        goto L8
    }

    public static int getMaxHARStatus() {
        return d.d().f(BDLocationConfig.getHARStatusRange(), true);
    }
}
