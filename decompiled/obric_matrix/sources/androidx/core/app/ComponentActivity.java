package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import androidx.core.os.BuildCompat;
import androidx.core.view.KeyEventDispatcher;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ReportFragment;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class ComponentActivity extends Activity implements LifecycleOwner, KeyEventDispatcher.Component {
    private SimpleArrayMap<Class<? extends ExtraData>, ExtraData> mExtraDataMap;
    private LifecycleRegistry mLifecycleRegistry;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static class ExtraData {
        public ExtraData() {
        }
    }

    public ComponentActivity() {
        this.mExtraDataMap = new SimpleArrayMap();
        this.mLifecycleRegistry = new LifecycleRegistry(this);
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    private static boolean shouldSkipDump(@Nullable String[] r5) {
        int r0 = Build.VERSION.SDK_INT;
        if (r5 != null) goto L5;
        return false;
    L5:
        if (r5.length <= 0) goto L48;
        String r6 = r5[0];
        r6.hashCode();
        byte r2 = -1;
        switch(r6.hashCode()) {
            case -645125871: goto L26;
            case 100470631: goto L22;
            case 472614934: goto L18;
            case 1159329357: goto L14;
            case 1455016274: goto L10;
            default: goto L29;
        };
    L29:
        switch(r2) {
            case 0: goto L42;
            case 1: goto L40;
            case 2: goto L40;
            case 3: goto L36;
            case 4: goto L32;
            default: goto L50;
        };
    L50:
        return false;
    L32:
        if (r0 >= 26) goto L34;
        return false;
    L34:
        return true;
    L36:
        if (r0 >= 29) goto L38;
        return false;
    L38:
        return true;
    L40:
        return BuildCompat.isAtLeastT();
    L42:
        if (r0 >= 31) goto L44;
        return false;
    L44:
        return true;
    L10:
        if (r6.equals("--autofill") == false) goto L29;
        r2 = 4;
        goto L29
    L14:
        if (r6.equals("--contentcapture") == false) goto L29;
        r2 = 3;
        goto L29
    L18:
        if (r6.equals("--list-dumpables") == false) goto L29;
        r2 = 2;
        goto L29
    L22:
        if (r6.equals("--dump-dumpable") == false) goto L29;
        r2 = 1;
        goto L29
    L26:
        if (r6.equals("--translation") == false) goto L29;
        r2 = 0;
        goto L29
    L48:
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent r3) {
        View r0 = getWindow().getDecorView();
        if (r0 == null) goto L9;
        if (KeyEventDispatcher.dispatchBeforeHierarchy(r0, r3) == false) goto L9;
        return true;
    L9:
        return KeyEventDispatcher.dispatchKeyEvent(this, r0, this, r3);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent r2) {
        View r0 = getWindow().getDecorView();
        if (r0 == null) goto L9;
        if (KeyEventDispatcher.dispatchBeforeHierarchy(r0, r2) == false) goto L9;
        return true;
    L9:
        return super.dispatchKeyShortcutEvent(r2);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public <T extends ExtraData> T getExtraData(Class<T> r1) {
        return (T) this.mExtraDataMap.get(r1);
    }

    @NonNull
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Override // android.app.Activity
    @SuppressLint({"RestrictedApi"})
    protected void onCreate(@Nullable Bundle r1) {
        super.onCreate(r1);
        ReportFragment.injectIfNeededIn(this);
    }

    @Override // android.app.Activity
    @CallSuper
    protected void onSaveInstanceState(@NonNull Bundle r3) {
        this.mLifecycleRegistry.markState(Lifecycle.State.CREATED);
        super.onSaveInstanceState(r3);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public void putExtraData(ExtraData r2) {
        this.mExtraDataMap.put((Class<? extends ExtraData>) r2.getClass(), r2);
    }

    protected final boolean shouldDumpInternalState(@Nullable String[] r1) {
        return !shouldSkipDump(r1);
    }

    @Override // androidx.core.view.KeyEventDispatcher.Component
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean superDispatchKeyEvent(@NonNull KeyEvent r1) {
        return super.dispatchKeyEvent(r1);
    }
}
