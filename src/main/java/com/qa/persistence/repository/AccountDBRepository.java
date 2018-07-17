package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class AccountDBRepository implements AccountRepository {
	private final static Logger LOGGER = Logger.getLogger(AccountDBRepository.class.getName());

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	
	public String getAllAccounts() {
		LOGGER.info("In AccountDBRepository getAllAccounts ");
		Query query = manager.createQuery("Select a FROM Account a");
		Collection<Account> accounts = (Collection<Account>) query.getResultList();
		return util.getJSONForObject(accounts);
	}


	@Transactional(REQUIRED)
	public String createAccount(String account) {
		LOGGER.info("In AccountDBRepository createAccount");
		Account anAccount = util.getObjectForJSON(account, Account.class);
		manager.persist(anAccount);
		return "{\"message\": \"account has been sucessfully added\"}";
	}


	@Transactional(REQUIRED)
	public String updateAccount(Long id, String accountToUpdate) {
		LOGGER.info("In AccountDBRepository updateAccount");
		Account updatedAccount = util.getObjectForJSON(accountToUpdate, Account.class);
		Account accountFromDB = findAccount(id);
		if (accountToUpdate != null) {
			updatedAccount.setId(id);
			accountFromDB = updatedAccount;
			manager.merge(accountFromDB);
		}
		return "{\"message\": \"account sucessfully updated\"}";
	}

	@Transactional(REQUIRED)
	public String deleteAccount(Long id) {
		LOGGER.info("In AccountDBRepository deleteAccount");
		Account accountInDB = findAccount(id);
		if (accountInDB != null) {
			manager.remove(accountInDB);
		}
		return "{\"message\": \"account sucessfully deleted\"}";
	}

	private Account findAccount(Long id) {
		return manager.find(Account.class, id);
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
