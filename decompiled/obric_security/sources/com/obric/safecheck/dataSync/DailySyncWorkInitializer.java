package com.obric.safecheck.dataSync;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DailySyncWorkInitializer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/safecheck/dataSync/DailySyncWorkInitializer;", "", "()V", "init", "", "context", "Landroid/content/Context;", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class DailySyncWorkInitializer {
    public static final DailySyncWorkInitializer INSTANCE = null;

    static {
        INSTANCE = new DailySyncWorkInitializer();
    }

    private DailySyncWorkInitializer() {
    }

    public final void init(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        WorkManagerHelper.INSTANCE.initDailySyncWork(r1);
    }
}
