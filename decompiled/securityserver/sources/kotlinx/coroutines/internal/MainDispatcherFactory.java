package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes2.dex */
@InternalCoroutinesApi
@Metadata
public interface MainDispatcherFactory {

    @Metadata
    public static final class DefaultImpls {
    }

    MainCoroutineDispatcher a();
}
