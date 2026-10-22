package com.obric.safecheck.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.alog.AlogMonitor;
import com.obric.olog.OLog;
import com.obric.safecheck.database.AntiFraudDatabase;
import com.obric.safecheck.database.dao.PkgSignDao;
import com.obric.safecheck.database.entity.PkgSignItem;
import com.obric.safecheck.service.ApkVirusCheckHelper;
import com.obric.security.health.score.HealthModuleIds;
import com.obric.security.safecheckapi.CheckResult;
import com.obric.securitycenter.api.ApkResultEntity;
import com.obric.securitycenter.api.ApkScanListener;
import com.obric.securitycenter.api.GlobalManagerCreator;
import com.obric.securitycenter.api.ITmsApkCheckManager;
import com.obric.taskmanager.TaskManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: SaveCheckProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0002J1\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0010\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010\u0011J\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00132\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\rH\u0016J\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\u0016\u001a\u0004\u0018\u00010\r2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016JO\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\f\u001a\u00020\r2\u0010\u0010\u001d\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0010\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\u001fJ;\u0010 \u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0010\u0010\u000f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u0010H\u0016¢\u0006\u0002\u0010!¨\u0006#"}, d2 = {"Lcom/obric/safecheck/provider/SaveCheckProvider;", "Landroid/content/ContentProvider;", "()V", NotificationCompat.CATEGORY_CALL, "Landroid/os/Bundle;", "method", "", "arg", "extras", "currentTimestamp", "delete", "", "uri", "Landroid/net/Uri;", "selection", "selectionArgs", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "getApkPackageList", "", "getType", "handleVirusAppsCheck", "insert", "values", "Landroid/content/ContentValues;", "onCreate", "", "query", "Landroid/database/Cursor;", "projection", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", HealthModuleIds.UPDATE, "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Companion", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class SaveCheckProvider extends ContentProvider {
    private static final Companion Companion = null;

    @Deprecated
    private static final String KEY_APK_PACKAGE = "apk_package";

    @Deprecated
    private static final String KEY_APK_PACKAGE_LIST = "apk_package_list";

    @Deprecated
    private static final String KEY_CALL_APK_PACKAGE = "call_apk_package";

    @Deprecated
    private static final String KEY_DETECT_RESULTS = "detect_results";

    @Deprecated
    private static final String KEY_IS_CLOUD_SCAN = "is_cloud_scan";

    @Deprecated
    private static final String KEY_MIN_RISK_LEVEL = "min_riskLevel";

    @Deprecated
    private static final String METHOD_FRAUD_APPS_ITEMS = "fraud_apps_items";

    @Deprecated
    private static final String METHOD_VIRUS_APPS_ITEMS = "virus_apps_items";

    @Deprecated
    private static final int RESULT_FRAUD = 1;

    @Deprecated
    private static final int RESULT_NORMAL = 0;

    @Deprecated
    private static final long SCAN_TIMEOUT_MILLIS = 3000;

    @Deprecated
    private static final String TAG = "SaveCheckProvider";

    /* JADX INFO: compiled from: SaveCheckProvider.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/safecheck/provider/SaveCheckProvider$Companion;", "", "()V", "KEY_APK_PACKAGE", "", "KEY_APK_PACKAGE_LIST", "KEY_CALL_APK_PACKAGE", "KEY_DETECT_RESULTS", "KEY_IS_CLOUD_SCAN", "KEY_MIN_RISK_LEVEL", "METHOD_FRAUD_APPS_ITEMS", "METHOD_VIRUS_APPS_ITEMS", "RESULT_FRAUD", "", "RESULT_NORMAL", "SCAN_TIMEOUT_MILLIS", "", "TAG", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.obric.safecheck.provider.SaveCheckProvider$handleVirusAppsCheck$1, reason: invalid class name */
    /* JADX INFO: compiled from: SaveCheckProvider.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0016¨\u0006\u000b"}, d2 = {"com/obric/safecheck/provider/SaveCheckProvider$handleVirusAppsCheck$1", "Lcom/obric/securitycenter/api/ApkScanListener;", "onScanError", "", AlogMonitor.ALOG_RESULT_CODE, "", "onScanFinished", "var1", "var2", "", "Lcom/obric/securitycenter/api/ApkResultEntity;", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class AnonymousClass1 implements ApkScanListener {
        final /* synthetic */ Context $ctx;
        final /* synthetic */ Ref.BooleanRef $hasScanError;
        final /* synthetic */ List $scanResults;
        final /* synthetic */ SaveCheckProvider this$0;

        AnonymousClass1(SaveCheckProvider r1, List r2, Context r3, Ref.BooleanRef r4) {
            this.this$0 = r1;
            this.$scanResults = r2;
            this.$ctx = r3;
            this.$hasScanError = r4;
        }

        @Override // com.obric.securitycenter.api.ApkScanListener
        public void onScanCanceled(int r1) {
            ApkScanListener.DefaultImpls.onScanCanceled(this, r1);
        }

        @Override // com.obric.securitycenter.api.ApkScanListener
        public void onScanContinue(int r1) {
            ApkScanListener.DefaultImpls.onScanContinue(this, r1);
        }

        @Override // com.obric.securitycenter.api.ApkScanListener
        public void onScanPaused(int r1) {
            ApkScanListener.DefaultImpls.onScanPaused(this, r1);
        }

        @Override // com.obric.securitycenter.api.ApkScanListener
        public void onScanProgress(int r1, int r2, int r3, String r4, String r5) {
            ApkScanListener.DefaultImpls.onScanProgress(this, r1, r2, r3, r4, r5);
        }

        @Override // com.obric.securitycenter.api.ApkScanListener
        public void onScanStarted(int r1) {
            ApkScanListener.DefaultImpls.onScanStarted(this, r1);
        }

        @Override // com.obric.securitycenter.api.ApkScanListener
        public void onScanFinished(int r12, final List<ApkResultEntity> r13) {
            if (r13 == null) goto L13;
            Iterator<T> r14 = r13.iterator();     // Catch: Throwable -> L10
        L5:
            if (r14.hasNext() == false) goto L13;
            ApkResultEntity r0 = (ApkResultEntity) r14.next();     // Catch: Throwable -> L10
            CheckResult r10 = new CheckResult(null, false, null, null, null, null, 63, null);     // Catch: Throwable -> L10
            r10.setCheckType(CheckResult.TYPE_APK);     // Catch: Throwable -> L10
            r10.setThreatType(CheckResult.THREAT_VIRUS);     // Catch: Throwable -> L10
            String r1 = r0.getPackageName();     // Catch: Throwable -> L10
            if (r1 != null) goto L9;
            r1 = "";
        L9:
            r10.setSource(r1);     // Catch: Throwable -> L10
            r10.setBlacklisted(r0.getHasRisk());     // Catch: Throwable -> L10
            this.$scanResults.add(r10);     // Catch: Throwable -> L10
            SaveCheckProvider.access$Companion();     // Catch: Throwable -> L10
            OLog.d(SaveCheckProvider.TAG, "checkApk THREAT_VIRUS isBlacklist = " + r0.getHasRisk());     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;
        L13:
            if (this.$ctx == null) goto L30;
            List<ApkResultEntity> r15 = r13;     // Catch: Throwable -> L10
            if (r15 != null) goto L17;
        L20:
            boolean r16 = true;
        L21:
            if (r16 == true) goto L31;
            TaskManager.Companion.getInstance().submit("virus_apk_insert", new SaveCheckProvider$handleVirusAppsCheck$1$onScanFinished$2(this, r13));     // Catch: Throwable -> L10
            return;
        L31:
            return;
        L17:
            if (r15.isEmpty() == true) goto L20;
            r16 = false;
            goto L21
        }

        @Override // com.obric.securitycenter.api.ApkScanListener
        public void onScanError(int r2) {
            this.$hasScanError.element = true;
            SaveCheckProvider.access$Companion();
            OLog.e(SaveCheckProvider.TAG, "virus scan error code=" + r2);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static final /* synthetic */ Companion access$Companion() {
        return Companion;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return -1;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r1) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return "";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r1, ContentValues r2) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return -1;
    }

    public SaveCheckProvider() {
    }

    public static final /* synthetic */ String access$currentTimestamp(SaveCheckProvider r0) {
        return r0.currentTimestamp();
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r7, String r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "method");
        String r0 = null;
        if (Intrinsics.areEqual(METHOD_FRAUD_APPS_ITEMS, r7) == false) goto L53;
        if (r9 == null) goto L8;
        String r10 = r9.getString(KEY_CALL_APK_PACKAGE);
        if (r10 == null) goto L8;
    L9:
        Intrinsics.checkNotNullExpressionValue(r10, "extras?.getString(KEY_CALL_APK_PACKAGE) ?: \"\"");
        if (r9 == null) goto L13;
        String r11 = r9.getString(KEY_APK_PACKAGE);
        if (r11 == null) goto L13;
    L14:
        Intrinsics.checkNotNullExpressionValue(r11, "extras?.getString(KEY_APK_PACKAGE) ?: \"\"");
        int r12 = 3;
        if (r9 == null) goto L17;
        r12 = r9.getInt(KEY_MIN_RISK_LEVEL, 3);
    L17:
        int r1 = r12;
        AntiFraudDatabase r6 = AntiFraudDatabase.getDatabase(getContext());
        Intrinsics.checkNotNullExpressionValue(r6, "AntiFraudDatabase.getDatabase(getContext())");
        PkgSignDao r13 = r6.pkgSignDao();
        Intrinsics.checkNotNullExpressionValue(r13, "db.pkgSignDao()");
        List<PkgSignItem> r14 = r13.getPkgSignItemsByPkg(r11);
        Intrinsics.checkNotNullExpressionValue(r14, "pkgSignDao.getPkgSignItemsByPkg(apkPackage)");
        Iterator<T> r2 = r14.iterator();
        if (r2.hasNext() == true) goto L20;
        Object r15 = null;
    L35:
        PkgSignItem r16 = (PkgSignItem) r15;
        if (r16 == null) goto L40;
        String r17 = r16.getRiskLevel();
        if (r17 == null) goto L40;
        int r18 = Integer.parseInt(r17);
    L41:
        if (r16 == null) goto L43;
        String r3 = r16.getPkg();
    L44:
        if (r16 == null) goto L46;
        r0 = r16.getRiskLevel();
    L46:
        OLog.d(TAG, "resultRiskLevel = " + r18 + ", minRiskLevel = " + r1 + ", newPkgSignItem.pkg = " + r3 + " , newPkgSignItem.riskLevel = " + r0 + " ,apkPackage = " + r11);
        if (r18 < r1) goto L50;
        Bundle r19 = new Bundle();
        r19.putInt(KEY_DETECT_RESULTS, 1);
        return r19;
    L50:
        Bundle r20 = new Bundle();
        r20.putInt(KEY_DETECT_RESULTS, 0);
        return r20;
    L43:
        r3 = null;
    L40:
        r18 = 0;
        goto L41
    L20:
        r15 = r2.next();
        if (r2.hasNext() == false) goto L35;
        String r21 = ((PkgSignItem) r15).getTimestamp();
        if (r21 != null) goto L26;
        r21 = "0000:00:00";
    L26:
        String r22 = r21;
    L27:
        Object r23 = r2.next();
        String r4 = ((PkgSignItem) r23).getTimestamp();
        if (r4 != null) goto L30;
        r4 = "0000:00:00";
    L30:
        String r5 = r4;
        if (r22.compareTo(r5) >= 0) goto L34;
        r15 = r23;
        r22 = r5;
    L34:
        if (r2.hasNext() == true) goto L27;
    L13:
        r11 = "";
    L8:
        r10 = "";
        goto L9
    L53:
        if (Intrinsics.areEqual(METHOD_VIRUS_APPS_ITEMS, r7) == true) goto L55;
        return null;
    L55:
        return handleVirusAppsCheck(r9);
    }

    private final List<String> getApkPackageList(Bundle r5) {
        if (r5 == null) goto L4;
        ArrayList<String> r4 = r5.getStringArrayList(KEY_APK_PACKAGE_LIST);
    L5:
        ArrayList<String> r0 = r4;
        if (r0 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == true) goto L21;
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r4.iterator();
    L15:
        if (r7.hasNext() == false) goto L20;
        Object r2 = r7.next();
        String r3 = (String) r2;
        Intrinsics.checkNotNullExpressionValue(r3, "it");
        if ((!StringsKt.isBlank(r3)) == false) goto L15;
        r6.add(r2);
        goto L15
    L20:
        return r6;
    L21:
        if (r5 == null) goto L24;
        String r8 = r5.getString(KEY_APK_PACKAGE);
        if (r8 == null) goto L24;
    L25:
        Intrinsics.checkNotNullExpressionValue(r8, "extras?.getString(KEY_APK_PACKAGE) ?: \"\"");
        if ((!StringsKt.isBlank(r8)) == false) goto L29;
        return CollectionsKt.listOf(r8);
    L29:
        return CollectionsKt.emptyList();
    L24:
        r8 = "";
        goto L25
    L8:
        if (r0.isEmpty() == true) goto L11;
        r1 = false;
        goto L12
    L4:
        r4 = null;
        goto L5
    }

    private final Bundle handleVirusAppsCheck(Bundle r18) {
        ArrayList r2 = getApkPackageList(r18);
        int r3 = 0;
        if (r18 == null) goto L5;
        boolean r5 = r18.getBoolean(KEY_IS_CLOUD_SCAN, false);
    L6:
        ArrayList r1 = new ArrayList();
        Bundle r10 = new Bundle();
        Context r4 = getContext();
        if (r2.isEmpty() == false) goto L10;
        r10.putInt(KEY_DETECT_RESULTS, 0);
        return r10;
    L10:
        ArrayList r6 = new ArrayList();
        ArrayList r7 = new ArrayList();
        if (r4 == null) goto L31;
        ArrayList r8 = new ArrayList();
        Iterator<T> r9 = r2.iterator();
        int r11 = 0;
    L15:
        if (r9.hasNext() == false) goto L29;
        Object r13 = r9.next();
        String r14 = (String) r13;
        ApkVirusCheckHelper.ScanResult r15 = ApkVirusCheckHelper.INSTANCE.checkPackage(r4, r14);
        if (r15.getVirusTypeCode() != 0) goto L20;
        r6.add(r14);
        r10.putInt(r14, r3);
    L26:
        if (r3 == 0) goto L28;
        r8.add(r13);
    L28:
        r3 = 0;
        goto L15
    L20:
        if (r15.getVirusTypeCode() != 1) goto L22;
    L25:
        r7.add(r14);
        r10.putInt(r14, 1);
        r11 = 1;
        r3 = 0;
        goto L26
    L22:
        if (r15.getVirusTypeCode() == 2) goto L25;
        r3 = 1;
        goto L26
    L29:
        r2 = r8;
        r3 = r11;
    L31:
        if ((!r6.isEmpty()) == false) goto L34;
        OLog.d(TAG, "skip virus scan via helper check, count=" + r6.size() + ", pkgs=" + r6);
    L34:
        if ((!r7.isEmpty()) == false) goto L37;
        OLog.d(TAG, "skip virus scan via helper check VIRUS_CODE_SEX, count=" + r7.size() + ", pkgs=" + r7);
    L37:
        if (r2.isEmpty() == false) goto L76;
        r10.putInt(KEY_DETECT_RESULTS, r3);
        return r10;
    L76:
        ITmsApkCheckManager r12 = (ITmsApkCheckManager) GlobalManagerCreator.INSTANCE.getManager(ITmsApkCheckManager.class);     // Catch: Exception -> L73
        Ref.BooleanRef r16 = new Ref.BooleanRef();     // Catch: Exception -> L73
        int r17 = 0;
        r16.element = false;     // Catch: Exception -> L73
        if (r12 == null) goto L68;
        r12.scanInstalledPackages(r5, r2, new AnonymousClass1(this, r1, r4, r16), 3000);     // Catch: Exception -> L73
        ArrayList r0 = r1;     // Catch: Exception -> L73
        if ((r0 instanceof Collection) == true) goto L45;
    L47:
        Iterator r19 = r0.iterator();     // Catch: Exception -> L73
    L49:
        if (r19.hasNext() == false) goto L46;
        if (((CheckResult) r19.next()).isBlacklisted() == false) goto L49;
        boolean r20 = true;
    L53:
        Iterator r21 = r1.iterator();     // Catch: Exception -> L73
        int r22 = 0;
    L55:
        if (r21.hasNext() == false) goto L64;
        Object r23 = r21.next();     // Catch: Exception -> L73
        int r24 = r22 + 1;     // Catch: Exception -> L73
        if (r22 >= 0) goto L59;
        CollectionsKt.throwIndexOverflow();     // Catch: Exception -> L73
    L59:
        CheckResult r25 = (CheckResult) r23;     // Catch: Exception -> L73
        String r26 = r25.getSource();     // Catch: Exception -> L73
        if (r25.isBlacklisted() == false) goto L62;
        int r27 = 1;
    L63:
        r10.putInt(r26, r27);     // Catch: Exception -> L73
        r22 = r24;
        goto L55
    L62:
        r27 = 0;
        goto L63
    L64:
        if (r3 != 0) goto L66;
        if (r20 == true) goto L66;
    L67:
        r10.putInt(KEY_DETECT_RESULTS, r17);     // Catch: Exception -> L73
    L75:
        return r10;
    L66:
        r17 = 1;
    L46:
        r20 = false;
        goto L53
    L45:
        if (r0.isEmpty() == false) goto L47;
    L68:
        SaveCheckProvider r28 = this;     // Catch: Exception -> L73
        if (r3 == 0) goto L71;
        r17 = 1;
    L71:
        r10.putInt(KEY_DETECT_RESULTS, r17);     // Catch: Exception -> L73
        return r10;
    L73:
        e = move-exception;
        OLog.e(TAG, "Virus scan error", e);
        r10.putInt(KEY_DETECT_RESULTS, r3);
        goto L75
    L5:
        r5 = false;
        goto L6
    }

    private final String currentTimestamp() {
        String r3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(System.currentTimeMillis()));
        Intrinsics.checkNotNullExpressionValue(r3, "sdf.format(Date(System.currentTimeMillis()))");
        return r3;
    }
}
