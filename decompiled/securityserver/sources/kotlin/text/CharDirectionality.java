package kotlin.text;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final enum CharDirectionality extends Enum<CharDirectionality> {
    public static final Lazy c = null;
    public static final /* synthetic */ CharDirectionality[] e = null;
    public final int b;

    @Metadata
    public static final class Companion {
    }

    static {
        e = new CharDirectionality[]{new CharDirectionality("UNDEFINED", 0, -1), new CharDirectionality("LEFT_TO_RIGHT", 1, 0), new CharDirectionality("RIGHT_TO_LEFT", 2, 1), new CharDirectionality("RIGHT_TO_LEFT_ARABIC", 3, 2), new CharDirectionality("EUROPEAN_NUMBER", 4, 3), new CharDirectionality("EUROPEAN_NUMBER_SEPARATOR", 5, 4), new CharDirectionality("EUROPEAN_NUMBER_TERMINATOR", 6, 5), new CharDirectionality("ARABIC_NUMBER", 7, 6), new CharDirectionality("COMMON_NUMBER_SEPARATOR", 8, 7), new CharDirectionality("NONSPACING_MARK", 9, 8), new CharDirectionality("BOUNDARY_NEUTRAL", 10, 9), new CharDirectionality("PARAGRAPH_SEPARATOR", 11, 10), new CharDirectionality("SEGMENT_SEPARATOR", 12, 11), new CharDirectionality("WHITESPACE", 13, 12), new CharDirectionality("OTHER_NEUTRALS", 14, 13), new CharDirectionality("LEFT_TO_RIGHT_EMBEDDING", 15, 14), new CharDirectionality("LEFT_TO_RIGHT_OVERRIDE", 16, 15), new CharDirectionality("RIGHT_TO_LEFT_EMBEDDING", 17, 16), new CharDirectionality("RIGHT_TO_LEFT_OVERRIDE", 18, 17), new CharDirectionality("POP_DIRECTIONAL_FORMAT", 19, 18)};
        c = LazyKt.b(CharDirectionality$Companion$directionalityMap$2.b);
    }

    public CharDirectionality(String r1, int r2, int r3) {
        super(r1, r2);
        this.b = r3;
    }

    public static CharDirectionality valueOf(String r1) {
        return (CharDirectionality) Enum.valueOf(CharDirectionality.class, r1);
    }

    public static CharDirectionality[] values() {
        return (CharDirectionality[]) e.clone();
    }
}
