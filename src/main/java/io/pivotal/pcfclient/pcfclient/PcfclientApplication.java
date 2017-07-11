package io.pivotal.pcfclient.pcfclient;

import org.cloudfoundry.client.v2.organizations.OrganizationResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PcfclientApplication implements CommandLineRunner {
	
	@Autowired
	PcfService service;

	public static void main(String[] args) {
		SpringApplication.run(PcfclientApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		if (arg0.length <= 0) {
			System.out.println("Need an org name as an argument!");
			System.exit(1);
		}
		for (OrganizationResource o : service.listOrganisations(arg0[0]) ) {
			System.out.println(o.getEntity().getName());
		}
	}
}
