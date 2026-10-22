package com.android.settingslib;

/* JADX INFO: loaded from: classes.dex */
public class SignalIcon {

    public static class IconGroup {
        public final int[] contentDesc;
        public final int discContentDesc;
        public final String name;
        public final int qsDiscState;
        public final int[][] qsIcons;
        public final int qsNullState;
        public final int sbDiscState;
        public final int[][] sbIcons;
        public final int sbNullState;

        public IconGroup(String r1, int[][] r2, int[][] r3, int[] r4, int r5, int r6, int r7, int r8, int r9) {
            this.name = r1;
            this.sbIcons = r2;
            this.qsIcons = r3;
            this.contentDesc = r4;
            this.sbNullState = r5;
            this.qsNullState = r6;
            this.sbDiscState = r7;
            this.qsDiscState = r8;
            this.discContentDesc = r9;
        }

        public String toString() {
            return "IconGroup(" + this.name + ")";
        }
    }

    public static class MobileIconGroup extends IconGroup {
        public final int dataContentDescription;
        public final int dataType;

        public MobileIconGroup(String r11, int r12, int r13) {
            super(r11, null, null, AccessibilityContentDescriptions.PHONE_SIGNAL_STRENGTH, 0, 0, 0, 0, AccessibilityContentDescriptions.PHONE_SIGNAL_STRENGTH_NONE);
            this.dataContentDescription = r12;
            this.dataType = r13;
        }
    }

    public SignalIcon() {
    }
}
