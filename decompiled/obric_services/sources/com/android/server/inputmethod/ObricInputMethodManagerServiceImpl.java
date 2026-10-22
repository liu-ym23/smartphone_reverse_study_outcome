package com.android.server.inputmethod;

import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Slog;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ImeTracker;
import android.view.inputmethod.SurroundingText;
import com.android.internal.infra.AndroidFuture;
import com.android.internal.inputmethod.IInputMethodClient;
import com.android.internal.inputmethod.IRemoteInputConnection;
import com.android.internal.inputmethod.InputBindResult;
import com.android.internal.inputmethod.InputConnectionCommandHeader;
import com.android.internal.view.IObricInputMethodManager;
import com.obric.utils.ObricPermissionCheckHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
public class ObricInputMethodManagerServiceImpl implements IObricInputMethodManagerService {
    static final long KEY_EVENT_DELAY_MS = 20;
    static final int MAX_VERIFY_TEXT_LENGTH = 10000;
    static final long REMOTE_TEXT_TIMEOUT_MS = 200;
    static final long REPLACE_VERIFY_DELAY_MS = 80;
    private static final String SETTINGS_INPUT_METHOD_ACTIVITY = "com.android.settings.inputmethod.InputMethodAndLanguageSettingsActivity";
    private static final String SETTINGS_PACKAGE_NAME = "com.android.settings";
    private static final String TAG = "ObricInputMethodManagerServiceImpl";
    private final InputMethodManagerService mBase;
    private IRemoteInputConnection mCurrentInputConnection;
    private int mEnd;
    private IObricInputMethodManager mIInputMethodManagerExt;
    private String mPackageName;
    private final ScheduledExecutorService mScheduler;
    private int mStart;

    protected class InputMethodManagerExtImpl extends IObricInputMethodManager.Stub {
        final /* synthetic */ ObricInputMethodManagerServiceImpl this$0;

        /* JADX INFO: renamed from: $r8$lambda$YqgY2N-DZgxCvi_RVdpooScF2do, reason: not valid java name */
        public static /* synthetic */ void m21$r8$lambda$YqgY2NDZgxCvi_RVdpooScF2do(InputMethodManagerExtImpl r0, IRemoteInputConnection r1, CharSequence r2) {
            r0.lambda$scheduleVerifyReplaceAndFallback$0(r1, r2);
        }

        /* JADX INFO: renamed from: $r8$lambda$r8-rZiDT4SJ6DhGCVwkTUHOYjV4, reason: not valid java name */
        public static /* synthetic */ void m22$r8$lambda$r8rZiDT4SJ6DhGCVwkTUHOYjV4(InputMethodManagerExtImpl r0, InputConnectionCommandHeader r1, List r2, int r3, CharSequence r4) {
            r0.lambda$performKeyStep$1(r1, r2, r3, r4);
        }

        protected InputMethodManagerExtImpl(ObricInputMethodManagerServiceImpl this$0) {
            this.this$0 = this$0;
        }

        public boolean injectText(CharSequence text, boolean replace) throws RemoteException {
            ObricInputMethodManagerServiceImpl r1 = this.this$0;
            monitor-enter(r1);
        L33:
            th = th;
        L35:
            monitor-exit(r1);     // Catch: Throwable -> L37
            throw th;
        L6:
            if (ObricInputMethodManagerServiceImpl.m16$$Nest$fgetmCurrentInputConnection(this.this$0) != null) goto L13;
            Slog.e(ObricInputMethodManagerServiceImpl.TAG, "the mCurrentInputConnection is null");     // Catch: Throwable -> L10
            monitor-exit(r1);     // Catch: Throwable -> L10
            return false;
        L10:
            th = th;
            goto L35
        L13:
            if (ObricPermissionCheckHelper.isSystemApp(ObricInputMethodManagerServiceImpl.m15$$Nest$fgetmBase(this.this$0).mContext, Binder.getCallingUid()) == false) goto L32;
            InputConnectionCommandHeader header = new InputConnectionCommandHeader(0);     // Catch: Throwable -> L33
            if (replace == true) goto L47;
            CharSequence text2 = text;
            ObricInputMethodManagerServiceImpl.m16$$Nest$fgetmCurrentInputConnection(this.this$0).commitText(header, text2, 1);     // Catch: RemoteException -> L24 Throwable -> L37
            Slog.d(ObricInputMethodManagerServiceImpl.TAG, "trying to commitText");     // Catch: RemoteException -> L24 Throwable -> L37
        L39:
        L29:
            monitor-exit(r1);     // Catch: Throwable -> L37
            return true;
        L47:
            IRemoteInputConnection targetConnection = ObricInputMethodManagerServiceImpl.m16$$Nest$fgetmCurrentInputConnection(this.this$0);     // Catch: RemoteException -> L20 Throwable -> L33
            text2 = text;
            ObricInputMethodManagerServiceImpl.m16$$Nest$fgetmCurrentInputConnection(this.this$0).replaceText(header, 0, Integer.MAX_VALUE, text2, 1, null);     // Catch: RemoteException -> L24 Throwable -> L37
            scheduleVerifyReplaceAndFallback(targetConnection, text2);     // Catch: RemoteException -> L24 Throwable -> L37
            Slog.d(ObricInputMethodManagerServiceImpl.TAG, "trying to replaceText");     // Catch: RemoteException -> L24 Throwable -> L37
            goto L39
        L20:
            e = move-exception;
            text2 = text;
            RemoteException e = e;
        L26:
            Slog.e(ObricInputMethodManagerServiceImpl.TAG, "Failed to injectText" + e);     // Catch: Throwable -> L37
            if (replace == false) goto L29;
            performCtrlAReplaceSafely(text2);     // Catch: Throwable -> L37
        L24:
            e = move-exception;
            e = e;
            goto L26
        L32:
            throw new SecurityException("injectText is not allowed");     // Catch: Throwable -> L37
        L37:
            th = th;
            goto L35
        }

