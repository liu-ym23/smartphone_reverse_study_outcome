package tmsdkobf;

import android.content.Context;
import android.content.pm.Signature;

/* JADX INFO: loaded from: classes5.dex */
public abstract class aj {
    public static Signature[] a(Context r1, String r2) {
        return r1.getPackageManager().getPackageInfo(r2, 64).signatures;
    L4:
        return null;
    }
}
