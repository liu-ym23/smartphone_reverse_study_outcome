package coil.size;

import kotlin.Metadata;

/* JADX INFO: compiled from: Scale.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcoil/size/Scale;", "", "(Ljava/lang/String;I)V", "FILL", "FIT", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final enum Scale extends Enum<Scale> {
    private static final /* synthetic */ Scale[] $VALUES = null;
    public static final Scale FILL = null;
    public static final Scale FIT = null;

    private static final /* synthetic */ Scale[] $values() {
        return new Scale[]{FILL, FIT};
    }

    public static Scale valueOf(String r1) {
        return (Scale) Enum.valueOf(Scale.class, r1);
    }

    public static Scale[] values() {
        return (Scale[]) $VALUES.clone();
    }

    private Scale(String r1, int r2) {
        super(r1, r2);
    }

    static {
        FILL = new Scale("FILL", 0);
        FIT = new Scale("FIT", 1);
        $VALUES = $values();
    }
}
