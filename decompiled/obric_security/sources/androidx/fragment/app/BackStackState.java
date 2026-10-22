package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = null;
    private static final String TAG = "FragmentManager";
    final int mBreadCrumbShortTitleRes;
    final CharSequence mBreadCrumbShortTitleText;
    final int mBreadCrumbTitleRes;
    final CharSequence mBreadCrumbTitleText;
    final int[] mCurrentMaxLifecycleStates;
    final ArrayList<String> mFragmentWhos;
    final int mIndex;
    final String mName;
    final int[] mOldMaxLifecycleStates;
    final int[] mOps;
    final boolean mReorderingAllowed;
    final ArrayList<String> mSharedElementSourceNames;
    final ArrayList<String> mSharedElementTargetNames;
    final int mTransition;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BackStackState(BackStackRecord r8) {
        int r0 = r8.mOps.size();
        this.mOps = new int[r0 * 5];
        if (r8.mAddToBackStack == false) goto L14;
        this.mFragmentWhos = new ArrayList(r0);
        this.mOldMaxLifecycleStates = new int[r0];
        this.mCurrentMaxLifecycleStates = new int[r0];
        int r1 = 0;
        int r2 = 0;
    L5:
        if (r1 >= r0) goto L11;
        FragmentTransaction.Op r3 = r8.mOps.get(r1);
        int r5 = r2 + 1;
        this.mOps[r2] = r3.mCmd;
        ArrayList<String> r4 = this.mFragmentWhos;
        if (r3.mFragment == null) goto L9;
        String r6 = r3.mFragment.mWho;
    L10:
        r4.add(r6);
        int r7 = r5 + 1;
        this.mOps[r5] = r3.mEnterAnim;
        int r9 = r7 + 1;
        this.mOps[r7] = r3.mExitAnim;
        int r10 = r9 + 1;
        this.mOps[r9] = r3.mPopEnterAnim;
        this.mOps[r10] = r3.mPopExitAnim;
        this.mOldMaxLifecycleStates[r1] = r3.mOldMaxState.ordinal();
        this.mCurrentMaxLifecycleStates[r1] = r3.mCurrentMaxState.ordinal();
        r1 = r1 + 1;
        r2 = r10 + 1;
        goto L5
    L9:
        r6 = null;
        goto L10
    L11:
        this.mTransition = r8.mTransition;
        this.mName = r8.mName;
        this.mIndex = r8.mIndex;
        this.mBreadCrumbTitleRes = r8.mBreadCrumbTitleRes;
        this.mBreadCrumbTitleText = r8.mBreadCrumbTitleText;
        this.mBreadCrumbShortTitleRes = r8.mBreadCrumbShortTitleRes;
        this.mBreadCrumbShortTitleText = r8.mBreadCrumbShortTitleText;
        this.mSharedElementSourceNames = r8.mSharedElementSourceNames;
        this.mSharedElementTargetNames = r8.mSharedElementTargetNames;
        this.mReorderingAllowed = r8.mReorderingAllowed;
        return;
    L14:
        throw new IllegalStateException("Not on back stack");
    }

    public BackStackState(Parcel r2) {
        this.mOps = r2.createIntArray();
        this.mFragmentWhos = r2.createStringArrayList();
        this.mOldMaxLifecycleStates = r2.createIntArray();
        this.mCurrentMaxLifecycleStates = r2.createIntArray();
        this.mTransition = r2.readInt();
        this.mName = r2.readString();
        this.mIndex = r2.readInt();
        this.mBreadCrumbTitleRes = r2.readInt();
        this.mBreadCrumbTitleText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r2);
        this.mBreadCrumbShortTitleRes = r2.readInt();
        this.mBreadCrumbShortTitleText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(r2);
        this.mSharedElementSourceNames = r2.createStringArrayList();
        this.mSharedElementTargetNames = r2.createStringArrayList();
        if (r2.readInt() == 0) goto L5;
        boolean r3 = true;
    L6:
        this.mReorderingAllowed = r3;
        return;
    L5:
        r3 = false;
        goto L6
    }

    public BackStackRecord instantiate(FragmentManager r7) {
        BackStackRecord r0 = new BackStackRecord(r7);
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= this.mOps.length) goto L13;
        FragmentTransaction.Op r3 = new FragmentTransaction.Op();
        int r5 = r1 + 1;
        r3.mCmd = this.mOps[r1];
        if (FragmentManager.isLoggingEnabled(2) == false) goto L8;
        Log.v(TAG, "Instantiate " + r0 + " op #" + r2 + " base fragment #" + this.mOps[r5]);
    L8:
        String r4 = this.mFragmentWhos.get(r2);
        if (r4 == null) goto L11;
        r3.mFragment = r7.findActiveFragment(r4);
    L12:
        r3.mOldMaxState = Lifecycle.State.values()[this.mOldMaxLifecycleStates[r2]];
        r3.mCurrentMaxState = Lifecycle.State.values()[this.mCurrentMaxLifecycleStates[r2]];
        int r6 = r5 + 1;
        r3.mEnterAnim = this.mOps[r5];
        int r8 = r6 + 1;
        r3.mExitAnim = this.mOps[r6];
        int r9 = r8 + 1;
        r3.mPopEnterAnim = this.mOps[r8];
        r3.mPopExitAnim = this.mOps[r9];
        r0.mEnterAnim = r3.mEnterAnim;
        r0.mExitAnim = r3.mExitAnim;
        r0.mPopEnterAnim = r3.mPopEnterAnim;
        r0.mPopExitAnim = r3.mPopExitAnim;
        r0.addOp(r3);
        r2 = r2 + 1;
        r1 = r9 + 1;
        goto L4
    L11:
        r3.mFragment = null;
        goto L12
    L13:
        r0.mTransition = this.mTransition;
        r0.mName = this.mName;
        r0.mIndex = this.mIndex;
        r0.mAddToBackStack = true;
        r0.mBreadCrumbTitleRes = this.mBreadCrumbTitleRes;
        r0.mBreadCrumbTitleText = this.mBreadCrumbTitleText;
        r0.mBreadCrumbShortTitleRes = this.mBreadCrumbShortTitleRes;
        r0.mBreadCrumbShortTitleText = this.mBreadCrumbShortTitleText;
        r0.mSharedElementSourceNames = this.mSharedElementSourceNames;
        r0.mSharedElementTargetNames = this.mSharedElementTargetNames;
        r0.mReorderingAllowed = this.mReorderingAllowed;
        r0.bumpBackStackNesting(1);
        return r0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeIntArray(this.mOps);
        r2.writeStringList(this.mFragmentWhos);
        r2.writeIntArray(this.mOldMaxLifecycleStates);
        r2.writeIntArray(this.mCurrentMaxLifecycleStates);
        r2.writeInt(this.mTransition);
        r2.writeString(this.mName);
        r2.writeInt(this.mIndex);
        r2.writeInt(this.mBreadCrumbTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbTitleText, r2, 0);
        r2.writeInt(this.mBreadCrumbShortTitleRes);
        TextUtils.writeToParcel(this.mBreadCrumbShortTitleText, r2, 0);
        r2.writeStringList(this.mSharedElementSourceNames);
        r2.writeStringList(this.mSharedElementTargetNames);
        r2.writeInt(this.mReorderingAllowed ? 1 : 0);
    }

    static {
        CREATOR = new AnonymousClass1();
    }
}
