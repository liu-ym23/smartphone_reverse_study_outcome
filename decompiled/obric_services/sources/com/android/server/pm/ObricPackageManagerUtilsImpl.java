package com.android.server.pm;

import android.content.pm.PkgSignForNative;
import android.content.pm.Signature;
import android.content.pm.SigningDetails;
import android.os.Binder;
import android.util.Slog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ObricPackageManagerUtilsImpl implements IObricPackageManagerUtils {
    private static final String TAG = "ObricPackageManagerUtilsImpl";
    private PackageManagerNative mService;

    public ObricPackageManagerUtilsImpl(PackageManagerNative base) {
        this.mService = base;
    }

    public List<PkgSignForNative> getSignaturesForUid(PackageManagerService pms, int uid) {
        List<PkgSignForNative> signatureList = new ArrayList();
        int callingUid = Binder.getCallingUid();
        if (callingUid == 1000) goto L6;
        Slog.e(TAG, "permission denied.");
        return signatureList;
    L6:
        SigningDetails signDetails = pms.snapshotComputer().getSigningDetails(uid);
        if (signDetails != null) goto L10;
        Slog.e(TAG, "getSigningDetails failed.");
        return signatureList;
    L10:
        Signature[] signatures = signDetails.getSignatures();
        if (signatures != null) goto L13;
    L22:
        Slog.e(TAG, "getSignatures failed.");
        return signatureList;
    L13:
        if (signatures.length == 0) goto L22;
        int r3 = signatures.length;
        int r5 = 0;
    L16:
        if (r5 >= r3) goto L21;
        Signature signature = signatures[r5];
        if (signature == null) goto L20;
        PkgSignForNative pkgSign = new PkgSignForNative();
        pkgSign.signature = signature.toByteArray();
        signatureList.add(pkgSign);
    L20:
        r5 = r5 + 1;
        goto L16
    L21:
        return signatureList;
    }
}
