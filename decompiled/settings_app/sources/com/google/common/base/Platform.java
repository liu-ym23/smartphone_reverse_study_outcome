package com.google.common.base;

import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.ServiceConfigurationError;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
final class Platform {
    private static final Logger logger = null;
    private static final PatternCompiler patternCompiler = null;

    /* JADX INFO: renamed from: com.google.common.base.Platform$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class JdkPatternCompiler implements PatternCompiler {
        @Override // com.google.common.base.PatternCompiler
        public boolean isPcreLike() {
            return true;
        }

        private JdkPatternCompiler() {
        }

        /* synthetic */ JdkPatternCompiler(AnonymousClass1 r1) {
            this();
        }

        @Override // com.google.common.base.PatternCompiler
        public CommonPattern compile(String r1) {
            return new JdkPattern(Pattern.compile(r1));
        }
    }

    static String nullToEmpty(@CheckForNull String r0) {
        if (r0 != null) goto L5;
        return "";
    L5:
        return r0;
    }

    static {
        logger = Logger.getLogger(Platform.class.getName());
        patternCompiler = loadPatternCompiler();
    }

    private Platform() {
    }

    static long systemNanoTime() {
        return System.nanoTime();
    }

    static CharMatcher precomputeCharMatcher(CharMatcher r0) {
        return r0.precomputedInternal();
    }

    static <T extends Enum<T>> Optional<T> getEnumIfPresent(Class<T> r1, String r2) {
        WeakReference<? extends Enum<?>> r3 = Enums.getEnumConstants(r1).get(r2);
        if (r3 != null) goto L6;
        return Optional.absent();
    L6:
        return Optional.of(r1.cast(r3.get()));
    }

    static String formatCompact4Digits(double r3) {
        return String.format(Locale.ROOT, "%.4g", new Object[]{Double.valueOf(r3)});
    }

    static boolean stringIsNullOrEmpty(@CheckForNull String r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.isEmpty() == true) goto L7;
        return false;
    }

    @CheckForNull
    static String emptyToNull(@CheckForNull String r1) {
        if (stringIsNullOrEmpty(r1) == false) goto L6;
        return null;
    L6:
        return r1;
    }

    static CommonPattern compilePattern(String r1) {
        Preconditions.checkNotNull(r1);
        return patternCompiler.compile(r1);
    }

    static boolean patternCompilerIsPcreLike() {
        return patternCompiler.isPcreLike();
    }

    private static PatternCompiler loadPatternCompiler() {
        return new JdkPatternCompiler(null);
    }

    private static void logPatternCompilerError(ServiceConfigurationError r3) {
        logger.log(Level.WARNING, "Error loading regex compiler, falling back to next option", r3);
    }

    static void checkGwtRpcEnabled() {
        if (Boolean.parseBoolean(System.getProperty("guava.gwt.emergency_reenable_rpc", "false")) == false) goto L7;
        logger.log(Level.WARNING, "Later in 2020, we will remove GWT-RPC support for Guava types. You are seeing this warning because you are sending a Guava type over GWT-RPC, which will break. You can identify which type by looking at the class name in the attached stack trace.", new Throwable());
        return;
    L7:
        throw new UnsupportedOperationException(Strings.lenientFormat("We are removing GWT-RPC support for Guava types. You can temporarily reenable support by setting the system property %s to true. For more about system properties, see %s. For more about Guava's GWT-RPC support, see %s.", new Object[]{"guava.gwt.emergency_reenable_rpc", "https://stackoverflow.com/q/5189914/28465", "https://groups.google.com/d/msg/guava-announce/zHZTFg7YF3o/rQNnwdHeEwAJ"}));
    }
}
