package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
final class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = null;
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
    final int mTransitionStyle;

    static {
        CREATOR = new AnonymousClass1();
    }

    public BackStackState(BackStackRecord r9) {
        int r0 = r9.mOps.size();
        this.mOps = new int[r0 * 5];
        if (r9.mAddToBackStack == false) goto L14;
        this.mFragmentWhos = new ArrayList(r0);
        this.mOldMaxLifecycleStates = new int[r0];
        this.mCurrentMaxLifecycleStates = new int[r0];
        int r1 = 0;
        int r2 = 0;
    L5:
        if (r1 >= r0) goto L11;
        FragmentTransaction.Op r3 = r9.mOps.get(r1);
        int r5 = r2 + 1;
        this.mOps[r2] = r3.mCmd;
        ArrayList<String> r4 = this.mFragmentWhos;
        Fragment r6 = r3.mFragment;
        if (r6 == null) goto L9;
        String r7 = r6.mWho;
    L10:
        r4.add(r7);
        int[] r8 = this.mOps;
        r8[r5] = r3.mEnterAnim;
        r8[r2 + 2] = r3.mExitAnim;
        int r10 = r2 + 4;
        r8[r2 + 3] = r3.mPopEnterAnim;
        r2 = r2 + 5;
        r8[r10] = r3.mPopExitAnim;
        this.mOldMaxLifecycleStates[r1] = r3.mOldMaxState.ordinal();
        this.mCurrentMaxLifecycleStates[r1] = r3.mCurrentMaxState.ordinal();
        r1 = r1 + 1;
        goto L5
    L9:
        r7 = null;
        goto L10
    L11:
        this.mTransition = r9.mTransition;
        this.mTransitionStyle = r9.mTransitionStyle;
        this.mName = r9.mName;
        this.mIndex = r9.mIndex;
        this.mBreadCrumbTitleRes = r9.mBreadCrumbTitleRes;
        this.mBreadCrumbTitleText = r9.mBreadCrumbTitleText;
        this.mBreadCrumbShortTitleRes = r9.mBreadCrumbShortTitleRes;
        this.mBreadCrumbShortTitleText = r9.mBreadCrumbShortTitleText;
        this.mSharedElementSourceNames = r9.mSharedElementSourceNames;
        this.mSharedElementTargetNames = r9.mSharedElementTargetNames;
        this.mReorderingAllowed = r9.mReorderingAllowed;
        return;
    L14:
        throw new IllegalStateException("Not on back stack");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public BackStackRecord instantiate(FragmentManagerImpl r10) {
        BackStackRecord r0 = new BackStackRecord(r10);
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= this.mOps.length) goto L13;
        FragmentTransaction.Op r3 = new FragmentTransaction.Op();
        int r5 = r1 + 1;
        r3.mCmd = this.mOps[r1];
        if (FragmentManagerImpl.DEBUG == false) goto L8;
        Log.v("FragmentManager", "Instantiate " + r0 + " op #" + r2 + " base fragment #" + this.mOps[r5]);
    L8:
        String r4 = this.mFragmentWhos.get(r2);
        if (r4 == null) goto L11;
        r3.mFragment = r10.mActive.get(r4);
    L12:
        r3.mOldMaxState = Lifecycle.State.values()[this.mOldMaxLifecycleStates[r2]];
        r3.mCurrentMaxState = Lifecycle.State.values()[this.mCurrentMaxLifecycleStates[r2]];
        int[] r6 = this.mOps;
        int r7 = r6[r5];
        r3.mEnterAnim = r7;
        int r8 = r6[r1 + 2];
        r3.mExitAnim = r8;
        int r9 = r1 + 4;
        int r11 = r6[r1 + 3];
        r3.mPopEnterAnim = r11;
        r1 = r1 + 5;
        int r12 = r6[r9];
        r3.mPopExitAnim = r12;
        r0.mEnterAnim = r7;
        r0.mExitAnim = r8;
        r0.mPopEnterAnim = r11;
        r0.mPopExitAnim = r12;
        r0.addOp(r3);
        r2 = r2 + 1;
        goto L4
    L11:
        r3.mFragment = null;
        goto L12
    L13:
        r0.mTransition = this.mTransition;
        r0.mTransitionStyle = this.mTransitionStyle;
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
        r2.writeInt(this.mTransitionStyle);
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

    public BackStackState(Parcel r3) {
        this.mOps = r3.createIntArray();
        this.mFragmentWhos = r3.createStringArrayList();
        this.mOldMaxLifecycleStates = r3.createIntArray();
        this.mCurrentMaxLifecycleStates = r3.createIntArray();
        this.mTransition = r3.readInt();
        this.mTransitionStyle = r3.readInt();
        this.mName = r3.readString();
        this.mIndex = r3.readInt();
        this.mBreadCrumbTitleRes = r3.readInt();
        Parcelable.Creator r0 = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.mBreadCrumbTitleText = (CharSequence) r0.createFromParcel(r3);
        this.mBreadCrumbShortTitleRes = r3.readInt();
        this.mBreadCrumbShortTitleText = (CharSequence) r0.createFromParcel(r3);
        this.mSharedElementSourceNames = r3.createStringArrayList();
        this.mSharedElementTargetNames = r3.createStringArrayList();
        if (r3.readInt() == 0) goto L5;
        boolean r4 = true;
    L6:
        this.mReorderingAllowed = r4;
        return;
    L5:
        r4 = false;
        goto L6
    }
}
