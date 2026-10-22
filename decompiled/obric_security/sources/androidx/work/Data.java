package androidx.work;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class Data {
    public static final Data EMPTY = null;
    public static final int MAX_DATA_BYTES = 10240;
    private static final String TAG = null;
    Map<String, Object> mValues;

    public static final class Builder {
        private Map<String, Object> mValues;

        public Builder() {
            this.mValues = new HashMap();
        }

        public Builder putBoolean(String key, boolean value) {
            this.mValues.put(key, Boolean.valueOf(value));
            return this;
        }

        public Builder putBooleanArray(String key, boolean[] value) {
            this.mValues.put(key, Data.convertPrimitiveBooleanArray(value));
            return this;
        }

        public Builder putByte(String key, byte value) {
            this.mValues.put(key, Byte.valueOf(value));
            return this;
        }

        public Builder putByteArray(String key, byte[] value) {
            this.mValues.put(key, Data.convertPrimitiveByteArray(value));
            return this;
        }

        public Builder putInt(String key, int value) {
            this.mValues.put(key, Integer.valueOf(value));
            return this;
        }

        public Builder putIntArray(String key, int[] value) {
            this.mValues.put(key, Data.convertPrimitiveIntArray(value));
            return this;
        }

        public Builder putLong(String key, long value) {
            this.mValues.put(key, Long.valueOf(value));
            return this;
        }

        public Builder putLongArray(String key, long[] value) {
            this.mValues.put(key, Data.convertPrimitiveLongArray(value));
            return this;
        }

        public Builder putFloat(String key, float value) {
            this.mValues.put(key, Float.valueOf(value));
            return this;
        }

        public Builder putFloatArray(String key, float[] value) {
            this.mValues.put(key, Data.convertPrimitiveFloatArray(value));
            return this;
        }

        public Builder putDouble(String key, double value) {
            this.mValues.put(key, Double.valueOf(value));
            return this;
        }

        public Builder putDoubleArray(String key, double[] value) {
            this.mValues.put(key, Data.convertPrimitiveDoubleArray(value));
            return this;
        }

        public Builder putString(String key, String value) {
            this.mValues.put(key, value);
            return this;
        }

        public Builder putStringArray(String key, String[] value) {
            this.mValues.put(key, value);
            return this;
        }

        public Builder putAll(Data data) {
            putAll(data.mValues);
            return this;
        }

        public Builder putAll(Map<String, Object> values) {
            Iterator<Map.Entry<String, Object>> r3 = values.entrySet().iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            Map.Entry<String, Object> r0 = r3.next();
            put(r0.getKey(), r0.getValue());
            goto L4
        L6:
            return this;
        }

        public Builder put(String key, Object value) {
            if (value != null) goto L4;
            this.mValues.put(key, null);
        L54:
            return this;
        L4:
            Class<?> r0 = value.getClass();
            if (r0 != Boolean.class) goto L7;
        L53:
            this.mValues.put(key, value);
            goto L54
        L7:
            if (r0 == Byte.class) goto L53;
            if (r0 == Integer.class) goto L53;
            if (r0 == Long.class) goto L53;
            if (r0 == Float.class) goto L53;
            if (r0 == Double.class) goto L53;
            if (r0 == String.class) goto L53;
            if (r0 == Boolean[].class) goto L53;
            if (r0 == Byte[].class) goto L53;
            if (r0 == Integer[].class) goto L53;
            if (r0 == Long[].class) goto L53;
            if (r0 == Float[].class) goto L53;
            if (r0 == Double[].class) goto L53;
            if (r0 == String[].class) goto L53;
            if (r0 != boolean[].class) goto L37;
            this.mValues.put(key, Data.convertPrimitiveBooleanArray((boolean[]) value));
            goto L54
        L37:
            if (r0 != byte[].class) goto L40;
            this.mValues.put(key, Data.convertPrimitiveByteArray((byte[]) value));
            goto L54
        L40:
            if (r0 != int[].class) goto L43;
            this.mValues.put(key, Data.convertPrimitiveIntArray((int[]) value));
            goto L54
        L43:
            if (r0 != long[].class) goto L46;
            this.mValues.put(key, Data.convertPrimitiveLongArray((long[]) value));
            goto L54
        L46:
            if (r0 != float[].class) goto L49;
            this.mValues.put(key, Data.convertPrimitiveFloatArray((float[]) value));
            goto L54
        L49:
            if (r0 != double[].class) goto L52;
            this.mValues.put(key, Data.convertPrimitiveDoubleArray((double[]) value));
            goto L54
        L52:
            throw new IllegalArgumentException("Key " + key + "has invalid type " + r0);
        }

        public Data build() {
            Data r0 = new Data(this.mValues);
            Data.toByteArrayInternal(r0);
            return r0;
        }
    }

    static {
        TAG = Logger.tagWithPrefix("Data");
        EMPTY = new Builder().build();
    }

    Data() {
    }

    public Data(Data other) {
        this.mValues = new HashMap(other.mValues);
    }

    public Data(Map<String, ?> values) {
        this.mValues = new HashMap(values);
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        Object r0 = this.mValues.get(key);
        if ((r0 instanceof Boolean) == true) goto L5;
        return defaultValue;
    L5:
        return ((Boolean) r0).booleanValue();
    }

    public boolean[] getBooleanArray(String key) {
        Object r0 = this.mValues.get(key);
        if ((r0 instanceof Boolean[]) == true) goto L5;
        return null;
    L5:
        return convertToPrimitiveArray((Boolean[]) r0);
    }

    public byte getByte(String key, byte defaultValue) {
        Object r0 = this.mValues.get(key);
        if ((r0 instanceof Byte) == true) goto L5;
        return defaultValue;
    L5:
        return ((Byte) r0).byteValue();
    }

    public byte[] getByteArray(String key) {
        Object r0 = this.mValues.get(key);
        if ((r0 instanceof Byte[]) == true) goto L5;
        return null;
    L5:
        return convertToPrimitiveArray((Byte[]) r0);
    }

    public int getInt(String key, int defaultValue) {
        Object r0 = this.mValues.get(key);
        if ((r0 instanceof Integer) == true) goto L5;
        return defaultValue;
    L5:
        return ((Integer) r0).intValue();
    }

    public int[] getIntArray(String key) {
        Object r0 = this.mValues.get(key);
        if ((r0 instanceof Integer[]) == true) goto L5;
        return null;
    L5:
        return convertToPrimitiveArray((Integer[]) r0);
    }

    public long getLong(String key, long defaultValue) {
        Object r0 = this.mValues.get(key);
        if ((r0 instanceof Long) == true) goto L5;
        return defaultValue;
    L5:
        return ((Long) r0).longValue();
    }

    public long[] getLongArray(String key) {
        Object r0 = this.mValues.get(key);
        if ((r0 instanceof Long[]) == true) goto L5;
        return null;
    L5:
        return convertToPrimitiveArray((Long[]) r0);
    }

    public float getFloat(String key, float defaultValue) {
        Object r0 = this.mValues.get(key);
        if ((r0 instanceof Float) == true) goto L5;
        return defaultValue;
    L5:
        return ((Float) r0).floatValue();
    }

    public float[] getFloatArray(String key) {
        Object r0 = this.mValues.get(key);
        if ((r0 instanceof Float[]) == true) goto L5;
        return null;
    L5:
        return convertToPrimitiveArray((Float[]) r0);
    }

    public double getDouble(String key, double defaultValue) {
        Object r0 = this.mValues.get(key);
        if ((r0 instanceof Double) == true) goto L5;
        return defaultValue;
    L5:
        return ((Double) r0).doubleValue();
    }

    public double[] getDoubleArray(String key) {
        Object r0 = this.mValues.get(key);
        if ((r0 instanceof Double[]) == true) goto L5;
        return null;
    L5:
        return convertToPrimitiveArray((Double[]) r0);
    }

    public String getString(String key) {
        Object r0 = this.mValues.get(key);
        if ((r0 instanceof String) == true) goto L5;
        return null;
    L5:
        return (String) r0;
    }

    public String[] getStringArray(String key) {
        Object r0 = this.mValues.get(key);
        if ((r0 instanceof String[]) == true) goto L5;
        return null;
    L5:
        return (String[]) r0;
    }

    public Map<String, Object> getKeyValueMap() {
        return Collections.unmodifiableMap(this.mValues);
    }

    public byte[] toByteArray() {
        return toByteArrayInternal(this);
    }

    public <T> boolean hasKeyWithValueOfType(String key, Class<T> klass) {
        Object r0 = this.mValues.get(key);
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (klass.isAssignableFrom(r0.getClass()) == false) goto L7;
        return true;
    }

    public int size() {
        return this.mValues.size();
    }

    public static byte[] toByteArrayInternal(Data data) {
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();
        ObjectOutputStream r2 = null;
        ObjectOutputStream r3 = new ObjectOutputStream(r1);     // Catch: Throwable -> L27 IOException -> L29
        r3.writeInt(data.size());     // Catch: Throwable -> L23 IOException -> L25
        Iterator<Map.Entry<String, Object>> r5 = data.mValues.entrySet().iterator();     // Catch: Throwable -> L23 IOException -> L25
    L6:
        if (r5.hasNext() == false) goto L57;
        Map.Entry<String, Object> r4 = r5.next();     // Catch: Throwable -> L23 IOException -> L25
        r3.writeUTF(r4.getKey());     // Catch: Throwable -> L23 IOException -> L25
        r3.writeObject(r4.getValue());     // Catch: Throwable -> L23 IOException -> L25
    L57:
        r3.close();     // Catch: IOException -> L11
    L51:
        r1.close();     // Catch: IOException -> L15
    L18:
        if (r1.size() > 10240) goto L22;
        return r1.toByteArray();
    L22:
        throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
    L15:
        e = move-exception;
        Log.e(TAG, "Error in Data#toByteArray: ", e);
    L11:
        e = move-exception;
        Log.e(TAG, "Error in Data#toByteArray: ", e);
    L25:
        e = e;
        r2 = r3;
    L30:
        Log.e(TAG, "Error in Data#toByteArray: ", e);     // Catch: Throwable -> L27
        byte[] r6 = r1.toByteArray();     // Catch: Throwable -> L27
        if (r2 != null) goto L63;
    L53:
        r1.close();     // Catch: IOException -> L38
    L40:
        return r6;
    L38:
        e = move-exception;
        Log.e(TAG, "Error in Data#toByteArray: ", e);
        goto L40
    L63:
        r2.close();     // Catch: IOException -> L34
    L34:
        e = move-exception;
        Log.e(TAG, "Error in Data#toByteArray: ", e);
    L23:
        th = th;
        r2 = r3;
    L41:
        if (r2 == null) goto L61;
        r2.close();     // Catch: IOException -> L44
    L44:
        e = move-exception;
        Log.e(TAG, "Error in Data#toByteArray: ", e);
    L61:
        r1.close();     // Catch: IOException -> L48
        throw th;
    L48:
        e = move-exception;
        Log.e(TAG, "Error in Data#toByteArray: ", e);
        throw th;
    L27:
        th = th;
    L29:
        e = e;
        goto L30
    }

    public static Data fromByteArray(byte[] bytes) {
        if (bytes.length > 10240) goto L46;
        HashMap r1 = new HashMap();
        ByteArrayInputStream r2 = new ByteArrayInputStream(bytes);
        ObjectInputStream r7 = null;
        ObjectInputStream r3 = new ObjectInputStream(r2);     // Catch: Throwable -> L18 Throwable -> L20
        int r8 = r3.readInt();     // Catch: Throwable -> L16 Throwable -> L34
    L7:
        if (r8 <= 0) goto L53;
        r1.put(r3.readUTF(), r3.readObject());     // Catch: Throwable -> L16 Throwable -> L34
        r8 = r8 - 1;
        goto L7
    L53:
        r3.close();     // Catch: IOException -> L12
    L14:
        r2.close();     // Catch: IOException -> L30
    L47:
    L33:
        return new Data(r1);
    L12:
        e = move-exception;
        Log.e(TAG, "Error in Data#fromByteArray: ", e);
    L16:
        Throwable e = e;
    L22:
        Log.e(TAG, "Error in Data#fromByteArray: ", e);     // Catch: Throwable -> L34
        if (r3 != null) goto L57;
    L28:
        r2.close();     // Catch: IOException -> L30
        goto L47
    L57:
        r3.close();     // Catch: IOException -> L26
    L26:
        e = move-exception;
        Log.e(TAG, "Error in Data#fromByteArray: ", e);
        goto L28
    L30:
        e = move-exception;
        Log.e(TAG, "Error in Data#fromByteArray: ", e);
    L20:
        e = move-exception;
        r3 = null;
        e = e;
    L18:
        th = move-exception;
        th = th;
    L35:
        if (0 != 0) goto L59;
    L50:
        r2.close();     // Catch: IOException -> L42
        throw th;
    L42:
        e = move-exception;
        Log.e(TAG, "Error in Data#fromByteArray: ", e);
        throw th;
    L59:
        r7.close();     // Catch: IOException -> L38
    L38:
        e = move-exception;
        Log.e(TAG, "Error in Data#fromByteArray: ", e);
    L34:
        th = th;
        goto L35
    L46:
        throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
    }

    public boolean equals(Object o) {
        if (this != o) goto L6;
        return true;
    L6:
        if (o != null) goto L8;
    L32:
        return false;
    L8:
        if (getClass() != o.getClass()) goto L32;
        Data r7 = (Data) o;
        Set<String> r2 = this.mValues.keySet();
        if (r2.equals(r7.mValues.keySet()) == true) goto L13;
        return false;
    L13:
        Iterator<String> r3 = r2.iterator();
    L15:
        if (r3.hasNext() == false) goto L31;
        String r4 = r3.next();
        Object r5 = this.mValues.get(r4);
        Object r6 = r7.mValues.get(r4);
        if (r5 == null) goto L26;
        if (r6 == null) goto L26;
        if ((r5 instanceof Object[]) == true) goto L23;
    L25:
        boolean r8 = r5.equals(r6);
    L29:
        if (r8 == true) goto L15;
        return false;
    L23:
        if ((r6 instanceof Object[]) == false) goto L25;
        r8 = Arrays.deepEquals((Object[]) r5, (Object[]) r6);
    L26:
        if (r5 != r6) goto L28;
        r8 = true;
        goto L29
    L28:
        r8 = false;
        goto L29
    L31:
        return true;
    }

    public int hashCode() {
        return this.mValues.hashCode() * 31;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("Data {");
        if (this.mValues.isEmpty() == true) goto L12;
        Iterator<String> r1 = this.mValues.keySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L12;
        String r2 = r1.next();
        r0.append(r2).append(" : ");
        Object r3 = this.mValues.get(r2);
        if ((r3 instanceof Object[]) == false) goto L10;
        r0.append(Arrays.toString((Object[]) r3));
    L11:
        r0.append(", ");
        goto L6
    L10:
        r0.append(r3);
    L12:
        r0.append("}");
        return r0.toString();
    }

    public static Boolean[] convertPrimitiveBooleanArray(boolean[] value) {
        Boolean[] r0 = new Boolean[value.length];
        int r1 = 0;
    L4:
        if (r1 >= value.length) goto L6;
        r0[r1] = Boolean.valueOf(value[r1]);
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public static Byte[] convertPrimitiveByteArray(byte[] value) {
        Byte[] r0 = new Byte[value.length];
        int r1 = 0;
    L4:
        if (r1 >= value.length) goto L6;
        r0[r1] = Byte.valueOf(value[r1]);
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public static Integer[] convertPrimitiveIntArray(int[] value) {
        Integer[] r0 = new Integer[value.length];
        int r1 = 0;
    L4:
        if (r1 >= value.length) goto L6;
        r0[r1] = Integer.valueOf(value[r1]);
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public static Long[] convertPrimitiveLongArray(long[] value) {
        Long[] r0 = new Long[value.length];
        int r1 = 0;
    L4:
        if (r1 >= value.length) goto L6;
        r0[r1] = Long.valueOf(value[r1]);
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public static Float[] convertPrimitiveFloatArray(float[] value) {
        Float[] r0 = new Float[value.length];
        int r1 = 0;
    L4:
        if (r1 >= value.length) goto L6;
        r0[r1] = Float.valueOf(value[r1]);
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public static Double[] convertPrimitiveDoubleArray(double[] value) {
        Double[] r0 = new Double[value.length];
        int r1 = 0;
    L4:
        if (r1 >= value.length) goto L6;
        r0[r1] = Double.valueOf(value[r1]);
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public static boolean[] convertToPrimitiveArray(Boolean[] array) {
        boolean[] r0 = new boolean[array.length];
        int r1 = 0;
    L4:
        if (r1 >= array.length) goto L6;
        r0[r1] = array[r1].booleanValue();
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public static byte[] convertToPrimitiveArray(Byte[] array) {
        byte[] r0 = new byte[array.length];
        int r1 = 0;
    L4:
        if (r1 >= array.length) goto L6;
        r0[r1] = array[r1].byteValue();
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public static int[] convertToPrimitiveArray(Integer[] array) {
        int[] r0 = new int[array.length];
        int r1 = 0;
    L4:
        if (r1 >= array.length) goto L6;
        r0[r1] = array[r1].intValue();
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public static long[] convertToPrimitiveArray(Long[] array) {
        long[] r0 = new long[array.length];
        int r1 = 0;
    L4:
        if (r1 >= array.length) goto L6;
        r0[r1] = array[r1].longValue();
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public static float[] convertToPrimitiveArray(Float[] array) {
        float[] r0 = new float[array.length];
        int r1 = 0;
    L4:
        if (r1 >= array.length) goto L6;
        r0[r1] = array[r1].floatValue();
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }

    public static double[] convertToPrimitiveArray(Double[] array) {
        double[] r0 = new double[array.length];
        int r1 = 0;
    L4:
        if (r1 >= array.length) goto L6;
        r0[r1] = array[r1].doubleValue();
        r1 = r1 + 1;
        goto L4
    L6:
        return r0;
    }
}
