package cz.msebera.android.httpclient.client.utils;

import com.android.settingslib.accessibility.AccessibilityUtils;
import com.bytedance.librarian.LibrarianImpl;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.conn.routing.RouteInfo;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.TextUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Stack;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes5.dex */
public class URIUtils {
    public static final EnumSet<UriFlag> DROP_FRAGMENT = null;
    public static final EnumSet<UriFlag> DROP_FRAGMENT_AND_NORMALIZE = null;
    public static final EnumSet<UriFlag> NORMALIZE = null;
    public static final EnumSet<UriFlag> NO_FLAGS = null;

    public static final enum UriFlag extends Enum<UriFlag> {
        private static final /* synthetic */ UriFlag[] $VALUES = null;
        public static final UriFlag DROP_FRAGMENT = null;
        public static final UriFlag NORMALIZE = null;

        private UriFlag(String r1, int r2) {
            super(r1, r2);
        }

        public static UriFlag valueOf(String r1) {
            return (UriFlag) Enum.valueOf(UriFlag.class, r1);
        }

        public static UriFlag[] values() {
            return (UriFlag[]) $VALUES.clone();
        }

        static {
            UriFlag r0 = new UriFlag("DROP_FRAGMENT", 0);
            DROP_FRAGMENT = r0;
            UriFlag r1 = new UriFlag("NORMALIZE", 1);
            NORMALIZE = r1;
            $VALUES = new UriFlag[]{r0, r1};
        }
    }

    static {
        NO_FLAGS = EnumSet.noneOf(UriFlag.class);
        DROP_FRAGMENT = EnumSet.of(UriFlag.DROP_FRAGMENT);
        NORMALIZE = EnumSet.of(UriFlag.NORMALIZE);
        DROP_FRAGMENT_AND_NORMALIZE = EnumSet.of(UriFlag.DROP_FRAGMENT, UriFlag.NORMALIZE);
    }

    @Deprecated
    public static URI createURI(String r1, String r2, int r3, String r4, String r5, String r6) throws URISyntaxException {
        StringBuilder r0 = new StringBuilder();
        if (r2 == null) goto L9;
        if (r1 == null) goto L6;
        r0.append(r1);
        r0.append("://");
    L6:
        r0.append(r2);
        if (r3 <= 0) goto L9;
        r0.append(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR);
        r0.append(r3);
    L9:
        if (r4 != null) goto L11;
    L12:
        r0.append(IOUtils.DIR_SEPARATOR_UNIX);
    L13:
        if (r4 == null) goto L15;
        r0.append(r4);
    L15:
        if (r5 == null) goto L17;
        r0.append('?');
        r0.append(r5);
    L17:
        if (r6 == null) goto L20;
        r0.append('#');
        r0.append(r6);
    L20:
        return new URI(r0.toString());
    L11:
        if (r4.startsWith(LibrarianImpl.Constants.SEPARATOR) == true) goto L13;
        goto L12
    }

    @Deprecated
    public static URI rewriteURI(URI r0, HttpHost r1, boolean r2) throws URISyntaxException {
        if (r2 == false) goto L4;
        EnumSet<UriFlag> r3 = DROP_FRAGMENT;
    L6:
        return rewriteURI(r0, r1, r3);
    L4:
        r3 = NO_FLAGS;
        goto L6
    }

