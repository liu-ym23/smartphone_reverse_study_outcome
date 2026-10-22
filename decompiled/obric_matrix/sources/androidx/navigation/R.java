package androidx.navigation;

/* JADX INFO: loaded from: classes.dex */
public final class R {

    public static final class attr {
        public static final int action = 0x7f040009;
        public static final int data = 0x7f04015c;
        public static final int dataPattern = 0x7f04015d;
        public static final int graph = 0x7f0401fd;
        public static final int navGraph = 0x7f04032d;
        public static final int targetPackage = 0x7f040597;

        private attr() {
        }
    }

    public static final class id {
        public static final int nav_controller_view_tag = 0x7f090259;

        private id() {
        }
    }

    public static final class styleable {
        public static final int[] ActivityNavigator = null;
        public static final int ActivityNavigator_action = 0x00000001;
        public static final int ActivityNavigator_android_name = 0x00000000;
        public static final int ActivityNavigator_data = 0x00000002;
        public static final int ActivityNavigator_dataPattern = 0x00000003;
        public static final int ActivityNavigator_targetPackage = 0x00000004;
        public static final int[] NavHost = null;
        public static final int NavHost_navGraph = 0;
        public static final int[] NavInclude = null;
        public static final int NavInclude_graph = 0;

        static {
            ActivityNavigator = new int[]{android.R.attr.name, com.obric.matrix.R.attr.action, com.obric.matrix.R.attr.data, com.obric.matrix.R.attr.dataPattern, com.obric.matrix.R.attr.targetPackage};
            NavHost = new int[]{com.obric.matrix.R.attr.navGraph};
            NavInclude = new int[]{com.obric.matrix.R.attr.graph};
        }

        private styleable() {
        }
    }

    private R() {
    }
}
