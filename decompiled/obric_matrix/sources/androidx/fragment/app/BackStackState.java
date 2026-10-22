package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = null;
    final List<String> mFragments;
    final List<BackStackRecordState> mTransactions;

    static {
        CREATOR = new AnonymousClass1();
    }

    BackStackState(@NonNull Parcel r2) {
        this.mFragments = r2.createStringArrayList();
        this.mTransactions = r2.createTypedArrayList(BackStackRecordState.CREATOR);
    }

    BackStackState(List<String> r1, List<BackStackRecordState> r2) {
        this.mFragments = r1;
        this.mTransactions = r2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    List<BackStackRecord> instantiate(@NonNull FragmentManager r6, Map<String, Fragment> r7) {
        HashMap r0 = new HashMap(this.mFragments.size());
        Iterator<String> r1 = this.mFragments.iterator();
    L4:
        if (r1.hasNext() == false) goto L11;
        String r2 = r1.next();
        Fragment r3 = r7.get(r2);
        if (r3 != null) goto L7;
        FragmentState r4 = r6.getFragmentStore().setSavedState(r2, null);
        if (r4 == null) goto L4;
        Fragment r5 = r4.instantiate(r6.getFragmentFactory(), r6.getHost().getContext().getClassLoader());
        r0.put(r5.mWho, r5);
        goto L4
    L7:
        r0.put(r3.mWho, r3);
        goto L4
    L11:
        ArrayList r8 = new ArrayList();
        Iterator<BackStackRecordState> r9 = this.mTransactions.iterator();
    L13:
        if (r9.hasNext() == false) goto L15;
        r8.add(r9.next().instantiate(r6, r0));
        goto L13
    L15:
        return r8;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel r1, int r2) {
        r1.writeStringList(this.mFragments);
        r1.writeTypedList(this.mTransactions);
    }
}
