package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatRatingBar extends RatingBar {
    private final AppCompatProgressBarHelper mAppCompatProgressBarHelper;

    public AppCompatRatingBar(@NonNull Context r2) {
        this(r2, null);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int r2, int r3) {
        monitor-enter(this);
        super.onMeasure(r2, r3);     // Catch: Throwable -> L7
        Bitmap r4 = this.mAppCompatProgressBarHelper.getSampleTile();     // Catch: Throwable -> L7
        if (r4 == null) goto L9;
        setMeasuredDimension(View.resolveSizeAndState(r4.getWidth() * getNumStars(), r2, 0), getMeasuredHeight());     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public AppCompatRatingBar(@NonNull Context r2, @Nullable AttributeSet r3) {
        this(r2, r3, R.attr.ratingBarStyle);
    }

    public AppCompatRatingBar(@NonNull Context r1, @Nullable AttributeSet r2, int r3) {
        super(r1, r2, r3);
        ThemeUtils.checkAppCompatTheme(this, getContext());
        AppCompatProgressBarHelper r4 = new AppCompatProgressBarHelper(this);
        this.mAppCompatProgressBarHelper = r4;
        r4.loadFromAttributes(r2, r3);
    }
}
