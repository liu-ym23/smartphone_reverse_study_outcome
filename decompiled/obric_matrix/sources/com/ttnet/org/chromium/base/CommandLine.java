package com.ttnet.org.chromium.base;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.ttnet.org.chromium.base.annotations.MainDex;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
@MainDex
public abstract class CommandLine {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String SWITCH_PREFIX = "--";
    private static final String SWITCH_TERMINATOR = "--";
    private static final String SWITCH_VALUE_SEPARATOR = "=";
    private static final String TAG = "CommandLine";
    private static final AtomicReference<CommandLine> sCommandLine = null;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.base.CommandLine$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class JavaCommandLine extends CommandLine {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private ArrayList<String> mArgs;
        private int mArgsBegin;
        private HashMap<String, String> mSwitches;

        static {
        }

        JavaCommandLine(@Nullable String[] r5) {
            super(null);
            this.mSwitches = new HashMap();
            ArrayList<String> r0 = new ArrayList();
            this.mArgs = r0;
            this.mArgsBegin = 1;
            if (r5 != null) goto L5;
        L10:
            r0.add("");
            return;
        L5:
            if (r5.length == 0) goto L10;
            if (r5[0] == null) goto L10;
            r0.add(r5[0]);
            appendSwitchesInternal(r5, 1);
        }

        private void appendSwitchesInternal(String[] r9, int r10) {
            int r0 = r9.length;
            int r3 = 0;
            boolean r4 = true;
        L3:
            if (r3 >= r0) goto L20;
            String r5 = r9[r3];
            if (r10 <= 0) goto L8;
            r10 = r10 - 1;
        L19:
            r3 = r3 + 1;
            goto L3
        L8:
            if (r5.equals("--") == false) goto L10;
            r4 = false;
        L10:
            if (r4 == true) goto L12;
        L18:
            this.mArgs.add(r5);
            goto L19
        L12:
            if (r5.startsWith("--") == false) goto L18;
            String[] r6 = r5.split(CommandLine.SWITCH_VALUE_SEPARATOR, 2);
            if (r6.length <= 1) goto L16;
            String r7 = r6[1];
        L17:
            appendSwitchWithValue(r6[0].substring(2), r7);
            goto L19
        L16:
            r7 = null;
            goto L17
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public void appendSwitch(String r2) {
            appendSwitchWithValue(r2, null);
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public void appendSwitchWithValue(String r3, String r4) {
            HashMap<String, String> r0 = this.mSwitches;
            if (r4 != null) goto L5;
            String r1 = "";
        L6:
            r0.put(r3, r1);
            String r5 = "--" + r3;
            if (r4 != null) goto L9;
        L11:
            ArrayList<String> r6 = this.mArgs;
            int r2 = this.mArgsBegin;
            this.mArgsBegin = r2 + 1;
            r6.add(r2, r5);
            return;
        L9:
            if (r4.isEmpty() == true) goto L11;
            r5 = r5 + CommandLine.SWITCH_VALUE_SEPARATOR + r4;
            goto L11
        L5:
            r1 = r4;
            goto L6
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public void appendSwitchesAndArguments(String[] r2) {
            appendSwitchesInternal(r2, 0);
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        protected String[] getCommandLineArguments() {
            ArrayList<String> r1 = this.mArgs;
            return (String[]) r1.toArray(new String[r1.size()]);
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public String getSwitchValue(String r1) {
            String r0 = this.mSwitches.get(r1);
            if (r0 != null) goto L5;
        L6:
            return null;
        L5:
            if (r0.isEmpty() == true) goto L6;
            return r0;
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public Map<String, String> getSwitches() {
            return new HashMap(this.mSwitches);
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public boolean hasSwitch(String r1) {
            return this.mSwitches.containsKey(r1);
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public void removeSwitch(String r5) {
            this.mSwitches.remove(r5);
            String r6 = "--" + r5;
            int r0 = this.mArgsBegin - 1;
        L3:
            if (r0 <= 0) goto L10;
            if (this.mArgs.get(r0).equals(r6) == false) goto L7;
        L8:
            this.mArgsBegin--;
            this.mArgs.remove(r0);
        L9:
            r0 = r0 - 1;
            goto L3
        L7:
            if (this.mArgs.get(r0).startsWith(r6 + CommandLine.SWITCH_VALUE_SEPARATOR) == false) goto L9;
        }
    }

    private static class NativeCommandLine extends CommandLine {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        static {
        }

        public NativeCommandLine(@Nullable String[] r2) {
            super(null);
            CommandLineJni.get().init(r2);
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public void appendSwitch(String r1) {
            CommandLineJni.get().appendSwitch(r1);
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public void appendSwitchWithValue(String r1, String r2) {
            Natives r0 = CommandLineJni.get();
            if (r2 != null) goto L5;
            r2 = "";
        L5:
            r0.appendSwitchWithValue(r1, r2);
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public void appendSwitchesAndArguments(String[] r1) {
            CommandLineJni.get().appendSwitchesAndArguments(r1);
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        protected void destroy() {
            throw new IllegalStateException("Can't destroy native command line after startup");
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        protected String[] getCommandLineArguments() {
            return null;
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public String getSwitchValue(String r1) {
            return CommandLineJni.get().getSwitchValue(r1);
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public Map<String, String> getSwitches() {
            HashMap r4 = new HashMap();
            String[] r0 = CommandLineJni.get().getSwitchesFlattened();
            int r1 = 0;
        L4:
            if (r1 >= r0.length) goto L6;
            r4.put(r0[r1], r0[r1 + 1]);
            r1 = r1 + 2;
            goto L4
        L6:
            return r4;
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public boolean hasSwitch(String r1) {
            return CommandLineJni.get().hasSwitch(r1);
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public boolean isNativeImplementation() {
            return true;
        }

        @Override // com.ttnet.org.chromium.base.CommandLine
        public void removeSwitch(String r1) {
            CommandLineJni.get().removeSwitch(r1);
        }
    }

    interface Natives {
        void appendSwitch(String r1);

        void appendSwitchWithValue(String r1, String r2);

        void appendSwitchesAndArguments(String[] r1);

        String getSwitchValue(String r1);

        String[] getSwitchesFlattened();

        boolean hasSwitch(String r1);

        void init(String[] r1);

        void removeSwitch(String r1);
    }

    static {
        sCommandLine = new AtomicReference();
    }

    private CommandLine() {
    }

    /* synthetic */ CommandLine(AnonymousClass1 r1) {
        this();
    }

    public static void enableNativeProxy() {
        sCommandLine.set(new NativeCommandLine(getJavaSwitchesOrNull()));
    }

    public static CommandLine getInstance() {
        return sCommandLine.get();
    }

    @Nullable
    public static String[] getJavaSwitchesOrNull() {
        CommandLine r0 = sCommandLine.get();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getCommandLineArguments();
    }

    public static void init(@Nullable String[] r1) {
        setInstance(new JavaCommandLine(r1));
    }

    public static void initFromFile(String r0) {
        char[] r1 = readFileAsUtf8(r0);
        if (r1 != null) goto L5;
        String[] r2 = null;
    L6:
        init(r2);
        return;
    L5:
        r2 = tokenizeQuotedArguments(r1);
        goto L6
    }

    public static boolean isInitialized() {
        if (sCommandLine.get() == null) goto L5;
        return true;
    L5:
        return false;
    }

    private static char[] readFileAsUtf8(String r3) {
        File r0 = new File(r3);
        FileReader r4 = new FileReader(r0);     // Catch: IOException -> L13
        char[] r1 = new char[(int) r0.length()];     // Catch: Throwable -> L7
        char[] r2 = Arrays.copyOfRange(r1, 0, r4.read(r1));     // Catch: Throwable -> L7
        r4.close();     // Catch: IOException -> L13
        return r2;
    L7:
        th = move-exception;
        r4.close();     // Catch: Throwable -> L10
    L12:
        throw th;     // Catch: IOException -> L13
    L10:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L13
    L13:
        return null;
    }

    @VisibleForTesting
    public static void reset() {
        setInstance(null);
    }

    private static void setInstance(CommandLine r1) {
        CommandLine r2 = sCommandLine.getAndSet(r1);
        if (r2 == null) goto L6;
        r2.destroy();
        return;
    }

    @VisibleForTesting
    public static void setInstanceForTesting(CommandLine r0) {
        setInstance(r0);
    }

    @VisibleForTesting
    static String[] tokenizeQuotedArguments(char[] r10) {
        if (r10.length > 65536) goto L38;
        ArrayList r0 = new ArrayList();
        int r1 = r10.length;
        StringBuilder r5 = null;
        int r4 = 0;
        char r6 = 0;
    L5:
        if (r4 >= r1) goto L31;
        char r7 = r10[r4];
        if (r6 == 0) goto L9;
    L12:
        if (r7 != r6) goto L22;
    L13:
        if (r5 != null) goto L15;
    L19:
        if (r6 != 0) goto L21;
        r6 = r7;
    L30:
        r4 = r4 + 1;
        goto L5
    L21:
        r6 = 0;
        goto L30
    L15:
        if (r5.length() <= 0) goto L19;
        if (r5.charAt(r5.length() - 1) != '\\') goto L19;
        r5.setCharAt(r5.length() - 1, r7);
        goto L30
    L22:
        if (r6 == 0) goto L24;
    L27:
        if (r5 != null) goto L29;
        r5 = new StringBuilder();
    L29:
        r5.append(r7);
        goto L30
    L24:
        if (Character.isWhitespace(r7) == false) goto L27;
        if (r5 == null) goto L30;
        r0.add(r5.toString());
        r5 = null;
        goto L30
    L9:
        if (r7 == '\'') goto L13;
        if (r7 == '\"') goto L13;
    L31:
        if (r5 == null) goto L36;
        if (r6 == 0) goto L34;
        android.util.Log.w(TAG, "Unterminated quoted string: " + r5);
    L34:
        r0.add(r5.toString());
    L36:
        return (String[]) r0.toArray(new String[r0.size()]);
    L38:
        throw new RuntimeException("Flags file too big: " + r10.length);
    }

    public abstract void appendSwitch(String r1);

    public abstract void appendSwitchWithValue(String r1, String r2);

    public abstract void appendSwitchesAndArguments(String[] r1);

    protected void destroy() {
    }

    protected abstract String[] getCommandLineArguments();

    public abstract String getSwitchValue(String r1);

    public String getSwitchValue(String r1, String r2) {
        String r0 = getSwitchValue(r1);
        if (TextUtils.isEmpty(r0) == false) goto L6;
        return r2;
    L6:
        return r0;
    }

    public abstract Map getSwitches();

    public abstract boolean hasSwitch(String r1);

    public boolean isNativeImplementation() {
        return false;
    }

    public abstract void removeSwitch(String r1);
}
