package tmsdk.fg.module.urlcheck;

import android.content.Context;
import android.util.Log;
import tmsdk.common.module.urlcheck.UrlCheckResult;
import tmsdk.fg.creator.BaseManagerF;
import tmsdkobf.b0;
import tmsdkobf.f;
import tmsdkobf.q8;

/* JADX INFO: loaded from: classes5.dex */
public final class UrlCheckManager extends BaseManagerF {
    private a b;

    public UrlCheckManager() {
    }

    public int checkUrl(String r7, ICheckUrlCallback r8) {
        long r0 = System.currentTimeMillis();
        q8.c("TMSDK_UrlCheckManager", "checkUrl start...");
        f.f(29956);
        a r6 = this.b;
        if (r6 == null) goto L6;
        int r9 = r6.a(r7, r8);
        q8.c("TMSDK_UrlCheckManager", "checkUrl end exec time : " + (System.currentTimeMillis() - r0));
        return r9;
    L6:
        return -11;
    }

    public UrlCheckResult checkUrlSync(String r7) {
        long r0 = System.currentTimeMillis();
        q8.c("TMSDK_UrlCheckManager", "checkUrlSync start...");
        f.f(29956);
        a r6 = this.b;
        if (r6 == null) goto L6;
        UrlCheckResult r8 = r6.a(r7);
        q8.c("TMSDK_UrlCheckManager", "checkUrlSync end exec time : " + (System.currentTimeMillis() - r0));
        return r8;
    L6:
        return null;
    }

    @Override // tmsdkobf.b0
    public void onCreate(Context r2) {
        if (b0.a() == false) goto L6;
        Log.e(b0.TAG_INIT, "TMS onCreate failed, missing check Licence SafeState !");
        return;
    L6:
        a r0 = new a();
        this.b = r0;
        r0.onCreate(r2);
        a(this.b);
    }
}
