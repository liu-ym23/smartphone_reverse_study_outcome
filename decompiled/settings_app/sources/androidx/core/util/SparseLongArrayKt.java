package androidx.core.util;

import android.icu.text.PluralRules;
import android.util.SparseLongArray;
import com.bytedance.apm.constant.PerfConsts;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.collections.LongIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SparseLongArray.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0087\n\u001a\u0015\u0010\b\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\t\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0087\b\u001aH\u0010\f\u001a\u00020\r*\u00020\u000226\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\r0\u000fH\u0087\bø\u0001\u0000\u001a\u001d\u0010\u0012\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u000bH\u0087\b\u001a&\u0010\u0014\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0015H\u0087\bø\u0001\u0000\u001a\r\u0010\u0016\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\r\u0010\u0017\u001a\u00020\u0006*\u00020\u0002H\u0087\b\u001a\f\u0010\u0018\u001a\u00020\u0019*\u00020\u0002H\u0007\u001a\u0015\u0010\u001a\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0087\u0002\u001a\u0014\u0010\u001c\u001a\u00020\r*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0007\u001a\u001c\u0010\u001d\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0007\u001a\u001d\u0010\u001e\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0087\n\u001a\f\u0010\u001f\u001a\u00020 *\u00020\u0002H\u0007\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Ç\u0002¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006!"}, d2 = {PerfConsts.PERF_DISK_FILE_SIZE, "", "Landroid/util/SparseLongArray;", "getSize", "(Landroid/util/SparseLongArray;)I", "contains", "", "key", "containsKey", "containsValue", "value", "", "forEach", "", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "getOrDefault", "defaultValue", "getOrElse", "Lkotlin/Function0;", "isEmpty", "isNotEmpty", "keyIterator", "Lkotlin/collections/IntIterator;", "plus", PluralRules.KEYWORD_OTHER, "putAll", "remove", "set", "valueIterator", "Lkotlin/collections/LongIterator;", "core-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class SparseLongArrayKt {
    public static final int getSize(SparseLongArray r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.size();
    }

    public static final boolean contains(SparseLongArray r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.indexOfKey(r2) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final void set(SparseLongArray r1, int r2, long r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.put(r2, r3);
    }

    public static final SparseLongArray plus(SparseLongArray r3, SparseLongArray r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, PluralRules.KEYWORD_OTHER);
        SparseLongArray r0 = new SparseLongArray(r3.size() + r4.size());
        putAll(r0, r3);
        putAll(r0, r4);
        return r0;
    }

    public static final boolean containsKey(SparseLongArray r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.indexOfKey(r2) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean containsValue(SparseLongArray r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.indexOfValue(r2) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final long getOrDefault(SparseLongArray r1, int r2, long r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.get(r2, r3);
    }

    public static final long getOrElse(SparseLongArray r1, int r2, Function0<Long> r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r3, "defaultValue");
        int r4 = r1.indexOfKey(r2);
        if (r4 < 0) goto L6;
        return r1.valueAt(r4);
    L6:
        return r3.invoke().longValue();
    }

    public static final boolean isEmpty(SparseLongArray r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean isNotEmpty(SparseLongArray r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.size() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean remove(SparseLongArray r2, int r3, long r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        int r5 = r2.indexOfKey(r3);
        if (r5 >= 0) goto L5;
        return false;
    L5:
        if (r4 != r2.valueAt(r5)) goto L10;
        r2.removeAt(r5);
        return true;
    L10:
        return false;
    }

    public static final void forEach(SparseLongArray r5, Function2<? super Integer, ? super Long, Unit> r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "action");
        int r0 = r5.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r6.invoke(Integer.valueOf(r5.keyAt(r1)), Long.valueOf(r5.valueAt(r1)));
        r1 = r1 + 1;
        goto L3
    }

    public static final IntIterator keyIterator(final SparseLongArray r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return new AnonymousClass1(r1);
    }

    public static final LongIterator valueIterator(final SparseLongArray r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return new C01151(r1);
    }

    public static final void putAll(SparseLongArray r5, SparseLongArray r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, PluralRules.KEYWORD_OTHER);
        int r0 = r6.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r5.put(r6.keyAt(r1), r6.valueAt(r1));
        r1 = r1 + 1;
        goto L3
    }
}
