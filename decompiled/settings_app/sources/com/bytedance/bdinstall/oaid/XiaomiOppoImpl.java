package com.bytedance.bdinstall.oaid;

import android.content.Context;
import com.bytedance.bdinstall.DrLog;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes3.dex */
final class XiaomiOppoImpl implements OaidApi {
    private static Class<?> sClass;
    private static Method sGetOAID;
    private static Object sIdProviderImpl;

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public String getName() {
        return "Xiaomi";
    }

    static {
        Class<?> r0 = Class.forName("com.android.id.impl.IdProviderImpl");     // Catch: Exception -> L4
        sClass = r0;     // Catch: Exception -> L4
        sIdProviderImpl = r0.newInstance();     // Catch: Exception -> L4
        sGetOAID = sClass.getMethod("getOAID", new Class[]{Context.class});     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        DrLog.e("Oaid#static reflect exception! " + e.getMessage());
    }

    XiaomiOppoImpl() {
    }

    static boolean isSupport() {
        if (sClass != null) goto L5;
    L9:
        return false;
    L5:
        if (sIdProviderImpl == null) goto L9;
        if (sGetOAID == null) goto L9;
        return true;
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public boolean support(Context r1) {
        return isSupport();
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public OaidApi.Result getOaid(Context r2) {
        OaidApi.Result r1 = new OaidApi.Result();     // Catch: Exception -> L4
        r1.oaid = invokeMethod(r2, sGetOAID);     // Catch: Exception -> L4
        return r1;
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    private static String invokeMethod(Context r3, Method r4) {
        Object r0 = sIdProviderImpl;
        if (r0 == null) goto L10;
        if (r4 != null) goto L13;
        return null;
    L13:
        Object r5 = r4.invoke(r0, new Object[]{r3});     // Catch: Exception -> L12
        if (r5 == null) goto L16;
        return (String) r5;
    L16:
        return null;
    L17:
        return null;
    L10:
        return null;
    }
}
