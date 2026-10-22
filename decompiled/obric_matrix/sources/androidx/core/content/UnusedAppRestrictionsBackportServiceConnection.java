package androidx.core.content;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportService;

/* JADX INFO: loaded from: classes.dex */
class UnusedAppRestrictionsBackportServiceConnection implements ServiceConnection {
    private final Context mContext;
    private boolean mHasBoundService;

    @NonNull
    ResolvableFuture<Integer> mResultFuture;

    @Nullable
    @VisibleForTesting
    IUnusedAppRestrictionsBackportService mUnusedAppRestrictionsService;

    UnusedAppRestrictionsBackportServiceConnection(@NonNull Context r2) {
        this.mUnusedAppRestrictionsService = null;
        this.mHasBoundService = false;
        this.mContext = r2;
    }

    private IUnusedAppRestrictionsBackportCallback getBackportCallback() {
        return new AnonymousClass1(this);
    }

    public void connectAndFetchResult(@NonNull ResolvableFuture<Integer> r3) {
        if (this.mHasBoundService == true) goto L7;
        this.mHasBoundService = true;
        this.mResultFuture = r3;
        Intent r4 = new Intent(UnusedAppRestrictionsBackportService.ACTION_UNUSED_APP_RESTRICTIONS_BACKPORT_CONNECTION).setPackage(PackageManagerCompat.getPermissionRevocationVerifierApp(this.mContext.getPackageManager()));
        this.mContext.bindService(r4, this, 1);
        return;
    L7:
        throw new IllegalStateException("Each UnusedAppRestrictionsBackportServiceConnection can only be bound once.");
    }

    public void disconnectFromService() {
        if (this.mHasBoundService == false) goto L7;
        this.mHasBoundService = false;
        this.mContext.unbindService(this);
        return;
    L7:
        throw new IllegalStateException("bindService must be called before unbind");
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName r1, IBinder r2) {
        IUnusedAppRestrictionsBackportService r3 = IUnusedAppRestrictionsBackportService.Stub.asInterface(r2);
        this.mUnusedAppRestrictionsService = r3;
        r3.isPermissionRevocationEnabledForApp(getBackportCallback());     // Catch: RemoteException -> L5
        return;
    L5:
        this.mResultFuture.set(0);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName r1) {
        this.mUnusedAppRestrictionsService = null;
    }
}
