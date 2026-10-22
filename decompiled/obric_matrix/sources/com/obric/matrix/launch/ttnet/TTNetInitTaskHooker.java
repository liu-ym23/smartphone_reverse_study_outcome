package com.obric.matrix.launch.ttnet;

import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.s.d;
import com.obric.matrix.base.env.e;
import com.ss.android.init.tasks.TTNetInitTaskHook;
import com.ttnet.org.chromium.base.ContextUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/matrix/launch/ttnet/TTNetInitTaskHooker;", "Lcom/ss/android/init/tasks/TTNetInitTaskHook;", "()V", "TAG", "", "after", "", "before", "hook", "", "app_launch_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TTNetInitTaskHooker implements TTNetInitTaskHook {
    private final String TAG;

    public TTNetInitTaskHooker() {
        this.TAG = "TTNetInitTaskHooker";
    }

    @Override // com.ss.android.init.tasks.TTNetInitTaskHook
    public void after() {
        com.obric.matrix.r.c.c.j(this.TAG, "after start.");     // Catch: Exception -> L4
        d.a(new e());     // Catch: Exception -> L4
        d.a(new c());     // Catch: Exception -> L4
        d.a(new com.obric.matrix.q.g.e());     // Catch: Exception -> L4
        TTNetInit.preInitCronetKernel();     // Catch: Exception -> L4
        TTNetInit.setBypassOfflineCheck(true);     // Catch: Exception -> L4
        com.obric.matrix.r.a.f9907a.e().countDown();     // Catch: Exception -> L4
        com.obric.matrix.r.c.c.j(this.TAG, "after end.");     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.obric.matrix.r.c.c.g(this.TAG, "after end with exception", e);
    }

    @Override // com.ss.android.init.tasks.TTNetInitTaskHook
    public void before() {
        com.obric.matrix.r.c.c.j(this.TAG, "before start.");
        com.obric.matrix.q.e.a.f9851a.d();
        ContextUtils.initApplicationContext(com.bytedance.mpaas.app.a.f5245g);
        com.bytedance.ttnet.s.e.c(com.obric.matrix.base.env.d.f8838a.e());
        a.e();
        TTNetInit.setTTNetDepend(new b());
        TTNetInit.setCronetDepend(a.f9157a);
        com.obric.matrix.r.c.c.j(this.TAG, "before end.");
    }

    @Override // com.ss.android.init.tasks.TTNetInitTaskHook
    public boolean hook() {
        return false;
    }
}
