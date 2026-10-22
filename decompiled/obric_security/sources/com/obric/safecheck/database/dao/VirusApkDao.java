package com.obric.safecheck.database.dao;

import com.obric.safecheck.database.entity.VirusApkItem;
import com.obric.safecheck.provider.ApkVirusCheckProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VirusApkDao.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H'J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H'J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH'J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u0006H'J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0017J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\tH'J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\bH'J\"\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H'J<\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\u0006H'JD\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0017J\u0010\u0010\u001a\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0017¨\u0006\u001b"}, d2 = {"Lcom/obric/safecheck/database/dao/VirusApkDao;", "", "deleteAll", "", "deleteByPkg", ApkVirusCheckProvider.KEY_PKG, "", "getAll", "", "Lcom/obric/safecheck/database/entity/VirusApkItem;", "getByPkg", "insert", "", "item", "insertIfAbsent", "", "listRiskControlled", "updateRiskControlState", "riskControlState", "virusDescription", "updateVirusResult", ApkVirusCheckProvider.KEY_VIRUS_TYPE, ApkVirusCheckProvider.KEY_VIRUS_TYPE_CODE, "virusName", "timestamp", "upsertRiskControlState", "upsertVirusResult", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public interface VirusApkDao {

    /* JADX INFO: compiled from: VirusApkDao.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static void insert(VirusApkDao r1, VirusApkItem r2) {
            Intrinsics.checkNotNullParameter(r2, "item");
            r1.upsertVirusResult(r2);
        }

        public static void upsertVirusResult(VirusApkDao r8, VirusApkItem r9) {
            Intrinsics.checkNotNullParameter(r9, "item");
            if (r8.insertIfAbsent(r9) != (-1)) goto L6;
            r8.updateVirusResult(r9.getPkg(), r9.getVirusType(), r9.getVirusTypeCode(), r9.getVirusName(), r9.getVirusDescription(), r9.getTimestamp());
            return;
        }

        public static void upsertRiskControlState(VirusApkDao r10, String r11, String r12, int r13, String r14, String r15, String r16, String r17) {
            Intrinsics.checkNotNullParameter(r11, ApkVirusCheckProvider.KEY_PKG);
            Intrinsics.checkNotNullParameter(r12, ApkVirusCheckProvider.KEY_VIRUS_TYPE);
            Intrinsics.checkNotNullParameter(r16, "timestamp");
            Intrinsics.checkNotNullParameter(r17, "riskControlState");
            if (r10.updateRiskControlState(r11, r17, r15) != 0) goto L6;
            r10.insertIfAbsent(new VirusApkItem(r11, r12, r13, r14, r15, r16, r17));
            return;
        }
    }

    int deleteAll();

    int deleteByPkg(String r1);

    List<VirusApkItem> getAll();

    List<VirusApkItem> getByPkg(String r1);

    void insert(VirusApkItem r1);

    long insertIfAbsent(VirusApkItem r1);

    List<VirusApkItem> listRiskControlled();

    int updateRiskControlState(String r1, String r2, String r3);

    int updateVirusResult(String r1, String r2, int r3, String r4, String r5, String r6);

    void upsertRiskControlState(String r1, String r2, int r3, String r4, String r5, String r6, String r7);

    void upsertVirusResult(VirusApkItem r1);
}
