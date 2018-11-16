package com.google.refine.model.metadata.validator.checks;

import com.google.refine.model.Project;
import org.json.JSONObject;

public class MissingHeader extends AbstractValidator {

    public MissingHeader(Project project, int cellIndex, JSONObject options) {
        super(project, cellIndex, options);
    }
}