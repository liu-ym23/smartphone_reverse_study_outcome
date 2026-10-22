package s0;

import android.app.Activity;
import android.app.Application;
import com.bytedance.ai.model.p;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AtomicBoolean f21801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f21802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Application f21803c;

    static {
        f21801a = new AtomicBoolean(false);
        new HashMap();
    }

    public static Application a() {
        Application r5 = f21803c;
        if (r5 == null) goto L5;
        return r5;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("application");
        return null;
    }

    public static Activity b() {
        Activity r5 = q2.a.f21470a.a();
        if (r5 != null) goto L10;
        t0.b r10 = p.f2294c;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.currentActivity();
    L10:
        return r5;
    }
}
