package androidx.core.view;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class KeyEventDispatcher {
    private static boolean sActionBarFieldsFetched = false;
    private static Method sActionBarOnMenuKeyMethod = null;
    private static boolean sDialogFieldsFetched = false;
    private static Field sDialogKeyListenerField;

    public interface Component {
        boolean superDispatchKeyEvent(KeyEvent r1);
    }

    static {
    }

    private KeyEventDispatcher() {
    }

    public static boolean dispatchBeforeHierarchy(View r0, KeyEvent r1) {
        return ViewCompat.dispatchUnhandledKeyEventBeforeHierarchy(r0, r1);
    }

    public static boolean dispatchKeyEvent(Component r0, View r1, Window.Callback r2, KeyEvent r3) {
        if (r0 != null) goto L6;
        return false;
    L6:
        return r0.superDispatchKeyEvent(r3);
    }

    private static boolean actionBarOnMenuKeyEventPre28(ActionBar r6, KeyEvent r7) {
        if (sActionBarFieldsFetched == false) goto L16;
    L6:
        Method r0 = sActionBarOnMenuKeyMethod;
        if (r0 != null) goto L18;
    L13:
        return false;
    L18:
        Object r8 = r0.invoke(r6, new Object[]{r7});     // Catch: Throwable -> L14
        if (r8 != null) goto L11;
        return false;
    L11:
        return ((Boolean) r8).booleanValue();
    L16:
        sActionBarOnMenuKeyMethod = r6.getClass().getMethod("onMenuKeyEvent", new Class[]{KeyEvent.class});     // Catch: NoSuchMethodException -> L15
    L5:
        sActionBarFieldsFetched = true;
        goto L6
    }

    private static boolean activitySuperDispatchKeyEventPre28(Activity r5, KeyEvent r6) {
        r5.onUserInteraction();
        Window r0 = r5.getWindow();
        if (r0.hasFeature(8) == false) goto L11;
        ActionBar r1 = r5.getActionBar();
        if (r6.getKeyCode() != 82) goto L11;
        if (r1 == null) goto L11;
        if (actionBarOnMenuKeyEventPre28(r1, r6) == false) goto L11;
        return true;
    L11:
        if (r0.superDispatchKeyEvent(r6) == false) goto L13;
        return true;
    L13:
        View r2 = r0.getDecorView();
        if (ViewCompat.dispatchUnhandledKeyEventBeforeCallback(r2, r6) == false) goto L16;
        return true;
    L16:
        if (r2 == null) goto L18;
        KeyEvent.DispatcherState r3 = r2.getKeyDispatcherState();
    L20:
        return r6.dispatch(r5, r3, r5);
    L18:
        r3 = null;
        goto L20
    }

    private static DialogInterface.OnKeyListener getDialogKeyListenerPre28(Dialog r3) {
        if (sDialogFieldsFetched == false) goto L17;
    L7:
        Field r0 = sDialogKeyListenerField;
        if (r0 != null) goto L15;
        return null;
    L15:
        return (DialogInterface.OnKeyListener) r0.get(r3);
    L19:
        return null;
    L17:
        Field r1 = Dialog.class.getDeclaredField("mOnKeyListener");     // Catch: NoSuchFieldException -> L13
        sDialogKeyListenerField = r1;     // Catch: NoSuchFieldException -> L13
        r1.setAccessible(true);     // Catch: NoSuchFieldException -> L13
    L6:
        sDialogFieldsFetched = true;
        goto L7
    }

    private static boolean dialogSuperDispatchKeyEventPre28(Dialog r3, KeyEvent r4) {
        DialogInterface.OnKeyListener r0 = getDialogKeyListenerPre28(r3);
        if (r0 != null) goto L5;
    L7:
        Window r1 = r3.getWindow();
        if (r1.superDispatchKeyEvent(r4) == false) goto L10;
        return true;
    L10:
        View r2 = r1.getDecorView();
        if (ViewCompat.dispatchUnhandledKeyEventBeforeCallback(r2, r4) == false) goto L13;
        return true;
    L13:
        if (r2 == null) goto L15;
        KeyEvent.DispatcherState r5 = r2.getKeyDispatcherState();
    L17:
        return r4.dispatch(r3, r5, r3);
    L15:
        r5 = null;
        goto L17
    L5:
        if (r0.onKey(r3, r4.getKeyCode(), r4) == false) goto L7;
        return true;
    }
}
