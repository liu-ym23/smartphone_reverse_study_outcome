package okhttp3;

import java.io.IOException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public interface Callback {
    void onFailure(@NotNull Call r1, @NotNull IOException r2);

    void onResponse(@NotNull Call r1, @NotNull Response r2);
}
