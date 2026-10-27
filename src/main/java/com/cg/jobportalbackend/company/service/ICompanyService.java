package com.cg.jobportalbackend.company.service;

import com.cg.jobportalbackend.dto.CompanyDTO;
import java.util.List;

public interface ICompanyService {
    List<CompanyDTO> findAllCompanies();
}
