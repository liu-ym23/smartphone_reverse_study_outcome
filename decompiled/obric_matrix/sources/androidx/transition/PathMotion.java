package androidx.transition;

import android.content.Context;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public abstract class PathMotion {
    public PathMotion() {
    }

    public PathMotion(@NonNull Context r1, @NonNull AttributeSet r2) {
    }

    @NonNull
    public abstract Path getPath(float r1, float r2, float r3, float r4);
}
