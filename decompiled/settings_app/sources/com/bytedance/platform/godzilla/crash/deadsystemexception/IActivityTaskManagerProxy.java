package com.bytedance.platform.godzilla.crash.deadsystemexception;

import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodDelegate;
import com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodProxy;
import com.bytedance.platform.godzilla.utils.FieldUtils;
import com.bytedance.platform.godzilla.utils.MethodUtils;
import com.bytedance.platform.godzilla.utils.ProxyHelper;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes3.dex */
public class IActivityTaskManagerProxy extends MethodProxy {
    private static final String TAG = "IActivityTaskManagerProxy";

    /* JADX INFO: renamed from: com.bytedance.platform.godzilla.crash.deadsystemexception.IActivityTaskManagerProxy$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class IpcProtectInterface extends MethodDelegate {
        private IpcProtectInterface() {
        }

        /* synthetic */ IpcProtectInterface(AnonymousClass1 r1) {
            this();
        }

        @Override // com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodDelegate
        public Object beforeInvoke(Object r3, Method r4, Object[] r5) {
            Logger.e(IActivityTaskManagerProxy.TAG, r4.getName() + " is called!");
            return super.beforeInvoke(r3, r4, r5);
        }
    }

    public IActivityTaskManagerProxy() {
    }

    @Override // com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodProxy
    public void onInstall() {
        Object r2 = FieldUtils.readStaticField(Class.forName("android.app.ActivityTaskManager"), "IActivityTaskManagerSingleton");     // Catch: Throwable -> L13
        if (Class.forName("android.util.Singleton").isInstance(r2) == false) goto L18;
        Object r3 = FieldUtils.readField(r2, "mInstance");     // Catch: Throwable -> L13
        if (r3 != null) goto L8;
        r3 = MethodUtils.getAccessibleMethod(r2.getClass(), "get", new Class[0]).invoke(r2, new Object[0]);     // Catch: Throwable -> L13
    L8:
        if (r3 != null) goto L10;
        return;
    L10:
        if (Proxy.isProxyClass(r3.getClass()) == true) goto L20;
        setTarget(r3);     // Catch: Throwable -> L13
        FieldUtils.writeField(r2, "mInstance", ProxyHelper.createProxy(r3, this));     // Catch: Throwable -> L13
        Logger.e(TAG, "Hook proxy ActivityTaskManager success!!!");     // Catch: Throwable -> L13
        return;
    L20:
        return;
    L18:
        return;
    L13:
        th = move-exception;
        Logger.e(TAG, "Hook proxy ActivityTaskManager Failed!!!");
        th.printStackTrace();
    }

    static {
        AnonymousClass1 r1 = null;
        addMethodDelegate("activityDestroyed", new IpcProtectInterface(r1));
        addMethodDelegate("activitySlept", new IpcProtectInterface(r1));
    }
}
