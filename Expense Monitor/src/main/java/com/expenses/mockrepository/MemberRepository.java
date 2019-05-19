package com.expenses.mockrepository;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.expenses.exceptions.GroupMemberNotFoundException;
import com.expenses.interfaces.RepositoryEssentials;
import com.expenses.model.GroupMember;

@Repository
public class MemberRepository implements RepositoryEssentials {

	//Internal storage of members
	private HashMap<Integer,GroupMember> repository = new HashMap<>();
	
	/**
	 * Default constructor
	 */
	public MemberRepository() {}

	@Override
	public void addGroupMember(GroupMember member) {
		this.repository.put(member.getMemberId(),member);		
	}

	@Override
	public GroupMember getMemberById(int memberId) throws GroupMemberNotFoundException {
		
		GroupMember member = this.repository.get(memberId);
		if(member != null) {
			return member;
		}
		
		throw new GroupMemberNotFoundException("Group member with ID :" + memberId + " was not found in the repository!");
	}

	public HashMap<Integer, GroupMember> getRepository() {
		return repository;
	}

	public void setRepository(HashMap<Integer, GroupMember> repository) {
		this.repository = repository;
	}

	@Override
	public boolean deleteMemberById(int memberId) {
		
		if(this.repository.get(memberId) != null) {
			this.repository.remove(memberId);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean clearRepository() {
		this.repository.clear();
		return true;
	}
	
	
}
