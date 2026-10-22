package com.android.settings.intent;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: DeviceStateIntent.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JV\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u0002H\u00050\u0004j\b\u0012\u0004\u0012\u0002H\u0005`\u0006\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0007\u001a\u00020\b2(\u0010\t\u001a$\b\u0001\u0012\u0004\u0012\u00020\u000b\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u00010\nH\u0087@¢\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0007J\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0014\"\u0004\b\u0000\u0010\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00050\rH\u0007¨\u0006\u0016"}, d2 = {"Lcom/android/settings/intent/DeviceStateIntentBluetoothFields;", "", "()V", "awaitProfileResultsConcurrently", "Ljava/util/LinkedHashSet;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/collections/LinkedHashSet;", "profiles", "", "loader", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "", "([ILkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldAddBondedBluetoothDevice", "", "alreadyDiscovered", "aclConnected", "snapshotDevices", "", "devices", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DeviceStateIntentBluetoothFields {
    public static final DeviceStateIntentBluetoothFields INSTANCE = null;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.android.settings.intent.DeviceStateIntentBluetoothFields$awaitProfileResultsConcurrently$2, reason: invalid class name */
    /* JADX INFO: compiled from: DeviceStateIntent.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u0002H\u00020\u0001j\b\u0012\u0004\u0012\u0002H\u0002`\u0003\"\u0004\b\u0000\u0010\u0002*\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "Ljava/util/LinkedHashSet;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/collections/LinkedHashSet;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.android.settings.intent.DeviceStateIntentBluetoothFields$awaitProfileResultsConcurrently$2", f = "DeviceStateIntent.kt", i = {}, l = {920}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super LinkedHashSet<T>>, Object> {
        final /* synthetic */ Function2<Integer, Continuation<? super Collection<? extends T>>, Object> $loader;
        final /* synthetic */ int[] $profiles;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(int[] r1, Function2<? super Integer, ? super Continuation<? super Collection<? extends T>>, ? extends Object> r2, Continuation<? super AnonymousClass2> r3) {
            this.$profiles = r1;
            this.$loader = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass2 r0 = new AnonymousClass2(this.$profiles, this.$loader, r4);
            r0.L$0 = r3;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Object r2) {
            return invoke(r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super LinkedHashSet<T>> r2) {
            return ((AnonymousClass2) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r14);
        L15:
            return CollectionsKt.toCollection(CollectionsKt.flatten((Iterable) r14), new LinkedHashSet());
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r14);
            CoroutineScope r15 = (CoroutineScope) this.L$0;
            int[] r2 = this.$profiles;
            Function2<Integer, Continuation<? super Collection<? extends T>>, Object> r9 = this.$loader;
            ArrayList r10 = new ArrayList(r2.length);
            int r11 = r2.length;
            int r12 = 0;
        L9:
            if (r12 >= r11) goto L11;
            r10.add(BuildersKt.async$default(r15, null, null, new DeviceStateIntentBluetoothFields$awaitProfileResultsConcurrently$2$1$1(r9, r2[r12], null), 3, null));
            r12 = r12 + 1;
            goto L9
        L11:
            this.label = 1;
            r14 = AwaitKt.awaitAll(r10, this);
            if (r14 != r0) goto L15;
            return r0;
        }
    }

    static {
        INSTANCE = new DeviceStateIntentBluetoothFields();
    }

    @JvmStatic
    public static final boolean shouldAddBondedBluetoothDevice(boolean r0, boolean r1) {
        if (r0 == true) goto L5;
        if (r1 == false) goto L5;
        return true;
    L5:
        return false;
    }

    private DeviceStateIntentBluetoothFields() {
    }

    @JvmStatic
    public static final <T> List<T> snapshotDevices(Collection<? extends T> r1) {
        Intrinsics.checkNotNullParameter(r1, "devices");
        return CollectionsKt.toList(r1);
    }

    @JvmStatic
    public static final <T> Object awaitProfileResultsConcurrently(int[] r2, Function2<? super Integer, ? super Continuation<? super Collection<? extends T>>, ? extends Object> r3, Continuation<? super LinkedHashSet<T>> r4) {
        return CoroutineScopeKt.coroutineScope(new AnonymousClass2(r2, r3, null), r4);
    }
}
