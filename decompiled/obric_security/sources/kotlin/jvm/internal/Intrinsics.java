package kotlin.jvm.internal;

import com.bytedance.librarian.LibrarianImpl;
import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes5.dex */
public class Intrinsics {

    public static class Kotlin {
        private Kotlin() {
        }
    }

    public static int compare(int r0, int r1) {
        if (r0 >= r1) goto L4;
        return -1;
    L4:
        if (r0 != r1) goto L6;
        return 0;
    L6:
        return 1;
    }

    public static int compare(long r0, long r2) {
        if (r0 >= r2) goto L5;
        return -1;
    L5:
        if (r0 != r2) goto L7;
        return 0;
    L7:
        return 1;
    }

    private Intrinsics() {
    }

    public static String stringPlus(String r1, Object r2) {
        return r1 + r2;
    }

    public static void checkNotNull(Object r0) {
        if (r0 != null) goto L5;
        throwJavaNpe();
        return;
    }

    public static void checkNotNull(Object r0, String r1) {
        if (r0 != null) goto L5;
        throwJavaNpe(r1);
        return;
    }

    public static void throwNpe() {
        throw ((KotlinNullPointerException) sanitizeStackTrace(new KotlinNullPointerException()));
    }

    public static void throwNpe(String r1) {
        throw ((KotlinNullPointerException) sanitizeStackTrace(new KotlinNullPointerException(r1)));
    }

    public static void throwJavaNpe() {
        throw ((NullPointerException) sanitizeStackTrace(new NullPointerException()));
    }

    public static void throwJavaNpe(String r1) {
        throw ((NullPointerException) sanitizeStackTrace(new NullPointerException(r1)));
    }

    public static void throwUninitializedProperty(String r1) {
        throw ((UninitializedPropertyAccessException) sanitizeStackTrace(new UninitializedPropertyAccessException(r1)));
    }

    public static void throwUninitializedPropertyAccessException(String r2) {
        throwUninitializedProperty("lateinit property " + r2 + " has not been initialized");
    }

    public static void throwAssert() {
        throw ((AssertionError) sanitizeStackTrace(new AssertionError()));
    }

    public static void throwAssert(String r1) {
        throw ((AssertionError) sanitizeStackTrace(new AssertionError(r1)));
    }

    public static void throwIllegalArgument() {
        throw ((IllegalArgumentException) sanitizeStackTrace(new IllegalArgumentException()));
    }

    public static void throwIllegalArgument(String r1) {
        throw ((IllegalArgumentException) sanitizeStackTrace(new IllegalArgumentException(r1)));
    }

