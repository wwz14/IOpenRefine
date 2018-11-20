package com.google.refine.commonpart;

import com.google.refine.RefineServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public interface HttpResponder {
    public void init(RefineServlet servlet);

    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException;
}
