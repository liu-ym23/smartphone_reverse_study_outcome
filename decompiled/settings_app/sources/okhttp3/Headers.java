package okhttp3;

import android.icu.text.PluralRules;
import com.android.settings.fuelgauge.PowerUsageDetail;
import com.android.settings.search.IndexDatabaseHelper;
import com.android.settingslib.accessibility.AccessibilityUtils;
import com.bytedance.apm.constant.PerfConsts;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;

/* JADX INFO: compiled from: Headers.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0006\u0018\u0000 '2\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0002&'B\u0015\b\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0086\u0002J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0012\u001a\u00020\u0003J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0012\u001a\u00020\u0003H\u0007J\b\u0010\u0017\u001a\u00020\tH\u0016J\u001b\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0019H\u0096\u0002J\u000e\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\tJ\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u001cJ\u0006\u0010\u001d\u001a\u00020\u001eJ\r\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\u001fJ\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\"0!J\b\u0010#\u001a\u00020\u0003H\u0016J\u000e\u0010$\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\tJ\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030\"2\u0006\u0010\u0012\u001a\u00020\u0003R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8G¢\u0006\u0006\u001a\u0004\b\b\u0010\n¨\u0006("}, d2 = {"Lokhttp3/Headers;", "", "Lkotlin/Pair;", "", "namesAndValues", "", "([Ljava/lang/String;)V", "[Ljava/lang/String;", PerfConsts.PERF_DISK_FILE_SIZE, "", "()I", "byteCount", "", "equals", "", PluralRules.KEYWORD_OTHER, "", "get", "name", "getDate", "Ljava/util/Date;", "getInstant", "Ljava/time/Instant;", "hashCode", "iterator", "", "index", "names", "", "newBuilder", "Lokhttp3/Headers$Builder;", "-deprecated_size", "toMultimap", "", "", "toString", "value", PowerUsageDetail.EXTRA_DETAIL_VALUES, "Builder", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Headers implements Iterable<Pair<? extends String, ? extends String>>, KMappedMarker {
    public static final Companion Companion = null;
    private final String[] namesAndValues;

    /* JADX INFO: compiled from: Headers.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0016\u0010\b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\rJ\u0016\u0010\b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010J\u0015\u0010\u0011\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0012J\u001d\u0010\u0011\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0012J\u0016\u0010\u0013\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J\u0006\u0010\u0014\u001a\u00020\u0010J\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0086\u0002J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0005J\u0019\u0010\u0017\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0087\u0002J\u0019\u0010\u0017\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\rH\u0086\u0002J\u0019\u0010\u0017\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0086\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lokhttp3/Headers$Builder;", "", "()V", "namesAndValues", "", "", "getNamesAndValues$okhttp", "()Ljava/util/List;", "add", "line", "name", "value", "Ljava/time/Instant;", "Ljava/util/Date;", "addAll", "headers", "Lokhttp3/Headers;", "addLenient", "addLenient$okhttp", "addUnsafeNonAscii", IndexDatabaseHelper.MetaColumns.BUILD, "get", "removeAll", "set", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {
        private final List<String> namesAndValues;

        public Builder() {
            this.namesAndValues = new ArrayList(20);
        }

        public final List<String> getNamesAndValues$okhttp() {
            return this.namesAndValues;
        }

        public final Builder addLenient$okhttp(String r8) {
            Intrinsics.checkNotNullParameter(r8, "line");
            int r0 = StringsKt.indexOf$default(r8, AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR, 1, false, 4, null);
            if (r0 == (-1)) goto L6;
            String r1 = r8.substring(0, r0);
            Intrinsics.checkNotNullExpressionValue(r1, "this as java.lang.String…ing(startIndex, endIndex)");
            String r9 = r8.substring(r0 + 1);
            Intrinsics.checkNotNullExpressionValue(r9, "this as java.lang.String).substring(startIndex)");
            addLenient$okhttp(r1, r9);
        L9:
            return this;
        L6:
            if (r8.charAt(0) != ':') goto L8;
            String r10 = r8.substring(1);
            Intrinsics.checkNotNullExpressionValue(r10, "this as java.lang.String).substring(startIndex)");
            addLenient$okhttp("", r10);
            goto L9
        L8:
            addLenient$okhttp("", r8);
            goto L9
        }

        public final Builder add(String r8) {
            Intrinsics.checkNotNullParameter(r8, "line");
            int r0 = StringsKt.indexOf$default(r8, AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR, 0, false, 6, null);
            if (r0 == (-1)) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == false) goto L10;
            String r2 = r8.substring(0, r0);
            Intrinsics.checkNotNullExpressionValue(r2, "this as java.lang.String…ing(startIndex, endIndex)");
            String r3 = StringsKt.trim(r2).toString();
            String r9 = r8.substring(r0 + 1);
            Intrinsics.checkNotNullExpressionValue(r9, "this as java.lang.String).substring(startIndex)");
            add(r3, r9);
            return this;
        L10:
            throw new IllegalArgumentException(Intrinsics.stringPlus("Unexpected header: ", r8).toString());
        L5:
            r1 = false;
            goto L6
        }

        public final Builder add(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r3, "value");
            Companion.access$checkName(Headers.Companion, r2);
            Companion.access$checkValue(Headers.Companion, r3, r2);
            addLenient$okhttp(r2, r3);
            return this;
        }

        public final Builder addUnsafeNonAscii(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r3, "value");
            Companion.access$checkName(Headers.Companion, r2);
            addLenient$okhttp(r2, r3);
            return this;
        }

        public final Builder addAll(Headers r5) {
            Intrinsics.checkNotNullParameter(r5, "headers");
            int r0 = r5.size();
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L5;
            int r2 = r1 + 1;
            addLenient$okhttp(r5.name(r1), r5.value(r1));
            r1 = r2;
            goto L3
        L5:
            return this;
        }

        public final Builder add(String r2, Date r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r3, "value");
            add(r2, DatesKt.toHttpDateString(r3));
            return this;
        }

        public final Builder add(String r4, Instant r5) {
            Intrinsics.checkNotNullParameter(r4, "name");
            Intrinsics.checkNotNullParameter(r5, "value");
            add(r4, new Date(r5.toEpochMilli()));
            return this;
        }

        public final Builder set(String r2, Date r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r3, "value");
            set(r2, DatesKt.toHttpDateString(r3));
            return this;
        }

        public final Builder set(String r4, Instant r5) {
            Intrinsics.checkNotNullParameter(r4, "name");
            Intrinsics.checkNotNullParameter(r5, "value");
            return set(r4, new Date(r5.toEpochMilli()));
        }

        public final Builder addLenient$okhttp(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r3, "value");
            getNamesAndValues$okhttp().add(r2);
            getNamesAndValues$okhttp().add(StringsKt.trim(r3).toString());
            return this;
        }

        public final Builder removeAll(String r4) {
            Intrinsics.checkNotNullParameter(r4, "name");
            int r0 = 0;
        L4:
            if (r0 >= getNamesAndValues$okhttp().size()) goto L9;
            if (StringsKt.equals(r4, getNamesAndValues$okhttp().get(r0), true) == false) goto L8;
            getNamesAndValues$okhttp().remove(r0);
            getNamesAndValues$okhttp().remove(r0);
            r0 = r0 - 2;
        L8:
            r0 = r0 + 2;
            goto L4
        L9:
            return this;
        }

        public final Builder set(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            Intrinsics.checkNotNullParameter(r3, "value");
            Companion.access$checkName(Headers.Companion, r2);
            Companion.access$checkValue(Headers.Companion, r3, r2);
            removeAll(r2);
            addLenient$okhttp(r2, r3);
            return this;
        }

        public final String get(String r6) {
            Intrinsics.checkNotNullParameter(r6, "name");
            int r0 = this.namesAndValues.size() - 2;
            int r1 = ProgressionUtilKt.getProgressionLastElement(r0, 0, -2);
            if (r1 > r0) goto L11;
        L4:
            int r2 = r0 - 2;
            if (StringsKt.equals(r6, this.namesAndValues.get(r0), true) == true) goto L7;
            if (r0 == r1) goto L15;
            r0 = r2;
            goto L4
        L15:
            return null;
        L7:
            return this.namesAndValues.get(r0 + 1);
        L11:
            return null;
        }

        public final Headers build() {
            Object[] r2 = this.namesAndValues.toArray(new String[0]);
            if (r2 == null) goto L7;
            return new Headers((String[]) r2, null);
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
    }

    /* JADX INFO: compiled from: Headers.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J%\u0010\t\u001a\u0004\u0018\u00010\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¢\u0006\u0002\u0010\fJ#\u0010\r\u001a\u00020\u000e2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u000b\"\u00020\u0006H\u0007¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u000b\"\u00020\u0006H\u0007¢\u0006\u0004\b\u0011\u0010\u0010J!\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0013H\u0007¢\u0006\u0002\b\u0011J\u001d\u0010\u0014\u001a\u00020\u000e*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0013H\u0007¢\u0006\u0002\b\u000f¨\u0006\u0015"}, d2 = {"Lokhttp3/Headers$Companion;", "", "()V", "checkName", "", "name", "", "checkValue", "value", "get", "namesAndValues", "", "([Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "headersOf", "Lokhttp3/Headers;", "of", "([Ljava/lang/String;)Lokhttp3/Headers;", "-deprecated_of", "headers", "", "toHeaders", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

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

        private final String get(String[] r5, String r6) {
            int r4 = r5.length - 2;
            int r0 = ProgressionUtilKt.getProgressionLastElement(r4, 0, -2);
            if (r0 > r4) goto L11;
        L4:
            int r1 = r4 - 2;
            if (StringsKt.equals(r6, r5[r4], true) == true) goto L7;
            if (r4 == r0) goto L15;
            r4 = r1;
            goto L4
        L15:
            return null;
        L7:
            return r5[r4 + 1];
        L11:
            return null;
        }

        @JvmStatic
        public final Headers of(String... r9) {
            Intrinsics.checkNotNullParameter(r9, "namesAndValues");
            int r3 = 0;
            if ((r9.length % 2) != 0) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L26;
            String[] r10 = (String[]) r9.clone();
            int r1 = r10.length;
            int r4 = 0;
        L8:
            if (r4 >= r1) goto L17;
            int r5 = r4 + 1;
            String r6 = r10[r4];
            if (r6 == null) goto L12;
            boolean r7 = true;
        L13:
            if (r7 == false) goto L16;
            r10[r4] = StringsKt.trim(r6).toString();
            r4 = r5;
            goto L8
        L16:
            throw new IllegalArgumentException("Headers cannot be null".toString());
        L12:
            r7 = false;
            goto L13
        L17:
            int r2 = ProgressionUtilKt.getProgressionLastElement(0, r10.length - 1, 2);
            if (r2 < 0) goto L24;
        L19:
            int r8 = r3 + 2;
            String r11 = r10[r3];
            String r12 = r10[r3 + 1];
            checkName(r11);
            checkValue(r12, r11);
            if (r3 == r2) goto L24;
            r3 = r8;
        L24:
            return new Headers(r10, null);
        L26:
            throw new IllegalArgumentException("Expected alternating header names and values".toString());
        L5:
            r0 = false;
            goto L6
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "function name changed", replaceWith = @ReplaceWith(expression = "headersOf(*namesAndValues)", imports = {}))
        /* JADX INFO: renamed from: -deprecated_of, reason: not valid java name */
        public final Headers m3137deprecated_of(String... r2) {
            Intrinsics.checkNotNullParameter(r2, "namesAndValues");
            return of((String[]) Arrays.copyOf(r2, r2.length));
        }

        @JvmStatic
        public final Headers of(Map<String, String> r5) {
            Intrinsics.checkNotNullParameter(r5, "<this>");
            String[] r0 = new String[r5.size() * 2];
            Iterator<Map.Entry<String, String>> r6 = r5.entrySet().iterator();
            int r1 = 0;
        L4:
            if (r6.hasNext() == false) goto L7;
            Map.Entry<String, String> r2 = r6.next();
            String r3 = r2.getKey();
            String r4 = r2.getValue();
            String r7 = StringsKt.trim(r3).toString();
            String r8 = StringsKt.trim(r4).toString();
            checkName(r7);
            checkValue(r8, r7);
            r0[r1] = r7;
            r0[r1 + 1] = r8;
            r1 = r1 + 2;
            goto L4
        L7:
            return new Headers(r0, null);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "function moved to extension", replaceWith = @ReplaceWith(expression = "headers.toHeaders()", imports = {}))
        /* JADX INFO: renamed from: -deprecated_of, reason: not valid java name */
        public final Headers m3136deprecated_of(Map<String, String> r2) {
            Intrinsics.checkNotNullParameter(r2, "headers");
            return of(r2);
        }

        private final void checkName(String r7) {
            if (r7.length() <= 0) goto L5;
            boolean r6 = true;
        L6:
            if (r6 == false) goto L21;
            int r8 = r7.length();
            int r2 = 0;
        L8:
            if (r2 >= r8) goto L19;
            int r3 = r2 + 1;
            char r4 = r7.charAt(r2);
            if ('!' <= r4) goto L12;
        L14:
            boolean r5 = false;
        L15:
            if (r5 == false) goto L18;
            r2 = r3;
            goto L8
        L18:
            throw new IllegalArgumentException(Util.format("Unexpected char %#04x at %d in header name: %s", new Object[]{Integer.valueOf(r4), Integer.valueOf(r2), r7}).toString());
        L12:
            if (r4 >= 127) goto L14;
            r5 = true;
            goto L15
        L19:
            return;
        L21:
            throw new IllegalArgumentException("name is empty".toString());
        L5:
            r6 = false;
            goto L6
        }

        private final void checkValue(String r7, String r8) {
            int r6 = r7.length();
            int r1 = 0;
        L3:
            if (r1 >= r6) goto L24;
            int r2 = r1 + 1;
            char r3 = r7.charAt(r1);
            if (r3 != '\t') goto L7;
        L15:
            boolean r4 = true;
        L16:
            if (r4 == false) goto L17;
            r1 = r2;
            goto L3
        L17:
            String r9 = Util.format("Unexpected char %#04x at %d in %s value", new Object[]{Integer.valueOf(r3), Integer.valueOf(r1), r8});
            if (Util.isSensitiveHeader(r8) == false) goto L20;
            String r10 = "";
        L22:
            throw new IllegalArgumentException(Intrinsics.stringPlus(r9, r10).toString());
        L20:
            r10 = Intrinsics.stringPlus(": ", r7);
            goto L22
        L7:
            if (' ' <= r3) goto L9;
        L11:
            boolean r5 = false;
        L12:
            if (r5 == true) goto L15;
            r4 = false;
            goto L16
        L9:
            if (r3 >= 127) goto L11;
            r5 = true;
            goto L12
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ Headers(String[] r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    @JvmStatic
    public static final Headers of(Map<String, String> r1) {
        return Companion.of(r1);
    }

    @JvmStatic
    public static final Headers of(String... r1) {
        return Companion.of(r1);
    }

    private Headers(String[] r1) {
        this.namesAndValues = r1;
    }

    public final String get(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        return Companion.access$get(Companion, this.namesAndValues, r2);
    }

    public final Date getDate(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        String r1 = get(r2);
        if (r1 != null) goto L6;
        return null;
    L6:
        return DatesKt.toHttpDateOrNull(r1);
    }

    public final Instant getInstant(String r2) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Date r1 = getDate(r2);
        if (r1 != null) goto L6;
        return null;
    L6:
        return r1.toInstant();
    }

    public final int size() {
        return this.namesAndValues.length / 2;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = PerfConsts.PERF_DISK_FILE_SIZE, imports = {}))
    /* JADX INFO: renamed from: -deprecated_size, reason: not valid java name */
    public final int m3135deprecated_size() {
        return size();
    }

    public final String name(int r1) {
        return this.namesAndValues[r1 * 2];
    }

    public final String value(int r1) {
        return this.namesAndValues[(r1 * 2) + 1];
    }

    public final Set<String> names() {
        TreeSet r0 = new TreeSet(StringsKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
        int r1 = size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        int r3 = r2 + 1;
        r0.add(name(r2));
        r2 = r3;
        goto L3
    L5:
        Set<String> r4 = Collections.unmodifiableSet(r0);
        Intrinsics.checkNotNullExpressionValue(r4, "unmodifiableSet(result)");
        return r4;
    }

    public final List<String> values(String r7) {
        Intrinsics.checkNotNullParameter(r7, "name");
        int r0 = size();
        ArrayList r1 = null;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L10;
        int r3 = r2 + 1;
        if (StringsKt.equals(r7, name(r2), true) == false) goto L9;
        if (r1 != null) goto L8;
        r1 = new ArrayList(2);
    L8:
        r1.add(value(r2));
    L9:
        r2 = r3;
        goto L3
    L10:
        if (r1 == null) goto L13;
        List<String> r6 = Collections.unmodifiableList(r1);
        Intrinsics.checkNotNullExpressionValue(r6, "{\n      Collections.unmodifiableList(result)\n    }");
        return r6;
    L13:
        return CollectionsKt.emptyList();
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

    @Override // java.lang.Iterable
    public Iterator<Pair<? extends String, ? extends String>> iterator() {
        int r0 = size();
        Pair[] r1 = new Pair[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L6;
        r1[r2] = TuplesKt.to(name(r2), value(r2));
        r2 = r2 + 1;
        goto L3
    L6:
        return ArrayIteratorKt.iterator(r1);
    }

    public final Builder newBuilder() {
        Builder r0 = new Builder();
        CollectionsKt.addAll(r0.getNamesAndValues$okhttp(), this.namesAndValues);
        return r0;
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof Headers) == true) goto L5;
    L7:
        return false;
    L5:
        if (Arrays.equals(this.namesAndValues, ((Headers) r2).namesAndValues) == false) goto L7;
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(this.namesAndValues);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        int r1 = size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L8;
        int r3 = r2 + 1;
        String r4 = name(r2);
        String r5 = value(r2);
        r0.append(r4);
        r0.append(": ");
        if (Util.isSensitiveHeader(r4) == false) goto L7;
        r5 = "██";
    L7:
        r0.append(r5);
        r0.append("\n");
        r2 = r3;
        goto L3
    L8:
        String r6 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r6, "StringBuilder().apply(builderAction).toString()");
        return r6;
    }

    public final Map<String, List<String>> toMultimap() {
        TreeMap r0 = new TreeMap(StringsKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
        int r1 = size();
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        int r3 = r2 + 1;
        String r4 = name(r2);
        Locale r5 = Locale.US;
        Intrinsics.checkNotNullExpressionValue(r5, "US");
        String r6 = r4.toLowerCase(r5);
        Intrinsics.checkNotNullExpressionValue(r6, "this as java.lang.String).toLowerCase(locale)");
        ArrayList r7 = (List) r0.get(r6);
        if (r7 != null) goto L7;
        r7 = new ArrayList(2);
        r0.put(r6, r7);
    L7:
        r7.add(value(r2));
        r2 = r3;
        goto L3
    L9:
        return r0;
    }
}
