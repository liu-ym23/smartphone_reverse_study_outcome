package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentContainer {
    public FragmentContainer() {
    }

    @NonNull
    @Deprecated
    public Fragment instantiate(@NonNull Context r1, @NonNull String r2, @Nullable Bundle r3) {
        return Fragment.instantiate(r1, r2, r3);
    }

    @Nullable
    public abstract View onFindViewById(@IdRes int r1);

    public abstract boolean onHasView();
}
