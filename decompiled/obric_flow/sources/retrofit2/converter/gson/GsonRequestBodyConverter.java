package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.regex.Pattern;
import nu.i;
import nu.j;
import okhttp3.h0;
import okhttp3.q0;
import okhttp3.z;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes3.dex */
final class GsonRequestBodyConverter<T> implements Converter<T, q0> {
    private static final h0 MEDIA_TYPE = null;
    private static final Charset UTF_8 = null;
    private final TypeAdapter<T> adapter;
    private final Gson gson;

    static {
        Pattern r5 = h0.e;
        MEDIA_TYPE = z.j("application/json; charset=UTF-8");
        UTF_8 = Charset.forName("UTF-8");
    }

    public GsonRequestBodyConverter(Gson r5, TypeAdapter<T> r10) {
        this.gson = r5;
        this.adapter = r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // retrofit2.Converter
    public /* bridge */ /* synthetic */ q0 convert(Object r5) throws IOException {
        return convert2(r5);
    }

    @Override // retrofit2.Converter
    /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
    public q0 convert2(T r5) throws IOException {
        j r10 = new j();
        OutputStreamWriter r11 = new OutputStreamWriter(new i(r10), UTF_8);
        JsonWriter r12 = this.gson.newJsonWriter(r11);
        this.adapter.write(r12, r5);
        r12.close();
        return q0.create(MEDIA_TYPE, r10.v(r10.f20328b));
    }
}
