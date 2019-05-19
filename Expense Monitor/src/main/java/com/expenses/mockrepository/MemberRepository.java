package com.expenses.mockrepository;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger LOGGER = LoggerFactory.getLogger(MemberRepository.class);
	
	
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
		//Try to fetch the member
		GroupMember member = this.repository.get(memberId);
		if(member != null) {
			return member;
		}
		
		//Log and throw the error
		GroupMemberNotFoundException groupMemberError = new GroupMemberNotFoundException(ErrorMessages.MEMBER_NOT_FOUND_MESSAGE);
		LOGGER.error(groupMemberError.getMessage());
		throw groupMemberError;
	}

	@SuppressWarnings("unused")
	public HashMap<Integer, GroupMember> getRepository() throws RepositoryNotInstantiatedException{
		
		try {
			//Dummy code to test if the actual repository is null
			HashMap<Integer, GroupMember> repository = this.repository;
			
		}catch(NullPointerException e) {
			//Log and throw the error
			RepositoryNotInstantiatedException repositoryError = new RepositoryNotInstantiatedException(ErrorMessages.REPOSITORY_NOT_INSTANTIATED);
			LOGGER.error(repositoryError.getMessage());
			throw repositoryError;
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
		//Log and throw the error
		GroupMemberNotFoundException groupMemberError = new GroupMemberNotFoundException(ErrorMessages.MEMBER_NOT_FOUND_MESSAGE);
		LOGGER.error(groupMemberError.getMessage());
		throw groupMemberError;
	}

	@Override
	public boolean clearRepository() {
		this.repository.clear();
		return true;
	}
	
	
}
