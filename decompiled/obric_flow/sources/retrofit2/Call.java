package retrofit2;

import java.io.IOException;
import nu.f0;
import okhttp3.Request;

/* JADX INFO: loaded from: classes3.dex */
public interface Call<T> extends Cloneable {
    void cancel();

    /* JADX INFO: renamed from: clone */
    Call<T> mo1704clone();

    void enqueue(Callback<T> r5);

    Response<T> execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    Request request();

    f0 timeout();
}
