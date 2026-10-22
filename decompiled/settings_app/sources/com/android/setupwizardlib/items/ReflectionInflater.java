package com.android.setupwizardlib.items;

import android.content.Context;
import android.util.AttributeSet;
import android.view.InflateException;
import java.lang.reflect.Constructor;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class ReflectionInflater<T> extends SimpleInflater<T> {
    private static final Class<?>[] CONSTRUCTOR_SIGNATURE = null;
    private static final HashMap<String, Constructor<?>> constructorMap = null;
    private final Context context;
    private String defaultPackage;
    private final Object[] tempConstructorArgs;

    static {
        CONSTRUCTOR_SIGNATURE = new Class[]{Context.class, AttributeSet.class};
        constructorMap = new HashMap();
    }

    protected ReflectionInflater(Context r2) {
        super(r2.getResources());
        this.tempConstructorArgs = new Object[2];
        this.context = r2;
    }

    public Context getContext() {
        return this.context;
    }

    public final T createItem(String r5, String r6, AttributeSet r7) {
        if (r6 != null) goto L4;
    L6:
        String r8 = r5;
    L7:
        HashMap<String, Constructor<?>> r0 = constructorMap;
        Constructor<?> r1 = r0.get(r8);
        if (r1 == null) goto L15;
    L10:
        Object[] r9 = this.tempConstructorArgs;     // Catch: Exception -> L12
        r9[0] = this.context;     // Catch: Exception -> L12
        r9[1] = r7;     // Catch: Exception -> L12
        T r10 = (T) r1.newInstance(r9);
        Object[] r4 = this.tempConstructorArgs;     // Catch: Exception -> L12
        r4[0] = null;     // Catch: Exception -> L12
        r4[1] = null;     // Catch: Exception -> L12
        return r10;
    L12:
        e = move-exception;
        throw new InflateException(r7.getPositionDescription() + ": Error inflating class " + r8, e);
    L15:
        r1 = this.context.getClassLoader().loadClass(r8).getConstructor(CONSTRUCTOR_SIGNATURE);     // Catch: Exception -> L12
        r1.setAccessible(true);     // Catch: Exception -> L12
        r0.put(r5, r1);     // Catch: Exception -> L12
        goto L10
    L4:
        if (r5.indexOf(46) != (-1)) goto L6;
        r8 = r6.concat(r5);
        goto L7
    }

    @Override // com.android.setupwizardlib.items.SimpleInflater
    protected T onCreateItem(String r2, AttributeSet r3) {
        return createItem(r2, this.defaultPackage, r3);
    }

    public void setDefaultPackage(String r1) {
        this.defaultPackage = r1;
    }

    public String getDefaultPackage() {
        return this.defaultPackage;
    }
}
