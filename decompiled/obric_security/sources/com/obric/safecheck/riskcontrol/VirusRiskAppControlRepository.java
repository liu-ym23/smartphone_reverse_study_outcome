package com.obric.safecheck.riskcontrol;

import android.content.Context;
import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import com.obric.matrix.platform.sdk.ones.account.AccountInfoBundleKey;
import com.obric.safecheck.database.dao.VirusApkDao;
import com.obric.safecheck.database.entity.VirusApkItem;
import com.obric.safecheck.provider.ApkVirusCheckProvider;
import com.obric.safecheck.riskcontrol.api.model.RiskAppControlRecord;
import com.obric.safecheck.riskcontrol.api.model.RiskControlFlags;
import com.obric.safecheck.riskcontrol.api.model.RiskControlStatus;
import com.obric.safecheck.riskcontrol.api.repo.RiskAppControlRepository;
import com.obric.safecheck.riskcontrol.domain.settings.RiskControlSettingsSnapshotStore;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: VirusRiskAppControlRepository.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 %2\u00020\u0001:\u0001%B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u0014H\u0016J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u0014H\u0016J\"\u0010\u0016\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000eH\u0016J\u0010\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u000eH\u0002J\u0018\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\fH\u0002J!\u0010\u001c\u001a\u0002H\u001d\"\u0004\b\u0000\u0010\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u001fH\u0002¢\u0006\u0002\u0010 J\u0010\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u0010H\u0016J\u0014\u0010#\u001a\u00020\u0010*\u00020$2\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u0016\u0010\u0007\u001a\n \b*\u0004\u0018\u00010\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/obric/safecheck/riskcontrol/VirusRiskAppControlRepository;", "Lcom/obric/safecheck/riskcontrol/api/repo/RiskAppControlRepository;", "context", "Landroid/content/Context;", "dao", "Lcom/obric/safecheck/database/dao/VirusApkDao;", "(Landroid/content/Context;Lcom/obric/safecheck/database/dao/VirusApkDao;)V", "appContext", "kotlin.jvm.PlatformType", "delete", "", ApkVirusCheckProvider.KEY_PKG, "", AccountInfoBundleKey.USER_ID, "", "get", "Lcom/obric/safecheck/riskcontrol/api/model/RiskAppControlRecord;", "isMainThread", "", "listAll", "", "listControlled", "releaseControlFlags", "flags", "riskLevel", ApkVirusCheckProvider.KEY_VIRUS_TYPE_CODE, "riskTypeCode", "riskType", "runDaoCall", ExifInterface.GPS_DIRECTION_TRUE, "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "upsert", "record", "toRecord", "Lcom/obric/safecheck/database/entity/VirusApkItem;", "Companion", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class VirusRiskAppControlRepository implements RiskAppControlRepository {
    private static final Companion Companion = null;

    @Deprecated
    private static final ExecutorService daoExecutor = null;
    private final Context appContext;
    private final VirusApkDao dao;

    /* JADX INFO: compiled from: VirusRiskAppControlRepository.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/obric/safecheck/riskcontrol/VirusRiskAppControlRepository$Companion;", "", "()V", "daoExecutor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "getDaoExecutor", "()Ljava/util/concurrent/ExecutorService;", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final ExecutorService getDaoExecutor() {
            return VirusRiskAppControlRepository.access$getDaoExecutor$cp();
        }
    }

    private final String riskLevel(int r1) {
        if (r1 != 1) goto L5;
        return "high";
    L5:
        return "medium";
    }

    public VirusRiskAppControlRepository(Context r2, VirusApkDao r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "dao");
        this.dao = r3;
        this.appContext = r2.getApplicationContext();
    }

    public static final /* synthetic */ Context access$getAppContext$p(VirusRiskAppControlRepository r0) {
        return r0.appContext;
    }

    public static final /* synthetic */ VirusApkDao access$getDao$p(VirusRiskAppControlRepository r0) {
        return r0.dao;
    }

    public static final /* synthetic */ ExecutorService access$getDaoExecutor$cp() {
        return daoExecutor;
    }

    public static final /* synthetic */ int access$riskTypeCode(VirusRiskAppControlRepository r0, String r1, String r2) {
        return r0.riskTypeCode(r1, r2);
    }

    public static final /* synthetic */ RiskAppControlRecord access$toRecord(VirusRiskAppControlRepository r0, VirusApkItem r1, int r2) {
        return r0.toRecord(r1, r2);
    }

    @Override // com.obric.safecheck.riskcontrol.api.repo.RiskAppControlRepository
    public RiskAppControlRecord get(final String r2, final int r3) {
        Intrinsics.checkNotNullParameter(r2, ApkVirusCheckProvider.KEY_PKG);
        return (RiskAppControlRecord) runDaoCall(new C03121(this, r2, r3));
    }

    @Override // com.obric.safecheck.riskcontrol.api.repo.RiskAppControlRepository
    public void upsert(final RiskAppControlRecord r2) {
        Intrinsics.checkNotNullParameter(r2, "record");
        runDaoCall(new C03161(this, r2));
    }

    @Override // com.obric.safecheck.riskcontrol.api.repo.RiskAppControlRepository
    public void delete(final String r2, final int r3) {
        Intrinsics.checkNotNullParameter(r2, ApkVirusCheckProvider.KEY_PKG);
        runDaoCall(new AnonymousClass1(this, r2, r3));
    }

    @Override // com.obric.safecheck.riskcontrol.api.repo.RiskAppControlRepository
    public RiskAppControlRecord releaseControlFlags(final String r2, final int r3, final int r4) {
        Intrinsics.checkNotNullParameter(r2, ApkVirusCheckProvider.KEY_PKG);
        return (RiskAppControlRecord) runDaoCall(new C03151(this, r2, r3, r4));
    }

    @Override // com.obric.safecheck.riskcontrol.api.repo.RiskAppControlRepository
    public List<RiskAppControlRecord> listControlled() {
        return (List) runDaoCall(new C03141(this));
    }

    @Override // com.obric.safecheck.riskcontrol.api.repo.RiskAppControlRepository
    public List<RiskAppControlRecord> listAll() {
        return (List) runDaoCall(new C03131(this));
    }

    private final RiskAppControlRecord toRecord(VirusApkItem r18, int r19) {
        Context r1 = this.appContext;
        Intrinsics.checkNotNullExpressionValue(r1, "appContext");
        int r9 = RiskControlSettingsSnapshotStore.getControlFlags(r1, r18.getPkg(), r19);
        if (VirusApkItem.Companion.isRiskControlled(r18.getRiskControlState()) == true) goto L5;
    L7:
        boolean r2 = false;
    L8:
        String r3 = r18.getPkg();
        String r4 = r18.getPkg();
        String r5 = r18.getVirusType();
        String r6 = riskLevel(r18.getVirusTypeCode());
        String r0 = r18.getVirusDescription();
        if (r0 != null) goto L11;
        r0 = "";
    L11:
        String r7 = r0;
        String r8 = r18.getPkg() + "#" + r19;
        if (r2 == false) goto L14;
        RiskControlStatus r10 = RiskControlStatus.CONTROLLED;
    L16:
        return new RiskAppControlRecord(r3, r19, r4, r5, r6, r7, r8, r10, r9, 0, 0);
    L14:
        r10 = RiskControlStatus.RELEASED;
        goto L16
    L5:
        if (RiskControlFlags.hasControlledItem(r9) == false) goto L7;
        r2 = true;
        goto L8
    }

    private final int riskTypeCode(String r1, String r2) {
        if (Intrinsics.areEqual(r1, "sex") == false) goto L5;
    L11:
        return 1;
    L5:
        if (Intrinsics.areEqual(r2, "high") == true) goto L11;
        if (Intrinsics.areEqual(r1, "none") == false) goto L10;
        return 0;
    L10:
        return 2;
    }

    private final <T> T runDaoCall(final Function0<? extends T> r2) {
        if (isMainThread() == true) goto L14;
        return r2.invoke();
    L14:
        return daoExecutor.submit(new VirusRiskAppControlRepository$runDaoCall$future$1(r2)).get();
    L9:
        e = move-exception;
        Throwable r3 = e.getCause();
        if (r3 == null) goto L13;
        throw r3;
    L13:
        throw e;
    }

    private final boolean isMainThread() {
        return Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());
    L4:
        return false;
    }

    static {
        Companion = new Companion(null);
        daoExecutor = Executors.newSingleThreadExecutor();
    }
}
