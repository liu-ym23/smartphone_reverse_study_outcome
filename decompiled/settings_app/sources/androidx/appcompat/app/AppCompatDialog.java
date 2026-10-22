package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentDialog;
import androidx.appcompat.R;
import androidx.appcompat.view.ActionMode;
import androidx.core.view.KeyEventDispatcher;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatDialog extends ComponentDialog implements AppCompatCallback {
    private AppCompatDelegate mDelegate;
    private final KeyEventDispatcher.Component mKeyDispatcher;

    @Override // androidx.appcompat.app.AppCompatCallback
    public void onSupportActionModeFinished(ActionMode r1) {
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public void onSupportActionModeStarted(ActionMode r1) {
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public ActionMode onWindowStartingSupportActionMode(ActionMode.Callback r1) {
        return null;
    }

    public AppCompatDialog(Context r2) {
        this(r2, 0);
    }

    public AppCompatDialog(Context r2, int r3) {
        super(r2, getThemeResId(r2, r3));
        this.mKeyDispatcher = new AppCompatDialog$$ExternalSyntheticLambda0(this);
        AppCompatDelegate r1 = getDelegate();
        r1.setTheme(getThemeResId(r2, r3));
        r1.onCreate(null);
    }

    protected AppCompatDialog(Context r1, boolean r2, DialogInterface.OnCancelListener r3) {
        super(r1);
        this.mKeyDispatcher = new AppCompatDialog$$ExternalSyntheticLambda0(this);
        setCancelable(r2);
        setOnCancelListener(r3);
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    protected void onCreate(Bundle r2) {
        getDelegate().installViewFactory();
        super.onCreate(r2);
        getDelegate().onCreate(r2);
    }

    public ActionBar getSupportActionBar() {
        return getDelegate().getSupportActionBar();
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(int r1) {
        getDelegate().setContentView(r1);
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View r1) {
        getDelegate().setContentView(r1);
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void setContentView(View r1, ViewGroup.LayoutParams r2) {
        getDelegate().setContentView(r1, r2);
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int r1) {
        return (T) getDelegate().findViewById(r1);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence r1) {
        super.setTitle(r1);
        getDelegate().setTitle(r1);
    }

    @Override // android.app.Dialog
    public void setTitle(int r2) {
        super.setTitle(r2);
        getDelegate().setTitle(getContext().getString(r2));
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    public void addContentView(View r1, ViewGroup.LayoutParams r2) {
        getDelegate().addContentView(r1, r2);
    }

    @Override // androidx.activity.ComponentDialog, android.app.Dialog
    protected void onStop() {
        super.onStop();
        getDelegate().onStop();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        getDelegate().onDestroy();
    }

    public boolean supportRequestWindowFeature(int r1) {
        return getDelegate().requestWindowFeature(r1);
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    public AppCompatDelegate getDelegate() {
        if (this.mDelegate != null) goto L6;
        this.mDelegate = AppCompatDelegate.create(this, this);
    L6:
        return this.mDelegate;
    }

    private static int getThemeResId(Context r2, int r3) {
        if (r3 != 0) goto L5;
        TypedValue r4 = new TypedValue();
        r2.getTheme().resolveAttribute(R.attr.dialogTheme, r4, true);
        return r4.resourceId;
    L5:
        return r3;
    }

    boolean superDispatchKeyEvent(KeyEvent r1) {
        return super.dispatchKeyEvent(r1);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent r3) {
        View r0 = getWindow().getDecorView();
        return KeyEventDispatcher.dispatchKeyEvent(this.mKeyDispatcher, r0, this, r3);
    }
}
