package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
class VersionedParcelParcel extends VersionedParcel {
    private static final boolean DEBUG = false;
    private static final String TAG = "VersionedParcelParcel";
    private int mCurrentField;
    private final int mEnd;
    private int mFieldId;
    private int mNextRead;
    private final int mOffset;
    private final Parcel mParcel;
    private final SparseIntArray mPositionLookup;
    private final String mPrefix;

    VersionedParcelParcel(Parcel r9) {
        this(r9, r9.dataPosition(), r9.dataSize(), "", new ArrayMap(), new ArrayMap(), new ArrayMap());
    }

    private VersionedParcelParcel(Parcel r1, int r2, int r3, String r4, ArrayMap<String, Method> r5, ArrayMap<String, Method> r6, ArrayMap<String, Class> r7) {
        super(r5, r6, r7);
        this.mPositionLookup = new SparseIntArray();
        this.mCurrentField = -1;
        this.mNextRead = 0;
        this.mFieldId = -1;
        this.mParcel = r1;
        this.mOffset = r2;
        this.mEnd = r3;
        this.mNextRead = r2;
        this.mPrefix = r4;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void closeField() {
        int r0 = this.mCurrentField;
        if (r0 < 0) goto L6;
        int r1 = this.mPositionLookup.get(r0);
        int r2 = this.mParcel.dataPosition();
        int r3 = r2 - r1;
        this.mParcel.setDataPosition(r1);
        this.mParcel.writeInt(r3);
        this.mParcel.setDataPosition(r2);
        return;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected VersionedParcel createSubParcel() {
        Parcel r1 = this.mParcel;
        int r2 = r1.dataPosition();
        int r0 = this.mNextRead;
        if (r0 != this.mOffset) goto L6;
        r0 = this.mEnd;
    L6:
        return new VersionedParcelParcel(r1, r2, r0, this.mPrefix + "  ", this.mReadCache, this.mWriteCache, this.mParcelizerCache);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean readBoolean() {
        if (this.mParcel.readInt() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public Bundle readBundle() {
        return this.mParcel.readBundle(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public byte[] readByteArray() {
        int r0 = this.mParcel.readInt();
        if (r0 >= 0) goto L6;
        return null;
    L6:
        byte[] r1 = new byte[r0];
        this.mParcel.readByteArray(r1);
        return r1;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected CharSequence readCharSequence() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.mParcel);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public double readDouble() {
        return this.mParcel.readDouble();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean readField(int r5) {
    L3:
        if (this.mNextRead >= this.mEnd) goto L12;
        int r0 = this.mFieldId;
        if (r0 == r5) goto L6;
        if (String.valueOf(r0).compareTo(String.valueOf(r5)) > 0) goto L9;
        this.mParcel.setDataPosition(this.mNextRead);
        int r1 = this.mParcel.readInt();
        this.mFieldId = this.mParcel.readInt();
        this.mNextRead += r1;
        goto L3
    L9:
        return false;
    L6:
        return true;
    L12:
        if (this.mFieldId != r5) goto L15;
        return true;
    L15:
        return false;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public float readFloat() {
        return this.mParcel.readFloat();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public int readInt() {
        return this.mParcel.readInt();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public long readLong() {
        return this.mParcel.readLong();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public <T extends Parcelable> T readParcelable() {
        return (T) this.mParcel.readParcelable(getClass().getClassLoader());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public String readString() {
        return this.mParcel.readString();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public IBinder readStrongBinder() {
        return this.mParcel.readStrongBinder();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void setOutputField(int r3) {
        closeField();
        this.mCurrentField = r3;
        this.mPositionLookup.put(r3, this.mParcel.dataPosition());
        writeInt(0);
        writeInt(r3);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBoolean(boolean r1) {
        this.mParcel.writeInt(r1 ? 1 : 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBundle(Bundle r1) {
        this.mParcel.writeBundle(r1);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] r3) {
        if (r3 == null) goto L4;
        this.mParcel.writeInt(r3.length);
        this.mParcel.writeByteArray(r3);
        return;
    L4:
        this.mParcel.writeInt(-1);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] r3, int r4, int r5) {
        if (r3 == null) goto L4;
        this.mParcel.writeInt(r3.length);
        this.mParcel.writeByteArray(r3, r4, r5);
        return;
    L4:
        this.mParcel.writeInt(-1);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected void writeCharSequence(CharSequence r2) {
        TextUtils.writeToParcel(r2, this.mParcel, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeDouble(double r1) {
        this.mParcel.writeDouble(r1);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeFloat(float r1) {
        this.mParcel.writeFloat(r1);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeInt(int r1) {
        this.mParcel.writeInt(r1);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeLong(long r1) {
        this.mParcel.writeLong(r1);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeParcelable(Parcelable r2) {
        this.mParcel.writeParcelable(r2, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeString(String r1) {
        this.mParcel.writeString(r1);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongBinder(IBinder r1) {
        this.mParcel.writeStrongBinder(r1);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongInterface(IInterface r1) {
        this.mParcel.writeStrongInterface(r1);
    }
}
