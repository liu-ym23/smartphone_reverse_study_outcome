package ms.bd.c;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
public class l3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f22417a;

    public l3(Context r1) {
        this.f22417a = r1;
    }

    public String a() {
        int r1 = Build.VERSION.SDK_INT;
        if (r1 <= 28) goto L5;
        boolean r4 = true;
    L7:
        if (r4 == true) goto L9;
        return null;
    L9:
        Uri r6 = Uri.parse((String) m.a(16777217, 0, 0, "7495c6", new byte[]{37, 57, 68, 85, 89, 47, 32, 79, 39, 42, 37, 56, 4, 79, 73, 35, 61, 20, 38, 108, 34, 51, 68, 85, 85, 53, 45, 90, 97, 97, 35, 56, 94, 72, 72, 56}));
        if (r1 <= 17) goto L19;
        ContentProviderClient r0 = this.f22417a.getContentResolver().acquireContentProviderClient(r6);     // Catch: Exception -> L31
        Bundle r5 = r0.call((String) m.a(16777217, 0, 0, "23cc17", new byte[]{36, 52, 4, 56, 47, 9, 21}), null, null);     // Catch: Exception -> L31
        if (r1 < 24) goto L16;
        r0.close();     // Catch: Exception -> L31
    L20:
        if (r5 != null) goto L24;
        return null;
    L24:
        if (r5.getInt((String) m.a(16777217, 0, 0, "5eea3e", new byte[]{39, 104, 18, 16}), -1) != 0) goto L29;
        return r5.getString((String) m.a(16777217, 0, 0, "828045", new byte[]{32, 52}));
    L29:
        r5.getString((String) m.a(16777217, 0, 0, "6d40be", new byte[]{42, 99, 84, 87, 92, 117, 48}));     // Catch: Exception -> L31
        goto L30
    L16:
        r0.release();     // Catch: Exception -> L31
        goto L20
    L19:
        r5 = this.f22417a.getContentResolver().call(r6, (String) m.a(16777217, 0, 0, "44a167", new byte[]{34, 51, 6, 106, 40, 9, 19}), null, null);     // Catch: Exception -> L31
    L30:
        return null;
    L5:
        r4 = false;
        goto L7
    }
}
