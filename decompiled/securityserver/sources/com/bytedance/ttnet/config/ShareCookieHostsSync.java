package com.bytedance.ttnet.config;

import a.a;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedance.ttnet.utils.TtnetUtil;
import java.net.CookieHandler;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ShareCookieHostsSync {
    private static final String TAG = "ShareCookieHostsSync";
    private static volatile ShareCookieHostsSync mInstance;

    public ShareCookieHostsSync() {
    }

    public static /* synthetic */ void access$000(ShareCookieHostsSync r0, String r1, String r2) {
        r0.doSyncShareCookies(r1, r2);
    }

    private void doSyncShareCookies(String r10, String r11) {
        CookieHandler r0 = CookieHandler.getDefault();
        if (r0 != null) goto L6;
        Logger.e(TAG, "Default CookieHandler is null.");
        return;
    L6:
        List<String> r12 = parseCookieHostListFromString(r10);
        List<String> r13 = parseCookieHostListFromString(r11);
        ArrayList r2 = new ArrayList();
        ArrayList r3 = new ArrayList();
        Iterator<String> r14 = r13.iterator();
    L8:
        if (r14.hasNext() == false) goto L20;
        String r4 = r14.next();
        if (TtnetUtil.inCookieHostList(r4, r12) == true) goto L12;
        if (Logger.debug() == false) goto L18;
        a.y("added hosts add: ", r4, TAG);
    L18:
        r3.add(r4);
        goto L8
    L12:
        if (Logger.debug() == false) goto L14;
        a.y("kept hosts add: ", r4, TAG);
    L14:
        r2.add(r4);
        goto L8
    L20:
        if (r3.isEmpty() == false) goto L23;
        return;
    L23:
        if (r2.isEmpty() == false) goto L26;
        r2 = r3;
    L26:
        Map<String, List<String>> r15 = new HashMap();
        Iterator r16 = r2.iterator();
    L28:
        if (r16.hasNext() == false) goto L38;
        String r5 = (String) r16.next();
        r15 = r0.get(new URI("https://" + r5 + LibrarianImpl.Constants.SEPARATOR), null);     // Catch: Throwable -> L36
        if (r15.size() <= 0) goto L28;
        if (Logger.debug() == false) goto L38;
        Logger.d(TAG, "Sync cookie from host: " + r5 + " sync cookies: " + r15.toString());     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        th.printStackTrace();
    L38:
        if (r15 != null) goto L40;
        return;
    L40:
        if (r15.isEmpty() == true) goto L95;
        List<String> r17 = r15.get("Cookie");
        if (r17 != null) goto L45;
    L46:
        r17 = r15.get(BaseHttpRequestInfo.KEY_COOKIE);
        if (r17 != null) goto L49;
        return;
    L49:
        if (r17.isEmpty() == true) goto L96;
    L51:
        LinkedHashMap r18 = new LinkedHashMap();
        List<String> r9 = splitWebkitCookieStringToCookieList(r17);
        Iterator r19 = r3.iterator();
    L53:
        if (r19.hasNext() == false) goto L97;
        String r1 = (String) r19.next();
        ArrayList r6 = new ArrayList();
        URI r7 = new URI("https://" + r1 + LibrarianImpl.Constants.SEPARATOR);     // Catch: Throwable -> L61
        Iterator<String> r8 = r9.iterator();     // Catch: Throwable -> L61
    L57:
        if (r8.hasNext() == false) goto L63;
        String r20 = r8.next();     // Catch: Throwable -> L61
        if (StringUtils.isEmpty(r20) == true) goto L57;
        r6.add(r20 + "; Domain=" + r1);     // Catch: Throwable -> L61
        goto L57
    L63:
        r18.put("Set-Cookie", r6);     // Catch: Throwable -> L61
        r0.put(r7, r18);     // Catch: Throwable -> L61
    L61:
        th = move-exception;
        th.printStackTrace();
        goto L53
    L97:
        return;
    L96:
        return;
    L45:
        if (r17.isEmpty() == false) goto L51;
    }

    public static ShareCookieHostsSync inst() {
        if (mInstance != null) goto L16;
        monitor-enter(ShareCookieHostsSync.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L11;
        mInstance = new ShareCookieHostsSync();     // Catch: Throwable -> L9
    L11:
        monitor-exit(ShareCookieHostsSync.class);     // Catch: Throwable -> L9
    L16:
        return mInstance;
    }

    private List<String> parseCookieHostListFromString(String r5) {
        ArrayList r4 = new ArrayList();
        if (StringUtils.isEmpty(r5) == false) goto L5;
        return r4;
    L5:
        String[] r6 = r5.split(",");
        int r0 = r6.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L11;
        String r2 = r6[r1];
        if (StringUtils.isEmpty(r2) == true) goto L10;
        r4.add(r2.trim());
    L10:
        r1 = r1 + 1;
        goto L6
    L11:
        return r4;
    }

    private List<String> splitWebkitCookieStringToCookieList(List<String> r6) {
        ArrayList r5 = new ArrayList();
        Iterator<String> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L11;
        String[] r0 = r7.next().split(";");
        int r1 = r0.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L4;
        String r3 = r0[r2];
        if (StringUtils.isEmpty(r3) == true) goto L10;
        r5.add(r3.trim());
    L10:
        r2 = r2 + 1;
        goto L6
    L11:
        return r5;
    }

    public void onShareCookieHostsChanged(final String r3, final String r4) {
        if (r4.equals(r3) == false) goto L5;
        return;
    L5:
        final String r1 = "Sync-Cookie";
        new AnonymousClass1(this, r1, r3, r4).start();
    }
}
