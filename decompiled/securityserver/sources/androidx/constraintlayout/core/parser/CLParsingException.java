package androidx.constraintlayout.core.parser;

import a.a;
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
        this.mLineNumber = r2.getLine();
        return;
    L5:
        this.mElementClass = EnvironmentCompat.MEDIA_UNKNOWN;
        this.mLineNumber = 0;
    }

    public String reason() {
        StringBuilder r0 = new StringBuilder();
        r0.append(this.mReason);
        r0.append(" (");
        r0.append(this.mElementClass);
        r0.append(" at line ");
        return a.n(r0, ")", this.mLineNumber);
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "CLParsingException (" + hashCode() + ") : " + reason();
    }
}
