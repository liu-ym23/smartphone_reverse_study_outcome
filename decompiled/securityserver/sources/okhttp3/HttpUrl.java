package okhttp3;

import a.a;
import com.bytedance.apm.battery.config.BatteryDetectConfig;
import com.bytedance.frameworks.baselib.network.http.util.HttpHost;
import com.bytedance.librarian.LibrarianImpl;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.collections.EmptySet;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okio.Buffer;
import okio.Utf8;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class HttpUrl {
    public static final Companion Companion = null;

    @NotNull
    public static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";

    @NotNull
    public static final String FRAGMENT_ENCODE_SET = "";

    @NotNull
    public static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
    private static final char[] HEX_DIGITS = null;

    @NotNull
    public static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";

    @NotNull
    public static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";

    @NotNull
    public static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";

    @NotNull
    public static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";

    @NotNull
    public static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";

    @NotNull
    public static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";

    @NotNull
    public static final String QUERY_ENCODE_SET = " \"'<>#";

    @NotNull
    public static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";

    @Nullable
    private final String fragment;

    @NotNull
    private final String host;
    private final boolean isHttps;

    @NotNull
    private final String password;

    @NotNull
    private final List<String> pathSegments;
    private final int port;
    private final List<String> queryNamesAndValues;

    @NotNull
    private final String scheme;
    private final String url;

    @NotNull
    private final String username;

    @Metadata
    public static final class Builder {
        public static final Companion Companion = null;

        @NotNull
        public static final String INVALID_HOST = "Invalid URL host";

        @Nullable
        private String encodedFragment;

        @NotNull
        private String encodedPassword;

        @NotNull
        private final List<String> encodedPathSegments;

        @Nullable
        private List<String> encodedQueryNamesAndValues;

        @NotNull
        private String encodedUsername;

        @Nullable
        private String host;
        private int port;

        @Nullable
        private String scheme;

        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public static final /* synthetic */ int access$parsePort(Companion r0, String r1, int r2, int r3) {
                return r0.parsePort(r1, r2, r3);
            }

            public static final /* synthetic */ int access$portColonOffset(Companion r0, String r1, int r2, int r3) {
                return r0.portColonOffset(r1, r2, r3);
            }

            public static final /* synthetic */ int access$schemeDelimiterOffset(Companion r0, String r1, int r2, int r3) {
                return r0.schemeDelimiterOffset(r1, r2, r3);
            }

            public static final /* synthetic */ int access$slashCount(Companion r0, String r1, int r2, int r3) {
                return r0.slashCount(r1, r2, r3);
            }

            private final int parsePort(String r13, int r14, int r15) {
                int r16 = Integer.parseInt(Companion.canonicalize$okhttp$default(HttpUrl.Companion, r13, r14, r15, "", false, false, false, false, null, 248, null));     // Catch: NumberFormatException -> L11
                if (1 <= r16) goto L8;
                return -1;
            L8:
                if (65535 >= r16) goto L10;
                return -1;
            L10:
                return r16;
            L16:
                return -1;
            }

            private final int portColonOffset(String r2, int r3, int r4) {
            L2:
                if (r3 >= r4) goto L14;
                char r1 = r2.charAt(r3);
                if (r1 == ':') goto L13;
                if (r1 != '[') goto L12;
            L8:
                r3 = r3 + 1;
                if (r3 >= r4) goto L12;
                if (r2.charAt(r3) != ']') goto L8;
            L12:
                r3 = r3 + 1;
                goto L2
            L13:
                return r3;
            L14:
                return r4;
            }

            private final int schemeDelimiterOffset(String r7, int r8, int r9) {
                if ((r9 - r8) >= 2) goto L5;
                return -1;
            L5:
                char r6 = r7.charAt(r8);
                if (Intrinsics.h(r6, 97) < 0) goto L10;
                if (Intrinsics.h(r6, 122) > 0) goto L10;
            L14:
                r8 = r8 + 1;
                if (r8 >= r9) goto L65;
                char r10 = r7.charAt(r8);
                if ('a' > r10) goto L21;
                if ('z' >= r10) goto L14;
            L21:
                if ('A' > r10) goto L26;
                if ('Z' >= r10) goto L14;
            L26:
                if ('0' > r10) goto L32;
                if ('9' >= r10) goto L14;
            L32:
                if (r10 == '+') goto L14;
                if (r10 == '-') goto L14;
                if (r10 == '.') goto L14;
                if (r10 == ':') goto L43;
                return -1;
            L43:
                return r8;
            L65:
                return -1;
            L10:
                if (Intrinsics.h(r6, 65) >= 0) goto L12;
                return -1;
            L12:
                if (Intrinsics.h(r6, 90) <= 0) goto L14;
                return -1;
            }

            private final int slashCount(String r3, int r4, int r5) {
                int r2 = 0;
            L3:
                if (r4 >= r5) goto L9;
                char r0 = r3.charAt(r4);
                if (r0 == '\\') goto L8;
                if (r0 != '/') goto L9;
            L8:
                r2 = r2 + 1;
                r4 = r4 + 1;
            L9:
                return r2;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        public Builder() {
            this.encodedUsername = "";
            this.encodedPassword = "";
            this.port = -1;
            ArrayList r1 = new ArrayList();
            this.encodedPathSegments = r1;
            r1.add("");
        }

        private final int effectivePort() {
            int r0 = this.port;
            if (r0 != (-1)) goto L7;
            Companion r1 = HttpUrl.Companion;
            String r2 = this.scheme;
            Intrinsics.c(r2);
            return r1.defaultPort(r2);
        L7:
            return r0;
        }

        private final boolean isDot(String r2) {
            if (Intrinsics.a(r2, LibrarianImpl.Constants.DOT) == false) goto L5;
            return true;
        L5:
            if (StringsKt.p(r2, "%2e", true) == true) goto L10;
            return false;
        L10:
            return true;
        }

        private final boolean isDotDot(String r2) {
            if (Intrinsics.a(r2, "..") == false) goto L5;
            return true;
        L5:
            if (StringsKt.p(r2, "%2e.", true) == false) goto L7;
            return true;
        L7:
            if (StringsKt.p(r2, ".%2e", true) == false) goto L9;
            return true;
        L9:
            if (StringsKt.p(r2, "%2e%2e", true) == true) goto L16;
            return false;
        L16:
            return true;
        }

        private final void pop() {
            List<String> r0 = this.encodedPathSegments;
            if (r0.remove(r0.size() - 1).length() == 0) goto L5;
        L7:
            this.encodedPathSegments.add("");
            return;
        L5:
            if ((!this.encodedPathSegments.isEmpty()) == false) goto L7;
            List<String> r2 = this.encodedPathSegments;
            r2.set(r2.size() - 1, "");
        }

        private final void push(String r14, int r15, int r16, boolean r17, boolean r18) {
            String r1 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r14, r15, r16, HttpUrl.PATH_SEGMENT_ENCODE_SET, r18, false, false, false, null, BatteryDetectConfig.MAX_TOTAL_LOC_REQUEST_TIME_10_MINS_SECOND, null);
            if (isDot(r1) == false) goto L6;
            return;
        L6:
            if (isDotDot(r1) == false) goto L9;
            pop();
            return;
        L9:
            List<String> r2 = this.encodedPathSegments;
            if (r2.get(r2.size() - 1).length() != 0) goto L12;
            List<String> r3 = this.encodedPathSegments;
            r3.set(r3.size() - 1, r1);
        L13:
            if (r17 == false) goto L16;
            this.encodedPathSegments.add("");
            return;
        L16:
            return;
        L12:
            this.encodedPathSegments.add(r1);
            goto L13
        }

        private final void removeAllCanonicalQueryParameters(String r6) {
            List<String> r0 = this.encodedQueryNamesAndValues;
            Intrinsics.c(r0);
            IntProgression r1 = RangesKt.d(new IntProgression(r0.size() - 2, 0, -1), 2);
            int r2 = r1.b;
            int r3 = r1.c;
            int r4 = r1.e;
            if (r4 < 0) goto L6;
            if (r2 <= r3) goto L7;
            return;
        L7:
            List<String> r5 = this.encodedQueryNamesAndValues;
            Intrinsics.c(r5);
            if (Intrinsics.a(r6, r5.get(r2)) == false) goto L13;
            List<String> r7 = this.encodedQueryNamesAndValues;
            Intrinsics.c(r7);
            r7.remove(r2 + 1);
            List<String> r8 = this.encodedQueryNamesAndValues;
            Intrinsics.c(r8);
            r8.remove(r2);
            List<String> r9 = this.encodedQueryNamesAndValues;
            Intrinsics.c(r9);
            if (r9.isEmpty() == false) goto L13;
            this.encodedQueryNamesAndValues = null;
            return;
        L13:
            if (r2 == r3) goto L20;
            r2 = r2 + r4;
            goto L7
        L20:
            return;
        L6:
            if (r2 >= r3) goto L7;
        }

        private final void resolvePath(String r11, int r12, int r13) {
            if (r12 != r13) goto L4;
            return;
        L4:
            char r0 = r11.charAt(r12);
            if (r0 != '/') goto L7;
        L10:
            this.encodedPathSegments.clear();
            this.encodedPathSegments.add("");
            r12 = r12 + 1;
        L11:
            int r6 = r12;
            if (r6 >= r13) goto L20;
            r12 = Util.delimiterOffset(r11, "/\\", r6, r13);
            if (r12 >= r13) goto L16;
            boolean r1 = true;
        L17:
            push(r11, r6, r12, r1, true);
            if (r1 == false) goto L11;
            r12 = r12 + 1;
            goto L11
        L16:
            r1 = false;
            goto L17
        L20:
            return;
        L7:
            if (r0 == '\\') goto L10;
            List<String> r2 = this.encodedPathSegments;
            r2.set(r2.size() - 1, "");
            goto L11
        }

        @NotNull
        public final Builder addEncodedPathSegment(@NotNull String r8) {
            Intrinsics.f(r8, "encodedPathSegment");
            push(r8, 0, r8.length(), false, true);
            return this;
        }

        @NotNull
        public final Builder addEncodedPathSegments(@NotNull String r2) {
            Intrinsics.f(r2, "encodedPathSegments");
            return addPathSegments(r2, true);
        }

        @NotNull
        public final Builder addEncodedQueryParameter(@NotNull String r16, @Nullable String r17) {
            Intrinsics.f(r16, "encodedName");
            if (this.encodedQueryNamesAndValues != null) goto L5;
            this.encodedQueryNamesAndValues = new ArrayList();
        L5:
            List<String> r1 = this.encodedQueryNamesAndValues;
            Intrinsics.c(r1);
            Companion r14 = HttpUrl.Companion;
            r1.add(Companion.canonicalize$okhttp$default(r14, r16, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null));
            List<String> r2 = this.encodedQueryNamesAndValues;
            Intrinsics.c(r2);
            if (r17 == null) goto L8;
            String r3 = Companion.canonicalize$okhttp$default(r14, r17, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null);
        L9:
            r2.add(r3);
            return this;
        L8:
            r3 = null;
            goto L9
        }

        @NotNull
        public final Builder addPathSegment(@NotNull String r8) {
            Intrinsics.f(r8, "pathSegment");
            push(r8, 0, r8.length(), false, false);
            return this;
        }

        @NotNull
        public final Builder addPathSegments(@NotNull String r2) {
            Intrinsics.f(r2, "pathSegments");
            return addPathSegments(r2, false);
        }

        @NotNull
        public final Builder addQueryParameter(@NotNull String r16, @Nullable String r17) {
            Intrinsics.f(r16, "name");
            if (this.encodedQueryNamesAndValues != null) goto L5;
            this.encodedQueryNamesAndValues = new ArrayList();
        L5:
            List<String> r1 = this.encodedQueryNamesAndValues;
            Intrinsics.c(r1);
            Companion r14 = HttpUrl.Companion;
            r1.add(Companion.canonicalize$okhttp$default(r14, r16, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null));
            List<String> r2 = this.encodedQueryNamesAndValues;
            Intrinsics.c(r2);
            if (r17 == null) goto L8;
            String r3 = Companion.canonicalize$okhttp$default(r14, r17, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null);
        L9:
            r2.add(r3);
            return this;
        L8:
            r3 = null;
            goto L9
        }

        @NotNull
        public final HttpUrl build() {
            String r1 = this.scheme;
            if (r1 == null) goto L30;
            Companion r9 = HttpUrl.Companion;
            String r10 = Companion.percentDecode$okhttp$default(r9, this.encodedUsername, 0, 0, false, 7, null);
            String r3 = Companion.percentDecode$okhttp$default(r9, this.encodedPassword, 0, 0, false, 7, null);
            String r4 = this.host;
            if (r4 == null) goto L28;
            int r5 = effectivePort();
            List<String> r2 = this.encodedPathSegments;
            ArrayList r6 = new ArrayList(CollectionsKt.e(r2, 10));
            Iterator<T> r7 = r2.iterator();
        L8:
            if (r7.hasNext() == false) goto L10;
            r6.add(Companion.percentDecode$okhttp$default(HttpUrl.Companion, (String) r7.next(), 0, 0, false, 7, null));
            goto L8
        L10:
            List<String> r8 = this.encodedQueryNamesAndValues;
            String r11 = null;
            if (r8 == null) goto L21;
            ArrayList r12 = new ArrayList(CollectionsKt.e(r8, 10));
            Iterator<T> r13 = r8.iterator();
        L14:
            if (r13.hasNext() == false) goto L20;
            String r14 = (String) r13.next();
            if (r14 == null) goto L18;
            String r15 = Companion.percentDecode$okhttp$default(HttpUrl.Companion, r14, 0, 0, true, 3, null);
        L19:
            r12.add(r15);
            goto L14
        L18:
            r15 = null;
            goto L19
        L20:
            ArrayList r16 = r12;
        L22:
            String r17 = this.encodedFragment;
            if (r17 == null) goto L26;
            r11 = Companion.percentDecode$okhttp$default(HttpUrl.Companion, r17, 0, 0, false, 7, null);
        L26:
            return new HttpUrl(r1, r10, r3, r4, r5, r6, r16, r11, toString());
        L21:
            r16 = null;
            goto L22
        L28:
            throw new IllegalStateException("host == null");
        L30:
            throw new IllegalStateException("scheme == null");
        }

        @NotNull
        public final Builder encodedFragment(@Nullable String r13) {
            if (r13 == null) goto L4;
            String r14 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r13, 0, 0, "", true, false, false, true, null, 179, null);
        L5:
            this.encodedFragment = r14;
            return this;
        L4:
            r14 = null;
            goto L5
        }

        @NotNull
        public final Builder encodedPassword(@NotNull String r14) {
            Intrinsics.f(r14, "encodedPassword");
            this.encodedPassword = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r14, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 243, null);
            return this;
        }

        @NotNull
        public final Builder encodedPath(@NotNull String r3) {
            Intrinsics.f(r3, "encodedPath");
            if (StringsKt.F(r3, LibrarianImpl.Constants.SEPARATOR, false) == false) goto L7;
            resolvePath(r3, 0, r3.length());
            return this;
        L7:
            throw new IllegalArgumentException("unexpected encodedPath: ".concat(r3).toString());
        }

        @NotNull
        public final Builder encodedQuery(@Nullable String r14) {
            if (r14 == null) goto L6;
            Companion r12 = HttpUrl.Companion;
            String r15 = Companion.canonicalize$okhttp$default(r12, r14, 0, 0, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, null, 211, null);
            if (r15 == null) goto L6;
            List<String> r16 = r12.toQueryNamesAndValues$okhttp(r15);
        L7:
            this.encodedQueryNamesAndValues = r16;
            return this;
        L6:
            r16 = null;
            goto L7
        }

        @NotNull
        public final Builder encodedUsername(@NotNull String r14) {
            Intrinsics.f(r14, "encodedUsername");
            this.encodedUsername = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r14, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 243, null);
            return this;
        }

        @NotNull
        public final Builder fragment(@Nullable String r13) {
            if (r13 == null) goto L4;
            String r14 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r13, 0, 0, "", false, false, false, true, null, 187, null);
        L5:
            this.encodedFragment = r14;
            return this;
        L4:
            r14 = null;
            goto L5
        }

        @Nullable
        public final String getEncodedFragment$okhttp() {
            return this.encodedFragment;
        }

        @NotNull
        public final String getEncodedPassword$okhttp() {
            return this.encodedPassword;
        }

        @NotNull
        public final List<String> getEncodedPathSegments$okhttp() {
            return this.encodedPathSegments;
        }

        @Nullable
        public final List<String> getEncodedQueryNamesAndValues$okhttp() {
            return this.encodedQueryNamesAndValues;
        }

        @NotNull
        public final String getEncodedUsername$okhttp() {
            return this.encodedUsername;
        }

        @Nullable
        public final String getHost$okhttp() {
            return this.host;
        }

        public final int getPort$okhttp() {
            return this.port;
        }

        @Nullable
        public final String getScheme$okhttp() {
            return this.scheme;
        }

        @NotNull
        public final Builder host(@NotNull String r9) {
            Intrinsics.f(r9, "host");
            String r0 = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, r9, 0, 0, false, 7, null));
            if (r0 == null) goto L7;
            this.host = r0;
            return this;
        L7:
            throw new IllegalArgumentException("unexpected host: ".concat(r9));
        }

        @NotNull
        public final Builder parse$okhttp(@Nullable HttpUrl r32, @NotNull String r33) {
            Intrinsics.f(r33, "input");
            int r1 = Util.indexOfFirstNonAsciiWhitespace$default(r33, 0, 0, 3, null);
            int r15 = Util.indexOfLastNonAsciiWhitespace$default(r33, r1, 0, 2, null);
            Companion r2 = Companion;
            int r4 = Companion.access$schemeDelimiterOffset(r2, r33, r1, r15);
            String r12 = "(this as java.lang.Strin…ing(startIndex, endIndex)";
            boolean r11 = true;
            byte r10 = -1;
            if (r4 != (-1)) goto L5;
            if (r32 == null) goto L84;
            this.scheme = r32.scheme();
        L14:
            int r3 = Companion.access$slashCount(r2, r33, r1, r15);
            byte r9 = Utf8.REPLACEMENT_BYTE;
            byte r8 = 35;
            if (r3 >= 2) goto L26;
            if (r32 == null) goto L26;
            if ((!Intrinsics.a(r32.scheme(), this.scheme)) == true) goto L26;
            this.encodedUsername = r32.encodedUsername();
            this.encodedPassword = r32.encodedPassword();
            this.host = r32.host();
            this.port = r32.port();
            this.encodedPathSegments.clear();
            this.encodedPathSegments.addAll(r32.encodedPathSegments());
            if (r1 != r15) goto L23;
        L24:
            encodedQuery(r32.encodedQuery());
        L25:
            int r19 = r15;
        L71:
            int r14 = r19;
            int r5 = Util.delimiterOffset(r33, "?#", r1, r14);
            resolvePath(r33, r1, r5);
            if (r5 < r14) goto L74;
        L76:
            if (r5 < r14) goto L78;
        L80:
            return this;
        L78:
            if (r33.charAt(r5) != '#') goto L80;
            this.encodedFragment = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r33, r5 + 1, r14, "", true, false, false, true, null, 176, null);
            goto L80
        L74:
            if (r33.charAt(r5) != '?') goto L76;
            int r16 = Util.delimiterOffset(r33, '#', r5, r14);
            Companion r13 = HttpUrl.Companion;
            this.encodedQueryNamesAndValues = r13.toQueryNamesAndValues$okhttp(Companion.canonicalize$okhttp$default(r13, r33, r5 + 1, r16, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, null, 208, null));
            r5 = r16;
            goto L76
        L23:
            if (r33.charAt(r1) != '#') goto L25;
        L26:
            int r7 = r1 + r3;
            boolean r17 = false;
            boolean r18 = false;
        L27:
            int r6 = Util.delimiterOffset(r33, "@/\\?#", r7, r15);
            if (r6 == r15) goto L30;
            byte r20 = r33.charAt(r6);
        L31:
            if (r20 == r10) goto L54;
            if (r20 == r8) goto L54;
            if (r20 == 47) goto L54;
            if (r20 == 92) goto L54;
            if (r20 == r9) goto L54;
            if (r20 == 64) goto L42;
            boolean r21 = r11;
            r15 = r15;
            r12 = r12;
        L53:
            r12 = r12;
            r15 = r15;
            r11 = r21;
            r8 = 35;
            r9 = Utf8.REPLACEMENT_BYTE;
            r10 = -1;
            goto L27
        L42:
            if (r17 == true) goto L51;
            int r22 = Util.delimiterOffset(r33, ':', r7, r6);
            Companion r110 = HttpUrl.Companion;
            r21 = r11;
            String r23 = Companion.canonicalize$okhttp$default(r110, r33, r7, r22, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, BatteryDetectConfig.MAX_TOTAL_LOC_REQUEST_TIME_10_MINS_SECOND, null);
            if (r18 == false) goto L46;
            r23 = this.encodedUsername + "%40" + r23;
        L46:
            this.encodedUsername = r23;
            int r111 = r6;
            if (r22 == r111) goto L49;
            this.encodedPassword = Companion.canonicalize$okhttp$default(r110, r33, r22 + 1, r111, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, BatteryDetectConfig.MAX_TOTAL_LOC_REQUEST_TIME_10_MINS_SECOND, null);
            boolean r112 = r21;
        L50:
            r17 = r112;
            boolean r113 = r21;
        L52:
            r7 = r111 + 1;
            r18 = r113;
            goto L53
        L49:
            r112 = r17;
            goto L50
        L51:
            r21 = r11;
            StringBuilder r114 = new StringBuilder();
            r114.append(this.encodedPassword);
            r114.append("%40");
            r111 = r6;
            r114.append(Companion.canonicalize$okhttp$default(HttpUrl.Companion, r33, r7, r6, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, BatteryDetectConfig.MAX_TOTAL_LOC_REQUEST_TIME_10_MINS_SECOND, null));
            this.encodedPassword = r114.toString();
            r113 = r18;
        L54:
            boolean r24 = r11;
            r19 = r15;
            String r115 = r12;
            Companion r25 = Companion;
            int r26 = Companion.access$portColonOffset(r25, r33, r7, r6);
            int r116 = r26 + 1;
            if (r116 >= r6) goto L64;
            int r34 = r7;
            this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, r33, r7, r26, false, 4, null));
            int r27 = Companion.access$parsePort(r25, r33, r116, r6);
            this.port = r27;
            if (r27 == (-1)) goto L59;
            boolean r28 = r24;
        L60:
            if (r28 == true) goto L66;
            StringBuilder r0 = new StringBuilder("Invalid URL port: \"");
            String r29 = r33.substring(r116, r6);
            Intrinsics.e(r29, r115);
            r0.append(r29);
            r0.append('\"');
            throw new IllegalArgumentException(r0.toString().toString());
        L66:
            if (this.host == null) goto L68;
            boolean r210 = r24;
        L69:
            if (r210 == false) goto L81;
            r1 = r6;
            goto L71
        L81:
            StringBuilder r30 = new StringBuilder("Invalid URL host: \"");
            String r31 = r33.substring(r34, r26);
            Intrinsics.e(r31, r115);
            r30.append(r31);
            r30.append('\"');
            throw new IllegalArgumentException(r30.toString().toString());
        L68:
            r210 = false;
            goto L69
        L59:
            r28 = false;
            goto L60
        L64:
            r34 = r7;
            Companion r35 = HttpUrl.Companion;
            this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(r35, r33, r34, r26, false, 4, null));
            String r36 = this.scheme;
            Intrinsics.c(r36);
            this.port = r35.defaultPort(r36);
            goto L66
        L30:
            r20 = r10;
            goto L31
        L84:
            throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
        L5:
            if (StringsKt.E(r33, r1, "https:", true) == false) goto L8;
            this.scheme = "https";
            r1 = r1 + 6;
            goto L14
        L8:
            if (StringsKt.E(r33, r1, "http:", true) == false) goto L10;
            this.scheme = HttpHost.DEFAULT_SCHEME_NAME;
            r1 = r1 + 5;
            goto L14
        L10:
            StringBuilder r37 = new StringBuilder("Expected URL scheme 'http' or 'https' but was '");
            String r38 = r33.substring(0, r4);
            Intrinsics.e(r38, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            r37.append(r38);
            r37.append("'");
            throw new IllegalArgumentException(r37.toString());
        }

        @NotNull
        public final Builder password(@NotNull String r14) {
            Intrinsics.f(r14, "password");
            this.encodedPassword = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r14, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }

        @NotNull
        public final Builder port(int r3) {
            boolean r0 = true;
            if (1 <= r3) goto L6;
        L8:
            r0 = false;
        L9:
            if (r0 == false) goto L13;
            this.port = r3;
            return this;
        L13:
            throw new IllegalArgumentException(a.e(r3, "unexpected port: ").toString());
        L6:
            if (65535 < r3) goto L8;
            goto L8
        }

        @NotNull
        public final Builder query(@Nullable String r14) {
            if (r14 == null) goto L6;
            Companion r12 = HttpUrl.Companion;
            String r15 = Companion.canonicalize$okhttp$default(r12, r14, 0, 0, HttpUrl.QUERY_ENCODE_SET, false, false, true, false, null, 219, null);
            if (r15 == null) goto L6;
            List<String> r16 = r12.toQueryNamesAndValues$okhttp(r15);
        L7:
            this.encodedQueryNamesAndValues = r16;
            return this;
        L6:
            r16 = null;
            goto L7
        }

        @NotNull
        public final Builder reencodeForUri$okhttp() {
            String r1 = this.host;
            String r2 = null;
            if (r1 == null) goto L5;
            String r3 = new Regex("[\"<>^`{|}]").b.matcher(r1).replaceAll("");
            Intrinsics.e(r3, "nativePattern.matcher(in…).replaceAll(replacement)");
        L6:
            this.host = r3;
            int r4 = this.encodedPathSegments.size();
            int r5 = 0;
            int r6 = 0;
        L7:
            if (r6 >= r4) goto L9;
            List<String> r7 = this.encodedPathSegments;
            r7.set(r6, Companion.canonicalize$okhttp$default(HttpUrl.Companion, r7.get(r6), 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, false, null, 227, null));
            r6 = r6 + 1;
            goto L7
        L9:
            List<String> r8 = this.encodedQueryNamesAndValues;
            if (r8 == null) goto L18;
            int r9 = r8.size();
        L12:
            if (r5 >= r9) goto L18;
            String r10 = r8.get(r5);
            if (r10 == null) goto L16;
            String r11 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r10, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, false, null, 195, null);
        L17:
            r8.set(r5, r11);
            r5 = r5 + 1;
            goto L12
        L16:
            r11 = null;
        L18:
            String r12 = this.encodedFragment;
            if (r12 == null) goto L21;
            r2 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r12, 0, 0, HttpUrl.FRAGMENT_ENCODE_SET_URI, true, true, false, true, null, 163, null);
        L21:
            this.encodedFragment = r2;
            return this;
        L5:
            r3 = null;
            goto L6
        }

        @NotNull
        public final Builder removeAllEncodedQueryParameters(@NotNull String r14) {
            Intrinsics.f(r14, "encodedName");
            if (this.encodedQueryNamesAndValues != null) goto L5;
            return this;
        L5:
            removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, r14, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null));
            return this;
        }

        @NotNull
        public final Builder removeAllQueryParameters(@NotNull String r14) {
            Intrinsics.f(r14, "name");
            if (this.encodedQueryNamesAndValues != null) goto L5;
            return this;
        L5:
            removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, r14, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null));
            return this;
        }

        @NotNull
        public final Builder removePathSegment(int r2) {
            this.encodedPathSegments.remove(r2);
            if (this.encodedPathSegments.isEmpty() == false) goto L5;
            this.encodedPathSegments.add("");
        L5:
            return this;
        }

        @NotNull
        public final Builder scheme(@NotNull String r3) {
            Intrinsics.f(r3, "scheme");
            if (r3.equalsIgnoreCase(HttpHost.DEFAULT_SCHEME_NAME) == false) goto L6;
            this.scheme = HttpHost.DEFAULT_SCHEME_NAME;
        L8:
            return this;
        L6:
            if (r3.equalsIgnoreCase("https") == false) goto L10;
            this.scheme = "https";
            goto L8
        L10:
            throw new IllegalArgumentException("unexpected scheme: ".concat(r3));
        }

        public final void setEncodedFragment$okhttp(@Nullable String r1) {
            this.encodedFragment = r1;
        }

        public final void setEncodedPassword$okhttp(@NotNull String r2) {
            Intrinsics.f(r2, "<set-?>");
            this.encodedPassword = r2;
        }

        @NotNull
        public final Builder setEncodedPathSegment(int r14, @NotNull String r15) {
            Intrinsics.f(r15, "encodedPathSegment");
            String r0 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r15, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, true, false, false, false, null, 243, null);
            this.encodedPathSegments.set(r14, r0);
            if (isDot(r0) == false) goto L5;
        L7:
            boolean r16 = false;
        L8:
            if (r16 == false) goto L11;
            return this;
        L11:
            throw new IllegalArgumentException("unexpected path segment: ".concat(r15).toString());
        L5:
            if (isDotDot(r0) == true) goto L7;
            r16 = true;
            goto L8
        }

        public final void setEncodedQueryNamesAndValues$okhttp(@Nullable List<String> r1) {
            this.encodedQueryNamesAndValues = r1;
        }

        @NotNull
        public final Builder setEncodedQueryParameter(@NotNull String r2, @Nullable String r3) {
            Intrinsics.f(r2, "encodedName");
            removeAllEncodedQueryParameters(r2);
            addEncodedQueryParameter(r2, r3);
            return this;
        }

        public final void setEncodedUsername$okhttp(@NotNull String r2) {
            Intrinsics.f(r2, "<set-?>");
            this.encodedUsername = r2;
        }

        public final void setHost$okhttp(@Nullable String r1) {
            this.host = r1;
        }

        @NotNull
        public final Builder setPathSegment(int r14, @NotNull String r15) {
            Intrinsics.f(r15, "pathSegment");
            String r0 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r15, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, false, false, false, false, null, 251, null);
            if (isDot(r0) == false) goto L5;
        L7:
            boolean r1 = false;
        L8:
            if (r1 == false) goto L12;
            this.encodedPathSegments.set(r14, r0);
            return this;
        L12:
            throw new IllegalArgumentException("unexpected path segment: ".concat(r15).toString());
        L5:
            if (isDotDot(r0) == true) goto L7;
            r1 = true;
            goto L8
        }

        public final void setPort$okhttp(int r1) {
            this.port = r1;
        }

        @NotNull
        public final Builder setQueryParameter(@NotNull String r2, @Nullable String r3) {
            Intrinsics.f(r2, "name");
            removeAllQueryParameters(r2);
            addQueryParameter(r2, r3);
            return this;
        }

        public final void setScheme$okhttp(@Nullable String r1) {
            this.scheme = r1;
        }

        @NotNull
        public String toString() {
            StringBuilder r0 = new StringBuilder();
            String r1 = this.scheme;
            if (r1 == null) goto L5;
            r0.append(r1);
            r0.append("://");
        L7:
            if (this.encodedUsername.length() <= 0) goto L10;
        L11:
            r0.append(this.encodedUsername);
            if (this.encodedPassword.length() <= 0) goto L14;
            r0.append(':');
            r0.append(this.encodedPassword);
        L14:
            r0.append('@');
        L15:
            String r2 = this.host;
            if (r2 == null) goto L22;
            if (StringsKt.n(r2, ':') == false) goto L20;
            r0.append('[');
            r0.append(this.host);
            r0.append(']');
            goto L22
        L20:
            r0.append(this.host);
        L22:
            if (this.port == (-1)) goto L24;
        L25:
            int r3 = effectivePort();
            String r4 = this.scheme;
            if (r4 != null) goto L28;
        L29:
            r0.append(':');
            r0.append(r3);
        L30:
            Companion r5 = HttpUrl.Companion;
            r5.toPathString$okhttp(this.encodedPathSegments, r0);
            if (this.encodedQueryNamesAndValues == null) goto L34;
            r0.append('?');
            List<String> r6 = this.encodedQueryNamesAndValues;
            Intrinsics.c(r6);
            r5.toQueryString$okhttp(r6, r0);
        L34:
            if (this.encodedFragment == null) goto L36;
            r0.append('#');
            r0.append(this.encodedFragment);
        L36:
            String r7 = r0.toString();
            Intrinsics.e(r7, "StringBuilder().apply(builderAction).toString()");
            return r7;
        L28:
            if (r3 == HttpUrl.Companion.defaultPort(r4)) goto L30;
        L24:
            if (this.scheme == null) goto L30;
        L10:
            if (this.encodedPassword.length() <= 0) goto L15;
        L5:
            r0.append("//");
            goto L7
        }

        @NotNull
        public final Builder username(@NotNull String r14) {
            Intrinsics.f(r14, "username");
            this.encodedUsername = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r14, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }

        private final Builder addPathSegments(String r9, boolean r10) {
            int r3 = 0;
        L3:
            int r7 = Util.delimiterOffset(r9, "/\\", r3, r9.length());
            if (r7 >= r9.length()) goto L6;
            boolean r5 = true;
        L7:
            push(r9, r3, r7, r5, r10);
            r3 = r7 + 1;
            if (r3 <= r9.length()) goto L3;
            return this;
        L6:
            r5 = false;
            goto L7
        }
    }

    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ String canonicalize$okhttp$default(Companion r13, String r14, int r15, int r16, String r17, boolean r18, boolean r19, boolean r20, boolean r21, Charset r22, int r23, Object r24) {
            if ((r23 & 1) == 0) goto L5;
            int r5 = 0;
        L7:
            if ((r23 & 2) == 0) goto L9;
            int r6 = r14.length();
        L11:
            if ((r23 & 8) == 0) goto L13;
            boolean r8 = false;
        L15:
            if ((r23 & 16) == 0) goto L17;
            boolean r9 = false;
        L19:
            if ((r23 & 32) == 0) goto L21;
            boolean r10 = false;
        L23:
            if ((r23 & 64) == 0) goto L25;
            boolean r11 = false;
        L27:
            if ((r23 & 128) == 0) goto L29;
            Charset r12 = null;
        L31:
            return r13.canonicalize$okhttp(r14, r5, r6, r17, r8, r9, r10, r11, r12);
        L29:
            r12 = r22;
            goto L31
        L25:
            r11 = r21;
            goto L27
        L21:
            r10 = r20;
            goto L23
        L17:
            r9 = r19;
            goto L19
        L13:
            r8 = r18;
            goto L15
        L9:
            r6 = r16;
            goto L11
        L5:
            r5 = r15;
            goto L7
        }

        private final boolean isPercentEncoded(String r2, int r3, int r4) {
            int r1 = r3 + 2;
            if (r1 < r4) goto L5;
        L11:
            return false;
        L5:
            if (r2.charAt(r3) != '%') goto L11;
            if (Util.parseHexDigit(r2.charAt(r3 + 1)) == (-1)) goto L11;
            if (Util.parseHexDigit(r2.charAt(r1)) == (-1)) goto L11;
            return true;
        }

        public static /* synthetic */ String percentDecode$okhttp$default(Companion r1, String r2, int r3, int r4, boolean r5, int r6, Object r7) {
            if ((r6 & 1) == 0) goto L6;
            r3 = 0;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r4 = r2.length();
        L9:
            if ((r6 & 4) == 0) goto L12;
            r5 = false;
        L12:
            return r1.percentDecode$okhttp(r2, r3, r4, r5);
        }

        private final void writeCanonicalized(Buffer r14, String r15, int r16, int r17, String r18, boolean r19, boolean r20, boolean r21, boolean r22, Charset r23) {
            Buffer r5 = null;
            int r4 = r16;
        L3:
            if (r4 >= r17) goto L58;
            if (r15 == null) goto L57;
            int r6 = r15.codePointAt(r4);
            if (r19 == false) goto L18;
            if (r6 == 9) goto L55;
            if (r6 == 10) goto L55;
            if (r6 == 12) goto L55;
            if (r6 != 13) goto L18;
        L55:
            r4 = r4 + Character.charCount(r6);
        L18:
            if (r6 != 43) goto L25;
            if (r21 == false) goto L25;
            if (r19 == false) goto L22;
            String r7 = "+";
        L23:
            r14.writeUtf8(r7);
            goto L55
        L22:
            r7 = "%2B";
        L25:
            if (r6 < 32) goto L44;
            if (r6 == 127) goto L44;
            if (r6 < 128) goto L34;
            if (r22 == false) goto L44;
        L34:
            if (StringsKt.n(r18, (char) r6) == true) goto L44;
            if (r6 != 37) goto L43;
            if (r19 == false) goto L44;
            if (r20 == false) goto L43;
            if (isPercentEncoded(r15, r4, r17) == false) goto L44;
        L43:
            r14.writeUtf8CodePoint(r6);
        L44:
            if (r5 != null) goto L46;
            r5 = new Buffer();
        L46:
            if (r23 != null) goto L48;
        L51:
            r5.writeUtf8CodePoint(r6);
        L53:
            if (r5.exhausted() == true) goto L55;
            byte r10 = r5.readByte();
            r14.writeByte(37);
            r14.writeByte(HttpUrl.access$getHEX_DIGITS$cp()[((r10 & 255) >> 4) & 15]);
            r14.writeByte(HttpUrl.access$getHEX_DIGITS$cp()[r10 & 15]);
            goto L53
        L48:
            if (r23.equals(StandardCharsets.UTF_8) == true) goto L51;
            r5.writeString(r15, r4, Character.charCount(r6) + r4, r23);
            goto L53
        L57:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }

        private final void writePercentDecoded(Buffer r5, String r6, int r7, int r8, boolean r9) {
        L2:
            if (r7 >= r8) goto L19;
            if (r6 == null) goto L18;
            int r4 = r6.codePointAt(r7);
            if (r4 != 37) goto L13;
            int r0 = r7 + 2;
            if (r0 >= r8) goto L13;
            int r1 = Util.parseHexDigit(r6.charAt(r7 + 1));
            int r2 = Util.parseHexDigit(r6.charAt(r0));
            if (r1 == (-1)) goto L16;
            if (r2 == (-1)) goto L16;
            r5.writeByte((r1 << 4) + r2);
            r7 = Character.charCount(r4) + r0;
        L16:
            r5.writeUtf8CodePoint(r4);
            r7 = r7 + Character.charCount(r4);
        L13:
            if (r4 != 43) goto L16;
            if (r9 == false) goto L16;
            r5.writeByte(32);
            r7 = r7 + 1;
            goto L2
        L18:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }

        @Deprecated
        @JvmName
        @NotNull
        /* JADX INFO: renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m115deprecated_get(@NotNull String r2) {
            Intrinsics.f(r2, "url");
            return get(r2);
        }

        @Deprecated
        @JvmName
        @Nullable
        /* JADX INFO: renamed from: -deprecated_parse, reason: not valid java name */
        public final HttpUrl m118deprecated_parse(@NotNull String r2) {
            Intrinsics.f(r2, "url");
            return parse(r2);
        }

        @NotNull
        public final String canonicalize$okhttp(@NotNull String r13, int r14, int r15, @NotNull String r16, boolean r17, boolean r18, boolean r19, boolean r20, @Nullable Charset r21) {
            Intrinsics.f(r13, "$this$canonicalize");
            Intrinsics.f(r16, "encodeSet");
            int r3 = r14;
        L3:
            if (r3 >= r15) goto L30;
            int r0 = r13.codePointAt(r3);
            if (r0 < 32) goto L28;
            if (r0 == 127) goto L28;
            if (r0 < 128) goto L14;
            if (r20 == false) goto L28;
        L14:
            if (StringsKt.n(r16, (char) r0) == true) goto L28;
            if (r0 != 37) goto L24;
            if (r17 == false) goto L28;
            if (r18 == false) goto L24;
            if (isPercentEncoded(r13, r3, r15) == false) goto L28;
        L24:
            if (r0 != 43) goto L27;
            if (r19 == true) goto L28;
        L27:
            r3 = r3 + Character.charCount(r0);
        L28:
            Buffer r11 = new Buffer();
            r11.writeUtf8(r13, r14, r3);
            writeCanonicalized(r11, r13, r3, r15, r16, r17, r18, r19, r20, r21);
            return r11.readUtf8();
        L30:
            String r1 = r13.substring(r14, r15);
            Intrinsics.e(r1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return r1;
        }

        @JvmStatic
        public final int defaultPort(@NotNull String r2) {
            Intrinsics.f(r2, "scheme");
            int r1 = r2.hashCode();
            if (r1 == 3213448) goto L11;
            if (r1 == 99617003) goto L8;
        L13:
            return -1;
        L8:
            if (r2.equals("https") == false) goto L13;
            return 443;
        L11:
            if (r2.equals(HttpHost.DEFAULT_SCHEME_NAME) == false) goto L13;
            return 80;
        }

        @JvmStatic
        @JvmName
        @NotNull
        public final HttpUrl get(@NotNull String r2) {
            Intrinsics.f(r2, "$this$toHttpUrl");
            return new Builder().parse$okhttp(null, r2).build();
        }

        @JvmStatic
        @JvmName
        @Nullable
        public final HttpUrl parse(@NotNull String r2) {
            Intrinsics.f(r2, "$this$toHttpUrlOrNull");
            return get(r2);
        L5:
            return null;
        }

        @NotNull
        public final String percentDecode$okhttp(@NotNull String r8, int r9, int r10, boolean r11) {
            Intrinsics.f(r8, "$this$percentDecode");
            int r4 = r9;
        L3:
            if (r4 >= r10) goto L13;
            char r0 = r8.charAt(r4);
            if (r0 == '%') goto L11;
            if (r0 != '+') goto L10;
            if (r11 == true) goto L11;
        L10:
            r4 = r4 + 1;
        L11:
            Buffer r1 = new Buffer();
            r1.writeUtf8(r8, r9, r4);
            writePercentDecoded(r1, r8, r4, r10, r11);
            return r1.readUtf8();
        L13:
            String r7 = r8.substring(r9, r10);
            Intrinsics.e(r7, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return r7;
        }

        public final void toPathString$okhttp(@NotNull List<String> r3, @NotNull StringBuilder r4) {
            Intrinsics.f(r3, "$this$toPathString");
            Intrinsics.f(r4, "out");
            int r2 = r3.size();
            int r0 = 0;
        L3:
            if (r0 >= r2) goto L5;
            r4.append('/');
            r4.append(r3.get(r0));
            r0 = r0 + 1;
            goto L3
        }

        @NotNull
        public final List<String> toQueryNamesAndValues$okhttp(@NotNull String r7) {
            Intrinsics.f(r7, "$this$toQueryNamesAndValues");
            ArrayList r6 = new ArrayList();
            int r1 = 0;
        L4:
            if (r1 > r7.length()) goto L15;
            int r2 = StringsKt.r(r7, '&', r1, false, 4);
            if (r2 != (-1)) goto L8;
            r2 = r7.length();
        L8:
            int r3 = StringsKt.r(r7, '=', r1, false, 4);
            if (r3 == (-1)) goto L13;
            if (r3 > r2) goto L13;
            String r4 = r7.substring(r1, r3);
            Intrinsics.e(r4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            r6.add(r4);
            String r5 = r7.substring(r3 + 1, r2);
            Intrinsics.e(r5, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            r6.add(r5);
        L14:
            r1 = r2 + 1;
        L13:
            String r8 = r7.substring(r1, r2);
            Intrinsics.e(r8, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            r6.add(r8);
            r6.add(null);
            goto L14
        L15:
            return r6;
        }

        public final void toQueryString$okhttp(@NotNull List<String> r6, @NotNull StringBuilder r7) {
            Intrinsics.f(r6, "$this$toQueryString");
            Intrinsics.f(r7, "out");
            IntProgression r5 = RangesKt.d(RangesKt.e(0, r6.size()), 2);
            int r0 = r5.b;
            int r1 = r5.c;
            int r8 = r5.e;
            if (r8 < 0) goto L6;
            if (r0 <= r1) goto L7;
            return;
        L7:
            String r2 = r6.get(r0);
            String r3 = r6.get(r0 + 1);
            if (r0 <= 0) goto L10;
            r7.append('&');
        L10:
            r7.append(r2);
            if (r3 == null) goto L13;
            r7.append('=');
            r7.append(r3);
        L13:
            if (r0 == r1) goto L19;
            r0 = r0 + r8;
            goto L7
        L19:
            return;
        L6:
            if (r0 >= r1) goto L7;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @Deprecated
        @JvmName
        @Nullable
        /* JADX INFO: renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m117deprecated_get(@NotNull URL r2) {
            Intrinsics.f(r2, "url");
            return get(r2);
        }

        @JvmStatic
        @JvmName
        @Nullable
        public final HttpUrl get(@NotNull URL r2) {
            Intrinsics.f(r2, "$this$toHttpUrlOrNull");
            String r3 = r2.toString();
            Intrinsics.e(r3, "toString()");
            return parse(r3);
        }

        @Deprecated
        @JvmName
        @Nullable
        /* JADX INFO: renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m116deprecated_get(@NotNull URI r2) {
            Intrinsics.f(r2, "uri");
            return get(r2);
        }

        @JvmStatic
        @JvmName
        @Nullable
        public final HttpUrl get(@NotNull URI r2) {
            Intrinsics.f(r2, "$this$toHttpUrlOrNull");
            String r3 = r2.toString();
            Intrinsics.e(r3, "toString()");
            return parse(r3);
        }
    }

    static {
        Companion = new Companion(null);
        HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public HttpUrl(@NotNull String r2, @NotNull String r3, @NotNull String r4, @NotNull String r5, int r6, @NotNull List<String> r7, @Nullable List<String> r8, @Nullable String r9, @NotNull String r10) {
        Intrinsics.f(r2, "scheme");
        Intrinsics.f(r3, "username");
        Intrinsics.f(r4, "password");
        Intrinsics.f(r5, "host");
        Intrinsics.f(r7, "pathSegments");
        Intrinsics.f(r10, "url");
        this.scheme = r2;
        this.username = r3;
        this.password = r4;
        this.host = r5;
        this.port = r6;
        this.pathSegments = r7;
        this.queryNamesAndValues = r8;
        this.fragment = r9;
        this.url = r10;
        this.isHttps = Intrinsics.a(r2, "https");
    }

    public static final /* synthetic */ char[] access$getHEX_DIGITS$cp() {
        return HEX_DIGITS;
    }

    @JvmStatic
    public static final int defaultPort(@NotNull String r1) {
        return Companion.defaultPort(r1);
    }

    @JvmStatic
    @JvmName
    @NotNull
    public static final HttpUrl get(@NotNull String r1) {
        return Companion.get(r1);
    }

    @JvmStatic
    @JvmName
    @Nullable
    public static final HttpUrl parse(@NotNull String r1) {
        return Companion.parse(r1);
    }

    @Deprecated
    @JvmName
    @Nullable
    /* JADX INFO: renamed from: -deprecated_encodedFragment, reason: not valid java name */
    public final String m96deprecated_encodedFragment() {
        return encodedFragment();
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_encodedPassword, reason: not valid java name */
    public final String m97deprecated_encodedPassword() {
        return encodedPassword();
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_encodedPath, reason: not valid java name */
    public final String m98deprecated_encodedPath() {
        return encodedPath();
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_encodedPathSegments, reason: not valid java name */
    public final List<String> m99deprecated_encodedPathSegments() {
        return encodedPathSegments();
    }

    @Deprecated
    @JvmName
    @Nullable
    /* JADX INFO: renamed from: -deprecated_encodedQuery, reason: not valid java name */
    public final String m100deprecated_encodedQuery() {
        return encodedQuery();
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_encodedUsername, reason: not valid java name */
    public final String m101deprecated_encodedUsername() {
        return encodedUsername();
    }

    @Deprecated
    @JvmName
    @Nullable
    /* JADX INFO: renamed from: -deprecated_fragment, reason: not valid java name */
    public final String m102deprecated_fragment() {
        return this.fragment;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_host, reason: not valid java name */
    public final String m103deprecated_host() {
        return this.host;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_password, reason: not valid java name */
    public final String m104deprecated_password() {
        return this.password;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_pathSegments, reason: not valid java name */
    public final List<String> m105deprecated_pathSegments() {
        return this.pathSegments;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_pathSize, reason: not valid java name */
    public final int m106deprecated_pathSize() {
        return pathSize();
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_port, reason: not valid java name */
    public final int m107deprecated_port() {
        return this.port;
    }

    @Deprecated
    @JvmName
    @Nullable
    /* JADX INFO: renamed from: -deprecated_query, reason: not valid java name */
    public final String m108deprecated_query() {
        return query();
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_queryParameterNames, reason: not valid java name */
    public final Set<String> m109deprecated_queryParameterNames() {
        return queryParameterNames();
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_querySize, reason: not valid java name */
    public final int m110deprecated_querySize() {
        return querySize();
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_scheme, reason: not valid java name */
    public final String m111deprecated_scheme() {
        return this.scheme;
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_uri, reason: not valid java name */
    public final URI m112deprecated_uri() {
        return uri();
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_url, reason: not valid java name */
    public final URL m113deprecated_url() {
        return url();
    }

    @Deprecated
    @JvmName
    @NotNull
    /* JADX INFO: renamed from: -deprecated_username, reason: not valid java name */
    public final String m114deprecated_username() {
        return this.username;
    }

    @JvmName
    @Nullable
    public final String encodedFragment() {
        if (this.fragment != null) goto L6;
        return null;
    L6:
        int r0 = StringsKt.r(this.url, '#', 0, false, 6) + 1;
        String r4 = this.url;
        if (r4 == null) goto L11;
        String r5 = r4.substring(r0);
        Intrinsics.e(r5, "(this as java.lang.String).substring(startIndex)");
        return r5;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @JvmName
    @NotNull
    public final String encodedPassword() {
        if (this.password.length() != 0) goto L6;
        return "";
    L6:
        int r0 = StringsKt.r(this.url, ':', this.scheme.length() + 3, false, 4) + 1;
        int r1 = StringsKt.r(this.url, '@', 0, false, 6);
        String r5 = this.url;
        if (r5 == null) goto L11;
        String r6 = r5.substring(r0, r1);
        Intrinsics.e(r6, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return r6;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @JvmName
    @NotNull
    public final String encodedPath() {
        int r0 = StringsKt.r(this.url, '/', this.scheme.length() + 3, false, 4);
        String r1 = this.url;
        int r2 = Util.delimiterOffset(r1, "?#", r0, r1.length());
        String r5 = this.url;
        if (r5 == null) goto L7;
        String r6 = r5.substring(r0, r2);
        Intrinsics.e(r6, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return r6;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @JvmName
    @NotNull
    public final List<String> encodedPathSegments() {
        int r0 = StringsKt.r(this.url, '/', this.scheme.length() + 3, false, 4);
        String r1 = this.url;
        int r2 = Util.delimiterOffset(r1, "?#", r0, r1.length());
        ArrayList r3 = new ArrayList();
    L3:
        if (r0 >= r2) goto L9;
        int r4 = r0 + 1;
        int r5 = Util.delimiterOffset(this.url, '/', r4, r2);
        String r6 = this.url;
        if (r6 == null) goto L8;
        String r7 = r6.substring(r4, r5);
        Intrinsics.e(r7, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        r3.add(r7);
        r0 = r5;
        goto L3
    L8:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    L9:
        return r3;
    }

    @JvmName
    @Nullable
    public final String encodedQuery() {
        if (this.queryNamesAndValues != null) goto L6;
        return null;
    L6:
        int r0 = StringsKt.r(this.url, '?', 0, false, 6) + 1;
        String r1 = this.url;
        int r2 = Util.delimiterOffset(r1, '#', r0, r1.length());
        String r4 = this.url;
        if (r4 == null) goto L11;
        String r5 = r4.substring(r0, r2);
        Intrinsics.e(r5, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return r5;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @JvmName
    @NotNull
    public final String encodedUsername() {
        if (this.username.length() != 0) goto L6;
        return "";
    L6:
        int r0 = this.scheme.length() + 3;
        String r1 = this.url;
        int r2 = Util.delimiterOffset(r1, ":@", r0, r1.length());
        String r4 = this.url;
        if (r4 == null) goto L11;
        String r5 = r4.substring(r0, r2);
        Intrinsics.e(r5, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return r5;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public boolean equals(@Nullable Object r2) {
        if ((r2 instanceof HttpUrl) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.a(((HttpUrl) r2).url, this.url) == false) goto L7;
        return true;
    }

    @JvmName
    @Nullable
    public final String fragment() {
        return this.fragment;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    @JvmName
    @NotNull
    public final String host() {
        return this.host;
    }

    public final boolean isHttps() {
        return this.isHttps;
    }

    @NotNull
    public final Builder newBuilder() {
        Builder r0 = new Builder();
        r0.setScheme$okhttp(this.scheme);
        r0.setEncodedUsername$okhttp(encodedUsername());
        r0.setEncodedPassword$okhttp(encodedPassword());
        r0.setHost$okhttp(this.host);
        if (this.port == Companion.defaultPort(this.scheme)) goto L5;
        int r1 = this.port;
    L6:
        r0.setPort$okhttp(r1);
        r0.getEncodedPathSegments$okhttp().clear();
        r0.getEncodedPathSegments$okhttp().addAll(encodedPathSegments());
        r0.encodedQuery(encodedQuery());
        r0.setEncodedFragment$okhttp(encodedFragment());
        return r0;
    L5:
        r1 = -1;
        goto L6
    }

    @JvmName
    @NotNull
    public final String password() {
        return this.password;
    }

    @JvmName
    @NotNull
    public final List<String> pathSegments() {
        return this.pathSegments;
    }

    @JvmName
    public final int pathSize() {
        return this.pathSegments.size();
    }

    @JvmName
    public final int port() {
        return this.port;
    }

    @JvmName
    @Nullable
    public final String query() {
        if (this.queryNamesAndValues != null) goto L6;
        return null;
    L6:
        StringBuilder r0 = new StringBuilder();
        Companion.toQueryString$okhttp(this.queryNamesAndValues, r0);
        return r0.toString();
    }

    @Nullable
    public final String queryParameter(@NotNull String r6) {
        Intrinsics.f(r6, "name");
        List<String> r0 = this.queryNamesAndValues;
        if (r0 != null) goto L5;
        return null;
    L5:
        IntProgression r1 = RangesKt.d(RangesKt.e(0, r0.size()), 2);
        int r2 = r1.b;
        int r3 = r1.c;
        int r4 = r1.e;
        if (r4 < 0) goto L9;
        if (r2 <= r3) goto L11;
    L16:
        return null;
    L11:
        if (r6.equals(this.queryNamesAndValues.get(r2)) == true) goto L13;
        if (r2 == r3) goto L16;
        r2 = r2 + r4;
        goto L11
    L13:
        return this.queryNamesAndValues.get(r2 + 1);
    L9:
        if (r2 < r3) goto L16;
        goto L16
    }

    @NotNull
    public final String queryParameterName(int r1) {
        List<String> r0 = this.queryNamesAndValues;
        if (r0 == null) goto L7;
        String r2 = r0.get(r1 * 2);
        Intrinsics.c(r2);
        return r2;
    L7:
        throw new IndexOutOfBoundsException();
    }

    @JvmName
    @NotNull
    public final Set<String> queryParameterNames() {
        if (this.queryNamesAndValues == null) goto L5;
        LinkedHashSet r0 = new LinkedHashSet();
        IntProgression r1 = RangesKt.d(RangesKt.e(0, this.queryNamesAndValues.size()), 2);
        int r2 = r1.b;
        int r3 = r1.c;
        int r4 = r1.e;
        if (r4 < 0) goto L10;
        if (r2 <= r3) goto L11;
    L14:
        Set<String> r5 = Collections.unmodifiableSet(r0);
        Intrinsics.e(r5, "Collections.unmodifiableSet(result)");
        return r5;
    L11:
        String r6 = this.queryNamesAndValues.get(r2);
        Intrinsics.c(r6);
        r0.add(r6);
        if (r2 == r3) goto L14;
        r2 = r2 + r4;
        goto L11
    L10:
        if (r2 < r3) goto L14;
    L5:
        return EmptySet.b;
    }

    @Nullable
    public final String queryParameterValue(int r1) {
        List<String> r0 = this.queryNamesAndValues;
        if (r0 == null) goto L7;
        return r0.get((r1 * 2) + 1);
    L7:
        throw new IndexOutOfBoundsException();
    }

    @NotNull
    public final List<String> queryParameterValues(@NotNull String r7) {
        Intrinsics.f(r7, "name");
        if (this.queryNamesAndValues == null) goto L5;
        ArrayList r0 = new ArrayList();
        IntProgression r1 = RangesKt.d(RangesKt.e(0, this.queryNamesAndValues.size()), 2);
        int r2 = r1.b;
        int r3 = r1.c;
        int r4 = r1.e;
        if (r4 < 0) goto L10;
        if (r2 <= r3) goto L12;
    L16:
        List<String> r6 = Collections.unmodifiableList(r0);
        Intrinsics.e(r6, "Collections.unmodifiableList(result)");
        return r6;
    L12:
        if (r7.equals(this.queryNamesAndValues.get(r2)) == false) goto L14;
        r0.add(this.queryNamesAndValues.get(r2 + 1));
    L14:
        if (r2 == r3) goto L16;
        r2 = r2 + r4;
        goto L12
    L10:
        if (r2 < r3) goto L16;
    L5:
        return EmptyList.b;
    }

    @JvmName
    public final int querySize() {
        List<String> r0 = this.queryNamesAndValues;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size() / 2;
    }

    @NotNull
    public final String redact() {
        Builder r1 = newBuilder("/...");
        Intrinsics.c(r1);
        return r1.username("").password("").build().toString();
    }

    @Nullable
    public final HttpUrl resolve(@NotNull String r2) {
        Intrinsics.f(r2, "link");
        Builder r1 = newBuilder(r2);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.build();
    }

    @JvmName
    @NotNull
    public final String scheme() {
        return this.scheme;
    }

    @NotNull
    public String toString() {
        return this.url;
    }

    @Nullable
    public final String topPrivateDomain() {
        if (Util.canParseAsIpAddress(this.host) == false) goto L6;
        return null;
    L6:
        return PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(this.host);
    }

    @JvmName
    @NotNull
    public final URI uri() {
        String r3 = newBuilder().reencodeForUri$okhttp().toString();
        return new URI(r3);
    L5:
        e = move-exception;
        Regex r1 = new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]");     // Catch: Exception -> L9
        Intrinsics.f(r3, "input");     // Catch: Exception -> L9
        String r4 = r1.b.matcher(r3).replaceAll("");     // Catch: Exception -> L9
        Intrinsics.e(r4, "nativePattern.matcher(in…).replaceAll(replacement)");     // Catch: Exception -> L9
        URI r0 = URI.create(r4);     // Catch: Exception -> L9
        Intrinsics.e(r0, "try {\n        val stripp…e) // Unexpected!\n      }");
        return r0;
    L10:
        throw new RuntimeException(e);
    }

    @JvmName
    @NotNull
    public final URL url() {
        return new URL(this.url);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @JvmName
    @NotNull
    public final String username() {
        return this.username;
    }

    @JvmStatic
    @JvmName
    @Nullable
    public static final HttpUrl get(@NotNull URI r1) {
        return Companion.get(r1);
    }

    @JvmStatic
    @JvmName
    @Nullable
    public static final HttpUrl get(@NotNull URL r1) {
        return Companion.get(r1);
    }

    @Nullable
    public final Builder newBuilder(@NotNull String r2) {
        Intrinsics.f(r2, "link");
        return new Builder().parse$okhttp(this, r2);
    L5:
        return null;
    }
}
