package kotlin.contracts;

import com.bytedance.networkstackapplib.NetworkStackConstant;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.ContractsDsl;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@ContractsDsl
@Metadata
@ExperimentalContracts
public final enum InvocationKind extends Enum<InvocationKind> {
    public static final /* synthetic */ InvocationKind[] b = null;

    static {
        b = new InvocationKind[]{new InvocationKind("AT_MOST_ONCE", 0), new InvocationKind("AT_LEAST_ONCE", 1), new InvocationKind("EXACTLY_ONCE", 2), new InvocationKind(NetworkStackConstant.UNKNOWN_TYPE, 3)};
    }

    public static InvocationKind valueOf(String r1) {
        return (InvocationKind) Enum.valueOf(InvocationKind.class, r1);
    }

    public static InvocationKind[] values() {
        return (InvocationKind[]) b.clone();
    }
}
