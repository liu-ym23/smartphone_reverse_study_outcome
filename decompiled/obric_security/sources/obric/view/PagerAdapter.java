package obric.view;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes5.dex */
public abstract class PagerAdapter {
    public static final int POSITION_NONE = -2;
    public static final int POSITION_UNCHANGED = -1;
    private DataSetObservable mObservable;

    public void finishUpdate(View container) {
    }

    public abstract int getCount();

    public int getItemPosition(Object object) {
        return -1;
    }

    public CharSequence getPageTitle(int position) {
        return null;
    }

    public float getPageWidth(int position) {
        return 1.0f;
    }

    public abstract boolean isViewFromObject(View view, Object object);

    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    public Parcelable saveState() {
        return null;
    }

    public void setPrimaryItem(View container, int position, Object object) {
    }

    public void startUpdate(View container) {
    }

    public PagerAdapter() {
        this.mObservable = new DataSetObservable();
    }

    public void startUpdate(ViewGroup container) {
        startUpdate(container);
    }

    public Object instantiateItem(ViewGroup container, int position) {
        return instantiateItem(container, position);
    }

    public void destroyItem(ViewGroup container, int position, Object object) {
        destroyItem(container, position, object);
    }

    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        setPrimaryItem(container, position, object);
    }

    public void finishUpdate(ViewGroup container) {
        finishUpdate(container);
    }

    public Object instantiateItem(View container, int position) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    public void destroyItem(View container, int position, Object object) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    public void notifyDataSetChanged() {
        this.mObservable.notifyChanged();
    }

    public void registerDataSetObserver(DataSetObserver observer) {
        this.mObservable.registerObserver(observer);
    }

    public void unregisterDataSetObserver(DataSetObserver observer) {
        this.mObservable.unregisterObserver(observer);
    }
}
