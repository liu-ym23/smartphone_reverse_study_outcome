package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
final class BackStackRecordState implements Parcelable {
    public static final Parcelable.Creator<BackStackRecordState> CREATOR = null;
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

    static {
        CREATOR = new AnonymousClass1();
    }

    BackStackRecordState(Parcel r2) {
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

    BackStackRecordState(BackStackRecord r8) {
        int r0 = r8.mOps.size();
        this.mOps = new int[r0 * 6];
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
        Fragment r6 = r3.mFragment;
        if (r6 == null) goto L9;
        String r7 = r6.mWho;
    L10:
        r4.add(r7);
        int[] r9 = this.mOps;
        int r10 = r5 + 1;
        r9[r5] = r3.mFromExpandedOp ? 1 : 0;
        int r11 = r10 + 1;
        r9[r10] = r3.mEnterAnim;
        int r12 = r11 + 1;
        r9[r11] = r3.mExitAnim;
        int r13 = r12 + 1;
        r9[r12] = r3.mPopEnterAnim;
        r9[r13] = r3.mPopExitAnim;
        this.mOldMaxLifecycleStates[r1] = r3.mOldMaxState.ordinal();
        this.mCurrentMaxLifecycleStates[r1] = r3.mCurrentMaxState.ordinal();
        r1 = r1 + 1;
        r2 = r13 + 1;
        goto L5
    L9:
        r7 = null;
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

    private void fillInBackStackRecord(@NonNull BackStackRecord r10) {
        int r1 = 0;
        int r2 = 0;
    L3:
        boolean r4 = true;
        if (r1 >= this.mOps.length) goto L13;
        FragmentTransaction.Op r3 = new FragmentTransaction.Op();
        int r6 = r1 + 1;
        r3.mCmd = this.mOps[r1];
        if (FragmentManager.isLoggingEnabled(2) == false) goto L8;
        Log.v("FragmentManager", "Instantiate " + r10 + " op #" + r2 + " base fragment #" + this.mOps[r6]);
    L8:
        r3.mOldMaxState = Lifecycle.State.values()[this.mOldMaxLifecycleStates[r2]];
        r3.mCurrentMaxState = Lifecycle.State.values()[this.mCurrentMaxLifecycleStates[r2]];
        int[] r5 = this.mOps;
        int r7 = r6 + 1;
        if (r5[r6] != 0) goto L12;
        r4 = false;
    L12:
        r3.mFromExpandedOp = r4;
        int r8 = r7 + 1;
        int r9 = r5[r7];
        r3.mEnterAnim = r9;
        int r11 = r8 + 1;
        int r12 = r5[r8];
        r3.mExitAnim = r12;
        int r13 = r11 + 1;
        int r14 = r5[r11];
        r3.mPopEnterAnim = r14;
        int r15 = r5[r13];
        r3.mPopExitAnim = r15;
        r10.mEnterAnim = r9;
        r10.mExitAnim = r12;
        r10.mPopEnterAnim = r14;
        r10.mPopExitAnim = r15;
        r10.addOp(r3);
        r2 = r2 + 1;
        r1 = r13 + 1;
        goto L3
    L13:
        r10.mTransition = this.mTransition;
        r10.mName = this.mName;
        r10.mAddToBackStack = true;
        r10.mBreadCrumbTitleRes = this.mBreadCrumbTitleRes;
        r10.mBreadCrumbTitleText = this.mBreadCrumbTitleText;
        r10.mBreadCrumbShortTitleRes = this.mBreadCrumbShortTitleRes;
        r10.mBreadCrumbShortTitleText = this.mBreadCrumbShortTitleText;
        r10.mSharedElementSourceNames = this.mSharedElementSourceNames;
        r10.mSharedElementTargetNames = this.mSharedElementTargetNames;
        r10.mReorderingAllowed = this.mReorderingAllowed;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public BackStackRecord instantiate(@NonNull FragmentManager r5) {
        BackStackRecord r0 = new BackStackRecord(r5);
        fillInBackStackRecord(r0);
        r0.mIndex = this.mIndex;
        int r1 = 0;
    L4:
        if (r1 >= this.mFragmentWhos.size()) goto L9;
        String r2 = this.mFragmentWhos.get(r1);
        if (r2 == null) goto L8;
        FragmentTransaction.Op r3 = r0.mOps.get(r1);
        r3.mFragment = r5.findActiveFragment(r2);
    L8:
        r1 = r1 + 1;
        goto L4
    L9:
        r0.bumpBackStackNesting(1);
        return r0;
    }

    @NonNull
    public BackStackRecord instantiate(@NonNull FragmentManager r4, @NonNull Map<String, Fragment> r5) {
        BackStackRecord r0 = new BackStackRecord(r4);
        fillInBackStackRecord(r0);
        int r6 = 0;
    L4:
        if (r6 >= this.mFragmentWhos.size()) goto L13;
        String r1 = this.mFragmentWhos.get(r6);
        if (r1 == null) goto L12;
        Fragment r2 = r5.get(r1);
        if (r2 == null) goto L11;
        r0.mOps.get(r6).mFragment = r2;
        goto L12
    L11:
        throw new IllegalStateException("Restoring FragmentTransaction " + this.mName + " failed due to missing saved state for Fragment (" + r1 + ")");
    L12:
        r6 = r6 + 1;
        goto L4
    L13:
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
}
