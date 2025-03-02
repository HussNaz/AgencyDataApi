package com.example.AgencyDataApi.controller;


import com.example.AgencyDataApi.data.AgencyRefData;
import com.example.AgencyDataApi.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/agencydata")
public class AgencyDataApiController {
    @Autowired
    private AgencyService agencyService;

    @GetMapping("/fetch-and-save")
    public String fetchAndSaveAgencyRefData() {
        List<AgencyRefData> agencyRefDataList =
                agencyService.fetchAndTransformAgencyData();
        agencyService.saveAgencyRefData(agencyRefDataList);
        return "Agency reference data saved successfully.";
    }

    @GetMapping("/ref-data")
    public List<AgencyRefData> getAgencyRefData() {
        return agencyService.fetchAndTransformAgencyData();
    }
}