/*
 * **
 *  * @project : DeliX
 *  * @created : 30/04/2024, 19:00
 *  * @modified : 30/04/2024, 19:00
 *  * @description : This file is part of the DeliX project.
 *  * @license : MIT License
 * **
 */

package com.fsdm.pfe.delix.repository;

import com.fsdm.pfe.delix.entity.DeliveryAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryAddressRepo extends JpaRepository<DeliveryAddress, Long> {
}
