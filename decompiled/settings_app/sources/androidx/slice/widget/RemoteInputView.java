package androidx.slice.widget;

import android.animation.Animator;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.core.widget.TextViewCompat;
import androidx.slice.SliceItem;
import androidx.slice.view.R;

/* JADX INFO: loaded from: classes.dex */
public class RemoteInputView extends LinearLayout implements View.OnClickListener, TextWatcher {
    private static final String TAG = "RemoteInput";
    public static final Object VIEW_TAG = null;
    private SliceItem mAction;
    RemoteEditText mEditText;
    private ProgressBar mProgressBar;
    private RemoteInput mRemoteInput;
    private RemoteInput[] mRemoteInputs;
    private boolean mResetting;
    private int mRevealCx;
    private int mRevealCy;
    private int mRevealR;
    private ImageButton mSendButton;

    public static class RemoteEditText extends EditText {
        private final Drawable mBackground;
        RemoteInputView mRemoteInputView;
        boolean mShowImeOnInputConnection;

        public RemoteEditText(Context r1, AttributeSet r2) {
            super(r1, r2);
            this.mBackground = getBackground();
        }

        private void defocusIfNeeded(boolean r2) {
            if (this.mRemoteInputView == null) goto L5;
        L16:
            isTemporarilyDetachedCompat();
            return;
        L5:
            if (isTemporarilyDetachedCompat() == true) goto L16;
            if (isFocusable() == true) goto L10;
            return;
        L10:
            if (isEnabled() == false) goto L19;
            setInnerFocusable(false);
            RemoteInputView r0 = this.mRemoteInputView;
            if (r0 == null) goto L14;
            r0.onDefocus();
        L14:
            this.mShowImeOnInputConnection = false;
            return;
        }

        private boolean isTemporarilyDetachedCompat() {
            return isTemporarilyDetached();
        }

        @Override // android.widget.TextView, android.view.View
        protected void onVisibilityChanged(View r1, int r2) {
            super.onVisibilityChanged(r1, r2);
            if (isShown() == true) goto L6;
            defocusIfNeeded(false);
            return;
        }

        @Override // android.widget.TextView, android.view.View
        protected void onFocusChanged(boolean r1, int r2, Rect r3) {
            super.onFocusChanged(r1, r2, r3);
            if (r1 == true) goto L6;
            defocusIfNeeded(true);
            return;
        }

        @Override // android.widget.TextView, android.view.View
        public void getFocusedRect(Rect r3) {
            super.getFocusedRect(r3);
            r3.top = getScrollY();
            r3.bottom = getScrollY() + (getBottom() - getTop());
        }

        @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int r2, KeyEvent r3) {
            if (r2 != 4) goto L7;
            return true;
        L7:
            return super.onKeyDown(r2, r3);
        }

        @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyUp(int r2, KeyEvent r3) {
            if (r2 != 4) goto L7;
            defocusIfNeeded(true);
            return true;
        L7:
            return super.onKeyUp(r2, r3);
        }

