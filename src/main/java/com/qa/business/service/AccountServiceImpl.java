package com.qa.business.service;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.persistence.repository.AccountRepository;

public class AccountServiceImpl implements AccountService {

	private static final Logger LOGGER = Logger.getLogger(AccountServiceImpl.class);

	@Inject
	private AccountRepository repo;

	public String getAllAccounts() {
		LOGGER.info("In AccountServiceImpl getAllAccounts ");
		return repo.getAllAccounts();
	}

	@Override
	public String addAccount(String account) {
		LOGGER.info("In AccountServiceImpl addAccount");
		return repo.createAccount(account);
	}

	@Override
	public String updateAccount(Long id, String account) {
		LOGGER.info("In AccountServiceImpl updateAccount");
		return repo.updateAccount(id, account);
	}

	@Override
	public String deleteAccount(Long id) {
		LOGGER.info("In AccountServiceImpl deleteAccounts ");
		return repo.deleteAccount(id);

	}

	public void setRepo(AccountRepository repo) {
		this.repo = repo;
	}
}
