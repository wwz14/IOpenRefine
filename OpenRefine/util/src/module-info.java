module util {
    requires json;
    requires commons.collections;
    requires servlet.api;
    requires commons.codec;
    requires org.apache.commons.lang3;
    requires commonpart;

    exports com.google.refine.utility.util;
    exports com.google.refine.utility.preference;
}
