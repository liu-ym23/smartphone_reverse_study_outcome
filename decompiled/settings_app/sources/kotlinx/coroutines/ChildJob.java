package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: Job.kt */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/ChildJob;", "Lkotlinx/coroutines/Job;", "parentCancelled", "", "parentJob", "Lkotlinx/coroutines/ParentJob;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ChildJob extends Job {

    /* JADX INFO: compiled from: Job.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
        public static /* synthetic */ void cancel(ChildJob r0) {
            Job.DefaultImpls.cancel(r0);
        }

        public static <R> R fold(ChildJob r0, R r1, Function2<? super R, ? super CoroutineContext.Element, ? extends R> r2) {
            return (R) Job.DefaultImpls.fold(r0, r1, r2);
        }

        public static <E extends CoroutineContext.Element> E get(ChildJob r0, CoroutineContext.Key<E> r1) {
            return (E) Job.DefaultImpls.get(r0, r1);
        }

        public static CoroutineContext minusKey(ChildJob r0, CoroutineContext.Key<?> r1) {
            return Job.DefaultImpls.minusKey(r0, r1);
        }

        public static CoroutineContext plus(ChildJob r0, CoroutineContext r1) {
            return Job.DefaultImpls.plus(r0, r1);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        public static Job plus(ChildJob r0, Job r1) {
            return Job.DefaultImpls.plus(r0, r1);
        }
    }

    void parentCancelled(ParentJob r1);
}
