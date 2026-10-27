package com.cg.jobportalbackend.service;

import com.cg.jobportalbackend.dto.CompanyDTO;
import com.cg.jobportalbackend.entity.Company;
import com.cg.jobportalbackend.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZoneOffset;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements ICompanyService{

    private final CompanyRepository repo;

    @Override
    public List<CompanyDTO> findAllCompanies() {
        return mapToDTO(repo.findAll());
    }

    private List<CompanyDTO> mapToDTO(List<Company> companies){
        return companies.stream()
                .map(this::mapToDTO)
                .toList();
    }

    private CompanyDTO mapToDTO(Company company){
        if (company == null) {
            return null;
        }
        return new CompanyDTO(
                company.getId(),
                company.getName(),
                company.getLogo(),
                company.getIndustry(),
                company.getSize(),
                company.getRating(),
                company.getLocations(),
                company.getFounded(),
                company.getDescription(),
                company.getEmployees(),
                company.getWebsite(),
                company.getCreatedAt() == null
                        ? null
                        : company.getCreatedAt().toInstant(ZoneOffset.UTC)
        );
    }
}
