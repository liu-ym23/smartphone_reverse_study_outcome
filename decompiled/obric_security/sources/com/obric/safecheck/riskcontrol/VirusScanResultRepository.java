package com.obric.safecheck.riskcontrol;

import com.obric.matrix.platform.sdk.ones.account.AccountInfoBundleKey;
import com.obric.safecheck.database.dao.VirusApkDao;
import com.obric.safecheck.database.entity.VirusApkItem;
import com.obric.safecheck.provider.ApkVirusCheckProvider;
import com.obric.safecheck.riskcontrol.api.model.ScanResultRecord;
import com.obric.safecheck.riskcontrol.api.repo.ScanResultRepository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VirusScanResultRepository.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J*\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u000bH\u0016J\u0016\u0010\u0017\u001a\u00020\t2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u000fH\u0016J\f\u0010\u001a\u001a\u00020\u0010*\u00020\u001bH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/safecheck/riskcontrol/VirusScanResultRepository;", "Lcom/obric/safecheck/riskcontrol/api/repo/ScanResultRepository;", "dao", "Lcom/obric/safecheck/database/dao/VirusApkDao;", "clock", "Lkotlin/Function0;", "", "(Lcom/obric/safecheck/database/dao/VirusApkDao;Lkotlin/jvm/functions/Function0;)V", "deleteByPkg", "", ApkVirusCheckProvider.KEY_PKG, "", "isRiskControlled", "", "listAll", "", "Lcom/obric/safecheck/riskcontrol/api/model/ScanResultRecord;", "listControlled", "updateControlState", AccountInfoBundleKey.USER_ID, "", "controlled", "virusDescription", "upsertScanResults", "records", "Lcom/obric/safecheck/riskcontrol/api/repo/ScanResultRepository$NewScanResult;", "toRecord", "Lcom/obric/safecheck/database/entity/VirusApkItem;", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class VirusScanResultRepository implements ScanResultRepository {
    private final Function0<Long> clock;
    private final VirusApkDao dao;

    public VirusScanResultRepository(VirusApkDao r2, Function0<Long> r3) {
        Intrinsics.checkNotNullParameter(r2, "dao");
        Intrinsics.checkNotNullParameter(r3, "clock");
        this.dao = r2;
        this.clock = r3;
    }

    public /* synthetic */ VirusScanResultRepository(VirusApkDao r1, AnonymousClass1 r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = AnonymousClass1.INSTANCE;
    L5:
        this(r1, r2);
    }

    @Override // com.obric.safecheck.riskcontrol.api.repo.ScanResultRepository
    public void upsertScanResults(List<ScanResultRepository.NewScanResult> r15) {
        Intrinsics.checkNotNullParameter(r15, "records");
        if (r15.isEmpty() == false) goto L5;
        return;
    L5:
        String r0 = String.valueOf(this.clock.invoke().longValue());
        Iterator<T> r16 = r15.iterator();
    L7:
        if (r16.hasNext() == false) goto L9;
        ScanResultRepository.NewScanResult r1 = (ScanResultRepository.NewScanResult) r16.next();
        this.dao.upsertVirusResult(new VirusApkItem(r1.getPkg(), r1.getVirusType(), r1.getVirusTypeCode(), r1.getVirusName(), r1.getVirusDescription(), r0, null, 64, null));
        goto L7
    }

    @Override // com.obric.safecheck.riskcontrol.api.repo.ScanResultRepository
    public boolean isRiskControlled(String r2) {
        Intrinsics.checkNotNullParameter(r2, ApkVirusCheckProvider.KEY_PKG);
        VirusApkItem r1 = (VirusApkItem) CollectionsKt.firstOrNull(this.dao.getByPkg(r2));
        if (r1 != null) goto L7;
        return false;
    L7:
        return VirusApkItem.Companion.isRiskControlled(r1.getRiskControlState());
    }

    @Override // com.obric.safecheck.riskcontrol.api.repo.ScanResultRepository
    public void deleteByPkg(String r2) {
        Intrinsics.checkNotNullParameter(r2, ApkVirusCheckProvider.KEY_PKG);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        VirusScanResultRepository r1 = this;     // Catch: Throwable -> L5
        Result.m774constructorimpl(Integer.valueOf(this.dao.deleteByPkg(r2)));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.m774constructorimpl(ResultKt.createFailure(th));
    }

    @Override // com.obric.safecheck.riskcontrol.api.repo.ScanResultRepository
    public void updateControlState(String r2, int r3, boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, ApkVirusCheckProvider.KEY_PKG);
        String r6 = VirusApkItem.Companion.riskControlState(r3, r4);
        this.dao.updateRiskControlState(r2, r6, r5);
    }

    @Override // com.obric.safecheck.riskcontrol.api.repo.ScanResultRepository
    public List<ScanResultRecord> listAll() {
        List<VirusApkItem> r0 = this.dao.getAll();
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        r1.add(toRecord((VirusApkItem) r2.next()));
        goto L4
    L7:
        return r1;
    }

    @Override // com.obric.safecheck.riskcontrol.api.repo.ScanResultRepository
    public List<ScanResultRecord> listControlled() {
        List<VirusApkItem> r0 = this.dao.listRiskControlled();
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        r1.add(toRecord((VirusApkItem) r2.next()));
        goto L4
    L7:
        return r1;
    }

    private final ScanResultRecord toRecord(VirusApkItem r9) {
        return new ScanResultRecord(r9.getPkg(), VirusApkItem.Companion.parseRiskControlUserId(r9.getRiskControlState()), r9.getVirusType(), r9.getVirusTypeCode(), r9.getVirusName(), r9.getVirusDescription(), VirusApkItem.Companion.isRiskControlled(r9.getRiskControlState()));
    }
}
