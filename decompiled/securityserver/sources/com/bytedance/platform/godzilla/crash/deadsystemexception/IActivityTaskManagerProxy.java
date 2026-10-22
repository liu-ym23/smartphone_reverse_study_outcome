package com.bytedance.platform.godzilla.crash.deadsystemexception;

import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodDelegate;
import com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodProxy;
import com.bytedance.platform.godzilla.utils.FieldUtils;
import com.bytedance.platform.godzilla.utils.MethodUtils;
import com.bytedance.platform.godzilla.utils.ProxyHelper;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* JADX INFO: loaded from: classes.dex */
public class IActivityTaskManagerProxy extends MethodProxy {
    private static final String TAG = "IActivityTaskManagerProxy";

    /* JADX INFO: renamed from: com.bytedance.platform.godzilla.crash.deadsystemexception.IActivityTaskManagerProxy$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class IpcProtectInterface extends MethodDelegate {
        private IpcProtectInterface() {
        }

        @Override // com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodDelegate
        public Object beforeInvoke(Object r3, Method r4, Object[] r5) {
            Logger.e(IActivityTaskManagerProxy.TAG, r4.getName() + " is called!");
            return super.beforeInvoke(r3, r4, r5);
        }

        public /* synthetic */ IpcProtectInterface(AnonymousClass1 r1) {
            this();
        }
    }

    static {
        AnonymousClass1 r1 = null;
        MethodProxy.addMethodDelegate("activityDestroyed", new IpcProtectInterface(r1));
        MethodProxy.addMethodDelegate("activitySlept", new IpcProtectInterface(r1));
    }

    public IActivityTaskManagerProxy() {
    }

    @Override // com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodProxy
    public void onInstall() {
        Object r2 = FieldUtils.readStaticField(Class.forName("android.app.ActivityTaskManager"), "IActivityTaskManagerSingleton");     // Catch: Throwable -> L8
        if (Class.forName("android.util.Singleton").isInstance(r2) == false) goto L19;
        Object r3 = FieldUtils.readField(r2, "mInstance");     // Catch: Throwable -> L8
        if (r3 != null) goto L10;
        r3 = MethodUtils.getAccessibleMethod(r2.getClass(), "get", new Class[0]).invoke(r2, null);     // Catch: Throwable -> L8
    L10:
        if (r3 != null) goto L12;
        return;
    L12:
        if (Proxy.isProxyClass(r3.getClass()) == true) goto L21;
        setTarget(r3);     // Catch: Throwable -> L8
        FieldUtils.writeField(r2, "mInstance", ProxyHelper.createProxy(r3, this));     // Catch: Throwable -> L8
        Logger.e(TAG, "Hook proxy ActivityTaskManager success!!!");     // Catch: Throwable -> L8
        return;
    L21:
        return;
    L19:
        return;
    L8:
        th = move-exception;
        Logger.e(TAG, "Hook proxy ActivityTaskManager Failed!!!");
        th.printStackTrace();
    }
}
