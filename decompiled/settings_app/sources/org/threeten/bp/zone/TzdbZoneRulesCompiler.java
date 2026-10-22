package org.threeten.bp.zone;

import androidx.exifinterface.media.ExifInterface;
import com.android.settings.CustomKeyUtils;
import com.android.settingslib.accessibility.AccessibilityUtils;
import com.google.common.net.HttpHeaders;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Month;
import org.threeten.bp.Year;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjusters;

/* JADX INFO: loaded from: classes6.dex */
final class TzdbZoneRulesCompiler {
    private static final DateTimeFormatter TIME_PARSER = null;
    private final SortedMap<String, ZoneRules> builtZones;
    private Map<Object, Object> deduplicateMap;
    private final SortedMap<LocalDate, Byte> leapSeconds;
    private final File leapSecondsFile;
    private final Map<String, String> links;
    private final Map<String, List<TZDBRule>> rules;
    private final List<File> sourceFiles;
    private final boolean verbose;
    private final String version;
    private final Map<String, List<TZDBZone>> zones;

    static final class LeapSecondRule {
        final LocalDate leapDate;
        byte secondAdjustment;

        public LeapSecondRule(LocalDate r1, byte r2) {
            this.leapDate = r1;
            this.secondAdjustment = r2;
        }
    }

    abstract class TZDBMonthDayTime {
        boolean adjustForwards;
        int dayOfMonth;
        DayOfWeek dayOfWeek;
        boolean endOfDay;
        Month month;
        final /* synthetic */ TzdbZoneRulesCompiler this$0;
        LocalTime time;
        ZoneOffsetTransitionRule.TimeDefinition timeDefinition;

        TZDBMonthDayTime(TzdbZoneRulesCompiler r1) {
            this.this$0 = r1;
            this.month = Month.JANUARY;
            this.dayOfMonth = 1;
            this.adjustForwards = true;
            this.time = LocalTime.MIDNIGHT;
            this.timeDefinition = ZoneOffsetTransitionRule.TimeDefinition.WALL;
        }

        void adjustToFowards(int r3) {
            if (this.adjustForwards == true) goto L8;
            int r0 = this.dayOfMonth;
            if (r0 <= 0) goto L9;
            LocalDate r4 = LocalDate.of(r3, this.month, r0).minusDays(6);
            this.dayOfMonth = r4.getDayOfMonth();
            this.month = r4.getMonth();
            this.adjustForwards = true;
            return;
        L9:
            return;
        }
    }

    final class TZDBRule extends TZDBMonthDayTime {
        int endYear;
        int savingsAmount;
        int startYear;
        String text;
        final /* synthetic */ TzdbZoneRulesCompiler this$0;

        TZDBRule(TzdbZoneRulesCompiler r1) {
            this.this$0 = r1;
            super(r1);
        }

        void addToBuilder(ZoneRulesBuilder r12) {
            adjustToFowards(2004);
            r12.addRuleToWindow(this.startYear, this.endYear, this.month, this.dayOfMonth, this.dayOfWeek, this.time, this.endOfDay, this.timeDefinition, this.savingsAmount);
        }
    }

    final class TZDBZone extends TZDBMonthDayTime {
        Integer fixedSavingsSecs;
        String savingsRule;
        ZoneOffset standardOffset;
        String text;
        final /* synthetic */ TzdbZoneRulesCompiler this$0;
        Year year;

        TZDBZone(TzdbZoneRulesCompiler r1) {
            this.this$0 = r1;
            super(r1);
        }

        ZoneRulesBuilder addToBuilder(ZoneRulesBuilder r4, Map<String, List<TZDBRule>> r5) {
            Year r0 = this.year;
            if (r0 == null) goto L5;
            r4.addWindow(this.standardOffset, toDateTime(r0.getValue()), this.timeDefinition);
        L6:
            Integer r1 = this.fixedSavingsSecs;
            if (r1 == null) goto L9;
            r4.setFixedSavingsToWindow(r1.intValue());
        L15:
            return r4;
        L9:
            List<TZDBRule> r6 = r5.get(this.savingsRule);
            if (r6 == null) goto L17;
            Iterator<TZDBRule> r3 = r6.iterator();
        L13:
            if (r3.hasNext() == false) goto L15;
            r3.next().addToBuilder(r4);
            goto L13
        L17:
            throw new IllegalArgumentException("Rule not found: " + this.savingsRule);
        L5:
            r4.addWindowForever(this.standardOffset);
            goto L6
        }

