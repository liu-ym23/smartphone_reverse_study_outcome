package androidx.slice;

import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: classes.dex */
public final class SliceParcelizer {
    public SliceParcelizer() {
    }

    public static Slice read(VersionedParcel r3) {
        Slice r0 = new Slice();
        r0.mSpec = (SliceSpec) r3.readVersionedParcelable(r0.mSpec, 1);
        r0.mItems = (SliceItem[]) r3.readArray(r0.mItems, 2);
        r0.mHints = (String[]) r3.readArray(r0.mHints, 3);
        r0.mUri = r3.readString(r0.mUri, 4);
        return r0;
    }

    public static void write(Slice r2, VersionedParcel r3) {
        r3.setSerializationFlags(true, false);
        r3.writeVersionedParcelable(r2.mSpec, 1);
        r3.writeArray(r2.mItems, 2);
        r3.writeArray(r2.mHints, 3);
        r3.writeString(r2.mUri, 4);
    }
}
