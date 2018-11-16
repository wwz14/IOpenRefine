package com.google.refine.browsing.facets;

import org.json.JSONObject;

import com.google.refine.Jsonizable;
import com.google.refine.model.Project;


/**
 * Represents the configuration of a facet, as stored
 * in the engine configuration and in the JSON serialization
 * of operations. It does not contain the actual values displayed by
 * the facet.
 * 
 * @author antonin
 *
 */
public interface FacetConfig extends Jsonizable {
    /**
     * Reads the facet configuration from a JSON object (will be removed once we migrate to Jackson)
     * @param fo
     */
    public void initializeFromJSON(JSONObject fo);
    
    /**
     * Instantiates the given facet on a particular project.
     * @param project
     * @return a computed facet on the given project.
     */
    public Facet apply(Project project);
}
