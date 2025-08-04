package com.openkm.handlers;

import java.util.Collection;

import org.jbpm.graph.exe.ExecutionContext;
import org.jbpm.taskmgmt.def.AssignmentHandler;
import org.jbpm.taskmgmt.exe.Assignable;

import com.openkm.module.db.DbAuthModule;

public class RoleAssignmentHandler implements AssignmentHandler {

	@Override
	public void assign(Assignable assignable, ExecutionContext executionContext) throws Exception {
		DbAuthModule authModule = new DbAuthModule();

		// Get all users with admin privileges
		Collection<String> adminUsers = authModule.getUsersByRole(null,"ROLE_ADMIN");

		if (adminUsers == null || adminUsers.isEmpty()) {
			throw new Exception("No users with admin privileges found for role assignment.");
		}

		// Assign all as pooled actors
		assignable.setPooledActors(adminUsers.toArray(new String[0]));
	}
}
