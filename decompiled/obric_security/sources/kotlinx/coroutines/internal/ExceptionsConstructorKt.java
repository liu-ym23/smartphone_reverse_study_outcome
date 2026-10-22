package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CopyableThrowable;

/* JADX INFO: compiled from: ExceptionsConstructor.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a2\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\u0002`\u0007\"\b\b\u0000\u0010\b*\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nH\u0002\u001a*\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u00072\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\rH\u0002\u001a1\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005j\u0002`\u00072\u0014\b\u0004\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H\u0082\b\u001a!\u0010\u0010\u001a\u0004\u0018\u0001H\b\"\b\b\u0000\u0010\b*\u00020\u00062\u0006\u0010\u0011\u001a\u0002H\bH\u0000¢\u0006\u0002\u0010\u0012\u001a\u001b\u0010\u0013\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\n2\b\b\u0002\u0010\u0014\u001a\u00020\u0003H\u0082\u0010\u001a\u0018\u0010\u0015\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u0016\u001a\u00020\u0003H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000*(\b\u0002\u0010\u0017\"\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005¨\u0006\u0018"}, d2 = {"ctorCache", "Lkotlinx/coroutines/internal/CtorCache;", "throwableFields", "", "createConstructor", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/Ctor;", ExifInterface.LONGITUDE_EAST, "clz", "Ljava/lang/Class;", "createSafeConstructor", "constructor", "Ljava/lang/reflect/Constructor;", "safeCtor", "block", "tryCopyException", "exception", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "fieldsCount", "accumulator", "fieldsCountOrDefault", "defaultValue", "Ctor", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
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
        Object r3 = Result.m774constructorimpl(((CopyableThrowable) r2).createCopy());     // Catch: Throwable -> L6
    L9:
        if (Result.m780isFailureimpl(r3) == false) goto L12;
        r3 = null;
    L12:
        return (E) r3;
    L6:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r3 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L9
    L14:
        return (E) ctorCache.get(r2.getClass()).invoke(r2);
    }

    private static final <E extends Throwable> Function1<Throwable, Throwable> createConstructor(Class<E> r3) {
        ExceptionsConstructorKt$createConstructor$nullResult$1 r0 = ExceptionsConstructorKt$createConstructor$nullResult$1.INSTANCE;
        if (throwableFields == fieldsCountOrDefault(r3, 0)) goto L5;
        return r0;
    L5:
        Iterator r4 = ArraysKt.sortedWith(r3.getConstructors(), new ExceptionsConstructorKt$createConstructor$$inlined$sortedByDescending$1()).iterator();
    L7:
        if (r4.hasNext() == false) goto L11;
        Function1<Throwable, Throwable> r1 = createSafeConstructor((Constructor) r4.next());
        if (r1 == null) goto L7;
        return r1;
    L11:
        return r0;
    }

    private static final Function1<Throwable, Throwable> createSafeConstructor(final Constructor<?> r6) {
        Class<?>[] r0 = r6.getParameterTypes();
        int r1 = r0.length;
        if (r1 == 0) goto L21;
        if (r1 != 1) goto L7;
        Class<?> r2 = r0[0];
        if (Intrinsics.areEqual(r2, Throwable.class) == false) goto L18;
        return new ExceptionsConstructorKt$createSafeConstructor$$inlined$safeCtor$2(r6);
    L18:
        if (Intrinsics.areEqual(r2, String.class) == true) goto L27;
        return null;
    L27:
        return new ExceptionsConstructorKt$createSafeConstructor$$inlined$safeCtor$3(r6);
    L7:
        if (r1 == 2) goto L10;
        return null;
    L10:
        if (Intrinsics.areEqual(r0[0], String.class) == true) goto L12;
        return null;
    L12:
        if (Intrinsics.areEqual(r0[1], Throwable.class) == true) goto L24;
        return null;
    L24:
        return new ExceptionsConstructorKt$createSafeConstructor$$inlined$safeCtor$1(r6);
    L21:
        return new ExceptionsConstructorKt$createSafeConstructor$$inlined$safeCtor$4(r6);
    }

    private static final Function1<Throwable, Throwable> safeCtor(final Function1<? super Throwable, ? extends Throwable> r1) {
        return new AnonymousClass1(r1);
    }

    private static final int fieldsCountOrDefault(Class<?> r3, int r4) {
        JvmClassMappingKt.getKotlinClass(r3);
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r5 = Result.m774constructorimpl(Integer.valueOf(fieldsCount$default(r3, 0, 1, null)));     // Catch: Throwable -> L5
    L7:
        Integer r6 = Integer.valueOf(r4);
        if (Result.m780isFailureimpl(r5) == false) goto L11;
        r5 = r6;
    L11:
        return ((Number) r5).intValue();
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r5 = Result.m774constructorimpl(ResultKt.createFailure(th));
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
