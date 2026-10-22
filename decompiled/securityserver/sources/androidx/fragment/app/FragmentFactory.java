package androidx.fragment.app;

import a.a;
import androidx.annotation.NonNull;
import androidx.collection.SimpleArrayMap;

/* JADX INFO: loaded from: classes.dex */
public class FragmentFactory {
    private static final SimpleArrayMap<String, Class<?>> sClassMap = null;

    static {
        sClassMap = new SimpleArrayMap();
    }

    public FragmentFactory() {
    }

    public static boolean isFragmentClass(@NonNull ClassLoader r0, @NonNull String r1) {
        return Fragment.class.isAssignableFrom(loadClass(r0, r1));
    L4:
        return false;
    }

    @NonNull
    private static Class<?> loadClass(@NonNull ClassLoader r2, @NonNull String r3) {
        SimpleArrayMap<String, Class<?>> r0 = sClassMap;
        Class<?> r1 = r0.get(r3);
        if (r1 != null) goto L6;
        Class<?> r4 = Class.forName(r3, false, r2);
        r0.put(r3, r4);
        return r4;
    L6:
        return r1;
    }

    @NonNull
    public static Class<? extends Fragment> loadFragmentClass(@NonNull ClassLoader r3, @NonNull String r4) {
        return loadClass(r3, r4);
    L5:
        e = move-exception;
        throw new Fragment.InstantiationException(a.k("Unable to instantiate fragment ", r4, ": make sure class is a valid subclass of Fragment"), e);
    L8:
        e = move-exception;
        throw new Fragment.InstantiationException(a.k("Unable to instantiate fragment ", r4, ": make sure class name exists"), e);
    }

    @NonNull
    public Fragment instantiate(@NonNull ClassLoader r3, @NonNull String r4) {
        return loadFragmentClass(r3, r4).getConstructor(null).newInstance(null);
    L9:
        e = move-exception;
        throw new Fragment.InstantiationException(a.k("Unable to instantiate fragment ", r4, ": make sure class name exists, is public, and has an empty constructor that is public"), e);
    L11:
        e = move-exception;
        throw new Fragment.InstantiationException(a.k("Unable to instantiate fragment ", r4, ": make sure class name exists, is public, and has an empty constructor that is public"), e);
    L7:
        e = move-exception;
        throw new Fragment.InstantiationException(a.k("Unable to instantiate fragment ", r4, ": could not find Fragment constructor"), e);
    L5:
        e = move-exception;
        throw new Fragment.InstantiationException(a.k("Unable to instantiate fragment ", r4, ": calling Fragment constructor caused an exception"), e);
    }
}
