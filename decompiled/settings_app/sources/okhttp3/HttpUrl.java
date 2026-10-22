package okhttp3;

import android.icu.lang.UCharacter;
import android.icu.text.PluralRules;
import com.android.settings.CustomKeyUtils;
import com.android.settings.DataUsageFragment;
import com.android.settings.search.IndexDatabaseHelper;
import com.android.settings.wifi.WifiAuthorizeUtils;
import com.android.settingslib.SliceBroadcastRelay;
import com.android.settingslib.accessibility.AccessibilityUtils;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.librarian.LibrarianImpl;
import cz.msebera.android.httpclient.cookie.ClientCookie;
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
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;
import obric.time.HttpHeadTimeFetcher;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okio.Buffer;
import okio.Utf8;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: HttpUrl.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 J2\u00020\u0001:\u0002IJBa\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\u000f\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\b!J\r\u0010\u0011\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\"J\r\u0010\u0012\u001a\u00020\u0003H\u0007¢\u0006\u0002\b#J\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0007¢\u0006\u0002\b$J\u000f\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\b%J\r\u0010\u0016\u001a\u00020\u0003H\u0007¢\u0006\u0002\b&J\u0013\u0010'\u001a\u00020\u00182\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u000f\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\b)J\b\u0010*\u001a\u00020\bH\u0016J\r\u0010\u0006\u001a\u00020\u0003H\u0007¢\u0006\u0002\b+J\u0006\u0010,\u001a\u00020-J\u0010\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020\u0003J\r\u0010\u0005\u001a\u00020\u0003H\u0007¢\u0006\u0002\b/J\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0007¢\u0006\u0002\b0J\r\u0010\u001a\u001a\u00020\bH\u0007¢\u0006\u0002\b1J\r\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\b2J\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\b3J\u0010\u00104\u001a\u0004\u0018\u00010\u00032\u0006\u00105\u001a\u00020\u0003J\u000e\u00106\u001a\u00020\u00032\u0006\u00107\u001a\u00020\bJ\u0013\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001eH\u0007¢\u0006\u0002\b8J\u0010\u00109\u001a\u0004\u0018\u00010\u00032\u0006\u00107\u001a\u00020\bJ\u0016\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\n2\u0006\u00105\u001a\u00020\u0003J\r\u0010 \u001a\u00020\bH\u0007¢\u0006\u0002\b;J\u0006\u0010<\u001a\u00020\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u00002\u0006\u0010.\u001a\u00020\u0003J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b>J\b\u0010?\u001a\u00020\u0003H\u0016J\r\u0010@\u001a\u00020AH\u0007¢\u0006\u0002\bBJ\r\u0010C\u001a\u00020DH\u0007¢\u0006\u0002\b\rJ\b\u0010E\u001a\u0004\u0018\u00010\u0003J\r\u0010B\u001a\u00020AH\u0007¢\u0006\u0002\bFJ\r\u0010\r\u001a\u00020DH\u0007¢\u0006\u0002\bGJ\r\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\bHR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u00038G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0012\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\n8G¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00038G¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0016\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0010R\u0015\u0010\f\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0010R\u0013\u0010\u0006\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0010R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0019R\u0013\u0010\u0005\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0010R\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0014R\u0011\u0010\u001a\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0007\u001a\u00020\b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u001bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u00038G¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0010R\u0018\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e8G¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001fR\u0011\u0010 \u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b \u0010\u001bR\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0010R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0010¨\u0006K"}, d2 = {"Lokhttp3/HttpUrl;", "", "scheme", "", "username", "password", WifiAuthorizeUtils.AUTO_LOGIN_HOST, ClientCookie.PORT_ATTR, "", "pathSegments", "", "queryNamesAndValues", "fragment", "url", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "encodedFragment", "()Ljava/lang/String;", "encodedPassword", "encodedPath", "encodedPathSegments", "()Ljava/util/List;", "encodedQuery", "encodedUsername", "isHttps", "", "()Z", "pathSize", "()I", IndexDatabaseHelper.SavedQueriesColums.QUERY, "queryParameterNames", "", "()Ljava/util/Set;", "querySize", "-deprecated_encodedFragment", "-deprecated_encodedPassword", "-deprecated_encodedPath", "-deprecated_encodedPathSegments", "-deprecated_encodedQuery", "-deprecated_encodedUsername", "equals", PluralRules.KEYWORD_OTHER, "-deprecated_fragment", "hashCode", "-deprecated_host", "newBuilder", "Lokhttp3/HttpUrl$Builder;", "link", "-deprecated_password", "-deprecated_pathSegments", "-deprecated_pathSize", "-deprecated_port", "-deprecated_query", "queryParameter", "name", "queryParameterName", "index", "-deprecated_queryParameterNames", "queryParameterValue", "queryParameterValues", "-deprecated_querySize", "redact", "resolve", "-deprecated_scheme", "toString", "toUri", "Ljava/net/URI;", SliceBroadcastRelay.EXTRA_URI, "toUrl", "Ljava/net/URL;", "topPrivateDomain", "-deprecated_uri", "-deprecated_url", "-deprecated_username", "Builder", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HttpUrl {
    public static final Companion Companion = null;
    public static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
    public static final String FRAGMENT_ENCODE_SET = "";
    public static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
    private static final char[] HEX_DIGITS = null;
    public static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
    public static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
    public static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
    public static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";
    public static final String QUERY_ENCODE_SET = " \"'<>#";
    public static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    private final String fragment;
    private final String host;
    private final boolean isHttps;
    private final String password;
    private final List<String> pathSegments;
    private final int port;
    private final List<String> queryNamesAndValues;
    private final String scheme;
    private final String url;
    private final String username;

    /* JADX INFO: compiled from: HttpUrl.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0017\u0018\u0000 V2\u00020\u0001:\u0001VB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u0004J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0004J\u0018\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010\u0004J\u000e\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0004J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0004J\u0018\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020.H\u0002J\u0018\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u00010\u0004J\u0006\u00102\u001a\u000203J\b\u00104\u001a\u00020\u001bH\u0002J\u0010\u0010\u0003\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0004J\u000e\u00105\u001a\u00020\u00002\u0006\u00105\u001a\u00020\u0004J\u0010\u00106\u001a\u00020\u00002\b\u00106\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0004J\u0010\u00107\u001a\u00020\u00002\b\u00107\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0004J\u0010\u00108\u001a\u00020.2\u0006\u00109\u001a\u00020\u0004H\u0002J\u0010\u0010:\u001a\u00020.2\u0006\u00109\u001a\u00020\u0004H\u0002J\u001f\u0010;\u001a\u00020\u00002\b\u0010<\u001a\u0004\u0018\u0001032\u0006\u00109\u001a\u00020\u0004H\u0000¢\u0006\u0002\b=J\u000e\u0010>\u001a\u00020\u00002\u0006\u0010>\u001a\u00020\u0004J\b\u0010?\u001a\u00020@H\u0002J\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001bJ0\u0010A\u001a\u00020@2\u0006\u00109\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\u001b2\u0006\u0010C\u001a\u00020\u001b2\u0006\u0010D\u001a\u00020.2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010E\u001a\u00020\u00002\b\u0010E\u001a\u0004\u0018\u00010\u0004J\r\u0010F\u001a\u00020\u0000H\u0000¢\u0006\u0002\bGJ\u0010\u0010H\u001a\u00020@2\u0006\u0010I\u001a\u00020\u0004H\u0002J\u000e\u0010J\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u0004J\u000e\u0010K\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u0004J\u000e\u0010L\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u001bJ \u0010N\u001a\u00020@2\u0006\u00109\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u001b2\u0006\u0010C\u001a\u00020\u001bH\u0002J\u000e\u0010 \u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0004J\u0016\u0010P\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u0004J\u0018\u0010Q\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010\u0004J\u0016\u0010R\u001a\u00020\u00002\u0006\u0010M\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u0004J\u0018\u0010S\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u00010\u0004J\b\u0010T\u001a\u00020\u0004H\u0016J\u000e\u0010U\u001a\u00020\u00002\u0006\u0010U\u001a\u00020\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\rX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000f\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\u001a\u0010\u001a\u001a\u00020\u001bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\b¨\u0006W"}, d2 = {"Lokhttp3/HttpUrl$Builder;", "", "()V", "encodedFragment", "", "getEncodedFragment$okhttp", "()Ljava/lang/String;", "setEncodedFragment$okhttp", "(Ljava/lang/String;)V", "encodedPassword", "getEncodedPassword$okhttp", "setEncodedPassword$okhttp", "encodedPathSegments", "", "getEncodedPathSegments$okhttp", "()Ljava/util/List;", "encodedQueryNamesAndValues", "getEncodedQueryNamesAndValues$okhttp", "setEncodedQueryNamesAndValues$okhttp", "(Ljava/util/List;)V", "encodedUsername", "getEncodedUsername$okhttp", "setEncodedUsername$okhttp", WifiAuthorizeUtils.AUTO_LOGIN_HOST, "getHost$okhttp", "setHost$okhttp", ClientCookie.PORT_ATTR, "", "getPort$okhttp", "()I", "setPort$okhttp", "(I)V", "scheme", "getScheme$okhttp", "setScheme$okhttp", "addEncodedPathSegment", "encodedPathSegment", "addEncodedPathSegments", "addEncodedQueryParameter", "encodedName", "encodedValue", "addPathSegment", "pathSegment", "addPathSegments", "pathSegments", "alreadyEncoded", "", "addQueryParameter", "name", "value", IndexDatabaseHelper.MetaColumns.BUILD, "Lokhttp3/HttpUrl;", "effectivePort", "encodedPath", "encodedQuery", "fragment", "isDot", "input", "isDotDot", "parse", TraceStatsConsts.STATS_BASE_MODULE, "parse$okhttp", "password", "pop", "", "push", "pos", DataUsageFragment.INTENT_EXTRA_LIMIT, "addTrailingSlash", IndexDatabaseHelper.SavedQueriesColums.QUERY, "reencodeForUri", "reencodeForUri$okhttp", "removeAllCanonicalQueryParameters", "canonicalName", "removeAllEncodedQueryParameters", "removeAllQueryParameters", "removePathSegment", "index", "resolvePath", "startPos", "setEncodedPathSegment", "setEncodedQueryParameter", "setPathSegment", "setQueryParameter", "toString", "username", "Companion", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Builder {
        public static final Companion Companion = null;
        public static final String INVALID_HOST = "Invalid URL host";
        private String encodedFragment;
        private String encodedPassword;
        private final List<String> encodedPathSegments;
        private List<String> encodedQueryNamesAndValues;
        private String encodedUsername;
        private String host;
        private int port;
        private String scheme;

        /* JADX INFO: compiled from: HttpUrl.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J \u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u001c\u0010\f\u001a\u00020\u0006*\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lokhttp3/HttpUrl$Builder$Companion;", "", "()V", "INVALID_HOST", "", "parsePort", "", "input", "pos", DataUsageFragment.INTENT_EXTRA_LIMIT, "portColonOffset", "schemeDelimiterOffset", "slashCount", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

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

            private final int schemeDelimiterOffset(String r9, int r10, int r11) {
                if ((r11 - r10) >= 2) goto L5;
                return -1;
            L5:
                char r8 = r9.charAt(r10);
                if (Intrinsics.compare(r8, 97) < 0) goto L10;
                if (Intrinsics.compare(r8, 122) > 0) goto L10;
            L14:
                int r12 = r10 + 1;
            L15:
                if (r12 >= r11) goto L64;
                int r2 = r12 + 1;
                char r4 = r9.charAt(r12);
                boolean r5 = false;
                if ('a' <= r4) goto L19;
            L21:
                boolean r6 = false;
            L22:
                if (r6 == false) goto L24;
            L23:
                boolean r7 = true;
            L30:
                if (r7 == false) goto L33;
            L31:
                boolean r13 = true;
            L37:
                if (r13 == false) goto L40;
            L38:
                boolean r14 = true;
            L43:
                if (r14 == false) goto L46;
            L44:
                boolean r15 = true;
            L49:
                if (r15 == false) goto L52;
            L50:
                r5 = true;
            L54:
                if (r5 == false) goto L56;
                r12 = r2;
                goto L15
            L56:
                if (r4 == ':') goto L58;
                return -1;
            L58:
                return r12;
            L52:
                if (r4 != '.') goto L54;
            L46:
                if (r4 == '-') goto L44;
                r15 = false;
                goto L49
            L40:
                if (r4 == '+') goto L38;
                r14 = false;
                goto L43
            L33:
                if ('0' > r4) goto L36;
                if (r4 < ':') goto L31;
            L36:
                r13 = false;
                goto L37
            L24:
                if ('A' <= r4) goto L26;
            L28:
                r7 = false;
                goto L30
            L26:
                if (r4 >= '[') goto L28;
            L19:
                if (r4 >= '{') goto L21;
                r6 = true;
                goto L22
            L64:
                return -1;
            L10:
                if (Intrinsics.compare(r8, 65) >= 0) goto L12;
                return -1;
            L12:
                if (Intrinsics.compare(r8, 90) <= 0) goto L14;
                return -1;
            }

            private final int slashCount(String r3, int r4, int r5) {
                int r2 = 0;
            L3:
                if (r4 >= r5) goto L9;
                int r0 = r4 + 1;
                char r6 = r3.charAt(r4);
                if (r6 == '\\') goto L8;
                if (r6 != '/') goto L9;
            L8:
                r2 = r2 + 1;
                r4 = r0;
            L9:
                return r2;
            }

            private final int portColonOffset(String r2, int r3, int r4) {
            L2:
                if (r3 >= r4) goto L14;
                char r1 = r2.charAt(r3);
                if (r1 != '[') goto L11;
            L5:
                r3 = r3 + 1;
                if (r3 >= r4) goto L13;
                if (r2.charAt(r3) != ']') goto L5;
            L13:
                r3 = r3 + 1;
                goto L2
            L11:
                if (r1 != ':') goto L13;
                return r3;
            L14:
                return r4;
            }

            private final int parsePort(String r13, int r14, int r15) {
                int r16 = Integer.parseInt(Companion.canonicalize$okhttp$default(HttpUrl.Companion, r13, r14, r15, "", false, false, false, false, null, UCharacter.UnicodeBlock.SIDDHAM_ID, null));     // Catch: NumberFormatException -> L12
                boolean r17 = false;
                if (1 <= r16) goto L7;
            L9:
                if (r17 == true) goto L11;
                return -1;
            L11:
                return r16;
            L7:
                if (r16 >= 65536) goto L9;
                r17 = true;
            L16:
                return -1;
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

        public final String getScheme$okhttp() {
            return this.scheme;
        }

        public final void setScheme$okhttp(String r1) {
            this.scheme = r1;
        }

        public final String getEncodedUsername$okhttp() {
            return this.encodedUsername;
        }

        public final void setEncodedUsername$okhttp(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.encodedUsername = r2;
        }

        public final String getEncodedPassword$okhttp() {
            return this.encodedPassword;
        }

        public final void setEncodedPassword$okhttp(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.encodedPassword = r2;
        }

        public final String getHost$okhttp() {
            return this.host;
        }

        public final void setHost$okhttp(String r1) {
            this.host = r1;
        }

        public final int getPort$okhttp() {
            return this.port;
        }

        public final void setPort$okhttp(int r1) {
            this.port = r1;
        }

        public final List<String> getEncodedPathSegments$okhttp() {
            return this.encodedPathSegments;
        }

        public final List<String> getEncodedQueryNamesAndValues$okhttp() {
            return this.encodedQueryNamesAndValues;
        }

        public final void setEncodedQueryNamesAndValues$okhttp(List<String> r1) {
            this.encodedQueryNamesAndValues = r1;
        }

        public final String getEncodedFragment$okhttp() {
            return this.encodedFragment;
        }

        public final void setEncodedFragment$okhttp(String r1) {
            this.encodedFragment = r1;
        }

        public final Builder scheme(String r4) {
            Intrinsics.checkNotNullParameter(r4, "scheme");
            if (StringsKt.equals(r4, "http", true) == false) goto L6;
            setScheme$okhttp("http");
        L8:
            return this;
        L6:
            if (StringsKt.equals(r4, HttpHeadTimeFetcher.FETCHER_TYPE, true) == false) goto L10;
            setScheme$okhttp(HttpHeadTimeFetcher.FETCHER_TYPE);
            goto L8
        L10:
            throw new IllegalArgumentException(Intrinsics.stringPlus("unexpected scheme: ", r4));
        }

        public final Builder username(String r14) {
            Intrinsics.checkNotNullParameter(r14, "username");
            setEncodedUsername$okhttp(Companion.canonicalize$okhttp$default(HttpUrl.Companion, r14, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, UCharacter.UnicodeBlock.TIRHUTA_ID, null));
            return this;
        }

        public final Builder encodedUsername(String r14) {
            Intrinsics.checkNotNullParameter(r14, "encodedUsername");
            setEncodedUsername$okhttp(Companion.canonicalize$okhttp$default(HttpUrl.Companion, r14, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, UCharacter.UnicodeBlock.PAHAWH_HMONG_ID, null));
            return this;
        }

        public final Builder password(String r14) {
            Intrinsics.checkNotNullParameter(r14, "password");
            setEncodedPassword$okhttp(Companion.canonicalize$okhttp$default(HttpUrl.Companion, r14, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, UCharacter.UnicodeBlock.TIRHUTA_ID, null));
            return this;
        }

        public final Builder encodedPassword(String r14) {
            Intrinsics.checkNotNullParameter(r14, "encodedPassword");
            setEncodedPassword$okhttp(Companion.canonicalize$okhttp$default(HttpUrl.Companion, r14, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, UCharacter.UnicodeBlock.PAHAWH_HMONG_ID, null));
            return this;
        }

        public final Builder host(String r9) {
            Intrinsics.checkNotNullParameter(r9, WifiAuthorizeUtils.AUTO_LOGIN_HOST);
            String r0 = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, r9, 0, 0, false, 7, null));
            if (r0 == null) goto L7;
            setHost$okhttp(r0);
            return this;
        L7:
            throw new IllegalArgumentException(Intrinsics.stringPlus("unexpected host: ", r9));
        }

        public final Builder port(int r4) {
            boolean r0 = false;
            if (1 <= r4) goto L5;
        L7:
            if (r0 == false) goto L11;
            setPort$okhttp(r4);
            return this;
        L11:
            throw new IllegalArgumentException(Intrinsics.stringPlus("unexpected port: ", Integer.valueOf(r4)).toString());
        L5:
            if (r4 >= 65536) goto L7;
            r0 = true;
            goto L7
        }

        private final int effectivePort() {
            int r0 = this.port;
            if (r0 != (-1)) goto L7;
            Companion r1 = HttpUrl.Companion;
            String r2 = this.scheme;
            Intrinsics.checkNotNull(r2);
            return r1.defaultPort(r2);
        L7:
            return r0;
        }

        public final Builder addPathSegment(String r8) {
            Intrinsics.checkNotNullParameter(r8, "pathSegment");
            push(r8, 0, r8.length(), false, false);
            return this;
        }

        public final Builder addPathSegments(String r2) {
            Intrinsics.checkNotNullParameter(r2, "pathSegments");
            return addPathSegments(r2, false);
        }

        public final Builder addEncodedPathSegment(String r8) {
            Intrinsics.checkNotNullParameter(r8, "encodedPathSegment");
            push(r8, 0, r8.length(), false, true);
            return this;
        }

        public final Builder addEncodedPathSegments(String r2) {
            Intrinsics.checkNotNullParameter(r2, "encodedPathSegments");
            return addPathSegments(r2, true);
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

        public final Builder setPathSegment(int r14, String r15) {
            Intrinsics.checkNotNullParameter(r15, "pathSegment");
            String r0 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r15, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, false, false, false, false, null, UCharacter.UnicodeBlock.TIRHUTA_ID, null);
            if (isDot(r0) == false) goto L5;
        L7:
            boolean r1 = false;
        L8:
            if (r1 == false) goto L12;
            getEncodedPathSegments$okhttp().set(r14, r0);
            return this;
        L12:
            throw new IllegalArgumentException(Intrinsics.stringPlus("unexpected path segment: ", r15).toString());
        L5:
            if (isDotDot(r0) == true) goto L7;
            r1 = true;
            goto L8
        }

        public final Builder setEncodedPathSegment(int r14, String r15) {
            Intrinsics.checkNotNullParameter(r15, "encodedPathSegment");
            String r0 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r15, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, true, false, false, false, null, UCharacter.UnicodeBlock.PAHAWH_HMONG_ID, null);
            getEncodedPathSegments$okhttp().set(r14, r0);
            if (isDot(r0) == false) goto L5;
        L7:
            boolean r16 = false;
        L8:
            if (r16 == false) goto L11;
            return this;
        L11:
            throw new IllegalArgumentException(Intrinsics.stringPlus("unexpected path segment: ", r15).toString());
        L5:
            if (isDotDot(r0) == true) goto L7;
            r16 = true;
            goto L8
        }

        public final Builder removePathSegment(int r2) {
            getEncodedPathSegments$okhttp().remove(r2);
            if (getEncodedPathSegments$okhttp().isEmpty() == false) goto L5;
            getEncodedPathSegments$okhttp().add("");
        L5:
            return this;
        }

        public final Builder encodedPath(String r5) {
            Intrinsics.checkNotNullParameter(r5, "encodedPath");
            if (StringsKt.startsWith$default(r5, LibrarianImpl.Constants.SEPARATOR, false, 2, null) == false) goto L7;
            resolvePath(r5, 0, r5.length());
            return this;
        L7:
            throw new IllegalArgumentException(Intrinsics.stringPlus("unexpected encodedPath: ", r5).toString());
        }

        public final Builder query(String r14) {
            List<String> r0 = null;
            if (r14 == null) goto L9;
            String r15 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r14, 0, 0, HttpUrl.QUERY_ENCODE_SET, false, false, true, false, null, UCharacter.UnicodeBlock.SUNDANESE_SUPPLEMENT_ID, null);
            if (r15 == null) goto L9;
            r0 = HttpUrl.Companion.toQueryNamesAndValues$okhttp(r15);
        L9:
            setEncodedQueryNamesAndValues$okhttp(r0);
            return this;
        }

        public final Builder encodedQuery(String r14) {
            List<String> r0 = null;
            if (r14 == null) goto L9;
            String r15 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r14, 0, 0, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, null, 211, null);
            if (r15 == null) goto L9;
            r0 = HttpUrl.Companion.toQueryNamesAndValues$okhttp(r15);
        L9:
            setEncodedQueryNamesAndValues$okhttp(r0);
            return this;
        }

        public final Builder addQueryParameter(String r14, String r15) {
            Intrinsics.checkNotNullParameter(r14, "name");
            if (getEncodedQueryNamesAndValues$okhttp() != null) goto L5;
            setEncodedQueryNamesAndValues$okhttp(new ArrayList());
        L5:
            List<String> r0 = getEncodedQueryNamesAndValues$okhttp();
            Intrinsics.checkNotNull(r0);
            r0.add(Companion.canonicalize$okhttp$default(HttpUrl.Companion, r14, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, UCharacter.UnicodeBlock.SUNDANESE_SUPPLEMENT_ID, null));
            List<String> r16 = getEncodedQueryNamesAndValues$okhttp();
            Intrinsics.checkNotNull(r16);
            if (r15 != null) goto L8;
            String r17 = null;
        L9:
            r16.add(r17);
            return this;
        L8:
            r17 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r15, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, UCharacter.UnicodeBlock.SUNDANESE_SUPPLEMENT_ID, null);
            goto L9
        }

        public final Builder addEncodedQueryParameter(String r14, String r15) {
            Intrinsics.checkNotNullParameter(r14, "encodedName");
            if (getEncodedQueryNamesAndValues$okhttp() != null) goto L5;
            setEncodedQueryNamesAndValues$okhttp(new ArrayList());
        L5:
            List<String> r0 = getEncodedQueryNamesAndValues$okhttp();
            Intrinsics.checkNotNull(r0);
            r0.add(Companion.canonicalize$okhttp$default(HttpUrl.Companion, r14, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null));
            List<String> r16 = getEncodedQueryNamesAndValues$okhttp();
            Intrinsics.checkNotNull(r16);
            if (r15 != null) goto L8;
            String r17 = null;
        L9:
            r16.add(r17);
            return this;
        L8:
            r17 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r15, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null);
            goto L9
        }

        public final Builder setQueryParameter(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "name");
            removeAllQueryParameters(r2);
            addQueryParameter(r2, r3);
            return this;
        }

        public final Builder setEncodedQueryParameter(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "encodedName");
            removeAllEncodedQueryParameters(r2);
            addEncodedQueryParameter(r2, r3);
            return this;
        }

        public final Builder removeAllQueryParameters(String r14) {
            Intrinsics.checkNotNullParameter(r14, "name");
            if (getEncodedQueryNamesAndValues$okhttp() != null) goto L5;
            return this;
        L5:
            removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, r14, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, UCharacter.UnicodeBlock.SUNDANESE_SUPPLEMENT_ID, null));
            return this;
        }

        public final Builder removeAllEncodedQueryParameters(String r14) {
            Intrinsics.checkNotNullParameter(r14, "encodedName");
            if (getEncodedQueryNamesAndValues$okhttp() != null) goto L5;
            return this;
        L5:
            removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, r14, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null));
            return this;
        }

        private final void removeAllCanonicalQueryParameters(String r6) {
            List<String> r0 = this.encodedQueryNamesAndValues;
            Intrinsics.checkNotNull(r0);
            int r1 = r0.size() - 2;
            int r2 = ProgressionUtilKt.getProgressionLastElement(r1, 0, -2);
            if (r2 > r1) goto L13;
        L4:
            int r3 = r1 - 2;
            List<String> r4 = this.encodedQueryNamesAndValues;
            Intrinsics.checkNotNull(r4);
            if (Intrinsics.areEqual(r6, r4.get(r1)) == false) goto L10;
            List<String> r5 = this.encodedQueryNamesAndValues;
            Intrinsics.checkNotNull(r5);
            r5.remove(r1 + 1);
            List<String> r7 = this.encodedQueryNamesAndValues;
            Intrinsics.checkNotNull(r7);
            r7.remove(r1);
            List<String> r8 = this.encodedQueryNamesAndValues;
            Intrinsics.checkNotNull(r8);
            if (r8.isEmpty() == false) goto L10;
            this.encodedQueryNamesAndValues = null;
            return;
        L10:
            if (r1 == r2) goto L16;
            r1 = r3;
            goto L4
        L16:
            return;
        }

        public final Builder fragment(String r13) {
            if (r13 != null) goto L5;
            String r14 = null;
        L6:
            setEncodedFragment$okhttp(r14);
            return this;
        L5:
            r14 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r13, 0, 0, "", false, false, false, true, null, 187, null);
            goto L6
        }

        public final Builder encodedFragment(String r13) {
            if (r13 != null) goto L5;
            String r14 = null;
        L6:
            setEncodedFragment$okhttp(r14);
            return this;
        L5:
            r14 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r13, 0, 0, "", true, false, false, true, null, 179, null);
            goto L6
        }

        public final Builder reencodeForUri$okhttp() {
            String r1 = getHost$okhttp();
            String r2 = null;
            if (r1 != null) goto L5;
            String r3 = null;
        L6:
            setHost$okhttp(r3);
            int r4 = getEncodedPathSegments$okhttp().size();
            int r5 = 0;
            int r6 = 0;
        L7:
            if (r6 >= r4) goto L9;
            getEncodedPathSegments$okhttp().set(r6, Companion.canonicalize$okhttp$default(HttpUrl.Companion, getEncodedPathSegments$okhttp().get(r6), 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, false, null, UCharacter.UnicodeBlock.GEOMETRIC_SHAPES_EXTENDED_ID, null));
            r6 = r6 + 1;
            goto L7
        L9:
            List<String> r7 = getEncodedQueryNamesAndValues$okhttp();
            if (r7 == null) goto L18;
            int r8 = r7.size();
        L12:
            if (r5 >= r8) goto L18;
            int r9 = r5 + 1;
            String r10 = r7.get(r5);
            if (r10 != null) goto L16;
            String r11 = null;
        L17:
            r7.set(r5, r11);
            r5 = r9;
            goto L12
        L16:
            r11 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r10, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, false, null, 195, null);
        L18:
            String r12 = getEncodedFragment$okhttp();
            if (r12 == null) goto L22;
            r2 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r12, 0, 0, HttpUrl.FRAGMENT_ENCODE_SET_URI, true, true, false, true, null, 163, null);
        L22:
            setEncodedFragment$okhttp(r2);
            return this;
        L5:
            r3 = new Regex("[\"<>^`{|}]").replace(r1, "");
            goto L6
        }

        public final HttpUrl build() {
            String r1 = this.scheme;
            if (r1 == null) goto L31;
            String r2 = Companion.percentDecode$okhttp$default(HttpUrl.Companion, this.encodedUsername, 0, 0, false, 7, null);
            String r3 = Companion.percentDecode$okhttp$default(HttpUrl.Companion, this.encodedPassword, 0, 0, false, 7, null);
            String r4 = this.host;
            if (r4 == null) goto L29;
            int r5 = effectivePort();
            List<String> r6 = this.encodedPathSegments;
            ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
            Iterator<T> r8 = r6.iterator();
        L8:
            if (r8.hasNext() == false) goto L10;
            r7.add(Companion.percentDecode$okhttp$default(HttpUrl.Companion, (String) r8.next(), 0, 0, false, 7, null));
            goto L8
        L10:
            ArrayList r9 = r7;
            List<String> r10 = this.encodedQueryNamesAndValues;
            if (r10 != null) goto L13;
            ArrayList r11 = null;
        L22:
            String r12 = this.encodedFragment;
            if (r12 != null) goto L25;
            String r13 = null;
        L27:
            return new HttpUrl(r1, r2, r3, r4, r5, r9, r11, r13, toString());
        L25:
            r13 = Companion.percentDecode$okhttp$default(HttpUrl.Companion, r12, 0, 0, false, 7, null);
            goto L27
        L13:
            List<String> r14 = r10;
            ArrayList r15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
            Iterator<T> r16 = r14.iterator();
        L15:
            if (r16.hasNext() == false) goto L21;
            String r17 = (String) r16.next();
            if (r17 != null) goto L19;
            String r18 = null;
        L20:
            r15.add(r18);
            goto L15
        L19:
            r18 = Companion.percentDecode$okhttp$default(HttpUrl.Companion, r17, 0, 0, true, 3, null);
            goto L20
        L21:
            r11 = r15;
            goto L22
        L29:
            throw new IllegalStateException("host == null");
        L31:
            throw new IllegalStateException("scheme == null");
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            if (getScheme$okhttp() == null) goto L5;
            r0.append(getScheme$okhttp());
            r0.append("://");
        L6:
            boolean r2 = true;
            if (getEncodedUsername$okhttp().length() <= 0) goto L9;
            boolean r1 = true;
        L11:
            if (r1 == false) goto L13;
        L17:
            r0.append(getEncodedUsername$okhttp());
            if (getEncodedPassword$okhttp().length() > 0) goto L21;
            r2 = false;
        L21:
            if (r2 == false) goto L23;
            r0.append(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR);
            r0.append(getEncodedPassword$okhttp());
        L23:
            r0.append('@');
        L25:
            if (getHost$okhttp() == null) goto L31;
            String r3 = getHost$okhttp();
            Intrinsics.checkNotNull(r3);
            if (StringsKt.contains$default(r3, AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR, false, 2, null) == false) goto L29;
            r0.append('[');
            r0.append(getHost$okhttp());
            r0.append(']');
            goto L31
        L29:
            r0.append(getHost$okhttp());
        L31:
            if (getPort$okhttp() == (-1)) goto L33;
        L34:
            int r4 = effectivePort();
            if (getScheme$okhttp() == null) goto L38;
            Companion r5 = HttpUrl.Companion;
            String r6 = getScheme$okhttp();
            Intrinsics.checkNotNull(r6);
            if (r4 != r5.defaultPort(r6)) goto L38;
        L39:
            HttpUrl.Companion.toPathString$okhttp(getEncodedPathSegments$okhttp(), r0);
            if (getEncodedQueryNamesAndValues$okhttp() == null) goto L43;
            r0.append('?');
            Companion r7 = HttpUrl.Companion;
            List<String> r8 = getEncodedQueryNamesAndValues$okhttp();
            Intrinsics.checkNotNull(r8);
            r7.toQueryString$okhttp(r8, r0);
        L43:
            if (getEncodedFragment$okhttp() == null) goto L45;
            r0.append('#');
            r0.append(getEncodedFragment$okhttp());
        L45:
            String r9 = r0.toString();
            Intrinsics.checkNotNullExpressionValue(r9, "StringBuilder().apply(builderAction).toString()");
            return r9;
        L38:
            r0.append(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR);
            r0.append(r4);
            goto L39
        L33:
            if (getScheme$okhttp() == null) goto L39;
        L13:
            if (getEncodedPassword$okhttp().length() <= 0) goto L15;
            boolean r10 = true;
        L16:
            if (r10 == false) goto L25;
        L15:
            r10 = false;
            goto L16
        L9:
            r1 = false;
            goto L11
        L5:
            r0.append("//");
            goto L6
        }

        public final Builder parse$okhttp(HttpUrl r30, String r31) {
            String r13 = r31;
            Intrinsics.checkNotNullParameter(r13, "input");
            int r1 = Util.indexOfFirstNonAsciiWhitespace$default(r13, 0, 0, 3, null);
            int r15 = Util.indexOfLastNonAsciiWhitespace$default(r13, r1, 0, 2, null);
            Companion r2 = Companion;
            int r4 = Companion.access$schemeDelimiterOffset(r2, r13, r1, r15);
            String r12 = "this as java.lang.String…ing(startIndex, endIndex)";
            boolean r11 = true;
            byte r10 = -1;
            if (r4 != (-1)) goto L5;
            if (r30 == null) goto L83;
            this.scheme = r30.scheme();
        L14:
            int r3 = Companion.access$slashCount(r2, r13, r1, r15);
            byte r9 = Utf8.REPLACEMENT_BYTE;
            byte r8 = 35;
            if (r3 >= 2) goto L26;
            if (r30 == null) goto L26;
            if (Intrinsics.areEqual(r30.scheme(), this.scheme) == false) goto L26;
            this.encodedUsername = r30.encodedUsername();
            this.encodedPassword = r30.encodedPassword();
            this.host = r30.host();
            this.port = r30.port();
            this.encodedPathSegments.clear();
            this.encodedPathSegments.addAll(r30.encodedPathSegments());
            if (r1 != r15) goto L23;
        L24:
            encodedQuery(r30.encodedQuery());
        L25:
            int r19 = r15;
        L70:
            int r14 = r19;
            int r5 = Util.delimiterOffset(r13, "?#", r1, r14);
            resolvePath(r13, r1, r5);
            if (r5 < r14) goto L73;
        L75:
            if (r5 < r14) goto L77;
        L79:
            return this;
        L77:
            if (r13.charAt(r5) != '#') goto L79;
            this.encodedFragment = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r31, r5 + 1, r14, "", true, false, false, true, null, 176, null);
            goto L79
        L73:
            if (r13.charAt(r5) != '?') goto L75;
            int r16 = Util.delimiterOffset(r13, '#', r5, r14);
            this.encodedQueryNamesAndValues = HttpUrl.Companion.toQueryNamesAndValues$okhttp(Companion.canonicalize$okhttp$default(HttpUrl.Companion, r31, r5 + 1, r16, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, null, 208, null));
            r5 = r16;
            goto L75
        L23:
            if (r13.charAt(r1) != '#') goto L25;
        L26:
            int r7 = r1 + r3;
            boolean r17 = false;
            boolean r18 = false;
        L27:
            int r6 = Util.delimiterOffset(r13, "@/\\?#", r7, r15);
            if (r6 == r15) goto L30;
            byte r20 = r13.charAt(r6);
        L31:
            if (r20 == r10) goto L53;
            if (r20 == r8) goto L53;
            if (r20 == 47) goto L53;
            if (r20 == 92) goto L53;
            if (r20 == r9) goto L53;
            if (r20 != 64) goto L27;
            if (r17 == true) goto L51;
            int r21 = Util.delimiterOffset(r13, AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR, r7, r6);
            boolean r110 = r11;
            String r111 = r12;
            String r22 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r31, r7, r21, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
            if (r18 == false) goto L46;
            r22 = this.encodedUsername + "%40" + r22;
        L46:
            this.encodedUsername = r22;
            if (r21 == r6) goto L49;
            this.encodedPassword = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r31, r21 + 1, r6, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
            boolean r112 = r110;
        L50:
            r17 = r112;
            String r23 = r111;
            r18 = r110;
            int r113 = r6;
        L52:
            r7 = r113 + 1;
            r11 = r110;
            r15 = r15;
            r12 = r23;
            r8 = 35;
            r9 = Utf8.REPLACEMENT_BYTE;
            r10 = -1;
            goto L27
        L49:
            r112 = r17;
            goto L50
        L51:
            r110 = r11;
            r23 = r12;
            r113 = r6;
            this.encodedPassword += "%40" + Companion.canonicalize$okhttp$default(HttpUrl.Companion, r31, r7, r6, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
        L53:
            boolean r114 = r11;
            String r24 = r12;
            r19 = r15;
            Companion r25 = Companion;
            int r26 = Companion.access$portColonOffset(r25, r13, r7, r6);
            int r115 = r26 + 1;
            if (r115 >= r6) goto L63;
            int r116 = r7;
            this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, r31, r7, r26, false, 4, null));
            int r27 = Companion.access$parsePort(r25, r13, r115, r6);
            this.port = r27;
            if (r27 == (-1)) goto L58;
            boolean r28 = r114;
        L59:
            if (r28 == true) goto L65;
            StringBuilder r0 = new StringBuilder("Invalid URL port: \"");
            String r29 = r13.substring(r115, r6);
            Intrinsics.checkNotNullExpressionValue(r29, r24);
            throw new IllegalArgumentException(r0.append(r29).append('\"').toString().toString());
        L65:
            if (this.host == null) goto L67;
            boolean r210 = r114;
        L68:
            if (r210 == false) goto L80;
            r1 = r6;
            goto L70
        L80:
            StringBuilder r32 = new StringBuilder("Invalid URL host: \"");
            String r33 = r13.substring(r116, r26);
            Intrinsics.checkNotNullExpressionValue(r33, r24);
            throw new IllegalArgumentException(r32.append(r33).append('\"').toString().toString());
        L67:
            r210 = false;
            goto L68
        L58:
            r28 = false;
            goto L59
        L63:
            r116 = r7;
            this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, r31, r116, r26, false, 4, null));
            Companion r34 = HttpUrl.Companion;
            String r35 = this.scheme;
            Intrinsics.checkNotNull(r35);
            this.port = r34.defaultPort(r35);
            goto L65
        L30:
            r20 = r10;
            goto L31
        L83:
            if (r31.length() <= 6) goto L86;
            r13 = Intrinsics.stringPlus(StringsKt.take(r13, 6), "...");
        L86:
            throw new IllegalArgumentException(Intrinsics.stringPlus("Expected URL scheme 'http' or 'https' but no scheme was found for ", r13));
        L5:
            if (StringsKt.startsWith(r13, "https:", r1, true) == false) goto L8;
            this.scheme = HttpHeadTimeFetcher.FETCHER_TYPE;
            r1 = r1 + 6;
            goto L14
        L8:
            if (StringsKt.startsWith(r13, "http:", r1, true) == false) goto L10;
            this.scheme = "http";
            r1 = r1 + 5;
            goto L14
        L10:
            StringBuilder r36 = new StringBuilder("Expected URL scheme 'http' or 'https' but was '");
            String r37 = r13.substring(0, r4);
            Intrinsics.checkNotNullExpressionValue(r37, "this as java.lang.String…ing(startIndex, endIndex)");
            throw new IllegalArgumentException(r36.append(r37).append('\'').toString());
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
        L12:
            if (r6 >= r13) goto L20;
            r12 = Util.delimiterOffset(r11, "/\\", r6, r13);
            if (r12 >= r13) goto L16;
            boolean r1 = true;
        L17:
            push(r11, r6, r12, r1, true);
            if (r1 == false) goto L11;
            r6 = r12 + 1;
            goto L12
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

        private final void push(String r14, int r15, int r16, boolean r17, boolean r18) {
            String r1 = Companion.canonicalize$okhttp$default(HttpUrl.Companion, r14, r15, r16, HttpUrl.PATH_SEGMENT_ENCODE_SET, r18, false, false, false, null, 240, null);
            if (isDot(r1) == false) goto L6;
            return;
        L6:
            if (isDotDot(r1) == false) goto L9;
            pop();
            return;
        L9:
            List<String> r2 = this.encodedPathSegments;
            if (r2.get(r2.size() - 1).length() != 0) goto L12;
            boolean r3 = true;
        L13:
            if (r3 == false) goto L15;
            List<String> r4 = this.encodedPathSegments;
            r4.set(r4.size() - 1, r1);
        L16:
            if (r17 == false) goto L19;
            this.encodedPathSegments.add("");
            return;
        L19:
            return;
        L15:
            this.encodedPathSegments.add(r1);
            goto L16
        L12:
            r3 = false;
            goto L13
        }

        private final boolean isDot(String r2) {
            if (Intrinsics.areEqual(r2, ".") == false) goto L5;
            return true;
        L5:
            if (StringsKt.equals(r2, "%2e", true) == true) goto L10;
            return false;
        L10:
            return true;
        }

        private final boolean isDotDot(String r2) {
            if (Intrinsics.areEqual(r2, "..") == false) goto L5;
            return true;
        L5:
            if (StringsKt.equals(r2, "%2e.", true) == false) goto L7;
            return true;
        L7:
            if (StringsKt.equals(r2, ".%2e", true) == false) goto L9;
            return true;
        L9:
            if (StringsKt.equals(r2, "%2e%2e", true) == true) goto L16;
            return false;
        L16:
            return true;
        }

        private final void pop() {
            List<String> r0 = this.encodedPathSegments;
            if (r0.remove(r0.size() - 1).length() != 0) goto L5;
            boolean r1 = true;
        L7:
            if (r1 == true) goto L9;
        L11:
            this.encodedPathSegments.add("");
            return;
        L9:
            if ((!this.encodedPathSegments.isEmpty()) == false) goto L11;
            List<String> r3 = this.encodedPathSegments;
            r3.set(r3.size() - 1, "");
            return;
        L5:
            r1 = false;
            goto L7
        }
    }

    /* JADX INFO: compiled from: HttpUrl.kt */
    @Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0004H\u0007J\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007¢\u0006\u0002\b\u0018J\u0017\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0007¢\u0006\u0002\b\u0018J\u0015\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0004H\u0007¢\u0006\u0002\b\u0018J\u0017\u0010\u001b\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0019\u001a\u00020\u0004H\u0007¢\u0006\u0002\b\u001cJa\u0010\u001d\u001a\u00020\u0004*\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00042\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\"2\b\b\u0002\u0010%\u001a\u00020\"2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'H\u0000¢\u0006\u0002\b(J\u001c\u0010)\u001a\u00020\"*\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u0012H\u0002J/\u0010*\u001a\u00020\u0004*\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u00122\b\b\u0002\u0010\u001f\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020\"H\u0000¢\u0006\u0002\b+J\u0011\u0010,\u001a\u00020\u0015*\u00020\u0004H\u0007¢\u0006\u0002\b\u0014J\u0013\u0010-\u001a\u0004\u0018\u00010\u0015*\u00020\u0017H\u0007¢\u0006\u0002\b\u0014J\u0013\u0010-\u001a\u0004\u0018\u00010\u0015*\u00020\u001aH\u0007¢\u0006\u0002\b\u0014J\u0013\u0010-\u001a\u0004\u0018\u00010\u0015*\u00020\u0004H\u0007¢\u0006\u0002\b\u001bJ#\u0010.\u001a\u00020/*\b\u0012\u0004\u0012\u00020\u0004002\n\u00101\u001a\u000602j\u0002`3H\u0000¢\u0006\u0002\b4J\u0019\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000406*\u00020\u0004H\u0000¢\u0006\u0002\b7J%\u00108\u001a\u00020/*\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004002\n\u00101\u001a\u000602j\u0002`3H\u0000¢\u0006\u0002\b9JV\u0010:\u001a\u00020/*\u00020;2\u0006\u0010<\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\"2\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J,\u0010=\u001a\u00020/*\u00020;2\u0006\u0010>\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\"H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lokhttp3/HttpUrl$Companion;", "", "()V", "FORM_ENCODE_SET", "", "FRAGMENT_ENCODE_SET", "FRAGMENT_ENCODE_SET_URI", "HEX_DIGITS", "", "PASSWORD_ENCODE_SET", "PATH_SEGMENT_ENCODE_SET", "PATH_SEGMENT_ENCODE_SET_URI", "QUERY_COMPONENT_ENCODE_SET", "QUERY_COMPONENT_ENCODE_SET_URI", "QUERY_COMPONENT_REENCODE_SET", "QUERY_ENCODE_SET", "USERNAME_ENCODE_SET", "defaultPort", "", "scheme", "get", "Lokhttp3/HttpUrl;", SliceBroadcastRelay.EXTRA_URI, "Ljava/net/URI;", "-deprecated_get", "url", "Ljava/net/URL;", "parse", "-deprecated_parse", "canonicalize", "pos", DataUsageFragment.INTENT_EXTRA_LIMIT, "encodeSet", "alreadyEncoded", "", "strict", "plusIsSpace", "unicodeAllowed", "charset", "Ljava/nio/charset/Charset;", "canonicalize$okhttp", "isPercentEncoded", "percentDecode", "percentDecode$okhttp", "toHttpUrl", "toHttpUrlOrNull", "toPathString", "", "", "out", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "toPathString$okhttp", "toQueryNamesAndValues", "", "toQueryNamesAndValues$okhttp", "toQueryString", "toQueryString$okhttp", "writeCanonicalized", "Lokio/Buffer;", "input", "writePercentDecoded", "encoded", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final int defaultPort(String r1) {
            Intrinsics.checkNotNullParameter(r1, "scheme");
            if (Intrinsics.areEqual(r1, "http") == false) goto L6;
            return 80;
        L6:
            if (Intrinsics.areEqual(r1, HttpHeadTimeFetcher.FETCHER_TYPE) == false) goto L8;
            return 443;
        L8:
            return -1;
        }

        public final void toPathString$okhttp(List<String> r4, StringBuilder r5) {
            Intrinsics.checkNotNullParameter(r4, "<this>");
            Intrinsics.checkNotNullParameter(r5, "out");
            int r3 = r4.size();
            int r0 = 0;
        L3:
            if (r0 >= r3) goto L5;
            int r1 = r0 + 1;
            r5.append(IOUtils.DIR_SEPARATOR_UNIX);
            r5.append(r4.get(r0));
            r0 = r1;
            goto L3
        }

        public final void toQueryString$okhttp(List<String> r7, StringBuilder r8) {
            Intrinsics.checkNotNullParameter(r7, "<this>");
            Intrinsics.checkNotNullParameter(r8, "out");
            IntProgression r6 = RangesKt.step(RangesKt.until(0, r7.size()), 2);
            int r0 = r6.getFirst();
            int r1 = r6.getLast();
            int r9 = r6.getStep();
            if (r9 <= 0) goto L5;
            if (r0 > r1) goto L5;
        L7:
            int r2 = r0 + r9;
            String r3 = r7.get(r0);
            String r4 = r7.get(r0 + 1);
            if (r0 <= 0) goto L10;
            r8.append(Typography.amp);
        L10:
            r8.append(r3);
            if (r4 == null) goto L13;
            r8.append('=');
            r8.append(r4);
        L13:
            if (r0 == r1) goto L20;
            r0 = r2;
            goto L7
        L20:
            return;
        L5:
            if (r9 >= 0) goto L16;
            if (r1 <= r0) goto L7;
            return;
        }

        public final List<String> toQueryNamesAndValues$okhttp(String r11) {
            Intrinsics.checkNotNullParameter(r11, "<this>");
            ArrayList r10 = new ArrayList();
            int r0 = 0;
        L4:
            if (r0 > r11.length()) goto L15;
            String r7 = r11;
            int r1 = StringsKt.indexOf$default(r7, Typography.amp, r0, false, 4, null);
            if (r1 != (-1)) goto L8;
            r1 = r11.length();
        L8:
            int r9 = r1;
            int r2 = StringsKt.indexOf$default(r7, '=', r0, false, 4, null);
            if (r2 == (-1)) goto L13;
            if (r2 > r9) goto L13;
            String r3 = r11.substring(r0, r2);
            Intrinsics.checkNotNullExpressionValue(r3, "this as java.lang.String…ing(startIndex, endIndex)");
            r10.add(r3);
            String r4 = r11.substring(r2 + 1, r9);
            Intrinsics.checkNotNullExpressionValue(r4, "this as java.lang.String…ing(startIndex, endIndex)");
            r10.add(r4);
        L14:
            r0 = r9 + 1;
        L13:
            String r5 = r11.substring(r0, r9);
            Intrinsics.checkNotNullExpressionValue(r5, "this as java.lang.String…ing(startIndex, endIndex)");
            r10.add(r5);
            r10.add(null);
            goto L14
        L15:
            return r10;
        }

        @JvmStatic
        public final HttpUrl get(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<this>");
            return new Builder().parse$okhttp(null, r2).build();
        }

        @JvmStatic
        public final HttpUrl parse(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<this>");
            return get(r2);
        L5:
            HttpUrl r3 = (HttpUrl) null;
            return null;
        }

        @JvmStatic
        public final HttpUrl get(URL r2) {
            Intrinsics.checkNotNullParameter(r2, "<this>");
            String r3 = r2.toString();
            Intrinsics.checkNotNullExpressionValue(r3, "toString()");
            return parse(r3);
        }

        @JvmStatic
        public final HttpUrl get(URI r2) {
            Intrinsics.checkNotNullParameter(r2, "<this>");
            String r3 = r2.toString();
            Intrinsics.checkNotNullExpressionValue(r3, "toString()");
            return parse(r3);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "url.toHttpUrl()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrl"}))
        /* JADX INFO: renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m3157deprecated_get(String r2) {
            Intrinsics.checkNotNullParameter(r2, "url");
            return get(r2);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "url.toHttpUrlOrNull()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}))
        /* JADX INFO: renamed from: -deprecated_parse, reason: not valid java name */
        public final HttpUrl m3160deprecated_parse(String r2) {
            Intrinsics.checkNotNullParameter(r2, "url");
            return parse(r2);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "url.toHttpUrlOrNull()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}))
        /* JADX INFO: renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m3159deprecated_get(URL r2) {
            Intrinsics.checkNotNullParameter(r2, "url");
            return get(r2);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "uri.toHttpUrlOrNull()", imports = {"okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}))
        /* JADX INFO: renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m3158deprecated_get(URI r2) {
            Intrinsics.checkNotNullParameter(r2, SliceBroadcastRelay.EXTRA_URI);
            return get(r2);
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

        public final String percentDecode$okhttp(String r8, int r9, int r10, boolean r11) {
            Intrinsics.checkNotNullParameter(r8, "<this>");
            int r4 = r9;
        L3:
            if (r4 >= r10) goto L13;
            int r0 = r4 + 1;
            char r1 = r8.charAt(r4);
            if (r1 == '%') goto L11;
            if (r1 != '+') goto L10;
            if (r11 == true) goto L11;
        L10:
            r4 = r0;
        L11:
            Buffer r2 = new Buffer();
            r2.writeUtf8(r8, r9, r4);
            writePercentDecoded(r2, r8, r4, r10, r11);
            return r2.readUtf8();
        L13:
            String r7 = r8.substring(r9, r10);
            Intrinsics.checkNotNullExpressionValue(r7, "this as java.lang.String…ing(startIndex, endIndex)");
            return r7;
        }

        private final void writePercentDecoded(Buffer r5, String r6, int r7, int r8, boolean r9) {
        L2:
            if (r7 >= r8) goto L16;
            int r4 = r6.codePointAt(r7);
            if (r4 != 37) goto L12;
            int r0 = r7 + 2;
            if (r0 >= r8) goto L12;
            int r1 = Util.parseHexDigit(r6.charAt(r7 + 1));
            int r2 = Util.parseHexDigit(r6.charAt(r0));
            if (r1 == (-1)) goto L15;
            if (r2 == (-1)) goto L15;
            r5.writeByte((r1 << 4) + r2);
            r7 = r0 + Character.charCount(r4);
        L15:
            r5.writeUtf8CodePoint(r4);
            r7 = r7 + Character.charCount(r4);
        L12:
            if (r4 != 43) goto L15;
            if (r9 == false) goto L15;
            r5.writeByte(32);
            r7 = r7 + 1;
            goto L2
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

        public final String canonicalize$okhttp(String r13, int r14, int r15, String r16, boolean r17, boolean r18, boolean r19, boolean r20, Charset r21) {
            Intrinsics.checkNotNullParameter(r13, "<this>");
            Intrinsics.checkNotNullParameter(r16, "encodeSet");
            int r3 = r14;
        L3:
            if (r3 >= r15) goto L29;
            int r0 = r13.codePointAt(r3);
            if (r0 < 32) goto L27;
            if (r0 == 127) goto L27;
            if (r0 < 128) goto L12;
            if (r20 == false) goto L27;
        L12:
            if (StringsKt.contains$default(r16, (char) r0, false, 2, null) == true) goto L27;
            if (r0 != 37) goto L22;
            if (r17 == false) goto L27;
            if (r18 == false) goto L22;
            if (isPercentEncoded(r13, r3, r15) == false) goto L27;
        L22:
            if (r0 != 43) goto L25;
            if (r19 == true) goto L27;
        L25:
            r3 = r3 + Character.charCount(r0);
        L27:
            Buffer r11 = new Buffer();
            r11.writeUtf8(r13, r14, r3);
            writeCanonicalized(r11, r13, r3, r15, r16, r17, r18, r19, r20, r21);
            return r11.readUtf8();
        L29:
            String r1 = r13.substring(r14, r15);
            Intrinsics.checkNotNullExpressionValue(r1, "this as java.lang.String…ing(startIndex, endIndex)");
            return r1;
        }

        private final void writeCanonicalized(Buffer r14, String r15, int r16, int r17, String r18, boolean r19, boolean r20, boolean r21, boolean r22, Charset r23) {
            int r5 = r16;
            Buffer r6 = null;
        L3:
            if (r5 >= r17) goto L52;
            int r7 = r15.codePointAt(r5);
            if (r19 == false) goto L16;
            if (r7 == 9) goto L51;
            if (r7 == 10) goto L51;
            if (r7 == 12) goto L51;
            if (r7 != 13) goto L16;
        L51:
            r5 = r5 + Character.charCount(r7);
        L16:
            if (r7 != 43) goto L23;
            if (r21 == false) goto L23;
            if (r19 == false) goto L20;
            String r8 = CustomKeyUtils.KEY_SEPARATE_FOR_SHOW;
        L21:
            r14.writeUtf8(r8);
            goto L51
        L20:
            r8 = "%2B";
        L23:
            if (r7 < 32) goto L40;
            if (r7 == 127) goto L40;
            if (r7 < 128) goto L30;
            if (r22 == false) goto L40;
        L30:
            if (StringsKt.contains$default(r18, (char) r7, false, 2, null) == true) goto L40;
            if (r7 != 37) goto L38;
            if (r19 == false) goto L40;
            if (r20 == false) goto L38;
            if (isPercentEncoded(r15, r5, r17) == false) goto L40;
        L38:
            r14.writeUtf8CodePoint(r7);
        L40:
            if (r6 != null) goto L42;
            r6 = new Buffer();
        L42:
            if (r23 != null) goto L44;
        L47:
            r6.writeUtf8CodePoint(r7);
        L49:
            if (r6.exhausted() == true) goto L51;
            int r10 = r6.readByte() & 255;
            r14.writeByte(37);
            r14.writeByte(HttpUrl.access$getHEX_DIGITS$cp()[(r10 >> 4) & 15]);
            r14.writeByte(HttpUrl.access$getHEX_DIGITS$cp()[r10 & 15]);
            goto L49
        L44:
            if (Intrinsics.areEqual(r23, StandardCharsets.UTF_8) == true) goto L47;
            r6.writeString(r15, r5, Character.charCount(r7) + r5, r23);
            goto L49
        }
    }

    @JvmStatic
    public static final int defaultPort(String r1) {
        return Companion.defaultPort(r1);
    }

    @JvmStatic
    public static final HttpUrl get(String r1) {
        return Companion.get(r1);
    }

    @JvmStatic
    public static final HttpUrl get(URI r1) {
        return Companion.get(r1);
    }

    @JvmStatic
    public static final HttpUrl get(URL r1) {
        return Companion.get(r1);
    }

    @JvmStatic
    public static final HttpUrl parse(String r1) {
        return Companion.parse(r1);
    }

    public HttpUrl(String r2, String r3, String r4, String r5, int r6, List<String> r7, List<String> r8, String r9, String r10) {
        Intrinsics.checkNotNullParameter(r2, "scheme");
        Intrinsics.checkNotNullParameter(r3, "username");
        Intrinsics.checkNotNullParameter(r4, "password");
        Intrinsics.checkNotNullParameter(r5, WifiAuthorizeUtils.AUTO_LOGIN_HOST);
        Intrinsics.checkNotNullParameter(r7, "pathSegments");
        Intrinsics.checkNotNullParameter(r10, "url");
        this.scheme = r2;
        this.username = r3;
        this.password = r4;
        this.host = r5;
        this.port = r6;
        this.pathSegments = r7;
        this.queryNamesAndValues = r8;
        this.fragment = r9;
        this.url = r10;
        this.isHttps = Intrinsics.areEqual(r2, HttpHeadTimeFetcher.FETCHER_TYPE);
    }

    public static final /* synthetic */ char[] access$getHEX_DIGITS$cp() {
        return HEX_DIGITS;
    }

    public final String scheme() {
        return this.scheme;
    }

    public final String username() {
        return this.username;
    }

    public final String password() {
        return this.password;
    }

    public final String host() {
        return this.host;
    }

    public final int port() {
        return this.port;
    }

    public final List<String> pathSegments() {
        return this.pathSegments;
    }

    public final String fragment() {
        return this.fragment;
    }

    public final boolean isHttps() {
        return this.isHttps;
    }

    public final URL url() {
        return new URL(this.url);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public final URI uri() {
        String r3 = newBuilder().reencodeForUri$okhttp().toString();
        return new URI(r3);
    L5:
        e = move-exception;
        Regex r1 = new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]");     // Catch: Exception -> L9
        URI r0 = URI.create(r1.replace(r3, ""));     // Catch: Exception -> L9
        Intrinsics.checkNotNullExpressionValue(r0, "{\n      // Unlikely edge…Unexpected!\n      }\n    }");
        return r0;
    L10:
        throw new RuntimeException(e);
    }

    public final String encodedUsername() {
        if (this.username.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return "";
    L9:
        int r1 = this.scheme.length() + 3;
        String r2 = this.url;
        int r3 = Util.delimiterOffset(r2, ":@", r1, r2.length());
        String r4 = this.url.substring(r1, r3);
        Intrinsics.checkNotNullExpressionValue(r4, "this as java.lang.String…ing(startIndex, endIndex)");
        return r4;
    L5:
        r0 = false;
        goto L6
    }

    public final String encodedPassword() {
        if (this.password.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return "";
    L9:
        String r8 = this.url.substring(StringsKt.indexOf$default(this.url, AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR, this.scheme.length() + 3, false, 4, null) + 1, StringsKt.indexOf$default(this.url, '@', 0, false, 6, null));
        Intrinsics.checkNotNullExpressionValue(r8, "this as java.lang.String…ing(startIndex, endIndex)");
        return r8;
    L5:
        r0 = false;
        goto L6
    }

    public final int pathSize() {
        return this.pathSegments.size();
    }

    public final String encodedPath() {
        int r0 = StringsKt.indexOf$default(this.url, IOUtils.DIR_SEPARATOR_UNIX, this.scheme.length() + 3, false, 4, null);
        String r1 = this.url;
        int r2 = Util.delimiterOffset(r1, "?#", r0, r1.length());
        String r7 = this.url.substring(r0, r2);
        Intrinsics.checkNotNullExpressionValue(r7, "this as java.lang.String…ing(startIndex, endIndex)");
        return r7;
    }

    public final List<String> encodedPathSegments() {
        int r0 = StringsKt.indexOf$default(this.url, IOUtils.DIR_SEPARATOR_UNIX, this.scheme.length() + 3, false, 4, null);
        String r1 = this.url;
        int r2 = Util.delimiterOffset(r1, "?#", r0, r1.length());
        ArrayList r3 = new ArrayList();
    L3:
        if (r0 >= r2) goto L5;
        int r4 = r0 + 1;
        int r5 = Util.delimiterOffset(this.url, IOUtils.DIR_SEPARATOR_UNIX, r4, r2);
        String r6 = this.url.substring(r4, r5);
        Intrinsics.checkNotNullExpressionValue(r6, "this as java.lang.String…ing(startIndex, endIndex)");
        r3.add(r6);
        r0 = r5;
        goto L3
    L5:
        return r3;
    }

    public final String encodedQuery() {
        if (this.queryNamesAndValues != null) goto L6;
        return null;
    L6:
        int r0 = StringsKt.indexOf$default(this.url, '?', 0, false, 6, null) + 1;
        String r1 = this.url;
        int r2 = Util.delimiterOffset(r1, '#', r0, r1.length());
        String r7 = this.url.substring(r0, r2);
        Intrinsics.checkNotNullExpressionValue(r7, "this as java.lang.String…ing(startIndex, endIndex)");
        return r7;
    }

    public final String query() {
        if (this.queryNamesAndValues != null) goto L6;
        return null;
    L6:
        StringBuilder r0 = new StringBuilder();
        Companion.toQueryString$okhttp(this.queryNamesAndValues, r0);
        return r0.toString();
    }

    public final int querySize() {
        List<String> r0 = this.queryNamesAndValues;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size() / 2;
    }

    public final String queryParameter(String r7) {
        Intrinsics.checkNotNullParameter(r7, "name");
        List<String> r0 = this.queryNamesAndValues;
        if (r0 != null) goto L5;
        return null;
    L5:
        IntProgression r1 = RangesKt.step(RangesKt.until(0, r0.size()), 2);
        int r2 = r1.getFirst();
        int r3 = r1.getLast();
        int r4 = r1.getStep();
        if (r4 <= 0) goto L8;
        if (r2 > r3) goto L8;
    L10:
        int r5 = r2 + r4;
        if (Intrinsics.areEqual(r7, this.queryNamesAndValues.get(r2)) == true) goto L13;
        if (r2 == r3) goto L17;
        r2 = r5;
    L17:
        return null;
    L13:
        return this.queryNamesAndValues.get(r2 + 1);
    L8:
        if (r4 >= 0) goto L17;
        if (r3 > r2) goto L17;
        goto L17
    }

    public final Set<String> queryParameterNames() {
        if (this.queryNamesAndValues == null) goto L5;
        LinkedHashSet r0 = new LinkedHashSet();
        IntProgression r1 = RangesKt.step(RangesKt.until(0, this.queryNamesAndValues.size()), 2);
        int r2 = r1.getFirst();
        int r3 = r1.getLast();
        int r4 = r1.getStep();
        if (r4 <= 0) goto L9;
        if (r2 > r3) goto L9;
    L11:
        int r5 = r2 + r4;
        String r6 = this.queryNamesAndValues.get(r2);
        Intrinsics.checkNotNull(r6);
        r0.add(r6);
        if (r2 == r3) goto L15;
        r2 = r5;
    L15:
        Set<String> r7 = Collections.unmodifiableSet(r0);
        Intrinsics.checkNotNullExpressionValue(r7, "unmodifiableSet(result)");
        return r7;
    L9:
        if (r4 >= 0) goto L15;
        if (r3 > r2) goto L15;
    L5:
        return SetsKt.emptySet();
    }

    public final List<String> queryParameterValues(String r8) {
        Intrinsics.checkNotNullParameter(r8, "name");
        if (this.queryNamesAndValues == null) goto L5;
        ArrayList r0 = new ArrayList();
        IntProgression r1 = RangesKt.step(RangesKt.until(0, this.queryNamesAndValues.size()), 2);
        int r2 = r1.getFirst();
        int r3 = r1.getLast();
        int r4 = r1.getStep();
        if (r4 <= 0) goto L9;
        if (r2 > r3) goto L9;
    L11:
        int r5 = r2 + r4;
        if (Intrinsics.areEqual(r8, this.queryNamesAndValues.get(r2)) == false) goto L14;
        r0.add(this.queryNamesAndValues.get(r2 + 1));
    L14:
        if (r2 == r3) goto L17;
        r2 = r5;
    L17:
        List<String> r7 = Collections.unmodifiableList(r0);
        Intrinsics.checkNotNullExpressionValue(r7, "unmodifiableList(result)");
        return r7;
    L9:
        if (r4 >= 0) goto L17;
        if (r3 > r2) goto L17;
    L5:
        return CollectionsKt.emptyList();
    }

    public final String queryParameterName(int r1) {
        List<String> r0 = this.queryNamesAndValues;
        if (r0 == null) goto L7;
        String r2 = r0.get(r1 * 2);
        Intrinsics.checkNotNull(r2);
        return r2;
    L7:
        throw new IndexOutOfBoundsException();
    }

    public final String queryParameterValue(int r1) {
        List<String> r0 = this.queryNamesAndValues;
        if (r0 == null) goto L7;
        return r0.get((r1 * 2) + 1);
    L7:
        throw new IndexOutOfBoundsException();
    }

    public final String encodedFragment() {
        if (this.fragment != null) goto L6;
        return null;
    L6:
        int r0 = StringsKt.indexOf$default(this.url, '#', 0, false, 6, null) + 1;
        String r7 = this.url.substring(r0);
        Intrinsics.checkNotNullExpressionValue(r7, "this as java.lang.String).substring(startIndex)");
        return r7;
    }

    public final String redact() {
        Builder r1 = newBuilder("/...");
        Intrinsics.checkNotNull(r1);
        return r1.username("").password("").build().toString();
    }

    public final HttpUrl resolve(String r2) {
        Intrinsics.checkNotNullParameter(r2, "link");
        Builder r1 = newBuilder(r2);
        if (r1 != null) goto L6;
        return null;
    L6:
        return r1.build();
    }

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

    public final Builder newBuilder(String r2) {
        Intrinsics.checkNotNullParameter(r2, "link");
        return new Builder().parse$okhttp(this, r2);
    L5:
        Builder r3 = (Builder) null;
        return null;
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof HttpUrl) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(((HttpUrl) r2).url, this.url) == false) goto L7;
        return true;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public String toString() {
        return this.url;
    }

    public final String topPrivateDomain() {
        if (Util.canParseAsIpAddress(this.host) == false) goto L6;
        String r0 = (String) null;
        return null;
    L6:
        return PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(this.host);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to toUrl()", replaceWith = @ReplaceWith(expression = "toUrl()", imports = {}))
    /* JADX INFO: renamed from: -deprecated_url, reason: not valid java name */
    public final URL m3155deprecated_url() {
        return url();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to toUri()", replaceWith = @ReplaceWith(expression = "toUri()", imports = {}))
    /* JADX INFO: renamed from: -deprecated_uri, reason: not valid java name */
    public final URI m3154deprecated_uri() {
        return uri();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "scheme", imports = {}))
    /* JADX INFO: renamed from: -deprecated_scheme, reason: not valid java name */
    public final String m3153deprecated_scheme() {
        return this.scheme;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedUsername", imports = {}))
    /* JADX INFO: renamed from: -deprecated_encodedUsername, reason: not valid java name */
    public final String m3143deprecated_encodedUsername() {
        return encodedUsername();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "username", imports = {}))
    /* JADX INFO: renamed from: -deprecated_username, reason: not valid java name */
    public final String m3156deprecated_username() {
        return this.username;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedPassword", imports = {}))
    /* JADX INFO: renamed from: -deprecated_encodedPassword, reason: not valid java name */
    public final String m3139deprecated_encodedPassword() {
        return encodedPassword();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "password", imports = {}))
    /* JADX INFO: renamed from: -deprecated_password, reason: not valid java name */
    public final String m3146deprecated_password() {
        return this.password;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = WifiAuthorizeUtils.AUTO_LOGIN_HOST, imports = {}))
    /* JADX INFO: renamed from: -deprecated_host, reason: not valid java name */
    public final String m3145deprecated_host() {
        return this.host;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = ClientCookie.PORT_ATTR, imports = {}))
    /* JADX INFO: renamed from: -deprecated_port, reason: not valid java name */
    public final int m3149deprecated_port() {
        return this.port;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "pathSize", imports = {}))
    /* JADX INFO: renamed from: -deprecated_pathSize, reason: not valid java name */
    public final int m3148deprecated_pathSize() {
        return pathSize();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedPath", imports = {}))
    /* JADX INFO: renamed from: -deprecated_encodedPath, reason: not valid java name */
    public final String m3140deprecated_encodedPath() {
        return encodedPath();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedPathSegments", imports = {}))
    /* JADX INFO: renamed from: -deprecated_encodedPathSegments, reason: not valid java name */
    public final List<String> m3141deprecated_encodedPathSegments() {
        return encodedPathSegments();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "pathSegments", imports = {}))
    /* JADX INFO: renamed from: -deprecated_pathSegments, reason: not valid java name */
    public final List<String> m3147deprecated_pathSegments() {
        return this.pathSegments;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedQuery", imports = {}))
    /* JADX INFO: renamed from: -deprecated_encodedQuery, reason: not valid java name */
    public final String m3142deprecated_encodedQuery() {
        return encodedQuery();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = IndexDatabaseHelper.SavedQueriesColums.QUERY, imports = {}))
    /* JADX INFO: renamed from: -deprecated_query, reason: not valid java name */
    public final String m3150deprecated_query() {
        return query();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "querySize", imports = {}))
    /* JADX INFO: renamed from: -deprecated_querySize, reason: not valid java name */
    public final int m3152deprecated_querySize() {
        return querySize();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "queryParameterNames", imports = {}))
    /* JADX INFO: renamed from: -deprecated_queryParameterNames, reason: not valid java name */
    public final Set<String> m3151deprecated_queryParameterNames() {
        return queryParameterNames();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedFragment", imports = {}))
    /* JADX INFO: renamed from: -deprecated_encodedFragment, reason: not valid java name */
    public final String m3138deprecated_encodedFragment() {
        return encodedFragment();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "fragment", imports = {}))
    /* JADX INFO: renamed from: -deprecated_fragment, reason: not valid java name */
    public final String m3144deprecated_fragment() {
        return this.fragment;
    }

    static {
        Companion = new Companion(null);
        HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }
}
