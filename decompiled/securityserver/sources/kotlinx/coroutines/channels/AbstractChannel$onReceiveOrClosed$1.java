package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectInstance;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class AbstractChannel$onReceiveOrClosed$1 implements SelectClause1<ValueOrClosed<Object>> {
    @Override // kotlinx.coroutines.selects.SelectClause1
    public final void h(SelectInstance r2, Function2 r3) {
        AbstractChannel.p(2, r3, null, r2);
        throw null;
    }
}
