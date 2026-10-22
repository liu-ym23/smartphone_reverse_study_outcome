package com.obric.securitycenter.nodisturb.setting.slot;

import com.bytedance.apm.constant.PerfConsts;
import com.bytedanceos.security.Utils;
import kotlin.Metadata;

/* JADX INFO: compiled from: SlotExt.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001¨\u0006\u0004"}, d2 = {"cardPositionOf", "", Utils.INTENT_KEY_INDEX, PerfConsts.PERF_DISK_TOTAL, "nodisturb_neridaCnRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class SlotExtKt {
    public static final int cardPositionOf(int r1, int r2) {
        if (r2 != 1) goto L5;
        return 0;
    L5:
        if (r1 != 0) goto L8;
        return 1;
    L8:
        if (r1 != (r2 - 1)) goto L10;
        return 3;
    L10:
        return 2;
    }
}
