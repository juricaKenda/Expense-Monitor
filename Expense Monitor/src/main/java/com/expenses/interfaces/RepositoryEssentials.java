package com.expenses.interfaces;

import org.springframework.stereotype.Component;

import com.expenses.model.GroupMember;

@Component
public interface RepositoryEssentials {

	/**
	 * Adds a new member into the member repository
	 * @param member a member that is being added
	 */
	void addGroupMember(GroupMember member);
	
	/**
	 * Searches for a member with a given ID and returns him
	 * @param memberId identification number of a particular member
	 * @return a member if found
	 */
	GroupMember getMemberById(int memberId);
}
