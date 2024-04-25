/*
 * **
 *  * @project : SuiviColis
 *  * @created : 25/04/2024, 16:11
 *  * @modified : 25/04/2024, 16:11
 *  * @description : This file is part of the SuiviColis project.
 *  * @license : MIT License
 * **
 */

package com.suivi.colis.suivicolis.controllers;

import com.suivi.colis.suivicolis.models.PrivilegesGroup;
import com.suivi.colis.suivicolis.models.enums.Privilege;
import com.suivi.colis.suivicolis.services.PrivilegesGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

/*
* actualy this is a test class
* we used it for testing pruposes
*
* todo : delete this class after testing
* */
@Controller
public class Test {


    @Autowired
    private PrivilegesGroupService privilegesGroupService;
    @GetMapping("/test/addPriviligeGroup")
    public ResponseEntity<String> addPriviligeGroup() {
        List<Privilege> privileges = new ArrayList<>();
        privileges.add(Privilege.ADD_EMPLOYEE);
        privileges.add(Privilege.ADD_USER);
        privileges.add(Privilege.ADD_USER);
        privileges.add(Privilege.AGENCY_MANAGEMENT);
        try {
            privilegesGroupService.addPrivilegesGroup(new PrivilegesGroup("ADMIN", privileges));
        } catch (Exception e) {
            return new ResponseEntity<>("priviliges not added added"+e.toString(), HttpStatus.OK);
        }

        return new ResponseEntity<>("priviliges was added", HttpStatus.OK);
    }
}
