package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CopyableThrowable;

/* JADX INFO: compiled from: ExceptionsConstructor.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a2\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\u0002`\u0007\"\b\b\u0000\u0010\b*\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\u0002\u001a.\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\u0002`\u00072\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H\u0002\u001a!\u0010\r\u001a\u0004\u0018\u0001H\b\"\b\b\u0000\u0010\b*\u00020\u00062\u0006\u0010\u000e\u001a\u0002H\bH\u0000¢\u0006\u0002\u0010\u000f\u001a\u001b\u0010\u0010\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\n2\b\b\u0002\u0010\u0011\u001a\u00020\u0003H\u0082\u0010\u001a\u0018\u0010\u0012\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u0013\u001a\u00020\u0003H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000*(\b\u0002\u0010\u0014\"\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¨\u0006\u0015"}, d2 = {"ctorCache", "Lkotlinx/coroutines/internal/CtorCache;", "throwableFields", "", "createConstructor", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/Ctor;", "E", "clz", "Ljava/lang/Class;", "safeCtor", "block", "tryCopyException", "exception", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "fieldsCount", "accumulator", "fieldsCountOrDefault", "defaultValue", "Ctor", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ExceptionsConstructorKt {
    private static final CtorCache ctorCache = null;
    private static final int throwableFields = 0;

    public static final /* synthetic */ Function1 access$createConstructor(Class r0) {
        return createConstructor(r0);
    }

    static {
        throwableFields = fieldsCountOrDefault(Throwable.class, -1);
    L8:
        WeakMapCtorCache r0 = WeakMapCtorCache.INSTANCE;
    L9:
        ctorCache = r0;
        return;
    L4:
        if (FastServiceLoaderKt.getANDROID_DETECTED() == false) goto L6;
        r0 = WeakMapCtorCache.INSTANCE;     // Catch: Throwable -> L8
    L11:
        goto L9
    L6:
        r0 = ClassValueCtorCache.INSTANCE;     // Catch: Throwable -> L8
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E extends Throwable> E tryCopyException(E r2) {
        if ((r2 instanceof CopyableThrowable) == false) goto L14;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L6
        Object r3 = Result.m1508constructorimpl(((CopyableThrowable) r2).createCopy());     // Catch: Throwable -> L6
    L9:
        if (Result.m1514isFailureimpl(r3) == false) goto L12;
        r3 = null;
    L12:
        return (E) r3;
    L6:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r3 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L9
    L14:
        return (E) ctorCache.get(r2.getClass()).invoke(r2);
    }

    private static final <E extends Throwable> Function1<Throwable, Throwable> createConstructor(Class<E> r12) {
        ExceptionsConstructorKt$createConstructor$nullResult$1 r0 = ExceptionsConstructorKt$createConstructor$nullResult$1.INSTANCE;
        if (throwableFields == fieldsCountOrDefault(r12, 0)) goto L5;
        return r0;
    L5:
        Constructor<?>[] r13 = r12.getConstructors();
        ArrayList r1 = new ArrayList(r13.length);
        int r3 = r13.length;
        int r4 = 0;
    L6:
        Object r5 = null;
        if (r4 >= r3) goto L29;
        final Constructor<?> r6 = r13[r4];
        Class<?>[] r7 = r6.getParameterTypes();
        int r8 = r7.length;
        if (r8 != 0) goto L11;
        Pair r9 = TuplesKt.to(safeCtor(new ExceptionsConstructorKt$createConstructor$1$4(r6)), 0);
    L28:
        r1.add(r9);
        r4 = r4 + 1;
        goto L6
    L11:
        if (r8 == 1) goto L20;
        if (r8 == 2) goto L15;
        r9 = TuplesKt.to(null, -1);
        goto L28
    L15:
        if (Intrinsics.areEqual(r7[0], String.class) == true) goto L17;
    L19:
        r9 = TuplesKt.to(null, -1);
        goto L28
    L17:
        if (Intrinsics.areEqual(r7[1], Throwable.class) == false) goto L19;
        r9 = TuplesKt.to(safeCtor(new ExceptionsConstructorKt$createConstructor$1$1(r6)), 3);
        goto L28
    L20:
        Class<?> r10 = r7[0];
        if (Intrinsics.areEqual(r10, String.class) == false) goto L24;
        r9 = TuplesKt.to(safeCtor(new ExceptionsConstructorKt$createConstructor$1$2(r6)), 2);
        goto L28
    L24:
        if (Intrinsics.areEqual(r10, Throwable.class) == false) goto L26;
        r9 = TuplesKt.to(safeCtor(new ExceptionsConstructorKt$createConstructor$1$3(r6)), 1);
        goto L28
    L26:
        r9 = TuplesKt.to(null, -1);
        goto L28
    L29:
        Iterator r14 = r1.iterator();
        if (r14.hasNext() == false) goto L41;
        r5 = r14.next();
        if (r14.hasNext() == false) goto L41;
        int r2 = ((Number) ((Pair) r5).getSecond()).intValue();
    L36:
        Object r11 = r14.next();
        int r15 = ((Number) ((Pair) r11).getSecond()).intValue();
        if (r2 >= r15) goto L40;
        r5 = r11;
        r2 = r15;
    L40:
        if (r14.hasNext() == true) goto L36;
    L41:
        Pair r16 = (Pair) r5;
        if (r16 == null) goto L58;
        Function1<Throwable, Throwable> r17 = (Function1) r16.getFirst();
        if (r17 != null) goto L47;
        return r0;
    L47:
        return r17;
    L58:
        return r0;
    }

    private static final Function1<Throwable, Throwable> safeCtor(final Function1<? super Throwable, ? extends Throwable> r1) {
        return new AnonymousClass1(r1);
    }

    private static final int fieldsCountOrDefault(Class<?> r3, int r4) {
        JvmClassMappingKt.getKotlinClass(r3);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r5 = Result.m1508constructorimpl(Integer.valueOf(fieldsCount$default(r3, 0, 1, null)));     // Catch: Throwable -> L5
    L7:
        Integer r6 = Integer.valueOf(r4);
        if (Result.m1514isFailureimpl(r5) == false) goto L11;
        r5 = r6;
    L11:
        return ((Number) r5).intValue();
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r5 = Result.m1508constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    static /* synthetic */ int fieldsCount$default(Class r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        return fieldsCount(r0, r1);
    }

    private static final int fieldsCount(Class<?> r5, int r6) {
    L2:
        Field[] r0 = r5.getDeclaredFields();
        int r1 = r0.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r1) goto L8;
        if ((!Modifier.isStatic(r0[r2].getModifiers())) == false) goto L7;
        r3 = r3 + 1;
    L7:
        r2 = r2 + 1;
        goto L3
    L8:
        r6 = r6 + r3;
        r5 = r5.getSuperclass();
        if (r5 != null) goto L2;
        return r6;
    }
}
