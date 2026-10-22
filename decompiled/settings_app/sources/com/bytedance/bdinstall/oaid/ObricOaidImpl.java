package com.bytedance.bdinstall.oaid;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes3.dex */
public class ObricOaidImpl implements OaidApi {

    static class PicoOaid extends OaidApi.Result {
        PicoOaid() {
        }
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public String getName() {
        return "Pico";
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public boolean support(Context r1) {
        return true;
    }

    public ObricOaidImpl() {
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public OaidApi.Result getOaid(Context r3) {
        PicoOaid r2 = new PicoOaid();
        ContentProviderClient r0 = null;
        ContentProviderClient r4 = r3.getContentResolver().acquireUnstableContentProviderClient(Uri.parse("content://com.obric.idprovider"));     // Catch: Throwable -> L9 RemoteException -> L11
        Bundle r1 = r4.call("request_oaid", null, null);     // Catch: RemoteException -> L7 Throwable -> L20
        if (r4 == null) goto L17;
        r4.close();
    L17:
        if (r1 == null) goto L19;
        r2.oaid = r1.getString("oaid", null);
        r2.isTrackLimit = r1.getBoolean("forbidden", false);
    L19:
        return r2;
    L7:
        e = e;
    L13:
        e.printStackTrace();     // Catch: Throwable -> L20
        if (r4 == null) goto L16;
        r4.close();
    L16:
        r1 = null;
    L20:
        th = th;
        r0 = r4;
    L22:
        if (r0 == null) goto L24;
        r0.close();
    L24:
        throw th;
    L11:
        e = e;
        r4 = null;
    L9:
        th = th;
        goto L22
    }
}
