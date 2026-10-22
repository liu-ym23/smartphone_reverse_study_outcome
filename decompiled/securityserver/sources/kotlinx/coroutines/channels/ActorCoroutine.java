package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
class ActorCoroutine<E> extends ChannelCoroutine<E> implements ActorScope<E> {
    @Override // kotlinx.coroutines.JobSupport
    public final boolean d0(Throwable r1) {
        CoroutineExceptionHandlerKt.a(this.c, r1);
        return true;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // kotlinx.coroutines.JobSupport
    public final void m0(Throwable r3) {
        CancellationException r0 = null;
        Throwable r1 = null;
        if (r3 != null) goto L5;
    L12:
        this.f.a(r0);
        return;
    L5:
        if ((r3 instanceof CancellationException) == false) goto L8;
        r1 = r3;
    L8:
        r0 = (CancellationException) r1;
        if (r0 != null) goto L12;
        CancellationException r2 = new CancellationException(getClass().getSimpleName().concat(" was cancelled"));
        r2.initCause(r3);
        r0 = r2;
        goto L12
    }
}