        private LocalDateTime toDateTime(int r4) {
            adjustToFowards(r4);
            if (this.dayOfMonth != (-1)) goto L7;
            this.dayOfMonth = this.month.length(Year.isLeap(r4));
            LocalDate r5 = LocalDate.of(r4, this.month, this.dayOfMonth);
            if (this.dayOfWeek == null) goto L10;
            r5 = r5.with(TemporalAdjusters.previousOrSame(this.dayOfWeek));
        L10:
            LocalDateTime r6 = LocalDateTime.of((LocalDate) this.this$0.deduplicate(r5), this.time);
            if (this.endOfDay == true) goto L13;
            return r6;
        L13:
            return r6.plusDays(1);
        L7:
            r5 = LocalDate.of(r4, this.month, this.dayOfMonth);
            if (this.dayOfWeek == null) goto L10;
            r5 = r5.with(TemporalAdjusters.nextOrSame(this.dayOfWeek));
            goto L10
        }
    }

    static {
        TIME_PARSER = new DateTimeFormatterBuilder().appendValue(ChronoField.HOUR_OF_DAY).optionalStart().appendLiteral(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR).appendValue(ChronoField.MINUTE_OF_HOUR, 2).optionalStart().appendLiteral(AccessibilityUtils.ENABLED_ACCESSIBILITY_SERVICES_SEPARATOR).appendValue(ChronoField.SECOND_OF_MINUTE, 2).toFormatter();
    }

    public static void main(String[] r17) {
        if (r17.length >= 2) goto L6;
        outputHelp();
        return;
    L6:
        File r1 = null;
        int r2 = 0;
        File r3 = null;
        String r4 = null;
        int r5 = 0;
        boolean r6 = false;
        boolean r7 = false;
    L8:
        if (r5 >= r17.length) goto L44;
        String r8 = r17[r5];
        if (r8.startsWith("-") == false) goto L44;
        if ("-srcdir".equals(r8) == false) goto L19;
        if (r1 != null) goto L42;
        r5 = r5 + 1;
        if (r5 >= r17.length) goto L42;
        r1 = new File(r17[r5]);
    L38:
        r5 = r5 + 1;
    L42:
        outputHelp();
        return;
    L19:
        if ("-dstdir".equals(r8) == false) goto L25;
        if (r3 != null) goto L42;
        r5 = r5 + 1;
        if (r5 >= r17.length) goto L42;
        r3 = new File(r17[r5]);
        goto L38
    L25:
        if ("-version".equals(r8) == false) goto L31;
        if (r4 != null) goto L42;
        r5 = r5 + 1;
        if (r5 >= r17.length) goto L42;
        r4 = r17[r5];
        goto L38
    L31:
        if ("-unpacked".equals(r8) == false) goto L35;
        if (r6 == true) goto L42;
        r6 = true;
        goto L38
    L35:
        if ("-verbose".equals(r8) == false) goto L40;
        if (r7 == true) goto L42;
        r7 = true;
        goto L38
    L40:
        if ("-help".equals(r8) == true) goto L42;
        System.out.println("Unrecognised option: " + r8);
    L44:
        if (r1 != null) goto L48;
        System.out.println("Source directory must be specified using -srcdir: " + r1);
        return;
    L48:
        if (r1.isDirectory() == true) goto L51;
        System.out.println("Source does not exist or is not a directory: " + r1);
        return;
    L51:
        if (r3 != null) goto L54;
        r3 = r1;
    L54:
        List r0 = Arrays.asList(Arrays.copyOfRange(r17, r5, r17.length));
        if (r0.isEmpty() == false) goto L57;
        System.out.println("Source filenames not specified, using default set");
        System.out.println("(africa antarctica asia australasia backward etcetera europe northamerica southamerica)");
        r0 = Arrays.asList(new String[]{"africa", "antarctica", "asia", "australasia", "backward", "etcetera", "europe", "northamerica", "southamerica"});
    L57:
        ArrayList r9 = new ArrayList();
        if (r4 == null) goto L64;
        File r10 = new File(r1, r4);
        if (r10.isDirectory() == true) goto L63;
        System.out.println("Version does not represent a valid source directory : " + r10);
        return;
    L63:
        r9.add(r10);
    L73:
        if (r9.isEmpty() == false) goto L77;
        System.out.println("Source directory contains no valid source folders: " + r1);
        return;
    L77:
        if (r3.exists() == true) goto L83;
        if (r3.mkdirs() == true) goto L83;
        System.out.println("Destination directory could not be created: " + r3);
        return;
    L83:
        if (r3.isDirectory() == true) goto L86;
        System.out.println("Destination is not a directory: " + r3);
        return;
    L86:
        process(r9, r0, r3, r6, r7);
        return;
    L64:
        File[] r11 = r1.listFiles();
        int r12 = r11.length;
    L65:
        if (r2 >= r12) goto L73;
        File r13 = r11[r2];
        if (r13.isDirectory() == false) goto L71;
        if (r13.getName().matches("[12][0-9][0-9][0-9][A-Za-z0-9._-]+") == false) goto L71;
        r9.add(r13);
    L71:
        r2 = r2 + 1;
        goto L65
    }