    public static void throwIllegalState() {
        throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException()));
    }

    public static void throwIllegalState(String r1) {
        throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException(r1)));
    }

    public static void checkExpressionValueIsNotNull(Object r1, String r2) {
        if (r1 == null) goto L5;
        return;
    L5:
        throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException(r2 + " must not be null")));
    }

    public static void checkNotNullExpressionValue(Object r1, String r2) {
        if (r1 == null) goto L5;
        return;
    L5:
        throw ((NullPointerException) sanitizeStackTrace(new NullPointerException(r2 + " must not be null")));
    }

    public static void checkReturnedValueIsNotNull(Object r2, String r3, String r4) {
        if (r2 == null) goto L5;
        return;
    L5:
        throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException("Method specified as non-null returned null: " + r3 + LibrarianImpl.Constants.DOT + r4)));
    }

    public static void checkReturnedValueIsNotNull(Object r0, String r1) {
        if (r0 == null) goto L5;
        return;
    L5:
        throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException(r1)));
    }

    public static void checkFieldIsNotNull(Object r2, String r3, String r4) {
        if (r2 == null) goto L5;
        return;
    L5:
        throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException("Field specified as non-null is null: " + r3 + LibrarianImpl.Constants.DOT + r4)));
    }

    public static void checkFieldIsNotNull(Object r0, String r1) {
        if (r0 == null) goto L5;
        return;
    L5:
        throw ((IllegalStateException) sanitizeStackTrace(new IllegalStateException(r1)));
    }

    public static void checkParameterIsNotNull(Object r0, String r1) {
        if (r0 != null) goto L5;
        throwParameterIsNullIAE(r1);
        return;
    }

    public static void checkNotNullParameter(Object r0, String r1) {
        if (r0 != null) goto L5;
        throwParameterIsNullNPE(r1);
        return;
    }

    private static void throwParameterIsNullIAE(String r1) {
        throw ((IllegalArgumentException) sanitizeStackTrace(new IllegalArgumentException(createParameterIsNullExceptionMessage(r1))));
    }

    private static void throwParameterIsNullNPE(String r1) {
        throw ((NullPointerException) sanitizeStackTrace(new NullPointerException(createParameterIsNullExceptionMessage(r1))));
    }

    private static String createParameterIsNullExceptionMessage(String r4) {
        StackTraceElement[] r0 = Thread.currentThread().getStackTrace();
        String r1 = Intrinsics.class.getName();
        int r2 = 0;
    L4:
        if (r0[r2].getClassName().equals(r1) == true) goto L7;
        r2 = r2 + 1;
    L7:
        if (r0[r2].getClassName().equals(r1) == false) goto L9;
        r2 = r2 + 1;
        goto L7
    L9:
        StackTraceElement r3 = r0[r2];
        return "Parameter specified as non-null is null: method " + r3.getClassName() + LibrarianImpl.Constants.DOT + r3.getMethodName() + ", parameter " + r4;
    }

    public static boolean areEqual(Object r0, Object r1) {
        if (r0 != null) goto L7;
        if (r1 != null) goto L5;
        return true;
    L5:
        return false;
    L7:
        return r0.equals(r1);
    }

    public static boolean areEqual(Double r4, Double r5) {
        if (r4 != null) goto L6;
        if (r5 != null) goto L11;
        return true;
    L11:
        return false;
    L6:
        if (r5 == null) goto L11;
        if (r4.doubleValue() != r5.doubleValue()) goto L11;
        return true;
    }

    public static boolean areEqual(Double r2, double r3) {
        if (r2 != null) goto L4;
    L6:
        return false;
    L4:
        if (r2.doubleValue() != r3) goto L6;
        return true;
    }

    public static boolean areEqual(double r2, Double r4) {
        if (r4 != null) goto L4;
    L6:
        return false;
    L4:
        if (r2 != r4.doubleValue()) goto L6;
        return true;
    }

    public static boolean areEqual(Float r2, Float r3) {
        if (r2 != null) goto L6;
        if (r3 != null) goto L11;
        return true;
    L11:
        return false;
    L6:
        if (r3 == null) goto L11;
        if (r2.floatValue() != r3.floatValue()) goto L11;
        return true;
    }

    public static boolean areEqual(Float r0, float r1) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0.floatValue() != r1) goto L6;
        return true;
    }

    public static boolean areEqual(float r0, Float r1) {
        if (r1 != null) goto L4;
    L6:
        return false;
    L4:
        if (r0 != r1.floatValue()) goto L6;
        return true;
    }

    public static void throwUndefinedForReified() {
        throwUndefinedForReified("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void throwUndefinedForReified(String r1) {
        throw new UnsupportedOperationException(r1);
    }

    public static void reifiedOperationMarker(int r0, String r1) {
        throwUndefinedForReified();
    }

    public static void reifiedOperationMarker(int r0, String r1, String r2) {
        throwUndefinedForReified(r2);
    }

    public static void needClassReification() {
        throwUndefinedForReified();
    }

    public static void needClassReification(String r0) {
        throwUndefinedForReified(r0);
    }

    public static void checkHasClass(String r4) throws ClassNotFoundException {
        String r5 = r4.replace(IOUtils.DIR_SEPARATOR_UNIX, '.');
        Class.forName(r5);     // Catch: ClassNotFoundException -> L5
        return;
    L5:
        e = move-exception;
        throw ((ClassNotFoundException) sanitizeStackTrace(new ClassNotFoundException("Class " + r5 + " is not found. Please update the Kotlin runtime to the latest version", e)));
    }

    public static void checkHasClass(String r4, String r5) throws ClassNotFoundException {
        String r6 = r4.replace(IOUtils.DIR_SEPARATOR_UNIX, '.');
        Class.forName(r6);     // Catch: ClassNotFoundException -> L5
        return;
    L5:
        e = move-exception;
        throw ((ClassNotFoundException) sanitizeStackTrace(new ClassNotFoundException("Class " + r6 + " is not found: this code requires the Kotlin runtime of version at least " + r5, e)));
    }

    private static <T extends Throwable> T sanitizeStackTrace(T r1) {
        return (T) sanitizeStackTrace(r1, Intrinsics.class.getName());
    }

    static <T extends Throwable> T sanitizeStackTrace(T r5, String r6) {
        StackTraceElement[] r0 = r5.getStackTrace();
        int r1 = r0.length;
        int r2 = -1;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L8;
        if (r6.equals(r0[r3].getClassName()) == false) goto L7;
        r2 = r3;
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        r5.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(r0, r2 + 1, r1));
        return r5;
    }
}
