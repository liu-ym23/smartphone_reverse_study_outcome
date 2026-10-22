package retrofit2.converter.gson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.q0;
import okhttp3.w0;
import retrofit2.Converter;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: classes3.dex */
public final class GsonConverterFactory extends Converter.Factory {
    private final Gson gson;

    private GsonConverterFactory(Gson r5) {
        if (r5 == null) goto L7;
        this.gson = r5;
        return;
    L7:
        throw new NullPointerException("gson == null");
    }

    public static GsonConverterFactory create() {
        return create(new Gson());
    }

    @Override // retrofit2.Converter.Factory
    public Converter<?, q0> requestBodyConverter(Type r5, Annotation[] r10, Annotation[] r11, Retrofit r12) {
        TypeAdapter r13 = this.gson.getAdapter(TypeToken.get(r5));
        return new GsonRequestBodyConverter(this.gson, r13);
    }

    @Override // retrofit2.Converter.Factory
    public Converter<w0, ?> responseBodyConverter(Type r5, Annotation[] r10, Retrofit r11) {
        TypeAdapter r12 = this.gson.getAdapter(TypeToken.get(r5));
        return new GsonResponseBodyConverter(this.gson, r12);
    }

    public static GsonConverterFactory create(Gson r5) {
        return new GsonConverterFactory(r5);
    }
}
