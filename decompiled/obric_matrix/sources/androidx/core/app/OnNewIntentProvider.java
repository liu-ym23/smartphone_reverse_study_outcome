package androidx.core.app;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.core.util.Consumer;

/* JADX INFO: loaded from: classes.dex */
public interface OnNewIntentProvider {
    void addOnNewIntentListener(@NonNull Consumer<Intent> r1);

    void removeOnNewIntentListener(@NonNull Consumer<Intent> r1);
}
