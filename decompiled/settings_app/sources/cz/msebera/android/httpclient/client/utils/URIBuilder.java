package cz.msebera.android.httpclient.client.utils;

import com.android.settingslib.accessibility.AccessibilityUtils;
import com.bytedance.librarian.LibrarianImpl;
import cz.msebera.android.httpclient.Consts;
import cz.msebera.android.httpclient.NameValuePair;
import cz.msebera.android.httpclient.conn.util.InetAddressUtils;
import cz.msebera.android.httpclient.message.BasicNameValuePair;
import cz.msebera.android.httpclient.util.TextUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes5.dex */
public class URIBuilder {
    private Charset charset;
    private String encodedAuthority;
    private String encodedFragment;
    private String encodedPath;
    private String encodedQuery;
    private String encodedSchemeSpecificPart;
    private String encodedUserInfo;
    private String fragment;
    private String host;
    private List<String> pathSegments;
    private int port;
    private String query;
    private List<NameValuePair> queryParams;
    private String scheme;
    private String userInfo;

    public URIBuilder() {
        this.port = -1;
    }

    public URIBuilder(String r2) throws URISyntaxException {
        digestURI(new URI(r2));
    }

    public URIBuilder(URI r1) {
        digestURI(r1);
    }

    public URIBuilder setCharset(Charset r1) {
        this.charset = r1;
        return this;
    }

    public Charset getCharset() {
        return this.charset;
    }

    private List<NameValuePair> parseQuery(String r1, Charset r2) {
        if (r1 != null) goto L4;
        return null;
    L4:
        if (r1.isEmpty() == false) goto L6;
        return null;
    L6:
        return URLEncodedUtils.parse(r1, r2);
    }

    private List<String> parsePath(String r1, Charset r2) {
        if (r1 != null) goto L4;
        return null;
    L4:
        if (r1.isEmpty() == false) goto L6;
        return null;
    L6:
        return URLEncodedUtils.parsePathSegments(r1, r2);
    }

    public URI build() throws URISyntaxException {
        return new URI(buildString());
    }

    private String buildString() {
        StringBuilder r0 = new StringBuilder();
        String r1 = this.scheme;
        if (r1 == null) goto L5;
        r0.append(r1).append(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR);
    L5:
        String r2 = this.encodedSchemeSpecificPart;
        if (r2 == null) goto L9;
        r0.append(r2);
    L48:
        if (this.encodedFragment == null) goto L51;
        r0.append("#").append(this.encodedFragment);
    L54:
        return r0.toString();
    L51:
        if (this.fragment == null) goto L54;
        r0.append("#").append(encodeUric(this.fragment));
        goto L54
    L9:
        if (this.encodedAuthority == null) goto L12;
        r0.append("//").append(this.encodedAuthority);
    L26:
        String r3 = this.encodedPath;
        if (r3 != null) goto L29;
        List<String> r4 = this.pathSegments;
        if (r4 == null) goto L37;
        r0.append(encodePath(r4));
    L37:
        if (this.encodedQuery == null) goto L39;
        r0.append("?").append(this.encodedQuery);
        goto L48
    L39:
        List<NameValuePair> r5 = this.queryParams;
        if (r5 == null) goto L45;
        if (r5.isEmpty() == true) goto L45;
        r0.append("?").append(encodeUrlForm(this.queryParams));
    L45:
        if (this.query == null) goto L48;
        r0.append("?").append(encodeUric(this.query));
        goto L48
    L29:
        if (r0.length() != 0) goto L31;
        boolean r6 = true;
    L32:
        r0.append(normalizePath(r3, r6));
        goto L37
    L31:
        r6 = false;
        goto L32
    L12:
        if (this.host == null) goto L26;
        r0.append("//");
        String r7 = this.encodedUserInfo;
        if (r7 == null) goto L16;
        r0.append(r7).append("@");
    L20:
        if (InetAddressUtils.isIPv6Address(this.host) == false) goto L22;
        r0.append("[").append(this.host).append("]");
    L24:
        if (this.port < 0) goto L26;
        r0.append(":").append(this.port);
        goto L26
    L22:
        r0.append(this.host);
        goto L24
    L16:
        String r8 = this.userInfo;
        if (r8 == null) goto L20;
        r0.append(encodeUserInfo(r8)).append("@");
        goto L20
    }

