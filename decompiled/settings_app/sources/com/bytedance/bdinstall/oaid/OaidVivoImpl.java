package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.SystemProperties;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.util.Singleton;

/* JADX INFO: loaded from: classes3.dex */
final class OaidVivoImpl implements OaidApi {
    private static final String ID_PROPERTY = "persist.sys.identifierid.supported";
    private static final String NOT_SUPPORTED = "0";
    private static final String SUPPORTED = "1";
    private static final int TYPE_AAID = 2;
    private static final int TYPE_OAID = 0;
    private static final int TYPE_VAID = 1;
    private static final Singleton<Boolean> support = null;

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public String getName() {
        return "Vivo";
    }

    static /* synthetic */ String access$000(String r0, String r1) {
        return getSystemProperties(r0, r1);
    }

    static {
        support = new AnonymousClass1();
    }

    OaidVivoImpl(Context r1) {
    }

    static boolean isSupport() {
        return support.get(new Object[0]).booleanValue();
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public boolean support(Context r1) {
        return isSupport();
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public OaidApi.Result getOaid(Context r3) {
        OaidApi.Result r2 = new OaidApi.Result();
        r2.oaid = query(r3, 0, null);
        return r2;
    }

    private static String getSystemProperties(String r0, String r1) {
        return SystemProperties.get(r0, r1);
    L7:
        return r1;
    }

    private static String query(Context r9, int r10, String r11) {
        String r2 = null;
        r2 = null;
        r2 = null;
        r2 = null;
        r2 = null;
        r2 = null;
        Cursor r3 = null;
        if (r10 != 0) goto L5;
        Uri r12 = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID");
    L12:
        Uri r4 = r12;
    L13:
        if (r4 != null) goto L56;
    L46:
        return r2;
    L56:
        Cursor r13 = r9.getContentResolver().query(r4, null, null, null, null);     // Catch: Throwable -> L28 Exception -> L30
        if (r13 != null) goto L47;
    L22:
        if (r13 == null) goto L46;
        r13.close();     // Catch: Exception -> L25
    L25:
        e = e;
        e.printStackTrace();
        StringBuilder r14 = new StringBuilder("OaidVivo#query close cursor exception.");
    L27:
        DrLog.d(r14.append(e).toString());
        goto L46
    L47:
    L20:
        e = e;
    L32:
        e.printStackTrace();     // Catch: Throwable -> L38
        DrLog.d("OaidVivo#query" + e);     // Catch: Throwable -> L38
        if (r13 == null) goto L46;
        r13.close();     // Catch: Exception -> L36
    L36:
        e = e;
        e.printStackTrace();
        r14 = new StringBuilder("OaidVivo#query close cursor exception.");
    L38:
        th = th;
        r3 = r13;
    L40:
        if (r3 != null) goto L49;
    L45:
        throw th;
    L49:
        r3.close();     // Catch: Exception -> L43
    L43:
        e = move-exception;
        e.printStackTrace();
        DrLog.d("OaidVivo#query close cursor exception." + e);
        goto L45
    L17:
        if (r13.moveToNext() == false) goto L22;
        r2 = r13.getString(r13.getColumnIndex("value"));     // Catch: Exception -> L20 Throwable -> L38
        goto L22
    L30:
        e = e;
        r13 = null;
    L28:
        th = th;
        goto L40
    L5:
        if (r10 != 1) goto L7;
        r12 = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + r11);
        goto L12
    L7:
        if (r10 == 2) goto L9;
        r4 = null;
        goto L13
    L9:
        r12 = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + r11);
        goto L12
    }
}
