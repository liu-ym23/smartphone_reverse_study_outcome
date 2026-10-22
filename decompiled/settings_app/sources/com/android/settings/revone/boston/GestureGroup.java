package com.android.settings.revone.boston;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class GestureGroup {
    String groupTitle;
    List<GestureItem> items;

    static class GestureItem {
        String desc;
        boolean editable;
        boolean enabled;
        String key;
        String title;

        public GestureItem(String r1, String r2, String r3) {
            this.key = r1;
            this.title = r2;
            this.desc = r3;
        }

        public void setEnabled(boolean r1) {
            this.enabled = r1;
        }

        public boolean isEnabled() {
            return this.enabled;
        }

        public boolean isEditable() {
            return this.editable;
        }

        public void setEditable(boolean r1) {
            this.editable = r1;
        }
    }

    public GestureGroup() {
    }
}
