package com.google.refine.tests.operations.column;

import static org.mockito.Mockito.mock;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.google.refine.model.Project;
import com.google.refine.operations.OperationRegistry;
import com.google.refine.operations.column.ColumnSplitOperation;
import com.google.refine.tests.RefineTest;
import com.google.refine.tests.util.TestUtils;

public class ColumnSplitOperationTests extends RefineTest {
    @BeforeSuite
    public void registerOperation() {
        OperationRegistry.registerOperation(getCoreModule(), "column-split", ColumnSplitOperation.class);
    }
    
    @Test
    public void serializeColumnSplitOperation() throws JSONException, Exception {
        String json = "{\n" + 
                "    \"op\": \"core/column-split\",\n" + 
                "    \"description\": \"Split column ea by separator\",\n" + 
                "    \"engineConfig\": {\n" + 
                "      \"mode\": \"row-based\",\n" + 
                "      \"facets\": []\n" + 
                "    },\n" + 
                "    \"columnName\": \"ea\",\n" + 
                "    \"guessCellType\": true,\n" + 
                "    \"removeOriginalColumn\": true,\n" + 
                "    \"mode\": \"separator\",\n" + 
                "    \"separator\": \"e\",\n" + 
                "    \"regex\": false,\n" + 
                "    \"maxColumns\": 0\n" + 
                "  }";
        Project project = mock(Project.class);
        TestUtils.isSerializedTo(ColumnSplitOperation.reconstruct(project, new JSONObject(json)), json);
    }
}
