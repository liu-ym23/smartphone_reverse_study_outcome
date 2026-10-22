package com.bytedance.securityserver.trustcircle;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.bytedance.securityserver.utils.GlobalContext;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class LockEventService extends Service {
    public final IBinder b;

    public static final class ServiceStub extends ILockEventService.Stub {
        private final WeakReference<LockEventService> mService;

        public ServiceStub(LockEventService r2) {
            this.mService = new WeakReference(r2);
        }

        @Override // com.bytedance.securityserver.trustcircle.ILockEventService
        public void onLockEvent(int r1, int r2, byte[] r3, Bundle r4) {
            Log.i("SecurityServer-LockEventService", "onLockEvent in, event type: " + r1 + ", credentialType: " + r2);
            int r0 = Binder.getCallingUid();
            GlobalContext.f82a.getPackageManager().getNameForUid(r0);
            if (r0 == 1000) goto L7;
            Log.e("SecurityServer-LockEventService", "Permission deny, caller is not system app");
            return;
        L7:
            if (r1 != 1) goto L9;
            return;
        L9:
            if (r1 != 2) goto L11;
            return;
        L11:
            if (r1 != 3) goto L13;
            return;
        L13:
            if (r1 == 4) goto L19;
            Log.e("SecurityServer-LockEventService", "unknown event type");
            return;
        }
    }

    public LockEventService() {
        this.b = new ServiceStub(this);
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r1) {
        return this.b;
    }
}
