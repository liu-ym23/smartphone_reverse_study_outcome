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

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int r2, int r3) {
        monitor-enter(this);
        super.onMeasure(r2, r3);     // Catch: Throwable -> L8
        Bitmap r4 = this.mAppCompatProgressBarHelper.getSampleTile();     // Catch: Throwable -> L8
        if (r4 == null) goto L6;
        setMeasuredDimension(View.resolveSizeAndState(r4.getWidth() * getNumStars(), r2, 0), getMeasuredHeight());     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }
}
