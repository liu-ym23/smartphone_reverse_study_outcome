package androidx.core.view;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: loaded from: classes.dex */
public interface MenuHost {
    void addMenuProvider(@NonNull MenuProvider r1);

    void addMenuProvider(@NonNull MenuProvider r1, @NonNull LifecycleOwner r2);

    @SuppressLint({"LambdaLast"})
    void addMenuProvider(@NonNull MenuProvider r1, @NonNull LifecycleOwner r2, @NonNull Lifecycle.State r3);

    void invalidateMenu();

    void removeMenuProvider(@NonNull MenuProvider r1);
}
