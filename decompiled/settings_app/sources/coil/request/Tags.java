package coil.request;

import android.icu.text.PluralRules;
import androidx.exifinterface.media.ExifInterface;
import coil.util.Collections;
import com.bytedance.tracing.internal.TracingConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Tags.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001f\b\u0002\u0012\u0016\u0010\u0002\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0016\u0010\u0006\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u00010\u0003J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u0004\u0018\u0001H\r\"\n\b\u0000\u0010\r\u0018\u0001*\u00020\u0001H\u0086\b¢\u0006\u0002\u0010\u000eJ'\u0010\f\u001a\u0004\u0018\u0001H\r\"\b\b\u0000\u0010\r*\u00020\u00012\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\r0\u0004¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u001e\u0010\u0002\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcoil/request/Tags;", "", TracingConstants.KEY_TAGS, "", "Ljava/lang/Class;", "(Ljava/util/Map;)V", "asMap", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "", "tag", ExifInterface.GPS_DIRECTION_TRUE, "()Ljava/lang/Object;", "type", "(Ljava/lang/Class;)Ljava/lang/Object;", "toString", "", "Companion", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Tags {
    public static final Companion Companion = null;
    public static final Tags EMPTY = null;
    private final Map<Class<?>, Object> tags;

    /* JADX INFO: compiled from: Tags.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00042\u0016\u0010\u0006\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcoil/request/Tags$Companion;", "", "()V", "EMPTY", "Lcoil/request/Tags;", "from", TracingConstants.KEY_TAGS, "", "Ljava/lang/Class;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Tags from(Map<Class<?>, ? extends Object> r2) {
            return new Tags(Collections.toImmutableMap(r2), null);
        }
    }

    public /* synthetic */ Tags(Map r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    @JvmStatic
    public static final Tags from(Map<Class<?>, ? extends Object> r1) {
        return Companion.from(r1);
    }

    private Tags(Map<Class<?>, ? extends Object> r1) {
        this.tags = r1;
    }

    public final /* synthetic */ <T> T tag() {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) tag(Object.class);
    }

    public final <T> T tag(Class<? extends T> r1) {
        return r1.cast(this.tags.get(r1));
    }

    public final Map<Class<?>, Object> asMap() {
        return this.tags;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L6;
        return true;
    L6:
        if ((r3 instanceof Tags) == true) goto L8;
    L10:
        return false;
    L8:
        if (Intrinsics.areEqual(this.tags, ((Tags) r3).tags) == false) goto L10;
        return true;
    }

    public int hashCode() {
        return this.tags.hashCode();
    }

    public String toString() {
        return "Tags(tags=" + this.tags + ')';
    }

    static {
        Companion = new Companion(null);
        EMPTY = new Tags(MapsKt.emptyMap());
    }
}
