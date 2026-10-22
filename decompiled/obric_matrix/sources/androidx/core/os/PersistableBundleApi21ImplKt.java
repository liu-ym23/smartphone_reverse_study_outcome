package androidx.core.os;

import android.os.Build;
import android.os.PersistableBundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J$\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0007¨\u0006\r"}, d2 = {"Landroidx/core/os/PersistableBundleApi21ImplKt;", "", "()V", "createPersistableBundle", "Landroid/os/PersistableBundle;", "capacity", "", "putValue", "", "persistableBundle", "key", "", "value", "core-ktx_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class PersistableBundleApi21ImplKt {
    public static final PersistableBundleApi21ImplKt INSTANCE = null;

    static {
        INSTANCE = new PersistableBundleApi21ImplKt();
    }

    private PersistableBundleApi21ImplKt() {
    }

    @DoNotInline
    public static final PersistableBundle createPersistableBundle(int r1) {
        return new PersistableBundle(r1);
    }

    @DoNotInline
    public static final void putValue(PersistableBundle r4, String r5, Object r6) {
        int r0 = Build.VERSION.SDK_INT;
        o.f(r4, "persistableBundle");
        if (r6 != null) goto L7;
        String r7 = null;
    L5:
        r4.putString(r5, r7);
        return;
    L7:
        if ((r6 instanceof Boolean) == false) goto L13;
        if (r0 < 22) goto L11;
        PersistableBundleApi22ImplKt.putBoolean(r4, r5, ((Boolean) r6).booleanValue());
        return;
    L11:
        throw new IllegalArgumentException("Illegal value type boolean for key \"" + r5 + '\"');
    L13:
        if ((r6 instanceof Double) == false) goto L16;
        r4.putDouble(r5, ((Number) r6).doubleValue());
        return;
    L16:
        if ((r6 instanceof Integer) == false) goto L19;
        r4.putInt(r5, ((Number) r6).intValue());
        return;
    L19:
        if ((r6 instanceof Long) == false) goto L22;
        r4.putLong(r5, ((Number) r6).longValue());
        return;
    L22:
        if ((r6 instanceof String) == false) goto L25;
        r7 = (String) r6;
        goto L5
    L25:
        if ((r6 instanceof boolean[]) == false) goto L31;
        if (r0 < 22) goto L29;
        PersistableBundleApi22ImplKt.putBooleanArray(r4, r5, (boolean[]) r6);
        return;
    L29:
        throw new IllegalArgumentException("Illegal value type boolean[] for key \"" + r5 + '\"');
    L31:
        if ((r6 instanceof double[]) == false) goto L34;
        r4.putDoubleArray(r5, (double[]) r6);
        return;
    L34:
        if ((r6 instanceof int[]) == false) goto L37;
        r4.putIntArray(r5, (int[]) r6);
        return;
    L37:
        if ((r6 instanceof long[]) == false) goto L40;
        r4.putLongArray(r5, (long[]) r6);
        return;
    L40:
        if ((r6 instanceof Object[]) == false) goto L48;
        Class<?> r1 = r6.getClass().getComponentType();
        o.c(r1);
        if (String.class.isAssignableFrom(r1) == false) goto L46;
        o.d(r6, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
        r4.putStringArray(r5, (String[]) r6);
        return;
    L46:
        throw new IllegalArgumentException("Illegal value array type " + r1.getCanonicalName() + " for key \"" + r5 + '\"');
    L48:
        throw new IllegalArgumentException("Illegal value type " + r6.getClass().getCanonicalName() + " for key \"" + r5 + '\"');
    }
}
