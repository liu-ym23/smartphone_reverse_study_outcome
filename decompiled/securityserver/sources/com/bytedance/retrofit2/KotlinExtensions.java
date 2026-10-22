package com.bytedance.retrofit2;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
@Metadata
@JvmName
public final class KotlinExtensions {
    @Nullable
    public static final <T> Object await(@NotNull final Call<T> r2, @NotNull Continuation<? super T> r3) {
        final CancellableContinuationImpl r0 = new CancellableContinuationImpl(1, IntrinsicsKt.b(r3));
        r0.D();
        r0.u(new KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$1(r2));
        r2.enqueue(new KotlinExtensions$await$2$2(r0));
        return r0.s();
    }

    @JvmName
    @Nullable
    public static final <T> Object awaitNullable(@NotNull final Call<T> r2, @NotNull Continuation<? super T> r3) {
        final CancellableContinuationImpl r0 = new CancellableContinuationImpl(1, IntrinsicsKt.b(r3));
        r0.D();
        r0.u(new KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2(r2));
        r2.enqueue(new KotlinExtensions$await$4$2(r0));
        return r0.s();
    }

    @Nullable
    public static final <T> Object awaitResponse(@NotNull final Call<T> r2, @NotNull Continuation<? super SsResponse<T>> r3) {
        final CancellableContinuationImpl r0 = new CancellableContinuationImpl(1, IntrinsicsKt.b(r3));
        r0.D();
        r0.u(new KotlinExtensions$awaitResponse$$inlined$suspendCancellableCoroutine$lambda$1(r2));
        r2.enqueue(new KotlinExtensions$awaitResponse$2$2(r0));
        return r0.s();
    }

    public static final <T> T create(@NotNull Retrofit r1) {
        Intrinsics.f(r1, "$this$create");
        Intrinsics.l();
        throw null;
    }

    @Nullable
    public static final Object suspendAndThrow(@NotNull final Exception r3, @NotNull final Continuation<?> r4) {
        Dispatchers.f372a.j(r4.getContext(), new KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1(r4, r3));
        return CoroutineSingletons.b;
    }
}
