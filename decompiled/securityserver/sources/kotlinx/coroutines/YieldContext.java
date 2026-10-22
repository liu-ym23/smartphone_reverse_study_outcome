package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class YieldContext extends AbstractCoroutineContextElement {
    public static final Key e = null;
    public boolean c;

    @Metadata
    public static final class Key implements CoroutineContext.Key<YieldContext> {
    }

    static {
        e = new Key();
    }
}