    private static void outputHelp() {
        System.out.println("Usage: TzdbZoneRulesCompiler <options> <tzdb source filenames>");
        System.out.println("where options include:");
        System.out.println("   -srcdir <directory>   Where to find source directories (required)");
        System.out.println("   -dstdir <directory>   Where to output generated files (default srcdir)");
        System.out.println("   -version <version>    Specify the version, such as 2009a (optional)");
        System.out.println("   -unpacked             Generate dat files without jar files");
        System.out.println("   -help                 Print this usage message");
        System.out.println("   -verbose              Output verbose information during compilation");
        System.out.println(" There must be one directory for each version in srcdir");
        System.out.println(" Each directory must have the name of the version, such as 2009a");
        System.out.println(" Each directory must contain the unpacked tzdb files, such as asia or europe");
        System.out.println(" Directories must match the regex [12][0-9][0-9][0-9][A-Za-z0-9._-]+");
        System.out.println(" There will be one jar file for each version and one combined jar in dstdir");
        System.out.println(" If the version is specified, only that version is processed");
    }

    private static void process(List<File> r16, List<String> r17, File r18, boolean r19, boolean r20) {
        HashMap r3 = new HashMap();
        TreeMap r4 = new TreeMap();
        TreeSet r5 = new TreeSet();
        HashSet r6 = new HashSet();
        Iterator<File> r7 = r16.iterator();
        SortedMap<LocalDate, Byte> r9 = null;
    L4:
        if (r7.hasNext() == false) goto L32;
        File r0 = r7.next();
        ArrayList r10 = new ArrayList();
        Iterator<String> r11 = r17.iterator();
    L7:
        if (r11.hasNext() == false) goto L12;
        File r13 = new File(r0, r11.next());
        if (r13.exists() == false) goto L7;
        r10.add(r13);
        goto L7
    L12:
        if (r10.isEmpty() == true) goto L4;
        File r12 = new File(r0, "leapseconds");
        if (r12.exists() == true) goto L17;
        System.out.println("Version " + r0.getName() + " does not include leap seconds information.");
        r12 = null;
    L17:
        String r1 = r0.getName();
        TzdbZoneRulesCompiler r14 = new TzdbZoneRulesCompiler(r1, r10, r12, r20);
        r14.setDeduplicateMap(r3);
        r14.compile();     // Catch: Exception -> L30
        SortedMap<String, ZoneRules> r15 = r14.getZones();     // Catch: Exception -> L30
        SortedMap<LocalDate, Byte> r110 = r14.getLeapSeconds();     // Catch: Exception -> L30
        if (r19 == true) goto L24;
        File r111 = new File(r18, "threeten-TZDB-" + r1 + ".jar");     // Catch: Exception -> L30
        if (r20 == false) goto L23;
        System.out.println("Outputting file: " + r111);     // Catch: Exception -> L30
    L23:
        outputFile(r111, r1, r15, r110);     // Catch: Exception -> L30
    L24:
        r4.put(r1, r15);     // Catch: Exception -> L30
        r5.addAll(r15.keySet());     // Catch: Exception -> L30
        r6.addAll(r15.values());     // Catch: Exception -> L30
        if (r14.getMostRecentLeapSecond() == null) goto L4;
        if (r9 == null) goto L29;
        if (r14.getMostRecentLeapSecond().compareTo(r9.lastKey()) <= 0) goto L4;
    L29:
        r9 = r110;
    L30:
        e = move-exception;
        System.out.println("Failed: " + e.toString());
        e.printStackTrace();
        System.exit(1);
        goto L4
    L32:
        if (r19 == false) goto L36;
        if (r20 == false) goto L35;
        System.out.println("Outputting combined files: " + r18);
    L35:
        outputFilesDat(r18, r4, r5, r6, r9);
        return;
    L36:
        File r2 = new File(r18, "threeten-TZDB-all.jar");
        if (r20 == false) goto L39;
        System.out.println("Outputting combined file: " + r2);
    L39:
        outputFile(r2, r4, r5, r6, r9);
    }

