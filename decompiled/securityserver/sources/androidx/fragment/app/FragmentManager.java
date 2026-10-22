package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentManager {
    static final FragmentFactory DEFAULT_FACTORY = null;
    public static final int POP_BACK_STACK_INCLUSIVE = 1;
    private FragmentFactory mFragmentFactory;

    public interface BackStackEntry {
        @Nullable
        CharSequence getBreadCrumbShortTitle();

        @StringRes
        int getBreadCrumbShortTitleRes();

        @Nullable
        CharSequence getBreadCrumbTitle();

        @StringRes
        int getBreadCrumbTitleRes();

        int getId();

        @Nullable
        String getName();
    }

    public static abstract class FragmentLifecycleCallbacks {
        public FragmentLifecycleCallbacks() {
        }

        public void onFragmentActivityCreated(@NonNull FragmentManager r1, @NonNull Fragment r2, @Nullable Bundle r3) {
        }

        public void onFragmentAttached(@NonNull FragmentManager r1, @NonNull Fragment r2, @NonNull Context r3) {
        }

        public void onFragmentCreated(@NonNull FragmentManager r1, @NonNull Fragment r2, @Nullable Bundle r3) {
        }

        public void onFragmentDestroyed(@NonNull FragmentManager r1, @NonNull Fragment r2) {
        }

        public void onFragmentDetached(@NonNull FragmentManager r1, @NonNull Fragment r2) {
        }

        public void onFragmentPaused(@NonNull FragmentManager r1, @NonNull Fragment r2) {
        }

        public void onFragmentPreAttached(@NonNull FragmentManager r1, @NonNull Fragment r2, @NonNull Context r3) {
        }

        public void onFragmentPreCreated(@NonNull FragmentManager r1, @NonNull Fragment r2, @Nullable Bundle r3) {
        }

        public void onFragmentResumed(@NonNull FragmentManager r1, @NonNull Fragment r2) {
        }

        public void onFragmentSaveInstanceState(@NonNull FragmentManager r1, @NonNull Fragment r2, @NonNull Bundle r3) {
        }

        public void onFragmentStarted(@NonNull FragmentManager r1, @NonNull Fragment r2) {
        }

        public void onFragmentStopped(@NonNull FragmentManager r1, @NonNull Fragment r2) {
        }

        public void onFragmentViewCreated(@NonNull FragmentManager r1, @NonNull Fragment r2, @NonNull View r3, @Nullable Bundle r4) {
        }

        public void onFragmentViewDestroyed(@NonNull FragmentManager r1, @NonNull Fragment r2) {
        }
    }

    public interface OnBackStackChangedListener {
        void onBackStackChanged();
    }

    static {
        DEFAULT_FACTORY = new FragmentFactory();
    }

    public FragmentManager() {
        this.mFragmentFactory = null;
    }

    public static void enableDebugLogging(boolean r0) {
        FragmentManagerImpl.DEBUG = r0;
    }

    public abstract void addOnBackStackChangedListener(@NonNull OnBackStackChangedListener r1);

    @NonNull
    public abstract FragmentTransaction beginTransaction();

    public abstract void dump(@NonNull String r1, @Nullable FileDescriptor r2, @NonNull PrintWriter r3, @Nullable String[] r4);

    public abstract boolean executePendingTransactions();

    @Nullable
    public abstract Fragment findFragmentById(@IdRes int r1);

    @Nullable
    public abstract Fragment findFragmentByTag(@Nullable String r1);

    @NonNull
    public abstract BackStackEntry getBackStackEntryAt(int r1);

    public abstract int getBackStackEntryCount();

    @Nullable
    public abstract Fragment getFragment(@NonNull Bundle r1, @NonNull String r2);

    @NonNull
    public FragmentFactory getFragmentFactory() {
        if (this.mFragmentFactory != null) goto L6;
        this.mFragmentFactory = DEFAULT_FACTORY;
    L6:
        return this.mFragmentFactory;
    }

    @NonNull
    public abstract List<Fragment> getFragments();

    @Nullable
    public abstract Fragment getPrimaryNavigationFragment();

    public abstract boolean isDestroyed();

    public abstract boolean isStateSaved();

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public FragmentTransaction openTransaction() {
        return beginTransaction();
    }

    public abstract void popBackStack();

    public abstract void popBackStack(int r1, int r2);

    public abstract void popBackStack(@Nullable String r1, int r2);

    public abstract boolean popBackStackImmediate();

    public abstract boolean popBackStackImmediate(int r1, int r2);

    public abstract boolean popBackStackImmediate(@Nullable String r1, int r2);

    public abstract void putFragment(@NonNull Bundle r1, @NonNull String r2, @NonNull Fragment r3);

    public abstract void registerFragmentLifecycleCallbacks(@NonNull FragmentLifecycleCallbacks r1, boolean r2);

    public abstract void removeOnBackStackChangedListener(@NonNull OnBackStackChangedListener r1);

    @Nullable
    public abstract Fragment.SavedState saveFragmentInstanceState(@NonNull Fragment r1);

    public void setFragmentFactory(@NonNull FragmentFactory r1) {
        this.mFragmentFactory = r1;
    }

    public abstract void unregisterFragmentLifecycleCallbacks(@NonNull FragmentLifecycleCallbacks r1);
}
