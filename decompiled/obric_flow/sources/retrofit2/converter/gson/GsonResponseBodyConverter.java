package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import java.io.IOException;
import okhttp3.w0;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes3.dex */
final class GsonResponseBodyConverter<T> implements Converter<w0, T> {
    private final TypeAdapter<T> adapter;
    private final Gson gson;

    public GsonResponseBodyConverter(Gson r5, TypeAdapter<T> r10) {
        this.gson = r5;
        this.adapter = r10;
    }

    @Override // retrofit2.Converter
    public /* bridge */ /* synthetic */ Object convert(w0 r5) throws IOException {
        return convert2(r5);
    }

    /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
    public T convert2(w0 r5) throws IOException {
        JsonReader r10 = this.gson.newJsonReader(r5.charStream());
        T r11 = this.adapter.read(r10);     // Catch: Throwable -> L6
        r5.close();
        return r11;
    L6:
        th = move-exception;
        r5.close();
        throw th;
    }
}
