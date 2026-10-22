package tmsdkobf;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes5.dex */
public abstract class qi {
    public static int a(Context r5) {
        Intent r6 = r5.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));     // Catch: Throwable -> L20
        if (r6 != null) goto L7;
        return -1;
    L7:
        if (TextUtils.equals(r6.getAction(), "android.intent.action.BATTERY_CHANGED") == true) goto L9;
        return -1;
    L9:
        int r2 = 0;
        int r0 = r6.getIntExtra("level", 0);     // Catch: Throwable -> L20
        int r7 = r6.getIntExtra("scale", 100);     // Catch: Throwable -> L20
        if (r7 != 0) goto L12;
        return -1;
    L12:
        int r1 = (r0 * 100) / r7;
        if (r1 < 0) goto L16;
        r2 = r1;
    L16:
        if (r2 <= 100) goto L19;
        return 100;
    L19:
        return r2;
    L20:
        return -1;
    }
}
