package com.bytedance.apm.r.m;

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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
public abstract class h implements Window.Callback {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected Window.Callback f1951f;

    public h(Window.Callback r1) {
        this.f1951f = r1;
    }

    @Override // android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent r1) {
        return this.f1951f.dispatchGenericMotionEvent(r1);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent r1) {
        return this.f1951f.dispatchKeyShortcutEvent(r1);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r1) {
        return this.f1951f.dispatchPopulateAccessibilityEvent(r1);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent r1) {
        return this.f1951f.dispatchTrackballEvent(r1);
    }

    @Override // android.view.Window.Callback
    public void onActionModeFinished(ActionMode r1) {
        this.f1951f.onActionModeFinished(r1);
    }

    @Override // android.view.Window.Callback
    public void onActionModeStarted(ActionMode r1) {
        this.f1951f.onActionModeStarted(r1);
    }

    @Override // android.view.Window.Callback
    public void onAttachedToWindow() {
        this.f1951f.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public void onContentChanged() {
        this.f1951f.onContentChanged();
    }

    @Override // android.view.Window.Callback
    public boolean onCreatePanelMenu(int r1, @NonNull Menu r2) {
        return this.f1951f.onCreatePanelMenu(r1, r2);
    }

    @Override // android.view.Window.Callback
    @Nullable
    public View onCreatePanelView(int r1) {
        return this.f1951f.onCreatePanelView(r1);
    }

    @Override // android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.f1951f.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public boolean onMenuItemSelected(int r1, @NonNull MenuItem r2) {
        return this.f1951f.onMenuItemSelected(r1, r2);
    }

    @Override // android.view.Window.Callback
    public boolean onMenuOpened(int r1, @NonNull Menu r2) {
        return this.f1951f.onMenuOpened(r1, r2);
    }

    @Override // android.view.Window.Callback
    public void onPanelClosed(int r1, @NonNull Menu r2) {
        this.f1951f.onPanelClosed(r1, r2);
    }

    @Override // android.view.Window.Callback
    public boolean onPreparePanel(int r1, @Nullable View r2, @NonNull Menu r3) {
        return this.f1951f.onPreparePanel(r1, r2, r3);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested() {
        return this.f1951f.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested(SearchEvent r1) {
        return this.f1951f.onSearchRequested(r1);
    }

    @Override // android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams r1) {
        this.f1951f.onWindowAttributesChanged(r1);
    }

    @Override // android.view.Window.Callback
    public void onWindowFocusChanged(boolean r1) {
        this.f1951f.onWindowFocusChanged(r1);
    }

    @Override // android.view.Window.Callback
    @Nullable
    public ActionMode onWindowStartingActionMode(ActionMode.Callback r1) {
        return this.f1951f.onWindowStartingActionMode(r1);
    }

    @Override // android.view.Window.Callback
    @Nullable
    public ActionMode onWindowStartingActionMode(ActionMode.Callback r1, int r2) {
        return this.f1951f.onWindowStartingActionMode(r1, r2);
    }
}
