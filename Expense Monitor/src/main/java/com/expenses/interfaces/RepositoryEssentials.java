package com.expenses.interfaces;

import org.springframework.stereotype.Component;

import com.expenses.exceptions.GroupMemberNotFoundException;
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
	 * @throws GroupMemberNotFoundException
	 */
	GroupMember getMemberById(int memberId) throws GroupMemberNotFoundException;
	
	
	/**
	 * Searches for a member with a given ID and deletes him
	 * @param memberId identification number of a particular member
	 * @return true if a member was found and deleted
	 * @throws GroupMemberNotFoundException 
	 */
	boolean deleteMemberById(int memberId) throws GroupMemberNotFoundException;
	
	/**
	 * Clears all repository entries
	 * @return if the cleaning was successful, false otherwise
	 */
	boolean clearRepository();
}
