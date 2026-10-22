package android.view.inputmethod;

import android.os.RemoteException;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewRootImpl;
import android.view.WindowManagerGlobal;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ObricInputMethodManagerExtImpl implements IObricInputMethodManagerExt {
    private static final String TAG = "ObricInputMethodManagerExtImpl";

    public ObricInputMethodManagerExtImpl() {
    }

    public void updateSelection(InputMethodManager imm, View view, int selStart, int selEnd, int candidatesStart, int candidatesEnd) {
        if (view != null) goto L4;
        return;
    L4:
        if (view.getDisplay() != null) goto L6;
        return;
    L6:
        if (view.getDisplay().getObricExt().isObricVirtualDisplay() == false) goto L16;
        imm.mService.getIObricExt().updateSelection(selStart, selEnd, candidatesStart, candidatesEnd);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        Log.e(TAG, "the updateSelection exception is " + e);
        return;
    }

    public boolean injectText(CharSequence text, boolean replace) {
        return IInputMethodManagerGlobalInvoker.getService().getIObricExt().injectText(text, replace);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public void clearInputMethodState() {
        IInputMethodManagerGlobalInvoker.getService().getIObricExt().clearInputMethodState();     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public boolean showInputMethodPicker(InputMethodManager sourceImm) {
        if (sourceImm != null) goto L5;
        return false;
    L5:
        ViewRootImpl currentRoot = sourceImm.getFocusedRootViewForObric();
        if (isFocusedRoot(currentRoot) == false) goto L13;
        if (currentRoot.getDisplayId() != sourceImm.getDisplayId()) goto L11;
        return false;
    L11:
        return dispatchInputMethodPicker(sourceImm, resolveAutoDisplayInputMethodManager(currentRoot));
    L13:
        return dispatchInputMethodPicker(sourceImm, findFocusedAutoDisplayInputMethodManager());
    }

    private boolean dispatchInputMethodPicker(InputMethodManager sourceImm, InputMethodManager targetImm) {
        if (targetImm == null) goto L7;
        if (targetImm == sourceImm) goto L9;
        targetImm.showInputMethodPickerFromObric();
        return true;
    L9:
        return false;
    L7:
        return false;
    }

    private InputMethodManager findFocusedAutoDisplayInputMethodManager() {
        InputMethodManager targetImm = null;
        Iterator r1 = WindowManagerGlobal.getInstance().getWindowViews().iterator();
    L4:
        if (r1.hasNext() == false) goto L14;
        View rootView = (View) r1.next();
        InputMethodManager candidate = resolveAutoDisplayInputMethodManager(rootView.getViewRootImpl());
        if (candidate == null) goto L4;
        if (targetImm != null) goto L10;
    L13:
        targetImm = candidate;
        goto L4
    L10:
        if (targetImm.getDisplayId() == candidate.getDisplayId()) goto L13;
        Log.w(TAG, "Multiple focused Obric displays found");
        return null;
    L14:
        return targetImm;
    }

    private InputMethodManager resolveAutoDisplayInputMethodManager(ViewRootImpl root) {
        if (isFocusedRoot(root) == true) goto L5;
        return null;
    L5:
        View rootView = root.getView();
        Display display = rootView.getDisplay();
        if (display != null) goto L8;
    L22:
        return null;
    L8:
        if (display.getDisplayId() == 0) goto L22;
        if (display.getDisplayId() != root.getDisplayId()) goto L22;
        if (display.getObricExt().isObricVirtualDisplay() == false) goto L22;
        InputMethodManager imm = (InputMethodManager) rootView.getContext().getSystemService(InputMethodManager.class);
        if (imm != null) goto L17;
    L20:
        Log.w(TAG, "Failed to resolve IMM for display " + root.getDisplayId());
        return null;
    L17:
        if (imm.getDisplayId() != root.getDisplayId()) goto L20;
        return imm;
    }

    private boolean isFocusedRoot(ViewRootImpl root) {
        if (root != null) goto L5;
        return false;
    L5:
        View rootView = root.getView();
        if (rootView != null) goto L8;
        return false;
    L8:
        if (rootView.isAttachedToWindow() == true) goto L10;
        return false;
    L10:
        if (rootView.hasWindowFocus() == false) goto L16;
        return true;
    L16:
        return false;
    }
}
