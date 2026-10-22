package kotlinx.coroutines.channels;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final enum BufferOverflow extends Enum<BufferOverflow> {
    public static final BufferOverflow b = null;
    public static final BufferOverflow c = null;
    public static final /* synthetic */ BufferOverflow[] e = null;

    static {
        BufferOverflow r0 = new BufferOverflow("SUSPEND", 0);
        b = r0;
        BufferOverflow r1 = new BufferOverflow("DROP_OLDEST", 1);
        c = r1;
        e = new BufferOverflow[]{r0, r1, new BufferOverflow("DROP_LATEST", 2)};
    }

    public static BufferOverflow valueOf(String r1) {
        return (BufferOverflow) Enum.valueOf(BufferOverflow.class, r1);
    }

    public static BufferOverflow[] values() {
        return (BufferOverflow[]) e.clone();
    }
}
