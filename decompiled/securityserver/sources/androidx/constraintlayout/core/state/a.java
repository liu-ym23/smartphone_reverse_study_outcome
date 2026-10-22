package androidx.constraintlayout.core.state;

import android.app.Application;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.Ok3SsCall;
import com.bytedance.securityserver.SecurityAppDelegateImpl;
import com.bytedance.securityserver.utils.WiFiMonitor;
import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Interpolator, Authenticator, WiFiMonitor.WiFiTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f0a;

    public /* synthetic */ a(Object r1) {
        this.f0a = r1;
    }

    @Override // com.bytedance.securityserver.utils.WiFiMonitor.WiFiTask
    public int a() {
        return SecurityAppDelegateImpl.c((Application) this.f0a);
    }

    @Override // okhttp3.Authenticator
    public Request authenticate(Route r1, Response r2) {
        return Ok3SsCall.a((BaseRequestContext.AuthCredentials) this.f0a, r1, r2);
    }

    @Override // androidx.constraintlayout.core.state.Interpolator
    public float getInterpolation(float r1) {
        return Transition.d((String) this.f0a, r1);
    }
}
