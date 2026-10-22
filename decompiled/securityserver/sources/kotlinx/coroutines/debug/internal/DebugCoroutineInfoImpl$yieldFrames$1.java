package kotlinx.coroutines.debug.internal;

import com.bytedance.apm6.hub.config.SlardarHandlerConfigManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import kotlin.sequences.SequenceScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl", f = "DebugCoroutineInfoImpl.kt", l = {SlardarHandlerConfigManager.DEFAULT_MAX_DB_SIZE_MB}, m = "yieldFrames")
final class DebugCoroutineInfoImpl$yieldFrames$1 extends RestrictedContinuationImpl {
    public /* synthetic */ Object c;
    public int e;
    public final /* synthetic */ DebugCoroutineInfoImpl f;
    public DebugCoroutineInfoImpl i;
    public SequenceScope j;
    public CoroutineStackFrame k;

    public DebugCoroutineInfoImpl$yieldFrames$1(DebugCoroutineInfoImpl r1, Continuation r2) {
        this.f = r1;
        super(r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r2) {
        this.c = r2;
        this.e |= Integer.MIN_VALUE;
        return this.f.a(null, this);
    }
}
