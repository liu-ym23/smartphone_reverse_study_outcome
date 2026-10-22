package kotlin.coroutines;

import kotlin.Metadata;
import kotlin.SinceKotlin;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@Metadata
public interface Continuation<T> {
    CoroutineContext getContext();

    void k(Object r1);
}
