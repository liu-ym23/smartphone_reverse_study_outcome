package kotlinx.coroutines.internal;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class AtomicDesc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AtomicOp f406a;

    public abstract void a(AtomicOp r1, Object r2);

    public abstract Object b(AtomicOp r1);
}
