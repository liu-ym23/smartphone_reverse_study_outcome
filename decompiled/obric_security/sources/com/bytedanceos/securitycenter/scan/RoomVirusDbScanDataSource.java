package com.bytedanceos.securitycenter.scan;

import android.content.Context;
import com.obric.safecheck.database.VirusDatabase;
import com.obric.safecheck.database.entity.VirusApkItem;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: RoomVirusDbScanDataSource.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0016J\f\u0010\u000b\u001a\u00020\n*\u00020\fH\u0002R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedanceos/securitycenter/scan/RoomVirusDbScanDataSource;", "Lcom/bytedanceos/securitycenter/scan/VirusDbScanDataSource;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "appContext", "kotlin.jvm.PlatformType", "loadAllByPkg", "", "", "Lcom/bytedanceos/securitycenter/scan/VirusDbRecord;", "toRecord", "Lcom/obric/safecheck/database/entity/VirusApkItem;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomVirusDbScanDataSource implements VirusDbScanDataSource {
    private final Context appContext;

    public RoomVirusDbScanDataSource(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.appContext = r2.getApplicationContext();
    }

    @Override // com.bytedanceos.securitycenter.scan.VirusDbScanDataSource
    public Map<String, VirusDbRecord> loadAllByPkg() {
        VirusDatabase.Companion r0 = VirusDatabase.Companion;     // Catch: Exception -> L7
        Context r1 = this.appContext;     // Catch: Exception -> L7
        Intrinsics.checkNotNullExpressionValue(r1, "appContext");     // Catch: Exception -> L7
        List<VirusApkItem> r2 = r0.getDatabase(r1).virusApkDao().getAll();     // Catch: Exception -> L7
        LinkedHashMap r3 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r2, 10)), 16));     // Catch: Exception -> L7
        Iterator<T> r4 = r2.iterator();     // Catch: Exception -> L7
    L4:
        if (r4.hasNext() == false) goto L14;
        VirusApkItem r5 = (VirusApkItem) r4.next();     // Catch: Exception -> L7
        Pair r6 = TuplesKt.to(r5.getPkg(), toRecord(r5));     // Catch: Exception -> L7
        r3.put(r6.getFirst(), r6.getSecond());     // Catch: Exception -> L7
        goto L4
    L14:
        return r3;
    L7:
        e = move-exception;
        e.printStackTrace();
        return MapsKt.emptyMap();
    }

    private final VirusDbRecord toRecord(VirusApkItem r7) {
        return new VirusDbRecord(r7.getPkg(), r7.getVirusTypeCode(), r7.getVirusName(), r7.getVirusDescription(), VirusApkItem.Companion.isRiskControlled(r7.getRiskControlState()));
    }
}
