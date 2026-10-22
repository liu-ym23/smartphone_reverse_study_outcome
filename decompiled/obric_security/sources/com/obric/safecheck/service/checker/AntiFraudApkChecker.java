package com.obric.safecheck.service.checker;

import android.content.Context;
import com.bytedance.apm.battery.dao.DBHelper;
import com.obric.olog.OLog;
import com.obric.safecheck.database.AntiFraudDatabase;
import com.obric.safecheck.database.dao.PkgSignDao;
import com.obric.safecheck.database.entity.PkgSignItem;
import com.obric.safecheck.service.ApkAnalyzer;
import com.obric.safecheck.util.serviceutil.MatchResultKt;
import com.obric.security.safecheckapi.ApkInfo;
import com.obric.security.safecheckapi.CheckResult;
import com.obric.securitycenter.api.TrackUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AntiFraudApkChecker.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/safecheck/service/checker/AntiFraudApkChecker;", "Lcom/obric/safecheck/service/checker/ApkAntiFraudChecker;", "context", "Landroid/content/Context;", "apkAnalyzer", "Lcom/obric/safecheck/service/ApkAnalyzer;", "(Landroid/content/Context;Lcom/obric/safecheck/service/ApkAnalyzer;)V", "checkByInfo", "", "Lcom/obric/security/safecheckapi/CheckResult;", "apkInfo", "Lcom/obric/security/safecheckapi/ApkInfo;", "checkByPath", "apkPath", "", "queryPkgSignItem", "Lcom/obric/safecheck/database/entity/PkgSignItem;", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class AntiFraudApkChecker implements ApkAntiFraudChecker {
    private final ApkAnalyzer apkAnalyzer;
    private final Context context;

    public AntiFraudApkChecker(Context r2, ApkAnalyzer r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.context = r2;
        this.apkAnalyzer = r3;
    }

    @Override // com.obric.safecheck.service.checker.ApkAntiFraudChecker
    public List<CheckResult> checkByPath(String r11) {
        OLog.d("AntiFraudApkChecker", "checkByPath");
        ApkAnalyzer r0 = this.apkAnalyzer;
        if (r0 == null) goto L5;
        ApkInfo r1 = r0.getApkInfo(r11);
    L6:
        PkgSignItem r10 = queryPkgSignItem(r1);
        CheckResult r9 = new CheckResult(null, false, null, null, null, null, 63, null);
        r9.setCheckType(CheckResult.TYPE_APK);
        if (r11 != null) goto L9;
        r11 = "";
    L9:
        r9.setSource(r11);
        if (r10 == null) goto L16;
        r9.setBlacklisted(r10.isBlacklist());
        r9.setThreatType(CheckResult.THREAT_FRAUD);
        if (Intrinsics.areEqual(r10.getRiskLevel(), "3") == false) goto L14;
        String r12 = CheckResult.LEVEL_HIGH;
    L15:
        r9.setThreatLevel(r12);
        r9.setDescription("");
        goto L16
    L14:
        r12 = CheckResult.LEVEL_LOW;
    L16:
        TrackUtils r2 = TrackUtils.INSTANCE;
        Pair[] r13 = new Pair[2];
        if (r9.isBlacklisted() == false) goto L19;
        String r14 = "high";
    L20:
        r13[0] = TuplesKt.to("risk_level", r14);
        r13[1] = TuplesKt.to(DBHelper.BATTERY_COL_SOURCE, r9.getSource());
        TrackUtils.trackEvent$default(r2, "anti_fraud_apk_check", MapsKt.mapOf(r13), false, 4, null);
        return CollectionsKt.mutableListOf(new CheckResult[]{r9});
    L19:
        r14 = "none";
        goto L20
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.obric.safecheck.service.checker.ApkAntiFraudChecker
    public List<CheckResult> checkByInfo(ApkInfo r11) {
        OLog.d("AntiFraudApkChecker", "checkByInfo");
        PkgSignItem r10 = queryPkgSignItem(r11);
        CheckResult r9 = new CheckResult(null, false, null, null, null, null, 63, null);
        r9.setCheckType(CheckResult.TYPE_APK);
        if (r11 == null) goto L6;
        String r12 = r11.getPackageName();
        if (r12 == null) goto L6;
    L7:
        r9.setSource(r12);
        if (r10 == null) goto L14;
        r9.setBlacklisted(r10.isBlacklist());
        r9.setThreatType(CheckResult.THREAT_FRAUD);
        if (Intrinsics.areEqual(r10.getRiskLevel(), "3") == false) goto L12;
        String r13 = CheckResult.LEVEL_HIGH;
    L13:
        r9.setThreatLevel(r13);
        r9.setDescription("");
    L15:
        TrackUtils r1 = TrackUtils.INSTANCE;
        Pair[] r14 = new Pair[2];
        if (r9.isBlacklisted() == false) goto L18;
        String r0 = "high";
    L19:
        r14[0] = TuplesKt.to("risk_level", r0);
        r14[1] = TuplesKt.to("package_name", r9.getSource());
        TrackUtils.trackEvent$default(r1, "anti_fraud_apk_check", MapsKt.mapOf(r14), false, 4, null);
        return CollectionsKt.mutableListOf(new CheckResult[]{r9});
    L18:
        r0 = "none";
        goto L19
    L12:
        r13 = CheckResult.LEVEL_LOW;
        goto L13
    L14:
        r9.setBlacklisted(false);
    L6:
        r12 = "";
        goto L7
    }

    private final PkgSignItem queryPkgSignItem(ApkInfo r2) {
        AntiFraudDatabase r1 = AntiFraudDatabase.getDatabase(this.context);
        Intrinsics.checkNotNullExpressionValue(r1, "AntiFraudDatabase.getDatabase(context)");
        PkgSignDao r3 = r1.pkgSignDao();
        Intrinsics.checkNotNullExpressionValue(r3, "db.pkgSignDao()");
        if (r2 == null) goto L5;
        String r0 = r2.getPackageName();
    L6:
        List<PkgSignItem> r4 = r3.getPkgSignItemsByPkg(r0);
        Intrinsics.checkNotNullExpressionValue(r4, "pkgSignDao.getPkgSignIte…Pkg(apkInfo?.packageName)");
        return MatchResultKt.checkApkInBlacklist(r2, CollectionsKt.toMutableList(r4));
    L5:
        r0 = null;
        goto L6
    }
}
