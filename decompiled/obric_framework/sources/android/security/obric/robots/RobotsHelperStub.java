package android.security.obric.robots;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class RobotsHelperStub {
    private static final String IMPL_CLASS_NAME = "com.obric.security.robots.RobotsProtocolHelper";
    private static final String METHOD_IS_ROBOTS_ENABLED = "isRobotsEnabled";
    private static final String TAG = "RobotsHelperStub";
    private static volatile RobotsHelperStub sInstance;
    private Class<?> mClazz;

    private RobotsHelperStub() {
    }

    public static RobotsHelperStub getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(RobotsHelperStub.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new RobotsHelperStub();     // Catch: Throwable -> L11
    L9:
        monitor-exit(RobotsHelperStub.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void init() {
        if (this.mClazz == null) goto L10;
        return;
    L10:
        this.mClazz = Class.forName(IMPL_CLASS_NAME);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        Log.e(TAG, "init failed", e);
        this.mClazz = null;
    }

    public boolean isRobotsEnabled(Context context) {
        init();
        if (this.mClazz != null) goto L12;
        return false;
    L12:
        Method method = this.mClazz.getDeclaredMethod(METHOD_IS_ROBOTS_ENABLED, new Class[]{Context.class});     // Catch: Exception -> L9
        method.setAccessible(true);     // Catch: Exception -> L9
        Object ret = method.invoke(null, new Object[]{context});     // Catch: Exception -> L9
        if ((ret instanceof Boolean) == false) goto L14;
        return ((Boolean) ret).booleanValue();
    L14:
        return false;
    L9:
        e = move-exception;
        Log.e(TAG, "isRobotsEnabled(Context) failed", e);
        return false;
    }

    public boolean isRobotsEnabled() {
        init();
        if (this.mClazz != null) goto L12;
        return false;
    L12:
        Method method = this.mClazz.getDeclaredMethod(METHOD_IS_ROBOTS_ENABLED, new Class[0]);     // Catch: Exception -> L9
        method.setAccessible(true);     // Catch: Exception -> L9
        Object ret = method.invoke(null, new Object[0]);     // Catch: Exception -> L9
        if ((ret instanceof Boolean) == false) goto L14;
        return ((Boolean) ret).booleanValue();
    L14:
        return false;
    L9:
        e = move-exception;
        Log.e(TAG, "isRobotsEnabled failed", e);
        return false;
    }
}
