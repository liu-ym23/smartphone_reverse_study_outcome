package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import okhttp3.w0;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: loaded from: classes3.dex */
@IgnoreJRERequirement
final class OptionalConverterFactory extends Converter.Factory {
    static final Converter.Factory INSTANCE = null;

    @IgnoreJRERequirement
    public static final class OptionalConverter<T> implements Converter<w0, Optional<T>> {
        final Converter<w0, T> delegate;

        public OptionalConverter(Converter<w0, T> r5) {
            this.delegate = r5;
        }

        @Override // retrofit2.Converter
        public /* bridge */ /* synthetic */ Object convert(w0 r5) throws IOException {
            return convert2(r5);
        }

        /* JADX INFO: renamed from: convert, reason: avoid collision after fix types in other method */
        public Optional<T> convert2(w0 r5) throws IOException {
            return Optional.ofNullable(this.delegate.convert(r5));
        }
    }

    static {
        INSTANCE = new OptionalConverterFactory();
    }

    public OptionalConverterFactory() {
    }

    @Override // retrofit2.Converter.Factory
    public Converter<w0, ?> responseBodyConverter(Type r5, Annotation[] r10, Retrofit r11) {
        if (Converter.Factory.getRawType(r5) == Optional.class) goto L7;
        return null;
    L7:
        return new OptionalConverter(r11.responseBodyConverter(Converter.Factory.getParameterUpperBound(0, (ParameterizedType) r5), r10));
    }
}
