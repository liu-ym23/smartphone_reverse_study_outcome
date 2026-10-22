package okhttp3;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class Headers implements Iterable<Pair<? extends String, ? extends String>>, KMappedMarker {
    public static final Companion Companion = null;
    private final String[] namesAndValues;

    @Metadata
    public static final class Builder {

        @NotNull
        private final List<String> namesAndValues;

        public Builder() {
            this.namesAndValues = new ArrayList(20);
        }

        @NotNull
        public final Builder add(@NotNull String r4) {
            Intrinsics.f(r4, "line");
            int r0 = StringsKt.r(r4, ':', 0, false, 6);
            if (r0 == (-1)) goto L7;
            String r1 = r4.substring(0, r0);
            Intrinsics.e(r1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String r2 = StringsKt.J(r1).toString();
            String r5 = r4.substring(r0 + 1);
            Intrinsics.e(r5, "(this as java.lang.String).substring(startIndex)");
            add(r2, r5);
            return this;
        L7:
            throw new IllegalArgumentException("Unexpected header: ".concat(r4).toString());
        }

        @NotNull
        public final Builder addAll(@NotNull Headers r5) {
            Intrinsics.f(r5, "headers");
            int r0 = r5.size();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            addLenient$okhttp(r5.name(r1), r5.value(r1));
            r1 = r1 + 1;
            goto L3
        L5:
            return this;
        }

        @NotNull
        public final Builder addLenient$okhttp(@NotNull String r7) {
            Intrinsics.f(r7, "line");
            int r3 = StringsKt.r(r7, ':', 1, false, 4);
            if (r3 == (-1)) goto L6;
            String r0 = r7.substring(0, r3);
            Intrinsics.e(r0, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String r8 = r7.substring(r3 + 1);
            Intrinsics.e(r8, "(this as java.lang.String).substring(startIndex)");
            addLenient$okhttp(r0, r8);
        L9:
            return this;
        L6:
            if (r7.charAt(0) != ':') goto L8;
            String r9 = r7.substring(1);
            Intrinsics.e(r9, "(this as java.lang.String).substring(startIndex)");
            addLenient$okhttp("", r9);
            goto L9
        L8:
            addLenient$okhttp("", r7);
            goto L9
        }

        @NotNull
        public final Builder addUnsafeNonAscii(@NotNull String r2, @NotNull String r3) {
            Intrinsics.f(r2, "name");
            Intrinsics.f(r3, "value");
            Companion.access$checkName(Headers.Companion, r2);
            addLenient$okhttp(r2, r3);
            return this;
        }

        @NotNull
        public final Headers build() {
            Object[] r2 = this.namesAndValues.toArray(new String[0]);
            if (r2 == null) goto L7;
            return new Headers((String[]) r2, null);
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        @Nullable
        public final String get(@NotNull String r6) {
            Intrinsics.f(r6, "name");
            IntProgression r0 = RangesKt.d(new IntProgression(this.namesAndValues.size() - 2, 0, -1), 2);
            int r1 = r0.b;
            int r2 = r0.c;
            int r3 = r0.e;
            if (r3 < 0) goto L6;
            if (r1 <= r2) goto L8;
            return null;
        L8:
            if (r6.equalsIgnoreCase(this.namesAndValues.get(r1)) == true) goto L10;
            if (r1 == r2) goto L19;
            r1 = r1 + r3;
            goto L8
        L19:
            return null;
        L10:
            return this.namesAndValues.get(r1 + 1);
        L6:
            if (r1 >= r2) goto L8;
            return null;
        }

        @NotNull
        public final List<String> getNamesAndValues$okhttp() {
            return this.namesAndValues;
        }

        @NotNull
        public final Builder removeAll(@NotNull String r3) {
            Intrinsics.f(r3, "name");
            int r0 = 0;
        L4:
            if (r0 >= this.namesAndValues.size()) goto L9;
            if (r3.equalsIgnoreCase(this.namesAndValues.get(r0)) == false) goto L8;
            this.namesAndValues.remove(r0);
            this.namesAndValues.remove(r0);
            r0 = r0 - 2;
        L8:
            r0 = r0 + 2;
            goto L4
        L9:
            return this;
        }

        @NotNull
        public final Builder set(@NotNull String r2, @NotNull Date r3) {
            Intrinsics.f(r2, "name");
            Intrinsics.f(r3, "value");
            set(r2, DatesKt.toHttpDateString(r3));
            return this;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder set(@NotNull String r4, @NotNull Instant r5) {
            Intrinsics.f(r4, "name");
            Intrinsics.f(r5, "value");
            return set(r4, new Date(r5.toEpochMilli()));
        }

        @NotNull
        public final Builder set(@NotNull String r2, @NotNull String r3) {
            Intrinsics.f(r2, "name");
            Intrinsics.f(r3, "value");
            Companion r0 = Headers.Companion;
            Companion.access$checkName(r0, r2);
            Companion.access$checkValue(r0, r3, r2);
            removeAll(r2);
            addLenient$okhttp(r2, r3);
            return this;
        }

        @NotNull
        public final Builder add(@NotNull String r2, @NotNull String r3) {
            Intrinsics.f(r2, "name");
            Intrinsics.f(r3, "value");
            Companion r0 = Headers.Companion;
            Companion.access$checkName(r0, r2);
            Companion.access$checkValue(r0, r3, r2);
            addLenient$okhttp(r2, r3);
            return this;
        }

        @NotNull
        public final Builder add(@NotNull String r2, @NotNull Date r3) {
            Intrinsics.f(r2, "name");
            Intrinsics.f(r3, "value");
            add(r2, DatesKt.toHttpDateString(r3));
            return this;
        }

        @NotNull
        public final Builder addLenient$okhttp(@NotNull String r2, @NotNull String r3) {
            Intrinsics.f(r2, "name");
            Intrinsics.f(r3, "value");
            this.namesAndValues.add(r2);
            this.namesAndValues.add(StringsKt.J(r3).toString());
            return this;
        }

        @IgnoreJRERequirement
        @NotNull
        public final Builder add(@NotNull String r4, @NotNull Instant r5) {
            Intrinsics.f(r4, "name");
            Intrinsics.f(r5, "value");
            add(r4, new Date(r5.toEpochMilli()));
            return this;
        }
    }

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ void access$checkName(Companion r0, String r1) {
            r0.checkName(r1);
        }

        public static final /* synthetic */ void access$checkValue(Companion r0, String r1, String r2) {
            r0.checkValue(r1, r2);
        }

        public static final /* synthetic */ String access$get(Companion r0, String[] r1, String r2) {
            return r0.get(r1, r2);
        }

        private final void checkName(String r6) {
            if (r6.length() <= 0) goto L5;
            boolean r5 = true;
        L6:
            if (r5 == false) goto L22;
            int r7 = r6.length();
            int r2 = 0;
        L8:
            if (r2 >= r7) goto L20;
            char r3 = r6.charAt(r2);
            if ('!' <= r3) goto L13;
        L15:
            boolean r4 = false;
        L16:
            if (r4 == false) goto L19;
            r2 = r2 + 1;
            goto L8
        L19:
            throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", new Object[]{Integer.valueOf(r3), Integer.valueOf(r2), r6}).toString());
        L13:
            if ('~' < r3) goto L15;
            r4 = true;
            goto L16
        L20:
            return;
        L22:
            throw new IllegalArgumentException("name is empty".toString());
        L5:
            r5 = false;
            goto L6
        }

        private final void checkValue(String r5, String r6) {
            int r4 = r5.length();
            int r1 = 0;
        L3:
            if (r1 >= r4) goto L22;
            char r2 = r5.charAt(r1);
            if (r2 != '\t') goto L7;
        L13:
            boolean r3 = true;
        L14:
            if (r3 == false) goto L15;
            r1 = r1 + 1;
            goto L3
        L15:
            StringBuilder r7 = new StringBuilder();
            r7.append(Util.format("Unexpected char %#04x at %d in %s value", new Object[]{Integer.valueOf(r2), Integer.valueOf(r1), r6}));
            if (Util.isSensitiveHeader(r6) == false) goto L18;
            String r8 = "";
        L19:
            r7.append(r8);
            throw new IllegalArgumentException(r7.toString().toString());
        L18:
            r8 = ": ".concat(r5);
            goto L19
        L7:
            if (' ' <= r2) goto L10;
        L12:
            r3 = false;
            goto L14
        L10:
            if ('~' < r2) goto L12;
        }

        private final String get(String[] r5, String r6) {
            IntProgression r4 = RangesKt.d(new IntProgression(r5.length - 2, 0, -1), 2);
            int r0 = r4.b;
            int r1 = r4.c;
            int r7 = r4.e;
            if (r7 < 0) goto L6;
            if (r0 <= r1) goto L8;
            return null;
        L8:
            if (StringsKt.p(r6, r5[r0], true) == true) goto L10;
            if (r0 == r1) goto L19;
            r0 = r0 + r7;
            goto L8
        L19:
            return null;
        L10:
            return r5[r0 + 1];
        L6:
            if (r0 >= r1) goto L8;
            return null;
        }

        @Deprecated
        @JvmName
        @NotNull
        /* JADX INFO: renamed from: -deprecated_of, reason: not valid java name */
        public final Headers m95deprecated_of(@NotNull String... r2) {
            Intrinsics.f(r2, "namesAndValues");
            return of((String[]) Arrays.copyOf(r2, r2.length));
        }

        @JvmStatic
        @JvmName
        @NotNull
        public final Headers of(@NotNull String... r6) {
            Intrinsics.f(r6, "namesAndValues");
            if ((r6.length % 2) != 0) goto L29;
            Object r7 = r6.clone();
            if (r7 == null) goto L27;
            String[] r8 = (String[]) r7;
            int r0 = r8.length;
            int r3 = 0;
        L7:
            if (r3 >= r0) goto L16;
            String r4 = r8[r3];
            if (r4 == null) goto L15;
            if (r4 == null) goto L13;
            r8[r3] = StringsKt.J(r4).toString();
            r3 = r3 + 1;
            goto L7
        L13:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        L15:
            throw new IllegalArgumentException("Headers cannot be null".toString());
        L16:
            IntProgression r1 = RangesKt.d(new IntRange(0, r8.length - 1, 1), 2);
            int r2 = r1.b;
            int r5 = r1.c;
            int r9 = r1.e;
            if (r9 < 0) goto L20;
            if (r2 <= r5) goto L21;
        L25:
            return new Headers(r8, null);
        L21:
            String r10 = r8[r2];
            String r11 = r8[r2 + 1];
            checkName(r10);
            checkValue(r11, r10);
            if (r2 == r5) goto L25;
            r2 = r2 + r9;
            goto L21
        L20:
            if (r2 < r5) goto L25;
        L27:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
        L29:
            throw new IllegalArgumentException("Expected alternating header names and values".toString());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @Deprecated
        @JvmName
        @NotNull
        /* JADX INFO: renamed from: -deprecated_of, reason: not valid java name */
        public final Headers m94deprecated_of(@NotNull Map<String, String> r2) {
            Intrinsics.f(r2, "headers");
            return of(r2);
        }

        @JvmStatic
        @JvmName
        @NotNull
        public final Headers of(@NotNull Map<String, String> r6) {
            Intrinsics.f(r6, "$this$toHeaders");
            String[] r0 = new String[r6.size() * 2];
            Iterator<Map.Entry<String, String>> r7 = r6.entrySet().iterator();
            int r1 = 0;
        L4:
            if (r7.hasNext() == false) goto L15;
            Map.Entry<String, String> r2 = r7.next();
            String r3 = r2.getKey();
            String r4 = r2.getValue();
            if (r3 == null) goto L13;
            String r5 = StringsKt.J(r3).toString();
            if (r4 == null) goto L11;
            String r8 = StringsKt.J(r4).toString();
            checkName(r5);
            checkValue(r8, r5);
            r0[r1] = r5;
            r0[r1 + 1] = r8;
            r1 = r1 + 2;
            goto L4
        L11:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        L13:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        L15:
            return new Headers(r0, null);
        }
    }

    static {
        Companion = new Companion(null);
    }

    private Headers(String[] r1) {
        this.namesAndValues = r1;
    }

    @JvmStatic
    @JvmName
    @NotNull
    public static final Headers of(@NotNull Map<String, String> r1) {
        return Companion.of(r1);
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_size, reason: not valid java name */
    public final int m93deprecated_size() {
        return size();
    }

    public final long byteCount() {
        String[] r0 = this.namesAndValues;
        long r1 = r0.length * 2;
        int r2 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        r1 = r1 + ((long) this.namesAndValues[r3].length());
        r3 = r3 + 1;
        goto L3
    L5:
        return r1;
    }

    public boolean equals(@Nullable Object r2) {
        if ((r2 instanceof Headers) == true) goto L5;
    L7:
        return false;
    L5:
        if (Arrays.equals(this.namesAndValues, ((Headers) r2).namesAndValues) == false) goto L7;
        return true;
    }

    @Nullable
    public final String get(@NotNull String r2) {
        Intrinsics.f(r2, "name");
        return Companion.access$get(Companion, this.namesAndValues, r2);
    }

    @Nullable
    public final Date getDate(@NotNull String r2) {
        Intrinsics.f(r2, "name");
        String r1 = get(r2);
        if (r1 != null) goto L7;
        return null;
    L7:
        return DatesKt.toHttpDateOrNull(r1);
    }

    @IgnoreJRERequirement
    @Nullable
    public final Instant getInstant(@NotNull String r2) {
        Intrinsics.f(r2, "name");
        Date r1 = getDate(r2);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.toInstant();
    }

    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<Pair<? extends String, ? extends String>> iterator() {
        int r0 = size();
        Pair[] r1 = new Pair[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L6;
        r1[r2] = new Pair(name(r2), value(r2));
        r2 = r2 + 1;
        goto L3
    L6:
        return ArrayIteratorKt.a(r1);
    }

    @NotNull
    public final String name(int r1) {
        return this.namesAndValues[r1 * 2];
    }

    @NotNull
    public final Set<String> names() {
        Comparator r1 = String.CASE_INSENSITIVE_ORDER;
        Intrinsics.e(r1, "CASE_INSENSITIVE_ORDER");
        TreeSet r0 = new TreeSet(r1);
        int r2 = size();
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L5;
        r0.add(name(r3));
        r3 = r3 + 1;
        goto L3
    L5:
        Set<String> r4 = Collections.unmodifiableSet(r0);
        Intrinsics.e(r4, "Collections.unmodifiableSet(result)");
        return r4;
    }

    @NotNull
    public final Builder newBuilder() {
        Builder r0 = new Builder();
        List<String> r1 = r0.getNamesAndValues$okhttp();
        String[] r3 = this.namesAndValues;
        Intrinsics.f(r1, "<this>");
        Intrinsics.f(r3, "elements");
        r1.addAll(ArraysKt.b(r3));
        return r0;
    }

    @JvmName
    public final int size() {
        return this.namesAndValues.length / 2;
    }

    @NotNull
    public final Map<String, List<String>> toMultimap() {
        Comparator r1 = String.CASE_INSENSITIVE_ORDER;
        Intrinsics.e(r1, "CASE_INSENSITIVE_ORDER");
        TreeMap r0 = new TreeMap(r1);
        int r2 = size();
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L12;
        String r4 = name(r3);
        Locale r5 = Locale.US;
        Intrinsics.e(r5, "Locale.US");
        if (r4 == null) goto L11;
        String r6 = r4.toLowerCase(r5);
        Intrinsics.e(r6, "(this as java.lang.String).toLowerCase(locale)");
        List r7 = (List) r0.get(r6);
        if (r7 != null) goto L9;
        r7 = new ArrayList(2);
        r0.put(r6, r7);
    L9:
        r7.add(value(r3));
        r3 = r3 + 1;
        goto L3
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L12:
        return r0;
    }

    @NotNull
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        int r1 = size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        String r3 = name(r2);
        String r4 = value(r2);
        r0.append(r3);
        r0.append(": ");
        if (Util.isSensitiveHeader(r3) == false) goto L7;
        r4 = "██";
    L7:
        r0.append(r4);
        r0.append("\n");
        r2 = r2 + 1;
        goto L3
    L8:
        String r6 = r0.toString();
        Intrinsics.e(r6, "StringBuilder().apply(builderAction).toString()");
        return r6;
    }

    @NotNull
    public final String value(int r1) {
        return this.namesAndValues[(r1 * 2) + 1];
    }

    @NotNull
    public final List<String> values(@NotNull String r5) {
        Intrinsics.f(r5, "name");
        int r0 = size();
        ArrayList r1 = null;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L10;
        if (r5.equalsIgnoreCase(name(r2)) == false) goto L9;
        if (r1 != null) goto L8;
        r1 = new ArrayList(2);
    L8:
        r1.add(value(r2));
    L9:
        r2 = r2 + 1;
        goto L3
    L10:
        if (r1 == null) goto L13;
        List<String> r4 = Collections.unmodifiableList(r1);
        Intrinsics.e(r4, "Collections.unmodifiableList(result)");
        return r4;
    L13:
        return EmptyList.b;
    }

    public /* synthetic */ Headers(String[] r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    @JvmStatic
    @JvmName
    @NotNull
    public static final Headers of(@NotNull String... r1) {
        return Companion.of(r1);
    }
}
