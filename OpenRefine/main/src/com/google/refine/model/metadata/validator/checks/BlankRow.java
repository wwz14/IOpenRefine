package com.google.refine.model.metadata.validator.checks;

import com.google.refine.model.Project;
import org.json.JSONObject;

public class BlankRow extends AbstractValidator {
    
    public BlankRow(Project project, int cellIndex, JSONObject options) {
        super(project, cellIndex, options);
    }
}