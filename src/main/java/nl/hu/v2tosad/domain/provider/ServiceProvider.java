package nl.hu.v2tosad.domain.provider;

import nl.hu.v2tosad.domain.service.ApplicationService;

public class ServiceProvider {
	private ApplicationService applicationService;
	
	public static ApplicationService getApplicationService(ApplicationService appService) {
		return appService;
	}

}
