module commonpart {
    requires slf4j.api;
    requires butterfly;
    requires servlet.api;
    requires json;
    requires main;

    exports com.google.refine.commonpart;
}