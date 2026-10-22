package androidx.fragment.app;

import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.PagerAdapter;

/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentPagerAdapter extends PagerAdapter {
    public static final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;

    @Deprecated
    public static final int BEHAVIOR_SET_USER_VISIBLE_HINT = 0;
    private static final boolean DEBUG = false;
    private static final String TAG = "FragmentPagerAdapter";
    private final int mBehavior;
    private FragmentTransaction mCurTransaction;
    private Fragment mCurrentPrimaryItem;
    private final FragmentManager mFragmentManager;

    @Deprecated
    public FragmentPagerAdapter(@NonNull FragmentManager r2) {
        this(r2, 0);
    }

    private static String makeFragmentName(int r2, long r3) {
        return "android:switcher:" + r2 + ":" + r3;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup r1, int r2, @NonNull Object r3) {
        Fragment r4 = (Fragment) r3;
        if (this.mCurTransaction != null) goto L5;
        this.mCurTransaction = this.mFragmentManager.beginTransaction();
    L5:
        this.mCurTransaction.detach(r4);
        if (r4 != this.mCurrentPrimaryItem) goto L9;
        this.mCurrentPrimaryItem = null;
        return;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void finishUpdate(@NonNull ViewGroup r1) {
        FragmentTransaction r2 = this.mCurTransaction;
        if (r2 == null) goto L6;
        r2.commitNowAllowingStateLoss();
        this.mCurTransaction = null;
        return;
    }

    @NonNull
    public abstract Fragment getItem(int r1);

    public long getItemId(int r1) {
        return r1;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup r5, int r6) {
        if (this.mCurTransaction != null) goto L5;
        this.mCurTransaction = this.mFragmentManager.beginTransaction();
    L5:
        long r0 = getItemId(r6);
        String r2 = makeFragmentName(r5.getId(), r0);
        Fragment r3 = this.mFragmentManager.findFragmentByTag(r2);
        if (r3 == null) goto L8;
        this.mCurTransaction.attach(r3);
    L10:
        if (r3 == this.mCurrentPrimaryItem) goto L15;
        r3.setMenuVisibility(false);
        if (this.mBehavior != 1) goto L14;
        this.mCurTransaction.setMaxLifecycle(r3, Lifecycle.State.STARTED);
        goto L15
    L14:
        r3.setUserVisibleHint(false);
    L15:
        return r3;
    L8:
        r3 = getItem(r6);
        this.mCurTransaction.add(r5.getId(), r3, makeFragmentName(r5.getId(), r0));
        goto L10
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View r1, @NonNull Object r2) {
        if (((Fragment) r2).getView() != r1) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void restoreState(@Nullable Parcelable r1, @Nullable ClassLoader r2) {
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @Nullable
    public Parcelable saveState() {
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup r3, int r4, @NonNull Object r5) {
        Fragment r6 = (Fragment) r5;
        Fragment r7 = this.mCurrentPrimaryItem;
        if (r6 != r7) goto L5;
        return;
    L5:
        if (r7 == null) goto L13;
        r7.setMenuVisibility(false);
        if (this.mBehavior == 1) goto L9;
        this.mCurrentPrimaryItem.setUserVisibleHint(false);
        goto L13
    L9:
        if (this.mCurTransaction != null) goto L11;
        this.mCurTransaction = this.mFragmentManager.beginTransaction();
    L11:
        this.mCurTransaction.setMaxLifecycle(this.mCurrentPrimaryItem, Lifecycle.State.STARTED);
    L13:
        r6.setMenuVisibility(true);
        if (this.mBehavior == 1) goto L16;
        r6.setUserVisibleHint(true);
    L20:
        this.mCurrentPrimaryItem = r6;
        return;
    L16:
        if (this.mCurTransaction != null) goto L18;
        this.mCurTransaction = this.mFragmentManager.beginTransaction();
    L18:
        this.mCurTransaction.setMaxLifecycle(r6, Lifecycle.State.RESUMED);
        goto L20
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void startUpdate(@NonNull ViewGroup r3) {
        if (r3.getId() == (-1)) goto L6;
        return;
    L6:
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }

    public FragmentPagerAdapter(@NonNull FragmentManager r2, int r3) {
        this.mCurTransaction = null;
        this.mCurrentPrimaryItem = null;
        this.mFragmentManager = r2;
        this.mBehavior = r3;
    }
}
