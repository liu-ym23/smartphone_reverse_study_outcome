package kotlin.reflect;

import kotlin.Metadata;
import kotlin.SinceKotlin;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@Metadata
public final enum KVisibility extends Enum<KVisibility> {
    public static final /* synthetic */ KVisibility[] b = null;

    static {
        b = new KVisibility[]{new KVisibility("PUBLIC", 0), new KVisibility("PROTECTED", 1), new KVisibility("INTERNAL", 2), new KVisibility("PRIVATE", 3)};
    }

    public static KVisibility valueOf(String r1) {
        return (KVisibility) Enum.valueOf(KVisibility.class, r1);
    }

    public static KVisibility[] values() {
        return (KVisibility[]) b.clone();
    }
}
