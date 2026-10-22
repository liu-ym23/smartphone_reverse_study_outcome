package androidx.core.text.util;

import a.a;
import android.annotation.SuppressLint;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
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

    public static class LinkSpec {
        int end;
        URLSpan frameworkAddedSpan;
        int start;
        String url;

        public LinkSpec() {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface LinkifyMask {
    }

    static {
        EMPTY_STRING = new String[0];
        COMPARATOR = new AnonymousClass1();
    }

    private LinkifyCompat() {
    }

    private static void addLinkMovementMethod(@NonNull TextView r1) {
        if ((r1.getMovementMethod() instanceof LinkMovementMethod) == false) goto L5;
        return;
    L5:
        if (r1.getLinksClickable() == false) goto L9;
        r1.setMovementMethod(LinkMovementMethod.getInstance());
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
        gatherLinks(r3, r10, PatternsCompat.AUTOLINK_EMAIL_ADDRESS, new String[]{"mailto:"}, null, null);
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

    private static void applyLink(String r1, int r2, int r3, Spannable r4) {
        r4.setSpan(new URLSpan(r1), r2, r3, 33);
    }

    private static String findAddress(String r0) {
        return WebView.findAddress(r0);
    }

    private static void gatherLinks(ArrayList<LinkSpec> r4, Spannable r5, Pattern r6, String[] r7, Linkify.MatchFilter r8, Linkify.TransformFilter r9) {
        Matcher r10 = r6.matcher(r5);
    L4:
        if (r10.find() == false) goto L10;
        int r0 = r10.start();
        int r1 = r10.end();
        if (r8 == null) goto L9;
        if (r8.acceptMatch(r5, r0, r1) == false) goto L4;
    L9:
        LinkSpec r2 = new LinkSpec();
        r2.url = makeUrl(r10.group(0), r7, r10, r9);
        r2.start = r0;
        r2.end = r1;
        r4.add(r2);
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

    private static String makeUrl(@NonNull String r6, @NonNull String[] r7, Matcher r8, @Nullable Linkify.TransformFilter r9) {
        if (r9 == null) goto L4;
        r6 = r9.transformUrl(r8, r6);
    L4:
        int r10 = 0;
    L6:
        if (r10 >= r7.length) goto L13;
        String r3 = r7[r10];
        if (r6.regionMatches(true, 0, r3, 0, r3.length()) == true) goto L9;
        r10 = r10 + 1;
        goto L6
    L9:
        String r4 = r7[r10];
        boolean r1 = true;
        if (r6.regionMatches(false, 0, r4, 0, r4.length()) == true) goto L14;
        r6 = r7[r10] + r6.substring(r7[r10].length());
    L14:
        if (r1 == false) goto L16;
        return r6;
    L16:
        if (r7.length > 0) goto L18;
        return r6;
    L18:
        return a.o(new StringBuilder(), r7[0], r6);
    L13:
        r1 = false;
        goto L14
    }

    private static void pruneOverlaps(ArrayList<LinkSpec> r10, Spannable r11) {
        int r2 = 0;
        URLSpan[] r0 = (URLSpan[]) r11.getSpans(0, r11.length(), URLSpan.class);
        int r1 = 0;
    L4:
        if (r1 >= r0.length) goto L6;
        LinkSpec r3 = new LinkSpec();
        URLSpan r4 = r0[r1];
        r3.frameworkAddedSpan = r4;
        r3.start = r11.getSpanStart(r4);
        r3.end = r11.getSpanEnd(r0[r1]);
        r10.add(r3);
        r1 = r1 + 1;
        goto L4
    L6:
        Collections.sort(r10, COMPARATOR);
        int r5 = r10.size();
    L8:
        if (r2 >= (r5 - 1)) goto L29;
        LinkSpec r6 = r10.get(r2);
        int r7 = r2 + 1;
        LinkSpec r8 = r10.get(r7);
        int r9 = r6.start;
        int r12 = r8.start;
        if (r9 > r12) goto L28;
        int r13 = r6.end;
        if (r13 <= r12) goto L28;
        int r14 = r8.end;
        if (r14 > r13) goto L17;
    L15:
        int r15 = r7;
    L23:
        if (r15 == (-1)) goto L28;
        Object r16 = r10.get(r15).frameworkAddedSpan;
        if (r16 == null) goto L27;
        r11.removeSpan(r16);
    L27:
        r10.remove(r15);
        r5 = r5 - 1;
        goto L8
    L17:
        if ((r13 - r9) > (r14 - r12)) goto L15;
        if ((r13 - r9) >= (r14 - r12)) goto L22;
        r15 = r2;
        goto L23
    L22:
        r15 = -1;
    L28:
        r2 = r7;
        goto L8
    }

    private static boolean shouldAddLinksFallbackToFramework() {
        return true;
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
        if (addLinks(r2, r5) == false) goto L20;
        addLinkMovementMethod(r4);
        r4.setText(r2);
        return true;
    L20:
        return false;
    L12:
        if (addLinks((Spannable) r1, r5) == false) goto L15;
        addLinkMovementMethod(r4);
        return true;
    L15:
        return false;
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

    @SuppressLint({"NewApi"})
    public static void addLinks(@NonNull TextView r7, @NonNull Pattern r8, @Nullable String r9, @Nullable String[] r10, @Nullable Linkify.MatchFilter r11, @Nullable Linkify.TransformFilter r12) {
        if (shouldAddLinksFallbackToFramework() == false) goto L6;
        Linkify.addLinks(r7, r8, r9, r10, r11, r12);
        return;
    L6:
        SpannableString r0 = SpannableString.valueOf(r7.getText());
        if (addLinks(r0, r8, r9, r10, r11, r12) == false) goto L10;
        r7.setText(r0);
        addLinkMovementMethod(r7);
        return;
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

    @SuppressLint({"NewApi"})
    public static boolean addLinks(@NonNull Spannable r6, @NonNull Pattern r7, @Nullable String r8, @Nullable String[] r9, @Nullable Linkify.MatchFilter r10, @Nullable Linkify.TransformFilter r11) {
        if (shouldAddLinksFallbackToFramework() == false) goto L7;
        return Linkify.addLinks(r6, r7, r8, r9, r10, r11);
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
        if (r13.find() == false) goto L31;
        int r15 = r13.start();
        int r0 = r13.end();
        if (r10 == null) goto L28;
        boolean r16 = r10.acceptMatch(r6, r15, r0);
    L29:
        if (r16 == false) goto L24;
        applyLink(makeUrl(r13.group(0), r2, r13, r11), r15, r0, r6);
        r14 = true;
        goto L24
    L28:
        r16 = true;
        goto L29
    L31:
        return r14;
    L12:
        if (r9.length >= 1) goto L14;
        goto L13
    }
}
