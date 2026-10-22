package tmsdkobf;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public abstract class wj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map f605a;

    static {
        f605a = new HashMap();
    }

    public static void a(int r1, long r2) {
        Map r0 = f605a;
        HashMap r3 = (HashMap) r0;
        r3.put(Integer.valueOf(r1), Long.valueOf(r2));
    }
}
