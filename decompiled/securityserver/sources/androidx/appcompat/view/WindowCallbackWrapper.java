package androidx.appcompat.view;

import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class WindowCallbackWrapper implements Window.Callback {
    final Window.Callback mWrapped;

    public WindowCallbackWrapper(Window.Callback r1) {
        if (r1 == null) goto L7;
        this.mWrapped = r1;
        return;
    L7:
        throw new IllegalArgumentException("Window callback may not be null");
    }

    @Override // android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent r1) {
        return this.mWrapped.dispatchGenericMotionEvent(r1);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent r1) {
        return this.mWrapped.dispatchKeyEvent(r1);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent r1) {
        return this.mWrapped.dispatchKeyShortcutEvent(r1);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r1) {
        return this.mWrapped.dispatchPopulateAccessibilityEvent(r1);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent r1) {
        return this.mWrapped.dispatchTouchEvent(r1);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent r1) {
        return this.mWrapped.dispatchTrackballEvent(r1);
    }

    public final Window.Callback getWrapped() {
        return this.mWrapped;
    }

    @Override // android.view.Window.Callback
    public void onActionModeFinished(android.view.ActionMode r1) {
        this.mWrapped.onActionModeFinished(r1);
    }

    @Override // android.view.Window.Callback
    public void onActionModeStarted(android.view.ActionMode r1) {
        this.mWrapped.onActionModeStarted(r1);
    }

    @Override // android.view.Window.Callback
    public void onAttachedToWindow() {
        this.mWrapped.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public void onContentChanged() {
        this.mWrapped.onContentChanged();
    }

    @Override // android.view.Window.Callback
    public boolean onCreatePanelMenu(int r1, Menu r2) {
        return this.mWrapped.onCreatePanelMenu(r1, r2);
    }

    @Override // android.view.Window.Callback
    public View onCreatePanelView(int r1) {
        return this.mWrapped.onCreatePanelView(r1);
    }

    @Override // android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.mWrapped.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public boolean onMenuItemSelected(int r1, MenuItem r2) {
        return this.mWrapped.onMenuItemSelected(r1, r2);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuOpened(int r1, Menu r2) {
        return this.mWrapped.onMenuOpened(r1, r2);
    }

    @Override // android.view.Window.Callback
    public void onPanelClosed(int r1, Menu r2) {
        this.mWrapped.onPanelClosed(r1, r2);
    }

    @Override // android.view.Window.Callback
    @RequiresApi(26)
    public void onPointerCaptureChanged(boolean r1) {
        this.mWrapped.onPointerCaptureChanged(r1);
    }

    @Override // android.view.Window.Callback
    public boolean onPreparePanel(int r1, View r2, Menu r3) {
        return this.mWrapped.onPreparePanel(r1, r2, r3);
    }

    @Override // android.view.Window.Callback
    @RequiresApi(24)
    public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> r1, Menu r2, int r3) {
        this.mWrapped.onProvideKeyboardShortcuts(r1, r2, r3);
    }

    @Override // android.view.Window.Callback
    @RequiresApi(23)
    public boolean onSearchRequested(SearchEvent r1) {
        return this.mWrapped.onSearchRequested(r1);
    }

    @Override // android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams r1) {
        this.mWrapped.onWindowAttributesChanged(r1);
    }

    @Override // android.view.Window.Callback
    public void onWindowFocusChanged(boolean r1) {
        this.mWrapped.onWindowFocusChanged(r1);
    }

    @Override // android.view.Window.Callback
    public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback r1) {
        return this.mWrapped.onWindowStartingActionMode(r1);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested() {
        return this.mWrapped.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    @RequiresApi(23)
    public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback r1, int r2) {
        return this.mWrapped.onWindowStartingActionMode(r1, r2);
    }
}
