package okhttp3;

import android.icu.text.DateFormat;
import android.icu.text.PluralRules;
import com.android.settings.DataUsageFragment;
import com.android.settings.search.IndexDatabaseHelper;
import com.bytedance.librarian.LibrarianImpl;
import com.obric.oui.calendar.ODatePickerView;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: Cookie.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 &2\u00020\u0001:\u0002%&BO\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0002\u0010\u000eJ\r\u0010\u0007\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0012J\u0013\u0010\u0013\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\r\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0017J\r\u0010\r\u001a\u00020\nH\u0007¢\u0006\u0002\b\u0018J\r\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0002\b\u0019J\u000e\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cJ\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001dJ\r\u0010\b\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001eJ\r\u0010\f\u001a\u00020\nH\u0007¢\u0006\u0002\b\u001fJ\r\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\b J\b\u0010!\u001a\u00020\u0003H\u0016J\u0015\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\nH\u0000¢\u0006\u0002\b#J\r\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\b$R\u0013\u0010\u0007\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000fR\u0013\u0010\u0005\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0010R\u0013\u0010\r\u001a\u00020\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0011R\u0013\u0010\u000b\u001a\u00020\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0011R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u000fR\u0013\u0010\b\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000fR\u0013\u0010\f\u001a\u00020\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0011R\u0013\u0010\t\u001a\u00020\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0011R\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000f¨\u0006'"}, d2 = {"Lokhttp3/Cookie;", "", "name", "", "value", "expiresAt", "", ClientCookie.DOMAIN_ATTR, "path", "secure", "", "httpOnly", "persistent", "hostOnly", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ZZZZ)V", "()Ljava/lang/String;", "()J", "()Z", "-deprecated_domain", "equals", PluralRules.KEYWORD_OTHER, "-deprecated_expiresAt", "hashCode", "", "-deprecated_hostOnly", "-deprecated_httpOnly", "matches", "url", "Lokhttp3/HttpUrl;", "-deprecated_name", "-deprecated_path", "-deprecated_persistent", "-deprecated_secure", "toString", "forObsoleteRfc2965", "toString$okhttp", "-deprecated_value", "Builder", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Cookie {
    public static final Companion Companion = null;
    private static final Pattern DAY_OF_MONTH_PATTERN = null;
    private static final Pattern MONTH_PATTERN = null;
    private static final Pattern TIME_PATTERN = null;
    private static final Pattern YEAR_PATTERN = null;
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;
    private final String name;
    private final String path;
    private final boolean persistent;
    private final boolean secure;
    private final String value;

    /* JADX INFO: compiled from: Cookie.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u0018\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0000J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0000J\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lokhttp3/Cookie$Builder;", "", "()V", ClientCookie.DOMAIN_ATTR, "", "expiresAt", "", "hostOnly", "", "httpOnly", "name", "path", "persistent", "secure", "value", IndexDatabaseHelper.MetaColumns.BUILD, "Lokhttp3/Cookie;", "hostOnlyDomain", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {
        private String domain;
        private long expiresAt;
        private boolean hostOnly;
        private boolean httpOnly;
        private String name;
        private String path;
        private boolean persistent;
        private boolean secure;
        private String value;

        public Builder() {
            this.expiresAt = DatesKt.MAX_DATE;
            this.path = LibrarianImpl.Constants.SEPARATOR;
        }

        public final Builder name(String r2) {
            Intrinsics.checkNotNullParameter(r2, "name");
            if (Intrinsics.areEqual(StringsKt.trim(r2).toString(), r2) == false) goto L7;
            this.name = r2;
            return this;
        L7:
            throw new IllegalArgumentException("name is not trimmed".toString());
        }

        public final Builder value(String r2) {
            Intrinsics.checkNotNullParameter(r2, "value");
            if (Intrinsics.areEqual(StringsKt.trim(r2).toString(), r2) == false) goto L7;
            this.value = r2;
            return this;
        L7:
            throw new IllegalArgumentException("value is not trimmed".toString());
        }

        public final Builder expiresAt(long r4) {
            if (r4 > 0) goto L6;
            r4 = Long.MIN_VALUE;
        L6:
            if (r4 <= DatesKt.MAX_DATE) goto L8;
            r4 = 253402300799999L;
        L8:
            this.expiresAt = r4;
            this.persistent = true;
            return this;
        }

        public final Builder domain(String r2) {
            Intrinsics.checkNotNullParameter(r2, ClientCookie.DOMAIN_ATTR);
            return domain(r2, false);
        }

        public final Builder hostOnlyDomain(String r2) {
            Intrinsics.checkNotNullParameter(r2, ClientCookie.DOMAIN_ATTR);
            return domain(r2, true);
        }

        private final Builder domain(String r2, boolean r3) {
            String r0 = HostnamesKt.toCanonicalHost(r2);
            if (r0 == null) goto L7;
            this.domain = r0;
            this.hostOnly = r3;
            return this;
        L7:
            throw new IllegalArgumentException(Intrinsics.stringPlus("unexpected domain: ", r2));
        }

        public final Builder path(String r5) {
            Intrinsics.checkNotNullParameter(r5, "path");
            if (StringsKt.startsWith$default(r5, LibrarianImpl.Constants.SEPARATOR, false, 2, null) == false) goto L7;
            this.path = r5;
            return this;
        L7:
            throw new IllegalArgumentException("path must start with '/'".toString());
        }

        public final Builder secure() {
            this.secure = true;
            return this;
        }

        public final Builder httpOnly() {
            this.httpOnly = true;
            return this;
        }

        public final Cookie build() {
            String r1 = this.name;
            if (r1 == null) goto L15;
            String r2 = this.value;
            if (r2 == null) goto L13;
            long r3 = this.expiresAt;
            String r5 = this.domain;
            if (r5 == null) goto L11;
            return new Cookie(r1, r2, r3, r5, this.path, this.secure, this.httpOnly, this.persistent, this.hostOnly, null);
        L11:
            throw new NullPointerException("builder.domain == null");
        L13:
            throw new NullPointerException("builder.value == null");
        L15:
            throw new NullPointerException("builder.name == null");
        }
    }

    /* JADX INFO: compiled from: Cookie.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fH\u0002J'\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\fH\u0000¢\u0006\u0002\b\u001bJ\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\fH\u0007J\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00150\u001d2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u001fH\u0007J\u0010\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\fH\u0002J \u0010\"\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0002J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\fH\u0002J\u0018\u0010$\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\fH\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lokhttp3/Cookie$Companion;", "", "()V", "DAY_OF_MONTH_PATTERN", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "MONTH_PATTERN", "TIME_PATTERN", "YEAR_PATTERN", "dateCharacterOffset", "", "input", "", "pos", DataUsageFragment.INTENT_EXTRA_LIMIT, "invert", "", "domainMatch", "urlHost", ClientCookie.DOMAIN_ATTR, "parse", "Lokhttp3/Cookie;", "currentTimeMillis", "", "url", "Lokhttp3/HttpUrl;", "setCookie", "parse$okhttp", "parseAll", "", "headers", "Lokhttp3/Headers;", "parseDomain", DateFormat.SECOND, "parseExpires", "parseMaxAge", "pathMatch", "path", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public static final /* synthetic */ boolean access$domainMatch(Companion r0, String r1, String r2) {
            return r0.domainMatch(r1, r2);
        }

        public static final /* synthetic */ boolean access$pathMatch(Companion r0, HttpUrl r1, String r2) {
            return r0.pathMatch(r1, r2);
        }

        private final boolean domainMatch(String r4, String r5) {
            if (Intrinsics.areEqual(r4, r5) == false) goto L6;
            return true;
        L6:
            if (StringsKt.endsWith$default(r4, r5, false, 2, null) == false) goto L13;
            if (r4.charAt((r4.length() - r5.length()) - 1) != '.') goto L13;
            if (Util.canParseAsIpAddress(r4) == true) goto L13;
            return true;
        L13:
            return false;
        }

        private final boolean pathMatch(HttpUrl r5, String r6) {
            String r4 = r5.encodedPath();
            if (Intrinsics.areEqual(r4, r6) == false) goto L6;
            return true;
        L6:
            if (StringsKt.startsWith$default(r4, r6, false, 2, null) == true) goto L8;
        L13:
            return false;
        L8:
            if (StringsKt.endsWith$default(r6, LibrarianImpl.Constants.SEPARATOR, false, 2, null) == false) goto L11;
            return true;
        L11:
            if (r4.charAt(r6.length()) != '/') goto L13;
            return true;
        }

        @JvmStatic
        public final Cookie parse(HttpUrl r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "url");
            Intrinsics.checkNotNullParameter(r4, "setCookie");
            return parse$okhttp(System.currentTimeMillis(), r3, r4);
        }

        public final Cookie parse$okhttp(long r26, HttpUrl r28, String r29) {
            Intrinsics.checkNotNullParameter(r28, "url");
            Intrinsics.checkNotNullParameter(r29, "setCookie");
            int r9 = Util.delimiterOffset$default(r29, ';', 0, 0, 6, null);
            int r1 = Util.delimiterOffset$default(r29, '=', 0, r9, 2, null);
            if (r1 != r9) goto L5;
            return null;
        L5:
            String r11 = Util.trimSubstring$default(r29, 0, r1, 1, null);
            if (r11.length() != 0) goto L8;
            boolean r5 = true;
        L9:
            if (r5 == true) goto L87;
            if (Util.indexOfControlOrNonAscii(r11) != (-1)) goto L87;
            String r12 = Util.trimSubstring(r29, r1 + 1, r9);
            if (Util.indexOfControlOrNonAscii(r12) == (-1)) goto L16;
            return null;
        L16:
            int r10 = r9 + 1;
            int r2 = r29.length();
            String r13 = null;
            String r22 = null;
            boolean r17 = false;
            boolean r18 = false;
            boolean r19 = false;
            boolean r20 = true;
            long r15 = -1;
            long r23 = DatesKt.MAX_DATE;
        L17:
            if (r10 >= r2) goto L44;
            int r3 = Util.delimiterOffset(r29, ';', r10, r2);
            int r14 = Util.delimiterOffset(r29, '=', r10, r3);
            String r16 = Util.trimSubstring(r29, r10, r14);
            if (r14 >= r3) goto L21;
            String r110 = Util.trimSubstring(r29, r14 + 1, r3);
        L23:
            if (StringsKt.equals(r16, ClientCookie.EXPIRES_ATTR, true) == false) goto L27;
            r23 = parseExpires(r110, 0, r110.length());     // Catch: Throwable -> L88
        L29:
            r19 = true;
        L43:
            r10 = r3 + 1;
            goto L17
        L27:
            if (StringsKt.equals(r16, "max-age", true) == false) goto L31;
            r15 = parseMaxAge(r110);
            goto L29
        L31:
            if (StringsKt.equals(r16, ClientCookie.DOMAIN_ATTR, true) == false) goto L35;
            r13 = parseDomain(r110);     // Catch: Throwable -> L88
            r20 = false;
            goto L43
        L35:
            if (StringsKt.equals(r16, "path", true) == false) goto L38;
            r22 = r110;
            goto L43
        L38:
            if (StringsKt.equals(r16, "secure", true) == false) goto L41;
            r17 = true;
            goto L43
        L41:
            if (StringsKt.equals(r16, "httponly", true) == false) goto L43;
            r18 = true;
            goto L43
        L21:
            r110 = "";
            goto L23
        L44:
            long r4 = Long.MIN_VALUE;
            if (r15 != Long.MIN_VALUE) goto L48;
        L46:
            long r111 = r4;
        L61:
            String r6 = r28.host();
            if (r13 != null) goto L65;
            String r112 = r6;
            Cookie r0 = null;
        L70:
            if (r6.length() != r112.length()) goto L72;
        L74:
            String r7 = LibrarianImpl.Constants.SEPARATOR;
            String r8 = r22;
            if (r8 != null) goto L77;
        L80:
            String r21 = r28.encodedPath();
            int r24 = StringsKt.lastIndexOf$default(r21, IOUtils.DIR_SEPARATOR_UNIX, 0, false, 6, null);
            if (r24 == 0) goto L83;
            r7 = r21.substring(0, r24);
            Intrinsics.checkNotNullExpressionValue(r7, "this as java.lang.String…ing(startIndex, endIndex)");
        L83:
            String r113 = r7;
        L85:
            return new Cookie(r11, r12, r111, r112, r113, r17, r18, r19, r20, null);
        L77:
            if (StringsKt.startsWith$default(r8, LibrarianImpl.Constants.SEPARATOR, false, 2, r0) == false) goto L80;
            r113 = r8;
            goto L85
        L72:
            if (PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(r112) != null) goto L74;
            return r0;
        L65:
            if (domainMatch(r6, r13) == true) goto L68;
            return null;
        L68:
            r0 = null;
            r112 = r13;
            goto L70
        L48:
            if (r15 != (-1)) goto L50;
            r111 = r23;
            goto L61
        L50:
            if (r15 > 9223372036854775L) goto L52;
            long r114 = r15 * ((long) 1000);
        L53:
            r4 = r26 + r114;
            if (r4 < r26) goto L58;
            long r25 = DatesKt.MAX_DATE;
            if (r4 <= DatesKt.MAX_DATE) goto L46;
        L59:
            r111 = r25;
            goto L61
        L58:
            r25 = DatesKt.MAX_DATE;
            goto L59
        L52:
            r114 = Long.MAX_VALUE;
        L87:
            return null;
        L8:
            r5 = false;
            goto L9
        }

        private final long parseExpires(String r23, int r24, int r25) {
            int r4 = dateCharacterOffset(r23, r24, r25, false);
            Matcher r5 = Cookie.access$getTIME_PATTERN$cp().matcher(r23);
            int r7 = -1;
            int r8 = -1;
            int r9 = -1;
            int r10 = -1;
            int r11 = -1;
            int r12 = -1;
        L4:
            if (r4 >= r25) goto L24;
            int r15 = dateCharacterOffset(r23, r4 + 1, r25, true);
            r5.region(r4, r15);
            if (r8 == (-1)) goto L8;
        L10:
            if (r9 == (-1)) goto L12;
        L14:
            if (r10 == (-1)) goto L16;
        L18:
            if (r7 != (-1)) goto L22;
            if (r5.usePattern(Cookie.access$getYEAR_PATTERN$cp()).matches() == false) goto L22;
            String r3 = r5.group(1);
            Intrinsics.checkNotNullExpressionValue(r3, "matcher.group(1)");
            r7 = Integer.parseInt(r3);
        L22:
            r4 = dateCharacterOffset(r23, r15 + 1, r25, false);
            goto L4
        L16:
            if (r5.usePattern(Cookie.access$getMONTH_PATTERN$cp()).matches() == false) goto L18;
            String r6 = r5.group(1);
            Intrinsics.checkNotNullExpressionValue(r6, "matcher.group(1)");
            Locale r13 = Locale.US;
            Intrinsics.checkNotNullExpressionValue(r13, "US");
            String r14 = r6.toLowerCase(r13);
            Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String).toLowerCase(locale)");
            String r16 = Cookie.access$getMONTH_PATTERN$cp().pattern();
            Intrinsics.checkNotNullExpressionValue(r16, "MONTH_PATTERN.pattern()");
            r10 = StringsKt.indexOf$default(r16, r14, 0, false, 6, null) / 4;
            goto L22
        L12:
            if (r5.usePattern(Cookie.access$getDAY_OF_MONTH_PATTERN$cp()).matches() == false) goto L14;
            String r17 = r5.group(1);
            Intrinsics.checkNotNullExpressionValue(r17, "matcher.group(1)");
            r9 = Integer.parseInt(r17);
            goto L22
        L8:
            if (r5.usePattern(Cookie.access$getTIME_PATTERN$cp()).matches() == false) goto L10;
            String r18 = r5.group(1);
            Intrinsics.checkNotNullExpressionValue(r18, "matcher.group(1)");
            r8 = Integer.parseInt(r18);
            String r19 = r5.group(2);
            Intrinsics.checkNotNullExpressionValue(r19, "matcher.group(2)");
            r11 = Integer.parseInt(r19);
            String r20 = r5.group(3);
            Intrinsics.checkNotNullExpressionValue(r20, "matcher.group(3)");
            r12 = Integer.parseInt(r20);
            goto L22
        L24:
            if (70 <= r7) goto L26;
        L28:
            boolean r1 = false;
        L29:
            if (r1 == false) goto L31;
            r7 = r7 + ODatePickerView.YEAR_FROM;
        L31:
            if (r7 < 0) goto L34;
            if (r7 >= 70) goto L34;
            boolean r0 = true;
        L35:
            if (r0 == false) goto L38;
            r7 = r7 + 2000;
        L38:
            if (r7 < 1601) goto L40;
            boolean r2 = true;
        L42:
            if (r2 == false) goto L83;
            if (r10 == (-1)) goto L45;
            boolean r21 = true;
        L46:
            if (r21 == false) goto L81;
            if (1 <= r9) goto L49;
        L51:
            boolean r22 = false;
        L52:
            if (r22 == false) goto L79;
            if (r8 >= 0) goto L55;
        L57:
            boolean r26 = false;
        L58:
            if (r26 == false) goto L77;
            if (r11 < 0) goto L63;
            if (r11 >= 60) goto L63;
            boolean r27 = true;
        L64:
            if (r27 == false) goto L75;
            if (r12 < 0) goto L68;
            if (r12 >= 60) goto L68;
            boolean r28 = true;
        L69:
            if (r28 == false) goto L73;
            GregorianCalendar r29 = new GregorianCalendar(Util.UTC);
            r29.setLenient(false);
            r29.set(1, r7);
            r29.set(2, r10 - 1);
            r29.set(5, r9);
            r29.set(11, r8);
            r29.set(12, r11);
            r29.set(13, r12);
            r29.set(14, 0);
            return r29.getTimeInMillis();
        L73:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L68:
            r28 = false;
            goto L69
        L75:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L63:
            r27 = false;
            goto L64
        L77:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L55:
            if (r8 >= 24) goto L57;
            r26 = true;
            goto L58
        L79:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L49:
            if (r9 >= 32) goto L51;
            r22 = true;
            goto L52
        L81:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L45:
            r21 = false;
            goto L46
        L83:
            throw new IllegalArgumentException("Failed requirement.".toString());
        L40:
            r2 = false;
        L34:
            r0 = false;
            goto L35
        L26:
            if (r7 >= 100) goto L28;
            r1 = true;
            goto L29
        }

        private final int dateCharacterOffset(String r5, int r6, int r7, boolean r8) {
        L2:
            if (r6 >= r7) goto L37;
            int r4 = r6 + 1;
            char r0 = r5.charAt(r6);
            if (r0 >= ' ') goto L8;
            if (r0 == '\t') goto L8;
        L32:
            boolean r3 = true;
        L34:
            if (r3 == (!r8)) goto L35;
            r6 = r4;
            goto L2
        L35:
            return r6;
        L8:
            if (r0 >= 127) goto L32;
            r3 = false;
            if (r0 <= '9') goto L12;
        L14:
            boolean r1 = false;
        L15:
            if (r1 == true) goto L32;
            if (r0 <= 'z') goto L19;
        L21:
            boolean r2 = false;
        L22:
            if (r2 == true) goto L32;
            if (r0 <= 'Z') goto L26;
        L28:
            boolean r9 = false;
        L29:
            if (r9 == true) goto L32;
            if (r0 != ':') goto L34;
        L26:
            if ('A' > r0) goto L28;
            r9 = true;
            goto L29
        L19:
            if ('a' > r0) goto L21;
            r2 = true;
            goto L22
        L12:
            if ('0' > r0) goto L14;
            r1 = true;
            goto L15
        L37:
            return r7;
        }

        private final long parseMaxAge(String r6) {
            long r5 = Long.parseLong(r6);     // Catch: NumberFormatException -> L9
            if (r5 > 0) goto L8;
            return Long.MIN_VALUE;
        L8:
            return r5;
        L9:
            e = move-exception;
            Regex r3 = new Regex("-?\\d+");
            if (r3.matches(r6) == true) goto L13;
            throw e;
        L13:
            if (StringsKt.startsWith$default(r6, "-", false, 2, null) == true) goto L21;
            return Long.MAX_VALUE;
        L21:
            return Long.MIN_VALUE;
        }

        private final String parseDomain(String r4) {
            if ((!StringsKt.endsWith$default(r4, ".", false, 2, null)) == false) goto L10;
            String r3 = HostnamesKt.toCanonicalHost(StringsKt.removePrefix(r4, "."));
            if (r3 == null) goto L8;
            return r3;
        L8:
            throw new IllegalArgumentException();
        L10:
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        @JvmStatic
        public final List<Cookie> parseAll(HttpUrl r5, Headers r6) {
            Intrinsics.checkNotNullParameter(r5, "url");
            Intrinsics.checkNotNullParameter(r6, "headers");
            List<String> r7 = r6.values("Set-Cookie");
            int r0 = r7.size();
            ArrayList r1 = null;
            int r2 = 0;
        L3:
            if (r2 >= r0) goto L10;
            int r3 = r2 + 1;
            Cookie r4 = parse(r5, r7.get(r2));
            if (r4 == null) goto L6;
            if (r1 != null) goto L9;
            r1 = new ArrayList();
        L9:
            r1.add(r4);
        L6:
            r2 = r3;
            goto L3
        L10:
            if (r1 == null) goto L13;
            List<Cookie> r8 = Collections.unmodifiableList(r1);
            Intrinsics.checkNotNullExpressionValue(r8, "{\n        Collections.un…ableList(cookies)\n      }");
            return r8;
        L13:
            return CollectionsKt.emptyList();
        }
    }

    public /* synthetic */ Cookie(String r1, String r2, long r3, String r5, String r6, boolean r7, boolean r8, boolean r9, boolean r10, DefaultConstructorMarker r11) {
        this(r1, r2, r3, r5, r6, r7, r8, r9, r10);
    }

    @JvmStatic
    public static final Cookie parse(HttpUrl r1, String r2) {
        return Companion.parse(r1, r2);
    }

    @JvmStatic
    public static final List<Cookie> parseAll(HttpUrl r1, Headers r2) {
        return Companion.parseAll(r1, r2);
    }

    private Cookie(String r1, String r2, long r3, String r5, String r6, boolean r7, boolean r8, boolean r9, boolean r10) {
        this.name = r1;
        this.value = r2;
        this.expiresAt = r3;
        this.domain = r5;
        this.path = r6;
        this.secure = r7;
        this.httpOnly = r8;
        this.persistent = r9;
        this.hostOnly = r10;
    }

    public static final /* synthetic */ Pattern access$getDAY_OF_MONTH_PATTERN$cp() {
        return DAY_OF_MONTH_PATTERN;
    }

    public static final /* synthetic */ Pattern access$getMONTH_PATTERN$cp() {
        return MONTH_PATTERN;
    }

    public static final /* synthetic */ Pattern access$getTIME_PATTERN$cp() {
        return TIME_PATTERN;
    }

    public static final /* synthetic */ Pattern access$getYEAR_PATTERN$cp() {
        return YEAR_PATTERN;
    }

    public final String name() {
        return this.name;
    }

    public final String value() {
        return this.value;
    }

    public final long expiresAt() {
        return this.expiresAt;
    }

    public final String domain() {
        return this.domain;
    }

    public final String path() {
        return this.path;
    }

    public final boolean secure() {
        return this.secure;
    }

    public final boolean httpOnly() {
        return this.httpOnly;
    }

    public final boolean persistent() {
        return this.persistent;
    }

    public final boolean hostOnly() {
        return this.hostOnly;
    }

    public final boolean matches(HttpUrl r4) {
        Intrinsics.checkNotNullParameter(r4, "url");
        if (this.hostOnly == false) goto L5;
        boolean r0 = Intrinsics.areEqual(r4.host(), this.domain);
    L7:
        if (r0 == true) goto L10;
        return false;
    L10:
        if (Companion.access$pathMatch(Companion, r4, this.path) == true) goto L13;
        return false;
    L13:
        if (this.secure == true) goto L15;
    L16:
        return true;
    L15:
        if (r4.isHttps() == true) goto L16;
        return false;
    L5:
        r0 = Companion.access$domainMatch(Companion, r4.host(), this.domain);
        goto L7
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof Cookie) == false) goto L23;
        Cookie r6 = (Cookie) r5;
        if (Intrinsics.areEqual(r6.name, this.name) == false) goto L23;
        if (Intrinsics.areEqual(r6.value, this.value) == false) goto L23;
        if (r6.expiresAt != this.expiresAt) goto L23;
        if (Intrinsics.areEqual(r6.domain, this.domain) == false) goto L23;
        if (Intrinsics.areEqual(r6.path, this.path) == false) goto L23;
        if (r6.secure != this.secure) goto L23;
        if (r6.httpOnly != this.httpOnly) goto L23;
        if (r6.persistent != this.persistent) goto L23;
        if (r6.hostOnly != this.hostOnly) goto L23;
        return true;
    L23:
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((527 + this.name.hashCode()) * 31) + this.value.hashCode()) * 31) + Long.hashCode(this.expiresAt)) * 31) + this.domain.hashCode()) * 31) + this.path.hashCode()) * 31) + Boolean.hashCode(this.secure)) * 31) + Boolean.hashCode(this.httpOnly)) * 31) + Boolean.hashCode(this.persistent)) * 31) + Boolean.hashCode(this.hostOnly);
    }

    public String toString() {
        return toString$okhttp(false);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "name", imports = {}))
    /* JADX INFO: renamed from: -deprecated_name, reason: not valid java name */
    public final String m3121deprecated_name() {
        return this.name;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "value", imports = {}))
    /* JADX INFO: renamed from: -deprecated_value, reason: not valid java name */
    public final String m3125deprecated_value() {
        return this.value;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "persistent", imports = {}))
    /* JADX INFO: renamed from: -deprecated_persistent, reason: not valid java name */
    public final boolean m3123deprecated_persistent() {
        return this.persistent;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "expiresAt", imports = {}))
    /* JADX INFO: renamed from: -deprecated_expiresAt, reason: not valid java name */
    public final long m3118deprecated_expiresAt() {
        return this.expiresAt;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "hostOnly", imports = {}))
    /* JADX INFO: renamed from: -deprecated_hostOnly, reason: not valid java name */
    public final boolean m3119deprecated_hostOnly() {
        return this.hostOnly;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = ClientCookie.DOMAIN_ATTR, imports = {}))
    /* JADX INFO: renamed from: -deprecated_domain, reason: not valid java name */
    public final String m3117deprecated_domain() {
        return this.domain;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "path", imports = {}))
    /* JADX INFO: renamed from: -deprecated_path, reason: not valid java name */
    public final String m3122deprecated_path() {
        return this.path;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "httpOnly", imports = {}))
    /* JADX INFO: renamed from: -deprecated_httpOnly, reason: not valid java name */
    public final boolean m3120deprecated_httpOnly() {
        return this.httpOnly;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "secure", imports = {}))
    /* JADX INFO: renamed from: -deprecated_secure, reason: not valid java name */
    public final boolean m3124deprecated_secure() {
        return this.secure;
    }

    public final String toString$okhttp(boolean r6) {
        StringBuilder r0 = new StringBuilder();
        r0.append(name());
        r0.append('=');
        r0.append(value());
        if (persistent() == false) goto L9;
        if (expiresAt() != Long.MIN_VALUE) goto L7;
        r0.append("; max-age=0");
        goto L9
    L7:
        r0.append("; expires=").append(DatesKt.toHttpDateString(new Date(expiresAt())));
    L9:
        if (hostOnly() == true) goto L14;
        r0.append("; domain=");
        if (r6 == false) goto L13;
        r0.append(".");
    L13:
        r0.append(domain());
    L14:
        r0.append("; path=").append(path());
        if (secure() == false) goto L18;
        r0.append("; secure");
    L18:
        if (httpOnly() == false) goto L20;
        r0.append("; httponly");
    L20:
        String r5 = r0.toString();
        Intrinsics.checkNotNullExpressionValue(r5, "toString()");
        return r5;
    }

    static {
        Companion = new Companion(null);
        YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
        MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
        DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
        TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    }
}
