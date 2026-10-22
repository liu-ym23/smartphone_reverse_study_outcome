package com.bytedance.securityserver.sdid;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.core.app.NotificationManagerCompat;
import com.bytedance.securityserver.utils.GlobalContext;

/* JADX INFO: loaded from: classes.dex */
public class OAIDProvider extends ContentProvider {
    public OAIDProvider() {
    }

    public static Bundle a() {
        Bundle r0 = new Bundle();
        OAIDManager r1 = OAIDManager.b();
        monitor-enter(r1);
        r1.a(GlobalContext.f82a);     // Catch: Throwable -> L9
        if (r1.b == true) goto L21;
        Log.i("SecurityServer-OAIDManager", "OAID is disabled, returning zero.");     // Catch: Throwable -> L9
        String r2 = "0000000000000000000000000000000000000000000000000000000000000000";
        monitor-exit(r1);
    L13:
        r0.putString("oaid", r2);
        r0.putInt("errCode", 0);
        r0.putString("errMsg", "Get OAID success");
        return r0;
    L21:
        r2 = OAIDStore.b().c();     // Catch: Throwable -> L9 SDIDException -> L15
        monitor-exit(r1);
        goto L13
    L15:
        e = move-exception;
        Log.e("SecurityServer-OAIDManager", "getOAID failed: " + e.c);     // Catch: Throwable -> L9
        throw e;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public static Bundle b() {
        Bundle r0 = new Bundle();
        OAIDManager r1 = OAIDManager.b();
        monitor-enter(r1);
        r1.a(GlobalContext.f82a);     // Catch: Throwable -> L10
        if (r1.b == true) goto L19;
        Log.i("SecurityServer-OAIDManager", "OAID disabled, skip reset");     // Catch: Throwable -> L10
        throw new SDIDException(-7, "OAID disabled");     // Catch: Throwable -> L10
    L19:
        OAIDStore.b().e();     // Catch: Throwable -> L10 SDIDException -> L12
        monitor-exit(r1);
        r0.putInt("errCode", 0);
        r0.putString("errMsg", "Reset OAID success");
        return r0;
    L12:
        e = move-exception;
        Log.e("SecurityServer-OAIDManager", "resetOAID failed: " + e.c);     // Catch: Throwable -> L10
        throw e;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ContentProvider
    public final Bundle call(String r9, String r10, Bundle r11) {
        Bundle r2 = new Bundle();
        int r3 = r9.hashCode();     // Catch: Exception -> L11 SDIDException -> L13
        boolean r6 = false;
        if (r3 == (-1676573859)) goto L16;
        if (r3 == 1976516022) goto L9;
    L18:
        byte r4 = -1;
    L19:
        if (r4 == 0) goto L33;
        if (r4 == 1) goto L23;
        Log.e("SecurityServer-OAIDProvider", "Unknown method: ".concat(r9));     // Catch: Exception -> L11 SDIDException -> L13
        r2.putInt("errCode", -2);     // Catch: Exception -> L11 SDIDException -> L13
        r2.putString("errMsg", "Unknown method");     // Catch: Exception -> L11 SDIDException -> L13
        return r2;
    L23:
        String r8 = getCallingPackage();     // Catch: Exception -> L11 SDIDException -> L13
        if (r8 == null) goto L27;
        r6 = "com.security.privacytest".equals(r8);     // Catch: Exception -> L11 SDIDException -> L13
    L27:
        if (r6 == true) goto L31;
        r2.putInt("errCode", -1);     // Catch: Exception -> L11 SDIDException -> L13
        r2.putString("errMsg", "permission denied");     // Catch: Exception -> L11 SDIDException -> L13
        return r2;
    L31:
        return b();
    L33:
        return a();
    L9:
        if (r9.equals("get_oaid") == false) goto L18;
        r4 = 0;
        goto L19
    L16:
        if (r9.equals("reset_oaid") == false) goto L18;
        r4 = 1;
    L13:
        e = move-exception;
        StringBuilder r12 = new StringBuilder("call failed: ");
        String r1 = e.c;
        r12.append(r1);
        Log.e("SecurityServer-OAIDProvider", r12.toString());
        r2.putInt("errCode", e.b);
        r2.putString("errMsg", r1);
    L36:
        return r2;
    L11:
        e = move-exception;
        Log.e("SecurityServer-OAIDProvider", "unexpected error");
        r2.putInt("errCode", NotificationManagerCompat.IMPORTANCE_UNSPECIFIED);
        r2.putString("errMsg", e.getMessage());
        goto L36
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
