package com.bytedance.bdinstall;

/* JADX INFO: loaded from: classes3.dex */
public interface IOaidObserver {

    public static final class Oaid {
        public final String id;
        public final boolean maySupport;

        public Oaid(String r1, boolean r2) {
            this.id = r1;
            this.maySupport = r2;
        }

        public String toString() {
            return "Oaid{id='" + this.id + "', maySupport=" + this.maySupport + '}';
        }
    }

    void onOaidLoaded(Oaid r1);
}
