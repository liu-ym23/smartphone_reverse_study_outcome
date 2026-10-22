package tmsdkobf;

import android.os.Build;
import android.os.UserHandle;
import android.text.TextUtils;
import tmsdk.common.TMSDKContext;

/* JADX INFO: loaded from: classes5.dex */
public abstract class zc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static boolean f662a = false;
    private static final byte[] b = null;
    private static final byte[] c = null;
    private static final byte[] d = null;
    private static final byte[] e = null;
    public static final byte[] f = null;
    public static final byte[] g = null;
    public static final byte[] h = null;
    public static final byte[] i = null;
    public static final byte[] j = null;
    public static final byte[] k = null;
    public static final byte[] l = null;
    public static final byte[] m = null;
    public static final byte[] n = null;

    static {
        b = new byte[]{116, 109, 115, 100, 107, 46, 99, 111, 109, 109, 111, 110, 46, 114, 111, 97, 99, 104, 46, 110, 101, 115, 116, 46, 116, 116};
        c = new byte[]{99, 111, 109, 46, 113, 113, 46, 116, 97, 102, 46, 106, 99, 101, 46, 74, 99, 101, 83, 116, 114, 117, 99, 116};
        d = new byte[]{99, 111, 109, 46, 113, 113, 46, 116, 97, 102, 46, 106, 99, 101, 46, 74, 99, 101, 73, 110, 112, 117, 116, 83, 116, 114, 101, 97, 109};
        e = new byte[]{99, 111, 109, 46, 116, 101, 110, 99, 101, 110, 116, 46, 116, 109, 115, 101, 99, 117, 114, 101, 46, 118, 100, 46, 84, 78, 97, 116, 105, 118, 101, 36, 97, 97, 36, 98, 98};
        f = new byte[]{104, 117, 97, 119, 101, 105};
        g = new byte[]{114, 111, 46, 98, 117, 105, 108, 100, 46, 118, 101, 114, 115, 105, 111, 110, 46, 101, 109, 117, 105};
        h = new byte[]{72, 79, 78, 79, 82};
        i = new byte[]{99, 111, 109, 46, 104, 117, 97, 119, 101, 105, 46, 104, 119, 105, 100};
        j = new byte[]{111, 97, 105, 100};
        k = new byte[]{71, 97, 105, 100};
        l = new byte[]{99, 111, 109, 46, 104, 117, 97, 119, 101, 105, 46, 115, 121, 115, 116, 101, 109, 46, 66, 117, 105, 108, 100, 69, 120};
        m = new byte[]{105, 115, 83, 117, 112, 112, 111, 114, 116, 101, 100};
        n = new byte[]{111, 98, 116, 97, 105, 110, 79, 97, 105, 100};
    }

    public static boolean a() {
        boolean r1 = f662a;
        if (r1 == false) goto L5;
        return r1;
    L5:
        String r2 = TMSDKContext.getApplicaionContext().getPackageName();
        int r3 = TMSDKContext.getApplicaionContext().getApplicationInfo().uid;
        q8.a("SanityUtil", "pkgName:[" + r2 + "]uid: [" + r3 + "]android version:[" + Build.VERSION.SDK_INT + "]");
        if (TextUtils.equals(r2, "com.tencent.tmsecure.demo") == false) goto L17;
    L15:
        f662a = true;
        return true;
    L17:
        r3 = ((Integer) Class.forName(UserHandle.class.getName()).getMethod("getAppId", new Class[]{Integer.TYPE}).invoke(null, new Object[]{Integer.valueOf(r3)})).intValue();     // Catch: Throwable -> L9
        q8.a("SanityUtil", "appId:[" + r3 + "]");     // Catch: Throwable -> L9
    L12:
        if (r3 != 1000) goto L15;
        q8.a("SanityUtil", "check system uid ok");
        f.f(1320027);
    L9:
        th = move-exception;
        q8.a("SanityUtil", "e:[" + th + "]");
        goto L12
    }

    public static boolean b() {
        Class.forName(new String(c));     // Catch: Throwable -> L5
        Class.forName(new String(e));     // Catch: Throwable -> L5
        q8.a("SanityUtil", "check proguard ok");     // Catch: Throwable -> L5
        return true;
    L5:
        q8.e("SanityUtil", "is re proguard");
        return false;
    }
}
