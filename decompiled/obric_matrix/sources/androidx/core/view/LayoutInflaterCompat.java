package androidx.core.view;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class LayoutInflaterCompat {
    private static final String TAG = "LayoutInflaterCompatHC";
    private static boolean sCheckedField;
    private static Field sLayoutInflaterFactory2Field;

    static class Factory2Wrapper implements LayoutInflater.Factory2 {
        final LayoutInflaterFactory mDelegateFactory;

        Factory2Wrapper(LayoutInflaterFactory r1) {
            this.mDelegateFactory = r1;
        }

        @Override // android.view.LayoutInflater.Factory2
        public View onCreateView(View r1, String r2, Context r3, AttributeSet r4) {
            return this.mDelegateFactory.onCreateView(r1, r2, r3, r4);
        }

        @Override // android.view.LayoutInflater.Factory
        public View onCreateView(String r2, Context r3, AttributeSet r4) {
            return this.mDelegateFactory.onCreateView(null, r2, r3, r4);
        }

        @NonNull
        public String toString() {
            return getClass().getName() + "{" + this.mDelegateFactory + "}";
        }
    }

    private LayoutInflaterCompat() {
    }

    private static void forceSetFactory2(LayoutInflater r6, LayoutInflater.Factory2 r7) {
        if (sCheckedField == false) goto L17;
    L10:
        Field r0 = sLayoutInflaterFactory2Field;
        if (r0 == null) goto L21;
        r0.set(r6, r7);     // Catch: IllegalAccessException -> L14
        return;
    L14:
        e = move-exception;
        Log.e(TAG, "forceSetFactory2 could not set the Factory2 on LayoutInflater " + r6 + "; inflation may have unexpected results.", e);
        return;
    L21:
        return;
    L17:
        Field r3 = LayoutInflater.class.getDeclaredField("mFactory2");     // Catch: NoSuchFieldException -> L7
        sLayoutInflaterFactory2Field = r3;     // Catch: NoSuchFieldException -> L7
        r3.setAccessible(true);     // Catch: NoSuchFieldException -> L7
    L9:
        sCheckedField = true;
    L7:
        e = move-exception;
        Log.e(TAG, "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
        goto L9
    }

    @Deprecated
    public static LayoutInflaterFactory getFactory(LayoutInflater r1) {
        LayoutInflater.Factory r2 = r1.getFactory();
        if ((r2 instanceof Factory2Wrapper) == true) goto L5;
        return null;
    L5:
        return ((Factory2Wrapper) r2).mDelegateFactory;
    }

    @Deprecated
    public static void setFactory(@NonNull LayoutInflater r2, @NonNull LayoutInflaterFactory r3) {
        if (Build.VERSION.SDK_INT < 21) goto L5;
        r2.setFactory2(new Factory2Wrapper(r3));
        return;
    L5:
        Factory2Wrapper r0 = new Factory2Wrapper(r3);
        r2.setFactory2(r0);
        LayoutInflater.Factory r4 = r2.getFactory();
        if ((r4 instanceof LayoutInflater.Factory2) == false) goto L8;
        forceSetFactory2(r2, (LayoutInflater.Factory2) r4);
        return;
    L8:
        forceSetFactory2(r2, r0);
    }

    public static void setFactory2(@NonNull LayoutInflater r2, @NonNull LayoutInflater.Factory2 r3) {
        r2.setFactory2(r3);
        if (Build.VERSION.SDK_INT >= 21) goto L9;
        LayoutInflater.Factory r0 = r2.getFactory();
        if ((r0 instanceof LayoutInflater.Factory2) == false) goto L7;
        forceSetFactory2(r2, (LayoutInflater.Factory2) r0);
        return;
    L7:
        forceSetFactory2(r2, r3);
        return;
    }
}
