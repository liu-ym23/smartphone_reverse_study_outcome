package y7;

import androidx.lifecycle.Lifecycle;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f23237a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f23238b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f23239c = null;

    static {
        int[] r5 = new int[Lifecycle.Event.values().length];
        f23237a = r5;
        Lifecycle.Event r10 = Lifecycle.Event.ON_DESTROY;
        r5[r10.ordinal()] = 1;
        int[] r11 = new int[Lifecycle.Event.values().length];
        f23238b = r11;
        r11[r10.ordinal()] = 1;
        int[] r12 = new int[Lifecycle.Event.values().length];
        f23239c = r12;
        r12[r10.ordinal()] = 1;
    }
}
