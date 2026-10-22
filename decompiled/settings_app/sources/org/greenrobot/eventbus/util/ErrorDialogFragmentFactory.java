package org.greenrobot.eventbus.util;

import android.app.Fragment;
import android.os.Bundle;

/* JADX INFO: loaded from: classes6.dex */
public abstract class ErrorDialogFragmentFactory<T> {
    protected final ErrorDialogConfig config;

    public static class Honeycomb extends ErrorDialogFragmentFactory<Fragment> {
        @Override // org.greenrobot.eventbus.util.ErrorDialogFragmentFactory
        protected /* bridge */ /* synthetic */ Fragment createErrorFragment(ThrowableFailureEvent r1, Bundle r2) {
            return createErrorFragment(r1, r2);
        }

        public Honeycomb(ErrorDialogConfig r1) {
            super(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.greenrobot.eventbus.util.ErrorDialogFragmentFactory
        protected Fragment createErrorFragment(ThrowableFailureEvent r1, Bundle r2) {
            ErrorDialogFragments.Honeycomb r0 = new ErrorDialogFragments.Honeycomb();
            r0.setArguments(r2);
            return r0;
        }
    }

    public static class Support extends ErrorDialogFragmentFactory<androidx.fragment.app.Fragment> {
        @Override // org.greenrobot.eventbus.util.ErrorDialogFragmentFactory
        protected /* bridge */ /* synthetic */ androidx.fragment.app.Fragment createErrorFragment(ThrowableFailureEvent r1, Bundle r2) {
            return createErrorFragment(r1, r2);
        }

        public Support(ErrorDialogConfig r1) {
            super(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.greenrobot.eventbus.util.ErrorDialogFragmentFactory
        protected androidx.fragment.app.Fragment createErrorFragment(ThrowableFailureEvent r1, Bundle r2) {
            ErrorDialogFragments.Support r0 = new ErrorDialogFragments.Support();
            r0.setArguments(r2);
            return r0;
        }
    }

    protected abstract T createErrorFragment(ThrowableFailureEvent r1, Bundle r2);

    protected ErrorDialogFragmentFactory(ErrorDialogConfig r1) {
        this.config = r1;
    }

    protected T prepareErrorFragment(ThrowableFailureEvent r3, boolean r4, Bundle r5) {
        if (r3.isSuppressErrorUi() == false) goto L6;
        return null;
    L6:
        if (r5 == null) goto L8;
        Bundle r6 = (Bundle) r5.clone();
    L10:
        if (r6.containsKey(ErrorDialogManager.KEY_TITLE) == true) goto L13;
        r6.putString(ErrorDialogManager.KEY_TITLE, getTitleFor(r3, r6));
    L13:
        if (r6.containsKey(ErrorDialogManager.KEY_MESSAGE) == true) goto L16;
        r6.putString(ErrorDialogManager.KEY_MESSAGE, getMessageFor(r3, r6));
    L16:
        if (r6.containsKey(ErrorDialogManager.KEY_FINISH_AFTER_DIALOG) == true) goto L19;
        r6.putBoolean(ErrorDialogManager.KEY_FINISH_AFTER_DIALOG, r4);
    L19:
        if (r6.containsKey(ErrorDialogManager.KEY_EVENT_TYPE_ON_CLOSE) == true) goto L24;
        if (this.config.defaultEventTypeOnDialogClosed == null) goto L24;
        r6.putSerializable(ErrorDialogManager.KEY_EVENT_TYPE_ON_CLOSE, this.config.defaultEventTypeOnDialogClosed);
    L24:
        if (r6.containsKey(ErrorDialogManager.KEY_ICON_ID) == true) goto L29;
        if (this.config.defaultDialogIconId == 0) goto L29;
        r6.putInt(ErrorDialogManager.KEY_ICON_ID, this.config.defaultDialogIconId);
    L29:
        return createErrorFragment(r3, r6);
    L8:
        r6 = new Bundle();
        goto L10
    }

    protected String getTitleFor(ThrowableFailureEvent r1, Bundle r2) {
        return this.config.resources.getString(this.config.defaultTitleId);
    }

    protected String getMessageFor(ThrowableFailureEvent r1, Bundle r2) {
        int r3 = this.config.getMessageIdForThrowable(r1.throwable);
        return this.config.resources.getString(r3);
    }
}
