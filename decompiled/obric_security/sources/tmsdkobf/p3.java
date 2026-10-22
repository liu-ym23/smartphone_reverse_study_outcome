package tmsdkobf;

import java.util.HashMap;
import tmsdk.common.TMSDKContext;

/* JADX INFO: loaded from: classes5.dex */
public abstract class p3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final HashMap f406a = null;

    static {
        HashMap r0 = new HashMap(5);
        f406a = r0;
        r0.put("ConfigProvider", new u3(0, new z2()));
        r0.put("MeriExtProvider", new u3(0, new f9()));
        r0.put("QQSecureProvider", new u3(1, new db()));
        r0.put("SpProvider", new u3(0, new ke(TMSDKContext.getApplicaionContext())));
    }

    public static u3 a(String r1) {
        if (r1 != null) goto L6;
        return null;
    L6:
        return (u3) f406a.get(r1);
    }
}