    private static String normalizePath(String r1, boolean r2) {
        if (TextUtils.isBlank(r1) == false) goto L6;
        return "";
    L6:
        if (r2 == false) goto L8;
        return r1;
    L8:
        if (r1.startsWith(LibrarianImpl.Constants.SEPARATOR) == false) goto L10;
        return r1;
    L10:
        return LibrarianImpl.Constants.SEPARATOR + r1;
    }

    private void digestURI(URI r3) {
        this.scheme = r3.getScheme();
        this.encodedSchemeSpecificPart = r3.getRawSchemeSpecificPart();
        this.encodedAuthority = r3.getRawAuthority();
        this.host = r3.getHost();
        this.port = r3.getPort();
        this.encodedUserInfo = r3.getRawUserInfo();
        this.userInfo = r3.getUserInfo();
        this.encodedPath = r3.getRawPath();
        String r0 = r3.getRawPath();
        Charset r1 = this.charset;
        if (r1 != null) goto L6;
        r1 = Consts.UTF_8;
    L6:
        this.pathSegments = parsePath(r0, r1);
        this.encodedQuery = r3.getRawQuery();
        String r2 = r3.getRawQuery();
        Charset r4 = this.charset;
        if (r4 != null) goto L10;
        r4 = Consts.UTF_8;
    L10:
        this.queryParams = parseQuery(r2, r4);
        this.encodedFragment = r3.getRawFragment();
        this.fragment = r3.getFragment();
    }

    private String encodeUserInfo(String r1) {
        Charset r0 = this.charset;
        if (r0 != null) goto L7;
        r0 = Consts.UTF_8;
    L7:
        return URLEncodedUtils.encUserInfo(r1, r0);
    }

    private String encodePath(List<String> r1) {
        Charset r0 = this.charset;
        if (r0 != null) goto L7;
        r0 = Consts.UTF_8;
    L7:
        return URLEncodedUtils.formatSegments(r1, r0);
    }

    private String encodeUrlForm(List<NameValuePair> r1) {
        Charset r0 = this.charset;
        if (r0 != null) goto L7;
        r0 = Consts.UTF_8;
    L7:
        return URLEncodedUtils.format(r1, r0);
    }

    private String encodeUric(String r1) {
        Charset r0 = this.charset;
        if (r0 != null) goto L7;
        r0 = Consts.UTF_8;
    L7:
        return URLEncodedUtils.encUric(r1, r0);
    }

    public URIBuilder setScheme(String r1) {
        this.scheme = r1;
        return this;
    }

    public URIBuilder setUserInfo(String r1) {
        this.userInfo = r1;
        this.encodedSchemeSpecificPart = null;
        this.encodedAuthority = null;
        this.encodedUserInfo = null;
        return this;
    }

    public URIBuilder setUserInfo(String r2, String r3) {
        return setUserInfo(r2 + AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR + r3);
    }

    public URIBuilder setHost(String r1) {
        this.host = r1;
        this.encodedSchemeSpecificPart = null;
        this.encodedAuthority = null;
        return this;
    }

    public URIBuilder setPort(int r1) {
        if (r1 >= 0) goto L4;
        r1 = -1;
    L4:
        this.port = r1;
        this.encodedSchemeSpecificPart = null;
        this.encodedAuthority = null;
        return this;
    }

    public URIBuilder setPath(String r1) {
        if (r1 == null) goto L4;
        List<String> r2 = URLEncodedUtils.splitPathSegments(r1);
    L6:
        return setPathSegments(r2);
    L4:
        r2 = null;
        goto L6
    }

    public URIBuilder setPathSegments(String... r3) {
        if (r3.length <= 0) goto L5;
        List<String> r4 = Arrays.asList(r3);
    L6:
        this.pathSegments = r4;
        this.encodedSchemeSpecificPart = null;
        this.encodedPath = null;
        return this;
    L5:
        r4 = null;
        goto L6
    }

    public URIBuilder setPathSegments(List<String> r3) {
        if (r3 != null) goto L5;
    L7:
        ArrayList r1 = null;
    L8:
        this.pathSegments = r1;
        this.encodedSchemeSpecificPart = null;
        this.encodedPath = null;
        return this;
    L5:
        if (r3.size() <= 0) goto L7;
        r1 = new ArrayList(r3);
        goto L8
    }

    public URIBuilder removeQuery() {
        this.queryParams = null;
        this.query = null;
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        return this;
    }

