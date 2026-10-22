package com.ss.android.m.a.a;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, WeakReference<ExecutorService>> f12169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<k, AtomicInteger> f12170b;

    j() {
        this.f12169a = new HashMap();
        this.f12170b = new HashMap();
    }

    void a(k r3, ExecutorService r4, boolean r5) {
        if (r5 == false) goto L5;
        this.f12169a.put(r3.name(), new WeakReference(r4));
        return;
    L5:
        if (this.f12170b.get(r3) != null) goto L7;
        this.f12170b.put(r3, new AtomicInteger(0));
    L7:
        this.f12169a.put(r3.name() + "_" + this.f12170b.get(r3).incrementAndGet(), new WeakReference(r4));
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        Iterator<Map.Entry<String, WeakReference<ExecutorService>>> r4 = this.f12169a.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        Map.Entry<String, WeakReference<ExecutorService>> r1 = r4.next();
        String r2 = r1.getKey();
        if (r1.getValue().get() == null) goto L4;
        ThreadPoolExecutor r3 = (ThreadPoolExecutor) r1.getValue().get();
        r0.append("pool=");
        r0.append(r2);
        r0.append(", core.size=");
        r0.append(r3.getCorePoolSize());
        r0.append(", pool.size=");
        r0.append(r3.getPoolSize());
        r0.append(", largest.pool.size=");
        r0.append(r3.getLargestPoolSize());
        r0.append(", queue.size=");
        r0.append(r3.getQueue().size());
        r0.append(", task.count=");
        r0.append(r3.getTaskCount());
        r0.append(", task.completed.count=");
        r0.append(r3.getCompletedTaskCount());
        r0.append("\n");
        goto L4
    L9:
        return r0.toString();
    }
}
