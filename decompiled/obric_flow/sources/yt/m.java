package yt;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes3.dex */
public final class m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f23349b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f23350c = null;
    public static final /* synthetic */ AtomicIntegerFieldUpdater d = null;
    public static final /* synthetic */ AtomicIntegerFieldUpdater e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReferenceArray f23351a;
    private volatile /* synthetic */ int blockingTasksInBuffer$volatile;
    private volatile /* synthetic */ int consumerIndex$volatile;
    private volatile /* synthetic */ Object lastScheduledTask$volatile;
    private volatile /* synthetic */ int producerIndex$volatile;

    static {
        f23349b = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "lastScheduledTask$volatile");
        f23350c = AtomicIntegerFieldUpdater.newUpdater(m.class, "producerIndex$volatile");
        d = AtomicIntegerFieldUpdater.newUpdater(m.class, "consumerIndex$volatile");
        e = AtomicIntegerFieldUpdater.newUpdater(m.class, "blockingTasksInBuffer$volatile");
    }

    public m() {
        this.f23351a = new AtomicReferenceArray(128);
    }

    public final i a(i r5) {
        AtomicIntegerFieldUpdater r10 = f23350c;
        if ((r10.get(this) - d.get(this)) != 127) goto L6;
        return r5;
    L6:
        if (r5.f23343b == false) goto L8;
        e.incrementAndGet(this);
    L8:
        int r11 = r10.get(this) & 127;
    L9:
        AtomicReferenceArray r12 = this.f23351a;
        if (r12.get(r11) == null) goto L12;
        Thread.yield();
        goto L9
    L12:
        r12.lazySet(r11, r5);
        r10.incrementAndGet(this);
        return null;
    }

    public final i b() {
    L2:
        AtomicIntegerFieldUpdater r5 = d;
        int r10 = r5.get(this);
        if ((r10 - f23350c.get(this)) == 0) goto L4;
        int r11 = r10 & 127;
        if (r5.compareAndSet(this, r10, r10 + 1) == false) goto L2;
        i r12 = (i) this.f23351a.getAndSet(r11, null);
        if (r12 == null) goto L2;
        if (r12.f23343b == false) goto L13;
        e.decrementAndGet(this);
    L13:
        return r12;
    L4:
        return null;
    }

    public final i c(int r5, boolean r10) {
        int r11 = r5 & 127;
        AtomicReferenceArray r12 = this.f23351a;
        i r13 = (i) r12.get(r11);
        if (r13 != null) goto L5;
    L13:
        return null;
    L5:
        if (r13.f23343b != r10) goto L13;
    L7:
        if (r12.compareAndSet(r11, r13, null) == true) goto L8;
        if (r12.get(r11) == r13) goto L7;
    L8:
        if (r10 == false) goto L10;
        e.decrementAndGet(this);
    L10:
        return r13;
    }
}
