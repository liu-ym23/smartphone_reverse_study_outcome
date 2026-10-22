package okhttp3;

import android.text.TextUtils;
import com.bytedance.frameworks.baselib.network.http.util.HttpHost;
import com.bytedance.librarian.LibrarianImpl;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import kotlin.UByte;
import kotlin.text.Typography;
import okhttp3.internal.Util;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okhttp3.ttnet.TTConfigManager;
import okio.Buffer;
import org.apache.commons.io.IOUtils;
import tmsdk.common.tcc.DeepCleanSAFEngine;

/* JADX INFO: loaded from: classes5.dex */
public final class HttpUrl {
    static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
    static final String FRAGMENT_ENCODE_SET = "";
    static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
    private static final char[] HEX_DIGITS = null;
    static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
    static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
    static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
    static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";
    static final String QUERY_ENCODE_SET = " \"'<>#";
    static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";

    @Nullable
    private final String fragment;
    final String host;
    private final String password;
    private final List<String> pathSegments;
    final int port;

    @Nullable
    private final List<String> queryNamesAndValues;
    final String scheme;
    private final String url;
    private final String username;

    public static final class Builder {
        static final String INVALID_HOST = "Invalid URL host";

        @Nullable
        String encodedFragment;
        String encodedPassword;
        final List<String> encodedPathSegments;

        @Nullable
        List<String> encodedQueryNamesAndValues;
        String encodedUsername;

        @Nullable
        String host;
        int port;

        @Nullable
        String scheme;

        public Builder() {
            this.encodedUsername = "";
            this.encodedPassword = "";
            this.port = -1;
            ArrayList r1 = new ArrayList();
            this.encodedPathSegments = r1;
            r1.add("");
        }

        public Builder scheme(String r3) {
            if (r3 == null) goto L13;
            if (r3.equalsIgnoreCase(HttpHost.DEFAULT_SCHEME_NAME) == false) goto L7;
            this.scheme = HttpHost.DEFAULT_SCHEME_NAME;
        L9:
            return this;
        L7:
            if (r3.equalsIgnoreCase("https") == false) goto L11;
            this.scheme = "https";
            goto L9
        L11:
            throw new IllegalArgumentException("unexpected scheme: " + r3);
        L13:
            throw new NullPointerException("scheme == null");
        }

