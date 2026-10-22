package androidx.constraintlayout.core.parser;

import androidx.core.os.EnvironmentCompat;

/* JADX INFO: loaded from: classes.dex */
public class CLParsingException extends Exception {
    private final String mElementClass;
    private final int mLineNumber;
    private final String mReason;

    public CLParsingException(String r1, CLElement r2) {
        this.mReason = r1;
        if (r2 == null) goto L5;
        this.mElementClass = r2.getStrClass();
        int r3 = r2.getLine();
    L6:
        this.mLineNumber = r3;
        return;
    L5:
        this.mElementClass = EnvironmentCompat.MEDIA_UNKNOWN;
        r3 = 0;
        goto L6
    }

    public String reason() {
        return this.mReason + " (" + this.mElementClass + " at line " + this.mLineNumber + ")";
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "CLParsingException (" + hashCode() + ") : " + reason();
    }
}
