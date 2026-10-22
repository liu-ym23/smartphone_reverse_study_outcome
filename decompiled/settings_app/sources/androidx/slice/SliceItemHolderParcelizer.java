package androidx.slice;

import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: classes.dex */
public final class SliceItemHolderParcelizer {
    public SliceItemHolderParcelizer() {
    }

    public static SliceItemHolder read(VersionedParcel r4) {
        SliceItemHolder r0 = new SliceItemHolder();
        r0.mVersionedParcelable = r4.readVersionedParcelable(r0.mVersionedParcelable, 1);
        r0.mParcelable = r4.readParcelable(r0.mParcelable, 2);
        r0.mStr = r4.readString(r0.mStr, 3);
        r0.mInt = r4.readInt(r0.mInt, 4);
        r0.mLong = r4.readLong(r0.mLong, 5);
        return r0;
    }

    public static void write(SliceItemHolder r2, VersionedParcel r3) {
        r3.setSerializationFlags(true, true);
        r3.writeVersionedParcelable(r2.mVersionedParcelable, 1);
        r3.writeParcelable(r2.mParcelable, 2);
        r3.writeString(r2.mStr, 3);
        r3.writeInt(r2.mInt, 4);
        r3.writeLong(r2.mLong, 5);
    }
}
