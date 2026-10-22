package tmsdk.common.exception;

/* JADX INFO: loaded from: classes5.dex */
public class NotInitializedException extends Exception {
    public NotInitializedException() {
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "没有完成初始化配置";
    }
}
