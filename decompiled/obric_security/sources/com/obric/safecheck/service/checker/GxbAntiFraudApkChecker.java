package com.obric.safecheck.service.checker;

import android.content.Context;
import com.obric.olog.OLog;
import com.obric.safecheck.dataSync.miitAntiFraud.GxbAntiFraudRuleExpiry;
import com.obric.safecheck.dataSync.miitAntiFraud.GxbAppInstallHitReporter;
import com.obric.safecheck.dataSync.miitAntiFraud.GxbAppInstallableOkHttpRequester;
import com.obric.safecheck.dataSync.miitAntiFraud.GxbAppInstallableRequester;
import com.obric.safecheck.dataSync.miitAntiFraud.GxbRiskAppCache;
import com.obric.safecheck.database.AntiFraudDatabase;
import com.obric.safecheck.database.dao.GxbAntiFraudRuleDao;
import com.obric.safecheck.database.entity.GxbAntiFraudRuleItem;
import com.obric.safecheck.service.ApkAnalyzer;
import com.obric.security.safecheckapi.ApkInfo;
import com.obric.security.safecheckapi.CheckResult;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: GxbAntiFraudApkChecker.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0014\u0010\u0019\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u000e2\u0006\u0010\u001b\u001a\u00020\u0013H\u0002J\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/safecheck/service/checker/GxbAntiFraudApkChecker;", "Lcom/obric/safecheck/service/checker/ApkAntiFraudChecker;", "context", "Landroid/content/Context;", "apkAnalyzer", "Lcom/obric/safecheck/service/ApkAnalyzer;", "(Landroid/content/Context;Lcom/obric/safecheck/service/ApkAnalyzer;)V", "applyRuleMatch", "", "result", "Lcom/obric/security/safecheckapi/CheckResult;", "rule", "Lcom/obric/safecheck/database/entity/GxbAntiFraudRuleItem;", "checkByInfo", "", "apkInfo", "Lcom/obric/security/safecheckapi/ApkInfo;", "checkByPath", "apkPath", "", "dispatchCheckInstallable", "app", "Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbAppInstallableRequester$GxbAppCheckItem;", "callback", "Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbAppInstallableRequester$Callback;", "matchRule", "queryRules", "packageName", "requestInstallableRule", "Lcom/obric/safecheck/dataSync/miitAntiFraud/GxbAppInstallableRequester$GxbAppInstallableRule;", "Companion", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class GxbAntiFraudApkChecker implements ApkAntiFraudChecker {
    private static final Companion Companion = null;

    @Deprecated
    private static final long REQUEST_TIMEOUT_SECONDS = 5;

    @Deprecated
    private static final String TAG = "GbtCodeDict-GxbAntiFraudApkChecker";

    @Deprecated
    private static final boolean USE_OKHTTP_REQUESTER = true;
    private final ApkAnalyzer apkAnalyzer;
    private final Context context;

    /* JADX INFO: compiled from: GxbAntiFraudApkChecker.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/safecheck/service/checker/GxbAntiFraudApkChecker$Companion;", "", "()V", "REQUEST_TIMEOUT_SECONDS", "", "TAG", "", "USE_OKHTTP_REQUESTER", "", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static final /* synthetic */ Companion access$Companion() {
        return Companion;
    }

    public GxbAntiFraudApkChecker(Context r2, ApkAnalyzer r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.context = r2;
        this.apkAnalyzer = r3;
    }

    @Override // com.obric.safecheck.service.checker.ApkAntiFraudChecker
    public List<CheckResult> checkByPath(String r14) {
        OLog.d(TAG, "checkByPath start, apkPath is " + r14);
        ApkAnalyzer r0 = this.apkAnalyzer;
        String r2 = null;
        if (r0 == null) goto L5;
        ApkInfo r1 = r0.getApkInfo(r14);
    L6:
        if (r1 == null) goto L8;
        String r3 = r1.getPackageName();
    L9:
        if (r1 == null) goto L11;
        String r4 = r1.getSignatureMd5();
    L12:
        if (r1 == null) goto L14;
        String r5 = r1.getSignatureSha1();
    L15:
        if (r1 == null) goto L17;
        String r6 = r1.getSignatureSha256();
    L18:
        OLog.d(TAG, "checkByPath apkInfo, packageName is " + r3 + ", signMd5 is " + r4 + ", signSha1 is " + r5 + ", signSha256 is " + r6);
        CheckResult r7 = new CheckResult(null, false, null, null, null, null, 63, null);
        r7.setCheckType(CheckResult.TYPE_APK);
        if (r14 != null) goto L21;
        String r8 = "";
    L22:
        r7.setSource(r8);
        GxbAntiFraudRuleItem r9 = matchRule(r1);
        applyRuleMatch(r7, r9);
        boolean r13 = r7.isBlacklisted();
        if (r9 == null) goto L25;
        r2 = r9.getRuleNo();
    L25:
        OLog.d(TAG, "checkByPath end, apkPath is " + r14 + ", hit is " + r13 + ", ruleNo is " + r2);
        return CollectionsKt.mutableListOf(new CheckResult[]{r7});
    L21:
        r8 = r14;
        goto L22
    L17:
        r6 = null;
        goto L18
    L14:
        r5 = null;
        goto L15
    L11:
        r4 = null;
        goto L12
    L8:
        r3 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.obric.safecheck.service.checker.ApkAntiFraudChecker
    public List<CheckResult> checkByInfo(ApkInfo r17) {
        String r1 = null;
        if (r17 == null) goto L5;
        String r2 = r17.getPackageName();
    L6:
        if (r17 == null) goto L8;
        String r3 = r17.getSignatureMd5();
    L9:
        if (r17 == null) goto L11;
        String r4 = r17.getSignatureSha1();
    L12:
        if (r17 == null) goto L14;
        r1 = r17.getSignatureSha256();
    L14:
        OLog.d(TAG, "checkByInfo start, packageName is " + r2 + ", signMd5 is " + r3 + ", signSha1 is " + r4 + ", signSha256 is " + r1);
        CheckResult r5 = new CheckResult(null, false, null, null, null, null, 63, null);
        r5.setCheckType(CheckResult.TYPE_APK);
        if (r2 != null) goto L17;
        String r6 = "";
    L18:
        r5.setSource(r6);
        String r7 = r2;
        if (r7 != null) goto L21;
    L24:
        boolean r8 = true;
    L25:
        if (r8 == false) goto L28;
        OLog.e(TAG, "checkByInfo skipped, packageName is empty");
        r5.setBlacklisted(false);
        return CollectionsKt.mutableListOf(new CheckResult[]{r5});
    L28:
        Intrinsics.checkNotNull(r17);
        GxbAppInstallableRequester.GxbAppInstallableRule r0 = requestInstallableRule(r2, r17);
        if (r0 != null) goto L31;
        OLog.d(TAG, "checkByInfo miss by gxb_app_installable, packageName is " + r2);
        r5.setBlacklisted(false);
    L62:
        OLog.d(TAG, "checkByInfo end, packageName is " + r2 + ", isBlacklisted is " + r5.isBlacklisted() + " ,checkResult is " + r5.getSource() + " ");
        return CollectionsKt.mutableListOf(new CheckResult[]{r5});
    L31:
        if (GxbAreaMatcher.isRuleAreaMatched(r0.getAreaType(), r0.getArea()) == true) goto L34;
        OLog.d(TAG, "checkByInfo skipped by area filter, packageName is " + r2 + ", ruleNo is " + r0.getRuleNo() + ", area is " + r0.getArea() + ", areaType is " + r0.getAreaType());
        r5.setBlacklisted(false);
        return CollectionsKt.mutableListOf(new CheckResult[]{r5});
    L34:
        Integer r9 = r0.getRuleType();
        if (r9 == null) goto L41;
        if (r9.intValue() != 1) goto L41;
        String r10 = CheckResult.LEVEL_MEDIUM;
    L55:
        OLog.d(TAG, "checkByInfo hit by gxb_app_installable, packageName is " + r2 + ", ruleNo is " + r0.getRuleNo() + ", ruleType is " + r0.getRuleType() + ", area is " + r0.getArea() + ", areaType is " + r0.getAreaType() + ", level is " + r10);
        r5.setBlacklisted(true);
        r5.setThreatType(CheckResult.THREAT_FRAUD_GXB);
        r5.setThreatLevel(r10);
        r5.setDescription("");
        GxbAppInstallHitReporter.report$default(2, r0.getRuleNo(), 1, 0, null, 24, null);
        Integer r11 = r0.getRuleType();
        if (r11 == null) goto L62;
        if (r11.intValue() != 1) goto L62;
        GxbRiskAppCache.put(r2, r0.getRuleType(), r0.getRuleNo());
    L41:
        if (r9 != null) goto L44;
    L46:
        if (r9 != null) goto L49;
    L51:
        if (r9 == null) goto L54;
        r9.intValue();
    L54:
        r10 = CheckResult.LEVEL_HIGH;
        goto L55
    L49:
        if (r9.intValue() != 3) goto L51;
    L44:
        if (r9.intValue() != 2) goto L46;
    L21:
        if (r7.length() == 0) goto L24;
        r8 = false;
        goto L25
    L17:
        r6 = r2;
        goto L18
    L11:
        r4 = null;
        goto L12
    L8:
        r3 = null;
        goto L9
    L5:
        r2 = null;
        goto L6
    }

    private final GxbAppInstallableRequester.GxbAppInstallableRule requestInstallableRule(final String r13, ApkInfo r14) {
        OLog.d(TAG, "requestInstallableRule start, packageName is " + r13);
        final CountDownLatch r1 = new CountDownLatch(1);
        String r4 = null;
        final AtomicReference r3 = new AtomicReference(null);
        dispatchCheckInstallable(new GxbAppInstallableRequester.GxbAppCheckItem(r13, r14.getApkMd5(), r14.getSignatureMd5(), r14.getSignatureSha1(), r14.getSignatureSha256()), new AnonymousClass1(r13, r3, r1));     // Catch: Throwable -> L12
        if (r1.await(5, TimeUnit.SECONDS) == true) goto L7;
        OLog.e(TAG, "gxb_app_installable timeout, packageName is " + r13 + ", timeout is 5s");     // Catch: Throwable -> L12
        return null;
    L7:
        GxbAppInstallableRequester.GxbAppInstallableRule r12 = (GxbAppInstallableRequester.GxbAppInstallableRule) r3.get();
        if (r12 == null) goto L10;
        r4 = r12.getRuleNo();
    L10:
        OLog.d(TAG, "requestInstallableRule end, packageName is " + r13 + ", ruleNo is " + r4);
        return r12;
    L12:
        th = move-exception;
        OLog.e(TAG, "gxb_app_installable exception, packageName is " + r13, th);
        return null;
    }

    private final void dispatchCheckInstallable(GxbAppInstallableRequester.GxbAppCheckItem r1, GxbAppInstallableRequester.Callback r2) {
        GxbAppInstallableOkHttpRequester.checkInstallable(r1, r2);
    }

    private final void applyRuleMatch(CheckResult r7, GxbAntiFraudRuleItem r8) {
        if (r8 != null) goto L6;
        OLog.d(TAG, "applyRuleMatch miss, set isBlacklisted=false, source is " + r7.getSource());
        r7.setBlacklisted(false);
        return;
    L6:
        OLog.d(TAG, "applyRuleMatch hit, source is " + r7.getSource() + ", ruleNo is " + r8.getRuleNo() + ", ruleType is " + r8.getRuleType() + ", packetName is " + r8.getPacketName());
        r7.setBlacklisted(true);
        r7.setThreatType(CheckResult.THREAT_FRAUD);
        r7.setThreatLevel(CheckResult.LEVEL_HIGH);
        r7.setDescription("gxb ruleNo=" + r8.getRuleNo() + ", ruleType=" + r8.getRuleType());
    }

    private final GxbAntiFraudRuleItem matchRule(ApkInfo r12) {
        String r1 = null;
        if (r12 != null) goto L6;
        OLog.e(TAG, "matchRule skipped, apkInfo is null");
        return null;
    L6:
        String r2 = r12.getPackageName();
        String r3 = r2;
        boolean r4 = false;
        if (r3 != null) goto L9;
    L12:
        boolean r5 = true;
    L13:
        if (r5 == false) goto L16;
        OLog.e(TAG, "matchRule skipped, packageName is empty");
        return null;
    L16:
        List<GxbAntiFraudRuleItem> r11 = queryRules(r2);
        OLog.d(TAG, "matchRule loaded rules, packageName is " + r2 + ", rules size is " + r11.size());
        if (r11.isEmpty() == false) goto L19;
        return null;
    L19:
        String r6 = r12.getSignatureMd5();
        String r7 = "";
        if (r6 != null) goto L22;
        r6 = "";
    L22:
        String r8 = r12.getSignatureSha1();
        if (r8 != null) goto L25;
        r8 = "";
    L25:
        String r13 = r12.getSignatureSha256();
        if (r13 == null) goto L29;
        r7 = r13;
    L29:
        Iterator<T> r14 = r11.iterator();
    L31:
        if (r14.hasNext() == false) goto L74;
        Object r15 = r14.next();
        GxbAntiFraudRuleItem r9 = (GxbAntiFraudRuleItem) r15;
        if (GxbAntiFraudRuleExpiry.isExpired(r9) == true) goto L71;
        String r10 = r9.getSignMd5();
        if (r10 != null) goto L37;
    L46:
        String r16 = r9.getSignSha1();
        if (r16 != null) goto L49;
    L58:
        String r17 = r9.getSignSha256();
        if (r17 == null) goto L71;
        if (r17.length() <= 0) goto L63;
        boolean r18 = true;
    L64:
        if (r18 == true) goto L67;
        r17 = null;
    L67:
        if (r17 == null) goto L71;
        if (StringsKt.equals(r17, r7, true) != true) goto L71;
    L70:
        boolean r19 = true;
    L72:
        if (r19 == false) goto L31;
    L75:
        GxbAntiFraudRuleItem r110 = (GxbAntiFraudRuleItem) r15;
        if (r110 == null) goto L78;
        r4 = true;
    L78:
        if (r110 == null) goto L80;
        r1 = r110.getRuleNo();
    L80:
        OLog.d(TAG, "matchRule done, packageName is " + r2 + ", hit is " + r4 + ", hitRuleNo is " + r1);
        return r110;
    L63:
        r18 = false;
        goto L64
    L49:
        if (r16.length() <= 0) goto L51;
        boolean r111 = true;
    L52:
        if (r111 == true) goto L55;
        r16 = null;
    L55:
        if (r16 == null) goto L58;
        if (StringsKt.equals(r16, r8, true) == true) goto L70;
    L51:
        r111 = false;
        goto L52
    L37:
        if (r10.length() <= 0) goto L39;
        boolean r112 = true;
    L40:
        if (r112 == true) goto L43;
        r10 = null;
    L43:
        if (r10 == null) goto L46;
        if (StringsKt.equals(r10, r6, true) == true) goto L70;
    L39:
        r112 = false;
    L71:
        r19 = false;
        goto L72
    L74:
        r15 = null;
        goto L75
    L9:
        if (r3.length() == 0) goto L12;
        r5 = false;
        goto L13
    }

    private final List<GxbAntiFraudRuleItem> queryRules(String r3) {
        AntiFraudDatabase r2 = AntiFraudDatabase.getDatabase(this.context);     // Catch: Throwable -> L4
        Intrinsics.checkNotNullExpressionValue(r2, "AntiFraudDatabase.getDatabase(context)");     // Catch: Throwable -> L4
        GxbAntiFraudRuleDao r4 = r2.gxbAntiFraudRuleDao();     // Catch: Throwable -> L4
        Intrinsics.checkNotNullExpressionValue(r4, "db.gxbAntiFraudRuleDao()");     // Catch: Throwable -> L4
        return r4.getByPacketName(r3);
    L4:
        th = move-exception;
        OLog.e(TAG, "query gxb rules failed, packageName is " + r3, th);
        return CollectionsKt.emptyList();
    }
}
