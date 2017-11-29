/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wacoal.dockeeper;

import java.security.Principal;
import javax.sql.DataSource;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Administrator
 */
@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    DataSource datasouce;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public ModelAndView index(Model model, Principal principal) {
        return new ModelAndView("report");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/report")
    public ModelAndView viewReports(
            final ModelMap modelMap,
            ModelAndView view,
            @PathParam("reportname") String reportname,
            @RequestParam("format") String format,
            @RequestParam("p_type_id") String typeId
    ) {

        modelMap.put("datasource", this.datasouce);
        modelMap.put("format", format);
        modelMap.put("p_type_id", typeId);
        view = new ModelAndView(reportname, modelMap);

        return view;
    }

}
