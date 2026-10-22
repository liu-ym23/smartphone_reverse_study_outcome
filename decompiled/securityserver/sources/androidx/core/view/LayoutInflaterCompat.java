package androidx.core.view;

import android.content.Context;
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

    public static class Factory2Wrapper implements LayoutInflater.Factory2 {
        final LayoutInflaterFactory mDelegateFactory;

        public Factory2Wrapper(LayoutInflaterFactory r1) {
            this.mDelegateFactory = r1;
        }

        @Override // android.view.LayoutInflater.Factory
        public View onCreateView(String r2, Context r3, AttributeSet r4) {
            return this.mDelegateFactory.onCreateView(null, r2, r3, r4);
        }

        @NonNull
        public String toString() {
            return getClass().getName() + "{" + this.mDelegateFactory + "}";
        }

        @Override // android.view.LayoutInflater.Factory2
        public View onCreateView(View r1, String r2, Context r3, AttributeSet r4) {
            return this.mDelegateFactory.onCreateView(r1, r2, r3, r4);
        }
    }

    private LayoutInflaterCompat() {
    }

    private static void forceSetFactory2(LayoutInflater r7, LayoutInflater.Factory2 r8) {
        if (sCheckedField == false) goto L17;
    L10:
        Field r0 = sLayoutInflaterFactory2Field;
        if (r0 == null) goto L21;
        r0.set(r7, r8);     // Catch: IllegalAccessException -> L14
        return;
    L14:
        e = move-exception;
        Log.e(TAG, "forceSetFactory2 could not set the Factory2 on LayoutInflater " + r7 + "; inflation may have unexpected results.", e);
        return;
    L21:
        return;
    L17:
        Field r4 = LayoutInflater.class.getDeclaredField("mFactory2");     // Catch: NoSuchFieldException -> L7
        sLayoutInflaterFactory2Field = r4;     // Catch: NoSuchFieldException -> L7
        r4.setAccessible(true);     // Catch: NoSuchFieldException -> L7
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
    public static void setFactory(@NonNull LayoutInflater r1, @NonNull LayoutInflaterFactory r2) {
        if (r2 == null) goto L4;
        Factory2Wrapper r0 = new Factory2Wrapper(r2);
    L5:
        r1.setFactory2(r0);
        return;
    L4:
        r0 = null;
        goto L5
    }

    public static void setFactory2(@NonNull LayoutInflater r0, @NonNull LayoutInflater.Factory2 r1) {
        r0.setFactory2(r1);
    }
}
