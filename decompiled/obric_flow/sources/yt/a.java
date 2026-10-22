package yt;

import kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f23324a = null;

    static {
        int[] r5 = new int[CoroutineScheduler$WorkerState.values().length];
        r5[CoroutineScheduler$WorkerState.PARKING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
    L15:
        r5[CoroutineScheduler$WorkerState.BLOCKING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
    L23:
        r5[CoroutineScheduler$WorkerState.CPU_ACQUIRED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
    L17:
        r5[CoroutineScheduler$WorkerState.DORMANT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
    L19:
        r5[CoroutineScheduler$WorkerState.TERMINATED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
    L8:
        f23324a = r5;
    }
}