    private static void outputFilesDat(File r1, Map<String, SortedMap<String, ZoneRules>> r2, Set<String> r3, Set<ZoneRules> r4, SortedMap<LocalDate, Byte> r5) {
        File r6 = new File(r1, "TZDB.dat");
        r6.delete();
        FileOutputStream r0 = new FileOutputStream(r6);     // Catch: Throwable -> L8
        outputTzdbDat(r0, r2, r3, r4);     // Catch: Throwable -> L6
        r0.close();     // Catch: Exception -> L13
        return;
    L6:
        Throwable th = th;
    L10:
        if (r0 == null) goto L21;
        r0.close();     // Catch: Exception -> L13
        throw th;     // Catch: Exception -> L13
    L21:
        throw th;     // Catch: Exception -> L13
    L8:
        th = move-exception;
        r0 = null;
        th = th;
    L13:
        e = move-exception;
        System.out.println("Failed: " + e.toString());
        e.printStackTrace();
        System.exit(1);
    }

    private static void outputFile(File r2, String r3, SortedMap<String, ZoneRules> r4, SortedMap<LocalDate, Byte> r5) {
        TreeMap r0 = new TreeMap();
        r0.put(r3, r4);
        outputFile(r2, r0, new TreeSet(r4.keySet()), new HashSet(r4.values()), r5);
    }

    private static void outputFile(File r3, Map<String, SortedMap<String, ZoneRules>> r4, Set<String> r5, Set<ZoneRules> r6, SortedMap<LocalDate, Byte> r7) {
        JarOutputStream r0 = null;
        JarOutputStream r1 = new JarOutputStream(new FileOutputStream(r3));     // Catch: Throwable -> L11 Exception -> L13
        outputTzdbEntry(r1, r4, r5, r6);     // Catch: Throwable -> L7 Exception -> L9
        r1.close();     // Catch: IOException -> L21
    L27:
        return;
    L9:
        e = e;
        r0 = r1;
    L14:
        System.out.println("Failed: " + e.toString());     // Catch: Throwable -> L11
        e.printStackTrace();     // Catch: Throwable -> L11
        System.exit(1);     // Catch: Throwable -> L11
        if (r0 == null) goto L33;
        r0.close();     // Catch: IOException -> L21
        goto L27
    L33:
        return;
    L7:
        th = th;
        r0 = r1;
    L18:
        if (r0 != null) goto L23;
    L20:
        throw th;
    L23:
        r0.close();     // Catch: IOException -> L22
    L13:
        e = e;
    L11:
        th = th;
    }

    private static void outputTzdbEntry(JarOutputStream r2, Map<String, SortedMap<String, ZoneRules>> r3, Set<String> r4, Set<ZoneRules> r5) {
        r2.putNextEntry(new ZipEntry("org/threeten/bp/TZDB.dat"));     // Catch: Exception -> L4
        outputTzdbDat(r2, r3, r4, r5);     // Catch: Exception -> L4
        r2.closeEntry();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        System.out.println("Failed: " + e.toString());
        e.printStackTrace();
        System.exit(1);
    }

    private static void outputTzdbDat(OutputStream r5, Map<String, SortedMap<String, ZoneRules>> r6, Set<String> r7, Set<ZoneRules> r8) throws IOException {
        DataOutputStream r0 = new DataOutputStream(r5);
        r0.writeByte(1);
        r0.writeUTF("TZDB");
        String[] r9 = (String[]) r6.keySet().toArray(new String[r6.size()]);
        r0.writeShort(r9.length);
        int r1 = r9.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        r0.writeUTF(r9[r3]);
        r3 = r3 + 1;
        goto L3
    L5:
        String[] r10 = (String[]) r7.toArray(new String[r7.size()]);
        r0.writeShort(r10.length);
        int r11 = r10.length;
    L6:
        if (r2 >= r11) goto L8;
        r0.writeUTF(r10[r2]);
        r2 = r2 + 1;
        goto L6
    L8:
        ArrayList r12 = new ArrayList(r8);
        r0.writeShort(r12.size());
        ByteArrayOutputStream r13 = new ByteArrayOutputStream(1024);
        Iterator r4 = r12.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        ZoneRules r14 = (ZoneRules) r4.next();
        r13.reset();
        DataOutputStream r15 = new DataOutputStream(r13);
        Ser.write(r14, r15);
        r15.close();
        byte[] r16 = r13.toByteArray();
        r0.writeShort(r16.length);
        r0.write(r16);
        goto L10
    L12:
        Iterator<String> r17 = r6.keySet().iterator();
    L14:
        if (r17.hasNext() == false) goto L19;
        String r18 = r17.next();
        r0.writeShort(r6.get(r18).size());
        Iterator<Map.Entry<String, ZoneRules>> r19 = r6.get(r18).entrySet().iterator();
    L17:
        if (r19.hasNext() == false) goto L14;
        Map.Entry<String, ZoneRules> r20 = r19.next();
        int r21 = Arrays.binarySearch(r10, r20.getKey());
        int r22 = r12.indexOf(r20.getValue());
        r0.writeShort(r21);
        r0.writeShort(r22);
        goto L17
    L19:
        r0.flush();
    }

