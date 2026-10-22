package x7;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f22981a = null;

    static {
        int[] r5 = new int[Lifecycle.State.values().length];
        r5[Lifecycle.State.CREATED.ordinal()] = 1;
        r5[Lifecycle.State.STARTED.ordinal()] = 2;
        r5[Lifecycle.State.RESUMED.ordinal()] = 3;
        r5[Lifecycle.State.DESTROYED.ordinal()] = 4;
        int[] r10 = new int[Lifecycle.Event.values().length];
        f22981a = r10;
        r10[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
        r10[Lifecycle.Event.ON_START.ordinal()] = 2;
        r10[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
        r10[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
        r10[Lifecycle.Event.ON_STOP.ordinal()] = 5;
        r10[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
    }
}
