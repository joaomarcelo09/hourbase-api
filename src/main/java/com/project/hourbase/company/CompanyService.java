package com.project.hourbase.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hourbase.company.dto.CreateCompanyReq;

@Service
public class CompanyService {
	private final CompanyRepository companyRepository;

	public CompanyService(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	public void create(CreateCompanyReq data) {

		Company newCompany = new Company();
		newCompany.setName(data.name());
		newCompany.setContractedHours(data.contracted_hours());

	}
}
