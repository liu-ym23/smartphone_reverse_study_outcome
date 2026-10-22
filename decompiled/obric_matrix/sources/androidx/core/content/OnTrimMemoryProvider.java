package androidx.core.content;

import androidx.annotation.NonNull;
import androidx.core.util.Consumer;

/* JADX INFO: loaded from: classes.dex */
public interface OnTrimMemoryProvider {
    void addOnTrimMemoryListener(@NonNull Consumer<Integer> r1);

    void removeOnTrimMemoryListener(@NonNull Consumer<Integer> r1);
}
