package t2;

import com.bytedance.ai.infra.thread_pool.ThreadPriority;
import com.bytedance.common.utility.Logger;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThreadPriority f22093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicInteger f22094c;

    public d(String r5, ThreadPriority r10) {
        Intrinsics.checkNotNullParameter(r5, "namePrefix");
        Intrinsics.checkNotNullParameter(r10, "threadPriority");
        this.f22092a = r5;
        this.f22093b = r10;
        this.f22094c = new AtomicInteger(0);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r5) {
        Intrinsics.checkNotNullParameter(r5, "r");
        String r10 = this.f22092a + '-' + this.f22094c.incrementAndGet();
        Logger.d("DefaultThreadFactory", td.d.b("Create New Thread: ", r10));
        return new b9.a(r5, r10, this);
    }
}
