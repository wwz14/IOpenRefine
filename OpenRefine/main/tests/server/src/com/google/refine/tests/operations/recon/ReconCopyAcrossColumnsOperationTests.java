package com.google.refine.tests.operations.recon;
import static org.mockito.Mockito.mock;

import org.json.JSONObject;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.google.refine.model.Project;
import com.google.refine.operations.OperationRegistry;
import com.google.refine.operations.recon.ReconCopyAcrossColumnsOperation;
import com.google.refine.tests.RefineTest;
import com.google.refine.tests.util.TestUtils;

public class ReconCopyAcrossColumnsOperationTests extends RefineTest {
    @BeforeSuite
    public void registerOperation() {
        OperationRegistry.registerOperation(getCoreModule(), "recon-copy-across-columns", ReconCopyAcrossColumnsOperation.class);
    }
    
    @Test
    public void serializeReconCopyAcrossColumnsOperation() throws Exception {
        String json = "{\"op\":\"core/recon-copy-across-columns\","
                + "\"description\":\"Copy recon judgments from column source column to firstsecond\","
                + "\"engineConfig\":{\"mode\":\"row-based\",\"facets\":[]},"
                + "\"fromColumnName\":\"source column\","
                + "\"toColumnNames\":[\"first\",\"second\"],"
                + "\"judgments\":[\"matched\",\"new\"],"
                + "\"applyToJudgedCells\":true}";
        Project project = mock(Project.class);
        TestUtils.isSerializedTo(ReconCopyAcrossColumnsOperation.reconstruct(project, new JSONObject(json)), json);
    }
}
