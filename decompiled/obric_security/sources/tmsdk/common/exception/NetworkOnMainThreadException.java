package tmsdk.common.exception;

/* JADX INFO: loaded from: classes5.dex */
public class NetworkOnMainThreadException extends RuntimeException {
    public NetworkOnMainThreadException() {
        super("Network cannot run on main thread if the targetSDKVersion is over 9 please make sure not to invoke network relevant methods on the main thread or change the manifest targetSDKVersion to be under 10");
    }

    public NetworkOnMainThreadException(String r1) {
        super(r1);
    }
}
