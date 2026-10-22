package com.android.server;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.IVold;
import android.util.Slog;
import com.android.server.voiceinteraction.ObricVoiceInteractionSessionConnectionImpl;

/* JADX INFO: loaded from: classes.dex */
public class ObricStorageManagerServiceImpl implements IObricStorageManagerService {
    private static final String TAG = "ObricStorageManagerServiceImpl";
    private StorageManagerService mService;

    public ObricStorageManagerServiceImpl(StorageManagerService base) {
        this.mService = base;
    }

    private boolean packageNameCheck(String packageName) {
        String[] r0 = {"com.obric.aikernel", ObricVoiceInteractionSessionConnectionImpl.COM_LARUS_NOVA, "com.android.gallery3d"};
        int r2 = 0;
    L4:
        if (r2 >= 3) goto L10;
        String str = r0[r2];
        if (str.equals(packageName) == true) goto L7;
        r2 = r2 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    private boolean packageSignatureCheck(Context context, String packageName) {
        if (ObricVoiceInteractionSessionConnectionImpl.COM_LARUS_NOVA.equals(packageName) == false) goto L5;
        return true;
    L5:
        PackageManager pm = context.getPackageManager();
        if (pm.checkSignatures(packageName, "android") != 0) goto L8;
        return true;
    L8:
        return false;
    }

    private boolean uidCheck(int uid) {
        if (uid != 1000) goto L6;
        return true;
    L6:
        return false;
    }

    private boolean packageCheck(Context context) {
        int callingUid = Binder.getCallingUid();
        if (uidCheck(callingUid) == false) goto L5;
        return true;
    L5:
        String[] packages = context.getPackageManager().getPackagesForUid(callingUid);
        if (packageNameCheck(packages[0]) == true) goto L10;
        Slog.e(TAG, packages[0] + "package name is not in list");
        return false;
    L10:
        if (packageSignatureCheck(context, packages[0]) == true) goto L13;
        Slog.e(TAG, packages[0] + "package signature err");
        return false;
    L13:
        return true;
    }

    public void serviceKeyInit(Context context, IVold vold, int serviceId, int userId, byte[] secret) {
        if (packageCheck(context) == false) goto L11;
        vold.serviceKeyInit(serviceId, userId, Binder.getCallingUid(), secret);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        Slog.wtf(TAG, e);
        return;
    }

    public void serviceKeyDelete(Context context, IVold vold, int serviceId, int userId) {
        if (packageCheck(context) == false) goto L11;
        vold.serviceKeyDelete(serviceId, userId);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        Slog.wtf(TAG, e);
        return;
    }

    public void serviceLockStorage(Context context, IVold vold, int serviceId, int userId) {
        if (packageCheck(context) == false) goto L11;
        vold.serviceLockStorage(serviceId, userId);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        Slog.wtf(TAG, e);
        return;
    }

    public void serviceUnlockStorage(Context context, IVold vold, int serviceId, int userId, byte[] secret) {
        if (packageCheck(context) == false) goto L11;
        vold.serviceUnlockStorage(serviceId, userId, secret);     // Catch: Exception -> L6
        return;
    L6:
        e = move-exception;
        Slog.wtf(TAG, e);
        return;
    }
}
