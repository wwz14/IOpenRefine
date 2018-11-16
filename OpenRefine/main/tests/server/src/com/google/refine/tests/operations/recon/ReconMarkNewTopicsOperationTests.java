package com.google.refine.tests.operations.recon;
import static org.mockito.Mockito.mock;

import org.json.JSONObject;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.google.refine.model.Project;
import com.google.refine.operations.OperationRegistry;
import com.google.refine.operations.recon.ReconMarkNewTopicsOperation;
import com.google.refine.tests.RefineTest;
import com.google.refine.tests.util.TestUtils;

public class ReconMarkNewTopicsOperationTests extends RefineTest {
    @BeforeSuite
    public void registerOperation() {
        OperationRegistry.registerOperation(getCoreModule(), "recon-mark-new-topics", ReconMarkNewTopicsOperation.class);
    }
    
    @Test
    public void serializeReconMarkNewTopicsOperation() throws Exception {
        String json = "{"
                + "\"op\":\"core/recon-mark-new-topics\","
                + "\"engineConfig\":{\"mode\":\"row-based\",\"facets\":[]},"
                + "\"columnName\":\"my column\","
                + "\"shareNewTopics\":true,"
                + "\"description\":\"Mark to create new items for cells in column my column, one item for each group of similar cells\""
                + "}";
        Project project = mock(Project.class);
        TestUtils.isSerializedTo(ReconMarkNewTopicsOperation.reconstruct(project, new JSONObject(json)), json);
    }
}
