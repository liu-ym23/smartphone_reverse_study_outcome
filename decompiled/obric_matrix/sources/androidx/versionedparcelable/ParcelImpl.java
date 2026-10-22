package androidx.versionedparcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = null;
    private final VersionedParcelable mParcel;

    static {
        CREATOR = new AnonymousClass1();
    }

    protected ParcelImpl(Parcel r2) {
        this.mParcel = new VersionedParcelParcel(r2).readVersionedParcelable();
    }

    public ParcelImpl(VersionedParcelable r1) {
        this.mParcel = r1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public <T extends VersionedParcelable> T getVersionedParcel() {
        return (T) this.mParcel;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        new VersionedParcelParcel(r1).writeVersionedParcelable(this.mParcel);
    }
}
