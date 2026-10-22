package androidx.fragment.app;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: loaded from: classes.dex */
public interface FragmentResultOwner {
    void clearFragmentResult(@NonNull String r1);

    void clearFragmentResultListener(@NonNull String r1);

    void setFragmentResult(@NonNull String r1, @NonNull Bundle r2);

    void setFragmentResultListener(@NonNull String r1, @NonNull LifecycleOwner r2, @NonNull FragmentResultListener r3);
}