        private void scheduleVerifyReplaceAndFallback(final IRemoteInputConnection expectedConnection, final CharSequence text) {
            ObricInputMethodManagerServiceImpl.m18$$Nest$fgetmScheduler(this.this$0).schedule(new ObricInputMethodManagerServiceImpl$InputMethodManagerExtImpl$$ExternalSyntheticLambda0(this, expectedConnection, text), ObricInputMethodManagerServiceImpl.REPLACE_VERIFY_DELAY_MS, TimeUnit.MILLISECONDS);
        }

        private /* synthetic */ void lambda$scheduleVerifyReplaceAndFallback$0(IRemoteInputConnection expectedConnection, CharSequence text) {
            verifyReplaceAndFallback(expectedConnection, text);
        }

        private void verifyReplaceAndFallback(IRemoteInputConnection expectedConnection, CharSequence expectedText) {
            InputConnectionCommandHeader header = new InputConnectionCommandHeader(0);
            ObricInputMethodManagerServiceImpl r1 = this.this$0;
            monitor-enter(r1);
        L35:
            e = move-exception;
            throw e;
        L5:
            if (ObricInputMethodManagerServiceImpl.m16$$Nest$fgetmCurrentInputConnection(this.this$0) == expectedConnection) goto L9;
            Slog.d(ObricInputMethodManagerServiceImpl.TAG, "skip replace verification because input connection changed");     // Catch: Throwable -> L35
            monitor-exit(r1);     // Catch: Throwable -> L35
            return;
        L9:
            monitor-exit(r1);     // Catch: Throwable -> L35
            CharSequence currentText = readCurrentText(header, expectedConnection, ObricInputMethodManagerServiceImpl.MAX_VERIFY_TEXT_LENGTH);     // Catch: Throwable -> L24
            if (TextUtils.equals(currentText, expectedText) == true) goto L45;
            Slog.w(ObricInputMethodManagerServiceImpl.TAG, "replaceText verification failed for " + ObricInputMethodManagerServiceImpl.m17$$Nest$fgetmPackageName(this.this$0) + ", fallback to Ctrl+A");     // Catch: Throwable -> L24
            ObricInputMethodManagerServiceImpl r2 = this.this$0;     // Catch: Throwable -> L24
            monitor-enter(r2);     // Catch: Throwable -> L24
        L20:
            th = move-exception;
            throw th;     // Catch: Throwable -> L24 Throwable -> L24 Throwable -> L24 Throwable -> L24
        L16:
            if (ObricInputMethodManagerServiceImpl.m16$$Nest$fgetmCurrentInputConnection(this.this$0) != expectedConnection) goto L18;
            performCtrlAReplaceSafely(expectedText);     // Catch: Throwable -> L20
        L18:
            monitor-exit(r2);     // Catch: Throwable -> L20
            return;
        L45:
            return;
        L24:
            e = move-exception;
            Slog.w(ObricInputMethodManagerServiceImpl.TAG, "replaceText verification error, fallback to Ctrl+A", e);
            monitor-enter(this.this$0);
        L32:
            th = move-exception;
            throw th;
        L28:
            if (ObricInputMethodManagerServiceImpl.m16$$Nest$fgetmCurrentInputConnection(this.this$0) != expectedConnection) goto L30;
            performCtrlAReplaceSafely(expectedText);     // Catch: Throwable -> L32
        L30:
        }

