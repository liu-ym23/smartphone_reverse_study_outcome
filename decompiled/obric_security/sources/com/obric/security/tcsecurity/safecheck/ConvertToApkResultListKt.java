package com.obric.security.tcsecurity.safecheck;

import com.obric.securitycenter.api.ApkResultEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import tmsdk.common.module.qscanner.QScanResultEntity;

/* JADX INFO: compiled from: convertToApkResultList.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¨\u0006\u0006"}, d2 = {"convertToApkResultList", "", "Lcom/obric/securitycenter/api/ApkResultEntity;", "sourceList", "", "Ltmsdk/common/module/qscanner/QScanResultEntity;", "app_neridaCnRelease"}, k = 2, mv = {1, 4, 3})
public final class ConvertToApkResultListKt {
    public static final List<ApkResultEntity> convertToApkResultList(List<QScanResultEntity> r7) {
        List<QScanResultEntity> r0 = r7;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
        List<QScanResultEntity> r8 = r7;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r9 = r8.iterator();
    L14:
        if (r9.hasNext() == false) goto L28;
        QScanResultEntity r3 = (QScanResultEntity) r9.next();
        ApkResultEntity r4 = new ApkResultEntity();
        r4.setPackageName(r3.packageName);
        r4.setPath(r3.path);
        r4.setSoftName(r3.softName);
        r4.setVersion(r3.version);
        r4.setVersionCode(r3.versionCode);
        r4.setVirusName(r3.virusName);
        r4.setVirusDescription(r3.virusDiscription);
        r4.setVirusUrl(r3.virusUrl);
        if (r3.scanResult != 259) goto L18;
    L25:
        boolean r5 = true;
    L26:
        r4.setHasRisk(r5);
        r2.add(r4);
        goto L14
    L18:
        if (r3.scanResult == 260) goto L25;
        if (r3.scanResult == 261) goto L25;
        if (r3.scanResult == 262) goto L25;
        r5 = false;
        goto L26
    L28:
        return r2;
    L11:
        return CollectionsKt.emptyList();
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }
}
