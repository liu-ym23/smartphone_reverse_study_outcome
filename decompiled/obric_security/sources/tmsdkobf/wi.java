package tmsdkobf;

import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class wi implements Window.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Window.Callback f604a;

    public wi(Window.Callback r1) {
        if (r1 == null) goto L7;
        this.f604a = r1;
        return;
    L7:
        throw new IllegalArgumentException("Window callback may not be null");
    }

    @Override // android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent r1) {
        return this.f604a.dispatchGenericMotionEvent(r1);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent r1) {
        return this.f604a.dispatchKeyEvent(r1);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent r1) {
        return this.f604a.dispatchKeyShortcutEvent(r1);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r1) {
        return this.f604a.dispatchPopulateAccessibilityEvent(r1);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent r1) {
        return this.f604a.dispatchTouchEvent(r1);
    L4:
        return true;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent r1) {
        return this.f604a.dispatchTrackballEvent(r1);
    }

    @Override // android.view.Window.Callback
    public void onActionModeFinished(ActionMode r1) {
        this.f604a.onActionModeFinished(r1);
    }

    @Override // android.view.Window.Callback
    public void onActionModeStarted(ActionMode r1) {
        this.f604a.onActionModeStarted(r1);
    }

    @Override // android.view.Window.Callback
    public void onAttachedToWindow() {
        this.f604a.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public void onContentChanged() {
        this.f604a.onContentChanged();
    }

    @Override // android.view.Window.Callback
    public boolean onCreatePanelMenu(int r1, Menu r2) {
        return this.f604a.onCreatePanelMenu(r1, r2);
    }

    @Override // android.view.Window.Callback
    public View onCreatePanelView(int r1) {
        return this.f604a.onCreatePanelView(r1);
    }

    @Override // android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.f604a.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public boolean onMenuItemSelected(int r1, MenuItem r2) {
        return this.f604a.onMenuItemSelected(r1, r2);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuOpened(int r1, Menu r2) {
        return this.f604a.onMenuOpened(r1, r2);
    }

    @Override // android.view.Window.Callback
    public void onPanelClosed(int r1, Menu r2) {
        this.f604a.onPanelClosed(r1, r2);
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean r1) {
        this.f604a.onPointerCaptureChanged(r1);
    }

    @Override // android.view.Window.Callback
    public boolean onPreparePanel(int r1, View r2, Menu r3) {
        return this.f604a.onPreparePanel(r1, r2, r3);
    }

    @Override // android.view.Window.Callback
    public void onProvideKeyboardShortcuts(List r1, Menu r2, int r3) {
        this.f604a.onProvideKeyboardShortcuts(r1, r2, r3);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested(SearchEvent r1) {
        return this.f604a.onSearchRequested(r1);
    }

    @Override // android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams r1) {
        this.f604a.onWindowAttributesChanged(r1);     // Catch: Throwable -> L4
        return;
    }

    @Override // android.view.Window.Callback
    public void onWindowFocusChanged(boolean r1) {
        this.f604a.onWindowFocusChanged(r1);
    }

    @Override // android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback r1) {
        return this.f604a.onWindowStartingActionMode(r1);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested() {
        return this.f604a.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public ActionMode onWindowStartingActionMode(ActionMode.Callback r1, int r2) {
        return this.f604a.onWindowStartingActionMode(r1, r2);
    }
}
