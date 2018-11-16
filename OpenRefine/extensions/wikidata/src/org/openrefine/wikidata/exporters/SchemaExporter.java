package org.openrefine.wikidata.exporters;

import java.io.IOException;
import java.io.Writer;
import java.util.Properties;

import org.json.JSONWriter;
import org.openrefine.wikidata.schema.WikibaseSchema;

import com.google.refine.browsing.Engine;
import com.google.refine.exporters.WriterExporter;
import com.google.refine.model.Project;

public class SchemaExporter implements WriterExporter {

	@Override
	public String getContentType() {
		return "application/octet-stream";
	}

	@Override
	public void export(Project project, Properties options, Engine engine, Writer writer) throws IOException {
        WikibaseSchema schema = (WikibaseSchema) project.overlayModels.get("wikibaseSchema");
        if (schema == null) {
            schema = new WikibaseSchema();
        }
        JSONWriter jsonWriter = new JSONWriter(writer);
        schema.write(jsonWriter, new Properties());
	}

}
