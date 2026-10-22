package com.zte.settings.backup;

import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Binder;
import android.os.IBinder;
import com.android.vcard.VCardConfig;
import com.obric.olog.OLog;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes5.dex */
public class DataBackupService extends Service {
    private static final String PACKAGE_NAME = "cuuca.sendfiles.Activity";
    private static final String TAG = "DataBackupService";
    private static final String TARGET_SIGN_HASH = "D9731DBEFDC00B288CBF7A36126B0AC1A8ADE04B39E28545EB96714074443E19";
    private final IBackupController.Stub mBinder;

    public DataBackupService() {
        this.mBinder = new AnonymousClass1(this);
    }

    static /* synthetic */ String access$000(DataBackupService r0) {
        return r0.getCallingPackage();
    }

    static /* synthetic */ boolean access$100(DataBackupService r0, String r1) {
        return r0.checkSignature(r1);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r1) {
        return this.mBinder;
    }

    private String getCallingPackage() {
        int r0 = Binder.getCallingUid();     // Catch: Exception -> L4
        return getPackageManager().getNameForUid(r0);
    L4:
        e = move-exception;
        OLog.e(TAG, "getCallingPackage", e);
        return null;
    }

    private boolean checkSignature(String r6) {
        PackageInfo r7 = getPackageManager().getPackageInfo(r6, VCardConfig.FLAG_CONVERT_PHONETIC_NAME_STRINGS);     // Catch: Exception -> L18
        if (r7.signingInfo != null) goto L6;
        Signature[] r8 = null;
    L10:
        if (r8 == null) goto L20;
        int r1 = r8.length;     // Catch: Exception -> L18
        int r2 = 0;
    L12:
        if (r2 >= r1) goto L20;
        if (getSHA256(r8[r2].toByteArray()).equalsIgnoreCase(TARGET_SIGN_HASH) == true) goto L15;
        r2 = r2 + 1;
        goto L12
    L15:
        return true;
    L20:
        return false;
    L6:
        if (r7.signingInfo.hasMultipleSigners() == false) goto L8;
        r8 = r7.signingInfo.getApkContentsSigners();     // Catch: Exception -> L18
        goto L10
    L8:
        r8 = r7.signingInfo.getSigningCertificateHistory();     // Catch: Exception -> L18
    L18:
        e = move-exception;
        OLog.e(TAG, "Signature check failed", e);
        goto L20
    }

    private String getSHA256(byte[] r6) {
        byte[] r5 = MessageDigest.getInstance("SHA-256").digest(r6);     // Catch: Exception -> L10
        StringBuilder r7 = new StringBuilder();     // Catch: Exception -> L10
        int r0 = r5.length;     // Catch: Exception -> L10
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        String r2 = Integer.toHexString(r5[r1] & 255);     // Catch: Exception -> L10
        if (r2.length() != 1) goto L7;
        r7.append('0');     // Catch: Exception -> L10
    L7:
        r7.append(r2);     // Catch: Exception -> L10
        r1 = r1 + 1;     // Catch: Exception -> L10
        goto L3
    L8:
        return r7.toString().toUpperCase();
    L10:
        e = move-exception;
        OLog.e(TAG, "SHA-256 algorithm not available", e);
        return "";
    }
}
