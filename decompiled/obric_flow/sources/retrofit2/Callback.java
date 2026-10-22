package retrofit2;

/* JADX INFO: loaded from: classes3.dex */
public interface Callback<T> {
    void onFailure(Call<T> r5, Throwable r10);

    void onResponse(Call<T> r5, Response<T> r10);
}
