package kotlin.collections.builders;

import android.icu.text.PluralRules;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.constant.PerfConsts;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ListBuilder.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0005\u001a+\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0001\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u00012\u0006\u0010\b\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\t\u001a%\u0010\n\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\f\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\r\u001a-\u0010\u000e\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0010\u0011\u001a9\u0010\u0012\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u00012\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0002¢\u0006\u0002\u0010\u0018\u001a-\u0010\u0019\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u00012\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u001a\u001a=\u0010\u001b\u001a\u00020\u001c\"\u0004\b\u0000\u0010\u0007*\n\u0012\u0006\b\u0001\u0012\u0002H\u00070\u00012\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00070\u001eH\u0002¢\u0006\u0002\u0010\u001f¨\u0006 "}, d2 = {"arrayOfUninitializedElements", "", "E", PerfConsts.PERF_DISK_FILE_SIZE, "", "(I)[Ljava/lang/Object;", "copyOfUninitializedElements", ExifInterface.GPS_DIRECTION_TRUE, "newSize", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "resetAt", "", "index", "([Ljava/lang/Object;I)V", "resetRange", "fromIndex", "toIndex", "([Ljava/lang/Object;II)V", "subarrayContentEquals", "", "offset", "length", PluralRules.KEYWORD_OTHER, "", "([Ljava/lang/Object;IILjava/util/List;)Z", "subarrayContentHashCode", "([Ljava/lang/Object;II)I", "subarrayContentToString", "", "thisCollection", "", "([Ljava/lang/Object;IILjava/util/Collection;)Ljava/lang/String;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ListBuilderKt {
    public static final /* synthetic */ boolean access$subarrayContentEquals(Object[] r0, int r1, int r2, List r3) {
        return subarrayContentEquals(r0, r1, r2, r3);
    }

    public static final /* synthetic */ int access$subarrayContentHashCode(Object[] r0, int r1, int r2) {
        return subarrayContentHashCode(r0, r1, r2);
    }

    public static final /* synthetic */ String access$subarrayContentToString(Object[] r0, int r1, int r2, Collection r3) {
        return subarrayContentToString(r0, r1, r2, r3);
    }

    public static final <E> E[] arrayOfUninitializedElements(int r1) {
        if (r1 < 0) goto L4;
        boolean r0 = true;
    L5:
        if (r0 == false) goto L9;
        return (E[]) new Object[r1];
    L9:
        throw new IllegalArgumentException("capacity must be non-negative.".toString());
    L4:
        r0 = false;
        goto L5
    }

    private static final <T> String subarrayContentToString(T[] r3, int r4, int r5, Collection<? extends T> r6) {
        StringBuilder r0 = new StringBuilder((r5 * 3) + 2);
        r0.append("[");
        int r1 = 0;
    L3:
        if (r1 >= r5) goto L11;
        if (r1 <= 0) goto L6;
        r0.append(", ");
    L6:
        T r2 = r3[r4 + r1];
        if (r2 != r6) goto L9;
        r0.append("(this Collection)");
    L10:
        r1 = r1 + 1;
        goto L3
    L9:
        r0.append(r2);
        goto L10
    L11:
        r0.append("]");
        String r7 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r7, "toString(...)");
        return r7;
    }

    private static final <T> int subarrayContentHashCode(T[] r4, int r5, int r6) {
        int r0 = 1;
        int r2 = 0;
    L3:
        if (r2 >= r6) goto L9;
        T r3 = r4[r5 + r2];
        int r1 = r0 * 31;
        if (r3 == null) goto L7;
        int r7 = r3.hashCode();
    L8:
        r0 = r1 + r7;
        r2 = r2 + 1;
        goto L3
    L7:
        r7 = 0;
        goto L8
    L9:
        return r0;
    }

    private static final <T> boolean subarrayContentEquals(T[] r4, int r5, int r6, List<?> r7) {
        if (r6 == r7.size()) goto L5;
        return false;
    L5:
        int r0 = 0;
    L6:
        if (r0 >= r6) goto L11;
        if (Intrinsics.areEqual(r4[r5 + r0], r7.get(r0)) == false) goto L9;
        r0 = r0 + 1;
        goto L6
    L9:
        return false;
    L11:
        return true;
    }

    public static final <T> T[] copyOfUninitializedElements(T[] r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        T[] r3 = (T[]) Arrays.copyOf(r1, r2);
        Intrinsics.checkNotNullExpressionValue(r3, "copyOf(...)");
        return r3;
    }

    public static final <E> void resetAt(E[] r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1[r2] = null;
    }

    public static final <E> void resetRange(E[] r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
    L3:
        if (r2 >= r3) goto L5;
        resetAt(r1, r2);
        r2 = r2 + 1;
        goto L3
    }
}