        private void performCtrlAReplaceSafely(CharSequence text) {
            performCtrlAReplace(new InputConnectionCommandHeader(0), text);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Slog.e(ObricInputMethodManagerServiceImpl.TAG, "fallback Ctrl+A replace failed", e);
        }

        private CharSequence readCurrentText(InputConnectionCommandHeader header, IRemoteInputConnection connection, int maxTextLength) throws RemoteException, InterruptedException, ExecutionException, TimeoutException {
            AndroidFuture<SurroundingText> surroundingTextFuture = new AndroidFuture();
            connection.getSurroundingText(header, maxTextLength, maxTextLength, 0, surroundingTextFuture);
            SurroundingText surroundingText = (SurroundingText) surroundingTextFuture.get(ObricInputMethodManagerServiceImpl.REMOTE_TEXT_TIMEOUT_MS, TimeUnit.MILLISECONDS);
            if (surroundingText != null) goto L5;
            return "";
        L5:
            if (surroundingText.getText() != null) goto L8;
            return "";
        L8:
            return surroundingText.getText();
        }

        private void performCtrlAReplace(InputConnectionCommandHeader header, CharSequence text) throws RemoteException {
            if (ObricInputMethodManagerServiceImpl.m16$$Nest$fgetmCurrentInputConnection(this.this$0) != null) goto L5;
            return;
        L5:
            long now = SystemClock.uptimeMillis();
            List<KeyEvent> keysToSend = new ArrayList();
            keysToSend.add(new KeyEvent(now, now, 0, 113, 0, 4096));
            keysToSend.add(new KeyEvent(now, now, 0, 29, 0, 4096));
            keysToSend.add(new KeyEvent(now, now, 1, 29, 0, 4096));
            keysToSend.add(new KeyEvent(now, now, 1, 113, 0, 0));
            keysToSend.add(new KeyEvent(now, now, 0, 67, 0, 0));
            keysToSend.add(new KeyEvent(now, now, 1, 67, 0, 0));
            performKeyStep(header, keysToSend, 0, text);
        }

        private void performKeyStep(final InputConnectionCommandHeader header, final List<KeyEvent> keysToSend, int currStep, final CharSequence text) {
            final int nextStep = currStep + 1;
            ObricInputMethodManagerServiceImpl r1 = this.this$0;
            monitor-enter(r1);
            ObricInputMethodManagerServiceImpl.m16$$Nest$fgetmCurrentInputConnection(this.this$0).sendKeyEvent(header, keysToSend.get(currStep));     // Catch: Throwable -> L17 RemoteException -> L19
            if (nextStep >= keysToSend.size()) goto L26;
            monitor-exit(r1);     // Catch: Throwable -> L17
            ObricInputMethodManagerServiceImpl.m18$$Nest$fgetmScheduler(this.this$0).schedule(new ObricInputMethodManagerServiceImpl$InputMethodManagerExtImpl$$ExternalSyntheticLambda1(this, header, keysToSend, nextStep, text), ObricInputMethodManagerServiceImpl.KEY_EVENT_DELAY_MS, TimeUnit.MILLISECONDS);
            return;
        L26:
            ObricInputMethodManagerServiceImpl.m16$$Nest$fgetmCurrentInputConnection(this.this$0).commitText(header, text, 1);     // Catch: Throwable -> L9 RemoteException -> L11
            monitor-exit(r1);     // Catch: Throwable -> L9
            return;
        L9:
            e = th;
        L24:
            monitor-exit(r1);     // Catch: Throwable -> L23
            throw e;
        L11:
            e = e;
        L22:
            throw e.rethrowFromSystemServer();     // Catch: Throwable -> L23
        L23:
            e = th;
        L19:
            e = e;
        L17:
            e = th;
            goto L24
        }

        private /* synthetic */ void lambda$performKeyStep$1(InputConnectionCommandHeader header, List keysToSend, int nextStep, CharSequence text) {
            performKeyStep(header, keysToSend, nextStep, text);
        }

