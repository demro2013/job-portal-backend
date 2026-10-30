package com.cg.jobportalbackend.company.service;

import com.cg.jobportalbackend.dto.CompanyDTO;
import com.cg.jobportalbackend.dto.JobDTO;
import com.cg.jobportalbackend.entity.Company;
import com.cg.jobportalbackend.company.repository.CompanyRepository;
import com.cg.jobportalbackend.entity.Job;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements ICompanyService{

    private final CompanyRepository repo;

    @Override
    public List<CompanyDTO> findAllCompanies() {
        return mapCompaniesToCompanyDTOList(repo.findAll());
    }

    private List<CompanyDTO> mapCompaniesToCompanyDTOList(List<Company> companies){
        return companies.stream()
                .map(this::mapCompanyToCompanyDTO)
                .toList();
    }

    private CompanyDTO mapCompanyToCompanyDTO(Company company){
        if (company == null) {
            return null;
        }
        List<JobDTO> jobs = company
                .getJobs()
                .stream()
                .map(this::mapJobToJobDTO)
                .collect(Collectors.toList());

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
                        : company.getCreatedAt(),
                jobs
        );
    }

    private JobDTO mapJobToJobDTO(Job job) {
        if (job == null) {
            return null;
        }
        return new JobDTO(
                job.getId(),
                job.getTitle(),
                job.getCompany().getId(),
                job.getCompany().getName(),
                job.getCompany().getLogo(),
                job.getLocation(),
                job.getWorkType(),
                job.getJobType(),
                job.getCategory(),
                job.getExperienceLevel(),
                job.getSalaryMin(),
                job.getSalaryMax(),
                job.getSalaryCurrency(),
                job.getSalaryPeriod(),
                job.getDescription(),
                job.getRequirements(),
                job.getBenefits(),
                job.getPostedDate(),
                job.getApplicationDeadline(),
                job.getApplicationsCount(),
                job.getFeatured(),
                job.getUrgent(),
                job.getRemote(),
                job.getStatus()
        );
    }
}
