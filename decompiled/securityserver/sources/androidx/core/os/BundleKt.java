package androidx.core.os;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class BundleKt {
    @NotNull
    public static final Bundle bundleOf(@NotNull Pair<String, ? extends Object>... r9) {
        Intrinsics.g(r9, "pairs");
        Bundle r0 = new Bundle(r9.length);
        int r1 = r9.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L99;
        Pair<String, ? extends Object> r3 = r9[r2];
        String r4 = (String) r3.b;
        Object r5 = r3.c;
        if (r5 != null) goto L8;
        r0.putString(r4, null);
    L96:
        r2 = r2 + 1;
        goto L3
    L8:
        if ((r5 instanceof Boolean) == false) goto L11;
        r0.putBoolean(r4, ((Boolean) r5).booleanValue());
        goto L96
    L11:
        if ((r5 instanceof Byte) == false) goto L14;
        r0.putByte(r4, ((Number) r5).byteValue());
        goto L96
    L14:
        if ((r5 instanceof Character) == false) goto L17;
        r0.putChar(r4, ((Character) r5).charValue());
        goto L96
    L17:
        if ((r5 instanceof Double) == false) goto L20;
        r0.putDouble(r4, ((Number) r5).doubleValue());
        goto L96
    L20:
        if ((r5 instanceof Float) == false) goto L23;
        r0.putFloat(r4, ((Number) r5).floatValue());
        goto L96
    L23:
        if ((r5 instanceof Integer) == false) goto L26;
        r0.putInt(r4, ((Number) r5).intValue());
        goto L96
    L26:
        if ((r5 instanceof Long) == false) goto L29;
        r0.putLong(r4, ((Number) r5).longValue());
        goto L96
    L29:
        if ((r5 instanceof Short) == false) goto L32;
        r0.putShort(r4, ((Number) r5).shortValue());
        goto L96
    L32:
        if ((r5 instanceof Bundle) == false) goto L35;
        r0.putBundle(r4, (Bundle) r5);
        goto L96
    L35:
        if ((r5 instanceof CharSequence) == false) goto L38;
        r0.putCharSequence(r4, (CharSequence) r5);
        goto L96
    L38:
        if ((r5 instanceof Parcelable) == false) goto L41;
        r0.putParcelable(r4, (Parcelable) r5);
        goto L96
    L41:
        if ((r5 instanceof boolean[]) == false) goto L44;
        r0.putBooleanArray(r4, (boolean[]) r5);
        goto L96
    L44:
        if ((r5 instanceof byte[]) == false) goto L47;
        r0.putByteArray(r4, (byte[]) r5);
        goto L96
    L47:
        if ((r5 instanceof char[]) == false) goto L50;
        r0.putCharArray(r4, (char[]) r5);
        goto L96
    L50:
        if ((r5 instanceof double[]) == false) goto L53;
        r0.putDoubleArray(r4, (double[]) r5);
        goto L96
    L53:
        if ((r5 instanceof float[]) == false) goto L56;
        r0.putFloatArray(r4, (float[]) r5);
        goto L96
    L56:
        if ((r5 instanceof int[]) == false) goto L59;
        r0.putIntArray(r4, (int[]) r5);
        goto L96
    L59:
        if ((r5 instanceof long[]) == false) goto L62;
        r0.putLongArray(r4, (long[]) r5);
        goto L96
    L62:
        if ((r5 instanceof short[]) == false) goto L65;
        r0.putShortArray(r4, (short[]) r5);
        goto L96
    L65:
        if ((r5 instanceof Object[]) == false) goto L85;
        Class<?> r6 = r5.getClass().getComponentType();
        if (r6 == null) goto L82;
        if (Parcelable.class.isAssignableFrom(r6) == false) goto L72;
        r0.putParcelableArray(r4, (Parcelable[]) r5);
        goto L96
    L72:
        if (String.class.isAssignableFrom(r6) == false) goto L75;
        r0.putStringArray(r4, (String[]) r5);
        goto L96
    L75:
        if (CharSequence.class.isAssignableFrom(r6) == false) goto L78;
        r0.putCharSequenceArray(r4, (CharSequence[]) r5);
        goto L96
    L78:
        if (Serializable.class.isAssignableFrom(r6) == false) goto L81;
        r0.putSerializable(r4, (Serializable) r5);
        goto L96
    L81:
        throw new IllegalArgumentException("Illegal value array type " + r6.getCanonicalName() + " for key \"" + r4 + '\"');
    L82:
        Intrinsics.k();
        throw null;
    L85:
        if ((r5 instanceof Serializable) == false) goto L88;
        r0.putSerializable(r4, (Serializable) r5);
        goto L96
    L88:
        if ((r5 instanceof Binder) == false) goto L91;
        r0.putBinder(r4, (IBinder) r5);
        goto L96
    L91:
        if ((r5 instanceof Size) == false) goto L94;
        r0.putSize(r4, (Size) r5);
        goto L96
    L94:
        if ((r5 instanceof SizeF) == false) goto L98;
        r0.putSizeF(r4, (SizeF) r5);
        goto L96
    L98:
        throw new IllegalArgumentException("Illegal value type " + r5.getClass().getCanonicalName() + " for key \"" + r4 + '\"');
    L99:
        return r0;
    }
}
