package androidx.core.content;

import android.os.RemoteException;
import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback;

/* JADX INFO: loaded from: classes.dex */
public class UnusedAppRestrictionsBackportCallback {
    private IUnusedAppRestrictionsBackportCallback mCallback;

    public UnusedAppRestrictionsBackportCallback(IUnusedAppRestrictionsBackportCallback r1) {
        this.mCallback = r1;
    }

    public void onResult(boolean r1, boolean r2) throws RemoteException {
        this.mCallback.onIsPermissionRevocationEnabledForAppResult(r1, r2);
    }
}
