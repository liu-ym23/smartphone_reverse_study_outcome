package sq;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.obric.oui.common.style.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements ComponentCallbacks2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f21991a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f21992b;

    static {
        f21991a = new a();
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r5) {
        Intrinsics.checkNotNullParameter(r5, "newConfig");
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        j.a();
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int r5) {
        j.a();
    }
}
