package androidx.fragment.app;

import androidx.collection.SimpleArrayMap;

/* JADX INFO: loaded from: classes.dex */
public class FragmentFactory {
    private static final SimpleArrayMap<ClassLoader, SimpleArrayMap<String, Class<?>>> sClassCacheMap = null;

    public FragmentFactory() {
    }

    static {
        sClassCacheMap = new SimpleArrayMap();
    }

    private static Class<?> loadClass(ClassLoader r2, String r3) throws ClassNotFoundException {
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

    static boolean isFragmentClass(ClassLoader r0, String r1) {
        return Fragment.class.isAssignableFrom(loadClass(r0, r1));
    L4:
        return false;
    }

    public static Class<? extends Fragment> loadFragmentClass(ClassLoader r3, String r4) {
        return loadClass(r3, r4);
    L5:
        e = move-exception;
        throw new Fragment.InstantiationException("Unable to instantiate fragment " + r4 + ": make sure class is a valid subclass of Fragment", e);
    L8:
        e = move-exception;
        throw new Fragment.InstantiationException("Unable to instantiate fragment " + r4 + ": make sure class name exists", e);
    }

    public Fragment instantiate(ClassLoader r4, String r5) {
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
