package kotlin.ranges;

import java.lang.Comparable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface ClosedRange<T extends Comparable<? super T>> {

    @Metadata
    public static final class DefaultImpls {
        public static boolean a(ClosedRange r1) {
            if (r1.getStart().compareTo(r1.getEndInclusive()) <= 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    Comparable getEndInclusive();

    Comparable getStart();
}
