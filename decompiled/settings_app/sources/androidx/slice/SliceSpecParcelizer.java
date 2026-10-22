package androidx.slice;

import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: classes.dex */
public final class SliceSpecParcelizer {
    public SliceSpecParcelizer() {
    }

    public static SliceSpec read(VersionedParcel r3) {
        SliceSpec r0 = new SliceSpec();
        r0.mType = r3.readString(r0.mType, 1);
        r0.mRevision = r3.readInt(r0.mRevision, 2);
        return r0;
    }

    public static void write(SliceSpec r2, VersionedParcel r3) {
        r3.setSerializationFlags(true, false);
        r3.writeString(r2.mType, 1);
        r3.writeInt(r2.mRevision, 2);
    }
}