    @Deprecated
    public URIBuilder setQuery(String r2) {
        Charset r0 = this.charset;
        if (r0 != null) goto L6;
        r0 = Consts.UTF_8;
    L6:
        this.queryParams = parseQuery(r2, r0);
        this.query = null;
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        return this;
    }

    public URIBuilder setParameters(List<NameValuePair> r2) {
        List<NameValuePair> r0 = this.queryParams;
        if (r0 != null) goto L5;
        this.queryParams = new ArrayList();
    L6:
        this.queryParams.addAll(r2);
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        this.query = null;
        return this;
    L5:
        r0.clear();
        goto L6
    }

    public URIBuilder addParameters(List<NameValuePair> r2) {
        if (this.queryParams != null) goto L5;
        this.queryParams = new ArrayList();
    L5:
        this.queryParams.addAll(r2);
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        this.query = null;
        return this;
    }

    public URIBuilder setParameters(NameValuePair... r5) {
        List<NameValuePair> r0 = this.queryParams;
        if (r0 != null) goto L5;
        this.queryParams = new ArrayList();
    L6:
        int r1 = r5.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L9;
        NameValuePair r3 = r5[r2];
        this.queryParams.add(r3);
        r2 = r2 + 1;
        goto L7
    L9:
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        this.query = null;
        return this;
    L5:
        r0.clear();
        goto L6
    }

    public URIBuilder addParameter(String r3, String r4) {
        if (this.queryParams != null) goto L5;
        this.queryParams = new ArrayList();
    L5:
        this.queryParams.add(new BasicNameValuePair(r3, r4));
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        this.query = null;
        return this;
    }

    public URIBuilder setParameter(String r3, String r4) {
        if (this.queryParams != null) goto L6;
        this.queryParams = new ArrayList();
    L6:
        if (this.queryParams.isEmpty() == true) goto L13;
        Iterator<NameValuePair> r0 = this.queryParams.iterator();
    L9:
        if (r0.hasNext() == false) goto L13;
        if (r0.next().getName().equals(r3) == false) goto L9;
        r0.remove();
    L13:
        this.queryParams.add(new BasicNameValuePair(r3, r4));
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        this.query = null;
        return this;
    }

    public URIBuilder clearParameters() {
        this.queryParams = null;
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        return this;
    }

    public URIBuilder setCustomQuery(String r1) {
        this.query = r1;
        this.encodedQuery = null;
        this.encodedSchemeSpecificPart = null;
        this.queryParams = null;
        return this;
    }

    public URIBuilder setFragment(String r1) {
        this.fragment = r1;
        this.encodedFragment = null;
        return this;
    }

    public boolean isAbsolute() {
        if (this.scheme == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isOpaque() {
        return isPathEmpty();
    }

    public String getScheme() {
        return this.scheme;
    }

    public String getUserInfo() {
        return this.userInfo;
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        return this.port;
    }

    public boolean isPathEmpty() {
        List<String> r0 = this.pathSegments;
        if (r0 == null) goto L7;
        if (r0.isEmpty() == true) goto L7;
    L9:
        return false;
    L7:
        if (this.encodedPath != null) goto L9;
        return true;
    }

    public List<String> getPathSegments() {
        if (this.pathSegments == null) goto L6;
        return new ArrayList(this.pathSegments);
    L6:
        return Collections.emptyList();
    }

    public String getPath() {
        if (this.pathSegments != null) goto L6;
        return null;
    L6:
        StringBuilder r0 = new StringBuilder();
        Iterator<String> r3 = this.pathSegments.iterator();
    L8:
        if (r3.hasNext() == false) goto L11;
        String r1 = r3.next();
        r0.append(IOUtils.DIR_SEPARATOR_UNIX).append(r1);
        goto L8
    L11:
        return r0.toString();
    }

    public boolean isQueryEmpty() {
        List<NameValuePair> r0 = this.queryParams;
        if (r0 == null) goto L7;
        if (r0.isEmpty() == true) goto L7;
    L9:
        return false;
    L7:
        if (this.encodedQuery != null) goto L9;
        return true;
    }

    public List<NameValuePair> getQueryParams() {
        if (this.queryParams == null) goto L6;
        return new ArrayList(this.queryParams);
    L6:
        return Collections.emptyList();
    }

    public String getFragment() {
        return this.fragment;
    }

    public String toString() {
        return buildString();
    }
}
