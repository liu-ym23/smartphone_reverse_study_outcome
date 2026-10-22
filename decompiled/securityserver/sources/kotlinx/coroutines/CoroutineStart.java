package kotlinx.coroutines;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final enum CoroutineStart extends Enum<CoroutineStart> {
    public static final CoroutineStart b = null;
    public static final CoroutineStart c = null;
    public static final CoroutineStart e = null;
    public static final CoroutineStart f = null;
    public static final /* synthetic */ CoroutineStart[] i = null;

    @Metadata
    public final /* synthetic */ class WhenMappings {
        static {
            int[] r0 = new int[CoroutineStart.values().length];
            r0[0] = 1;
            r0[2] = 2;
            r0[3] = 3;
            r0[1] = 4;
            int[] r1 = new int[CoroutineStart.values().length];
            r1[0] = 1;
            r1[2] = 2;
            r1[3] = 3;
            r1[1] = 4;
        }
    }

    static {
        CoroutineStart r0 = new CoroutineStart("DEFAULT", 0);
        b = r0;
        CoroutineStart r1 = new CoroutineStart("LAZY", 1);
        c = r1;
        CoroutineStart r2 = new CoroutineStart("ATOMIC", 2);
        e = r2;
        CoroutineStart r3 = new CoroutineStart("UNDISPATCHED", 3);
        f = r3;
        i = new CoroutineStart[]{r0, r1, r2, r3};
    }

    public static CoroutineStart valueOf(String r1) {
        return (CoroutineStart) Enum.valueOf(CoroutineStart.class, r1);
    }

    public static CoroutineStart[] values() {
        return (CoroutineStart[]) i.clone();
    }
}
