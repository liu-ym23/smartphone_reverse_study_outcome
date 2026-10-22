package androidx.viewpager.widget;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public abstract class PagerAdapter {
    public static final int POSITION_NONE = -2;
    public static final int POSITION_UNCHANGED = -1;
    private final DataSetObservable mObservable;
    private DataSetObserver mViewPagerObserver;

    public PagerAdapter() {
        this.mObservable = new DataSetObservable();
    }

    public void destroyItem(@NonNull ViewGroup r1, int r2, @NonNull Object r3) {
        destroyItem(r1, r2, r3);
    }

    @Deprecated
    public void finishUpdate(@NonNull View r1) {
    }

    public abstract int getCount();

    public int getItemPosition(@NonNull Object r1) {
        return -1;
    }

    @Nullable
    public CharSequence getPageTitle(int r1) {
        return null;
    }

    public float getPageWidth(int r1) {
        return 1.0f;
    }

    @NonNull
    public Object instantiateItem(@NonNull ViewGroup r1, int r2) {
        return instantiateItem(r1, r2);
    }

    public abstract boolean isViewFromObject(@NonNull View r1, @NonNull Object r2);

    public void notifyDataSetChanged() {
        monitor-enter(this);
        DataSetObserver r0 = this.mViewPagerObserver;     // Catch: Throwable -> L6
        if (r0 == null) goto L8;
        r0.onChanged();     // Catch: Throwable -> L6
    L8:
        monitor-exit(this);     // Catch: Throwable -> L6
        this.mObservable.notifyChanged();
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void registerDataSetObserver(@NonNull DataSetObserver r1) {
        this.mObservable.registerObserver(r1);
    }

    public void restoreState(@Nullable Parcelable r1, @Nullable ClassLoader r2) {
    }

    @Nullable
    public Parcelable saveState() {
        return null;
    }

    @Deprecated
    public void setPrimaryItem(@NonNull View r1, int r2, @NonNull Object r3) {
    }

    public void setViewPagerObserver(DataSetObserver r1) {
        monitor-enter(this);
        this.mViewPagerObserver = r1;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public void startUpdate(@NonNull View r1) {
    }

    public void unregisterDataSetObserver(@NonNull DataSetObserver r1) {
        this.mObservable.unregisterObserver(r1);
    }

    @Deprecated
    public void destroyItem(@NonNull View r1, int r2, @NonNull Object r3) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void finishUpdate(@NonNull ViewGroup r1) {
        finishUpdate(r1);
    }

    @NonNull
    @Deprecated
    public Object instantiateItem(@NonNull View r1, int r2) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    public void setPrimaryItem(@NonNull ViewGroup r1, int r2, @NonNull Object r3) {
        setPrimaryItem(r1, r2, r3);
    }

    public void startUpdate(@NonNull ViewGroup r1) {
        startUpdate(r1);
    }
}
