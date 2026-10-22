package com.qihoo360.mobilesafe.common.ui.base;

import com.qihoo360.mobilesafe.common.ui.R;

/* JADX INFO: loaded from: classes4.dex */
public class CommonSwitch {

    public static final enum Style extends Enum<Style> {
        private static final /* synthetic */ Style[] $VALUES = null;
        public static final Style SWITCH1 = null;
        public static final Style SWITCH2 = null;
        public static final Style SWITCH4 = null;
        public static final Style SWITCH5 = null;
        public static final Style SWITCH6 = null;
        private int idRes;

        public static Style valueOf(String r1) {
            return (Style) Enum.valueOf(Style.class, r1);
        }

        public static Style[] values() {
            return (Style[]) $VALUES.clone();
        }

        static {
            Style r0 = new Style("SWITCH1", 0, R.drawable.inner_row_checkbox1_selector);
            SWITCH1 = r0;
            Style r1 = new Style("SWITCH2", 1, R.drawable.inner_row_checkbox2_selector);
            SWITCH2 = r1;
            Style r2 = new Style("SWITCH4", 2, R.drawable.inner_row_switch4_selector);
            SWITCH4 = r2;
            Style r4 = new Style("SWITCH5", 3, R.drawable.inner_row_switch5_selector);
            SWITCH5 = r4;
            Style r6 = new Style("SWITCH6", 4, R.drawable.inner_row_switch6_selector);
            SWITCH6 = r6;
            $VALUES = new Style[]{r0, r1, r2, r4, r6};
        }

        private Style(String r1, int r2, int r3) {
            super(r1, r2);
            this.idRes = r3;
        }

        public int getIdRes() {
            return this.idRes;
        }
    }

    public CommonSwitch() {
    }
}
