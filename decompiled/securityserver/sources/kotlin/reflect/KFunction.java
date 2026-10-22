package kotlin.reflect;

import kotlin.Function;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface KFunction<R> extends KCallable<R>, Function<R> {

    @Metadata
    public static final class DefaultImpls {
    }

    @Override // kotlin.reflect.KCallable
    boolean isSuspend();
}
