package com.obric.safecheck.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm.alog.AlogMonitor;
import com.obric.safecheck.service.ApkVirusCheckHelper;
import com.obric.safecheck.task.PackageAddedTasks;
import com.obric.security.health.score.HealthModuleIds;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ApkVirusCheckProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016J1\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0010\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\nH\u0002J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u0017\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0002J\u001c\u0010\u0018\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016JO\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u000b\u001a\u00020\f2\u0010\u0010\u001f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0010\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u000f2\b\u0010 \u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010!J;\u0010\"\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\u0010\u0010\u000e\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0006\u0018\u00010\u000fH\u0016¢\u0006\u0002\u0010#¨\u0006%"}, d2 = {"Lcom/obric/safecheck/provider/ApkVirusCheckProvider;", "Landroid/content/ContentProvider;", "()V", NotificationCompat.CATEGORY_CALL, "Landroid/os/Bundle;", "method", "", "arg", "extras", "delete", "", "uri", "Landroid/net/Uri;", "selection", "selectionArgs", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "enforceSystemCaller", "", "failureBundle", AlogMonitor.ALOG_RESULT_CODE, "getType", "handleCheckApk", "handleCheckApkBatch", "insert", "values", "Landroid/content/ContentValues;", "onCreate", "", "query", "Landroid/database/Cursor;", "projection", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", HealthModuleIds.UPDATE, "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "Companion", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class ApkVirusCheckProvider extends ContentProvider {
    public static final Companion Companion = null;
    public static final String KEY_PKG = "pkg";
    public static final String KEY_PKGS = "pkgs";
    public static final String KEY_RESULT = "result";
    public static final String KEY_RESULTS = "results";
    public static final String KEY_VIRUS_TYPE = "virusType";
    public static final String KEY_VIRUS_TYPE_CODE = "virusTypeCode";
    public static final String METHOD_CHECK_APK = "checkApk";
    public static final String METHOD_CHECK_APK_BATCH = "checkApkBatch";
    private static final String TAG = "ApkVirusCheckProvider";
    public static final int VIRUS_CODE_NOT_VIRUS = 0;
    public static final int VIRUS_CODE_OTHER = 2;
    public static final int VIRUS_CODE_SEX = 1;
    public static final int VIRUS_CODE_UNKNOWN = 3;

    /* JADX INFO: compiled from: ApkVirusCheckProvider.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/safecheck/provider/ApkVirusCheckProvider$Companion;", "", "()V", "KEY_PKG", "", "KEY_PKGS", "KEY_RESULT", "KEY_RESULTS", "KEY_VIRUS_TYPE", "KEY_VIRUS_TYPE_CODE", "METHOD_CHECK_APK", "METHOD_CHECK_APK_BATCH", "TAG", "VIRUS_CODE_NOT_VIRUS", "", "VIRUS_CODE_OTHER", "VIRUS_CODE_SEX", "VIRUS_CODE_UNKNOWN", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r1) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r1, ContentValues r2) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        Intrinsics.checkNotNullParameter(r1, "uri");
        return 0;
    }

    public ApkVirusCheckProvider() {
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Log.i(TAG, "onCreate");
        return true;
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r11, String r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r11, "method");
        if (r13 == null) goto L7;
        Set<String> r0 = r13.keySet();
        if (r0 == null) goto L7;
        String r1 = CollectionsKt.joinToString$default(r0, null, null, null, 0, null, null, 63, null);
    L8:
        Log.d(TAG, "call method=" + r11 + " arg=" + r12 + " extrasKeys=" + r1);
        int r14 = r11.hashCode();
        if (r14 == (-882958426)) goto L17;
        if (r14 != 1536860148) goto L20;
        if (r11.equals(METHOD_CHECK_APK) == false) goto L20;
        return handleCheckApk(r13);
    L20:
        return failureBundle(-3);
    L17:
        if (r11.equals(METHOD_CHECK_APK_BATCH) == false) goto L20;
        return handleCheckApkBatch(r13);
    L7:
        r1 = null;
        goto L8
    }

    private final Bundle handleCheckApk(Bundle r8) {
        if (r8 == null) goto L4;
        String r9 = r8.getString(KEY_PKG);
    L5:
        String r0 = r9;
        if (r0 != null) goto L8;
    L11:
        boolean r1 = true;
    L12:
        if (r1 == true) goto L14;
        Log.d(TAG, "handleCheckApk pkg=" + r9);
        Context r2 = getContext();
        if (r2 == null) goto L19;
        ApkVirusCheckHelper r3 = ApkVirusCheckHelper.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r2, "it");
        ApkVirusCheckHelper.ScanResult r4 = r3.checkPackage(r2, r9);
        if (r4 == null) goto L19;
    L20:
        Log.d(TAG, "handleCheckApk result type=" + r4.getVirusType() + " code=" + r4.getVirusTypeCode());
        if (r4.getVirusTypeCode() != 3) goto L28;
        Context r7 = getContext();
        if (r7 == null) goto L28;
        Intrinsics.checkNotNullExpressionValue(r7, "ctx");     // Catch: Throwable -> L26
        PackageAddedTasks.execute(r7, r9, 0);     // Catch: Throwable -> L26
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        Integer.valueOf(Log.w(TAG, "trigger PackageAddedTasks error", th));
    L28:
        Bundle r11 = new Bundle();
        r11.putInt("result", 0);
        r11.putString(KEY_VIRUS_TYPE, r4.getVirusType());
        r11.putInt(KEY_VIRUS_TYPE_CODE, r4.getVirusTypeCode());
        return r11;
    L19:
        r4 = ApkVirusCheckHelper.INSTANCE.unknownResult();
        goto L20
    L14:
        return failureBundle(-4);
    L8:
        if (r0.length() == 0) goto L11;
        r1 = false;
        goto L12
    L4:
        r9 = null;
        goto L5
    }

    private final Bundle handleCheckApkBatch(Bundle r14) {
        if (r14 == null) goto L4;
        String[] r15 = r14.getStringArray(KEY_PKGS);
    L5:
        if (r15 == null) goto L32;
        if (r15.length != 0) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == true) goto L32;
        Log.d(TAG, "handleCheckApkBatch size=" + r15.length);
        Bundle r1 = new Bundle();
        int r3 = r15.length;
        int r4 = 0;
    L14:
        if (r4 >= r3) goto L29;
        String r6 = r15[r4];
        Context r7 = getContext();
        if (r7 == null) goto L19;
        ApkVirusCheckHelper r9 = ApkVirusCheckHelper.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r7, "it");
        Intrinsics.checkNotNullExpressionValue(r6, "p");
        ApkVirusCheckHelper.ScanResult r8 = r9.checkPackage(r7, r6);
        if (r8 == null) goto L19;
    L20:
        Log.d(TAG, "batch item pkg=" + r6 + " result type=" + r8.getVirusType() + " code=" + r8.getVirusTypeCode());
        if (r8.getVirusTypeCode() != 3) goto L28;
        Context r10 = getContext();
        if (r10 == null) goto L28;
        Intrinsics.checkNotNullExpressionValue(r10, "ctx");     // Catch: Throwable -> L26
        Intrinsics.checkNotNullExpressionValue(r6, "p");     // Catch: Throwable -> L26
        PackageAddedTasks.execute(r10, r6, 0);     // Catch: Throwable -> L26
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        Integer.valueOf(Log.w(TAG, "batch trigger error for pkg=" + r6, th));
    L28:
        Bundle r12 = new Bundle();
        r12.putInt("result", 0);
        r12.putString(KEY_VIRUS_TYPE, r8.getVirusType());
        r12.putInt(KEY_VIRUS_TYPE_CODE, r8.getVirusTypeCode());
        r1.putBundle(r6, r12);
        r4 = r4 + 1;
    L19:
        r8 = ApkVirusCheckHelper.INSTANCE.unknownResult();
        goto L20
    L29:
        Bundle r13 = new Bundle();
        r13.putInt("result", 0);
        r13.putBundle(KEY_RESULTS, r1);
        return r13;
    L9:
        r0 = false;
    L32:
        return failureBundle(-4);
    L4:
        r15 = null;
        goto L5
    }

    private final Bundle failureBundle(int r2) {
        Bundle r1 = new Bundle();
        r1.putInt("result", r2);
        return r1;
    }

    private final void enforceSystemCaller() {
        Context r0 = getContext();
        if (r0 == null) goto L17;
        Intrinsics.checkNotNullExpressionValue(r0, "context ?: throw SecurityException(\"no context\")");
        if (Binder.getCallingUid() != Process.myUid()) goto L7;
        return;
    L7:
        String r3 = getCallingPackage();
        if (r3 == null) goto L15;
        Intrinsics.checkNotNullExpressionValue(r3, "callingPackage ?: throw …\"unknown caller package\")");
        if (ApkVirusCheckHelper.INSTANCE.isSystemApp(r0, r3) == false) goto L13;
        return;
    L13:
        throw new SecurityException("Caller must be system app, pkg=" + r3);
    L15:
        throw new SecurityException("unknown caller package");
    L17:
        throw new SecurityException("no context");
    }
}
