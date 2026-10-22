package kotlin.contracts;

import com.bytedance.networkstackapplib.NetworkStackConstant;
import kotlin.Metadata;

/* JADX INFO: compiled from: ContractBuilder.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/contracts/InvocationKind;", "", "(Ljava/lang/String;I)V", "AT_MOST_ONCE", "AT_LEAST_ONCE", "EXACTLY_ONCE", NetworkStackConstant.UNKNOWN_TYPE, "kotlin-stdlib"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final enum InvocationKind extends Enum<InvocationKind> {
    private static final /* synthetic */ InvocationKind[] $VALUES = null;
    public static final InvocationKind AT_LEAST_ONCE = null;
    public static final InvocationKind AT_MOST_ONCE = null;
    public static final InvocationKind EXACTLY_ONCE = null;
    public static final InvocationKind UNKNOWN = null;

    private static final /* synthetic */ InvocationKind[] $values() {
        return new InvocationKind[]{AT_MOST_ONCE, AT_LEAST_ONCE, EXACTLY_ONCE, UNKNOWN};
    }

    public static InvocationKind valueOf(String r1) {
        return (InvocationKind) Enum.valueOf(InvocationKind.class, r1);
    }

    public static InvocationKind[] values() {
        return (InvocationKind[]) $VALUES.clone();
    }

    private InvocationKind(String r1, int r2) {
        super(r1, r2);
    }

    static {
        AT_MOST_ONCE = new InvocationKind("AT_MOST_ONCE", 0);
        AT_LEAST_ONCE = new InvocationKind("AT_LEAST_ONCE", 1);
        EXACTLY_ONCE = new InvocationKind("EXACTLY_ONCE", 2);
        UNKNOWN = new InvocationKind(NetworkStackConstant.UNKNOWN_TYPE, 3);
        $VALUES = $values();
    }
}
