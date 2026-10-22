package kotlin.sequences;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.RestrictsSuspension;

/* JADX INFO: loaded from: classes2.dex */
@SinceKotlin
@RestrictsSuspension
@Metadata
public abstract class SequenceScope<T> {
    public abstract void a(Object r1, Continuation r2);
}
