package com.bytedance.bdinstall.a1;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public class h implements c {

    static class a extends c.a {
        a() {
        }
    }

    public h() {
    }

    @Override // com.bytedance.bdinstall.a1.c
    @RequiresApi(api = 24)
    public c.a a(Context r4) {
        a r3 = new a();
        ContentProviderClient r0 = null;
        ContentProviderClient r5 = r4.getContentResolver().acquireUnstableContentProviderClient(Uri.parse("content://com.obric.idprovider"));     // Catch: Throwable -> L13 RemoteException -> L15
    L11:
        e = e;
    L17:
        e.printStackTrace();     // Catch: Throwable -> L24
        if (r5 == null) goto L20;
        r5.close();
    L20:
        Bundle r1 = null;
    L21:
        if (r1 == null) goto L23;
        r3.f2650a = r1.getString("oaid", null);
        r3.f2651b = r1.getBoolean("forbidden", false);
    L23:
        return r3;
    L24:
        th = th;
        r0 = r5;
    L26:
        if (r0 == null) goto L28;
        r0.close();
    L28:
        throw th;
    L5:
        if (Build.VERSION.SDK_INT < 17) goto L8;
        r1 = r5.call("request_oaid", null, null);     // Catch: RemoteException -> L11 Throwable -> L24
    L9:
        if (r5 == null) goto L21;
        r5.close();
        goto L21
    L8:
        r1 = null;
        goto L9
    L15:
        e = e;
        r5 = null;
    L13:
        th = th;
        goto L26
    }

    @Override // com.bytedance.bdinstall.a1.c
    public boolean b(Context r1) {
        return true;
    }

    @Override // com.bytedance.bdinstall.a1.c
    public String getName() {
        return "Pico";
    }
}
