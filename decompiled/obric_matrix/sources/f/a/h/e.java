package f.a.h;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends IllegalStateException {
    public e(Throwable r3) {
        super("The exception could not be delivered to the consumer because it has already canceled/disposed the flow or the exception has nowhere to go to begin with. Further reading: https://github.com/ReactiveX/RxJava/wiki/What's-different-in-2.0#error-handling | " + r3, r3);
    }
}
