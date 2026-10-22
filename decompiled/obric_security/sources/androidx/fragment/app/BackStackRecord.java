package androidx.fragment.app;

import android.util.Log;
import androidx.lifecycle.Lifecycle;
import java.io.PrintWriter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
final class BackStackRecord extends FragmentTransaction implements FragmentManager.BackStackEntry, FragmentManager.OpGenerator {
    private static final String TAG = "FragmentManager";
    boolean mCommitted;
    int mIndex;
    final FragmentManager mManager;

    public String toString() {
        StringBuilder r0 = new StringBuilder(128);
        r0.append("BackStackEntry{");
        r0.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.mIndex < 0) goto L6;
        r0.append(" #");
        r0.append(this.mIndex);
    L6:
        if (this.mName == null) goto L8;
        r0.append(" ");
        r0.append(this.mName);
    L8:
        r0.append("}");
        return r0.toString();
    }

    public void dump(String r2, PrintWriter r3) {
        dump(r2, r3, true);
    }

    public void dump(String r6, PrintWriter r7, boolean r8) {
        if (r8 == false) goto L27;
        r7.print(r6);
        r7.print("mName=");
        r7.print(this.mName);
        r7.print(" mIndex=");
        r7.print(this.mIndex);
        r7.print(" mCommitted=");
        r7.println(this.mCommitted);
        if (this.mTransition == 0) goto L7;
        r7.print(r6);
        r7.print("mTransition=#");
        r7.print(Integer.toHexString(this.mTransition));
    L7:
        if (this.mEnterAnim == 0) goto L9;
    L10:
        r7.print(r6);
        r7.print("mEnterAnim=#");
        r7.print(Integer.toHexString(this.mEnterAnim));
        r7.print(" mExitAnim=#");
        r7.println(Integer.toHexString(this.mExitAnim));
    L12:
        if (this.mPopEnterAnim == 0) goto L14;
    L15:
        r7.print(r6);
        r7.print("mPopEnterAnim=#");
        r7.print(Integer.toHexString(this.mPopEnterAnim));
        r7.print(" mPopExitAnim=#");
        r7.println(Integer.toHexString(this.mPopExitAnim));
    L17:
        if (this.mBreadCrumbTitleRes == 0) goto L19;
    L20:
        r7.print(r6);
        r7.print("mBreadCrumbTitleRes=#");
        r7.print(Integer.toHexString(this.mBreadCrumbTitleRes));
        r7.print(" mBreadCrumbTitleText=");
        r7.println(this.mBreadCrumbTitleText);
    L22:
        if (this.mBreadCrumbShortTitleRes == 0) goto L24;
    L25:
        r7.print(r6);
        r7.print("mBreadCrumbShortTitleRes=#");
        r7.print(Integer.toHexString(this.mBreadCrumbShortTitleRes));
        r7.print(" mBreadCrumbShortTitleText=");
        r7.println(this.mBreadCrumbShortTitleText);
        goto L27
    L24:
        if (this.mBreadCrumbShortTitleText == null) goto L27;
    L19:
        if (this.mBreadCrumbTitleText == null) goto L22;
    L14:
        if (this.mPopExitAnim == 0) goto L17;
    L9:
        if (this.mExitAnim == 0) goto L12;
    L27:
        if (this.mOps.isEmpty() == true) goto L57;
        r7.print(r6);
        r7.println("Operations:");
        int r0 = this.mOps.size();
        int r1 = 0;
    L29:
        if (r1 >= r0) goto L62;
        FragmentTransaction.Op r2 = this.mOps.get(r1);
        switch(r2.mCmd) {
            case 0: goto L43;
            case 1: goto L42;
            case 2: goto L41;
            case 3: goto L40;
            case 4: goto L39;
            case 5: goto L38;
            case 6: goto L37;
            case 7: goto L36;
            case 8: goto L35;
            case 9: goto L34;
            case 10: goto L33;
            default: goto L32;
        };
    L32:
        String r3 = "cmd=" + r2.mCmd;
    L44:
        r7.print(r6);
        r7.print("  Op #");
        r7.print(r1);
        r7.print(": ");
        r7.print(r3);
        r7.print(" ");
        r7.println(r2.mFragment);
        if (r8 == false) goto L56;
        if (r2.mEnterAnim == 0) goto L49;
    L50:
        r7.print(r6);
        r7.print("enterAnim=#");
        r7.print(Integer.toHexString(r2.mEnterAnim));
        r7.print(" exitAnim=#");
        r7.println(Integer.toHexString(r2.mExitAnim));
    L52:
        if (r2.mPopEnterAnim == 0) goto L54;
    L55:
        r7.print(r6);
        r7.print("popEnterAnim=#");
        r7.print(Integer.toHexString(r2.mPopEnterAnim));
        r7.print(" popExitAnim=#");
        r7.println(Integer.toHexString(r2.mPopExitAnim));
        goto L56
    L54:
        if (r2.mPopExitAnim == 0) goto L56;
    L49:
        if (r2.mExitAnim == 0) goto L52;
    L56:
        r1 = r1 + 1;
        goto L29
    L33:
        r3 = "OP_SET_MAX_LIFECYCLE";
        goto L44
    L34:
        r3 = "UNSET_PRIMARY_NAV";
        goto L44
    L35:
        r3 = "SET_PRIMARY_NAV";
        goto L44
    L36:
        r3 = "ATTACH";
        goto L44
    L37:
        r3 = "DETACH";
        goto L44
    L38:
        r3 = "SHOW";
        goto L44
    L39:
        r3 = "HIDE";
        goto L44
    L40:
        r3 = "REMOVE";
        goto L44
    L41:
        r3 = "REPLACE";
        goto L44
    L42:
        r3 = "ADD";
        goto L44
    L43:
        r3 = "NULL";
        goto L44
    L62:
        return;
    }

    BackStackRecord(FragmentManager r3) {
        FragmentFactory r0 = r3.getFragmentFactory();
        if (r3.getHost() == null) goto L5;
        ClassLoader r1 = r3.getHost().getContext().getClassLoader();
    L6:
        super(r0, r1);
        this.mIndex = -1;
        this.mManager = r3;
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public int getId() {
        return this.mIndex;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public int getBreadCrumbTitleRes() {
        return this.mBreadCrumbTitleRes;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public int getBreadCrumbShortTitleRes() {
        return this.mBreadCrumbShortTitleRes;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public CharSequence getBreadCrumbTitle() {
        if (this.mBreadCrumbTitleRes == 0) goto L7;
        return this.mManager.getHost().getContext().getText(this.mBreadCrumbTitleRes);
    L7:
        return this.mBreadCrumbTitleText;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public CharSequence getBreadCrumbShortTitle() {
        if (this.mBreadCrumbShortTitleRes == 0) goto L7;
        return this.mManager.getHost().getContext().getText(this.mBreadCrumbShortTitleRes);
    L7:
        return this.mBreadCrumbShortTitleText;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    void doAddOp(int r1, Fragment r2, String r3, int r4) {
        super.doAddOp(r1, r2, r3, r4);
        r2.mFragmentManager = this.mManager;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction remove(Fragment r3) {
        if (r3.mFragmentManager == null) goto L10;
        if (r3.mFragmentManager == this.mManager) goto L10;
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + r3.toString() + " is already attached to a FragmentManager.");
    L10:
        return super.remove(r3);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction hide(Fragment r3) {
        if (r3.mFragmentManager == null) goto L10;
        if (r3.mFragmentManager == this.mManager) goto L10;
        throw new IllegalStateException("Cannot hide Fragment attached to a different FragmentManager. Fragment " + r3.toString() + " is already attached to a FragmentManager.");
    L10:
        return super.hide(r3);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction show(Fragment r3) {
        if (r3.mFragmentManager == null) goto L10;
        if (r3.mFragmentManager == this.mManager) goto L10;
        throw new IllegalStateException("Cannot show Fragment attached to a different FragmentManager. Fragment " + r3.toString() + " is already attached to a FragmentManager.");
    L10:
        return super.show(r3);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction detach(Fragment r3) {
        if (r3.mFragmentManager == null) goto L10;
        if (r3.mFragmentManager == this.mManager) goto L10;
        throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + r3.toString() + " is already attached to a FragmentManager.");
    L10:
        return super.detach(r3);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction setPrimaryNavigationFragment(Fragment r3) {
        if (r3 == null) goto L11;
        if (r3.mFragmentManager == null) goto L11;
        if (r3.mFragmentManager == this.mManager) goto L11;
        throw new IllegalStateException("Cannot setPrimaryNavigation for Fragment attached to a different FragmentManager. Fragment " + r3.toString() + " is already attached to a FragmentManager.");
    L11:
        return super.setPrimaryNavigationFragment(r3);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public FragmentTransaction setMaxLifecycle(Fragment r4, Lifecycle.State r5) {
        if (r4.mFragmentManager != this.mManager) goto L18;
        if (r5 != Lifecycle.State.INITIALIZED) goto L12;
        if (r4.mState <= (-1)) goto L12;
        throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + r5 + " after the Fragment has been created");
    L12:
        if (r5 == Lifecycle.State.DESTROYED) goto L16;
        return super.setMaxLifecycle(r4, r5);
    L16:
        throw new IllegalArgumentException("Cannot set maximum Lifecycle to " + r5 + ". Use remove() to remove the fragment from the FragmentManager and trigger its destruction.");
    L18:
        throw new IllegalArgumentException("Cannot setMaxLifecycle for Fragment not attached to FragmentManager " + this.mManager);
    }

    void bumpBackStackNesting(int r8) {
        if (this.mAddToBackStack == true) goto L6;
        return;
    L6:
        if (FragmentManager.isLoggingEnabled(2) == false) goto L8;
        Log.v(TAG, "Bump nesting in " + this + " by " + r8);
    L8:
        int r1 = this.mOps.size();
        int r3 = 0;
    L9:
        if (r3 >= r1) goto L16;
        FragmentTransaction.Op r4 = this.mOps.get(r3);
        if (r4.mFragment == null) goto L15;
        r4.mFragment.mBackStackNesting += r8;
        if (FragmentManager.isLoggingEnabled(2) == false) goto L15;
        Log.v(TAG, "Bump nesting of " + r4.mFragment + " to " + r4.mFragment.mBackStackNesting);
    L15:
        r3 = r3 + 1;
        goto L9
    }

    public void runOnCommitRunnables() {
        if (this.mCommitRunnables == null) goto L11;
        int r0 = 0;
    L6:
        if (r0 >= this.mCommitRunnables.size()) goto L8;
        this.mCommitRunnables.get(r0).run();
        r0 = r0 + 1;
        goto L6
    L8:
        this.mCommitRunnables = null;
        return;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public int commit() {
        return commitInternal(false);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public int commitAllowingStateLoss() {
        return commitInternal(true);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public void commitNow() {
        disallowAddToBackStack();
        this.mManager.execSingleAction(this, false);
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public void commitNowAllowingStateLoss() {
        disallowAddToBackStack();
        this.mManager.execSingleAction(this, true);
    }

    int commitInternal(boolean r3) {
        if (this.mCommitted == true) goto L14;
        if (FragmentManager.isLoggingEnabled(2) == false) goto L7;
        Log.v(TAG, "Commit: " + this);
        PrintWriter r1 = new PrintWriter(new LogWriter(TAG));
        dump("  ", r1);
        r1.close();
    L7:
        this.mCommitted = true;
        if (this.mAddToBackStack == false) goto L10;
        this.mIndex = this.mManager.allocBackStackIndex();
    L11:
        this.mManager.enqueueAction(this, r3);
        return this.mIndex;
    L10:
        this.mIndex = -1;
        goto L11
    L14:
        throw new IllegalStateException("commit already called");
    }

    @Override // androidx.fragment.app.FragmentManager.OpGenerator
    public boolean generateOps(ArrayList<BackStackRecord> r3, ArrayList<Boolean> r4) {
        if (FragmentManager.isLoggingEnabled(2) == false) goto L5;
        Log.v(TAG, "Run: " + this);
    L5:
        r3.add(this);
        r4.add(false);
        if (this.mAddToBackStack == false) goto L10;
        this.mManager.addBackStackState(this);
        return true;
    L10:
        return true;
    }

    boolean interactsWith(int r6) {
        int r0 = this.mOps.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L13;
        FragmentTransaction.Op r3 = this.mOps.get(r2);
        if (r3.mFragment == null) goto L7;
        int r4 = r3.mFragment.mContainerId;
    L8:
        if (r4 == 0) goto L12;
        if (r4 != r6) goto L12;
        return true;
    L12:
        r2 = r2 + 1;
        goto L3
    L7:
        r4 = 0;
        goto L8
    L13:
        return false;
    }

    boolean interactsWith(ArrayList<BackStackRecord> r11, int r12, int r13) {
        if (r13 != r12) goto L5;
        return false;
    L5:
        int r1 = this.mOps.size();
        int r2 = -1;
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L28;
        FragmentTransaction.Op r4 = this.mOps.get(r3);
        if (r4.mFragment == null) goto L10;
        int r5 = r4.mFragment.mContainerId;
    L11:
        if (r5 == 0) goto L27;
        if (r5 == r2) goto L27;
        int r6 = r12;
    L14:
        if (r6 >= r13) goto L26;
        BackStackRecord r7 = r11.get(r6);
        int r8 = r7.mOps.size();
        int r9 = 0;
    L16:
        if (r9 >= r8) goto L25;
        FragmentTransaction.Op r10 = r7.mOps.get(r9);
        if (r10.mFragment == null) goto L20;
        int r14 = r10.mFragment.mContainerId;
    L21:
        if (r14 == r5) goto L22;
        r9 = r9 + 1;
        goto L16
    L22:
        return true;
    L20:
        r14 = 0;
        goto L21
    L25:
        r6 = r6 + 1;
        goto L14
    L26:
        r2 = r5;
    L27:
        r3 = r3 + 1;
        goto L6
    L10:
        r5 = 0;
        goto L11
    L28:
        return false;
    }

    void executeOps() {
        int r0 = this.mOps.size();
        int r2 = 0;
    L4:
        if (r2 >= r0) goto L31;
        FragmentTransaction.Op r4 = this.mOps.get(r2);
        Fragment r5 = r4.mFragment;
        if (r5 == null) goto L9;
        r5.setPopDirection(false);
        r5.setNextTransition(this.mTransition);
        r5.setSharedElementNames(this.mSharedElementSourceNames, this.mSharedElementTargetNames);
    L9:
        switch(r4.mCmd) {
            case 1: goto L20;
            case 2: goto L11;
            case 3: goto L19;
            case 4: goto L18;
            case 5: goto L17;
            case 6: goto L16;
            case 7: goto L15;
            case 8: goto L14;
            case 9: goto L13;
            case 10: goto L12;
            default: goto L11;
        };
    L12:
        this.mManager.setMaxLifecycle(r5, r4.mCurrentMaxState);
    L22:
        if (this.mReorderingAllowed == true) goto L29;
        if (r4.mCmd == 1) goto L29;
        if (r5 == null) goto L29;
        if (FragmentManager.USE_STATE_MANAGER == true) goto L29;
        this.mManager.moveFragmentToExpectedState(r5);
    L29:
        r2 = r2 + 1;
        goto L4
    L13:
        this.mManager.setPrimaryNavigationFragment(null);
        goto L22
    L14:
        this.mManager.setPrimaryNavigationFragment(r5);
        goto L22
    L15:
        r5.setAnimations(r4.mEnterAnim, r4.mExitAnim, r4.mPopEnterAnim, r4.mPopExitAnim);
        this.mManager.setExitAnimationOrder(r5, false);
        this.mManager.attachFragment(r5);
        goto L22
    L16:
        r5.setAnimations(r4.mEnterAnim, r4.mExitAnim, r4.mPopEnterAnim, r4.mPopExitAnim);
        this.mManager.detachFragment(r5);
        goto L22
    L17:
        r5.setAnimations(r4.mEnterAnim, r4.mExitAnim, r4.mPopEnterAnim, r4.mPopExitAnim);
        this.mManager.setExitAnimationOrder(r5, false);
        this.mManager.showFragment(r5);
        goto L22
    L18:
        r5.setAnimations(r4.mEnterAnim, r4.mExitAnim, r4.mPopEnterAnim, r4.mPopExitAnim);
        this.mManager.hideFragment(r5);
        goto L22
    L19:
        r5.setAnimations(r4.mEnterAnim, r4.mExitAnim, r4.mPopEnterAnim, r4.mPopExitAnim);
        this.mManager.removeFragment(r5);
        goto L22
    L20:
        r5.setAnimations(r4.mEnterAnim, r4.mExitAnim, r4.mPopEnterAnim, r4.mPopExitAnim);
        this.mManager.setExitAnimationOrder(r5, false);
        this.mManager.addFragment(r5);
        goto L22
    L11:
        throw new IllegalArgumentException("Unknown cmd: " + r4.mCmd);
    L31:
        if (this.mReorderingAllowed == false) goto L33;
        return;
    L33:
        if (FragmentManager.USE_STATE_MANAGER == true) goto L44;
        FragmentManager r10 = this.mManager;
        r10.moveToState(r10.mCurState, true);
        return;
    }

    void executePopOps(boolean r9) {
        int r0 = this.mOps.size() - 1;
    L3:
        if (r0 < 0) goto L30;
        FragmentTransaction.Op r2 = this.mOps.get(r0);
        Fragment r3 = r2.mFragment;
        if (r3 == null) goto L8;
        r3.setPopDirection(true);
        r3.setNextTransition(FragmentManager.reverseTransit(this.mTransition));
        r3.setSharedElementNames(this.mSharedElementTargetNames, this.mSharedElementSourceNames);
    L8:
        switch(r2.mCmd) {
            case 1: goto L19;
            case 2: goto L10;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            case 8: goto L13;
            case 9: goto L12;
            case 10: goto L11;
            default: goto L10;
        };
    L11:
        this.mManager.setMaxLifecycle(r3, r2.mOldMaxState);
    L21:
        if (this.mReorderingAllowed == true) goto L28;
        if (r2.mCmd == 3) goto L28;
        if (r3 == null) goto L28;
        if (FragmentManager.USE_STATE_MANAGER == true) goto L28;
        this.mManager.moveFragmentToExpectedState(r3);
    L28:
        r0 = r0 - 1;
        goto L3
    L12:
        this.mManager.setPrimaryNavigationFragment(r3);
        goto L21
    L13:
        this.mManager.setPrimaryNavigationFragment(null);
        goto L21
    L14:
        r3.setAnimations(r2.mEnterAnim, r2.mExitAnim, r2.mPopEnterAnim, r2.mPopExitAnim);
        this.mManager.setExitAnimationOrder(r3, true);
        this.mManager.detachFragment(r3);
        goto L21
    L15:
        r3.setAnimations(r2.mEnterAnim, r2.mExitAnim, r2.mPopEnterAnim, r2.mPopExitAnim);
        this.mManager.attachFragment(r3);
        goto L21
    L16:
        r3.setAnimations(r2.mEnterAnim, r2.mExitAnim, r2.mPopEnterAnim, r2.mPopExitAnim);
        this.mManager.setExitAnimationOrder(r3, true);
        this.mManager.hideFragment(r3);
        goto L21
    L17:
        r3.setAnimations(r2.mEnterAnim, r2.mExitAnim, r2.mPopEnterAnim, r2.mPopExitAnim);
        this.mManager.showFragment(r3);
        goto L21
    L18:
        r3.setAnimations(r2.mEnterAnim, r2.mExitAnim, r2.mPopEnterAnim, r2.mPopExitAnim);
        this.mManager.addFragment(r3);
        goto L21
    L19:
        r3.setAnimations(r2.mEnterAnim, r2.mExitAnim, r2.mPopEnterAnim, r2.mPopExitAnim);
        this.mManager.setExitAnimationOrder(r3, true);
        this.mManager.removeFragment(r3);
        goto L21
    L10:
        throw new IllegalArgumentException("Unknown cmd: " + r2.mCmd);
    L30:
        if (this.mReorderingAllowed == true) goto L43;
        if (r9 == true) goto L33;
        return;
    L33:
        if (FragmentManager.USE_STATE_MANAGER == true) goto L45;
        FragmentManager r8 = this.mManager;
        r8.moveToState(r8.mCurState, true);
        return;
    L45:
        return;
    }

    Fragment expandOps(ArrayList<Fragment> r17, Fragment r18) {
        Fragment r3 = r18;
        int r4 = 0;
    L4:
        if (r4 >= this.mOps.size()) goto L36;
        FragmentTransaction.Op r5 = this.mOps.get(r4);
        int r6 = r5.mCmd;
        if (r6 != 1) goto L8;
    L34:
        r17.add(r5.mFragment);
    L35:
        r4 = r4 + 1;
        goto L4
    L8:
        if (r6 == 2) goto L21;
        if (r6 != 3) goto L11;
    L18:
        r17.remove(r5.mFragment);
        if (r5.mFragment != r3) goto L35;
        this.mOps.add(r4, new FragmentTransaction.Op(9, r5.mFragment));
        r4 = r4 + 1;
        r3 = null;
        goto L35
    L11:
        if (r6 == 6) goto L18;
        if (r6 == 7) goto L34;
        if (r6 != 8) goto L35;
        this.mOps.add(r4, new FragmentTransaction.Op(9, r3));
        r4 = r4 + 1;
        r3 = r5.mFragment;
        goto L35
    L21:
        Fragment r7 = r5.mFragment;
        int r8 = r7.mContainerId;
        int r12 = r17.size() - 1;
        boolean r13 = false;
    L22:
        if (r12 < 0) goto L31;
        Fragment r14 = r17.get(r12);
        if (r14.mContainerId != r8) goto L30;
        if (r14 != r7) goto L27;
        r13 = true;
        goto L30
    L27:
        if (r14 != r3) goto L29;
        this.mOps.add(r4, new FragmentTransaction.Op(9, r14));
        r4 = r4 + 1;
        r3 = null;
    L29:
        FragmentTransaction.Op r15 = new FragmentTransaction.Op(3, r14);
        r15.mEnterAnim = r5.mEnterAnim;
        r15.mPopEnterAnim = r5.mPopEnterAnim;
        r15.mExitAnim = r5.mExitAnim;
        r15.mPopExitAnim = r5.mPopExitAnim;
        this.mOps.add(r4, r15);
        r17.remove(r14);
        r4 = r4 + 1;
    L30:
        r12 = r12 - 1;
        goto L22
    L31:
        if (r13 == false) goto L33;
        this.mOps.remove(r4);
        r4 = r4 - 1;
        goto L35
    L33:
        r5.mCmd = 1;
        r17.add(r7);
        goto L35
    L36:
        return r3;
    }

    Fragment trackAddedFragmentsInPop(ArrayList<Fragment> r6, Fragment r7) {
        int r0 = this.mOps.size() - 1;
    L3:
        if (r0 < 0) goto L16;
        FragmentTransaction.Op r2 = this.mOps.get(r0);
        int r3 = r2.mCmd;
        if (r3 != 1) goto L7;
    L14:
        r6.remove(r2.mFragment);
    L15:
        r0 = r0 - 1;
        goto L3
    L7:
        if (r3 == 3) goto L13;
        switch(r3) {
            case 6: goto L13;
            case 7: goto L14;
            case 8: goto L12;
            case 9: goto L11;
            case 10: goto L10;
            default: goto L15;
        };
    L10:
        r2.mCurrentMaxState = r2.mOldMaxState;
        goto L15
    L11:
        r7 = r2.mFragment;
        goto L15
    L12:
        r7 = null;
    L13:
        r6.add(r2.mFragment);
        goto L15
    L16:
        return r7;
    }

    boolean isPostponed() {
        int r1 = 0;
    L4:
        if (r1 >= this.mOps.size()) goto L10;
        if (isFragmentPostponed(this.mOps.get(r1)) == true) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    void setOnStartPostponedListener(Fragment.OnStartEnterTransitionListener r4) {
        int r0 = 0;
    L4:
        if (r0 >= this.mOps.size()) goto L9;
        FragmentTransaction.Op r1 = this.mOps.get(r0);
        if (isFragmentPostponed(r1) == false) goto L8;
        r1.mFragment.setOnStartEnterTransitionListener(r4);
    L8:
        r0 = r0 + 1;
        goto L4
    }

    private static boolean isFragmentPostponed(FragmentTransaction.Op r1) {
        Fragment r2 = r1.mFragment;
        if (r2 != null) goto L5;
    L15:
        return false;
    L5:
        if (r2.mAdded == false) goto L15;
        if (r2.mView == null) goto L15;
        if (r2.mDetached == true) goto L15;
        if (r2.mHidden == true) goto L15;
        if (r2.isPostponed() == false) goto L15;
        return true;
    }

    @Override // androidx.fragment.app.FragmentManager.BackStackEntry
    public String getName() {
        return this.mName;
    }

    @Override // androidx.fragment.app.FragmentTransaction
    public boolean isEmpty() {
        return this.mOps.isEmpty();
    }
}
