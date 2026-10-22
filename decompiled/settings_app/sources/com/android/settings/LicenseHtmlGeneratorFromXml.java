package com.android.settings;

import android.text.TextUtils;
import android.util.Xml;
import com.bytedance.librarian.LibrarianImpl;
import com.obric.olog.OLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.zip.GZIPInputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
class LicenseHtmlGeneratorFromXml {
    private static final String ATTR_CONTENT_ID = "contentId";
    private static final String ATTR_LIBRARY_NAME = "lib";
    private static final String CONTENT_HEAD_STRING = "<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\">";
    private static final String CONTENT_TAIL_STRING = "</table>";
    private static final String FILES_HEAD_STRING = "<ul class=\"files\">";
    private static final String FILES_TAIL_STRING = "</ul>\n</div><!-- table of contents -->";
    private static final String HTML_HEAD_STRING = "<html><head>\n<style type=\"text/css\">\nbody { padding: 0; font-family: sans-serif; }\n.same-license { background-color: #eeeeee;\n                border-top: 20px solid white;\n                padding: 10px; }\n.label { font-weight: bold; }\n.file-list { margin-left: 1em; color: blue; }\n</style>\n</head><body topmargin=\"0\" leftmargin=\"0\" rightmargin=\"0\" bottommargin=\"0\">\n<div class=\"toc\">";
    private static final String HTML_TAIL_STRING = "</body></html>";
    private static final String IMAGES_HEAD_STRING = "<div class=\"images-list\"><strong>Images</strong>\n<ul class=\"images\">";
    private static final String IMAGES_TAIL_STRING = "</ul></div>\n";
    private static final String LIBRARY_HEAD_STRING = "<strong>Libraries</strong>\n<ul class=\"libraries\">";
    private static final String LIBRARY_TAIL_STRING = "</ul>\n<strong>Files</strong>";
    private static final String PATH_COUNTS_HEAD_STRING = "<div class=\"path-counts\"><table>\n  <tr><th>Path prefix</th><th>Count</th></tr>\n";
    private static final String PATH_COUNTS_TAIL_STRING = "</table></div>\n";
    private static final String TAG = "LicenseGeneratorFromXml";
    private static final String TAG_FILE_CONTENT = "file-content";
    private static final String TAG_FILE_NAME = "file-name";
    private static final String TAG_ROOT = "licenses";
    private final Map<String, String> mContentIdToFileContentMap;
    private final Map<String, Map<String, Set<String>>> mFileNameToLibraryToContentIdMap;
    private final List<File> mXmlFiles;

    static class ContentIdAndFileNames {
        final String mContentId;
        final Map<String, List<String>> mLibraryToFileNameMap;

        ContentIdAndFileNames(String r2) {
            this.mLibraryToFileNameMap = new TreeMap();
            this.mContentId = r2;
        }
    }

    public static /* synthetic */ int $r8$lambda$PLyH_8zRx7lwjaMeeJ3EDjz5kyk(int r0, int r1) {
        return Integer.sum(r0, r1);
    }

    private LicenseHtmlGeneratorFromXml(List<File> r2) {
        this.mFileNameToLibraryToContentIdMap = new HashMap();
        this.mContentIdToFileContentMap = new HashMap();
        this.mXmlFiles = r2;
    }

    public static boolean generateHtml(List<File> r1, File r2, String r3) {
        return new LicenseHtmlGeneratorFromXml(r1).generateHtml(r2, r3);
    }

    private boolean generateHtml(File r5, String r6) {
        Iterator<File> r0 = this.mXmlFiles.iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        parse(r0.next());
        goto L4
    L7:
        if (this.mFileNameToLibraryToContentIdMap.isEmpty() == false) goto L9;
    L22:
        return false;
    L9:
        if (this.mContentIdToFileContentMap.isEmpty() == true) goto L22;
        PrintWriter r1 = null;
        PrintWriter r2 = new PrintWriter(r5);     // Catch: Throwable -> L18
        generateHtml(this.mXmlFiles, this.mFileNameToLibraryToContentIdMap, this.mContentIdToFileContentMap, r2, r6);     // Catch: Throwable -> L16
        r2.flush();     // Catch: Throwable -> L16
        r2.close();     // Catch: Throwable -> L16
        return true;
    L16:
        e = e;
        r1 = r2;
    L19:
        OLog.e(TAG, "Failed to generate " + r5, e);
        if (r1 == null) goto L22;
        r1.close();
    L18:
        e = e;
        goto L19
    }

