package com.bytedance.securityserver.sdid;

import android.os.Bundle;
import android.util.Log;
import com.bytedance.securityserver.adapter.SecurityLibFactory;
import com.bytedance.securityserver.adapter.TypeDetector;
import com.bytedance.securityserver.adapter.api.IKeyManager;
import com.bytedance.securityserver.adapter.api.IUDIDResult;
import com.bytedance.securityserver.adapter.assistant.AssistantKeyManagerAdapter;
import com.bytedance.securityserver.adapter.obric.ObricKeyManagerAdapter;
import com.bytedance.securityserver.utils.GlobalContext;

/* JADX INFO: loaded from: classes.dex */
public class UDIDManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile UDIDManager f63a;

    public static UDIDManager a() {
        if (f63a != null) goto L16;
        monitor-enter(UDIDManager.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f63a != null) goto L11;
        f63a = new UDIDManager();     // Catch: Throwable -> L9
    L11:
        monitor-exit(UDIDManager.class);     // Catch: Throwable -> L9
    L16:
        return f63a;
    }

    public static String b() {
        monitor-enter(SecurityLibFactory.class);
        IKeyManager r1 = SecurityLibFactory.b;     // Catch: Throwable -> L11
        if (r1 == null) goto L8;
        monitor-exit(SecurityLibFactory.class);
    L19:
        if (r1 == null) goto L26;
        IUDIDResult r2 = r1.a(GlobalContext.f82a, new Bundle());
        if (r2.a() == 0) goto L23;
        Log.e("SecurityServer-UDIDManager", "get UDID failed! ret:" + r2.a());
        throw new SDIDException(-3, "get udid from native service failed!");
    L23:
        return r2.b();
    L26:
        Log.e("SecurityServer-UDIDManager", "KeyManager unavailable (securitylib framework not detected)");
        throw new SDIDException(-3, "key manager unavailable");
    L8:
        int r3 = TypeDetector.a();     // Catch: Throwable -> L11
        if (r3 != 1) goto L14;
        SecurityLibFactory.b = new ObricKeyManagerAdapter();     // Catch: Throwable -> L11
    L16:
        r1 = SecurityLibFactory.b;     // Catch: Throwable -> L11
        monitor-exit(SecurityLibFactory.class);
        goto L19
    L14:
        if (r3 != 2) goto L16;
        SecurityLibFactory.b = new AssistantKeyManagerAdapter();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }
}
