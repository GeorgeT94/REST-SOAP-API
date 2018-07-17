package com.qa.interoperability;


import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.service.AccountService;

@Path("/account")
public class AccountEndpoint {
	private final static Logger LOGGER = Logger.getLogger(AccountEndpoint.class.getName());

	@Inject
	private AccountService service;

	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getAllAccounts() {
		LOGGER.info("getAllAccounts in AccountEndpoint");
		LOGGER.info("getAllAccounts in AccountEndpoint");
		System.out.println();
		return service.getAllAccounts();
	}

	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String addAccount(String account) {
		LOGGER.info("Account Endpoint: add account path");
		return service.addAccount(account);
	}

	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateAccount(@PathParam("id") Long id, String account) {
		LOGGER.info("Account Endpoint: update account path");
		return service.updateAccount(id, account);
	}

	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAccount(@PathParam("id") Long id) {
		LOGGER.info("Account Endpoint: delete account path");
		return service.deleteAccount(id);

	}

	public void setService(AccountService service) {
		this.service = service;
	}

}
