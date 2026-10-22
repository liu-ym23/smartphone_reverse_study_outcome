package okhttp3;

import kotlin.Metadata;
import okio.Timeout;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface Call extends Cloneable {

    @Metadata
    public interface Factory {
        @NotNull
        Call newCall(@NotNull Request r1);
    }

    void cancel();

    @NotNull
    Call clone();

    void enqueue(@NotNull Callback r1);

    @NotNull
    Response execute();

    boolean isCanceled();

    boolean isExecuted();

    @NotNull
    Request request();

    @NotNull
    Timeout timeout();
}
