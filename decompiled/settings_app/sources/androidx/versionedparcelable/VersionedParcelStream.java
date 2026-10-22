package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcelable;
import androidx.collection.ArrayMap;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class VersionedParcelStream extends VersionedParcel {
    private static final int TYPE_BOOLEAN = 5;
    private static final int TYPE_BOOLEAN_ARRAY = 6;
    private static final int TYPE_DOUBLE = 7;
    private static final int TYPE_DOUBLE_ARRAY = 8;
    private static final int TYPE_FLOAT = 13;
    private static final int TYPE_FLOAT_ARRAY = 14;
    private static final int TYPE_INT = 9;
    private static final int TYPE_INT_ARRAY = 10;
    private static final int TYPE_LONG = 11;
    private static final int TYPE_LONG_ARRAY = 12;
    private static final int TYPE_NULL = 0;
    private static final int TYPE_STRING = 3;
    private static final int TYPE_STRING_ARRAY = 4;
    private static final int TYPE_SUB_BUNDLE = 1;
    private static final int TYPE_SUB_PERSISTABLE_BUNDLE = 2;
    private static final Charset UTF_16 = null;
    int mCount;
    private DataInputStream mCurrentInput;
    private DataOutputStream mCurrentOutput;
    private FieldBuffer mFieldBuffer;
    private int mFieldId;
    int mFieldSize;
    private boolean mIgnoreParcelables;
    private final DataInputStream mMasterInput;
    private final DataOutputStream mMasterOutput;

    private static class FieldBuffer {
        final DataOutputStream mDataStream;
        private final int mFieldId;
        final ByteArrayOutputStream mOutput;
        private final DataOutputStream mTarget;

        FieldBuffer(int r3, DataOutputStream r4) {
            ByteArrayOutputStream r0 = new ByteArrayOutputStream();
            this.mOutput = r0;
            this.mDataStream = new DataOutputStream(r0);
            this.mFieldId = r3;
            this.mTarget = r4;
        }

        void flushField() throws IOException {
            this.mDataStream.flush();
            int r0 = this.mOutput.size();
            int r1 = this.mFieldId << 16;
            if (r0 < 65535) goto L5;
            int r3 = 65535;
        L6:
            this.mTarget.writeInt(r1 | r3);
            if (r0 < 65535) goto L9;
            this.mTarget.writeInt(r0);
        L9:
            this.mOutput.writeTo(this.mTarget);
            return;
        L5:
            r3 = r0;
            goto L6
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean isStream() {
        return true;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected CharSequence readCharSequence() {
        return null;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public <T extends Parcelable> T readParcelable() {
        return null;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public IBinder readStrongBinder() {
        return null;
    }

    static {
        UTF_16 = Charset.forName("UTF-16");
    }

    public VersionedParcelStream(InputStream r7, OutputStream r8) {
        this(r7, r8, new ArrayMap(), new ArrayMap(), new ArrayMap());
    }

    private VersionedParcelStream(final InputStream r1, OutputStream r2, ArrayMap<String, Method> r3, ArrayMap<String, Method> r4, ArrayMap<String, Class> r5) {
        super(r3, r4, r5);
        this.mCount = 0;
        this.mFieldId = -1;
        this.mFieldSize = -1;
        DataOutputStream r6 = null;
        if (r1 == null) goto L5;
        DataInputStream r7 = new DataInputStream(new AnonymousClass1(this, r1));
    L6:
        this.mMasterInput = r7;
        if (r2 == null) goto L9;
        r6 = new DataOutputStream(r2);
    L9:
        this.mMasterOutput = r6;
        this.mCurrentInput = r7;
        this.mCurrentOutput = r6;
        return;
    L5:
        r7 = null;
        goto L6
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void setSerializationFlags(boolean r1, boolean r2) {
        if (r1 == false) goto L6;
        this.mIgnoreParcelables = r2;
        return;
    L6:
        throw new RuntimeException("Serialization of this object is not allowed");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void closeField() {
        FieldBuffer r0 = this.mFieldBuffer;
        if (r0 != null) goto L12;
        return;
    L12:
    L8:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    L5:
        if (r0.mOutput.size() == 0) goto L7;
        this.mFieldBuffer.flushField();     // Catch: IOException -> L8
    L7:
        this.mFieldBuffer = null;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected VersionedParcel createSubParcel() {
        return new VersionedParcelStream(this.mCurrentInput, this.mCurrentOutput, this.mReadCache, this.mWriteCache, this.mParcelizerCache);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean readField(int r5) {
    L19:
        int r1 = this.mFieldId;     // Catch: IOException -> L18
        if (r1 == r5) goto L5;
        if (String.valueOf(r1).compareTo(String.valueOf(r5)) > 0) goto L9;
        int r2 = this.mCount;     // Catch: IOException -> L18
        int r3 = this.mFieldSize;     // Catch: IOException -> L18
        if (r2 >= r3) goto L13;
        this.mMasterInput.skip(r3 - r2);     // Catch: IOException -> L18
    L13:
        this.mFieldSize = -1;     // Catch: IOException -> L18
        int r4 = this.mMasterInput.readInt();     // Catch: IOException -> L18
        this.mCount = 0;     // Catch: IOException -> L18
        int r6 = r4 & 65535;     // Catch: IOException -> L18
        if (r6 != 65535) goto L16;
        r6 = this.mMasterInput.readInt();     // Catch: IOException -> L18
    L16:
        this.mFieldId = (r4 >> 16) & 65535;     // Catch: IOException -> L18
        this.mFieldSize = r6;     // Catch: IOException -> L18
        goto L19
    L9:
        return false;
    L5:
        return true;
    L18:
        return false;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void setOutputField(int r3) {
        closeField();
        FieldBuffer r0 = new FieldBuffer(r3, this.mMasterOutput);
        this.mFieldBuffer = r0;
        this.mCurrentOutput = r0.mDataStream;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] r3) {
        if (r3 == null) goto L4;
        this.mCurrentOutput.writeInt(r3.length);     // Catch: IOException -> L6
        this.mCurrentOutput.write(r3);     // Catch: IOException -> L6
    L9:
        return;
    L4:
        this.mCurrentOutput.writeInt(-1);     // Catch: IOException -> L6
    L6:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] r2, int r3, int r4) {
        if (r2 == null) goto L4;
        this.mCurrentOutput.writeInt(r4);     // Catch: IOException -> L6
        this.mCurrentOutput.write(r2, r3, r4);     // Catch: IOException -> L6
    L9:
        return;
    L4:
        this.mCurrentOutput.writeInt(-1);     // Catch: IOException -> L6
    L6:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected void writeCharSequence(CharSequence r1) {
        if (this.mIgnoreParcelables == false) goto L6;
        return;
    L6:
        throw new RuntimeException("CharSequence cannot be written to an OutputStream");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeInt(int r1) {
        this.mCurrentOutput.writeInt(r1);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeLong(long r1) {
        this.mCurrentOutput.writeLong(r1);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeFloat(float r1) {
        this.mCurrentOutput.writeFloat(r1);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeDouble(double r1) {
        this.mCurrentOutput.writeDouble(r1);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeString(String r3) {
        if (r3 == null) goto L4;
        byte[] r4 = r3.getBytes(UTF_16);     // Catch: IOException -> L6
        this.mCurrentOutput.writeInt(r4.length);     // Catch: IOException -> L6
        this.mCurrentOutput.write(r4);     // Catch: IOException -> L6
    L9:
        return;
    L4:
        this.mCurrentOutput.writeInt(-1);     // Catch: IOException -> L6
    L6:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBoolean(boolean r1) {
        this.mCurrentOutput.writeBoolean(r1);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongBinder(IBinder r1) {
        if (this.mIgnoreParcelables == false) goto L6;
        return;
    L6:
        throw new RuntimeException("Binders cannot be written to an OutputStream");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeParcelable(Parcelable r1) {
        if (this.mIgnoreParcelables == false) goto L6;
        return;
    L6:
        throw new RuntimeException("Parcelables cannot be written to an OutputStream");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongInterface(IInterface r1) {
        if (this.mIgnoreParcelables == false) goto L6;
        return;
    L6:
        throw new RuntimeException("Binders cannot be written to an OutputStream");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public int readInt() {
        return this.mCurrentInput.readInt();
    L4:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public long readLong() {
        return this.mCurrentInput.readLong();
    L4:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public float readFloat() {
        return this.mCurrentInput.readFloat();
    L4:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public double readDouble() {
        return this.mCurrentInput.readDouble();
    L4:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public String readString() {
        int r0 = this.mCurrentInput.readInt();     // Catch: IOException -> L8
        if (r0 <= 0) goto L6;
        byte[] r1 = new byte[r0];     // Catch: IOException -> L8
        this.mCurrentInput.readFully(r1);     // Catch: IOException -> L8
        return new String(r1, UTF_16);
    L6:
        return null;
    L8:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public byte[] readByteArray() {
        int r0 = this.mCurrentInput.readInt();     // Catch: IOException -> L8
        if (r0 <= 0) goto L6;
        byte[] r1 = new byte[r0];     // Catch: IOException -> L8
        this.mCurrentInput.readFully(r1);     // Catch: IOException -> L8
        return r1;
    L6:
        return null;
    L8:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean readBoolean() {
        return this.mCurrentInput.readBoolean();
    L4:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBundle(Bundle r4) {
        if (r4 == null) goto L7;
        Set<String> r0 = r4.keySet();     // Catch: IOException -> L9
        this.mCurrentOutput.writeInt(r0.size());     // Catch: IOException -> L9
        Iterator<String> r1 = r0.iterator();     // Catch: IOException -> L9
    L5:
        if (r1.hasNext() == false) goto L14;
        String r2 = r1.next();     // Catch: IOException -> L9
        writeString(r2);     // Catch: IOException -> L9
        writeObject(r4.get(r2));     // Catch: IOException -> L9
        goto L5
    L14:
        return;
    L7:
        this.mCurrentOutput.writeInt(-1);     // Catch: IOException -> L9
        return;
    L9:
        e = move-exception;
        throw new VersionedParcel.ParcelException(e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public Bundle readBundle() {
        int r0 = readInt();
        if (r0 >= 0) goto L6;
        return null;
    L6:
        Bundle r1 = new Bundle();
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L9;
        String r3 = readString();
        readObject(readInt(), r3, r1);
        r2 = r2 + 1;
        goto L7
    L9:
        return r1;
    }

    private void writeObject(Object r3) {
        if (r3 != null) goto L5;
        writeInt(0);
        return;
    L5:
        if ((r3 instanceof Bundle) == false) goto L8;
        writeInt(1);
        writeBundle((Bundle) r3);
        return;
    L8:
        if ((r3 instanceof String) == false) goto L11;
        writeInt(3);
        writeString((String) r3);
        return;
    L11:
        if ((r3 instanceof String[]) == false) goto L14;
        writeInt(4);
        writeArray((String[]) r3);
        return;
    L14:
        if ((r3 instanceof Boolean) == false) goto L17;
        writeInt(5);
        writeBoolean(((Boolean) r3).booleanValue());
        return;
    L17:
        if ((r3 instanceof boolean[]) == false) goto L20;
        writeInt(6);
        writeBooleanArray((boolean[]) r3);
        return;
    L20:
        if ((r3 instanceof Double) == false) goto L23;
        writeInt(7);
        writeDouble(((Double) r3).doubleValue());
        return;
    L23:
        if ((r3 instanceof double[]) == false) goto L26;
        writeInt(8);
        writeDoubleArray((double[]) r3);
        return;
    L26:
        if ((r3 instanceof Integer) == false) goto L29;
        writeInt(9);
        writeInt(((Integer) r3).intValue());
        return;
    L29:
        if ((r3 instanceof int[]) == false) goto L32;
        writeInt(10);
        writeIntArray((int[]) r3);
        return;
    L32:
        if ((r3 instanceof Long) == false) goto L35;
        writeInt(11);
        writeLong(((Long) r3).longValue());
        return;
    L35:
        if ((r3 instanceof long[]) == false) goto L38;
        writeInt(12);
        writeLongArray((long[]) r3);
        return;
    L38:
        if ((r3 instanceof Float) == false) goto L41;
        writeInt(13);
        writeFloat(((Float) r3).floatValue());
        return;
    L41:
        if ((r3 instanceof float[]) == false) goto L45;
        writeInt(14);
        writeFloatArray((float[]) r3);
        return;
    L45:
        throw new IllegalArgumentException("Unsupported type " + r3.getClass());
    }

    private void readObject(int r1, String r2, Bundle r3) {
        switch(r1) {
            case 0: goto L19;
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            case 11: goto L8;
            case 12: goto L7;
            case 13: goto L6;
            case 14: goto L5;
            default: goto L4;
        };
    L5:
        r3.putFloatArray(r2, readFloatArray());
        return;
    L6:
        r3.putFloat(r2, readFloat());
        return;
    L7:
        r3.putLongArray(r2, readLongArray());
        return;
    L8:
        r3.putLong(r2, readLong());
        return;
    L9:
        r3.putIntArray(r2, readIntArray());
        return;
    L10:
        r3.putInt(r2, readInt());
        return;
    L11:
        r3.putDoubleArray(r2, readDoubleArray());
        return;
    L12:
        r3.putDouble(r2, readDouble());
        return;
    L13:
        r3.putBooleanArray(r2, readBooleanArray());
        return;
    L14:
        r3.putBoolean(r2, readBoolean());
        return;
    L15:
        r3.putStringArray(r2, (String[]) readArray(new String[0]));
        return;
    L16:
        r3.putString(r2, readString());
        return;
    L17:
        r3.putBundle(r2, readBundle());
        return;
    L18:
        r3.putBundle(r2, readBundle());
        return;
    L19:
        r3.putParcelable(r2, null);
        return;
    L4:
        throw new RuntimeException("Unknown type " + r1);
    }
}
