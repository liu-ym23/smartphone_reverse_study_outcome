package d.b.l.a.h.g;

import android.util.Pair;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import d.b.l.a.h.e;
import d.b.l.a.h.f;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class b extends ScheduledThreadPoolExecutor implements c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f14125f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private f f14126g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map<Integer, List<ScheduledFuture<?>>> f14127h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map<ScheduledFuture<?>, Pair<Integer, Boolean>> f14128i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ExecutorService f14129j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ThreadPoolExecutor f14130k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f14131l;
    private C0377b m;

    class a implements InvocationHandler {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ ExecutorService f14132f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ b f14133g;

        a(b r1, ExecutorService r2) {
            this.f14133g = r1;
            this.f14132f = r2;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r6, Method r7, Object[] r8) {
            Object r9 = r7.invoke(this.f14132f, r8);
            if (b.k(this.f14133g) == false) goto L12;
            String r0 = "null";
            if (r8 == null) goto L9;
            int r1 = r8.length;
            int r2 = 0;
        L7:
            if (r2 >= r1) goto L9;
            r0 = r0 + r8[r2];
            r2 = r2 + 1;
        L9:
            b.l(this.f14133g, "call outer-executor " + r7.getName() + ", args: " + r0);
            if (LocationMonitorConst.SUBMIT.equals(r7.getName()) == false) goto L12;
            b.l(this.f14133g, "call outer-executor " + r7.getName() + ", args: " + r0);
        L12:
            return r9;
        }
    }

    /* JADX INFO: renamed from: d.b.l.a.h.g.b$b, reason: collision with other inner class name */
    public class C0377b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Runnable f14134a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f14135b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f14136c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f14137d;

        public C0377b(b r1, Runnable r2, Thread r3, int r4) {
            this.f14137d = r1;
            this.f14134a = r2;
            this.f14135b = System.currentTimeMillis();
            this.f14136c = r4;
        }

        public void a() {
            Runnable r0 = this.f14134a;
            if (r0 != null) goto L6;
            return;
        L6:
            if ((r0 instanceof FutureTask) == false) goto L11;
            boolean r1 = ((FutureTask) r0).cancel(true);
            if (b.k(this.f14137d) == false) goto L12;
            b.l(this.f14137d, "TimeSensitive + mCancelOverTimeTaskRunnable run ------------ cancel FutureTask, canceled?" + r1);
            return;
        L12:
            return;
        }

        public boolean b() {
            if ((System.currentTimeMillis() - this.f14135b) <= this.f14136c) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public b(int r1, ThreadFactory r2) {
        super(r1, r2);
        this.f14125f = false;
        this.f14127h = new ConcurrentHashMap();
        this.f14128i = new ConcurrentHashMap();
    }

    static /* synthetic */ boolean k(b r0) {
        return r0.s();
    }

    static /* synthetic */ void l(b r0, String r1) {
        r0.q(r1);
    }

    private boolean m(e r7) {
        boolean r0 = false;
        if (r7 != null) goto L5;
        return false;
    L5:
        int r1 = r7.hashCode();
        List<ScheduledFuture<?>> r2 = this.f14127h.get(Integer.valueOf(r1));
        StringBuilder r3 = new StringBuilder();
        r3.append("z-debug scheduledFutures in ?");
        if (r2 == null) goto L8;
        boolean r5 = true;
    L9:
        r3.append(r5);
        q(r3.toString());
        if (r2 != null) goto L12;
    L25:
        return r0;
    L12:
        if (r2.isEmpty() == true) goto L25;
        if (s() == false) goto L16;
        q("z-debug-removeTask from mTaskFutureMap" + d.b.l.a.h.c.b(r7));
        q("z-debug scheduledFutures size:" + r2.size());
    L16:
        Iterator<ScheduledFuture<?>> r8 = r2.iterator();
    L18:
        if (r8.hasNext() == false) goto L25;
        ScheduledFuture<?> r4 = r8.next();
        if (r4.isCancelled() == true) goto L18;
        if (r4.cancel(true) == false) goto L24;
        r0 = true;
    L24:
        t(Integer.valueOf(r1), r4);
        goto L18
    L8:
        r5 = false;
        goto L9
    }

    private void n() {
        C0377b r0 = this.m;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.b() == false) goto L9;
        this.m.a();
        this.m = null;
        return;
    }

    private void o(boolean r2, Runnable r3, Thread r4) {
        if (r() == true) goto L5;
        return;
    L5:
        if (r2 == false) goto L7;
        C0377b r5 = new C0377b(this, r3, r4, this.f14131l);
    L8:
        this.m = r5;
        return;
    L7:
        r5 = null;
        goto L8
    }

    private String p(Runnable r1) {
        if ((r1 instanceof e) == true) goto L5;
        if (r1 != null) goto L10;
        return "null";
    L10:
        return r1.toString();
    L5:
        return ((e) r1).X();
    }

    private void q(String r2) {
        d.b.l.a.h.c.c(this.f14126g, "ApmInnerThreadPool", r2);
    }

    private boolean r() {
        if (this.f14131l <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean s() {
        if (this.f14125f == false) goto L9;
        f r1 = this.f14126g;
        if (r1 == null) goto L9;
        if (r1.isDebug() == false) goto L9;
        return true;
    L9:
        return false;
    }

    private void t(Integer r3, ScheduledFuture r4) {
        List<ScheduledFuture<?>> r0 = this.f14127h.get(r3);
        if (r0 == null) goto L7;
        boolean r1 = r0.remove(r4);
        if (r0.isEmpty() == false) goto L8;
        this.f14127h.remove(r3);
    L8:
        this.f14128i.remove(r4);
        if (s() == false) goto L12;
        q("z-debug removeMapRecord: " + r4 + ", removed: " + r1);
        return;
    L12:
        return;
    L7:
        r1 = false;
        goto L8
    }

    private void u(ScheduledFuture<?> r4, int r5, boolean r6) {
        List<ScheduledFuture<?>> r0 = this.f14127h.get(Integer.valueOf(r5));
        if (r0 != null) goto L5;
        r0 = new CopyOnWriteArrayList();
        this.f14127h.put(Integer.valueOf(r5), r0);
    L5:
        r0.add(r4);
        this.f14128i.put(r4, new Pair(Integer.valueOf(r5), Boolean.valueOf(r6)));
        if (s() == false) goto L9;
        q("z-debug saveToMap -current task count: " + getQueue().size() + ", thread-count; " + getActiveCount());
        q("z-debug saveToMap >>>>>> mTaskFutureMap size: " + this.f14127h.size() + ", mFutureTaskMap size: " + this.f14128i.size());
        StringBuilder r7 = new StringBuilder();
        r7.append("z-debug saveToMap >>>>>> sameHashCodeFutures size: ");
        r7.append(r0.size());
        q(r7.toString());
        return;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable r4, Throwable r5) {
        super.afterExecute(r4, r5);
        o(false, r4, null);
        if ((r4 instanceof ScheduledFuture) == false) goto L18;
        ScheduledFuture r6 = (ScheduledFuture) r4;
        Pair<Integer, Boolean> r0 = this.f14128i.get(r6);
        if (r0 == null) goto L19;
        Object r1 = r0.first;
        if (r1 == null) goto L20;
        int r2 = ((Integer) r1).intValue();
        Boolean r3 = (Boolean) r0.second;
        if (r3 != null) goto L11;
        return;
    L11:
        if (r3.booleanValue() == false) goto L14;
        return;
    L14:
        if (s() == false) goto L16;
        q("z-debug postDelay or scheduled task: " + r4 + ", taskHashCode: " + r2 + ", in map? " + this.f14127h.containsKey(Integer.valueOf(r2)));
    L16:
        t(Integer.valueOf(r2), r6);
        return;
    L20:
        return;
    L19:
        return;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void beforeExecute(Thread r2, Runnable r3) {
        o(true, r3, r2);
        super.beforeExecute(r2, r3);
    }

    @Override // d.b.l.a.h.g.c
    public void c(e r3) {
        if (s() == false) goto L5;
        q("post " + d.b.l.a.h.c.b(r3));
    L5:
        submit(r3);
        n();
        if (this.f14129j == null) goto L8;
        return;
    L8:
        if (s() == false) goto L12;
        q("current task count: " + getQueue().size());
        return;
    }

    @Override // d.b.l.a.h.g.c
    public void e(e r3) {
        ThreadPoolExecutor r0 = this.f14130k;
        if (r0 == null) goto L6;
        r0.remove(r3);
    L6:
        if (m(r3) == false) goto L8;
        return;
    L8:
        if (s() == false) goto L12;
        q("z-debug-removeTask " + d.b.l.a.h.c.b(r3) + ", remove failed");
        return;
    }

    @Override // d.b.l.a.h.g.c
    public void g(e r9, long r10, long r12) {
        if (r9 != null) goto L5;
        return;
    L5:
        if (s() == false) goto L7;
        q("scheduleWithFixedDelay " + d.b.l.a.h.c.b(r9) + ", initialDelay: " + r10 + ", delayInMillis: " + r12 + "\n task count: " + getQueue().size());
    L7:
        m(r9);
        u(scheduleWithFixedDelay(r9, r10, r12, TimeUnit.MILLISECONDS), r9.hashCode(), true);
        n();
    }

    @Override // d.b.l.a.h.g.c
    public void h(e r3, long r4) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (s() == false) goto L7;
        q("postDelayed " + d.b.l.a.h.c.b(r3));
    L7:
        u(schedule(r3, r4, TimeUnit.MILLISECONDS), r3.hashCode(), false);
        n();
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable r3) {
        if (this.f14129j == null) goto L10;
        if (s() == false) goto L8;
        q("submit task to outer-executor: " + p(r3));
    L8:
        return this.f14129j.submit(r3);
    L10:
        return super.submit(r3);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable r3, T r4) {
        if (this.f14129j == null) goto L10;
        if (s() == false) goto L8;
        q("submit task to outer-executor: " + p(r3));
    L8:
        return this.f14129j.submit(r3, r4);
    L10:
        return super.submit(r3, r4);
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> r3) {
        if (this.f14129j == null) goto L10;
        if (s() == false) goto L8;
        q("submit task to outer-executor: " + r3);
    L8:
        return this.f14129j.submit(r3);
    L10:
        return super.submit(r3);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void terminated() {
        super.terminated();
    }

    public void v(ExecutorService r5) {
        if (r5 != null) goto L6;
        this.f14129j = null;
        this.f14130k = null;
        return;
    L6:
        if ((r5 instanceof ThreadPoolExecutor) == false) goto L8;
        this.f14130k = (ThreadPoolExecutor) r5;
    L8:
        this.f14129j = (ExecutorService) Proxy.newProxyInstance(r5.getClass().getClassLoader(), new Class[]{ExecutorService.class}, new a(this, r5));
    }

    public void w(f r1) {
        this.f14126g = r1;
    }
}
