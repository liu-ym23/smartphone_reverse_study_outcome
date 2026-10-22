package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmInline;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@Metadata
@ExperimentalTime
public interface TimeSource {

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final class Monotonic implements TimeSource {

        @SinceKotlin
        @Metadata
        @JvmInline
        @ExperimentalTime
        public static final class ValueTimeMark implements TimeMark {
            public final boolean equals(Object r1) {
                if ((r1 instanceof ValueTimeMark) == true) goto L5;
                return false;
            L5:
                ((ValueTimeMark) r1).getClass();
                return true;
            }

            public final int hashCode() {
                return (int) 0;
            }

            public final String toString() {
                return "ValueTimeMark(reading=0)";
            }
        }

        public final String toString() {
            int r0 = MonotonicTimeSource.f359a;
            return "TimeSource(System.nanoTime())";
        }
    }
}
