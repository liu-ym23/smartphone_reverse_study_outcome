package androidx.core.text.util;

import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.net.MailTo;
import androidx.core.util.PatternsCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class LinkifyCompat {
    private static final Comparator<LinkSpec> COMPARATOR = null;
    private static final String[] EMPTY_STRING = null;

    @RequiresApi(24)
    static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        static void addLinks(TextView r0, Pattern r1, String r2, String[] r3, Linkify.MatchFilter r4, Linkify.TransformFilter r5) {
            Linkify.addLinks(r0, r1, r2, r3, r4, r5);
        }

        @DoNotInline
        static boolean addLinks(Spannable r0, Pattern r1, String r2, String[] r3, Linkify.MatchFilter r4, Linkify.TransformFilter r5) {
            return Linkify.addLinks(r0, r1, r2, r3, r4, r5);
        }
    }

    private static class LinkSpec {
        int end;
        URLSpan frameworkAddedSpan;
        int start;
        String url;

        LinkSpec() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface LinkifyMask {
    }

    static {
        EMPTY_STRING = new String[0];
        COMPARATOR = a.f333f;
    }

    private LinkifyCompat() {
    }

    static /* synthetic */ int a(LinkSpec r2, LinkSpec r3) {
        int r0 = r2.start;
        int r1 = r3.start;
        if (r0 >= r1) goto L6;
        return -1;
    L6:
        if (r0 <= r1) goto L10;
        return 1;
    L10:
        return Integer.compare(r3.end, r2.end);
    }

    private static void addLinkMovementMethod(@NonNull TextView r1) {
        if ((r1.getMovementMethod() instanceof LinkMovementMethod) == false) goto L5;
        return;
    L5:
        if (r1.getLinksClickable() == false) goto L9;
        r1.setMovementMethod(LinkMovementMethod.getInstance());
        return;
    }

    public static void addLinks(@NonNull TextView r7, @NonNull Pattern r8, @Nullable String r9) {
        if (shouldAddLinksFallbackToFramework() == false) goto L6;
        Linkify.addLinks(r7, r8, r9);
        return;
    L6:
        addLinks(r7, r8, r9, null, null, null);
    }

    public static void addLinks(@NonNull TextView r7, @NonNull Pattern r8, @Nullable String r9, @Nullable Linkify.MatchFilter r10, @Nullable Linkify.TransformFilter r11) {
        if (shouldAddLinksFallbackToFramework() == false) goto L6;
        Linkify.addLinks(r7, r8, r9, r10, r11);
        return;
    L6:
        addLinks(r7, r8, r9, null, r10, r11);
    }

    public static void addLinks(@NonNull TextView r7, @NonNull Pattern r8, @Nullable String r9, @Nullable String[] r10, @Nullable Linkify.MatchFilter r11, @Nullable Linkify.TransformFilter r12) {
        if (shouldAddLinksFallbackToFramework() == false) goto L6;
        Api24Impl.addLinks(r7, r8, r9, r10, r11, r12);
        return;
    L6:
        SpannableString r0 = SpannableString.valueOf(r7.getText());
        if (addLinks(r0, r8, r9, r10, r11, r12) == false) goto L10;
        r7.setText(r0);
        addLinkMovementMethod(r7);
        return;
    }

    public static boolean addLinks(@NonNull Spannable r10, int r11) {
        if (shouldAddLinksFallbackToFramework() == false) goto L7;
        return Linkify.addLinks(r10, r11);
    L7:
        if (r11 != 0) goto L9;
        return false;
    L9:
        URLSpan[] r1 = (URLSpan[]) r10.getSpans(0, r10.length(), URLSpan.class);
        int r2 = r1.length - 1;
    L10:
        if (r2 < 0) goto L13;
        r10.removeSpan(r1[r2]);
        r2 = r2 - 1;
        goto L10
    L13:
        if ((r11 & 4) == 0) goto L15;
        Linkify.addLinks(r10, 4);
    L15:
        ArrayList r3 = new ArrayList();
        if ((r11 & 1) == 0) goto L19;
        gatherLinks(r3, r10, PatternsCompat.AUTOLINK_WEB_URL, new String[]{"http://", "https://", "rtsp://"}, Linkify.sUrlMatchFilter, null);
    L19:
        if ((r11 & 2) == 0) goto L22;
        gatherLinks(r3, r10, PatternsCompat.AUTOLINK_EMAIL_ADDRESS, new String[]{MailTo.MAILTO_SCHEME}, null, null);
    L22:
        if ((r11 & 8) == 0) goto L24;
        gatherMapLinks(r3, r10);
    L24:
        pruneOverlaps(r3, r10);
        if (r3.size() != 0) goto L27;
        return false;
    L27:
        Iterator r12 = r3.iterator();
    L29:
        if (r12.hasNext() == false) goto L33;
        LinkSpec r0 = (LinkSpec) r12.next();
        if (r0.frameworkAddedSpan != null) goto L29;
        applyLink(r0.url, r0.start, r0.end, r10);
        goto L29
    L33:
        return true;
    }

    public static boolean addLinks(@NonNull Spannable r6, @NonNull Pattern r7, @Nullable String r8) {
        if (shouldAddLinksFallbackToFramework() == false) goto L7;
        return Linkify.addLinks(r6, r7, r8);
    L7:
        return addLinks(r6, r7, r8, null, null, null);
    }

    public static boolean addLinks(@NonNull Spannable r6, @NonNull Pattern r7, @Nullable String r8, @Nullable Linkify.MatchFilter r9, @Nullable Linkify.TransformFilter r10) {
        if (shouldAddLinksFallbackToFramework() == false) goto L7;
        return Linkify.addLinks(r6, r7, r8, r9, r10);
    L7:
        return addLinks(r6, r7, r8, null, r9, r10);
    }

    public static boolean addLinks(@NonNull Spannable r6, @NonNull Pattern r7, @Nullable String r8, @Nullable String[] r9, @Nullable Linkify.MatchFilter r10, @Nullable Linkify.TransformFilter r11) {
        if (shouldAddLinksFallbackToFramework() == false) goto L7;
        return Api24Impl.addLinks(r6, r7, r8, r9, r10, r11);
    L7:
        if (r8 != null) goto L10;
        r8 = "";
    L10:
        if (r9 != null) goto L12;
    L13:
        r9 = EMPTY_STRING;
    L14:
        String[] r2 = new String[r9.length + 1];
        r2[0] = r8.toLowerCase(Locale.ROOT);
        int r12 = 0;
    L16:
        if (r12 >= r9.length) goto L22;
        String r4 = r9[r12];
        r12 = r12 + 1;
        if (r4 != null) goto L20;
        String r5 = "";
    L21:
        r2[r12] = r5;
        goto L16
    L20:
        r5 = r4.toLowerCase(Locale.ROOT);
        goto L21
    L22:
        Matcher r13 = r7.matcher(r6);
        boolean r14 = false;
    L24:
        if (r13.find() == false) goto L32;
        int r15 = r13.start();
        int r0 = r13.end();
        String r16 = r13.group(0);
        if (r10 == null) goto L28;
        boolean r17 = r10.acceptMatch(r6, r15, r0);
    L29:
        if (r17 == false) goto L24;
        if (r16 == null) goto L24;
        applyLink(makeUrl(r16, r2, r13, r11), r15, r0, r6);
        r14 = true;
        goto L24
    L28:
        r17 = true;
        goto L29
    L32:
        return r14;
    L12:
        if (r9.length >= 1) goto L14;
        goto L13
    }

    public static boolean addLinks(@NonNull TextView r4, int r5) {
        if (shouldAddLinksFallbackToFramework() == false) goto L7;
        return Linkify.addLinks(r4, r5);
    L7:
        if (r5 != 0) goto L9;
        return false;
    L9:
        CharSequence r1 = r4.getText();
        if ((r1 instanceof Spannable) == true) goto L12;
        SpannableString r2 = SpannableString.valueOf(r1);
        if (addLinks(r2, r5) == false) goto L19;
        addLinkMovementMethod(r4);
        r4.setText(r2);
        return true;
    L19:
        return false;
    L12:
        if (addLinks((Spannable) r1, r5) == false) goto L19;
        addLinkMovementMethod(r4);
        return true;
    }

    private static void applyLink(String r1, int r2, int r3, Spannable r4) {
        r4.setSpan(new URLSpan(r1), r2, r3, 33);
    }

    private static String findAddress(String r2) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return WebView.findAddress(r2);
    L7:
        return FindAddress.findAddress(r2);
    }

    private static void gatherLinks(ArrayList<LinkSpec> r4, Spannable r5, Pattern r6, String[] r7, Linkify.MatchFilter r8, Linkify.TransformFilter r9) {
        Matcher r10 = r6.matcher(r5);
    L4:
        if (r10.find() == false) goto L11;
        int r0 = r10.start();
        int r1 = r10.end();
        String r2 = r10.group(0);
        if (r8 == null) goto L9;
        if (r8.acceptMatch(r5, r0, r1) == false) goto L4;
    L9:
        if (r2 == null) goto L4;
        LinkSpec r3 = new LinkSpec();
        r3.url = makeUrl(r2, r7, r10, r9);
        r3.start = r0;
        r3.end = r1;
        r4.add(r3);
        goto L4
    }

    private static void gatherMapLinks(ArrayList<LinkSpec> r5, Spannable r6) {
        String r7 = r6.toString();
        int r0 = 0;
    L15:
        String r1 = findAddress(r7);     // Catch: UnsupportedOperationException -> L14
        if (r1 == null) goto L25;
        int r2 = r7.indexOf(r1);     // Catch: UnsupportedOperationException -> L14
        if (r2 < 0) goto L12;
        LinkSpec r3 = new LinkSpec();     // Catch: UnsupportedOperationException -> L14
        int r4 = r1.length() + r2;     // Catch: UnsupportedOperationException -> L14
        r3.start = r2 + r0;     // Catch: UnsupportedOperationException -> L14
        r0 = r0 + r4;     // Catch: UnsupportedOperationException -> L14
        r3.end = r0;     // Catch: UnsupportedOperationException -> L14
        r7 = r7.substring(r4);     // Catch: UnsupportedOperationException -> L14
        r3.url = "geo:0,0?q=" + URLEncoder.encode(r1, "UTF-8");     // Catch: UnsupportedOperationException -> L14
        r5.add(r3);     // Catch: UnsupportedOperationException -> L14
    L12:
        return;
    L25:
        return;
    }

    private static String makeUrl(@NonNull String r9, @NonNull String[] r10, Matcher r11, @Nullable Linkify.TransformFilter r12) {
        if (r12 == null) goto L4;
        r9 = r12.transformUrl(r11, r9);
    L4:
        int r13 = r10.length;
        int r6 = 0;
    L5:
        boolean r7 = true;
        if (r6 >= r13) goto L13;
        String r8 = r10[r6];
        if (r9.regionMatches(true, 0, r8, 0, r8.length()) == true) goto L10;
        r6 = r6 + 1;
        goto L5
    L10:
        if (r9.regionMatches(false, 0, r8, 0, r8.length()) == true) goto L14;
        r9 = r8 + r9.substring(r8.length());
    L14:
        if (r7 == false) goto L16;
        return r9;
    L16:
        if (r10.length > 0) goto L18;
        return r9;
    L18:
        return r10[0] + r9;
    L13:
        r7 = false;
        goto L14
    }

    private static void pruneOverlaps(ArrayList<LinkSpec> r10, Spannable r11) {
        int r2 = 0;
        URLSpan[] r0 = (URLSpan[]) r11.getSpans(0, r11.length(), URLSpan.class);
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        URLSpan r4 = r0[r3];
        LinkSpec r5 = new LinkSpec();
        r5.frameworkAddedSpan = r4;
        r5.start = r11.getSpanStart(r4);
        r5.end = r11.getSpanEnd(r4);
        r10.add(r5);
        r3 = r3 + 1;
        goto L3
    L5:
        Collections.sort(r10, COMPARATOR);
        int r6 = r10.size();
    L7:
        if (r2 >= (r6 - 1)) goto L28;
        LinkSpec r7 = r10.get(r2);
        int r8 = r2 + 1;
        LinkSpec r9 = r10.get(r8);
        int r12 = r7.start;
        int r13 = r9.start;
        if (r12 > r13) goto L27;
        int r14 = r7.end;
        if (r14 <= r13) goto L27;
        int r15 = r9.end;
        if (r15 > r14) goto L16;
    L14:
        int r16 = r8;
    L22:
        if (r16 == (-1)) goto L27;
        Object r17 = r10.get(r16).frameworkAddedSpan;
        if (r17 == null) goto L26;
        r11.removeSpan(r17);
    L26:
        r10.remove(r16);
        r6 = r6 - 1;
        goto L7
    L16:
        if ((r14 - r12) > (r15 - r13)) goto L14;
        if ((r14 - r12) >= (r15 - r13)) goto L21;
        r16 = r2;
        goto L22
    L21:
        r16 = -1;
    L27:
        r2 = r8;
        goto L7
    }

    private static boolean shouldAddLinksFallbackToFramework() {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        return true;
    L5:
        return false;
    }
}
