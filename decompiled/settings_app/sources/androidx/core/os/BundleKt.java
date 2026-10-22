package androidx.core.os;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Bundle.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a;\u0010\u0000\u001a\u00020\u00012.\u0010\u0002\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00040\u0003\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"bundleOf", "Landroid/os/Bundle;", "pairs", "", "Lkotlin/Pair;", "", "", "([Lkotlin/Pair;)Landroid/os/Bundle;", "core-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class BundleKt {
    public static final Bundle bundleOf(Pair<String, ? extends Object>... r9) {
        Intrinsics.checkNotNullParameter(r9, "pairs");
        Bundle r0 = new Bundle(r9.length);
        int r1 = r9.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L95;
        Pair<String, ? extends Object> r3 = r9[r2];
        String r4 = r3.component1();
        Object r5 = r3.component2();
        if (r5 != null) goto L8;
        r0.putString(r4, null);
    L92:
        r2 = r2 + 1;
        goto L3
    L8:
        if ((r5 instanceof Boolean) == false) goto L11;
        r0.putBoolean(r4, ((Boolean) r5).booleanValue());
        goto L92
    L11:
        if ((r5 instanceof Byte) == false) goto L14;
        r0.putByte(r4, ((Number) r5).byteValue());
        goto L92
    L14:
        if ((r5 instanceof Character) == false) goto L17;
        r0.putChar(r4, ((Character) r5).charValue());
        goto L92
    L17:
        if ((r5 instanceof Double) == false) goto L20;
        r0.putDouble(r4, ((Number) r5).doubleValue());
        goto L92
    L20:
        if ((r5 instanceof Float) == false) goto L23;
        r0.putFloat(r4, ((Number) r5).floatValue());
        goto L92
    L23:
        if ((r5 instanceof Integer) == false) goto L26;
        r0.putInt(r4, ((Number) r5).intValue());
        goto L92
    L26:
        if ((r5 instanceof Long) == false) goto L29;
        r0.putLong(r4, ((Number) r5).longValue());
        goto L92
    L29:
        if ((r5 instanceof Short) == false) goto L32;
        r0.putShort(r4, ((Number) r5).shortValue());
        goto L92
    L32:
        if ((r5 instanceof Bundle) == false) goto L35;
        r0.putBundle(r4, (Bundle) r5);
        goto L92
    L35:
        if ((r5 instanceof CharSequence) == false) goto L38;
        r0.putCharSequence(r4, (CharSequence) r5);
        goto L92
    L38:
        if ((r5 instanceof Parcelable) == false) goto L41;
        r0.putParcelable(r4, (Parcelable) r5);
        goto L92
    L41:
        if ((r5 instanceof boolean[]) == false) goto L44;
        r0.putBooleanArray(r4, (boolean[]) r5);
        goto L92
    L44:
        if ((r5 instanceof byte[]) == false) goto L47;
        r0.putByteArray(r4, (byte[]) r5);
        goto L92
    L47:
        if ((r5 instanceof char[]) == false) goto L50;
        r0.putCharArray(r4, (char[]) r5);
        goto L92
    L50:
        if ((r5 instanceof double[]) == false) goto L53;
        r0.putDoubleArray(r4, (double[]) r5);
        goto L92
    L53:
        if ((r5 instanceof float[]) == false) goto L56;
        r0.putFloatArray(r4, (float[]) r5);
        goto L92
    L56:
        if ((r5 instanceof int[]) == false) goto L59;
        r0.putIntArray(r4, (int[]) r5);
        goto L92
    L59:
        if ((r5 instanceof long[]) == false) goto L62;
        r0.putLongArray(r4, (long[]) r5);
        goto L92
    L62:
        if ((r5 instanceof short[]) == false) goto L65;
        r0.putShortArray(r4, (short[]) r5);
        goto L92
    L65:
        if ((r5 instanceof Object[]) == false) goto L81;
        Class<?> r6 = r5.getClass().getComponentType();
        Intrinsics.checkNotNull(r6);
        if (Parcelable.class.isAssignableFrom(r6) == false) goto L70;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Array<android.os.Parcelable>");
        r0.putParcelableArray(r4, (Parcelable[]) r5);
        goto L92
    L70:
        if (String.class.isAssignableFrom(r6) == false) goto L73;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
        r0.putStringArray(r4, (String[]) r5);
        goto L92
    L73:
        if (CharSequence.class.isAssignableFrom(r6) == false) goto L76;
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type kotlin.Array<kotlin.CharSequence>");
        r0.putCharSequenceArray(r4, (CharSequence[]) r5);
        goto L92
    L76:
        if (Serializable.class.isAssignableFrom(r6) == false) goto L79;
        r0.putSerializable(r4, (Serializable) r5);
        goto L92
    L79:
        throw new IllegalArgumentException("Illegal value array type " + r6.getCanonicalName() + " for key \"" + r4 + '\"');
    L81:
        if ((r5 instanceof Serializable) == false) goto L84;
        r0.putSerializable(r4, (Serializable) r5);
        goto L92
    L84:
        if ((r5 instanceof IBinder) == false) goto L87;
        BundleApi18ImplKt.putBinder(r0, r4, (IBinder) r5);
        goto L92
    L87:
        if ((r5 instanceof Size) == false) goto L90;
        BundleApi21ImplKt.putSize(r0, r4, (Size) r5);
        goto L92
    L90:
        if ((r5 instanceof SizeF) == false) goto L94;
        BundleApi21ImplKt.putSizeF(r0, r4, (SizeF) r5);
        goto L92
    L94:
        throw new IllegalArgumentException("Illegal value type " + r5.getClass().getCanonicalName() + " for key \"" + r4 + '\"');
    L95:
        return r0;
    }

    public static final Bundle bundleOf() {
        return new Bundle(0);
    }
}
