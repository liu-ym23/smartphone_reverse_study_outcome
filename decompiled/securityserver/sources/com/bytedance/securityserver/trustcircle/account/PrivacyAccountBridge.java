package com.bytedance.securityserver.trustcircle.account;

import a.a;
import android.app.Application;
import android.util.Log;
import com.bytedance.privacy.bridge.IAccountBridge;
import com.bytedance.securityserver.sdid.SDIDException;
import com.bytedance.securityserver.sdid.UDIDManager;
import com.obric.matrix.platform.sdk.ones.account.OAccount;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class PrivacyAccountBridge implements IAccountBridge {
    public static volatile PrivacyAccountBridge b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Application f75a;

    public PrivacyAccountBridge(Application r1) {
        this.f75a = r1;
    }

    public static PrivacyAccountBridge f(Application r2) {
        if (b != null) goto L16;
        monitor-enter(PrivacyAccountBridge.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (b != null) goto L11;
        b = new PrivacyAccountBridge(r2);     // Catch: Throwable -> L9
    L11:
        monitor-exit(PrivacyAccountBridge.class);     // Catch: Throwable -> L9
    L16:
        return b;
    }

    public static boolean g() {
        return OAccount.INSTANCE.isLogin(true);
    L4:
        e = move-exception;
        a.C(e, new StringBuilder("get IsAccountLogin failed, exception : "), "SecurityServer-PrivacyAccountBridge");
        return false;
    }

    @Override // com.bytedance.privacy.bridge.IAccountBridge
    public final Map a() {
        return OAccount.INSTANCE.xttTokenMap();
    L4:
        e = move-exception;
        a.C(e, new StringBuilder("get XttTokenMap failed, exception : "), "SecurityServer-PrivacyAccountBridge");
        return null;
    }

    @Override // com.bytedance.privacy.bridge.IAccountBridge
    public final String b() {
        return OAccount.INSTANCE.accountInfo(true).getUserId();
    L4:
        e = move-exception;
        Log.e("SecurityServer-PrivacyAccountBridge", "get UserId failed, exception : " + e.getMessage());
        return null;
    }

    @Override // com.bytedance.privacy.bridge.IAccountBridge
    public final String c() {
        UDIDManager.a().getClass();     // Catch: SDIDException -> L4
        return UDIDManager.b();
    L4:
        e = move-exception;
        Log.e("SecurityServer-PrivacyAccountBridge", "getUDID failed, exception: " + e);
        return "";
    }

    @Override // com.bytedance.privacy.bridge.IAccountBridge
    public final boolean d() {
        return OAccount.INSTANCE.isLogin(true);
    L4:
        e = move-exception;
        a.C(e, new StringBuilder("get IsAccountLogin failed, exception : "), "SecurityServer-PrivacyAccountBridge");
        return false;
    }

    @Override // com.bytedance.privacy.bridge.IAccountBridge
    public final String e() {
        MatrixTeaManager.Companion r1 = MatrixTeaManager.Companion;     // Catch: Throwable -> L13
        if (r1.isInited() == true) goto L6;
    L15:
        Log.w("SecurityServer-PrivacyAccountBridge", "onGetDeviceId skipped, MatrixTeaManager not ready");     // Catch: Throwable -> L13
        return "";
    L6:
        if (r1.getInstance() == null) goto L15;
        String r4 = r1.getInstance().getDeviceId();     // Catch: Throwable -> L13
        if (r4 != null) goto L12;
        return "";
    L12:
        return r4;
    L13:
        th = move-exception;
        StringBuilder r2 = new StringBuilder("onGetDeviceId failed: ");
        if (th.getMessage() != null) goto L20;
        String r3 = th.getClass().getSimpleName();
    L21:
        r2.append(r3);
        Log.e("SecurityServer-PrivacyAccountBridge", r2.toString());
        return "";
    L20:
        r3 = th.getMessage();
        goto L21
    }
}
