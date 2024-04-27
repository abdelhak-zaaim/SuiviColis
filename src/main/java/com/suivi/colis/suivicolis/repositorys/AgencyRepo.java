/*
 * **
 *  * @project : SuiviColis
 *  * @created : 25/04/2024, 14:47
 *  * @modified : 25/04/2024, 14:47
 *  * @description : This file is part of the SuiviColis project.
 *  * @license : MIT License
 *  **
 */

package com.suivi.colis.suivicolis.repositorys;

import com.suivi.colis.suivicolis.entities.Agency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgencyRepo extends JpaRepository<Agency, Long> {
    boolean existsByAgencyCode(String agencyCode);
}
