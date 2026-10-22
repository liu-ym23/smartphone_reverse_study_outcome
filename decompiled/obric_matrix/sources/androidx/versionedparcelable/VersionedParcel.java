package androidx.versionedparcelable;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.NetworkOnMainThreadException;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseBooleanArray;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class VersionedParcel {
    private static final int EX_BAD_PARCELABLE = -2;
    private static final int EX_ILLEGAL_ARGUMENT = -3;
    private static final int EX_ILLEGAL_STATE = -5;
    private static final int EX_NETWORK_MAIN_THREAD = -6;
    private static final int EX_NULL_POINTER = -4;
    private static final int EX_PARCELABLE = -9;
    private static final int EX_SECURITY = -1;
    private static final int EX_UNSUPPORTED_OPERATION = -7;
    private static final String TAG = "VersionedParcel";
    private static final int TYPE_BINDER = 5;
    private static final int TYPE_FLOAT = 8;
    private static final int TYPE_INTEGER = 7;
    private static final int TYPE_PARCELABLE = 2;
    private static final int TYPE_SERIALIZABLE = 3;
    private static final int TYPE_STRING = 4;
    private static final int TYPE_VERSIONED_PARCELABLE = 1;
    protected final ArrayMap<String, Class> mParcelizerCache;
    protected final ArrayMap<String, Method> mReadCache;
    protected final ArrayMap<String, Method> mWriteCache;

    public static class ParcelException extends RuntimeException {
        public ParcelException(Throwable r1) {
            super(r1);
        }
    }

    public VersionedParcel(ArrayMap<String, Method> r1, ArrayMap<String, Method> r2, ArrayMap<String, Class> r3) {
        this.mReadCache = r1;
        this.mWriteCache = r2;
        this.mParcelizerCache = r3;
    }

    private Exception createException(int r3, String r4) {
        switch(r3) {
            case -9: goto L20;
            case -8: goto L4;
            case -7: goto L18;
            case -6: goto L16;
            case -5: goto L14;
            case -4: goto L12;
            case -3: goto L10;
            case -2: goto L8;
            case -1: goto L6;
            default: goto L4;
        };
    L4:
        return new RuntimeException("Unknown exception code: " + r3 + " msg " + r4);
    L6:
        return new SecurityException(r4);
    L8:
        return new BadParcelableException(r4);
    L10:
        return new IllegalArgumentException(r4);
    L12:
        return new NullPointerException(r4);
    L14:
        return new IllegalStateException(r4);
    L16:
        return new NetworkOnMainThreadException();
    L18:
        return new UnsupportedOperationException(r4);
    L20:
        return (Exception) readParcelable();
    }

    private Class findParcelClass(Class<? extends VersionedParcelable> r5) {
        Class r0 = this.mParcelizerCache.get(r5.getName());
        if (r0 != null) goto L6;
        Class<?> r1 = Class.forName(String.format("%s.%sParcelizer", new Object[]{r5.getPackage().getName(), r5.getSimpleName()}), false, r5.getClassLoader());
        this.mParcelizerCache.put(r5.getName(), r1);
        return r1;
    L6:
        return r0;
    }

    private Method getReadMethod(String r5) {
        Method r1 = this.mReadCache.get(r5);
        if (r1 != null) goto L6;
        System.currentTimeMillis();
        Method r2 = Class.forName(r5, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod("read", new Class[]{VersionedParcel.class});
        this.mReadCache.put(r5, r2);
        return r2;
    L6:
        return r1;
    }

    @NonNull
    protected static Throwable getRootCause(@NonNull Throwable r1) {
    L3:
        if (r1.getCause() == null) goto L5;
        r1 = r1.getCause();
        goto L3
    L5:
        return r1;
    }

    private <T> int getType(T r2) {
        if ((r2 instanceof String) == false) goto L7;
        return 4;
    L7:
        if ((r2 instanceof Parcelable) == false) goto L11;
        return 2;
    L11:
        if ((r2 instanceof VersionedParcelable) == false) goto L15;
        return 1;
    L15:
        if ((r2 instanceof Serializable) == false) goto L19;
        return 3;
    L19:
        if ((r2 instanceof IBinder) == false) goto L23;
        return 5;
    L23:
        if ((r2 instanceof Integer) == false) goto L27;
        return 7;
    L27:
        if ((r2 instanceof Float) == false) goto L31;
        return 8;
    L31:
        throw new IllegalArgumentException(r2.getClass().getName() + " cannot be VersionedParcelled");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Method getWriteMethod(Class r5) {
        Method r0 = this.mWriteCache.get(r5.getName());
        if (r0 != null) goto L6;
        Class r1 = findParcelClass(r5);
        System.currentTimeMillis();
        Method r2 = r1.getDeclaredMethod("write", new Class[]{r5, VersionedParcel.class});
        this.mWriteCache.put(r5.getName(), r2);
        return r2;
    L6:
        return r0;
    }

    private <T, S extends Collection<T>> S readCollection(S r4) {
        int r0 = readInt();
        if (r0 >= 0) goto L5;
        return null;
    L5:
        if (r0 == 0) goto L30;
        int r2 = readInt();
        if (r0 >= 0) goto L10;
        return null;
    L10:
        if (r2 != 1) goto L12;
    L28:
        if (r0 <= 0) goto L30;
        r4.add(readVersionedParcelable());
        r0 = r0 - 1;
        goto L28
    L12:
        if (r2 != 2) goto L14;
    L26:
        if (r0 <= 0) goto L30;
        r4.add(readParcelable());
        r0 = r0 - 1;
        goto L26
    L14:
        if (r2 != 3) goto L16;
    L24:
        if (r0 <= 0) goto L30;
        r4.add(readSerializable());
        r0 = r0 - 1;
        goto L24
    L16:
        if (r2 != 4) goto L18;
    L22:
        if (r0 <= 0) goto L30;
        r4.add(readString());
        r0 = r0 - 1;
        goto L22
    L18:
        if (r2 != 5) goto L30;
    L20:
        if (r0 <= 0) goto L30;
        r4.add(readStrongBinder());
        r0 = r0 - 1;
    L30:
        return r4;
    }

    private Exception readException(int r1, String r2) {
        return createException(r1, r2);
    }

    private int readExceptionCode() {
        return readInt();
    }

    private <T> void writeCollection(Collection<T> r2) {
        if (r2 != null) goto L5;
        writeInt(-1);
        return;
    L5:
        int r0 = r2.size();
        writeInt(r0);
        if (r0 <= 0) goto L38;
        int r1 = getType(r2.iterator().next());
        writeInt(r1);
        switch(r1) {
            case 1: goto L34;
            case 2: goto L30;
            case 3: goto L26;
            case 4: goto L22;
            case 5: goto L18;
            case 6: goto L46;
            case 7: goto L14;
            case 8: goto L10;
            default: goto L46;
        };
    L10:
        Iterator<T> r3 = r2.iterator();
    L12:
        if (r3.hasNext() == false) goto L47;
        writeFloat(((Float) r3.next()).floatValue());
        goto L12
    L47:
        return;
    L14:
        Iterator<T> r4 = r2.iterator();
    L16:
        if (r4.hasNext() == false) goto L48;
        writeInt(((Integer) r4.next()).intValue());
        goto L16
    L48:
        return;
    L18:
        Iterator<T> r5 = r2.iterator();
    L20:
        if (r5.hasNext() == false) goto L49;
        writeStrongBinder((IBinder) r5.next());
        goto L20
    L49:
        return;
    L22:
        Iterator<T> r6 = r2.iterator();
    L24:
        if (r6.hasNext() == false) goto L50;
        writeString((String) r6.next());
        goto L24
    L50:
        return;
    L26:
        Iterator<T> r7 = r2.iterator();
    L28:
        if (r7.hasNext() == false) goto L51;
        writeSerializable((Serializable) r7.next());
        goto L28
    L51:
        return;
    L30:
        Iterator<T> r8 = r2.iterator();
    L32:
        if (r8.hasNext() == false) goto L52;
        writeParcelable((Parcelable) r8.next());
        goto L32
    L52:
        return;
    L34:
        Iterator<T> r9 = r2.iterator();
    L36:
        if (r9.hasNext() == false) goto L53;
        writeVersionedParcelable((VersionedParcelable) r9.next());
        goto L36
    L53:
        return;
    L46:
        return;
    }

    private <T> void writeCollection(Collection<T> r1, int r2) {
        setOutputField(r2);
        writeCollection(r1);
    }

    private void writeSerializable(Serializable r4) {
        if (r4 != null) goto L5;
        writeString(null);
        return;
    L5:
        String r0 = r4.getClass().getName();
        writeString(r0);
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();
        ObjectOutputStream r2 = new ObjectOutputStream(r1);     // Catch: IOException -> L8
        r2.writeObject(r4);     // Catch: IOException -> L8
        r2.close();     // Catch: IOException -> L8
        writeByteArray(r1.toByteArray());     // Catch: IOException -> L8
        return;
    L8:
        e = move-exception;
        throw new RuntimeException("VersionedParcelable encountered IOException writing serializable object (name = " + r0 + ")", e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void writeVersionedParcelableCreator(VersionedParcelable r3) {
        writeString(findParcelClass(r3.getClass()).getName());
        return;
    L5:
        e = move-exception;
        throw new RuntimeException(r3.getClass().getSimpleName() + " does not have a Parcelizer", e);
    }

    protected abstract void closeField();

    protected abstract VersionedParcel createSubParcel();

    public boolean isStream() {
        return false;
    }

    protected <T> T[] readArray(T[] r5) {
        int r0 = readInt();
        if (r0 >= 0) goto L5;
        return null;
    L5:
        ArrayList r2 = new ArrayList(r0);
        if (r0 == 0) goto L32;
        int r3 = readInt();
        if (r0 >= 0) goto L11;
        return null;
    L11:
        if (r3 != 1) goto L13;
    L29:
        if (r0 <= 0) goto L32;
        r2.add(readVersionedParcelable());
        r0 = r0 - 1;
        goto L29
    L13:
        if (r3 != 2) goto L15;
    L27:
        if (r0 <= 0) goto L32;
        r2.add(readParcelable());
        r0 = r0 - 1;
        goto L27
    L15:
        if (r3 != 3) goto L17;
    L25:
        if (r0 <= 0) goto L32;
        r2.add(readSerializable());
        r0 = r0 - 1;
        goto L25
    L17:
        if (r3 != 4) goto L19;
    L23:
        if (r0 <= 0) goto L32;
        r2.add(readString());
        r0 = r0 - 1;
        goto L23
    L19:
        if (r3 != 5) goto L32;
    L21:
        if (r0 <= 0) goto L32;
        r2.add(readStrongBinder());
        r0 = r0 - 1;
    L32:
        return (T[]) r2.toArray(r5);
    }

    public <T> T[] readArray(T[] r1, int r2) {
        if (readField(r2) == true) goto L6;
        return r1;
    L6:
        return (T[]) readArray(r1);
    }

    protected abstract boolean readBoolean();

    public boolean readBoolean(boolean r1, int r2) {
        if (readField(r2) == true) goto L6;
        return r1;
    L6:
        return readBoolean();
    }

    protected boolean[] readBooleanArray() {
        int r0 = readInt();
        if (r0 >= 0) goto L6;
        return null;
    L6:
        boolean[] r1 = new boolean[r0];
        int r3 = 0;
    L7:
        if (r3 >= r0) goto L13;
        if (readInt() == 0) goto L11;
        boolean r4 = true;
    L12:
        r1[r3] = r4;
        r3 = r3 + 1;
        goto L7
    L11:
        r4 = false;
        goto L12
    L13:
        return r1;
    }

    public boolean[] readBooleanArray(boolean[] r1, int r2) {
        if (readField(r2) == true) goto L6;
        return r1;
    L6:
        return readBooleanArray();
    }

    protected abstract Bundle readBundle();

    public Bundle readBundle(Bundle r1, int r2) {
        if (readField(r2) == true) goto L6;
        return r1;
    L6:
        return readBundle();
    }

    public byte readByte(byte r1, int r2) {
        if (readField(r2) == true) goto L6;
        return r1;
    L6:
        return (byte) (readInt() & 255);
    }

    protected abstract byte[] readByteArray();

    public byte[] readByteArray(byte[] r1, int r2) {
        if (readField(r2) == true) goto L6;
        return r1;
    L6:
        return readByteArray();
    }

    public char[] readCharArray(char[] r3, int r4) {
        if (readField(r4) == true) goto L5;
        return r3;
    L5:
        int r5 = readInt();
        if (r5 >= 0) goto L9;
        return null;
    L9:
        char[] r6 = new char[r5];
        int r0 = 0;
    L10:
        if (r0 >= r5) goto L12;
        r6[r0] = (char) readInt();
        r0 = r0 + 1;
        goto L10
    L12:
        return r6;
    }

    protected abstract CharSequence readCharSequence();

    public CharSequence readCharSequence(CharSequence r1, int r2) {
        if (readField(r2) == true) goto L6;
        return r1;
    L6:
        return readCharSequence();
    }

    protected abstract double readDouble();

    public double readDouble(double r1, int r3) {
        if (readField(r3) == true) goto L6;
        return r1;
    L6:
        return readDouble();
    }

    protected double[] readDoubleArray() {
        int r0 = readInt();
        if (r0 >= 0) goto L6;
        return null;
    L6:
        double[] r1 = new double[r0];
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L9;
        r1[r2] = readDouble();
        r2 = r2 + 1;
        goto L7
    L9:
        return r1;
    }

    public double[] readDoubleArray(double[] r1, int r2) {
        if (readField(r2) == true) goto L6;
        return r1;
    L6:
        return readDoubleArray();
    }

    public Exception readException(Exception r1, int r2) {
        if (readField(r2) == true) goto L5;
        return r1;
    L5:
        int r3 = readExceptionCode();
        if (r3 != 0) goto L8;
        return r1;
    L8:
        return readException(r3, readString());
    }

    protected abstract boolean readField(int r1);

    protected abstract float readFloat();

    public float readFloat(float r1, int r2) {
        if (readField(r2) == true) goto L6;
        return r1;
    L6:
        return readFloat();
    }

    protected float[] readFloatArray() {
        int r0 = readInt();
        if (r0 >= 0) goto L6;
        return null;
    L6:
        float[] r1 = new float[r0];
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L9;
        r1[r2] = readFloat();
        r2 = r2 + 1;
        goto L7
    L9:
        return r1;
    }

    public float[] readFloatArray(float[] r1, int r2) {
        if (readField(r2) == true) goto L6;
        return r1;
    L6:
        return readFloatArray();
    }

    protected <T extends VersionedParcelable> T readFromParcel(String r3, VersionedParcel r4) {
        return (T) getReadMethod(r3).invoke(null, new Object[]{r4});
    L4:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
    L17:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e);
    L7:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e);
    L10:
        e = move-exception;
        if ((e.getCause() instanceof RuntimeException) == false) goto L16;
        throw ((RuntimeException) e.getCause());
    L16:
        throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e);
    }

    protected abstract int readInt();

    public int readInt(int r1, int r2) {
        if (readField(r2) == true) goto L6;
        return r1;
    L6:
        return readInt();
    }

    protected int[] readIntArray() {
        int r0 = readInt();
        if (r0 >= 0) goto L6;
        return null;
    L6:
        int[] r1 = new int[r0];
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L9;
        r1[r2] = readInt();
        r2 = r2 + 1;
        goto L7
    L9:
        return r1;
    }

    public int[] readIntArray(int[] r1, int r2) {
        if (readField(r2) == true) goto L6;
        return r1;
    L6:
        return readIntArray();
    }

    public <T> List<T> readList(List<T> r1, int r2) {
        if (readField(r2) == true) goto L6;
        return r1;
    L6:
        return (List) readCollection(new ArrayList());
    }

    protected abstract long readLong();

    public long readLong(long r1, int r3) {
        if (readField(r3) == true) goto L6;
        return r1;
    L6:
        return readLong();
    }

    protected long[] readLongArray() {
        int r0 = readInt();
        if (r0 >= 0) goto L6;
        return null;
    L6:
        long[] r1 = new long[r0];
        int r2 = 0;
    L7:
        if (r2 >= r0) goto L9;
        r1[r2] = readLong();
        r2 = r2 + 1;
        goto L7
    L9:
        return r1;
    }

    public long[] readLongArray(long[] r1, int r2) {
        if (readField(r2) == true) goto L6;
        return r1;
    L6:
        return readLongArray();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <K, V> Map<K, V> readMap(Map<K, V> r5, int r6) {
        if (readField(r6) == true) goto L5;
        return r5;
    L5:
        int r7 = readInt();
        if (r7 >= 0) goto L9;
        return null;
    L9:
        ArrayMap r8 = new ArrayMap();
        if (r7 != 0) goto L12;
        return r8;
    L12:
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        readCollection(r0);
        readCollection(r1);
        int r4 = 0;
    L13:
        if (r4 >= r7) goto L15;
        r8.put(r0.get(r4), r1.get(r4));
        r4 = r4 + 1;
        goto L13
    L15:
        return r8;
    }

    protected abstract <T extends Parcelable> T readParcelable();

    public <T extends Parcelable> T readParcelable(T r1, int r2) {
        if (readField(r2) == true) goto L6;
        return r1;
    L6:
        return (T) readParcelable();
    }

    protected Serializable readSerializable() {
        String r1 = readString();
        if (r1 != null) goto L6;
        return null;
    L6:
        final ByteArrayInputStream r3 = new ByteArrayInputStream(readByteArray());
        return (Serializable) new AnonymousClass1(this, r3).readObject();
    L12:
        e = move-exception;
        throw new RuntimeException("VersionedParcelable encountered IOException reading a Serializable object (name = " + r1 + ")", e);
    L9:
        e = move-exception;
        throw new RuntimeException("VersionedParcelable encountered ClassNotFoundException reading a Serializable object (name = " + r1 + ")", e);
    }

    public <T> Set<T> readSet(Set<T> r1, int r2) {
        if (readField(r2) == true) goto L6;
        return r1;
    L6:
        return (Set) readCollection(new ArraySet());
    }

    @RequiresApi(api = 21)
    public Size readSize(Size r1, int r2) {
        if (readField(r2) == true) goto L6;
        return r1;
    L6:
        if (readBoolean() == true) goto L8;
        return null;
    L8:
        return new Size(readInt(), readInt());
    }

    @RequiresApi(api = 21)
    public SizeF readSizeF(SizeF r1, int r2) {
        if (readField(r2) == true) goto L6;
        return r1;
    L6:
        if (readBoolean() == true) goto L8;
        return null;
    L8:
        return new SizeF(readFloat(), readFloat());
    }

    public SparseBooleanArray readSparseBooleanArray(SparseBooleanArray r4, int r5) {
        if (readField(r5) == true) goto L5;
        return r4;
    L5:
        int r6 = readInt();
        if (r6 >= 0) goto L9;
        return null;
    L9:
        SparseBooleanArray r7 = new SparseBooleanArray(r6);
        int r0 = 0;
    L10:
        if (r0 >= r6) goto L12;
        r7.put(readInt(), readBoolean());
        r0 = r0 + 1;
        goto L10
    L12:
        return r7;
    }

    protected abstract String readString();

    public String readString(String r1, int r2) {
        if (readField(r2) == true) goto L6;
        return r1;
    L6:
        return readString();
    }

    protected abstract IBinder readStrongBinder();

    public IBinder readStrongBinder(IBinder r1, int r2) {
        if (readField(r2) == true) goto L6;
        return r1;
    L6:
        return readStrongBinder();
    }

    protected <T extends VersionedParcelable> T readVersionedParcelable() {
        String r0 = readString();
        if (r0 != null) goto L7;
        return null;
    L7:
        return (T) readFromParcel(r0, createSubParcel());
    }

    public <T extends VersionedParcelable> T readVersionedParcelable(T r1, int r2) {
        if (readField(r2) == true) goto L6;
        return r1;
    L6:
        return (T) readVersionedParcelable();
    }

    protected abstract void setOutputField(int r1);

    public void setSerializationFlags(boolean r1, boolean r2) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected <T> void writeArray(T[] r5) {
        if (r5 != 0) goto L5;
        writeInt(-1);
        return;
    L5:
        int r0 = r5.length;
        writeInt(r0);
        if (r0 <= 0) goto L28;
        int r1 = 0;
        int r2 = getType(r5[0]);
        writeInt(r2);
        if (r2 != 1) goto L10;
    L26:
        if (r1 >= r0) goto L39;
        writeVersionedParcelable((VersionedParcelable) r5[r1]);
        r1 = r1 + 1;
        goto L26
    L39:
        return;
    L10:
        if (r2 != 2) goto L12;
    L24:
        if (r1 >= r0) goto L38;
        writeParcelable((Parcelable) r5[r1]);
        r1 = r1 + 1;
        goto L24
    L38:
        return;
    L12:
        if (r2 != 3) goto L14;
    L22:
        if (r1 >= r0) goto L37;
        writeSerializable((Serializable) r5[r1]);
        r1 = r1 + 1;
        goto L22
    L37:
        return;
    L14:
        if (r2 != 4) goto L16;
    L20:
        if (r1 >= r0) goto L36;
        writeString((String) r5[r1]);
        r1 = r1 + 1;
        goto L20
    L36:
        return;
    L16:
        if (r2 != 5) goto L34;
    L18:
        if (r1 >= r0) goto L35;
        writeStrongBinder((IBinder) r5[r1]);
        r1 = r1 + 1;
        goto L18
    L35:
        return;
    L34:
        return;
    }

    public <T> void writeArray(T[] r1, int r2) {
        setOutputField(r2);
        writeArray(r1);
    }

    protected abstract void writeBoolean(boolean r1);

    public void writeBoolean(boolean r1, int r2) {
        setOutputField(r2);
        writeBoolean(r1);
    }

    protected void writeBooleanArray(boolean[] r4) {
        if (r4 == null) goto L6;
        int r0 = r4.length;
        writeInt(r0);
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L9;
        writeInt(r4[r1] ? 1 : 0);
        r1 = r1 + 1;
        goto L4
    L9:
        return;
    L6:
        writeInt(-1);
    }

    public void writeBooleanArray(boolean[] r1, int r2) {
        setOutputField(r2);
        writeBooleanArray(r1);
    }

    protected abstract void writeBundle(Bundle r1);

    public void writeBundle(Bundle r1, int r2) {
        setOutputField(r2);
        writeBundle(r1);
    }

    public void writeByte(byte r1, int r2) {
        setOutputField(r2);
        writeInt(r1);
    }

    protected abstract void writeByteArray(byte[] r1);

    public void writeByteArray(byte[] r1, int r2) {
        setOutputField(r2);
        writeByteArray(r1);
    }

    protected abstract void writeByteArray(byte[] r1, int r2, int r3);

    public void writeByteArray(byte[] r1, int r2, int r3, int r4) {
        setOutputField(r4);
        writeByteArray(r1, r2, r3);
    }

    public void writeCharArray(char[] r3, int r4) {
        setOutputField(r4);
        if (r3 == null) goto L7;
        int r5 = r3.length;
        writeInt(r5);
        int r0 = 0;
    L5:
        if (r0 >= r5) goto L10;
        writeInt(r3[r0]);
        r0 = r0 + 1;
        goto L5
    L10:
        return;
    L7:
        writeInt(-1);
    }

    protected abstract void writeCharSequence(CharSequence r1);

    public void writeCharSequence(CharSequence r1, int r2) {
        setOutputField(r2);
        writeCharSequence(r1);
    }

    protected abstract void writeDouble(double r1);

    public void writeDouble(double r1, int r3) {
        setOutputField(r3);
        writeDouble(r1);
    }

    protected void writeDoubleArray(double[] r5) {
        if (r5 == null) goto L6;
        int r0 = r5.length;
        writeInt(r0);
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L9;
        writeDouble(r5[r1]);
        r1 = r1 + 1;
        goto L4
    L9:
        return;
    L6:
        writeInt(-1);
    }

    public void writeDoubleArray(double[] r1, int r2) {
        setOutputField(r2);
        writeDoubleArray(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void writeException(Exception r4, int r5) {
        setOutputField(r5);
        if (r4 != 0) goto L6;
        writeNoException();
        return;
    L6:
        int r6 = 0;
        if ((r4 instanceof Parcelable) == false) goto L12;
        if (r4.getClass().getClassLoader() != Parcelable.class.getClassLoader()) goto L12;
        r6 = -9;
    L32:
        writeInt(r6);
        if (r6 == 0) goto L35;
        writeString(r4.getMessage());
        if (r6 != (-9)) goto L45;
        writeParcelable((Parcelable) r4);
        return;
    L45:
        return;
    L35:
        if ((r4 instanceof RuntimeException) == false) goto L39;
        throw ((RuntimeException) r4);
    L39:
        throw new RuntimeException(r4);
    L12:
        if ((r4 instanceof SecurityException) == false) goto L15;
        r6 = -1;
        goto L32
    L15:
        if ((r4 instanceof BadParcelableException) == false) goto L18;
        r6 = -2;
        goto L32
    L18:
        if ((r4 instanceof IllegalArgumentException) == false) goto L21;
        r6 = -3;
        goto L32
    L21:
        if ((r4 instanceof NullPointerException) == false) goto L24;
        r6 = -4;
        goto L32
    L24:
        if ((r4 instanceof IllegalStateException) == false) goto L27;
        r6 = -5;
        goto L32
    L27:
        if ((r4 instanceof NetworkOnMainThreadException) == false) goto L30;
        r6 = -6;
        goto L32
    L30:
        if ((r4 instanceof UnsupportedOperationException) == false) goto L32;
        r6 = -7;
        goto L32
    }

    protected abstract void writeFloat(float r1);

    public void writeFloat(float r1, int r2) {
        setOutputField(r2);
        writeFloat(r1);
    }

    protected void writeFloatArray(float[] r4) {
        if (r4 == null) goto L6;
        int r0 = r4.length;
        writeInt(r0);
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L9;
        writeFloat(r4[r1]);
        r1 = r1 + 1;
        goto L4
    L9:
        return;
    L6:
        writeInt(-1);
    }

    public void writeFloatArray(float[] r1, int r2) {
        setOutputField(r2);
        writeFloatArray(r1);
    }

    protected abstract void writeInt(int r1);

    public void writeInt(int r1, int r2) {
        setOutputField(r2);
        writeInt(r1);
    }

    protected void writeIntArray(int[] r4) {
        if (r4 == null) goto L6;
        int r0 = r4.length;
        writeInt(r0);
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L9;
        writeInt(r4[r1]);
        r1 = r1 + 1;
        goto L4
    L9:
        return;
    L6:
        writeInt(-1);
    }

    public void writeIntArray(int[] r1, int r2) {
        setOutputField(r2);
        writeIntArray(r1);
    }

    public <T> void writeList(List<T> r1, int r2) {
        writeCollection(r1, r2);
    }

    protected abstract void writeLong(long r1);

    public void writeLong(long r1, int r3) {
        setOutputField(r3);
        writeLong(r1);
    }

    protected void writeLongArray(long[] r5) {
        if (r5 == null) goto L6;
        int r0 = r5.length;
        writeInt(r0);
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L9;
        writeLong(r5[r1]);
        r1 = r1 + 1;
        goto L4
    L9:
        return;
    L6:
        writeInt(-1);
    }

    public void writeLongArray(long[] r1, int r2) {
        setOutputField(r2);
        writeLongArray(r1);
    }

    public <K, V> void writeMap(Map<K, V> r4, int r5) {
        setOutputField(r5);
        if (r4 != null) goto L6;
        writeInt(-1);
        return;
    L6:
        int r6 = r4.size();
        writeInt(r6);
        if (r6 != 0) goto L9;
        return;
    L9:
        ArrayList r7 = new ArrayList();
        ArrayList r0 = new ArrayList();
        Iterator<Map.Entry<K, V>> r8 = r4.entrySet().iterator();
    L11:
        if (r8.hasNext() == false) goto L13;
        Map.Entry<K, V> r1 = r8.next();
        r7.add(r1.getKey());
        r0.add(r1.getValue());
        goto L11
    L13:
        writeCollection(r7);
        writeCollection(r0);
    }

    protected void writeNoException() {
        writeInt(0);
    }

    protected abstract void writeParcelable(Parcelable r1);

    public void writeParcelable(Parcelable r1, int r2) {
        setOutputField(r2);
        writeParcelable(r1);
    }

    public void writeSerializable(Serializable r1, int r2) {
        setOutputField(r2);
        writeSerializable(r1);
    }

    public <T> void writeSet(Set<T> r1, int r2) {
        writeCollection(r1, r2);
    }

    @RequiresApi(api = 21)
    public void writeSize(Size r1, int r2) {
        setOutputField(r2);
        if (r1 == null) goto L5;
        boolean r3 = true;
    L6:
        writeBoolean(r3);
        if (r1 == null) goto L10;
        writeInt(r1.getWidth());
        writeInt(r1.getHeight());
        return;
    L10:
        return;
    L5:
        r3 = false;
        goto L6
    }

    @RequiresApi(api = 21)
    public void writeSizeF(SizeF r1, int r2) {
        setOutputField(r2);
        if (r1 == null) goto L5;
        boolean r3 = true;
    L6:
        writeBoolean(r3);
        if (r1 == null) goto L10;
        writeFloat(r1.getWidth());
        writeFloat(r1.getHeight());
        return;
    L10:
        return;
    L5:
        r3 = false;
        goto L6
    }

    public void writeSparseBooleanArray(SparseBooleanArray r3, int r4) {
        setOutputField(r4);
        if (r3 != null) goto L6;
        writeInt(-1);
        return;
    L6:
        int r5 = r3.size();
        writeInt(r5);
        int r0 = 0;
    L7:
        if (r0 >= r5) goto L9;
        writeInt(r3.keyAt(r0));
        writeBoolean(r3.valueAt(r0));
        r0 = r0 + 1;
        goto L7
    }

    protected abstract void writeString(String r1);

    public void writeString(String r1, int r2) {
        setOutputField(r2);
        writeString(r1);
    }

    protected abstract void writeStrongBinder(IBinder r1);

    public void writeStrongBinder(IBinder r1, int r2) {
        setOutputField(r2);
        writeStrongBinder(r1);
    }

    protected abstract void writeStrongInterface(IInterface r1);

    public void writeStrongInterface(IInterface r1, int r2) {
        setOutputField(r2);
        writeStrongInterface(r1);
    }

    protected <T extends VersionedParcelable> void writeToParcel(T r4, VersionedParcel r5) {
        getWriteMethod(r4.getClass()).invoke(null, new Object[]{r4, r5});     // Catch: ClassNotFoundException -> L4 NoSuchMethodException -> L7 InvocationTargetException -> L10 IllegalAccessException -> L17
        return;
    L4:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
    L17:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e);
    L7:
        e = move-exception;
        throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e);
    L10:
        e = move-exception;
        if ((e.getCause() instanceof RuntimeException) == false) goto L16;
        throw ((RuntimeException) e.getCause());
    L16:
        throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e);
    }

    protected void writeVersionedParcelable(VersionedParcelable r2) {
        if (r2 != null) goto L5;
        writeString(null);
        return;
    L5:
        writeVersionedParcelableCreator(r2);
        VersionedParcel r0 = createSubParcel();
        writeToParcel(r2, r0);
        r0.closeField();
    }

    public void writeVersionedParcelable(VersionedParcelable r1, int r2) {
        setOutputField(r2);
        writeVersionedParcelable(r1);
    }
}
