package com.bytedance.securityserver;

import android.app.Application;
import android.util.Log;
import com.bytedance.securityserver.robotspolicy.RobotsPolicyManager;
import com.bytedance.securityserver.utils.EventUploadUtils;
import com.bytedance.securityserver.utils.GlobalContext;

/* JADX INFO: loaded from: classes.dex */
public class SecurityApplication extends Application {
    private static final String TAG = "SecurityApplication";
    private final ISecurityAppDelegate delegate;

    /* JADX INFO: renamed from: com.bytedance.securityserver.SecurityApplication$1, reason: invalid class name */
    public class AnonymousClass1 implements ISecurityAppDelegate {
        @Override // com.bytedance.securityserver.ISecurityAppDelegate
        public final void onCreate(Application r1) {
        }
    }

    public SecurityApplication() {
        this.delegate = createDelegate();
    }

    private ISecurityAppDelegate createDelegate() {
        Object r1 = SecurityAppDelegateImpl.class.newInstance();     // Catch: Throwable -> L6
        if ((r1 instanceof ISecurityAppDelegate) == false) goto L8;
        return (ISecurityAppDelegate) r1;
    L8:
        return new AnonymousClass1();
    L6:
        Log.w(TAG, "No flavor delegate found or instantiation failed.");
        goto L8
    }

    @Override // android.app.Application
    public void onCreate() {
        Log.i(TAG, "SecurityApplication start.");
        super.onCreate();
        GlobalContext.f82a = this;
        RobotsPolicyManager.getInstance().setup(this);
        EventUploadUtils.c();
        ISecurityAppDelegate r0 = this.delegate;     // Catch: Throwable -> L7
        if (r0 == null) goto L16;
        r0.onCreate(this);     // Catch: Throwable -> L7
        return;
    L16:
        return;
    L7:
        th = move-exception;
        StringBuilder r1 = new StringBuilder("Delegate onCreate failed: ");
        if (th.getMessage() != null) goto L11;
        String r3 = th.getClass().getSimpleName();
    L12:
        r1.append(r3);
        Log.e(TAG, r1.toString());
        return;
    L11:
        r3 = th.getMessage();
        goto L12
    }
}
