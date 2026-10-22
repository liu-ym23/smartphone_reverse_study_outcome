package com.bytedance.platform.godzilla.crash.boostcrash.impl.deadobject;

import android.os.IBinder;
import com.bytedance.platform.godzilla.common.Logger;
import com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodDelegate;
import com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodProxy;
import com.bytedance.platform.godzilla.utils.MethodUtils;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class IMountServiceProxy extends MethodProxy {

    static final class IsUserKeyUnlocked extends MethodDelegate {
        IsUserKeyUnlocked() {
        }

        @Override // com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodDelegate
        public Object beforeInvoke(Object r1, Method r2, Object[] r3) {
            Logger.d("IMountServiceProxy", "IsUserKeyUnlocked method is called.");
            return null;
        }

        @Override // com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodDelegate
        public Object afterInvoke(Object r6, Method r7, Object[] r8, Object r9) {
            StackTraceElement[] r0 = Thread.currentThread().getStackTrace();
            int r1 = r0.length;
            int r2 = 0;
        L3:
            if (r2 >= r1) goto L10;
            if (r0[r2].getMethodName().contains("getSharedPreferences") == true) goto L6;
            r2 = r2 + 1;
            goto L3
        L6:
            Logger.d("IMountServiceProxy", "IsUserKeyUnlocked method is called，hint getSharedPreferences，return true。");
            return true;
        L10:
            return super.afterInvoke(r6, r7, r8, r9);
        }
    }

    public IMountServiceProxy() {
    }

    @Override // com.bytedance.platform.godzilla.crash.boostcrash.api.deadobject.MethodProxy
    public void onInstall() {
        IBinderProxy r0 = new IBinderProxy("mount", this);
        r0.onInstall();
        setTarget(MethodUtils.getAccessibleMethod(Class.forName("android.os.storage.IStorageManager$Stub"), "asInterface", new Class[]{IBinder.class}).invoke(null, new Object[]{r0.getTarget()}));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Logger.e("IMountServiceProxy", "Hook proxy MountService Failed!!!");
        e.printStackTrace();
    }

    static {
        addMethodDelegate("isUserKeyUnlocked", new IsUserKeyUnlocked());
    }
}
