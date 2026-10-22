package androidx.core.graphics;

import android.graphics.Typeface;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.reflect.Array;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(28)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class TypefaceCompatApi28Impl extends TypefaceCompatApi26Impl {
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    private static final String DEFAULT_FAMILY = "sans-serif";
    private static final int RESOLVE_BY_FONT_TABLE = -1;

    public TypefaceCompatApi28Impl() {
    }

    @Override // androidx.core.graphics.TypefaceCompatApi26Impl
    public Typeface createFromFamiliesWithDefault(Object r4) {
        Object r0 = Array.newInstance(this.mFontFamily, 1);     // Catch: Throwable -> L4
        Array.set(r0, 0, r4);     // Catch: Throwable -> L4
        return (Typeface) this.mCreateFromFamiliesWithDefault.invoke(null, new Object[]{r0, DEFAULT_FAMILY, -1, -1});
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // androidx.core.graphics.TypefaceCompatApi26Impl
    public Method obtainCreateFromFamiliesWithDefaultMethod(Class<?> r3) {
        Class<?> r4 = Array.newInstance(r3, 1).getClass();
        Class r1 = Integer.TYPE;
        Method r5 = Typeface.class.getDeclaredMethod(CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD, new Class[]{r4, String.class, r1, r1});
        r5.setAccessible(true);
        return r5;
    }
}
