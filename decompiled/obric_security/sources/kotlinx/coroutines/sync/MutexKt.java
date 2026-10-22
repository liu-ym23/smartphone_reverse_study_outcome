package kotlinx.coroutines.sync;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.Symbol;

/* JADX INFO: compiled from: Mutex.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u001aB\u0010\u0013\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u0014*\u00020\u00102\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0018H\u0086Hø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\u0019\"\u0016\u0010\u0000\u001a\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00018\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\"\u0016\u0010\u0006\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003\"\u0016\u0010\t\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0003\"\u0016\u0010\u000b\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\u0003\"\u0016\u0010\r\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"EMPTY_LOCKED", "Lkotlinx/coroutines/sync/Empty;", "getEMPTY_LOCKED$annotations", "()V", "EMPTY_UNLOCKED", "getEMPTY_UNLOCKED$annotations", "LOCKED", "Lkotlinx/coroutines/internal/Symbol;", "getLOCKED$annotations", "LOCK_FAIL", "getLOCK_FAIL$annotations", "UNLOCKED", "getUNLOCKED$annotations", "UNLOCK_FAIL", "getUNLOCK_FAIL$annotations", "Mutex", "Lkotlinx/coroutines/sync/Mutex;", "locked", "", "withLock", ExifInterface.GPS_DIRECTION_TRUE, "owner", "", "action", "Lkotlin/Function0;", "(Lkotlinx/coroutines/sync/Mutex;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class MutexKt {
    private static final Empty EMPTY_LOCKED = null;
    private static final Empty EMPTY_UNLOCKED = null;
    private static final Symbol LOCKED = null;
    private static final Symbol LOCK_FAIL = null;
    private static final Symbol UNLOCKED = null;
    private static final Symbol UNLOCK_FAIL = null;

    /* JADX INFO: renamed from: kotlinx.coroutines.sync.MutexKt$withLock$1, reason: invalid class name */
    /* JADX INFO: compiled from: Mutex.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 176)
    @DebugMetadata(c = "kotlinx.coroutines.sync.MutexKt", f = "Mutex.kt", i = {0, 0, 0}, l = {112}, m = "withLock", n = {"$this$withLock", "owner", "action"}, s = {"L$0", "L$1", "L$2"})
    static final class AnonymousClass1<T> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> r1) {
            super(r1);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return MutexKt.withLock(null, null, null, this);
        }
    }

    public static final /* synthetic */ Empty access$getEMPTY_LOCKED$p() {
        return EMPTY_LOCKED;
    }

    public static final /* synthetic */ Empty access$getEMPTY_UNLOCKED$p() {
        return EMPTY_UNLOCKED;
    }

    public static final /* synthetic */ Symbol access$getLOCKED$p() {
        return LOCKED;
    }

    public static final /* synthetic */ Symbol access$getLOCK_FAIL$p() {
        return LOCK_FAIL;
    }

    public static final /* synthetic */ Symbol access$getUNLOCKED$p() {
        return UNLOCKED;
    }

    public static final /* synthetic */ Symbol access$getUNLOCK_FAIL$p() {
        return UNLOCK_FAIL;
    }

    private static /* synthetic */ void getEMPTY_LOCKED$annotations() {
    }

    private static /* synthetic */ void getEMPTY_UNLOCKED$annotations() {
    }

    private static /* synthetic */ void getLOCKED$annotations() {
    }

    private static /* synthetic */ void getLOCK_FAIL$annotations() {
    }

    private static /* synthetic */ void getUNLOCKED$annotations() {
    }

    private static /* synthetic */ void getUNLOCK_FAIL$annotations() {
    }

    public static /* synthetic */ Mutex Mutex$default(boolean r0, int r1, Object r2) {
        if ((r1 & 1) == 0) goto L6;
        r0 = false;
    L6:
        return Mutex(r0);
    }

    public static final Mutex Mutex(boolean r1) {
        return new MutexImpl(r1);
    }

    public static final <T> Object withLock(Mutex r4, Object r5, Function0<? extends T> r6, Continuation<? super T> r7) {
        if ((r7 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r7;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r6 = (Function0) r0.L$2;
        r5 = r0.L$1;
        r4 = (Mutex) r0.L$0;
        ResultKt.throwOnFailure(r8);
    L23:
        T r9 = r6.invoke();     // Catch: Throwable -> L20
        InlineMarker.finallyStart(1);
        r4.unlock(r5);
        InlineMarker.finallyEnd(1);
        return r9;
    L20:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r4.unlock(r5);
        InlineMarker.finallyEnd(1);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        r0.L$0 = r4;
        r0.L$1 = r5;
        r0.L$2 = r6;
        r0.label = 1;
        if (r4.lock(r5, r0) != r1) goto L23;
        return r1;
    L7:
        r0 = new AnonymousClass1(r7);
        goto L8
    }

    private static final <T> Object withLock$$forInline(Mutex r1, Object r2, Function0<? extends T> r3, Continuation<? super T> r4) {
        InlineMarker.mark(0);
        r1.lock(r2, r4);
        InlineMarker.mark(1);
        T r5 = r3.invoke();     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        r1.unlock(r2);
        InlineMarker.finallyEnd(1);
        return r5;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r1.unlock(r2);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    public static /* synthetic */ Object withLock$default(Mutex r0, Object r1, Function0 r2, Continuation r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L5;
        r1 = null;
    L5:
        InlineMarker.mark(0);
        r0.lock(r1, r3);
        InlineMarker.mark(1);
        Object r6 = r2.invoke();     // Catch: Throwable -> L9
        InlineMarker.finallyStart(1);
        r0.unlock(r1);
        InlineMarker.finallyEnd(1);
        return r6;
    L9:
        th = move-exception;
        InlineMarker.finallyStart(1);
        r0.unlock(r1);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    static {
        LOCK_FAIL = new Symbol("LOCK_FAIL");
        UNLOCK_FAIL = new Symbol("UNLOCK_FAIL");
        Symbol r0 = new Symbol("LOCKED");
        LOCKED = r0;
        Symbol r1 = new Symbol("UNLOCKED");
        UNLOCKED = r1;
        EMPTY_LOCKED = new Empty(r0);
        EMPTY_UNLOCKED = new Empty(r1);
    }
}
