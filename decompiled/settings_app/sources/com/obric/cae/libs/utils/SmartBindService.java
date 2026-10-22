package com.obric.cae.libs.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.util.Log;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class SmartBindService {
    public final Context a;
    public final ServiceConnection b;
    public final String c;
    public final String d;

    public SmartBindService(Context r1, ServiceConnection r2, String r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public void smartBindToService() {
        Context r0 = this.a;
        List<ResolveInfo> r1 = r0.getPackageManager().queryIntentServices(new Intent(this.c), 0);
        if (r1 == null) goto L10;
        Iterator<ResolveInfo> r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L10;
        String r3 = r2.next().serviceInfo.packageName;
        if (r3.equals(r0.getPackageName()) == true) goto L6;
    L11:
        Log.i("SmartBindService", "findExternalHostPackage: " + r3);
        if (r3 == null) goto L20;
        Intent r4 = new Intent(this.c);
        r4.setPackage(r3);
        Log.i("SmartBindService", "bindToRemoteService: pkg=" + r3 + ", bound=" + this.a.bindService(r4, this.b, 1));     // Catch: Exception -> L16 SecurityException -> L18
    L42:
        return;
    L18:
        e = move-exception;
        Log.e("SmartBindService", "bindToRemoteService: Permission denied", e);
        return;
    L16:
        e = move-exception;
        Log.e("SmartBindService", "bindToRemoteService: Failed to bind", e);
        return;
    L20:
        String r5 = this.d;
        if (r5 != null) goto L23;
    L30:
        Log.e("SmartBindService", "Local Service Class Name is null or empty, cannot start.");
        return;
    L23:
        if (r5.isEmpty() == true) goto L30;
        ComponentName r6 = new ComponentName(this.a.getPackageName(), this.d);
        Intent r7 = new Intent();
        r7.setComponent(r6);
        r7.setAction(this.c);
        Log.i("SmartBindService", "startAndBindLocalService: bindService called, bound=" + this.a.bindService(r7, this.b, 1));     // Catch: Exception -> L28
        return;
    L28:
        e = move-exception;
        Log.e("SmartBindService", "Failed to start/bind local service: " + this.d, e);
        return;
    L10:
        r3 = null;
        goto L11
    }
}
