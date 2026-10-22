package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes2.dex */
public class ReflectionFactory {
    public static String a(FunctionBase r1) {
        String r2 = r1.getClass().getGenericInterfaces()[0].toString();
        if (r2.startsWith("kotlin.jvm.functions.") == true) goto L5;
        return r2;
    L5:
        return r2.substring(21);
    }
}
