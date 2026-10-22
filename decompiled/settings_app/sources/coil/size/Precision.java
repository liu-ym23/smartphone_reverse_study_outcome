package coil.size;

import kotlin.Metadata;

/* JADX INFO: compiled from: Precision.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcoil/size/Precision;", "", "(Ljava/lang/String;I)V", "EXACT", "INEXACT", "AUTOMATIC", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final enum Precision extends Enum<Precision> {
    private static final /* synthetic */ Precision[] $VALUES = null;
    public static final Precision AUTOMATIC = null;
    public static final Precision EXACT = null;
    public static final Precision INEXACT = null;

    private static final /* synthetic */ Precision[] $values() {
        return new Precision[]{EXACT, INEXACT, AUTOMATIC};
    }

    public static Precision valueOf(String r1) {
        return (Precision) Enum.valueOf(Precision.class, r1);
    }

    public static Precision[] values() {
        return (Precision[]) $VALUES.clone();
    }

    private Precision(String r1, int r2) {
        super(r1, r2);
    }

    static {
        EXACT = new Precision("EXACT", 0);
        INEXACT = new Precision("INEXACT", 1);
        AUTOMATIC = new Precision("AUTOMATIC", 2);
        $VALUES = $values();
    }
}
