package com.android.setupwizardlib.view;

import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public interface TouchableMovementMethod {

    public static class TouchableLinkMovementMethod extends LinkMovementMethod implements TouchableMovementMethod {
        MotionEvent lastEvent;
        boolean lastEventResult;

        public TouchableLinkMovementMethod() {
            this.lastEventResult = false;
        }

        public static TouchableLinkMovementMethod getInstance() {
            return new TouchableLinkMovementMethod();
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(TextView r1, Spannable r2, MotionEvent r3) {
            this.lastEvent = r3;
            boolean r4 = super.onTouchEvent(r1, r2, r3);
            if (r3.getAction() == 0) goto L5;
            this.lastEventResult = r4;
        L10:
            return r4;
        L5:
            if (Selection.getSelectionStart(r2) == (-1)) goto L7;
            boolean r5 = true;
        L8:
            this.lastEventResult = r5;
            goto L10
        L7:
            r5 = false;
            goto L8
        }

        @Override // com.android.setupwizardlib.view.TouchableMovementMethod
        public MotionEvent getLastTouchEvent() {
            return this.lastEvent;
        }

        @Override // com.android.setupwizardlib.view.TouchableMovementMethod
        public boolean isLastTouchEventHandled() {
            return this.lastEventResult;
        }
    }

    MotionEvent getLastTouchEvent();

    boolean isLastTouchEventHandled();
}
