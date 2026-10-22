package tmsdkobf;

import android.util.Log;

/* JADX INFO: loaded from: classes5.dex */
class fj extends hh {
    fj() {
    }

    @Override // tmsdkobf.hh
    public void a(int r2, String r3, String r4) {
        if (r4 != null) goto L5;
        r4 = "(null)";
    L5:
        if (r2 != 10) goto L7;
        Log.println(r2, "Shark_" + r3, r4);
        return;
    L7:
        Log.println(r2, "Shark_" + r3, r4);
    }
}
