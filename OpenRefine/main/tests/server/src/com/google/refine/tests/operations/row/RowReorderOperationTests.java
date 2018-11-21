package com.google.refine.tests.operations.row;

import static org.mockito.Mockito.mock;

import java.util.Properties;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.google.refine.ProjectManager;
import com.google.refine.browsing.Engine.Mode;
import com.google.refine.model.AbstractOperation;
import com.google.refine.model.Cell;
import com.google.refine.model.Project;
import com.google.refine.operations.OperationRegistry;
import com.google.refine.operations.row.RowReorderOperation;
import com.google.refine.process.Process;
import com.google.refine.tests.RefineTest;
import com.google.refine.tests.util.TestUtils;

public class RowReorderOperationTests extends RefineTest {
    
    Project project = null;

    @BeforeSuite
    public void registerOperation() {
        OperationRegistry.registerOperation(getCoreModule(), "row-reorder", RowReorderOperation.class);
    }
    
    @BeforeMethod
    public void setUp() {
        project = createCSVProject(
                "key,first\n"+
                "8,b\n"+
                ",d\n"+
                "2,f\n"+
                "1,h\n");
    }
    
    @AfterMethod
    public void tearDown() {
        ProjectManager.singleton.deleteProject(project.id);
    }
    
    @Test
    public void testSortEmptyString() throws Exception {
        project.rows.get(1).cells.set(0, new Cell("", null));
        AbstractOperation op = new RowReorderOperation(
                Mode.RowBased,
                new JSONObject("{\"criteria\":[{\"column\":\"key\",\"valueType\":\"number\",\"reverse\":false,\"blankPosition\":2,\"errorPosition\":1}]}"));
        Process process = op.createProcess(project, new Properties());
        process.performImmediate();
        
        Assert.assertEquals("h", project.rows.get(0).cells.get(1).value);
        Assert.assertEquals("f", project.rows.get(1).cells.get(1).value);
        Assert.assertEquals("b", project.rows.get(2).cells.get(1).value);
        Assert.assertEquals("d", project.rows.get(3).cells.get(1).value);
    }

   
    @Test
    public void serializeRowReorderOperation() throws JSONException, Exception {
        Project project = mock(Project.class);
        String json = "  {\n" + 
                "    \"op\": \"core/row-reorder\",\n" + 
                "    \"description\": \"Reorder rows\",\n" + 
                "    \"mode\": \"record-based\",\n" + 
                "    \"sorting\": {\n" + 
                "      \"criteria\": [\n" + 
                "        {\n" + 
                "          \"errorPosition\": 1,\n" + 
                "          \"valueType\": \"number\",\n" + 
                "          \"column\": \"start_year\",\n" + 
                "          \"blankPosition\": 2,\n" + 
                "          \"reverse\": false\n" + 
                "        }\n" + 
                "      ]\n" + 
                "    }\n" + 
                "  }";
        TestUtils.isSerializedTo(RowReorderOperation.reconstruct(project, new JSONObject(json)), json);
    }

}