        public void updateSelection(int selStart, int selEnd, int candidatesStart, int candidatesEnd) {
            ObricInputMethodManagerServiceImpl r0 = this.this$0;
            monitor-enter(r0);
            ObricInputMethodManagerServiceImpl.m20$$Nest$fputmStart(this.this$0, selStart);     // Catch: Throwable -> L8
            ObricInputMethodManagerServiceImpl.m19$$Nest$fputmEnd(this.this$0, selEnd);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            Slog.d(ObricInputMethodManagerServiceImpl.TAG, "updateSelection to " + selStart + " " + selEnd);
            return;
        L8:
            th = move-exception;
            throw th;
        }

        public void clearInputMethodState() {
            long ident = Binder.clearCallingIdentity();
            monitor-enter(ImfLock.class);     // Catch: Throwable -> L12
            ImeTracker.Token statsToken = ObricInputMethodManagerServiceImpl.m15$$Nest$fgetmBase(this.this$0).createStatsTokenForFocusedClient(false, 15, ObricInputMethodManagerServiceImpl.m15$$Nest$fgetmBase(this.this$0).mCurrentImeUserId);     // Catch: Throwable -> L9
            ObricInputMethodManagerServiceImpl.m15$$Nest$fgetmBase(this.this$0).hideCurrentInputLocked(ObricInputMethodManagerServiceImpl.m15$$Nest$fgetmBase(this.this$0).getUserData(ObricInputMethodManagerServiceImpl.m15$$Nest$fgetmBase(this.this$0).mCurrentImeUserId).mImeBindingState.mFocusedWindow, statsToken, 0, null, 15, ObricInputMethodManagerServiceImpl.m15$$Nest$fgetmBase(this.this$0).mCurrentImeUserId);     // Catch: Throwable -> L9
            InputMethodBindingController bindingController = ObricInputMethodManagerServiceImpl.m15$$Nest$fgetmBase(this.this$0).getInputMethodBindingController(0);     // Catch: Throwable -> L9
            bindingController.unbindCurrentMethod();     // Catch: Throwable -> L9
            ObricInputMethodManagerServiceImpl.m15$$Nest$fgetmBase(this.this$0).unbindCurrentClientLocked(1, ObricInputMethodManagerServiceImpl.m15$$Nest$fgetmBase(this.this$0).mCurrentImeUserId);     // Catch: Throwable -> L9
            monitor-exit(ImfLock.class);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(ident);
            return;
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            Binder.restoreCallingIdentity(ident);
            throw th;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBase, reason: not valid java name */
    static /* bridge */ /* synthetic */ InputMethodManagerService m15$$Nest$fgetmBase(ObricInputMethodManagerServiceImpl r0) {
        return r0.mBase;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurrentInputConnection, reason: not valid java name */
    static /* bridge */ /* synthetic */ IRemoteInputConnection m16$$Nest$fgetmCurrentInputConnection(ObricInputMethodManagerServiceImpl r0) {
        return r0.mCurrentInputConnection;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPackageName, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m17$$Nest$fgetmPackageName(ObricInputMethodManagerServiceImpl r0) {
        return r0.mPackageName;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmScheduler, reason: not valid java name */
    static /* bridge */ /* synthetic */ ScheduledExecutorService m18$$Nest$fgetmScheduler(ObricInputMethodManagerServiceImpl r0) {
        return r0.mScheduler;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmEnd, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m19$$Nest$fputmEnd(ObricInputMethodManagerServiceImpl r0, int r1) {
        r0.mEnd = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmStart, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m20$$Nest$fputmStart(ObricInputMethodManagerServiceImpl r0, int r1) {
        r0.mStart = r1;
    }

    public ObricInputMethodManagerServiceImpl(InputMethodManagerService base) {
        this.mScheduler = Executors.newSingleThreadScheduledExecutor();
        this.mStart = 0;
        this.mEnd = 0;
        this.mPackageName = "";
        this.mCurrentInputConnection = null;
        Objects.requireNonNull(this);
        this.mIInputMethodManagerExt = new InputMethodManagerExtImpl(this);
        this.mBase = base;
    }

    public IObricInputMethodManager getIObricExt() {
        return this.mIInputMethodManagerExt;
    }

    public void setFakeInputConnection(IRemoteInputConnection connection, int start, int end, CharSequence text, String packageName) {
        monitor-enter(this);
        Slog.w(TAG, "mCurrentInputConnection is " + connection);     // Catch: Throwable -> L6
        this.mCurrentInputConnection = connection;     // Catch: Throwable -> L6
        this.mBase.mWindowManagerInternal.getObricWindowManagerInternal().setFakeInputConnection(this.mCurrentInputConnection);     // Catch: Throwable -> L6
        Slog.d(TAG, "updateSelection to " + start + " " + end);     // Catch: Throwable -> L6
        this.mStart = start;     // Catch: Throwable -> L6
        this.mEnd = end;     // Catch: Throwable -> L6
        this.mPackageName = packageName;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public InputBindResult getInputBindResult(IBinder windowToken, int startInputFlags, EditorInfo editorInfo, IRemoteInputConnection inputConnection, ClientState cs) {
        if (editorInfo == null) goto L8;
        int start = editorInfo.initialSelStart;
        int end = editorInfo.initialSelEnd;
        Slog.d(TAG, "the editorInfo end is " + start);
        Slog.d(TAG, "the editorInfo start is " + end);
        CharSequence text = editorInfo.getText();
        String packageName = editorInfo.packageName;
        if (text == null) goto L7;
        int start2 = start;
        CharSequence finalText = text;
        String packageName2 = packageName;
        int end2 = end;
    L9:
        Slog.d(TAG, "startInputOrWindowGainedFocusInternal: auto virtuald display");
        setFakeInputConnection(inputConnection, start2, end2, finalText, packageName2);
        boolean isTextEditor = true;
        if (this.mBase.mWindowManagerInternal.getObricWindowManagerInternal().getAutoFocusedWindowToken() != windowToken) goto L12;
        boolean sameWindowFocused = true;
    L14:
        if ((startInputFlags & 2) != 0) goto L17;
        isTextEditor = false;
    L17:
        if (sameWindowFocused == false) goto L20;
        if (isTextEditor == false) goto L20;
    L22:
        return InputBindResult.DISPLAY_ID_MISMATCH;
    L20:
        this.mBase.mWindowManagerInternal.getObricWindowManagerInternal().hideImeInAuto(cs.mSelfReportedDisplayId);
        goto L22
    L12:
        sameWindowFocused = false;
        goto L14
    L7:
        start2 = start;
        finalText = null;
        packageName2 = packageName;
        end2 = end;
        goto L9
    L8:
        start2 = -1;
        finalText = null;
        packageName2 = null;
        end2 = -1;
        goto L9
    }

    public boolean canShowAutoInputMethodPicker(IInputMethodClient client) {
        boolean r0 = false;
        if (client != null) goto L6;
        return false;
    L6:
        monitor-enter(ImfLock.class);
    L12:
        th = move-exception;
        throw th;
    L8:
        if (resolvePickerDisplayId(this.mBase.getClientStateLocked(client)) == (-1)) goto L10;
        r0 = true;
    L10:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L12
        return r0;
    }

    public int getAutoInputMethodPickerDisplayId(IInputMethodClient client, int fallbackDisplayId) {
        if (client != null) goto L5;
        return fallbackDisplayId;
    L5:
        monitor-enter(ImfLock.class);
        ClientState cs = this.mBase.getClientStateLocked(client);     // Catch: Throwable -> L12
        int displayId = resolvePickerDisplayId(cs);     // Catch: Throwable -> L12
        if (displayId == (-1)) goto L9;
        int r3 = displayId;
    L10:
        monitor-exit(ImfLock.class);     // Catch: Throwable -> L12
        return r3;
    L9:
        r3 = fallbackDisplayId;
    L12:
        th = move-exception;
        throw th;
    }

    private int resolvePickerDisplayId(ClientState cs) {
        if (cs != null) goto L6;
        return -1;
    L6:
        if (InputMethodUtils.checkIfPackageBelongsToUid(this.mBase.mPackageManagerInternal, cs.mUid, SETTINGS_PACKAGE_NAME) == true) goto L8;
        return -1;
    L8:
        int autoDisplayId = this.mBase.mWindowManagerInternal.getObricWindowManagerInternal().getAutoDisplayId();
        if (autoDisplayId == 0) goto L14;
        if (cs.mSelfReportedDisplayId != autoDisplayId) goto L14;
        return autoDisplayId;
    L14:
        if (isSettingsFocusedOnDefaultDisplay(cs) == false) goto L17;
        return 0;
    L17:
        return -1;
    }

    private boolean isSettingsFocusedOnDefaultDisplay(ClientState cs) {
        return this.mBase.mWindowManagerInternal.getObricWindowManagerInternal().isOwningFocusedWindowOnDisplay(cs.mUid, cs.mPid, SETTINGS_PACKAGE_NAME, SETTINGS_INPUT_METHOD_ACTIVITY, 0);
    }
}
