package com.obric.capabilitykit.common;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.obric.capabilitykit.entity.app.AppEntity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\n\u0012\u0004\u0012\u0002H\u0005\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/obric/capabilitykit/entity/EntityTypeAdapterFactory;", "Lcom/google/gson/TypeAdapterFactory;", "()V", "create", "Lcom/google/gson/TypeAdapter;", ExifInterface.GPS_DIRECTION_TRUE, "gson", "Lcom/google/gson/Gson;", "type", "Lcom/google/gson/reflect/TypeToken;", "Companion", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class g implements TypeAdapterFactory {
    public static final a a = null;
    private static final String b = "yyyy-MM-dd HH:mm:ss";
    private static final String c = "createTime";
    private static final String d = "lastModifiedTime";
    private static final String e = "createTimeStamp";
    private static final String f = "lastModifiedTimeStamp";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/obric/capabilitykit/entity/EntityTypeAdapterFactory$Companion;", "", "()V", "KEY_CREATE_TIME", "", "KEY_CREATE_TIME_STAMP", "KEY_LAST_MODIFIED_TIME", "KEY_LAST_MODIFIED_TIME_STAMP", "TIME_FORMAT", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0015\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00020\u0004H\u0016¢\u0006\u0002\u0010\u0005J\u001d\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"com/obric/capabilitykit/entity/EntityTypeAdapterFactory$create$1", "Lcom/google/gson/TypeAdapter;", "read", "input", "Lcom/google/gson/stream/JsonReader;", "(Lcom/google/gson/stream/JsonReader;)Ljava/lang/Object;", "write", "", "out", "Lcom/google/gson/stream/JsonWriter;", "value", "(Lcom/google/gson/stream/JsonWriter;Ljava/lang/Object;)V", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b<T> extends TypeAdapter<T> {
        public final /* synthetic */ TypeAdapter<T> a;
        public final /* synthetic */ Gson b;

        public b(TypeAdapter<T> r1, Gson r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // com.google.gson.TypeAdapter
        public T read(JsonReader r9) {
            Intrinsics.checkNotNullParameter(r9, "input");
            JsonObject r10 = new JsonParser().parse(r9).getAsJsonObject();
            String r1 = r10.get(g.c).getAsString();
            String r3 = r10.get(g.d).getAsString();
            SimpleDateFormat r4 = new SimpleDateFormat(g.b, Locale.getDefault());
            Long r7 = null;
            if (r10.has(g.e) == false) goto L7;
            long r5 = r10.get(g.e).getAsLong();
        L5:
            Long r2 = Long.valueOf(r5);
        L6:
            r10.addProperty(g.c, r2);
            if (r10.has(g.f) == false) goto L14;
            r10.addProperty(g.d, Long.valueOf(r10.get(g.f).getAsLong()));
        L19:
            return this.a.fromJsonTree(r10);
        L14:
            Date r0 = r4.parse(r3);
            if (r0 == null) goto L17;
            r7 = Long.valueOf(r0.getTime());
        L17:
            r10.addProperty(g.d, r7);
            goto L19
        L7:
            Date r6 = r4.parse(r1);
            if (r6 == null) goto L10;
            r5 = r6.getTime();
            goto L5
        L10:
            r2 = null;
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter r8, T r9) {
            Intrinsics.checkNotNullParameter(r8, "out");
            JsonObject r0 = this.a.toJsonTree(r9).getAsJsonObject();
            Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.AppEntity");
            AppEntity r10 = (AppEntity) r9;
            long r1 = r10.getCreateTime();
            long r3 = r10.getLastModifiedTime();
            SimpleDateFormat r11 = new SimpleDateFormat(g.b, Locale.getDefault());
            r0.addProperty(g.c, r11.format(new Date(r1)));
            r0.addProperty(g.e, Long.valueOf(r1));
            r0.addProperty(g.d, r11.format(new Date(r3)));
            r0.addProperty(g.f, Long.valueOf(r3));
            this.b.toJson(r0, r8);
        }
    }

    static {
        a = new a(null);
    }

    public g() {
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson r2, TypeToken<T> r3) {
        Intrinsics.checkNotNullParameter(r2, "gson");
        Intrinsics.checkNotNullParameter(r3, "type");
        TypeAdapter<T> r1 = r2.getDelegateAdapter(this, r3);
        if (AppEntity.class.isAssignableFrom(r3.getRawType()) == true) goto L5;
        return null;
    L5:
        return new b(r1, r2).nullSafe();
    }
}
