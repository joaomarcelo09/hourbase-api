package com.project.hourbase.company;

import java.util.List;
import java.util.Optional;

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
		newCompany.setContracted_hours(data.contracted_hours());

		companyRepository.save(newCompany);

	}

	public Optional<Company> findCompany(String id_company) {

		Optional<Company> company = companyRepository.findById(id_company);

		return company;
	}

	public List<Company> findAllCompanies() {

		List<Company> companies = companyRepository.findAll();

		return companies;
	}

	public void deleteCompany(String id_company) throws Exception {

		Company deleteCompany = findCompany(id_company).orElseThrow();

		companyRepository.delete(deleteCompany);

	}

	public void updateCompany(String id_company, CreateCompanyReq data) {
		Company company = findCompany(id_company).orElseThrow();

		company.setName(data.name());
		company.setContracted_hours(data.contracted_hours());
	}
}
