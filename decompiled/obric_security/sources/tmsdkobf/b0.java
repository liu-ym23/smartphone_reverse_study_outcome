package tmsdkobf;

import android.content.Context;
import android.util.Log;
import tmsdk.common.TMSDKContext;

/* JADX INFO: loaded from: classes5.dex */
public abstract class b0 {
    public static final String TAG_INIT = "TMSDK_init";
    public static final int TYPE_AUTO = 0;
    public static final int TYPE_FOREVER = 1;
    public static final int TYPE_ONCE = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b0 f105a;

    public b0() {
    }

    protected static final boolean a() {
        if (TMSDKContext.isInitialized() == true) goto L6;
        return true;
    L6:
        if (zc.a() == true) goto L9;
        return true;
    L9:
        if (b0$$ExternalSyntheticBackport0.m(b3.a()) == false) goto L13;
        Log.e(TAG_INIT, "TMS configuration file does not exist or is corrupt !");
        return true;
    L13:
        return ye.d().e();
    }

    public int getSingletonType() {
        b0 r0 = this.f105a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getSingletonType();
    }

    public abstract void onCreate(Context r1);

    protected void a(b0 r1) {
        this.f105a = r1;
    }
}
