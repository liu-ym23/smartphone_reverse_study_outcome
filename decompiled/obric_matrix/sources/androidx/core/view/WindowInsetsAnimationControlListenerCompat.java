package androidx.core.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public interface WindowInsetsAnimationControlListenerCompat {
    void onCancelled(@Nullable WindowInsetsAnimationControllerCompat r1);

    void onFinished(@NonNull WindowInsetsAnimationControllerCompat r1);

    void onReady(@NonNull WindowInsetsAnimationControllerCompat r1, int r2);
}
