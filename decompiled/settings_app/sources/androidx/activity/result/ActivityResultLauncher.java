package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContract;
import androidx.core.app.ActivityOptionsCompat;

/* JADX INFO: loaded from: classes.dex */
public abstract class ActivityResultLauncher<I> {
    public abstract ActivityResultContract<I, ?> getContract();

    public abstract void launch(I r1, ActivityOptionsCompat r2);

    public abstract void unregister();

    public ActivityResultLauncher() {
    }

    public void launch(I r2) {
        launch(r2, null);
    }
}
