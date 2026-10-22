package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", l = {1882, 1885}, m = "maxBy")
public final class ChannelsKt__Channels_commonKt$maxBy$1 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public ReceiveChannel j;
    public Function1 k;
    public ReceiveChannel l;
    public Throwable m;
    public ReceiveChannel n;
    public ChannelIterator o;
    public Object p;
    public Comparable q;

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
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x007c -> B:25:0x0080). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r14) {
        this.f = r14;
        int r0 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r0;
        CoroutineSingletons r1 = CoroutineSingletons.b;
        ReceiveChannel r2 = null;
        Object r3 = null;
        if (r0 != 0) goto L5;
        ResultKt.b(r14);
        throw null;     // Catch: Throwable -> L34
    L5:
        if (r0 == 1) goto L14;
        if (r0 != 2) goto L13;
        Comparable r4 = this.q;
        r3 = this.p;
        ChannelIterator r5 = this.o;
        ReceiveChannel r6 = this.n;
        Throwable r7 = this.m;
        ReceiveChannel r8 = this.l;
        Function1 r9 = this.k;
        ReceiveChannel r10 = this.j;
        ResultKt.b(r14);     // Catch: Throwable -> L10
    L25:
        if (((Boolean) r14).booleanValue() == false) goto L32;
        Object r15 = r5.next();     // Catch: Throwable -> L10
        Comparable r11 = (Comparable) r9.invoke(r15);     // Catch: Throwable -> L10
        if (r4.compareTo(r11) >= 0) goto L30;
        r4 = r11;
    L31:
        ReceiveChannel r12 = r8;
    L21:
        this.j = r10;     // Catch: Throwable -> L34
        this.k = r9;     // Catch: Throwable -> L34
        this.l = r12;     // Catch: Throwable -> L34
        this.m = r7;     // Catch: Throwable -> L34
        this.n = r6;     // Catch: Throwable -> L34
        this.o = r5;     // Catch: Throwable -> L34
        this.p = r15;     // Catch: Throwable -> L34
        this.q = r4;     // Catch: Throwable -> L34
        this.i = 2;     // Catch: Throwable -> L34
        Object r13 = r5.a(this);     // Catch: Throwable -> L34
        if (r13 == r1) goto L51;
        ReceiveChannel r16 = r12;
        r3 = r15;
        r14 = r13;
        r8 = r16;
        goto L25
    L51:
        return r1;
    L30:
        r15 = r3;
        goto L31
    L32:
        ChannelsKt.a(r8, r7);
    L33:
        return r3;
    L10:
        th = th;
        r2 = r8;
    L49:
        throw th;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        ChannelsKt.a(r2, th);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ChannelIterator r17 = this.o;
        ReceiveChannel r18 = this.n;
        Throwable r19 = this.m;
        ReceiveChannel r20 = this.l;
        Function1 r21 = this.k;
        ReceiveChannel r22 = this.j;
        ResultKt.b(r14);     // Catch: Throwable -> L36
        if (((Boolean) r14).booleanValue() == true) goto L19;
        ChannelsKt.a(r20, r19);
        goto L33
    L19:
        r15 = r17.next();     // Catch: Throwable -> L36
        r10 = r22;
        r9 = r21;
        r5 = r17;
        r4 = (Comparable) r21.invoke(r15);     // Catch: Throwable -> L36
        r12 = r20;
        r7 = r19;
        r6 = r18;
    L36:
        th = th;
        r2 = r20;
    L34:
        th = th;
        goto L49
    }
}
