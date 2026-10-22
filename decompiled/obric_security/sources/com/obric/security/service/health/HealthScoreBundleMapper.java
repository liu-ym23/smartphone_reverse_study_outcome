package com.obric.security.service.health;

import android.os.Bundle;
import com.obric.security.health.model.HealthCheckItemSnapshot;
import com.obric.security.health.model.HealthModuleSnapshot;
import com.obric.security.health.model.HealthScoreSnapshot;
import com.obric.security.health.score.HealthTaskIds;
import com.obric.securitycenter.api.Const;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: HealthScoreBundleMapper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u000b"}, d2 = {"Lcom/obric/security/service/health/HealthScoreBundleMapper;", "", "()V", "fromHealthSnapshot", "Landroid/os/Bundle;", "snapshot", "Lcom/obric/security/health/model/HealthScoreSnapshot;", "itemScore", "", "itemId", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class HealthScoreBundleMapper {
    public static final HealthScoreBundleMapper INSTANCE = null;

    static {
        INSTANCE = new HealthScoreBundleMapper();
    }

    private HealthScoreBundleMapper() {
    }

    public final Bundle fromHealthSnapshot(HealthScoreSnapshot r4) {
        Intrinsics.checkNotNullParameter(r4, "snapshot");
        Bundle r3 = new Bundle();
        HealthScoreBundleMapper r0 = INSTANCE;
        r3.putInt(Const.TRASH_SCORE, r0.itemScore(r4, HealthTaskIds.TRASH_LESS));
        r3.putInt(Const.MEMORY_SCORE, r0.itemScore(r4, HealthTaskIds.MEMORY_CLEAN));
        r3.putInt(Const.TOTAL_SCORE, 100);
        r3.putInt(Const.CURRENT_SCORE, r4.getTotal());
        return r3;
    }

    private final int itemScore(HealthScoreSnapshot r2, String r3) {
        List<HealthModuleSnapshot> r1 = r2.getModules();
        ArrayList r4 = new ArrayList();
        Iterator<T> r5 = r1.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        CollectionsKt.addAll(r4, ((HealthModuleSnapshot) r5.next()).getItems());
        goto L4
    L6:
        Iterator r6 = r4.iterator();
    L8:
        if (r6.hasNext() == false) goto L12;
        Object r7 = r6.next();
        if (Intrinsics.areEqual(((HealthCheckItemSnapshot) r7).getId(), r3) == false) goto L8;
    L13:
        HealthCheckItemSnapshot r8 = (HealthCheckItemSnapshot) r7;
        if (r8 != null) goto L16;
        return 0;
    L16:
        return RangesKt.coerceIn(r8.getScore() - r8.getEarnedScore(), 0, r8.getScore());
    L12:
        r7 = null;
        goto L13
    }
}
