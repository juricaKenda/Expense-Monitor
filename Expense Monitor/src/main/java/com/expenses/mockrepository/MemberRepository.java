package com.expenses.mockrepository;

import java.util.HashMap;

import com.expenses.interfaces.RepositoryEssentials;
import com.expenses.model.GroupMember;

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
	public GroupMember getMemberById(int memberId) {
		return this.repository.get(memberId);
	}

	public HashMap<Integer, GroupMember> getRepository() {
		return repository;
	}

	public void setRepository(HashMap<Integer, GroupMember> repository) {
		this.repository = repository;
	}
	
	
}
