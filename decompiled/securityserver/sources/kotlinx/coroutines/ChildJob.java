package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
@InternalCoroutinesApi
@Metadata
public interface ChildJob extends Job {

    @Metadata
    public static final class DefaultImpls {
    }

    void t(ParentJob r1);
}
