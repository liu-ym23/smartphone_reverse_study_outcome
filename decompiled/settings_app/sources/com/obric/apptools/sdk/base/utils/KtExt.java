package com.obric.apptools.sdk.base.utils;

import androidx.exifinterface.media.ExifInterface;
import com.obric.apptools.sdk.base.log.L;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.math3.geometry.VectorFormat;

/* JADX INFO: compiled from: KtExt.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u001f\n\u0002\b\t\n\u0002\u0010\u001e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J9\u0010\u0003\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u000e\b\u0004\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00040\tH\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\nJI\u0010\u000b\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u001e\b\u0004\u0010\b\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\fH\u0086Hø\u0001\u0001¢\u0006\u0002\u0010\u000eJ%\u0010\u000f\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0004*\n\u0012\u0004\u0012\u0002H\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u0002H\u0004¢\u0006\u0002\u0010\u0013J\f\u0010\u0014\u001a\u00020\u0006*\u0004\u0018\u00010\u0001J\u0012\u0010\u0015\u001a\u00020\u0010*\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tJ+\u0010\u0015\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0004*\u0010\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u0010\u0018\u00010\f2\u0006\u0010\u0016\u001a\u0002H\u0004¢\u0006\u0002\u0010\u0017J\u001e\u0010\u0018\u001a\u0004\u0018\u0001H\u0004\"\u0006\b\u0000\u0010\u0004\u0018\u0001*\u0004\u0018\u00010\u0001H\u0086\b¢\u0006\u0002\u0010\u0019J,\u0010\u001a\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0004*\n\u0012\u0004\u0012\u0002H\u0004\u0018\u00010\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u00020\u00100\f\u0082\u0002\u000b\n\u0005\b\u009920\u0001\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lcom/obric/apptools/sdk/base/utils/KtExt;", "", "()V", "statTimeCost", ExifInterface.GPS_DIRECTION_TRUE, "tag", "", "signature", "block", "Lkotlin/Function0;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "statTimeCostSuspend", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addIfAbsent", "", "", "item", "(Ljava/util/Collection;Ljava/lang/Object;)V", "dumpStr", "invokeSafely", "t", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)V", "safeCastTo", "(Ljava/lang/Object;)Ljava/lang/Object;", "traverseSafely", "", "action", "tools_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class KtExt {
    public static final KtExt INSTANCE = null;

    /* JADX INFO: renamed from: com.obric.apptools.sdk.base.utils.KtExt$statTimeCostSuspend$1, reason: invalid class name */
    /* JADX INFO: compiled from: KtExt.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 176)
    @DebugMetadata(c = "com.obric.apptools.sdk.base.utils.KtExt", f = "KtExt.kt", i = {0, 0, 0}, l = {67}, m = "statTimeCostSuspend", n = {"tag", "signature", "start"}, s = {"L$0", "L$1", "J$0"})
    static final class AnonymousClass1<T> extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ KtExt this$0;

        AnonymousClass1(KtExt r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.statTimeCostSuspend(null, null, null, this);
        }
    }

    static {
        INSTANCE = new KtExt();
    }

    private KtExt() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ <T> T safeCastTo(Object r3) {
        if (r3 != 0) goto L5;
        return null;
    L5:
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        if ((r3 instanceof Object) == false) goto L9;
        return r3;
    L9:
        return null;
    }

    public final <T> void traverseSafely(Collection<? extends T> r2, Function1<? super T, Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "action");
        if (r2 != null) goto L5;
        return;
    L5:
        Iterator<? extends T> r1 = r2.iterator();
    L7:
        if (r1.hasNext() == false) goto L14;
        T r4 = r1.next();
        if (r4 == null) goto L7;
        r3.invoke(r4);     // Catch: Exception -> L12
    L12:
        e = move-exception;
        L.e("traverse action invoke error", e);
        goto L7
    }

    public final <T> void addIfAbsent(Collection<T> r1, T r2) {
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.contains(r2) == true) goto L8;
        r1.add(r2);
        return;
    }

    public static /* synthetic */ Object statTimeCost$default(KtExt r2, String r3, String r4, Function0 r5, int r6, Object r7) {
        if ((r6 & 1) == 0) goto L5;
        r3 = "";
    L5:
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "signature");
        Intrinsics.checkNotNullParameter(r5, "block");
        L.d(r3, r4 + " >>>");
        long r8 = System.currentTimeMillis();
        Object r9 = r5.invoke();
        L.d(r3, r4 + " <<< cost: " + (System.currentTimeMillis() - r8) + " ms");
        return r9;
    }

    public final <T> T statTimeCost(String r5, String r6, Function0<? extends T> r7) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        Intrinsics.checkNotNullParameter(r6, "signature");
        Intrinsics.checkNotNullParameter(r7, "block");
        L.d(r5, r6 + " >>>");
        long r0 = System.currentTimeMillis();
        T r4 = r7.invoke();
        L.d(r5, r6 + " <<< cost: " + (System.currentTimeMillis() - r0) + " ms");
        return r4;
    }

    public final <T> Object statTimeCostSuspend(String r6, String r7, Function1<? super Continuation<? super T>, ? extends Object> r8, Continuation<? super T> r9) {
        if ((r9 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r9;
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r5 = r0.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r0.label;
        if (r1 == 0) goto L14;
        if (r1 != 1) goto L13;
        long r11 = r0.J$0;
        String r12 = (String) r0.L$1;
        String r13 = (String) r0.L$0;
        ResultKt.throwOnFailure(r5);
        long r3 = r11;
        r7 = r12;
        r6 = r13;
    L17:
        L.d(r6, r7 + " <<< cost: " + (System.currentTimeMillis() - r3) + " ms");
        return r5;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r5);
        L.d(r6, r7 + " >>>");
        r3 = System.currentTimeMillis();
        r0.L$0 = r6;
        r0.L$1 = r7;
        r0.J$0 = r3;
        r0.label = 1;
        r5 = r8.invoke(r0);
        if (r5 != r10) goto L17;
        return r10;
    L7:
        r0 = new AnonymousClass1(this, r9);
        goto L8
    }

    private final <T> Object statTimeCostSuspend$$forInline(String r3, String r4, Function1<? super Continuation<? super T>, ? extends Object> r5, Continuation<? super T> r6) {
        L.d(r3, r4 + " >>>");
        long r0 = System.currentTimeMillis();
        Object r2 = r5.invoke(r6);
        L.d(r3, r4 + " <<< cost: " + (System.currentTimeMillis() - r0) + " ms");
        return r2;
    }

    public static /* synthetic */ Object statTimeCostSuspend$default(KtExt r2, String r3, String r4, Function1 r5, Continuation r6, int r7, Object r8) {
        if ((r7 & 1) == 0) goto L5;
        r3 = "";
    L5:
        L.d(r3, r4 + " >>>");
        long r9 = System.currentTimeMillis();
        InlineMarker.mark(0);
        Object r10 = r5.invoke(r6);
        InlineMarker.mark(1);
        L.d(r3, r4 + " <<< cost: " + (System.currentTimeMillis() - r9) + " ms");
        return r10;
    }

    public final String dumpStr(Object r11) {
        if ((r11 instanceof Collection) == false) goto L6;
        return CollectionsKt.joinToString$default((Iterable) r11, ", ", VectorFormat.DEFAULT_PREFIX, VectorFormat.DEFAULT_SUFFIX, 0, null, null, 56, null);
    L6:
        if ((r11 instanceof Object[]) == false) goto L9;
        return ArraysKt.joinToString$default((Object[]) r11, ", ", "[", "]", 0, null, null, 56, null);
    L9:
        return String.valueOf(r11);
    }

    public final void invokeSafely(Function0<Unit> r1) {
        if (r1 == null) goto L10;
        r1.invoke();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        L.e("invokeSafely, error", e);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> void invokeSafely(Function1<? super T, Unit> r1, T r2) {
        if (r1 == null) goto L10;
        r1.invoke(r2);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        L.e("invokeSafely, error", e);
        return;
    }
}
