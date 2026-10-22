package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = null;
    ArrayList<FragmentState> mActive;
    ArrayList<String> mAdded;
    BackStackState[] mBackStack;
    int mNextFragmentIndex;
    String mPrimaryNavActiveWho;

    static {
        CREATOR = new AnonymousClass1();
    }

    public FragmentManagerState() {
        this.mPrimaryNavActiveWho = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeTypedList(this.mActive);
        r2.writeStringList(this.mAdded);
        r2.writeTypedArray(this.mBackStack, r3);
        r2.writeString(this.mPrimaryNavActiveWho);
        r2.writeInt(this.mNextFragmentIndex);
    }

    public FragmentManagerState(Parcel r2) {
        this.mPrimaryNavActiveWho = null;
        this.mActive = r2.createTypedArrayList(FragmentState.CREATOR);
        this.mAdded = r2.createStringArrayList();
        this.mBackStack = (BackStackState[]) r2.createTypedArray(BackStackState.CREATOR);
        this.mPrimaryNavActiveWho = r2.readString();
        this.mNextFragmentIndex = r2.readInt();
    }
}
