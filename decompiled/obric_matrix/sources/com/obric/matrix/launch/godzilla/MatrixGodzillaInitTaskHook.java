package com.obric.matrix.launch.godzilla;

import android.app.Application;
import com.bytedance.mpaas.app.AppInfo;
import com.ss.android.init.tasks.GodzillaInitTaskHook;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.n0.d.o;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/obric/matrix/launch/godzilla/MatrixGodzillaInitTaskHook;", "Lcom/ss/android/init/tasks/GodzillaInitTaskHook;", "()V", "after", "", "before", "config", "Lcom/bytedance/platform/godzilla/Godzilla$Builder;", "hook", "", "app_launch_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MatrixGodzillaInitTaskHook implements GodzillaInitTaskHook {

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016¨\u0006\f"}, d2 = {"com/obric/matrix/launch/godzilla/MatrixGodzillaInitTaskHook$before$1", "Lcom/bytedance/platform/godzilla/crash/uncaughtexecption/SuperUncaughtExceptionPlugin$ConfigFetcher;", "getAppVersion", "", "getCrashPortrait", "", "Lcom/bytedance/platform/godzilla/common/CrashPortrait;", "getUpdateVersion", "", "onCrashCatchSucceed", "", "crashPortrait", "app_launch_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a implements d.b.p.a.e.i.e.a {
        a() {
        }

        @Override // d.b.p.a.e.i.e.a
        public String a() {
            String r1 = AppInfo.getInstatnce().getVersionCode();
            o.e(r1, "getInstatnce().versionCode");
            return r1;
        }

        @Override // d.b.p.a.e.i.e.a
        public int b() {
            String r1 = AppInfo.getInstatnce().getVersionCode();
            o.e(r1, "getInstatnce().versionCode");
            return Integer.parseInt(r1);
        }

        @Override // d.b.p.a.e.i.e.a
        public List<d.b.p.a.d.c> c() {
            ArrayList r2 = new ArrayList();
            Iterator<d> r0 = ((IgodzillaSuperUncaughtConfig) com.bytedance.news.common.settings.e.e(IgodzillaSuperUncaughtConfig.class)).getCrashPortraits().b().iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            r2.add(r0.next().a());
            goto L4
        L6:
            return r2;
        }

        @Override // d.b.p.a.e.i.e.a
        public void d(d.b.p.a.d.c r2) {
            o.f(r2, "crashPortrait");
            com.obric.matrix.r.c.c.s("MatrixGodzillaInitTaskH", "onCrashCatchSucceed: crashPortrait = " + r2);
            JSONObject r1 = new JSONObject();
            r1.put("crash_portrait", r2.toString());
            com.obric.matrix.ostracker_api.b.g("matrix_super_uncaught_crash_catch_succeed", r1);
        }
    }

    public MatrixGodzillaInitTaskHook() {
    }

    public static /* synthetic */ void a(String r0, long r1) {
        m60before$lambda1(r0, r1);
    }

    /* JADX INFO: renamed from: before$lambda-1, reason: not valid java name */
    private static final void m60before$lambda1(String r2, long r3) {
        JSONObject r0 = new JSONObject();
        r0.put("clazz_name", r2);
        r0.put("during", r2);
        com.obric.matrix.ostracker_api.b.g("matrix_idle_handler_monitor", r0);
        com.obric.matrix.r.c.c.f("MatrixGodzillaInitTaskH", "IdleHandlerMonitorPlugin clazzName = " + r2 + ", time = " + r3);
    }

    @Override // com.ss.android.init.tasks.GodzillaInitTaskHook
    public void after() {
    }

    @Override // com.ss.android.init.tasks.GodzillaInitTaskHook
    public void before(d.b.p.a.a.b r4) {
        o.f(r4, "config");
        r4.b(new d.b.p.a.e.i.e(new a(), com.bytedance.mpaas.app.a.f5245g));
        r4.b(new d.b.p.a.c.b(c.f9122a));
        Application r1 = com.bytedance.mpaas.app.a.f5245g;
        o.e(r1, "sApplication");
        r4.b(new d.b.p.a.f.a.c(new f(r1)));
    }

    @Override // com.ss.android.init.tasks.GodzillaInitTaskHook
    public boolean hook() {
        return false;
    }
}
