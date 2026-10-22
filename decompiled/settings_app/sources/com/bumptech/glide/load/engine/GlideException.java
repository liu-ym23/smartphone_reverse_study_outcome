package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class GlideException extends Exception {
    private static final StackTraceElement[] EMPTY_ELEMENTS = null;
    private static final long serialVersionUID = 1;
    private final List<Throwable> causes;
    private Class<?> dataClass;
    private DataSource dataSource;
    private String detailMessage;
    private Exception exception;
    private Key key;

    private static final class IndentedAppendable implements Appendable {
        private static final String EMPTY_SEQUENCE = "";
        private static final String INDENT = "  ";
        private final Appendable appendable;
        private boolean printedNewLine;

        private CharSequence safeSequence(CharSequence r1) {
            if (r1 != null) goto L5;
            return "";
        L5:
            return r1;
        }

        IndentedAppendable(Appendable r2) {
            this.printedNewLine = true;
            this.appendable = r2;
        }

        @Override // java.lang.Appendable
        public Appendable append(char r4) throws IOException {
            boolean r1 = false;
            if (this.printedNewLine == false) goto L6;
            this.printedNewLine = false;
            this.appendable.append("  ");
        L6:
            if (r4 != '\n') goto L8;
            r1 = true;
        L8:
            this.printedNewLine = r1;
            this.appendable.append(r4);
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence r3) throws IOException {
            CharSequence r4 = safeSequence(r3);
            return append(r4, 0, r4.length());
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence r4, int r5, int r6) throws IOException {
            CharSequence r7 = safeSequence(r4);
            boolean r1 = false;
            if (this.printedNewLine == false) goto L6;
            this.printedNewLine = false;
            this.appendable.append("  ");
        L6:
            if (r7.length() > 0) goto L8;
        L10:
            this.printedNewLine = r1;
            this.appendable.append(r7, r5, r6);
            return this;
        L8:
            if (r7.charAt(r6 - 1) != '\n') goto L10;
            r1 = true;
            goto L10
        }
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    static {
        EMPTY_ELEMENTS = new StackTraceElement[0];
    }

    public GlideException(String r2) {
        this(r2, Collections.emptyList());
    }

    public GlideException(String r1, Throwable r2) {
        this(r1, Collections.singletonList(r2));
    }

    public GlideException(String r1, List<Throwable> r2) {
        this.detailMessage = r1;
        setStackTrace(EMPTY_ELEMENTS);
        this.causes = r2;
    }

    void setLoggingDetails(Key r2, DataSource r3) {
        setLoggingDetails(r2, r3, null);
    }

    void setLoggingDetails(Key r1, DataSource r2, Class<?> r3) {
        this.key = r1;
        this.dataSource = r2;
        this.dataClass = r3;
    }

    public void setOrigin(Exception r1) {
        this.exception = r1;
    }

    public Exception getOrigin() {
        return this.exception;
    }

    public List<Throwable> getCauses() {
        return this.causes;
    }

    public List<Throwable> getRootCauses() {
        ArrayList r0 = new ArrayList();
        addRootCauses(this, r0);
        return r0;
    }

    public void logRootCauses(String r6) {
        List<Throwable> r5 = getRootCauses();
        int r0 = r5.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        int r3 = r1 + 1;
        Log.i(r6, "Root cause (" + r3 + " of " + r0 + ")", r5.get(r1));
        r1 = r3;
        goto L3
    }

    private void addRootCauses(Throwable r2, List<Throwable> r3) {
        if ((r2 instanceof GlideException) == false) goto L8;
        Iterator<Throwable> r4 = ((GlideException) r2).getCauses().iterator();
    L6:
        if (r4.hasNext() == false) goto L11;
        addRootCauses(r4.next(), r3);
        goto L6
    L11:
        return;
    L8:
        r3.add(r2);
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream r1) {
        printStackTrace(r1);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter r1) {
        printStackTrace(r1);
    }

    private void printStackTrace(Appendable r2) {
        appendExceptionMessage(this, r2);
        appendCauses(getCauses(), new IndentedAppendable(r2));
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder r0 = new StringBuilder(71).append(this.detailMessage);
        String r3 = "";
        if (this.dataClass == null) goto L5;
        String r1 = ", " + this.dataClass;
    L6:
        StringBuilder r2 = r0.append(r1);
        if (this.dataSource == null) goto L9;
        String r4 = ", " + this.dataSource;
    L10:
        StringBuilder r5 = r2.append(r4);
        if (this.key == null) goto L13;
        r3 = ", " + this.key;
    L13:
        StringBuilder r6 = r5.append(r3);
        List<Throwable> r7 = getRootCauses();
        if (r7.isEmpty() == false) goto L18;
        return r6.toString();
    L18:
        if (r7.size() != 1) goto L20;
        r6.append("\nThere was 1 root cause:");
    L21:
        Iterator<Throwable> r8 = r7.iterator();
    L23:
        if (r8.hasNext() == false) goto L25;
        Throwable r9 = r8.next();
        r6.append('\n').append(r9.getClass().getName()).append('(').append(r9.getMessage()).append(')');
        goto L23
    L25:
        r6.append("\n call GlideException#logRootCauses(String) for more detail");
        return r6.toString();
    L20:
        r6.append("\nThere were ").append(r7.size()).append(" root causes:");
        goto L21
    L9:
        r4 = "";
        goto L10
    L5:
        r1 = "";
        goto L6
    }

    private static void appendExceptionMessage(Throwable r1, Appendable r2) {
        r2.append(r1.getClass().toString()).append(": ").append(r1.getMessage()).append('\n');     // Catch: IOException -> L4
        return;
    L5:
        throw new RuntimeException(r1);
    }

    private static void appendCauses(List<Throwable> r0, Appendable r1) {
        appendCausesWrapped(r0, r1);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private static void appendCausesWrapped(List<Throwable> r5, Appendable r6) throws IOException {
        int r0 = r5.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L9;
        int r3 = r1 + 1;
        r6.append("Cause (").append(String.valueOf(r3)).append(" of ").append(String.valueOf(r0)).append("): ");
        Throwable r2 = r5.get(r1);
        if ((r2 instanceof GlideException) == false) goto L7;
        ((GlideException) r2).printStackTrace(r6);
    L8:
        r1 = r3;
        goto L3
    L7:
        appendExceptionMessage(r2, r6);
        goto L8
    }
}
