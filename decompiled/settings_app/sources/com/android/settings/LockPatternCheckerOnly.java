package com.android.settings;

import android.os.AsyncTask;
import com.android.internal.widget.LockPatternChecker;
import com.android.internal.widget.LockPatternUtils;
import com.android.internal.widget.LockPatternView;
import com.android.internal.widget.LockscreenCredential;
import com.android.internal.widget.VerifyCredentialResponse;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class LockPatternCheckerOnly {
    public LockPatternCheckerOnly() {
    }

    public static AsyncTask<?, ?, ?> verifyPattern(final LockPatternUtils r8, final List<LockPatternView.Cell> r9, final long r10, final int r12, final LockPatternChecker.OnVerifyCallback r13) {
        AsyncTask<Void, Void, VerifyCredentialResponse> r7 = new AnonymousClass1(r9, r8, r10, r12, r13);
        r7.execute(new Void[0]);
        return r7;
    }

    public static AsyncTask<?, ?, ?> verifyPattern2(final LockPatternUtils r8, final LockscreenCredential r9, final long r10, final int r12, final LockPatternChecker.OnVerifyCallback r13) {
        AsyncTask<Void, Void, VerifyCredentialResponse> r7 = new AnonymousClass2(r9, r8, r10, r12, r13);
        r7.execute(new Void[0]);
        return r7;
    }

    public static AsyncTask<?, ?, ?> checkPattern(final LockPatternUtils r1, final List<LockPatternView.Cell> r2, final int r3, final LockPatternChecker.OnCheckCallback r4) {
        AsyncTask<Void, Void, Boolean> r0 = new AnonymousClass3(r2, r4, r1, r3);
        r0.execute(new Void[0]);
        return r0;
    }

    @Deprecated
    public static AsyncTask<?, ?, ?> verifyPassword(LockPatternUtils r6, String r7, long r8, int r10, LockPatternChecker.OnVerifyCallback r11) {
        if (r7 == null) goto L4;
        byte[] r9 = r7.getBytes();
    L6:
        return verifyPassword(r6, r9, r8, r10, r11);
    L4:
        r9 = null;
        goto L6
    }

    public static AsyncTask<?, ?, ?> verifyPassword(final LockPatternUtils r8, final byte[] r9, final long r10, final int r12, final LockPatternChecker.OnVerifyCallback r13) {
        AsyncTask<Void, Void, VerifyCredentialResponse> r7 = new AnonymousClass4(r8, r9, r10, r12, r13);
        r7.execute(new Void[0]);
        return r7;
    }

    public static AsyncTask<?, ?, ?> verifyPassword2(final LockPatternUtils r8, final LockscreenCredential r9, final long r10, final int r12, final LockPatternChecker.OnVerifyCallback r13) {
        AsyncTask<Void, Void, VerifyCredentialResponse> r7 = new AnonymousClass5(r8, r9, r10, r12, r13);
        r7.execute(new Void[0]);
        return r7;
    }

    @Deprecated
    public static AsyncTask<?, ?, ?> checkPassword(LockPatternUtils r0, String r1, int r2, LockPatternChecker.OnCheckCallback r3) {
        if (r1 == null) goto L4;
        byte[] r4 = r1.getBytes();
    L6:
        return checkPassword(r0, r4, r2, r3);
    L4:
        r4 = null;
        goto L6
    }

    public static AsyncTask<?, ?, ?> checkPassword(final LockPatternUtils r1, final byte[] r2, final int r3, final LockPatternChecker.OnCheckCallback r4) {
        AsyncTask<Void, Void, Boolean> r0 = new AnonymousClass6(r1, r2, r3, r4);
        r0.execute(new Void[0]);
        return r0;
    }
}
