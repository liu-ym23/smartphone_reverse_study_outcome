package androidx.fragment.app;

import androidx.annotation.NonNull;
import androidx.collection.SimpleArrayMap;

/* JADX INFO: loaded from: classes.dex */
public class FragmentFactory {
    private static final SimpleArrayMap<ClassLoader, SimpleArrayMap<String, Class<?>>> sClassCacheMap = null;

    static {
        sClassCacheMap = new SimpleArrayMap();
    }

    public FragmentFactory() {
    }

    static boolean isFragmentClass(@NonNull ClassLoader r0, @NonNull String r1) {
        return Fragment.class.isAssignableFrom(loadClass(r0, r1));
    L4:
        return false;
    }

    @NonNull
    private static Class<?> loadClass(@NonNull ClassLoader r2, @NonNull String r3) {
        SimpleArrayMap<ClassLoader, SimpleArrayMap<String, Class<?>>> r0 = sClassCacheMap;
        SimpleArrayMap<String, Class<?>> r1 = r0.get(r2);
        if (r1 != null) goto L5;
        r1 = new SimpleArrayMap();
        r0.put(r2, r1);
    L5:
        Class<?> r4 = r1.get(r3);
        if (r4 != null) goto L9;
        Class<?> r5 = Class.forName(r3, false, r2);
        r1.put(r3, r5);
        return r5;
    L9:
        return r4;
    }

    @NonNull
    public static Class<? extends Fragment> loadFragmentClass(@NonNull ClassLoader r3, @NonNull String r4) {
        return loadClass(r3, r4);
    L5:
        e = move-exception;
        throw new Fragment.InstantiationException("Unable to instantiate fragment " + r4 + ": make sure class is a valid subclass of Fragment", e);
    L8:
        e = move-exception;
        throw new Fragment.InstantiationException("Unable to instantiate fragment " + r4 + ": make sure class name exists", e);
    }

    @NonNull
    public Fragment instantiate(@NonNull ClassLoader r4, @NonNull String r5) {
        return loadFragmentClass(r4, r5).getConstructor(new Class[0]).newInstance(new Object[0]);
    L11:
        e = move-exception;
        throw new Fragment.InstantiationException("Unable to instantiate fragment " + r5 + ": make sure class name exists, is public, and has an empty constructor that is public", e);
    L14:
        e = move-exception;
        throw new Fragment.InstantiationException("Unable to instantiate fragment " + r5 + ": make sure class name exists, is public, and has an empty constructor that is public", e);
    L8:
        e = move-exception;
        throw new Fragment.InstantiationException("Unable to instantiate fragment " + r5 + ": could not find Fragment constructor", e);
    L5:
        e = move-exception;
        throw new Fragment.InstantiationException("Unable to instantiate fragment " + r5 + ": calling Fragment constructor caused an exception", e);
    }
}
