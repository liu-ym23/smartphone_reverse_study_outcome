package com.bytedanceos.security;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
public class PermissionTestingBroadcastReceiver extends BroadcastReceiver {
    public PermissionTestingBroadcastReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.provider.Telephony.SECRET_CODE".equals(intent.getAction()) == false) goto L6;
        Intent r0 = new Intent("android.intent.action.MAIN");
        r0.setFlags(268435456);
        r0.setClass(context, PermissionTestingSettings.class);
        context.startActivity(r0);
        return;
    }
}
