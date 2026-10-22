package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.bdinstall.util.Singleton;

/* JADX INFO: loaded from: classes3.dex */
final class MeizuOaidImpl implements OaidApi {
    private Singleton<Boolean> isSupport;

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public String getName() {
        return "Meizu";
    }

    MeizuOaidImpl() {
        this.isSupport = new AnonymousClass1(this);
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public boolean support(Context r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        return this.isSupport.get(new Object[]{r3}).booleanValue();
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public OaidApi.Result getOaid(Context r8) {
        Cursor r0 = r8.getContentResolver().query(Uri.parse("content://com.meizu.flyme.openidsdk/"), null, null, new String[]{"oaid"}, null);     // Catch: Throwable -> L14
        if (r0 != null) goto L24;
        if (r0 == null) goto L7;
        r0.close();
    L7:
        return null;
    L24:
        OaidApi.Result r1 = new OaidApi.Result();     // Catch: Throwable -> L12
        r1.oaid = getOaid(r0);     // Catch: Throwable -> L12
        if (r0 == null) goto L11;
        r0.close();
    L11:
        return r1;
    L12:
        th = th;
    L28:
        th.printStackTrace();     // Catch: Throwable -> L20
        if (r0 == null) goto L19;
        r0.close();
    L19:
        return null;
    L20:
        th = move-exception;
        if (r0 == null) goto L23;
        r0.close();
    L23:
        throw th;
    L14:
        th = th;
        r0 = null;
        goto L28
    }

    private String getOaid(Cursor r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if (r2.isClosed() == false) goto L8;
        return null;
    L8:
        r2.moveToFirst();
        int r0 = r2.getColumnIndex("value");
        if (r0 >= 0) goto L11;
        return null;
    L11:
        return r2.getString(r0);
    }
}