    private void parse(File r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.exists() == true) goto L6;
        return;
    L6:
        if (r5.length() == 0) goto L29;
        InputStreamReader r0 = null;
    L15:
        e = move-exception;
        OLog.e(TAG, "Failed to parse " + r5, e);
        if (r0 == null) goto L28;
        r0.close();     // Catch: IOException -> L20
        return;
    L20:
        OLog.w(TAG, "Failed to close " + r5);
        return;
    L28:
        return;
    L10:
        if (r5.getName().endsWith(".gz") == false) goto L12;
        InputStreamReader r1 = new InputStreamReader(new GZIPInputStream(new FileInputStream(r5)));     // Catch: Throwable -> L15
    L13:
        r0 = r1;
        parse(r0, this.mFileNameToLibraryToContentIdMap, this.mContentIdToFileContentMap);     // Catch: Throwable -> L15
        r0.close();     // Catch: Throwable -> L15
        return;
    L12:
        r1 = new FileReader(r5);     // Catch: Throwable -> L15
        goto L13
    }

    static void parse(InputStreamReader r8, Map<String, Map<String, Set<String>>> r9, Map<String, String> r10) throws XmlPullParserException, IOException {
        HashMap r0 = new HashMap();
        Map<? extends String, ? extends String> r1 = new HashMap();
        XmlPullParser r2 = Xml.newPullParser();
        r2.setInput(r8);
        r2.nextTag();
        r2.require(2, "", TAG_ROOT);
        int r11 = r2.getEventType();
    L4:
        if (r11 == 1) goto L25;
        if (r11 != 2) goto L24;
        if (TAG_FILE_NAME.equals(r2.getName()) == false) goto L14;
        String r12 = r2.getAttributeValue("", ATTR_CONTENT_ID);
        String r5 = r2.getAttributeValue("", "lib");
        if (TextUtils.isEmpty(r12) == true) goto L24;
        String r6 = readText(r2).trim();
        if (TextUtils.isEmpty(r6) == true) goto L24;
        ((Set) ((Map) r0.computeIfAbsent(r6, new LicenseHtmlGeneratorFromXml$$ExternalSyntheticLambda0())).computeIfAbsent(r5, new LicenseHtmlGeneratorFromXml$$ExternalSyntheticLambda1())).add(r12);
        goto L24
    L14:
        if (TAG_FILE_CONTENT.equals(r2.getName()) == false) goto L24;
        String r13 = r2.getAttributeValue("", ATTR_CONTENT_ID);
        if (TextUtils.isEmpty(r13) == true) goto L24;
        if (r10.containsKey(r13) == true) goto L24;
        if (r1.containsKey(r13) == true) goto L24;
        String r7 = readText(r2);
        if (TextUtils.isEmpty(r7) == true) goto L24;
        r1.put(r13, r7);
    L24:
        r11 = r2.next();
        goto L4
    L25:
        Iterator r14 = r0.entrySet().iterator();
    L27:
        if (r14.hasNext() == false) goto L29;
        Map.Entry r3 = (Map.Entry) r14.next();
        r9.merge((String) r3.getKey(), (Map) r3.getValue(), new LicenseHtmlGeneratorFromXml$$ExternalSyntheticLambda2());
        goto L27
    L29:
        r10.putAll(r1);
    }

    static /* synthetic */ Map lambda$parse$0(String r0) {
        return new HashMap();
    }

    static /* synthetic */ Set lambda$parse$1(String r0) {
        return new HashSet();
    }

    static /* synthetic */ Map lambda$parse$3(Map r3, Map r4) {
        Iterator r5 = r4.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Map.Entry r0 = (Map.Entry) r5.next();
        r3.merge((String) r0.getKey(), (Set) r0.getValue(), new LicenseHtmlGeneratorFromXml$$ExternalSyntheticLambda6());
        goto L4
    L6:
        return r3;
    }

    static /* synthetic */ Set lambda$parse$2(Set r0, Set r1) {
        r0.addAll(r1);
        return r0;
    }

    private static String readText(XmlPullParser r3) throws IOException, XmlPullParserException {
        StringBuffer r0 = new StringBuffer();
        int r1 = r3.next();
    L4:
        if (r1 != 4) goto L7;
        r0.append(r3.getText());
        r1 = r3.next();
        goto L4
    L7:
        return r0.toString();
    }

    private static String pathPrefix(String r4) {
    L3:
        if (r4.length() <= 0) goto L7;
        if (r4.substring(0, 1).equals(LibrarianImpl.Constants.SEPARATOR) == false) goto L7;
        r4 = r4.substring(1);
    L7:
        int r0 = r4.indexOf(LibrarianImpl.Constants.SEPARATOR);
        if (r0 > 0) goto L10;
        return r4;
    L10:
        return r4.substring(0, r0);
    }

    static void generateHtml(List<File> r17, Map<String, Map<String, Set<String>>> r18, Map<String, String> r19, PrintWriter r20, String r21) throws IOException {
        ArrayList r1 = new ArrayList();
        r1.addAll(r18.keySet());
        Collections.sort(r1);
        TreeMap r2 = new TreeMap();
        Iterator r3 = r1.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        r2.merge(pathPrefix((String) r3.next()), 1, new LicenseHtmlGeneratorFromXml$$ExternalSyntheticLambda3());
        goto L4
    L6:
        TreeMap r4 = new TreeMap();
        Iterator<Map<String, Set<String>>> r5 = r18.values().iterator();
    L8:
        if (r5.hasNext() == false) goto L16;
        Iterator<Map.Entry<String, Set<String>>> r6 = r5.next().entrySet().iterator();
    L11:
        if (r6.hasNext() == false) goto L8;
        Map.Entry<String, Set<String>> r7 = r6.next();
        if (TextUtils.isEmpty(r7.getKey()) == true) goto L11;
        r4.merge(r7.getKey(), r7.getValue(), new LicenseHtmlGeneratorFromXml$$ExternalSyntheticLambda4());
        goto L11
    L16:
        r20.println(HTML_HEAD_STRING);
        if (TextUtils.isEmpty(r21) == true) goto L19;
        r20.println(r21);
        r20.println("<br/>");
    L19:
        HashMap r8 = new HashMap();
        ArrayList r9 = new ArrayList();
        if (r4.isEmpty() == true) goto L32;
        r20.println(LIBRARY_HEAD_STRING);
        Iterator r10 = r4.entrySet().iterator();
        int r11 = 0;
    L23:
        if (r10.hasNext() == false) goto L31;
        Map.Entry r12 = (Map.Entry) r10.next();
        Object r13 = (String) r12.getKey();
        Iterator r14 = ((Set) r12.getValue()).iterator();
    L26:
        if (r14.hasNext() == false) goto L23;
        String r15 = (String) r14.next();
        if (r8.containsKey(r15) == true) goto L30;
        r8.put(r15, Integer.valueOf(r11));
        r9.add(new ContentIdAndFileNames(r15));
        r11 = r11 + 1;
    L30:
        r20.format("<li><a href=\"#id%d\">%s</a></li>\n", new Object[]{Integer.valueOf(((Integer) r8.get(r15)).intValue()), r13});
        goto L26
    L31:
        r20.println(LIBRARY_TAIL_STRING);
    L34:
        if (r1.isEmpty() == true) goto L57;
        r20.println(FILES_HEAD_STRING);
        Iterator r16 = r1.iterator();
    L37:
        if (r16.hasNext() == false) goto L55;
        String r22 = (String) r16.next();
        Iterator<Map.Entry<String, Set<String>>> r110 = r18.get(r22).entrySet().iterator();
    L40:
        if (r110.hasNext() == false) goto L37;
        Map.Entry<String, Set<String>> r111 = r110.next();
        String r112 = r111.getKey();
        if (r112 != null) goto L44;
        r112 = "";
    L44:
        Iterator<String> r113 = r111.getValue().iterator();
    L46:
        if (r113.hasNext() == false) goto L40;
        String r114 = r113.next();
        if (r8.containsKey(r114) == true) goto L50;
        r8.put(r114, Integer.valueOf(r11));
        r9.add(new ContentIdAndFileNames(r114));
        r11 = r11 + 1;
    L50:
        int r23 = ((Integer) r8.get(r114)).intValue();
        ((ContentIdAndFileNames) r9.get(r23)).mLibraryToFileNameMap.computeIfAbsent(r112, new LicenseHtmlGeneratorFromXml$$ExternalSyntheticLambda5()).add(r22);
        if (TextUtils.isEmpty(r112) == false) goto L53;
        r20.format("<li><a href=\"#id%d\">%s</a></li>\n", new Object[]{Integer.valueOf(r23), r22});
        goto L46
    L53:
        r20.format("<li><a href=\"#id%d\">%s - %s</a></li>\n", new Object[]{Integer.valueOf(r23), r22, r112});
        goto L46
    L55:
        r20.println(FILES_TAIL_STRING);
    L57:
        if (r9.isEmpty() == true) goto L79;
        r20.println(CONTENT_HEAD_STRING);
        Iterator r24 = r9.iterator();
    L60:
        if (r24.hasNext() == false) goto L77;
        ContentIdAndFileNames r25 = (ContentIdAndFileNames) r24.next();
        if (r8.containsKey(r25.mContentId) == true) goto L64;
        r8.put(r25.mContentId, Integer.valueOf(r11));
        r11 = r11 + 1;
    L64:
        r20.format("<tr id=\"id%d\"><td class=\"same-license\">\n", new Object[]{Integer.valueOf(((Integer) r8.get(r25.mContentId)).intValue())});
        Iterator<Map.Entry<String, List<String>>> r26 = r25.mLibraryToFileNameMap.entrySet().iterator();
    L66:
        if (r26.hasNext() == false) goto L76;
        Map.Entry<String, List<String>> r27 = r26.next();
        String r28 = r27.getKey();
        if (TextUtils.isEmpty(r28) == false) goto L70;
        r20.println("<div class=\"label\">Notices for file(s):</div>");
    L71:
        r20.println("<div class=\"file-list\">");
        Iterator<String> r29 = r27.getValue().iterator();
    L73:
        if (r29.hasNext() == false) goto L75;
        r20.format("%s <br/>\n", new Object[]{(String) r29.next()});
        goto L73
    L75:
        r20.println("</div><!-- file-list -->");
        goto L66
    L70:
        r20.format("<div class=\"label\"><strong>%s</strong> used by:</div>\n", new Object[]{r28});
        goto L71
    L76:
        r20.println("<pre class=\"license-text\">");
        r20.println(r19.get(r25.mContentId));
        r20.println("</pre><!-- license-text -->");
        r20.println("</td></tr><!-- same-license -->");
        goto L60
    L77:
        r20.println(CONTENT_TAIL_STRING);
    L79:
        if (r17.isEmpty() == true) goto L86;
        r20.println(IMAGES_HEAD_STRING);
        Iterator<File> r30 = r17.iterator();
    L82:
        if (r30.hasNext() == false) goto L84;
        r20.format("  <li>%s</li>\n", new Object[]{pathPrefix(r30.next().getCanonicalPath())});
        goto L82
    L84:
        r20.println(IMAGES_TAIL_STRING);
    L86:
        if (r2.isEmpty() == true) goto L92;
        r20.println(PATH_COUNTS_HEAD_STRING);
        Iterator r31 = r2.entrySet().iterator();
    L89:
        if (r31.hasNext() == false) goto L91;
        Map.Entry r32 = (Map.Entry) r31.next();
        r20.format("  <tr><td>%s</td><td>%d</td></tr>\n", new Object[]{r32.getKey(), r32.getValue()});
        goto L89
    L91:
        r20.println(PATH_COUNTS_TAIL_STRING);
    L92:
        r20.println(HTML_TAIL_STRING);
        return;
    L32:
        r11 = 0;
        goto L34
    }

    static /* synthetic */ Set lambda$generateHtml$4(Set r0, Set r1) {
        r0.addAll(r1);
        return r0;
    }

    static /* synthetic */ List lambda$generateHtml$5(String r0) {
        return new ArrayList();
    }
}
