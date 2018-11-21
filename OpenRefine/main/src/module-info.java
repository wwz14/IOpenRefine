module main {
    requires util;
    requires commonpart;
    //requires wdtk.datamodel;
    requires ant;
    requires json;
    requires slf4j.api;
    requires servlet.api;

    requires org.everit.json.schema;
    requires commons.io;
    requires commons.beanutils;
    requires com.fasterxml.jackson.core;
    requires signpost.core;
    requires signpost.commonshttp4;
    requires guava;
    requires butterfly;
    requires com.fasterxml.jackson.annotation;
    requires commons.fileupload;
    requires commons.lang;
    requires httpcore;
    requires httpclient;
    requires datapackage.java;
    requires tableschema.java;


    exports com.google.refine;
    exports com.google.refine.model;
    exports com.google.refine.model.metadata;
    exports com.google.refine.browsing;
    exports com.google.refine.clustering;
    exports com.google.refine.exporters;
    exports com.google.refine.expr;
    exports com.google.refine.history;
    exports com.google.refine.process;
    exports com.google.refine.clustering.binning;
    exports com.google.refine.clustering.knn;
    exports com.google.refine.oauth;
    exports com.google.refine.browsing.facets;
    exports com.google.refine.browsing.util;
    exports com.google.refine.operations.cell;
    exports com.google.refine.model.changes;
    exports com.google.refine.operations.column;
    exports com.google.refine.grel;
    exports com.google.refine.operations;
    exports com.google.refine.importing;
    exports com.google.refine.operations.row;
    exports com.google.refine.exporters.sql;
    exports com.google.refine.model.metadata.validator;
}