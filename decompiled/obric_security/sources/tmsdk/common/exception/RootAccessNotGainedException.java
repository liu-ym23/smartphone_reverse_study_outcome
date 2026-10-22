package tmsdk.common.exception;

/* JADX INFO: loaded from: classes5.dex */
public class RootAccessNotGainedException extends RuntimeException {
    public RootAccessNotGainedException() {
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "Root permission is not granted!";
    }
}
