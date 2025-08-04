package com.openkm.handlers;

import org.jbpm.graph.def.ActionHandler;
import org.jbpm.graph.exe.ExecutionContext;

public class MoveToFinalFolderActionHandler implements ActionHandler {
    
    @Override
    public void execute(ExecutionContext context) throws Exception {
        System.out.println("Document Approved!");
    }
}
