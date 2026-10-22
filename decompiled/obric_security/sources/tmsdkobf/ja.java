package tmsdkobf;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: loaded from: classes5.dex */
public class ja implements zi {
    public ja() {
    }

    @Override // tmsdkobf.zi
    public u9 a(Context r2) {
        Uri r1 = Uri.parse(xk.a(xk.x0));
        String r0 = xk.a(xk.f627a);
        ContentProviderClient r3 = r2.getContentResolver().acquireContentProviderClient(r1);
        Bundle r4 = null;
        r4 = r3.call(r0, null, null);     // Catch: Throwable -> L5
    L6:
        r3.close();
    L8:
        if (r4 != null) goto L12;
        return u9.a(-1);
    L12:
        if (r4.getInt(xk.a(xk.y0), -1) == 0) goto L16;
        return u9.a(-2);
    L16:
        return new u9(r4.getString(xk.a(xk.z0)), 0);
    L5:
        if (r3 == null) goto L8;
        goto L6
    }
}
