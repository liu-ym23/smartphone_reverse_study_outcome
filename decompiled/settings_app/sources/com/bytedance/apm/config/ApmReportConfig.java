package com.bytedance.apm.config;

/* JADX INFO: loaded from: classes3.dex */
public class ApmReportConfig {
    public static final int REPORT_SMALL_BATCH_ONCE_SIZE_BYTES = 512000;
    private long onceReportMaxSizeBytes;
    private int reportMode;

    /* JADX INFO: renamed from: com.bytedance.apm.config.ApmReportConfig$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private long onceReportMaxSizeBytes;
        private int reportMode;

        static /* synthetic */ int access$000(Builder r0) {
            return r0.reportMode;
        }

        static /* synthetic */ long access$100(Builder r2) {
            return r2.onceReportMaxSizeBytes;
        }

        Builder() {
            this.reportMode = 0;
            this.onceReportMaxSizeBytes = 2147483647L;
        }

        public Builder setReportMode(int r3) {
            this.reportMode = r3;
            if (r3 != 1) goto L5;
            this.onceReportMaxSizeBytes = 512000;
        L5:
            return this;
        }

        public Builder setOnceReportMaxSizeBytes(int r3) {
            this.onceReportMaxSizeBytes = r3;
            return this;
        }

        public ApmReportConfig build() {
            return new ApmReportConfig(this, null);
        }
    }

    /* synthetic */ ApmReportConfig(Builder r1, AnonymousClass1 r2) {
        this(r1);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    private ApmReportConfig(Builder r3) {
        this.reportMode = Builder.access$000(r3);
        this.onceReportMaxSizeBytes = Builder.access$100(r3);
    }

    public int getReportMode() {
        return this.reportMode;
    }

    public long getOnceReportMaxSizeBytes() {
        return this.onceReportMaxSizeBytes;
    }
}
