package androidx.slice;

import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: classes.dex */
public final class SliceItemParcelizer {
    public SliceItemParcelizer() {
    }

    public static SliceItem read(VersionedParcel r3) {
        SliceItem r0 = new SliceItem();
        r0.mHints = (String[]) r3.readArray(r0.mHints, 1);
        r0.mFormat = r3.readString(r0.mFormat, 2);
        r0.mSubType = r3.readString(r0.mSubType, 3);
        r0.mHolder = (SliceItemHolder) r3.readVersionedParcelable(r0.mHolder, 4);
        r0.onPostParceling();
        return r0;
    }

    public static void write(SliceItem r2, VersionedParcel r3) {
        r3.setSerializationFlags(true, true);
        r2.onPreParceling(r3.isStream());
        r3.writeArray(r2.mHints, 1);
        r3.writeString(r2.mFormat, 2);
        r3.writeString(r2.mSubType, 3);
        r3.writeVersionedParcelable(r2.mHolder, 4);
    }
}
