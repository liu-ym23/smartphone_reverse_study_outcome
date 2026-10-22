package androidx.fragment.app;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.AnimRes;
import androidx.annotation.AnimatorRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentTransaction {
    static final int OP_ADD = 1;
    static final int OP_ATTACH = 7;
    static final int OP_DETACH = 6;
    static final int OP_HIDE = 4;
    static final int OP_NULL = 0;
    static final int OP_REMOVE = 3;
    static final int OP_REPLACE = 2;
    static final int OP_SET_MAX_LIFECYCLE = 10;
    static final int OP_SET_PRIMARY_NAV = 8;
    static final int OP_SHOW = 5;
    static final int OP_UNSET_PRIMARY_NAV = 9;
    public static final int TRANSIT_ENTER_MASK = 4096;
    public static final int TRANSIT_EXIT_MASK = 8192;
    public static final int TRANSIT_FRAGMENT_CLOSE = 8194;
    public static final int TRANSIT_FRAGMENT_FADE = 4099;
    public static final int TRANSIT_FRAGMENT_MATCH_ACTIVITY_CLOSE = 8197;
    public static final int TRANSIT_FRAGMENT_MATCH_ACTIVITY_OPEN = 4100;
    public static final int TRANSIT_FRAGMENT_OPEN = 4097;
    public static final int TRANSIT_NONE = 0;
    public static final int TRANSIT_UNSET = -1;
    boolean mAddToBackStack;
    boolean mAllowAddToBackStack;
    int mBreadCrumbShortTitleRes;
    CharSequence mBreadCrumbShortTitleText;
    int mBreadCrumbTitleRes;
    CharSequence mBreadCrumbTitleText;
    private final ClassLoader mClassLoader;
    ArrayList<Runnable> mCommitRunnables;
    int mEnterAnim;
    int mExitAnim;
    private final FragmentFactory mFragmentFactory;

    @Nullable
    String mName;
    ArrayList<Op> mOps;
    int mPopEnterAnim;
    int mPopExitAnim;
    boolean mReorderingAllowed;
    ArrayList<String> mSharedElementSourceNames;
    ArrayList<String> mSharedElementTargetNames;
    int mTransition;

    static final class Op {
        int mCmd;
        Lifecycle.State mCurrentMaxState;
        int mEnterAnim;
        int mExitAnim;
        Fragment mFragment;
        boolean mFromExpandedOp;
        Lifecycle.State mOldMaxState;
        int mPopEnterAnim;
        int mPopExitAnim;

        Op() {
        }

        Op(int r1, Fragment r2) {
            this.mCmd = r1;
            this.mFragment = r2;
            this.mFromExpandedOp = false;
            Lifecycle.State r3 = Lifecycle.State.RESUMED;
            this.mOldMaxState = r3;
            this.mCurrentMaxState = r3;
        }

        Op(int r1, @NonNull Fragment r2, Lifecycle.State r3) {
            this.mCmd = r1;
            this.mFragment = r2;
            this.mFromExpandedOp = false;
            this.mOldMaxState = r2.mMaxState;
            this.mCurrentMaxState = r3;
        }

        Op(int r1, Fragment r2, boolean r3) {
            this.mCmd = r1;
            this.mFragment = r2;
            this.mFromExpandedOp = r3;
            Lifecycle.State r4 = Lifecycle.State.RESUMED;
            this.mOldMaxState = r4;
            this.mCurrentMaxState = r4;
        }

        Op(Op r2) {
            this.mCmd = r2.mCmd;
            this.mFragment = r2.mFragment;
            this.mFromExpandedOp = r2.mFromExpandedOp;
            this.mEnterAnim = r2.mEnterAnim;
            this.mExitAnim = r2.mExitAnim;
            this.mPopEnterAnim = r2.mPopEnterAnim;
            this.mPopExitAnim = r2.mPopExitAnim;
            this.mOldMaxState = r2.mOldMaxState;
            this.mCurrentMaxState = r2.mCurrentMaxState;
        }
    }

    @Deprecated
    public FragmentTransaction() {
        this.mOps = new ArrayList();
        this.mAllowAddToBackStack = true;
        this.mReorderingAllowed = false;
        this.mFragmentFactory = null;
        this.mClassLoader = null;
    }

    FragmentTransaction(@NonNull FragmentFactory r2, @Nullable ClassLoader r3) {
        this.mOps = new ArrayList();
        this.mAllowAddToBackStack = true;
        this.mReorderingAllowed = false;
        this.mFragmentFactory = r2;
        this.mClassLoader = r3;
    }

    FragmentTransaction(@NonNull FragmentFactory r3, @Nullable ClassLoader r4, @NonNull FragmentTransaction r5) {
        this(r3, r4);
        Iterator<Op> r6 = r5.mOps.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        Op r7 = r6.next();
        this.mOps.add(new Op(r7));
        goto L4
    L6:
        this.mEnterAnim = r5.mEnterAnim;
        this.mExitAnim = r5.mExitAnim;
        this.mPopEnterAnim = r5.mPopEnterAnim;
        this.mPopExitAnim = r5.mPopExitAnim;
        this.mTransition = r5.mTransition;
        this.mAddToBackStack = r5.mAddToBackStack;
        this.mAllowAddToBackStack = r5.mAllowAddToBackStack;
        this.mName = r5.mName;
        this.mBreadCrumbShortTitleRes = r5.mBreadCrumbShortTitleRes;
        this.mBreadCrumbShortTitleText = r5.mBreadCrumbShortTitleText;
        this.mBreadCrumbTitleRes = r5.mBreadCrumbTitleRes;
        this.mBreadCrumbTitleText = r5.mBreadCrumbTitleText;
        if (r5.mSharedElementSourceNames == null) goto L10;
        ArrayList<String> r8 = new ArrayList();
        this.mSharedElementSourceNames = r8;
        r8.addAll(r5.mSharedElementSourceNames);
    L10:
        if (r5.mSharedElementTargetNames == null) goto L12;
        ArrayList<String> r9 = new ArrayList();
        this.mSharedElementTargetNames = r9;
        r9.addAll(r5.mSharedElementTargetNames);
    L12:
        this.mReorderingAllowed = r5.mReorderingAllowed;
    }

    @NonNull
    private Fragment createFragment(@NonNull Class<? extends Fragment> r2, @Nullable Bundle r3) {
        FragmentFactory r0 = this.mFragmentFactory;
        if (r0 == null) goto L13;
        ClassLoader r1 = this.mClassLoader;
        if (r1 == null) goto L11;
        Fragment r4 = r0.instantiate(r1, r2.getName());
        if (r3 == null) goto L9;
        r4.setArguments(r3);
    L9:
        return r4;
    L11:
        throw new IllegalStateException("The FragmentManager must be attached to itshost to create a Fragment");
    L13:
        throw new IllegalStateException("Creating a Fragment requires that this FragmentTransaction was built with FragmentManager.beginTransaction()");
    }

    @NonNull
    public FragmentTransaction add(@IdRes int r3, @NonNull Fragment r4) {
        doAddOp(r3, r4, null, 1);
        return this;
    }

    @NonNull
    public FragmentTransaction add(@IdRes int r2, @NonNull Fragment r3, @Nullable String r4) {
        doAddOp(r2, r3, r4, 1);
        return this;
    }

    @NonNull
    public final FragmentTransaction add(@IdRes int r1, @NonNull Class<? extends Fragment> r2, @Nullable Bundle r3) {
        return add(r1, createFragment(r2, r3));
    }

    @NonNull
    public final FragmentTransaction add(@IdRes int r1, @NonNull Class<? extends Fragment> r2, @Nullable Bundle r3, @Nullable String r4) {
        return add(r1, createFragment(r2, r3), r4);
    }

    FragmentTransaction add(@NonNull ViewGroup r1, @NonNull Fragment r2, @Nullable String r3) {
        r2.mContainer = r1;
        return add(r1.getId(), r2, r3);
    }

    @NonNull
    public FragmentTransaction add(@NonNull Fragment r3, @Nullable String r4) {
        doAddOp(0, r3, r4, 1);
        return this;
    }

    @NonNull
    public final FragmentTransaction add(@NonNull Class<? extends Fragment> r1, @Nullable Bundle r2, @Nullable String r3) {
        return add(createFragment(r1, r2), r3);
    }

    void addOp(Op r2) {
        this.mOps.add(r2);
        r2.mEnterAnim = this.mEnterAnim;
        r2.mExitAnim = this.mExitAnim;
        r2.mPopEnterAnim = this.mPopEnterAnim;
        r2.mPopExitAnim = this.mPopExitAnim;
    }

    @NonNull
    public FragmentTransaction addSharedElement(@NonNull View r3, @NonNull String r4) {
        if (FragmentTransition.supportsTransition() == false) goto L20;
        String r5 = ViewCompat.getTransitionName(r3);
        if (r5 == null) goto L19;
        if (this.mSharedElementSourceNames != null) goto L10;
        this.mSharedElementSourceNames = new ArrayList();
        this.mSharedElementTargetNames = new ArrayList();
    L13:
        this.mSharedElementSourceNames.add(r5);
        this.mSharedElementTargetNames.add(r4);
        goto L20
    L10:
        if (this.mSharedElementTargetNames.contains(r4) == true) goto L17;
        if (this.mSharedElementSourceNames.contains(r5) == false) goto L13;
        throw new IllegalArgumentException("A shared element with the source name '" + r5 + "' has already been added to the transaction.");
    L17:
        throw new IllegalArgumentException("A shared element with the target name '" + r4 + "' has already been added to the transaction.");
    L19:
        throw new IllegalArgumentException("Unique transitionNames are required for all sharedElements");
    L20:
        return this;
    }

    @NonNull
    public FragmentTransaction addToBackStack(@Nullable String r2) {
        if (this.mAllowAddToBackStack == false) goto L7;
        this.mAddToBackStack = true;
        this.mName = r2;
        return this;
    L7:
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    @NonNull
    public FragmentTransaction attach(@NonNull Fragment r3) {
        addOp(new Op(7, r3));
        return this;
    }

    public abstract int commit();

    public abstract int commitAllowingStateLoss();

    public abstract void commitNow();

    public abstract void commitNowAllowingStateLoss();

    @NonNull
    public FragmentTransaction detach(@NonNull Fragment r3) {
        addOp(new Op(6, r3));
        return this;
    }

    @NonNull
    public FragmentTransaction disallowAddToBackStack() {
        if (this.mAddToBackStack == true) goto L7;
        this.mAllowAddToBackStack = false;
        return this;
    L7:
        throw new IllegalStateException("This transaction is already being added to the back stack");
    }

    void doAddOp(int r4, Fragment r5, @Nullable String r6, int r7) {
        String r0 = r5.mPreviousWho;
        if (r0 == null) goto L5;
        FragmentStrictMode.onFragmentReuse(r5, r0);
    L5:
        Class<?> r1 = r5.getClass();
        int r2 = r1.getModifiers();
        if (r1.isAnonymousClass() == true) goto L38;
        if (Modifier.isPublic(r2) == false) goto L38;
        if (r1.isMemberClass() == false) goto L14;
        if (Modifier.isStatic(r2) == false) goto L38;
    L14:
        if (r6 == null) goto L23;
        String r3 = r5.mTag;
        if (r3 != null) goto L18;
    L22:
        r5.mTag = r6;
        goto L23
    L18:
        if (r6.equals(r3) == true) goto L22;
        throw new IllegalStateException("Can't change tag of fragment " + r5 + ": was " + r5.mTag + " now " + r6);
    L23:
        if (r4 != 0) goto L25;
    L35:
        addOp(new Op(r7, r5));
        return;
    L25:
        if (r4 == (-1)) goto L34;
        int r8 = r5.mFragmentId;
        if (r8 == 0) goto L32;
        if (r8 == r4) goto L32;
        throw new IllegalStateException("Can't change container ID of fragment " + r5 + ": was " + r5.mFragmentId + " now " + r4);
    L32:
        r5.mFragmentId = r4;
        r5.mContainerId = r4;
        goto L35
    L34:
        throw new IllegalArgumentException("Can't add fragment " + r5 + " with tag " + r6 + " to container view with no id");
    L38:
        throw new IllegalStateException("Fragment " + r1.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
    }

    @NonNull
    public FragmentTransaction hide(@NonNull Fragment r3) {
        addOp(new Op(4, r3));
        return this;
    }

    public boolean isAddToBackStackAllowed() {
        return this.mAllowAddToBackStack;
    }

    public boolean isEmpty() {
        return this.mOps.isEmpty();
    }

    @NonNull
    public FragmentTransaction remove(@NonNull Fragment r3) {
        addOp(new Op(3, r3));
        return this;
    }

    @NonNull
    public FragmentTransaction replace(@IdRes int r2, @NonNull Fragment r3) {
        return replace(r2, r3, null);
    }

    @NonNull
    public FragmentTransaction replace(@IdRes int r2, @NonNull Fragment r3, @Nullable String r4) {
        if (r2 == 0) goto L6;
        doAddOp(r2, r3, r4, 2);
        return this;
    L6:
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    @NonNull
    public final FragmentTransaction replace(@IdRes int r2, @NonNull Class<? extends Fragment> r3, @Nullable Bundle r4) {
        return replace(r2, r3, r4, null);
    }

    @NonNull
    public final FragmentTransaction replace(@IdRes int r1, @NonNull Class<? extends Fragment> r2, @Nullable Bundle r3, @Nullable String r4) {
        return replace(r1, createFragment(r2, r3), r4);
    }

    @NonNull
    public FragmentTransaction runOnCommit(@NonNull Runnable r2) {
        disallowAddToBackStack();
        if (this.mCommitRunnables != null) goto L5;
        this.mCommitRunnables = new ArrayList();
    L5:
        this.mCommitRunnables.add(r2);
        return this;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setAllowOptimization(boolean r1) {
        return setReorderingAllowed(r1);
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setBreadCrumbShortTitle(@StringRes int r1) {
        this.mBreadCrumbShortTitleRes = r1;
        this.mBreadCrumbShortTitleText = null;
        return this;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setBreadCrumbShortTitle(@Nullable CharSequence r2) {
        this.mBreadCrumbShortTitleRes = 0;
        this.mBreadCrumbShortTitleText = r2;
        return this;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setBreadCrumbTitle(@StringRes int r1) {
        this.mBreadCrumbTitleRes = r1;
        this.mBreadCrumbTitleText = null;
        return this;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setBreadCrumbTitle(@Nullable CharSequence r2) {
        this.mBreadCrumbTitleRes = 0;
        this.mBreadCrumbTitleText = r2;
        return this;
    }

    @NonNull
    public FragmentTransaction setCustomAnimations(@AnimRes @AnimatorRes int r2, @AnimRes @AnimatorRes int r3) {
        return setCustomAnimations(r2, r3, 0, 0);
    }

    @NonNull
    public FragmentTransaction setCustomAnimations(@AnimRes @AnimatorRes int r1, @AnimRes @AnimatorRes int r2, @AnimRes @AnimatorRes int r3, @AnimRes @AnimatorRes int r4) {
        this.mEnterAnim = r1;
        this.mExitAnim = r2;
        this.mPopEnterAnim = r3;
        this.mPopExitAnim = r4;
        return this;
    }

    @NonNull
    public FragmentTransaction setMaxLifecycle(@NonNull Fragment r3, @NonNull Lifecycle.State r4) {
        addOp(new Op(10, r3, r4));
        return this;
    }

    @NonNull
    public FragmentTransaction setPrimaryNavigationFragment(@Nullable Fragment r3) {
        addOp(new Op(8, r3));
        return this;
    }

    @NonNull
    public FragmentTransaction setReorderingAllowed(boolean r1) {
        this.mReorderingAllowed = r1;
        return this;
    }

    @NonNull
    public FragmentTransaction setTransition(int r1) {
        this.mTransition = r1;
        return this;
    }

    @NonNull
    @Deprecated
    public FragmentTransaction setTransitionStyle(@StyleRes int r1) {
        return this;
    }

    @NonNull
    public FragmentTransaction show(@NonNull Fragment r3) {
        addOp(new Op(5, r3));
        return this;
    }
}
