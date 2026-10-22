package androidx.activity.result;

import android.annotation.SuppressLint;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityOptionsCompat;

/* JADX INFO: loaded from: classes.dex */
public abstract class ActivityResultLauncher<I> {
    public ActivityResultLauncher() {
    }

    @NonNull
    public abstract ActivityResultContract<I, ?> getContract();

    public void launch(@SuppressLint({"UnknownNullness"}) I r2) {
        launch(r2, null);
    }

    public abstract void launch(@SuppressLint({"UnknownNullness"}) I r1, @Nullable ActivityOptionsCompat r2);

    @MainThread
    public abstract void unregister();
}
