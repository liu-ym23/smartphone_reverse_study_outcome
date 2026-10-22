package com.obric.safecheck.service;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.text.TextUtils;
import com.obric.olog.OLog;
import com.obric.security.safecheckapi.ApkInfo;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import tmsdk.common.tcc.DeepCleanSAFEngine;

/* JADX INFO: compiled from: ApkAnalyzer.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/safecheck/service/ApkAnalyzer;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "bytesToHexString", "bytes", "", "algorithm", "calculateFileMd5", "file", "Ljava/io/File;", "getApkInfo", "Lcom/obric/security/safecheckapi/ApkInfo;", "apkPath", "getSignatureBytes", "packageInfo", "Landroid/content/pm/PackageInfo;", "safecheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class ApkAnalyzer {
    private final String TAG;
    private final Context context;

    public ApkAnalyzer(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.context = r2;
        this.TAG = "ApkAnalyzer";
    }

    public final ApkInfo getApkInfo(String r9) {
        if (TextUtils.isEmpty(r9) == false) goto L5;
        return null;
    L5:
        File r0 = new File(r9);
        if (r0.exists() == true) goto L8;
    L24:
        OLog.e(this.TAG, "APK文件不存在或无法读取: " + r9);
        return null;
    L8:
        if (r0.canRead() == false) goto L24;
        PackageManager r2 = this.context.getPackageManager();
        Intrinsics.checkNotNullExpressionValue(r2, "context.packageManager");
        Intrinsics.checkNotNull(r9);     // Catch: Exception -> L13
        PackageInfo r10 = r2.getPackageArchiveInfo(r9, 134217728);     // Catch: Exception -> L13
    L15:
        if (r10 != null) goto L18;
        OLog.e(this.TAG, "无法解析APK信息，可能是文件损坏或路径错误。");
        return null;
    L18:
        String r3 = r10.packageName;
        Intrinsics.checkNotNullExpressionValue(r3, "packageInfo.packageName");
        byte[] r11 = getSignatureBytes(r10);
        if (r11 != null) goto L23;
        OLog.e(this.TAG, "无法获取APK签名字节。");
        return null;
    L23:
        return new ApkInfo(r3, bytesToHexString(r11, "MD5"), bytesToHexString(r11, "SHA-1"), bytesToHexString(r11, "SHA-256"), calculateFileMd5(r0));
    L13:
        e = move-exception;
        OLog.e(this.TAG, "解析APK时发生异常", e);
        r10 = null;
        goto L15
    }

    private final String calculateFileMd5(File r8) {
        MessageDigest r1 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L22
        FileInputStream r2 = new FileInputStream(r8);     // Catch: Throwable -> L22
        FileInputStream r9 = r2;     // Catch: Throwable -> L17
        byte[] r3 = new byte[8192];     // Catch: Throwable -> L17
    L5:
        int r4 = r9.read(r3);     // Catch: Throwable -> L17
        int r5 = 0;
        if (r4 <= 0) goto L8;
        r1.update(r3, 0, r4);     // Catch: Throwable -> L17
        goto L5
    L8:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L17
        CloseableKt.closeFinally(r2, null);     // Catch: Throwable -> L22
        byte[] r11 = r1.digest();     // Catch: Throwable -> L22
        StringBuilder r6 = new StringBuilder();     // Catch: Throwable -> L22
        int r7 = r11.length;     // Catch: Throwable -> L22
    L10:
        if (r5 >= r7) goto L15;
        String r12 = Integer.toHexString(r11[r5] & UByte.MAX_VALUE);     // Catch: Throwable -> L22
        if (r12.length() != 1) goto L14;
        r6.append(DeepCleanSAFEngine.DetailPath.KEY);     // Catch: Throwable -> L22
    L14:
        r6.append(r12);     // Catch: Throwable -> L22
        r5 = r5 + 1;     // Catch: Throwable -> L22
        goto L10
    L15:
        String r13 = r6.toString();     // Catch: Throwable -> L22
        Intrinsics.checkNotNullExpressionValue(r13, "sb.toString()");     // Catch: Throwable -> L22
        String r14 = r13.toUpperCase();     // Catch: Throwable -> L22
        Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String).toUpperCase()");     // Catch: Throwable -> L22
        return r14;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        CloseableKt.closeFinally(r2, th);     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        OLog.e(this.TAG, "calc apk file md5 failed", th);
        return null;
    }

    private final byte[] getSignatureBytes(PackageInfo r2) {
        SigningInfo r1 = r2.signingInfo;
        if (r1 != null) goto L5;
        return null;
    L5:
        Intrinsics.checkNotNullExpressionValue(r1, "packageInfo.signingInfo ?: return null");
        if (r1.hasMultipleSigners() == false) goto L10;
        Signature[] r3 = r1.getApkContentsSigners();
        Intrinsics.checkNotNullExpressionValue(r3, "signingInfo.apkContentsSigners");
        Signature r4 = (Signature) ArraysKt.firstOrNull(r3);
        if (r4 != null) goto L15;
        return null;
    L15:
        return r4.toByteArray();
    L10:
        Signature[] r5 = r1.getSigningCertificateHistory();
        Intrinsics.checkNotNullExpressionValue(r5, "signingInfo.signingCertificateHistory");
        Signature r6 = (Signature) ArraysKt.firstOrNull(r5);
        if (r6 != null) goto L13;
        return null;
    L13:
        return r6.toByteArray();
    }

    private final String bytesToHexString(byte[] r7, String r8) {
        MessageDigest r0 = MessageDigest.getInstance(r8);     // Catch: NoSuchAlgorithmException -> L10
        r0.update(r7);     // Catch: NoSuchAlgorithmException -> L10
        byte[] r9 = r0.digest();     // Catch: NoSuchAlgorithmException -> L10
        StringBuilder r1 = new StringBuilder();     // Catch: NoSuchAlgorithmException -> L10
        int r2 = r9.length;     // Catch: NoSuchAlgorithmException -> L10
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L8;
        String r4 = Integer.toHexString(r9[r3] & UByte.MAX_VALUE);     // Catch: NoSuchAlgorithmException -> L10
        if (r4.length() != 1) goto L7;
        r1.append(DeepCleanSAFEngine.DetailPath.KEY);     // Catch: NoSuchAlgorithmException -> L10
    L7:
        r1.append(r4);     // Catch: NoSuchAlgorithmException -> L10
        r3 = r3 + 1;     // Catch: NoSuchAlgorithmException -> L10
        goto L3
    L8:
        String r10 = r1.toString();     // Catch: NoSuchAlgorithmException -> L10
        Intrinsics.checkNotNullExpressionValue(r10, "sb.toString()");     // Catch: NoSuchAlgorithmException -> L10
        String r11 = r10.toUpperCase();     // Catch: NoSuchAlgorithmException -> L10
        Intrinsics.checkNotNullExpressionValue(r11, "this as java.lang.String).toUpperCase()");     // Catch: NoSuchAlgorithmException -> L10
        return r11;
    L10:
        e = move-exception;
        OLog.e(this.TAG, "不支持的哈希算法: " + r8, e);
        return "";
    }
}
