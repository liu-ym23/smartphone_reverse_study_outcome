package kotlin.reflect;

import kotlin.Metadata;
import kotlin.SinceKotlin;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@Metadata
public final enum KVariance extends Enum<KVariance> {
    public static final /* synthetic */ KVariance[] b = null;

    static {
        b = new KVariance[]{new KVariance("INVARIANT", 0), new KVariance("IN", 1), new KVariance("OUT", 2)};
    }

    public static KVariance valueOf(String r1) {
        return (KVariance) Enum.valueOf(KVariance.class, r1);
    }

    public static KVariance[] values() {
        return (KVariance[]) b.clone();
    }
}
