package com.bytedance.securityserver.sdid;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.core.app.NotificationManagerCompat;

/* JADX INFO: loaded from: classes.dex */
public class UDIDProvider extends ContentProvider {
    public UDIDProvider() {
    }

    @Override // android.content.ContentProvider
    public final Bundle call(String r4, String r5, Bundle r6) {
        String r3 = getCallingPackage();
        Bundle r7 = new Bundle();
        if (r3 != null) goto L5;
        boolean r8 = false;
    L7:
        if (r8 == true) goto L21;
        r7.putInt("errCode", -1);
        r7.putString("errMsg", "permission denied");
        return r7;
    L21:
    L16:
        e = move-exception;
        StringBuilder r9 = new StringBuilder("call failed: ");
        String r0 = e.c;
        r9.append(r0);
        Log.e("SecurityServer-UDIDProvider", r9.toString());
        r7.putInt("errCode", e.b);
        r7.putString("errMsg", r0);
    L20:
        return r7;
    L14:
        e = move-exception;
        Log.e("SecurityServer-UDIDProvider", "unexpected error");
        r7.putInt("errCode", NotificationManagerCompat.IMPORTANCE_UNSPECIFIED);
        r7.putString("errMsg", e.getMessage());
        goto L20
    L11:
        if ("get_udid".equals(r4) == false) goto L20;
        UDIDManager.a().getClass();     // Catch: Exception -> L14 SDIDException -> L16
        r7.putString("udid", UDIDManager.b());     // Catch: Exception -> L14 SDIDException -> L16
        r7.putInt("errCode", 0);     // Catch: Exception -> L14 SDIDException -> L16
        r7.putString("errMsg", "Get UDID success");     // Catch: Exception -> L14 SDIDException -> L16
    L5:
        r8 = "com.security.privacytest".equals(r3);
        goto L7
    }

    @Override // android.content.ContentProvider
    public final int delete(Uri r1, String r2, String[] r3) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public final String getType(Uri r1) {
        return "";
    }

    @Override // android.content.ContentProvider
    public final Uri insert(Uri r1, ContentValues r2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public final Cursor query(Uri r1, String[] r2, String r3, String[] r4, String r5) {
        return null;
    }

    @Override // android.content.ContentProvider
    public final int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        return 0;
    }
}