        public Builder username(String r7) {
            if (r7 == null) goto L6;
            this.encodedUsername = HttpUrl.canonicalize(r7, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        L6:
            throw new NullPointerException("username == null");
        }

        public Builder encodedUsername(String r7) {
            if (r7 == null) goto L6;
            this.encodedUsername = HttpUrl.canonicalize(r7, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
            return this;
        L6:
            throw new NullPointerException("encodedUsername == null");
        }

        public Builder password(String r7) {
            if (r7 == null) goto L6;
            this.encodedPassword = HttpUrl.canonicalize(r7, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        L6:
            throw new NullPointerException("password == null");
        }

        public Builder encodedPassword(String r7) {
            if (r7 == null) goto L6;
            this.encodedPassword = HttpUrl.canonicalize(r7, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
            return this;
        L6:
            throw new NullPointerException("encodedPassword == null");
        }

        public Builder host(String r3) {
            if (r3 == null) goto L10;
            String r0 = canonicalizeHost(r3, 0, r3.length());
            if (r0 == null) goto L8;
            this.host = r0;
            return this;
        L8:
            throw new IllegalArgumentException("unexpected host: " + r3);
        L10:
            throw new NullPointerException("host == null");
        }

        public Builder port(int r3) {
            if (r3 <= 0) goto L8;
            if (r3 > 65535) goto L8;
            this.port = r3;
            return this;
        L8:
            throw new IllegalArgumentException("unexpected port: " + r3);
        }

        int effectivePort() {
            int r0 = this.port;
            if (r0 == (-1)) goto L6;
            return r0;
        L6:
            return HttpUrl.defaultPort(this.scheme);
        }

        public Builder addPathSegment(String r7) {
            if (r7 == null) goto L6;
            push(r7, 0, r7.length(), false, false);
            return this;
        L6:
            throw new NullPointerException("pathSegment == null");
        }

        public Builder addPathSegments(String r2) {
            if (r2 == null) goto L6;
            return addPathSegments(r2, false);
        L6:
            throw new NullPointerException("pathSegments == null");
        }

        public Builder addEncodedPathSegment(String r7) {
            if (r7 == null) goto L6;
            push(r7, 0, r7.length(), false, true);
            return this;
        L6:
            throw new NullPointerException("encodedPathSegment == null");
        }

        public Builder addEncodedPathSegments(String r2) {
            if (r2 == null) goto L6;
            return addPathSegments(r2, true);
        L6:
            throw new NullPointerException("encodedPathSegments == null");
        }

        private Builder addPathSegments(String r9, boolean r10) {
            int r3 = 0;
        L3:
            int r7 = Util.delimiterOffset(r9, r3, r9.length(), "/\\");
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

        public Builder setPathSegment(int r10, String r11) {
            if (r11 == null) goto L12;
            String r0 = HttpUrl.canonicalize(r11, 0, r11.length(), HttpUrl.PATH_SEGMENT_ENCODE_SET, false, false, false, true, null);
            if (isDot(r0) == true) goto L10;
            if (isDotDot(r0) == true) goto L10;
            this.encodedPathSegments.set(r10, r0);
            return this;
        L10:
            throw new IllegalArgumentException("unexpected path segment: " + r11);
        L12:
            throw new NullPointerException("pathSegment == null");
        }

        public Builder setEncodedPathSegment(int r10, String r11) {
            if (r11 == null) goto L11;
            String r0 = HttpUrl.canonicalize(r11, 0, r11.length(), HttpUrl.PATH_SEGMENT_ENCODE_SET, true, false, false, true, null);
            this.encodedPathSegments.set(r10, r0);
            if (isDot(r0) == true) goto L9;
            if (isDotDot(r0) == true) goto L9;
            return this;
        L9:
            throw new IllegalArgumentException("unexpected path segment: " + r11);
        L11:
            throw new NullPointerException("encodedPathSegment == null");
        }

        public Builder removePathSegment(int r2) {
            this.encodedPathSegments.remove(r2);
            if (this.encodedPathSegments.isEmpty() == false) goto L5;
            this.encodedPathSegments.add("");
        L5:
            return this;
        }

        public Builder encodedPath(String r3) {
            if (r3 == null) goto L10;
            if (r3.startsWith(LibrarianImpl.Constants.SEPARATOR) == false) goto L8;
            resolvePath(r3, 0, r3.length());
            return this;
        L8:
            throw new IllegalArgumentException("unexpected encodedPath: " + r3);
        L10:
            throw new NullPointerException("encodedPath == null");
        }

        public Builder query(@Nullable String r7) {
            if (r7 == null) goto L4;
            List<String> r8 = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(r7, HttpUrl.QUERY_ENCODE_SET, false, false, true, true));
        L5:
            this.encodedQueryNamesAndValues = r8;
            return this;
        L4:
            r8 = null;
            goto L5
        }

        public Builder encodedQuery(@Nullable String r7) {
            if (r7 == null) goto L4;
            List<String> r8 = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(r7, HttpUrl.QUERY_ENCODE_SET, true, false, true, true));
        L5:
            this.encodedQueryNamesAndValues = r8;
            return this;
        L4:
            r8 = null;
            goto L5
        }

        public Builder addQueryParameter(String r8, @Nullable String r9) {
            if (r8 == null) goto L13;
            if (this.encodedQueryNamesAndValues != null) goto L6;
            this.encodedQueryNamesAndValues = new ArrayList();
        L6:
            this.encodedQueryNamesAndValues.add(HttpUrl.canonicalize(r8, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, true));
            List<String> r10 = this.encodedQueryNamesAndValues;
            if (r9 == null) goto L9;
            String r11 = HttpUrl.canonicalize(r9, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, true);
        L10:
            r10.add(r11);
            return this;
        L9:
            r11 = null;
            goto L10
        L13:
            throw new NullPointerException("name == null");
        }

        public Builder addEncodedQueryParameter(String r8, @Nullable String r9) {
            if (r8 == null) goto L13;
            if (this.encodedQueryNamesAndValues != null) goto L6;
            this.encodedQueryNamesAndValues = new ArrayList();
        L6:
            this.encodedQueryNamesAndValues.add(HttpUrl.canonicalize(r8, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, true));
            List<String> r10 = this.encodedQueryNamesAndValues;
            if (r9 == null) goto L9;
            String r11 = HttpUrl.canonicalize(r9, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, true);
        L10:
            r10.add(r11);
            return this;
        L9:
            r11 = null;
            goto L10
        L13:
            throw new NullPointerException("encodedName == null");
        }

        public Builder setQueryParameter(String r1, @Nullable String r2) {
            removeAllQueryParameters(r1);
            addQueryParameter(r1, r2);
            return this;
        }

        public Builder setEncodedQueryParameter(String r1, @Nullable String r2) {
            removeAllEncodedQueryParameters(r1);
            addEncodedQueryParameter(r1, r2);
            return this;
        }

        public Builder removeAllQueryParameters(String r8) {
            if (r8 == null) goto L9;
            if (this.encodedQueryNamesAndValues != null) goto L6;
            return this;
        L6:
            removeAllCanonicalQueryParameters(HttpUrl.canonicalize(r8, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, true));
            return this;
        L9:
            throw new NullPointerException("name == null");
        }

        public Builder removeAllEncodedQueryParameters(String r8) {
            if (r8 == null) goto L9;
            if (this.encodedQueryNamesAndValues != null) goto L6;
            return this;
        L6:
            removeAllCanonicalQueryParameters(HttpUrl.canonicalize(r8, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, true));
            return this;
        L9:
            throw new NullPointerException("encodedName == null");
        }

        private void removeAllCanonicalQueryParameters(String r4) {
            int r0 = this.encodedQueryNamesAndValues.size() - 2;
        L3:
            if (r0 < 0) goto L11;
            if (r4.equals(this.encodedQueryNamesAndValues.get(r0)) == false) goto L10;
            this.encodedQueryNamesAndValues.remove(r0 + 1);
            this.encodedQueryNamesAndValues.remove(r0);
            if (this.encodedQueryNamesAndValues.isEmpty() == false) goto L10;
            this.encodedQueryNamesAndValues = null;
            return;
        L10:
            r0 = r0 - 2;
            goto L3
        }

        public Builder fragment(@Nullable String r7) {
            if (r7 == null) goto L4;
            String r8 = HttpUrl.canonicalize(r7, "", false, false, false, false);
        L5:
            this.encodedFragment = r8;
            return this;
        L4:
            r8 = null;
            goto L5
        }

        public Builder encodedFragment(@Nullable String r7) {
            if (r7 == null) goto L4;
            String r8 = HttpUrl.canonicalize(r7, "", true, false, false, false);
        L5:
            this.encodedFragment = r8;
            return this;
        L4:
            r8 = null;
            goto L5
        }

        Builder reencodeForUri() {
            int r0 = this.encodedPathSegments.size();
            int r1 = 0;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L5;
            this.encodedPathSegments.set(r2, HttpUrl.canonicalize(this.encodedPathSegments.get(r2), HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, true));
            r2 = r2 + 1;
            goto L3
        L5:
            List<String> r3 = this.encodedQueryNamesAndValues;
            if (r3 == null) goto L13;
            int r4 = r3.size();
        L8:
            if (r1 >= r4) goto L13;
            String r5 = this.encodedQueryNamesAndValues.get(r1);
            if (r5 == null) goto L12;
            this.encodedQueryNamesAndValues.set(r1, HttpUrl.canonicalize(r5, HttpUrl.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, true));
        L12:
            r1 = r1 + 1;
        L13:
            String r6 = this.encodedFragment;
            if (r6 == null) goto L16;
            this.encodedFragment = HttpUrl.canonicalize(r6, HttpUrl.FRAGMENT_ENCODE_SET_URI, true, true, false, false);
        L16:
            return this;
        }

        public HttpUrl build() {
            if (this.scheme == null) goto L11;
            if (this.host == null) goto L9;
            return new HttpUrl(this);
        L9:
            throw new IllegalStateException("host == null");
        L11:
            throw new IllegalStateException("scheme == null");
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            String r1 = this.scheme;
            if (r1 == null) goto L5;
            r0.append(r1);
            r0.append("://");
        L7:
            if (this.encodedUsername.isEmpty() == true) goto L9;
        L10:
            r0.append(this.encodedUsername);
            if (this.encodedPassword.isEmpty() == true) goto L13;
            r0.append(':');
            r0.append(this.encodedPassword);
        L13:
            r0.append('@');
        L14:
            String r2 = this.host;
            if (r2 == null) goto L21;
            if (r2.indexOf(58) == (-1)) goto L19;
            r0.append('[');
            r0.append(this.host);
            r0.append(']');
            goto L21
        L19:
            r0.append(this.host);
        L21:
            if (this.port == (-1)) goto L23;
        L24:
            int r3 = effectivePort();
            String r4 = this.scheme;
            if (r4 != null) goto L27;
        L28:
            r0.append(':');
            r0.append(r3);
        L29:
            HttpUrl.pathSegmentsToString(r0, this.encodedPathSegments);
            if (this.encodedQueryNamesAndValues == null) goto L33;
            r0.append('?');
            HttpUrl.namesAndValuesToQueryString(r0, this.encodedQueryNamesAndValues);
        L33:
            if (this.encodedFragment == null) goto L36;
            r0.append('#');
            r0.append(this.encodedFragment);
        L36:
            return r0.toString();
        L27:
            if (r3 == HttpUrl.defaultPort(r4)) goto L29;
        L23:
            if (this.scheme == null) goto L29;
        L9:
            if (this.encodedPassword.isEmpty() == true) goto L14;
        L5:
            r0.append("//");
            goto L7
        }

        private static boolean shouldParseAuthority(int r2, String r3) {
            if (r2 >= 2) goto L6;
            return false;
        L6:
            if (TTConfigManager.isIgnoreSlashEnabled() == true) goto L9;
            return true;
        L9:
            if (TextUtils.isEmpty(r3) == false) goto L11;
        L15:
            return false;
        L11:
            if (r3.startsWith("https://") == false) goto L13;
        L14:
            return true;
        L13:
            if (r3.startsWith("http://") == false) goto L15;
            goto L14
        }

        Builder parse(@Nullable HttpUrl r22, String r23) {
            int r9 = Util.skipLeadingAsciiWhitespace(r23, 0, r23.length());
            int r11 = Util.skipTrailingAsciiWhitespace(r23, r9, r23.length());
            int r12 = schemeDelimiterOffset(r23, r9, r11);
            if (r12 != (-1)) goto L5;
            if (r22 == null) goto L76;
            this.scheme = r22.scheme;
        L14:
            int r2 = slashCount(r23, r9, r11);
            char r13 = '?';
            char r14 = '#';
            if (shouldParseAuthority(r2, r23) == true) goto L25;
            if (r22 == null) goto L25;
            if (r22.scheme.equals(this.scheme) == false) goto L25;
            this.encodedUsername = r22.encodedUsername();
            this.encodedPassword = r22.encodedPassword();
            this.host = r22.host;
            this.port = r22.port;
            this.encodedPathSegments.clear();
            this.encodedPathSegments.addAll(r22.encodedPathSegments());
            if (r9 != r11) goto L23;
        L24:
            encodedQuery(r22.encodedQuery());
        L63:
            int r1 = Util.delimiterOffset(r23, r9, r11, "?#");
            resolvePath(r23, r9, r1);
            if (r1 < r11) goto L66;
        L68:
            if (r1 < r11) goto L70;
        L72:
            return this;
        L70:
            if (r23.charAt(r1) != '#') goto L72;
            this.encodedFragment = HttpUrl.canonicalize(r23, 1 + r1, r11, "", true, false, false, false, null);
            goto L72
        L66:
            if (r23.charAt(r1) != '?') goto L68;
            int r15 = Util.delimiterOffset(r23, r1, r11, '#');
            this.encodedQueryNamesAndValues = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(r23, r1 + 1, r15, HttpUrl.QUERY_ENCODE_SET, true, false, true, true, null));
            r1 = r15;
            goto L68
        L23:
            if (r23.charAt(r9) != '#') goto L63;
        L25:
            boolean r16 = false;
            boolean r17 = false;
            int r3 = r9 + r2;
        L26:
            int r10 = Util.delimiterOffset(r23, r3, r11, "@/\\?#");
            if (r10 == r11) goto L29;
            byte r4 = r23.charAt(r10);
        L30:
            if (r4 == (-1)) goto L52;
            if (r4 == r14) goto L52;
            if (r4 == 47) goto L52;
            if (r4 == 92) goto L52;
            if (r4 == r13) goto L52;
            if (r4 != 64) goto L51;
            if (r16 == true) goto L49;
            int r7 = Util.delimiterOffset(r23, r3, r10, ':');
            int r18 = r10;
            String r5 = HttpUrl.canonicalize(r23, r3, r7, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
            if (r17 == false) goto L45;
            r5 = this.encodedUsername + "%40" + r5;
        L45:
            this.encodedUsername = r5;
            if (r7 == r18) goto L48;
            this.encodedPassword = HttpUrl.canonicalize(r23, r7 + 1, r18, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
            r16 = true;
        L48:
            r17 = true;
        L50:
            r3 = r18 + 1;
            goto L51
        L49:
            r18 = r10;
            this.encodedPassword += "%40" + HttpUrl.canonicalize(r23, r3, r18, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
        L51:
            r13 = '?';
            r14 = '#';
        L52:
            int r6 = portColonOffset(r23, r3, r10);
            int r8 = r6 + 1;
            if (r8 >= r10) goto L59;
            this.host = canonicalizeHost(r23, r3, r6);
            int r19 = parsePort(r23, r8, r10);
            this.port = r19;
            if (r19 != (-1)) goto L61;
            throw new IllegalArgumentException("Invalid URL port: \"" + r23.substring(r8, r10) + Typography.quote);
        L61:
            if (this.host == null) goto L74;
            r9 = r10;
            goto L63
        L74:
            throw new IllegalArgumentException("Invalid URL host: \"" + r23.substring(r3, r6) + Typography.quote);
        L59:
            this.host = canonicalizeHost(r23, r3, r6);
            this.port = HttpUrl.defaultPort(this.scheme);
            goto L61
        L29:
            r4 = -1;
            goto L30
        L76:
            throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
        L5:
            if (r23.regionMatches(true, r9, "https:", 0, 6) == false) goto L8;
            this.scheme = "https";
            r9 = r9 + 6;
            goto L14
        L8:
            if (r23.regionMatches(true, r9, "http:", 0, 5) == false) goto L11;
            this.scheme = HttpHost.DEFAULT_SCHEME_NAME;
            r9 = r9 + 5;
            goto L14
        L11:
            throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + r23.substring(0, r12) + "'");
        }

        private void resolvePath(String r11, int r12, int r13) {
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
            r12 = Util.delimiterOffset(r11, r6, r13, "/\\");
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

        private void push(String r10, int r11, int r12, boolean r13, boolean r14) {
            String r15 = HttpUrl.canonicalize(r10, r11, r12, HttpUrl.PATH_SEGMENT_ENCODE_SET, r14, false, false, true, null);
            if (isDot(r15) == false) goto L6;
            return;
        L6:
            if (isDotDot(r15) == false) goto L9;
            pop();
            return;
        L9:
            List<String> r16 = this.encodedPathSegments;
            if (r16.get(r16.size() - 1).isEmpty() == false) goto L12;
            List<String> r17 = this.encodedPathSegments;
            r17.set(r17.size() - 1, r15);
        L13:
            if (r13 == false) goto L16;
            this.encodedPathSegments.add("");
            return;
        L16:
            return;
        L12:
            this.encodedPathSegments.add(r15);
            goto L13
        }

        private boolean isDot(String r1) {
            if (r1.equals(LibrarianImpl.Constants.DOT) == false) goto L5;
        L8:
            return true;
        L5:
            if (r1.equalsIgnoreCase("%2e") == true) goto L8;
            return false;
        }

        private boolean isDotDot(String r1) {
            if (r1.equals("..") == false) goto L5;
        L12:
            return true;
        L5:
            if (r1.equalsIgnoreCase("%2e.") == true) goto L12;
            if (r1.equalsIgnoreCase(".%2e") == true) goto L12;
            if (r1.equalsIgnoreCase("%2e%2e") == true) goto L12;
            return false;
        }

        private void pop() {
            List<String> r0 = this.encodedPathSegments;
            if (r0.remove(r0.size() - 1).isEmpty() == true) goto L5;
        L7:
            this.encodedPathSegments.add("");
            return;
        L5:
            if (this.encodedPathSegments.isEmpty() == true) goto L7;
            List<String> r2 = this.encodedPathSegments;
            r2.set(r2.size() - 1, "");
        }

        private static int schemeDelimiterOffset(String r7, int r8, int r9) {
            if ((r9 - r8) >= 2) goto L5;
            return -1;
        L5:
            char r0 = r7.charAt(r8);
            if (r0 < 'a') goto L8;
            if (r0 > 'z') goto L8;
        L11:
            r8 = r8 + 1;
            if (r8 >= r9) goto L32;
            char r1 = r7.charAt(r8);
            if (r1 < 'a') goto L16;
            if (r1 <= 'z') goto L11;
        L16:
            if (r1 < 'A') goto L19;
            if (r1 <= 'Z') goto L11;
        L19:
            if (r1 < '0') goto L23;
            if (r1 <= '9') goto L11;
        L23:
            if (r1 == '+') goto L11;
            if (r1 == '-') goto L11;
            if (r1 == '.') goto L11;
            if (r1 != ':') goto L32;
            return r8;
        L32:
            return -1;
        L8:
            if (r0 < 'A') goto L32;
            if (r0 <= 'Z') goto L11;
            goto L32
        }

        private static int slashCount(String r3, int r4, int r5) {
            int r0 = 0;
        L3:
            if (r4 >= r5) goto L9;
            char r1 = r3.charAt(r4);
            if (r1 == '\\') goto L8;
            if (r1 != '/') goto L9;
        L8:
            r0 = r0 + 1;
            r4 = r4 + 1;
        L9:
            return r0;
        }

        private static int portColonOffset(String r2, int r3, int r4) {
        L2:
            if (r3 >= r4) goto L14;
            char r0 = r2.charAt(r3);
            if (r0 == ':') goto L13;
            if (r0 != '[') goto L12;
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

        private static String canonicalizeHost(String r1, int r2, int r3) {
            return Util.canonicalizeHost(HttpUrl.percentDecode(r1, r2, r3, false));
        }

        private static int parsePort(String r10, int r11, int r12) {
            int r13 = Integer.parseInt(HttpUrl.canonicalize(r10, r11, r12, "", false, false, false, true, null));     // Catch: NumberFormatException -> L9
            if (r13 <= 0) goto L8;
            if (r13 > 65535) goto L8;
            return r13;
        L8:
            return -1;
        }
    }

    static {
        HEX_DIGITS = new char[]{DeepCleanSAFEngine.DetailPath.KEY, DeepCleanSAFEngine.DetailPath.DETAIL_PATH, DeepCleanSAFEngine.DetailPath.FILENAME, DeepCleanSAFEngine.DetailPath.FILESIZE, DeepCleanSAFEngine.DetailPath.CTIME, DeepCleanSAFEngine.DetailPath.MTIME, DeepCleanSAFEngine.DetailPath.ATIME, DeepCleanSAFEngine.DetailPath.IMPORTANT, '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    HttpUrl(Builder r5) {
        this.scheme = r5.scheme;
        this.username = percentDecode(r5.encodedUsername, false);
        this.password = percentDecode(r5.encodedPassword, false);
        this.host = r5.host;
        this.port = r5.effectivePort();
        this.pathSegments = percentDecode(r5.encodedPathSegments, false);
        String r2 = null;
        if (r5.encodedQueryNamesAndValues == null) goto L5;
        List<String> r0 = percentDecode(r5.encodedQueryNamesAndValues, true);
    L6:
        this.queryNamesAndValues = r0;
        if (r5.encodedFragment == null) goto L9;
        r2 = percentDecode(r5.encodedFragment, false);
    L9:
        this.fragment = r2;
        this.url = r5.toString();
        return;
    L5:
        r0 = null;
        goto L6
    }

    public URL url() {
        return new URL(this.url);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public URI uri() {
        String r3 = newBuilder().reencodeForUri().toString();
        return new URI(r3);
    L5:
        e = move-exception;
        return URI.create(r3.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
    L9:
        throw new RuntimeException(e);
    }

    public String scheme() {
        return this.scheme;
    }

    public boolean isHttps() {
        return this.scheme.equals("https");
    }

    public String encodedUsername() {
        if (this.username.isEmpty() == false) goto L6;
        return "";
    L6:
        int r0 = this.scheme.length() + 3;
        String r1 = this.url;
        int r2 = Util.delimiterOffset(r1, r0, r1.length(), ":@");
        return this.url.substring(r0, r2);
    }

    public String username() {
        return this.username;
    }

    public String encodedPassword() {
        if (this.password.isEmpty() == false) goto L6;
        return "";
    L6:
        int r0 = this.url.indexOf(58, this.scheme.length() + 3) + 1;
        int r1 = this.url.indexOf(64);
        return this.url.substring(r0, r1);
    }

    public String password() {
        return this.password;
    }

    public String host() {
        return this.host;
    }

    public int port() {
        return this.port;
    }

    public static int defaultPort(String r1) {
        if (r1.equals(HttpHost.DEFAULT_SCHEME_NAME) == false) goto L7;
        return 80;
    L7:
        if (r1.equals("https") == false) goto L10;
        return 443;
    L10:
        return -1;
    }

    public int pathSize() {
        return this.pathSegments.size();
    }

    public String encodedPath() {
        int r0 = this.url.indexOf(47, this.scheme.length() + 3);
        String r1 = this.url;
        int r2 = Util.delimiterOffset(r1, r0, r1.length(), "?#");
        return this.url.substring(r0, r2);
    }

    static void pathSegmentsToString(StringBuilder r3, List<String> r4) {
        int r0 = r4.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3.append(IOUtils.DIR_SEPARATOR_UNIX);
        r3.append(r4.get(r1));
        r1 = r1 + 1;
        goto L3
    }

    public List<String> encodedPathSegments() {
        int r0 = this.url.indexOf(47, this.scheme.length() + 3);
        String r1 = this.url;
        int r2 = Util.delimiterOffset(r1, r0, r1.length(), "?#");
        ArrayList r3 = new ArrayList();
    L3:
        if (r0 >= r2) goto L5;
        int r4 = r0 + 1;
        int r5 = Util.delimiterOffset(this.url, r4, r2, IOUtils.DIR_SEPARATOR_UNIX);
        r3.add(this.url.substring(r4, r5));
        r0 = r5;
        goto L3
    L5:
        return r3;
    }

    public List<String> pathSegments() {
        return this.pathSegments;
    }

    @Nullable
    public String encodedQuery() {
        if (this.queryNamesAndValues != null) goto L6;
        return null;
    L6:
        int r0 = this.url.indexOf(63) + 1;
        String r1 = this.url;
        int r2 = Util.delimiterOffset(r1, r0, r1.length(), '#');
        return this.url.substring(r0, r2);
    }

    static void namesAndValuesToQueryString(StringBuilder r5, List<String> r6) {
        int r0 = r6.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        String r2 = r6.get(r1);
        String r3 = r6.get(r1 + 1);
        if (r1 <= 0) goto L7;
        r5.append(Typography.amp);
    L7:
        r5.append(r2);
        if (r3 == null) goto L10;
        r5.append('=');
        r5.append(r3);
    L10:
        r1 = r1 + 2;
        goto L3
    }

    static List<String> queryStringToNamesAndValues(String r5) {
        ArrayList r0 = new ArrayList();
        int r1 = 0;
    L4:
        if (r1 > r5.length()) goto L15;
        int r2 = r5.indexOf(38, r1);
        if (r2 != (-1)) goto L8;
        r2 = r5.length();
    L8:
        int r4 = r5.indexOf(61, r1);
        if (r4 == (-1)) goto L13;
        if (r4 > r2) goto L13;
        r0.add(r5.substring(r1, r4));
        r0.add(r5.substring(r4 + 1, r2));
    L14:
        r1 = r2 + 1;
    L13:
        r0.add(r5.substring(r1, r2));
        r0.add(null);
        goto L14
    L15:
        return r0;
    }

    @Nullable
    public String query() {
        if (this.queryNamesAndValues != null) goto L6;
        return null;
    L6:
        StringBuilder r0 = new StringBuilder();
        namesAndValuesToQueryString(r0, this.queryNamesAndValues);
        return r0.toString();
    }

    public int querySize() {
        List<String> r0 = this.queryNamesAndValues;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size() / 2;
    }

    @Nullable
    public String queryParameter(String r5) {
        List<String> r0 = this.queryNamesAndValues;
        if (r0 != null) goto L5;
        return null;
    L5:
        int r1 = r0.size();
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L12;
        if (r5.equals(this.queryNamesAndValues.get(r2)) == true) goto L10;
        r2 = r2 + 2;
        goto L6
    L10:
        return this.queryNamesAndValues.get(r2 + 1);
    L12:
        return null;
    }

    public Set<String> queryParameterNames() {
        if (this.queryNamesAndValues == null) goto L5;
        LinkedHashSet r0 = new LinkedHashSet();
        int r1 = this.queryNamesAndValues.size();
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L10;
        r0.add(this.queryNamesAndValues.get(r2));
        r2 = r2 + 2;
        goto L7
    L10:
        return Collections.unmodifiableSet(r0);
    L5:
        return Collections.emptySet();
    }

    public List<String> queryParameterValues(String r6) {
        if (this.queryNamesAndValues == null) goto L5;
        ArrayList r0 = new ArrayList();
        int r1 = this.queryNamesAndValues.size();
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L13;
        if (r6.equals(this.queryNamesAndValues.get(r2)) == false) goto L11;
        r0.add(this.queryNamesAndValues.get(r2 + 1));
    L11:
        r2 = r2 + 2;
        goto L7
    L13:
        return Collections.unmodifiableList(r0);
    L5:
        return Collections.emptyList();
    }

    public String queryParameterName(int r1) {
        List<String> r0 = this.queryNamesAndValues;
        if (r0 == null) goto L7;
        return r0.get(r1 * 2);
    L7:
        throw new IndexOutOfBoundsException();
    }

    public String queryParameterValue(int r1) {
        List<String> r0 = this.queryNamesAndValues;
        if (r0 == null) goto L7;
        return r0.get((r1 * 2) + 1);
    L7:
        throw new IndexOutOfBoundsException();
    }

    @Nullable
    public String encodedFragment() {
        if (this.fragment != null) goto L6;
        return null;
    L6:
        int r0 = this.url.indexOf(35) + 1;
        return this.url.substring(r0);
    }

    @Nullable
    public String fragment() {
        return this.fragment;
    }

    public String redact() {
        return newBuilder("/...").username("").password("").build().toString();
    }

    @Nullable
    public HttpUrl resolve(String r1) {
        Builder r0 = newBuilder(r1);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.build();
    }

    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.scheme = this.scheme;
        r0.encodedUsername = encodedUsername();
        r0.encodedPassword = encodedPassword();
        r0.host = this.host;
        if (this.port == defaultPort(this.scheme)) goto L5;
        int r1 = this.port;
    L6:
        r0.port = r1;
        r0.encodedPathSegments.clear();
        r0.encodedPathSegments.addAll(encodedPathSegments());
        r0.encodedQuery(encodedQuery());
        r0.encodedFragment = encodedFragment();
        return r0;
    L5:
        r1 = -1;
        goto L6
    }

    @Nullable
    public Builder newBuilder(String r2) {
        return new Builder().parse(this, r2);
    L4:
        return null;
    }

    @Nullable
    public static HttpUrl parse(String r0) {
        return get(r0);
    L4:
        return null;
    }

    public static HttpUrl get(String r2) {
        return new Builder().parse(null, r2).build();
    }

    @Nullable
    public static HttpUrl get(URL r0) {
        return parse(r0.toString());
    }

    @Nullable
    public static HttpUrl get(URI r0) {
        return parse(r0.toString());
    }

    public boolean equals(@Nullable Object r2) {
        if ((r2 instanceof HttpUrl) == true) goto L5;
    L7:
        return false;
    L5:
        if (((HttpUrl) r2).url.equals(this.url) == false) goto L7;
        return true;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public String toString() {
        return this.url;
    }

    @Nullable
    public String topPrivateDomain() {
        if (Util.verifyAsIpAddress(this.host) == false) goto L7;
        return null;
    L7:
        return PublicSuffixDatabase.get().getEffectiveTldPlusOne(this.host);
    }

    static String percentDecode(String r2, boolean r3) {
        return percentDecode(r2, 0, r2.length(), r3);
    }

    private List<String> percentDecode(List<String> r4, boolean r5) {
        int r3 = r4.size();
        ArrayList r0 = new ArrayList(r3);
        int r1 = 0;
    L3:
        if (r1 >= r3) goto L10;
        String r2 = r4.get(r1);
        if (r2 == null) goto L7;
        String r6 = percentDecode(r2, r5);
    L8:
        r0.add(r6);
        r1 = r1 + 1;
        goto L3
    L7:
        r6 = null;
        goto L8
    L10:
        return Collections.unmodifiableList(r0);
    }

    static String percentDecode(String r3, int r4, int r5, boolean r6) {
        int r0 = r4;
    L3:
        if (r0 >= r5) goto L14;
        char r1 = r3.charAt(r0);
        if (r1 == '%') goto L11;
        if (r1 != '+') goto L10;
        if (r6 == true) goto L11;
    L10:
        r0 = r0 + 1;
    L11:
        Buffer r2 = new Buffer();
        r2.writeUtf8(r3, r4, r0);
        percentDecode(r2, r3, r0, r5, r6);
        return r2.readUtf8();
    L14:
        return r3.substring(r4, r5);
    }

    static void percentDecode(Buffer r5, String r6, int r7, int r8, boolean r9) {
    L2:
        if (r7 >= r8) goto L17;
        int r0 = r6.codePointAt(r7);
        if (r0 != 37) goto L12;
        int r1 = r7 + 2;
        if (r1 >= r8) goto L12;
        int r2 = Util.decodeHexDigit(r6.charAt(r7 + 1));
        int r3 = Util.decodeHexDigit(r6.charAt(r1));
        if (r2 == (-1)) goto L15;
        if (r3 == (-1)) goto L15;
        r5.writeByte((r2 << 4) + r3);
        r7 = r1;
    L16:
        r7 = r7 + Character.charCount(r0);
    L15:
        r5.writeUtf8CodePoint(r0);
    L12:
        if (r0 != 43) goto L15;
        if (r9 == false) goto L15;
        r5.writeByte(32);
        goto L16
    }

    static boolean percentEncoded(String r2, int r3, int r4) {
        int r0 = r3 + 2;
        if (r0 < r4) goto L5;
    L11:
        return false;
    L5:
        if (r2.charAt(r3) != '%') goto L11;
        if (Util.decodeHexDigit(r2.charAt(r3 + 1)) == (-1)) goto L11;
        if (Util.decodeHexDigit(r2.charAt(r0)) == (-1)) goto L11;
        return true;
    }

    static String canonicalize(String r11, int r12, int r13, String r14, boolean r15, boolean r16, boolean r17, boolean r18, Charset r19) {
        int r2 = r12;
    L3:
        if (r2 >= r13) goto L28;
        int r0 = r11.codePointAt(r2);
        if (r0 < 32) goto L25;
        if (r0 == 127) goto L25;
        if (r0 < 128) goto L12;
        if (r18 == true) goto L25;
    L12:
        if (r14.indexOf(r0) != (-1)) goto L25;
        if (r0 != 37) goto L20;
        if (r15 == false) goto L25;
        if (r16 == false) goto L20;
        if (percentEncoded(r11, r2, r13) == false) goto L25;
    L20:
        if (r0 != 43) goto L23;
        if (r17 == true) goto L25;
    L23:
        r2 = r2 + Character.charCount(r0);
    L25:
        Buffer r10 = new Buffer();
        r10.writeUtf8(r11, r12, r2);
        canonicalize(r10, r11, r2, r13, r14, r15, r16, r17, r18, r19);
        return r10.readUtf8();
    L28:
        return r11.substring(r12, r13);
    }

    static void canonicalize(Buffer r6, String r7, int r8, int r9, String r10, boolean r11, boolean r12, boolean r13, boolean r14, Charset r15) {
        Buffer r0 = null;
    L3:
        if (r8 >= r9) goto L50;
        int r1 = r7.codePointAt(r8);
        if (r11 == false) goto L16;
        if (r1 == 9) goto L49;
        if (r1 == 10) goto L49;
        if (r1 == 12) goto L49;
        if (r1 != 13) goto L16;
    L49:
        r8 = r8 + Character.charCount(r1);
    L16:
        if (r1 != 43) goto L23;
        if (r13 == false) goto L23;
        if (r11 == false) goto L20;
        String r2 = "+";
    L21:
        r6.writeUtf8(r2);
        goto L49
    L20:
        r2 = "%2B";
    L23:
        if (r1 >= 32) goto L25;
    L38:
        if (r0 != null) goto L40;
        r0 = new Buffer();
    L40:
        if (r15 != null) goto L42;
    L45:
        r0.writeUtf8CodePoint(r1);
    L47:
        if (r0.exhausted() == true) goto L49;
        int r3 = r0.readByte() & UByte.MAX_VALUE;
        r6.writeByte(37);
        char[] r4 = HEX_DIGITS;
        r6.writeByte(r4[(r3 >> 4) & 15]);
        r6.writeByte(r4[r3 & 15]);
        goto L47
    L42:
        if (r15.equals(Util.UTF_8) == true) goto L45;
        r0.writeString(r7, r8, Character.charCount(r1) + r8, r15);
        goto L47
    L25:
        if (r1 == 127) goto L38;
        if (r1 < 128) goto L30;
        if (r14 == true) goto L38;
    L30:
        if (r10.indexOf(r1) != (-1)) goto L38;
        if (r1 != 37) goto L37;
        if (r11 == false) goto L38;
        if (r12 == false) goto L37;
        if (percentEncoded(r7, r8, r9) == false) goto L38;
    L37:
        r6.writeUtf8CodePoint(r1);
        goto L49
    }

    static String canonicalize(String r9, String r10, boolean r11, boolean r12, boolean r13, boolean r14, Charset r15) {
        return canonicalize(r9, 0, r9.length(), r10, r11, r12, r13, r14, r15);
    }

    static String canonicalize(String r9, String r10, boolean r11, boolean r12, boolean r13, boolean r14) {
        return canonicalize(r9, 0, r9.length(), r10, r11, r12, r13, r14, null);
    }
}
