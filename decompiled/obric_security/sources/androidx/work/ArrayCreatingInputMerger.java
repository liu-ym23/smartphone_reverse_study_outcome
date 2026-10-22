package androidx.work;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ArrayCreatingInputMerger.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u001e\u0010\f\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0002J\u0016\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010H\u0016¨\u0006\u0011"}, d2 = {"Landroidx/work/ArrayCreatingInputMerger;", "Landroidx/work/InputMerger;", "()V", "concatenateArrayAndNonArray", "", "array", "obj", "valueClass", "Ljava/lang/Class;", "concatenateArrays", "array1", "array2", "createArrayFor", "merge", "Landroidx/work/Data;", "inputs", "", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ArrayCreatingInputMerger extends InputMerger {
    public ArrayCreatingInputMerger() {
    }

    @Override // androidx.work.InputMerger
    public Data merge(List<Data> r10) {
        Intrinsics.checkNotNullParameter(r10, "inputs");
        Data.Builder r0 = new Data.Builder();
        HashMap r1 = new HashMap();
        Iterator<Data> r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L28;
        Map<String, Object> r2 = r11.next().getKeyValueMap();
        Intrinsics.checkNotNullExpressionValue(r2, "input.keyValueMap");
        Iterator<Map.Entry<String, Object>> r3 = r2.entrySet().iterator();
    L7:
        if (r3.hasNext() == false) goto L4;
        Map.Entry<String, Object> r4 = r3.next();
        String r5 = r4.getKey();
        Object r6 = r4.getValue();
        if (r6 == null) goto L12;
        Class<?> r7 = r6.getClass();
        if (r7 == null) goto L12;
    L13:
        Object r8 = r1.get(r5);
        Intrinsics.checkNotNullExpressionValue(r5, "key");
        if (r8 == null) goto L16;
        Class<?> r9 = r8.getClass();
        if (Intrinsics.areEqual(r9, r7) == false) goto L23;
        Intrinsics.checkNotNullExpressionValue(r6, "value");
        r6 = concatenateArrays(r8, r6);
    L25:
        Intrinsics.checkNotNullExpressionValue(r6, "if (existingValue == nul…      }\n                }");
        r1.put(r5, r6);
        goto L7
    L23:
        if (Intrinsics.areEqual(r9.getComponentType(), r7) == false) goto L27;
        r6 = concatenateArrayAndNonArray(r8, r6, r7);
        goto L25
    L27:
        throw new IllegalArgumentException();
    L16:
        if (r7.isArray() == true) goto L25;
        r6 = createArrayFor(r6, r7);
    L12:
        r7 = String.class;
        goto L13
    L28:
        r0.putAll(r1);
        Data r12 = r0.build();
        Intrinsics.checkNotNullExpressionValue(r12, "output.build()");
        return r12;
    }

    private final Object concatenateArrays(Object r4, Object r5) {
        int r3 = Array.getLength(r4);
        int r0 = Array.getLength(r5);
        Class<?> r1 = r4.getClass().getComponentType();
        Intrinsics.checkNotNull(r1);
        Object r2 = Array.newInstance(r1, r3 + r0);
        System.arraycopy(r4, 0, r2, 0, r3);
        System.arraycopy(r5, 0, r2, r3, r0);
        Intrinsics.checkNotNullExpressionValue(r2, "newArray");
        return r2;
    }

    private final Object concatenateArrayAndNonArray(Object r2, Object r3, Class<?> r4) {
        int r1 = Array.getLength(r2);
        Object r5 = Array.newInstance(r4, r1 + 1);
        System.arraycopy(r2, 0, r5, 0, r1);
        Array.set(r5, r1, r3);
        Intrinsics.checkNotNullExpressionValue(r5, "newArray");
        return r5;
    }

    private final Object createArrayFor(Object r1, Class<?> r2) {
        Object r0 = Array.newInstance(r2, 1);
        Array.set(r0, 0, r1);
        Intrinsics.checkNotNullExpressionValue(r0, "newArray");
        return r0;
    }
}
