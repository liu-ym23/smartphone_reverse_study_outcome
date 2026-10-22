package d.c.g.a.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.IntRange;

/* JADX INFO: loaded from: classes.dex */
public interface a extends d {
    int c();

    void clear();

    void d(Rect r1);

    int e();

    boolean f(int r1);

    void h(ColorFilter r1);

    void j(@IntRange(from = 0, to = 255) int r1);

    boolean k(Drawable r1, Canvas r2, int r3);
}
