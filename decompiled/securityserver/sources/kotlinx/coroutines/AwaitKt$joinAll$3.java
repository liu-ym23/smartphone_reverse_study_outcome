package kotlinx.coroutines;

import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.AwaitKt", f = "Await.kt", l = {ConstraintLayout.LayoutParams.Table.GUIDELINE_USE_RTL}, m = "joinAll")
final class AwaitKt$joinAll$3 extends ContinuationImpl {
    public /* synthetic */ Object f;
    public int i;
    public Collection j;
    public Iterable k;
    public Iterator l;
    public Object m;
    public Job n;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object i(Object r7) {
        this.f = r7;
        int r0 = (this.i | Integer.MIN_VALUE) - Integer.MIN_VALUE;
        this.i = r0;
        CoroutineSingletons r1 = CoroutineSingletons.b;
        if (r0 != 0) goto L5;
        ResultKt.b(r7);
        throw null;
    L5:
        if (r0 != 1) goto L15;
        Iterator r2 = this.l;
        Iterable r3 = this.k;
        Collection r4 = this.j;
        ResultKt.b(r7);
    L8:
        if (r2.hasNext() == false) goto L13;
        Object r8 = r2.next();
        Job r5 = (Job) r8;
        this.j = r4;
        this.k = r3;
        this.l = r2;
        this.m = r8;
        this.n = r5;
        this.i = 1;
        if (r5.o(this) != r1) goto L8;
        return r1;
    L13:
        return Unit.f330a;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
