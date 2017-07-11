package io.pivotal.pcfclient.pcfclient;

import java.time.Duration;
import java.util.List;

import org.cloudfoundry.client.CloudFoundryClient;
import org.cloudfoundry.client.v2.organizations.ListOrganizationsRequest;
import org.cloudfoundry.client.v2.organizations.OrganizationResource;
import org.springframework.stereotype.Service;

@Service
public class PcfService {
	private CloudFoundryClient client;
	private Duration blockTimeout = Duration.ofSeconds(10);
	
	public PcfService(CloudFoundryClient client) {
		
	}

	public List<OrganizationResource> listOrganisations(String orgName) {
		List<OrganizationResource> orgResources =
		        client.organizations()
		                .list(ListOrganizationsRequest.builder().name(orgName).build())
		                .block(blockTimeout)
		                .getResources();
		return orgResources;
	}
}
