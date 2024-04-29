
/*
 * **
 *  * @project : SuiviColis
 *  * @created : 23/04/2024, 19:44
 *  * @modified : 23/04/2024, 19:44
 *  * @description : This file is part of the SuiviColis project.
 *  * @license : MIT License
 *  **
 */

package com.suivi.colis.suivicolis.entity;

import com.suivi.colis.suivicolis.entity.converters.ListLocationPointListConverter;
import com.suivi.colis.suivicolis.model.MapsLocationPoint;
import com.suivi.colis.suivicolis.util.helpers.DateUtils;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class DeliveryArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String areaName;

    @Column(nullable = false, unique = true)
    private String areaCode;

    @Convert(converter = ListLocationPointListConverter.class)
    private List<MapsLocationPoint> areaVertices;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private AdminEmployee createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date creationDate;
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date lastUpdateDate;

    @PrePersist
    protected void onCreated() {
        java.util.Date date = DateUtils.getCurrentDateWithSpecifiedTimeZone();
        this.creationDate = date;
        this.lastUpdateDate = date;
    }

    @PreUpdate
    protected void onUpdate() {
        this.lastUpdateDate = DateUtils.getCurrentDateWithSpecifiedTimeZone();
    }


}