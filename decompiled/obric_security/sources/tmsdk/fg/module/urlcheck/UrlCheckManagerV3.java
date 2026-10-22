package tmsdk.fg.module.urlcheck;

import android.content.Context;
import tmsdk.fg.creator.BaseManagerF;
import tmsdkobf.b0;
import tmsdkobf.f;
import tmsdkobf.q8;

/* JADX INFO: loaded from: classes5.dex */
public class UrlCheckManagerV3 extends BaseManagerF {
    public static final String TAG = "TMSDK_UrlCheckManagerV3";
    private b b;

    public UrlCheckManagerV3() {
    }

    public boolean checkUrl(String r3, int r4, ICheckUrlCallbackV3 r5) {
        if (b0.a() == false) goto L6;
        return false;
    L6:
        q8.c(TAG, "checkUrl");
        f.f(29956);
        return this.b.a(r3, r4, r5);
    }

    @Override // tmsdkobf.b0
    public void onCreate(Context r2) {
        b r0 = new b();
        this.b = r0;
        r0.onCreate(r2);
        a(this.b);
    }
}
