package com.bytedance.platform.godzilla.crash.deadsystemexception;

import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodDelegate;
import com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodProxy;
import com.bytedance.platform.godzilla.utils.FieldUtils;
import com.bytedance.platform.godzilla.utils.ProxyHelper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class IDisplayManagerProxy extends MethodProxy {

    /* JADX INFO: renamed from: com.bytedance.platform.godzilla.crash.deadsystemexception.IDisplayManagerProxy$1, reason: invalid class name */
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
            Logger.e("IDisplayManagerProxy", r4.getName() + " is called!");
            return super.beforeInvoke(r3, r4, r5);
        }
    }

    public IDisplayManagerProxy() {
    }

    @Override // com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodProxy
    public void onInstall() {
        Class<?> r1 = Class.forName("android.hardware.display.DisplayManagerGlobal");     // Catch: Exception -> L5
        Object r2 = FieldUtils.getField(r1, "sInstance").get(null);     // Catch: Exception -> L5
        Field r3 = FieldUtils.getField(r1, "mDm");     // Catch: Exception -> L5
        Object r4 = r3.get(r2);     // Catch: Exception -> L5
        setTarget(r4);     // Catch: Exception -> L5
        r3.set(r2, ProxyHelper.createProxy(r4, this));     // Catch: Exception -> L5
        Logger.e("IDisplayManagerProxy", "mDm is " + r3.get(r2).getClass().getName());     // Catch: Exception -> L5
        return;
    }

    static {
        addMethodDelegate("getDisplayInfo", new IpcProtectInterface(null));
    }
}
