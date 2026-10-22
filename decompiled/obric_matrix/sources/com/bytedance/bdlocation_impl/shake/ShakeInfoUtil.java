package com.bytedance.bdlocation_impl.shake;

import androidx.annotation.Nullable;
import com.bytedance.bdlocation.scan.bluetooth.BDBleInfo;
import com.bytedance.bdlocation.utils.json.JsonUtil;
import com.google.gson.g;
import com.google.gson.j;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ShakeInfoUtil {
    public ShakeInfoUtil() {
    }

    @Nullable
    public static g getBleInfoArray(List<BDBleInfo> r2) {
        if (r2 != null) goto L5;
        return null;
    L5:
        j r3 = JsonUtil.toJsonTreeSafely(r2, new AnonymousClass1().getType());
        if (r3 != null) goto L8;
    L12:
        return null;
    L8:
        if (r3.m() == false) goto L12;
        return r3.b();
    }
}
