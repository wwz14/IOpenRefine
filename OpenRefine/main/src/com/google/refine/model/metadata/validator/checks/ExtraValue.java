package com.google.refine.model.metadata.validator.checks;

import com.google.refine.model.Project;
import org.json.JSONObject;

public class ExtraValue extends AbstractValidator {

    public ExtraValue(Project project, int cellIndex, JSONObject options) {
        super(project, cellIndex, options);
    }
}