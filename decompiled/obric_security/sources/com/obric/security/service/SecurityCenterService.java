package com.obric.security.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import kotlin.Metadata;

/* JADX INFO: compiled from: SecurityCenterService.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/security/service/SecurityCenterService;", "Landroid/app/Service;", "()V", "securityServiceBinder", "Lcom/obric/security/service/SecurityServiceBinder;", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class SecurityCenterService extends Service {
    private SecurityServiceBinder securityServiceBinder;

    public SecurityCenterService() {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r1) {
        if (this.securityServiceBinder != null) goto L5;
        this.securityServiceBinder = SecurityServiceBinder.Companion.getInstance();
    L5:
        SecurityServiceBinder r0 = this.securityServiceBinder;
        if (r0 == null) goto L10;
        return r0;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.security.service.SecurityServiceBinder");
    }
}
