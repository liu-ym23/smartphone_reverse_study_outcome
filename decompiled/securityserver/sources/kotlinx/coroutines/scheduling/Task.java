package kotlinx.coroutines.scheduling;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class Task implements Runnable {
    public long b;
    public TaskContext c;

    public Task(long r1, TaskContext r3) {
        this.b = r1;
        this.c = r3;
    }
}
