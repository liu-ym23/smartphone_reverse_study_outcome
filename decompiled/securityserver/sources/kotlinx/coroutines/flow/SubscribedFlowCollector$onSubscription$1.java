package kotlinx.coroutines.flow;

import com.bytedance.frameworks.baselib.network.http.util.HttpStatus;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.SubscribedFlowCollector", f = "Share.kt", l = {HttpStatus.SC_PROXY_AUTHENTICATION_REQUIRED, 411}, m = "onSubscription")
final class SubscribedFlowCollector$onSubscription$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public final /* synthetic */ SubscribedFlowCollector j;

    public SubscribedFlowCollector$onSubscription$1(SubscribedFlowCollector r1, Continuation r2) {
        this.j = r1;
        super(r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r2) {
        this.f = r2;
        this.i |= Integer.MIN_VALUE;
        return this.j.a(this);
    }
}
