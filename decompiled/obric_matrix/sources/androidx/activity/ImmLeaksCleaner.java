package androidx.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(19)
final class ImmLeaksCleaner implements LifecycleEventObserver {
    private static final int INIT_FAILED = 2;
    private static final int INIT_SUCCESS = 1;
    private static final int NOT_INITIALIAZED = 0;
    private static Field sHField;
    private static Field sNextServedViewField;
    private static int sReflectedFieldsInitialized;
    private static Field sServedViewField;
    private Activity mActivity;

    static {
    }

    ImmLeaksCleaner(Activity r1) {
        this.mActivity = r1;
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    @MainThread
    private static void initializeReflectiveFields() {
        sReflectedFieldsInitialized = 2;     // Catch: NoSuchFieldException -> L5
        Field r0 = InputMethodManager.class.getDeclaredField("mServedView");     // Catch: NoSuchFieldException -> L5
        sServedViewField = r0;     // Catch: NoSuchFieldException -> L5
        r0.setAccessible(true);     // Catch: NoSuchFieldException -> L5
        Field r1 = InputMethodManager.class.getDeclaredField("mNextServedView");     // Catch: NoSuchFieldException -> L5
        sNextServedViewField = r1;     // Catch: NoSuchFieldException -> L5
        r1.setAccessible(true);     // Catch: NoSuchFieldException -> L5
        Field r2 = InputMethodManager.class.getDeclaredField("mH");     // Catch: NoSuchFieldException -> L5
        sHField = r2;     // Catch: NoSuchFieldException -> L5
        r2.setAccessible(true);     // Catch: NoSuchFieldException -> L5
        sReflectedFieldsInitialized = 1;     // Catch: NoSuchFieldException -> L5
        return;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner r2, @NonNull Lifecycle.Event r3) {
        if (r3 == Lifecycle.Event.ON_DESTROY) goto L6;
        return;
    L6:
        if (sReflectedFieldsInitialized != 0) goto L9;
        initializeReflectiveFields();
    L9:
        if (sReflectedFieldsInitialized != 1) goto L36;
        InputMethodManager r1 = (InputMethodManager) this.mActivity.getSystemService("input_method");
        Object r4 = sHField.get(r1);     // Catch: IllegalAccessException -> L37
        if (r4 != null) goto L14;
        return;
    L14:
        monitor-enter(r4);
        View r5 = (View) sServedViewField.get(r1);     // Catch: Throwable -> L28 ClassCastException -> L30 IllegalAccessException -> L32
        if (r5 != null) goto L20;
        monitor-exit(r4);     // Catch: Throwable -> L28
        return;
    L20:
        if (r5.isAttachedToWindow() == false) goto L38;
        monitor-exit(r4);     // Catch: Throwable -> L28
        return;
    L38:
        sNextServedViewField.set(r1, null);     // Catch: IllegalAccessException -> L26 Throwable -> L28
        monitor-exit(r4);     // Catch: Throwable -> L28
        r1.isActive();
        return;
    L27:
        return;
    L28:
        th = move-exception;
        throw th;
    L31:
        return;
    L33:
        return;
    L45:
        return;
    }
}
