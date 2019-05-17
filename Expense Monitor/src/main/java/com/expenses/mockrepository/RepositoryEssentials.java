package com.expenses.mockrepository;

import com.expenses.model.GroupMember;

public interface RepositoryEssentials {

	void addGroupMember(GroupMember member);
	GroupMember getMemberById(int memberId);
}
