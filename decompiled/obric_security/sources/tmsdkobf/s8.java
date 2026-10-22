package tmsdkobf;

import android.text.TextUtils;
import android.util.Log;

/* JADX INFO: loaded from: classes5.dex */
class s8 extends c {
    s8() {
    }

    @Override // tmsdkobf.c
    public void a(int r3, String r4, String r5) {
        if (r5 != null) goto L5;
        r5 = "(null)";
    L5:
        if (r3 != 10) goto L8;
        r3 = 3;
    L8:
        if (TextUtils.isEmpty(q8.f436a) == true) goto L10;
        Log.println(r3, q8.f436a, "[TMSDK_" + r4 + "]" + r5);
        return;
    L10:
        Log.println(r3, "TMSDK_" + r4, r5);
    }
}
