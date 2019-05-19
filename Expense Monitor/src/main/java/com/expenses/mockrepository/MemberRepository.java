package com.expenses.mockrepository;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.expenses.exceptions.ErrorMessages;
import com.expenses.exceptions.GroupMemberNotFoundException;
import com.expenses.exceptions.RepositoryNotInstantiatedException;
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
		
		throw new GroupMemberNotFoundException(ErrorMessages.MEMBER_NOT_FOUND_MESSAGE);
	}

	@SuppressWarnings("unused")
	public HashMap<Integer, GroupMember> getRepository() throws RepositoryNotInstantiatedException{
		
		try {
			//Dummy code to test if the actual repository is null
			HashMap<Integer, GroupMember> repository = this.repository;
			
		}catch(NullPointerException e) {
			//Log the error
			throw new RepositoryNotInstantiatedException(ErrorMessages.REPOSITORY_NOT_INSTANTIATED);
		}	
		
		return repository;
	}

	public void setRepository(HashMap<Integer, GroupMember> repository) {
		this.repository = repository;
	}

	@Override
	public boolean deleteMemberById(int memberId) throws GroupMemberNotFoundException{
		
		
		if(this.repository.get(memberId) != null) {
			this.repository.remove(memberId);
			return true;
		}
		
		throw new GroupMemberNotFoundException(ErrorMessages.MEMBER_NOT_FOUND_MESSAGE);
	}

	@Override
	public boolean clearRepository() {
		this.repository.clear();
		return true;
	}
	
	
}
