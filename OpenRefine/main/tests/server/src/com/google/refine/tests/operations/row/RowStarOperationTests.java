package com.google.refine.tests.operations.row;

import static org.mockito.Mockito.mock;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.google.refine.model.Project;
import com.google.refine.operations.OperationRegistry;
import com.google.refine.operations.row.RowStarOperation;
import com.google.refine.tests.RefineTest;
import com.google.refine.tests.util.TestUtils;

public class RowStarOperationTests extends RefineTest {
    @BeforeSuite
    public void registerOperation() {
        OperationRegistry.registerOperation(getCoreModule(), "row-star", RowStarOperation.class);
    }
    
    @Test
    public void serializeRowStarOperation() throws JSONException, Exception {
        Project project = mock(Project.class);
        String json = "{"
                + "\"op\":\"core/row-star\","
                + "\"description\":\"Star rows\","
                + "\"starred\":true,"
                + "\"engineConfig\":{\"mode\":\"row-based\",\"facets\":[]}}";
        TestUtils.isSerializedTo(RowStarOperation.reconstruct(project, new JSONObject(json)), json);
    }
}
