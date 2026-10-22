package com.bytedance.platform.godzilla.crash.deadsystemexception;

import android.os.IBinder;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodDelegate;
import com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodProxy;
import com.bytedance.platform.godzilla.crash.boostcrash.impl.deadobject.IBinderProxy;
import com.bytedance.platform.godzilla.utils.MethodUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class IConnectivityManagerProxy extends MethodProxy {
    private static final String TAG = "IConnectivityManagerProxy";

    /* JADX INFO: renamed from: com.bytedance.platform.godzilla.crash.deadsystemexception.IConnectivityManagerProxy$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class IpcProtectInterface extends MethodDelegate {
        private IpcProtectInterface() {
        }

        /* synthetic */ IpcProtectInterface(AnonymousClass1 r1) {
            this();
        }

        @Override // com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodDelegate
        public Object beforeInvoke(Object r1, Method r2, Object[] r3) {
            return super.beforeInvoke(r1, r2, r3);
        }
    }

    public IConnectivityManagerProxy() {
    }

    @Override // com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodProxy
    public void onInstall() {
        IBinderProxy r1 = new IBinderProxy("connectivity", this);     // Catch: Exception -> L5
        r1.onInstall();     // Catch: Exception -> L5
        setTarget(MethodUtils.getAccessibleMethod(Class.forName("android.net.IConnectivityManager$Stub"), "asInterface", new Class[]{IBinder.class}).invoke(null, new Object[]{r1.getTarget()}));     // Catch: Exception -> L5
        Logger.e(TAG, "Hook proxy success!");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Logger.e(TAG, "Hook proxy connectivity Failed!!!");
        e.printStackTrace();
    }

    static {
        AnonymousClass1 r1 = null;
        addMethodDelegate("getNetworkCapabilities", new IpcProtectInterface(r1));
        addMethodDelegate("getAllNetworks", new IpcProtectInterface(r1));
        addMethodDelegate("getLinkProperties", new IpcProtectInterface(r1));
        addMethodDelegate("getActiveNetworkInfo", new IpcProtectInterface(r1));
    }
}
