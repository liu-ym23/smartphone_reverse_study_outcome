package androidx.transition;

import android.content.Context;
import android.graphics.Path;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class PathMotion {
    public abstract Path getPath(float r1, float r2, float r3, float r4);

    public PathMotion() {
    }

    public PathMotion(Context r1, AttributeSet r2) {
    }
}
