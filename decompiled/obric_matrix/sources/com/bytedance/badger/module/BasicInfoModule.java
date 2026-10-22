package com.bytedance.badger.module;

import android.content.Context;
import android.os.Build;
import com.bytedance.badger.data.BadgerResult;
import kotlin.a0;
import kotlin.i0.m0;
import kotlin.n0.d.o;
import kotlin.u;

/* JADX INFO: loaded from: classes.dex */
public final class BasicInfoModule extends BadgerModuleBase {
    public BasicInfoModule() {
    }

    @Override // com.bytedance.badger.module.BadgerModuleBase
    protected BadgerResult a(Context r5) {
        o.g(r5, "context");
        u[] r4 = new u[8];
        r4[0] = a0.a("hardware", Build.HARDWARE);
        r4[1] = a0.a("board", Build.BOARD);
        r4[2] = a0.a("device", Build.DEVICE);
        r4[3] = a0.a("manufacturer", Build.MANUFACTURER);
        int r6 = Build.VERSION.SDK_INT;
        String r0 = "";
        if (r6 < 31) goto L5;
        String r2 = Build.SOC_MODEL;
        o.b(r2, "Build.SOC_MODEL");
    L6:
        r4[4] = a0.a("soc_model", r2);
        if (r6 < 31) goto L9;
        r0 = Build.SOC_MANUFACTURER;
        o.b(r0, "Build.SOC_MANUFACTURER");
    L9:
        r4[5] = a0.a("soc_manufacturer", r0);
        r4[6] = a0.a("product", Build.PRODUCT);
        r4[7] = a0.a("display_os_version", Build.DISPLAY);
        return new BadgerResult.Success(m0.k(r4));
    L5:
        r2 = "";
        goto L6
    }

    @Override // com.bytedance.badger.module.BadgerModuleBase
    public String getName() {
        return "basic_info";
    }

    @Override // com.bytedance.badger.module.BadgerModuleBase
    public int getPriority() {
        return 2;
    }

    @Override // com.bytedance.badger.module.BadgerModuleBase
    public int getRefreshIntervalSeconds() {
        return 0;
    }
}
