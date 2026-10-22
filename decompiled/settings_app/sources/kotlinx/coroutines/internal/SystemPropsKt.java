package kotlinx.coroutines.internal;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"kotlinx/coroutines/internal/SystemPropsKt__SystemPropsKt", "kotlinx/coroutines/internal/SystemPropsKt__SystemProps_commonKt"}, k = 4, mv = {1, 8, 0}, xi = 48)
public final class SystemPropsKt {
    public static final int getAVAILABLE_PROCESSORS() {
        return SystemPropsKt__SystemPropsKt.getAVAILABLE_PROCESSORS();
    }

    public static final int systemProp(String r0, int r1, int r2, int r3) {
        return SystemPropsKt__SystemProps_commonKt.systemProp(r0, r1, r2, r3);
    }

    public static final long systemProp(String r0, long r1, long r3, long r5) {
        return SystemPropsKt__SystemProps_commonKt.systemProp(r0, r1, r3, r5);
    }

    public static final String systemProp(String r0) {
        return SystemPropsKt__SystemPropsKt.systemProp(r0);
    }

    public static final String systemProp(String r0, String r1) {
        return SystemPropsKt__SystemProps_commonKt.systemProp(r0, r1);
    }

    public static final boolean systemProp(String r0, boolean r1) {
        return SystemPropsKt__SystemProps_commonKt.systemProp(r0, r1);
    }

    public static /* synthetic */ int systemProp$default(String r0, int r1, int r2, int r3, int r4, Object r5) {
        return SystemPropsKt__SystemProps_commonKt.systemProp$default(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ long systemProp$default(String r0, long r1, long r3, long r5, int r7, Object r8) {
        return SystemPropsKt__SystemProps_commonKt.systemProp$default(r0, r1, r3, r5, r7, r8);
    }
}
