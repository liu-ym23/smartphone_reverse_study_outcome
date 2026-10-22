package androidx.core.os;

import android.os.PersistableBundle;
import com.bytedance.apm.constant.PerfConsts;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PersistableBundle.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J$\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0007¨\u0006\r"}, d2 = {"Landroidx/core/os/PersistableBundleApi21ImplKt;", "", "()V", "createPersistableBundle", "Landroid/os/PersistableBundle;", PerfConsts.KEY_CURRENT_CAPACITY, "", "putValue", "", "persistableBundle", "key", "", "value", "core-ktx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class PersistableBundleApi21ImplKt {
    public static final PersistableBundleApi21ImplKt INSTANCE = null;

    static {
        INSTANCE = new PersistableBundleApi21ImplKt();
    }

    private PersistableBundleApi21ImplKt() {
    }

    @JvmStatic
    public static final PersistableBundle createPersistableBundle(int r1) {
        return new PersistableBundle(r1);
    }

    @JvmStatic
    public static final void putValue(PersistableBundle r4, String r5, Object r6) {
        Intrinsics.checkNotNullParameter(r4, "persistableBundle");
        if (r6 != null) goto L6;
        r4.putString(r5, null);
        return;
    L6:
        if ((r6 instanceof Boolean) == false) goto L9;
        PersistableBundleApi22ImplKt.putBoolean(r4, r5, ((Boolean) r6).booleanValue());
        return;
    L9:
        if ((r6 instanceof Double) == false) goto L12;
        r4.putDouble(r5, ((Number) r6).doubleValue());
        return;
    L12:
        if ((r6 instanceof Integer) == false) goto L15;
        r4.putInt(r5, ((Number) r6).intValue());
        return;
    L15:
        if ((r6 instanceof Long) == false) goto L18;
        r4.putLong(r5, ((Number) r6).longValue());
        return;
    L18:
        if ((r6 instanceof String) == false) goto L21;
        r4.putString(r5, (String) r6);
        return;
    L21:
        if ((r6 instanceof boolean[]) == false) goto L24;
        PersistableBundleApi22ImplKt.putBooleanArray(r4, r5, (boolean[]) r6);
        return;
    L24:
        if ((r6 instanceof double[]) == false) goto L27;
        r4.putDoubleArray(r5, (double[]) r6);
        return;
    L27:
        if ((r6 instanceof int[]) == false) goto L30;
        r4.putIntArray(r5, (int[]) r6);
        return;
    L30:
        if ((r6 instanceof long[]) == false) goto L33;
        r4.putLongArray(r5, (long[]) r6);
        return;
    L33:
        if ((r6 instanceof Object[]) == false) goto L41;
        Class<?> r0 = r6.getClass().getComponentType();
        Intrinsics.checkNotNull(r0);
        if (String.class.isAssignableFrom(r0) == false) goto L39;
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
        r4.putStringArray(r5, (String[]) r6);
        return;
    L39:
        throw new IllegalArgumentException("Illegal value array type " + r0.getCanonicalName() + " for key \"" + r5 + '\"');
    L41:
        throw new IllegalArgumentException("Illegal value type " + r6.getClass().getCanonicalName() + " for key \"" + r5 + '\"');
    }
}
