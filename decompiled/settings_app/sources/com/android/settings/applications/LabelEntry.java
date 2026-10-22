package com.android.settings.applications;

/* JADX INFO: loaded from: classes2.dex */
public class LabelEntry {
    public char firstChar;
    public String firstLetters;
    public String label;
    public String labelPinyin;
    public String packageName;

    /* JADX INFO: renamed from: com.android.settings.applications.LabelEntry$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private char firstChar;
        private String firstLetters;
        private String label;
        private String labelPinyin;
        private String pacakgeName;

        public Builder() {
        }

        public Builder setPacakgeName(String r1) {
            this.pacakgeName = r1;
            return this;
        }

        public Builder setLabel(String r1) {
            this.label = r1;
            return this;
        }

        public Builder setLabelPinyin(String r1) {
            this.labelPinyin = r1;
            return this;
        }

        public Builder setFirstLetters(String r1) {
            this.firstLetters = r1;
            return this;
        }

        public Builder setFirstChar(char r1) {
            this.firstChar = r1;
            return this;
        }

        public LabelEntry build() {
            LabelEntry r0 = new LabelEntry(null);
            r0.packageName = this.pacakgeName;
            r0.label = this.label;
            r0.labelPinyin = this.labelPinyin;
            r0.firstLetters = this.firstLetters;
            r0.firstChar = this.firstChar;
            return r0;
        }
    }

    /* synthetic */ LabelEntry(AnonymousClass1 r1) {
        this();
    }

    private LabelEntry() {
    }

    public String toString() {
        return "packageName=" + this.packageName + ", label=" + this.label + ", labelPinyin=" + this.labelPinyin + ", firstLetters=" + this.firstLetters + ", firstChar=" + this.firstChar;
    }
}
