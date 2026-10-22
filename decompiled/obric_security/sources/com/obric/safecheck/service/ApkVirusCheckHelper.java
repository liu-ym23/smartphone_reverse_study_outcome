package com.obric.safecheck.service;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ApplicationInfoEx;
import android.content.pm.PackageManager;
import android.util.Log;
import com.obric.safecheck.AntiVirusWhiteListSettings;
import com.obric.safecheck.PackageInfo;
import com.obric.safecheck.database.VirusDatabase;
import com.obric.safecheck.database.entity.VirusApkItem;
import com.obric.safecheck.provider.ApkVirusCheckProvider;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApkVirusCheckHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004J\u0016\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/safecheck/service/ApkVirusCheckHelper;", "", "()V", "TAG", "", "VIRUS_CODE_NOT_VIRUS", "", "VIRUS_CODE_UNKNOWN", "VIRUS_TYPE_NONE", "VIRUS_TYPE_UNKNOWN", "checkPackage", "Lcom/obric/safecheck/service/ApkVirusCheckHelper$ScanResult;", "context", "Landroid/content/Context;", ApkVirusCheckProvider.KEY_PKG, "isObricApp", "", "isSystemApp", "unknownResult", "ScanResult", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class ApkVirusCheckHelper {
    public static final ApkVirusCheckHelper INSTANCE = null;
    private static final String TAG = "ApkVirusCheckHelper";
    private static final int VIRUS_CODE_NOT_VIRUS = 0;
    private static final int VIRUS_CODE_UNKNOWN = 3;
    private static final String VIRUS_TYPE_NONE = "none";
    private static final String VIRUS_TYPE_UNKNOWN = "unknown";

    /* JADX INFO: compiled from: ApkVirusCheckHelper.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/obric/safecheck/service/ApkVirusCheckHelper$ScanResult;", "", ApkVirusCheckProvider.KEY_VIRUS_TYPE, "", ApkVirusCheckProvider.KEY_VIRUS_TYPE_CODE, "", "(Ljava/lang/String;I)V", "getVirusType", "()Ljava/lang/String;", "getVirusTypeCode", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ScanResult {
        private final String virusType;
        private final int virusTypeCode;

        public static /* synthetic */ ScanResult copy$default(ScanResult r0, String r1, int r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.virusType;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.virusTypeCode;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.virusType;
        }

        public final int component2() {
            return this.virusTypeCode;
        }

        public final ScanResult copy(String r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, ApkVirusCheckProvider.KEY_VIRUS_TYPE);
            return new ScanResult(r1, r2);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof ScanResult) == false) goto L10;
            ScanResult r4 = (ScanResult) r3;
            if (Intrinsics.areEqual(this.virusType, r4.virusType) == true) goto L8;
            return false;
        L8:
            if (this.virusTypeCode == r4.virusTypeCode) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            String r0 = this.virusType;
            if (r0 == null) goto L5;
            int r1 = r0.hashCode();
        L7:
            return (r1 * 31) + Integer.hashCode(this.virusTypeCode);
        L5:
            r1 = 0;
            goto L7
        }

        public String toString() {
            return "ScanResult(virusType=" + this.virusType + ", virusTypeCode=" + this.virusTypeCode + ")";
        }

        public ScanResult(String r2, int r3) {
            Intrinsics.checkNotNullParameter(r2, ApkVirusCheckProvider.KEY_VIRUS_TYPE);
            this.virusType = r2;
            this.virusTypeCode = r3;
        }

        public final String getVirusType() {
            return this.virusType;
        }

        public final int getVirusTypeCode() {
            return this.virusTypeCode;
        }
    }

    static {
        INSTANCE = new ApkVirusCheckHelper();
    }

    private ApkVirusCheckHelper() {
    }

    public final ScanResult checkPackage(Context r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r7, ApkVirusCheckProvider.KEY_PKG);
        if (isSystemApp(r6, r7) == false) goto L5;
    L31:
        Log.d(TAG, "checkPackage skip scan for system/orbic app, pkg=" + r7);
        return new ScanResult("none", 0);
    L5:
        if (isObricApp(r6, r7) == true) goto L31;
        List<PackageInfo> r0 = AntiVirusWhiteListSettings.getValue();
        if (r0 == null) goto L33;
        List<PackageInfo> r1 = r0;
        if ((r1 instanceof Collection) == true) goto L12;
    L14:
        Iterator<T> r2 = r1.iterator();
    L16:
        if (r2.hasNext() == false) goto L13;
        if (Intrinsics.areEqual(((PackageInfo) r2.next()).getPkgName(), r7) == false) goto L16;
        boolean r3 = true;
    L20:
        if (r3 == false) goto L33;
        Log.d(TAG, "checkPackage skip scan for whitelist app, pkg=" + r7);
        return new ScanResult("none", 0);
    L13:
        r3 = false;
        goto L20
    L12:
        if (r1.isEmpty() == false) goto L14;
    L33:
        VirusDatabase r8 = VirusDatabase.Companion.getDatabase(r6);     // Catch: Throwable -> L28
        Log.d(TAG, "checkPackage query start, pkg=" + r7);     // Catch: Throwable -> L28
        List<VirusApkItem> r9 = r8.virusApkDao().getByPkg(r7);     // Catch: Throwable -> L28
        Log.d(TAG, "checkPackage query end, count=" + r9.size());     // Catch: Throwable -> L28
        if (r9.isEmpty() == true) goto L37;
        VirusApkItem r10 = (VirusApkItem) CollectionsKt.first(r9);     // Catch: Throwable -> L28
        return new ScanResult(r10.getVirusType(), r10.getVirusTypeCode());
    L37:
        return unknownResult();
    L28:
        th = move-exception;
        Log.w(TAG, "checkPackage query error, pkg=" + r7, th);
        return unknownResult();
    }

    public final ScanResult unknownResult() {
        return new ScanResult("unknown", 3);
    }

    public final boolean isSystemApp(Context r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        Intrinsics.checkNotNullParameter(r2, ApkVirusCheckProvider.KEY_PKG);
        ApplicationInfo r3 = r1.getPackageManager().getApplicationInfo(r2, 0);     // Catch: PackageManager.NameNotFoundException -> L10
        Intrinsics.checkNotNullExpressionValue(r3, "context.packageManager.getApplicationInfo(pkg, 0)");     // Catch: PackageManager.NameNotFoundException -> L10
        int r4 = r3.flags;     // Catch: PackageManager.NameNotFoundException -> L10
        if ((r4 & 1) == 0) goto L7;
    L8:
        return true;
    L7:
        if ((r4 & 128) != 0) goto L8;
        return false;
    L14:
        return false;
    }

    public final boolean isObricApp(Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, ApkVirusCheckProvider.KEY_PKG);
        ApplicationInfo r5 = r3.getPackageManager().getApplicationInfo(r4, 0);     // Catch: Throwable -> L5 PackageManager.NameNotFoundException -> L8
        Intrinsics.checkNotNullExpressionValue(r5, "context.packageManager.getApplicationInfo(pkg, 0)");     // Catch: Throwable -> L5 PackageManager.NameNotFoundException -> L8
        goto L12
    L11:
        return ApplicationInfoEx.isObricApp(r5);
    L5:
        th = move-exception;
        Log.w(TAG, "isObricApp error, pkg=" + r4, th);
        return false;
    L12:
        return false;
    }
}
