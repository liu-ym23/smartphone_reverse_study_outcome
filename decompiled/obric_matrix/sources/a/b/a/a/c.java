package a.b.a.a;

import com.bytedance.lego.init.InitScheduler;
import com.bytedance.lego.init.config.ProcessMatchMode;
import com.bytedance.lego.init.e.l;
import java.util.Iterator;
import java.util.List;
import kotlin.f0;

/* JADX INFO: loaded from: classes.dex */
public final class c {
    public static final void a(kotlin.n0.c.a<f0> r2) {
        kotlin.n0.d.o.g(r2, "runnable");
        a.f6c.a().execute(new b(r2));
    }

    public static final boolean b(com.bytedance.lego.init.e.c r5) {
        kotlin.n0.d.o.g(r5, "receiver$0");
        if (r5.f4866j.contains("all") == false) goto L5;
        return true;
    L5:
        List<String> r0 = r5.f4866j;
        InitScheduler r2 = InitScheduler.INSTANCE;
        if (r0.contains(r2.getConfig$initscheduler_release().getProcessName()) == false) goto L9;
        return true;
    L9:
        if (r2.getConfig$initscheduler_release().isMainProcess() == false) goto L13;
        return r5.f4866j.contains("main");
    L13:
        if (r5.f4866j.contains("nonmain") == false) goto L15;
        return true;
    L15:
        ProcessMatchMode r1 = r2.getProcessMatchMode$initscheduler_release();
        int r3 = a.b.a.a.l.a.f71a[r1.ordinal()];
        if (r3 != 1) goto L18;
        List<String> r6 = r5.f4866j;
        kotlin.n0.d.o.b(r6, "runInProcess");
        Iterator<T> r7 = r6.iterator();
    L28:
        if (r7.hasNext() == false) goto L41;
        String r4 = (String) r7.next();
        String r8 = InitScheduler.INSTANCE.getConfig$initscheduler_release().getProcessName();
        kotlin.n0.d.o.b(r4, "it");
        if (kotlin.u0.k.m(r8, r4, true) == false) goto L28;
        return true;
    L41:
        return false;
    L18:
        if (r3 != 2) goto L32;
        List<String> r9 = r5.f4866j;
        kotlin.n0.d.o.b(r9, "runInProcess");
        Iterator<T> r10 = r9.iterator();
    L22:
        if (r10.hasNext() == false) goto L40;
        String r11 = (String) r10.next();
        String r12 = InitScheduler.INSTANCE.getConfig$initscheduler_release().getProcessName();
        kotlin.n0.d.o.b(r11, "it");
        if (kotlin.u0.k.D(r12, r11, true) == false) goto L22;
        return true;
    L40:
        return false;
    L32:
        return false;
    }

    public static final boolean c(l r5) {
        kotlin.n0.d.o.g(r5, "receiver$0");
        if (r5.f4905l.contains("all") == false) goto L5;
        return true;
    L5:
        List<String> r0 = r5.f4905l;
        InitScheduler r2 = InitScheduler.INSTANCE;
        if (r0.contains(r2.getConfig$initscheduler_release().getProcessName()) == false) goto L9;
        return true;
    L9:
        if (r2.getConfig$initscheduler_release().isMainProcess() == false) goto L13;
        return r5.f4905l.contains("main");
    L13:
        if (r5.f4905l.contains("nonmain") == false) goto L15;
        return true;
    L15:
        ProcessMatchMode r1 = r2.getProcessMatchMode$initscheduler_release();
        int r3 = a.b.a.a.l.c.f73a[r1.ordinal()];
        if (r3 != 1) goto L18;
        List<String> r6 = r5.f4905l;
        kotlin.n0.d.o.b(r6, "runInProcess");
        Iterator<T> r7 = r6.iterator();
    L28:
        if (r7.hasNext() == false) goto L41;
        String r4 = (String) r7.next();
        String r8 = InitScheduler.INSTANCE.getConfig$initscheduler_release().getProcessName();
        kotlin.n0.d.o.b(r4, "it");
        if (kotlin.u0.k.m(r8, r4, true) == false) goto L28;
        return true;
    L41:
        return false;
    L18:
        if (r3 != 2) goto L32;
        List<String> r9 = r5.f4905l;
        kotlin.n0.d.o.b(r9, "runInProcess");
        Iterator<T> r10 = r9.iterator();
    L22:
        if (r10.hasNext() == false) goto L40;
        String r11 = (String) r10.next();
        String r12 = InitScheduler.INSTANCE.getConfig$initscheduler_release().getProcessName();
        kotlin.n0.d.o.b(r11, "it");
        if (kotlin.u0.k.D(r12, r11, true) == false) goto L22;
        return true;
    L40:
        return false;
    L32:
        return false;
    }

    public static final boolean d(l r1) {
        kotlin.n0.d.o.g(r1, "receiver$0");
        return kotlin.n0.d.o.a("init_shceduler_internal_task", r1.f4901h);
    }
}
