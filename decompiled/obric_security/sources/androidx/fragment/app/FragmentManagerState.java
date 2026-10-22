package androidx.fragment.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = null;
    ArrayList<FragmentState> mActive;
    ArrayList<String> mAdded;
    BackStackState[] mBackStack;
    int mBackStackIndex;
    ArrayList<FragmentManager.LaunchedFragmentInfo> mLaunchedFragments;
    String mPrimaryNavActiveWho;
    ArrayList<String> mResultKeys;
    ArrayList<Bundle> mResults;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public FragmentManagerState() {
        this.mPrimaryNavActiveWho = null;
        this.mResultKeys = new ArrayList();
        this.mResults = new ArrayList();
    }

    public FragmentManagerState(Parcel r2) {
        this.mPrimaryNavActiveWho = null;
        this.mResultKeys = new ArrayList();
        this.mResults = new ArrayList();
        this.mActive = r2.createTypedArrayList(FragmentState.CREATOR);
        this.mAdded = r2.createStringArrayList();
        this.mBackStack = (BackStackState[]) r2.createTypedArray(BackStackState.CREATOR);
        this.mBackStackIndex = r2.readInt();
        this.mPrimaryNavActiveWho = r2.readString();
        this.mResultKeys = r2.createStringArrayList();
        this.mResults = r2.createTypedArrayList(Bundle.CREATOR);
        this.mLaunchedFragments = r2.createTypedArrayList(FragmentManager.LaunchedFragmentInfo.CREATOR);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeTypedList(this.mActive);
        r2.writeStringList(this.mAdded);
        r2.writeTypedArray(this.mBackStack, r3);
        r2.writeInt(this.mBackStackIndex);
        r2.writeString(this.mPrimaryNavActiveWho);
        r2.writeStringList(this.mResultKeys);
        r2.writeTypedList(this.mResults);
        r2.writeTypedList(this.mLaunchedFragments);
    }

    static {
        CREATOR = new AnonymousClass1();
    }
}
