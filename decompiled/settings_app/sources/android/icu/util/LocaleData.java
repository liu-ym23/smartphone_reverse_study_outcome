package android.icu.util;

/* JADX INFO: loaded from: classes.dex */
public final class LocaleData {
    public static final int ALT_QUOTATION_END = 3;
    public static final int ALT_QUOTATION_START = 2;
    public static final int QUOTATION_END = 1;
    public static final int QUOTATION_START = 0;

    public static final class MeasurementSystem {
        public static final MeasurementSystem SI = null;
        public static final MeasurementSystem UK = null;
        public static final MeasurementSystem US = null;

        static {
        }

        private MeasurementSystem() {
            throw new RuntimeException("Stub!");
        }
    }

    public static final class PaperSize {
        private PaperSize() {
            throw new RuntimeException("Stub!");
        }

        public int getHeight() {
            throw new RuntimeException("Stub!");
        }

        public int getWidth() {
            throw new RuntimeException("Stub!");
        }
    }

    private LocaleData() {
        throw new RuntimeException("Stub!");
    }

    public static LocaleData getInstance(ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public static LocaleData getInstance() {
        throw new RuntimeException("Stub!");
    }

    public void setNoSubstitute(boolean r1) {
        throw new RuntimeException("Stub!");
    }

    public boolean getNoSubstitute() {
        throw new RuntimeException("Stub!");
    }

    public String getDelimiter(int r1) {
        throw new RuntimeException("Stub!");
    }

    public static MeasurementSystem getMeasurementSystem(ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public static PaperSize getPaperSize(ULocale r1) {
        throw new RuntimeException("Stub!");
    }

    public static VersionInfo getCLDRVersion() {
        throw new RuntimeException("Stub!");
    }
}