    public static URI rewriteURI(URI r2, HttpHost r3, EnumSet<UriFlag> r4) throws URISyntaxException {
        Args.notNull(r2, "URI");
        Args.notNull(r4, "URI flags");
        if (r2.isOpaque() == false) goto L5;
        return r2;
    L5:
        URIBuilder r0 = new URIBuilder(r2);
        if (r3 == null) goto L8;
        r0.setScheme(r3.getSchemeName());
        r0.setHost(r3.getHostName());
        r0.setPort(r3.getPort());
    L10:
        if (r4.contains(UriFlag.DROP_FRAGMENT) == false) goto L13;
        r0.setFragment(null);
    L13:
        if (r4.contains(UriFlag.NORMALIZE) == false) goto L24;
        ArrayList r5 = new ArrayList(r0.getPathSegments());
        Iterator<String> r6 = r5.iterator();
    L16:
        if (r6.hasNext() == false) goto L22;
        if (r6.next().isEmpty() == false) goto L16;
        if (r6.hasNext() == false) goto L16;
        r6.remove();
        goto L16
    L22:
        r0.setPathSegments(r5);
    L24:
        if (r0.isPathEmpty() == false) goto L27;
        r0.setPathSegments(new String[]{""});
    L27:
        return r0.build();
    L8:
        r0.setScheme(null);
        r0.setHost(null);
        r0.setPort(-1);
        goto L10
    }

    public static URI rewriteURI(URI r1, HttpHost r2) throws URISyntaxException {
        return rewriteURI(r1, r2, NORMALIZE);
    }

    public static URI rewriteURI(URI r3) throws URISyntaxException {
        Args.notNull(r3, "URI");
        if (r3.isOpaque() == false) goto L5;
        return r3;
    L5:
        URIBuilder r0 = new URIBuilder(r3);
        if (r0.getUserInfo() == null) goto L9;
        r0.setUserInfo(null);
    L9:
        if (r0.getPathSegments().isEmpty() == false) goto L12;
        r0.setPathSegments(new String[]{""});
    L12:
        if (TextUtils.isEmpty(r0.getPath()) == false) goto L15;
        r0.setPath(LibrarianImpl.Constants.SEPARATOR);
    L15:
        if (r0.getHost() == null) goto L17;
        r0.setHost(r0.getHost().toLowerCase(Locale.ROOT));
    L17:
        r0.setFragment(null);
        return r0.build();
    }

    public static URI rewriteURIForRoute(URI r1, RouteInfo r2) throws URISyntaxException {
        return rewriteURIForRoute(r1, r2, true);
    }

    public static URI rewriteURIForRoute(URI r2, RouteInfo r3, boolean r4) throws URISyntaxException {
        if (r2 != null) goto L6;
        return null;
    L6:
        if (r3.getProxyHost() == null) goto L19;
        if (r3.isTunnelled() == true) goto L19;
        if (r2.isAbsolute() == true) goto L26;
        HttpHost r5 = r3.getTargetHost();
        if (r4 == false) goto L15;
        EnumSet<UriFlag> r6 = DROP_FRAGMENT_AND_NORMALIZE;
    L17:
        return rewriteURI(r2, r5, r6);
    L15:
        r6 = DROP_FRAGMENT;
        goto L17
    L26:
        return rewriteURI(r2);
    L19:
        if (r2.isAbsolute() == false) goto L25;
        if (r4 == false) goto L22;
        EnumSet<UriFlag> r7 = DROP_FRAGMENT_AND_NORMALIZE;
    L27:
        return rewriteURI(r2, null, r7);
    L22:
        r7 = DROP_FRAGMENT;
        goto L27
    L25:
        return rewriteURI(r2);
    }

    public static URI resolve(URI r0, String r1) {
        return resolve(r0, URI.create(r1));
    }

    public static URI resolve(URI r3, URI r4) {
        Args.notNull(r3, "Base URI");
        Args.notNull(r4, "Reference URI");
        String r0 = r4.toASCIIString();
        if (r0.startsWith("?") == false) goto L10;
        String r5 = r3.toASCIIString();
        int r6 = r5.indexOf(63);
        if (r6 <= (-1)) goto L8;
        r5 = r5.substring(0, r6);
    L8:
        return URI.create(r5 + r0);
    L10:
        if (r0.isEmpty() == false) goto L12;
        String r7 = r3.resolve(URI.create("#")).toASCIIString();
        URI r8 = URI.create(r7.substring(0, r7.indexOf(35)));
    L18:
        return normalizeSyntax(r8);
    L15:
        e = move-exception;
        throw new IllegalArgumentException(e);
    L12:
        r8 = r3.resolve(r4);
        goto L18
    }

