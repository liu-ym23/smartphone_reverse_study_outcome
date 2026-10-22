package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CopyableThrowable;
import kotlinx.coroutines.DebugKt;

/* JADX INFO: compiled from: StackTraceRecovery.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u001a\u0014\u0010\u0006\u001a\u00060\u0007j\u0002`\b2\u0006\u0010\t\u001a\u00020\u0001H\u0007\u001a9\u0010\n\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f2\u0006\u0010\r\u001a\u0002H\u000b2\u0006\u0010\u000e\u001a\u0002H\u000b2\u0010\u0010\u000f\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u0010H\u0002¢\u0006\u0002\u0010\u0011\u001a\u001e\u0010\u0012\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u00102\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0002\u001a1\u0010\u0016\u001a\u00020\u00172\u0010\u0010\u0018\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u00192\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u0010H\u0002¢\u0006\u0002\u0010\u001a\u001a\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\fH\u0080Hø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001a+\u0010\u001f\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f2\u0006\u0010\u001d\u001a\u0002H\u000b2\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0002¢\u0006\u0002\u0010 \u001a\u001f\u0010!\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f2\u0006\u0010\u001d\u001a\u0002H\u000bH\u0000¢\u0006\u0002\u0010\"\u001a,\u0010!\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f2\u0006\u0010\u001d\u001a\u0002H\u000b2\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030#H\u0080\b¢\u0006\u0002\u0010$\u001a!\u0010%\u001a\u0004\u0018\u0001H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f2\u0006\u0010\u001d\u001a\u0002H\u000bH\u0002¢\u0006\u0002\u0010\"\u001a \u0010&\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f2\u0006\u0010\u001d\u001a\u0002H\u000bH\u0080\b¢\u0006\u0002\u0010\"\u001a\u001f\u0010'\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f2\u0006\u0010\u001d\u001a\u0002H\u000bH\u0000¢\u0006\u0002\u0010\"\u001a1\u0010(\u001a\u0018\u0012\u0004\u0012\u0002H\u000b\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u00190)\"\b\b\u0000\u0010\u000b*\u00020\f*\u0002H\u000bH\u0002¢\u0006\u0002\u0010*\u001a\u001c\u0010+\u001a\u00020,*\u00060\u0007j\u0002`\b2\n\u0010-\u001a\u00060\u0007j\u0002`\bH\u0002\u001a#\u0010.\u001a\u00020/*\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u00192\u0006\u00100\u001a\u00020\u0001H\u0002¢\u0006\u0002\u00101\u001a\u0014\u00102\u001a\u00020\u0017*\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0000\u001a\u0010\u00103\u001a\u00020,*\u00060\u0007j\u0002`\bH\u0000\u001a\u001b\u00104\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f*\u0002H\u000bH\u0002¢\u0006\u0002\u0010\"\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\n \u0003*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0005\u001a\n \u0003*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000*\f\b\u0000\u00105\"\u00020\u00142\u00020\u0014*\f\b\u0000\u00106\"\u00020\u00072\u00020\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u00067"}, d2 = {"baseContinuationImplClass", "", "baseContinuationImplClassName", "kotlin.jvm.PlatformType", "stackTraceRecoveryClass", "stackTraceRecoveryClassName", "artificialFrame", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "message", "createFinalException", ExifInterface.LONGITUDE_EAST, "", "cause", "result", "resultStackTrace", "Ljava/util/ArrayDeque;", "(Ljava/lang/Throwable;Ljava/lang/Throwable;Ljava/util/ArrayDeque;)Ljava/lang/Throwable;", "createStackTrace", "continuation", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "mergeRecoveredTraces", "", "recoveredStacktrace", "", "([Ljava/lang/StackTraceElement;Ljava/util/ArrayDeque;)V", "recoverAndThrow", "", "exception", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recoverFromStackFrame", "(Ljava/lang/Throwable;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Ljava/lang/Throwable;", "recoverStackTrace", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Throwable;", "tryCopyAndVerify", "unwrap", "unwrapImpl", "causeAndStacktrace", "Lkotlin/Pair;", "(Ljava/lang/Throwable;)Lkotlin/Pair;", "elementWiseEquals", "", "e", "frameIndex", "", "methodName", "([Ljava/lang/StackTraceElement;Ljava/lang/String;)I", "initCause", "isArtificial", "sanitizeStackTrace", "CoroutineStackFrame", "StackTraceElement", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class StackTraceRecoveryKt {
    private static final String baseContinuationImplClass = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
    private static final String baseContinuationImplClassName = null;
    private static final String stackTraceRecoveryClass = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
    private static final String stackTraceRecoveryClassName = null;

    public static /* synthetic */ void CoroutineStackFrame$annotations() {
    }

    public static /* synthetic */ void StackTraceElement$annotations() {
    }

    public static final /* synthetic */ Throwable access$recoverFromStackFrame(Throwable r0, CoroutineStackFrame r1) {
        return recoverFromStackFrame(r0, r1);
    }

    static {
        Object r0 = stackTraceRecoveryClass;
        Object r1 = baseContinuationImplClass;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L5
        Object r3 = Result.m774constructorimpl(Class.forName(baseContinuationImplClass).getCanonicalName());     // Catch: Throwable -> L5
    L8:
        if (Result.m777exceptionOrNullimpl(r3) != null) goto L10;
        r1 = r3;
    L10:
        baseContinuationImplClassName = (String) r1;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L13
        Object r5 = Result.m774constructorimpl(Class.forName(stackTraceRecoveryClass).getCanonicalName());     // Catch: Throwable -> L13
    L16:
        if (Result.m777exceptionOrNullimpl(r5) != null) goto L18;
        r0 = r5;
    L18:
        stackTraceRecoveryClassName = (String) r0;
        return;
    L13:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.m774constructorimpl(ResultKt.createFailure(th));
    L5:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r3 = Result.m774constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static final <E extends Throwable> E recoverStackTrace(E r1) {
        if (DebugKt.getRECOVER_STACK_TRACES() == true) goto L5;
        return r1;
    L5:
        Throwable r0 = tryCopyAndVerify(r1);
        if (r0 != null) goto L9;
        return r1;
    L9:
        return (E) sanitizeStackTrace(r0);
    }

    private static final <E extends Throwable> E sanitizeStackTrace(E r7) {
        StackTraceElement[] r0 = r7.getStackTrace();
        int r1 = r0.length;
        int r2 = frameIndex(r0, stackTraceRecoveryClassName);
        int r3 = r2 + 1;
        int r4 = frameIndex(r0, baseContinuationImplClassName);
        int r6 = 0;
        if (r4 != (-1)) goto L5;
        int r5 = 0;
    L6:
        int r8 = (r1 - r2) - r5;
        StackTraceElement[] r9 = new StackTraceElement[r8];
    L7:
        if (r6 >= r8) goto L12;
        if (r6 != 0) goto L10;
        StackTraceElement r10 = artificialFrame("Coroutine boundary");
    L11:
        r9[r6] = r10;
        r6 = r6 + 1;
        goto L7
    L10:
        r10 = r0[(r3 + r6) - 1];
        goto L11
    L12:
        r7.setStackTrace(r9);
        return r7;
    L5:
        r5 = r1 - r4;
        goto L6
    }

    public static final <E extends Throwable> E recoverStackTrace(E r1, Continuation<?> r2) {
        if (DebugKt.getRECOVER_STACK_TRACES() == true) goto L5;
        return r1;
    L5:
        if ((r2 instanceof CoroutineStackFrame) == true) goto L8;
        return r1;
    L8:
        return (E) access$recoverFromStackFrame(r1, (CoroutineStackFrame) r2);
    }

    private static final <E extends Throwable> E recoverFromStackFrame(E r4, CoroutineStackFrame r5) {
        Pair r0 = causeAndStacktrace(r4);
        Throwable r1 = (Throwable) r0.component1();
        StackTraceElement[] r2 = (StackTraceElement[]) r0.component2();
        Throwable r3 = tryCopyAndVerify(r1);
        if (r3 != null) goto L5;
        return r4;
    L5:
        ArrayDeque<StackTraceElement> r6 = createStackTrace(r5);
        if (r6.isEmpty() == false) goto L8;
        return r4;
    L8:
        if (r1 == r4) goto L11;
        mergeRecoveredTraces(r2, r6);
    L11:
        return (E) createFinalException(r1, r3, r6);
    }

    private static final <E extends Throwable> E tryCopyAndVerify(E r3) {
        E r0 = (E) ExceptionsConstructorKt.tryCopyException(r3);
        if (r0 != null) goto L6;
        return null;
    L6:
        if ((r3 instanceof CopyableThrowable) == false) goto L8;
    L10:
        return r0;
    L8:
        if (Intrinsics.areEqual(r0.getMessage(), r3.getMessage()) == true) goto L10;
        return null;
    }

    private static final <E extends Throwable> E createFinalException(E r5, E r6, ArrayDeque<StackTraceElement> r7) {
        r7.addFirst(artificialFrame("Coroutine boundary"));
        StackTraceElement[] r8 = r5.getStackTrace();
        int r0 = frameIndex(r8, baseContinuationImplClassName);
        int r2 = 0;
        if (r0 != (-1)) goto L10;
        Object[] r9 = r7.toArray(new StackTraceElement[0]);
        if (r9 == null) goto L9;
        r6.setStackTrace((StackTraceElement[]) r9);
        return r6;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    L10:
        StackTraceElement[] r1 = new StackTraceElement[r7.size() + r0];
        int r3 = 0;
    L11:
        if (r3 >= r0) goto L13;
        r1[r3] = r8[r3];
        r3 = r3 + 1;
        goto L11
    L13:
        Iterator<StackTraceElement> r10 = r7.iterator();
    L15:
        if (r10.hasNext() == false) goto L17;
        int r11 = r2 + 1;
        r1[r2 + r0] = r10.next();
        r2 = r11;
        goto L15
    L17:
        r6.setStackTrace(r1);
        return r6;
    }

    private static final <E extends Throwable> Pair<E, StackTraceElement[]> causeAndStacktrace(E r6) {
        Throwable r0 = r6.getCause();
        if (r0 == null) goto L17;
        if (Intrinsics.areEqual(r0.getClass(), r6.getClass()) == false) goto L17;
        StackTraceElement[] r2 = r6.getStackTrace();
        int r3 = r2.length;
        int r4 = 0;
    L7:
        if (r4 >= r3) goto L12;
        if (isArtificial(r2[r4]) == true) goto L10;
        r4 = r4 + 1;
        goto L7
    L10:
        boolean r5 = true;
    L13:
        if (r5 == false) goto L21;
        return TuplesKt.to(r0, r2);
    L21:
        return TuplesKt.to(r6, new StackTraceElement[0]);
    L12:
        r5 = false;
    L17:
        return TuplesKt.to(r6, new StackTraceElement[0]);
    }

    public static final Object recoverAndThrow(Throwable r1, Continuation<?> r2) {
        if (DebugKt.getRECOVER_STACK_TRACES() == true) goto L5;
        throw r1;
    L5:
        if ((r2 instanceof CoroutineStackFrame) == true) goto L8;
        throw r1;
    L8:
        throw access$recoverFromStackFrame(r1, (CoroutineStackFrame) r2);
    }

    private static final Object recoverAndThrow$$forInline(Throwable r1, Continuation<?> r2) {
        if (DebugKt.getRECOVER_STACK_TRACES() == false) goto L9;
        InlineMarker.mark(0);
        if ((r2 instanceof CoroutineStackFrame) == true) goto L8;
        throw r1;
    L8:
        throw access$recoverFromStackFrame(r1, (CoroutineStackFrame) r2);
    L9:
        throw r1;
    }

    public static final <E extends Throwable> E unwrap(E r1) {
        if (DebugKt.getRECOVER_STACK_TRACES() == true) goto L6;
        return r1;
    L6:
        return (E) unwrapImpl(r1);
    }

    public static final <E extends Throwable> E unwrapImpl(E r6) {
        E r0 = (E) r6.getCause();
        if (r0 != null) goto L5;
    L15:
        return r6;
    L5:
        if (Intrinsics.areEqual(r0.getClass(), r6.getClass()) == false) goto L15;
        StackTraceElement[] r1 = r6.getStackTrace();
        int r2 = r1.length;
        boolean r3 = false;
        int r4 = 0;
    L8:
        if (r4 >= r2) goto L13;
        if (isArtificial(r1[r4]) == true) goto L11;
        r4 = r4 + 1;
        goto L8
    L11:
        r3 = true;
    L13:
        if (r3 == false) goto L15;
        return r0;
    }

    private static final ArrayDeque<StackTraceElement> createStackTrace(CoroutineStackFrame r2) {
        ArrayDeque<StackTraceElement> r0 = new ArrayDeque();
        StackTraceElement r1 = r2.getStackTraceElement();
        if (r1 == null) goto L6;
        r0.add(r1);
    L6:
        if ((r2 instanceof CoroutineStackFrame) == true) goto L9;
        r2 = null;
    L9:
        if (r2 == null) goto L16;
        r2 = r2.getCallerFrame();
        if (r2 == null) goto L16;
        StackTraceElement r3 = r2.getStackTraceElement();
        if (r3 == null) goto L6;
        r0.add(r3);
    L16:
        return r0;
    }

    public static final StackTraceElement artificialFrame(String r3) {
        return new StackTraceElement("\b\b\b(" + r3, "\b", "\b", -1);
    }

    public static final boolean isArtificial(StackTraceElement r4) {
        return StringsKt.startsWith$default(r4.getClassName(), "\b\b\b", false, 2, null);
    }

    private static final boolean elementWiseEquals(StackTraceElement r2, StackTraceElement r3) {
        if (r2.getLineNumber() == r3.getLineNumber()) goto L5;
    L11:
        return false;
    L5:
        if (Intrinsics.areEqual(r2.getMethodName(), r3.getMethodName()) == false) goto L11;
        if (Intrinsics.areEqual(r2.getFileName(), r3.getFileName()) == false) goto L11;
        if (Intrinsics.areEqual(r2.getClassName(), r3.getClassName()) == false) goto L11;
        return true;
    }

    public static final void initCause(Throwable r0, Throwable r1) {
        r0.initCause(r1);
    }

    private static final void mergeRecoveredTraces(StackTraceElement[] r4, ArrayDeque<StackTraceElement> r5) {
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (isArtificial(r4[r1]) == true) goto L9;
        r1 = r1 + 1;
    L9:
        int r2 = r1 + 1;
        int r3 = r4.length - 1;
        if (r2 <= r3) goto L12;
        return;
    L12:
        if (elementWiseEquals(r4[r3], r5.getLast()) == false) goto L14;
        r5.removeLast();
    L14:
        r5.addFirst(r4[r3]);
        if (r3 == r2) goto L21;
        r3 = r3 - 1;
        goto L12
    L21:
        return;
    L8:
        r1 = -1;
        goto L9
    }

    private static final int frameIndex(StackTraceElement[] r3, String r4) {
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        if (Intrinsics.areEqual(r4, r3[r1].getClassName()) == true) goto L12;
        r1 = r1 + 1;
        goto L3
    L12:
        return r1;
    L8:
        return -1;
    }
}
