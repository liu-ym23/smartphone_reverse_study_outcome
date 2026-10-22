package androidx.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class GhostViewPlatform implements GhostView {
    private static final String TAG = "GhostViewApi21";
    private static Method sAddGhostMethod;
    private static boolean sAddGhostMethodFetched;
    private static Class<?> sGhostViewClass;
    private static boolean sGhostViewClassFetched;
    private static Method sRemoveGhostMethod;
    private static boolean sRemoveGhostMethodFetched;
    private final View mGhostView;

    private GhostViewPlatform(@NonNull View r1) {
        this.mGhostView = r1;
    }

    static GhostView addGhost(View r5, ViewGroup r6, Matrix r7) {
        fetchAddGhostMethod();
        Method r0 = sAddGhostMethod;
        if (r0 != null) goto L11;
    L9:
        return null;
    L11:
        return new GhostViewPlatform((View) r0.invoke(null, new Object[]{r5, r6, r7}));
    L6:
        e = move-exception;
        throw new RuntimeException(e.getCause());
    }

    private static void fetchAddGhostMethod() {
        if (sAddGhostMethodFetched == false) goto L11;
        return;
    L11:
        fetchGhostViewClass();     // Catch: NoSuchMethodException -> L7
        Method r1 = sGhostViewClass.getDeclaredMethod("addGhost", new Class[]{View.class, ViewGroup.class, Matrix.class});     // Catch: NoSuchMethodException -> L7
        sAddGhostMethod = r1;     // Catch: NoSuchMethodException -> L7
        r1.setAccessible(true);     // Catch: NoSuchMethodException -> L7
    L9:
        sAddGhostMethodFetched = true;
        return;
    L7:
        e = move-exception;
        Log.i(TAG, "Failed to retrieve addGhost method", e);
        goto L9
    }

    private static void fetchGhostViewClass() {
        if (sGhostViewClassFetched == true) goto L12;
        sGhostViewClass = Class.forName("android.view.GhostView");     // Catch: ClassNotFoundException -> L6
    L8:
        sGhostViewClassFetched = true;
        return;
    L6:
        e = move-exception;
        Log.i(TAG, "Failed to retrieve GhostView class", e);
        goto L8
    }

    private static void fetchRemoveGhostMethod() {
        if (sRemoveGhostMethodFetched == false) goto L11;
        return;
    L11:
        fetchGhostViewClass();     // Catch: NoSuchMethodException -> L7
        Method r1 = sGhostViewClass.getDeclaredMethod("removeGhost", new Class[]{View.class});     // Catch: NoSuchMethodException -> L7
        sRemoveGhostMethod = r1;     // Catch: NoSuchMethodException -> L7
        r1.setAccessible(true);     // Catch: NoSuchMethodException -> L7
    L9:
        sRemoveGhostMethodFetched = true;
        return;
    L7:
        e = move-exception;
        Log.i(TAG, "Failed to retrieve removeGhost method", e);
        goto L9
    }

    static void removeGhost(View r4) {
        fetchRemoveGhostMethod();
        Method r0 = sRemoveGhostMethod;
        if (r0 != null) goto L12;
        return;
    L12:
        r0.invoke(null, new Object[]{r4});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L11
        goto L15
    L14:
        return;
    L7:
        e = move-exception;
        throw new RuntimeException(e.getCause());
    }

    @Override // androidx.transition.GhostView
    public void reserveEndViewTransition(ViewGroup r1, View r2) {
    }

    @Override // androidx.transition.GhostView
    public void setVisibility(int r1) {
        this.mGhostView.setVisibility(r1);
    }
}
