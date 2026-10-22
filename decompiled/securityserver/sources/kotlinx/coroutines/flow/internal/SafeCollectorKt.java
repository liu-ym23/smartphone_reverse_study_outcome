package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SafeCollectorKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Function3 f404a = null;

    static {
        SafeCollectorKt$emitFun$1 r6 = new SafeCollectorKt$emitFun$1(3, FlowCollector.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        TypeIntrinsics.b(3, r6);
        f404a = r6;
    }
}
