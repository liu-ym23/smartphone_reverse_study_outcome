package coil;

import androidx.exifinterface.media.ExifInterface;
import coil.decode.Decoder;
import coil.fetch.Fetcher;
import coil.fetch.SourceResult;
import coil.intercept.Interceptor;
import coil.key.Keyer;
import coil.map.Mapper;
import coil.request.Options;
import coil.util.Collections;
import com.android.settings.search.IndexDatabaseHelper;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ComponentRegistry.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001)B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B©\u0001\b\u0002\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00120\u0010\u0006\u001a,\u0012(\u0012&\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0006\b\u0001\u0012\u00020\u00010\b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\t0\u00070\u0004\u0012(\u0010\n\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\t0\u00070\u0004\u0012(\u0010\f\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\r\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\t0\u00070\u0004\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001d\u001a\u00020\u001eJ8\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!\u0018\u00010\u00072\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020!H\u0007J8\u0010'\u001a\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020!\u0018\u00010\u00072\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020!H\u0007R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R3\u0010\f\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\r\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\t0\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R3\u0010\n\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\t0\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R;\u0010\u0006\u001a,\u0012(\u0012&\u0012\u0014\u0012\u0012\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0006\b\u0001\u0012\u00020\u00010\b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\t0\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012¨\u0006*"}, d2 = {"Lcoil/ComponentRegistry;", "", "()V", "interceptors", "", "Lcoil/intercept/Interceptor;", "mappers", "Lkotlin/Pair;", "Lcoil/map/Mapper;", "Ljava/lang/Class;", "keyers", "Lcoil/key/Keyer;", "fetcherFactories", "Lcoil/fetch/Fetcher$Factory;", "decoderFactories", "Lcoil/decode/Decoder$Factory;", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getDecoderFactories", "()Ljava/util/List;", "getFetcherFactories", "getInterceptors", "getKeyers", "getMappers", "key", "", "data", "options", "Lcoil/request/Options;", "map", "newBuilder", "Lcoil/ComponentRegistry$Builder;", "newDecoder", "Lcoil/decode/Decoder;", "", "result", "Lcoil/fetch/SourceResult;", "imageLoader", "Lcoil/ImageLoader;", "startIndex", "newFetcher", "Lcoil/fetch/Fetcher;", "Builder", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ComponentRegistry {
    private final List<Decoder.Factory> decoderFactories;
    private final List<Pair<Fetcher.Factory<? extends Object>, Class<? extends Object>>> fetcherFactories;
    private final List<Interceptor> interceptors;
    private final List<Pair<Keyer<? extends Object>, Class<? extends Object>>> keyers;
    private final List<Pair<Mapper<? extends Object, ? extends Object>, Class<? extends Object>>> mappers;

    /* JADX INFO: compiled from: ComponentRegistry.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\bJ#\u0010\u0019\u001a\u00020\u0000\"\n\b\u0000\u0010\u001b\u0018\u0001*\u00020\u00012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u001b0\rH\u0086\bJ,\u0010\u0019\u001a\u00020\u0000\"\b\b\u0000\u0010\u001b*\u00020\u00012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u001b0\r2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u000eJ\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0011J#\u0010\u0019\u001a\u00020\u0000\"\n\b\u0000\u0010\u001b\u0018\u0001*\u00020\u00012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u0014H\u0086\bJ,\u0010\u0019\u001a\u00020\u0000\"\b\b\u0000\u0010\u001b*\u00020\u00012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u00142\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u000eJ'\u0010\u0019\u001a\u00020\u0000\"\n\b\u0000\u0010\u001b\u0018\u0001*\u00020\u00012\u0010\u0010\u001f\u001a\f\u0012\u0004\u0012\u0002H\u001b\u0012\u0002\b\u00030\u0017H\u0086\bJ0\u0010\u0019\u001a\u00020\u0000\"\b\b\u0000\u0010\u001b*\u00020\u00012\u0010\u0010\u001f\u001a\f\u0012\u0004\u0012\u0002H\u001b\u0012\u0002\b\u00030\u00172\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u000eJ\u0006\u0010 \u001a\u00020\u0004R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR6\u0010\u000b\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\r\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000e0\f0\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\nR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\nR6\u0010\u0013\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0014\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000e0\f0\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\nR:\u0010\u0016\u001a(\u0012$\u0012\"\u0012\u0010\u0012\u000e\u0012\u0006\b\u0001\u0012\u00020\u0001\u0012\u0002\b\u00030\u0017\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u000e0\f0\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\n¨\u0006!"}, d2 = {"Lcoil/ComponentRegistry$Builder;", "", "()V", "registry", "Lcoil/ComponentRegistry;", "(Lcoil/ComponentRegistry;)V", "decoderFactories", "", "Lcoil/decode/Decoder$Factory;", "getDecoderFactories$coil_base_release", "()Ljava/util/List;", "fetcherFactories", "Lkotlin/Pair;", "Lcoil/fetch/Fetcher$Factory;", "Ljava/lang/Class;", "getFetcherFactories$coil_base_release", "interceptors", "Lcoil/intercept/Interceptor;", "getInterceptors$coil_base_release", "keyers", "Lcoil/key/Keyer;", "getKeyers$coil_base_release", "mappers", "Lcoil/map/Mapper;", "getMappers$coil_base_release", "add", "factory", ExifInterface.GPS_DIRECTION_TRUE, "type", "interceptor", "keyer", "mapper", IndexDatabaseHelper.MetaColumns.BUILD, "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder {
        private final List<Decoder.Factory> decoderFactories;
        private final List<Pair<Fetcher.Factory<? extends Object>, Class<? extends Object>>> fetcherFactories;
        private final List<Interceptor> interceptors;
        private final List<Pair<Keyer<? extends Object>, Class<? extends Object>>> keyers;
        private final List<Pair<Mapper<? extends Object, ?>, Class<? extends Object>>> mappers;

        public final List<Interceptor> getInterceptors$coil_base_release() {
            return this.interceptors;
        }

        public final List<Pair<Mapper<? extends Object, ?>, Class<? extends Object>>> getMappers$coil_base_release() {
            return this.mappers;
        }

        public final List<Pair<Keyer<? extends Object>, Class<? extends Object>>> getKeyers$coil_base_release() {
            return this.keyers;
        }

        public final List<Pair<Fetcher.Factory<? extends Object>, Class<? extends Object>>> getFetcherFactories$coil_base_release() {
            return this.fetcherFactories;
        }

        public final List<Decoder.Factory> getDecoderFactories$coil_base_release() {
            return this.decoderFactories;
        }

        public Builder() {
            this.interceptors = new ArrayList();
            this.mappers = new ArrayList();
            this.keyers = new ArrayList();
            this.fetcherFactories = new ArrayList();
            this.decoderFactories = new ArrayList();
        }

        public Builder(ComponentRegistry r2) {
            this.interceptors = CollectionsKt.toMutableList(r2.getInterceptors());
            this.mappers = CollectionsKt.toMutableList(r2.getMappers());
            this.keyers = CollectionsKt.toMutableList(r2.getKeyers());
            this.fetcherFactories = CollectionsKt.toMutableList(r2.getFetcherFactories());
            this.decoderFactories = CollectionsKt.toMutableList(r2.getDecoderFactories());
        }

        public final Builder add(Interceptor r2) {
            this.interceptors.add(r2);
            return this;
        }

        public final /* synthetic */ <T> Builder add(Mapper<T, ?> r3) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            return add(r3, Object.class);
        }

        public final <T> Builder add(Mapper<T, ?> r2, Class<T> r3) {
            this.mappers.add(TuplesKt.to(r2, r3));
            return this;
        }

        public final /* synthetic */ <T> Builder add(Keyer<T> r3) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            return add(r3, Object.class);
        }

        public final <T> Builder add(Keyer<T> r2, Class<T> r3) {
            this.keyers.add(TuplesKt.to(r2, r3));
            return this;
        }

        public final /* synthetic */ <T> Builder add(Fetcher.Factory<T> r3) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            return add(r3, Object.class);
        }

        public final <T> Builder add(Fetcher.Factory<T> r2, Class<T> r3) {
            this.fetcherFactories.add(TuplesKt.to(r2, r3));
            return this;
        }

        public final Builder add(Decoder.Factory r2) {
            this.decoderFactories.add(r2);
            return this;
        }

        public final ComponentRegistry build() {
            return new ComponentRegistry(Collections.toImmutableList(this.interceptors), Collections.toImmutableList(this.mappers), Collections.toImmutableList(this.keyers), Collections.toImmutableList(this.fetcherFactories), Collections.toImmutableList(this.decoderFactories), null);
        }
    }

    public /* synthetic */ ComponentRegistry(List r1, List r2, List r3, List r4, List r5, DefaultConstructorMarker r6) {
        this(r1, r2, r3, r4, r5);
    }

    public final Pair<Decoder, Integer> newDecoder(SourceResult r8, Options r9, ImageLoader r10) {
        return newDecoder$default(this, r8, r9, r10, 0, 8, null);
    }

    public final Pair<Fetcher, Integer> newFetcher(Object r8, Options r9, ImageLoader r10) {
        return newFetcher$default(this, r8, r9, r10, 0, 8, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ComponentRegistry(List<? extends Interceptor> r1, List<? extends Pair<? extends Mapper<? extends Object, ? extends Object>, ? extends Class<? extends Object>>> r2, List<? extends Pair<? extends Keyer<? extends Object>, ? extends Class<? extends Object>>> r3, List<? extends Pair<? extends Fetcher.Factory<? extends Object>, ? extends Class<? extends Object>>> r4, List<? extends Decoder.Factory> r5) {
        this.interceptors = r1;
        this.mappers = r2;
        this.keyers = r3;
        this.fetcherFactories = r4;
        this.decoderFactories = r5;
    }

    public final List<Interceptor> getInterceptors() {
        return this.interceptors;
    }

    public final List<Pair<Mapper<? extends Object, ? extends Object>, Class<? extends Object>>> getMappers() {
        return this.mappers;
    }

    public final List<Pair<Keyer<? extends Object>, Class<? extends Object>>> getKeyers() {
        return this.keyers;
    }

    public final List<Pair<Fetcher.Factory<? extends Object>, Class<? extends Object>>> getFetcherFactories() {
        return this.fetcherFactories;
    }

    public final List<Decoder.Factory> getDecoderFactories() {
        return this.decoderFactories;
    }

    public ComponentRegistry() {
        this(CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList());
    }

    public final Object map(Object r6, Options r7) {
        List<Pair<Mapper<? extends Object, ? extends Object>, Class<? extends Object>>> r5 = this.mappers;
        int r0 = r5.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        Pair<Mapper<? extends Object, ? extends Object>, Class<? extends Object>> r2 = r5.get(r1);
        Mapper<? extends Object, ? extends Object> r3 = r2.component1();
        if (r2.component2().isAssignableFrom(r6.getClass()) == false) goto L9;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type coil.map.Mapper<kotlin.Any, *>");
        Object r4 = r3.map(r6, r7);
        if (r4 == null) goto L9;
        r6 = r4;
    L9:
        r1 = r1 + 1;
        goto L3
    L10:
        return r6;
    }

    public final String key(Object r6, Options r7) {
        List<Pair<Keyer<? extends Object>, Class<? extends Object>>> r5 = this.keyers;
        int r0 = r5.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L10;
        Pair<Keyer<? extends Object>, Class<? extends Object>> r2 = r5.get(r1);
        Keyer<? extends Object> r3 = r2.component1();
        if (r2.component2().isAssignableFrom(r6.getClass()) == false) goto L9;
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type coil.key.Keyer<kotlin.Any>");
        String r4 = r3.key(r6, r7);
        if (r4 == null) goto L9;
        return r4;
    L9:
        r1 = r1 + 1;
        goto L3
    L10:
        return null;
    }

    public static /* synthetic */ Pair newFetcher$default(ComponentRegistry r0, Object r1, Options r2, ImageLoader r3, int r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r4 = 0;
    L6:
        return r0.newFetcher(r1, r2, r3, r4);
    }

    public final Pair<Fetcher, Integer> newFetcher(Object r5, Options r6, ImageLoader r7, int r8) {
        int r0 = this.fetcherFactories.size();
    L3:
        if (r8 >= r0) goto L11;
        Pair<Fetcher.Factory<? extends Object>, Class<? extends Object>> r1 = this.fetcherFactories.get(r8);
        Fetcher.Factory<? extends Object> r2 = r1.component1();
        if (r1.component2().isAssignableFrom(r5.getClass()) == false) goto L10;
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type coil.fetch.Fetcher.Factory<kotlin.Any>");
        Fetcher r3 = r2.create(r5, r6, r7);
        if (r3 == null) goto L10;
        return TuplesKt.to(r3, Integer.valueOf(r8));
    L10:
        r8 = r8 + 1;
        goto L3
    L11:
        return null;
    }

    public static /* synthetic */ Pair newDecoder$default(ComponentRegistry r0, SourceResult r1, Options r2, ImageLoader r3, int r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L6;
        r4 = 0;
    L6:
        return r0.newDecoder(r1, r2, r3, r4);
    }

    public final Pair<Decoder, Integer> newDecoder(SourceResult r3, Options r4, ImageLoader r5, int r6) {
        int r0 = this.decoderFactories.size();
    L3:
        if (r6 >= r0) goto L9;
        Decoder r1 = this.decoderFactories.get(r6).create(r3, r4, r5);
        if (r1 != null) goto L7;
        r6 = r6 + 1;
        goto L3
    L7:
        return TuplesKt.to(r1, Integer.valueOf(r6));
    L9:
        return null;
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }
}
