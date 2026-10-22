package obric.common.security.ssl;

import com.obric.olog.OLog;
import java.lang.reflect.Method;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class BDKeyManagerRef {
    private static final String TAG = "BDKeyManagerRef";
    public static final String TLS_PRO_CERT = "SYSTEM_Device_TLS_cert";
    public static final String TLS_PRO_PKEY = "SYSTEM_Device_TLS_pkey";
    public static final String TLS_TEST_CERT = "SYSTEM_Device_TLS_cert_test";
    public static final String TLS_TEST_PKEY = "SYSTEM_Device_TLS_pkey_test";
    private static BDKeyManagerRef sInstance;
    private Object mBDKeyManager;
    private Class<?> mClazz;

    public BDKeyManagerRef() {
    }

    public List<X509Certificate> getCertChain(String r7) {
        init();
        Method r0 = this.mClazz.getDeclaredMethod("getCertChain", new Class[]{String.class});     // Catch: Exception -> L5
        r0.setAccessible(true);     // Catch: Exception -> L5
        return (List) r0.invoke(this.mBDKeyManager, new Object[]{r7});
    L5:
        e = move-exception;
        OLog.e(TAG, "getCertChain failed, " + e.getMessage());
        return null;
    }

    public PrivateKey getPrivateKey(String r7) {
        init();
        Method r0 = this.mClazz.getDeclaredMethod("getPrivateKey", new Class[]{String.class});     // Catch: Exception -> L5
        r0.setAccessible(true);     // Catch: Exception -> L5
        return (PrivateKey) r0.invoke(this.mBDKeyManager, new Object[]{r7});
    L5:
        e = move-exception;
        OLog.e(TAG, "getPrivateKey failed, " + e.getMessage());
        return null;
    }

    public long getDoSignAddress(String r7) {
        init();
        Method r0 = this.mClazz.getDeclaredMethod("getDoSignAddress", new Class[]{String.class});     // Catch: Exception -> L5
        r0.setAccessible(true);     // Catch: Exception -> L5
        return ((Long) r0.invoke(this.mBDKeyManager, new Object[]{r7})).longValue();
    L5:
        e = move-exception;
        OLog.e(TAG, "getDoSignAddress failed, " + e.getMessage());
        return -1;
    }

    public long getAlgorithmAddress() {
        init();
        Method r0 = this.mClazz.getDeclaredMethod("getAlgorithmAddress", new Class[0]);     // Catch: Exception -> L5
        r0.setAccessible(true);     // Catch: Exception -> L5
        return ((Long) r0.invoke(this.mBDKeyManager, new Object[0])).longValue();
    L5:
        e = move-exception;
        OLog.e(TAG, "getAlgorithmAddress failed, " + e.getMessage());
        return -1;
    }

    public boolean isContainsKey(String r7) {
        init();
        Method r1 = this.mClazz.getDeclaredMethod("isContainsKey", new Class[]{String.class});     // Catch: Exception -> L5
        r1.setAccessible(true);     // Catch: Exception -> L5
        return ((Boolean) r1.invoke(this.mBDKeyManager, new Object[]{r7})).booleanValue();
    L5:
        e = move-exception;
        OLog.e(TAG, "isContainsKey failed, " + e.getMessage());
        return false;
    }

    private void init() {
        if (this.mBDKeyManager != null) goto L5;
    L11:
        Class<?> r0 = Class.forName("com.bytedance.security.ssl.BDKeyManager");     // Catch: Exception -> L8
        this.mClazz = r0;     // Catch: Exception -> L8
        this.mBDKeyManager = r0.newInstance();     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        OLog.e(TAG, "init failed, " + e.getMessage());
        return;
    L5:
        if (this.mClazz == null) goto L11;
    }

    public static BDKeyManagerRef getInstance() {
        if (sInstance != null) goto L6;
        sInstance = new BDKeyManagerRef();
    L6:
        return sInstance;
    }
}
