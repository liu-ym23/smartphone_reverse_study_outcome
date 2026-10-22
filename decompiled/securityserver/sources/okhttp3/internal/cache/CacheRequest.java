package okhttp3.internal.cache;

import kotlin.Metadata;
import okio.Sink;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface CacheRequest {
    void abort();

    @NotNull
    Sink body();
}