        @Override // android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo r3) {
            InputConnection r4 = super.onCreateInputConnection(r3);
            if (this.mShowImeOnInputConnection == false) goto L8;
            if (r4 == null) goto L8;
            final InputMethodManager r0 = (InputMethodManager) ContextCompat.getSystemService(getContext(), InputMethodManager.class);
            if (r0 == null) goto L8;
            post(new AnonymousClass1(this, r0));
        L8:
            return r4;
        }

        @Override // android.widget.TextView
        public void onCommitCompletion(CompletionInfo r1) {
            clearComposingText();
            setText(r1.getText());
            setSelection(getText().length());
        }

        void setInnerFocusable(boolean r1) {
            setFocusableInTouchMode(r1);
            setFocusable(r1);
            setCursorVisible(r1);
            if (r1 == false) goto L5;
            requestFocus();
            setBackground(this.mBackground);
            return;
        L5:
            setBackground(null);
        }

        @Override // android.widget.TextView
        public void setCustomSelectionActionModeCallback(ActionMode.Callback r1) {
            super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, r1));
        }
    }

    public static final boolean isConfirmKey(int r1) {
        if (r1 != 23) goto L5;
        return true;
    L5:
        if (r1 != 62) goto L7;
        return true;
    L7:
        if (r1 != 66) goto L9;
        return true;
    L9:
        if (r1 == 160) goto L16;
        return false;
    L16:
        return true;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    static {
        VIEW_TAG = new Object();
    }

    public RemoteInputView(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.mProgressBar = (ProgressBar) findViewById(R.id.remote_input_progress);
        ImageButton r0 = (ImageButton) findViewById(R.id.remote_input_send);
        this.mSendButton = r0;
        r0.setOnClickListener(this);
        RemoteEditText r1 = (RemoteEditText) getChildAt(0);
        this.mEditText = r1;
        r1.setOnEditorActionListener(new AnonymousClass1(this));
        this.mEditText.addTextChangedListener(this);
        this.mEditText.setInnerFocusable(false);
        this.mEditText.mRemoteInputView = this;
    }

    void sendRemoteInput() {
        Bundle r0 = new Bundle();
        r0.putString(this.mRemoteInput.getResultKey(), this.mEditText.getText().toString());
        Intent r1 = new Intent().addFlags(268435456);
        RemoteInput.addResultsToIntent(this.mRemoteInputs, r1, r0);
        this.mEditText.setEnabled(false);
        this.mSendButton.setVisibility(4);
        this.mProgressBar.setVisibility(0);
        this.mEditText.mShowImeOnInputConnection = false;
        this.mAction.fireAction(getContext(), r1);     // Catch: PendingIntent.CanceledException -> L5
        reset();     // Catch: PendingIntent.CanceledException -> L5
        return;
    L5:
        e = move-exception;
        Log.i(TAG, "Unable to send remote input result", e);
        Toast.makeText(getContext(), "Failure sending pending intent for inline reply :(", 0).show();
        reset();
    }

    public static RemoteInputView inflate(Context r2, ViewGroup r3) {
        RemoteInputView r4 = (RemoteInputView) LayoutInflater.from(r2).inflate(R.layout.abc_slice_remote_input, r3, false);
        r4.setTag(VIEW_TAG);
        return r4;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2 != this.mSendButton) goto L6;
        sendRemoteInput();
        return;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent r1) {
        super.onTouchEvent(r1);
        return true;
    }

    void onDefocus() {
        setVisibility(4);
    }

    public void setAction(SliceItem r1) {
        this.mAction = r1;
    }

    public void setRemoteInput(RemoteInput[] r1, RemoteInput r2) {
        this.mRemoteInputs = r1;
        this.mRemoteInput = r2;
        this.mEditText.setHint(r2.getLabel());
    }

    public void focusAnimated() {
        if (getVisibility() == 0) goto L5;
        Animator r0 = ViewAnimationUtils.createCircularReveal(this, this.mRevealCx, this.mRevealCy, 0.0f, this.mRevealR);
        r0.setDuration(200);
        r0.start();
    L5:
        focus();
    }

    private void focus() {
        setVisibility(0);
        this.mEditText.setInnerFocusable(true);
        this.mEditText.mShowImeOnInputConnection = true;
        RemoteEditText r0 = this.mEditText;
        r0.setSelection(r0.getText().length());
        this.mEditText.requestFocus();
        updateSendButton();
    }

    private void reset() {
        this.mResetting = true;
        this.mEditText.getText().clear();
        this.mEditText.setEnabled(true);
        this.mSendButton.setVisibility(0);
        this.mProgressBar.setVisibility(4);
        updateSendButton();
        onDefocus();
        this.mResetting = false;
    }

    @Override // android.view.ViewGroup
    public boolean onRequestSendAccessibilityEvent(View r2, AccessibilityEvent r3) {
        if (this.mResetting == false) goto L9;
        if (r2 != this.mEditText) goto L9;
        return false;
    L9:
        return super.onRequestSendAccessibilityEvent(r2, r3);
    }

    private void updateSendButton() {
        ImageButton r0 = this.mSendButton;
        if (this.mEditText.getText().length() == 0) goto L5;
        boolean r1 = true;
    L6:
        r0.setEnabled(r1);
        return;
    L5:
        r1 = false;
        goto L6
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable r1) {
        updateSendButton();
    }

    public void setRevealParameters(int r1, int r2, int r3) {
        this.mRevealCx = r1;
        this.mRevealCy = r2;
        this.mRevealR = r3;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchStartTemporaryDetach() {
        super.dispatchStartTemporaryDetach();
        detachViewFromParent(this.mEditText);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchFinishTemporaryDetach() {
        if (isAttachedToWindow() == false) goto L5;
        RemoteEditText r0 = this.mEditText;
        attachViewToParent(r0, 0, r0.getLayoutParams());
    L6:
        super.dispatchFinishTemporaryDetach();
        return;
    L5:
        removeDetachedView(this.mEditText, false);
        goto L6
    }
}