    public TzdbZoneRulesCompiler(String r2, List<File> r3, File r4, boolean r5) {
        this.rules = new HashMap();
        this.zones = new HashMap();
        this.links = new HashMap();
        this.builtZones = new TreeMap();
        this.deduplicateMap = new HashMap();
        this.leapSeconds = new TreeMap();
        this.version = r2;
        this.sourceFiles = r3;
        this.leapSecondsFile = r4;
        this.verbose = r5;
    }

    public void compile() throws Exception {
        printVerbose("Compiling TZDB version " + this.version);
        parseFiles();
        parseLeapSecondsFile();
        buildZoneRules();
        printVerbose("Compiled TZDB version " + this.version);
    }

    public SortedMap<String, ZoneRules> getZones() {
        return this.builtZones;
    }

    public SortedMap<LocalDate, Byte> getLeapSeconds() {
        return this.leapSeconds;
    }

    private LocalDate getMostRecentLeapSecond() {
        if (this.leapSeconds.isEmpty() == false) goto L6;
        return null;
    L6:
        return this.leapSeconds.lastKey();
    }

    void setDeduplicateMap(Map<Object, Object> r1) {
        this.deduplicateMap = r1;
    }

    private void parseFiles() throws Exception {
        Iterator<File> r0 = this.sourceFiles.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        File r1 = r0.next();
        printVerbose("Parsing file: " + r1);
        parseFile(r1);
        goto L4
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0094: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:25:0x0094 */
    private void parseLeapSecondsFile() throws Exception {
        printVerbose("Parsing leap second file: " + this.leapSecondsFile);
        int r0 = 1;
        BufferedReader r1 = null;
        String r2 = null;
        r2 = null;
        BufferedReader r3 = new BufferedReader(new FileReader(this.leapSecondsFile));     // Catch: Throwable -> L18 Exception -> L20
    L34:
        r2 = r3.readLine();     // Catch: Exception -> L16 Throwable -> L24
        if (r2 == null) goto L36;
        int r4 = r2.indexOf(35);     // Catch: Exception -> L16 Throwable -> L24
        if (r4 < 0) goto L10;
        r2 = r2.substring(0, r4);     // Catch: Exception -> L16 Throwable -> L24
    L10:
        if (r2.trim().length() == 0) goto L13;
        LeapSecondRule r5 = parseLeapSecondRule(r2);     // Catch: Exception -> L16 Throwable -> L24
        this.leapSeconds.put(r5.leapDate, Byte.valueOf(r5.secondAdjustment));     // Catch: Exception -> L16 Throwable -> L24
    L13:
        r0 = r0 + 1;
        goto L34
    L36:
        r3.close();     // Catch: Exception -> L29
        return;
    L41:
        return;
    L16:
        e = e;
    L23:
        throw new Exception("Failed while processing file '" + this.leapSecondsFile + "' on line " + r0 + " '" + r2 + "'", e);     // Catch: Throwable -> L24
    L24:
        th = th;
        r1 = r2;
    L26:
        if (r1 != null) goto L32;
    L28:
        throw th;
    L32:
        r1.close();     // Catch: Exception -> L30
    L20:
        e = e;
    L18:
        th = th;
        goto L26
    }

    private LeapSecondRule parseLeapSecondRule(String r4) {
        StringTokenizer r0 = new StringTokenizer(r4, " \t");
        if (r0.nextToken().equals("Leap") == false) goto L31;
        if (r0.countTokens() < 6) goto L28;
        LocalDate r3 = LocalDate.of(Integer.parseInt(r0.nextToken()), parseMonth(r0.nextToken()), Integer.parseInt(r0.nextToken()));
        String r5 = r0.nextToken();
        String r1 = r0.nextToken();
        if (r1.equals(CustomKeyUtils.KEY_SEPARATE_FOR_SHOW) == false) goto L14;
        if ("23:59:60".equals(r5) == false) goto L12;
        byte r6 = 1;
    L18:
        String r2 = r0.nextToken();
        if (ExifInterface.LATITUDE_SOUTH.equalsIgnoreCase(r2) == false) goto L23;
        return new LeapSecondRule(r3, r6);
    L23:
        throw new IllegalArgumentException("Only stationary ('S') leap seconds are supported, not '" + r2 + "'");
    L12:
        throw new IllegalArgumentException("Leap seconds can only be inserted at 23:59:60 - Date:" + r3);
    L14:
        if (r1.equals("-") == false) goto L27;
        if ("23:59:59".equals(r5) == false) goto L25;
        r6 = -1;
        goto L18
    L25:
        throw new IllegalArgumentException("Leap seconds can only be removed at 23:59:59 - Date:" + r3);
    L27:
        throw new IllegalArgumentException("Invalid adjustment '" + r1 + "' in leap second rule for " + r3);
    L28:
        printVerbose("Invalid leap second line in file: " + this.leapSecondsFile + ", line: " + r4);
        throw new IllegalArgumentException("Invalid leap second line");
    L31:
        throw new IllegalArgumentException("Unknown line");
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x016e: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:62:0x016e */
    private void parseFile(File r9) throws Exception {
        int r0 = 1;
        BufferedReader r1 = null;
        String r2 = null;
        BufferedReader r3 = new BufferedReader(new FileReader(r9));     // Catch: Throwable -> L55 Exception -> L57
        ArrayList r4 = null;
        String r5 = null;
    L67:
        r5 = r3.readLine();     // Catch: Exception -> L53 Throwable -> L61
        if (r5 == null) goto L51;
        int r6 = r5.indexOf(35);     // Catch: Exception -> L53 Throwable -> L61
        if (r6 < 0) goto L11;
        r5 = r5.substring(0, r6);     // Catch: Exception -> L53 Throwable -> L61
    L11:
        if (r5.trim().length() == 0) goto L50;
        StringTokenizer r7 = new StringTokenizer(r5, " \t");     // Catch: Exception -> L53 Throwable -> L61
        if (r4 == null) goto L23;
        if (Character.isWhitespace(r5.charAt(0)) == false) goto L23;
        if (r7.hasMoreTokens() == false) goto L23;
        if (parseZoneLine(r7, r4) == false) goto L50;
    L21:
        r4 = null;
    L23:
        if (r7.hasMoreTokens() == false) goto L50;
        String r8 = r7.nextToken();     // Catch: Exception -> L53 Throwable -> L61
        if (r8.equals("Zone") == false) goto L35;
        if (r7.countTokens() < 3) goto L32;
        r4 = new ArrayList();     // Catch: Exception -> L53 Throwable -> L61
        this.zones.put(r7.nextToken(), r4);     // Catch: Exception -> L53 Throwable -> L61
        if (parseZoneLine(r7, r4) == false) goto L50;
    L32:
        printVerbose("Invalid Zone line in file: " + r9 + ", line: " + r5);     // Catch: Exception -> L53 Throwable -> L61
        throw new IllegalArgumentException("Invalid Zone line");     // Catch: Exception -> L53 Throwable -> L61
    L35:
        if (r8.equals("Rule") == false) goto L42;
        if (r7.countTokens() < 9) goto L39;
        parseRuleLine(r7);     // Catch: Exception -> L53 Throwable -> L61
        goto L21
    L39:
        printVerbose("Invalid Rule line in file: " + r9 + ", line: " + r5);     // Catch: Exception -> L53 Throwable -> L61
        throw new IllegalArgumentException("Invalid Rule line");     // Catch: Exception -> L53 Throwable -> L61
    L42:
        if (r8.equals(HttpHeaders.LINK) == false) goto L49;
        if (r7.countTokens() < 2) goto L46;
        String r10 = r7.nextToken();     // Catch: Exception -> L53 Throwable -> L61
        this.links.put(r7.nextToken(), r10);     // Catch: Exception -> L53 Throwable -> L61
        goto L21
    L46:
        printVerbose("Invalid Link line in file: " + r9 + ", line: " + r5);     // Catch: Exception -> L53 Throwable -> L61
        throw new IllegalArgumentException("Invalid Link line");     // Catch: Exception -> L53 Throwable -> L61
    L49:
        throw new IllegalArgumentException("Unknown line");     // Catch: Exception -> L53 Throwable -> L61
    L50:
        r0 = r0 + 1;
        goto L67
    L51:
        r3.close();
        return;
    L53:
        e = e;
        r2 = r5;
    L60:
        throw new Exception("Failed while processing file '" + r9 + "' on line " + r0 + " '" + r2 + "'", e);     // Catch: Throwable -> L61
    L61:
        th = th;
        r1 = r2;
    L63:
        if (r1 == null) goto L65;
        r1.close();
    L65:
        throw th;
    L57:
        e = e;
    L55:
        th = th;
        goto L63
    }

    private void parseRuleLine(StringTokenizer r5) {
        TZDBRule r0 = new TZDBRule(this);
        String r1 = r5.nextToken();
        if (this.rules.containsKey(r1) == true) goto L5;
        this.rules.put(r1, new ArrayList());
    L5:
        this.rules.get(r1).add(r0);
        r0.startYear = parseYear(r5.nextToken(), 0);
        r0.endYear = parseYear(r5.nextToken(), r0.startYear);
        if (r0.startYear > r0.endYear) goto L10;
        parseOptional(r5.nextToken());
        parseMonthDayTime(r5, r0);
        r0.savingsAmount = parsePeriod(r5.nextToken());
        r0.text = parseOptional(r5.nextToken());
        return;
    L10:
        throw new IllegalArgumentException("Year order invalid: " + r0.startYear + " > " + r0.endYear);
    }

    private boolean parseZoneLine(StringTokenizer r5, List<TZDBZone> r6) {
        TZDBZone r0 = new TZDBZone(this);
        r6.add(r0);
        r0.standardOffset = parseOffset(r5.nextToken());
        String r7 = parseOptional(r5.nextToken());
        if (r7 != null) goto L16;
        r0.fixedSavingsSecs = 0;
        r0.savingsRule = null;
    L8:
        r0.text = r5.nextToken();
        if (r5.hasMoreTokens() == false) goto L14;
        r0.year = Year.of(Integer.parseInt(r5.nextToken()));
        if (r5.hasMoreTokens() == false) goto L13;
        parseMonthDayTime(r5, r0);
    L13:
        return false;
    L14:
        return true;
    L16:
        r0.fixedSavingsSecs = Integer.valueOf(parsePeriod(r7));     // Catch: Exception -> L7
        r0.savingsRule = null;     // Catch: Exception -> L7
    L7:
        r0.fixedSavingsSecs = null;
        r0.savingsRule = r7;
        goto L8
    }

    private void parseMonthDayTime(StringTokenizer r5, TZDBMonthDayTime r6) {
        r6.month = parseMonth(r5.nextToken());
        if (r5.hasMoreTokens() == false) goto L22;
        String r0 = r5.nextToken();
        int r2 = 0;
        if (r0.startsWith("last") == false) goto L7;
        r6.dayOfMonth = -1;
        r6.dayOfWeek = parseDayOfWeek(r0.substring(4));
        r6.adjustForwards = false;
    L15:
        if (r5.hasMoreTokens() == false) goto L23;
        String r7 = r5.nextToken();
        int r1 = parseSecs(r7);
        if (r1 != 86400) goto L19;
        r6.endOfDay = true;
    L20:
        r6.time = (LocalTime) deduplicate(LocalTime.ofSecondOfDay(r2));
        r6.timeDefinition = parseTimeDefinition(r7.charAt(r7.length() - 1));
        return;
    L19:
        r2 = r1;
        goto L20
    L23:
        return;
    L7:
        int r3 = r0.indexOf(">=");
        if (r3 <= 0) goto L10;
        r6.dayOfWeek = parseDayOfWeek(r0.substring(0, r3));
        r0 = r0.substring(r3 + 2);
    L13:
        r6.dayOfMonth = Integer.parseInt(r0);
        goto L15
    L10:
        int r4 = r0.indexOf("<=");
        if (r4 <= 0) goto L13;
        r6.dayOfWeek = parseDayOfWeek(r0.substring(0, r4));
        r6.adjustForwards = false;
        r0 = r0.substring(r4 + 2);
        goto L13
    }

    private int parseYear(String r2, int r3) {
        String r4 = r2.toLowerCase();
        if (matches(r4, "minimum") == false) goto L7;
        return Year.MIN_VALUE;
    L7:
        if (matches(r4, "maximum") == false) goto L11;
        return Year.MAX_VALUE;
    L11:
        if (r4.equals("only") == false) goto L14;
        return r3;
    L14:
        return Integer.parseInt(r4);
    }

    private Month parseMonth(String r6) {
        String r7 = r6.toLowerCase();
        Month[] r0 = Month.values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        Month r3 = r0[r2];
        if (matches(r7, r3.name().toLowerCase()) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        throw new IllegalArgumentException("Unknown month: " + r7);
    }

    private DayOfWeek parseDayOfWeek(String r6) {
        String r7 = r6.toLowerCase();
        DayOfWeek[] r0 = DayOfWeek.values();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        DayOfWeek r3 = r0[r2];
        if (matches(r7, r3.name().toLowerCase()) == true) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        throw new IllegalArgumentException("Unknown day-of-week: " + r7);
    }

    private boolean matches(String r2, String r3) {
        if (r2.startsWith(r3.substring(0, 3)) == true) goto L5;
        return false;
    L5:
        if (r3.startsWith(r2) == true) goto L7;
        return false;
    L7:
        if (r2.length() > r3.length()) goto L12;
        return true;
    L12:
        return false;
    }

    private String parseOptional(String r1) {
        if (r1.equals("-") == false) goto L6;
        return null;
    L6:
        return r1;
    }

    private int parseSecs(String r11) {
        if (r11.equals("-") == false) goto L6;
        return 0;
    L6:
        boolean r10 = r11.startsWith("-");
        ParsePosition r0 = new ParsePosition(r10 ? 1 : 0);
        TemporalAccessor r1 = TIME_PARSER.parseUnresolved(r11, r0);
        if (r1 == null) goto L29;
        if (r0.getErrorIndex() >= 0) goto L29;
        long r2 = r1.getLong(ChronoField.HOUR_OF_DAY);
        Long r3 = null;
        if (r1.isSupported(ChronoField.MINUTE_OF_HOUR) == false) goto L13;
        Long r12 = Long.valueOf(r1.getLong(ChronoField.MINUTE_OF_HOUR));
    L15:
        if (r1.isSupported(ChronoField.SECOND_OF_MINUTE) == false) goto L17;
        r3 = Long.valueOf(r1.getLong(ChronoField.SECOND_OF_MINUTE));
    L17:
        long r4 = (r2 * 60) * 60;
        long r6 = 0;
        if (r12 == null) goto L20;
        long r8 = r12.longValue();
    L21:
        long r5 = r4 + (r8 * 60);
        if (r3 == null) goto L24;
        r6 = r3.longValue();
    L24:
        int r13 = (int) (r5 + r6);
        if (r10 == true) goto L27;
        return r13;
    L27:
        return -r13;
    L20:
        r8 = 0;
        goto L21
    L13:
        r12 = null;
    L29:
        throw new IllegalArgumentException(r11);
    }

    private ZoneOffset parseOffset(String r1) {
        return ZoneOffset.ofTotalSeconds(parseSecs(r1));
    }

    private int parsePeriod(String r1) {
        return parseSecs(r1);
    }

    private ZoneOffsetTransitionRule.TimeDefinition parseTimeDefinition(char r1) {
        if (r1 == 'G') goto L23;
        if (r1 == 'S') goto L21;
        if (r1 == 'U') goto L23;
        if (r1 == 'Z') goto L23;
        if (r1 == 'g') goto L23;
        if (r1 == 's') goto L21;
        if (r1 == 'u') goto L23;
        if (r1 == 'z') goto L23;
        return ZoneOffsetTransitionRule.TimeDefinition.WALL;
    L21:
        return ZoneOffsetTransitionRule.TimeDefinition.STANDARD;
    L23:
        return ZoneOffsetTransitionRule.TimeDefinition.UTC;
    }

    private void buildZoneRules() throws Exception {
        Iterator<String> r0 = this.zones.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        String r1 = r0.next();
        printVerbose("Building zone " + r1);
        String r2 = (String) deduplicate(r1);
        List<TZDBZone> r3 = this.zones.get(r2);
        ZoneRulesBuilder r4 = new ZoneRulesBuilder();
        Iterator<TZDBZone> r5 = r3.iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        r4 = r5.next().addToBuilder(r4, this.rules);
        goto L7
    L9:
        this.builtZones.put(r2, (ZoneRules) deduplicate(r4.toRules(r2, this.deduplicateMap)));
        goto L4
    L10:
        Iterator<String> r6 = this.links.keySet().iterator();
    L12:
        if (r6.hasNext() == false) goto L21;
        String r7 = (String) deduplicate(r6.next());
        String r8 = this.links.get(r7);
        printVerbose("Linking alias " + r7 + " to " + r8);
        ZoneRules r9 = this.builtZones.get(r8);
        if (r9 != null) goto L20;
        String r10 = this.links.get(r8);
        printVerbose("Relinking alias " + r7 + " to " + r10);
        r9 = this.builtZones.get(r10);
        if (r9 != null) goto L20;
        throw new IllegalArgumentException("Alias '" + r7 + "' links to invalid zone '" + r10 + "' for '" + this.version + "'");
    L20:
        this.builtZones.put(r7, r9);
        goto L12
    L21:
        this.builtZones.remove("UTC");
        this.builtZones.remove("GMT");
        this.builtZones.remove("GMT0");
        this.builtZones.remove("GMT+0");
        this.builtZones.remove("GMT-0");
    }

    <T> T deduplicate(T r2) {
        if (this.deduplicateMap.containsKey(r2) == true) goto L6;
        this.deduplicateMap.put(r2, r2);
    L6:
        return (T) this.deduplicateMap.get(r2);
    }

    private void printVerbose(String r1) {
        if (this.verbose == false) goto L6;
        System.out.println(r1);
        return;
    }
}