    public static URI normalizeSyntax(URI r4) throws URISyntaxException {
        if (r4.isOpaque() == false) goto L5;
        return r4;
    L5:
        if (r4.getAuthority() == null) goto L41;
        URIBuilder r0 = new URIBuilder(r4);
        List<String> r5 = r0.getPathSegments();
        Stack r1 = new Stack();
        Iterator<String> r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L20;
        String r2 = r6.next();
        if (".".equals(r2) == true) goto L9;
        if ("..".equals(r2) == true) goto L16;
        r1.push(r2);
        goto L9
    L16:
        if (r1.isEmpty() == true) goto L9;
        r1.pop();
        goto L9
    L20:
        if (r1.size() != 0) goto L22;
        r1.add("");
    L22:
        r0.setPathSegments(r1);
        if (r0.getScheme() == null) goto L26;
        r0.setScheme(r0.getScheme().toLowerCase(Locale.ROOT));
    L26:
        if (r0.getHost() == null) goto L29;
        r0.setHost(r0.getHost().toLowerCase(Locale.ROOT));
    L29:
        return r0.build();
    L41:
        return r4;
    }

    public static HttpHost extractHost(URI r9) {
        if (r9 != null) goto L6;
        return null;
    L6:
        if (r9.isAbsolute() == false) goto L43;
        int r1 = r9.getPort();
        String r2 = r9.getHost();
        if (r2 != null) goto L30;
        r2 = r9.getAuthority();
        if (r2 == null) goto L30;
        int r3 = r2.indexOf(64);
        if (r3 < 0) goto L17;
        int r4 = r3 + 1;
        if (r2.length() <= r4) goto L16;
        r2 = r2.substring(r4);
        goto L17
    L16:
        r2 = null;
    L17:
        if (r2 == null) goto L30;
        int r5 = r2.indexOf(58);
        if (r5 < 0) goto L30;
        int r6 = r5 + 1;
        int r7 = r6;
        int r8 = 0;
    L22:
        if (r7 >= r2.length()) goto L26;
        if (Character.isDigit(r2.charAt(r7)) == false) goto L26;
        r8 = r8 + 1;
        r7 = r7 + 1;
    L26:
        if (r8 > 0) goto L39;
    L29:
        r2 = r2.substring(0, r5);
        goto L30
    L39:
        r1 = Integer.parseInt(r2.substring(r6, r8 + r6));     // Catch: NumberFormatException -> L35
    L30:
        String r10 = r9.getScheme();
        if (TextUtils.isBlank(r2) == true) goto L44;
        return new HttpHost(r2, r1, r10);
    L45:
        return null;
    L44:
        return null;
    L43:
        return null;
    }

    public static URI resolve(URI r3, HttpHost r4, List<URI> r5) throws URISyntaxException {
        Args.notNull(r3, "Request URI");
        if (r5 != null) goto L5;
    L12:
        URIBuilder r0 = new URIBuilder(r3);
    L14:
        if (r0.getFragment() != null) goto L16;
        r0.setFragment(r3.getFragment());
    L16:
        if (r4 == null) goto L21;
        if (r0.isAbsolute() == true) goto L21;
        r0.setScheme(r4.getSchemeName());
        r0.setHost(r4.getHostName());
        r0.setPort(r4.getPort());
    L21:
        return r0.build();
    L5:
        if (r5.isEmpty() == true) goto L12;
        r0 = new URIBuilder(r5.get(r5.size() - 1));
        String r1 = r0.getFragment();
        int r2 = r5.size() - 1;
    L8:
        if (r1 != null) goto L11;
        if (r2 < 0) goto L11;
        r1 = r5.get(r2).getFragment();
        r2 = r2 - 1;
    L11:
        r0.setFragment(r1);
        goto L14
    }

    private URIUtils() {
    }
}
