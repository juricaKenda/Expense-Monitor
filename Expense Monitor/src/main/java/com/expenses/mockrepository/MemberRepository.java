package com.expenses.mockrepository;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

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
	public GroupMember getMemberById(int memberId) {
		//TODO Handle user not found exception
		return this.repository.get(memberId);
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
